package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IViewPart;
import com.safi.db.server.config.SafiServer;
import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class OpenServerView implements org.eclipse.ui.IViewActionDelegate {

  public OpenServerView() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void init(IViewPart view) {
    // TODO Auto-generated method stub

  }

  @Override
  public void run(IAction action) {
    if (!SafiServerRemoteManager.getInstance().isConnected()) {
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Connected",
          "You are not currently connected to a production SafiServer");
      return;
    }
    SafiServerPlugin.getDefault().getCurrentUser();

    try {
      AsteriskDiagramEditorPlugin.getInstance().updateServerView(true, false);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
          "Couldn't Open SafiServer View", "The SafiServer View could not be opened: "
              + e.getLocalizedMessage());
      return;
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
      SafiServer server = (SafiServer) o;

      action.setEnabled(SafiServerRemoteManager.getInstance().isConnected());

    }

  }

}
