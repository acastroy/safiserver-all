package com.safi.workshop.sheet.actionstep;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.emf.workspace.impl.WorkspaceCommandStackImpl;

public abstract class AbstractActionstepEditCommand extends AbstractOverrideableCommand {

  private int initialStackHistorySize;
  private Resource resource;
  protected List<Command> commandHistory;
  protected List<WeakReference<ActionstepEditorPage>> pagemap = new LinkedList<WeakReference<ActionstepEditorPage>>();
  protected volatile boolean flushedOperations;

  public AbstractActionstepEditCommand(EditingDomain domain, Resource resource,
      int initialStackHistorySize, List<ActionstepEditorPage> pages, List<Command> commandHistory) {
    super(domain, "Rollback and Clear");
    this.initialStackHistorySize = initialStackHistorySize;
    this.resource = resource;
    this.commandHistory = commandHistory;
    for (ActionstepEditorPage page : pages) {
      pagemap.add(new WeakReference<ActionstepEditorPage>(page));
    }
  }

  @Override
  public void doRedo() {
  }

  @Override
  public void doUndo() {
  }

  @Override
  public boolean doCanExecute() {
    return true;
  }

  protected synchronized void flushOperations(TransactionalEditingDomain domain, int cmdSkip,
      boolean flush) {
    if (!flushedOperations) {
      WorkspaceCommandStackImpl stack = (WorkspaceCommandStackImpl) domain.getCommandStack();
      IUndoableOperation[] ops = stack.getOperationHistory().getUndoHistory(
          stack.getDefaultUndoContext());
      ResourceUndoContext ctx = new ResourceUndoContext(domain, resource);
      for (int currIdx = ops.length - 1; currIdx >= initialStackHistorySize; currIdx--) {
        if (currIdx >= 0) {
          if (cmdSkip-- <= 0) {
            ((EMFCommandOperation) ops[currIdx]).addContext(ctx);
            commandHistory.add(((EMFCommandOperation) ops[currIdx]).getCommand());
            // if (flush)
            stack.getOperationHistory().replaceOperation(ops[currIdx], new IUndoableOperation[0]);
          }
        }
      }
      flushedOperations = true;
    }

  }

  protected void doRollback(EditingDomain domain) {

    // TODO Auto-generated method stub
    Collections.reverse(commandHistory);
    for (Command command : commandHistory) {
      try {
        command.undo();
        // op.redo(monitor, null);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    for (WeakReference<ActionstepEditorPage> ref : pagemap) {
      ActionstepEditorPage page = ref.get();
      if (page != null)
        page.operationsUndone();
    }
    Collections.reverse(commandHistory);
  }
}
