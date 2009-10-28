package com.safi.workshop.part;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.widgets.Composite;

/**
 * @generated NOT
 */
public class AsteriskCreationWizardPage extends
    com.safi.workshop.application.WizardNewFileCreationPage {

  /**
   * @generated
   */
  private final String fileExtension;

  /**
   * @generated
   */
  public AsteriskCreationWizardPage(String pageName, IStructuredSelection selection,
      String fileExtension) {
    super(pageName, selection);
    this.fileExtension = fileExtension;
  }

  // /**
  // * @generated
  // */
  // protected IPath getFilePath() {
  // IPath path = getContainerFullPath();
  // if (path == null) {
  //      path = new Path(""); //$NON-NLS-1$
  // }
  // String fileName = getFileName();
  // if (fileName != null) {
  // path = path.append(fileName);
  // }
  // return path;
  // }

  /**
   * Override to create files with this extension.
   * 
   * @generated
   */
  protected String getExtension() {
    return fileExtension;
  }

  /**
   * @generated
   */
  public URI getURI() {
    return URI.createFileURI(getFilePath().toString());
  }

  /**
   * @generated
   */
  @Override
  public void createControl(Composite parent) {
    super.createControl(parent);
    setFileName(AsteriskDiagramEditorUtil.getUniqueFileName(getContainerFullPath(), getFileName(),
        getExtension()));
    setPageComplete(validatePage());
  }

  /**
   * @generated
   */
  @Override
  protected boolean validatePage() {
    if (!super.validatePage()) {
      return false;
    }
    String extension = getExtension();
    if (extension != null && !getFilePath().toString().endsWith("." + extension)) {
      setErrorMessage(NLS.bind(Messages.AsteriskCreationWizardPageExtensionError, extension));
      return false;
    }
    return true;
  }
}