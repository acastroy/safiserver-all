package com.safi.asterisk.handler.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.fastagi.AgiScript;
import org.asteriskjava.fastagi.AgiServerThread;
import org.asteriskjava.fastagi.BaseAgiScript;
import org.asteriskjava.fastagi.MappingStrategy;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.ManagerEventListener;
import org.asteriskjava.manager.SafiManagerConnection;
import org.asteriskjava.manager.SafiManagerConnectionFactory;
import org.asteriskjava.manager.action.PingAction;
import org.asteriskjava.manager.event.HangupEvent;
import org.asteriskjava.manager.event.ManagerEvent;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.springframework.jmx.export.notification.UnableToSendNotificationException;
import org.tanukisoftware.wrapper.WrapperManager;

import com.safi.asterisk.handler.SafiFastAgiServerFactory;
import com.safi.asterisk.handler.SafletEngine;
import com.safi.asterisk.handler.SafletEngineException;
import com.safi.asterisk.handler.dispatch.SafletDispatch;
import com.safi.asterisk.handler.mbean.SafiServerMonitorImpl;
import com.safi.asterisk.initiator.AsteriskInitiatorInfo;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;
import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.SafiDriverManager;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.db.manager.PooledDataSourceManager;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.SafiServer;
import com.safi.server.SafiAgiServerThread;
import com.safi.server.SafiFastAgiServer;
import com.safi.server.SafiServerListener;

public abstract class AbstractConnectionManager implements AsteriskConnectionManager {

  protected final static Logger log = Logger.getLogger(AbstractConnectionManager.class);
  // protected final static Logger debugLog = HandlerEngine.debuggerLog;
  protected static final long LOOPBACK_TIMEOUT = 120000;
  protected static final long DEBUG_LOOPBACK_TIMEOUT = 120000; // 2 min for debugging

  public final static String PATTERN_IP = "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";
  // public static final String SHARED_JS_FILE = "shared.js";

  protected SafiFastAgiServer agiServer;
  protected Map<String, Object> loopbackCallLock;
  protected Map<String, KeepAlive> channelKeepaliveMap;
  protected SafiManagerEventListener listener;
  protected SafletDispatch dispatcher;
  protected Executor keepAliveExecutor;

  protected Set<SafiServerListener> listeners = new HashSet<SafiServerListener>();
  protected Map<Integer, SafiManagerConnection> managerConnectionMap = new Hashtable<Integer, SafiManagerConnection>();
  protected SafiServer safiServerConfig;
  protected boolean blocking = true;
  protected boolean testing;
  private AgiServerThread agiServerThread;
  private SafiFastAgiServerFactory fastAgiServerFactory;

  private SafiFastAgiServerFactory factory;
  private String currentHostname;
  private int currentFastAgiPort;
  private int currentManagementPort;
  private Timer managerConnectionPoller;
  private volatile boolean stopping;
  private SafiServer oldSafiServerConfig;
  private int currentDBPort;
  private int numAgiRequests;
  private int numCustomInitiations;

  public AbstractConnectionManager() {

    loopbackCallLock = new Hashtable<String, Object>();
    channelKeepaliveMap = new Hashtable<String, KeepAlive>();
    listener = new SafiManagerEventListener();
    keepAliveExecutor = Executors.newCachedThreadPool();
    numAgiRequests = numCustomInitiations = 0;
  }

  @Override
  public void handle(AgiRequest request, AgiChannel channel) {
    numAgiRequests++;

  }

  @Override
  public void handle(String saflet, String astIp, Properties properties,
      ExceptionHandler exceptionHandler) {
    numCustomInitiations++;
    if (log.isDebugEnabled())
      log.debug("Invoking custom initiator for saflet " + saflet + " for asterisk " + astIp);

  }

  /*
   * (non-Javadoc)
   * 
   * @seecom.safi.asterisk.handler.AsteriskConnectionManager#addListener(com.safi.server.
   * SafiServerListener)
   */
  public boolean addListener(SafiServerListener listener) {
    return listeners.add(listener);
  }

  @Override
  public void notifyServerStarted() {
    // TODO Auto-generated method stub
    if (listeners != null)
      for (SafiServerListener l : listeners) {
        l.serverStarted();
      }
  }

  @Override
  public void notifyServerStopped(String msg) {
    // TODO Auto-generated method stub
    if (listeners != null)
      for (SafiServerListener l : listeners) {
        l.serverStopped(msg);
      }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.asterisk.handler.AsteriskConnectionManager#removeListener(com.safi.server
   * .SafiServerListener)
   */
  public boolean removeListener(SafiServerListener listener) {
    return listeners.remove(listener);
  }

