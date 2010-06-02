package com.safi.workshop.part;

import java.lang.ref.WeakReference;

import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

public class ValidateActionDelegate implements IWorkbenchWindowActionDelegate {

  private WeakReference<IWorkbenchWindow> window;

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(IWorkbenchWindow window) {
    this.window = new WeakReference<IWorkbenchWindow>(window);

  }

  @Override
  public void run(IAction action) {
    org.eclipse.ui.IWorkbenchPart wpart = window.get().getPartService().getActivePart();
    if (wpart instanceof IDiagramWorkbenchPart) {
      IDiagramWorkbenchPart part = (IDiagramWorkbenchPart) wpart;
      ValidateAction.runValidation(part.getDiagramEditPart(), part.getDiagram());
    }
    // ValidateAction va = new ValidateAction(part);
    // va.runValidation(diagramEditPart, view);
    // va.runValidation(diagramEditPart, view)

  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {

    if (window != null
        && window.get().getActivePage().getActiveEditor() instanceof AsteriskDiagramEditor)
      action.setEnabled(true);
    else
      action.setEnabled(false);

  }

}
