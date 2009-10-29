package com.safi.asterisk.handler;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.hibernate.Session;
import org.sadun.util.polling.DirectoryPoller;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.jmx.support.ConnectorServerFactoryBean;
import org.springframework.jmx.support.MBeanServerFactoryBean;
import org.springframework.remoting.rmi.RmiRegistryFactoryBean;
import org.springmodules.db.hsqldb.ServerBean;
import org.tanukisoftware.wrapper.jmx.WrapperManager;

import com.safi.asterisk.handler.SafletEngineException.SafletExceptionCode;
import com.safi.asterisk.handler.connection.AbstractConnectionManager;
import com.safi.asterisk.handler.connection.AsteriskConnectionManager;
import com.safi.asterisk.handler.connection.SSHDProvider;
import com.safi.asterisk.handler.dispatch.SafletDispatch;
import com.safi.asterisk.handler.importing.SafiArchiveImporter;
import com.safi.asterisk.handler.mbean.FileTransferImpl;
import com.safi.asterisk.handler.mbean.SafiServerMonitorImpl;
import com.safi.asterisk.handler.service.ServiceManager;
import com.safi.asterisk.handler.trigger.AstServerChangedTrigger;
import com.safi.asterisk.handler.trigger.SafiServerChangedTrigger;
import com.safi.asterisk.handler.trigger.SafletChangedTrigger;
import com.safi.asterisk.handler.trigger.VariableTrigger;
import com.safi.asterisk.handler.util.CustomInitiatorInvoker;
import com.safi.asterisk.handler.util.ServiceConfigUpdater;
import com.safi.asterisk.saflet.AsteriskSaflet;
import com.safi.asterisk.saflet.AsteriskSafletEnvironment;
import com.safi.core.saflet.Saflet;
import com.safi.core.scripting.SafletScriptEnvironment;
import com.safi.core.scripting.ScriptingFactory;
import com.safi.db.Variable;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.db.manager.PooledDataSourceManager;
import com.safi.db.server.config.SafiServer;
import com.safi.server.SafiServerListener;
import com.sshtools.j2ssh.transport.publickey.SshKeyGenerator;

public class SafletEngine {

  public static final String DEFAULT_KEY_PASSPHRASE = "safiserver";
  private static final String ENV_DEBUG_SERVER_MODE = "DebugServerMode";
  public final static String SAFISERVER_VERSION = "1.0_20090823";
  public final static String ROOT_DIR = System.getProperty("user.dir");
  private static final String RESOURCES_DIRECTORY = ROOT_DIR + File.separatorChar + "resources";
  public static final String HOST_KEY_NAME = RESOURCES_DIRECTORY + File.separatorChar
      + "ssh_host_dsa_key";
  public static final String SA_USER = "sa";
  public static final String OS_NAME = (String) System.getProperties().get("os.name");
  public static final String ACTIONPAK_DIRECTORY = ROOT_DIR + File.separatorChar + "deploy"
      + File.separatorChar + "actionpaks";
  public static final String LICENSE_DIRECTORY = ROOT_DIR + File.separatorChar + "deploy"
      + File.separatorChar + "license";
  private static final String RESOURCES_ENVIRONMENT_PROPERTIES = "environment.properties";

  private static final int DEFAULT_DB_PORT = 7021;
  public static final String WORKBENCH_DEBUGLOG = "WORKBENCH_DEBUGLOG";
  public static final String STANDARD_LOG = "STANDARD_LOG";

  private final static Logger log = Logger.getLogger(SafletEngine.class.getName());
  final static public Logger debuggerLog = Logger.getLogger(WORKBENCH_DEBUGLOG);
  public static final String CONTEXT_CONFIG_LOCATION = "springConfig.xml";

  private static SafletEngine instance = new SafletEngine();
  private static ServiceManager serviceManager;

  private SafletDispatch dispatcher;
  private AsteriskConnectionManager connectionManager;
  private SafletScriptEnvironment scriptingEnvironment;
  private boolean testing;
  private int fastAgiPoolsize = 10;
  private int fastAgiMaxPoolsize = 500;
  private int fastagiPort = 5043;

  private ThreadPoolExecutor threadPool;
  private ApplicationContext applicationContext;
  private GenericApplicationContext dynamicApplicationContext;
  private SafiServer debugSafiServer;
  private String bindIP;
  private String defaultPass;
  private SafiServerMonitorImpl safiServerMonitor;
  private Properties environmentProperties;
  private int databasePort;
  private int managementPort;
  private String actionpakDirectory = ACTIONPAK_DIRECTORY;
  private HashSet<File> actionpakJars;
  private boolean useDebugAsterisk = true;
  private Properties originalProperties;
  private volatile boolean shuttingDown;
  private boolean useSecurityManager;
  private volatile boolean actionpakPkgsInitated = false;
  private String audioDirectoryRoot;
  private DirectoryPoller importPoller;
  private SafiArchiveImporter pollManager;
  private ServiceConfigUpdater serviceConfigUpdater;
  private String importDirectory;

