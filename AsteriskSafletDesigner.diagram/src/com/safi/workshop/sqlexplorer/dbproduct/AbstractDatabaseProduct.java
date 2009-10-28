package com.safi.workshop.sqlexplorer.dbproduct;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.lang.NotImplementedException;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;

import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.db.SQLDataType;
import com.safi.db.VariableType;
import com.safi.workshop.sqlexplorer.parsers.NamedParameter;
import com.safi.workshop.sqlexplorer.parsers.Query;
import com.safi.workshop.sqlexplorer.parsers.QueryParameter;
import com.safi.workshop.sqlexplorer.parsers.QueryParameterDialog;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInput;

public abstract class AbstractDatabaseProduct implements DatabaseProduct {

  private final static String PATT_PARAM = ":[a-zA-Z_][a-zA-z_0-9]+";

  public ExecutionResults executeQuery(SQLConnection connection, Query query, int maxRows)
      throws SQLException {
    Statement stmt = null;
    try {
      CharSequence querySql = query.getQuerySql();
      LinkedList<NamedParameter> params = null;

      LinkedHashSet<QueryParameter> queryParams = null;

      // Apply any named parameters
      if (query.getQueryType() != Query.QueryType.DDL) {
        Map<String, NamedParameter> map = query.getNamedParameters();
        if (map != null && !map.isEmpty()) {
          StringBuffer sb = new StringBuffer(querySql);
          params = locateNamedParameters(sb, map);
          querySql = sb;
        }
      }

      queryParams = query.getQueryParameters();

      /*
       * Create the statement. Note that we only create a CallableStatement if we have
       * parameters; this is because some databases (MySQL) require that prepareCall is
       * only used for stored code. CallableStatements are only needed for output
       * parameters so because we cannot reliably detect what the query is
       * (DDL/DML/SELECT/CODE/etc) unless there is a specialised parser, we rely on
       * whether the user has given any named parameters.
       * 
       * Similarly, use Statement when we're just doing DDL - eg Oracle will not create
       * triggers when using PreparedStatement when it contains references to :new or
       * :old.
       */
      boolean hasResults = false;
      if (query.getQueryType() == Query.QueryType.DDL) {
        stmt = connection.getConnection().createStatement();
        hasResults = stmt.execute(querySql.toString());

      } else if (params != null) {
        CallableStatement cstmt = connection.getConnection().prepareCall(querySql.toString());
        stmt = cstmt;
        int columnIndex = 1;
        for (NamedParameter param : params)
          configureStatement((CallableStatement) stmt, param, columnIndex++);
        hasResults = cstmt.execute();

      } else {
        String qry = querySql.toString();
        boolean hasParams = queryParams != null && !queryParams.isEmpty();
        if (hasParams) {
          qry = makeValidPS(qry);
        }
        PreparedStatement pstmt = connection.getConnection().prepareStatement(qry);
        stmt = pstmt;

        if (queryParams != null) {
          int count = 0;
          for (QueryParameter p : queryParams) {
            if (!setParam(connection, pstmt, p, ++count)) {
              return null;
            }
          }
        }
        // Note we only set maxrows if we know what the query type is (and that it's a
        // SELECT)
        // This is important for MSSQL DDL statements which fail if maxrows is set, and
        // makes
        // no sense for non-select anyway.
        if (query.getQueryType() == Query.QueryType.SELECT)
          try {
            stmt.setMaxRows(maxRows);
          } catch (SQLException e) {
            // Nothing
          }
        // if (!hasParams)
        hasResults = pstmt.execute();
      }

      return new ExecutionResultImpl(this, stmt, hasResults, params, maxRows);

    } catch (SQLException e) {
      try {
        if (stmt != null)
          stmt.close();
      } catch (SQLException e2) {
        // Nothing
      }
      throw e;
    }
  }

  private String makeValidPS(String sql) {
    // Pattern p = Pattern.compile(PATT_PARAM);
    // Matcher m = p.matcher(sql);
    String copy = sql;
    // while (m.find()) {
    // copy.replace(m.group(), "?");
    // }
    copy = copy.replaceAll(PATT_PARAM, "?");
    // TODO Auto-generated method stub
    return copy;
  }

