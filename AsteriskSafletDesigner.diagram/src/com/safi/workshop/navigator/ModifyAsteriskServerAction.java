package com.safi.workshop.navigator;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.preferences.AsteriskConfigurationDialog;
import com.safi.server.saflet.manager.EntitlementUtils;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class ModifyAsteriskServerAction implements IWorkbenchWindowActionDelegate {

  private ISelection cachedSelection;

  public ModifyAsteriskServerAction() {
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
      final AsteriskServer asteriskSelected = (AsteriskServer) selection.getFirstElement();
      {
        if (!SafiServerPlugin.getDefault().isConnected()) {
          MessageDialog
              .openError(
                  AsteriskDiagramEditorUtil.getActiveShell(),
                  "Not Connected",
                  "You must be connected to a production SafiServer to complete this operation.  Please connection to a SafiServer instance first");
          return;
        }
        User user = SafiServerPlugin.getDefault().getCurrentUser();
        if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_MANAGE_ASTERISK_SERVERS)) {
          MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
              "You do not have sufficient privileges to carry out this operation.");
          return;
        }
        AsteriskConfigurationDialog astercfg = new AsteriskConfigurationDialog(
            AsteriskDiagramEditorUtil.getActiveShell(), asteriskSelected);
        int result = astercfg.open();
        if (result == Window.OK) {
          astercfg.commit();
          AsteriskDiagramEditorUtil.getSafiNavigator().refresh(asteriskSelected);
        }
      }
    }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    cachedSelection = selection;

  }

}
