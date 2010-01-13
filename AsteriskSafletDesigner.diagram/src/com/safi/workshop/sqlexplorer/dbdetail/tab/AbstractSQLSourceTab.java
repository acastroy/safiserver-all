/**
 * 
 */
package com.safi.workshop.sqlexplorer.dbdetail.tab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.dbproduct.SQLConnection;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

/**
 * @author k709335
 * 
 */
public abstract class AbstractSQLSourceTab extends AbstractSourceTab {

  public abstract String getSQL();

  public abstract Object[] getSQLParameters();

  @Override
  public String getSource() {

    String source = null;

    SQLConnection connection = null;
    ResultSet rs = null;
    Statement stmt = null;
    PreparedStatement pStmt = null;

    int timeOut = AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().getInt(
        IConstants.INTERACTIVE_QUERY_TIMEOUT);

    try {
      connection = getNode().getSession().grabConnection();
      Object[] params = getSQLParameters();
      if (params == null || params.length == 0) {

        // use normal statement
        stmt = connection.createStatement();
        stmt.setQueryTimeout(timeOut);
        rs = stmt.executeQuery(getSQL());

      } else {

        // use prepared statement
        pStmt = connection.prepareStatement(getSQL());
        pStmt.setQueryTimeout(timeOut);

        for (int i = 0; i < params.length; i++) {

          if (params[i] instanceof String) {
            pStmt.setString(i + 1, (String) params[i]);
          } else if (params[i] instanceof Integer) {
            pStmt.setInt(i + 1, ((Integer) params[i]).intValue());
          } else if (params[i] instanceof String) {
            pStmt.setLong(i + 1, ((Long) params[i]).longValue());
          }
        }

        rs = pStmt.executeQuery();
      }

      source = "";
      while (rs.next()) {

        source = source + rs.getString(1);
      }

      rs.close();

    } catch (Exception e) {

      SQLExplorerPlugin.error("Couldn't load source for: " + getNode().getName(), e);

    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (SQLException e) {
          SQLExplorerPlugin.error("Error closing result set", e);
        }
      if (stmt != null)
        try {
          stmt.close();
        } catch (SQLException e) {
          SQLExplorerPlugin.error("Error closing statement", e);
        }
      if (pStmt != null)
        try {
          pStmt.close();
        } catch (SQLException e) {
          SQLExplorerPlugin.error("Error closing statement", e);
        }
      if (connection != null)
        getNode().getSession().releaseConnection(connection);
    }
    return source;
  }

}
