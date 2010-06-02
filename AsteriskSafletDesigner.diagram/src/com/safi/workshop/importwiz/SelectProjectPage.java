package com.safi.workshop.importwiz;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.swtdesigner.ResourceManager;

public class SelectProjectPage extends WizardPage {

  class ContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      return ResourcesPlugin.getWorkspace().getRoot().getProjects();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }
  private List list;
  private Label availableSafiProjectsLabel;
  private ListViewer listViewer;
  private IProject selectedProject;

  /**
   * Create the wizard
   */
  public SelectProjectPage() {
    super("wizardPage");
    setTitle("Import Saflets Wizard");
    setDescription("Select the project which will recieve the imported Saflets");
    setImageDescriptor(ResourceManager.getPluginImageDescriptor(AsteriskDiagramEditorPlugin
        .getDefault(), "icons/wizban/ImportSafletWizard.gif"));
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginTop = 20;
    gridLayout.marginBottom = 20;
    gridLayout.marginLeft = 40;
    gridLayout.marginRight = 40;
    container.setLayout(gridLayout);
    //
    setControl(container);

    availableSafiProjectsLabel = new Label(container, SWT.CENTER);
    availableSafiProjectsLabel.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));
    availableSafiProjectsLabel.setText("Available Safi Projects");

    listViewer = new ListViewer(container, SWT.BORDER);
    listViewer.setContentProvider(new ContentProvider());
    listViewer.addSelectionChangedListener(new ISelectionChangedListener() {

      public void selectionChanged(final SelectionChangedEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        setPageComplete(!selection.isEmpty());
        if (!selection.isEmpty())
          selectedProject = (IProject) selection.getFirstElement();
        else
          selectedProject = null;
      }

    });
    list = listViewer.getList();
    list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    listViewer.setInput(new Object());
    setPageComplete(false);
  }

  public IProject getSelectedProject() {
    return selectedProject;
  }

  public void setSelectedProject(IProject selectedProject) {
    this.selectedProject = selectedProject;
  }
}
