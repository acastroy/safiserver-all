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

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.TreeMap;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import com.safi.db.DBConnection;
import com.safi.db.DbFactory;
import com.safi.db.Query;
import com.safi.db.manager.DBManagerException;
import com.safi.db.manager.DBResourceException;
import com.safi.db.manager.ResourceModifiedException;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

/**
 * Represents a configured Alias, maintaining a pool of available connections
 * 
 * Note that this superceeds the old com.safi.workshop.sqlexplorer.AliasModel and
 * com.safi.workshop.sqlexplorer.sessiontree.model.* classes.
 * 
 * This is basically a large rewrite of SQLAlias, which was originally taken from
 * SquirrelSQL; it was based on and used parts of Squirrel which no longer exist (even in
 * the SquirrelSQL CVS on Sourceforge) and are effectively undocumented. Changes needed to
 * fix bugs relating to transactions and multiple logons per alias meant that keeping the
 * old code became unmaintainable, hence the sweeping rewrite.
 * 
 * @author John Spackman
 */
public class Alias implements IAdaptable {

  /* package */static final String ALIASES = "aliases";
  /* package */static final String ALIAS = "alias";
  /* package */static final String AUTO_LOGON = "auto-logon";
  /* package */static final String CONNECT_AT_STARTUP = "connect-at-startup";
  /* package */static final String DEFAULT_USER = "default-user";
  /* package */static final String DRIVER_ID = "driver-id";
  /* package */static final String FOLDER_FILTER_EXPRESSION = "folder-filter-expression";
  /* package */static final String HAS_NO_USER_NAME = "has-no-user-name";
  /* package */static final String NAME = "name";
  /* package */static final String NAME_FILTER_EXPRESSION = "name-filter-expression";
  /* package */static final String SCHEMA_FILTER_EXPRESSION = "schema-filter-expression";
  /* package */static final String URL = "url";
  /* package */static final String USERS = "users";

  private static int s_serialNo = 0;

  // Descriptive name of the Alias
  private String name;

  // Driver
  private String driverId;

  // Database URL
  private String url;

  // Whether to auto-logon the default user
  private boolean autoLogon;

  // Whether to connect at startup
  private boolean connectAtStartup;

  // Filters
  private String folderFilterExpression = "";
  private String nameFilterExpression = "";
  private String schemaFilterExpression = "";

  // Whether username/password are required
  private boolean hasNoUserName;

  // Default user
  private User defaultUser;

  // List of all users (including the default user), indexed by user name
  private TreeMap<String, User> users = new TreeMap<String, User>();

  private DBConnection connection;

  public Alias(DBConnection conn) {
    this.connection = conn;
    if (StringUtils.isBlank(conn.getUser())) {
      User user = new User("anonymous", "");
      hasNoUserName = true;
      setDefaultUser(user);
    } else {
      User user = new User(conn.getUser(), conn.getPassword());
      hasNoUserName = false;
      setDefaultUser(user);
    }
    name = conn.getName();
    url = conn.getUrl();
    driverId = conn.getDriver().getName();
  }

  /**
   * Constructs a new Alias with a given name
   * 
   */
  public Alias(String name) {
    connection = DbFactory.eINSTANCE.createDBConnection();
    connection.setName(name);
    this.name = name;
  }

  /**
   * Constructs a new Alias with a unique name
   * 
   */
  public Alias() {
    this("new-alias-" + (++s_serialNo));
  }

