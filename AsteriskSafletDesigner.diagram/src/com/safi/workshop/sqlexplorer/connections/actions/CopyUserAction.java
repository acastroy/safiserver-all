package com.safi.workshop.sqlexplorer.connections.actions;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.dialogs.EditUserDlg;

public class CopyUserAction extends AbstractConnectionTreeAction {

  public CopyUserAction() {
    super("ConnectionsView.Actions.CopyUser", "ConnectionsView.Actions.CopyUser.ToolTip",
        "Images.ConnectionsView.CopyUser");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.action.Action#run()
   */
  @Override
  public void run() {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Not Connected",
          "You must be connected to a SafiServer instance to access this feature");
      return;
    }
    User user = getView().getSelectedUser(false);
    EditUserDlg dlg = new EditUserDlg(Display.getCurrent().getActiveShell(), EditUserDlg.Type.COPY,
        user.getAlias(), user);
    dlg.open();
    getView().refresh();
  }

  /*
   * (non-Javadoc)
   * 
   * @seecom.safi.workshop.sqlexplorer.connections.actions.AbstractConnectionTreeAction#
   * isAvailable()
   */
  @Override
  public boolean isAvailable() {
    if (getView() == null)
      return false;
    User user = getView().getSelectedUser(false);
    return user != null && !user.getAlias().hasNoUserName();
  }
}
