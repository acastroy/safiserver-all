package com.safi.workshop.serverview;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;

import com.safi.asterisk.handler.mbean.SysInfo;
import com.safi.asterisk.handler.util.FileUtils;
import com.safi.db.manager.EntitlementUtils;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;
import com.safi.server.manager.SafiServerManagementException;
import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin.ActionPak;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin.ActionPakJar;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin.SafiServerJar;
import com.safi.workshop.util.SafletPersistenceManager;
import com.swtdesigner.ResourceManager;
import com.swtdesigner.SWTResourceManager;

public class ServerViewPanel extends Composite {

  static enum LicenseMode {
    UPLOAD, TOKEN, USERNAME, SIGN_UP
  };
  private Label safiServerVersionLabel;
  private Label macLabel_1_1;
  private Composite composite_10;
  private Composite composite_9;
  private SashForm sashForm;
  private static final String DRIVE_SPACE_LABEL_FORMAT = "Drive Space (%1$s/%2$s)";
  private static final String SEVER_MEMORY_LABEL_FORMAT = "Server Memory (%1$s/%2$s)";
  private static final double BYTES_PER_MEGABYTE = 1048576d;
  private final static String LICENSE_URL = "http://www.safisystems.com/index.cfm?pageMode=accountlicensequickgen&serial=";
  private static final int MILLIS_PER_MINUTE = 60 * 1000;
  private static final int MILLIS_PER_HOUR = MILLIS_PER_MINUTE * 60;
  private static final int MILLIS_PER_DAY = MILLIS_PER_HOUR * 24;

  private Button button;
  private Table table;
  private CheckboxTableViewer updatesTableViewer;
  private Text logText;
  private Table pendingUpdatesTable;
  private Composite productBannerComposite;
  private Composite serverPannel;
  private Label safiserverStandardEdditionLabel;
  private Composite composite_8;
  private DataBindingContext m_bindingContext;
  private Composite maincomposite;
  private Composite composite_1;
  private SysInfo currentInfo;
  private ProgressBar memoryBar;
  private ProgressBar driveSpaceBar;
  private ProgressBar cpuUsageBar;
  private Label serverMemoryLabel;
  private Label driveSpaceLabel;
  private Label cpuUsageLabel;
  private CTabItem safletsTabItem;
  private CTabFolder tabFolder;
  private Label uptimeLabel;
  private Label lastRebootLabel;
  private Label incomingCallsLabel;
  private Label custInitiationsLabel;
  private Label ipAddressLabel;
  private Label macAddressLabel;
  private Label safiserverHeaderVersionLabel;
  private Label label_1;
  private List<ActionPak> actionPaks;
  private List<SafiServerJar> safiServerJars;
  private SafiServer server;
  private User user;
  private SafiServerRemoteManager manager;

  private FileDialog saveLogDialog;