  /**
   * Constructs an Alias from XML, previously obtained from describeAsXml()
   * 
   * @param root
   */
  // public Alias(Element root) {
  // autoLogon = Boolean.parseBoolean(root.attributeValue(AUTO_LOGON));
  // connectAtStartup = Boolean.parseBoolean(root.attributeValue(CONNECT_AT_STARTUP));
  // driverId = root.attributeValue(DRIVER_ID);
  // String str = root.attributeValue(HAS_NO_USER_NAME);
  // if (str != null)
  // hasNoUserName = Boolean.parseBoolean(str);
  // name = root.elementText(NAME);
  // url = root.elementText(URL);
  // folderFilterExpression = root.elementText(FOLDER_FILTER_EXPRESSION);
  // nameFilterExpression = root.elementText(NAME_FILTER_EXPRESSION);
  // schemaFilterExpression = root.elementText(SCHEMA_FILTER_EXPRESSION);
  //
  // if (hasNoUserName) {
  // User user = new User("anonymous", "");
  // addUser(user);
  // setDefaultUser(user);
  // } else {
  // Element usersElem = root.element(USERS);
  // if (usersElem != null) {
  // List<Element> list = usersElem.elements(User.USER);
  // if (list != null)
  // for (Element userElem : list) {
  // User user = new User(userElem);
  // if (user.getUserName() != null && user.getUserName().trim().length() > 0)
  // addUser(user);
  // }
  // String defaultUserName = root.elementText(DEFAULT_USER);
  // if (defaultUserName != null) {
  // User user = users.get(defaultUserName);
  // if (user != null)
  // defaultUser = user;
  // }
  // }
  // }
  // }
  /**
   * Describes this alias in XML; the result can be passed to the Alias(Element)
   * constructor to refabricate it
   * 
   * @return
   */
  // public Element describeAsXml() {
  // DefaultElement root = new DefaultElement(ALIAS);
  // root.addAttribute(AUTO_LOGON, Boolean.toString(autoLogon));
  // root.addAttribute(CONNECT_AT_STARTUP, Boolean.toString(connectAtStartup));
  // root.addAttribute(DRIVER_ID, driverId);
  // root.addAttribute(HAS_NO_USER_NAME, Boolean.toString(hasNoUserName));
  // root.addElement(NAME).setText(name);
  // root.addElement(URL).setText(url);
  // root.addElement(FOLDER_FILTER_EXPRESSION).setText(folderFilterExpression);
  // root.addElement(NAME_FILTER_EXPRESSION).setText(nameFilterExpression);
  // root.addElement(SCHEMA_FILTER_EXPRESSION).setText(schemaFilterExpression);
  // Element usersElem = root.addElement(USERS);
  // for (User user : users.values())
  // usersElem.add(user.describeAsXml());
  // if (defaultUser != null)
  // root.addElement(DEFAULT_USER).setText(defaultUser.getUserName());
  // return root;
  // }
  /**
   * Constructs an Alias as a duplicate of another, but with a new name
   * 
   * @param copyFrom
   */
  public Alias(Alias copyFrom) {
    this.name = "Copy of " + copyFrom.getName();
    if (copyFrom.defaultUser != null) {
      defaultUser = copyFrom.defaultUser.createCopy();
      addUser(defaultUser);
    }
    connection = (DBConnection) EcoreUtil.copy(copyFrom.getConnection());
  }

  /**
   * Closes all connections
   * 
   * @throws ExplorerException
   */
  public void closeAllConnections() {
    for (User user : users.values())
      user.closeAllSessions();
  }

  public void remove() throws IOException, DBResourceException, ResourceModifiedException,
      DBManagerException {
    remove(false, true);
  }

  /**
   * Removes this Alias (permanently)
   * 
   * @throws ResourceModifiedException
   * @throws DBResourceException
   * @throws IOException
   * @throws DBManagerException
   * @throws ExplorerException
   */
  public void remove(boolean removeFromDB, boolean removeFromSafi) throws IOException,
      DBResourceException, ResourceModifiedException, DBManagerException {
    if (removeFromDB && getConnection() != null && getConnection().getLastUpdated() != null) {
      SQLExplorerPlugin.getDefault().deleteDBResource(getConnection());
    }
    closeAllConnections();
    SQLExplorerPlugin.getDefault().getAliasManager().removeAlias(getName(), removeFromSafi);
  }

  /**
   * Returns the name of the alias
   * 
   * @return
   */
  public String getName() {
    return name;
  }

