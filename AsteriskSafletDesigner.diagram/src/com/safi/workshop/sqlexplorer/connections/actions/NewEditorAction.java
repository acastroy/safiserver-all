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

import java.util.HashSet;
import java.util.Set;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import com.safi.db.Query;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.SafiNavigator;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * @author Davy Vanherbergen
 * 
 */
public class NewEditorAction extends AbstractConnectionTreeAction implements IViewActionDelegate {

  public NewEditorAction() {
    super("ConnectionsView.Actions.NewEditor", "ConnectionsView.Actions.NewEditorToolTip",
        "Images.OpenSQLIcon");
    setDisabledImageDescriptor(ImageUtil.getDescriptor("Images.AliasIcon"));
  }

  @Override
  public void run() {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog.openError(Display.getCurrent().getActiveShell(), "Not Connected",
          "You must be connected to a SafiServer instance to access this feature");
      return;
    }
    final SafiNavigator nav = getView();
    nav.switchToDBPerspective();

    Set<User> users = getView().getSelectedUsers(true);
    if (users != null) {
      for (User user : users)
        getView().openNewEditor(user);
    } else {
      Set<com.safi.db.Query> queries = getView().getSelectedQueries(true);
      if (queries != null) {
        Set<User> usrs = new HashSet<User>();
        for (Query qry : queries) {
          usrs.add(getView().getAliasForQuery(qry).getDefaultUser());
        }

        for (User u : usrs) {
          getView().openNewEditor(u);
        }
      }
    }
    getView().refresh();
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    // TODO Auto-generated method stub
    // super.selectionChanged(action, selection);
  }

  /**
   * Only show action when there is at least 1 item selected
   * 
   * @see com.safi.workshop.sqlexplorer.connections.actions.AbstractConnectionTreeAction#isAvailable()
   */
  @Override
  public boolean isAvailable() {
    if (getView() == null)
      return false;
    return getView().getSelectedUsers(true) != null || getView().getSelectedQueries(true) != null;
  }
}
