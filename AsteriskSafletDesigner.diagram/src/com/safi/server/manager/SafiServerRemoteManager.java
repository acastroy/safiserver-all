package com.safi.server.manager;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;
import java.security.Permission;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.Notification;
import javax.management.NotificationFilter;
import javax.management.NotificationListener;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectionNotification;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import javax.management.remote.rmi.RMIConnectorServer;

import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.MessageConsole;
import org.tanukisoftware.wrapper.jmx.WrapperManagerMBean;

import sun.rmi.transport.proxy.RMIMasterSocketFactory;

import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.TelephonySubsystem;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.preferences.PreferenceConstants;
import com.safi.server.saflet.importing.OverwriteMode;
import com.safi.server.saflet.mbean.DebugRemoteControl;
import com.safi.server.saflet.mbean.ENotificationWrapper;
import com.safi.server.saflet.mbean.FileTransfer;
import com.safi.server.saflet.mbean.SafiServerMonitor;
import com.safi.server.saflet.mbean.SysInfo;

public class SafiServerRemoteManager implements NotificationListener {
  private MBeanServerConnection serverConnection;
  private static final SafiServerRemoteManager instance = new SafiServerRemoteManager();
  private JMXConnector jmxc;
  private org.tanukisoftware.wrapper.jmx.WrapperManagerMBean wrapperProxy;
  private SafiServerMonitor serverMonitor;
  private FileTransfer fileTransfer;
  private boolean listenerRegistered;
  private Object serverMonitorHandback = new Handback();
//  private ServerInfoNotificationFilter serverInfoNotificationFilter;
  private ObjectName serverMonitorName;
  private ObjectName wrapperMBeanName;
  private ObjectName fileTransferMBeanName;
//  private ObjectName licenseMBeanName;
  private boolean observerInfo = true;
  private boolean observeError = true;
  private volatile boolean isClosing;

  private List<DebugEventListener> debugEventListeners;
	private int currentActualRMIPort;
	private HashMap<String, Object> jmxEnvProperties;

  public static SafiServerRemoteManager getInstance() {
    return instance;
  }

  private SafiServerRemoteManager() {
  	initSockeFactory();
//    serverInfoNotificationFilter = new ServerInfoNotificationFilter();

    // Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
    // System.setProperty("java.security.policy", "safiserver.policy");
    // if (System.getSecurityManager() == null)
    // System.setSecurityManager(new MySecurityManager());
  }