  private long startupTime;

  public String getDefaultPass() {
    return defaultPass;
  }

  public void setDefaultPass(String defaultPass) {
    this.defaultPass = defaultPass;
    if (environmentProperties != null)
      environmentProperties.setProperty("user.password", defaultPass);
    if (dynamicApplicationContext != null && dynamicApplicationContext.containsBean("dataSource")) {
      DriverManagerDataSource ds = (DriverManagerDataSource) dynamicApplicationContext
          .getBean("dataSource");
      ds.setPassword(defaultPass);
      DBManager.getInstance().setPassword(defaultPass, true);
    }
  
  }

  public static synchronized SafletEngine getInstance() {
    if (instance == null)
      instance = new SafletEngine();
    return instance;
  }

  private SafletEngine() {
    GlobalVariableManager.getInstance().setDebug(false);
    initScriptingEnvironment();
    initThreadPool();
    initLogging();
    // LicenseManager.getInstance();
  }

  private void initLogging() {

  }

  public void loadEnvironmentProperties() {
    environmentProperties = new Properties();
    try {
      environmentProperties.load(ClassLoader
          .getSystemResourceAsStream(RESOURCES_ENVIRONMENT_PROPERTIES));
      originalProperties = (Properties) environmentProperties.clone();
    } catch (IOException e) {
      e.printStackTrace();
      log.error("Couldn't load environemnt properties", e);
    }

  }

  private void saveEnvironmentProperties() {
    try {
      if (environmentProperties != null && (originalProperties == null)
          || !originalProperties.equals(environmentProperties))
        environmentProperties.store(new FileOutputStream(new File("resources/"
            + RESOURCES_ENVIRONMENT_PROPERTIES)), null);
    } catch (Exception e) {
      e.printStackTrace();
      log.error("Couldn't save environment properties", e);
    }
  }

  public String getProperty(String key) {
    return environmentProperties == null ? null : environmentProperties.getProperty(key);
  }

  private void initThreadPool() {
    threadPool = new ThreadPoolExecutor(fastAgiPoolsize, fastAgiMaxPoolsize, 10L, TimeUnit.SECONDS,
        new LinkedBlockingQueue<Runnable>());
  }

  private void initScriptingEnvironment() {
    scriptingEnvironment = ScriptingFactory.eINSTANCE.createRhinoSafletScriptEnvironment();
    scriptingEnvironment.setSafletScriptFactory(ScriptingFactory.eINSTANCE
        .createRhinoSafletScriptFactory());
    scriptingEnvironment.setScriptScopeFactory(ScriptingFactory.eINSTANCE
        .createRhinoScriptScopeFactory());
  }

  public void addWorkbenchDebugStatement(Level level, String message) {
    debuggerLog.log(level, message);
  }

  public void hookHandler(Saflet handler) {
    boolean astSaflet = handler instanceof AsteriskSaflet;
    // if (astSaflet && !testing && astServerId != null)
    // ((AsteriskSaflet)handler).setManagerConnection(connectionManager.getManagerConnection(astServerId));
    handler.setScriptingEnvironment(scriptingEnvironment);
    if (astSaflet)
      ((AsteriskSaflet) handler).setSafletEnvironment(new EngineHandlerEnvironment(handler));

  }

  // public void setHostName(String hostName) {
  // connectionManager.setHostName(hostName);
  // }
  //
  // public void setPassword(String password) {
  // connectionManager.setPassword(password);
  // }
  //
  // public void setUserName(String userName) {
  // connectionManager.setUserName(userName);
  // }

  public void setFastAgiPoolsize(int size) {
    fastAgiPoolsize = size;
  }

  public void setFastAgiMaxPoolsize(int max) {
    fastAgiMaxPoolsize = max;
  }

  // public void setServerBindAddr(String bindAddr) {
  // connectionManager.setServerBindAddr(bindAddr);
  // }

  public boolean addListener(SafiServerListener listener) {
    return connectionManager.addListener(listener);
  }

  public boolean removeListener(SafiServerListener listener) {
    return connectionManager.removeListener(listener);
  }

  public void init() throws SafletEngineException {
    shuttingDown = false;
    try {
      if (useSecurityManager)
        installSecurityManager();
      loadEnvironmentProperties();
      loadActionpaks();

      dynamicApplicationContext = new GenericApplicationContext(applicationContext);

      // if (isServerMode())

      if (debuggerLog.isInfoEnabled())
        debuggerLog.info("Management listener started on " + getManagementPort());
      connectionManager.setManagementPort(getManagementPort());
      connectionManager.setBindIP(getBindIP());
      initializeDB(getDatabasePort());
      // Give DB time to start

      initShutdownHook();
      connectionManager.initSafiServer();
      connectionManager.initManagerConnections();
      connectionManager.initDBResources();
      initSSHD();
    } catch (DBManagerException e) {
      throw new SafletEngineException("Couldn't initialize DBManager: "
          + e.getCause().getLocalizedMessage(), e,
          SafletEngineException.SafletExceptionCode.SAFISERVER_DB_ERROR);
    }
    try {
      initJMXServer(getManagementPort(), getBindIP());
    } catch (Exception e) {
      throw new SafletEngineException("Couldn't initialize JMX Server: "
          + e.getCause().getLocalizedMessage(), e,
          SafletEngineException.SafletExceptionCode.RMI_ERROR);
    }
    initPoller();
    startPoller();

  }
  private SSHDProvider sshdProvider;

