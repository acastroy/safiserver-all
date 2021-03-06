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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.dom4j.Element;
import org.eclipse.core.runtime.Preferences;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.connections.SessionEstablishedListener;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

/**
 * Represents a username and password combo used to connect to an alias; contains a list
 * of all connections made
 * 
 * @author John Spackman
 */
public class User implements Comparable<User>, SessionEstablishedListener {

  /* package */static final String USER = "user";
  /* package */static final String USER_NAME = "user-name";
  /* package */static final String PASSWORD = "password";
  private static final String AUTO_COMMIT = "auto-commit";
  private static final String COMMIT_ON_CLOSE = "commit-on-close";

  // Maximum number of connections to keep in the pool
  public static final int MAX_POOL_SIZE = 3;

  // The Alias we belong to
  private Alias alias;

  // Username and password to login as
  private String userName;
  private String password;

  // Pool of available connections
  private List<SQLConnection> unused = Collections
      .synchronizedList(new LinkedList<SQLConnection>());

  // List of connections in use
  private List<SQLConnection> allocated = Collections
      .synchronizedList(new LinkedList<SQLConnection>());

  // Special session for MetaData
  private MetaDataSession metaDataSession;

  // List of Sessions (exluding meta data session)
  private List<Session> sessions = Collections.synchronizedList(new LinkedList<Session>());

  // List of requests for a new session
  private LinkedList<SessionEstablishedListener> newSessionsQueue = new LinkedList<SessionEstablishedListener>();

  // Auto commit behaviour
  private boolean autoCommit;
  private boolean commitOnClose;
  private boolean offlineMode;
  private boolean prompted;

  /**
   * Constructor
   * 
   * @param userName
   * @param password
   */
  public User(String userName, String password) {
    super();
    this.userName = userName;
    this.password = password;

    // Get default autocommit behaviour
    autoCommit = AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().getBoolean(
        IConstants.AUTO_COMMIT);
    commitOnClose = AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences().getBoolean(
        IConstants.COMMIT_ON_CLOSE);
  }

  /**
   * Constructs a User, from a definition previously recorded by describeAsXml()
   * 
   * @param root
   */
  public User(Element root) {
    super();
    this.userName = root.elementText(USER_NAME);
    this.password = root.elementText(PASSWORD);
    autoCommit = getBoolean(root.attributeValue(AUTO_COMMIT), true);
    commitOnClose = getBoolean(root.attributeValue(COMMIT_ON_CLOSE), true);
  }

  // /**
  // * Describes the User in XML
  // *
  // * @return
  // */
  // public Element describeAsXml() {
  // Element root = new DefaultElement(USER);
  // root.addElement(USER_NAME).setText(userName);
  // root.addElement(PASSWORD).setText(password);
  // root.addAttribute(AUTO_COMMIT, Boolean.toString(autoCommit));
  // root.addAttribute(COMMIT_ON_CLOSE, Boolean.toString(commitOnClose));
  // return root;
  // }

  /**
   * Creates a duplicate of this User
   * 
   * @param alias
   * @return
   */
  public User createCopy() {
    User copy = new User(userName, password);
    return copy;
  }

  /**
   * Merges the definition of the User "that" - IE takes the password, auto-commit
   * behaviour, etc
   * 
   * @param that
   */
  public void mergeWith(User that) {
    if (this == that)
      return;
    password = that.getPassword();
    autoCommit = that.isAutoCommit();
    commitOnClose = that.isCommitOnClose();
    for (SQLConnection connection : that.unused) {
      connection.setUser(this);
      if (unused.size() < MAX_POOL_SIZE)
        unused.add(connection);
      else
        try {
          connection.close();
        } catch (SQLException e) {
          SQLExplorerPlugin.error("Cannot close connection", e);
        }
    }
    for (SQLConnection connection : that.allocated) {
      connection.setUser(this);
      allocated.add(connection);
    }
    for (Session session : that.sessions) {
      session.setUser(this);
      sessions.add(session);
    }
    metaDataSession = that.metaDataSession;

    // Make "that" unusable
    that.unused = null;
    that.allocated = null;
    that.sessions = null;
    that.metaDataSession = null;
    that.password = null;

    SQLExplorerPlugin.getDefault().getAliasManager().modelChanged();
  }

