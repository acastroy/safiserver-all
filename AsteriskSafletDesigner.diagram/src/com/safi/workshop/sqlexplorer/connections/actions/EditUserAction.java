package com.safi.workshop.sqlexplorer.connections.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.dialogs.EditUserDlg;

public class EditUserAction extends AbstractConnectionTreeAction {

  public EditUserAction() {
    super("ConnectionsView.Actions.EditUser", null, "Images.ConnectionsView.EditUser");
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
    if (user == null)
      return;
    EditUserDlg dlg = new EditUserDlg(Display.getCurrent().getActiveShell(), EditUserDlg.Type.EDIT,
        user.getAlias(), user);
    dlg.open();
    getView().refresh();
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
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
