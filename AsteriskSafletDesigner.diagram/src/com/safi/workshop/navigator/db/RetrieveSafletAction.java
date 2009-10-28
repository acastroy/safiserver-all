package com.safi.workshop.navigator.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Shell;

import com.safi.db.manager.EntitlementUtils;
import com.safi.db.server.config.Saflet;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.util.SafletPersistenceManager;

public class RetrieveSafletAction extends ServerResourceAction {

  private List<String> selectedSaflets = Collections.EMPTY_LIST;

  public RetrieveSafletAction() {
    // TODO Auto-generated constructor stub

  }

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
    if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_RETRIEVE_SAFLETS)) {
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
          "You do not have sufficient privileges to carry out this operation.");
      return;
    }
    Shell shell = AsteriskDiagramEditorUtil.getActiveShell();
    try {

      // SelectSafletDialog dialog = new SelectSafletDialog(shell,
      // SafletPersistenceManager
      // .getInstance().getAllProjects(), SelectSafletDialog.Mode.IMPORT);
      // dialog.setBlockOnOpen(true);
      // if (org.eclipse.jface.dialogs.Dialog.OK == dialog.open()) {
      // List<ServerResource> res = dialog.getCheckedItems();
      List<ServerResource> res = SelectSafletPanel.openSelectDialog(shell, SafletPersistenceManager
          .getInstance().getAllProjects(), null, SelectSafletPanel.Mode.IMPORT, selectedSaflets);
      if (res != null) {

        IWorkspace ws = ResourcesPlugin.getWorkspace();
        IProject[] projects = ws.getRoot().getProjects();
        List<IProject> plist = new ArrayList<IProject>(Arrays.asList(projects));
        // QualifiedName qn = new QualifiedName(AsteriskDiagramEditorPlugin.ID,
        // PersistenceProperties.RES_ID);

        List<Saflet> saflets = new ArrayList<Saflet>();
        Map<SafletProject, IProject> projectToResourceMap = new HashMap<SafletProject, IProject>();

        SafletPersistenceManager.getInstance().prepareProjects(shell, res, projectToResourceMap,
            plist);

        for (ServerResource sr : res) {
          if (sr instanceof Saflet) {
            saflets.add((Saflet) sr);
          }
        }
        Map<IProject, List<Saflet>> perProjectMap = new HashMap<IProject, List<Saflet>>();
        for (Saflet saflet : saflets) {
          SafletProject proj = saflet.getProject();
          IProject p = projectToResourceMap.get(proj);
          if (p != null) {
            List<Saflet> sl = perProjectMap.get(p);
            if (sl == null) {
              sl = new ArrayList<Saflet>();
              perProjectMap.put(p, sl);
            }
            sl.add(saflet);
          }
        }

        for (Map.Entry<IProject, List<Saflet>> entry : perProjectMap.entrySet()) {
          SafletPersistenceManager.getInstance().addOrUpdateSaflets(entry.getKey(),
              entry.getValue(), true, false);
        }
      }
    } catch (Exception e) {
      MessageDialog.openError(shell, "Retrieval Error", "Couldn't retrieve all Saflets: "
          + e.getLocalizedMessage());
      AsteriskDiagramEditorPlugin.getInstance().logError("Retriev Saflet Error", e);
    }
    AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {

  }

  public List<String> getSelectedSaflets() {
    return selectedSaflets;
  }

  public void setSelectedSaflets(List<String> selectedSaflets) {
    this.selectedSaflets = selectedSaflets;
  }

}
