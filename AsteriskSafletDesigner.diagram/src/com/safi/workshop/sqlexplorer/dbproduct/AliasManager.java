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

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import org.dom4j.Element;
import org.dom4j.tree.DefaultElement;
import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.SafiDriverManager;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

/**
 * Maintains the list of Alias objects
 * 
 * @author John Spackman
 * 
 */
public class AliasManager implements ConnectionListener {

  // List of aliases, indexed by alias name
  private TreeMap<String, Alias> aliases = new TreeMap<String, Alias>();

  // Connection Listeners
  private LinkedList<ConnectionListener> connectionListeners = new LinkedList<ConnectionListener>();

  private SafiDriverManager safiDriverManager;

  public AliasManager(SafiDriverManager safiDriverManager) {
    this.safiDriverManager = safiDriverManager;
  }

  /**
   * Loads Aliases from the users preferences
   * 
   */
  public void loadAliases() throws ExplorerException {
    // if (safiDriverManager == null) return;
    aliases.clear();
    for (DBDriver driver : safiDriverManager.getDrivers()) {
      for (DBConnection conn : driver.getConnections()) {
        Alias a = new Alias(conn);
        // if (StringUtils.isBlank(conn.getName())){
        // a.setHasNoUserName(false);
        // User user = new User("anonymous", "");
        // a.addUser(user);
        // a.setDefaultUser(user);
        // a.setHasNoUserName(true);
        // }
        // else {
        // User user = new User(conn.getName(), conn.getPassword());
        // a.addUser(user);
        // a.setDefaultUser(user);
        // }
        // a.setName(conn.getName());
        // a.setUrl(conn.getUrl());
        // a.setDriverId(driver.getName());
        addAlias(a, false);
      }
    }
    // aliases.clear();
    //		
    // try {
    // SAXReader reader = new SAXReader();
    // File file = new File(ApplicationFiles.USER_ALIAS_FILE_NAME);
    // if (file.exists()) {
    // Element root = reader.read(file).getRootElement();
    // if (root.getName().equals("Beans"))
    // root = convertToV350(root);
    // List<Element> list = root.elements(Alias.ALIAS);
    // if (list != null)
    // for (Element elem : list)
    // addAlias(new Alias(elem));
    // }
    // }catch(DocumentException e) {
    // throw new ExplorerException(e);
    // }
  }

  /**
   * Saves all the Aliases to the users preferences
   * 
   */
  public void saveAliases(boolean saveToDb) throws ExplorerException {
    try {
      SQLExplorerPlugin.getDefault().saveDBResources(saveToDb);
      SQLExplorerPlugin.getDefault().getAliasManager().modelChanged();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      throw new ExplorerException(e);
    }

    // DefaultElement root = new DefaultElement(Alias.ALIASES);
    // for (Alias alias : aliases.values())
    // root.add(alias.describeAsXml());
    //
    // try {
    // FileWriter writer = new FileWriter(new
    // File(ApplicationFiles.USER_ALIAS_FILE_NAME));
    // OutputFormat format = OutputFormat.createPrettyPrint();
    // XMLWriter xmlWriter = new XMLWriter(writer, format);
    // xmlWriter.write(root);
    // writer.flush();
    // writer.close();
    // }catch(IOException e) {
    // throw new ExplorerException(e);
    // }
  }

  public void addAlias(Alias alias, boolean save) throws ExplorerException {
    Alias old = aliases.put(alias.getName(), alias);
    if (save) {
      saveAliases(false);
    }
  }

  public void saveAlias(Alias alias) throws ExplorerException {
    try {
      SQLExplorerPlugin.getDefault().saveDBResource(alias);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      throw new ExplorerException(e);
    }
  }

  /**
   * Adds an Alias
   * 
   * @param alias
   */
  // public void addAlias(Alias alias, boolean addT) throws ExplorerException {
  // Alias old = aliases.put(alias.getName(), alias);
  // if (old != null) {
  // DBConnection oldC = old.getConnection();
  //      
  // alias.setDriver(old.getDriver());
  // } else {
  // conn = DbFactory.eINSTANCE.createDBConnection();
  // conn.setName(alias.getName());
  // }
  //
  // conn.setUser(alias.getDefaultUser().getUserName());
  // conn.setPassword(alias.getDefaultUser().getPassword());
  // conn.setUrl(alias.getUrl());
  // if (old == null) alias.getDriver().getDriver().getConnections().add(conn);
  // saveAliases();
  //
  // // conn.setDriver(alias.getDriver().getDriver());
  // }
  public void removeAlias(String aliasName) {
    removeAlias(aliasName, true);
  }