  private boolean licensed;

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */
  public ServerViewPanel(Composite parent, int style) {
    super(parent, style);
    setLayout(new GridLayout());
    // Composite composite = parent;
    // composite = new Composite(parent, SWT.BORDER);

    serverPannel = this;
    serverPannel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    maincomposite = new Composite(serverPannel, SWT.NONE);
    final GridData gd_maincomposite = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_maincomposite.heightHint = 66;
    maincomposite.setLayoutData(gd_maincomposite);
    maincomposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    maincomposite.setLayout(gridLayout);

    productBannerComposite = new Composite(maincomposite, SWT.NONE);
    productBannerComposite.setBackgroundImage(ResourceManager.getPluginImage(
        AsteriskDiagramEditorPlugin.getDefault(), "icons/serverview/safiserverTop.jpg"));
    final GridData gd_composite_7 = new GridData(SWT.LEFT, SWT.FILL, false, true);
    gd_composite_7.widthHint = 276;
    productBannerComposite.setLayoutData(gd_composite_7);
    productBannerComposite.setLayout(new GridLayout());

    composite_8 = new Composite(maincomposite, SWT.NONE);
    final GridData gd_composite_8 = new GridData(SWT.RIGHT, SWT.BOTTOM, true, true);
    gd_composite_8.heightHint = 62;
    composite_8.setLayoutData(gd_composite_8);
    final GridLayout gridLayout_10 = new GridLayout();
    gridLayout_10.marginHeight = 2;
    gridLayout_10.verticalSpacing = 0;
    composite_8.setLayout(gridLayout_10);
    composite_8.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

    safiserverStandardEdditionLabel = new Label(composite_8, SWT.RIGHT);
    safiserverStandardEdditionLabel.setAlignment(SWT.RIGHT);
    safiserverStandardEdditionLabel.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, true));
    safiserverStandardEdditionLabel.setText("SafiServer ");
    safiserverStandardEdditionLabel.setBackground(Display.getCurrent().getSystemColor(
        SWT.COLOR_WHITE));

    safiserverHeaderVersionLabel = new Label(composite_8, SWT.RIGHT);
    safiserverHeaderVersionLabel.setText("version");
    safiserverHeaderVersionLabel.setAlignment(SWT.RIGHT);
    safiserverHeaderVersionLabel.setLayoutData(new GridData(SWT.FILL, SWT.BOTTOM, true, false));
    safiserverHeaderVersionLabel
        .setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

    composite_1 = new Composite(serverPannel, SWT.NONE);
    composite_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    composite_1.setData("newKey", "heoo");
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.marginWidth = 0;
    composite_1.setLayout(gridLayout_1);
    sashForm = new SashForm(composite_1, SWT.NONE);

    composite_9 = new Composite(sashForm, SWT.NONE);
    final GridLayout gridLayout_8 = new GridLayout();
    gridLayout_8.marginWidth = 0;
    composite_9.setLayout(gridLayout_8);

    final Composite liveServerData = new Composite(composite_9, SWT.BORDER);
    final GridData gd_liveServerData = new GridData(SWT.FILL, SWT.FILL, true, false);
    gd_liveServerData.heightHint = 155;
    gd_liveServerData.widthHint = 350;
    liveServerData.setLayoutData(gd_liveServerData);
    liveServerData.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
    final GridLayout gridLayout_2 = new GridLayout();
    gridLayout_2.numColumns = 2;
    liveServerData.setLayout(gridLayout_2);

    final Composite liveServerImage = new Composite(liveServerData, SWT.NONE);
    liveServerImage.setBackgroundImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
        .getDefault(), "icons/serverview/safiserverbox.jpg"));
    final GridData gd_liveServerImage = new GridData(SWT.LEFT, SWT.FILL, false, true);
    gd_liveServerImage.widthHint = 100;
    liveServerImage.setLayoutData(gd_liveServerImage);
    liveServerImage.setLayout(new GridLayout());

    final Composite liveServerBars = new Composite(liveServerData, SWT.BORDER);
    final GridData gd_liveServerBars = new GridData(SWT.FILL, SWT.FILL, true, true);
    gd_liveServerBars.heightHint = 18;
    liveServerBars.setLayoutData(gd_liveServerBars);
    liveServerBars.setLayout(new GridLayout());

    serverMemoryLabel = new Label(liveServerBars, SWT.NONE);
    serverMemoryLabel.setText("Server Memory");

    memoryBar = new ProgressBar(liveServerBars, SWT.NONE);
    final GridData gd_progressBar = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_progressBar.heightHint = 10;
    memoryBar.setLayoutData(gd_progressBar);
    memoryBar.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
    memoryBar.setData("newKey", null);

    driveSpaceLabel = new Label(liveServerBars, SWT.NONE);
    driveSpaceLabel.setText("Drive Space");

    driveSpaceBar = new ProgressBar(liveServerBars, SWT.NONE);
    final GridData gd_driveSpaceBar = new GridData(SWT.FILL, SWT.CENTER, false, false);
    gd_driveSpaceBar.heightHint = 10;
    driveSpaceBar.setLayoutData(gd_driveSpaceBar);
    driveSpaceBar.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

    cpuUsageLabel = new Label(liveServerBars, SWT.NONE);
    cpuUsageLabel.setText("CPU Usage");

    cpuUsageBar = new ProgressBar(liveServerBars, SWT.NONE);
    final GridData gd_cpuUsageBar = new GridData(SWT.FILL, SWT.CENTER, false, false);
    gd_cpuUsageBar.heightHint = 10;
    cpuUsageBar.setLayoutData(gd_cpuUsageBar);
    cpuUsageBar.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

    button = new Button(liveServerBars, SWT.NONE);
    button.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        requestImmediateUpdate();
      }
    });
    button.setToolTipText("Update server info now");
    button.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
        "icons/audio/refresh.gif"));

    final Composite updatesPending = new Composite(composite_9, SWT.NONE);
    final GridData gd_updatesPending = new GridData(SWT.FILL, SWT.FILL, true, true);
    gd_updatesPending.minimumHeight = 200;
    gd_updatesPending.heightHint = 350;
    updatesPending.setLayoutData(gd_updatesPending);
    final GridLayout gridLayout_7 = new GridLayout();
    gridLayout_7.marginWidth = 0;
    gridLayout_7.horizontalSpacing = 0;
    updatesPending.setLayout(gridLayout_7);

    final Label pendingUpdatesLabel = new Label(updatesPending, SWT.CENTER);
    pendingUpdatesLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false));
    pendingUpdatesLabel.setText("Pending Updates:");

    updatesTableViewer = CheckboxTableViewer.newCheckList(updatesPending, SWT.BORDER);
    updatesTableViewer.setLabelProvider(new TableLabelProvider());
    updatesTableViewer.setContentProvider(new ContentProvider());
    table = updatesTableViewer.getTable();
    table.setLinesVisible(true);
    table.setHeaderVisible(true);
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    final TableColumn columnUpdate = new TableColumn(table, SWT.NONE);
    columnUpdate.setWidth(150);
    columnUpdate.setText("Update");

    final TableColumn columnVersion = new TableColumn(table, SWT.NONE);
    columnVersion.setWidth(300);
    columnVersion.setText("Info");

    final Composite updateButtons = new Composite(updatesPending, SWT.NONE);
    updateButtons.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
    final GridLayout gridLayout_3 = new GridLayout();
    gridLayout_3.numColumns = 2;
    updateButtons.setLayout(gridLayout_3);

    final Button pushUpdatesToButton = new Button(updateButtons, SWT.NONE);
    pushUpdatesToButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        updateServer();
      }
    });
    pushUpdatesToButton.setText("Push Selected Updates to Server");

    final Button checkForUpdatesButton = new Button(updateButtons, SWT.NONE);
    checkForUpdatesButton.setText("Check for Updates");
    sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    composite_10 = new Composite(sashForm, SWT.NONE);
    final GridLayout gridLayout_9 = new GridLayout();
    gridLayout_9.marginWidth = 0;
    composite_10.setLayout(gridLayout_9);

    final Composite rightSide = new Composite(composite_10, SWT.NONE);
    rightSide.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    rightSide.setLayout(new GridLayout());

    tabFolder = new CTabFolder(rightSide, SWT.BORDER);
    tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    safletsTabItem = new CTabItem(tabFolder, SWT.NONE);
    safletsTabItem.setText("General");

    final Composite composite_4 = new Composite(tabFolder, SWT.BORDER);
    final GridLayout gridLayout_4 = new GridLayout();
    gridLayout_4.marginLeft = 5;
    gridLayout_4.numColumns = 2;
    composite_4.setLayout(gridLayout_4);
    safletsTabItem.setControl(composite_4);

    final Label safletsLabel_1_1 = new Label(composite_4, SWT.NONE);
    safletsLabel_1_1.setFont(SWTResourceManager.getFont("MS Sans Serif", 8, SWT.BOLD));
    safletsLabel_1_1.setText("Uptime: ");

    uptimeLabel = new Label(composite_4, SWT.NONE);
    uptimeLabel.setLayoutData(new GridData(200, SWT.DEFAULT));

    final Label safletsLabel_1 = new Label(composite_4, SWT.NONE);
    safletsLabel_1.setFont(SWTResourceManager.getFont("MS Sans Serif", 8, SWT.BOLD));
    safletsLabel_1.setText("Last Reboot: ");

    lastRebootLabel = new Label(composite_4, SWT.NONE);

    final Label label_8 = new Label(composite_4, SWT.SEPARATOR | SWT.HORIZONTAL);
    label_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

    final Label macLabel_1_1_1 = new Label(composite_4, SWT.NONE);
    macLabel_1_1_1.setFont(SWTResourceManager.getFont("MS Sans Serif", 8, SWT.BOLD));
    macLabel_1_1_1.setText("Incoming Calls:");

    incomingCallsLabel = new Label(composite_4, SWT.NONE);

    final Label macLabel_1_1_1_1 = new Label(composite_4, SWT.NONE);
    macLabel_1_1_1_1.setFont(SWTResourceManager.getFont("MS Sans Serif", 8, SWT.BOLD));
    macLabel_1_1_1_1.setText("Custom Initiations:");

    custInitiationsLabel = new Label(composite_4, SWT.NONE);

    final Label label_2 = new Label(composite_4, SWT.SEPARATOR | SWT.HORIZONTAL);
    label_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));

    final Label safletsLabel = new Label(composite_4, SWT.NONE);
    safletsLabel.setFont(SWTResourceManager.getFont("MS Sans Serif", 8, SWT.BOLD));
    safletsLabel.setText("IP Address: ");

    ipAddressLabel = new Label(composite_4, SWT.NONE);

    final Label macLabel_ = new Label(composite_4, SWT.NONE);
    macLabel_.setFont(SWTResourceManager.getFont("MS Sans Serif", 8, SWT.BOLD));
    macLabel_.setText("MAC:");

    macAddressLabel = new Label(composite_4, SWT.NONE);

    final Label macLabel_1 = new Label(composite_4, SWT.NONE);
    macLabel_1.setFont(SWTResourceManager.getFont("MS Sans Serif", 8, SWT.BOLD));
    macLabel_1.setText("Server ID:");

    label_1 = new Label(composite_4, SWT.NONE);

    macLabel_1_1 = new Label(composite_4, SWT.NONE);
    macLabel_1_1.setFont(SWTResourceManager.getFont("MS Sans Serif", 8, SWT.BOLD));
    macLabel_1_1.setText("SafiServer Ver:");

    safiServerVersionLabel = new Label(composite_4, SWT.NONE);

    final Label label_4 = new Label(composite_4, SWT.SEPARATOR | SWT.HORIZONTAL);
    label_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
    // setTitle("SafiServer License Manager");
    // setMessage("Upload and mamage SafiServer licenses.  You must be connected to a running Safiserver in order to view and update licensing.");
    // macLabel = new StyledText(composite, SWT.READ_ONLY | SWT.BORDER);

    final CTabItem logfileTabItem = new CTabItem(tabFolder, SWT.NONE);
    logfileTabItem.setText("Log File");

    final Composite composite_5 = new Composite(tabFolder, SWT.NONE);
    final GridLayout gridLayout_5 = new GridLayout();
    composite_5.setLayout(gridLayout_5);
    logfileTabItem.setControl(composite_5);

    final Label logFileLabel = new Label(composite_5, SWT.NONE);
    logFileLabel.setFont(SWTResourceManager.getFont("MS Sans Serif", 8, SWT.BOLD));
    logFileLabel.setText("Log File (service.log):");

    logText = new Text(composite_5, SWT.WRAP | SWT.V_SCROLL | SWT.BORDER);
    logText.setText("Click 'Refresh' button to load server log contents");
    logText.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
    logText.setEditable(false);
    logText.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    final Composite composite_6 = new Composite(composite_5, SWT.NONE);
    composite_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
    final GridLayout gridLayout_6 = new GridLayout();
    gridLayout_6.numColumns = 2;
    composite_6.setLayout(gridLayout_6);

    final Button refreshButton = new Button(composite_6, SWT.NONE);
    refreshButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        try {
          final byte[] bytes = SafiServerRemoteManager.getInstance().getServerLogFile();
          if (bytes == null || bytes.length == 0)
            logText.setText("");
          else
            logText.setText(new String(bytes));
        } catch (Exception e1) {
          MessageDialog.openError(getShell(), "Log Error",
              "Couldn't retrieve server log contents: " + e1.getLocalizedMessage());
          e1.printStackTrace();
        }
      }
    });
    refreshButton.setText("Refresh");

    final Button saveLogFileButton = new Button(composite_6, SWT.NONE);
    saveLogFileButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        saveLogToFile();
      }
    });
    saveLogFileButton.setText("Save Log File");

    tabFolder.setSelection(safletsTabItem);
    try {
      server = SafiServerPlugin.getDefault().getSafiServer(true);
      this.manager = SafiServerRemoteManager.getInstance();
      user = SafiServerPlugin.getDefault().getCurrentUser();
      if (server != null && manager != null) {

        // Activate buttons
        // uploadFileToButton.setEnabled(true);

        // Launch getLicense
        /*
         * this.getLicense();
         * 
         * // Auto-Select Tab if (!licensed) { }
         * 
         * try { this.selected(); } catch (Exception e) { e.printStackTrace(); }
         */
      } else {
        // this.retreiveLicenseInformationButton.setEnabled(false);
        // this.uploadFileToButton.setEnabled(false);
        // this.setMessage("Please log in to SafiServer first");
        // this.setErrorMessage("Please log in to SafiServer before performing license operations");
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    // list.select(0);
    sashForm.setWeights(new int[] { 2, 3 });

    //
    reloadModel();
  }

  // protected void setUploadLicenseEnabled() {
  // trialTokenButton.setEnabled(false);
  // trialTokenField.setEnabled(false);
  // trialTokenField.setEditable(false);
  // licenseFileText.setEnabled(true);
  // licenseFileText.setEditable(true);
  // browseButton.setEnabled(true);
  // if (licenseFileText.getText().endsWith(".xml"))
  // uploadFileToButton.setEnabled(true);
  // else
  // uploadFileToButton.setEnabled(false);
  // }
  //
  // protected void setEnterTokenEnabled() {
  // trialTokenField.setEnabled(true);
  // trialTokenField.setEditable(true);
  // if (StringUtils.isNotBlank(trialTokenField.getText())) {
  //
  // trialTokenButton.setEnabled(true);
  // } else {
  // trialTokenButton.setEnabled(false);
  // }
  //
  // licenseFileText.setEnabled(false);
  // licenseFileText.setEditable(false);
  // browseButton.setEnabled(false);
  // uploadFileToButton.setEnabled(false);
  //
  // }

  @Override
  public void dispose() {
    super.dispose();
  }

  protected void saveLogToFile() {
    String text = logText.getText();
    if (StringUtils.isBlank(text))
      return;

    if (saveLogDialog == null) {
      saveLogDialog = new FileDialog(getShell(), SWT.SAVE);
      saveLogDialog.setFilterExtensions(new String[] { "*.log" });
    }
    try {
      saveLogDialog.setFileName("SafiServer_"
          + SafiServerPlugin.getDefault().getSafiServer(true).getBindIP());
      String name = saveLogDialog.open();
      if (StringUtils.isNotBlank(name)) {
        try {
          FileUtils.writeFile(name, text.getBytes());
        } catch (IOException e) {
          e.printStackTrace();
          MessageDialog.openError(getShell(), "Save Error", "Couldn't save log contents: "
              + e.getLocalizedMessage());
          return;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "SafiServer Error",
          "Couldn't retrieve production SafiServer instance: " + e.getLocalizedMessage());
    }

  }

  public void requestImmediateUpdate() {
    try {
      SafiServerRemoteManager.getInstance().requestServerInfoUpdate();
    } catch (SafiServerManagementException e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "SafiServer Info Update Failure",
          "Couldn't update SafiServer info: " + e.getLocalizedMessage());
    }
  }

  protected void updateServer() {
    Object[] checked = updatesTableViewer.getCheckedElements();
    if (checked == null || checked.length == 0)
      return;
    boolean serverJarsTransported = false;
    int actionpaksTransported = 0;

    User user = SafiServerPlugin.getDefault().getCurrentUser();
    if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_UPDATE_SERVER)) {
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
          "You do not have sufficient privileges to carry out this operation.");
      return;
    }
    for (Object obj : checked) {
      if (obj instanceof SafiServerJar) {
        try {
          SafletPersistenceManager.getInstance().transferServerJar(((SafiServerJar) obj).url);
          serverJarsTransported = true;
        } catch (Exception e) {
          e.printStackTrace();
          AsteriskDiagramEditorPlugin.getInstance().logError(
              "Couldn't update SafiServer core file " + ((SafiServerJar) obj).url, e);
          MessageDialog.openError(getShell(), "SafiServer Core Update Failure",
              "Couldn't update SafiServer core file " + ((SafiServerJar) obj).url + ". "
                  + e.getLocalizedMessage());

        }
      } else if (obj instanceof ActionPak && ((ActionPak) obj).actionPakJars != null) {
        for (ActionPakJar jar : ((ActionPak) obj).actionPakJars) {
          try {
            SafletPersistenceManager.getInstance().transferActionPakJar(jar.url);
            actionpaksTransported++;
          } catch (Exception e) {
            e.printStackTrace();
            AsteriskDiagramEditorPlugin.getInstance().logError(
                "Couldn't update ActionPak file " + jar.url, e);
            MessageDialog.openError(getShell(), "SafiServer ActionPak Update Failure",
                "Couldn't update ActionPak file " + "Couldn't update ActionPak file " + jar.url
                    + ". " + e.getLocalizedMessage());
          }
        }

      }
    }

    if (serverJarsTransported) {
      if (MessageDialog
          .openQuestion(
              getShell(),
              "Restart SafiServer?",
              "The SafiServer must be restarted for some of the changes to take effect.  Would you like to restart the server now?")) {
        try {
          SafiServerRemoteManager.getInstance().restartServerService();
        } catch (SafiServerManagementException e) {
          AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't restart SafiServer: ", e);
          MessageDialog.openError(getShell(), "Restart Server Error",
              "The remote SafiServer couldn't be restarted: " + e.getLocalizedMessage());
          e.printStackTrace();
        }
      }
    } else if (actionpaksTransported > 0) {
      MessageDialog.openInformation(getShell(), "ActionPak Update Successful",
          actionpaksTransported
              + (actionpaksTransported > 1 ? " ActionPaks were" : "ActionPak was")
              + " successfully uploaded to the SafiServer.");
    }
    reloadModel();
  }

  private void reloadModel() {
    actionPaks = new ArrayList<ActionPak>(SafletPersistenceManager.getInstance()
        .getActionPaksForUpdate());
    safiServerJars = SafletPersistenceManager.getInstance().getNewServerJars();
    updatesTableViewer.setInput(new Object());
  }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

  public void update(SysInfo info) {
    if (isDisposed() || info == null || currentInfo == info || info.equals(currentInfo))
      return;
    this.currentInfo = info;

    final double totalMemInMegs = info.getTotalMemory() / BYTES_PER_MEGABYTE;
    memoryBar.setMaximum((int) totalMemInMegs);
    memoryBar.setSelection((int) (totalMemInMegs - (info.getFreeMemory() / BYTES_PER_MEGABYTE)));
    String totalString = StorageUnit.of(info.getTotalMemory()).format(info.getTotalMemory());
    String memString = StorageUnit.of(info.getTotalMemory() - info.getFreeMemory()).format(
        info.getTotalMemory() - info.getFreeMemory());
    final String totMemString = String.format(SEVER_MEMORY_LABEL_FORMAT, memString, totalString);
    serverMemoryLabel.setText(totMemString);
    serverMemoryLabel.pack();

    double totalDriveSpace = info.getTotalSpace() / BYTES_PER_MEGABYTE;
    driveSpaceBar.setMaximum((int) totalDriveSpace);
    driveSpaceBar.setSelection((int) (info.getFreeSpace() / BYTES_PER_MEGABYTE));

    String totalSpace = StorageUnit.of(info.getTotalSpace()).format(info.getTotalSpace());
    String usedSpace = StorageUnit.of(info.getTotalSpace() - info.getFreeSpace()).format(
        info.getTotalSpace() - info.getFreeSpace());
    driveSpaceLabel.setText(String.format(DRIVE_SPACE_LABEL_FORMAT, usedSpace, totalSpace));
    driveSpaceLabel.pack();

    cpuUsageBar.setMaximum(100);
    cpuUsageBar.setSelection((int) Math.floor(info.getCPUUsage() * 100d));
    cpuUsageLabel.setText(String.format("CPU Usage %1$-4s", info.getCPUUsage() == -1d ? "NA"
        : NumberFormat.getPercentInstance().format(info.getCPUUsage())));
    cpuUsageLabel.pack();

    ipAddressLabel.setText(info.getIPAddress());
    ipAddressLabel.pack();

    macAddressLabel.setText(info.getMacAddress());
    macAddressLabel.pack();

    incomingCallsLabel.setText(String.valueOf(info.getIncomingCalls()));
    incomingCallsLabel.pack();

    custInitiationsLabel.setText(String.valueOf(info.getCustomInitiations()));
    custInitiationsLabel.pack();

    int days = (int) (info.getUptime() / MILLIS_PER_DAY);
    int hours = (int) ((info.getUptime() - days * MILLIS_PER_DAY) / MILLIS_PER_HOUR);
    int minutes = (int) ((info.getUptime() - (days * MILLIS_PER_DAY + hours * MILLIS_PER_HOUR)) / MILLIS_PER_MINUTE);
    StringBuffer buf = new StringBuffer();
    boolean hadPrev = false;
    if (days > 0) {
      buf.append(days).append(days > 1 ? " Days" : " Day");
      hadPrev = true;
    }

    if (hours > 0) {
      if (hadPrev)
        buf.append(",");
      buf.append(hours).append(hours > 1 ? " Hours" : " Hour");
      hadPrev = true;
    }

    if (minutes > 0) {
      if (hadPrev)
        buf.append(",");
      buf.append(minutes).append(minutes > 1 ? " Minutes" : " Minute");
    }

    uptimeLabel.setText(buf.toString());
    uptimeLabel.pack();

    final Calendar instance = Calendar.getInstance();
    instance.setTimeInMillis(System.currentTimeMillis() - info.getUptime());
    lastRebootLabel.pack();

    label_1.setText(info.getServerID());
    label_1.pack();

    this.safiServerVersionLabel.setText(info.getSafiServerVersion() == null ? "" : info
        .getSafiServerVersion());
    this.safiserverHeaderVersionLabel.setText(info.getSafiServerVersion() == null ? "" : info
        .getSafiServerVersion());

    safiserverHeaderVersionLabel.pack();
    safiServerVersionLabel.pack();
  }

  public static void main(String[] args) {
    String s = String.format(DRIVE_SPACE_LABEL_FORMAT, "44.1 MB", "45.3 MB");
    System.err.println(s);
    s = NumberFormat.getPercentInstance().format(.4433d);
    System.err.println(String.format("CPU Usage %1$-4s", s));
  }

  class ContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      List<Object> objects = new ArrayList<Object>();
      objects.addAll(safiServerJars);
      objects.addAll(actionPaks);
      return objects.toArray();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }

  private void process(Document document) {

  }

  public void selectLicenseViewTab() {
    // TODO Auto-generated method stub
  }

  class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
    public String getColumnText(Object element, int columnIndex) {
      if (element instanceof ActionPak) {
        if (columnIndex == 0)
          return ((ActionPak) element).name;
        else if (columnIndex == 1)
          return ((ActionPak) element).description;
      } else if (element instanceof SafiServerJar) {
        if (columnIndex == 0)
          return ((SafiServerJar) element).url.getFile();
        else if (columnIndex == 1)
          return ((SafiServerJar) element).description;
      }
      return element.toString();
    }

    public Image getColumnImage(Object element, int columnIndex) {

      if (element instanceof ActionPak) {
        if (columnIndex == 0)
          return ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
              "icons/serverview/update_package.gif");
      } else if (element instanceof SafiServerJar) {
        if (columnIndex == 0)
          return ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
              "icons/serverview/update_servercore.gif");
      }
      return null;
    }
  }

  public enum StorageUnit {
    BYTE("B", 1L), KILOBYTE("KB", 1L << 10), MEGABYTE("MB", 1L << 20), GIGABYTE("GB", 1L << 30), TERABYTE(
        "TB", 1L << 40), PETABYTE("PB", 1L << 50), EXABYTE("EB", 1L << 60);

    public static final StorageUnit BASE = BYTE;

    private final String symbol;
    private final long divider; // divider of BASE unit

    StorageUnit(String name, long divider) {
      this.symbol = name;
      this.divider = divider;
    }

    public static StorageUnit of(final long number) {
      final long n = number > 0 ? -number : number;
      if (n > -(1L << 10)) {
        return BYTE;
      } else if (n > -(1L << 20)) {
        return KILOBYTE;
      } else if (n > -(1L << 30)) {
        return MEGABYTE;
      } else if (n > -(1L << 40)) {
        return GIGABYTE;
      } else if (n > -(1L << 50)) {
        return TERABYTE;
      } else if (n > -(1L << 60)) {
        return PETABYTE;
      } else { // n >= Long.MIN_VALUE
        return EXABYTE;
      }
    }

    public String format(long number) {
      return nf.format((double) number / divider) + " " + symbol;
    }

    private static java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
    static {
      nf.setGroupingUsed(false);
      nf.setMinimumFractionDigits(0);
      nf.setMaximumFractionDigits(1);
    }

  }

}