  private void initSockeFactory(){
  	jmxEnvProperties = new HashMap<String, Object>();
  	RMISocketFactory csf = new RMIMasterSocketFactory(){
    	@Override
    	public Socket createSocket(String host, int port) throws IOException {
    	  // TODO Auto-generated method stub
//    		System.err.println("Asked for "+port+" but actually connecting too "+host+":"+currentActualRMIPort);
//    		return super.createSocket(host, port);
    	  return super.createSocket(host, currentActualRMIPort);
    	}
    	
    	@Override
    	public ServerSocket createServerSocket(int port) throws IOException {
//    		System.err.println("Asked for "+port+" but actually serving up too "+currentActualRMIPort);
    	  return super.createServerSocket(currentActualRMIPort);
    	}
    	
    	
    };
//    SslRMIServerSocketFactory ssf = new SslRMIServerSocketFactory(){
//    	@Override
//    	public ServerSocket createServerSocket(int port) throws IOException {
//    	  // TODO Auto-generated method stub
//    		return super.createServerSocket(port);
////    	  return super.createServerSocket(actualRMIPort);
//    	}
//    };
    
    jmxEnvProperties.put(RMIConnectorServer.RMI_CLIENT_SOCKET_FACTORY_ATTRIBUTE, csf);
    jmxEnvProperties.put(RMIConnectorServer.RMI_SERVER_SOCKET_FACTORY_ATTRIBUTE, csf);
    try {
	    RMISocketFactory.setSocketFactory(csf);
    } catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
    }
    // Needed to avoid "non-JRMP server at remote endpoint" error
    jmxEnvProperties.put("com.sun.jndi.rmi.factory.socket", csf);
  }
  @Override
  public void handleNotification(final Notification notification, Object handback) {
    if (handback == serverMonitorHandback) {
      if (observeError
          && "error".equalsIgnoreCase(((AttributeChangeNotification) notification)
              .getAttributeType())) {
        final Display d = PlatformUI.getWorkbench().getDisplay();
        d.asyncExec(new Runnable() {
          @Override
          public void run() {
            // Shell sh = new Shell();
            BooleanMessageDialogWithToggle.openInformation(d.getActiveShell(),
                ((AttributeChangeNotification) notification).getAttributeName(), notification
                    .getMessage(), "Notify me of server info messages in the future", true,
                SafiServerPlugin.getDefault().getPreferenceStore(),
                PreferenceConstants.PREF_SERVER_ERROR_NOTIFICATION);
          }
        });
      } else if (observerInfo
          && "info".equalsIgnoreCase(((AttributeChangeNotification) notification)
              .getAttributeType())) {
        final Display d = PlatformUI.getWorkbench().getDisplay();
        d.asyncExec(new Runnable() {
          @Override
          public void run() {
            // Shell sh = new Shell();
            BooleanMessageDialogWithToggle.openInformation(d.getActiveShell(),
                ((AttributeChangeNotification) notification).getAttributeName(), notification
                    .getMessage(), "Notify me of server error messages in the future", true,
                SafiServerPlugin.getDefault().getPreferenceStore(),
                PreferenceConstants.PREF_SERVER_INFO_NOTIFICATION);
          }
        });
      } else if (SafiServerMonitor.LOG_EVENT_TYPE
          .equals(((AttributeChangeNotification) notification).getAttributeType())) {
        MessageConsole console = SafiServerPlugin.getDefault().getServerConsole();
        if (console != null) {
          try {
            // LoggingEvent evt = (LoggingEvent) ((AttributeChangeNotification)
            // notification)
            // .getNewValue();
            // console.newMessageStream().write(evt.getRenderedMessage() + "\n");
            String msg = (String) ((AttributeChangeNotification) notification).getNewValue();
            console.newMessageStream().write(msg + "\n");
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      } else if (SafiServerMonitor.SYSINFO_EVENT_TYPE
          .equalsIgnoreCase(((AttributeChangeNotification) notification).getAttributeType())) {
        SysInfo info = (SysInfo) ((AttributeChangeNotification) notification).getNewValue();
        SafiServerPlugin.getDefault().serverInfoUpdated(info);
      } else if (SafiServerMonitor.DEBUG_EVENT_TYPE
          .equals(((AttributeChangeNotification) notification).getAttributeType())) {
        AttributeChangeNotification acn = (AttributeChangeNotification) notification;
        Object obj = acn.getNewValue();
        if (obj instanceof ENotificationWrapper) {
          if (debugEventListeners != null)
            for (DebugEventListener l : debugEventListeners) {
              l.debugEvent((ENotificationWrapper) obj);
            }
          // ENotificationWrapper wrapper = (ENotificationWrapper)obj;
          // EObjectReference notObj = (EObjectReference)wrapper.getNotifiderID();
          // String uid = notObj.getUID();

        }
      }
    } else if (notification instanceof JMXConnectionNotification) {
      final JMXConnectionNotification n = (JMXConnectionNotification) notification;
      if (JMXConnectionNotification.OPENED.equals(n.getType())) {
        listenerRegistered = true;
        SafiServerPlugin.getDefault().serverConnected(n.getMessage());
      } else if (JMXConnectionNotification.CLOSED.equals(n.getType())
          || JMXConnectionNotification.FAILED.equals(n.getType()) && !isClosing) {
        reset();
        SafiServerPlugin.getDefault().serverDisconnected(n.getMessage());
        final Display d = PlatformUI.getWorkbench().getDisplay();
        d.asyncExec(new Runnable() {
          @Override
          public void run() {
            // Shell sh = new Shell();
            boolean b = MessageDialog.openQuestion(d.getActiveShell(),
                "Management Connection Lost",
                "Management connection to production SafiServer was lost: " + n.getMessage()
                    + ". Would you like to try to reconnect?");
            if (b)
              try {
                // connect();
                // SafiServerPlugin.getDefault().updateTraceLogLevel();
                new ReconnectDialog(d.getActiveShell()).open();
              } catch (Exception e) {
                e.printStackTrace();
                MessageDialog.openError(d.getActiveShell(), "Management Connection Error",
                    "Couldn't connnect to production SafiServer management channel: "
                        + e.getLocalizedMessage());
              }
          }
        });
      }
    }
  }

  public boolean isConnected() {
    return this.isConnected(false);
  }
  
  public boolean isConnected(boolean ping) {
  	if (!listenerRegistered)
  		return false;
  	
  	if (!ping)
    return true;
  	try {
  		serverMonitor.getTracelogLevel();
    } catch (Exception e) {
	    return false;
    }
    return true;
  	
  }

  public void connect() throws SafiServerManagementException {
    ClassLoader oldCl = Thread.currentThread().getContextClassLoader();
    reset();
    try {
      Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());

      final SafiServer server = SafiServerPlugin.getDefault().getSafiServer(true);
      if (serverConnection == null && server != null) {
        // RMISocketFactory.setSocketFactory(new
        // FixedPortRMISocketFactory(server.getManagementPort()));
        String rmiHost, serviceHost = server.getBindIP();
        int rmiPort, servicePort = server.getManagementPort();
        if (!SafiServerPlugin.getDefault().isLocalSafiServer()) {
          rmiHost = "127.0.0.1";
          
//          servicePort = getPreferenceStore().getInt(
//              PreferenceConstants.PREF_SSH_FORWARDING_MANAGEMENT_PORT_LOCAL);
//          rmiPort = servicePort;
          try {
          SafiServerPlugin.getDefault().refreshMgmtTunnelIfNecessary();
          } catch (Exception e) {
            e.printStackTrace();
            SafiServerPlugin.getDefault().logError("Couldn't establish management tunnel to " + serviceHost, e);
            final Display d = Display.getDefault();
            d.asyncExec(new Runnable(){
              @Override
              public void run() {
                if (d.getActiveShell() != null)
                  MessageDialog.openError(d.getActiveShell(), "Management Connection Failure",
                      "Management tunnel to " + server.getBindIP()
                          + " could not be established. Please ensure that port " + server.getManagementPort()
                          + " is available on this machine. Note that if you're running an instance of SafiServer locally and " +
                          		"you're attempting to connect to a remote SafiServer, you will " +
                          		"need to either stop it or choose different ports for database and management functions of the remote SafiServer.");
                
              }
            });
            throw new SafiServerManagementException("Couldn't connect", e);
          }
          rmiPort = SafiServerPlugin.getDefault().getCurrentSSHMgmtNum();
          serviceHost = rmiHost;
          // rmiHost = serviceHost;
          // rmiPort = servicePort;
//          if (!SafiServerPlugin.getDefault().isLocalPortForwarded(rmiPort)){
//            SafiServerPlugin.getDefault().addTunnel(rmiPort, servicePort, rmiHost);
//          }
        } else {
          rmiHost = serviceHost;
          rmiPort = servicePort;

        }
//        String urlString = "service:jmx:rmi://" + rmiHost + ":" + rmiPort + "/jndi/rmi://"
//            + serviceHost + ":" + servicePort + "/safiserver";
        
        String urlString = "service:jmx:rmi://127.0.0.1:" + servicePort + "/jndi/rmi://127.0.0.1:" + servicePort + "/safiserver";
        SafiServerPlugin.getDefault().getLog().log(
            new Status(Status.INFO, SafiServerPlugin.PLUGIN_ID,
                "SafiServerRemoteManager connecting to " + urlString));
        JMXServiceURL url = new JMXServiceURL(urlString);
        
        currentActualRMIPort = rmiPort;
        
//        env = null;
        jmxc = JMXConnectorFactory.connect(url, jmxEnvProperties);
        // Create listener
        //
        // Get an MBeanServerConnection
        //
        serverConnection = jmxc.getMBeanServerConnection();
        String domains[] = serverConnection.getDomains();
        String domain = serverConnection.getDefaultDomain();

        serverMonitorName = new ObjectName("bean:name=serverMonitor");
        serverMonitor = (SafiServerMonitor) MBeanServerInvocationHandler.newProxyInstance(
            serverConnection, serverMonitorName, SafiServerMonitor.class, true);
        // if (fileTransferMBeanName==null)
        fileTransferMBeanName = new ObjectName("bean:name=actionpakFileTransfer");
        fileTransfer = (FileTransfer) MBeanServerInvocationHandler.newProxyInstance(
            serverConnection, fileTransferMBeanName, FileTransfer.class, true);
//        this.licenseMBeanName = new ObjectName("bean:name=licenseManager");
       
        // serverInfoNotificationFilter.refreshSettings();
        // if (wrapperMBeanName == null)
        wrapperMBeanName = new ObjectName("bean:name=WrapperManager");
        wrapperProxy = (org.tanukisoftware.wrapper.jmx.WrapperManagerMBean) MBeanServerInvocationHandler
            .newProxyInstance(serverConnection, wrapperMBeanName, WrapperManagerMBean.class, true);
        notificationPreferencesChanged();
        serverConnection.addNotificationListener(serverMonitorName, this, null,
            serverMonitorHandback);
        jmxc.addConnectionNotificationListener(this, null, null);
        this.listenerRegistered = true;
        SafiServerPlugin.getDefault().notifyListenersConnectionChange(true);
      }

    } catch (Exception e) {
      if (e instanceof SafiServerManagementException)
        throw (SafiServerManagementException)e;
      e.printStackTrace();
      SafiServerPlugin.getDefault().getLog().log(
          new Status(Status.ERROR, SafiServerPlugin.PLUGIN_ID, "Couldn't connect to remote server",
              e));
      throw new SafiServerManagementException(e);
    } finally {
      Thread.currentThread().setContextClassLoader(oldCl);
    }
  }

  private IPreferenceStore getPreferenceStore() {
    // TODO Auto-generated method stub
    return SafiServerPlugin.getDefault().getPreferenceStore();
  }

  public void reset() {
    if (serverConnection != null && jmxc != null) {
      try {
        isClosing = true;
        if (listenerRegistered) {
          try {
            jmxc.removeConnectionNotificationListener(this);
            serverConnection.removeNotificationListener(serverMonitorName, this);
          } catch (Exception e) {
            e.printStackTrace();
          }
          // serverConnection.removeNotificationListener(wrapperMBeanName, this);
        }
        // serverConnection.unregisterMBean(serverMonitorName);
        // serverConnection.unregisterMBean(wrapperMBeanName);
        // serverConnection.unregisterMBean(fileTransferMBeanName);
        jmxc.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
      wrapperProxy = null;
      serverMonitor = null;
      listenerRegistered = false;
      serverConnection = null;
      fileTransfer = null;
      serverMonitor = null;
      wrapperProxy = null;
      jmxc = null;
      isClosing = false;
    }
  }

  public synchronized boolean restartConnection() throws SafiServerManagementException {
    if (isClosing)
      return false;
    reset();
    connect();
    return isConnected();
  }

  public boolean restartServerService() throws SafiServerManagementException {
    if (wrapperProxy == null)
      connect();
    if (wrapperProxy != null) {
      wrapperProxy.restart();
      return true;
    }
    return false;
  }

  public boolean stopServerService(int exitCode) throws SafiServerManagementException {
    if (wrapperProxy == null)
      connect();
    if (wrapperProxy != null) {
      try {
        wrapperProxy.stop(exitCode);
      } catch (Exception e) {
        throw new SafiServerManagementException(e);
      }
      return true;
    }
    return false;
  }

  public String[] getServerIPs() throws SafiServerManagementException {
    if (serverMonitor == null)
      return null;
    try {
      return serverMonitor.getLocalIPAddresses();
    } catch (Exception e) {
      e.printStackTrace();
      throw new SafiServerManagementException(e);
    }
  }

  public boolean needsUpdate(String version, String symbolicName) {
    if (fileTransfer != null)
      return fileTransfer.needsUpdateBundle(version, symbolicName);
    throw new IllegalStateException("No manager connection to SafiServer found");
  }

  public synchronized boolean promptNeedsUpdate(String projectID, String filename, Date timestamp) {
    if (fileTransfer != null)
      return fileTransfer.needsUpdateAudioFile(projectID, filename, timestamp);
    throw new IllegalStateException("No manager connection to SafiServer found");
  }

  public synchronized void transfer(String filename, String symbolicName, byte[] data) throws Exception {
    if (fileTransfer != null) {
    	fileTransfer.deployOrUpdateBundle(filename, symbolicName, data);
//      fileTransfer.transferJar(filename, data);
      return;
    }
    throw new IllegalStateException("No manager connection to SafiServer found");
  }

  public synchronized void transferPrompt(String projectID, String filename, byte[] data)
      throws Exception {
    if (fileTransfer != null) {
      fileTransfer.transferAudioFile(projectID, filename, data);
      return;
    }
    throw new IllegalStateException("No manager connection to SafiServer found");
  }

  public void renamePromptFile(int id, String projectName, String name, String extension)
      throws Exception {
    if (fileTransfer != null) {
      fileTransfer.renamePromptFile(id, projectName, name, extension);
      return;
    }
    throw new IllegalStateException("No manager connection to SafiServer found");
  }

  public synchronized void transferWorkspaceArchive(String filename, byte[] data, OverwriteMode mode)
      throws Exception {
    if (fileTransfer != null) {
      fileTransfer.transferWorkspaceArchive(filename, data, mode);
      return;
    }
    throw new IllegalStateException("No manager connection to SafiServer found");
  }

  public void setServerTracelogLevel(String level) throws SafiServerManagementException {
    if (serverMonitor == null)
      return;
    try {
      serverMonitor.setTracelogLevel(level);
    } catch (Exception e) {
      e.printStackTrace();
      throw new SafiServerManagementException(e);
    }
  }

  public String getServerTracelogLevel() throws SafiServerManagementException {
    if (serverMonitor == null)
      return null;
    try {
      return serverMonitor.getTracelogLevel();
    } catch (Exception e) {
      e.printStackTrace();
      throw new SafiServerManagementException(e);
    }
  }

  public void setServerInfoUpdatePeriod(int seconds) throws SafiServerManagementException {
    if (serverMonitor == null)
      return;
    try {
      serverMonitor.setServerInfoUpdateFrequency(seconds);
    } catch (Exception e) {
      e.printStackTrace();
      throw new SafiServerManagementException(e);
    }
  }

  public void requestServerInfoUpdate() throws SafiServerManagementException {
    if (serverMonitor == null)
      return;
    try {
      serverMonitor.requestServerInfoUpdate();
    } catch (Exception e) {
      e.printStackTrace();
      throw new SafiServerManagementException(e);
    }
  }

  public int getServerInfoUpdatePeriod() throws SafiServerManagementException {
    if (serverMonitor == null)
      return 0;
    try {
      return serverMonitor.getServerInfoUpdateFrequency();
    } catch (Exception e) {
      e.printStackTrace();
      throw new SafiServerManagementException(e);
    }
  }

  public void synchAudioFiles(TelephonySubsystem server ) throws Exception {
    if (serverMonitor == null)
      throw new IllegalStateException("No manager connection to SafiServer found");
    serverMonitor.synchAudioFiles(server.getId(), server.getPlatformId());
//    serverMonitor.synchAsteriskAudioFiles(server.getId());
  }
  
 

  public boolean notificationPreferencesChanged() {
    IPreferenceStore store = SafiServerPlugin.getDefault().getPreferenceStore();
    observeError = store.getBoolean(PreferenceConstants.PREF_SERVER_ERROR_NOTIFICATION);
    observerInfo = store.getBoolean(PreferenceConstants.PREF_SERVER_INFO_NOTIFICATION);
    return true;
  }

  public byte[] getPromptFile(int id) throws Exception {
    if (serverMonitor == null)
      throw new IllegalStateException("No manager connection to SafiServer found");
    return serverMonitor.getPromptFile(id);
  }

  public byte[] getServerLogFile() throws Exception {
    if (serverMonitor == null)
      throw new IllegalStateException("No manager connection to SafiServer found");
    return serverMonitor.getServerLogFile();
  }
  
  
  class ServerInfoNotificationFilter implements NotificationFilter {
    /**
     * 
     */
    private static final long serialVersionUID = 5121352357424157830L;
    private boolean observerInfo = true;
    private boolean observeError = true;

    public ServerInfoNotificationFilter() {
    }

    @Override
    public boolean isNotificationEnabled(Notification notification) {
      if (notification instanceof AttributeChangeNotification) {
        AttributeChangeNotification n = (AttributeChangeNotification) notification;
        if (observeError && "error".equalsIgnoreCase(n.getAttributeType()))
          return true;
        if (observerInfo && "info".equalsIgnoreCase(n.getAttributeType()))
          return true;
        System.err.println("ignoring log info " + n.getAttributeType() + " " + n.getMessage());
      }
      return false;
    }

    public void refreshSettings() {
      notificationPreferencesChanged();
    }
  }

  class Handback implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -1259329384907443291L;
  }

  public class MySecurityManager extends SecurityManager {
    public MySecurityManager() {
    }

    public void checkPermission() {
    }

    public void checkPermission(Permission perm) {
    }

    public void checkPermission(Permission perm, Object context) {
    }
  }


//  public boolean serverJarNeedsUpdate(String name) {
//    if (fileTransfer != null)
//      return fileTransfer.needsUpdateServerJar(name);
//    throw new IllegalStateException("No manager connection to SafiServer found");
//  }
//
//  public void transferServerJar(String filename, byte[] data) throws Exception {
//    if (fileTransfer != null) {
//      fileTransfer.transferServerJar(filename, data);
//      return;
//    }
//    throw new IllegalStateException("No manager connection to SafiServer found");
//
//  }

  public DebugRemoteControl startRemoteDebugSession(String projectName, String safletName)
      throws Exception {
    if (serverMonitor == null)
      throw new IllegalStateException("No manager connection to SafiServer found");

    final int key = serverMonitor.debugSaflet(projectName, safletName);
    return new DebugRemoteControl() {

      @Override
      public void next() throws Exception {
        if (serverMonitor != null)
          serverMonitor.stepDebug(key);
      }

      @Override
      public void resume() throws Exception {
        if (serverMonitor != null)
          serverMonitor.resumeDebug(key);

      }

      @Override
      public void stop() throws Exception {
        if (serverMonitor != null)
          serverMonitor.stopDebug(key);

      }

      @Override
      public void setBreakPoint(String uid, boolean b) throws Exception {
        serverMonitor.setBreakPoint(key, uid, b);
      }
    };
  }


  public void addDebugEventListener(DebugEventListener listener) {
    if (debugEventListeners == null)
      debugEventListeners = new ArrayList<DebugEventListener>();
    debugEventListeners.add(listener);

  }

  public void removeEventListener(DebugEventListener debugEventListener) {
    if (debugEventListeners == null)
      return;
    debugEventListeners.remove(debugEventListener);

  }
  
  public int getDBProxyServicePort() throws SafiServerManagementException {
  	if (serverMonitor == null)
      throw new IllegalStateException("No manager connection to SafiServer found");
    try {
	    return serverMonitor.getDBProxyServicePort();
    } catch (Exception e) {
      e.printStackTrace();
      throw new SafiServerManagementException(e);
    }
    
  }

}
