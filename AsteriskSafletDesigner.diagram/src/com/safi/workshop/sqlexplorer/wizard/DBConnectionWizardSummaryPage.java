package com.safi.workshop.sqlexplorer.wizard;

import java.sql.Connection;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;

public class DBConnectionWizardSummaryPage extends DBConnectionWizardPage {

  private Label usernameValue;
  private Label authPasswordValue;
  private Label authRequiredValue;
  private Label connNameValue;
  private Label connectionURLLabel;

  /**
   * Create the wizard
   */
  public DBConnectionWizardSummaryPage() {
    super("SummaryPage");
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
    gridLayout.marginTop = 20;
    gridLayout.marginLeft = 90;
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    //
    setControl(container);

    final Label databaseConnectionUrlLabel = new Label(container, SWT.NONE);
    databaseConnectionUrlLabel.setText("Database connection URL:");

    connectionURLLabel = new Label(container, SWT.NONE);
    connectionURLLabel.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));
    final GridData gd_connectionURLLabel = new GridData(SWT.FILL, SWT.CENTER, true, false);
    connectionURLLabel.setLayoutData(gd_connectionURLLabel);

    final Label userNameLabel = new Label(container, SWT.NONE);
    userNameLabel.setText("User name:");

    usernameValue = new Label(container, SWT.NONE);
    usernameValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    usernameValue.setText("okgood");
    usernameValue.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));

    final Label passwordLabel = new Label(container, SWT.NONE);
    passwordLabel.setText("Password:");

    authPasswordValue = new Label(container, SWT.NONE);
    authPasswordValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    authPasswordValue.setText("ok");
    authPasswordValue.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));

    final Label label_3 = new Label(container, SWT.NONE);
    label_3.setText("Auth required:");

    authRequiredValue = new Label(container, SWT.NONE);
    authRequiredValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    authRequiredValue.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));

    final Label connNameLabel = new Label(container, SWT.NONE);
    connNameLabel.setText("ConnectionName");

    connNameValue = new Label(container, SWT.NONE);
    connNameValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    connNameValue.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLUE));

    final Button testConnectionButton = new Button(container, SWT.NONE);
    testConnectionButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        String result = testConnection();
        if (result == null)
          MessageDialog.openInformation(getShell(), "Test Connection", "Connection Established");
        else
          MessageDialog.openError(getShell(), "Test Connection",
              "Connection could not be established: " + result);

      }
    });
    final GridData gd_testConnectionButton = new GridData(SWT.LEFT, SWT.BOTTOM, false, false);
    gd_testConnectionButton.verticalIndent = 20;
    testConnectionButton.setLayoutData(gd_testConnectionButton);
    testConnectionButton.setText("Test Connection");
    new Label(container, SWT.NONE);

  }

  @Override
  public void activate() {
    final DBConnectionWizard wiz = getDBConnectionWizard();
    String user = wiz.getAuthPage().getUsername();
    String password = wiz.getAuthPage().getPassword();
    usernameValue.setText(user == null ? "" : user);
    authPasswordValue.setText(password == null ? "" : password);
    String authRequired = String.valueOf(wiz.getAuthPage().isAuthRequired());
    authRequiredValue.setText(authRequired);
    String connectionName = wiz.getNamePage().getConnectionName();
    connNameValue.setText(connectionName);
    String constructUrl = wiz.constructUrl();
    connectionURLLabel.setText(constructUrl == null ? "" : constructUrl);
  }

  private String testConnection() {
    Connection connection = null;
    try {
      final DBConnectionWizard wiz = getDBConnectionWizard();
      String testUrl = wiz.constructUrl();
      if (StringUtils.isBlank(testUrl))
        return "Guide URL not available for driver " + wiz.getDriver().getId();

      boolean authReqd = wiz.getAuthPage().isAuthRequired();
      String user = wiz.getAuthPage().getUsername();
      String password = wiz.getAuthPage().getPassword();
      ManagedDriver driver = wiz.getDriver();
      if (driver == null)
        return "No driver selected.  Please select a driver";
      Properties props = wiz.getPropertiesPage().getProperties();
      if (props != null && !props.isEmpty()) {
        props = (Properties) props.clone();
      } else
        props = new Properties();

      if (authReqd) {
        props.setProperty("user", user);
        props.setProperty("password", password);
      }
      connection = driver.getJDBCConnection(testUrl, props);

      return null;
    } catch (Exception e) {
      e.printStackTrace();
      return e.getLocalizedMessage();
    } finally {
      if (connection != null)
        try {
          connection.close();
        } catch (Exception e) {
        }
    }
  }

  // private String createConnection() {
  // Connection connection = null;
  // try {
  // final DBConnectionWizard wiz = getDBConnectionWizard();
  // String guideUrl = wiz.getDriver().getDriver().getGuideUrl();
  // if (StringUtils.isBlank(guideUrl)) return
  // "Guide URL not available for driver "+wiz.getDriver().getId();
  //
  // String testUrl = wiz.constructUrl();
  // boolean authReqd = wiz.getAuthPage().isAuthRequired();
  // String user = wiz.getAuthPage().getUsername();
  // String password = wiz.getAuthPage().getPassword();
  //      
  // if (!wiz.getDriver().isDriverClassLoaded())
  // wiz.getDriver().registerSQLDriver();
  // Properties props = wiz.getPropertiesPage().getProperties();
  // if (props != null && !props.isEmpty()) {
  // props = (Properties)props.clone();
  // if (authReqd) {
  // props.setProperty("user", user);
  // props.setProperty("password", password);
  // }
  // connection = DriverManager.getConnection(testUrl, props);
  // } else {
  // if (authReqd)
  // connection = DriverManager.getConnection(testUrl, user, password);
  // else
  // connection = DriverManager.getConnection(testUrl);
  // }
  // return null;
  // } catch (Exception e) {
  // e.printStackTrace();
  // return e.getLocalizedMessage();
  // } finally {
  // if (connection != null) try {
  // connection.close();
  // } catch (Exception e) {
  // }
  // }
  // }

}
