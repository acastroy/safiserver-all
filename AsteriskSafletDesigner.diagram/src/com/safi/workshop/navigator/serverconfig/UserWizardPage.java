package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

public class UserWizardPage extends WizardPage {

  private List listAssigned;
  private List listAvailable;
  private Text textLastName;
  private Text textFirstName;
  private Text textPass;
  private Text textName;

  /**
   * Create the wizard
   */
  public UserWizardPage() {
    super("wizardPage");
    setTitle("Administer User Information");
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

    final Group userProfileGroup = new Group(container, SWT.NONE);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 3;
    userProfileGroup.setLayout(gridLayout);
    final FormData fd_userProfileGroup = new FormData();
    fd_userProfileGroup.bottom = new FormAttachment(0, 140);
    fd_userProfileGroup.left = new FormAttachment(0, 10);
    fd_userProfileGroup.right = new FormAttachment(100, -10);
    fd_userProfileGroup.top = new FormAttachment(0, 10);
    userProfileGroup.setLayoutData(fd_userProfileGroup);
    userProfileGroup.setText("User Profile");

    final Label loginLabel = new Label(userProfileGroup, SWT.NONE);
    loginLabel.setText("Login :");

    textName = new Text(userProfileGroup, SWT.BORDER);
    final GridData gd_text_name = new GridData(SWT.FILL, SWT.CENTER, true, false);
    textName.setLayoutData(gd_text_name);
    new Label(userProfileGroup, SWT.NONE);

    final Label passwordLabel = new Label(userProfileGroup, SWT.NONE);
    passwordLabel.setText("Password :");

    textPass = new Text(userProfileGroup, SWT.BORDER | SWT.PASSWORD);
    final GridData gd_text_pass = new GridData(SWT.FILL, SWT.CENTER, true, false);
    textPass.setLayoutData(gd_text_pass);

    final Button maskedButton = new Button(userProfileGroup, SWT.CHECK);
    maskedButton.setSelection(true);
    maskedButton.setText("Masked       ");

    final Label firstNameLabel = new Label(userProfileGroup, SWT.NONE);
    firstNameLabel.setText("First Name :");

    textFirstName = new Text(userProfileGroup, SWT.BORDER);
    final GridData gd_text_firstName = new GridData(SWT.FILL, SWT.CENTER, true, false);
    textFirstName.setLayoutData(gd_text_firstName);
    new Label(userProfileGroup, SWT.NONE);

    final Label lastNameLabel = new Label(userProfileGroup, SWT.NONE);
    lastNameLabel.setText("Last Name :");

    textLastName = new Text(userProfileGroup, SWT.BORDER);
    final GridData gd_text_lastName = new GridData(SWT.FILL, SWT.CENTER, true, false);
    textLastName.setLayoutData(gd_text_lastName);
    new Label(userProfileGroup, SWT.NONE);

    final Group roleAssignmentGroup = new Group(container, SWT.NONE);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 7;
    roleAssignmentGroup.setLayout(gridLayout_1);
    roleAssignmentGroup.setText("Role Assignment");
    final FormData fd_roleAssignmentGroup = new FormData();
    fd_roleAssignmentGroup.bottom = new FormAttachment(100, -7);
    fd_roleAssignmentGroup.left = new FormAttachment(userProfileGroup, 0, SWT.LEFT);
    fd_roleAssignmentGroup.right = new FormAttachment(userProfileGroup, 0, SWT.RIGHT);
    fd_roleAssignmentGroup.top = new FormAttachment(userProfileGroup, 5, SWT.BOTTOM);
    roleAssignmentGroup.setLayoutData(fd_roleAssignmentGroup);

    Group availableRoleGroup_1;

    final Group availableRoleGroup = new Group(roleAssignmentGroup, SWT.NONE);
    availableRoleGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
    availableRoleGroup.setText("Available Role");
    availableRoleGroup.setLayout(new FillLayout());

    listAvailable = new List(availableRoleGroup, SWT.BORDER);

    final Composite composite = new Composite(roleAssignmentGroup, SWT.NONE);
    composite.setLayout(new RowLayout(SWT.VERTICAL));

    final Button button_Add = new Button(composite, SWT.ARROW | SWT.RIGHT);
    final RowData rd_button_Add = new RowData();
    rd_button_Add.height = 25;
    rd_button_Add.width = 25;
    button_Add.setLayoutData(rd_button_Add);
    button_Add.setText("button");

    final Button button_Remove = new Button(composite, SWT.ARROW | SWT.LEFT);
    final RowData rd_button_Remove = new RowData();
    rd_button_Remove.width = 25;
    rd_button_Remove.height = 25;
    button_Remove.setLayoutData(rd_button_Remove);
    button_Remove.setText("button");
    availableRoleGroup_1 = new Group(roleAssignmentGroup, SWT.NONE);
    availableRoleGroup_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
    availableRoleGroup_1.setLayout(new FillLayout());
    availableRoleGroup_1.setText("Assigned Role");

    listAssigned = new List(availableRoleGroup_1, SWT.BORDER);
  }

  public static void main(String[] args) {

  }

}