  /**
   * Adds or redefines a User; if the user does not exist (IE there is no User object with
   * the same user name) then the new user is added, but if a User already exists then the
   * passed in User is used to reconfigure the existing User. In both cases addUser() will
   * return the User object which remains in this Alias instance; EG when reconfiguring a
   * User, the reconfigured, pre-existing User object is returned.
   * 
   * @param user
   * @return the User object which is kept in the list of Users
   */
  public User addUser(User user) {
    if (user.getAlias() != null) {
      if (user.getAlias() != this)
        throw new IllegalArgumentException("User already belongs to a different Alias");
      return user;
    }
    if (StringUtils.isBlank(user.getUserName()))
      throw new IllegalArgumentException("Illegal user name");
    if (!users.isEmpty() && hasNoUserName)
      throw new IllegalArgumentException(
          "Cannot add users when usernames are not required by the alias");

    User existingUser = users.get(user.getUserName());
    if (existingUser != null) {
      existingUser.mergeWith(user);
      if (connection != null) {
        connection.setUser(existingUser.getUserName());
        connection.setPassword(existingUser.getPassword());
      }
      return existingUser;
    }

    users.put(user.getUserName(), user);
    user.setAlias(this);
    if (defaultUser == null)
      defaultUser = user;
    if (connection != null) {
      connection.setUser(user.getUserName());
      connection.setPassword(user.getPassword());
    }
    SQLExplorerPlugin.getDefault().getAliasManager().modelChanged();
    return user;
  }

  public void addQuery(Query query) {
    getConnection().getQueries().add(query);
    getConnection().setLastModified(new Date());
    SQLExplorerPlugin.getDefault().saveDBResources(false);
    SQLExplorerPlugin.getDefault().getAliasManager().modelChanged();
  }

  public void removeQuery(Query query) {
    getConnection().getQueries().remove(query);
    getConnection().setLastModified(new Date());
    SQLExplorerPlugin.getDefault().saveDBResources(false);
    SQLExplorerPlugin.getDefault().getAliasManager().modelChanged();
  }

  /**
   * Removes the User from the list of users
   * 
   * @param user
   */
  public void removeUser(User user) {
    boolean isDefault = user == defaultUser;
    if (user.getAlias() != this)
      throw new IllegalArgumentException("User belongs to a different Alias");
    user.closeAllSessions();
    user.setAlias(null);
    users.remove(user.getUserName());
    if (isDefault) {
      getConnection().setPassword(null);
      getConnection().setUser(null);
      if (!users.isEmpty()) {
        setDefaultUser(users.values().iterator().next());
      } else
        defaultUser = null;
    }
  }

  /**
   * Returns the user with a given name
   * 
   * @param userName
   * @return
   */
  public User getUser(String userName) {
    return users.get(userName);
  }

  /**
   * Returns a list of all users
   * 
   * @return
   */
  public Collection<User> getUsers() {
    return users.values();
  }

  /**
   * Returns true if the user belongs to this Alias
   * 
   * @param user
   * @return
   */
  public boolean contains(User user) {
    return users.values().contains(user);
  }

  /**
   * Returns the ISQLDriver underlying this alias
   * 
   * @return
   */
  public ManagedDriver getDriver() {
    return SQLExplorerPlugin.getDefault().getDriverModel().getDriver(driverId);
  }

  /**
   * Sets the underlying driver
   * 
   * @param driver
   */
  public void setDriver(ManagedDriver driver) {
    driverId = driver.getId();
    if (connection != null) {
      connection.setDriver(driver.getDriver());
    }
  }

  /**
   * Returns true if filtering is applied
   * 
   * @return
   */
  public boolean isFiltered() {
    return (folderFilterExpression != null && folderFilterExpression.trim().length() > 0)
        || (nameFilterExpression != null && nameFilterExpression.trim().length() > 0)
        || (schemaFilterExpression != null && schemaFilterExpression.trim().length() > 0);
  }