  /**
   * Queues the listener to receive a session as soon as possible (FIFO queue); only one
   * attempt to establish a session at a time is made, and if one fails then the rest
   * fail. This is typically important for startup when restoring lots of connections and
   * we want to avoid the user getting presented with more than one error dialog for the
   * same alias/user.
   * 
   * @param listener
   * @param requirePassword
   */
  public synchronized void queueForNewSession(SessionEstablishedListener listener) {
    newSessionsQueue.add(listener);
    if (newSessionsQueue.size() == 1)
      ConnectionJob.createSession(alias, this, this, false);
  }

  /**
   * Callback when a session cannot be established; notifies all listeners and then clears
   * down the list on the basis that it was a terminal login error
   */
  public synchronized void cannotEstablishSession(User user) {
    for (SessionEstablishedListener listener : newSessionsQueue)
      listener.cannotEstablishSession(this);
    newSessionsQueue.clear();
  }

  /**
   * Callback when a session has been established; notifies the next listener in the queue
   * and then starts to establish a new session
   */
  public synchronized void sessionEstablished(Session session) {
    SessionEstablishedListener listener = newSessionsQueue.removeFirst();
    listener.sessionEstablished(session);
    if (!newSessionsQueue.isEmpty())
      ConnectionJob.createSession(alias, this, this, false);
  }

  /**
   * Creates a new session; NOTE, this is a blocking call, use ConnectionJob for
   * asychronous connections
   * 
   * @return
   */
  public Session createSession() throws SQLException {
    Session session = new Session(this);
    sessions.add(session);
    SQLExplorerPlugin.getDefault().getAliasManager().modelChanged();
    return session;
  }

  /**
   * Returns the special session for accessing meta data
   * 
   * @return
   * @throws SQLException
   */
  public MetaDataSession getMetaDataSession() {
    if (metaDataSession == null && !offlineMode)
      try {
        metaDataSession = new MetaDataSession(this);
      } catch (SQLException e) {
        SQLExplorerPlugin.error(e);
      }
    return metaDataSession;
  }

  /**
   * Releases a session
   * 
   * @param session
   */
  /* package */void releaseSession(Session session) {
    sessions.remove(session);
    SQLExplorerPlugin.getDefault().getAliasManager().modelChanged();
  }

  /**
   * Returns a list of sessions
   * 
   * @return
   */
  public List<Session> getSessions() {
    return sessions;
  }

  /**
   * Returns true if the session belongs to this User
   * 
   * @param session
   * @return
   */
  public boolean contains(Session session) {
    return sessions.contains(session);
  }

  /**
   * Closes all connections; note that ConnectionListeners are NOT invoked
   */
  /* package */void closeAllSessions() {
    List<Session> copy = new ArrayList<Session>(sessions);
    for (Session session : copy) {
      try {
        session.close();
      } catch (Exception e) {
        SQLExplorerPlugin.error(e);
      }

    }
    if (metaDataSession != null) {
      try {
        metaDataSession.close();
      } catch (Exception e) {
        SQLExplorerPlugin.error(e);
      }

      metaDataSession = null;
    }
  }

  /**
   * Retrieves a new connection, either from the pool or by allocating a new one
   * 
   * @return
   * @throws ExplorerException
   */
  public synchronized SQLConnection getConnection() throws SQLException {
    SQLConnection connection = null;
    if (!unused.isEmpty())
      connection = unused.remove(0);// unused.removeFirst();
    else if (!offlineMode) {
      connection = createNewConnection();
    }

    if (connection != null) {
      allocated.add(connection);
    }

    return connection;
  }

  /**
   * Releases a connection; the connection will be returned to the pool, unless the pool
   * has grown too large (in which case the connection is closed). Note that the
   * connection may not be in the "allocated" list if it is a hidden connection (see
   * hideConnection())
   * 
   * @param connection
   * @throws ExplorerException
   */
  public void releaseConnection(SQLConnection connection) throws SQLException {
    if (connection.getConnection() == null || connection.getConnection().isClosed()) {
      disposeConnection(connection);
      return;
    }

    boolean forPool = allocated.remove(connection);
    AsteriskDiagramEditorPlugin pluginInstance = AsteriskDiagramEditorPlugin.getDefault();
    if (pluginInstance == null)
      return;
    Preferences pluginPreferences = pluginInstance.getPluginPreferences();
    boolean commitOnClose = true;
    if (pluginPreferences != null)
      commitOnClose = pluginPreferences.getBoolean(IConstants.COMMIT_ON_CLOSE);

    if (!connection.getAutoCommit()) {
      if (commitOnClose)
        connection.commit();
      else
        connection.rollback();
    }

    // Keep the pool small
    if (forPool && unused.size() < MAX_POOL_SIZE) {
      unused.add(connection);
      return;
    }

    // Close unwanted connections
    connection.close();
  }

