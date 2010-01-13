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
package com.safi.workshop.sqlexplorer.dbdetail.tab;

import java.sql.SQLException;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dataset.DataSet;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.TableNode;

/**
 * @author Davy Vanherbergen
 * 
 */
public class RowCountTab extends AbstractDataSetTab {

  @Override
  public String getLabelText() {
    return Messages.getString("DatabaseDetailView.Tab.RowCount");
  }

  @Override
  public DataSet getDataSet() throws ExplorerException {

    String nodeName = getNode().toString();

    if (getNode() instanceof TableNode) {
      TableNode tableNode = (TableNode) getNode();
      nodeName = tableNode.getQualifiedName();
    }

    try {
      return new DataSet(null, "select count(*) from " + nodeName, null, getNode().getSession());
    } catch (SQLException e) {
      throw new ExplorerException(e);
    }
  }

  @Override
  public String getStatusMessage() {
    return Messages.getString("DatabaseDetailView.Tab.RowCount.status") + " "
        + getNode().getQualifiedName();
  }
}