  private boolean setParam(SQLConnection connection, PreparedStatement pstmt,
      final QueryParameter p, int idx) throws SQLException {
    String pname = p.getName();
    // connecption.getUser().get
    final Display display = PlatformUI.getWorkbench().getDisplay();
    final IWorkbenchPage[] pa = new IWorkbenchPage[1];
    display.syncExec(new Runnable() {
      @Override
      public void run() {
        // TODO Auto-generated method stub
        pa[0] = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
      }
    });
    // IWorkbenchPage activePage =
    // UIPlugin.getDefault().getWorkbench().getActiveWorkbenchWindow().getActivePage();
    IWorkbenchPage activePage = pa[0];
    com.safi.db.QueryParameter param = null;
    if (activePage != null) {
      IEditorPart editor = activePage.getActiveEditor();
      if (editor instanceof SQLEditor) {
        SQLEditorInput input = (SQLEditorInput) ((SQLEditor) editor).getEditorInput();
        com.safi.db.Query qry = input.getQuery();
        if (qry != null) {
          param = qry.getParameter(pname);
        }
      }
    }

    final String defaultValue = QueryParameter.getDefaultValue(p.getType());
    int res = -1;
    final com.safi.db.QueryParameter finalParam = param;
    final Object[] ra = new Object[3];
    display.syncExec(new Runnable() {
      public void run() {
        QueryParameterDialog dialog = new QueryParameterDialog(display.getActiveShell());
        if (finalParam != null)
          // dialog.setParameterInfo(finalParam, type)
          dialog.setParameterInfo(p.getName(), finalParam == null ? SQLDataType.TEXT : finalParam
              .getDataType());
        // InputDialog dialog = new InputDialog(display.getActiveShell(),
        // "Query Parameter",
        // "Enter a value for parameter " + p.getName() + "[" + p.getType() + "]",
        // defaultValue,
        // null);
        // TODO Auto-generated method stub
        ra[0] = dialog.open();
        ra[1] = dialog.getValue();
        ra[2] = dialog.getSelectedDataType();
      }
    });
    res = (Integer) ra[0];

    if (res != Window.OK) {
      return false;
    }

    Object value = null;
    Object result = ra[1];
    try {
      switch ((SQLDataType) ra[2]) {
        case ARRAY:
          throw new NotImplementedException("Array parameters are not yet supported");
        case BLOB:
          throw new NotImplementedException("BLOB parameters are not yet supported");
        case CLOB:
          throw new NotImplementedException("CLOB parameters are not yet supported");
        case DATE:
          pstmt.setDate(idx, new java.sql.Date(((Date) VariableTranslator.translateValue(
              VariableType.DATE, result)).getTime()));
          break;
        case DATE_TIME:
          pstmt.setDate(idx, new java.sql.Date(((Date) VariableTranslator.translateValue(
              VariableType.DATETIME, result)).getTime()));
          break;
        case DOUBLE:
          pstmt.setDouble(idx, (Double) VariableTranslator.translateValue(VariableType.DECIMAL,
              result));
          break;
        case INTEGER:
          pstmt.setDouble(idx, ((Number) VariableTranslator.translateValue(VariableType.INTEGER,
              result)).doubleValue());
          break;
        case LONG:
          pstmt
              .setLong(idx, (Long) VariableTranslator.translateValue(VariableType.INTEGER, result));
          break;
        case TEXT:
          pstmt.setString(idx, (String) VariableTranslator
              .translateValue(VariableType.TEXT, result));
          break;
        case TIME:
          pstmt.setTime(idx, new java.sql.Time(((Date) VariableTranslator.translateValue(
              VariableType.TIME, result)).getTime()));
          break;
        case BOOLEAN:
          pstmt.setBoolean(idx, (Boolean) VariableTranslator.translateValue(VariableType.BOOLEAN,
              result));
        default:
          pstmt.setObject(idx, result);
      }
      // value = QueryParameter.getValueFromString(p.getType(), enteredValue);
    } catch (Exception e) {
      e.printStackTrace();
      throw new SQLException("Couldn't parse " + p.getType() + " from " + result);
    }
    return true;

    /*
     * switch (p.getType()) { case ARRAY: pstmt.setArray(i, (Array) value); return true;
     * case BLOB: pstmt.setBlob(i, (Blob) value); return true; case CLOB: pstmt.setClob(i,
     * (Clob) value); return true; case DATE: pstmt.setDate(i, (java.sql.Date) value);
     * break; case DATETIME: pstmt.setDate(i, (java.sql.Date) value); return true; case
     * DOUBLE: pstmt.setDouble(i, (Double) value); return true; case INTEGER:
     * pstmt.setInt(i, (Integer) value); return true; case LONG: pstmt.setLong(i, (Long)
     * value); return true; case TEXT: pstmt.setString(i, (String) value); return true;
     * case TIME: pstmt.setTimestamp(i, (Timestamp) value); return true; } return false;
     */

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.workshop.sqlexplorer.dbproduct.DatabaseProduct#describeConnection(java.sql
   * .Connection)
   */
  public String describeConnection(Connection connection) throws SQLException {
    return null;
  }