  private void initSSHD() throws SafletEngineException {
    try {

      if (sshdProvider != null) {
        sshdProvider.stop();
      }
      if (!Boolean.valueOf(environmentProperties.getProperty("useSSHTunnel", "false")))
        return;

      if (sshdProvider == null) {
        throw new SafletEngineException("Couldn't create SSHD tunnel.  No SSHD Provider specified",
            SafletExceptionCode.SSHD_ERROR);
      }
      createKeysIfNecessary();
      int sshPort = Integer.parseInt(environmentProperties.getProperty("sshPort", "22"));
      sshdProvider.setSSHPort(sshPort);
      sshdProvider.setSSHHost(getBindIP());
      sshdProvider.start();
    } catch (Exception e) {
      if (e instanceof SafletEngineException)
        throw (SafletEngineException) e;
      throw new SafletEngineException("Couldn't start SSHD server", e,
          SafletEngineException.SafletExceptionCode.SSHD_ERROR);
    }
  }

  private void createKeysIfNecessary() throws IOException {
    File publicKeyFile = new File(HOST_KEY_NAME + ".pub");
    File privateKeyFile = new File(HOST_KEY_NAME);
    if (!(publicKeyFile.exists() && privateKeyFile.exists())) {
      publicKeyFile.delete();
      privateKeyFile.delete();
      SshKeyGenerator generator = new SshKeyGenerator();
      generator.generateKeyPair("DSA", 1024, HOST_KEY_NAME, System.getProperty("user.name"),
          DEFAULT_KEY_PASSPHRASE);
    }

  }

  // private void initSSHD2() throws SafletEngineException {
  // try {
  //      
  // try {
  // SshDaemon.stop("SafiServer stopping sshd");
  // } catch (Exception e) {
  // }
  // if (!Boolean.valueOf(environmentProperties.getProperty("useSSHTunnel", "false")))
  // return;
  //      
  // XmlServerConfigurationContext context = new XmlServerConfigurationContext();
  // context.setServerConfigurationResource(ConfigurationLoader.checkAndGetProperty(
  // "sshtools.server", "server.xml"));
  // context.setPlatformConfigurationResource(System.getProperty(
  // "sshtools.platform", "platform.xml"));
  // ConfigurationLoader.initialize(false, context);
  //
  // XmlConfigurationContext context2 = new XmlConfigurationContext();
  // context2.setFailOnError(false);
  // context2.setAPIConfigurationResource(ConfigurationLoader.checkAndGetProperty(
  // "sshtools.config", "sshtools.xml"));
  // context2.setAutomationConfigurationResource(ConfigurationLoader.checkAndGetProperty(
  // "sshtools.automate", "automation.xml"));
  // ConfigurationLoader.initialize(false, context2);
  // SshDaemon.start();
  //
  // } catch (Exception e) {
  // throw new SafletEngineException("Couldn't start SSHD server", e,
  // SafletEngineException.SafletExceptionCode.SSHD_ERROR);
  // }
  // }

