package com.safi.workshop.sqlexplorer.history.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.TableItem;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.history.SQLHistoryElement;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

public class RemoveFromHistoryAction extends AbstractHistoryContextAction {

  private ImageDescriptor _imageRemove = ImageUtil.getDescriptor("Images.RemoveIcon");

  @Override
  public ImageDescriptor getImageDescriptor() {

    return _imageRemove;
  }

  @Override
  public String getText() {

    return Messages.getString("SQLHistoryView.RemoveFromHistory");
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
      TableItem[] selections = _table.getSelection();
      if (selections != null && selections.length != 0) {
        for (TableItem selection : selections) {
          SQLHistoryElement el = (SQLHistoryElement) selection.getData();
          if (el != null) {
            _history.remove(el);
          }
        }
      }
      _table.deselectAll();
      setEnabled(false);

    } catch (Throwable e) {
      SQLExplorerPlugin.error("Error removing item from clipboard", e);
    }
  }

}
