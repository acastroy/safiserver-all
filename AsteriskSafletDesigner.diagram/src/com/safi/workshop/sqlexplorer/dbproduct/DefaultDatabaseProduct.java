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
package com.safi.workshop.sqlexplorer.dbproduct;

import java.net.MalformedURLException;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import net.sourceforge.squirrel_sql.fw.sql.SQLDriverClassLoader;

import com.safi.workshop.sqlexplorer.parsers.BasicQueryParser;
import com.safi.workshop.sqlexplorer.parsers.Query;
import com.safi.workshop.sqlexplorer.parsers.QueryParser;
import com.safi.workshop.sqlexplorer.plugin.editors.Message;

public class DefaultDatabaseProduct extends AbstractDatabaseProduct {

  /*
   * (non-JavaDoc)
   * 
   * @see
   * com.safi.workshop.sqlexplorer.dbproduct.DatabaseProduct#getDriver(com.safi.workshop
   * .sqlexplorer.fw.sql.ManagedDriver)
   */
  public Driver getDriver(ManagedDriver driver) throws ClassNotFoundException {
    try {
      ClassLoader loader = new SQLDriverClassLoader(getClass().getClassLoader(), driver);
      Class driverCls = loader.loadClass(driver.getDriverClassName());
      return (Driver) driverCls.newInstance();
    } catch (UnsupportedClassVersionError e) {
      throw new ClassNotFoundException(e.getMessage(), e);
    } catch (MalformedURLException e) {
      throw new ClassNotFoundException(e.getMessage(), e);
    } catch (InstantiationException e) {
      throw new ClassNotFoundException(e.getMessage(), e);
    } catch (IllegalAccessException e) {
      throw new ClassNotFoundException(e.getMessage(), e);
    }
  }

  public Collection<Message> getErrorMessages(SQLConnection connection, SQLException e,
      int lineNoOffset) throws SQLException {
    LinkedList list = new LinkedList();
    String message = e.getMessage();
    int offset = 1;
    if (message != null) {
      int pos = message.indexOf(" at line ");
      if (pos > 0) {
        try {
          offset = Integer.parseInt(message.substring(pos + " at line ".length()));
        } catch (Exception ignored) {
        }
      }
    }
    list.add(new Message(Message.Status.FAILURE, lineNoOffset + offset, 0, e.getMessage()));
    return list;
  }

  public Collection<Message> getServerMessages(SQLConnection connection) throws SQLException {
    return null;
  }

  public QueryParser getQueryParser(String sql, int initialLineNo) {
    return new BasicQueryParser(sql);
  }

  public Collection<Message> getErrorMessages(SQLConnection connection, Query query)
      throws SQLException {
    return null;
  }

}
