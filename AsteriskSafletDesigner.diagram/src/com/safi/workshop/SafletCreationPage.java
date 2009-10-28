package com.safi.workshop;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.part.Messages;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin.ActionStepProfile;
import com.safi.workshop.util.SafletPersistenceManager;

/**
 * This class is the only page of the Readme file resource creation wizard. It subclasses
 * the standard file resource creation page class, and consequently inherits the file
 * resource creation functionality.
 * 
 * This page provides users with the choice of creating sample headings for sections and
 * subsections. Additionally, the option is presented to open the file immediately for
 * editing after creation.
 */
public class SafletCreationPage extends WizardNewFileCreationPage {
  private IWorkbench workbench;

  // widgets
  // private Button sectionCheckbox;

  private Button subsectionCheckbox;

  private Button openFileCheckbox;
  private Combo initiatorCombo;
  private Label safletLabel;
  private HashMap<String, ActionStepProfile> actionProfilesHasp = new HashMap<String, ActionStepProfile>();
  List<ActionStepProfile> actionProfiles;
  // constants
  private static int nameCounter = 1;

  protected Resource diagram;
  private IStructuredSelection currentSelection;

  /**
   * Creates the page for the readme creation wizard.
   * 
   * @param workbench
   *          the workbench on which the page should be created
   * @param selection
   *          the current selection
   */
  public SafletCreationPage(IWorkbench workbench, IStructuredSelection selection) {
    super("sampleCreateReadmePage1", selection); //$NON-NLS-1$
    this.setTitle("Create Saflet(Call Flow Diagram)");
    // this.setTitle(MessageUtil.getString("Create_Readme_File"));
    // //$NON-NLS-1$
    // this.setDescription(MessageUtil.getString("Create_a_new_Readme_file_resource"));
    // //$NON-NLS-1$
    this.workbench = workbench;
    this.currentSelection = selection;

  }

  /**
   * (non-Javadoc) Method declared on IDialogPage.
   */
  @Override
  public void createControl(Composite parent) {
    // inherit default container and name specification widgets
    super.createControl(parent);
    this.actionProfilesHasp.clear();
    Composite composite = (Composite) getControl();

    PlatformUI.getWorkbench().getHelpSystem().setHelp(composite,
        IReadmeConstants.CREATION_WIZARD_PAGE_CONTEXT);

    IPath path = this.getContainerFullPath();
    /*
     * if(this.currentSelection!=null){ path=(IPath)
     * this.currentSelection.getFirstElement(); }
     */
    if (path != null) {

      IWorkspace workspace = ResourcesPlugin.getWorkspace();
      IWorkspaceRoot root = workspace.getRoot();
      IPath location = root.getRawLocation();
      File file = (location.append(path)).toFile();
      if (file.isDirectory()) {

        File[] files = file.listFiles();
        ArrayList<String> arrayList = new ArrayList<String>();
        for (File file2 : files) {
          arrayList.add(file2.getName());
        }
        if (!arrayList.contains(this.getFileName())) {
          int count = 1;
          String newString = "callflow" + count + ".saflet";
          while (arrayList.contains(newString) && count < 100) {
            count++;
            newString = "callflow" + count + ".saflet";
          }

          this.setFileExtension("saflet");
          try {
            this.setFileName(newString);
          } catch (Exception ex) {
            ex.printStackTrace();
          }
        }
      }
    }
    /*
     * this.setFileExtension("saflet"); this.setFileName("callflow" + nameCounter +
     * ".saflet"); //$NON-NLS-1$ //$NON-NLS-2$ int count=0; while
     * (!this.validatePage()&&count<100) { this.nameCounter++; count++;
     * this.setFileName("callflow" + nameCounter + ".saflet"); //$NON-NLS-1$ //$NON-NLS-2$
     * }
     */

    // sample section generation group
    /*
     * Group group = new Group(composite, SWT.NONE); group.setLayout(new GridLayout());
     */
    /*
     * group.setText(MessageUtil .getString("Automatic_sample_section_generation"));
     * //$NON-NLS-1$
     */
    /*
     * group.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL |
     * GridData.HORIZONTAL_ALIGN_FILL)); // sample section generation checkboxes
     * sectionCheckbox = new Button(group, SWT.CHECK);
     */
    /*
     * sectionCheckbox.setText(MessageUtil .getString("Generate_sample_section_titles"));
     * //$NON-NLS-1$
     */
    /*
     * sectionCheckbox.setText("Generate_sample_section_titles");
     * sectionCheckbox.setSelection(true); sectionCheckbox.addListener(SWT.Selection,
     * this);
     * 
     * subsectionCheckbox = new Button(group, SWT.CHECK);
     * subsectionCheckbox.setText("Generate_sample_subsection_titles"); //$NON-NLS-1$
     * subsectionCheckbox.setSelection(true);
     * subsectionCheckbox.addListener(SWT.Selection, this);
     */
    // open file for editing checkbox
    // this.initiatorCombo.add("Incoming Call");
    int safIndex = 0;
    int selectedIndex = 0;
    actionProfiles = AsteriskDiagramEditorPlugin.getInstance().getActionstepProfiles();
    for (ActionStepProfile asp : actionProfiles) {
      if (asp.isInitiator) {
        initiatorCombo.add(asp.displayName);
        this.actionProfilesHasp.put(asp.displayName, asp);

        if ("Incoming Call".equals(asp.displayName)) {
          selectedIndex = safIndex;
        }
        safIndex++;
        /*
         * else {
         * 
         * this.initiatorCombo.add(asp.displayName);
         * this.actionProfilesHasp.put(Integer.toString(safIndex), asp); //
         * this.initiatorCombo.setData(Integer.toString(safIndex), asp); } safIndex++;
         */
      }
    }
    // this.safletCombo.add("Incoming Call");
    // this.safletCombo.add("Custom initiator");
    this.initiatorCombo.select(selectedIndex);
    openFileCheckbox = new Button(composite, SWT.CHECK);
    openFileCheckbox.setText("Open_file_for_editing_when_done"); //$NON-NLS-1$
    openFileCheckbox.setSelection(true);

    setPageComplete(validatePage());

  }

