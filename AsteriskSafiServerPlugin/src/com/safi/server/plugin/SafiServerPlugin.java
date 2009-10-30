package com.safi.server.plugin;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Appender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.osgi.framework.BundleContext;

import com.jcraft.jsch.HostKey;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.UserInfo;
import com.safi.asterisk.handler.GlobalVariableManager;
import com.safi.asterisk.handler.mbean.SysInfo;
import com.safi.asterisk.util.AsteriskSafletConstants;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.saflet.impl.SafletImpl;
import com.safi.db.SafiDriverManager;
import com.safi.db.Variable;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.Entitlement;
import com.safi.db.server.config.Role;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;
import com.safi.server.manager.DebugEventListener;
import com.safi.server.manager.SafiServerManagementException;
import com.safi.server.manager.SafiServerRemoteManager;
import com.safi.server.preferences.PreferenceConstants;
import com.safi.server.preferences.SafiServerStatusListener;
import com.safi.server.util.Utils;

/**
 * The activator class controls the plug-in life cycle
 */
public class SafiServerPlugin extends AbstractUIPlugin {

  private static final String REGEX_PATT_IP = "^((0|1[0-9]{0,2}|2[0-9]{0,1}|2[0-4][0-9]|25[0-5]|[3-9][0-9]{0,1})\\.){3}(0|1[0-9]{0,2}|2[0-9]{0,1}|2[0-4][0-9]|25[0-5]|[3-9][0-9]{0,1})$";
  // public static final String AST_DEBUG_NAME_SUFFIX = "(Debug)";
  private static final String SAFI_SERVER_CONSOLE = "SafiServerConsole";
  private static final String SAFI_DEBUG_CONSOLE = "SafiDebugConsole";
  public static final String WORKBENCH_DEBUGLOG = "WORKBENCH_DEBUGLOG";
  // The plug-in ID
  public static final String PLUGIN_ID = "com.safi.server";

  // The shared instance
  private static SafiServerPlugin plugin;

  // private MessageConsole debugConsole;

  private SafiDriverManager driverManager;
  private List<SafiServerStatusListener> authListeners;
  private User currentUser;
  private SafiServer currentServer;
  private boolean localSafiServer;
  // private SafiServer localServer;
  // private AsteriskServer debugAsteriskServer;

  // private NotifyingListImpl<Variable> globalVariables = new
  // NotifyingListImpl<Variable>() {
  // Notifier notifier = new NotifierImpl();
  //
  // @Override
  // protected boolean isNotificationRequired() {
  // // TODO Auto-generated method stub
  // return true;
  // }
  //
  // @Override
  // public Object getNotifier() {
  // // TODO Auto-generated method stub
  // return notifier;
  // }
  // };
  private static MessageConsole serverConsole;
  // private static MessageConsole debugConsole;
  private static Appender debugConsoleAppender;
  public final static Logger debuggerLog = Logger.getLogger(WORKBENCH_DEBUGLOG);
  private ProdServerPrefListener prefListener;

  public static String SSH_HOME_DEFAULT = null;
  static {
    String ssh_dir_name = ".ssh"; //$NON-NLS-1$

    // Windows doesn't like files or directories starting with a dot.
    if (Platform.getOS().equals(Platform.OS_WIN32)) {
      ssh_dir_name = "ssh"; //$NON-NLS-1$
    }
    SSH_HOME_DEFAULT = System.getProperty("user.home"); //$NON-NLS-1$
    if (SSH_HOME_DEFAULT != null) {
      SSH_HOME_DEFAULT = SSH_HOME_DEFAULT + java.io.File.separator + ssh_dir_name;
    }
  }

