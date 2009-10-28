package com.safi.workshop.part;

/******************************************************************************
 * Copyright (c) 2006, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionChangeDescription;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.FilterManager;
import org.eclipse.emf.transaction.impl.InternalTransaction;
import org.eclipse.emf.transaction.impl.ReadWriteValidatorImpl;
import org.eclipse.emf.transaction.impl.TransactionChangeRecorder;
import org.eclipse.emf.transaction.impl.TransactionImpl;
import org.eclipse.emf.transaction.impl.TransactionValidator;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.emf.transaction.util.ConditionalRedoCommand;
import org.eclipse.emf.transaction.util.TriggerCommand;
import org.eclipse.emf.workspace.impl.WorkspaceCommandStackImpl;
import org.eclipse.gmf.runtime.diagram.core.internal.listener.NotationSemProc;
import org.eclipse.gmf.runtime.diagram.core.listener.DiagramEventBroker;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;

/**
 * Factory for {@link TransactionalEditingDomain}s that are properly configured to support
 * a GMF diagram application. This factory should be preferred over the
 * {@link GMFEditingDomainFactory} because it attaches a listener required to update the
 * notation model after changes to the semantic model. Also, it handles special use cases
 * involving the DiagramEventBroker.
 * 
 * @author cmahoney
 */
public class AsteriskDiagramEditingDomainFactory extends GMFEditingDomainFactory {

  protected static class AsteriskDiagramEditingDomain extends TransactionalEditingDomainImpl {
    // The following variable acts as a special latch for the DiagramEventBroker
    // listener so that we can allow it to execute in a write transaction context
    // while handling a post-commit event.
    private InternalTransaction originatingTransaction = null;
    private DiagramEventBroker deb = null;
    private ResourceSetListener debWrapper = null;
    private boolean debugFile;
    private boolean bypassTransactionRecorder = false;
    private ResourceSetListener debugResourceListener;

    @Override
    public void addResourceSetListener(ResourceSetListener l) {
      if (DiagramEventBroker.class.isInstance(l)) {
        assert deb == null;
        deb = (DiagramEventBroker) l;
        debWrapper = new ResourceSetListenerImpl() {
          @Override
          public boolean isAggregatePrecommitListener() {
            return deb.isAggregatePrecommitListener();
          }

          @Override
          public boolean isPrecommitOnly() {
            return true;
          }

          @Override
          public Command transactionAboutToCommit(ResourceSetChangeEvent event)
              throws RollbackException {
            return deb.transactionAboutToCommit(event);
          }

          @Override
          public void resourceSetChanged(ResourceSetChangeEvent event) {
            deb.resourceSetChanged(event);
          }

          @Override
          public NotificationFilter getFilter() {
            return deb.getFilter();
          }

          @Override
          public boolean isPostcommitOnly() {
            return false;
          }
        };

        super.addResourceSetListener(debWrapper);
      } else {
        super.addResourceSetListener(l);
      }
    }

    @Override
    public void removeResourceSetListener(ResourceSetListener l) {
      if (DiagramEventBroker.class.isInstance(l)) {
        assert deb != null;
        deb = null;
        super.removeResourceSetListener(debWrapper);
        debWrapper = null;
      } else {
        super.removeResourceSetListener(l);
      }
    }

    @Override
    public InternalTransaction startTransaction(boolean readOnly, Map options)
        throws InterruptedException {
      InternalTransaction result;

      result = new TransactionImpl(this, readOnly, options) {
        @Override
        public void add(Notification notification) {
          super.add(notification);
        }
      };
      result.start();

      return result;
    }

    // public AsteriskDiagramEditingDomain(AdapterFactory adapterFactory, ResourceSet
    // resourceSet) {
    // super(adapterFactory, resourceSet);
    // }

    public AsteriskDiagramEditingDomain(AdapterFactory adapterFactory,
        TransactionalCommandStack stack, ResourceSet resourceSet) {
      super(adapterFactory, stack, resourceSet);
      updateDebugStatus();
      hookDebugResourceListener();
    }

    private void hookDebugResourceListener() {
      debugResourceListener = new ResourceSetListener() {

        @Override
        public NotificationFilter getFilter() {
          return null;
        }

        @Override
        public boolean isAggregatePrecommitListener() {
          return true;
        }

        @Override
        public boolean isPostcommitOnly() {
          return false;
        }

        @Override
        public boolean isPrecommitOnly() {
          return false;
        }

        @Override
        public void resourceSetChanged(ResourceSetChangeEvent event) {
          updateDebugStatus();

        }

        @Override
        public Command transactionAboutToCommit(ResourceSetChangeEvent event)
            throws RollbackException {
          return null;
        }

      };
      addResourceSetListener(debugResourceListener);

    }

