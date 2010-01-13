package com.safi.workshop.sqlexplorer.sqleditor.actions;

import java.sql.SQLException;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import com.safi.db.Query;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbproduct.MetaDataSession;
import com.safi.workshop.sqlexplorer.dbproduct.SQLConnection;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInput;
import com.safi.workshop.sqlexplorer.plugin.editors.SwitchableSessionEditor;

public class SQLEditorCatalogSwitcher extends ControlContribution {

  private SwitchableSessionEditor _editor;

  private Combo _catalogCombo;

  /**
   * @param editor
   *          SQLEditor to which this catalog switcher belongs
   */
  public SQLEditorCatalogSwitcher(SwitchableSessionEditor editor) {

    super("com.safi.workshop.sqlexplorer.catalogswitcher");

    _editor = editor;

  }

  @Override
  protected Control createControl(Composite parent) {

    _catalogCombo = new Combo(parent, SWT.READ_ONLY);
    _catalogCombo.setToolTipText(Messages.getString("SQLEditor.Actions.ChooseCatalog.ToolTip"));
    _catalogCombo.setSize(200, _catalogCombo.getSize().y);

    // Uncomment for PRODUCTION release
    // _catalogCombo.setEnabled(false);
    _catalogCombo.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent arg0) {

        int selIndex = _catalogCombo.getSelectionIndex();
        String newCat = _catalogCombo.getItem(selIndex);

        if (_editor.getSession() != null) {
          try {
            _editor.getSession().setCatalog(newCat);
            if (_editor instanceof SQLEditor) {
              IEditorInput input = ((SQLEditor) _editor).getEditorInput();
              if (input instanceof SQLEditorInput) {
                Query qry = ((SQLEditorInput) input).getQuery();
                // Uncomment for PRODUCTION release
                if (qry != null) {
                  qry.setCatalog(newCat);
                  ((SQLEditor) _editor).setIsDirty(true);
                }
              }
            }
          } catch (Exception e1) {
            SQLExplorerPlugin.error("Error changing catalog", e1);
          }
        }
      }
    });

    _catalogCombo.add("");

    if (_editor.getSession() != null) {

      try {
        String[] catalogs = getMetaDataSession().getCatalogs();
        final User user = _editor.getSession().getUser();
        if (user.isOfflineMode())
          return _catalogCombo;

        // Get the connection directly from the user because the session may be busy with
        // its one one
        SQLConnection connection = null;
        try {
          connection = user.getConnection();
        } catch (final SQLException e) {
          throw e;
          // if (user.isPrompted())
          // throw e;
          // final Display display = UIPlugin.getDefault().getWorkbench().getDisplay();
          // final boolean[] result = new boolean[] { false };
          // Runnable runnable = new Runnable() {
          // public void run() {
          // result[0] = MessageDialog.openQuestion(display.getActiveShell(),
          // "Connection Failed",
          // "Connection could not be established to " + user.getAlias().getName()+
          // ": "+e.getLocalizedMessage()
          // + ". Would you like to continue in offline mode?");
          //
          // }
          // };
          // if (Thread.currentThread() != display.getThread()) {
          //            
          // display.syncExec(runnable);
          // }
          // else
          // runnable.run();
          // user.setPrompted(true);
          // if (result[0])
          // user.setOfflineMode(true);
          // else {
          // throw e;
          // }
        }

        try {
          String currentCatalog = connection.getCatalog();
          if (_editor instanceof SQLEditor) {
            IEditorInput input = ((SQLEditor) _editor).getEditorInput();
            if (input instanceof SQLEditorInput) {
              Query qry = ((SQLEditorInput) input).getQuery();
              // Uncomment for PRODUCTION release
              if (qry != null && StringUtils.isNotBlank(qry.getCatalog())) {
                currentCatalog = qry.getCatalog();
              }
            }
          }
          if (currentCatalog != null) {
            for (String catalog : catalogs) {
              _catalogCombo.add(catalog);
              if (currentCatalog.equals(catalog)) {
                _catalogCombo.select(_catalogCombo.getItemCount() - 1);
              }
            }
          }
        } finally {
          if (connection != null)
            user.releaseConnection(connection);
        }
      } catch (SQLException e) {
        e.printStackTrace();
        SQLExplorerPlugin.error(e);
      }
    }

    return _catalogCombo;
  }

  private MetaDataSession getMetaDataSession() {
    return _editor.getSession().getUser().getMetaDataSession();
  }

  public String getSelectedCatalog() {
    if (Thread.currentThread() != _catalogCombo.getDisplay().getThread()) {
      final String[] result = new String[1];
      Runnable runna = new Runnable() {
        @Override
        public void run() {
          final int idx = _catalogCombo.getSelectionIndex();
          if (idx < 0)
            return;
          result[0] = _catalogCombo.getItem(idx);

        }
      };
      _catalogCombo.getDisplay().syncExec(runna);
      return result[0];
    }
    final int idx = _catalogCombo.getSelectionIndex();
    if (idx < 0)
      return null;
    return _catalogCombo.getItem(idx);
  }

}
