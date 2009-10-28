package com.safi.workshop.sqlexplorer.wizard;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class DBConnectionWizardAuthPage extends DBConnectionWizardPage {

  private Text passwordField;
  private Text usernameField;
  private Combo combo;
  private Composite authPanel;

  /**
   * Create the wizard
   */
  public DBConnectionWizardAuthPage() {
    super("AuthPage");
  }

  /**
   * Create contents of the wizard
   * 
   * @param parent
   */
  @Override
  public void createControl(Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.marginRight = 40;
    gridLayout.marginLeft = 40;
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    //
    setControl(container);

    final Label isAsUsernameLabel = new Label(container, SWT.NONE);
    isAsUsernameLabel.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, false, true));
    isAsUsernameLabel.setText("Are username and password required for this connection?");

    combo = new Combo(container, SWT.NONE);
    combo.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        int idx = combo.getSelectionIndex();
        if (idx == -1 || idx == 1) {
          authPanel.setVisible(false);
        } else {
          authPanel.setVisible(true);
        }
      }
    });

    combo.setItems(new String[] { "YES", "NO" });
    combo.setLayoutData(new GridData(SWT.LEFT, SWT.BOTTOM, true, false));

    authPanel = new Composite(container, SWT.NONE);
    final GridData gd_authPanel = new GridData(SWT.FILL, SWT.CENTER, true, true, 2, 1);
    authPanel.setLayoutData(gd_authPanel);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.marginRight = 60;
    gridLayout_1.marginLeft = 40;
    gridLayout_1.numColumns = 2;
    authPanel.setLayout(gridLayout_1);

    final Label enterUsernameLabel = new Label(authPanel, SWT.NONE);
    enterUsernameLabel.setText("Enter Username:");

    usernameField = new Text(authPanel, SWT.BORDER);

    usernameField.setText(getDBConnectionWizard().getUser());
    usernameField.addVerifyListener(new VerifyListener() {
      public void verifyText(VerifyEvent e) {
      }
    });
    final GridData gd_usernameField = new GridData(SWT.FILL, SWT.CENTER, true, false);
    usernameField.setLayoutData(gd_usernameField);

    final Label enterPasswordLabel = new Label(authPanel, SWT.NONE);
    enterPasswordLabel.setText("Enter Password");

    passwordField = new Text(authPanel, SWT.BORDER | SWT.PASSWORD);
    final GridData gd_passwordField = new GridData(SWT.FILL, SWT.CENTER, true, false);
    passwordField.setLayoutData(gd_passwordField);
    passwordField.setText(getDBConnectionWizard().getPassword());
    new Label(container, SWT.NONE);
    boolean reqd = getDBConnectionWizard().isAuthRequired();
    if (reqd) {
      combo.select(0);
      authPanel.setVisible(true);
    } else {
      combo.select(1);
      authPanel.setVisible(false);
    }
    setPageComplete(true);
  }

  public String getUsername() {
    return usernameField.getText();
  }

  public String getPassword() {
    return passwordField.getText();
  }

  public boolean isAuthRequired() {
    return combo.getSelectionIndex() == 0;
  }

}
