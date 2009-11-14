package com.safi.workshop.sheet.actionstep;

import java.lang.ref.SoftReference;
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
import com.safi.workshop.edit.parts.ToolstepEditPart;

public abstract class AbstractActionstepEditCommand extends AbstractOverrideableCommand {

	protected int initialStackHistorySize;
	protected Resource resource;
	protected List<Command> commandHistory;
	protected List<SoftReference<ActionstepEditorPage>> pagemap = new LinkedList<SoftReference<ActionstepEditorPage>>();
	protected volatile boolean flushedOperations;
	protected ToolstepEditPart editPart;

	public AbstractActionstepEditCommand(ToolstepEditPart editPart,
	    int initialStackHistorySize, List<ActionstepEditorPage> pages,
	    List<Command> commandHistory) {
		super(editPart.getEditingDomain(), "Rollback and Clear");
		this.editPart = editPart;
		this.initialStackHistorySize = initialStackHistorySize;
		this.resource = editPart.getActionStep().eResource();
		this.commandHistory = commandHistory;
		for (ActionstepEditorPage page : pages) {
			pagemap.add(new SoftReference<ActionstepEditorPage>(page));
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

	protected synchronized void flushOperations(TransactionalEditingDomain domain,
	    int cmdSkip, boolean flush) {
		if (!flushedOperations) {
			WorkspaceCommandStackImpl stack = (WorkspaceCommandStackImpl) domain
			    .getCommandStack();
			IUndoableOperation[] ops = stack.getOperationHistory().getUndoHistory(
			    stack.getDefaultUndoContext());
			ResourceUndoContext ctx = new ResourceUndoContext(domain, resource);
			for (int currIdx = ops.length - 1; currIdx >= initialStackHistorySize; currIdx--) {
				if (currIdx >= 0) {
					if (cmdSkip-- <= 0) {
						((EMFCommandOperation) ops[currIdx]).addContext(ctx);
						System.err.println("Ading cmd "
						    + ((EMFCommandOperation) ops[currIdx]).getCommand());
						commandHistory.add(((EMFCommandOperation) ops[currIdx]).getCommand());
						// if (flush)
						stack.getOperationHistory().replaceOperation(ops[currIdx],
						    new IUndoableOperation[0]);
					} else {
						System.err.println("boi i'm skippin op "
						    + ((EMFCommandOperation) ops[currIdx]).toString());
						// if (flush)
						stack.getOperationHistory().replaceOperation(ops[currIdx],
						    new IUndoableOperation[0]);
					}
				}
			}
			System.err.println("the initialstaksize was " + initialStackHistorySize
			    + " but now its " + getCurrentOperationUndoSize());
			flushedOperations = true;

//			commandHistory.add(0, new WrappedToggleCanonicalModeCommand(true, editPart));
//			commandHistory.add(new WrappedToggleCanonicalModeCommand(false, editPart));

		}

	}

	protected int getCurrentOperationUndoSize() {
		IUndoableOperation[] ops = ((WorkspaceCommandStackImpl) getDomain().getCommandStack())
		    .getOperationHistory().getUndoHistory(
		        ((WorkspaceCommandStackImpl) getDomain().getCommandStack())
		            .getDefaultUndoContext());
		return ops == null ? 0 : ops.length;
	}

	protected int getCurrentOperationRedoSize() {
		IUndoableOperation[] ops = ((WorkspaceCommandStackImpl) getDomain().getCommandStack())
		    .getOperationHistory().getRedoHistory(
		        ((WorkspaceCommandStackImpl) getDomain().getCommandStack())
		            .getDefaultUndoContext());
		return ops == null ? 0 : ops.length;
	}

	protected void dumpCurrentOperationUndoSize() {
		IUndoableOperation[] ops = ((WorkspaceCommandStackImpl) getDomain().getCommandStack())
		    .getOperationHistory().getUndoHistory(
		        ((WorkspaceCommandStackImpl) getDomain().getCommandStack())
		            .getDefaultUndoContext());

		System.err.println("UNDO STACK:");
		for (IUndoableOperation op : ops) {
			System.err.println("\tUndoableOP: " + op);
		}
	}

	protected void dumpCurrentOperationRedoSize() {
		IUndoableOperation[] ops = ((WorkspaceCommandStackImpl) getDomain().getCommandStack())
		    .getOperationHistory().getRedoHistory(
		        ((WorkspaceCommandStackImpl) getDomain().getCommandStack())
		            .getDefaultUndoContext());
		System.err.println("REDO STACK:");
		for (IUndoableOperation op : ops) {
			System.err.println("\tUndoableOP: " + op);
		}

	}

	protected void doRollback(EditingDomain domain) {

		// TODO Auto-generated method stub
		Collections.reverse(commandHistory);
		for (Command command : commandHistory) {
			try {
				System.err.println("Rollin back " + command);
				command.undo();
				// op.redo(monitor, null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		for (SoftReference<ActionstepEditorPage> ref : pagemap) {
			ActionstepEditorPage page = ref.get();
			if (page != null)
				page.operationsUndone();
		}
		Collections.reverse(commandHistory);
	}
}