  private void initPoller() {
    if (importPoller != null) {
      importPoller.setFilter(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
          // TODO Auto-generated method stub
          return name != null && name.toLowerCase().endsWith(".sar");
        }
      });
      if (pollManager != null)
        importPoller.addPollManager(pollManager);
    }
  }

  private void startPoller() {
    if (importPoller != null)
      importPoller.start();

  }

  public synchronized void loadActionpaks() {
    File actionpakDir = new File(getActionpakDirectory());
    if (!actionpakDir.exists()) {
      actionpakDir.mkdirs();
    } else {
      File[] files = actionpakDir.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
          // TODO Auto-generated method stub
          return pathname.getName().endsWith(".jar");
        }
      });
      if (log.isDebugEnabled())
        for (File f : files) {
          log.debug("Got file " + f.getAbsolutePath() + " and uri " + f.toURI());
        }
      actionpakJars = new HashSet<File>(Arrays.asList(files));
      // for (File f : files){
      // try {
      // getDispatcher().loadJar(f);
      // } catch (Exception e) {
      // e.printStackTrace();
      // log.error("Couldn't load jar file "+f, e);
      // }
      // }
    }
  }

  private void installSecurityManager() {
    SecurityManager manager = System.getSecurityManager();
    if (manager == null) {
      SafiServerSecurityManager sm = new SafiServerSecurityManager();
      // System.setSecurityManager(sm);
    }

  }

  protected void initializeDB(int port) throws DBManagerException {

    if (!dynamicApplicationContext.containsBean("dataSource")) {
      BeanDefinitionBuilder builder1 = BeanDefinitionBuilder.rootBeanDefinition(
          DriverManagerDataSource.class).addPropertyValue("driverClassName",
          "org.hsqldb.jdbcDriver").addPropertyValue("url",
          "jdbc:hsqldb:file:" + ROOT_DIR + "/db/safi;hsqldb.default_table_type=cached")
          .addPropertyValue("username", SA_USER).addPropertyValue("password", defaultPass);
      dynamicApplicationContext.registerBeanDefinition("dataSource", builder1.getBeanDefinition());
    }
    // URL scriptLocation = ClassLoader.getSystemResource("db/safi.script");

    File file = null;

    try {
      // file = new File(scriptLocation.toURI());
      file = new File(ROOT_DIR + "/db/safi.script");
    } catch (Exception e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

    boolean isNew = file != null && !file.exists();
    Properties serverProperties = new Properties();
    serverProperties.setProperty("server.database.0", ROOT_DIR + "/db/safi");
    serverProperties.setProperty("server.dbname.0", "safi");
    serverProperties.setProperty("server.port", String.valueOf(port));
    serverProperties.setProperty("hsqldb.default_table_type", "cached");
    BeanDefinitionBuilder builder2 = BeanDefinitionBuilder.rootBeanDefinition(ServerBean.class)
        .addPropertyValue("serverProperties", serverProperties).addPropertyReference("dataSource",
            "dataSource");
    dynamicApplicationContext.registerBeanDefinition("database", builder2.getBeanDefinition());
    // dynamicApplicationContext.refresh();
    ServerBean bean = getServerBean();
    // if (bean != null) {
    DBManager.getInstance().setPort(port, true);
    // }
    DBManager.getInstance().setServerMode(true);
    DBManager.getInstance().setUsername(SA_USER, true);
    DBManager.getInstance().setPassword(isNew ? "" : defaultPass, true);
    try {
      if (StringUtils.isNotBlank(bindIP)) {
        // if ("0.0.0.0".equals(bindIP.trim()) && OS_NAME.toLowerCase().indexOf("windows")
        // < 0) {
        // bindIP = InetAddress.getLocalHost().getHostAddress();
        // log.warn("Wildcard IP 0.0.0.0 was selected but is invalid for OS " + OS_NAME
        // + ". Bind IP set to " + bindIP);
        //
        // }
      } else {
        bindIP = InetAddress.getLocalHost().getHostAddress();
        log.info("No Bind IP was specified so using reported address " + bindIP);
      }
      DBManager.getInstance().setHost(bindIP, true);

      // whether it changed or not just set it
      setBindIP(bindIP);
      connectionManager.setBindIP(getBindIP());
    } catch (UnknownHostException ex) {
      ex.printStackTrace();
      DBManager.getInstance().setHost("localhost", true);
    }
    DBManager.getInstance().setManagementPort(getManagementPort());
    Session session = null;
    try {
      DBManagerException lastException = null;
      for (int i = 0; i < 30; i++) {
        try {
          session = DBManager.getInstance().createSession();
          if (session != null) {
            lastException = null;
            break;
          }

        } catch (DBManagerException e) {
          lastException = e;
          log.warn("Session creation failed on try " + i + ": "
              + e.getCause().getLocalizedMessage());
          try {
            Thread.sleep(3000);
          } catch (Exception ignore) {
          }
        }
      }
      if (lastException != null)
        throw lastException;
      boolean wasInitialized = DBManager.getInstance().initializeDB(session);
      if (wasInitialized) {
        if (StringUtils.isNotBlank(defaultPass)) {
          try {
            DBManager.getInstance().setSAPassword(defaultPass, true);

          } catch (Exception exe) {
            throw new DBManagerException("Couldn't set admin password", exe);
          }
        }
        initTriggers();

      }
      GlobalVariableManager.getInstance().loadGlobalVariables();
    } finally {
      if (session != null)
        session.close();

    }
  }

  public void restartDB(int port) throws DBManagerException {
    dynamicApplicationContext.removeBeanDefinition("database");
    initializeDB(port);
  }

  public ServerBean getServerBean() {
    ServerBean bean = (ServerBean) dynamicApplicationContext.getBean("database", ServerBean.class);
    return bean;
  }

  private void initShutdownHook() {
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public synchronized void start() {
        stopProcessing();
      }
    });

  }

  private void initTriggers() throws DBManagerException {
    DBManager dbManager = DBManager.getInstance();
    dbManager.addTrigger(new DBResourceTrigger(), "\"dbconnection\"", "connectionTrigger");
    dbManager.addTrigger(new DBResourceTrigger(), "\"dbdriver\"", "driverTrigger");
    dbManager.addTrigger(new DBResourceTrigger(), "\"query\"", "queryTrigger");
    dbManager.addTrigger(new SafletChangedTrigger(), "\"saflet\"", "safletTrigger");
    // dbManager.addTrigger(new SafletProjectChangedTrigger(), "\"safletproject\"",
    // "safletProjectTrigger");

    dbManager.addTrigger(new AstServerChangedTrigger(), "\"asteriskserver\"", "astServerTrigger");

    dbManager.addTrigger(new SafiServerChangedTrigger(), "\"safiserver\"", "safiServerTrigger");
    dbManager.addTrigger(new com.safi.asterisk.handler.trigger.UserChangedTrigger(), "\"user\"",
        "userTrigger");

    dbManager.addTrigger(new VariableTrigger(), "\"variable\"", "varTrigger");
  }

  public void beginProcessing() throws SafletEngineException {
    connectionManager.beginProcessing();
  }

  public void stopProcessing() {
    if (shuttingDown)
      return;

    shuttingDown = true;
    saveEnvironmentProperties();
    try {
      getServerMonitor().postInfo("Server Shutting Down",
          "Production SafiServer at " + getBindIP() + " is shutting down");
    } catch (Exception exe) {
      exe.printStackTrace();
    }
    connectionManager.stopProcessing();
    stopJMX();
    // List<AsteriskServer> servers =
    // connectionManager.getSafiServerConfig().getAsteriskServers();
    if (!useDebugAsterisk)
      connectionManager.notifyServerStopped("");

    DBManager.getInstance().shutdown();
    PooledDataSourceManager.getInstance().shutdown();

    if (dynamicApplicationContext != null && dynamicApplicationContext.containsBean("database")) {
      ServerBean bean = getServerBean();
      if (bean != null) {
        bean.destroy();
        log.info("DB was stopped");
      }
    }
    if (dynamicApplicationContext != null)
      dynamicApplicationContext.destroy();

    if (importPoller != null)
      importPoller.shutdown();
  }

  public void setAgiServerFactory(SafiFastAgiServerFactory factory) {
    connectionManager.setAgiServerFactory(factory);
  }

  public void setTesting(boolean b) {
    this.testing = b;
    connectionManager.setTesting(b);
  }

  public static void main(String[] args) throws Exception {
    System.out.println("OS Name: " + OS_NAME);
    ApplicationContext context = new ClassPathXmlApplicationContext(CONTEXT_CONFIG_LOCATION) {
      @Override
      protected void initBeanDefinitionReader(XmlBeanDefinitionReader beanDefinitionReader) {
        beanDefinitionReader.setValidationMode(XmlBeanDefinitionReader.VALIDATION_NONE);
        super.initBeanDefinitionReader(beanDefinitionReader);
      }
    };
    SafletEngine engine = (SafletEngine) context.getBean("handlerEngine");
    SafletEngine.instance = engine;
    engine.startupTime = System.currentTimeMillis();
    try {
      engine.setApplicationContext(context);
      engine.init();
      engine.beginProcessing();

    } finally {
      // engine.stopProcessing();
    }
  }

  public void setApplicationContext(ApplicationContext context) {
    this.applicationContext = context;

  }

  class EngineHandlerEnvironment extends EObjectImpl implements AsteriskSafletEnvironment {

    private Saflet handler;

    public EngineHandlerEnvironment(Saflet handler) {
      this.handler = handler;
    }

    @Override
    public Executor getGlobalExecutor() {
      // TODO Auto-generated method stub
      return threadPool;
    }

    @Override
    public String getServerIpAddr() {
      return connectionManager.getServerIpAddress();
    }

    @Override
    public void setServerIpAddr(String value) {
      // TODO Auto-generated method stub

    }

    @Override
    public Saflet getSaflet(String path, int astServerId) {
      return dispatcher.getRunnableHandler(path, null);
    }

    @Override
    public Object getLoopbackCall(String uuid) {
      return connectionManager.getLoopbackCall(uuid);
    }

    @Override
    public void setLoopbackLock(String uuid, Object lock) {
      connectionManager.setLoopbackLock(uuid, lock);
    }

    
    @Override
    public int getFastAgiPort() {
      return connectionManager.getSafiServerConfig().getPort();
    }

    @Override
    public int getManagementPort() {
      return connectionManager.getSafiServerConfig().getManagementPort();
    }

    @Override
    public void setFastAgiPort(int value) {

    }

    @Override
    public void setManagementPort(int value) {

    }

    @Override
    public Object getGlobalVariableValue(String name) {
      Variable v = GlobalVariableManager.getInstance().getGlobalVariable(name, false);
      return v == null ? null : v.getDefaultValue();

    }

    @Override
    public Variable getGlobalVariable(String name) {
      return GlobalVariableManager.getInstance().getGlobalVariable(name, false);
    }

    @Override
    public void setGlobalVariableValue(String name, Object value) {
      try {
        GlobalVariableManager.getInstance().setGlobalVariable(name, value);
      } catch (DBManagerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        log.error("Couldn't set global var " + name + " to " + value + ": "
            + e.getLocalizedMessage(), e);
      }
    }

    @Override
    public List<Variable> getGlobalVariables() {
      return GlobalVariableManager.getInstance().getGlobalVariables();
    }

    @Override
    public Object getLoopbackLock(String uuid) {
      // TODO Auto-generated method stub
      return null;
    }
  }

  public SafletDispatch getDispatcher() {
    return dispatcher;
  }

  public void setDispatcher(SafletDispatch dispatcher) {
    this.dispatcher = dispatcher;
  }

  public AsteriskConnectionManager getConnectionManager() {
    return connectionManager;
  }

  public void setConnectionManager(AsteriskConnectionManager connectionManager) {
    this.connectionManager = connectionManager;
  }

  public ThreadPoolExecutor getThreadPool() {
    // TODO Auto-generated method stub
    return threadPool;
  }

  public static void setServiceManager(ServiceManager serviceManager) {
    SafletEngine.serviceManager = serviceManager;

  }

  public static ServiceManager getServiceManager() {
    return serviceManager;
  }

  public SafiServer getDebugSafiServer() {
    return debugSafiServer;
  }

  public void setDebugSafiServer(SafiServer debugSafiServer) {
    this.debugSafiServer = debugSafiServer;
  }

  public String getBindIP() {
    return bindIP;
  }

  public void setBindIP(String bindIP) {
    this.bindIP = bindIP;
    if (environmentProperties != null)
      environmentProperties.setProperty("bind.addr", bindIP);
  }

  public void setServerMonitor(SafiServerMonitorImpl safiServerMonitor) {
    this.safiServerMonitor = safiServerMonitor;

  }

  public SafiServerMonitorImpl getServerMonitor() {
    return safiServerMonitor;
  }

  public void stopJMX() {
    if (log.isDebugEnabled())
      log.debug("Stopping JMX Server");
    if (dynamicApplicationContext.containsBean("exporter"))
      dynamicApplicationContext.removeBeanDefinition("exporter");

    if (dynamicApplicationContext.containsBean("serverConnector"))
      dynamicApplicationContext.removeBeanDefinition("serverConnector");

    if (dynamicApplicationContext.containsBean("mbeanServer"))
      dynamicApplicationContext.removeBeanDefinition("mbeanServer");

    if (dynamicApplicationContext.containsBean("customInitiator"))
      dynamicApplicationContext.removeBeanDefinition("customInitiator");

    if (dynamicApplicationContext.containsBean("wrapperManager"))
      dynamicApplicationContext.removeBeanDefinition("wrapperManager");

    if (dynamicApplicationContext.containsBean("safiServerMonitor"))
      dynamicApplicationContext.removeBeanDefinition("safiServerMonitor");

    if (dynamicApplicationContext.containsBean("actionpakFileTransfer"))
      dynamicApplicationContext.removeBeanDefinition("actionpakFileTransfer");

    if (dynamicApplicationContext.containsBean("licenseManager"))
      dynamicApplicationContext.removeBeanDefinition("licenseManager");

    if (dynamicApplicationContext.containsBean("registry")) {
      dynamicApplicationContext.removeBeanDefinition("registry");
      try {
        Thread.sleep(10000); // give rmi server chance to shutdown
      } catch (Exception e) {
        // TODO: handle exception
      }
    }

  }

  public void initJMXServer(int port, String bindIP) {
    stopJMX();
    // FixedPortRMISocketFactory factory = new FixedPortRMISocketFactory(port);
    BeanDefinitionBuilder builder1 = BeanDefinitionBuilder.rootBeanDefinition(
        RmiRegistryFactoryBean.class).addPropertyValue("port", port);// .addPropertyValue("alwaysCreate",
    // "true");
    // builder1.addPropertyValue("clientSocketFactory", factory);
    // builder1.addPropertyValue("serverSocketFactory", factory);
    dynamicApplicationContext.registerBeanDefinition("registry", builder1.getBeanDefinition());

    Registry registry = (Registry) dynamicApplicationContext.getBean("registry");
    if (!dynamicApplicationContext.containsBean("mbeanServer")) {
      BeanDefinitionBuilder builder2 = BeanDefinitionBuilder.rootBeanDefinition(
          MBeanServerFactoryBean.class).addPropertyValue("locateExistingServerIfPossible", true);
      dynamicApplicationContext.registerBeanDefinition("mbeanServer", builder2.getBeanDefinition());
    }

    String serviceUrl = null;
    // if ("0.0.0.0".equals(bindIP.trim()) && OS_NAME.toLowerCase().indexOf("windows") <
    // 0) {
    // serviceUrl = "service:jmx:rmi:///jndi/rmi://127.0.0.1:" + port + "/safiserver";
    // }
    // else
    // serviceUrl = "service:jmx:rmi:///jndi/rmi://" + bindIP + ":" + port +
    // "/safiserver";

    if ("localhost".equalsIgnoreCase(bindIP.trim()) || "0.0.0.0".equals(bindIP.trim())
        || "127.0.0.1".equals(bindIP.trim())) {

      List<String> iplist = getLocalIPAddresses();

      for (String ip : iplist) {
        if (!"127.0.0.1".equals(ip) && !"0.0.0.0".equals(ip)) {
          bindIP = ip;

          serviceUrl = "service:jmx:rmi://" + ip + ":" + port + "/jndi/rmi://" + ip + ":" + port
              + "/safiserver";
          break;
        }
      }

    }
    if (serviceUrl == null) {
      bindIP = "127.0.0.1";
      serviceUrl = "service:jmx:rmi://" + bindIP + ":" + port + "/jndi/rmi://" + bindIP + ":"
          + port + "/safiserver";
    }

    // System.setProperty("java.rmi.server.hostname", bindIP);
    // serviceUrl = "service:jmx:rmi:///jndi/rmi://127.0.0.1:" + port + "/safiserver";
    BeanDefinitionBuilder builder3 = BeanDefinitionBuilder.rootBeanDefinition(
        ConnectorServerFactoryBean.class).addPropertyValue("objectName", "connector:name=rmi")
        .addPropertyValue("serviceUrl", serviceUrl).addPropertyReference("server", "mbeanServer")
        .addDependsOn("registry");
    dynamicApplicationContext.registerBeanDefinition("serverConnector", builder3
        .getBeanDefinition());

    dynamicApplicationContext.getBean("serverConnector");

    Map<String, String> beans = new HashMap<String, String>();
    if (!dynamicApplicationContext.containsBean("wrapperManager")) {
      BeanDefinitionBuilder builder4 = BeanDefinitionBuilder
          .rootBeanDefinition(WrapperManager.class);
      dynamicApplicationContext.registerBeanDefinition("wrapperManager", builder4
          .getBeanDefinition());

      WrapperManager mgr = (WrapperManager) dynamicApplicationContext.getBean("wrapperManager");
      beans.put("bean:name=WrapperManager", "wrapperManager");
    }

    if (!dynamicApplicationContext.containsBean("safiServerMonitor")) {
      BeanDefinitionBuilder builder5 = BeanDefinitionBuilder.rootBeanDefinition(
          SafiServerMonitorImpl.class).addPropertyReference("handlerEngine", "handlerEngine");
      dynamicApplicationContext.registerBeanDefinition("safiServerMonitor", builder5
          .getBeanDefinition());
      beans.put("bean:name=serverMonitor", "safiServerMonitor");
    }

    BeanDefinitionBuilder builder7 = BeanDefinitionBuilder
        .rootBeanDefinition(CustomInitiatorInvoker.class);
    dynamicApplicationContext.registerBeanDefinition("customInitiator", builder7
        .getBeanDefinition());
    beans.put("bean:name=customInitiator", "customInitiator");

    if (!dynamicApplicationContext.containsBean("actionpakFileTransfer")) {
      BeanDefinitionBuilder builder8 = BeanDefinitionBuilder
          .rootBeanDefinition(FileTransferImpl.class);
      dynamicApplicationContext.registerBeanDefinition("actionpakFileTransfer", builder8
          .getBeanDefinition());
      beans.put("bean:name=actionpakFileTransfer", "actionpakFileTransfer");
    }

    BeanDefinitionBuilder builder6 = BeanDefinitionBuilder.rootBeanDefinition(MBeanExporter.class)
        .addPropertyValue("beans", beans).addPropertyReference("server", "mbeanServer");
    dynamicApplicationContext.registerBeanDefinition("exporter", builder6.getBeanDefinition());
    dynamicApplicationContext.getBean("exporter");

    // dynamicApplicationContext.refresh();
    // dynamicApplicationContext.start();

  }

  public List<String> getLocalIPAddresses() {
    List<String> iplist = new ArrayList<String>();
    NetworkInterface iface = null;
    try {
      for (Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces(); ifaces
          .hasMoreElements();) {
        iface = ifaces.nextElement();
        System.out.println("Interface:" + iface.getDisplayName());
        InetAddress ia = null;
        for (Enumeration<InetAddress> ips = iface.getInetAddresses(); ips.hasMoreElements();) {
          ia = ips.nextElement();
          if (Pattern.matches(AbstractConnectionManager.PATTERN_IP, ia.getHostAddress())) {
            iplist.add(ia.getHostAddress());
          }
        }
      }
    } catch (SocketException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return iplist;
  }

  public int getDatabasePort() {
    return databasePort;
  }

  public void setDatabasePort(int databasePort) {
    this.databasePort = databasePort;
    if (environmentProperties != null)
      environmentProperties.setProperty("db.port", String.valueOf(databasePort));
  }

  public int getManagementPort() {
    return managementPort;
  }

  public void setManagementPort(int managementPort) {
    this.managementPort = managementPort;
    if (environmentProperties != null)
      environmentProperties.setProperty("management.port", String.valueOf(managementPort));
  }

  public String getActionpakDirectory() {
    return actionpakDirectory;
  }

  public void setActionpakDirectory(String actionpakDirectory) {
    this.actionpakDirectory = actionpakDirectory;
  }

  public synchronized HashSet<File> getActionpakJars() {
    return actionpakJars;
  }

  public synchronized void setActionpakJars(HashSet<File> actionpakJars) {
    this.actionpakJars = actionpakJars;
  }

  public boolean isUseDebugAsterisk() {
    return useDebugAsterisk;
  }

  public void setUseDebugAsterisk(boolean useDebugAsterisk) {
    this.useDebugAsterisk = useDebugAsterisk;
  }

  public int getFastagiPort() {
    return fastagiPort;
  }

  public void setFastagiPort(int fastagiPort) {
    this.fastagiPort = fastagiPort;
    if (environmentProperties != null)
      environmentProperties.setProperty("fastagi.port", String.valueOf(fastagiPort));
  }

  public static void setInstance(SafletEngine eng) {
    instance = eng;
  }

  public boolean isUseSecurityManager() {
    return useSecurityManager;
  }

  public void setUseSecurityManager(boolean useSecurityManager) {
    this.useSecurityManager = useSecurityManager;
  }

  public boolean isActionpakPkgsInitated() {
    return actionpakPkgsInitated;
  }

  public void setActionpakPkgsInitated(boolean actionpakPkgsInitated) {
    this.actionpakPkgsInitated = actionpakPkgsInitated;
  }

  public String getAudioDirectoryRoot() {
    return ROOT_DIR + "/" + audioDirectoryRoot;
  }

  public void setAudioDirectoryRoot(String audioDirectoryRoot) {
    this.audioDirectoryRoot = audioDirectoryRoot;
  }

  public String getResourcesDirectory() {
    // TODO Auto-generated method stub
    return this.RESOURCES_DIRECTORY;
  }

  public DirectoryPoller getImportPoller() {
    return importPoller;
  }

  public void setImportPoller(DirectoryPoller importPoller) {
    this.importPoller = importPoller;

  }

  public SafiArchiveImporter getPollManager() {
    return pollManager;
  }

  public void setPollManager(SafiArchiveImporter pollManager) {
    this.pollManager = pollManager;
  }

  public String getImportDirectory() {
    return importDirectory;
  }

  public void setImportDirectory(String importDirectory) {
    this.importDirectory = importDirectory;
  }

  public void updateServiceClasspath() {
    try {
      URL url = ClassLoader.getSystemResource("wrapper.conf");
      Properties props = new Properties();
      props.load(new FileInputStream(new File(url.toURI())));
      String patt = "^wrapper\\.java\\.classpath\\.[0-9]{1,3}\\s*=%ROOT_DIR%/lib/([a-zA-Z0-9\\.\\-_])*(\\*)?.jar$";
      Pattern pattern = Pattern.compile(patt);
      List<Map.Entry<Object, Object>> cpEntries = new LinkedList<Map.Entry<Object, Object>>();
      for (Map.Entry<Object, Object> entry : props.entrySet()) {
        String key = (String) entry.getKey();
        Matcher matcher = pattern.matcher(key);
        if (matcher.matches()) {
          matcher.group(1);
        }
        if (key.matches(patt)) {
          cpEntries.add(entry);
        }
      }

    } catch (Exception exe) {
      log.error("Couldn't udpate service classpath", exe);
    }
  }

  public ServiceConfigUpdater getServiceConfigUpdater() {
    return serviceConfigUpdater;
  }

  public void setServiceConfigUpdater(ServiceConfigUpdater serviceConfigUpdater) {
    this.serviceConfigUpdater = serviceConfigUpdater;
  }

  public long getStartupTime() {
    return startupTime;
  }

  public static String getMacString(byte[] mac) {
    String macTarget = "";
    if (mac == null)
      return macTarget;
    try {
      for (int i = 0; i < mac.length; i++) {
        macTarget = macTarget + String.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : "");
      }
    } catch (Exception ex) {
    }
    return macTarget.toUpperCase();

  }

  public static String getMacAddress() {
    try {

      Enumeration<NetworkInterface> enm = NetworkInterface.getNetworkInterfaces();
      while (enm.hasMoreElements()) {
        // for(int i=0;i<addresses.length;i++){
        NetworkInterface ni = enm.nextElement();
        try {
          byte[] mac = ni.getHardwareAddress();

          String macTarget = getMacString(mac);
          if (StringUtils.isNotBlank(macTarget))
            return macTarget.toUpperCase();
        } catch (Exception ignore) {
          if (log.isDebugEnabled())
            log.debug("Skipping " + ni.getDisplayName());
        }
      }

    } catch (Exception ex) {
    }
    return "";
  }

  public SSHDProvider getSshdProvider() {
    return sshdProvider;
  }

  public void setSshdProvider(SSHDProvider sshdProvider) {
    this.sshdProvider = sshdProvider;
  }

}
