/*
 * Copyright (C) 2006 SQL Explorer Development Team
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
package com.safi.workshop.sqlexplorer.connections.actions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.hibernate.Session;
import com.safi.db.DBConnection;
import com.safi.db.DBResource;
import com.safi.db.Query;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.ServerResource;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.DBManager;
import com.safi.server.saflet.manager.EntitlementUtils;
import com.safi.workshop.SafiNavigator;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.util.SafletPersistenceManager;

/**
 * Deletes a selected item; as of 3.5.0.beta2, this is a generic "delete", not just
 * specific to Aliases, hence the change in name
 * 
 * @author Davy Vanherbergen
 */
public class DeleteAction extends AbstractConnectionTreeAction {

  public DeleteAction() {
    super("ConnectionsView.Actions.Delete", "ConnectionsView.Actions.DeleteToolTip",
        "Images.Delete");
  }

  @Override
  public void run() {
    SafiNavigator nav = AsteriskDiagramEditorUtil.getSafiNavigator();
    IStructuredSelection viewerSelection = nav.getViewerSelection();
    if (viewerSelection.isEmpty())
      return;

    boolean okToDelete = MessageDialog.openConfirm(Display.getCurrent().getActiveShell(),
        "Delete Resource", "Are you sure you  want to delete the selected resource?");

    if (!okToDelete)
      return;

    List<IResource> resources = new ArrayList<IResource>();
    List<Object> dbResources = new ArrayList<Object>();
    List<ServerResource> serverResources = new ArrayList<ServerResource>();
    for (Object selected : viewerSelection.toArray()) {
      if(selected instanceof ManagedDriver){
    	  
    	  MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
    		        "Delete Driver rejected", "You can not delete Driver Resource.");
    	  return;
     
      }
      if (selected instanceof DBResource || selected instanceof User || selected instanceof Alias
          /*|| selected instanceof ManagedDriver*/){
        dbResources.add(selected);
      }
      else if (selected instanceof IResource)
        resources.add((IResource) selected);
      else if (selected instanceof ServerResource)
        serverResources.add((ServerResource) selected);
    }