  public void setBindIP(String ip) {
    this.currentHostname = ip;
  }

  public void setManagementPort(int port) {
    this.currentManagementPort = port;
  }

  public AsteriskServer getAsteriskServerById(Integer id, boolean fresh) {
    // safiServerChanged();
    if (safiServerConfig == null)
      return null;
    synchronized (safiServerConfig) {
      AsteriskServer old = null;
      for (AsteriskServer s : safiServerConfig.getAsteriskServers()) {
        if (id == s.getId()) {
          old = s;
          if (!fresh)
            return s;
        }
      }
      try {
        AsteriskServer newserver = DBManager.getInstance().getAsteriskServerConfig(id);
        if (old != null) {
          EcoreUtil.replace(old, newserver);
        }
        return newserver;
      } catch (DBManagerException e) {
        log.error("Couldn't find Asterisk Server " + id + " in DB", e);
      }
    }
    return null;
  }

  public AsteriskServer getAsteriskServerByIP(String ip) {
    // safiServerChanged();
    if (StringUtils.isBlank(ip))
      return null;
    if (safiServerConfig == null)
      return null;
    synchronized (safiServerConfig) {
      for (AsteriskServer s : safiServerConfig.getAsteriskServers()) {
        if (ip.equals(s.getHostname()))
          return s;
      }
      try {
        return DBManager.getInstance().getAsteriskServerConfigByIp(ip);
      } catch (DBManagerException e) {
        log.error("Couldn't find Asterisk Server with IP " + ip + " in DB", e);
      }
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.asterisk.handler.AsteriskConnectionManager#getServerIpAddress()
   */
  public String getServerIpAddress() {
    if (safiServerConfig != null) {
      return safiServerConfig.getBindIP();
    }
    // if (agiServer != null && ((SafiFastAgiServer) agiServer).isRunning())
    // return ((SafiFastAgiServer) agiServer).getBoundIpAddress();
    return null;
  }

  public void beginProcessing() throws SafletEngineException {
    try {
      if (managerConnectionPoller == null) {
        createAgiServer();
        managerConnectionPoller = new Timer(true);
        setupManagerDaemon();
      }
      // if (debugLog.isDebugEnabled()) {
      // debugLog.debug("Safi Server starting...");
      // }
      // createManagerConnection();
      // createAgiServer();
    } catch (Exception e) {
      if (e instanceof SafletEngineException)
        throw (SafletEngineException) e;

      throw new SafletEngineException(e);
    }
  }

  private void shutdownAGIServer() {
    if (agiServerThread != null) {
      try {
        agiServerThread.shutdown();
        // agiServer.shutdown();
        log.info("FastAGI server was stopped");
      } catch (Exception e) {
        log.error("error caught during shutdown", e);
      }
      agiServerThread = null;
      agiServer = null;
    } else if (agiServer != null)
      agiServer.shutdown();
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.asterisk.handler.AsteriskConnectionManager#stopProcessing()
   */
  public synchronized void stopProcessing() {
    stopping = true;
    try {
      shutdownAGIServer();
      for (SafiManagerConnection managerConnection : managerConnectionMap.values()) {
        try {
          managerConnection.removeEventListener(listener);
          managerConnection.logoff();
          log.info("Asterisk Manager connection was closed");
        } catch (Exception e) {
          log.error("error caught during shutdown", e);
        }
      }
      managerConnectionMap.clear();

    } finally {
      stopping = false;
    }
  }

  @Override
  public SafiManagerConnection getManagerConnection(Integer key) {
    return managerConnectionMap.get(key);
  }

  protected void applyParameters(AgiRequest request, Saflet copy) {
    final Map<String, String[]> parameterMap = request.getParameterMap();
    Map<String, Object> pmap = new HashMap<String, Object>();
    for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
      String[] val = entry.getValue();
      if (val == null || val.length == 0)
        pmap.put(entry.getKey(), null);
      else if (val.length == 1)
        pmap.put(entry.getKey(), val[0]);
      else
        pmap.put(entry.getKey(), val);
    }
    applyParametersCustom(pmap, copy);
  }



  protected void applyParametersCustom(Map params, Saflet copy) {
    // List<Variable> variables = copy.getHandlerContext().getVariables();
    SafletContext context = copy.getSafletContext();
    context.setVariableRawValue(SafletConstants.VAR_KEY_PROPS, params);
  }

  protected boolean createManagerConnection(AsteriskServer server) throws Exception {
    synchronized (server) {
      if (testing || !server.isActive())
        return false;
      
      SafiManagerConnectionFactory factory = new SafiManagerConnectionFactory(server.getHostname(),
          server.getManagerPort(), server.getManagerName(), server.getManagerPassword());
      SafiManagerConnection managerConnection = (SafiManagerConnection) factory
          .createManagerConnection();
      for (SafiServerListener listener : listeners)
        managerConnection.addListener(listener);
      managerConnection.addListener(new SafiServerListenerInternal(server.getName(), server
          .getHostname()));
      managerConnection.login();
      managerConnection.addEventListener(listener);
      managerConnectionMap.put(server.getId(), managerConnection);
      return true;
    }
  }

  protected void createAgiServer() throws IOException {
    // agiServer = blocking ? new SafiAgiServer() : new SafiMinaServer();
    if (fastAgiServerFactory == null)
      throw new IllegalStateException("No FastAgi server factory available");
    agiServer = fastAgiServerFactory.createAgiServer();
    agiServer.setPort(currentFastAgiPort);
    // ((SafiFastAgiServer) agiServer).setPoolSize(fastAgiPoolsize);
    // ((SafiFastAgiServer) agiServer).setMaximumPoolSize(fastAgiMaxPoolsize);
    agiServer.setPool(SafletEngine.getInstance().getThreadPool());
    agiServer.setMappingStrategy(new HandlerMappingStrategy());
    // String bindIP = safiServerConfig.getBindIP();
    String bindIP = SafletEngine.getInstance().getBindIP();
    if (bindIP != null) {
      if (Pattern.matches(PATTERN_IP, bindIP))
        agiServer.setBindAddr(bindIP);
      else {
        try {

          agiServer.setBindAddr(InetAddress.getByName(bindIP).getHostAddress());
        } catch (UnknownHostException e) {
          log.warn("Couldn't connect to host " + bindIP + ".  Defaulting...", e);
          agiServer.setBindAddr(InetAddress.getLocalHost().getHostAddress());

        }
      }
    }

    for (SafiServerListener ls : listeners) {
      agiServer.addListener(ls);
    }
    /*
     * if (!HandlerEngine.getInstance().isServerMode()) agiServer.startup(); else
     */{
      agiServerThread = new SafiAgiServerThread(agiServer, new AgiUncaughtExceptionHandler());
      agiServerThread.setDaemon(true);
      agiServerThread.startup();
    }
    // agiServer.startup();
  }

  protected void handleLoopback(AgiRequest request, AgiChannel channel) {
    try {
      String uuid = channel.getVariable("SafiUUID");
      if (uuid == null)
        return;
      Object obj = null;
      KeepAlive al = null;
      synchronized (loopbackCallLock) {
        obj = loopbackCallLock.get(uuid);
        if (obj == null) {
          log.error("No lock found for channel " + channel.getName() + " with uuid " + uuid);
          if (SafletEngine.debuggerLog.isEnabledFor(Level.ERROR))
            SafletEngine.debuggerLog.error("No lock found for channel " + channel.getName()
                + " with uuid " + uuid);
          return;
        }
        al = new KeepAlive(channel);
        // keepAliveExecutor.execute(al);
        KeepAlive al2 = channelKeepaliveMap.put(channel.getUniqueId(), al);
        if (al2 != null)
          al2.stop();
        if (obj != null)
          loopbackCallLock.put(uuid, new Object[] { channel, request });
      }
      if (obj != null) {
        // loopbackCallLock.put(uuid, new Object[] { channel, request });
        synchronized (obj) {
          obj.notifyAll();
        }

        if (al != null)
          al.run();
      }
    } catch (Exception e) {
      log.error("Error caught during handleLoopback", e);
      if (SafletEngine.debuggerLog.isEnabledFor(Level.ERROR))
        SafletEngine.debuggerLog.error("Error caught during handleLoopback", e);
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.asterisk.handler.AsteriskConnectionManager#setLoopbackLock(java.lang.String)
   */
  public Object setLoopbackLock(String uuid, Object lock) {
    if (lock == null)
      lock = new Object();
    synchronized (loopbackCallLock) {
      if (loopbackCallLock.containsKey(uuid)) {
        log.error("Lock already exists uuid " + uuid);
        if (SafletEngine.debuggerLog.isEnabledFor(Level.ERROR))
          SafletEngine.debuggerLog.error("Lock already exists uuid " + uuid);
        return null;
      }
      if (SafletEngine.debuggerLog.isDebugEnabled())
        SafletEngine.debuggerLog.error("Setting lock for uuid " + uuid);
      loopbackCallLock.put(uuid, lock);
    }
    return lock;
  }

  // TODO: strong this up
  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.asterisk.handler.AsteriskConnectionManager#getLoopbackCall(java.lang.String)
   */
  public Object getLoopbackCall(String uuid) {
    Object lock = null;
    synchronized (loopbackCallLock) {
      lock = loopbackCallLock.get(uuid);
      if (lock instanceof Object[]) {
        if (SafletEngine.debuggerLog.isDebugEnabled())
          SafletEngine.debuggerLog.error("Got my loopbacklock info for " + uuid);
        return (Object[]) loopbackCallLock.remove(uuid);
      }
    }
    if (lock == null) {
      if (SafletEngine.debuggerLog.isDebugEnabled())
        SafletEngine.debuggerLog.error("Loopbacklock info for " + uuid + " was null!");
      return null;
    }
    synchronized (lock) {
      try {
        if (SafletEngine.debuggerLog.isDebugEnabled())
          SafletEngine.debuggerLog
              .error("Loopback hasn't arrived for " + uuid + " so i'm waiting!");
        if (lock instanceof Long)
          lock.wait(((Long)lock).longValue());
        else
          lock.wait(LOOPBACK_TIMEOUT);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    if (SafletEngine.debuggerLog.isDebugEnabled())
      SafletEngine.debuggerLog.error("I've woken up for " + uuid + " so returning");
    return loopbackCallLock.remove(uuid);
  }

  @Override
  public void initManagerConnections() throws SafletEngineException {
    if (safiServerConfig == null)
      return;
    synchronized (safiServerConfig) {
      Runnable runna = new Runnable() {
        @Override
        public void run() {

          AsteriskServer[] astServers = new AsteriskServer[safiServerConfig.getAsteriskServers()
              .size()];
          safiServerConfig.getAsteriskServers().toArray(astServers);
          for (int i = 0; i < astServers.length; i++) {
            AsteriskServer astServer = astServers[i];
            if (!astServer.isActive())
              continue;
            if (managerConnectionMap.containsKey(astServer.getId())) {
              log.warn("Asterisk server with id " + astServer.getId() + " already exists");
              postInfoMessage("Warning!", "Asterisk server with id " + astServer.getId()
                  + " already exists");
              continue;
            }
            if (StringUtils.isNotBlank(astServer.getHostname())
                && StringUtils.isNotBlank(astServer.getManagerName()))
              try {
                createManagerConnection(astServer);
              } catch (Exception e) {
                log.error("Couldn't create manager connection for AsteriskServer "
                    + astServer.getName() + " at " + astServer.getHostname(), e);

                postErrorMessage("License Error",
                    "Couldn't create manager connection for AsteriskServer " + astServer.getName()
                        + " at " + astServer.getHostname());
              }
          }
        }
      };

      SafletEngine.getInstance().getThreadPool().execute(runna);

    }
  }

  @Override
  public void initDBResources() throws DBManagerException {
    SafiDriverManager mgr = DBManager.getInstance().getDriverManager();
    if (mgr == null)
      return;
    synchronized (mgr) {
      for (DBDriver drv : mgr.getDrivers())
        for (DBConnection conn : drv.getConnections())
          PooledDataSourceManager.getInstance().connectionChanged(conn);
    }
  }

  @Override
  public void initSafiServer() {
    safiServerChanged(true);

  }

  protected synchronized void updateSafiServer(SafiServer newConfig) throws DBManagerException {

    boolean isDirty = false;

    if (!StringUtils
        .equalsIgnoreCase(SafletEngine.getInstance().getBindIP(), newConfig.getBindIP())) {
      newConfig.setBindIP(SafletEngine.getInstance().getBindIP());
      isDirty = true;
    }
    if (newConfig.getPort() != SafletEngine.getInstance().getFastagiPort()) {
      isDirty = true;
      newConfig.setPort(SafletEngine.getInstance().getFastagiPort());
    }
    if (newConfig.getManagementPort() != SafletEngine.getInstance().getManagementPort()) {
      isDirty = true;
      newConfig.setManagementPort(SafletEngine.getInstance().getManagementPort());
    }

    if (newConfig.getDbPort() != SafletEngine.getInstance().getDatabasePort()) {
      isDirty = true;
      newConfig.setDbPort(SafletEngine.getInstance().getDatabasePort());
    }

    if (isDirty) {
      DBManager.getInstance().saveOrUpdateServerResource(newConfig);
    }
    this.oldSafiServerConfig = this.safiServerConfig;
    this.safiServerConfig = newConfig;
  }

  @Override
  public synchronized void safiServerChanged(boolean startup) {
    // SafiServer oldConfig = safiServerConfig;
    boolean shouldReloadAgi = true;
    SafiServer newConfig = null;

    try {
      newConfig = DBManager.getInstance().getSafiServerConfig(
          safiServerConfig != null ? safiServerConfig.getId() : -1);
      // if (newConfig == safiServerConfig)
      // return;

    } catch (DBManagerException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
      log.error("Couldn't create FastAgi connection", e1);
      postErrorMessage("FastAGI Error", "Couldn't create FastAgi connection: "
          + e1.getLocalizedMessage());
      return;
    }

    if (newConfig != null && startup) {
      try {
        updateSafiServer(newConfig);
      } catch (Exception e) {
        log.error("Fatal SafiServer initialization error", e);
        WrapperManager.stop(1);
        return;
      }
    }

    if (startup
        || (newConfig != null && safiServerConfig != null
            && StringUtils.equals(newConfig.getBindIP(), currentHostname) && currentFastAgiPort == newConfig
            .getPort())) {
      shouldReloadAgi = false;
    } else
      SafletEngine.getInstance().setFastagiPort(newConfig.getPort());
    int oldMgrPort = currentManagementPort;
    String oldIp = currentHostname;
    int oldDBPort = currentDBPort;
    setSafiServerConfig(newConfig);

    // restart RMI
    if (!startup
        && newConfig != null
        && (oldMgrPort != newConfig.getManagementPort() || !StringUtils.equals(newConfig
            .getBindIP(), oldIp))) {
      // should restart MBean server
      try {

        SafletEngine.getInstance().setManagementPort(newConfig.getManagementPort());
        SafletEngine.getInstance().setBindIP(newConfig.getBindIP());
        SafletEngine.getInstance().initJMXServer(newConfig.getManagementPort(),
            newConfig.getBindIP());
      } catch (Exception e) {
        e.printStackTrace();
        // log.error("Couldn't init JMX server on new settings...rolling back", e);
        // if (oldSafiServerConfig != safiServerConfig)
        // rollbackServerSettings(oldSafiServerConfig);
        // else
        WrapperManager.restartAndReturn();
        return;
      }
    }

    // restart DB
    if (!startup && newConfig != null && DBManager.getInstance().getPort() != newConfig.getDbPort()) {
      try {
        SafletEngine.getInstance().setDatabasePort(newConfig.getDbPort());
        SafletEngine.getInstance().restartDB(newConfig.getDbPort());
      } catch (DBManagerException e) {
        log.error("Critical Error. Restarting...", e);
        postErrorMessage("Critical Error", "Couldn't restart SafiServer database: "
            + e.getLocalizedMessage());
        // if (oldSafiServerConfig != safiServerConfig)
        // rollbackServerSettings(oldSafiServerConfig);
        // else
        WrapperManager.restartAndReturn();
        return;
      }
    }

    // restart AGI
    if (shouldReloadAgi) {
      try {
        SafletEngine.getInstance().setBindIP(newConfig.getBindIP());
        // HandlerEngine.getInstance().setDatabasePort(newConfig.getDbPort());

        shutdownAGIServer();
        if (newConfig != null) {
          createAgiServer();
          postInfoMessage("FastAGI Server", "FastAGI server was reloaded");
        }
      } catch (Exception e) {
        e.printStackTrace();
        log.error("Couldn't create FastAgi server from config " + newConfig, e);

        try {
          shutdownAGIServer();
        } catch (Exception ignore) {
        }
        postErrorMessage("FastAGI Error", "Couldn't create FastAgi connection: "
            + e.getLocalizedMessage());

        // if (oldSafiServerConfig != safiServerConfig)
        // rollbackServerSettings(oldSafiServerConfig);
        // else
        WrapperManager.restartAndReturn();
      }
    }

  }

  private void postInfoMessage(String title, String message) {
    if (SafletEngine.getInstance().getServerMonitor() == null) {
      log.info(title + " -- " + message);
      return;
    }
    try {
      SafletEngine.getInstance().getServerMonitor().postInfo(title, message);
    } catch (UnableToSendNotificationException e1) {
      e1.printStackTrace();
      log.error("Unable to send info notification via JMX", e1);
    }
  }

  private void postErrorMessage(String title, String message) {
    if (SafletEngine.getInstance().getServerMonitor() == null) {
      log.error(title + " -- " + message);
      return;
    }
    try {
      SafletEngine.getInstance().getServerMonitor().postError(title, message);
    } catch (UnableToSendNotificationException e1) {
      e1.printStackTrace();
      log.error("Unable to send info notification via JMX", e1);
    }

  }

  /*
   * ReentrantLock rollbackLock = new ReentrantLock();
   * 
   * private void rollbackServerSettings(SafiServer oldConfig) { if
   * (!rollbackLock.tryLock()) {
   * 
   * if (log.isDebugEnabled()) log.debug("Someone is rolling back and there are " +
   * rollbackLock.getQueueLength() + " in queue. I'm returning..."); return; } //
   * rollbackLock.lock(); log.debug("Lock is held by " +
   * Thread.currentThread().getName()); try { if (log.isDebugEnabled()) {
   * log.debug("Rolling back current config " + safiServerConfig + " to " + oldConfig); }
   * SafiServer newConfig =
   * DBManager.getInstance().getSafiServerConfig(oldConfig.getId());
   * newConfig.setBindIP(oldConfig.getBindIP());
   * newConfig.setDbPort(oldConfig.getDbPort());
   * newConfig.setManagementPort(oldConfig.getManagementPort());
   * newConfig.setPort(oldConfig.getPort());
   * 
   * safiServerConfig = oldSafiServerConfig = newConfig;
   * DBManager.getInstance().saveOrUpdateServerResource(newConfig); } catch (Exception e)
   * { // TODO Auto-generated catch block e.printStackTrace(); } finally {
   * rollbackLock.unlock(); log.debug("Lock is released by " +
   * Thread.currentThread().getName()); } }
   */
  @Override
  public synchronized void asteriskServerAdded(AsteriskServer astServer) {
    if (managerConnectionMap.containsKey(astServer.getId())) {
      log.warn("Asterisk server with id " + astServer.getId() + " already exists");
      return;
    }
    try {

      if (createManagerConnection(astServer))
        this.postInfoMessage("AsteriskServer added and connection created", astServer.getName()
            + " with IP " + astServer.getHostname());
    } catch (Exception e) {
      log.error("Couldn't create manager connection for AsteriskServer " + astServer.getName()
          + " at " + astServer.getHostname(), e);
      postErrorMessage("Add Asterisk Server Error",
          "Couldn't create manager connection for AsteriskServer " + astServer.getName() + " at "
              + astServer.getHostname() + ": " + e.getLocalizedMessage());

    }

  }

  @Override
  public synchronized void asteriskServerModified(Integer id) {
    AsteriskServer s = getAsteriskServerById(id, true);
    if (s == null) {
      log.error("Couldn't find existing Asterisk server with ID " + id);
      return;
    }
    SafiManagerConnection conn = managerConnectionMap.get(id);
    boolean connChanged = true;
    if (conn != null) {
      connChanged = false;
      if (!StringUtils.equals(s.getHostname(), conn.getHostname())
          || s.getManagerPort() != conn.getPort()
          || !StringUtils.equals(s.getManagerName(), conn.getUsername())
          || !StringUtils.equals(s.getManagerPassword(), conn.getPassword()))
        connChanged = true;

    }
    if (connChanged) {
      try {
        removeSafiManagerConnection(id);
      } catch (Exception e) {
        log.warn("Error caught while removing manager connection for Asterisk server "
            + s.getName(), e);
      }
      try {
        createManagerConnection(s);
      } catch (Exception e) {
        e.printStackTrace();
        log.error("Couldn't create manager connection for AsteriskServer " + s.getName() + " at "
            + s.getHostname(), e);
        postErrorMessage("Modify Asterisk Server Error", "Asterisk server " + s.getName()
            + " with IP " + s.getHostname() + " could not be connected: " + e.getLocalizedMessage());

      }
    }
  }

  @Override
  public synchronized void asteriskServerRemoved(Integer id) {
    if (removeSafiManagerConnection(id)) {
      try {
        SafletEngine.getInstance().getServerMonitor().postInfo("Asterisk Server Removed",
            "An active AsteriskServer with id " + id + " was shutdown and removed");
      } catch (UnableToSendNotificationException e1) {
        e1.printStackTrace();
        log.error("Unable to send info notification via JMX", e1);
      }
    }
  }

  protected boolean removeSafiManagerConnection(Integer id) {
    SafiManagerConnection managerConnection = null;
    if ((managerConnection = managerConnectionMap.remove(id)) != null) {
      managerConnection.removeEventListener(listener);
      managerConnection.logoff();
      return true;
    }
    return false;
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.asterisk.handler.AsteriskConnectionManager#getDispatcher()
   */
  public SafletDispatch getDispatcher() {
    return dispatcher;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.asterisk.handler.AsteriskConnectionManager#setDispatcher(com.safi.asterisk
   * .handler.SafiApplicationDispatch)
   */
  public void setDispatcher(SafletDispatch dispatcher) {
    this.dispatcher = dispatcher;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.asterisk.handler.AsteriskConnectionManager#setAgiServer(org.asteriskjava
   * .fastagi.AgiServer)
   */
  private void setAgiServer(SafiFastAgiServer agiServer) {
    this.agiServer = agiServer;
  }

  /*
   * / (non-Javadoc)
   * 
   * @see com.safi.asterisk.handler.AsteriskConnectionManager#setUseBlocking(boolean)
   */
  public void setUseBlocking(boolean blocking) {
    this.blocking = blocking;

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.asterisk.handler.AsteriskConnectionManager#setTesting(boolean)
   */
  public void setTesting(boolean b) {
    this.testing = b;

  }

  @Override
  public SafiServer getSafiServerConfig() {
    return safiServerConfig;
  }

  @Override
  public void setSafiServerConfig(SafiServer safiServerConfig) {
    this.oldSafiServerConfig = this.safiServerConfig;
    this.safiServerConfig = safiServerConfig;
    if (safiServerConfig == null) {
      currentManagementPort = -1;
      currentFastAgiPort = -1;
      currentDBPort = -1;
      currentHostname = null;
    } else {
      currentManagementPort = safiServerConfig.getManagementPort();
      currentFastAgiPort = safiServerConfig.getPort();
      currentHostname = safiServerConfig.getBindIP();
      currentDBPort = safiServerConfig.getDbPort();
    }
  }

  class HandlerMappingStrategy implements MappingStrategy {

    public AgiScript determineScript(AgiRequest request) {
      return new HandlerAgiScript();
    }

  }

  class SafiManagerEventListener implements ManagerEventListener {
    public void onManagerEvent(ManagerEvent event) {
      // if (HandlerEngine.debuggerLog.isDebugEnabled())
      // HandlerEngine.debuggerLog.debug("There was an event of some import: "+event);
      if (event instanceof HangupEvent) {
        String uid = ((HangupEvent) event).getUniqueId();
        synchronized (channelKeepaliveMap) {
          KeepAlive ka = channelKeepaliveMap.remove(uid);
          if (ka != null) {
            if (SafletEngine.debuggerLog.isDebugEnabled())
              SafletEngine.debuggerLog.debug("Loopback channel hangup event detected for chan "
                  + ((HangupEvent) event).getChannel());
            ka.stop();
          }
        }
      }
    }

  }

  class KeepAlive implements Runnable {
    AgiChannel channel;
    Object lock = new Object();

    KeepAlive(AgiChannel channel) {
      this.channel = channel;
    }

    @Override
    public void run() {
      int status = -1;
      try {
        while ((status = channel.getChannelStatus()) != 1 && status != 0) {
          synchronized (lock) {
            try {
              lock.wait(1000 * 60); // wait for a minute
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      } catch (AgiException e) {
      }
      if (SafletEngine.debuggerLog.isDebugEnabled())
        SafletEngine.debuggerLog
            .debug("KeepAlive for channel " + channel.getName() + " stopped...");
    }

    public void stop() {
      synchronized (lock) {
        lock.notifyAll();
      }
    }
  }

  class HandlerAgiScript extends BaseAgiScript {

    public HandlerAgiScript() {
    }

    public void service(AgiRequest request, AgiChannel channel) throws AgiException {
      handle(request, channel);
    }

  }

  public void setFactory(SafiFastAgiServerFactory factory) {
    this.factory = factory;
  }

  public SafiFastAgiServerFactory getAgiServerFactory() {
    return fastAgiServerFactory;
  }

  public void setAgiServerFactory(SafiFastAgiServerFactory fastAgiServerFactory) {
    this.fastAgiServerFactory = fastAgiServerFactory;
  }

  private void setupManagerDaemon() {
    managerConnectionPoller.schedule(new ManagerDaemon(), 10000, 3 * 60 * 1000);

  }

  private class ManagerDaemon extends TimerTask {

    @Override
    public void run() {
      // safiServerChanged();
      synchronized (safiServerConfig) {
        AsteriskServer[] astServers = new AsteriskServer[safiServerConfig.getAsteriskServers()
            .size()];
        safiServerConfig.getAsteriskServers().toArray(astServers);
        int j = 0;
        for (int i = 0; i < astServers.length; i++) {
          AsteriskServer astServer = astServers[i];
          if (!astServer.isActive())
            continue;

          SafiManagerConnection conn = managerConnectionMap.get(astServer.getId());
          if (conn == null) {
            try {
              if (createManagerConnection(astServer))
                postInfoMessage("Manager Connection created", astServer.getName() + " with IP "
                    + astServer.getHostname());
            } catch (Exception e) {
              e.printStackTrace();
              log.error("Couldn't create manager connection for server " + astServer.getId(), e);
            }
          } else {
            try {
              org.asteriskjava.manager.response.ManagerResponse res = conn
                  .sendAction(new PingAction());
            } catch (Exception e) {
              log.warn("Ping failed to manager connection, renewing connection.", e);
              managerConnectionMap.remove(astServer.getId());
              try {
                if (createManagerConnection(astServer))
                  postInfoMessage("Manager Connection re-created", astServer.getName()
                      + " with IP " + astServer.getHostname());
              } catch (Exception ex) {
                ex.printStackTrace();
                log.error("Couldn't create manager connection for server " + astServer.getId(), ex);
                postErrorMessage("Manager Connection Lost",
                    "Couldn't create manager connection for Asterisk server " + astServer.getName()
                        + " with IP " + astServer.getHostname());
              }

            }
          }
          j++;

        }
      }
    }
  }

  // private class ManagerDaemon extends TimerTask {
  //
  // @Override
  // public void run() {
  // // safiServerChanged();
  // synchronized (safiServerConfig) {
  // for (AsteriskServer astServer : safiServerConfig.getAsteriskServers()) {
  // if (!astServer.isActive())
  // continue;
  // SafiManagerConnection conn = managerConnectionMap.get(astServer.getId());
  // if (conn == null) {
  // try {
  // createManagerConnection(astServer);
  // } catch (Exception e) {
  // e.printStackTrace();
  // log.error("Couldn't create manager connection for server " + astServer.getId(), e);
  // }
  // } else {
  // try {
  // org.asteriskjava.manager.response.ManagerResponse res = conn
  // .sendAction(new PingAction());
  // } catch (Exception e) {
  // log.warn("Ping failed to manager connection, renewing connection.", e);
  // managerConnectionMap.remove(astServer.getId());
  // try {
  // createManagerConnection(astServer);
  // } catch (Exception ex) {
  // ex.printStackTrace();
  // log.error("Couldn't create manager connection for server " + astServer.getId(), ex);
  // postErrorMessage("Manager Connection Lost",
  // "Couldn't create manager connection for Asterisk server " + astServer.getName()
  // + " with IP " + astServer.getHostname());
  // }
  //
  // }
  // }
  // }
  // }
  // }
  // }

  public boolean isStopping() {
    return stopping;
  }

  class AgiUncaughtExceptionHandler implements java.lang.Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
      log.error("Safi FastAGI server error", e);
      postErrorMessage("FastAGI Error", "Uncaught FastAGI Error: " + e.getLocalizedMessage());
      // if (oldSafiServerConfig != null && oldSafiServerConfig != safiServerConfig) {
      // rollbackServerSettings(oldSafiServerConfig);
      // } else {
      // WrapperManager.restart();
      // log.warn("We've already rolled back. This error may be unrecoverable");
      // }

    }
  }

  class SafiServerListenerInternal implements SafiServerListener {
    private String name;
    private String ip;

    SafiServerListenerInternal(String name, String ip) {
      this.name = name;
      this.ip = ip;
    }

    @Override
    public void serverStarted() {
      // postInfoMessage("Asterisk Connection Created", "Connection to AsteriskServer at
      // "+ip+" was successfully created.");

    }

    @Override
    public void serverStopped(String reason) {
      postInfoMessage("Asterisk Connection Lost", "Connection to AsteriskServer named " + name
          + " at " + ip + " was lost. Reason: " + reason);
    }
  }

  @Override
  public int getNumAgiRequests() {
    return numAgiRequests;
  }

  public int getNumCustomInitiations() {
    return numCustomInitiations;
  }

  public static class AstInitInfo extends EObjectImpl implements AsteriskInitiatorInfo {
    private AgiRequest request;
    private AgiChannel channel;
    private ManagerConnection managerConnection;

    public AgiRequest getRequest() {
      return request;
    }

    public void setRequest(AgiRequest request) {
      this.request = request;
    }

    public AgiChannel getChannel() {
      return channel;
    }

    public void setChannel(AgiChannel channel) {
      this.channel = channel;
    }

    public ManagerConnection getManagerConnection() {
      return managerConnection;
    }

    public void setManagerConnection(ManagerConnection managerConnection) {
      this.managerConnection = managerConnection;
    }

  }
}
