package com.safi.workshop.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.InternalTransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.OpenEditPolicy;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.widgets.Display;

import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;

public class OpenEditorEditPolicy extends OpenEditPolicy {

	@Override
	protected Command getOpenCommand(Request request) {
		EditPart targetEditPart = getTargetEditPart(request);

		if (targetEditPart instanceof ToolstepEditPart) {
			ToolstepEditPart editPart = (ToolstepEditPart) targetEditPart;
			if (editPart.getHandlerEditPart().isDebug())
				return null;
			final ActionstepEditorDialog dlg = new ActionstepEditorDialog(
			    AsteriskDiagramEditorUtil.getActiveShell(), editPart);

			ActionStepDialogOperation op = new ActionStepDialogOperation(editPart
			    .getEditingDomain(), dlg, editPart.getNotationView());
			return new ICommandProxy(op);
//			try {
////				op.setOptions(Collections.singletonMap(Transaction.OPTION_UNPROTECTED	, Boolean.TRUE));
////				editPart.getEditingDomain().getCommandStack().execute(new ICommandProxy(op));
//				
//				IStatus res = AsteriskDiagramEditorPlugin.getInstance().getWorkbench().getOperationSupport().getOperationHistory().execute(op, null, null);
////				IStatus res = op.execute(null, null);
//				if (res.getCode() == IStatus.CANCEL) {
//					System.err.println("UNDOIN THIS SHIT");
//					op.undo(null, null);
//					op.dispose();
//				} else if (res.getCode() == IStatus.OK) {
//					System.err.println("OK WUZ PREST");
//				}
//			} catch (ExecutionException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
			// Display display = Display.getCurrent();
			// display.asyncExec(new Runnable() {
			// @Override
			// public void run() {
			// try {
			//
			// dlg.open();
			// } catch (Exception e) {
			// e.printStackTrace();
			// }
			//
			// }
			// });

//			View view = editPart.getNotationView();
//			if (view != null) {
//				EObject element = ViewUtil.resolveSemanticElement(view);
//				/*
//				 * String read_out = element.toString(); System.out.println("readout:" +
//				 * read_out); String read_out2 = view.toString();
//				 * System.out.println("readout2:" + read_out2); WorkbenchPage
//				 * page=(WorkbenchPage)AsteriskDiagramEditorUtil.getSafiNavigator
//				 * ().getSite().getPage(); IViewReference ref =
//				 * page.findViewReference("org.eclipse.ui.views.PropertySheet");
//				 * page.getActivePerspective().getPresentation().detachPart(ref); Point
//				 * p
//				 * =ref.getPage().getActiveEditor().getEditorSite().getShell().getSize()
//				 * ;
//				 * ref.getPage().getActivePart().getSite().getShell().setLocation(p.x/2
//				 * ,p.y/2);
//				 */
//				// getViewSite().getShell().setLocation(someX, someY);
//				// maybe add custom properties editor here.. with double click.
//				// or bring it front.
//				/* SWT STUFF GOES IN HERE AND WORKS FINE */
//
//			}
		}

		return null;
	}

	private class ActionStepDialogOperation extends AbstractTransactionalCommand {

		private ActionstepEditorDialog dlg;
		InternalTransactionalEditingDomain domain;

		public ActionStepDialogOperation(TransactionalEditingDomain domain,
		    ActionstepEditorDialog dlg, View containerView) {
			super(domain, "EditActionStepDialogOperation", getWorkspaceFiles(containerView));
			this.dlg = dlg;
			this.domain = (InternalTransactionalEditingDomain) domain;
		}

		@Override
		public boolean canExecute() {
		  // TODO Auto-generated method stub
		  return super.canExecute();
		}
		
		
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
		    throws ExecutionException {
			final Display display = Display.getCurrent();
			final CommandResult[] sresult = new CommandResult[1];
//			try {
//				domain.runExclusive(new Runnable() {
//					public void run() {
						display.syncExec(domain.createPrivilegedRunnable(new Runnable() {
							@Override
							public void run() {
								try {

									int result = dlg.open();
									switch (result) {
									case TitleAreaDialog.OK:
										sresult[0] = CommandResult.newOKCommandResult();
										break;
									case TitleAreaDialog.CANCEL:
										sresult[0] = CommandResult.newCancelledCommandResult();
										break;
									}
								} catch (Exception e) {
									e.printStackTrace();
								}

							}
						}));

//					}
//				});
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				throw new ExecutionException("ActionStepEditorDialog Error", e);
//			}
			return sresult[0];
		}
		
		@Override
		public boolean canUndo() {
		  // TODO Auto-generated method stub
		  return super.canUndo();
		}
		
		@Override
		protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info)
		    throws ExecutionException {
		  // TODO Auto-generated method stub
		  return super.doUndo(monitor, info);
		}
	}
}