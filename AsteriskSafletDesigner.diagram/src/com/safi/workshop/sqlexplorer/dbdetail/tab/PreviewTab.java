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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dataset.DataSet;
import com.safi.workshop.sqlexplorer.dbproduct.SQLConnection;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.INode;
import com.safi.workshop.sqlexplorer.dbstructure.nodes.TableNode;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

/**
 * @author Davy Vanherbergen
 * 
 */
public class PreviewTab extends AbstractDataSetTab {

  @Override
  public String getLabelText() {
    return Messages.getString("DatabaseDetailView.Tab.Preview");
  }

  @Override
  public DataSet getDataSet() throws Exception {

    INode node = getNode();

    if (node == null) {
      return null;
    }

    if (node instanceof TableNode) {
      TableNode tableNode = (TableNode) node;

      int maxResults = AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().getInt(
          IConstants.PRE_ROW_COUNT);
      if (maxResults == 0) {
        maxResults = 50;
      }

      SQLConnection connection = null;
      Statement statement = null;
      ResultSet resultSet = null;
      DataSet dataSet = null;
      try {
        connection = tableNode.getSession().grabConnection();
        statement = connection.createStatement();
        statement.setMaxRows(maxResults);
        statement.execute("select * from " + tableNode.getQualifiedName());
        resultSet = statement.getResultSet();

        dataSet = new DataSet(resultSet, null);
      } finally {
        if (resultSet != null)
          try {
            resultSet.close();
          } catch (SQLException e) {
            SQLExplorerPlugin.error("Error closing result set", e);
          }
        if (statement != null)
          try {
            statement.close();
          } catch (SQLException e) {
            SQLExplorerPlugin.error("Error closing statement", e);
          }
        if (connection != null)
          getNode().getSession().releaseConnection(connection);
      }
      return dataSet;
    }

    return null;
  }

  @Override
  public String getStatusMessage() {
    return Messages.getString("DatabaseDetailView.Tab.Preview.status") + " "
        + getNode().getQualifiedName();
  }
}
