/*
 * Copyright (C) 2007 SQL Explorer Development Team
 * http://sourceforge.net/projects/eclipsesql
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package com.safi.workshop.sqlexplorer.dialogs;

import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.TreeSet;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import com.safi.db.DBConnection;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.SafiWorkshopEditorUtil;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.DriverManager;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.preferences.DriverMaintenanceDialog;
import com.safi.workshop.sqlexplorer.util.ImageUtil;
import com.safi.workshop.sqlexplorer.wizard.DBConnectionWizard;
import com.safi.workshop.sqlexplorer.wizard.DBConnectionWizardDialog;

/**
 * Modified by Davy Vanherbergen to include metadata filter expression.
 * 
 */
public class CreateAliasDlg extends TitleAreaDialog {

  private static final int SIZING_TEXT_FIELD_WIDTH = 250;

  public enum Type {
    CREATE, CHANGE, COPY
  }

  private Type type;
  private Alias alias;
  private HashMap<Integer, ManagedDriver> comboDriverIndexes = new HashMap<Integer, ManagedDriver>();

  private Text nameField;
  private Combo cboDriver;
  private Text urlField;
  private Button noUsernameRequired;
  private Text userField;
  private Text passwordField;
  private Button commitOnCloseButton;
  private Spinner minSpinner;
  private Spinner maxSpinner;
  private Spinner incSpinner;
  private Spinner idleSpinner;
  private Spinner timeoutSpinner;
  private PropertyEditorDialog propertyDialog;
  private Properties localProperties;
  private ManagedDriver navSelectedDriver;

  public CreateAliasDlg(Shell parentShell, Type type, Alias alias, ManagedDriver driver) {
    super(parentShell);
    this.alias = alias;
    this.type = type;
    navSelectedDriver = driver;
  }

  @Override
  protected void configureShell(Shell shell) {

    super.configureShell(shell);
    if (type == Type.CREATE) {
      shell.setText(Messages.getString("AliasDialog.Create.Title")); //$NON-NLS-1$
    } else if (type == Type.CHANGE) {
      shell.setText(Messages.getString("AliasDialog.Change.Title")); //$NON-NLS-1$
    } else if (type == Type.COPY) {
      shell.setText(Messages.getString("AliasDialog.Copy.Title")); //$NON-NLS-1$
    }
  }

  @Override
  protected void createButtonsForButtonBar(Composite parent) {

    super.createButtonsForButtonBar(parent);
    validate();
  }

  @Override
  protected Control createContents(Composite parent) {

    Control contents = super.createContents(parent);

    if (type == Type.CREATE) {
      setTitle("Create a new database connection"); //$NON-NLS-1$
    } else if (type == Type.CHANGE) {
      setTitle(Messages.getString("AliasDialog.Change.Title")); //$NON-NLS-1$
      setMessage("Modify the database connection"); //$NON-NLS-1$			
    } else if (type == Type.COPY) {
      setTitle(Messages.getString("AliasDialog.Copy.Title")); //$NON-NLS-1$
      setMessage("Copy the database connection"); //$NON-NLS-1$						
    }

    Image image = ImageUtil.getImage("Images.WizardLogo");
    if (image != null) {
      setTitleImage(image);
    }
    contents.addDisposeListener(new DisposeListener() {

      public void widgetDisposed(DisposeEvent e) {

        ImageUtil.disposeImage("Images.WizardLogo");
      }
    });
    return contents;
  }

