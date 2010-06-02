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
package com.safi.workshop.sqlexplorer.plugin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.DBResource;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.db.SafiDriverManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.DBManager;
import com.safi.server.saflet.manager.DBManagerException;
import com.safi.server.saflet.manager.DBResourceException;
import com.safi.server.saflet.manager.ResourceModifiedException;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.SQLCannotConnectException;
import com.safi.workshop.sqlexplorer.IConstants.Confirm;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.AliasManager;
import com.safi.workshop.sqlexplorer.dbproduct.DriverManager;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.history.SQLHistory;
import com.safi.workshop.sqlexplorer.plugin.views.DatabaseStructureView;

/**
 * The main plugin class to be used in the desktop.
 */
public class SQLExplorerPlugin extends AbstractUIPlugin {

  public final static String PLUGIN_ID = AsteriskDiagramEditorPlugin.ID;
  private AliasManager aliasManager;

  private int count = 0;

  private DriverManager driverManager;

  private SafiDriverManager safiDriverManager;

  // Resource bundle.
  private ResourceBundle resourceBundle;

  private SQLHistory _history = null;

  // The shared instance.
  private static SQLExplorerPlugin plugin;

  private boolean _defaultConnectionsStarted = false;

  // Cached connections view
  // private ConnectionsView connectionsView;

  // Cached database structure view
  private DatabaseStructureView databaseStructureView;

  private boolean init;

  // private ResourceSet resourceLoader;

  // private Resource dbResource;

  /**
   * The constructor. Moved previous logic to the start method.
   */
  public SQLExplorerPlugin() {
    super();

    plugin = this;
  }

  /**
   * Initialises the Plugin
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);

    // initResources();
  }

  public void initResources(IProgressMonitor monitor) throws Exception {
    if (init)
      return;
    try {
      initHistory();
      getLog().addLogListener(new ILogListener() {
        public void logging(IStatus status, String plugin) {
          System.err.println(status.getMessage());
          Throwable t = status.getException();
          if (t != null) {
            System.err.println(t.getMessage());
            t.printStackTrace(System.err);
          }
        }
      });

      monitor.subTask("Populating Safi Navigator view");
      if (monitor.isCanceled())
        return;
      safiDriverManager = getSafiDriverManager();
      buildDBNavModel();
      monitor.worked(1);
      try {
        resourceBundle = ResourceBundle.getBundle("com.safi.workshop.sqlexplorer.test"); //$NON-NLS-1$
      } catch (MissingResourceException x) {
        resourceBundle = null;
      }

      // load SQL History from previous sessions

      init = true;
    } catch (Exception e) {
      error("Exception during start", e);
      throw e;
    }

  }

  public void initHistory() {
    if (_history == null)
      _history = new SQLHistory();

  }

  public void rebuildDBNavModel() throws ExplorerException {
    driverManager = null;
    aliasManager = null;
    buildDBNavModel();
    AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(SafiServerPlugin.getDefault().isConnected());
  }

  public void buildDBNavModel() throws ExplorerException {
    if (driverManager == null) {
      driverManager = new DriverManager(safiDriverManager);
      driverManager.loadDrivers();
    }
    if (aliasManager == null) {
      aliasManager = new AliasManager(safiDriverManager);
      aliasManager.loadAliases();
    }

  }

  public void saveDBResources(boolean saveToDB) {
    if (safiDriverManager != null)
      try {
        DBManager.getInstance().saveDriverManager(safiDriverManager, saveToDB);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        final Shell activeShell = Display.getDefault().getActiveShell();
        if (activeShell != null)
          MessageDialog.openError(activeShell, "Save Error", "Couldn't write DB resource file: "
              + e.getLocalizedMessage());
      }
  }

  /**
   * Game over. End all..
   * 
   * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    saveDBResources(false);
    if (aliasManager != null)
      aliasManager.closeAllConnections();

    // save SQL History for next session
    if (_history != null)
      _history.save();

    super.stop(context);
  }

  /**
   * @return Returns the next serial number for creating new editors (used in the title of
   *         the filename)
   */
  public int getEditorSerialNo() {
    return count++;
  }

  /**
   * Returns the DriverModel
   * 
   * @return
   */
  public DriverManager getDriverModel() {
    return driverManager;
  }

  /**
   * @return The list of configured Aliases
   */
  public AliasManager getAliasManager() {
    return aliasManager;
  }

  /**
   * @return SQLHistory Instance
   */
  public SQLHistory getSQLHistory() {

    return _history;
  }

