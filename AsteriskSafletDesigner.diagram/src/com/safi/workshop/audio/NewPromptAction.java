package com.safi.workshop.audio;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.navigator.serverconfig.RegisterSafiServerAction;
import com.safi.workshop.part.SafiWorkshopEditorUtil;

public class NewPromptAction implements IWorkbenchWindowActionDelegate {

  private IWorkbenchWindow window;

  public NewPromptAction() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(IWorkbenchWindow window) {
    this.window = window;

  }

  @Override
  public void run(IAction action) {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      if (!MessageDialog
          .openQuestion(
              SafiWorkshopEditorUtil.getActiveShell(),
              "Not Connected",
              "In order to access audio prompt management functionality you must be connected to a production SafiServer instance.\nWould you like to configure production SafiServer settings now?"))
        return;
      RegisterSafiServerAction sa = new RegisterSafiServerAction();
      sa.run();
      if (!SafiServerPlugin.getDefault().isConnected())
        return;
    }
    // TODO Auto-generated method stub
    ImportAudioFileWizard ipt = new ImportAudioFileWizard(ImportAudioFileWizard.Mode.NEW, true);
    WizardDialog dlg = new WizardDialog(SafiWorkshopEditorUtil.getActiveShell(), ipt);
    dlg.open();
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    action.setEnabled(true);

  }

}
