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
package com.safi.workshop.sqlexplorer.sqleditor.results.actions;

import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.sqleditor.results.CellRange;
import com.safi.workshop.sqlexplorer.sqleditor.results.ResultsTableAction;
import com.safi.workshop.sqlexplorer.sqleditor.results.AbstractResultsTable.SelectionType;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * Copy the column name of the selected column to the clipboard.
 * 
 * @author Davy Vanherbergen
 */
public class CopyColumnNameAction extends ResultsTableAction {

  public CopyColumnNameAction() {
    super(Messages.getString("DataSetTable.Actions.CopyColumnName"), ImageUtil
        .getDescriptor("Images.ExportToClipBoardIcon"));
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

      CellRange cells = getResultsTable().getSelection(SelectionType.COLUMN);
      if (cells == null)
        return;
      clipBoard.setContents(new Object[] { cells.getColumn(0).getCaption() },
          new Transfer[] { textTransfer });
    } catch (Exception e) {
      SQLExplorerPlugin.error("Error exporting cell to clipboard ", e);
    }
  }

  /**
   * Only show action if something is selected
   * 
   * @see com.safi.workshop.sqlexplorer.sqleditor.results.ResultsTableAction#isAvailable()
   */
  @Override
  public boolean isAvailable() {
    return getResultsTable().getSelection(SelectionType.COLUMN) != null;
  }

}
