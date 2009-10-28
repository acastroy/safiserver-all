package com.safi.workshop;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class SafiNewProjectWizardPage extends WizardPage {

  /**
   * Create the wizard
   */
  public SafiNewProjectWizardPage() {
    super("wizardPage");
    setTitle("Safi Project");
    setDescription("Create a new safi project resource");
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    container.setLayout(new FormLayout());
    //
    setControl(container);

    final Label projectNameLabel = new Label(container, SWT.NONE);
    final FormData fd_projectNameLabel = new FormData();
    fd_projectNameLabel.right = new FormAttachment(0, 85);
    fd_projectNameLabel.top = new FormAttachment(0, 7);
    fd_projectNameLabel.bottom = new FormAttachment(0, 20);
    fd_projectNameLabel.left = new FormAttachment(0, 5);
    projectNameLabel.setLayoutData(fd_projectNameLabel);
    projectNameLabel.setText("Project Name:");
  }

}
