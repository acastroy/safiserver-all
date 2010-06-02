/*
 * Copyright (C) 2006 Davy Vanherbergen
 * dvanherbergen@users.sourceforge.net
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
package com.safi.workshop.sqlexplorer.dataset.actions;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableItem;

import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dataset.DataSet;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.sqleditor.results.CellRange.Column;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * Copy an entire datasettable to the clipboard.
 * 
 * @author Davy Vanherbergen
 */
public class CopyTableAction extends AbstractDataSetTableContextAction {

  private static final ImageDescriptor _image = ImageUtil.getDescriptor("Images.CopyIcon");

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.action.IAction#getText()
   */
  @Override
  public String getText() {
    return Messages.getString("DataSetTable.Actions.CopyToClipboard");
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.action.IAction#getImageDescriptor()
   */
  @Override
  public ImageDescriptor getImageDescriptor() {
    return _image;
  }

  /**
   * Copy all table data to clipboard
   * 
   * @see org.eclipse.jface.action.IAction#run()
   */
  @Override
  public void run() {

    BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {

      public void run() {

        try {

          // create clipboard
          Clipboard clipBoard = new Clipboard(Display.getCurrent());
          TextTransfer textTransfer = TextTransfer.getInstance();
          StringBuffer buffer = new StringBuffer("");

          // get preferences
          String lineSeparator = System.getProperty("line.separator");
          String columnSeparator = SQLExplorerPlugin.getDefault().getPreferenceStore().getString(
              IConstants.CLIP_EXPORT_SEPARATOR);
          boolean includeColumnNames = SQLExplorerPlugin.getDefault().getPreferenceStore()
              .getBoolean(IConstants.CLIP_EXPORT_COLUMNS);

          TableItem[] items = _table.getItems();
          DataSet dataSet = (DataSet) _table.getData();

          if (items == null || dataSet == null) {
            return;
          }

          // export column names
          if (includeColumnNames) {

            DataSet.Column[] columns = dataSet.getColumns();
            for (Column column : columns) {
              buffer.append(column.getCaption());
              buffer.append(columnSeparator);
            }
            buffer.append(lineSeparator);
          }

          // export column data
          int columnCount = _table.getColumnCount();
          for (TableItem item : items) {

            for (int j = 0; j < columnCount; j++) {
              buffer.append(item.getText(j));
              buffer.append(columnSeparator);
            }
            buffer.append(lineSeparator);
          }

          // put all on clipboard
          clipBoard
              .setContents(new Object[] { buffer.toString() }, new Transfer[] { textTransfer });

        } catch (Exception e) {
          SQLExplorerPlugin.error("Error exporting to clipboard ", e);
        }
      }
    });

  }

}
