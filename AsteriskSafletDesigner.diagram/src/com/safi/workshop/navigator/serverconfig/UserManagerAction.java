package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.EntitlementUtils;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class UserManagerAction implements IWorkbenchWindowActionDelegate, IViewActionDelegate {

  public UserManagerAction() {
    // super("ConnectionsView.Actions.AddSafiServer",
    // "ConnectionsView.Actions.AddSafiServerToolTip", "Images.AliasWizard");
  }

  public void run() {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog
          .openError(
              AsteriskDiagramEditorUtil.getActiveShell(),
              "Not Connected",
              "You must be connected to a production SafiServer to complete this operation.  Please connection to a SafiServer instance first");
      return;
    }
    User user = SafiServerPlugin.getDefault().getCurrentUser();
    if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_MANAGE_USERS)) {
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
          "You do not have sufficient privileges to carry out this operation.");
      return;
    }

    SafiServer aSafiServer = null;
    try {
      aSafiServer = SafiServerPlugin.getDefault().getSafiServer(true);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (aSafiServer == null) {
      MessageDialog.openError(SafiServerPlugin.getDefault().getWorkbench().getDisplay()
          .getActiveShell(), "Server Not Available", "No SafiServer instance has been registered.");
      return;
    }
    /*
     * if(aSafiServer!=null){
     * 
     * }else { SafiServer prod=ConfigFactory.eINSTANCE.createSafiServer();
     * prod.setHostname("Not Configured"); aSafiServer=prod; }
     */
    Shell shell = new Shell();
    UserManagerDialog safi = new UserManagerDialog(shell);
    safi.open();

  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    /*
     * if (selection instanceof IStructuredSelection){ Object elem =
     * ((IStructuredSelection)selection).getFirstElement(); if (elem instanceof
     * DriverManager || elem instanceof ManagedDriver || elem instanceof Alias || elem
     * instanceof User || elem instanceof Query || elem instanceof QueryParameter)
     * action.setEnabled(true); else action.setEnabled(false); }
     */
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(IWorkbenchWindow window) {
  }

  @Override
  public void run(IAction action) {
    run();
  }

  @Override
  public void init(IViewPart view) {
  }
}
