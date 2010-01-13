package com.safi.workshop.sqlexplorer.history.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.history.SQLHistoryElement;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

public class CopyStatementAction extends AbstractHistoryContextAction {

  private ImageDescriptor _imageCopy = ImageUtil.getDescriptor("Images.CopyIcon");

  @Override
  public ImageDescriptor getImageDescriptor() {

    return _imageCopy;
  }

  @Override
  public String getText() {

    return Messages.getString("SQLHistoryView.CopyToClipboard");
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

      Clipboard cb = new Clipboard(Display.getCurrent());
      TextTransfer textTransfer = TextTransfer.getInstance();
      cb.setContents(new Object[] { copiedText.toString() }, new Transfer[] { textTransfer });

    } catch (Throwable e) {
      SQLExplorerPlugin.error("Error copying to clipboard", e);
    }
  }

}
