package com.safi.workshop.sqlexplorer.plugin.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

public class CopyTextToEditorAction extends Action {

  private ImageDescriptor _image = ImageUtil.getDescriptor("Images.CopyTextToEditor");
  private CopyTextProvider _provider;

  public CopyTextToEditorAction(CopyTextProvider pProvider) {
    this._provider = pProvider;
  }

  @Override
  public ImageDescriptor getImageDescriptor() {

    return _image;
  }

  @Override
  public String getText() {

    return Messages.getString("SQLEditor.Actions.CopyTextToEditor");
  }

  @Override
  public boolean isEnabled() {

    String text = this._provider.getCopyText();
    if (text == null || text.length() == 0) {
      return false;
    }

    SQLEditor editor = getCurrentSQLEditor();
    if (editor == null) {
      return false;
    }

    return true;
  }

  private SQLEditor getCurrentSQLEditor() {
    IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow()
        .getActivePage();
    if (page == null) {
      return null;
    }

    if (!(page.getActiveEditor() instanceof SQLEditor)) {
      return null;
    }
    return (SQLEditor) page.getActiveEditor();
  }

  @Override
  public void run() {

    try {
      String text = this._provider.getCopyText();
      if (text == null || text.length() == 0) {
        return;
      }

      SQLEditor editor = getCurrentSQLEditor();
      if (editor == null) {
        return;
      }
      editor.insertText(text);

    } catch (Throwable e) {
      SQLExplorerPlugin.error("Error inserting text in sql editor", e);
    }
  }
}