  public boolean isAutoLogon() {
    return autoLogon;
  }

  public void setAutoLogon(boolean autoLogon) {
    this.autoLogon = autoLogon;
  }

  public boolean isConnectAtStartup() {
    return connectAtStartup;
  }

  public void setConnectAtStartup(boolean connectAtStartup) {
    this.connectAtStartup = connectAtStartup;
  }

  public User getDefaultUser() {
    return defaultUser;
  }

  /**
   * Sets the default user, adding it to the list of users if necessary; if the
   * defaultUser is a new user and a user with the same username already exists then the
   * existing user is updated and returned (see addUser())
   * 
   * @param defaultUser
   * @return
   */
  public User setDefaultUser(User defaultUser) {
    this.defaultUser = addUser(defaultUser);
    // if (getConnection() != null && defaultUser != null){
    // getConnection().setUser(defaultUser.getUserName());
    // getConnection().setPassword(defaultUser.getPassword());
    // }
    return this.defaultUser;
  }

  public String getFolderFilterExpression() {
    return folderFilterExpression;
  }

  public void setFolderFilterExpression(String folderFilterExpression) {
    this.folderFilterExpression = folderFilterExpression;
  }

  public String getNameFilterExpression() {
    return nameFilterExpression;
  }

  public void setNameFilterExpression(String nameFilterExpression) {
    this.nameFilterExpression = nameFilterExpression;
  }

  public String getSchemaFilterExpression() {
    return schemaFilterExpression;
  }

  public void setSchemaFilterExpression(String schemaFilterExpression) {
    this.schemaFilterExpression = schemaFilterExpression;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
    if (connection != null)
      connection.setUrl(url);
  }

  public void setName(String name) {
    this.name = name;
    if (connection != null)
      connection.setName(name);
  }

  public String getDriverId() {
    return driverId;
  }

  /**
   * @return the hasNoUserName
   */
  public boolean hasNoUserName() {
    return hasNoUserName;
  }

  /**
   * @param hasNoUserName
   *          the hasNoUserName to set
   */
  public void setHasNoUserName(boolean hasNoUserName) {
    if (this.hasNoUserName == hasNoUserName)
      return;
    this.hasNoUserName = hasNoUserName;
    if (hasNoUserName) {
      for (User user : users.values())
        user.setAlias(null);
      users.clear();
      User user = new User("anonymous", "");
      addUser(user);
      setDefaultUser(user);
    } else {
      for (User user : users.values())
        user.setAlias(null);
      users.clear();
    }
  }

  public void setDriverId(String driverId) {
    this.driverId = driverId;
  }

  public DBConnection getConnection() {
    return connection;
  }

  public void setConnection(DBConnection connection) {
    this.connection = connection;
  }

  @Override
  public Object getAdapter(Class adapter) {
    if (adapter == IPropertySource.class) {// || adapter ==
      // IContributorResourceAdapter.class){
      return new AliasProperties(this);
    }

    return null;
  }

  private final static String PROPERTY_NAME = "name";
  private final static String PROPERTY_URL = "url";
  private final static String PROPERTY_USER = "user";
  private final static String PROPERTY_LOGIN_TIMEOUT = "login timeout";
  private final static String PROPERTY_TRANSACTION_MODE = "transaction mode";
  private final static String PROPERTY_MAX_IDLE_TIME = "max idle time";
  private final static String PROPERTY_MIN_POOLSIZE = "min poolsize";
  private final static String PROPERTY_MAX_POOLSIZE = "max poolsize";
  private final static String PROPERTY_ACQUIRE_INC = "acquire increment";
  public class AliasProperties implements IPropertySource, IWorkbenchAdapter {
    Alias alias;

