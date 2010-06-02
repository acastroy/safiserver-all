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

import java.util.List;

import net.sourceforge.squirrel_sql.fw.sql.IndexInfo;

import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dataset.DataSet;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.INode;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.TableNode;

/**
 * @author Davy Vanherbergen
 * 
 */
public class IndexesTab extends AbstractDataSetTab {

  private static final String COLUMN_LABELS[] = {
      Messages.getString("DatabaseDetailView.Tab.Indexes.Col.IsNonUnique"),
      Messages.getString("DatabaseDetailView.Tab.Indexes.Col.IndexQualifier"),
      Messages.getString("DatabaseDetailView.Tab.Indexes.Col.SimpleName"),
      Messages.getString("DatabaseDetailView.Tab.Indexes.Col.IndexType"),
      Messages.getString("DatabaseDetailView.Tab.Indexes.Col.OrdinalPosition"),
      Messages.getString("DatabaseDetailView.Tab.Indexes.Col.ColumnName"),
      Messages.getString("DatabaseDetailView.Tab.Indexes.Col.SortOrder"),
      Messages.getString("DatabaseDetailView.Tab.Indexes.Col.Cardinality"),
      Messages.getString("DatabaseDetailView.Tab.Indexes.Col.Pages"),
      Messages.getString("DatabaseDetailView.Tab.Indexes.Col.FilterCondition") };

  @Override
  public String getLabelText() {
    return Messages.getString("DatabaseDetailView.Tab.Indexes");
  }

  @Override
  public DataSet getDataSet() throws Exception {

    INode node = getNode();

    if (node == null) {
      return null;
    }

    if (node instanceof TableNode) {
      TableNode tableNode = (TableNode) node;

      List<IndexInfo> indexes = node.getSession().getMetaData().getIndexInfo(
          tableNode.getTableInfo());
      Comparable[][] dataRows = new Comparable[indexes.size()][];
      int index = 0;
      for (IndexInfo col : indexes) {
        Comparable[] row = new Comparable[COLUMN_LABELS.length];
        dataRows[index++] = row;

        int i = 0;
        row[i++] = col.isNonUnique();
        row[i++] = col.getIndexQualifier();
        row[i++] = col.getSimpleName();
        row[i++] = col.getIndexType();
        row[i++] = col.getOrdinalPosition();
        row[i++] = col.getColumnName();
        row[i++] = col.getSortOrder();
        row[i++] = col.getCardinality();
        row[i++] = col.getPages();
        row[i++] = col.getFilterCondition();
        if (i != COLUMN_LABELS.length)
          throw new RuntimeException("Internal error: ColumnInfoTab: wrong number of columns");
      }
      DataSet dataSet = new DataSet(COLUMN_LABELS, dataRows);

      return dataSet;
    }

    return null;
  }

  @Override
  public String getStatusMessage() {
    return Messages.getString("DatabaseDetailView.Tab.Indexes.status") + " "
        + getNode().getQualifiedName();
  }
}
