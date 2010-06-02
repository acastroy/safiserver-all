package com.safi.workshop.sqlexplorer.history.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPage;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.history.SQLHistoryElement;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

public class AppendToEditorAction extends AbstractHistoryContextAction {

  private ImageDescriptor _imageOpenInEditor = ImageUtil.getDescriptor("Images.AppendToEditor");

  @Override
  public ImageDescriptor getImageDescriptor() {

    return _imageOpenInEditor;
  }

  @Override
  public String getText() {

    return Messages.getString("SQLHistoryView.AppendToEditor");
  }

  @Override
  public boolean isEnabled() {

    TableItem[] ti = _table.getSelection();
    if (ti == null || ti.length == 0) {
      return false;
    }

    IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
        .getActivePage();
    if (page == null) {
      return false;
    }

    if (page.getActiveEditor() == null) {
      return false;
    }

    if (!(page.getActiveEditor() instanceof SQLEditor)) {
      return false;
    }

    return true;
  }

  @Override
  public void run() {

    try {
      TableItem[] ti = _table.getSelection();
      if (ti == null || ti.length == 0) {
        return;
      }

      String queryDelimiter = AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences()
          .getString(IConstants.SQL_QRY_DELIMITER);
      StringBuffer copiedText = new StringBuffer();

      for (TableItem element : ti) {

        SQLHistoryElement el = (SQLHistoryElement) element.getData();
        copiedText.append(el.getRawSQLString());
        copiedText.append(queryDelimiter);

        if (ti.length > 1) {
          copiedText.append("\n");
        }
      }

      IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench()
          .getActiveWorkbenchWindow().getActivePage();
      if (page == null) {
        return;
      }
      SQLEditor editorPart = (SQLEditor) page.getActiveEditor();
      editorPart.setText(editorPart.getSQLToBeExecuted() + "\n" + copiedText.toString());

    } catch (Throwable e) {
      SQLExplorerPlugin.error("Error creating sql editor", e);
    }
  }
}