  /**
   * The constructor
   */
  public SafiServerPlugin() {
    authListeners = new LinkedList<SafiServerStatusListener>();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  public void start(BundleContext context) throws Exception {
    super.start(context);
    // GlobalVariableManager.getInstance().setDebug(true);
    initLogging();
    // initDebugConsole();
    Log log = LogFactory.getLog(SafiServerPlugin.class);
    plugin = this;
    // IWorkspace workspace = ResourcesPlugin.getWorkspace();
    // if (workspace != null)
    // workspace.getRoot().refreshLocal(3, null);
    // IWorkspaceRoot root = workspace.getRoot();
    // getPreferenceStore().addPropertyChangeListener(new ProdServerPrefListener());
    // initializeResources(new NullProgressMonitor());

  }

//  public Job getPostStartupJob() {
//    final Job job = new Job("Initialize Server Resources") {
//
//      @Override
//      protected IStatus run(IProgressMonitor monitor) {
//        try {
//          initializeResources(monitor);
//        } catch (Exception ex) {
//          ex.printStackTrace();
//        }
//        return new Status(IStatus.OK, getClass().getName(), IStatus.OK,
//            "Server Resources Initialized", null);
//      }
//
//    };
//    return job;
//  }

  private volatile boolean isInitialized = false;
  private com.jcraft.jsch.Session sshTunnelSession;
  private JSch jsch;
  private boolean needToLoadKnownHosts = true;
  private Map<Integer, Integer> tunnels = new HashMap<Integer, Integer>();
  private int currentSSHDBPortNum;
  private int currentSSHMgmtNum;
//  private boolean isErrorOccurred;

  public synchronized void initializeResources(IProgressMonitor monitor) throws Exception {
    if (isInitialized)
      return;
    try {
//      isErrorOccurred = false;
      try {
        monitor.beginTask("Initialize Resources", 6);
        monitor.subTask("Init driver manager");
        loadDriverManager();
        monitor.worked(1);
      } catch (Exception e) {
        getLog().log(new Status(Status.ERROR, PLUGIN_ID, "Couldn't load driver manager", e));
      }

      if (isUseTunnel() && !isTunnelEstablished()) {
        try {
          monitor.subTask("Init SSH Tunnel");
          establishSSHTunnel();
        } catch (Exception e) {
          getLog().log(new Status(Status.ERROR, PLUGIN_ID, "Couldn't establish SSH tunnel", e));
//          isErrorOccurred = true;
//          try {
//            monitor.subTask("Init DB manager");
//            refreshDBManagerIfNecessary();
//            monitor.worked(1);
//          } catch (Exception ex) {
//            ex.printStackTrace();
//          }
          
          SafiServerRemoteManager.getInstance().reset();
          currentServer = null;
          currentUser = null;
          notifyListenersConnectionChange(false);
          
          throw e;
        }
      } else
        monitor.subTask("Skipping SSH");

//        if (!isErrorOccurred) {
          monitor.subTask("Init DB manager");
          initDBManager();
          monitor.worked(1);
//        } else {
//          monitor.subTask("Init DB manager");
//          refreshDBManagerIfNecessary();
//          monitor.worked(1);
//        }

      

      // localServer.getAsteriskServers().add(debugAsteriskServer);
//        if (!isErrorOccurred) {
          monitor.subTask("Initializing Remote SafiServer management tooling");
          refreshRemoteManagement();
          monitor.worked(1);
//        }
     
    } finally {
      // if(!isErrorOccurred){
      isInitialized = true;
      // }
    }
  }

  private void initDBManager() throws Exception {
    refreshDBManagerIfNecessary();
    // refreshDebugServer();
    refreshProdSafiServer();

    // if (StringUtils.isNotBlank(hostname) && StringUtils.isNotBlank(user)
    // && !DBManager.getInstance().isInitialized())
    // DBManager.getInstance().initializeDB();

  }

  private void refreshDBManagerIfNecessary() {
    IPreferenceStore store = getPreferenceStore();

    String hostname = store.getString(PreferenceConstants.PREF_SAFISERVER_HOSTNAME_PROD);
    String user = store.getString(PreferenceConstants.PREF_SAFISERVER_USER_PROD);
    String password = store.getString(PreferenceConstants.PREF_SAFISERVER_PASS_PROD);
    int portNumber = store.getInt(PreferenceConstants.PREF_DB_PORT_PROD);

    if (isUseTunnel() && sshTunnelSession != null && sshTunnelSession.isConnected()) {
      hostname = "127.0.0.1";
      portNumber = currentSSHDBPortNum;
    }

    DBManager.getInstance().setHost(hostname, true);
    DBManager.getInstance().setUsername(user, true);
    DBManager.getInstance().setPassword(password, true);
    DBManager.getInstance().setPort(
        portNumber < 0 ? store.getDefaultInt(PreferenceConstants.PREF_DB_PORT_PROD) : portNumber,
        true);
  }

  private void loadGlobalVariables() throws DBManagerException {
    if (hasProductionServerInfo() && StringUtils.isNotBlank(DBManager.getInstance().getHost()))
      GlobalVariableManager.getInstance().getGlobalVariables();
  }

  public void addGlobalVarListener(Adapter a) {

    GlobalVariableManager.getInstance().addGlobalVarListener(a);
    // ((Notifier) globalVariables.getNotifier()).eAdapters().add(a);
  }

  public void removeGlobalVarListener(Adapter a) {
    GlobalVariableManager.getInstance().removeGlobalVarListener(a);
    // ((Notifier) globalVariables.getNotifier()).eAdapters().remove(a);
  }

  public void addGlobalVariable(final Variable v) throws InvocationTargetException,
      InterruptedException {

    PlatformUI.getWorkbench().getProgressService().run(true, false, new IRunnableWithProgress() {

      @Override
      public void run(IProgressMonitor monitor) throws InvocationTargetException,
          InterruptedException {
        try {
          GlobalVariableManager.getInstance().addGlobalVariable(v);
        } catch (final Exception e) {
          e.printStackTrace();
          final Display d = Display.getDefault();
          d.asyncExec(new Runnable() {
            @Override
            public void run() {
              MessageDialog.openError(d.getActiveShell(), "Global Var Update Error",
                  "Couldn't create global variable: " + e.getLocalizedMessage());

            }
          });

        }
      }
    });

    // Variable newvar = DBManager.getInstance().changeGlobalVariableName(variable,
    // newName);
    // int idx = globalVariables.indexOf(variable);
    // globalVariables.remove(variable);
    // globalVariables.add(idx, newvar);
  }

  public void deleteGlobalVariable(final Variable v) throws InvocationTargetException,
      InterruptedException {

    PlatformUI.getWorkbench().getProgressService().run(true, false, new IRunnableWithProgress() {

      @Override
      public void run(IProgressMonitor monitor) throws InvocationTargetException,
          InterruptedException {
        try {
          GlobalVariableManager.getInstance().deleteGlobalVariable(v);
        } catch (final Exception e) {
          e.printStackTrace();
          final Display d = Display.getDefault();
          d.asyncExec(new Runnable() {
            @Override
            public void run() {
              MessageDialog.openError(d.getActiveShell(), "Global Var Delete Error",
                  "Couldn't delete global variable: " + e.getLocalizedMessage());

            }
          });

        }
      }
    });
  }

  public Variable getGlobalVariable(String name) {
    if (isConnected())
      return GlobalVariableManager.getInstance().getGlobalVariable(name, false);
    else
      return null;
  }

  public Variable setGlobalVariable(final String name, final Object value)
      throws InvocationTargetException, InterruptedException {

    final Variable[] va = new Variable[1];
    PlatformUI.getWorkbench().getProgressService().run(true, false, new IRunnableWithProgress() {

      @Override
      public void run(IProgressMonitor monitor) throws InvocationTargetException,
          InterruptedException {
        try {
          GlobalVariableManager.getInstance().setGlobalVariable(name, value);
          // for (Variable v : globalVariables) {
          // if (StringUtils.equals(name, v.getName())) {
          // v.setDefaultValue(value);
          // DBManager.getInstance().saveOrUpdateGlobalVariable(v);
          // va[0] = v;
          // return;
          // }
          // }
        } catch (final Exception e) {
          e.printStackTrace();
          final Display d = Display.getDefault();
          d.asyncExec(new Runnable() {
            @Override
            public void run() {
              MessageDialog.openError(d.getActiveShell(), "Global Var Delete Error",
                  "Couldn't delete global variable: " + e.getLocalizedMessage());

            }
          });

        }
      }
    });

    return va[0];
  }

  public void loadDriverManager() throws IOException {
    loadDriverManager(false);
  }

  public void loadDriverManager(boolean reload) throws IOException {
    if (driverManager == null || reload) {
      if (ResourcesPlugin.getWorkspace() == null) {
        throw new IOException("Can't load driver manager since workspace is null");
      }
      IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
      String rootPath = null;
      if (root.exists())
        rootPath = root.getLocation().toFile().getAbsolutePath();
      else
        rootPath = ".";

      driverManager = DBManager.getInstance().getDriverManagerFromFile(
          rootPath + File.separatorChar + "SafiDBResources.db");
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
    authListeners.clear();
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static SafiServerPlugin getDefault() {
    return plugin;
  }

  /**
   * Returns an image descriptor for the image file at the given plug-in relative path
   * 
   * @param path
   *          the path
   * @return the image descriptor
   */
  public static ImageDescriptor getImageDescriptor(String path) {
    return imageDescriptorFromPlugin(PLUGIN_ID, path);
  }

  public SafiDriverManager getDriverManager() {
    return driverManager;
  }

  // public void initDebugConsole() {
  // IConsole[] consoles = ConsolePlugin.getDefault().getConsoleManager().getConsoles();
  // IDialogSettings dialogSetting = ConsolePlugin.getDefault().getDialogSettings();
  //
  // IDialogSettings[] dialogSettings =
  // ConsolePlugin.getDefault().getDialogSettings().getSections();
  // // for (IDialogSettings ids : dialogSettings) {
  // // System.out.println(ids);
  // // }
  // // IDialogSettings dialogSetting=ConsolePlugin.getDefault().getDialogSettings();
  //
  // for (IConsole console : consoles) {
  // if (SAFI_DEBUG_CONSOLE.equals(console.getName())) {
  // debugConsole = (MessageConsole) console;
  //
  // break;
  // }
  // }
  // if (debugConsole == null) {
  // debugConsole = new MessageConsole(SAFI_DEBUG_CONSOLE, null);
  //
  // ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] {
  // debugConsole });
  // }
  //
  // ConsolePlugin.getDefault().getConsoleManager().showConsoleView(debugConsole);
  // MessageConsoleStream os = debugConsole.newMessageStream();
  // setDebugStream(os);
  //
  // }

  private void initLogging() {
    debuggerLog.setLevel(Level.OFF);
    debuggerLog.setAdditivity(false);
  }

  public void setDebugStream(OutputStream os) {
    if (debugConsoleAppender == null) {
      Layout layout = new PatternLayout(AsteriskSafletConstants.DEBUG_PATTERN_LAYOUT);
      debugConsoleAppender = new WriterAppender(layout, os);
      debuggerLog.addAppender(debugConsoleAppender);
      debuggerLog.setLevel(Level.DEBUG);
    }
  }

  // public void startDebugLog() {
  // if (debugConsole != null) {
  // if (debugConsoleAppender == null) {
  // Layout layout = new PatternLayout(AsteriskSafletConstants.DEBUG_PATTERN_LAYOUT);
  // debugConsoleAppender = new WriterAppender(layout, debugConsole.newMessageStream());
  // debuggerLog.addAppender(debugConsoleAppender);
  // }
  // debuggerLog.setLevel(Level.DEBUG);
  // ConsolePlugin.getDefault().getConsoleManager().showConsoleView(debugConsole);
  // }
  // }
  //
  // public void stopDebugLog() {
  // if (debugConsoleAppender != null) {
  // debuggerLog.removeAppender(debugConsoleAppender);
  // debugConsoleAppender.close();
  // debugConsoleAppender = null;
  // }
  // }

  public void initServerConsole() {
    IConsole[] consoles = ConsolePlugin.getDefault().getConsoleManager().getConsoles();
    for (IConsole console : consoles) {
      if (SAFI_SERVER_CONSOLE.equals(console.getName())) {
        serverConsole = (MessageConsole) console;
        break;
      }
    }
    // IViewDescriptor desc =
    // getWorkbench().getViewRegistry().find(IConsoleConstants.ID_CONSOLE_VIEW);
    // if (desc != null){
    // IViewReference[] refs =
    // getWorkbench().getActiveWorkbenchWindow().getActivePage().getViewReferences();
    // for (IViewReference ref : refs){
    //
    // if (ref.getId().equals(IConsoleConstants.ID_CONSOLE_VIEW)){
    // // IExtensionPoint extensionPoint =
    // Platform.getExtensionRegistry().getExtensionPoint(ConsolePlugin.getUniqueIdentifier(),
    // IConsoleConstants.EXTENSION_POINT_CONSOLE_FACTORIES);
    // // Platform.getExtensionRegistry().removeExtensionPoint(extensionPoint, null);
    // // ((ConsoleView)ref.getView(false).
    // }
    // }
    // }
    if (serverConsole == null) {
      serverConsole = new MessageConsole(SAFI_SERVER_CONSOLE, null);
      ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { serverConsole });
    }
    ConsolePlugin.getDefault().getConsoleManager().showConsoleView(serverConsole);
    // MessageConsoleStream os = serverConsole.newMessageStream();
  }

  public MessageConsole getServerConsole() {
    return serverConsole;
  }

  public void hideServerConsole() {
    if (serverConsole != null) {
      ConsolePlugin.getDefault().getConsoleManager().removeConsoles(
          new IConsole[] { serverConsole });
      serverConsole = null;
    }
  }
  public class ProdServerPrefListener implements org.eclipse.jface.util.IPropertyChangeListener {

    @Override
    public void propertyChange(org.eclipse.jface.util.PropertyChangeEvent event) {
      String property = event.getProperty();
      if (PreferenceConstants.PREF_SERVER_TRACELOG_LEVEL.equals(property)) {
        String level = (String) event.getNewValue();
        if (SafiServerRemoteManager.getInstance().isConnected()) {
          setServerTracelogLevel(level);
        }
      } else if (PreferenceConstants.PREF_SERVER_INFO_UPDATE_PERIOD.equals(property)) {
        try {
          Integer val = (Integer) event.getNewValue();
          if (SafiServerRemoteManager.getInstance().isConnected())
            setServerInfoUpdatePeriod(val);
        } catch (NumberFormatException e) {
          logError("Illegal value for server info update perdiod: " + event.getNewValue());
        }

        // updateServerInfoUpdatePeriod();
      } else if (PreferenceConstants.PREF_SERVER_ERROR_NOTIFICATION.equals(property)
          || PreferenceConstants.PREF_SERVER_INFO_NOTIFICATION.equals(property))
        SafiServerRemoteManager.getInstance().notificationPreferencesChanged();
    }
  }

  public void updateServerResources(IProgressMonitor monitor) throws SafiServerManagementException,
      DBManagerException, JSchException, Exception {

    String serverHostName;
    int dbPort;
    String sshIP = getPreferenceStore()
        .getString(PreferenceConstants.PREF_SAFISERVER_HOSTNAME_PROD);
    checkForLocalIP(sshIP);
    if (isUseTunnel()) {

      establishSSHTunnel(monitor);
      if (monitor.isCanceled())
        return;
      serverHostName = "127.0.0.1";
      dbPort = currentSSHDBPortNum;
    } else {
      serverHostName = getPreferenceStore().getString(
          PreferenceConstants.PREF_SAFISERVER_HOSTNAME_PROD);
      dbPort = getPreferenceStore().getInt(PreferenceConstants.PREF_DB_PORT_PROD);
    }

    if (monitor.isCanceled())
      return;
    

    currentServer = null;
    currentUser = null;
    monitor.subTask("Create Remote Settings");
    refreshRemoteManagement();
    monitor.worked(1);
    
    DBManager.getInstance().setHost(serverHostName, true);
    if (monitor.isCanceled())
      return;
    DBManager.getInstance().setUsername(
        getPreferenceStore().getString(PreferenceConstants.PREF_SAFISERVER_USER_PROD), true);
    if (monitor.isCanceled())
      return;
    DBManager.getInstance().setPassword(
        getPreferenceStore().getString(PreferenceConstants.PREF_SAFISERVER_PASS_PROD), true);
    if (monitor.isCanceled())
      return;
    DBManager.getInstance().setPort(dbPort, true);

    if (monitor.isCanceled())
      return;
    monitor.beginTask("Update Server Resources", 4);

    monitor.subTask("Update Debug Environment");
    // refreshDebugServer();
    monitor.worked(1);

    if (monitor.isCanceled())
      return;
    monitor.subTask("Update User");
    updateUser();
    monitor.worked(1);

    if (monitor.isCanceled())
      return;
    monitor.subTask("Retrieve SafiServer settings");
    refreshSafiServer();
    monitor.worked(1);

    GlobalVariableManager.getInstance().loadGlobalVariables();
    monitor.worked(1);
    // monitor.subTask("Notify Authorization Change event");
    // notifyListenersConnectionChange(isConnected());
    // notifyListenersAuthChange();
    // monitor.worked(1);
  }

  private boolean checkForLocalIP(String sshIP) {
    if (!sshIP.matches(REGEX_PATT_IP)) {
      try {
        InetSocketAddress addr = new InetSocketAddress(sshIP, 0);
        sshIP = addr.getAddress().getHostAddress();
      } catch (Exception e) {
        // e.printStackTrace();
        return false;
      }

    }

    if (Utils.getLocalIPAddresses().contains(sshIP)) {
      localSafiServer = true;
      return true;
    } else {
      localSafiServer = false;
      return false;
    }

  }

  public boolean isUseTunnel() {
    return !localSafiServer;
  }

  public synchronized JSch getJSch() {
    if (jsch == null)
      jsch = new JSch();
    return jsch;
  }

  public void loadKnownHosts() {
    String ssh_home = getPreferenceStore().getString(PreferenceConstants.KEY_SSH2HOME);

    if (ssh_home.length() == 0)
      ssh_home = SSH_HOME_DEFAULT;

    java.io.File file = new java.io.File(ssh_home, "known_hosts"); //$NON-NLS-1$
    try {
      getJSch().setKnownHosts(file.getPath());
    } catch (JSchException e) {
      logError("An error occurred while loading the know hosts file " + file, e);
    }
    needToLoadKnownHosts = false;
  }

  public boolean isNeedToLoadKnownHosts() {
    return needToLoadKnownHosts;
  }

  public void setNeedToLoadKnownHosts(boolean needToLoadKnownHosts) {
    this.needToLoadKnownHosts = needToLoadKnownHosts;
  }

  //
  // public boolean isNeedToLoadKeys(){
  // return needToLoadKeys;
  // }
  //
  // public void setNeedToLoadKeys(boolean needToLoadKeys){
  // this.needToLoadKeys=needToLoadKeys;
  // }

  public boolean isTunnelEstablished() {
    return sshTunnelSession != null && sshTunnelSession.isConnected();
  }

  public void disconnectManagement() {
    SafiServerRemoteManager.getInstance().reset();

  }

  public void disconnectSSHTunnel() {
    if (sshTunnelSession != null && sshTunnelSession.isConnected()) {
      try {
        sshTunnelSession.disconnect();
      } catch (Exception e) {
      }
    }
    tunnels.clear();
  }

  private void establishSSHTunnel() throws JSchException, IOException {
    establishSSHTunnel(null);
  }

  private void establishSSHTunnel(IProgressMonitor monitor) throws JSchException, IOException {

    if (needToLoadKnownHosts) {
      if (monitor != null) {
        if (monitor.isCanceled())
          return;
        monitor.setTaskName("Loading SSH host file");
      }
      loadKnownHosts();
      if (monitor != null)
        monitor.worked(1);
    }
    String sshUser = getPreferenceStore().getString(PreferenceConstants.PREF_SAFISERVER_USER_PROD);
    String sshIP = getPreferenceStore()
        .getString(PreferenceConstants.PREF_SAFISERVER_HOSTNAME_PROD);

    if (checkForLocalIP(sshIP))
      return;
    JSch jsch = getJSch();
    int sshPort = getPreferenceStore().getInt(PreferenceConstants.PREF_SSH_SERVER_PORT);
    String pass = getPreferenceStore().getString(PreferenceConstants.PREF_SAFISERVER_PASS_PROD);

    boolean isnew = false;
    if (sshTunnelSession != null && sshTunnelSession.isConnected()) {
      if (!StringUtils.equals(sshTunnelSession.getHost(), sshIP)
          || sshPort != sshTunnelSession.getPort()) {
        sshTunnelSession.disconnect();
        sshTunnelSession = null;
      }
    }

    if (sshTunnelSession == null || !sshTunnelSession.isConnected()) {
      isnew = true;

      sshTunnelSession = jsch.getSession(sshUser, sshIP, sshPort);
      sshTunnelSession.setTimeout(10000);
      MyUserInfo2 ui = new MyUserInfo2(pass);
      sshTunnelSession.setUserInfo(ui);
      if (monitor != null) {
        if (monitor.isCanceled())
          return;
        monitor.setTaskName("Initiating SSH connection");
      }
      sshTunnelSession.connect();
      if (monitor != null)
        monitor.worked(1);
    }
    HostKey key = sshTunnelSession.getHostKey();
    // int sshDBPortNum = getPreferenceStore().getInt(
    // PreferenceConstants.PREF_SSH_FORWARDING_DB_PORT_LOCAL);
    int sshDBPortRemote = getPreferenceStore().getInt(PreferenceConstants.PREF_DB_PORT_PROD);

    int sshDBPortNum = -1;
    if (!isnew) {
      if (currentSSHDBPortNum > 0) {
        try {
          sshTunnelSession.delPortForwardingL(currentSSHDBPortNum);
        } catch (Exception e) {
        }

        if (com.safi.server.util.Utils.isServerPortAvail(currentSSHDBPortNum))
          sshDBPortNum = currentSSHDBPortNum;
        else {
          sshDBPortNum = com.safi.server.util.Utils.findFreePort();
        }
      } else {
        sshDBPortNum = com.safi.server.util.Utils.findFreePort();
      }

    } else
      sshDBPortNum = com.safi.server.util.Utils.findFreePort();

    if (monitor != null) {
      if (monitor.isCanceled())
        return;
      monitor.setTaskName("Forwarding ports");
    }
    sshTunnelSession.setPortForwardingL(sshDBPortNum, "127.0.0.1", sshDBPortRemote);
    currentSSHDBPortNum = sshDBPortNum;
    // System.out.println("local:"+this.ssh_dbport_num_local+" ssh_ip:"+ssh_ip+" dbport:"+this.ssh_dbport_num_remote);

    // int sshMgmtPort = getPreferenceStore().getInt(
    // PreferenceConstants.PREF_SSH_FORWARDING_MANAGEMENT_PORT_LOCAL);
    // int sshMgmtPortRemote =
    // getPreferenceStore().getInt(PreferenceConstants.PREF_MANAGER_PORT_PROD);
    // // int sshMgmtPort = com.safi.server.util.Utils.findFreePort();
    // int sshMgmtPort = sshMgmtPortRemote;
    // if (!isnew) {
    // if (currentSSHMgmtNum >= 0) {
    // try {
    // sshTunnelSession.delPortForwardingL(currentSSHMgmtNum);
    // } catch (Exception e) {
    // }
    // if (com.safi.server.util.Utils.isServerPortAvail(currentSSHMgmtNum))
    // sshMgmtPort = currentSSHMgmtNum;
    //
    //
    // }
    // }
    //
    // sshTunnelSession.setPortForwardingL(sshMgmtPort, "127.0.0.1", sshMgmtPortRemote);
    // currentSSHMgmtNum = sshMgmtPort;

    if (isnew)
      for (Map.Entry<Integer, Integer> entry : tunnels.entrySet()) {
        // try {
        // sshTunnelSession.delPortForwardingL(entry.getValue());
        // } catch (Exception e) {
        // }
        sshTunnelSession.setPortForwardingL(entry.getValue(), "127.0.0.1", entry.getKey());
      }
    // System.out.println("local:"+this.ssh_fastport_num_local+" ssh_ip:"+ssh_ip+" fastport:"+this.ssh_fastport_num_remote);

  }

  public synchronized void addTunnel(int localPort, int remotePort, String host) throws Exception {
    Integer oldPort = tunnels.get(remotePort);
    if (sshTunnelSession == null || !sshTunnelSession.isConnected())
      establishSSHTunnel();
    else {
      if (oldPort != null) {
        if (oldPort.intValue() == localPort)
          return;
        else {
          try {
            sshTunnelSession.delPortForwardingL(oldPort);
            tunnels.remove(remotePort);
          } catch (Exception e) {
            e.printStackTrace();
            logError("Couldn't delete port forward for " + oldPort, e);
          }

        }
      }

      // sshTunnelSession.setPortForwardingL(boundaddress, lport, host, rport)
      // 192.168.0.145
      sshTunnelSession.setPortForwardingL(localPort, host, remotePort);
      tunnels.put(remotePort, localPort);
      // if (bidirectional)
      // sshTunnelSession.setPortForwardingR(localPort, "127.0.0.1", remotePort);
    }

  }

  public synchronized void removeTunnel(int localPort) throws Exception {
    Integer port = tunnels.get(localPort);
    if (port != null && sshTunnelSession != null && sshTunnelSession.isConnected()) {
      sshTunnelSession.delPortForwardingL(localPort);
      tunnels.remove(localPort);
    }
  }

  public boolean isRemotePortForwarded(int remotePort) {
    if (sshTunnelSession == null || !sshTunnelSession.isConnected()
        || !tunnels.containsKey(remotePort))
      return false;
    return true;
  }

  public boolean isLocalPortForwarded(int localPort) {
    if (sshTunnelSession == null || !sshTunnelSession.isConnected()
        || !tunnels.containsValue(localPort))
      return false;
    return true;
  }

  private boolean refreshRemoteManagement() throws SafiServerManagementException {
    boolean success = false;
    SafiServerManagementException exception = null;
    try {
      success = SafiServerRemoteManager.getInstance().restartConnection();
    } catch (SafiServerManagementException e) {
      logWarn("Couldn't refresh remote connection", e);
      disconnectSSHTunnel();
      exception = e;
    }
    notifyListenersConnectionChange(success);
    if (success) {
      updateTraceLogLevel();
      updateServerInfoUpdatePeriod();
    }
    if (exception != null)
      throw (SafiServerManagementException) exception;
    return success;
  }

  public void updateTraceLogLevel() {

    try {
      String level = SafiServerRemoteManager.getInstance().getServerTracelogLevel();
      getPreferenceStore().setValue(PreferenceConstants.PREF_SERVER_TRACELOG_LEVEL, level);
      setServerTracelogLevel(level);
    } catch (SafiServerManagementException e) {
      e.printStackTrace();
      logError("Couldn't retrieve info update period", e);
    }

    // setServerInfoUpdatePeriod(getPreferenceStore().getInt(PreferenceConstants.PREF_SERVER_INFO_UPDATE_PERIOD));

  }

  public void updateServerInfoUpdatePeriod() {
    try {
      int period = SafiServerRemoteManager.getInstance().getServerInfoUpdatePeriod();
      getPreferenceStore().setValue(PreferenceConstants.PREF_SERVER_INFO_UPDATE_PERIOD, period);
    } catch (SafiServerManagementException e) {
      e.printStackTrace();
      logError("Couldn't retrieve info update period", e);
    }
    // setServerInfoUpdatePeriod(getPreferenceStore().getInt(PreferenceConstants.PREF_SERVER_INFO_UPDATE_PERIOD));
  }

  public void commitTraceLogLevel() {
    setServerTracelogLevel(getPreferenceStore().getString(
        PreferenceConstants.PREF_SERVER_TRACELOG_LEVEL));
  }

  public void commitServerInfoUpdatePeriod() {
    setServerInfoUpdatePeriod(getPreferenceStore().getInt(
        PreferenceConstants.PREF_SERVER_INFO_UPDATE_PERIOD));
  }

  public void refreshSafiServer() throws Exception {
    int oldMgtPort = -1;
    if (currentServer != null) {
      oldMgtPort = currentServer.getManagementPort();
      currentServer = null;
    }
    getSafiServer(true);
    // int sshMgmtPortRemote =
    // getPreferenceStore().getInt(PreferenceConstants.PREF_MANAGER_PORT_PROD);
    // int sshMgmtPortLocal = getPreferenceStore().getInt(
    // PreferenceConstants.PREF_SSH_FORWARDING_MANAGEMENT_PORT_LOCAL);
    int sshMgmtPort = currentServer.getManagementPort();
    if (currentSSHMgmtNum <= 0) {
      // currentSSHMgmtNum = Utils.findFreePort();
      currentSSHMgmtNum = sshMgmtPort;
    }

    if (oldMgtPort >= 0 && oldMgtPort != sshMgmtPort) {
      if (isLocalPortForwarded(currentSSHMgmtNum))
        try {
          removeTunnel(currentSSHMgmtNum);
          // sshTunnelSession.delPortForwardingL(currentSSHMgmtNum);
        } catch (Exception e) {
        }
    }
    try {
      refreshMgmtTunnelIfNecessary();
    } catch (Exception e) {
      logError("Couldn't establish management tunnel to " + currentServer.getBindIP(), e);
      final Display d = Display.getDefault();
      d.asyncExec(new Runnable() {
        @Override
        public void run() {
          if (d.getActiveShell() != null)
            MessageDialog.openError(d.getActiveShell(), "Management Connection Failure",
                "Management tunnel to " + currentServer.getBindIP()
                    + " could not be established. Please ensure that port " + currentSSHMgmtNum
                    + " is available on this machine.");

        }
      });

    }

  }

  public void refreshMgmtTunnelIfNecessary() throws Exception {
    int sshMgmtPort = currentServer.getManagementPort();
    if (currentSSHMgmtNum <= 0) {
      // currentSSHMgmtNum = Utils.findFreePort();
      currentSSHMgmtNum = sshMgmtPort;
    }

    if (!isLocalPortForwarded(currentSSHMgmtNum)) {
      addTunnel(currentSSHMgmtNum, sshMgmtPort, "127.0.0.1");
    }

  }

  // public void storeDebug(AsteriskServer aserver) {
  // IPreferenceStore store = getPreferenceStore();
  // if (aserver != null) {
  // store.setValue(PreferenceConstants.AST_DESCRIPTION_DEBUG, aserver.getDescription());
  // store.setValue(PreferenceConstants.PREF_AST_IP_DEBUG, aserver.getHostname());
  // store.setValue(PreferenceConstants.PREF_MGR_USER_DEBUG, aserver.getManagerName());
  // store.setValue(PreferenceConstants.PREF_MGR_PWD_DEBUG, aserver.getManagerPassword());
  // store.setValue(PreferenceConstants.PREF_MANAGER_PORT_DEBUG,
  // aserver.getManagerPort());
  // String name = aserver.getName();
  //
  // if (aserver != debugAsteriskServer && name != null &&
  // !name.endsWith(AST_DEBUG_NAME_SUFFIX))
  // name += AST_DEBUG_NAME_SUFFIX;
  // store.setValue(PreferenceConstants.AST_NAME_DEBUG, name);
  // store.setValue(PreferenceConstants.AST_SFTP_USER_DEBUG, aserver.getSftpUser());
  // store.setValue(PreferenceConstants.AST_SFTP_PASSWORD_DEBUG,
  // aserver.getSftpPassword());
  // store.setValue(PreferenceConstants.AST_SFTP_PORT_DEBUG, aserver.getSftpPort());
  // store.setValue(PreferenceConstants.AST_ACTIVE_DEBUG, aserver.isActive());
  // store.setValue(PreferenceConstants.PREF_AST_ID_DEBUG, aserver.getId());
  // store.setValue(PreferenceConstants.AST_PRIVATE_DEBUG, aserver.isPrivate());
  // store.setValue(PreferenceConstants.AST_PROMPT_DIR_DEBUG,
  // aserver.getPromptDirectory());
  //
  // } else {
  // store.setValue(PreferenceConstants.AST_DESCRIPTION_DEBUG, "");
  // store.setValue(PreferenceConstants.PREF_AST_IP_DEBUG, "");
  // store.setValue(PreferenceConstants.PREF_MGR_USER_DEBUG, "");
  // store.setValue(PreferenceConstants.PREF_MGR_PWD_DEBUG, "");
  // store.setValue(PreferenceConstants.PREF_MANAGER_PORT_DEBUG, -1);
  // store.setValue(PreferenceConstants.AST_NAME_DEBUG, "");
  // store.setValue(PreferenceConstants.AST_SFTP_USER_DEBUG, "");
  // store.setValue(PreferenceConstants.AST_SFTP_PASSWORD_DEBUG, "");
  // store.setValue(PreferenceConstants.AST_SFTP_PORT_DEBUG, -1);
  // store.setValue(PreferenceConstants.AST_ACTIVE_DEBUG, true);
  // store.setValue(PreferenceConstants.PREF_AST_ID_DEBUG, "");
  // store.setValue(PreferenceConstants.AST_PRIVATE_DEBUG, true);
  // store.setValue(PreferenceConstants.AST_PROMPT_DIR_DEBUG, "");
  // }
  // }

  // public void storeSafiServer(SafiServer safiServer) {
  // IPreferenceStore store = getPreferenceStore();
  // if (safiServer != null) {
  // store.setValue(PreferenceConstants.PREF_SAFISERVER_ID,
  // safiServer.getId());
  // store.setValue(PreferenceConstants.PREF_SAFISERVER_HOSTNAME,
  // safiServer.getBindIP());
  // store.setValue(PreferenceConstants.PREF_SAFISERVER_USER_PROD,
  // safiServer.getUser().getName());
  // store.setValue(PreferenceConstants.PREF_SAFISERVER_PASS,
  // safiServer.getUser().getPassword());
  // store.setValue(PreferenceConstants.PREF_DB_PORT, safiServer.getPort());
  // }
  // }

  @Override
  public IPreferenceStore getPreferenceStore() {

    IPreferenceStore store = super.getPreferenceStore();
    if (prefListener == null) {
      prefListener = new ProdServerPrefListener();
      store.addPropertyChangeListener(prefListener);
    }
    return store;
  }

  // public synchronized SafiServer createLocalSafiServerFromStore() {
  // IPreferenceStore store = getPreferenceStore();
  // if (localServer == null) {
  // localServer = ConfigFactory.eINSTANCE.createSafiServer();
  // }
  // String safiServerBindAddress =
  // store.getString(PreferenceConstants.PREF_SAFI_BIND_ADDR_LOCAL);
  // localServer.setName(localServer.getName() == null ? "Debug" : localServer.getName());
  // localServer.setDebug(true);
  // localServer.setBindIP(safiServerBindAddress);
  // int port = store.getInt(PreferenceConstants.PREF_FASTAGI_PORT_DEBUG);
  // localServer.setPort(port);
  // int mgtport = store.getInt(PreferenceConstants.PREF_SERVER_MGT_PORT_DEBUG);
  // localServer.setManagementPort(mgtport);
  // localServer.setId(-1);
  // return localServer;
  //
  // }

  // public void storeLocalSafiServerToPref() {
  // if (localServer == null)
  // return;
  // IPreferenceStore store = getPreferenceStore();
  // store.setValue(PreferenceConstants.PREF_SAFI_BIND_ADDR_LOCAL,
  // localServer.getBindIP());
  // store.setValue(PreferenceConstants.PREF_FASTAGI_PORT_DEBUG, localServer.getPort());
  // store.setValue(PreferenceConstants.PREF_SERVER_MGT_PORT_DEBUG,
  // localServer.getManagementPort());
  // }

  public boolean isConnected() {
    return (currentUser != null && currentServer != null && SafiServerRemoteManager.getInstance()
        .isConnected());
  }

  public SafiServer refreshProdSafiServer() throws Exception {

    IPreferenceStore store = getPreferenceStore();
    int id = store.getInt(PreferenceConstants.PREF_SAFISERVER_ID);

    SafiServer oldServer = currentServer;
    SafiServer newServer = null;
    Exception ex = null;
    if (currentUser == null)
      try {
        updateUser();
      } catch (DBManagerException e) {
        ex = e;
      } catch (JSchException e) {
        // TODO Auto-generated catch block
        ex = e;
      }

    localSafiServer = false;
    if (currentUser != null)
      try {
        System.err.println("SafiServer Hiberno instance updated...");
        newServer = DBManager.getInstance().getSafiServerConfig(id == 0 ? -1 : id);
      } catch (DBManagerException e) {
        ex = e;

      }

    this.currentServer = newServer;

    if (newServer == null && oldServer != null) {
      if (SafiServerRemoteManager.getInstance().isConnected())
        SafiServerRemoteManager.getInstance().reset();
      else
        notifyListenersConnectionChange(false);
    }
    if (ex != null)
      throw ex;
    if (currentServer != null) {
      checkForLocalIP(currentServer.getBindIP());
      loadGlobalVariables();
    }
    return currentServer;
  }

  public String getProductionServerDisplayHostname() {
    return getPreferenceStore().getString(PreferenceConstants.PREF_SAFISERVER_HOSTNAME_PROD);
  }

  // public synchronized AsteriskServer createDebugAsteriskFromStore() {
  // IPreferenceStore store = getPreferenceStore();
  // String desc = store.getString(PreferenceConstants.AST_DESCRIPTION_DEBUG);
  // String host = store.getString(PreferenceConstants.PREF_AST_IP_DEBUG);
  // String managerName = store.getString(PreferenceConstants.PREF_MGR_USER_DEBUG);
  // String managerPass = store.getString(PreferenceConstants.PREF_MGR_PWD_DEBUG);
  // int mport = store.getInt(PreferenceConstants.PREF_MANAGER_PORT_DEBUG);
  // String name = store.getString(PreferenceConstants.AST_NAME_DEBUG);
  // String sftpUser = store.getString(PreferenceConstants.AST_SFTP_USER_DEBUG);
  // String sftpPass = store.getString(PreferenceConstants.AST_SFTP_PASSWORD_DEBUG);
  // int sftpPort = store.getInt(PreferenceConstants.AST_SFTP_PORT_DEBUG);
  // boolean isActive = store.getBoolean(PreferenceConstants.AST_ACTIVE_DEBUG);
  //
  // boolean isPrivate = store.getBoolean(PreferenceConstants.AST_PRIVATE_DEBUG);
  // String dir = store.getString(PreferenceConstants.AST_PROMPT_DIR_DEBUG);
  //
  // // boolean isDebug =
  // // store.getBoolean(PreferenceConstants.AST_DEBUG_DEBUG);
  // if (debugAsteriskServer == null)
  // debugAsteriskServer = ConfigFactory.eINSTANCE.createAsteriskServer();
  //
  // debugAsteriskServer.setDescription(desc);
  // debugAsteriskServer.setHostname(host);
  // debugAsteriskServer.setManagerName(managerName);
  // debugAsteriskServer.setManagerPassword(managerPass);
  // debugAsteriskServer.setName(name);
  // debugAsteriskServer.setSftpUser(sftpUser);
  // debugAsteriskServer.setSftpPassword(sftpPass);
  // debugAsteriskServer.setSftpPort(sftpPort);
  // debugAsteriskServer.setActive(isActive);
  // debugAsteriskServer.setManagerPort(mport);
  // debugAsteriskServer.setPrivate(isPrivate);
  // debugAsteriskServer.setActive(isActive);
  // debugAsteriskServer.setPromptDirectory(dir);
  // return debugAsteriskServer;
  // }

  // public AsteriskServer createAstServerfromPrefs() {
  // IPreferenceStore store = getPreferenceStore();
  // String name = store.getString(PreferenceConstants.AST_NAME_DEBUG);
  // if (StringUtils.isBlank(name))
  // return null;
  // AsteriskServer server = ConfigFactory.eINSTANCE.createAsteriskServer();
  // server.setActive(store.getBoolean(PreferenceConstants.AST_ACTIVE_DEBUG));
  // server.setDescription(store.getString(PreferenceConstants.AST_DESCRIPTION_DEBUG));
  // server.setHostname(store.getString(PreferenceConstants.PREF_AST_IP_DEBUG));
  // server.setLastModified(new Date());
  // server.setManagerName(store.getString(PreferenceConstants.PREF_MGR_USER_DEBUG));
  // server.setManagerPort(store.getInt(PreferenceConstants.PREF_MANAGER_PORT_DEBUG));
  //
  // server.setName(name);
  // server.setSftpPassword(store.getString(PreferenceConstants.AST_SFTP_PASSWORD_DEBUG));
  // server.setSftpPort(store.getInt(PreferenceConstants.AST_SFTP_PORT_DEBUG));
  // server.setSftpUser(store.getString(PreferenceConstants.AST_SFTP_USER_DEBUG));
  // server.setPrivate(store.getBoolean(PreferenceConstants.AST_PRIVATE_DEBUG));
  // return server;
  // }

  public void addAuthListener(SafiServerStatusListener l) {
    if (!authListeners.contains(l))
      authListeners.add(l);
  }

  public void removeAuthListener(SafiServerStatusListener l) {
    authListeners.remove(l);
  }

  public void notifyResourcesChanged() {
    for (SafiServerStatusListener l : authListeners)
      l.resourcesChanged();
  }

  public void notifyListenersConnectionChange(boolean b) {
    for (SafiServerStatusListener l : authListeners)
      l.serverConnectionChange(b);
  }

  public void updateUser() throws DBManagerException, JSchException, IOException {
    if (isUseTunnel() && !isTunnelEstablished())
      establishSSHTunnel();

    String user = getPreferenceStore().getString(PreferenceConstants.PREF_SAFISERVER_USER_PROD);
    IWorkbenchWindow window = null;
    if (PlatformUI.isWorkbenchRunning()) {
      window = getWorkbench().getActiveWorkbenchWindow();
      if (StringUtils.isBlank(user)) {
        if (window != null && window.getShell() != null)
          window.getShell().setText("Not Logged In");
        user = null;
      }
    }
    String pass = getPreferenceStore().getString(PreferenceConstants.PREF_SAFISERVER_PASS_PROD);
    currentUser = null;
    if (user == null)
      return;
    Session session = null;
    try {
      refreshDBManagerIfNecessary();
      // DBManager.getInstance().setUsername(user, false);
      // DBManager.getInstance().setPassword(pass, false);
      session = DBManager.getInstance().createSession();
      Criteria criteria = session.createCriteria(User.class);
      this.currentUser = (User) criteria.add(
          Restrictions.and(Restrictions.eq("name", user), Restrictions.eq("password", pass)))
          .uniqueResult();
      if (currentUser != null) {
        if (window != null && window.getShell() != null)
          window.getShell().setText("Logged In: " + currentUser.getName());
      }
    } catch (DBManagerException e) {
      // refreshSafiServer();
      throw e;
    } finally {
      if (session != null) {
        session.close();
        session = null;
      }
    }
  }

  /*
   * public void refreshDebugServer() { // if (!DBManager.getInstance().isInitialized()) {
   * int debugID = getPreferenceStore().getInt(PreferenceConstants.PREF_AST_ID_DEBUG);
   * AsteriskServer debugServer = null; boolean connectionSuccessful = false; if (debugID
   * > 0) { Session session = null; try { session =
   * DBManager.getInstance().createSession(); connectionSuccessful = true; debugServer =
   * (AsteriskServer) session.createCriteria(AsteriskServer.class).add(
   * Restrictions.eq("id", debugID)).uniqueResult(); if (debugServer == null) {
   * getPreferenceStore().setValue(PreferenceConstants.PREF_AST_ID_DEBUG, null); } else {
   * storeDebug(debugServer);
   * MessageDialog.openInformation(getWorkbench().getDisplay().getActiveShell(),
   * "Debug Asterisk Server Updated",
   * "The debug Asterisk server has been updated from the database"); } } catch (Exception
   * e) { // TODO: handle exception } finally { if (session != null) { session.close();
   * session = null; } } }
   * 
   * if (debugServer == null && debugID == 0 && connectionSuccessful) { AsteriskServer
   * newserver = createDebugAsteriskFromStore(); if (newserver != null) { Session session
   * = null; SafiServer ss = null; try { session =
   * DBManager.getInstance().createSession(); session.beginTransaction();
   * connectionSuccessful = true; List results =
   * session.createCriteria(SafiServer.class).list(); if (results.isEmpty()) {
   * getLog().log(new Status(Status.ERROR, PLUGIN_ID, "SafiServer has no server entry!"));
   * } else { ss = (SafiServer) results.get(0); ss.getAsteriskServers().add(newserver);
   * session.saveOrUpdate(ss); session.getTransaction().commit();
   * getPreferenceStore().setValue(PreferenceConstants.PREF_AST_ID_DEBUG,
   * newserver.getId()); } } catch (Exception e) { e.printStackTrace(); getLog().log(new
   * Status(Status.ERROR, PLUGIN_ID, "Couldn't add debug server to DB!", e)); } finally {
   * if (session != null) { session.close(); session = null; } } } } // } }
   */
  public User getCurrentUser() {
    return currentUser;
  }

  private boolean hasProductionServerInfo() {
    IPreferenceStore store = SafiServerPlugin.getDefault().getPreferenceStore();
    if (store == null)
      return false;
    String hostname = store.getString(PreferenceConstants.PREF_SAFISERVER_HOSTNAME_PROD);
    String user = store.getString(PreferenceConstants.PREF_SAFISERVER_USER_PROD);
    return StringUtils.isNotBlank(hostname) && StringUtils.isNotBlank(user);

  }

  public synchronized SafiServer getSafiServer(boolean refresh) throws Exception {
    if (this.currentServer != null) {
      return this.currentServer;
    } else if (refresh) {
      currentServer = this.refreshProdSafiServer();
      // if (aServer == null) {
      // this.currentServer = ConfigFactory.eINSTANCE.createSafiServer();
      // } else {
      // this.currentServer = aServer;
      // }
      return this.currentServer;
    }
    return null;
  }

  // public void setSafiServer(SafiServer s) {
  // this.currentServer = s;
  // // this.storeSafiServer(this.currentServer);
  // }

  // public boolean isCurrentUserAdmin() {
  // if (this.currentUser != null) {
  // for (Role role : this.currentUser.getRoles()) {
  // if ("Admin".equals(role.getName())) {
  // return true;
  // }
  // }
  // }
  //
  // return false;
  // }

  public List getAvailableRoles() {
    // if(!isCurrentUserAdmin()){
    // return null;
    // }

    Session session = null;
    List roles = null;
    try {
      session = DBManager.getInstance().createSession();
      Criteria criteria = session.createCriteria(Role.class);
      roles = (List) criteria.list();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (session != null) {
        session.close();
        session = null;
      }
    }
    return roles;
  }

  public List getAvailableEntitlements() {
    // if(!isCurrentUserAdmin()){
    // return null;
    // }

    Session session = null;
    List entitlements = null;
    try {
      session = DBManager.getInstance().createSession();
      Criteria criteria = session.createCriteria(Entitlement.class);
      entitlements = (List) criteria.list();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (session != null) {
        session.close();
        session = null;
      }
    }
    return entitlements;
  }

  public void remove(List<Entitlement> available, List<Entitlement> assign) {
    ArrayList list = new ArrayList();
    for (Entitlement ent : assign) {
      for (Entitlement aEnt : available) {
        if (ent.getName().trim().equalsIgnoreCase(aEnt.getName().trim())) {
          list.add(aEnt);
        }
      }

    }
    available.removeAll(list);
  }

  //
  // public SafiServer getLocalServer() {
  // return localServer;
  // }
  //
  // public AsteriskServer getDebugAsteriskServer() {
  // return debugAsteriskServer;
  // }

  public void setServerTracelogLevel(String level) {
    try {
      if (PreferenceConstants.PREF_LOG_LEVEL_OFF.equals(level)) {
        hideServerConsole();
      } else
        initServerConsole();
      SafiServerRemoteManager.getInstance().setServerTracelogLevel(level);
    } catch (SafiServerManagementException e) {
      e.printStackTrace();
      getLog().log(
          new Status(Status.ERROR, PLUGIN_ID, "Couldn't set production SafiServer tracelog level",
              e));
    }
  }

  public void setServerInfoUpdatePeriod(int seconds) {
    try {
      SafiServerRemoteManager.getInstance().setServerInfoUpdatePeriod(seconds);
    } catch (SafiServerManagementException e) {
      e.printStackTrace();
      getLog().log(
          new Status(Status.ERROR, PLUGIN_ID,
              "Couldn't set production SafiServer info update frequency", e));
    }
  }

  public void serverConnected(String message) {
    notifyListenersConnectionChange(true);

  }

  public void serverDisconnected(String message) {
    currentServer = null;
    currentUser = null;
    notifyListenersConnectionChange(false);

  }

  public boolean hasAsteriskServers() {
    try {
      if (!isConnected())
        return false;
      for (AsteriskServer server : getSafiServer(true).getAsteriskServers()) {
        if (server.isActive()
            && (!server.isPrivate() || (server.isPrivate() && server.getCreatedBy() != null && server
                .getCreatedBy().getId() == getCurrentUser().getId())))
          return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }

  public List<AsteriskServer> getAvailableAsteriskServers() {
    List<AsteriskServer> servers = new ArrayList<AsteriskServer>();
    try {
      for (AsteriskServer server : getSafiServer(true).getAsteriskServers()) {
        if (server.isActive()
            && (!server.isPrivate() || (server.isPrivate() && server.getCreatedBy() != null && server
                .getCreatedBy().getId() == getCurrentUser().getId())))
          servers.add(server);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return servers;
  }

  // public NotifyingListImpl<Variable> getGlobalVariables() {
  // return globalVariables;
  // }

  public Variable changeGlobalVariableName(final Variable variable, final String newName)
      throws InvocationTargetException, InterruptedException {

    final Variable[] fv = new Variable[1];
    PlatformUI.getWorkbench().getProgressService().run(true, false, new IRunnableWithProgress() {

      @Override
      public void run(IProgressMonitor monitor) throws InvocationTargetException,
          InterruptedException {
        try {
          fv[0] = GlobalVariableManager.getInstance().changeGlobalVariableName(variable, newName);
        } catch (final Exception e) {
          e.printStackTrace();
          final Display d = Display.getDefault();
          d.asyncExec(new Runnable() {
            @Override
            public void run() {
              MessageDialog.openError(d.getActiveShell(), "Global Var Update Error",
                  "Couldn't update global variable name to " + newName + ": "
                      + e.getLocalizedMessage());
            }
          });
        }
      }
    });

    // Variable newvar = DBManager.getInstance().changeGlobalVariableName(variable,
    // newName);
    // int idx = globalVariables.indexOf(variable);
    // globalVariables.remove(variable);
    // globalVariables.add(idx, newvar);
    return fv[0];
  }

  /**
   * @generated
   */
  public void logError(String error) {
    logError(error, null);
  }

  /**
   * @generated
   */
  public void logError(String error, Throwable throwable) {
    if (error == null && throwable != null) {
      error = throwable.getMessage();
    }
    getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, IStatus.OK, error, throwable));
    debug(error, throwable);
  }

  /**
   * @generated
   */
  public void logInfo(String message) {
    logInfo(message, null);
  }

  /**
   * @generated
   */
  public void logInfo(String message, Throwable throwable) {
    if (message == null && throwable != null) {
      message = throwable.getMessage();
    }
    getLog().log(new Status(IStatus.INFO, PLUGIN_ID, IStatus.OK, message, throwable));
    debug(message, throwable);
  }

  public void logWarn(String message) {
    logWarn(message, null);
  }

  public void logWarn(String message, Throwable throwable) {
    if (message == null && throwable != null) {
      message = throwable.getMessage();
    }
    getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, IStatus.OK, message, throwable));
    debug(message, throwable);
  }

  /**
   * @generated
   */
  private void debug(String message, Throwable throwable) {
    if (!isDebugging()) {
      return;
    }
    if (message != null) {
      System.err.println(message);
    }
    if (throwable != null) {
      throwable.printStackTrace();
    }
  }

  public void serverInfoUpdated(SysInfo info) {
    for (SafiServerStatusListener l : authListeners)
      l.serverInfoUpdate(info);

    GlobalVariableManager.getInstance().updateVars(info.getGlobalVars());
  }

  public List<Variable> getGlobalVariables() {
    return GlobalVariableManager.getInstance().getGlobalVariables();
  }

  public Object getGlobalVariablesNotifier() {
    return GlobalVariableManager.getInstance().getNotifier();
  }

  public void addDebugEventListener(DebugEventListener listener) {
    SafiServerRemoteManager.getInstance().addDebugEventListener(listener);
  }

  public void removeDebugEventListener(DebugEventListener debugEventListener) {
    SafiServerRemoteManager.getInstance().removeEventListener(debugEventListener);

  }

  public class MyUserInfo2 implements UserInfo {
    private String pass;

    public MyUserInfo2(String pass) {
      this.pass = pass;
    }

    public String getPassword() {
      return pass;
    }

    public void setPassword(String pass) {
    }

    public boolean promptYesNo(final String str) {
      System.err.println("PRompt yesnow? " + str);
      final Display d = Display.getDefault();
      final boolean[] result = new boolean[] { false };
      d.syncExec(new Runnable() {
        @Override
        public void run() {
          Shell shell = d.getActiveShell();
          result[0] = MessageDialog.openQuestion(shell, "Key Not Recognized", str);

        }
      });

      return result[0];
    }

    public String getPassphrase() {
      return null;
    }

    public boolean promptPassphrase(String message) {
      System.err.println("gimme passfrase " + message);
      return true;
    }

    public boolean promptPassword(String message) {
      System.err.println("gimme message " + message);
      return true;
    }

    public void showMessage(final String message) {
      final Display d = Display.getDefault();
      d.syncExec(new Runnable() {
        @Override
        public void run() {
          Shell shell = d.getActiveShell();
          MessageDialog.openInformation(shell, "SSH INFO", message);

        }
      });
      System.err.println("shotfuckingmessg " + message);
    }

    // public String[] promptKeyboardInteractive(String destination, String name, String
    // instruction,
    // String[] prompt, boolean[] echo) {
    // return null;
    // }
  }

  public int getCurrentSSHMgmtNum() {
    return currentSSHMgmtNum;
  }

  public boolean isLocalSafiServer() {
    return localSafiServer;
  }
}
