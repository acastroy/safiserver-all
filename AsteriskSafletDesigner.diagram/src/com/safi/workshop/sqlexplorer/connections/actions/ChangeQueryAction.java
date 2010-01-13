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

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import com.safi.db.Query;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.SafiNavigator;
import com.safi.workshop.sqlexplorer.dialogs.NewQueryDialog;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

/**
 * @author Davy Vanherbergen
 * 
 */
public class ChangeQueryAction extends AbstractConnectionTreeAction {

  public ChangeQueryAction() {
    super("ConnectionsView.Actions.ChangeQuery", "ConnectionsView.Actions.ChangeQueryToolTip",
        "Images.ModifyQuery");
  }

  @Override
  public void run() {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Not Connected",
          "You must be connected to a SafiServer instance to access this feature");
      return;
    }
    Query firstQuery = getView().getSelectedQueries(false).iterator().next();
    NewQueryDialog dlg = new NewQueryDialog(Display.getCurrent().getActiveShell(), firstQuery,
        NewQueryDialog.Mode.MODIFY);
    int result = dlg.open();
    if (result == Window.OK) {
      SQLExplorerPlugin.getDefault().saveDBResources(false);
      getView().modelChanged(SafiServerPlugin.getDefault().isConnected());
    }
    getView().refresh();
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
  }

  @Override
  public boolean isAvailable() {
    final SafiNavigator view = getView();
    if (view == null)
      return false;
    java.util.Set<com.safi.db.Query> q = view.getSelectedQueries(false);
    return q != null && !q.isEmpty();
  }
}