  /**
   * Scans the StringBuffer looking for named parameters (in the form ":paramname"), and
   * looking up the parameter in map. It returns a list of those parameters; note that the
   * list will contain duplicates if the named parameter is referenced more than once
   * 
   * @param sb
   * @param map
   * @return
   */
  protected LinkedList<NamedParameter> locateNamedParameters(StringBuffer sb,
      Map<String, NamedParameter> map) throws SQLException {
    LinkedList<NamedParameter> results = new LinkedList<NamedParameter>();

    // The quote character when we're in the middle of a string
    char inQuote = 0;

    // The string to look for which terminates a comment (if we're currenbtly parsing
    // one);
    // null if not currently parsing a comment
    String inComment = null;

    // Where the identifier started, relative to the buffer (-1 means no identifier yet)
    int idStart = -1;

    for (int i = 0; i < sb.length(); i++) {
      char c = sb.charAt(i);
      char nextC = (i < sb.length() - 1) ? sb.charAt(i + 1) : 0;

      // If we're in an identifier
      if (idStart != -1) {
        // Still an identifier?
        if (Character.isJavaIdentifierPart(c))
          continue;

        // Find the parameter
        String name = sb.substring(idStart + 1, i);
        NamedParameter param = map.get(name);

        // Ignore null parameters because they may be a valid syntax on the server
        if (param != null) {
          results.add(param);
          sb.delete(idStart + 1, i);
          sb.setCharAt(idStart, '?');
        }

        // Next!
        idStart = -1;
        continue;
      }

      // Already inside a string? Check for the end of the string
      if (inQuote != 0) {
        if (c == '\'' || c == '\"') {
          // Double just escapes, it does not terminate the string
          if (nextC != c)
            inQuote = 0;
        }
        continue;
      }

      // Already in a comment
      if (inComment != null) {
        // If inComment is empty then we're in a single-line comment; check for EOL
        if (inComment.length() == 0) {
          if (c == '\n')
            inComment = null;
          continue;
        }

        // Otherwise inComment is the string which terminates the comment
        if (c == inComment.charAt(0) && nextC == inComment.charAt(1)) {
          inComment = null;
          continue;
        }
      }

      // Starting a single-line comment?
      if (c == '-' && nextC == '-') {
        inComment = "";
        continue;
      }

      // Starting a multi-line comment?
      if (c == '/' && nextC == '*') {
        inComment = "*/";
        continue;
      }

      // Starting a string?
      if (c == '\'' || c == '\"') {
        inQuote = c;
        continue;
      }

      // Finally - is it a named parameter?
      if (c == ':' && Character.isJavaIdentifierPart(nextC)) {
        idStart = i;
      }
    }

    // Check for a parameter which exists at the very end of the string
    if (idStart > -1) {
      String name = sb.substring(idStart + 1);
      NamedParameter param = map.get(name);
      if (param == null)
        throw new SQLException("Unknown named parameter called " + name);
      results.add(param);
      sb.delete(idStart + 1, sb.length());
      sb.setCharAt(idStart, '?');
    }
    if (results.isEmpty())
      return null;

    return results;
  }

  /**
   * Configures the statement with a given parameter at a given ordinal index
   * 
   * @param stmt
   * @param param
   * @param columnIndex
   * @throws SQLException
   */
  protected void configureStatement(CallableStatement stmt, NamedParameter param, int columnIndex)
      throws SQLException {
    param.configureStatement(stmt, columnIndex);
  }

  /**
   * Override this method if the underlying database supports parameters returning
   * resultsets (ie cursors)
   * 
   * @param stmt
   * @param param
   * @param columnIndex
   * @return
   * @throws SQLException
   */
  public ResultSet getResultSet(CallableStatement stmt, NamedParameter param, int columnIndex)
      throws SQLException {
    return null;
  }
}
