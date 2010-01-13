/*
 * Copyright (C) 2006 SQL Explorer Development Team
 * http://sourceforge.net/projects/eclipsesql
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.safi.workshop.sqlexplorer.connections.actions;

import java.util.Set;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.SafiNavigator;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.SQLConnection;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * @author Davy Vanherbergen
 * 
 */
public class CloseAllConnectionsAction extends AbstractConnectionTreeAction implements
    IViewActionDelegate {

  public CloseAllConnectionsAction() {
    super("ConnectionsView.Actions.CloseAllConnections",
        "ConnectionsView.Actions.CloseAllConnectionsToolTip", "Images.CloseAllConnsIcon");
    setDisabledImageDescriptor(ImageUtil.getDescriptor("Images.DisabledCloseAllConnsIcon"));
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.action.IAction#run()
   */
  @Override
  public void run() {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Not Connected",
          "You must be connected to a SafiServer instance to access this feature");
      return;
    }
    boolean confirm = AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().getBoolean(
        IConstants.CONFIRM_BOOL_CLOSE_ALL_CONNECTIONS);
    if (confirm) {
      MessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(getView()
          .getSite().getShell(), Messages
          .getString("ConnectionsView.Actions.CloseAll.Confirm.Title"), Messages
          .getString("ConnectionsView.Actions.CloseAll.Confirm.Message"), Messages
          .getString("ConnectionsView.Actions.CloseAll.Confirm.Toggle"), false, null, null);

      if (dialog.getToggleState() && dialog.getReturnCode() == IDialogConstants.YES_ID)
        AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().setValue(
            IConstants.CONFIRM_BOOL_CLOSE_ALL_CONNECTIONS, false);
      if (dialog.getReturnCode() != IDialogConstants.YES_ID)
        return;
    }

    Set<SQLConnection> connections = getView().getSelectedConnections(true);
    for (SQLConnection connection : connections) {
      synchronized (connection) {
        Session session = connection.getSession();
        if (session != null) {
          synchronized (session) {
            if (!session.isConnectionInUse())
              session.disposeConnection();
          }
        } else
          connection.getUser().releaseFromPool(connection);
      }
    }

    setEnabled(false);
    getView().refresh();
  }

  /**
   * Action is available when there are open sessions
   */
  @Override
  public boolean isAvailable() {
    SafiNavigator view = getView();
    if (view == null)
      return false;
    Set<SQLConnection> connections = view.getSelectedConnections(true);
    if (connections.isEmpty()) {
      for (Alias alias : SQLExplorerPlugin.getDefault().getAliasManager().getAliases())
        for (User user : alias.getUsers())
          for (SQLConnection connection : user.getConnections()) {
            Session session = connection.getSession();
            if (session == null || !session.isConnectionInUse())
              return true;
          }
    } else
      for (SQLConnection connection : connections) {
        Session session = connection.getSession();
        if (session == null || !session.isConnectionInUse())
          return true;
      }
    return false;
  }
}
