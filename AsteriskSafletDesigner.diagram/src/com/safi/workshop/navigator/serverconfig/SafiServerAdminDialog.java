package com.safi.workshop.navigator.serverconfig;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.progress.ProgressMonitorJobsDialog;

import com.safi.db.server.config.SafiServer;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.DBManager;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.preferences.PreferenceConstants;

@Deprecated
public class SafiServerAdminDialog extends Dialog {

  private Text textDBPort;
  private Text textSafiServer;
  private Text textSafiMgtPort;
  private Text textSafiAgiPort;
  private CCombo bindIPCombo;
  private boolean isEnabled = true;
  private SafiServer safiServer;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public SafiServerAdminDialog(Shell parentShell, SafiServer server) {
    super(parentShell);
    this.safiServer = server;
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    container.setLayout(new FillLayout());

    final Group serverPropertiesGroup = new Group(container, SWT.NONE);
    serverPropertiesGroup.setText("Server Properties");
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 3;
    serverPropertiesGroup.setLayout(gridLayout);

    final Label registeredSafiserverLabel = new Label(serverPropertiesGroup, SWT.NONE);
    registeredSafiserverLabel.setText("Name:");

    textSafiServer = new Text(serverPropertiesGroup, SWT.BORDER);
    final GridData gd_text_safiserver = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    gd_text_safiserver.widthHint = 229;
    textSafiServer.setLayoutData(gd_text_safiserver);
    boolean isProd = safiServer.getId() != -1;
    textSafiServer.setEnabled(isProd);

    final Label safiserverIpLabel_2 = new Label(serverPropertiesGroup, SWT.NONE);
    safiserverIpLabel_2.setToolTipText("IP address that is reachable by the Asterisk server");
    final GridData gd_safiserverIpLabel_2 = new GridData();
    safiserverIpLabel_2.setLayoutData(gd_safiserverIpLabel_2);
    safiserverIpLabel_2.setText("Bind IP Address:");

    bindIPCombo = new CCombo(serverPropertiesGroup, SWT.BORDER);
    final GridData gd_bindIPCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    bindIPCombo.setLayoutData(gd_bindIPCombo);

    final Button bindToAllCheckbox = new Button(serverPropertiesGroup, SWT.CHECK);
    bindToAllCheckbox
        .setToolTipText("Server will attempt to bind to all available local IP addresses. Available only on Win OS's");
    bindToAllCheckbox.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        if (bindToAllCheckbox.getSelection()) {
          String[] items = bindIPCombo.getItems();
          int i = 0;
          for (; i < items.length; i++) {
            if ("0.0.0.0".equals(items[i])) {
              break;
            }
          }
          bindIPCombo.select(i);
          bindIPCombo.setEnabled(false);
        } else {
          bindIPCombo.setEnabled(true);
        }
      }
    });
    bindToAllCheckbox.setText("Bind to all");

    final Label fastagiPortLabel = new Label(serverPropertiesGroup, SWT.NONE);
    fastagiPortLabel.setLayoutData(new GridData());
    fastagiPortLabel
        .setToolTipText("Port on which the SafiServer will listen for incoming FastAGI requests");
    fastagiPortLabel.setText("FastAGI Port:");

    textSafiAgiPort = new Text(serverPropertiesGroup, SWT.BORDER);
    final GridData gd_text_safi_fastagi_port = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    textSafiAgiPort.setLayoutData(gd_text_safi_fastagi_port);

    final Label fastagiPortLabel_1 = new Label(serverPropertiesGroup, SWT.NONE);
    fastagiPortLabel_1.setLayoutData(new GridData());

    String mgtPortTxt = null;
    if (isProd)
      mgtPortTxt = "Port that SafiServer uses for remote management and incoming custom initiation events";
    else
      mgtPortTxt = "Port on which the SafiServer will listen for incoming custom initiation events";
    fastagiPortLabel_1.setToolTipText(mgtPortTxt);
    fastagiPortLabel_1.setText("Safi Mgt Port:");
    textSafiMgtPort = new Text(serverPropertiesGroup, SWT.BORDER);
    final GridData gd_text_safi_mgt_port = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    textSafiMgtPort.setLayoutData(gd_text_safi_mgt_port);
    // textSafiMgtPort.setEnabled(isProd);
    textSafiMgtPort.setEnabled(true);

    final Label dbPortLabel = new Label(serverPropertiesGroup, SWT.NONE);
    dbPortLabel.setToolTipText("Port utilized by SafiServer database");
    dbPortLabel.setText("DB Port:");

    textDBPort = new Text(serverPropertiesGroup, SWT.BORDER);
    final GridData gd_text_DBPort = new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1);
    textDBPort.setLayoutData(gd_text_DBPort);
    textDBPort.setEnabled(isProd);
    //
    // SafiServer safiServer = SafiServerPlugin.getDefault().getSafiServer();

    this.textSafiServer.setText(safiServer.getName());
    this.bindIPCombo.setText(safiServer.getBindIP());

    this.textSafiAgiPort.setText("4575"); //TODO: This should be taken from the Asterisk telephony subsystem
    this.textSafiMgtPort.setText(Integer.toString(safiServer.getManagementPort()));
    this.textDBPort.setText(Integer.toString(safiServer.getDbPort()));

    String[] addresses = null;
    {
      try {
        addresses = getLocalIPAddresses();
      } catch (UnknownHostException e1) {
        e1.printStackTrace();

      }
    }
    if (addresses == null)
      addresses = new String[] { "127.0.0.1", "0.0.0.0" };
    bindIPCombo.setItems(addresses);
    return container;
  }

  private String[] getLocalIPAddresses() throws UnknownHostException {
    InetAddress in = InetAddress.getLocalHost();
    InetAddress[] all = InetAddress.getAllByName(in.getHostName());
    String[] addresses = new String[all.length + 2];
    int i = 0;
    for (; i < all.length; i++) {
      System.out.println("  address = " + all[i].getHostAddress());
      addresses[i] = all[i].getHostAddress();
    }
    addresses[i++] = "127.0.0.1";
    addresses[i++] = "0.0.0.0";
    return addresses;
  }

  private void disableAll() {
    isEnabled = false;
    textSafiServer.setEnabled(false);
    this.bindIPCombo.setEnabled(false);
    this.textSafiAgiPort.setEnabled(false);
    this.textSafiMgtPort.setEnabled(false);
    this.textDBPort.setEnabled(false);
  }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(341, 228);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    if (safiServer.getName() == "Debug")
      newShell.setText("Debug SafiServer Manager");
    else
      newShell.setText("SafiServer Manager");
  }

  @Override
  protected void buttonPressed(int buttonId) {
    if (buttonId == IDialogConstants.CANCEL_ID) {
      cancelPressed();
      return;
    }
    if (buttonId == IDialogConstants.OK_ID) {
      if (!this.isEnabled) {
        okPressed();
        return;
      } else {
        String name = textSafiServer.getText().trim();
        String host = null;
        if (bindIPCombo.getSelectionIndex() >= 0)
          host = bindIPCombo.getItem(bindIPCombo.getSelectionIndex()).trim();
        else
          host = this.bindIPCombo.getText().trim();

        String fport = this.textSafiAgiPort.getText().trim();
        String mport = this.textSafiMgtPort.getText().trim();
        String dbport = this.textDBPort.getText().trim();

        if (host.length() == 0) {
          MessageDialog.openError(this.getShell(), "Validation error", "Please enter valid ip");
          return;
        }

        if (fport.length() == 0) {
          MessageDialog.openError(this.getShell(), "Validation error",
              "Please enter valid fastagi port!");
          return;
        }

        if (mport.length() == 0) {
          MessageDialog.openError(this.getShell(), "Validation error",
              "Please enter valid management port!");
          return;
        }

        if (dbport.length() == 0) {
          MessageDialog.openError(this.getShell(), "Validation error",
              "Please enter valid DB port!");
          return;
        }

        int fportInt = 4573;
        try {
          fportInt = Integer.parseInt(fport);
        } catch (Exception ex) {
          MessageDialog.openError(this.getShell(), "Validation error",
              "Please enter valid fastagi port!");
          return;
        }

        int mportInt = 7020;

        try {
          mportInt = Integer.parseInt(mport);
        } catch (Exception ex) {
          MessageDialog.openError(this.getShell(), "Validation error",
              "Please enter valid Management port!");
          return;
        }

        int dbportInt = 7020;

        try {
          dbportInt = Integer.parseInt(dbport);
        } catch (Exception ex) {
          MessageDialog.openError(this.getShell(), "Validation error",
              "Please enter valid DB port!");
          return;
        }

        safiServer.setBindIP(host);
//        safiServer.setPort(fportInt);
        safiServer.setName(name);
        // SafiServer server = SafiServerPlugin.getDefault().getSafiServer();
        safiServer.setManagementPort(mportInt);
        if (safiServer.getId() != -1) {
          safiServer.setDbPort(dbportInt);

          // IPreferenceStore store = SafiServerPlugin.getDefault().getPreferenceStore();
          // store.setValue(PreferenceConstants.PREF_SAFISERVER_BIND_IP, host);
          // store.setValue(PreferenceConstants.PREF_DB_PORT, dbportInt);
          // store.setValue(PreferenceConstants.PREF_MANAGER_PORT,mportInt);
          // store.setValue(PreferenceConstants.PREF_FASTAGI_PORT, fportInt);

          final String fhost = host;
          final int fdbport = dbportInt;
          IRunnableWithProgress job = new IRunnableWithProgress() {

            @Override
            public void run(IProgressMonitor monitor) {

              try {
                DBManager.getInstance().saveOrUpdateServerResource(safiServer);

                // DBManager.getInstance().setPort(dbportInt);
                IPreferenceStore store = AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore();
                store.setValue(PreferenceConstants.PREF_DB_PORT_PROD, fdbport);
                store.setValue(PreferenceConstants.PREF_SAFISERVER_HOSTNAME_PROD, fhost);
                SafiServerPlugin.getDefault().updateServerResources(monitor);
                Display.getDefault().asyncExec(new Runnable() {
                  public void run() {
                    okPressed();
                  }

                });

              } catch (final Exception e) {
                e.printStackTrace();
                Display.getDefault().asyncExec(new Runnable() {
                  public void run() {
                    MessageDialog.openError(getShell(), "Update Error",
                        "Couldn't update SafiServer settings: " + e.getLocalizedMessage());
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
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            MessageDialog.openError(getShell(), "Update Error",
                "Couldn't update SafiServer settings: " + e.getLocalizedMessage());
            return;
          }
          // job.setUser(true);

          // PlatformUI.getWorkbench().getProgressService().showInDialog(getShell(), job);
          // job.schedule();
          return;

          // SafiServerPlugin.getDefault().notifyListeners();
        } /*
           * else { SafiServerPlugin.getDefault().storeLocalSafiServerToPref();
           * AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(); }
           */
        // IPreferenceStore store = SafiServerPlugin.getDefault().getPreferenceStore();
        // store.setValue(PreferenceConstants.PREF_SAFISERVER_BIND_IP, host);
        // store.setValue(PreferenceConstants.PREF_DB_PORT, dbportInt);
        // store.setValue(PreferenceConstants.PREF_MANAGER_PORT,mportInt);
        // store.setValue(PreferenceConstants.PREF_FASTAGI_PORT, fportInt);
        //				 
        //				    
        // //update server Resources needs to look at.
        // SafiServerPlugin.getDefault().updateServerResources();
        this.okPressed();
        return;
      }
    }
    super.buttonPressed(buttonId);
  }

}
