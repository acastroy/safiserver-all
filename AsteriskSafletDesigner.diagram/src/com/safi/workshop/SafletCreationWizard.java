package com.safi.workshop;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

/**
 * This class implements the interface required by the workbench for all 'New' wizards.
 * This wizard creates readme files.
 */
public class SafletCreationWizard extends Wizard implements INewWizard {
  private IStructuredSelection selection;

  private IWorkbench workbench;

  private SafletCreationPage mainPage;
  private boolean projectsExist;

  /**
   * (non-Javadoc) Method declared on Wizard.
   */
  @Override
  public void addPages() {
    mainPage = new SafletCreationPage(workbench, selection);

    addPage(mainPage);
  }

  /**
   * (non-Javadoc) Method declared on IWorkbenchWizard
   */
  public void init(IWorkbench workbench, IStructuredSelection selection) {
    this.workbench = workbench;
    this.selection = null;
    if (selection != null && selection instanceof TreeSelection) {
      Object obj = ((TreeSelection) selection).getFirstElement();
      if (obj != null && obj instanceof IProject) {
        this.selection = selection;
        projectsExist = true;
      }
    }

    if (this.selection == null) {
      IWorkspace workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot root = workspace.getRoot();
      IProject[] pros = root.getProjects();
      if (pros != null && pros.length > 0) {
        StructuredSelection sel = new StructuredSelection(pros[0]);
        this.selection = sel;
        projectsExist = true;
      }

    }

    if (!projectsExist) {
      boolean b = MessageDialog
          .openQuestion(
              getShell(),
              "No Projects Exist",
              "There must be at least 1 project present before any Saflets may be added.  Do you wish to do that now?");
      if (b) {
        SafiBasicNewProjectResourceWizard wizard = new SafiBasicNewProjectResourceWizard();

        wizard.init(workbench, selection);

        WizardDialog dialog = new WizardDialog(null, wizard);
        dialog.setTitle("New Safi Project Wizard");

        dialog.setTitleImage(AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
            "icons/server/resource/ServerResources.gif"));
        int result = dialog.open();
        if (Window.OK == result) {
          IProject project = wizard.getNewProject();
          if (project != null) {
            StructuredSelection sel = new StructuredSelection(project);
            this.selection = sel;
            projectsExist = true;
          }
        }

        // NewSafiProjectAction action = new
        // NewSafiProjectAction(workbench.getActiveWorkbenchWindow());
        // action.run();
      }
    }

    /*
     * IPath location = root.getRawLocation(); File file =
     * (location.append(path)).toFile();
     */

    setWindowTitle("Saflet (Call Flow Diagram) file");
    ImageDescriptor imgDesc = ImageDescriptor.createFromURL(FileLocator.find(Platform
        .getBundle("AsteriskSafletDesigner.diagram"), new Path("icons/titlearea/NewSaflet.gif"),
        null));

    this.setDefaultPageImageDescriptor(imgDesc);

    // setWindowTitle(MessageUtil.getString("New_Readme_File"));
    // //$NON-NLS-1$
    // setDefaultPageImageDescriptor(SafletWizardImages.README_WIZARD_BANNER);
  }

  @Override
  public boolean canFinish() {
    if (!projectsExist)
      return false;
    return super.canFinish();
  }

  /**
   * (non-Javadoc) Method declared on IWizard
   */
  @Override
  public boolean performFinish() {
    return mainPage.finish();
  }
}