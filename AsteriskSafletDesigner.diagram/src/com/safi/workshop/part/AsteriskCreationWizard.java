package com.safi.workshop.part;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;

/**
 * @generated
 */
public class AsteriskCreationWizard extends Wizard implements INewWizard {

  /**
   * @generated
   */
  private IWorkbench workbench;

  /**
   * @generated
   */
  protected IStructuredSelection selection;

  /**
   * @generated
   */
  protected AsteriskCreationWizardPage diagramModelFilePage;

  /**
   * @generated
   */
  protected Resource diagram;

  /**
   * @generated
   */
  private boolean openNewlyCreatedDiagramEditor = true;

  /**
   * @generated
   */
  public IWorkbench getWorkbench() {
    return workbench;
  }

  /**
   * @generated
   */
  public IStructuredSelection getSelection() {
    return selection;
  }

  /**
   * @generated
   */
  public final Resource getDiagram() {
    return diagram;
  }

  /**
   * @generated
   */
  public final boolean isOpenNewlyCreatedDiagramEditor() {
    return openNewlyCreatedDiagramEditor;
  }

  /**
   * @generated
   */
  public void setOpenNewlyCreatedDiagramEditor(boolean openNewlyCreatedDiagramEditor) {
    this.openNewlyCreatedDiagramEditor = openNewlyCreatedDiagramEditor;
  }

  /**
   * @generated
   */
  public void init(IWorkbench workbench, IStructuredSelection selection) {
    this.workbench = workbench;
    this.selection = selection;
    setWindowTitle(Messages.AsteriskCreationWizardTitle);
    setDefaultPageImageDescriptor(AsteriskDiagramEditorPlugin
        .getBundledImageDescriptor("icons/wizban/NewHandlerWizard.gif")); //$NON-NLS-1$
    setNeedsProgressMonitor(true);
  }

  /**
   * @generated
   */
  @Override
  public void addPages() {
    diagramModelFilePage = new AsteriskCreationWizardPage(
        "DiagramModelFile", getSelection(), "saflet"); //$NON-NLS-1$ //$NON-NLS-2$
    diagramModelFilePage.setTitle(Messages.AsteriskCreationWizard_DiagramModelFilePageTitle);
    diagramModelFilePage
        .setDescription(Messages.AsteriskCreationWizard_DiagramModelFilePageDescription);
    addPage(diagramModelFilePage);
  }

  /**
   * @generated
   */
  @Override
  public boolean performFinish() {
    IRunnableWithProgress op = new IRunnableWithProgress() {

      public void run(IProgressMonitor monitor) throws InvocationTargetException,
          InterruptedException {
        diagram = AsteriskDiagramEditorUtil.createDiagram(diagramModelFilePage.getURI(), monitor);
        if (isOpenNewlyCreatedDiagramEditor() && diagram != null) {
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
    } catch (InterruptedException e) {
      return false;
    } catch (InvocationTargetException e) {
      if (e.getTargetException() instanceof CoreException) {
        ErrorDialog.openError(getContainer().getShell(),
            Messages.AsteriskCreationWizardCreationError, null, ((CoreException) e
                .getTargetException()).getStatus());
      } else {
        AsteriskDiagramEditorPlugin.getInstance().logError(
            "Error creating diagram", e.getTargetException()); //$NON-NLS-1$
      }
      return false;
    }
    return diagram != null;
  }
}
