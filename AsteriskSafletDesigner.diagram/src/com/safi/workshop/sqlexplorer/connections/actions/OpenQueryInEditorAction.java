package com.safi.workshop.sqlexplorer.connections.actions;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import com.safi.db.Query;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.SafiNavigator;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.SQLCannotConnectException;
import com.safi.workshop.sqlexplorer.connections.SessionEstablishedAdapter;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.ConnectionJob;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInput;
import com.safi.workshop.sqlexplorer.plugin.views.DatabaseStructureView;

public class OpenQueryInEditorAction extends AbstractConnectionTreeAction {

  // private Query query;

  public OpenQueryInEditorAction() {
    super("ConnectionsView.Actions.OpenQuery", "ConnectionsView.Actions.OpenQueryToolTip",
        "Images.OpenQueryIcon");
  }

  @Override
  public String getText() {

    return Messages.getString("ConnectionsView.Actions.OpenQuery");
  }

  @Override
  public boolean isAvailable() {
    final SafiNavigator view = getView();
    if (view == null)
      return false;
    java.util.Set<com.safi.db.Query> q = view.getSelectedQueries(false);
    return q != null && !q.isEmpty();
  }

  // }
  // public boolean isEnabled() {
  // return query != null;
  // }

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
      java.util.Set<com.safi.db.Query> q = nav.getSelectedQueries(false);
      if (q == null || q.isEmpty())
        return;
      final Query qry = q.iterator().next();
      Alias alias = nav.getAliasForQuery(qry);
      final User user = alias.getDefaultUser();

      // if (user != null && !user.hasAuthenticated() && !user.isOfflineMode()) {
      // boolean okToOpen =
      // MessageDialog.openConfirm(Display.getCurrent().getActiveShell(),
      // Messages.getString("SQLHistoryView.OpenInEditor.Confirm.Title"),
      // Messages.getString("SQLHistoryView.OpenInEditor.Confirm.Message.Prefix") + " "
      // + user.getDescription()
      // + Messages.getString("SQLHistoryView.OpenInEditor.Confirm.Message.Postfix"));
      //
      // if (okToOpen) {
      // OpenPasswordConnectDialogAction openDlgAction = new
      // OpenPasswordConnectDialogAction(alias, user, false);
      // openDlgAction.run();
      // }
      // }
      final boolean notAuthenticated = !user.hasAuthenticated();
      SessionEstablishedAdapter listener = new SessionEstablishedAdapter() {
        @Override
        public void sessionEstablished(Session session) {
          // synchronized (lock) {
          // lock.notifyAll();
          // }

          Display.getDefault().asyncExec(new Runnable() {
            public void run() {
              if (notAuthenticated) {
                DatabaseStructureView dsView = SQLExplorerPlugin.getDefault()
                    .showDatabaseStructureView();
                // DatabaseStructureView dsView =
                // SQLExplorerPlugin.getDefault().getDatabaseStructureView();
                if (dsView != null)
                  try {
                    dsView.addUser(user);
                  } catch (SQLCannotConnectException e) {
                    MessageDialog.openError(Display.getDefault().getActiveShell(),
                        "Cannot connect", e.getMessage());
                  }
              }
              SQLEditorInput input = new SQLEditorInput(qry);
              // user.sessionEstablished(session);
              input.setUser(user);
              IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench()
                  .getActiveWorkbenchWindow().getActivePage();
              if (page == null)
                return;
              try {
                SQLEditor editorPart = (SQLEditor) page
                    .openEditor(input, SQLEditor.class.getName());
                editorPart.setText(qry.getQuerySql());
              } catch (Throwable e) {
                e.printStackTrace();
                SQLExplorerPlugin.error("Error creating sql editor", e);
              }
            }

          });
        }
      };
      ConnectionJob.createSession(alias, user, listener, false);
      // OpenPasswordConnectDialogAction openDlgAction = new
      // OpenPasswordConnectDialogAction(user
      // .getAlias(), user, false);
      // openDlgAction.run();

      // SQLEditorInput input = new SQLEditorInput(qry);
      // input.setUser(user);
      // IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench()
      // .getActiveWorkbenchWindow().getActivePage();
      // if (page == null) return;
      // SQLEditor editorPart = (SQLEditor) page.openEditor(input,
      // SQLEditor.class.getName());
      // editorPart.setText(qry.getQuerySql());

    } catch (Throwable e) {
      e.printStackTrace();
      SQLExplorerPlugin.error("Error creating sql editor", e);
    }
  }
}
