/*
 * Copyright (C) 2007 SQL Explorer Development Team
 * http://sourceforge.net/projects/eclipsesql
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
package com.safi.workshop.sqlexplorer.parsers;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractQueryParser implements QueryParser {
  private final static String PATT_PARAM = ":[a-zA-Z_][a-zA-z_0-9]+";
  // protected int numParams = 0;
  // List of named parameters; note that there can be duplicates, but that
  // they are scoped according to their position. The list is expected to
  // be in the order in which they appeared in the original query
  private LinkedHashSet<NamedParameter> parameters = new LinkedHashSet<NamedParameter>();
  private ExecutionContext context = new ExecutionContext();

  public void addParameter(NamedParameter parameter) {
    parameters.add(parameter);
  }

  public LinkedHashSet<NamedParameter> getParameters() {
    return parameters;
  }

  protected Set<QueryParameter> parseArgs(String sql) throws ParserException {
    Pattern p = Pattern.compile(PATT_PARAM);
    Matcher m = p.matcher(sql);
    Set<QueryParameter> parms = new LinkedHashSet<QueryParameter>();
    while (m.find()) {
      parms.add(new QueryParameter(m.group(), QueryParameter.DataType.TEXT));
    }
    return parms;
  }

  public ExecutionContext getContext() {
    return this.context;
  }

  private QueryParameter parseQueryParam(String contents, int lineNo) throws ParserException {
    StringBuffer paramName = new StringBuffer();
    QueryParameter.DataType type = QueryParameter.DataType.TEXT;
    char c;
    int pos = 0;
    while (pos < contents.length() && Character.isLetterOrDigit(c = contents.charAt(pos))) {
      paramName.append(c);
      pos++;
    }
    if (paramName.length() == 0)
      throw new ParserException("Query Parameter Name is required and must not contain spaces.",
          lineNo, pos);

    pos = contents.indexOf('[', pos);
    if (pos >= 0) {
      int endPos = contents.indexOf(']', pos);
      if (endPos < 0)
        throw new ParserException("Missing ']' terminator", lineNo, pos);
      String typeStr = contents.substring(pos + 1, endPos);
      type = QueryParameter.DataType.valueOf(typeStr.toUpperCase());
    }

    return new QueryParameter(paramName.toString(), type);
  }

}
