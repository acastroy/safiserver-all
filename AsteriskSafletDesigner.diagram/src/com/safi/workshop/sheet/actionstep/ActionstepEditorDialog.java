package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.EMFCommandOperation;
import org.eclipse.emf.workspace.ResourceUndoContext;
import org.eclipse.emf.workspace.impl.WorkspaceCommandStackImpl;
import org.eclipse.gmf.runtime.emf.commands.core.command.EditingDomainUndoContext;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sheet.ActionstepEditorDialogFactoryManager;

public class ActionstepEditorDialog extends TitleAreaDialog {

  // protected List<RollbackItem> rollbackItems = new ArrayList<RollbackItem>();
  protected CTabFolder tabFolder;
  protected ToolstepEditPart editPart;
  protected List<ActionstepEditorPage> pages;
  protected List<Command> commandHistory = new ArrayList<Command>();
  protected CompoundCommand command;
  private int initialStackHistorySize;

  // private int rollbackCount = 0;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public ActionstepEditorDialog(Shell parentShell, ToolstepEditPart editPart) {
    super(parentShell);
    this.editPart = editPart;

  }

  @Override
  protected boolean isResizable() {
    return true;
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite area = (Composite) super.createDialogArea(parent);
    Composite container = new Composite(area, SWT.NONE);
    container.setLayout(new GridLayout());
    container.setLayoutData(new GridData(GridData.FILL_BOTH));

    tabFolder = new CTabFolder(container, SWT.BORDER);
    tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    //
    command = new ActionStepDLGCompoundCommand();

    addPages();

    setTitleImage(AsteriskDiagramEditorPlugin.getInstance().getItemImage(editPart.getActionStep()));
    setTitle("ActionStep " + editPart.getActionStep().getName());
    // ToolstepItemProviderAdapterFactory factory =
    // (ToolstepItemProviderAdapterFactory)editPart.getAdapter(ToolstepItemProviderAdapterFactory.class);
    // Image img = (Image)factory.adapt(Image.class, editPart.getActionStep());
    return area;
  }

  @Override
  public int open() {
    // TODO Auto-generated method stub
    WorkspaceCommandStackImpl stack = (WorkspaceCommandStackImpl) editPart.getEditingDomain()
        .getCommandStack();
    IUndoableOperation[] ops = stack.getOperationHistory().getUndoHistory(
        stack.getDefaultUndoContext());
    this.initialStackHistorySize = ops.length;
    return super.open();
  }

  @Override
  protected void constrainShellSize() {
    super.constrainShellSize();
    // getShell().pack();
  }

  protected void addPages() {
    for (ActionstepEditorPage page : ActionstepEditorDialogFactoryManager.getInstance()
        .createPages(editPart, this)) {
      addPage(page);
    }
  }

  private void addPage(ActionstepEditorPage page) {
    if (pages == null)
      pages = new ArrayList<ActionstepEditorPage>();
    CTabItem item = new CTabItem(tabFolder, SWT.NONE);
    item.setControl((Control) page);
    item.setText(page.getTabText());
    // page.setEditorDialog(this);
    pages.add(page);
  }

  public ActionstepEditorPage getPage(int idx) {
    if (pages == null || idx >= pages.size())
      return null;
    return pages.get(idx);
  }

  @Override
  protected void okPressed() {
    if (pages == null || pages.isEmpty()) {
      super.okPressed();
      return;
    }

    for (ActionstepEditorPage page : pages) {
      if (!page.validate())
        return;
    }

    // if (transaction != null) {
    // try {
    // transaction.commit();
    // transaction = null;
    // } catch (RollbackException e) {
    // MessageDialog.openError(getShell(), "Edit Actionstep Error",
    // "Changes couldn't be published: " + e.getLocalizedMessage());
    // e.printStackTrace();
    // return;
    // }
    //
    // }
    if (command != null) {
      try {

        RollbackActionstepEditCommand cmd = new RollbackActionstepEditCommand(editPart
            .getEditingDomain(), getEditPart().getActionStep().eResource(),
            initialStackHistorySize, pages, new ArrayList<Command>(commandHistory));
        command.append(cmd);
        editPart.getEditingDomain().getCommandStack().execute(command);
        command = null;
        WorkspaceCommandStackImpl stack = (WorkspaceCommandStackImpl) editPart.getEditingDomain()
            .getCommandStack();

        IUndoableOperation[] ops = stack.getOperationHistory().getUndoHistory(
            stack.getDefaultUndoContext());
        if (ops.length > 0) {
          ops[ops.length - 1].addContext(new ResourceUndoContext(editPart.getEditingDomain(),
              getEditPart().getActionStep().eResource()));
          ops[ops.length - 1].addContext(new EditingDomainUndoContext(editPart.getEditingDomain()));
        }
      } catch (Exception e) {
        MessageDialog.openError(getShell(), "Edit Actionstep Error",
            "Changes couldn't be published: " + e.getLocalizedMessage());
        e.printStackTrace();
        return;
      }
      command = null;
    }
    for (ActionstepEditorPage page : pages) {
      page.okPressed();
    }
    super.okPressed();
  }

  @Override
  protected void cancelPressed() {
    if (pages == null || pages.isEmpty()) {
      super.cancelPressed();
      return;
    }
    try {
      doCancel();
    } catch (Exception e) {
      MessageDialog.openError(getShell(), "Edit Actionstep Error",
          "Changes couldn't be rolled back: " + e.getLocalizedMessage());
      e.printStackTrace();
    }

    super.cancelPressed();
  }

  private void doCancel() {
    // if (transaction != null) {
    // transaction.rollback();
    // transaction = null;
    // }

    CancelActionstepEditCommand cmd = new CancelActionstepEditCommand(editPart.getEditingDomain(),
        getEditPart().getActionStep().eResource(), initialStackHistorySize, pages,
        new ArrayList<Command>(commandHistory));
    // AbstractOverrideableCommand cmd = new
    // AbstractOverrideableCommand(editPart.getEditingDomain(),
    // "Rollback And Clear") {
    //
    // @Override
    // public void doExecute() {
    // if (!flushedOperations) {
    // flushOperations((TransactionalEditingDomain) domain, 0, true);
    // Collections.reverse(commandHistory);
    // }
    // doRollback(domain);
    // }
    //
    // @Override
    // public void doRedo() {
    // }
    //
    // @Override
    // public void doUndo() {
    // }
    //
    // @Override
    // public boolean doCanExecute() {
    // return true;
    // }
    // };

    editPart.getEditingDomain().getCommandStack().execute(cmd);

    flushedOperations = false;
    flushOperations(editPart.getEditingDomain(), 0, true);
    command = null;
  }

  private void flushOperations(TransactionalEditingDomain domain, int cmdSkip, boolean flush) {
    if (!flushedOperations) {
      WorkspaceCommandStackImpl stack = (WorkspaceCommandStackImpl) domain.getCommandStack();
      IUndoableOperation[] ops = stack.getOperationHistory().getUndoHistory(
          stack.getDefaultUndoContext());
      ResourceUndoContext ctx = new ResourceUndoContext(domain, getEditPart().getActionStep()
          .eResource());
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

  @Override
  public boolean close() {

    if (command != null && pages != null && !pages.isEmpty()) {
      doCancel();
    }
    for (ActionstepEditorPage page : pages) {
      if (page instanceof Composite && !((Composite) page).isDisposed()) {
        ((Composite) page).dispose();
      }
    }
    tabFolder.dispose();
    if (commandHistory != null) {
      commandHistory.clear();
      commandHistory = null;
    }
    command = null;
    editPart = null;
    pages = null;
    return super.close();
  }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(421, 509);
  }

  public CTabFolder getTabFolder() {
    return tabFolder;
  }

  public ToolstepEditPart getEditPart() {
    return editPart;
  }

  public CompoundCommand getCommand() {
    return command;
  }

  //
  // public void appendRollbackItem(RollbackItem item) {
  // rollbackItems.add(item);
  // }

  boolean flushedOperations;

  //
  // protected static class RollbackItem {
  // private Command command;
  //
  // public RollbackItem(Command command) {
  // this.command = command;
  // }
  //
  // }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    if (editPart != null)
      newShell.setText(AsteriskDiagramEditorPlugin.getInstance().getItemLabelText(
          editPart.getActionStep()));
  }

  private static class ActionStepDLGCompoundCommand extends CompoundCommand {

    public ActionStepDLGCompoundCommand() {
      super("Compound ActionstepEditor guy");
    }

    @Override
    public boolean canExecute() {
      return true;
    }

    @Override
    public boolean canUndo() {
      return true;
    }

  }
}
