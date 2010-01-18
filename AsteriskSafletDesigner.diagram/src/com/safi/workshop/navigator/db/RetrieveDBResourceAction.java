package com.safi.workshop.navigator.db;

import java.util.Date;
import java.util.List;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.hibernate.HibernateException;
import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.DBResource;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.db.SafiDriverManager;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.DBManager;
import com.safi.server.saflet.manager.DBManagerException;
import com.safi.server.saflet.manager.DBResourceException;
import com.safi.server.saflet.manager.EntitlementUtils;
import com.safi.server.saflet.manager.ResourceModifiedException;
import com.safi.workshop.SafiNavigator;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

public class RetrieveDBResourceAction extends ServerResourceAction {

  private List<DBResource> dbResources;

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
    if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_DB_RESOURCES)) {
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
      // .getActiveShell(), manager, SelectDBResourceDialog.Mode.RETRIEVE);
      // int result = dlg.open();
      // if (result == Dialog.CANCEL)
      // return;
      // List<DBResource> items = dlg.getCheckedItems();

      if (dbResources == null)
        dbResources = SelectDBResourcesPanel.openSelectDialog(AsteriskDiagramEditorUtil
            .getActiveShell(), manager, SelectDBResourcesPanel.Mode.RETRIEVE);
      if (dbResources == null)
        return;
      importDBResources(dbResources);
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Retrieve Error",
          "Couldn't retrieve database resources: " + e.getLocalizedMessage());
    }
    AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(SafiServerPlugin.getDefault().isConnected());
  }

  public void importDBResources(List<DBResource> resources) throws ResourceModifiedException,
      DBManagerException, DBResourceException, ExplorerException {
    // Session session = DBManager.getInstance().createSession();
    SafiDriverManager mgr = SafiServerPlugin.getDefault().getDriverManager();
    try {
      boolean yesToAll = false;
      Date now = new Date();
      for (DBResource resource : resources) {
        if (resource instanceof QueryParameter)
          continue;
        String id = DBManager.constuctDBResourceId(resource);
        if (id == null)
          continue;
        DBResource existingRez = DBManager.getInstance().getObjectFromPath(mgr, id);

        if (existingRez != null) {

          if (((existingRez.getId() == -1 && existingRez.getLastModified() != null) || (existingRez
              .getLastModified() != null
              && existingRez.getLastUpdated() != null && existingRez.getLastModified().after(
              existingRez.getLastUpdated())))) {

            if (!yesToAll) {
              MessageDialog dlg = new MessageDialog(AsteriskDiagramEditorUtil.getActiveShell(),
                  "Resource Modified", null, "The database resource " + existingRez.getName()
                      + " was modified.  Do you want to overwrite?", MessageDialog.QUESTION,
                  new String[] { "Yes", "No", "Yes to all" }, 1);
              int result = dlg.open();
              if (result == 1)
                continue;
              if (result == 2)
                yesToAll = true;
            }
          }
          boolean isQuery = resource instanceof Query;

          DBManager.getInstance().copyProperties(existingRez, resource, isQuery);
          existingRez.setLastUpdated(now);
          if (isQuery)
            DBManager.touchChildren(existingRez, now);
        } else {
          DBResource parent = DBManager.getInstance().setDBResourceByPath(mgr, resource, id);
          if (parent instanceof SafiDriverManager) {
            SQLExplorerPlugin.getDefault().getDriverModel().addDriver(
                new ManagedDriver((DBDriver) resource), false);
          } else if (parent instanceof DBDriver) {
            DBConnection dbConn = (DBConnection) resource;
            dbConn.setLastUpdated(now);
            SQLExplorerPlugin.getDefault().getAliasManager().addAlias(new Alias(dbConn), false);
          } else if (resource instanceof Query) {
            resource.setLastUpdated(now);
            DBManager.touchChildren(resource, now);
          }
          // else
          // if (parent instanceof DBConnection){
          // SQLExplorerPlugin.getDefault().getAliasManager().getAlias(((DBConnection)parent).getName()).addQuery((Query)resource);
          // }

        }
      }
    } catch (HibernateException e) {
      throw new DBManagerException(e);
    }

  }

  public List<DBResource> getDbResources() {
    return dbResources;
  }

  public void setDbResources(List<DBResource> dbResources) {
    this.dbResources = dbResources;
  }

}