  @Override
  protected Control createDialogArea(Composite parent) {

    // top level composite
    Composite parentComposite = (Composite) super.createDialogArea(parent);

    // create a composite with standard margins and spacing
    Composite composite = new Composite(parentComposite, SWT.NONE);
    GridLayout layout = new GridLayout();
    layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
    layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
    layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
    layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
    composite.setLayout(layout);
    final GridData gd_composite = new GridData(SWT.FILL, SWT.FILL, true, true);
    gd_composite.heightHint = 350;
    composite.setLayoutData(gd_composite);
    composite.setFont(parentComposite.getFont());

    Composite nameGroup = new Composite(composite, SWT.NONE);
    layout = new GridLayout();
    layout.numColumns = 3;
    layout.marginWidth = 10;
    nameGroup.setLayout(layout);
    GridData data = new GridData(SWT.FILL, SWT.TOP, true, false);
    data.heightHint = 345;
    nameGroup.setLayoutData(data);

    Label label = new Label(nameGroup, SWT.WRAP);
    label.setText("Name"); //$NON-NLS-1$
    nameField = new Text(nameGroup, SWT.BORDER);
    if (type != Type.CREATE)
      nameField.setText(alias.getName());
    data = new GridData(SWT.FILL, SWT.CENTER, true, false);
    data.widthHint = 250;
    nameField.setLayoutData(data);
    nameField.addKeyListener(new KeyListener() {

      public void keyPressed(org.eclipse.swt.events.KeyEvent e) {

        CreateAliasDlg.this.validate();
      };

      public void keyReleased(org.eclipse.swt.events.KeyEvent e) {

        CreateAliasDlg.this.validate();
      };
    });

    final Button wizardButton = new Button(nameGroup, SWT.NONE);
    wizardButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        final DBConnectionWizard connectionWizard = new DBConnectionWizard();
        connectionWizard.setAlias(alias);
        connectionWizard.setDriver(getSelectedDriver());
        connectionWizard.setAuthRequired(!noUsernameRequired.getSelection());
        connectionWizard.setUser(userField.getText());
        connectionWizard.setConnectionName(nameField.getText());
        connectionWizard.setPassword(passwordField.getText());
        connectionWizard.setProperties(localProperties);
        connectionWizard.setUrl(urlField.getText());
        WizardDialog dialog = new DBConnectionWizardDialog(getShell(), connectionWizard);
        int result = dialog.open();
        if (Window.OK == result) {
          urlField.setText(connectionWizard.getUrl());
          userField.setText(connectionWizard.getUser());
          passwordField.setText(connectionWizard.getPassword());
          noUsernameRequired.setSelection(!connectionWizard.isAuthRequired());
          nameField.setText(connectionWizard.getConnectionName());
        }
        validate();
      }
    });
    wizardButton.setToolTipText("Open Database Connection Wizard");
    /*
     * wizardButton.setImage(ResourceManager.getPluginImage(SQLExplorerPlugin.getDefault(),
     * "icons/new_connection.gif"));
     */
    wizardButton.setImage(AsteriskDiagramEditorPlugin.getDefault().getBundledImage(
        "icons/DBCreationWizard.gif"));

    final GridData gd_wizardButton = new GridData(SWT.CENTER, SWT.CENTER, true, false);
    wizardButton.setLayoutData(gd_wizardButton);

    Label label2 = new Label(nameGroup, SWT.WRAP);
    label2.setText("Driver"); //$NON-NLS-1$
    cboDriver = new Combo(nameGroup, SWT.BORDER | SWT.DROP_DOWN | SWT.READ_ONLY);
    final GridData gd_driver = new GridData(GridData.HORIZONTAL_ALIGN_FILL
        | GridData.GRAB_HORIZONTAL);
    gd_driver.widthHint = SIZING_TEXT_FIELD_WIDTH;
    cboDriver.setLayoutData(gd_driver);

    String defaultDriverName = AsteriskDiagramEditorPlugin.getDefault().getPluginPreferences()
        .getString(IConstants.DEFAULT_DRIVER);
    ManagedDriver defaultDriver = null;
    int defaultDriverIndex = 0;
    populateCombo();
    for (Entry<Integer, ManagedDriver> entry : comboDriverIndexes.entrySet()) {
      ManagedDriver driver = entry.getValue();
      if (driver.getId().startsWith(defaultDriverName)) {
        defaultDriver = driver;
        defaultDriverIndex = entry.getKey();
        break;
      }
    }

    Button btnListDrivers = new Button(nameGroup, SWT.NULL);
    btnListDrivers.setText(Messages.getString("AliasDialog.EditDrivers")); //$NON-NLS-1$
    final GridData gd_btnListDrivers = new GridData(GridData.HORIZONTAL_ALIGN_FILL
        | GridData.GRAB_HORIZONTAL);
    btnListDrivers.setLayoutData(gd_btnListDrivers);
    btnListDrivers.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent event) {
        DriverMaintenanceDialog dlg = new DriverMaintenanceDialog(SafiWorkshopEditorUtil
            .getActiveShell());
        int result = dlg.open();
        if (result == Window.OK) {
          populateCombo();
          SafiWorkshopEditorUtil.getSafiNavigator().refresh();
        }
      }
    });

    Label label3 = new Label(nameGroup, SWT.WRAP);
    label3.setText("URL"); //$NON-NLS-1$
    urlField = new Text(nameGroup, SWT.BORDER);
    data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
    data.horizontalSpan = 2;
    data.widthHint = SIZING_TEXT_FIELD_WIDTH;
    urlField.setLayoutData(data);
    urlField.addKeyListener(new KeyListener() {

      public void keyPressed(org.eclipse.swt.events.KeyEvent e) {

        CreateAliasDlg.this.validate();
      };

      public void keyReleased(org.eclipse.swt.events.KeyEvent e) {

        CreateAliasDlg.this.validate();
      };
    });
    new Label(nameGroup, SWT.NONE);

    noUsernameRequired = new Button(nameGroup, SWT.CHECK);
    noUsernameRequired.setText("Username is not required for this database");
    new Label(nameGroup, SWT.NONE);

    Label label4 = new Label(nameGroup, SWT.WRAP);
    label4.setText("User Name"); //$NON-NLS-1$
    userField = new Text(nameGroup, SWT.BORDER);
    data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
    data.horizontalSpan = 2;
    data.widthHint = SIZING_TEXT_FIELD_WIDTH;
    userField.setLayoutData(data);

    userField.addKeyListener(new KeyListener() {

      public void keyPressed(org.eclipse.swt.events.KeyEvent e) {

        CreateAliasDlg.this.validate();
      };

      public void keyReleased(org.eclipse.swt.events.KeyEvent e) {

        CreateAliasDlg.this.validate();
      };
    });

    Label label5 = new Label(nameGroup, SWT.WRAP);
    label5.setText("Password"); //$NON-NLS-1$
    passwordField = new Text(nameGroup, SWT.BORDER);
    passwordField.setEchoChar('*');
    data = new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL);
    data.horizontalSpan = 2;
    data.widthHint = SIZING_TEXT_FIELD_WIDTH;
    passwordField.setLayoutData(data);

    cboDriver.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(org.eclipse.swt.events.SelectionEvent e) {
        ManagedDriver driver = getSelectedDriver();
        urlField.setText(driver.getUrl());
        CreateAliasDlg.this.validate();
        wizardButton.setEnabled(true);
      };
    });

    if (!comboDriverIndexes.isEmpty() && defaultDriver != null) {
      cboDriver.select(defaultDriverIndex);
      urlField.setText(defaultDriver.getUrl());
    }
    new Label(nameGroup, SWT.NONE);

    final Composite connectionPropertiesComposite = new Composite(nameGroup, SWT.NONE);
    connectionPropertiesComposite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 3;
    connectionPropertiesComposite.setLayout(gridLayout);
    new Label(nameGroup, SWT.NONE);
    /* final Button */
    /* final Button *//* final Button */
    /* final Button */new Label(nameGroup, SWT.NONE);
    User user = alias.getDefaultUser();

    final Label connectTimeoutLabel = new Label(connectionPropertiesComposite, SWT.NONE);
    connectTimeoutLabel.setText("Connect timeout(sec)");

    timeoutSpinner = new Spinner(connectionPropertiesComposite, SWT.BORDER);
    timeoutSpinner.setLayoutData(new GridData());
    DBConnection connection = alias.getConnection();
    timeoutSpinner.setSelection(connection.getLoginTimeout());
    commitOnCloseButton = new Button(connectionPropertiesComposite, SWT.CHECK);
    commitOnCloseButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
    commitOnCloseButton.setToolTipText("Sets the default for new SQL editors");
    commitOnCloseButton.setText("Commit on close");
    if (user != null) {

      commitOnCloseButton.setEnabled(!user.isAutoCommit());
      commitOnCloseButton.setSelection(user.isCommitOnClose());
    }
    noUsernameRequired.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        userField.setEnabled(!noUsernameRequired.getSelection());
        passwordField.setEnabled(!noUsernameRequired.getSelection());
      }
    });

    if (alias.hasNoUserName()) {
      noUsernameRequired.setSelection(true);
      userField.setEnabled(false);
      passwordField.setEnabled(false);
    } else {
      noUsernameRequired.setSelection(false);
      userField.setEnabled(true);
      passwordField.setEnabled(true);
      if (alias.getDefaultUser() != null) {
        String userName = alias.getDefaultUser().getUserName();
        userField.setText(userName == null ? "" : userName);
        String password = alias.getDefaultUser().getPassword();
        passwordField.setText(password == null ? "" : password);
      }
    }

    wizardButton.setEnabled(false);
    if (type != Type.CREATE) {

      if (alias.getDriver() != null) {
        cboDriver.setText(alias.getDriver().getId());
        wizardButton.setEnabled(true);
      }
      urlField.setText(alias.getUrl());
      Properties props = alias.getConnection().getProperties();
      if (props != null)
        localProperties = (Properties) props.clone();
      else
        localProperties = new Properties();
    } else {
      localProperties = new Properties();
      if (navSelectedDriver != null) {
        cboDriver.select(cboDriver.indexOf(navSelectedDriver.getId()));
        urlField.setText(navSelectedDriver.getUrl());
        wizardButton.setEnabled(true);
      }
    }

    final Group pool = new Group(nameGroup, SWT.NONE);
    pool.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));
    pool.setText("Pool info");
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 4;
    pool.setLayout(gridLayout_1);

    final Label minLabel = new Label(pool, SWT.NONE);
    minLabel.setText("Min");

    minSpinner = new Spinner(pool, SWT.BORDER);
    minSpinner.setSelection(connection.getMinPoolSize());
    final Label maxLabel = new Label(pool, SWT.NONE);
    maxLabel.setText("Max");

    maxSpinner = new Spinner(pool, SWT.BORDER);
    maxSpinner.setSelection(connection.getMaxPoolSize());
    final Label acquireInc = new Label(pool, SWT.NONE);
    final GridData gd_acquireInc = new GridData();
    acquireInc.setLayoutData(gd_acquireInc);
    acquireInc.setText("Increment");

    incSpinner = new Spinner(pool, SWT.BORDER);
    incSpinner.setSelection(connection.getAcquireIncrement());
    final Label maxIdlesecLabel = new Label(pool, SWT.NONE);
    maxIdlesecLabel.setText("Max Idle (sec)");

    idleSpinner = new Spinner(pool, SWT.BORDER);
    idleSpinner.setSelection(connection.getMaxIdleTime());
    new Label(nameGroup, SWT.NONE);
    new Label(nameGroup, SWT.NONE);

    final Composite composite_1 = new Composite(nameGroup, SWT.NONE);
    composite_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false, 2, 1));
    final GridLayout gridLayout_2 = new GridLayout();
    gridLayout_2.marginTop = 10;
    gridLayout_2.numColumns = 2;
    composite_1.setLayout(gridLayout_2);

    final Button editAdditionalPropertiesButton = new Button(composite_1, SWT.NONE);
    final GridData gd_editAdditionalPropertiesButton = new GridData(SWT.RIGHT, SWT.CENTER, false,
        false);
    gd_editAdditionalPropertiesButton.widthHint = 120;
    editAdditionalPropertiesButton.setLayoutData(gd_editAdditionalPropertiesButton);
    editAdditionalPropertiesButton.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        if (propertyDialog == null) {
          propertyDialog = new PropertyEditorDialog(getShell(), localProperties);
          propertyDialog.open();

        } else {
          propertyDialog.open();
        }
      }
    });
    editAdditionalPropertiesButton.setText("Additional Properties");

    final Button testconnectionButton = new Button(composite_1, SWT.NONE);
    final GridData gd_testconnectionButton = new GridData(SWT.RIGHT, SWT.CENTER, false, false);
    gd_testconnectionButton.widthHint = 120;
    testconnectionButton.setLayoutData(gd_testconnectionButton);
    testconnectionButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        String result = createConnection();
        if (result == null)
          MessageDialog.openInformation(getShell(), "Test Connection", "Connection Established");
        else
          MessageDialog.openError(getShell(), "Test Connection",
              "Connection could not be established: " + result);
      }
    });
    testconnectionButton.setText("Test Connection");
    new Label(nameGroup, SWT.NONE);
    return parentComposite;
  }

  private void populateCombo() {
    String previous = cboDriver.getText();
    if (previous != null) {
      previous = previous.trim();
      if (previous.length() == 0)
        previous = null;
    }
    if (previous != null)
      previous = previous.toLowerCase();
    DriverManager driverModel = SQLExplorerPlugin.getDefault().getDriverModel();
    cboDriver.removeAll();
    TreeSet<ManagedDriver> drivers = new TreeSet<ManagedDriver>();
    drivers.addAll(driverModel.getDrivers());
    int index = 0;
    for (ManagedDriver driver : drivers) {
      try {
        driver.registerSQLDriver();
      } catch (ClassNotFoundException e) {
        // Nothing
      }
      if (driver.isDriverClassLoaded() == true) {
        cboDriver.add(driver.getId());
        comboDriverIndexes.put(new Integer(index), driver);
        if (previous != null && driver.getId().toLowerCase().startsWith(previous))
          cboDriver.select(index);
        index++;
      }
    }
  }

  private String createConnection() {
    Connection connection = null;
    try {

      String testUrl = urlField.getText();

      boolean authReqd = !noUsernameRequired.getSelection();
      String user = userField.getText();
      String password = passwordField.getText();
      ManagedDriver driver = getSelectedDriver();
      if (driver == null)
        return "No driver selected.  Please select a driver";
      Properties props = localProperties;
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

  @Override
  protected void okPressed() {

    try {
      User previousUser = alias.getDefaultUser();
      String oldName = alias.getName();
      alias.setName(nameField.getText().trim());
      ManagedDriver driver = getSelectedDriver();
      alias.setDriver(driver);
      alias.setUrl(urlField.getText().trim());
      if (noUsernameRequired.getSelection())
        alias.setHasNoUserName(true);
      else {
        alias.setHasNoUserName(false);
        if (userField.getText().trim().length() > 0)
          alias
              .setDefaultUser(new User(userField.getText().trim(), passwordField.getText().trim()));

      }
      alias.setSchemaFilterExpression("");
      alias.setNameFilterExpression("");
      alias.setFolderFilterExpression("");

      DBConnection conn = alias.getConnection();
      conn.setAcquireIncrement(incSpinner.getSelection());
      conn.setLoginTimeout(timeoutSpinner.getSelection());
      conn.setMaxIdleTime(idleSpinner.getSelection());
      conn.setMaxPoolSize(maxSpinner.getSelection());
      conn.setMinPoolSize(minSpinner.getSelection());
      conn.setLastModified(new Date());

      if (type != Type.CHANGE) {
        alias.getConnection().setProperties(localProperties);

        SQLExplorerPlugin.getDefault().getAliasManager().addAlias(alias, true);

      }

      // If we changed the default user and the previous default user is not in use,
      // remove it (note: Alias maintains one User instance per username, merging
      // new additions into the existing instance which is why it is valid to compare
      // objects even though we have explicitly created a new instance of User above)
      else {
        Properties props = alias.getConnection().getProperties();
        if (props != null) {
          props.clear();
          props.putAll(localProperties);
        } else
          alias.getConnection().setProperties(localProperties);

        if (alias.getDefaultUser() != previousUser) {
          alias.removeUser(previousUser);
        }
        SQLExplorerPlugin.getDefault().getAliasManager().removeAlias(oldName, false);
        SQLExplorerPlugin.getDefault().getAliasManager().addAlias(alias, true);
        // if (oldName != null && !oldName.equals(alias.getName())) {
        // // SQLExplorerPlugin.getDefault().getAliasManager().getAlias(oldName);
        // if (alias.getDefaultUser() != previousUser && !previousUser.isInUse())
        // alias.removeUser(previousUser);
        // SQLExplorerPlugin.getDefault().getAliasManager().removeAlias(oldName, false);
        // SQLExplorerPlugin.getDefault().getAliasManager().addAlias(alias, true);
        // }

      }

      User user = alias.getDefaultUser();
      if (user != null) {
        user.setCommitOnClose(commitOnCloseButton.getSelection());
      }

    } catch (ExplorerException excp) {
      SQLExplorerPlugin.error("Validation Exception", excp);//$NON-NLS-1$
      // System.out.println(Messages.getString("Error_Validation_Exception_4"));//$NON-NLS-1$
    }

    if (type == Type.CHANGE) {
      SQLExplorerPlugin.getDefault().saveDBResources(false);
    }
    // Notify that ther has been changes
    SQLExplorerPlugin.getDefault().getAliasManager().modelChanged();

    close();
  }

  private ManagedDriver getSelectedDriver() {
    int selIndex = cboDriver.getSelectionIndex();
    ManagedDriver driver = comboDriverIndexes.get(selIndex);
    return driver;
  }

  protected void setDialogComplete(boolean value) {

    Button okBtn = getButton(IDialogConstants.OK_ID);
    if (okBtn != null)
      okBtn.setEnabled(value);
  }

  @Override
  protected void setShellStyle(int newShellStyle) {

    super.setShellStyle(newShellStyle | SWT.RESIZE);// Make the dialog
    // resizable
  }

  void validate() {
    
    if ((urlField.getText().trim().length() > 0) && (nameField.getText().trim().length() > 0)
        && (cboDriver.getSelectionIndex() >= 0)){
      String conName=this.nameField.getText().trim();
     if(conName.contains(".")){
    	 setDialogComplete(false);
    	 this.setErrorMessage("Connection Name should not contain \".\"");
    	 return;
     }
        
        this.setErrorMessage(null);
        this.setMessage("");
    	setDialogComplete(true);
    }
    else
      setDialogComplete(false);
  }

}
