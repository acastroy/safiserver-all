package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.emf.workspace.impl.WorkspaceCommandStackImpl;
import org.eclipse.jface.dialogs.IDialogConstants;
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
//	protected List<Command> commandHistory = new ArrayList<Command>();
//	protected CompoundCommand command;
//	private int initialStackHistorySize;
//	private Transaction transaction;

	// private int rollbackCount = 0;

	public ActionstepEditorDialog(){
		//this is strictrly for designer purpose.
		//this should never be called;
	   super(new Shell());
	   System.out.println("this constructor is strictly for designer. It never should be called.");
	}
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

	Transaction createTransaction(Map<?, ?> options) throws InterruptedException {
		return ((InternalTransactionalEditingDomain) editPart.getEditingDomain())
		    .startTransaction(false, options);
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
		// command = new ActionStepDLGCompoundCommand();

		// WrappedToggleCanonicalModeCommand cmd = new
		// WrappedToggleCanonicalModeCommand(false, editPart);
		// cmd.execute();
		// command.append(cmd);
		addPages();

		setTitleImage(AsteriskDiagramEditorPlugin.getInstance().getItemImage(
		    editPart.getActionStep()));
		setTitle("ActionStep " + editPart.getActionStep().getName());
		// ToolstepItemProviderAdapterFactory factory =
		// (ToolstepItemProviderAdapterFactory)editPart.getAdapter(ToolstepItemProviderAdapterFactory.class);
		// Image img = (Image)factory.adapt(Image.class, editPart.getActionStep());
		return area;
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
		for (ActionstepEditorPage page : pages) {
			page.okPressed();
		}
		super.okPressed();
	}

	@Override
	protected void cancelPressed() {
		super.cancelPressed();
	}


	@Override
	public int open() {
		
//			try {
//				transaction = createTransaction(null);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return CANCEL;
//			}
		// TODO Auto-generated method stub
		WorkspaceCommandStackImpl stack = (WorkspaceCommandStackImpl) editPart
		    .getEditingDomain().getCommandStack();
		// stack.execute(new WrappedToggleCanonicalModeCommand(false,
		// getEditPart()));
		IUndoableOperation[] ops = stack.getOperationHistory().getUndoHistory(
		    stack.getDefaultUndoContext());
		return super.open();
	}

	@Override
	public boolean close() {

		for (ActionstepEditorPage page : pages) {
			if (page instanceof Composite && !((Composite) page).isDisposed()) {
				((Composite) page).dispose();
			}
		}
		tabFolder.dispose();
		
		// editPart.getEditingDomain().getCommandStack().execute(
		// new WrappedToggleCanonicalModeCommand(true, getEditPart()));
		// new WrappedToggleCanonicalModeCommand(true, getEditPart()).execute();
		editPart.refresh();
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


	//
	// public void appendRollbackItem(RollbackItem item) {
	// rollbackItems.add(item);
	// }

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

	// private static class ActionStepDLGCompoundCommand extends CompoundCommand {
	//
	// public ActionStepDLGCompoundCommand() {
	// super("Compound ActionstepEditor guy");
	// }
	//
	// @Override
	// public boolean canExecute() {
	// return true;
	// }
	//
	// @Override
	// public boolean canUndo() {
	// return true;
	// }
	//
	// }

}
