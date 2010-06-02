package com.safi.workshop.navigator.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.hibernate.HibernateException;

import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.DBResource;
import com.safi.db.Query;
import com.safi.db.SafiDriverManager;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.DBManager;
import com.safi.server.saflet.manager.DBManagerException;
import com.safi.server.saflet.manager.DBResourceException;
import com.safi.server.saflet.manager.EntitlementUtils;
import com.safi.server.saflet.manager.ResourceModifiedException;
import com.safi.workshop.SafiNavigator;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

public class DeleteDBResourceAction extends ServerResourceAction {

  @Override
  public void run(IAction action) {
    if (!SafiServerPlugin.getDefault().isConnected()) {
      MessageDialog
          .openError(
              AsteriskDiagramEditorUtil.getActiveShell(),
              "Not Connected",
              "You must be connected to a production SafiServer to complete this operation.  Please connection to a SafiServer instance first");
      return;
    }
    User user = SafiServerPlugin.getDefault().getCurrentUser();
    if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_PUBLISH_DB_RESOURCES)) {
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
          "You do not have sufficient privileges to carry out this operation.");
      return;
    }
    SafiNavigator nav = AsteriskDiagramEditorUtil.getSafiNavigator(false);
    if (nav == null)
      return;
    try {

      SafiDriverManager manager = DBManager.getInstance().getDriverManagerFromDB();
      // SelectDBResourceDialog dlg = new SelectDBResourceDialog(AsteriskDiagramEditorUtil
      // .getActiveShell(), manager, SelectDBResourceDialog.Mode.DELETE);
      // int result = dlg.open();
      // if (result == Dialog.CANCEL)
      // return;
      // List<DBResource> items = dlg.getCheckedItems();
      List<DBResource> items = SelectDBResourcesPanel.openSelectDialog(AsteriskDiagramEditorUtil
          .getActiveShell(), manager, SelectDBResourcesPanel.Mode.DELETE);
      if (items == null)
        return;
      deleteDBResources(items);
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Retrieve Error",
          "Couldn't retrieve database resources: " + e.getLocalizedMessage());
    }
    AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(SafiServerPlugin.getDefault().isConnected());
  }

  public void deleteDBResources(List<DBResource> resources) throws ResourceModifiedException,
      DBManagerException, DBResourceException, ExplorerException {
    // Session session = DBManager.getInstance().createSession();
    SafiDriverManager mgr = SafiServerPlugin.getDefault().getDriverManager();
    try {
      removeDBResourceChildren(resources);
      for (DBResource res : resources) {

        if (res instanceof DBConnection) {
          DBConnection conn = (DBConnection) res;
          List<Query> queries = new ArrayList<Query>(conn.getQueries());
          Alias alias = SQLExplorerPlugin.getDefault().getAliasManager().getAlias(conn.getId());
          if (alias == null) {
            try {
              DBManager.getInstance().deleteDBResource(res);
            } catch (Exception e) {
              MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Delete Failed",
                  "Couldn't delete alias " + alias.getName() + ": " + e.getLocalizedMessage());
              AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't delete alias", e);
            }
          } else {
            alias.getConnection().setLastModified(new Date());
            try {
              alias.remove(true, true);
            } catch (Exception e) {
              MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Delete Failed",
                  "Couldn't delete alias " + alias.getName() + ": " + e.getLocalizedMessage());
              AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't delete alias", e);
            }
          }
          for (Query query : queries) {
            AsteriskDiagramEditorUtil.closeSQLEditors(query);
          }
        } else if (res instanceof Query) {

          Query query = (Query) res;

          DBConnection conn = query.getConnection();
          Alias alias = SQLExplorerPlugin.getDefault().getAliasManager().getAlias(conn.getId());
          query.getConnection().setLastModified(new Date());
          try {
            SQLExplorerPlugin.getDefault().deleteDBResource(query);
          } catch (Exception e) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Delete Failed",
                "Couldn't delete query " + query.getName() + ": " + e.getLocalizedMessage());
            AsteriskDiagramEditorPlugin.getInstance().logError(
                "Couldn't delete query " + query.getName(), e);
          }
          AsteriskDiagramEditorUtil.closeSQLEditors(query);
          if (alias != null) {
            alias.removeQuery(query);
          }
          // query.getConnection().getQueries().remove(query);

        } else if (res instanceof DBDriver) {
          DBDriver drv = (DBDriver) res;
          ManagedDriver driver = SQLExplorerPlugin.getDefault().getDriverModel().getDriver(
              drv.getId());
          if (!drv.isDefault()) {
            if (driver != null) {
              SQLExplorerPlugin.getDefault().getDriverModel().removeDriver(driver);
            }
            try {
              SQLExplorerPlugin.getDefault().deleteDBResource(driver.getDriver());
            } catch (Exception e) {
              MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Delete Failed",
                  "Couldn't delete query " + driver.getDriver().getName() + ": "
                      + e.getLocalizedMessage());
              AsteriskDiagramEditorPlugin.getInstance().logError(
                  "Couldn't delete query " + driver.getDriver().getName(), e);
            }
          } else {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Delete Failed",
                "Default database drivers may not be deleted: " + res.getName());
          }
        }
      }
    } catch (HibernateException e) {
      throw new DBManagerException(e);
    }

  }

  private void removeDBResourceChildren(List<DBResource> dbResources) {
    List<DBResource> cloned = new ArrayList<DBResource>(dbResources);
    for (DBResource ancestor : cloned) {
      for (DBResource descendant : cloned) {
        if (ancestor != descendant && EcoreUtil.isAncestor(ancestor, descendant)) {
          dbResources.remove(descendant);
          break;
        }
      }
    }
  }

}
