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
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * Copy the column name of the selected column to the clipboard.
 * 
 * @author Davy Vanherbergen
 */
public class CopyColumnNameAction extends AbstractDataSetTableContextAction {

  private static final ImageDescriptor _image = ImageUtil
      .getDescriptor("Images.ExportToClipBoardIcon");

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.action.IAction#getText()
   */
  @Override
  public String getText() {
    return Messages.getString("DataSetTable.Actions.CopyColumnName");
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

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.jface.action.IAction#run()
   */
  @Override
  public void run() {

    try {

      Clipboard clipBoard = new Clipboard(Display.getCurrent());
      TextTransfer textTransfer = TextTransfer.getInstance();

      TableItem[] items = _table.getSelection();

      if (items == null || items.length == 0) {
        return;
      }

      int columnIndex = _cursor.getColumn();
      TableColumn column = _table.getColumn(columnIndex);

      clipBoard.setContents(new Object[] { column.getText() }, new Transfer[] { textTransfer });

    } catch (Exception e) {
      SQLExplorerPlugin.error("Error exporting cell to clipboard ", e);
    }
  }

  /**
   * Only show action if something is selected
   * 
   * @see com.safi.workshop.sqlexplorer.dataset.actions.AbstractDataSetTableContextAction#isAvailable()
   */
  @Override
  public boolean isAvailable() {

    return (_table.getSelectionIndex() != -1);
  }

}
