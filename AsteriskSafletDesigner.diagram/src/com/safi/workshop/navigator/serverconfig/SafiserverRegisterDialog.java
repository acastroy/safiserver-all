package com.safi.workshop.navigator.serverconfig;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.progress.ProgressMonitorJobsDialog;

import com.safi.db.manager.DBManager;
import com.safi.db.server.config.SafiServer;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.preferences.PreferenceConstants;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.util.SafletPersistenceManager;

public class SafiserverRegisterDialog extends Dialog {
  private Text sshPortField;
  private Text passwordText;
  private Text userText;
  private Text hostText;

  private String sshIP;
  private String sshUser;
  int sshPort = -1;
  private Text dbPortText;
  private Text text_1;

  // private SafiServer safiServer;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public SafiserverRegisterDialog(Shell parentShell) {
    super(parentShell);
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    container.setLayout(new GridLayout());

    //
    IPreferenceStore store = SafiServerPlugin.getDefault().getPreferenceStore();

    CTabFolder tabFolder = new CTabFolder(container, SWT.BORDER);
    tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(
        SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));

    CTabItem tbtmBasicConnectionSettings = new CTabItem(tabFolder, SWT.NONE);
    tbtmBasicConnectionSettings.setText("Basic Connection Settings");

    final Composite productionSafiserverConfigurationGroup = new Composite(tabFolder, SWT.NONE);
    tbtmBasicConnectionSettings.setControl(productionSafiserverConfigurationGroup);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    productionSafiserverConfigurationGroup.setLayout(gridLayout);

    final Label safiserverIpLabel = new Label(productionSafiserverConfigurationGroup, SWT.NONE);
    safiserverIpLabel.setToolTipText("IP address of the SafiServer");
    safiserverIpLabel.setText("SafiServer IP or Hostname:");

    hostText = new Text(productionSafiserverConfigurationGroup, SWT.BORDER);
    GridData gd_text_safi_host = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text_safi_host.widthHint = 50;
    hostText.setLayoutData(gd_text_safi_host);

    final Label safiserverIpLabel_1_2 = new Label(productionSafiserverConfigurationGroup, SWT.NONE);
    safiserverIpLabel_1_2.setToolTipText("Port utilized by SafiServer database");
    safiserverIpLabel_1_2.setText("SafiServer Port:");

    sshPortField = new Text(productionSafiserverConfigurationGroup, SWT.BORDER);
    final GridData gd_sshPortField = new GridData(SWT.LEFT, SWT.CENTER, true, false);
    sshPortField.setLayoutData(gd_sshPortField);

    final Label safiserverIpLabel_1 = new Label(productionSafiserverConfigurationGroup, SWT.NONE);
    safiserverIpLabel_1.setText("SafiServer User Name:");

    userText = new Text(productionSafiserverConfigurationGroup, SWT.BORDER);
    GridData gd_text_safi_user = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text_safi_user.widthHint = 150;
    userText.setLayoutData(gd_text_safi_user);

    final Label safiserverIpLabel_1_1 = new Label(productionSafiserverConfigurationGroup, SWT.NONE);
    safiserverIpLabel_1_1.setText("SafiServer Password :");

    passwordText = new Text(productionSafiserverConfigurationGroup, SWT.BORDER | SWT.PASSWORD);
    passwordText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    CTabItem tbtmAdvanced = new CTabItem(tabFolder, SWT.NONE);
    tbtmAdvanced.setText("Advanced");

    final Composite group = new Composite(tabFolder, SWT.NONE);
    tbtmAdvanced.setControl(group);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 2;
    group.setLayout(gridLayout_1);

    Label lblSafiserverDatabasePort = new Label(group, SWT.NONE);
    lblSafiserverDatabasePort
        .setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
    lblSafiserverDatabasePort.setText("SafiServer Database Port:");

    dbPortText = new Text(group, SWT.BORDER);
    final GridData gd_dbPortText = new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1);
    dbPortText.setLayoutData(gd_dbPortText);

    Label lblSafiserverManagerPort = new Label(group, SWT.NONE);
    lblSafiserverManagerPort.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
    lblSafiserverManagerPort.setText("SafiServer Manager Port:");

    text_1 = new Text(group, SWT.BORDER);
    text_1.setEditable(false);
    text_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
    SafiServer server = null;
    try {
      server = SafiServerPlugin.getDefault().getSafiServer(false);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (server != null)
      text_1.setText(String.valueOf(server.getManagementPort()));
    Label label = new Label(group, SWT.NONE);
    label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
    new Label(group, SWT.NONE);

    // Boolean sshEnabled =
    // store.getBoolean(PreferenceConstants.PREF_PORT_FORWARDING_ENABLED);
    // if (sshEnabled != null && sshEnabled) {
    // this.useTunnelCheckbox.setSelection(true);
    // this.setEnablePortFowarding();
    // } else {
    // this.useTunnelCheckbox.setSelection(false);
    // this.setDisablePortFowarding();
    // }

    hostText.setText(store.getString(PreferenceConstants.PREF_SAFISERVER_HOSTNAME_PROD));
    userText.setText(store.getString(PreferenceConstants.PREF_SAFISERVER_USER_PROD));
    passwordText.setText(store.getString(PreferenceConstants.PREF_SAFISERVER_PASS_PROD));
    dbPortText.setText(store.getString(PreferenceConstants.PREF_DB_PORT_PROD));
    sshPortField.setText(store.getString(PreferenceConstants.PREF_SSH_SERVER_PORT));
    return container;
  }

  // private void setEnablePortFowarding() {
  //
  // this.sshIPText.setEnabled(true);
  // this.sshPasswordText.setEnabled(true);
  // this.sshUserText.setEnabled(true);
  // this.dbPortLocalText.setEnabled(true);
  // this.sshMgmtPortLocalText.setEnabled(true);
  // this.dbPortRemoteText.setEnabled(true);
  // this.mgmtPortRemoteText.setEnabled(true);
  // this.sshPortText.setEnabled(true);
  // }
  //
  // private void setDisablePortFowarding() {
  // this.sshIPText.setEnabled(false);
  // this.sshPasswordText.setEnabled(false);
  // this.sshUserText.setEnabled(false);
  // this.dbPortLocalText.setEnabled(false);
  // this.sshMgmtPortLocalText.setEnabled(false);
  // this.dbPortRemoteText.setEnabled(false);
  // this.mgmtPortRemoteText.setEnabled(false);
  // this.sshPortText.setEnabled(false);
  // }

  /*
   * public int open() { Shell shell = getShell(); if (shell == null ||
   * shell.isDisposed()) { shell = null; // create the window create(); } shell =
   * getShell(); // limit the shell size to the display size constrainShellSize();
   * shell.pack(); // open the window shell.open();
   * 
   * // run the event loop if specified runEventLoop(shell);
   * 
   * return getReturnCode(); }
   * 
   * private void runEventLoop(Shell loopShell) { Shell shell = getShell(); //Use the
   * display provided by the shell if possible Display display; if (shell == null) {
   * display = Display.getCurrent(); } else { display = loopShell.getDisplay(); }
   * 
   * while (loopShell != null && !loopShell.isDisposed()) { try { if
   * (!display.readAndDispatch()) { display.sleep(); } } catch (Throwable e) {
   * e.printStackTrace(); } } display.update(); }
   */

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, "Login", true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT);
    // return new Point(394, 280);
  }

  @Override
  protected void configureShell(Shell newShell) {
    newShell.setMinimumSize(new Point(200, 250));
    super.configureShell(newShell);
    newShell.setText("Production SafiServer Login");
  }

  @Override
  protected void buttonPressed(int buttonId) {
    if (buttonId == IDialogConstants.CANCEL_ID) {
      cancelPressed();
      return;
    }
    if (buttonId == IDialogConstants.OK_ID) {
      if (performOK()) {
        okPressed();
      }
      return;
    }
    super.buttonPressed(buttonId);
  }

  private boolean performOK() {
    String dbport = dbPortText.getText().trim();
    String pass = passwordText.getText().trim();
    String userName = userText.getText().trim();
    String host = hostText.getText().trim();
    // boolean useTunnel = this.useTunnelCheckbox.getSelection();
    sshIP = host;
    sshUser = userName;
    IPreferenceStore store = SafiServerPlugin.getDefault().getPreferenceStore();

    // int dbPortLocal =
    // store.getInt(PreferenceConstants.PREF_SSH_FORWARDING_DB_PORT_LOCAL);
    // if (dbPortLocal <= 0 || !Utils.isServerPortAvail(dbPortLocal)) {
    // try {
    // dbPortLocal = Utils.findFreePort();
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    // int sshMgmtPortLocal = store
    // .getInt(PreferenceConstants.PREF_SSH_FORWARDING_MANAGEMENT_PORT_LOCAL);
    // if (sshMgmtPortLocal <= 0 || !Utils.isServerPortAvail(sshMgmtPortLocal)) {
    // try {
    // sshMgmtPortLocal = Utils.findFreePort();
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }

    String sshPortStr = this.sshPortField.getText().trim();
    sshPort = -1;

    if (host.length() == 0) {
      MessageBox mb = new MessageBox(this.getShell(), SWT.ICON_ERROR);
      mb.setMessage("Please type valid host name");
      mb.setText("Warning! Missing host name");
      mb.open();
      return false;
    }

    if (userName.length() == 0) {
      MessageBox mb = new MessageBox(this.getShell(), SWT.ICON_ERROR);
      mb.setMessage("Please type valid user name");
      mb.setText("Warning! Missing user name");
      mb.open();
      return false;
    }

    int intdbport = -1;
    if (dbport.length() == 0) {
      MessageBox mb = new MessageBox(this.getShell(), SWT.ICON_ERROR);
      mb.setMessage("Please type valid database portnumber");
      mb.setText("Warning! Missing DB port #");
      mb.open();
      return false;
    } else {
      try {
        intdbport = Integer.parseInt(dbport);
      } catch (Exception ex) {
        MessageBox mb = new MessageBox(this.getShell(), SWT.ICON_ERROR);
        mb.setMessage("Please type valid database portnumber");
        mb.setText("Warning! Missing DB port #");
        mb.open();
        return false;
      }
    }

    if (sshIP.length() == 0) {
      MessageBox mb = new MessageBox(this.getShell(), SWT.ICON_ERROR);
      mb.setMessage("Please type valid ssh host name");
      mb.setText("Warning! Missing ssh host name");
      mb.open();
      return false;
    }

    if (sshUser.length() == 0) {
      MessageBox mb = new MessageBox(this.getShell(), SWT.ICON_ERROR);
      mb.setMessage("Please type valid ssh user name");
      mb.setText("Warning! Missing ssh user name");
      mb.open();
      return false;
    }

    // if (sshPass.length() == 0) {
    // MessageBox mb = new MessageBox(this.getShell(), SWT.ICON_ERROR);
    // mb.setMessage("Please type valid ssh password");
    // mb.setText("Warning! Missing ssh password");
    // mb.open();
    // return false;
    // }

    if (sshPortStr.length() == 0) {
      MessageBox mb = new MessageBox(this.getShell(), SWT.ICON_ERROR);
      mb.setMessage("Please type valid local portnumber for SSH Server");
      mb.setText("Warning! Missing Server port #");
      mb.open();
      return false;
    } else {
      try {
        sshPort = Integer.parseInt(sshPortStr);
      } catch (Exception ex) {
        MessageBox mb = new MessageBox(this.getShell(), SWT.ICON_ERROR);
        mb.setMessage("Please type valid local portnumber for SSH Server");
        mb.setText("Warning! Missing Server port #");
        mb.open();
        return false;
      }
    }

    // this.safiServer.setBindIP(host);

    // User user = this.safiServer.getUser();
    // if (user != null) {
    // user.setName(userName);
    // user.setPassword(pass);
    // }

    // this.safiServer.setDbPort(intdbport);

    final String oldHost = store.getString(PreferenceConstants.PREF_SAFISERVER_HOSTNAME_PROD);
    store.setValue(PreferenceConstants.PREF_SAFISERVER_HOSTNAME_PROD, host);
    store.setValue(PreferenceConstants.PREF_SAFISERVER_USER_PROD, userName);
    store.setValue(PreferenceConstants.PREF_SAFISERVER_PASS_PROD, pass);
    store.setValue(PreferenceConstants.PREF_DB_PORT_PROD, dbport);

    // store.setValue(PreferenceConstants.PREF_SSH_SERVER, sshIP);
    // store.setValue(PreferenceConstants.PREF_SSH_USER, sshUser);
    store.setValue(PreferenceConstants.PREF_SSH_SERVER_PORT, sshPort);
    // store.setValue(PreferenceConstants.PREF_SSH_PASSWORD, sshPass);
    // store.setValue(PreferenceConstants.PREF_SSH_FORWARDING_DB_PORT_LOCAL, dbPortLocal);
    // store.setValue(PreferenceConstants.PREF_SSH_FORWARDING_MANAGEMENT_PORT_LOCAL,
    // sshMgmtPortLocal);
    // store.setValue(PreferenceConstants.PREF_SSH_FORWARDING_DB_PORT_REMOTE,
    // sshDBPortRemote);
    // store.setValue(PreferenceConstants.PREF_SSH_FORWARDING_MANAGEMENT_PORT_LOCAL,
    // sshMgmtPortLocal);
    // store.setValue(PreferenceConstants.PREF_SSH_FORWARDING_MANAGEMENT_PORT_REMOTE,
    // sshMgmtPortRemote);

    // store.setValue(PreferenceConstants.PREF_PORT_FORWARDING_ENABLED, true);
    // try {
    // SafiServerPlugin.getDefault().updateServerResources();
    // } catch (Exception e) {
    // e.printStackTrace();
    // MessageDialog.openError(getShell(), "Connect Error",
    // "Couldn't connect to SafiServer: "+e.getLocalizedMessage());
    // return false;
    // }
    // if (useTunnel) {
    //
    // try {
    // // this is not working yet.
    // JSch jsch = new JSch();
    // Session session = jsch.getSession(sshUser, sshIP, sshPort);
    // MyUserInfo2 ui = new MyUserInfo2();
    // ui.setPassword(sshPass);
    // session.setUserInfo(ui);
    // session.connect();
    // int assinged_port1 = session.setPortForwardingL(this.sshDBPortNum, sshIP,
    // this.sshDBPortRemote);
    // //
    // System.out.println("local:"+this.ssh_dbport_num_local+" ssh_ip:"+ssh_ip+" dbport:"+this.ssh_dbport_num_remote);
    //
    // int assinged_port2 = session.setPortForwardingL(this.sshMgmtPort, sshIP,
    // this.sshMgmtPortRemote);
    // //
    // System.out.println("local:"+this.ssh_fastport_num_local+" ssh_ip:"+ssh_ip+" fastport:"+this.ssh_fastport_num_remote);
    //
    // } catch (JSchException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    //
    // }

    IRunnableWithProgress job = new IRunnableWithProgress() {

      @Override
      public void run(IProgressMonitor monitor) {

        try {
          if (!StringUtils.equals(oldHost, sshIP) && SafletPersistenceManager.getInstance().hasConnectedResources()) {
            Display.getDefault().asyncExec(new Runnable() {
              @Override
              public void run() {
                if (MessageDialog.openQuestion(getShell(), "Disconnect Resources?",
                    "One or more Workspace resources exist on the current SafiServer instance. "
                        + "Do you want to disconnect these resources from the SafiServer?")) {
                  SafletPersistenceManager.getInstance().disconnectLocalResources();
                }
              }
            });
          }

          DBManager.getInstance().resetLastConnectionAttempt();
          SafiServerPlugin.getDefault().disconnectSSHTunnel();
          SafiServerPlugin.getDefault().disconnectManagement();
          SafiServerPlugin.getDefault().updateServerResources(monitor);

          // return new Status(IStatus.OK, getClass().getName(), IStatus.OK,
          // "Server Resources Initialized", null);
        } catch (final Exception e) {
          e.printStackTrace();

          Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
              // TODO Auto-generated method stub
              MessageDialog.openError(getShell(), "Update Error",
                  "Couldn't update SafiServer settings: "
                      + (e.getCause() != null ? e.getCause().getLocalizedMessage() : e
                          .getLocalizedMessage()));
              AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged();

            }
          });

          // return new Status(Status.ERROR, AsteriskDiagramEditorPlugin.ID ,
          // "Couldn't load driver manager", e);
        }

      }
    };
    ProgressMonitorJobsDialog dialog = new ProgressMonitorJobsDialog(getShell());
    try {
      dialog.run(true, true, job);
    } catch (InvocationTargetException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return false;
    }
    // job.setUser(true);
    // Progress
    // job.schedule();
    return true;
  }

}
