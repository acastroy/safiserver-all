package com.safi.workshop.sqlexplorer.history.actions;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

public class ClearHistoryAction extends AbstractHistoryContextAction {

  private ImageDescriptor _imageRemoveAll = ImageUtil.getDescriptor("Images.RemoveAllIcon");

  @Override
  public ImageDescriptor getImageDescriptor() {

    return _imageRemoveAll;
  }

  @Override
  public String getText() {

    return Messages.getString("SQLHistoryView.ClearHistory");
  }

  @Override
  public void run() {

    try {

      boolean ok = MessageDialog.openConfirm(_table.getShell(), Messages
          .getString("SQLHistoryView.ClearHistory"), Messages
          .getString("SQLHistoryView.ClearHistory.Confirm"));

      if (ok) {
        _history.clear();
        _table.deselectAll();
        setEnabled(false);
      }
    } catch (Throwable e) {
      SQLExplorerPlugin.error("Error clearing sql history", e);
    }
  }
}
