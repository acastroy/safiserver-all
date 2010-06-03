package com.safi.workshop.navigator.db;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.safi.db.DBConnection;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.db.SafiDriverManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.AliasManager;
import com.safi.workshop.sqlexplorer.dbproduct.DriverManager;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.dbproduct.SQLConnection;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

public class DBResourcesContentProvider implements ITreeContentProvider, Adapter {

	private static final Object[] EMPTY_ARRAY = new Object[0];
  private SafiDriverManager dm;
  private static DBResourcesContentProvider instance;

  public static DBResourcesContentProvider getInstance() {
    return instance;
  }

  public DBResourcesContentProvider() {
    hookDriverManager();
    instance = this;
  }

  private void hookDriverManager() {
    SafiDriverManager d = SafiServerPlugin.getDefault().getDriverManager();
    if (dm != null)
      dm.eAdapters().remove(this);
    dm = d;
    if (dm != null)
      dm.eAdapters().add(this);
  }

  @Override
  public Object[] getChildren(Object parentElement) {
    if (parentElement instanceof DriverManager) {
      return ((DriverManager) parentElement).getDrivers().toArray();
    } else if (parentElement instanceof ManagedDriver) {
      List<Alias> l = new ArrayList<Alias>();
      for (Alias a : SQLExplorerPlugin.getDefault().getAliasManager().getAliases()) {
        if (parentElement.equals(a.getDriver())) {
          l.add(a);
        }
      }
      return l.toArray();
      // }
      // else if (parentElement instanceof AliasManager) {
      // AliasManager aliases = (AliasManager) parentElement;
      //
      // Object[] children = aliases.getAliases().toArray();
      // return children;

    } else if (parentElement instanceof Alias) {
      Alias alias = (Alias) parentElement;
      List<Object> l = new ArrayList<Object>();

      DBConnection connection = alias.getConnection();
      if (connection != null)
        l.addAll(connection.getQueries());

      l.addAll(alias.getUsers());
      return l.toArray();

    } else if (parentElement instanceof User) {
      User user = (User) parentElement;

      return user.getConnections().toArray();
    } else if (parentElement instanceof Query) {
      return ((Query) parentElement).getParameters().toArray();
    }

    
    return EMPTY_ARRAY;
  }

  @Override
  public Object getParent(Object element) {

    // // this is root node
    // if (element instanceof AliasManager)
    // return null;
    if (element instanceof DriverManager) {
      return ResourcesPlugin.getWorkspace().getRoot();
      // return null;
    } else if (element instanceof ManagedDriver)
      return SQLExplorerPlugin.getDefault().getDriverModel();
    else if (element instanceof Alias)
      return ((Alias) element).getDriver();
    // return alias
    // else if (element instanceof Alias)
    // return SQLExplorerPlugin.getDefault().getAliasManager();

    else if (element instanceof User)
      return ((User) element).getAlias();

    else if (element instanceof SQLConnection)
      return ((SQLConnection) element).getUser();

    else if (element instanceof QueryParameter) {
      return ((QueryParameter) element).getQuery();
    } else if (element instanceof Query) {
      DBConnection conn = ((Query) element).getConnection();
      AliasManager aliasManager = SQLExplorerPlugin.getDefault().getAliasManager();
      if (aliasManager != null && conn != null)
        return aliasManager.getAlias(conn.getName());
    }
    return null;
  }

  @Override
  public boolean hasChildren(Object element) {
    Object[] tmp = getChildren(element);

    return tmp != null && tmp.length != 0;
  }

  @Override
  public Object[] getElements(Object inputElement) {
    if (inputElement instanceof IWorkspaceRoot && SQLExplorerPlugin.getDefault() != null) {
      DriverManager driverModel = SQLExplorerPlugin.getDefault().getDriverModel();
      if (driverModel != null)
        return new Object[] { driverModel };
    }

    return EMPTY_ARRAY;
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    // if (newInput instanceof WorkspaceRoot){
    hookDriverManager();
    // }
  }

  @Override
  public Notifier getTarget() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isAdapterForType(Object type) {
    if (type instanceof com.safi.db.SafiDriverManager || type instanceof com.safi.db.DBDriver
        || type instanceof com.safi.db.DBConnection || type instanceof com.safi.db.Query
        || type instanceof com.safi.db.QueryParameter)
      return true;
    return false;
  }

  @Override
  public void notifyChanged(Notification notification) {
  }

  @Override
  public void setTarget(Notifier newTarget) {

  }

}
