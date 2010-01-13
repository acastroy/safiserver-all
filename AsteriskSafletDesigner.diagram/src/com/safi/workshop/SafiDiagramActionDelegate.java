package com.safi.workshop;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import com.safi.workshop.application.DiagramEditorActionBarAdvisor.NewDiagramAction2;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class SafiDiagramActionDelegate implements IViewActionDelegate {

  NewDiagramAction2 nda;
  IWorkbenchWindow iwindow;

  public void run(IAction action) {
    // TODO Auto-generated method stub
    // AsteriskApplication.
    if (nda == null) {
      nda = new NewDiagramAction2();
    }
    if (iwindow == null) {
      iwindow = AsteriskDiagramEditorPlugin.getInstance().getWorkbench().getActiveWorkbenchWindow();
      nda.init(iwindow);
    }
    nda.run(action);

  }

  @Override
  public void init(IViewPart view) {
    // TODO Auto-generated method stub
    nda = new NewDiagramAction2();
    iwindow = view.getViewSite().getWorkbenchWindow();
    nda.init(iwindow);

  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    // TODO Auto-generated method stub
    if (nda != null)
      nda.selectionChanged(action, selection);

  }

}
