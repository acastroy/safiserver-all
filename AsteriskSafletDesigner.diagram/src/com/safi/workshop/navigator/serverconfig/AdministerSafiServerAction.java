package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.db.server.config.SafiServer;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.SafiWorkshopEditorUtil;

public class AdministerSafiServerAction implements IWorkbenchWindowActionDelegate,
    IViewActionDelegate {

  public AdministerSafiServerAction() {
    // super("ConnectionsView.Actions.AddSafiServer",
    // "ConnectionsView.Actions.AddSafiServerToolTip", "Images.AliasWizard");
  }

  public void run() {
    SafiServer aSafiServer = null;
    IStructuredSelection selection = SafiWorkshopEditorUtil.getSafiNavigator()
        .getViewerSelection();
    if (selection.isEmpty()) {
      MessageDialog.openInformation(SafiWorkshopEditorUtil.getActiveShell(),
          "No Server Selected",
          "No SafiServer instance has been selected.  Select the SafiServer instance you wish to administer"
              + " from the Navigator tree.");
      return;
    }
    Object o = (selection).getFirstElement();
    if (o instanceof SafiServer)
      aSafiServer = (SafiServer) o;
    if (aSafiServer == null) {
      try {
        aSafiServer = SafiServerPlugin.getDefault().getSafiServer(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    if (aSafiServer == null) {
      MessageDialog.openInformation(SafiWorkshopEditorUtil.getActiveShell(),
          "No Server Selected",
          "No SafiServer instance has been selected.  Select the SafiServer instance you wish to administer"
              + " from the Navigator tree.");
      return;
    }
    /*
     * if(aSafiServer!=null){
     * 
     * }else { SafiServer prod=ConfigFactory.eINSTANCE.createSafiServer();
     * prod.setHostname("Not Configured"); aSafiServer=prod; }
     */
    SafiServerAdminDialog safi = new SafiServerAdminDialog(SafiWorkshopEditorUtil
        .getActiveShell(), aSafiServer);
    int result = safi.open();

    if (result == Window.OK)
      SafiWorkshopEditorUtil.getSafiNavigator().refresh();

  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {

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
    // TODO Auto-generated method stub
    run();
  }

  @Override
  public void init(IViewPart view) {
  }
}
