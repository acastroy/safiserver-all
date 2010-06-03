package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewPart;

import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;
import com.safi.server.manager.SafiServerManagementException;
import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.EntitlementUtils;
import com.safi.workshop.part.SafiWorkshopEditorUtil;

public class RestartSafiServerAction implements org.eclipse.ui.IViewActionDelegate {

  public RestartSafiServerAction() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void init(IViewPart view) {
    // TODO Auto-generated method stub

  }

  @Override
  public void run(IAction action) {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog
          .openError(
              SafiWorkshopEditorUtil.getActiveShell(),
              "Not Connected",
              "You must be connected to a production SafiServer to complete this operation.  Please connection to a SafiServer instance first");
      return;
    }
    User user = SafiServerPlugin.getDefault().getCurrentUser();
    if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_UPDATE_SERVER)) {
      MessageDialog.openError(SafiWorkshopEditorUtil.getActiveShell(), "Not Entitled",
          "You do not have sufficient privileges to carry out this operation.");
      return;
    }
    boolean result = MessageDialog
        .openQuestion(
            SafiWorkshopEditorUtil.getActiveShell(),
            "Restart Confirm",
            "Restarting the server will cause the server to stop responding for some time. Are you sure want to restart?");
    if (result) {
      try {
        SafiServerRemoteManager.getInstance().restartServerService();
      } catch (SafiServerManagementException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        MessageDialog.openError(SafiWorkshopEditorUtil.getActiveShell(), "Restart Failed",
            "The remote SafiServer could not be restarted: " + e.getLocalizedMessage());
        return;
      }
    }

  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    if (selection instanceof IStructuredSelection) {
      Object o = ((IStructuredSelection) selection).getFirstElement();
      if (o == null || (!(o instanceof SafiServer))) {
        action.setEnabled(false);
        return;
      }
      action.setEnabled(SafiServerRemoteManager.getInstance().isConnected());

    }

  }

}