    public AsteriskDiagramEditingDomain(AdapterFactory adapterFactory,
        TransactionalCommandStack stack) {
      super(adapterFactory, stack);
      updateDebugStatus();
      hookDebugResourceListener();
    }

    //
    // public AsteriskDiagramEditingDomain(AdapterFactory adapterFactory) {
    // super(adapterFactory);
    // }

    public void updateDebugStatus() {
      debugFile = AsteriskDiagramEditorUtil.hasDebugFile(getResourceSet());
    }

    @Override
    protected TransactionChangeRecorder createChangeRecorder(ResourceSet rset) {
      return new TransactionChangeRecorder(this, rset) {

        @Override
        protected void assertWriting() {
          if (!(debugFile || bypassTransactionRecorder))
            super.assertWriting();
        }

      };

    }

    @Override
    public void precommit(InternalTransaction tx) throws RollbackException {
      super.precommit(tx);

      if ((tx.getParent() == null) && (deb != null)) {
        // ensure that when the top-level transaction commits, it
        // has a self-chaining composite command as a trigger to
        // insert the DiagramEventBroker's post-commit changes into,
        // so that the transaction's change description and any other
        // AbstractEMFOperation will get the changes automatically
        Command existingTriggers = tx.getTriggers();
        if (existingTriggers instanceof CompoundCommand) {
          // nothing to do: already a self-chaining command
        } else if (existingTriggers != null) {
          // force it to be a compound by appending a no-op
          tx.addTriggers(NOOP_TRIGGER);
        } else {
          // no triggers, yet? have to add *two* no-ops
          tx.addTriggers(NOOP_TRIGGER);
          tx.addTriggers(NOOP_TRIGGER);
        }
      }
    }

