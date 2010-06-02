package com.safi.workshop.importwiz;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class ImportSafletAction implements IWorkbenchWindowActionDelegate {

  public ImportSafletAction() {
    // TODO Auto-generated constructor stub
  }

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
    // TODO Auto-generated method stub
    SafletImportWizard wizard = new SafletImportWizard();
    WizardDialog dlg = new WizardDialog(AsteriskDiagramEditorUtil.getActiveShell(), wizard);
    dlg.open();
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    // TODO Auto-generated method stub

  }

}