  /**
   * Disposes of the connection without returning it to the pool; usually called when the
   * connection has been closed by the server
   * 
   * @param connection
   */
  public void disposeConnection(SQLConnection connection) {
    allocated.remove(connection);
    try {
      connection.close();
    } catch (SQLException e) {
      // Nothing
    }
  }

  /**
   * Returns the connection from the pool, assuming the connection is currently in the
   * pool
   * 
   * @param connection
   * @return true if the connection was in the and has been removed
   */
  public synchronized boolean releaseFromPool(SQLConnection connection) {
    try {
      connection.close();
    } catch (SQLException e) {
      SQLExplorerPlugin.error(e);
    }
    if (unused.remove(connection)) {
      SQLExplorerPlugin.getDefault().getAliasManager().modelChanged();
      return true;
    }
    return false;
  }

  /**
   * Returns true if the connection is part of the pool of available connections
   * 
   * @param connection
   * @return
   */
  public boolean isInPool(SQLConnection connection) {
    return unused.contains(connection);
  }

  /**
   * Returns true if the User is in use (ie has any connections in use or active sessions)
   * 
   * @return
   */
  public boolean isInUse() {
    return !allocated.isEmpty() || !sessions.isEmpty();
  }

  /**
   * Returns all connections
   * 
   * @return
   */
  public List<SQLConnection> getConnections() {
    LinkedList<SQLConnection> result = new LinkedList<SQLConnection>();
    result.addAll(allocated);
    result.addAll(unused);
    return result;
  }

  /**
   * Returns true if the user has successfully authenticated at some point; IE, will
   * grabConnection() be able to return a valid connection, either from the pool or by
   * establishing a new connection, without normally causing an authentication failure
   * 
   * @return
   */
  public boolean hasAuthenticated() {
    return allocated.size() + unused.size() > 0;
  }

  /**
   * Creates a new connection
   * 
   * @return
   * @throws ExplorerException
   * @throws SQLException
   */
  protected SQLConnection createNewConnection() throws SQLException {

    SQLConnection connection = alias.getDriver().getConnection(this);
    return connection;
  }

  /**
   * Returns the Alias for this User
   * 
   * @return
   */
  public Alias getAlias() {
    return alias;
  }

  /**
   * Changes the alias for the User
   * 
   * @param alias
   */
  /* package */void setAlias(Alias alias) {
    if (this.alias != null && alias != null) {
      if (this.alias != alias)
        throw new IllegalArgumentException("Cannot change a User's Alias");
      return;
    }
    this.alias = alias;
  }

  public String getPassword() {
    return password;
  }

  public String getUserName() {
    return userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getDescription() {
    return getAlias().getName() + '/' + getUserName();
  }

  public boolean isAutoCommit() {
    return autoCommit;
  }

  public void setAutoCommit(boolean autoCommit) {
    this.autoCommit = autoCommit;
  }

  public boolean isCommitOnClose() {
    return commitOnClose;
  }

  public void setCommitOnClose(boolean commitOnClose) {
    this.commitOnClose = commitOnClose;
  }

  public int compareTo(User that) {
    return userName.compareToIgnoreCase(that.getUserName());
  }

  private boolean getBoolean(String value, boolean defaultValue) {
    try {
      return Boolean.parseBoolean(value);
    } catch (Exception e) {
      return defaultValue;
    }
  }

  @Override
  public String toString() {
    return getDescription();
  }

  public boolean isOfflineMode() {
    return offlineMode;
  }

  public void setOfflineMode(boolean b) {
    offlineMode = b;
    if (b)
      newSessionsQueue.clear();
    // if (!b)
    // prompted = false;
  }

  public boolean isPrompted() {
    return prompted;
  }

  public void setPrompted(boolean prompted) {
    this.prompted = prompted;
  }
}