  /**
   * Removes an Alias with a given name
   * 
   * @param aliasName
   */
  public void removeAlias(String aliasName, boolean removeFromSafi) {
    Alias alias = aliases.remove(aliasName);
    if (alias != null) {
      alias.closeAllConnections();
      if (removeFromSafi) {
        DBDriver driver = alias.getDriver().getDriver();
        if (driver != null) {
          driver.getConnections().remove(alias.getConnection());
          // driver.setLastModified(new Date());
        }
      }
      SQLExplorerPlugin.getDefault().getAliasManager().modelChanged();
    }
  }

  public void removeAll() {
    removeAll(true);
  }

  public void removeAll(Collection<Alias> aliases, boolean removeFromSafi) {
    for (Alias a : aliases) {
      try {
        a.remove(false, removeFromSafi);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  public void removeAll(boolean removeFromSafi) {
    TreeMap<String, Alias> clone = (TreeMap<String, Alias>) aliases.clone();
    for (Alias a : clone.values()) {
      try {
        a.remove(false, removeFromSafi);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Locates an Alias by name
   * 
   * @param aliasName
   * @return
   */
  public Alias getAlias(String aliasName) {
    return aliases.get(aliasName);
  }

  public Alias getAlias(int id) {
    for (Alias a : aliases.values()) {
      if (a.getConnection().getId() == id)
        return a;
    }
    return null;
  }

  /**
   * Provides a list of all Aliases
   * 
   * @return
   */
  public Collection<Alias> getAliases() {
    return aliases.values();
  }

  /**
   * Returns true if the alias is in our list
   * 
   * @param alias
   * @return
   */
  public boolean contains(Alias alias) {
    return aliases.values().contains(alias);
  }

  /**
   * Closes all connections in all aliases; note that ConnectionListeners are NOT invoked
   * 
   */
  public void closeAllConnections() throws ExplorerException {
    for (Alias alias : aliases.values()) {
      try {
        alias.closeAllConnections();
      } catch (Exception e) {
        SQLExplorerPlugin.error(e);
      }
    }
  }

  /**
   * Adds a listener for the connections
   * 
   * @param listener
   */
  public void addListener(ConnectionListener listener) {
    connectionListeners.add(listener);
  }

  /**
   * Removes a listener
   * 
   * @param listener
   */
  public void removeListener(ConnectionListener listener) {
    connectionListeners.remove(listener);
  }

  /**
   * Called to notify that the list of connections has changed; passes this onto the
   * listeners
   */
  public void modelChanged() {
    List<ConnectionListener> listeners = (List<ConnectionListener>) connectionListeners.clone();
    for (ConnectionListener listener : listeners)
      listener.modelChanged();

  }

  /**
   * Upgrades a v3 definition (java beans style) to v3.5.0beta2 and onwards
   * 
   * @param beans
   * @return
   */
  protected Element convertToV350(Element beans) {
    Element result = new DefaultElement(Alias.ALIASES);
    for (Object o : beans.elements("Bean")) {
      Element bean = (Element) o;
      Element alias = result.addElement(Alias.ALIAS);
      alias.addAttribute(Alias.AUTO_LOGON, Boolean.toString(getBoolean(bean
          .elementText("autoLogon"), false)));
      alias.addAttribute(Alias.CONNECT_AT_STARTUP, Boolean.toString(getBoolean(bean
          .elementText("connectAtStartup"), false)));
      alias.addAttribute(Alias.DRIVER_ID, bean.element("driverIdentifier").elementText("string"));
      alias.addElement(Alias.NAME).setText(bean.elementText("name"));
      Element userElem = alias.addElement(Alias.USERS).addElement(User.USER);
      userElem.addElement(User.USER_NAME).setText(bean.elementText("userName"));
      userElem.addElement(User.PASSWORD).setText(bean.elementText("password"));
      alias.addElement(Alias.URL).setText(bean.elementText("url"));
      alias.addElement(Alias.FOLDER_FILTER_EXPRESSION).setText(
          bean.elementText("folderFilterExpression"));
      alias.addElement(Alias.NAME_FILTER_EXPRESSION).setText(
          bean.elementText("nameFilterExpression"));
      alias.addElement(Alias.SCHEMA_FILTER_EXPRESSION).setText(
          bean.elementText("schemaFilterExpression"));
    }

    return result;
  }

  /**
   * Helper method to convert a string to a boolean
   * 
   * @param value
   * @param defaultValue
   * @return
   */
  private boolean getBoolean(String value, boolean defaultValue) {
    if (value == null || value.trim().length() == 0)
      return defaultValue;
    return value.equals("true") || value.equals("yes") || value.equals("on");
  }
}