    private final Object PropertiesTable[][] = {
        { PROPERTY_NAME, new TextPropertyDescriptor(PROPERTY_NAME, PROPERTY_NAME) },
        { PROPERTY_URL, new TextPropertyDescriptor(PROPERTY_URL, PROPERTY_URL) },
        { PROPERTY_USER, new TextPropertyDescriptor(PROPERTY_USER, PROPERTY_USER) },
        { PROPERTY_LOGIN_TIMEOUT,
            new TextPropertyDescriptor(PROPERTY_LOGIN_TIMEOUT, PROPERTY_LOGIN_TIMEOUT) },
        { PROPERTY_TRANSACTION_MODE,
            new TextPropertyDescriptor(PROPERTY_TRANSACTION_MODE, PROPERTY_TRANSACTION_MODE) },
        { PROPERTY_MAX_IDLE_TIME,
            new TextPropertyDescriptor(PROPERTY_MAX_IDLE_TIME, PROPERTY_MAX_IDLE_TIME) },
        { PROPERTY_MIN_POOLSIZE,
            new TextPropertyDescriptor(PROPERTY_MIN_POOLSIZE, PROPERTY_MIN_POOLSIZE) },
        { PROPERTY_MAX_POOLSIZE,
            new TextPropertyDescriptor(PROPERTY_MAX_POOLSIZE, PROPERTY_MAX_POOLSIZE) },
        { PROPERTY_ACQUIRE_INC,
            new TextPropertyDescriptor(PROPERTY_ACQUIRE_INC, PROPERTY_ACQUIRE_INC) } };

    public AliasProperties(Alias alias) {
      this.alias = alias;
    }

    @Override
    public Object getEditableValue() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
      // Create the property vector.
      IPropertyDescriptor[] propertyDescriptors = new IPropertyDescriptor[PropertiesTable.length];

      for (int i = 0; i < PropertiesTable.length; i++) {
        // Add each property supported.

        PropertyDescriptor descriptor;

        descriptor = (PropertyDescriptor) PropertiesTable[i][1];
        propertyDescriptors[i] = descriptor;
        descriptor.setCategory("DB Connection Info");
      }

      // Return it.
      return propertyDescriptors;

    }

    @Override
    public Object getPropertyValue(Object id) {
      if (PROPERTY_NAME.equals(id)) {
        return alias.getName();
      } else if (PROPERTY_NAME.equals(id)) {
        return alias.getName();
      } else if (PROPERTY_ACQUIRE_INC.equals(id)) {
        return alias.getConnection().getAcquireIncrement();
      } else if (PROPERTY_LOGIN_TIMEOUT.equals(id)) {
        return alias.getConnection().getLoginTimeout();
      } else if (PROPERTY_MAX_IDLE_TIME.equals(id)) {
        return alias.getConnection().getMaxIdleTime();
      } else if (PROPERTY_MAX_POOLSIZE.equals(id)) {
        return alias.getConnection().getMaxPoolSize();
      } else if (PROPERTY_MIN_POOLSIZE.equals(id)) {
        return alias.getConnection().getMinPoolSize();
      } else if (PROPERTY_TRANSACTION_MODE.equals(id)) {
        return alias.getConnection().getTransactionMode();
      } else if (PROPERTY_URL.equals(id)) {
        return alias.getConnection().getUrl();
      } else if (PROPERTY_USER.equals(id)) {
        return alias.getConnection().getUser();
      } else
        return null;
    }

    @Override
    public boolean isPropertySet(Object id) {
      // TODO Auto-generated method stub
      return false;
    }

    @Override
    public void resetPropertyValue(Object id) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setPropertyValue(Object id, Object value) {
      // TODO Auto-generated method stub

    }

    @Override
    public Object[] getChildren(Object o) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public ImageDescriptor getImageDescriptor(Object object) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public String getLabel(Object o) {
      return alias.getName();
    }

    @Override
    public Object getParent(Object o) {
      // TODO Auto-generated method stub
      return null;
    }

    // @Override
    // public IResource getAdaptedResource(IAdaptable adaptable) {
    // return new Resource(){
    // g
    // }
    // }

  }

}
