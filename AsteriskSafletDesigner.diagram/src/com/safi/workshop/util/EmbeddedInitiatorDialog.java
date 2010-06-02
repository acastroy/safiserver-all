package com.safi.workshop.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.safi.asterisk.handler.connection.ExceptionHandler;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.Saflet;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.util.CustomInitiatorClient;
import com.safi.util.ui.PropertyEditorTable;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class EmbeddedInitiatorDialog extends Dialog {

  // private Button remoteProductionServerButton;
  // private Button localDebugServerButton;
  private Composite composite;
  private CCombo safletNameText;
//  private Text safiServerManagementPort;
  private CCombo asteriskServerIPText;
  private Text safiServerIPText;
  private CustomInitiatorClient client;
  private PropertyEditorTable propertyEditorTable;
  private Executor executor = Executors.newCachedThreadPool();
  // private MyAutoCompleteField asteriskServerAutoCompleteField;
  // private MyAutoCompleteField safletAutoCompleteField;
  private Map<String, ServerResource> localResources;
  private List<SafletProject> projectList;
  // private String[] localSafletCompletions;
  private String[] prodSafletCompletions;
  private int position = PositionConstants.NONE;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public EmbeddedInitiatorDialog(Shell parentShell) {
    super(parentShell);
  }

  public EmbeddedInitiatorDialog(Shell parentShell, int stylebits) {
    super(parentShell);
    setShellStyle(stylebits);
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);

    composite = new Composite(container, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 2;
    composite.setLayout(gridLayout_1);

    // localDebugServerButton = new Button(composite, SWT.RADIO);
    // localDebugServerButton.addSelectionListener(new SelectionAdapter() {
    // public void widgetSelected(final SelectionEvent e) {
    // if (localDebugServerButton.getSelection())
    // debugMode();
    // }
    // });
    // localDebugServerButton.setText("Local debug server");

    // remoteProductionServerButton = new Button(composite, SWT.RADIO);
    // remoteProductionServerButton.addSelectionListener(new SelectionAdapter() {
    // public void widgetSelected(final SelectionEvent e) {
    // if (remoteProductionServerButton.getSelection())
    // prodMode();
    // }
    // });
    // final GridData gd_remoteProductionServerButton = new GridData();
    // remoteProductionServerButton.setLayoutData(gd_remoteProductionServerButton);
    // remoteProductionServerButton.setText("Remote production server");

    final Label safiserverIpLabel = new Label(container, SWT.NONE);
    safiserverIpLabel.setText("SafiServer IP:");

    safiServerIPText = new Text(container, SWT.BORDER);
    if (client.getHost() != null) {
      safiServerIPText.setText(client.getHost());
      safiServerIPText.setData(client.getHost());
    }

    final GridData gd_safiServerIPText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    safiServerIPText.setLayoutData(gd_safiServerIPText);

    final Label asteriskServerIpLabel = new Label(container, SWT.NONE);
    asteriskServerIpLabel.setText("Asterisk Server IP:");

    asteriskServerIPText = new CCombo(container, SWT.BORDER);
    final GridData gd_asteriskServerIP = new GridData(SWT.FILL, SWT.CENTER, true, false);
    asteriskServerIPText.setLayoutData(gd_asteriskServerIP);
    if (client.getAstIp() != null)
      asteriskServerIPText.setText(client.getAstIp());

//    final Label safiserverManagementPortLabel = new Label(container, SWT.NONE);
//    safiserverManagementPortLabel.setText("SafiServer Management Port:");

//    safiServerManagementPort = new Text(container, SWT.BORDER);
//    final GridData gd_safiServerManagementPort = new GridData(SWT.FILL, SWT.CENTER, true, false);
//    safiServerManagementPort.setLayoutData(gd_safiServerManagementPort);
//    safiServerManagementPort.setText(String.valueOf(client.getPort()));
//    safiServerManagementPort.setData(client.getPort());

    final Label safletNameLabel = new Label(container, SWT.NONE);
    safletNameLabel.setText("Saflet Name");

    safletNameText = new CCombo(container, SWT.BORDER);
    final GridData gd_safletNameText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    safletNameText.setLayoutData(gd_safletNameText);
    if (client.getSaflet() != null)
      safletNameText.setText(client.getSaflet());
    propertyEditorTable = new PropertyEditorTable(container, SWT.NONE, client.getProps());
    propertyEditorTable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
    // new Label(container, SWT.NONE);
    //
    prodMode();
    return container;
  }

  @Override
  protected void constrainShellSize() {
    super.constrainShellSize();
    updatePosition();
  }

  private String[] getProductionAsteriskServers() {
    List<String> servernames = new ArrayList<String>();
    for (AsteriskServer server : SafiServerPlugin.getDefault().getAvailableAsteriskServers()) {
      servernames.add(server.getHostname());
    }
    return servernames.toArray(new String[servernames.size()]);
  }

  protected void prodMode() {
    try {
      if (!SafiServerPlugin.getDefault().isConnected()) {

        MessageDialog
            .openWarning(
                getShell(),
                "Not Connected",
                "You are not currently connected to a production SafiServer.  No remote SafiServer information is available");
        asteriskServerIPText.setItems(new String[0]);
        safletNameText.setItems(new String[0]);
      } else {
        SafiServer server = SafiServerPlugin.getDefault().getSafiServer(true);
        safiServerIPText.setText(SafiServerPlugin.getDefault().getProductionServerDisplayHostname());
//        safiServerIPText.setText(server.getBindIP());
        boolean b = !SafiServerPlugin.getDefault().isLocalSafiServer();
        if (b)
          safiServerIPText.setData("127.0.0.1");
        else
          safiServerIPText.setData(safiServerIPText.getText());

//        safiServerManagementPort.setText(String.valueOf(server.getManagementPort()));
        // if (b) {
        // int sshMgmtPort = SafiServerPlugin.getDefault().getPreferenceStore().getInt(
        // PreferenceConstants.PREF_SSH_FORWARDING_MANAGEMENT_PORT_LOCAL);
        // safiServerManagementPort.setData(sshMgmtPort);
        // } else
//        safiServerManagementPort.setData(server.getManagementPort());

        asteriskServerIPText.setItems(getProductionAsteriskServers());
        safletNameText.setItems(getProdSafletCompletions());
      }
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "SafiServer IP Not Found",
          "Unable to retrieve production SafiServer IP: " + e.getLocalizedMessage());
    }

  }

  private void initLocalResources() {
    if (localResources == null) {
      localResources = SafletPersistenceManager.getInstance().getLocalProjectCopies(true);
    }

  }

  private void initProjectList() {
    if (localResources == null)
      initLocalResources();
    // IWorkspace ws = ResourcesPlugin.getWorkspace();
    // IProject[] projects = ws.getRoot().getProjects();
    // List<IProject> plist = new ArrayList<IProject>(Arrays.asList(projects));

    projectList = SafletPersistenceManager.getInstance().getProjectAndSafletTreeCloned(
        localResources);
  }

  // private String[] getLocalSafletCompletions() {
  // if (localSafletCompletions == null) {
  // if (localResources == null)
  // initLocalResources();
  // localSafletCompletions = localResources.keySet().toArray(new
  // String[localResources.size()]);
  // }
  // return localSafletCompletions;
  // }

  private String[] getProdSafletCompletions() {
    if (prodSafletCompletions == null) {
      if (projectList == null)
        initProjectList();
      List<String> prodSafletCompList = new ArrayList<String>();
      for (SafletProject project : projectList) {
        String path = null;
        for (Saflet saf : project.getSaflets()) {
          path = saf.getProject().getName() + "/" + saf.getName();
          prodSafletCompList.add(path);
        }
      }
      prodSafletCompletions = prodSafletCompList.toArray(new String[prodSafletCompList.size()]);
    }
    return prodSafletCompletions;
  }

  // protected void debugMode() {
  // try {
  // if (safiServerIPText == null)
  // return;
  // safiServerIPText.setText(server.getBindIP());
  // safiServerIPText.setData(server.getBindIP());
  // safiServerManagementPort.setText(String.valueOf(server.getManagementPort()));
  // safiServerManagementPort.setData(server.getManagementPort());
  // AsteriskServer ast = SafiServerPlugin.getDefault().getDebugAsteriskServer();
  //
  // if (ast != null) {
  // asteriskServerIPText.setItems(new String[] { ast.getHostname() });
  // asteriskServerIPText.select(0);
  // }
  // safletNameText.setItems(getLocalSafletCompletions());
  // } catch (Exception e) {
  // e.printStackTrace();
  // MessageDialog.openError(getShell(), "SafiServer IP Not Found",
  // "Unable to retrieve local debug SafiServer IP: " + e.getLocalizedMessage());
  // }
  //
  // }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.PROCEED_ID, "Send", false);
    createButton(parent, IDialogConstants.OK_ID, "Done", true);

  }

  @Override
  protected void buttonPressed(int buttonId) {
    if (IDialogConstants.OK_ID == buttonId)
      okPressed();
    else if (IDialogConstants.PROCEED_ID == buttonId) {
      client.setAstIp(asteriskServerIPText.getText());
      client.setHost((String) safiServerIPText.getData());
      try {
        client.setPort(SafiServerPlugin.getDefault().getLocalTunneledManagementPort());
      } catch (NumberFormatException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        MessageDialog.openError(getShell(), "Parse Error",
            "Enter a valid number for SafiServer managment port");
        return;
      }
      client.setProps(propertyEditorTable.getProperties());
      client.setSaflet(safletNameText.getText());
      final Display display = getShell().getDisplay();
      Runnable runna = new Runnable() {
        public void run() {
          try {
            client.connect(new ExceptionHandler() {

              /**
               * 
               */
              private static final long serialVersionUID = -2990481670810223709L;

              public void handleException(final String message, final Exception e) {
                if ((message == null || "".equals(message.trim()) && e == null))
                  return;
                display.asyncExec(new Runnable() {
                  @Override
                  public void run() {
                    Throwable ex = getUnderlyingCause(e);
                    MessageDialog.openError(getShell(), "Invoke Error",
                        "Custom Initiation returned an error: " + (message == null ? "" : message)
                            + (ex == null ? "" : "->" + ex.getLocalizedMessage()));

                  }

                });
              };
            });
          } catch (final Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            display.asyncExec(new Runnable() {
              @Override
              public void run() {
                MessageDialog.openError(getShell(), "Invoke Error",
                    "Custom Initiation returned an error: " + e.getLocalizedMessage());

              }
            });

            return;
          }
        }
      };
      executor.execute(runna);

    }
  }

  private Throwable getUnderlyingCause(Throwable e) {
    if (e == null)
      return null;
    Throwable cause = e;
    while (cause.getCause() != null) {
      cause = cause.getCause();
    }
    return cause;
  }

  @Override
	protected boolean isResizable() {
		// TODO Auto-generated method stub
		return true;
	}
  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(370, 340);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Custom Initiator Client");
  }

  public CustomInitiatorClient getClient() {
    return client;
  }

  public void setClient(CustomInitiatorClient client) {
    this.client = client;
  }

  public void setPosition(int pos) {
    this.position = pos;
    if (getShell() != null && !getShell().isDisposed()) {
      updatePosition();
    }
  }

  private void updatePosition() {
    if (position == PositionConstants.NONE || getShell() == null || getShell().isDisposed())
      return;
    Rectangle bounds = getShell().getBounds();
    // Rectangle displayBounds = getShell().getDisplay().getBounds();
    Rectangle displayBounds = AsteriskDiagramEditorPlugin.getInstance().getWorkbench()
        .getActiveWorkbenchWindow().getShell().getBounds();
    displayBounds = new Rectangle(10, 10, displayBounds.width - 20, displayBounds.height - 20);
    switch (position) {
      case PositionConstants.NORTH:
        getShell().setLocation(displayBounds.width / 2 - bounds.width / 2, 10);
        break;
      case PositionConstants.WEST:
        getShell().setLocation(10, displayBounds.height / 2 - bounds.height / 2);
        break;
      case PositionConstants.SOUTH:
        getShell().setLocation(displayBounds.width / 2 - bounds.width / 2,
            displayBounds.height - bounds.height);
        break;
      case PositionConstants.EAST:
        getShell().setLocation(displayBounds.width - bounds.width,
            displayBounds.height / 2 - bounds.height / 2);
        break;
      case PositionConstants.NORTH_WEST:
        getShell().setLocation(10, 10);
        break;
      case PositionConstants.SOUTH_WEST:
        getShell().setLocation(10, displayBounds.height - bounds.height);
        break;
      case PositionConstants.SOUTH_EAST:
        getShell().setLocation(displayBounds.width - bounds.width,
            displayBounds.height - bounds.height);
        break;
      case PositionConstants.NORTH_EAST:
        getShell().setLocation(displayBounds.width - bounds.width, 10);
        break;
    }

  }

}
