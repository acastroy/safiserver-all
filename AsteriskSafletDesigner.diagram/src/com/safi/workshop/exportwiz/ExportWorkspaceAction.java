package com.safi.workshop.exportwiz;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class ExportWorkspaceAction implements IWorkbenchWindowActionDelegate {

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(IWorkbenchWindow window) {
    // TODO Auto-generated method stub

  }

  @Override
  public void run(IAction action) {
    SafiWorkspaceExportWizard wizard = new SafiWorkspaceExportWizard();
    WizardDialog dlg = new WizardDialog(AsteriskDiagramEditorUtil.getActiveShell(), wizard);
    dlg.open();

  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    // TODO Auto-generated method stub

  }

}
