package com.safi.workshop.part;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.workshop.edit.parts.HandlerEditPart;

/**
 * @generated
 */
public class AsteriskInitDiagramFileAction implements IWorkbenchWindowActionDelegate {

  /**
   * @generated
   */
  private IWorkbenchWindow window;

  /**
   * @generated
   */
  public void init(IWorkbenchWindow window) {
    this.window = window;
  }

  /**
   * @generated
   */
  public void dispose() {
    window = null;
  }

  /**
   * @generated
   */
  public void selectionChanged(IAction action, ISelection selection) {
  }

  /**
   * @generated
   */
  private Shell getShell() {
    return window.getShell();
  }

  /**
   * @generated
   */
  public void run(IAction action) {
    TransactionalEditingDomain editingDomain = WorkspaceEditingDomainFactory.INSTANCE
        .createEditingDomain();
    Resource resource = AsteriskDiagramEditorUtil.openModel(getShell(),
        Messages.AsteriskInitDiagramFileAction_OpenModelFileDialogTitle, editingDomain);
    if (resource == null || resource.getContents().isEmpty()) {
      return;
    }
    EObject diagramRoot = resource.getContents().get(0);
    Wizard wizard = new AsteriskNewDiagramFileWizard(resource.getURI(), diagramRoot, editingDomain);
    wizard.setWindowTitle(NLS
        .bind(Messages.AsteriskInitDiagramFileAction_InitDiagramFileWizardTitle,
            HandlerEditPart.MODEL_ID));
    AsteriskDiagramEditorUtil.runWizard(getShell(), wizard, "InitDiagramFile"); //$NON-NLS-1$
  }
}
