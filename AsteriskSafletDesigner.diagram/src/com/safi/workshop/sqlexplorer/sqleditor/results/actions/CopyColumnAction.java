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

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.sqleditor.results.AbstractResultsTable.SelectionType;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

/**
 * Copy the value of the selected cell in a datasettable to the clipboard.
 * 
 * @author Davy Vanherbergen
 */
public class CopyColumnAction extends AbstractCopyAction {

  public CopyColumnAction() {
    super(Messages.getString("DataSetTable.Actions.CopyColumn"), ImageUtil
        .getDescriptor("Images.ExportToClipBoardIcon"));
  }

  @Override
  protected SelectionType getSelectionType() {
    return SelectionType.COLUMN;
  }

}