    if (!resources.isEmpty()) {
      if (SafiServerPlugin.getDefault().isConnected()) {
        boolean foundPersisted = false;
        for (IResource res : resources) {
          try {
            int id = SafletPersistenceManager.getInstance().getResourceId(res);
            if (id >= 0) {
              foundPersisted = true;
              break;
            }
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
        if (foundPersisted)
          MessageDialog
              .openInformation(
                  Display.getCurrent().getActiveShell(),
                  "Delete Local Only",
                  "This operation will delete only local copies of any selected Saflets or SafiProjects.  "
                      + " If you wish to delete them from the production SafiServer open the Delete Saflet dialog from the main toolbar.");
      }
      com.safi.workshop.navigator.DeleteResourceAction ac = new com.safi.workshop.navigator.DeleteResourceAction();
      ac.selectionChanged(viewerSelection);
      ac.run();
    }
    if (!dbResources.isEmpty()) {
      int deletePref = 1;
      com.safi.db.server.config.User user = SafiServerPlugin.getDefault().getCurrentUser();
      boolean isConnected = SafiServerPlugin.getDefault().isConnected();
      
      if (isConnected && !EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_PUBLISH_DB_RESOURCES)) {
        MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
            "You do not have sufficient privileges to carry out this operation.");
        return;
      }
      removeDBResourceChildren(dbResources);
      
      // if (SafiServerPlugin.getDefault().isConnected())
      // deleteFromServer =
      // MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
      // "Delete From Server?",
      // "Do you want to delete database resource(s) from the production SafiServer?");
      for (Object o : dbResources) {
        if (o instanceof Alias) {
          Alias alias = (Alias) o;
          DBConnection conn = alias.getConnection();
          List<Query> queries = new ArrayList<Query>(conn.getQueries());

          alias.getConnection().setLastModified(new Date());
          if (deletePref != 2 && deletePref != 3 && isConnected
              && alias.getConnection().getId() != -1) {
            MessageDialog dialog = new MessageDialog(AsteriskDiagramEditorUtil.getActiveShell(),
                "Delete From Server?", null, "Do you want to delete database connection "
                    + alias.getName() + " from the production SafiServer?", SWT.ICON_QUESTION,
                new String[] { "YES", "NO", "YES TO ALL", "NO TO ALL", "CANCEL" }, 1);
            deletePref = dialog.open();
            if (deletePref == 4)
              return;
          }
          try {
            alias.remove(deletePref == 0 || deletePref == 2, true);
          } catch (Exception e) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Delete Failed",
                "Couldn't delete alias " + alias.getName() + ": " + e.getLocalizedMessage());
            AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't delete alias", e);
          }
          for (Query query : queries) {
            AsteriskDiagramEditorUtil.closeSQLEditors(query);
          }
        } else if (o instanceof Query) {
          Query query = (Query) o;
          if (deletePref != 2 && deletePref != 3 && isConnected && query.getId() != -1) {
            MessageDialog dialog = new MessageDialog(AsteriskDiagramEditorUtil.getActiveShell(),
                "Delete From Server?", null, "Do you want to delete database query "
                    + query.getName() + " from the production SafiServer?", SWT.ICON_QUESTION,
                new String[] { "YES", "NO", "YES TO ALL", "NO TO ALL", "CANCEL" }, 1);
            deletePref = dialog.open();
            if (deletePref == 4)
              return;
          }
          if (deletePref == 0 || deletePref == 2) {
            
            try {
              SQLExplorerPlugin.getDefault().deleteDBResource(query);
            } catch (Exception e) {
              MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Delete Failed",
                  "Couldn't delete query " + query.getName() + ": " + e.getLocalizedMessage());
              AsteriskDiagramEditorPlugin.getInstance().logError(
                  "Couldn't delete query " + query.getName(), e);
            }
          }
          query.getConnection().setLastModified(new Date()); 
          query.getConnection().getQueries().remove(query);
          AsteriskDiagramEditorUtil.closeSQLEditors(query);
        } else if (o instanceof ManagedDriver) {
          ManagedDriver driver = (ManagedDriver) o;
          if (driver.getDriver() != null && !driver.getDriver().isDefault()) {
            if (deletePref != 2 && deletePref != 3 && isConnected
                && driver.getDriver().getId() != -1) {
              MessageDialog dialog = new MessageDialog(AsteriskDiagramEditorUtil.getActiveShell(),
                  "Delete From Server?", null, "Do you want to delete database driver "
                      + driver.getDriver().getName() + " from the production SafiServer?",
                  SWT.ICON_QUESTION, new String[] { "YES", "NO", "YES TO ALL", "NO TO ALL",
                      "CANCEL" }, 1);
              deletePref = dialog.open();
              if (deletePref == 4)
                return;
            }
            if (deletePref == 0 || deletePref == 1) {
              try {
                SQLExplorerPlugin.getDefault().deleteDBResource(driver.getDriver());
              } catch (Exception e) {
                MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
                    "Delete Failed", "Couldn't delete query " + driver.getDriver().getName() + ": "
                        + e.getLocalizedMessage());
                AsteriskDiagramEditorPlugin.getInstance().logError(
                    "Couldn't delete query " + driver.getDriver().getName(), e);
              }
            }
            SQLExplorerPlugin.getDefault().getDriverModel().removeDriver(driver);
          }
        }
      }
      SQLExplorerPlugin.getDefault().saveDBResources(false);
    }

    if (!serverResources.isEmpty()) {
      com.safi.db.server.config.User user = SafiServerPlugin.getDefault().getCurrentUser();

      List<ServerResource> deleted = new ArrayList<ServerResource>();
      SafiServer production = null;
      try {
        production = SafiServerPlugin.getDefault().getSafiServer(true);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      if (production != null) {
        removeChildren(serverResources);
        boolean checkedAsterisk = false;
        boolean checkedUsers = false;
        for (ServerResource r : serverResources) {
          if (r instanceof AsteriskServer) {
            if (!checkedAsterisk) {
              if (!EntitlementUtils.isUserEntitled(user,
                  EntitlementUtils.ENTIT_MANAGE_ASTERISK_SERVERS)) {
                MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                    "You do not have sufficient privileges to carry out this operation.");
                return;
              } else
                checkedAsterisk = true;
            }
            if (!production.getAsteriskServers().remove(r)) {
              MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Can't Delete",
                  "An error has occurred. The Asterisk server instance could not be deleted");
              continue;
            } else
              deleted.add(r);
          } else if (r instanceof com.safi.db.server.config.User) {
            if (!checkedUsers) {
              if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_MANAGE_USERS)) {
                MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                    "You do not have sufficient privileges to carry out this operation.");
                return;
              } else
                checkedUsers = true;
            }

            if (r.getId() == SafiServerPlugin.getDefault().getCurrentUser().getId()) {
              MessageDialog.openInformation(Display.getCurrent().getActiveShell(),
                  "Can't Delete Self", "The currently logged in user cannot be deleted.");
              continue;
            } else {
              production.getUsers().remove(r);
              deleted.add(r);
            }
          }

        }
      } else {
        MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Can't Delete",
            "An error has occurred.  No SafiServer instance could be found.");
        return;
      }
      deleteServerResources(production, deleted);

    }

    if (dbResources.isEmpty() && serverResources.isEmpty())
      nav.refresh();
    else {
    	try {
  			SafiServerPlugin.getDefault().updateServerResources(new NullProgressMonitor());
  		} catch (Exception e) {
  			e.printStackTrace();
  			MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Database Error",
  			    "Couldn't refresh from production SafiServer: " + e.getLocalizedMessage());
  			return;
  		}
