package com.safi.workshop.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;

import com.safi.workshop.application.PickWorkspaceDialog;

public class ActionSwitchWorkspace extends Action implements IWorkbenchAction {
  private Image _titleImage;

  public ActionSwitchWorkspace(Image titleImage) {
    super("Switch Workspace");
    _titleImage = titleImage;
    setActionDefinitionId("com.safi.workshop.actions.ActionSwitchWorkspace");
    setId("com.safi.workshop.actions.ActionSwitchWorkspace");
  }

  @Override
  public void run() {
    PickWorkspaceDialog pwd = new PickWorkspaceDialog(true, _titleImage);
    int pick = pwd.open();
    if (pick == Window.CANCEL)
      return;

    MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Switch Workspace",
        "The client will now restart with the new workspace");

    // restart client
    PlatformUI.getWorkbench().restart();
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }
}
