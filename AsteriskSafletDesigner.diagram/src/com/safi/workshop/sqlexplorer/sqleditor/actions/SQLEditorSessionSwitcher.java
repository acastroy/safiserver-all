/*
 * Copyright (C) 2007 SQL Explorer Development Team
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
package com.safi.workshop.sqlexplorer.sqleditor.actions;

import java.util.HashMap;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.connections.SessionEstablishedListener;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.AliasManager;
import com.safi.workshop.sqlexplorer.dbproduct.ConnectionJob;
import com.safi.workshop.sqlexplorer.dbproduct.ConnectionListener;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.editors.SwitchableSessionEditor;

public class SQLEditorSessionSwitcher extends ControlContribution implements ConnectionListener,
    SessionEstablishedListener {

  private SwitchableSessionEditor _editor;
  private Combo _sessionCombo;
  private HashMap<Integer, User> sessionIndexes = new HashMap<Integer, User>();

  /**
   * @param editor
   *          SQLEditor to which this session switcher belongs
   */
  public SQLEditorSessionSwitcher(SwitchableSessionEditor editor) {
    super("com.safi.workshop.sqlexplorer.sessionswitcher");
    _editor = editor;
  }

  @Override
  protected Control createControl(Composite parent) {
    AliasManager aliasManager = SQLExplorerPlugin.getDefault().getAliasManager();
    if (aliasManager != null)
      aliasManager.addListener(this);

    _sessionCombo = new Combo(parent, SWT.READ_ONLY);
    _sessionCombo.setToolTipText(Messages.getString("SQLEditor.Actions.ChooseSession.ToolTip"));

    _sessionCombo.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent event) {

        // change session for this editor
        User user = null;
        int selIndex = _sessionCombo.getSelectionIndex();
        if (selIndex != 0)
          user = sessionIndexes.get(selIndex - 1);

        // Nothing to do?
        if (user != null && _editor.getSession() != null && _editor.getSession().getUser() == user)
          return;

        // Disconnect from the current session while we try to connect
        _editor.setSession(null);
        _sessionCombo.deselectAll();
        _editor.refreshToolbars();

        if (user == null)
          return;

        // Start the connection job
        ConnectionJob.createSession(user.getAlias(), user, SQLEditorSessionSwitcher.this, false);
      }
    });
    setSessionOptions();
    // if (_sessionCombo.getItemCount() == 1)
    // MessageDialog.openInformation(parent.getShell(), Messages
    // .getString("SQLEditor.Actions.ChooseSession.NoConnections.Title"), Messages
    // .getString("SQLEditor.Actions.ChooseSession.NoConnections.Message"));

    return _sessionCombo;
  }

  @Override
  public void dispose() {
    SQLExplorerPlugin.getDefault().getAliasManager().removeListener(this);
    super.dispose();
  }

  private void setSessionOptions() {
    if (_sessionCombo.isDisposed())
      return;
    _sessionCombo.removeAll();
    _sessionCombo.add("");

    int index = 0;
    Alias currentAlias = null;
    User currentUser = null;
    if (_editor.getSession() != null) {
      currentUser = _editor.getSession().getUser();
      if (currentUser != null)
        currentAlias = currentUser.getAlias();
    }

    AliasManager aliasManager = SQLExplorerPlugin.getDefault().getAliasManager();
    if (aliasManager == null) {
      try {
        SQLExplorerPlugin.getDefault().buildDBNavModel();
        aliasManager = SQLExplorerPlugin.getDefault().getAliasManager();
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }

    if (aliasManager != null)
      for (Alias alias : aliasManager.getAliases()) {
        if (currentAlias != null && alias != currentAlias)
          continue;
        for (User user : alias.getUsers()) {
          _sessionCombo.add(user.getDescription());
          sessionIndexes.put(new Integer(index++), user);
          if (currentUser == user)
            _sessionCombo.select(_sessionCombo.getItemCount() - 1);
        }
      }
  }

  public void modelChanged() {
    if (_sessionCombo != null && !_sessionCombo.isDisposed())
      _editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {
        public void run() {
          setSessionOptions();
        }
      });
  }

  public void cannotEstablishSession(User user) {
    if (_sessionCombo.isDisposed())
      return;
    _editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {
      public void run() {
        _sessionCombo.deselectAll();
        _editor.refreshToolbars();
      }
    });
  }

  public void sessionEstablished(final Session session) {
    if (_sessionCombo.isDisposed())
      return;
    _editor.getSite().getShell().getDisplay().asyncExec(new Runnable() {
      public void run() {
        _editor.setSession(session);
        setSessionOptions();
        // SQLExplorerPlugin.getDefault().getConnectionsView().setDefaultUser(session.getUser());
        _editor.refreshToolbars();
      }
    });
  }
}