  /**
   * @return Returns the plugin's resource bundle,
   */
  public ResourceBundle getResourceBundle() {
    return resourceBundle;
  }

  /**
   * Get the version number as specified in plugin.xml
   * 
   * @return version number of SQL Explorer plugin
   */
  public String getVersion() {
    String version = (String) plugin.getBundle().getHeaders().get(
        org.osgi.framework.Constants.BUNDLE_VERSION);
    return version;
  }

  /**
   * Returns the shared instance.
   */
  public static SQLExplorerPlugin getDefault() {
    return plugin;
  }

  /**
   * Returns the confirmation state of the given preference id
   * 
   * @param preferenceId
   * @return
   */
  public static Confirm getConfirm(String preferenceId) {
    try {
      return IConstants.Confirm.valueOf(AsteriskDiagramEditorPlugin.getDefault()
          .getPluginPreferences().getString(preferenceId));
    } catch (IllegalArgumentException e) {
      // Nothing
    }
    return IConstants.Confirm.ASK;
  }

  /**
   * Global log method.
   * 
   * @param message
   * @param t
   */
  public static void error(String message, Throwable t) {
    if (t instanceof SQLCannotConnectException)
      getDefault().getLog().log(
          new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, IStatus.ERROR, String
              .valueOf(message), null));
    else {
      getDefault().getLog().log(
          new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, IStatus.ERROR, String
              .valueOf(message), t));
    }
  }

  /**
   * Global log method.
   * 
   * @param message
   */
  public static void error(String message) {
    getDefault().getLog().log(
        new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, IStatus.ERROR, String
            .valueOf(message), null));
  }

  /**
   * Global log method.
   * 
   * @param t
   */
  public static void error(Exception e) {
    error(e.getMessage(), e);
  }

  /**
   * Returns the string from the plugin's resource bundle, or 'key' if not found.
   */
  public static String getResourceString(String key) {
    ResourceBundle bundle = SQLExplorerPlugin.getDefault().getResourceBundle();
    try {
      return bundle.getString(key);
    } catch (MissingResourceException e) {
      return key;
    }
  }

  private IWorkbenchPage getActivePage() {

    IWorkbench wb = AsteriskDiagramEditorPlugin.getDefault().getWorkbench();
    if (wb != null && wb.getActiveWorkbenchWindow() != null)
      return wb.getActiveWorkbenchWindow().getActivePage();
    return null;
  }

  // public ConnectionsView getConnectionsView() {
  // return getConnectionsView(true);
  // }
  // public ConnectionsView getConnectionsView(boolean init) {
  // // try {
  // // initResources();
  // // } catch (Exception e) {
  // // e.printStackTrace();
  // // }
  // if (connectionsView == null && init) {
  // IWorkbenchPage page = getActivePage();
  // if (page != null) {
  // connectionsView = (ConnectionsView) page.findView(ConnectionsView.class.getName());
  // if (connectionsView == null) try {
  // connectionsView = (ConnectionsView) page.showView(ConnectionsView.class.getName());
  // } catch (PartInitException e) {
  // error(e);
  // }
  // }
  // }
  //
  // return connectionsView;
  // }
  //
  // public void setConnectionsView(ConnectionsView connectionsView) {
  // this.connectionsView = connectionsView;
  // }

  public DatabaseStructureView getDatabaseStructureView() {
    if (databaseStructureView == null) {
      IWorkbenchPage page = getActivePage();
      if (page != null) {
        databaseStructureView = (DatabaseStructureView) page.findView(DatabaseStructureView.class
            .getName());
        if (databaseStructureView == null)
          try {
            databaseStructureView = (DatabaseStructureView) page
                .showView(DatabaseStructureView.class.getName());
          } catch (PartInitException e) {
            error(e);
          }
      }
    }
    return databaseStructureView;
  }

  public DatabaseStructureView showDatabaseStructureView() {
    if (databaseStructureView == null)
      databaseStructureView = getDatabaseStructureView();
    else {
      IWorkbenchPage page = getActivePage();
      if (page != null) {
        databaseStructureView = (DatabaseStructureView) page.findView(DatabaseStructureView.class
            .getName());
        if (databaseStructureView == null)
          try {
            databaseStructureView = (DatabaseStructureView) page
                .showView(DatabaseStructureView.class.getName());
          } catch (PartInitException e) {
            error(e);
          }
      }
    }
    return databaseStructureView;
  }

  public void setDatabaseStructureView(DatabaseStructureView databaseStructureView) {
    this.databaseStructureView = databaseStructureView;
  }

  // public IWorkbenchSite getSite() {
  // if (getConnectionsView() == null) return null;
  // return connectionsView.getSite();
  // }

  public SafiDriverManager getSafiDriverManager() {
    if (safiDriverManager == null) {
      try {
        // SafiServerPlugin.getDefault().loadDriverManager();
        safiDriverManager = DBManager.getInstance().getDriverManager();
      } catch (DBManagerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    return safiDriverManager;
  }

  public void updateDBResource(Alias alias) throws DBManagerException {
    DBConnection oldConnection = alias.getConnection();
    if (oldConnection.getLastUpdated() == null)
      return;
    DBResource rez = DBManager.getInstance().updateDBResource(safiDriverManager, oldConnection);
    if (rez == oldConnection) {
      MessageDialog.openInformation(getWorkbench().getDisplay().getActiveShell(), "No changes",
          "There have been no changes to the selected resource");
      return;
    }
    if (rez == null) {
      DBConnection conn = oldConnection;
      boolean isModified = false;
      for (Query q : conn.getQueries()) {
        if (q.getLastUpdated() == null || q.getLastModified().compareTo(q.getLastUpdated()) >= 0) {
          isModified = true;
          break;
        }
      }
      if (isModified) {
        boolean ok = MessageDialog
            .openConfirm(
                getWorkbench().getDisplay().getActiveShell(),
                "Resource Deleted",
                "The selected resource "
                    + alias.getName()
                    + " has been renamed or deleted but\n"
                    + "one or more child queries have been modified.  Press 'OK' to continue or 'Cancel' \nto keep your changes ");
        if (!ok) {
          disconnectChildren(conn);
          return;
        }
      }
      try {
        alias.remove(false, true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      Date now = new Date();
      DBManager.getInstance().copyProperties(oldConnection, rez, false);
      oldConnection.setLastUpdated(now);
      DBManager.touchChildren(oldConnection, now);

    }
    AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(SafiServerPlugin.getDefault().isConnected());

  }

  public void updateDBResource(Query query) {
    if (query.getLastUpdated() == null)
      return;

    DBResource rez = null;
    try {
      rez = DBManager.getInstance().updateDBResource(safiDriverManager, query);
    } catch (DBManagerException e) {
      e.printStackTrace();
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Update Error",
          "Couldn't update Query: " + e.getLocalizedMessage());
      AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't update Query", e);
      return;
    }
    if (rez == query) {
      MessageDialog.openInformation(getWorkbench().getDisplay().getActiveShell(), "No changes",
          "There have been no changes to the selected resource");
      return;
    }
    if (rez == null) {
      EcoreUtil.remove(query);
    } else if (rez != query) {
      EcoreUtil.replace(query, rez);
      Date now = new Date();
      // ((Query) rez).setLastModified(now);
      ((Query) rez).setLastUpdated(now);
      DBManager.touchChildren(rez, now);
    }

    AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(SafiServerPlugin.getDefault().isConnected());

  }

  @SuppressWarnings("unchecked")
  public void updateDBResource(ManagedDriver md) {
    DBDriver oldDriver = md.getDriver();
    if (oldDriver.getLastUpdated() == null)
      return;
    DBResource newVersion = null;
    try {
      newVersion = DBManager.getInstance().updateDBResource(safiDriverManager, oldDriver);
    } catch (DBManagerException e) {
      e.printStackTrace();
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Update Error",
          "Couldn't update DB Driver: " + e.getLocalizedMessage());
      AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't update Driver", e);
      return;
    }
    if (oldDriver == newVersion) {
      MessageDialog.openInformation(getWorkbench().getDisplay().getActiveShell(), "No changes",
          "There have been no changes to the selected resource");
      return;
    }
    if (newVersion == null) {
      boolean isModified = false;
      for (DBConnection conn : oldDriver.getConnections()) {
        if (conn.getLastUpdated() == null
            || conn.getLastModified().compareTo(conn.getLastUpdated()) >= 0) {
          isModified = true;
          break;
        }
      }
      if (isModified) {
        boolean ok = MessageDialog
            .openConfirm(
                getWorkbench().getDisplay().getActiveShell(),
                "Resource Deleted",
                "The selected resource "
                    + md.getId()
                    + " has been renamed or deleted but\n"
                    + "one or more child connections have been modified.  Press 'OK' to continue or 'Cancel' \nto keep your changes ");
        if (!ok) {
          disconnectChildren(oldDriver);
          return;
        }
      }

      // try {
      // removes the driver from the Safi Model AND DbNav model
      SQLExplorerPlugin.getDefault().getDriverModel().removeDriver(md);
      // } catch (Exception e) {
      // e.printStackTrace();
      // }
    } else if (newVersion != oldDriver) {
      ArrayList<Alias> existingAliases = new ArrayList<Alias>();
      for (Alias a : SQLExplorerPlugin.getDefault().getAliasManager().getAliases()) {
        if (md.equals(a.getDriver()))
          existingAliases.add(a);
      }
      DBDriver newDriver = (DBDriver) newVersion;
      try {
        DBManager.getInstance().copyProperties(oldDriver, newDriver, false);
      } catch (DBManagerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        MessageDialog.openError(getWorkbench().getDisplay().getActiveShell(), "Name Conflict", e
            .getLocalizedMessage());
      }
      Date now = new Date();

      // newDriver.setLastModified(now);
      // newDriver.setLastUpdated(now);
      oldDriver.setLastUpdated(now);
      DBManager.touchChildren(oldDriver, now);
      // ArrayList<Integer> locals = new ArrayList<Integer>();
      // ArrayList<Alias> cloned = (ArrayList<Alias>) existingAliases.clone();
      // for (Alias a : cloned) {
      // DBConnection conn = (DBConnection) a.getConnection();
      // if (conn.getLastUpdated() == null || conn.getId() == -1) {
      // existingAliases.remove(a);
      // }
      // else {
      // locals.add(conn.getId());
      // }
      // }
      //      
      //      
      // SQLExplorerPlugin.getDefault().getAliasManager().removeAll(existingAliases,
      // false);
      // DBManager.getInstance().copyProperties(oldDriver, newDriver, false);
      // for (DBConnection conn : newDriver.getConnections()){
      // int id = conn.getId();
      // if (locals.contains(id)){
      // Alias a = new Alias(conn);
      // }
      // }
      // // replace the old DBDriver with the new on in the EObject tree
      // // EcoreUtil.replace(md.getDriver(), newDriver);
      // // SQLExplorerPlugin.getDefault().getAliasManager().removeAll(existingAliases,
      // false);
      // // set the new DBDriver
      // // md.setDriver(newDriver);
      // // SQLExplorerPlugin.getDefault().getDriverModel().addDriver(md, false);
      // for (Alias a : existingAliases) {
      //        
      // DBConnection connection = newDriver.getConnection(a.getName());
      // if (connection != null){
      // oldDriver.getConnections().add(connection);
      // SQLExplorerPlugin.getDefault().getAliasManager().addAlias(a, false);
      // }
      //        
      // }
      // SQLExplorerPlugin.getDefault().getAliasManager().removeAll(existingAliases,
      // false);
      // List<DBConnection> copied = new
      // ArrayList<DBConnection>(newDriver.getConnections());
      // for (DBConnection c : copied) {
      // if (!locals.contains(c.getId())){
      // newDriver.getConnections().remove(c);
      // continue;
      // }
      // c.setLastUpdated(now);
      //        
      // try {
      // Alias alias = new Alias(c);
      // SQLExplorerPlugin.getDefault().getAliasManager().addAlias(alias, false);
      // } catch (ExplorerException e) {
      // e.printStackTrace();
      // }
      // for (Query q : c.getQueries()) {
      // q.setLastUpdated(now);
      //  
      // }
      // }
      // EcoreUtil.replace(oldDriver, newVersion);
    }

    AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(SafiServerPlugin.getDefault().isConnected());

  }

  private void disconnectChildren(DBDriver oldDriver) {
    oldDriver.setId(-1);
    oldDriver.setLastUpdated(null);
    for (DBConnection c : oldDriver.getConnections()) {
      disconnectChildren(c);
    }
  }

  private void disconnectChildren(DBConnection c) {
    for (Query a : c.getQueries()) {
      for (QueryParameter p : a.getParameters()) {
        p.setId(-1);
        p.setLastUpdated(null);
      }
      a.setId(-1);
      a.setLastUpdated(null);
    }
    c.setId(-1);
    c.setLastUpdated(null);
  }

  // public void updateDBResource(DriverManager manager) {
  // SafiDriverManager newManager = null;
  // try {
  // newManager = (SafiDriverManager)
  // DBManager.getInstance().updateDBResource(safiDriverManager,
  // safiDriverManager);
  // } catch (DBManagerException e) {
  // e.printStackTrace();
  // MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
  // "Update Error", "Couldn't update Resource: " + e.getLocalizedMessage());
  // AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't update Query", e);
  // return;
  // }
  // if (newManager == safiDriverManager) {
  // MessageDialog.openInformation(getWorkbench().getDisplay().getActiveShell(),
  // "No changes",
  // "There have been no changes to the selected resource");
  // return;
  // }
  // List<DBDriver> drivers = new ArrayList<DBDriver>(safiDriverManager.getDrivers());
  // for (DBDriver d : drivers) {
  // if (d.getLastUpdated() != null) {
  // EcoreUtil.remove(d);
  // }
  // }
  // drivers = new ArrayList<DBDriver>(newManager.getDrivers());
  // Date now = new Date();
  // for (DBDriver d : drivers) {
  // // d.setLastModified(now);
  // d.setLastUpdated(now);
  // safiDriverManager.getDrivers().add(d);
  // }
  // try {
  // manager.loadDrivers(true);
  // } catch (ExplorerException e) {
  // e.printStackTrace();
  // }
  // // AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged();
  // }

  public void updateDBResource(DriverManager manager) {
    for (ManagedDriver d : manager.getDrivers()) {
      updateDBResource(d);
    }
  }

  public boolean saveDBResource(Alias alias) {
    if (safiDriverManager != null)
      try {

        saveDBResourceHelper(alias.getConnection());
        SQLExplorerPlugin.getDefault().saveDBResources(false);
        AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(SafiServerPlugin.getDefault().isConnected());
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        if (e instanceof ResourceModifiedException)
          return false;

        MessageDialog.openError(Display.getDefault().getActiveShell(), "Save Error",
            "Couldn't write DB resource file: " + e.getLocalizedMessage());
        return false;
      }
    return true;

  }

  public boolean saveDBResource(DriverManager alias) {
    if (safiDriverManager != null)
      try {
        saveDBResourceHelper(safiDriverManager);
        SQLExplorerPlugin.getDefault().saveDBResources(false);
        AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(SafiServerPlugin.getDefault().isConnected());
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        if (e instanceof ResourceModifiedException)
          return false;

        MessageDialog.openError(Display.getDefault().getActiveShell(), "Save Error",
            "Couldn't write DB resource file: " + e.getLocalizedMessage());
        return false;
      }
    return true;
  }

  public boolean saveDBResource(ManagedDriver driver) {
    if (safiDriverManager != null)
      try {

        saveDBResourceHelper(driver.getDriver());
        SQLExplorerPlugin.getDefault().saveDBResources(false);
        AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(SafiServerPlugin.getDefault().isConnected());
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        if (e instanceof ResourceModifiedException)
          return false;
        MessageDialog.openError(Display.getDefault().getActiveShell(), "Save Error",
            "Couldn't write DB resource file: " + e.getLocalizedMessage());
        return false;
      }
    return true;
  }

  public boolean saveDBResource(Query query) {
    if (safiDriverManager != null)
      try {
        saveDBResourceHelper(query);
        SQLExplorerPlugin.getDefault().saveDBResources(false);
        AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(SafiServerPlugin.getDefault().isConnected());
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        if (e instanceof ResourceModifiedException)
          return false;
        MessageDialog.openError(Display.getDefault().getActiveShell(), "Save Error",
            "Couldn't write DB resource file: " + e.getLocalizedMessage());
        return false;
      }
    return true;
  }

  private void saveDBResourceHelper(DBResource resource) throws IOException, DBResourceException,
      ResourceModifiedException, DBManagerException {

    try {
      DBManager.getInstance().saveDBResourceHierarchy(resource);
    } catch (ResourceModifiedException e) {
      boolean ok = MessageDialog.openConfirm(getWorkbench().getDisplay().getActiveShell(),
          "Resource Modified", e.getLocalizedMessage() + ".\nWould you like to commit anyway?");
      if (ok) {
        resource.setLastUpdated(resource.getLastModified());
        DBManager.getInstance().saveDBResourceHierarchy(resource);
      } else
        throw e;
    }
  }

  public void deleteDBResource(DBResource resource) throws IOException, DBResourceException,
      ResourceModifiedException, DBManagerException {

    try {
      DBManager.getInstance().deleteDBResource(resource);
    } catch (ResourceModifiedException e) {
      boolean ok = MessageDialog.openConfirm(getWorkbench().getDisplay().getActiveShell(),
          "Resource Modified", e.getLocalizedMessage() + ".\nWould you like to commit anyway?");
      if (ok) {
        resource.setLastUpdated(resource.getLastModified());
        DBManager.getInstance().deleteDBResource(resource);
      } else
        throw e;
    }
  }
}
