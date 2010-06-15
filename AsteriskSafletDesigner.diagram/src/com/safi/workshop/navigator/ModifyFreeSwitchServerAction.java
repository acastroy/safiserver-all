package com.safi.workshop.navigator;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.db.fsdb.FreeSwitchServer;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.preferences.FreeSwitchConfigurationDialog;
import com.safi.server.saflet.manager.EntitlementUtils;
import com.safi.workshop.part.SafiWorkshopEditorUtil;

public class ModifyFreeSwitchServerAction implements IWorkbenchWindowActionDelegate {

  private ISelection cachedSelection;

  public ModifyFreeSwitchServerAction() {
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
    if (cachedSelection == null)
      return;
    if (cachedSelection instanceof StructuredSelection) {
      StructuredSelection selection = (StructuredSelection) cachedSelection;
      if (selection.size() > 1)
        return;
      final FreeSwitchServer fsServer = (FreeSwitchServer) selection.getFirstElement();
      {
        if (!SafiServerPlugin.getDefault().isConnected()) {
          MessageDialog
              .openError(
                  SafiWorkshopEditorUtil.getActiveShell(),
                  "Not Connected",
                  "You must be connected to a production SafiServer to complete this operation.  Please connection to a SafiServer instance first");
          return;
        }
        User user = SafiServerPlugin.getDefault().getCurrentUser();
        if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_MANAGE_TELEPHONY_SERVERS)) {
          MessageDialog.openError(SafiWorkshopEditorUtil.getActiveShell(), "Not Entitled",
              "You do not have sufficient privileges to carry out this operation.");
          return;
        }
        FreeSwitchConfigurationDialog astercfg = new FreeSwitchConfigurationDialog(
            SafiWorkshopEditorUtil.getActiveShell(), fsServer);
        int result = astercfg.open();
        if (result == Window.OK) {
          astercfg.commit();
          SafiWorkshopEditorUtil.getSafiNavigator().refresh(fsServer);
        }
      }
    }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    cachedSelection = selection;

  }

}
