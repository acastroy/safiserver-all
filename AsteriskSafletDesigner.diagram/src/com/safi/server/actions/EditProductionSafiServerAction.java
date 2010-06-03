package com.safi.server.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.db.server.config.SafiServer;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.navigator.serverconfig.SafiServerAdminDialog;
import com.safi.workshop.part.SafiWorkshopEditorUtil;

public class EditProductionSafiServerAction implements IWorkbenchWindowActionDelegate {

  public EditProductionSafiServerAction() {
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
    SafiServer server;
    try {
      server = SafiServerPlugin.getDefault().getSafiServer(true);
    } catch (Exception e) {
      e.printStackTrace();
      return;
    }
    SafiServerAdminDialog safi = new SafiServerAdminDialog(SafiWorkshopEditorUtil
        .getActiveShell(), server);
    safi.open();
    SafiWorkshopEditorUtil.getSafiNavigator().refresh();

  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    // TODO Auto-generated method stub

  }

}
