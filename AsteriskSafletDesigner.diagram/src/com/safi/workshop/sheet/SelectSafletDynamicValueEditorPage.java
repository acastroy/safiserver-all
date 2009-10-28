package com.safi.workshop.sheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;

import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;
import com.safi.db.server.config.Saflet;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.workshop.navigator.db.SelectSafletPanel;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.util.SafletPersistenceManager;

public class SelectSafletDynamicValueEditorPage extends AbstractDynamicValueEditorPage {

  private SelectSafletPanel safletPanel;
  private Map<String, ServerResource> localResources;
  private List<IProject> plist;
  private List<SafletProject> projectList;

  public SelectSafletDynamicValueEditorPage() {
    localResources = SafletPersistenceManager.getInstance().getLocalProjectCopies(false);
    IWorkspace ws = ResourcesPlugin.getWorkspace();
    IProject[] projects = ws.getRoot().getProjects();
    plist = new ArrayList<IProject>(Arrays.asList(projects));

    projectList = SafletPersistenceManager.getInstance().getProjectAndSafletTreeCloned(
        localResources);

  }

  @Override
  public Composite createControl(Composite parent) {

    safletPanel = new SelectSafletPanel(parent, projectList, localResources,
        SelectSafletPanel.Mode.SELECT_SAFLET, Collections.singletonList(editor.getScratch()
            .getText()));
    return safletPanel;
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "Saflet Chooser";
  }

  @Override
  public String getText() {
    List<ServerResource> list = safletPanel.getCheckedItems();
    if (list != null) {

      Map<SafletProject, IProject> projectToResourceMap = new HashMap<SafletProject, IProject>();
      SafletPersistenceManager.getInstance().prepareProjects(editor.getShell(), list,
          projectToResourceMap, plist);
      List<Saflet> saflets = new ArrayList<Saflet>();
      for (ServerResource sr : list) {
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
        try {
          SafletPersistenceManager.getInstance().addOrUpdateSaflets(entry.getKey(),
              entry.getValue(), false, false);
        } catch (Exception e) {
          MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Retrieve Error",
              "Couldn't retrieve Saflet: " + e.getLocalizedMessage());
          AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't retrieve Saflet", e);
        }
      }
      if (!saflets.isEmpty()) {
        Saflet saflet = saflets.get(0);
        return saflet.getProject().getName() + "/" + saflet.getName();
      }

    }

    return null;
  }

  @Override
  public String getType() {
    // TODO Auto-generated method stub
    return "Saflet Path";
  }

  @Override
  public boolean commit() {
    DynamicValue scratch = editor.getScratch();
    scratch.setType(DynamicValueType.CUSTOM);
    String text = getText();
    scratch.setText(text);
    return true;
  }

  @Override
  public void show() {
    safletPanel.setSelectedSaflets(Collections.singletonList(editor.getScratch().getText()));
    super.show();
  }

}
