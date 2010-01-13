package com.safi.workshop.sqlexplorer.history.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPage;
import com.safi.db.DbFactory;
import com.safi.db.Query;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dialogs.NewQueryDialog;
import com.safi.workshop.sqlexplorer.history.SQLHistoryElement;
import com.safi.workshop.sqlexplorer.parsers.BasicQueryParser;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInput;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

public class AddDBQueryAction extends AbstractHistoryContextAction {

  private ImageDescriptor _imageAddQuery = ImageUtil.getDescriptor("Images.AddQuery");

  @Override
  public ImageDescriptor getImageDescriptor() {

    return _imageAddQuery;
  }

  public AddDBQueryAction() {
    super();
    setToolTipText("Add new query");
  }

  @Override
  public String getText() {

    return Messages.getString("SQLHistoryView.AddQuery");
  }

  @Override
  public boolean isEnabled() {

    TableItem[] ti = _table.getSelection();
    if (ti == null || ti.length != 1) {
      return false;
    }
    return true;
  }

  @Override
  public void run() {

    try {
      TableItem[] selections = _table.getSelection();
      if (selections != null && selections.length != 0) {
        SQLHistoryElement el = (SQLHistoryElement) selections[0].getData();
        Query q = DbFactory.eINSTANCE.createQuery();
        q.setQuerySql(el.getRawSQLString());
        BasicQueryParser.updateParameters(q);
        NewQueryDialog d = new NewQueryDialog(Display.getDefault().getActiveShell(), q,
            NewQueryDialog.Mode.ADD);
        int result = d.open();
        if (Window.OK == result) {
          el.getAlias().addQuery(q);

          SQLEditorInput input = new SQLEditorInput(q);
          input.setUser(el.getUser());
          IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench()
              .getActiveWorkbenchWindow().getActivePage();
          if (page == null)
            return;
          SQLEditor editorPart = (SQLEditor) page.openEditor(input, SQLEditor.class.getName());
          editorPart.setText(q.getQuerySql());
        }
      }

    } catch (Throwable e) {
      SQLExplorerPlugin.error("Error removing item from clipboard", e);
    }
  }
}