  @Override
  protected void createAdvancedControls(Composite parent) {
    Composite panel = new Composite(parent, SWT.NULL);
    panel.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
    // RowLayout flow = new RowLayout();
    GridLayout layout = new GridLayout(2, false);
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginTop = 0;

    panel.setLayout(layout);
    this.safletLabel = new Label(panel, SWT.NULL);
    safletLabel.setText(getNewFileLabel());
    Point size = safletLabel.computeSize(SWT.DEFAULT, SWT.DEFAULT);

    this.safletLabel.setText("Select Initiator:");
    // safletLabel.setSize(size);
    GridData data = new GridData(GridData.HORIZONTAL_ALIGN_END);
    data.widthHint = size.x - 4;
    data.heightHint = size.y;
    safletLabel.setLayoutData(data);
    this.initiatorCombo = new Combo(panel, SWT.READ_ONLY);

    // TODO Auto-generated method stub
    super.createAdvancedControls(parent);
  }

  /**
   * Creates a new file resource as requested by the user. If everything is OK then answer
   * true. If not, false will cause the dialog to stay open.
   * 
   * @return whether creation was successful
   * @see SafletCreationWizard#performFinish()
   */
  public boolean finish() {
    /*
     * // create the new file resource IFile newFile = createNewFile(); if (newFile ==
     * null) return false; // ie.- creation was unsuccessful // Since the file resource
     * was created fine, open it for editing // if requested by the user try { if
     * (openFileCheckbox.getSelection()) { IWorkbenchWindow dwindow =
     * workbench.getActiveWorkbenchWindow(); IWorkbenchPage page =
     * dwindow.getActivePage(); if (page != null) { IDE.openEditor(page, newFile, true); }
     * } } catch (PartInitException e) { e.printStackTrace(); return false; }
     * nameCounter++; return true;
     */

    final IFile newFile = this.createNewFile();

    IProject proj = newFile.getProject();
    IPath path = newFile.getProjectRelativePath();

    final org.eclipse.emf.common.util.URI newURI = org.eclipse.emf.common.util.URI
        .createFileURI(newFile.getRawLocation().toString());

    if (newFile == null)
      return false;

    IRunnableWithProgress op = new IRunnableWithProgress() {

      public void run(IProgressMonitor monitor) throws InvocationTargetException,
          InterruptedException {
        int selected = initiatorCombo.getSelectionIndex();
        ActionStepProfile asp = null;
        if (selected >= 0) {
          String selectedString = initiatorCombo.getItem(selected);

          try {
            asp = actionProfilesHasp.get(selectedString);
          } catch (Exception ex) {
            ex.printStackTrace();
          }
          // if (selected == 0) {
          // asp = null;
          // } else {
          //          
          // }
        }
        diagram = AsteriskDiagramEditorUtil.createDiagram(newURI, asp, monitor);
        if (openFileCheckbox.getSelection() && diagram != null) {
          try {
            AsteriskDiagramEditorUtil.openDiagram(diagram);
          } catch (PartInitException e) {
            ErrorDialog.openError(getContainer().getShell(),
                Messages.AsteriskCreationWizardOpenEditorError, null, e.getStatus());
          }
        }
      }
    };
    try {
      getContainer().run(false, true, op);
      newFile.setPersistentProperty(SafletPersistenceManager.MODIFIED_KEY, String.valueOf(System
          .currentTimeMillis()));

    } catch (InterruptedException e) {
      return false;
    } catch (InvocationTargetException e) {
      if (e.getTargetException() instanceof CoreException) {
        ErrorDialog.openError(getContainer().getShell(),
            Messages.AsteriskCreationWizardCreationError, null, ((CoreException) e
                .getTargetException()).getStatus());
      } else {
        AsteriskDiagramEditorPlugin.getDefault().logError(
            "Error creating diagram", e.getTargetException()); //$NON-NLS-1$
      }
      return false;
    } catch (CoreException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      ErrorDialog.openError(getContainer().getShell(),
          Messages.AsteriskCreationWizardCreationError, null, e.getStatus());

    }
    nameCounter++;
    return diagram != null;
  }

