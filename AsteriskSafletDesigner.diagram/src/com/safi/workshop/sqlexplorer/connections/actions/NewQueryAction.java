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

import java.util.Date;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import com.safi.db.DBConnection;
import com.safi.db.DbFactory;
import com.safi.db.Query;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.SafiNavigator;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sqlexplorer.SQLCannotConnectException;
import com.safi.workshop.sqlexplorer.connections.SessionEstablishedAdapter;
import com.safi.workshop.sqlexplorer.connections.SessionEstablishedListener;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.ConnectionJob;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInput;
import com.safi.workshop.sqlexplorer.plugin.views.DatabaseStructureView;

/**
 * @author Davy Vanherbergen
 * 
 */
public class NewQueryAction extends AbstractConnectionTreeAction {

  private String sql;
  private String queryName;
  private User user;

  public NewQueryAction() {
    super("ConnectionsView.Actions.NewQuery", "ConnectionsView.Actions.NewQueryToolTip",
        "Images.AddQuery");
  }

  @Override
  public void run() {
    try {
      if (!SafiServerPlugin.getDefault().isConnected()) {
        MessageDialog.openError(Display.getCurrent().getActiveShell(), "Not Connected",
            "You must be connected to a SafiServer instance to access this feature");
        return;
      }
      final SafiNavigator nav = getView();
      nav.switchToDBPerspective();
      final Query qry = DbFactory.eINSTANCE.createQuery();
      if (StringUtils.isNotBlank(sql))
        qry.setQuerySql(sql);
      Alias alias = null;
      DBConnection connection = null;
      if (user == null) {
        alias = getView().getSelectedAlias(true);
        user = alias.getDefaultUser();
      } else {
        alias = user.getAlias();
      }

      connection = alias.getConnection();
      final DBConnection fconn = connection;
      InputDialog dlg = new InputDialog(AsteriskDiagramEditorUtil.getActiveShell(), "New Query",
          "Enter a new query name", connection.getUniqueQueryName(queryName),
          new IInputValidator() {
            @Override
            public String isValid(String newText) {
              if (StringUtils.isBlank(newText)) {
                return "Query name must not be blank";
              }else if(StringUtils.contains(newText, ".")){
            	return "Query name must not contain '.'";  
              }
              Query q = fconn.getQuery(newText);
              if (q != null) {
                return "Query with name " + newText + " already exists. Please select another name";
              }
              return null;
            }
          });
      if (Window.OK == dlg.open()) {
        qry.setName(dlg.getValue());
        qry.setConnection(connection);
      } else
        return;
      qry.setLastModified(new Date());
      // OpenPasswordConnectDialogAction openDlgAction = new
      // OpenPasswordConnectDialogAction(user == null ? null : user
      // .getAlias(), user, false);
      // openDlgAction.run();

      boolean notAuthenticated = false;
      if (user != null) {
        notAuthenticated = !user.hasAuthenticated();
      }
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
                    SQLEditorInput input = new SQLEditorInput(qry);
                    input.setUser(user);
                    IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench()
                        .getActiveWorkbenchWindow().getActivePage();
                    if (page == null)
                      return;

                    SQLEditor editorPart = (SQLEditor) page.openEditor(input, SQLEditor.class
                        .getName());
                    editorPart.setText(qry.getQuerySql());
                    getView().modelChanged(SafiServerPlugin.getDefault().isConnected());
                  } catch (SQLCannotConnectException e) {
                    MessageDialog.openError(Display.getDefault().getActiveShell(),
                        "Cannot connect", e.getMessage());
                  } catch (PartInitException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    MessageDialog
                        .openError(Display.getDefault().getActiveShell(), "Editor Exception",
                            "Could't create SQL Editor: " + e.getLocalizedMessage());
                  }

              }

            });
          }
        };
      } else {
        SQLEditorInput input = new SQLEditorInput(qry);
        input.setUser(user);
        IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench()
            .getActiveWorkbenchWindow().getActivePage();
        if (page == null)
          return;

        SQLEditor editorPart = (SQLEditor) page.openEditor(input, SQLEditor.class.getName());
        editorPart.setText(qry.getQuerySql());
        if (StringUtils.isNotBlank(qry.getQuerySql())) {
          editorPart.setIsDirty(true);
        }
        getView().modelChanged();
      }
      ConnectionJob.createSession(alias, user, listener, false);
      // SQLEditorInput input = new SQLEditorInput(qry);
      // input.setUser(user);
      // IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench()
      // .getActiveWorkbenchWindow().getActivePage();
      // if (page == null) return;
      // SQLEditor editorPart = (SQLEditor) page.openEditor(input,
      // SQLEditor.class.getName());
      // editorPart.setText(qry.getQuerySql());
      // getView().modelChanged();
    } catch (Throwable e) {
      SQLExplorerPlugin.error("Error creating sql editor", e);
    }
    // NewQueryDialog dlg = new NewQueryDialog(Display.getCurrent().getActiveShell(), qry,
    // NewQueryDialog.Mode.ADD);
    // dlg.setParentConnection(alias.getConnection());
    // int result = dlg.open();
    // if (result == Dialog.OK){
    // SQLExplorerPlugin.getDefault().saveDBResources();
    // getView().modelChanged();
    // }
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
  }

  @Override
  public boolean isAvailable() {
    return getView().getSelectedAlias(true) != null;
  }

  public String getSql() {
    return sql;
  }

  public void setSql(String sql) {
    this.sql = sql;
  }

  public String getQueryName() {
    return queryName;
  }

  public void setQueryName(String queryName) {
    this.queryName = queryName;
  }

  public void setUser(User user) {
    this.user = user;

  }
}
