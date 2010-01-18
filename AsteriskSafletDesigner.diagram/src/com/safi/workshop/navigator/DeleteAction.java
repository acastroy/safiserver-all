package com.safi.workshop.navigator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import com.safi.db.DBResource;
import com.safi.db.Query;
import com.safi.db.server.config.ServerResource;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.EntitlementUtils;
import com.safi.workshop.SafiNavigator;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

public class DeleteAction extends Action implements IViewActionDelegate {

  public DeleteAction() {
    super("Delete");
  }

  @Override
  public void run(IAction a) {
    SafiNavigator nav = AsteriskDiagramEditorUtil.getSafiNavigator();
    IStructuredSelection viewerSelection = nav.getViewerSelection();
    if (viewerSelection.isEmpty())
      return;

    boolean okToDelete = MessageDialog.openConfirm(Display.getCurrent().getActiveShell(),
        "Delete Resource", "Are you sure you want to delete the selected resource?");

    if (!okToDelete)
      return;

    List<IResource> resources = new ArrayList<IResource>();
    List<Object> dbResources = new ArrayList<Object>();
    List<ServerResource> serverResources = new ArrayList<ServerResource>();
    for (Object selected : viewerSelection.toArray()) {
      if (selected instanceof DBResource || selected instanceof User || selected instanceof Alias
          || selected instanceof ManagedDriver)
        dbResources.add(selected);
      else if (selected instanceof IResource)
        resources.add((IResource) selected);
      else if (selected instanceof ServerResource)
        serverResources.add((ServerResource) selected);
    }

    if (!resources.isEmpty()) {
      if (SafiServerPlugin.getDefault().isConnected())
        MessageDialog
            .openInformation(
                Display.getCurrent().getActiveShell(),
                "Delete Local Only",
                "This operation will delete only local copies of any selected Saflets or SafiProjects.  "
                    + " If you wish to delete them from the production SafiServer open the Delete Saflet dialog from the main toolbar.");
      com.safi.workshop.navigator.DeleteResourceAction ac = new com.safi.workshop.navigator.DeleteResourceAction();
      ac.selectionChanged(viewerSelection);
      ac.run();
    }
    if (!dbResources.isEmpty()) {
      if (!SafiServerPlugin.getDefault().isConnected()) {
        MessageDialog
            .openError(
                AsteriskDiagramEditorUtil.getActiveShell(),
                "Not Connected",
                "You must be connected to a production SafiServer to complete this operation.  Please connection to a SafiServer instance first");
        return;
      }
      com.safi.db.server.config.User user = SafiServerPlugin.getDefault().getCurrentUser();
      if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_PUBLISH_DB_RESOURCES)) {
        MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
            "You do not have sufficient privileges to carry out this operation.");
        return;
      }
      int deletePref = -1;
      removeDBResourceChildren(dbResources);
      boolean isConnected = SafiServerPlugin.getDefault().isConnected();
      // if (SafiServerPlugin.getDefault().isConnected())
      // deleteFromServer =
      // MessageDialog.openQuestion(Display.getCurrent().getActiveShell(),
      // "Delete From Server?",
      // "Do you want to delete database resource(s) from the production SafiServer?");
      for (Object o : dbResources) {
        if (o instanceof Alias) {
          Alias alias = (Alias) o;
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
            alias.remove(deletePref == 0 || deletePref == 1, true);
          } catch (Exception e) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Delete Failed",
                "Couldn't delete alias " + alias.getName() + ": " + e.getLocalizedMessage());
            AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't delete alias", e);
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
          if (deletePref == 0 || deletePref == 1) {
            query.getConnection().setLastModified(new Date());
            try {
              SQLExplorerPlugin.getDefault().deleteDBResource(query);
            } catch (Exception e) {
              MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Delete Failed",
                  "Couldn't delete query " + query.getName() + ": " + e.getLocalizedMessage());
              AsteriskDiagramEditorPlugin.getInstance().logError(
                  "Couldn't delete query " + query.getName(), e);
            }
          }
          query.getConnection().getQueries().remove(query);

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
      removeChildren(serverResources);
      for (ServerResource r : serverResources) {

      }
    }

    if (dbResources.isEmpty())
      nav.refresh();
    else
      nav.modelChanged(SafiServerPlugin.getDefault().isConnected());

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

  private void removeChildren(List<ServerResource> serverResources) {
    List<ServerResource> cloned = new ArrayList<ServerResource>(serverResources);
    for (ServerResource ancestor : cloned) {
      for (ServerResource parent : cloned) {
        if (ancestor != parent && EcoreUtil.isAncestor(ancestor, parent)) {
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
        if (ancestor != parent && EcoreUtil.isAncestor(ancestor, parent)) {
          dbResources.remove(o);
          break;
        }
      }
    }
  }

  public void init(IViewPart view) {
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    action.setEnabled(true);

  }

}
