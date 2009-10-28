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

import net.sourceforge.squirrel_sql.fw.sql.dbobj.BestRowIdentifier;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dataset.DataSet;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.INode;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.TableNode;

/**
 * @author Davy Vanherbergen
 * 
 */
public class RowIdsTab extends AbstractDataSetTab {

  private static final String[] COLUMN_LABELS = { "DatabaseDetailView.Tab.RowIds.Col.Scope",
      "DatabaseDetailView.Tab.RowIds.Col.ColumnName", "DatabaseDetailView.Tab.RowIds.Col.DataType",
      "DatabaseDetailView.Tab.RowIds.Col.TypeName", "DatabaseDetailView.Tab.RowIds.Col.ColumnSize",
      "DatabaseDetailView.Tab.RowIds.Col.DecimalDigits",
      "DatabaseDetailView.Tab.RowIds.Col.PseudoColumn" };

  @Override
  public String getLabelText() {
    return Messages.getString("DatabaseDetailView.Tab.RowIds");
  }

  @Override
  public DataSet getDataSet() throws Exception {

    INode node = getNode();

    if (node == null) {
      return null;
    }

    if (node instanceof TableNode) {
      TableNode tableNode = (TableNode) node;

      BestRowIdentifier[] rowIds = node.getSession().getMetaData().getBestRowIdentifier(
          tableNode.getTableInfo());
      Comparable[][] data = new Comparable[rowIds.length][];
      int index = 0;
      for (BestRowIdentifier rowId : rowIds) {
        Comparable[] row = new Comparable[COLUMN_LABELS.length];
        data[index++] = row;

        int i = 0;
        row[i++] = rowId.getScope();
        row[i++] = rowId.getColumnName();
        row[i++] = rowId.getSQLDataType();
        row[i++] = rowId.getTypeName();
        row[i++] = rowId.getPrecision();
        row[i++] = rowId.getScale();
        row[i++] = rowId.getPseudoColumn();
        if (i != COLUMN_LABELS.length)
          throw new RuntimeException("Internal Error: RowIdsTab: wrong number of columns");
      }
      DataSet dataSet = new DataSet(COLUMN_LABELS, data);
      return dataSet;
    }

    return null;
  }

  @Override
  public String getStatusMessage() {
    return Messages.getString("DatabaseDetailView.Tab.RowIds.status") + " "
        + getNode().getQualifiedName();
  }
}