    @Override
    public void broadcastUnbatched(Notification notification) {
      super.broadcastUnbatched(notification);
      final ResourceSetChangeEvent unbatchedChangeEvent = new ResourceSetChangeEvent(this, null,
          Collections.singletonList(notification));
      try {
        runExclusive(new Runnable() {
          public void run() {
            try {
              if (deb != null)
                deb.resourceSetChanged(unbatchedChangeEvent);
            } catch (Exception e) {
              // do nothing for now
            }
          }
        });
      } catch (InterruptedException e) {
        // do ntohing for now
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void postcommit(InternalTransaction tx) {
      try {
        List notifications = getValidator().getNotificationsForPostcommit(tx);

        if (deb != null && notifications != null && !notifications.isEmpty()) {
          TransactionValidator originalValidator = null;

          // Set the latch if it has not yet been set
          if (originatingTransaction == null) {
            originatingTransaction = tx;
            originalValidator = getValidator();
            setValidator(new ReadWriteValidatorImpl());
          } else {
            // In this case we must copy over the notifications and change
            // descriptions to the originatingTransaction. Do this
            // as a "late trigger command" because the trigger
            // mechanism is already understood by some of the
            // operations that need to undo/redo these changes
            originatingTransaction.addTriggers(new TriggerCommand(Collections
                .singletonList(new AsteriskDiagramEventBrokerCommand(tx.getChangeDescription()))));
            originatingTransaction.getNotifications().addAll(notifications);
          }

          try {
            ArrayList cache = new ArrayList(notifications.size());

            List filtered = FilterManager.getInstance().select(notifications, deb.getFilter(),
                cache);

            HashMap options = new HashMap(originatingTransaction.getOptions());
            options.put(Transaction.OPTION_NO_UNDO, Boolean.FALSE);
            InternalTransaction newTx = startTransaction(false, options);
            deb.resourceSetChanged(new ResourceSetChangeEvent(this, tx, filtered));

            newTx.commit();
          } catch (RollbackException e) {
            // Do nothing in the rollback case, we have no change descriptions
            // or notifications to propagate.
          } finally {
            // Undo the latch if we are top-most in the recursion.
            if (originatingTransaction == tx) {
              originatingTransaction = null;
              getValidator().dispose();
              setValidator(originalValidator);
            }
          }
        }
      } catch (InterruptedException e) {
        // Simply fall-through in this case and allow the post commit listeners
        // to be notified.
      }

      // We will only call super on the top-most in the recursion.
      if (originatingTransaction == null) {
        super.postcommit(tx);
      }
    }

    public boolean isBypassTransactionRecorder() {
      return bypassTransactionRecorder;
    }

    public void setBypassTransactionRecorder(boolean bypassTransactionRecorder) {
      this.bypassTransactionRecorder = bypassTransactionRecorder;
    }

    @Override
    public void dispose() {
      // TODO Auto-generated method stub
      WorkspaceCommandStackImpl stack = (WorkspaceCommandStackImpl) getCommandStack();
      IUndoableOperation[] ops = stack.getOperationHistory().getUndoHistory(
          stack.getDefaultUndoContext());
      EditingDomainUndoContext undoctx = new EditingDomainUndoContext(this);
      for (IUndoableOperation op : ops) {
        if (op.hasContext(undoctx)) {
          stack.getOperationHistory().replaceOperation(op, new IUndoableOperation[0]);
        }
      }

      if (debugResourceListener != null)
        removeResourceSetListener(debugResourceListener);
      if (deb != null)
        removeResourceSetListener(deb);

      if (debWrapper != null)
        removeResourceSetListener(debWrapper);

      for (ResourceSetListener l : getAggregatePrecommitListeners()) {
        removeResourceSetListener(l);
      }

      for (ResourceSetListener l : getPrecommitListeners()) {
        removeResourceSetListener(l);
      }

      for (ResourceSetListener l : getPostcommitListeners()) {
        removeResourceSetListener(l);
      }

      if (getResourceSet() != null)
        getResourceSet().eAdapters().clear();

      setDefaultTransactionOptions(Collections.emptyMap());
      super.dispose();
      // this.resourceSet = null;
    }

  }

  private static class AsteriskDiagramEventBrokerCommand extends AbstractCommand implements
      ConditionalRedoCommand {
    private final TransactionChangeDescription change;

    AsteriskDiagramEventBrokerCommand(TransactionChangeDescription change) {
      this.change = change;
    }

    @Override
    protected boolean prepare() {
      return true;
    }

    public final void execute() {
      // never executed
    }

    @Override
    public boolean canUndo() {
      return (change != null) && change.canApply();
    }

    @Override
    public final void undo() {
      if (change != null) {
        change.applyAndReverse();
      }
    }

    public boolean canRedo() {
      return (change != null) && change.canApply();
    }

    public final void redo() {
      if (change != null) {
        change.applyAndReverse();
      }
    }
  }

  static final TriggerCommand NOOP_TRIGGER = new TriggerCommand(Collections
      .singletonList(new AbstractCommand() {
        @Override
        protected boolean prepare() {
          return true;
        }

        public void execute() {
        }

        @Override
        public boolean canUndo() {
          return true;
        }

        // this command does not need to implement canRedo() because it
        // is assumed to be redoable, anyway, which is what we want
        @Override
        public void undo() {
        }

        public void redo() {
        }
      }));

  /**
   * The single shared instance of the GMF diagram editing domain factory.
   */
  private static AsteriskDiagramEditingDomainFactory instance = new AsteriskDiagramEditingDomainFactory();

  /**
   * Gets the single shared instance of the GMF diagram editing domain factory.
   * 
   * @return the editing domain factory
   */
  public static AsteriskDiagramEditingDomainFactory getInstance() {
    return instance;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory#configure(org.eclipse.emf
   * .transaction.TransactionalEditingDomain)
   */
  @Override
  protected void configure(TransactionalEditingDomain domain) {
    super.configure(domain);
    domain.addResourceSetListener(new NotationSemProc());
  }

  @Override
  public TransactionalEditingDomain createEditingDomain() {
    TransactionalEditingDomain result = createEditingDomain(OperationHistoryFactory
        .getOperationHistory());
    configure(result);
    return result;
  }

  @Override
  public TransactionalEditingDomain createEditingDomain(IOperationHistory history) {
    WorkspaceCommandStackImpl stack = new WorkspaceCommandStackImpl(history);

    TransactionalEditingDomain result = new AsteriskDiagramEditingDomain(
        new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), stack);

    mapResourceSet(result);

    configure(result);
    return result;
  }

  @Override
  public TransactionalEditingDomain createEditingDomain(ResourceSet rset) {
    TransactionalEditingDomain result = createEditingDomain(rset, OperationHistoryFactory
        .getOperationHistory());
    configure(result);
    return result;
  }

  @Override
  public TransactionalEditingDomain createEditingDomain(ResourceSet rset, IOperationHistory history) {
    WorkspaceCommandStackImpl stack = new WorkspaceCommandStackImpl(history);

    TransactionalEditingDomain result = new AsteriskDiagramEditingDomain(
        new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE), stack,
        rset);

    mapResourceSet(result);
    configure(result);
    return result;
  }

}
