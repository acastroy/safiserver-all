package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import com.safi.db.server.config.SafiServer;
import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class ServerViewAction extends Action implements IAction {

  private IWorkbenchWindow window;

  public ServerViewAction(IWorkbenchWindow window) {
    // do nothing
    this.window = window;
    setId("com.safi.workshop.serverview");
    setText("&SafiServer View");
    setToolTipText("SafiServer View");
    setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("AsteriskSafletDesigner.diagram",
        "icons/product/SafiLicense.gif"));
  }

  @Override
  public void run() {

    run(null);

  }

  public void run(IAction action) {
    if (!SafiServerRemoteManager.getInstance().isConnected()) {
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Connected",
          "You are not currently connected to a production SafiServer");
      return;
    }
    SafiServerPlugin.getDefault().getCurrentUser();

    try {
      AsteriskDiagramEditorPlugin.getInstance().updateServerView(true, true);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
          "Couldn't Open SafiServer View", "The SafiServer View could not be opened: "
              + e.getLocalizedMessage());
      return;
    }

  }

  public void selectionChanged(IAction action, ISelection selection) {
    if (selection instanceof IStructuredSelection) {
      Object o = ((IStructuredSelection) selection).getFirstElement();
      if (o == null || (!(o instanceof SafiServer))) {
        action.setEnabled(false);
        return;
      }
      SafiServer server = (SafiServer) o;
      // if (server == SafiServerPlugin.getDefault().getLocalServer()) {
      // action.setEnabled(false);
      // return;
      // } else
      action.setEnabled(SafiServerRemoteManager.getInstance().isConnected());

    }
  }

  public void dispose() {
    // do nothing
  }

  public void init(IWorkbenchWindow window) {
    this.window = window;
  }
}
