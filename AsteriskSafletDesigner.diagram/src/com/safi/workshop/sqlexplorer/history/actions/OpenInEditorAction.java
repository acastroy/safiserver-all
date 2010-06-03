package com.safi.workshop.sqlexplorer.history.actions;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IWorkbenchPage;

import com.safi.workshop.SafiNavigator;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.SafiWorkshopEditorUtil;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.history.SQLHistoryElement;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.actions.OpenPasswordConnectDialogAction;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInput;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

public class OpenInEditorAction extends AbstractHistoryContextAction {

  private ImageDescriptor _imageOpenInEditor = ImageUtil.getDescriptor("Images.OpenSQLIcon");

  @Override
  public ImageDescriptor getImageDescriptor() {

    return _imageOpenInEditor;
  }

  @Override
  public String getText() {

    return Messages.getString("SQLHistoryView.OpenInEditor");
  }

  @Override
  public boolean isEnabled() {

    TableItem[] ti = _table.getSelection();
    if (ti == null || ti.length == 0) {
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

        if (ti.length > 0) {
          copiedText.append(queryDelimiter);
          copiedText.append("\n");
        }
      }

      SQLHistoryElement sqlHistoryElement = (SQLHistoryElement) ti[0].getData();
      User user = sqlHistoryElement.getUser();
      Alias alias;
      if (user != null)
        alias = user.getAlias();
      else {
        alias = sqlHistoryElement.getAlias();
        if (alias != null)
          user = alias.getDefaultUser();
        if (user == null) {
          SafiNavigator nav = SafiWorkshopEditorUtil.getSafiNavigator();
          if (nav != null)
            user = nav.getDefaultUser();

        }
      }

      if (user != null && !user.hasAuthenticated()) {
        boolean okToOpen = MessageDialog.openConfirm(_table.getShell(), Messages
            .getString("SQLHistoryView.OpenInEditor.Confirm.Title"), Messages
            .getString("SQLHistoryView.OpenInEditor.Confirm.Message.Prefix")
            + " "
            + user.getDescription()
            + Messages.getString("SQLHistoryView.OpenInEditor.Confirm.Message.Postfix"));

        if (okToOpen) {
          OpenPasswordConnectDialogAction openDlgAction = new OpenPasswordConnectDialogAction(
              alias, user, false);
          openDlgAction.run();
        }
      }

      SQLEditorInput input = new SQLEditorInput("SQL Editor ("
          + SQLExplorerPlugin.getDefault().getEditorSerialNo() + ").sql");
      input.setUser(user);
      IWorkbenchPage page = SQLExplorerPlugin.getDefault().getWorkbench()
          .getActiveWorkbenchWindow().getActivePage();
      if (page == null)
        return;
      SQLEditor editorPart = (SQLEditor) page.openEditor(input, SQLEditor.class.getName());
      editorPart.setText(copiedText.toString());

    } catch (Throwable e) {
      SQLExplorerPlugin.error("Error creating sql editor", e);
    }
  }
}
