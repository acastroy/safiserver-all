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
package com.safi.workshop.sqlexplorer.plugin.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import com.safi.workshop.sqlexplorer.SQLCannotConnectException;
import com.safi.workshop.sqlexplorer.connections.SessionEstablishedAdapter;
import com.safi.workshop.sqlexplorer.connections.SessionEstablishedListener;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.ConnectionJob;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.views.DatabaseStructureView;

public class OpenPasswordConnectDialogAction extends Action {

  // The Alias to login - this MUST be the same as the user's alias; the
  // reason we keep this in addition to the User object is in case we are
  // logging in a new user that we have no initial definition for
  private Alias alias;

  // The user to try and login
  private User user;

  private final static int CONNECTION_TIMEOUT = 300000;
  private final static Object lock = new Object();
  // Whether to prompt for the password, even if the user is auto-logon etc
  private boolean alwaysPrompt;

  public OpenPasswordConnectDialogAction(Alias alias, User user, boolean alwaysPrompt) {
    super();
    if (alias == null)
      throw new IllegalArgumentException("Alias cannot be null!");
    if (user != null && alias != user.getAlias())
      throw new IllegalArgumentException("User is attached the wrong alias");

    this.alias = alias;
    this.user = user;
    this.alwaysPrompt = alwaysPrompt;
  }

  @Override
  public void run() {
    final boolean notAuthenticated = !user.hasAuthenticated();
    SessionEstablishedListener listener = null;
    if (notAuthenticated) {
      listener = new SessionEstablishedAdapter() {
        @Override
        public void sessionEstablished(Session session) {
          // synchronized (lock) {
          // lock.notifyAll();
          // }

          Display.getDefault().asyncExec(new Runnable() {
            public void run() {

              DatabaseStructureView dsView = SQLExplorerPlugin.getDefault()
                  .showDatabaseStructureView();
              // DatabaseStructureView dsView =
              // SQLExplorerPlugin.getDefault().getDatabaseStructureView();
              if (dsView != null)
                try {
                  dsView.addUser(user);
                } catch (SQLCannotConnectException e) {
                  MessageDialog.openError(Display.getDefault().getActiveShell(), "Cannot connect",
                      e.getMessage());
                }

            }

          });
        }
      };
    }
    ConnectionJob.createSession(alias, user, listener, alwaysPrompt);
  }
}
