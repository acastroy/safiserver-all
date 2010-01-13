package com.safi.workshop.exportwiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.workshop.navigator.db.SelectSafletPanel;
import com.safi.workshop.util.SafletPersistenceManager;

public class SelectSafletsPage extends WizardPage {

  private SelectSafletPanel safletPanel;
  private Map<String, ServerResource> localResources;
  private List<SafletProject> projectList;

  /**
   * Create the wizard
   */
  public SelectSafletsPage() {
    super("wizardPage");
    setTitle("Export SAR (Safi Archive File) - Select Saflets");
    setDescription("Select all the Projects/Saflets you want to include in this export");

    init();
  }

  private void init() {
    localResources = SafletPersistenceManager.getInstance().getLocalProjectCopies(false);
    IWorkspace ws = ResourcesPlugin.getWorkspace();
    IProject[] projects = ws.getRoot().getProjects();
    projectList = new ArrayList<SafletProject>();
    for (ServerResource res : localResources.values()) {
      if (res instanceof SafletProject)
        projectList.add((SafletProject) res);
    }
    // projectList = SafletPersistenceManager.getInstance().getProjectAndSafletTreeCloned(
    // localResources);

  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginTop = 10;
    gridLayout.marginBottom = 10;
    gridLayout.marginLeft = 10;
    gridLayout.marginRight = 10;
    container.setLayout(gridLayout);
    //
    setControl(container);
    safletPanel = new SelectSafletPanel(container, projectList, localResources,
        SelectSafletPanel.Mode.EXPORT, null);
    safletPanel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
  }

  public List<ServerResource> getCheckedItems() {
    return safletPanel.getCheckedItems();
  }

}
