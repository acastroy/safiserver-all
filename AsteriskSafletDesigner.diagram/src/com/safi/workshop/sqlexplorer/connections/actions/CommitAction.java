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

import java.sql.SQLException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.sqlexplorer.dbproduct.SQLConnection;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

/**
 * @author Davy Vanherbergen
 * 
 */
public class CommitAction extends AbstractConnectionTreeAction implements IViewActionDelegate {

  public CommitAction() {
    super("ConnectionsView.Actions.Commit", null, "Images.CommitIcon");
  }

  @Override
  public void run() {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Not Connected",
          "You must be connected to a SafiServer instance to access this feature");
      return;
    }
    for (SQLConnection connection : getView().getSelectedConnections(true))
      try {
        if (!connection.getAutoCommit())
          connection.commit();
      } catch (SQLException e) {
        SQLExplorerPlugin.error(e);
      }
  }

  /**
   * Action is available when there is at least one session without autocommit selected
   * 
   * @see com.safi.workshop.sqlexplorer.connections.actions.AbstractConnectionTreeAction#isAvailable()
   */
  @Override
  public boolean isAvailable() {
    if (getView() == null)
      return false;
    for (SQLConnection connection : getView().getSelectedConnections(true))
      try {
        if (!connection.getAutoCommit())
          return true;
      } catch (SQLException e) {
        SQLExplorerPlugin.error(e);
      }

    return false;
  }
}
