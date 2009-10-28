package com.safi.workshop.serverview;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class NewUserRequiredFieldsPage extends WizardPage {

  private Text confirmPasswordField;
  private Label confirmPasswordLabel;
  private Text emailField;
  private Label emailLabel;
  private Text passwordField;
  private Label passwordLabel;
  private Text usernameField;
  private Label desiredUsernameLabel;

  /**
   * Create the wizard
   */
  public NewUserRequiredFieldsPage() {
    super("wizardPage");
    setTitle("Required Fields");
    setDescription("Please enter valid values for all fields");
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginTop = 40;
    gridLayout.marginRight = 40;
    gridLayout.marginLeft = 40;
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    //
    setControl(container);

    desiredUsernameLabel = new Label(container, SWT.NONE);
    desiredUsernameLabel.setText("Desired username:");

    usernameField = new Text(container, SWT.BORDER);
    usernameField.addModifyListener(new ModifyListener() {
      public void modifyText(final ModifyEvent e) {
        validate();
      }
    });
    final GridData gd_usernameField = new GridData(SWT.FILL, SWT.CENTER, true, false);
    usernameField.setLayoutData(gd_usernameField);

    passwordLabel = new Label(container, SWT.NONE);
    passwordLabel.setText("Password:");

    passwordField = new Text(container, SWT.BORDER | SWT.PASSWORD);
    final GridData gd_passwordField = new GridData(SWT.FILL, SWT.CENTER, true, false);
    passwordField.setLayoutData(gd_passwordField);
    passwordField.addModifyListener(new ModifyListener() {
      public void modifyText(final ModifyEvent e) {
        validate();
      }
    });

    confirmPasswordLabel = new Label(container, SWT.NONE);
    confirmPasswordLabel.setText("Confirm password:");

    confirmPasswordField = new Text(container, SWT.BORDER | SWT.PASSWORD);
    final GridData gd_confirmPasswordField = new GridData(SWT.FILL, SWT.CENTER, true, false);
    confirmPasswordField.setLayoutData(gd_confirmPasswordField);
    confirmPasswordField.addModifyListener(new ModifyListener() {
      public void modifyText(final ModifyEvent e) {
        validate();
      }
    });

    emailLabel = new Label(container, SWT.NONE);
    emailLabel.setText("Email:");

    emailField = new Text(container, SWT.BORDER);
    final GridData gd_emailField = new GridData(SWT.FILL, SWT.CENTER, true, false);
    emailField.setLayoutData(gd_emailField);
    emailField.addModifyListener(new ModifyListener() {
      public void modifyText(final ModifyEvent e) {
        validate();
      }
    });

    validate();
  }

  public String getUsername() {
    return usernameField.getText();
  }

  public String getPassword() {
    return passwordField.getText();
  }

  public String getEmail() {
    return emailField.getText();
  }

  private boolean validate() {
    boolean valid = false;
    if (StringUtils.isBlank(usernameField.getText())) {
      setMessage("Username is required", IMessageProvider.ERROR);
    } else if (StringUtils.isBlank(passwordField.getText())) {
      setMessage("Non-blank password is required", IMessageProvider.ERROR);
    } else if (!StringUtils.equals(passwordField.getText(), confirmPasswordField.getText())) {
      setMessage("Passwords don't match", IMessageProvider.ERROR);
    } else if (StringUtils.isBlank(emailField.getText())) {
      setMessage("Email address is required", IMessageProvider.ERROR);
    } else {
      setMessage(
          "All entered values appear to be valid. Press 'Next' to continue or 'Finish' to complete registration.",
          IMessageProvider.NONE);
      valid = true;
    }
    setPageComplete(valid);
    return valid;
  }

  // @Override
  // public boolean isPageComplete() {
  // return valid
  // return super.isPageComplete();
  // }

}