//      nav.modelChanged(SafiServerPlugin.getDefault().isConnected());
    }

    // if (!viewerSelection.isEmpty() && viewerSelection.getFirstElement() instanceof
    // IResource){
    // DeleteResourceAction action = new
    // DeleteResourceAction(Display.getCurrent().getActiveShell());
    // action.selectionChanged(viewerSelection);
    // action.run();
    // return;
    // }
    //    
    //
    //    
    // boolean deleteFromServer = false;
    // if (SafiServerPlugin.getDefault().hasProductionServerInfo())
    // deleteFromServer =
    // MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
    // "Delete From Server?", "Do you want to delete from the production SafiServer?");
    // boolean needsToSave = false;
    //    
    // Set<User> selectedUsers = nav.getSelectedUsers(false);
    // Date now = new Date();
    // for (User user : selectedUsers) {
    // user.getAlias().removeUser(user);
    // user.getAlias().getConnection().setLastModified(now);
    // }
    // if (!selectedUsers.isEmpty()) {
    // needsToSave = true;
    // }
    // Set<Alias> selectedAliases = nav.getSelectedAliases(false);
    // for (Alias alias : selectedAliases) {
    // alias.getConnection().setLastModified(now);
    // try {
    // alias.remove(deleteFromServer, true);
    // } catch (Exception e) {
    // MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
    // "Delete Failed", "Couldn't delete alias " + alias.getName() + ": "
    // + e.getLocalizedMessage());
    // AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't delete alias", e);
    // return;
    // }
    // }
    // if (!selectedAliases.isEmpty())
    // needsToSave = true;
    // Set<Query> selectedQueries = nav.getSelectedQueries(false);
    // for (Query query : selectedQueries) {
    // if (deleteFromServer) {
    // query.getConnection().setLastModified(now);
    // try {
    // SQLExplorerPlugin.getDefault().deleteDBResource(query);
    // } catch (Exception e) {
    // MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
    // "Delete Failed", "Couldn't delete query " + query.getName() + ": "
    // + e.getLocalizedMessage());
    // AsteriskDiagramEditorPlugin.getInstance().logError(
    // "Couldn't delete query " + query.getName(), e);
    // }
    // }
    // query.getConnection().getQueries().remove(query);
    // }
    // if (!selectedQueries.isEmpty())
    // needsToSave = true;
    //
    // Set<ManagedDriver> selectedDrivers = nav.getSelectedDrivers(false);
    // if (selectedDrivers != null && !selectedDrivers.isEmpty()) {
    // for (ManagedDriver driver : selectedDrivers) {
    // if (driver.getDriver() != null && !driver.getDriver().isDefault()) {
    // if (deleteFromServer) {
    // try {
    // SQLExplorerPlugin.getDefault().deleteDBResource(driver.getDriver());
    // } catch (Exception e) {
    // MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(),
    // "Delete Failed", "Couldn't delete query "
    // + driver.getDriver().getName() + ": " + e.getLocalizedMessage());
    // AsteriskDiagramEditorPlugin.getInstance().logError(
    // "Couldn't delete query " + driver.getDriver().getName(), e);
    // }
    // }
    // SQLExplorerPlugin.getDefault().getDriverModel().removeDriver(driver);
    // needsToSave = true;
    // }
    // }
    // }
    //
    // if (needsToSave) {
    // SQLExplorerPlugin.getDefault().saveDBResources(false);
    // nav.modelChanged();
    // return;
    // }
    // nav.refresh();
  }

  private void deleteServerResources(SafiServer production, List<ServerResource> deleted) {
    Session session = null;
    try {
    	
      session = DBManager.getInstance().createSession();
      
      for (ServerResource s : deleted) {
      	DBManager.getInstance().deleteServerResource(session, s);
//        session.delete(s);
      }
      DBManager.getInstance().saveOrUpdateServerResource(session, production);
//      session.beginTransaction();
//      session.saveOrUpdate(production);
//      session.getTransaction().commit();

    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Delete Server Error",
          "An error occurred while deleting SafiServer resources: " + e.getLocalizedMessage());
    } finally {
      try {
        if (session != null) {
          session.close();
          session = null;
        }
      } catch (Exception ex) {

      }
    }

  }

  /**
   * Only show action when there is at least 1 alias selected
   * 
   * @see com.safi.workshop.sqlexplorer.connections.actions.AbstractConnectionTreeAction#isAvailable()
   */
  @Override
  public boolean isAvailable() {
    SafiNavigator nav = AsteriskDiagramEditorUtil.getSafiNavigator();
    IStructuredSelection viewerSelection = nav.getViewerSelection();
    if (viewerSelection == null || viewerSelection.isEmpty())
      return false;

    for (Object o : viewerSelection.toArray()) {
      if (!(o instanceof Alias || o instanceof ManagedDriver || o instanceof ServerResource
          || o instanceof DBResource || o instanceof IResource))
        return false;

    }
    // if (getView() == null)
    // return false;
    // Set<Alias> aliases = getView().getSelectedAliases(false);
    // Set<User> users = getView().getSelectedUsers(false);
    // Set<Query> queries = getView().getSelectedQueries(false);
    // if (aliases.isEmpty() && users.isEmpty() && queries.isEmpty())
    // return false;
    // for (User user : users)
    // if (user.getAlias().hasNoUserName())
    // return false;
    return true;
  }

  private void removeChildren(List<ServerResource> serverResources) {
    List<ServerResource> cloned = new ArrayList<ServerResource>(serverResources);
    for (ServerResource ancestor : cloned) {
      for (ServerResource parent : cloned) {
        if (parent != ancestor && EcoreUtil.isAncestor(parent, ancestor)) {
          serverResources.remove(ancestor);
          break;
        }
      }
    }
  }

  private EObject getEObject(Object o) {
    if (o instanceof Alias)
      return ((Alias) o).getConnection();
    if (o instanceof ManagedDriver)
      return ((ManagedDriver) o).getDriver();
    if (o instanceof EObject)
      return (EObject) o;
    return null;
  }

  private void removeDBResourceChildren(List<Object> dbResources) {
    List<Object> cloned = new ArrayList<Object>(dbResources);
    for (Object o : cloned) {
      EObject ancestor = getEObject(o);
      for (Object o2 : cloned) {
        EObject parent = getEObject(o2);
        if (parent != ancestor && EcoreUtil.isAncestor(parent, ancestor)) {
          dbResources.remove(o);
          break;
        }
      }
    }
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return super.isEnabled();
  }

}
