package com.safi.workshop.part;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.osgi.util.NLS;
import org.eclipse.ui.PartInitException;

import com.safi.workshop.application.WizardNewFileCreationPage;
import com.safi.workshop.edit.parts.HandlerEditPart;

/**
 * @generated
 */
public class AsteriskNewDiagramFileWizard extends Wizard {

  /**
   * @generated
   */
  private WizardNewFileCreationPage myFileCreationPage;

  /**
   * @generated
   */
  private ModelElementSelectionPage diagramRootElementSelectionPage;

  /**
   * @generated
   */
  private TransactionalEditingDomain myEditingDomain;

  /**
   * @generated
   */
  public AsteriskNewDiagramFileWizard(URI domainModelURI, EObject diagramRoot,
      TransactionalEditingDomain editingDomain) {
    assert domainModelURI != null : "Domain model uri must be specified"; //$NON-NLS-1$
    assert diagramRoot != null : "Doagram root element must be specified"; //$NON-NLS-1$
    assert editingDomain != null : "Editing domain must be specified"; //$NON-NLS-1$

    myFileCreationPage = new WizardNewFileCreationPage(
        Messages.AsteriskNewDiagramFileWizard_CreationPageName, StructuredSelection.EMPTY);
    myFileCreationPage.setTitle(Messages.AsteriskNewDiagramFileWizard_CreationPageTitle);
    myFileCreationPage.setDescription(NLS.bind(
        Messages.AsteriskNewDiagramFileWizard_CreationPageDescription, HandlerEditPart.MODEL_ID));
    IPath filePath;
    String fileName = domainModelURI.trimFileExtension().lastSegment();
    if (domainModelURI.isPlatformResource()) {
      filePath = new Path(domainModelURI.trimSegments(1).toPlatformString(true));
    } else if (domainModelURI.isFile()) {
      filePath = new Path(domainModelURI.trimSegments(1).toFileString());
    } else {
      // TODO : use some default path
      throw new IllegalArgumentException("Unsupported URI: " + domainModelURI); //$NON-NLS-1$
    }
    myFileCreationPage.setContainerFullPath(filePath);
    myFileCreationPage.setFileName(AsteriskDiagramEditorUtil.getUniqueFileName(filePath, fileName,
        "saflet")); //$NON-NLS-1$

    diagramRootElementSelectionPage = new DiagramRootElementSelectionPage(
        Messages.AsteriskNewDiagramFileWizard_RootSelectionPageName);
    diagramRootElementSelectionPage
        .setTitle(Messages.AsteriskNewDiagramFileWizard_RootSelectionPageTitle);
    diagramRootElementSelectionPage
        .setDescription(Messages.AsteriskNewDiagramFileWizard_RootSelectionPageDescription);
    diagramRootElementSelectionPage.setModelElement(diagramRoot);

    myEditingDomain = editingDomain;
  }

  /**
   * @generated
   */
  @Override
  public void addPages() {
    addPage(myFileCreationPage);
    addPage(diagramRootElementSelectionPage);
  }

  /**
   * @generated
   */
  @Override
  public boolean performFinish() {
    List affectedFiles = new LinkedList();
    IPath diagramModelPath = myFileCreationPage.getContainerFullPath().append(
        myFileCreationPage.getFileName());
    URI diagramModelURI = URI.createFileURI(diagramModelPath.toString());
    ResourceSet resourceSet = myEditingDomain.getResourceSet();
    final Resource diagramResource = resourceSet.createResource(diagramModelURI);
    AbstractTransactionalCommand command = new AbstractTransactionalCommand(myEditingDomain,
        Messages.AsteriskNewDiagramFileWizard_InitDiagramCommand, affectedFiles) {

      @Override
      protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
          throws ExecutionException {
        int diagramVID = AsteriskVisualIDRegistry
            .getDiagramVisualID(diagramRootElementSelectionPage.getModelElement());
        if (diagramVID != HandlerEditPart.VISUAL_ID) {
          return CommandResult
              .newErrorCommandResult(Messages.AsteriskNewDiagramFileWizard_IncorrectRootError);
        }
        Diagram diagram = ViewService.createDiagram(diagramRootElementSelectionPage
            .getModelElement(), HandlerEditPart.MODEL_ID,
            AsteriskDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
        diagramResource.getContents().add(diagram);
        diagramResource.getContents().add(diagram.getElement());
        return CommandResult.newOKCommandResult();
      }
    };
    try {
      OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(),
          null);
      diagramResource.save(AsteriskDiagramEditorUtil.getSaveOptions());
      AsteriskDiagramEditorUtil.openDiagram(diagramResource);
    } catch (ExecutionException e) {
      AsteriskDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
    } catch (IOException ex) {
      AsteriskDiagramEditorPlugin.getInstance().logError(
          "Save operation failed for: " + diagramModelURI, ex); //$NON-NLS-1$
    } catch (PartInitException ex) {
      AsteriskDiagramEditorPlugin.getInstance().logError("Unable to open editor", ex); //$NON-NLS-1$
    }
    return true;
  }

  /**
   * @generated
   */
  private static class DiagramRootElementSelectionPage extends ModelElementSelectionPage {

    /**
     * @generated
     */
    protected DiagramRootElementSelectionPage(String pageName) {
      super(pageName);
    }

    /**
     * @generated
     */
    @Override
    protected String getSelectionTitle() {
      return Messages.AsteriskNewDiagramFileWizard_RootSelectionPageSelectionTitle;
    }

    /**
     * @generated
     */
    @Override
    protected boolean validatePage() {
      if (selectedModelElement == null) {
        setErrorMessage(Messages.AsteriskNewDiagramFileWizard_RootSelectionPageNoSelectionMessage);
        return false;
      }
      boolean result = ViewService.getInstance().provides(
          new CreateDiagramViewOperation(new EObjectAdapter(selectedModelElement),
              HandlerEditPart.MODEL_ID, AsteriskDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT));
      setErrorMessage(result ? null
          : Messages.AsteriskNewDiagramFileWizard_RootSelectionPageInvalidSelectionMessage);
      return result;
    }
  }
}