  /**
   * The <code>SafletCreationPage</code> implementation of this
   * <code>WizardNewFileCreationPage</code> method generates sample headings for sections
   * and subsections in the newly-created Readme file according to the selections of
   * self's checkbox widgets
   */
  @Override
  protected InputStream getInitialContents() {
    // if (!sectionCheckbox.getSelection())
    // return null;

    StringBuffer sb = new StringBuffer();
    /*
     * sb.append(MessageUtil.getString("SAMPLE_README_FILE")); //$NON-NLS-1$
     * sb.append(MessageUtil.getString("SECTION_1")); //$NON-NLS-1$
     * sb.append(MessageUtil.getString("SECTION_1_BODY_1")); //$NON-NLS-1$
     * 
     * if (subsectionCheckbox.getSelection()) {
     * sb.append(MessageUtil.getString("Subsection_1_1")); //$NON-NLS-1$
     * sb.append(MessageUtil.getString("Subsection_1_1_Body_1")); //$NON-NLS-1$ }
     * 
     * sb.append(MessageUtil.getString("SECTION_2")); //$NON-NLS-1$
     * sb.append(MessageUtil.getString("SECTION_2_BODY_1")); //$NON-NLS-1$
     * sb.append(MessageUtil.getString("SECTION_2_BODY_2")); //$NON-NLS-1$
     * 
     * if (subsectionCheckbox.getSelection()) {
     * sb.append(MessageUtil.getString("Subsection_2_1")); //$NON-NLS-1$
     * sb.append(MessageUtil.getString("Subsection_2_1_BODY_1")); //$NON-NLS-1$
     * sb.append(MessageUtil.getString("Subsection_2_2")); //$NON-NLS-1$
     * sb.append(MessageUtil.getString("Subsection_2_2_BODY_1")); //$NON-NLS-1$ }
     */
    return new ByteArrayInputStream(sb.toString().getBytes());
  }

  /**
   * (non-Javadoc) Method declared on WizardNewFileCreationPage.
   */
  @Override
  protected String getNewFileLabel() {
    // return MessageUtil.getString("Readme_file_name"); //$NON-NLS-1$
    return "New Saflet Name: ";
  }

  /**
   * (non-Javadoc) Method declared on WizardNewFileCreationPage.
   */
  @Override
  public void handleEvent(Event e) {
    Widget source = e.widget;
    /*
     * if (source == sectionCheckbox) { if (!sectionCheckbox.getSelection())
     * subsectionCheckbox.setSelection(false);
     * subsectionCheckbox.setEnabled(sectionCheckbox.getSelection()); }
     */

    super.handleEvent(e);
  }

  @Override
  protected boolean validatePage() {
    if (this.getControl() == null)
      return false;
    if (super.validatePage()) {
      return true;
    }
    IPath path = this.getContainerFullPath();
    if (path == null) {
      return false;
    }

    IWorkspace workspace = ResourcesPlugin.getWorkspace();
    IWorkspaceRoot root = workspace.getRoot();
    IPath location = root.getRawLocation();
    File file = (location.append(path)).toFile();
    if (!file.isDirectory())
      return false;
    File[] files = file.listFiles();
    ArrayList<String> arrayList = new ArrayList<String>();
    for (File file2 : files) {
      arrayList.add(file2.getName());
    }
    if (!arrayList.contains(this.getFileName())) {
      int count = 1;
      String newString = "callflow" + count + ".saflet";
      while (arrayList.contains(newString) && count < 1000) {
        count++;
        newString = "callflow" + count + ".saflet";
      }

      try {

        this.setFileName(newString);
        this.setFileExtension("saflet");
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    return this.validatePage();
    /*
     * boolean valid = true;
     * 
     * if (!resourceGroup.areAllValuesValid()) { // if blank name then fail silently if
     * (resourceGroup.getProblemType() == ResourceAndContainerGroup.PROBLEM_RESOURCE_EMPTY
     * || resourceGroup.getProblemType() ==
     * ResourceAndContainerGroup.PROBLEM_CONTAINER_EMPTY) {
     * setMessage(resourceGroup.getProblemMessage()); setErrorMessage(null); } else {
     * setErrorMessage(resourceGroup.getProblemMessage()); } valid = false; }
     * 
     * String resourceName = resourceGroup.getResource(); IWorkspace workspace =
     * ResourcesPlugin.getWorkspace(); IStatus result =
     * workspace.validateName(resourceName, IResource.FILE); if (!result.isOK()) {
     * setErrorMessage(result.getMessage()); return false; }
     * 
     * IStatus linkedResourceStatus = null; if (valid) { linkedResourceStatus =
     * validateLinkedResource(); if (linkedResourceStatus.getSeverity() == IStatus.ERROR)
     * { valid = false; } } // validateLinkedResource sets messages itself if (valid &&
     * (linkedResourceStatus == null || linkedResourceStatus.isOK())) { setMessage(null);
     * setErrorMessage(null); } return valid;
     */
  }

}