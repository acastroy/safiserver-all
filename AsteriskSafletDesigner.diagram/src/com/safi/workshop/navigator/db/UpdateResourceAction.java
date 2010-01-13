package com.safi.workshop.navigator.db;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.DiagramUtil;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.StructuredSelection;
import com.safi.core.saflet.Saflet;
import com.safi.db.Query;
import com.safi.db.manager.DBManagerException;
import com.safi.db.manager.EntitlementUtils;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.SafiNavigator;
import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.util.SafletPersistenceManager;

public class UpdateResourceAction extends ServerResourceAction {

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

    SafiNavigator nav = AsteriskDiagramEditorUtil.getSafiNavigator(false);
    if (nav == null)
      return;

    if (!MessageDialog.openConfirm(AsteriskDiagramEditorUtil.getActiveShell(), "Confirm Update",
        "Are you sure you want to proceed with update? Update will overwrite existing resource.")) {
      return;
    }
    boolean dbResourceUpdated = false;
    if (cachedSelection instanceof StructuredSelection) {
      StructuredSelection selection = ((StructuredSelection) cachedSelection);
      for (Object o : selection.toList()) {

        // Object o = selection.getFirstElement();
        if (o instanceof Alias) {
          if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_DB_RESOURCES)) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                "You do not have sufficient privileges to carry out this operation.");
            return;
          }
          Alias alias = (Alias) o;
          // DBConnection dbRes = alias.getConnection();
          // boolean doSave = false;
          // if (dbRes.getLastModified() == null
          // || !dbRes.getLastModified().equals(dbRes.getLastUpdated()))
          // doSave = true;
          // else {
          // MessageDialog.
          // }
          try {
            SQLExplorerPlugin.getDefault().updateDBResource(alias);
            dbResourceUpdated = true;
          } catch (DBManagerException e) {
            e.printStackTrace();
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Update Error",
                "Couldn't update DBConnection: " + e.getLocalizedMessage());
            AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't update DBConnection", e);
            return;
          }
        } else if (o instanceof ManagedDriver) {
          if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_DB_RESOURCES)) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                "You do not have sufficient privileges to carry out this operation.");
            return;
          }
          ManagedDriver driver = (ManagedDriver) o;
          // DBDriver dbRes = driver.getDriver();
          // if (dbRes.getLastModified() == null
          // || !dbRes.getLastModified().equals(dbRes.getLastUpdated()))
          SQLExplorerPlugin.getDefault().updateDBResource(driver);
          dbResourceUpdated = true;
        } else if (o instanceof Query) {
          if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_DB_RESOURCES)) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                "You do not have sufficient privileges to carry out this operation.");
            return;
          }
          Query dbRes = (Query) o;
          // if (dbRes.getLastModified() == null
          // || !dbRes.getLastModified().equals(dbRes.getLastUpdated()))
          SQLExplorerPlugin.getDefault().updateDBResource(dbRes);
          dbResourceUpdated = true;
        } else if (o instanceof com.safi.workshop.sqlexplorer.dbproduct.DriverManager) {
          if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_DB_RESOURCES)) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                "You do not have sufficient privileges to carry out this operation.");
            return;
          }
          SQLExplorerPlugin.getDefault().updateDBResource(
              (com.safi.workshop.sqlexplorer.dbproduct.DriverManager) o);
          dbResourceUpdated = true;
        } else if ((o instanceof IResource) && (((IResource) o).getType() == IResource.FILE)
            && "saflet".equals(((IResource) o).getFileExtension())) {
          if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_SAFLETS)) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                "You do not have sufficient privileges to carry out this operation.");
            return;
          }
          IFile platformResource = (IFile) o;
          updateHandlerFromResource(platformResource);

        } else if (o instanceof HandlerEditPart) {
          if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_SAFLETS)) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                "You do not have sufficient privileges to carry out this operation.");
            return;
          }
          HandlerEditPart part = (HandlerEditPart) o;
          Saflet handler = part.getHandlerModel();
          Resource emfResource = handler.eResource();
          IFile platformResource = WorkspaceSynchronizer.getFile(emfResource);
          AsteriskDiagramEditor editor = (AsteriskDiagramEditor) DiagramUtil
              .getOpenedDiagramEditor(part.getDiagramView(), null);
          try {
            update(handler, emfResource, platformResource, editor);
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Update Error",
                "Couldn't update Saflet: " + e.getLocalizedMessage());
            AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't update Saflet", e);
          }
        } else if (o instanceof IProject) {
          if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_SAFLETS)) {
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                "You do not have sufficient privileges to carry out this operation.");
            return;
          }
          IProject project = (IProject) o;
          try {
            project.accept(new IResourceVisitor() {

              @Override
              public boolean visit(IResource resource) throws CoreException {
                if (resource.getType() == IResource.FILE
                    && "saflet".equals(resource.getFileExtension())) {
                  updateHandlerFromResource((IFile) resource);
                }
                return true;
              }
            });
            SafletPersistenceManager.getInstance().updateProject(project);
          } catch (Exception e) {
            e.printStackTrace();
            MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Update Error",
                "Couldn't update all project resources: " + e.getLocalizedMessage());
            AsteriskDiagramEditorPlugin.getInstance().logError("Update Project Error", e);
            return;
          }

        }
      }
      if (dbResourceUpdated)
        AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(true);
      else
        AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
    }

  }

}
