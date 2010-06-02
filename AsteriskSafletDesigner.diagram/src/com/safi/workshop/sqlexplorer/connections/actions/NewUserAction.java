/*
 * Copyright (C) 2006 Davy Vanherbergen
 * dvanherbergen@users.sourceforge.net
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

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dialogs.EditUserDlg;

/**
 * @author Davy Vanherbergen
 * 
 */
public class NewUserAction extends AbstractConnectionTreeAction {

  public NewUserAction() {
    super("ConnectionsView.Actions.NewUser", "ConnectionsView.Actions.NewUser.ToolTip",
        "Images.ConnectionsView.NewUser");
  }

  @Override
  public void run() {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Not Connected",
          "You must be connected to a SafiServer instance to access this feature");
      return;
    }
    Alias alias = getView().getSelectedAlias(true);
    EditUserDlg dlg = new EditUserDlg(Display.getCurrent().getActiveShell(),
        EditUserDlg.Type.CREATE, alias, null);
    dlg.open();
    getView().refresh();
  }

  /**
   * Only show action when there is at least 1 alias selected
   * 
   * @see com.safi.workshop.sqlexplorer.connections.actions.AbstractConnectionTreeAction#isAvailable()
   */
  @Override
  public boolean isAvailable() {
    if (getView() == null)
      return false;
    Alias alias = getView().getSelectedAlias(true);
    return alias != null && !alias.hasNoUserName();
  }
}
