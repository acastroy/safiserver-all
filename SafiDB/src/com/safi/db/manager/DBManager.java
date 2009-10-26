package com.safi.db.manager;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbDataStore;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.LockMode;
import org.hibernate.MappingException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StaleObjectStateException;
import org.hibernate.Transaction;
import org.hibernate.cfg.Environment;
import org.hibernate.criterion.Restrictions;
import org.hibernate.id.TableHiLoGenerator;
import org.hibernate.impl.SessionImpl;
import org.hsqldb.Trigger;

import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.DBResource;
import com.safi.db.DbPackage;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.db.SafiDriverManager;
import com.safi.db.Variable;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.ConfigFactory;
import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.Entitlement;
import com.safi.db.server.config.Prompt;
import com.safi.db.server.config.Role;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.Saflet;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.db.server.config.User;

public class DBManager {

  public final static int DEFAULT_LOGIN_TIMEOUT = 10;
  private static final String DATASTORE_NAME = "SafiDBDatastore";
  private final static Logger log = Logger.getLogger(DBManager.class);
  protected final static DBManager instance = new DBManager();
  protected SafiDriverManager defaultDrivers;
  protected SafiDriverManager serverDriverManager;
  protected String username;
  protected String password;
  protected String host;
  protected boolean initialized;
  protected boolean serverMode;
  protected int port = 9001;
  protected int managementPort = 7020;

  public static DBManager getInstance() {
    return instance;
  }

  private Map<String, Resource> dbResourceTable = new Hashtable<String, Resource>();

  private ResourceSet resourceLoader;
  private HbDataStore dataStore;
  private String serverPort;
  private int loginTimeout = DEFAULT_LOGIN_TIMEOUT;

  public SafiDriverManager getDriverManagerFromFile(String path) throws IOException {
    return getDriverManagerFromFile(path, true);
  }

  public SafiDriverManager getDriverManagerFromFile(String path, boolean cache) throws IOException {
    Resource m = dbResourceTable.get(path);
    if (m != null)
      return (SafiDriverManager) m.getContents().get(0);

    return loadSafiDriverManager(path, cache);
  }

  // public Resource getDBResource(String path) throws IOException {
  // Resource m = dbResourceTable.get(path);
  // if (m != null)
  // return m;
  // loadSafiDriverManager(path);
  // return dbResourceTable.get(path);
  // }

  public SafiDriverManager getDriverManager() throws DBManagerException {
    if (DBManager.getInstance().isServerMode()) {
      if (serverDriverManager == null) {
        serverDriverManager = getDriverManagerFromDB();
      }
      return serverDriverManager;
    }
    if (dbResourceTable.isEmpty())
      return null;
    Resource r = dbResourceTable.values().toArray(new Resource[1])[0];
    return (SafiDriverManager) r.getContents().get(0);
  }

  public DBConnection getConnectionFromPath(SafiDriverManager manager, String path)
      throws DBManagerException {
    try {
      String[] segs = path.split("\\.");
      return manager.getDriver(segs[0]).getConnection(segs[1]);
    } catch (Exception e) {
      throw new DBManagerException("Couldn't retrieve connection from path " + path, e);
    }
  }

  public Query getQueryFromPath(SafiDriverManager manager, String path) throws DBManagerException {
    try {
      String[] segs = path.split("\\.");
      return manager.getDriver(segs[0]).getConnection(segs[1]).getQuery(segs[2]);
    } catch (Exception e) {
      throw new DBManagerException("Couldn't retrieve connection from path " + path, e);
    }
  }

  public QueryParameter getQueryParamFromPath(SafiDriverManager manager, String path)
      throws DBManagerException {
    try {
      String[] segs = path.split("\\.");
      return manager.getDriver(segs[0]).getConnection(segs[1]).getQuery(segs[2]).getParameter(
          segs[3]);
    } catch (Exception e) {
      throw new DBManagerException("Couldn't retrieve connection from path " + path, e);
    }
  }

  public DBResource getObjectFromPath(SafiDriverManager manager, String path)
      throws DBManagerException {
    try {
      String[] segs = path.split("\\.");
      switch (segs.length) {
        case 1:
          return manager.getDriver(segs[0]);
        case 2:
          return manager.getDriver(segs[0]).getConnection(segs[1]);
        case 3:
          return manager.getDriver(segs[0]).getConnection(segs[1]).getQuery(segs[2]);
        case 4:
          return manager.getDriver(segs[0]).getConnection(segs[1]).getQuery(segs[2]).getParameter(
              segs[3]);
        default:
          return null;
      }
    } catch (Exception e) {
      throw new DBManagerException("Couldn't retrieve connection from path " + path, e);
    }
  }

  public DBResource setDBResourceByPath(SafiDriverManager manager, DBResource resource, String path)
      throws DBManagerException {
    String parentPath;
    DBResource parent = null;
    int idx = path.lastIndexOf('.');
    if (idx >= 0) {
      parentPath = path.substring(0, idx);
      parent = getObjectFromPath(manager, parentPath);
      if (parent == null) {
        throw new DBManagerException("Couldn't find parent resource " + parentPath);
      }
    } else
      parent = manager;
    EReference ref = resource.eContainmentFeature();
    @SuppressWarnings("unchecked")
    EList<Object> list = (EList<Object>) parent.eGet(ref);
    DBResource match = null;
    for (Object o : list) {
      DBResource rez = (DBResource) o;
      if (rez.getId() == resource.getId() || rez.getName().equals(resource.getName())) {
        match = rez;
        break;
      }
    }
    if (match != null) {
      if (copyLocalChildren(match, resource))
        list.remove(match);
    }
    parent.eSetDeliver(true);

    // if (parent instanceof DBDriver){
    // ((DBDriver)parent).getConnections().add((DBConnection)resource);
    // }
    // else
    list.add(resource);
    return parent;
  }

  @SuppressWarnings("unchecked")
  private boolean copyLocalChildren(DBResource from, DBResource to) {
    if (from.eContainer() == to.eContainer())
      return false;
    List resources = null;
    if (from instanceof SafiDriverManager)
      resources = ((SafiDriverManager) from).getDrivers();
    else if (from instanceof DBDriver)
      resources = ((DBDriver) from).getConnections();
    else if (from instanceof DBConnection)
      resources = ((DBConnection) from).getQueries();
    else if (from instanceof Query)
      resources = ((Query) from).getParameters();
    else
      return false;

    EReference ref = null;
    List<Object> list = null;

    for (Object o : resources) {
      DBResource resource = (DBResource) o;
      if (ref == null) {
        ref = resource.eContainmentFeature();
        list = new ArrayList<Object>((List<Object>) to.eGet(ref));
      }
      list.add(resource);
    }
    return true;
  }

  // private boolean saveDriverManagerToFile(String path) throws IOException {
  // Resource m = dbResourceTable.get(path);
  // if (m != null) {
  // m.save(null);
  // return true;
  // }
  // return false;
  // }

  public boolean saveDriverManager(SafiDriverManager manager, boolean saveToDB) throws IOException,
      DBResourceException {
    saveSafiDriverManagerToDisk(manager);
    if (!saveToDB)
      return true;
    Session session = null;
    try {
      session = createSession();
      session.beginTransaction();

      session.saveOrUpdate(manager);

      session.getTransaction().commit();

    } catch (Exception e) {
      e.printStackTrace();
      // TODO: handle exception
    } finally {
      if (session != null)
        session.close();
    }
    return true;
  }

  public boolean saveDriverManagerToDB(SafiDriverManager manager, boolean saveToDisk)
      throws IOException, DBResourceException, DBManagerException {
    Session session = null;
    try {
      session = createSession();
      session.beginTransaction();

      saveDriverManagerToDB(session, manager, saveToDisk);

      session.getTransaction().commit();
    } finally {
      if (session != null)
        session.close();
    }
    return true;
  }

  public boolean saveDriverManagerToDB(Session session, SafiDriverManager manager,
      boolean saveToDisk) throws IOException, DBResourceException {
    if (saveToDisk)
      saveSafiDriverManagerToDisk(manager);
    session.saveOrUpdate(manager);
    return true;
  }

  public Session createSession() throws DBManagerException {
    return createSessionHelper();
  }

  private Session createSessionHelper() throws DBManagerException {
    if (host == null || host.trim().length() == 0 || username == null
        || username.trim().length() == 0)
      throw new DBManagerException(
          "Username or hostname was null.  Please specify server host and username");
    if (dataStore == null) {
      final String dataStoreName = DATASTORE_NAME;
      try {
        String driverName = "org.hsqldb.jdbcDriver";

        String connectionUrl = null;
        if (serverMode) {
          connectionUrl = "jdbc:hsqldb:hsql://localhost:" + port
              + "/safi;hsqldb.default_table_type=cached";
        } else
          connectionUrl = "jdbc:hsqldb:hsql://" + host + ":" + port + "/safi";
        if (!connectionTest(driverName, connectionUrl))
          throw new DBManagerException("Couldn't connect to SafiServer at " + connectionUrl);
        dataStore = HbHelper.INSTANCE.createRegisterDataStore(dataStoreName);
        final Properties props = new Properties();
        // props.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
        // props.setProperty(Environment.USER, "root");
        // props.setProperty(Environment.PASS, "steely12");
        // props.setProperty(Environment.URL, "jdbc:mysql://127.0.0.1:3306/test");
        // props.setProperty(Environment.DIALECT,
        // org.hibernate.dialect.MySQLInnoDBDialect.class
        // .getName());
        props.setProperty(Environment.DRIVER, driverName);
        props.setProperty(Environment.USER, username);
        props.setProperty(Environment.PASS, password);

        props.setProperty(Environment.URL, connectionUrl);
        // props.setProperty(Environment.DIALECT,
        // org.hibernate.dialect.HSQLDialect.class.getName());
        props.setProperty(Environment.DIALECT, HSQLCachedTableDialect.class.getName());
        props.setProperty(TableHiLoGenerator.MAX_LO, "100");
        // props.setProperty(Environment.SHOW_SQL, "true");
        props.setProperty(PersistenceOptions.INHERITANCE_MAPPING, "TABLE_PER_CLASS");
        // props.setProperty(PersistenceOptions.CASCADE_POLICY_ON_CONTAINMENT,
        // "REMOVE,PERSIST,MERGE,REFRESH");
        // props.setProperty(PersistenceOptions.INHERITANCE_MAPPING, "JOINED");
        props.setProperty(PersistenceOptions.ALWAYS_MAP_LIST_AS_BAG, "true");
        // props.setProperty("SET_PROXY", "false");//does it do anything?
        // props.setProperty(PersistenceOptions.VERSION_COLUMN_NAME, "e_version");
        // props.setProperty(PersistenceOptions.FETCH_CONTAINMENT_EAGERLY, serverMode ?
        // "false"
        // : "true");

        props.setProperty("hibernate.connection.hsqldb.default_table_type", "cached");
        props.setProperty(PersistenceOptions.FETCH_CONTAINMENT_EAGERLY, "false");
        // props.setProperty(PersistenceOptions.ALWAYS_VERSION, "false");
        // props.setProperty(PersistenceOptions.OPTIMISTIC, "false");
        props.setProperty(PersistenceOptions.SET_CASCADE_ALL_ON_CONTAINMENT, "true");
        // props.setProperty(PersistenceOptions.SET_GENERATED_VALUE_ON_ID_FEATURE,
        // "false");
        // props.setProperty(PersistenceOptions.USE_MAPPING_FILE, "true");
        // Configure the EPackages used by this DataStore.
        // List<String> classes = new ArrayList<String>();
        // dataStore.setEPackageClasses(classes);
        dataStore.setEPackages(new EPackage[] { DbPackage.eINSTANCE, ConfigPackage.eINSTANCE });

        dataStore.setProperties(props);
        // Initialize the DataStore. This sets up the Hibernate mapping and
        // creates the corresponding tables in the database.
        dataStore.initialize();
      } catch (Exception e) {
        e.printStackTrace();
        if (dataStore != null) {
          try {
            HbHelper.INSTANCE.deRegisterDataStore(dataStoreName);
            dataStore.close();
          } catch (Exception ignore) {
          }
          dataStore = null;
        }
        throw new DBManagerException("Couldn't connect to database at " + host, e);
      }
      String xml = dataStore.getMappingXML();
      System.err.println(xml);
    }
    // if (!dataStore.isInitialized())
    // dataStore.initialize();
    // if (!initialized) {
    // final SessionFactory sessionFactory = dataStore.getSessionFactory();
    // Session session = sessionFactory.openSession();
    // initializeDB(session);
    // }

    final SessionFactory sessionFactory = dataStore.getSessionFactory();
    Session session = null;
    try {
      session = sessionFactory.openSession();
      if (session.isConnected() && session instanceof SessionImpl) {
        if (!((SessionImpl) session).getJDBCContext().getConnectionManager().isCurrentlyConnected()) {

        }
        try {

          Connection c = ((SessionImpl) session).getJDBCContext().getConnectionManager()
              .getConnection();
        } catch (Exception e) {
          e.printStackTrace();
          System.err.println("trying again...");
          try {
            ((SessionImpl) session).getJDBCContext().getConnectionManager().manualDisconnect();
          } catch (Exception ig) {
          }
          ((SessionImpl) session).getJDBCContext().getConnectionManager().manualReconnect();
        }
        // checkAliveness(c);
      }
      return session;
    } catch (Exception e) {
      if (session != null)
        try {
          session.close();
        } catch (Exception ignoramus) {
        }
      throw new DBManagerException(e);
    }
  }

  public void shutdown() {
    if (dataStore != null) {
      try {
        HbHelper.INSTANCE.deRegisterDataStore(DATASTORE_NAME);
      } catch (Exception ignore) {
      }
      try {
        dataStore.close();
      } catch (Exception ignore) {
      }
      dataStore = null;
    }
  }

  private void checkAliveness(Connection c) throws SQLException {
    if (c.isClosed())
      throw new SQLException("Conneciton is closed");
    Statement s = c.createStatement();
    s.close();
  }

  public void shutdownDatastore() {
    if (dataStore == null)
      return;
    try {
      dataStore.close();
    } catch (Exception e) {
    } finally {
      dataStore = null;
    }
  }

  long lastTry = -1;
  String lastDriver;
  String lastConnectionUrl;

  private boolean connectionTest(String driverName, String connectionUrl) {
    if (lastTry > 0 && StringUtils.equals(lastDriver, driverName)
        && StringUtils.equals(lastConnectionUrl, connectionUrl)
        && System.currentTimeMillis() - lastTry < 25000l){
      log.info("Last connection attempt occurred less than 25 seconds ago.  Ignoring request...");
      return false;
    }

    lastDriver = driverName;
    lastConnectionUrl = connectionUrl;

    Connection conn = null;
    try {
      Class.forName(driverName);
      DriverManager.setLoginTimeout(loginTimeout);
      conn = DriverManager.getConnection(connectionUrl, username, password);
      lastTry = -1;
      return true;
    } catch (Exception e) {
      lastTry = System.currentTimeMillis();
      log.error("Couldn't connect to SafiServer", e);
    } finally {
      if (conn != null)
        try {
          conn.close();
        } catch (Exception e) {
        }
    }
    return false;
  }
  
  public void resetLastConnectionAttempt(){
    lastTry = -1;
  }

  public void addTrigger(Trigger trigger, String tableName, String name) throws DBManagerException {
    Session session = createSession();
    try {
      SQLQuery qry = session.createSQLQuery("CREATE TRIGGER " + name + "_ins AFTER INSERT ON "
          + tableName + " FOR EACH ROW CALL \"" + trigger.getClass().getName() + "\"");
      qry.executeUpdate();
      qry = session.createSQLQuery("CREATE TRIGGER " + name + "_upd AFTER UPDATE ON " + tableName
          + " FOR EACH ROW CALL \"" + trigger.getClass().getName() + "\"");
      qry.executeUpdate();

      qry = session.createSQLQuery("CREATE TRIGGER " + name + "_delbefore BEFORE DELETE ON "
          + tableName + " FOR EACH ROW CALL \"" + trigger.getClass().getName() + "\"");
      qry.executeUpdate();

      qry = session.createSQLQuery("CREATE TRIGGER " + name + "_delafter AFTER DELETE ON "
          + tableName + " FOR EACH ROW CALL \"" + trigger.getClass().getName() + "\"");
      qry.executeUpdate();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public User getUserByUsername(String username) throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      List results = session.createCriteria(User.class).add(Restrictions.eq("name", username))
          .list();
      if (results != null && !results.isEmpty()) {
        return (User) results.get(0);
      }
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }

    return null;
  }

  @SuppressWarnings("unchecked")
  public List getUsers() throws DBManagerException {
    Session session = createSession();
    try {
      return session.createCriteria(User.class).list();

    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public void saveOrUpdateUser(User u) throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();

      session.saveOrUpdate(u);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }

  }

  public Prompt getPromptByName(String name) throws DBManagerException {
    Session session = createSession();
    try {
      List results = session.createCriteria(Prompt.class).add(Restrictions.eq("name", name)).list();
      if (results != null && !results.isEmpty()) {
        return (Prompt) results.get(0);
      }
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }

    return null;
  }

  public Prompt getPromptByName(Session session, String name) throws DBManagerException {
    try {
      List results = session.createCriteria(Prompt.class).add(Restrictions.eq("name", name)).list();
      if (results != null && !results.isEmpty()) {
        return (Prompt) results.get(0);
      }
    } catch (Exception e) {
      throw new DBManagerException(e);
    }

    return null;
  }

  public Prompt getPromptByID(int id) throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      return (Prompt) session.createCriteria(Prompt.class).add(Restrictions.eq("id", id))
          .uniqueResult();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }

  }

  public void saveSafiDriverManagerToDisk(SafiDriverManager manager) throws DBResourceException,
      IOException {
    Resource res = null;
    for (Resource r : dbResourceTable.values()) {

      if (!r.getContents().isEmpty() && manager == r.getContents().get(0)) {
        res = r;
        break;
      }
    }
    if (res == null)
      throw new DBResourceException("Couldn't find SafiDriverManager");
    res.setModified(true);
    res.save(null);
  }

  public DBResource updateDBResource(SafiDriverManager manager, DBResource resource)
      throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      List results = session.createCriteria(resource.getClass()).add(
          resource.getId() == -1 ? Restrictions.eq("name", resource.getName()) : Restrictions.eq(
              "id", resource.getId())).list();
      if (results != null && !results.isEmpty()) {
        DBResource loaded = (DBResource) results.get(0);
        if (loaded == null)
          return null;
        loaded = (DBResource) EcoreUtil.copy(loaded);
        // touchChildren(loaded, new Date());
        return loaded;
      } else
        return null;

    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  // not indictable offense in this case
  public static void touchChildren(DBResource loaded, Date date) {
    for (EObject next : loaded.eContents()) {
      if (next instanceof DBResource) {
        DBResource rez = (DBResource) next;
        // rez.setLastModified(date);
        if (date != null)
          rez.setLastUpdated(date);
        touchChildren(rez, date);
      }
    }
  }

  public void setSAPassword(String password, boolean updateUserObject) throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      Connection connection = ((SessionImpl) session).getJDBCContext().getConnectionManager()
          .getConnection();
      Statement stat = connection.createStatement();
      stat.execute("alter user 'sa' set password '" + password + "';");
      if (updateUserObject) {
        User sa = (User) session.createCriteria(User.class).add(Restrictions.eq("name", "sa"))
            .uniqueResult();
        sa.setPassword(password);

      }
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public DBResource saveDBResource(DBResource resource) throws ResourceModifiedException,
      DBManagerException, DBResourceException {
    Session session = createSession();
    try {
      session.beginTransaction();
      // if (true){
      // DBResource newone = (DBResource)session.merge(resource);
      // session.getTransaction().commit();
      // return newone;
      // }
      List results = session.createCriteria(resource.getClass()).add(
          resource.getId() == -1 ? Restrictions.eq("name", resource.getName()) : Restrictions.eq(
              "id", resource.getId())).list();
      DBResource savedResource = null;

      // object already exists in DB
      if (results != null && !results.isEmpty()) {
        DBResource oldRes = (DBResource) results.get(0);
        if (oldRes != resource && resource.getId() == -1) {
          throw new DBResourceException("Resource with name " + resource.getName()
              + " already exists in the database.  Please select a different name");
        }
        if (oldRes != resource
            && oldRes.getId() == -1
            && oldRes.getLastModified() != null
            && (resource.getLastUpdated() == null || oldRes.getLastModified().after(
                resource.getLastUpdated()))) {
          throw new ResourceModifiedException("Resource " + resource.getName()
              + " has been modified on the SafiServer since the last update");
        }
        if (oldRes != resource) {
          copyProperties(oldRes, resource, false);
        }
        session.saveOrUpdate(oldRes);
        savedResource = oldRes;

      } else {
        EObject obj = resource.eContainer();
        if (obj != null && obj instanceof DBResource) {
          DBResource parentRes = ((DBResource) obj);
          results = session.createCriteria(obj.getClass()).add(
              parentRes.getId() != -1 ? Restrictions.eq("id", parentRes.getId()) : Restrictions.eq(
                  "name", parentRes.getName())).list();
          boolean wasSaved = false;
          if (results.isEmpty()) { // parent hasn't been persisted
            parentRes = saveDBResource(parentRes);
            wasSaved = true;
            EReference ref = resource.eContainmentFeature();
            @SuppressWarnings("unchecked")
            List<Object> list = (List<Object>) parentRes.eGet(ref);
            for (Object o : list) {
              DBResource res = (DBResource) o;
              if (res.getClass().getName().equals(resource.getClass().getName())
                  && res.getName().equals(resource.getName())) {
                Date now = new Date();
                copyProperties(resource, res, true);
                touchChildren(resource, now);
                resource.setId(res.getId());
                resource.setLastUpdated(now);
                return res;
              }
            }
          } else
            parentRes = (DBResource) results.get(0);
          EReference ref = resource.eContainmentFeature();
          @SuppressWarnings("unchecked")
          List<Object> list = (List<Object>) parentRes.eGet(ref);
          // DBResource clonedRes = (DBResource) EcoreUtil.copy(resource);
          DBResource clonedRes = (DBResource) com.safi.db.DbFactory.eINSTANCE.create(resource
              .eClass());
          copyProperties(clonedRes, resource, false);
          list.add(clonedRes);
          session.saveOrUpdate(clonedRes);

          savedResource = clonedRes;
          if (!wasSaved)
            session.saveOrUpdate(parentRes);
          // resource.setId(clonedRes.getId());
        } else {
          throw new DBManagerException("Parent wasn't a DBResource.  This should never happen!");
          // session.saveOrUpdate(resource);
          // savedResource = resource;
        }
      }
      session.getTransaction().commit();
      if (savedResource != resource)
        resource.setId(savedResource.getId());
      Date now = new Date();
      resource.setLastUpdated(now);
      // resource.setLastModified(now);
      return savedResource;
    } catch (HibernateException e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }

  }

  public boolean saveDBResourceHierarchy(DBResource resource) throws IOException,
      ResourceModifiedException, DBResourceException, DBManagerException {
    boolean b = saveDBResourceHierarchy(resource, false);
    touchChildren(resource, new Date());
    return b;
  }

  public boolean saveDBResourceHierarchy(DBResource resource, boolean onlyIfNotPresent)
      throws IOException, ResourceModifiedException, DBResourceException, DBManagerException {

    // saveSafiDriverManagerToDisk(manager);
    if (saveParents(resource)) {
      Date now = new Date();
      // resource.setLastModified(now);
      resource.setLastUpdated(now);
      return true;
    }

    Session session = createSession();
    try {
      session.beginTransaction();
      List results = session.createCriteria(resource.getClass()).add(
          resource.getId() == -1 ? Restrictions.eq("name", resource.getName()) : Restrictions.eq(
              "id", resource.getId())).list();
      DBResource savedResource = null;
      if (results != null && !results.isEmpty()) {
        if (onlyIfNotPresent) { // parent was here already
          Date now = new Date();
          // resource.setLastModified(now);
          resource.setLastUpdated(now);
          return false;
        }
        DBResource existingRes = (DBResource) results.get(0);
        if (existingRes != resource
            && existingRes.getId() == -1
            && existingRes.getLastModified() != null
            && (resource.getLastUpdated() == null || existingRes.getLastModified().after(
                resource.getLastUpdated()))) {
          throw new ResourceModifiedException("Resource " + resource.getName()
              + " has been modified on the SafiServer since the last update");
        }
        if (existingRes != resource) {
          copyProperties(existingRes, resource);
        }
        session.saveOrUpdate(existingRes);
        savedResource = existingRes;

      } else {
        EObject obj = resource.eContainer();
        if (obj != null && obj instanceof DBResource) {
          DBResource parentRes = ((DBResource) obj);
          results = session.createCriteria(obj.getClass()).add(
              parentRes.getId() != -1 ? Restrictions.eq("id", parentRes.getId()) : Restrictions.eq(
                  "name", parentRes.getName())).list();
          if (results.isEmpty())
            throw new DBResourceException("Couldn't find or create parent for "
                + resource.getName());
          DBResource rez = (DBResource) results.get(0);
          EReference ref = resource.eContainmentFeature();
          @SuppressWarnings("unchecked")
          List<Object> list = (List<Object>) rez.eGet(ref);
          DBResource clonedRes = (DBResource) EcoreUtil.copy(resource);
          list.add(clonedRes);
          session.saveOrUpdate(clonedRes);
          savedResource = clonedRes;
          // resource.setId(clonedRes.getId());
        } else {
          session.saveOrUpdate(resource);
        }
      }
      session.getTransaction().commit();
      if (savedResource != null) {
        updateChildIds(savedResource, resource);
      }
      Date now = new Date();
      resource.setLastUpdated(now);
      // resource.setLastModified(now);

    } catch (HibernateException e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }

    return true;

  }

  private void updateChildIds(DBResource savedResource, DBResource resource) {
    // TODO Auto-generated method stub
    resource.setId(savedResource.getId());
    for (EObject o1 : resource.eContents()) {
      if (o1 instanceof DBResource) {
        DBResource oldRez = (DBResource) o1;

        DBResource existingRez = null;
        for (EObject o2 : savedResource.eContents()) {
          if (o2 instanceof DBResource && o2.getClass() == o1.getClass()) {

            DBResource savedRez = (DBResource) o2;
            if ((oldRez.getId() == savedRez.getId())
                || StringUtils.equals(oldRez.getName(), savedRez.getName())) {
              existingRez = savedRez;
              break;
            }
          }
        }
        if (existingRez != null) {
          oldRez.setId(existingRez.getId());
          updateChildIds(existingRez, oldRez);
        }

      }
    }
  }

  public void deleteDBResource(Session session, DBResource resource) throws IOException,
      ResourceModifiedException, DBResourceException, DBManagerException {

    deleteChildren(session, resource);
    try {
      EObject obj = resource.eContainer();
      if (obj != null && obj instanceof DBResource) {
        List results = session.createCriteria(obj.getClass()).add(
            Restrictions.eq("name", ((DBResource) obj).getName())).list();
        if (results.isEmpty())
          throw new DBResourceException("Couldn't find parent for " + resource.getName());
        DBResource parentRez = (DBResource) results.get(0);
        EReference ref = resource.eContainmentFeature();
        @SuppressWarnings("unchecked")
        List<Object> list = (List<Object>) parentRez.eGet(ref);
        DBResource persistedRes = null;
        for (Object o : list) {
          if (((DBResource) o).getName().equals(resource.getName())) {
            persistedRes = (DBResource) o;
            break;
          }
        }
        if (persistedRes != null) {
          list.remove(persistedRes);
          session.update(parentRez);
          session.delete(persistedRes);
        } else
          throw new DBResourceException("Resource " + resource.getName()
              + " couldn't be found on server");
      } else {

        List results = session.createCriteria(resource.getClass()).add(
            Restrictions.eq("name", resource.getName())).list();
        if (results != null && !results.isEmpty()) {
          DBResource oldRes = (DBResource) results.get(0);
          session.delete(oldRes);
        } else
          throw new DBResourceException("Resource " + resource.getName()
              + " couldn't be found on server");
      }
    } catch (HibernateException e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }

    return;

  }

  public void deleteDBResource(DBResource resource) throws IOException, ResourceModifiedException,
      DBResourceException, DBManagerException {

    deleteChildren(resource);
    Session session = createSession();
    try {
      session.beginTransaction();
      EObject obj = resource.eContainer();
      if (obj != null && obj instanceof DBResource) {
        List results = session.createCriteria(obj.getClass()).add(
            Restrictions.eq("name", ((DBResource) obj).getName())).list();
        if (results.isEmpty())
          throw new DBResourceException("Couldn't find parent for " + resource.getName());
        DBResource parentRez = (DBResource) results.get(0);
        EReference ref = resource.eContainmentFeature();
        @SuppressWarnings("unchecked")
        List<Object> list = (List<Object>) parentRez.eGet(ref);
        DBResource persistedRes = null;
        for (Object o : list) {
          if (((DBResource) o).getName().equals(resource.getName())) {
            persistedRes = (DBResource) o;
            break;
          }
        }
        if (persistedRes != null) {
          list.remove(persistedRes);
          session.update(parentRez);
          session.delete(persistedRes);
          session.getTransaction().commit();
        } else
          throw new DBResourceException("Resource " + resource.getName()
              + " couldn't be found on server");
      } else {

        List results = session.createCriteria(resource.getClass()).add(
            Restrictions.eq("name", resource.getName())).list();
        if (results != null && !results.isEmpty()) {
          DBResource oldRes = (DBResource) results.get(0);
          session.delete(oldRes);
          session.getTransaction().commit();
        } else
          throw new DBResourceException("Resource " + resource.getName()
              + " couldn't be found on server");
      }
    } catch (HibernateException e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }

    return;

  }

  protected void deleteChildren(Session session, DBResource resource) throws IOException,
      ResourceModifiedException, DBResourceException, DBManagerException {
    if (resource instanceof Query) {
      List<QueryParameter> params = ((Query) resource).getParameters();
      for (QueryParameter param : params) {
        deleteDBResource(session, param);
      }
    } else if (resource instanceof DBConnection) {
      List<Query> queries = ((DBConnection) resource).getQueries();
      for (Query q : queries) {
        deleteDBResource(session, q);
      }
    } else if (resource instanceof DBDriver) {
      List<DBConnection> conns = ((DBDriver) resource).getConnections();
      for (DBConnection conn : conns) {
        deleteDBResource(session, conn);
      }
    }

  }

  protected void deleteChildren(DBResource resource) throws IOException, ResourceModifiedException,
      DBResourceException, DBManagerException {
    if (resource instanceof Query) {
      List<QueryParameter> params = ((Query) resource).getParameters();
      for (QueryParameter param : params) {
        deleteDBResource(param);
      }
    } else if (resource instanceof DBConnection) {
      List<Query> queries = ((DBConnection) resource).getQueries();
      for (Query q : queries) {
        deleteDBResource(q);
      }
    } else if (resource instanceof DBDriver) {
      List<DBConnection> conns = ((DBDriver) resource).getConnections();
      for (DBConnection conn : conns) {
        deleteDBResource(conn);
      }
    }

  }

  protected boolean saveParents(DBResource resource) throws IOException, ResourceModifiedException,
      DBResourceException, DBManagerException {
    DBResource parent = getParentResource(resource);
    if (parent == null)
      return false;
    return saveDBResourceHierarchy(parent, true);
  }

  protected DBResource getParentResource(DBResource resource) {
    EObject obj = resource.eContainer();
    if (obj == null)
      return null;
    if (obj instanceof DBResource)
      return (DBResource) obj;
    return null;
  }

  public void copyProperties(DBResource to, DBResource from) throws DBManagerException {
    copyProperties(to, from, true);
  }

  public void copyProperties(DBResource to, DBResource from, boolean copyChildren)
      throws DBManagerException {
    // TODO Auto-generated method stub
    if (to == from) {
      return;
    }
    to.setName(from.getName());
    if (from.getId() != -1)
      to.setId(from.getId());
    if (to instanceof Query) {
      Query oldQ = (Query) to;
      Query newQ = (Query) from;
      
//      try {
//        BeanUtils.copyProperties(oldQ, newQ);
//      } catch (Exception e) {
//        e.printStackTrace();
//        throw new DBManagerException("Couldn't update query "+from.getName(), e);
//      } 
      
//      copyProps(to, from);
      oldQ.setLastModified(newQ.getLastModified());
      oldQ.setLastUpdated(newQ.getLastUpdated());
      oldQ.setQuerySql(newQ.getQuerySql());
      oldQ.setQueryType(newQ.getQueryType());
      oldQ.getParameters().clear();
      oldQ.setCatalog(newQ.getCatalog());
      
      for (QueryParameter p : newQ.getParameters()) {
        QueryParameter copy = (QueryParameter) EcoreUtil.copy(p);
        oldQ.getParameters().add(copy);
      }

    } else if (to instanceof DBConnection) {
      DBConnection existingConn = (DBConnection) to;
      DBConnection newConn = (DBConnection) from;
      existingConn.setAcquireIncrement(newConn.getAcquireIncrement());
      existingConn.setLastModified(newConn.getLastModified());
      existingConn.setLastUpdated(newConn.getLastUpdated());
      existingConn.setLoginTimeout(newConn.getLoginTimeout());
      existingConn.setMaxIdleTime(newConn.getMaxIdleTime());
      existingConn.setMaxPoolSize(newConn.getMaxPoolSize());
      existingConn.setMinPoolSize(newConn.getMinPoolSize());
      existingConn.setPassword(newConn.getPassword());
      existingConn.setProperties(newConn.getProperties());
      existingConn.setTransactionMode(newConn.getTransactionMode());
      existingConn.setUrl(newConn.getUrl());
      existingConn.setUser(newConn.getUser());

      if (copyChildren) {
        for (Query q : newConn.getQueries()) {
          Query existingQry = null;
          for (Query q2 : existingConn.getQueries()) {
            if (q == q2)
              continue;
            if (q.getId() == q2.getId()) {
              existingQry = q2;
            } else if (StringUtils.equals(q.getName(), q2.getName())) {
              throw new DBManagerException("Different child query exists with name " + q.getName()
                  + ". Choose a different name");
            }
          }
          if (existingQry == null)
            existingConn.getQueries().add((Query) EcoreUtil.copy(q));
          else {
            copyProperties(existingQry, q);
          }
        }
      }
    } else if (to instanceof DBDriver) {
      DBDriver existingDrv = (DBDriver) to;
      DBDriver newDrv = (DBDriver) from;
      existingDrv.setDefault(newDrv.isDefault());
      existingDrv.setDriverClassName(newDrv.getDriverClassName());
      existingDrv.setExampleUrl(newDrv.getExampleUrl());
      existingDrv.setGuideUrl(newDrv.getGuideUrl());
      existingDrv.setPooling(newDrv.isPooling());
      existingDrv.setWebsiteUrl(newDrv.getWebsiteUrl());
      existingDrv.setDefaultPort(newDrv.getDefaultPort());
      existingDrv.setUrlRegexPattern(newDrv.getUrlRegexPattern());
      if (copyChildren) {
        for (DBConnection c1 : newDrv.getConnections()) {
          DBConnection existingConn = null;
          for (DBConnection c2 : existingDrv.getConnections()) {
            if (c1 == c2)
              continue;
            if (c1.getId() == c2.getId()) {
              existingConn = c2;
            } else if (StringUtils.equals(c1.getName(), c2.getName())) {
              throw new DBManagerException("Different child database connection exists with name "
                  + c1.getName() + ". Choose a different name");
            }
          }
          if (existingConn == null)
            existingDrv.getConnections().add((DBConnection) EcoreUtil.copy(c1));
          else {
            copyProperties(existingConn, c1);
          }
        }

        // existingDrv.getConnections().clear();
        // for (DBConnection c : newDrv.getConnections()) {
        // existingDrv.getConnections().add((DBConnection) EcoreUtil.copy(c));
        // }
      }
    }
    return;

    // EcoreUtil.replace(resource, oldRes);
  }
  
  private void copyProps(EObject to, EObject from) throws DBManagerException{
    if (to.getClass() != from.getClass())
      throw new DBManagerException("Classes aren't the same");
    for (EStructuralFeature feat : to.eClass().getEAllStructuralFeatures()){
      if (log.isDebugEnabled()) log.debug("Setting property "+feat.getName()+" of "+to.getClass());
      to.eSet(feat, from.eGet(feat, true));
    }
  }

  public Saflet getSaflet(String projectName, String safletName) throws DBManagerException {
    Session session = createSession();
    try {
      org.hibernate.Query qry = session
          .createQuery("from com.safi.db.server.config.Saflet saflet where "
              + "saflet.name = :safletName and saflet.project.name = :projectName");
      qry.setString("safletName", safletName);
      qry.setString("projectName", projectName);

      List results = qry.list();
      if (results.isEmpty())
        throw new DBResourceException("Couldn't find saflet " + projectName + "/" + safletName);
      return (Saflet) results.get(0);
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public boolean initializeDB(Session session) throws DBManagerException {
    try {
      List results = null;
      try {
        results = session.createCriteria(DBDriver.class).list();
      } catch (Exception e) {
        e.printStackTrace();
      }
      if (results == null || results.isEmpty()) {
        // throw new DBResourceException("Couldn't find parent for " +
        // resource.getName());
        Connection connection = ((SessionImpl) session).getJDBCContext().getConnectionManager()
            .getConnection();
        // DatabaseMetaData meta = connection.getMetaData();
        // ResultSet set = meta.getTables(null, null, "saflet", null);
        // if (!set.next()) {
        Statement stat = connection.createStatement();
        //
        
        stat.execute("SET DATABASE SQL SIZE FALSE");
        stat.execute("create user safiadmin password 'password' ADMIN;");
        stat.execute("create index promptNameIndex on \"prompt\" (\"name\")");

        // stat.execute("create index promptDirNameIndex on \"promptdirectory\" (\"name\")");

        stat.execute("create index hostNameIndex on \"asteriskserver\" (\"hostname\")");

        stat.execute("create index safletNameIndex on \"saflet\" (\"name\")");

        stat.execute("create index projectNameIndex on \"safletproject\" (\"name\")");
        // if (!b) {
        // throw new DBManagerException("Couldn't create default admin user!");
        // }
        session.beginTransaction();
        loadDefaultDrivers();
        session.save(defaultDrivers);
        Date now = new Date();

        SafiServer server = ConfigFactory.eINSTANCE.createSafiServer();
        server.setName("Default");
        server.setBindIP(this.host);

        Role adminRole = ConfigFactory.eINSTANCE.createRole();
        adminRole.setName("Admin");
        adminRole.setDescription("Admin role");
        adminRole.setLastModified(now);
        session.save(adminRole);

        Role userRole = ConfigFactory.eINSTANCE.createRole();
        userRole.setName("User");
        userRole.setDescription("User role");
        userRole.setLastModified(now);
        session.save(userRole);

        Entitlement entitlement = ConfigFactory.eINSTANCE.createEntitlement();
        entitlement.setName(EntitlementUtils.ENTIT_RETRIEVE_SAFLETS);
        entitlement.setDescription("Retrieve privilege for Saflets");
        entitlement.setLastModified(now);
        adminRole.getEntitlements().add(entitlement);
        userRole.getEntitlements().add(entitlement);
        session.save(entitlement);

        entitlement = ConfigFactory.eINSTANCE.createEntitlement();
        entitlement.setName(EntitlementUtils.ENTIT_PUBLISH_SAFLETS);
        entitlement.setDescription("Confers ability to publish Saflets to SafiServer");
        entitlement.setLastModified(now);
        adminRole.getEntitlements().add(entitlement);
        session.save(entitlement);

        Entitlement retrieveDBEntitlement = ConfigFactory.eINSTANCE.createEntitlement();
        retrieveDBEntitlement.setName(EntitlementUtils.ENTIT_RETRIEVE_DB_RESOURCES);
        retrieveDBEntitlement
            .setDescription("Confers ability to retrieve database resources (Drivers, Connections, Queries) from SafiServer");
        retrieveDBEntitlement.setLastModified(now);
        adminRole.getEntitlements().add(retrieveDBEntitlement);
        session.save(retrieveDBEntitlement);

        Entitlement publishDBEntitlement = ConfigFactory.eINSTANCE.createEntitlement();
        publishDBEntitlement.setName(EntitlementUtils.ENTIT_PUBLISH_DB_RESOURCES);
        publishDBEntitlement
            .setDescription("Confers ability to publish database resources (Drivers, Connections, Queries) to SafiServer");
        publishDBEntitlement.setLastModified(now);
        adminRole.getEntitlements().add(publishDBEntitlement);
        session.save(publishDBEntitlement);

        Entitlement patchEntitlement = ConfigFactory.eINSTANCE.createEntitlement();
        patchEntitlement.setName(EntitlementUtils.ENTIT_UPDATE_SERVER);
        patchEntitlement
            .setDescription("Confers ability to patch the SafiServer with new ActionPaks or updated core libraries");
        patchEntitlement.setLastModified(now);
        adminRole.getEntitlements().add(patchEntitlement);
        session.save(patchEntitlement);

        Entitlement promptsEntitlement = ConfigFactory.eINSTANCE.createEntitlement();
        promptsEntitlement.setName(EntitlementUtils.ENTIT_MANAGE_PROMPTS);
        promptsEntitlement.setDescription("Confers ability to manage audio prompts");
        promptsEntitlement.setLastModified(now);
        adminRole.getEntitlements().add(promptsEntitlement);
        session.save(promptsEntitlement);

        Entitlement usersEntitlement = ConfigFactory.eINSTANCE.createEntitlement();
        usersEntitlement.setName(EntitlementUtils.ENTIT_MANAGE_USERS);
        usersEntitlement.setDescription("Confers ability to manage SafiServer users");
        usersEntitlement.setLastModified(now);
        adminRole.getEntitlements().add(usersEntitlement);
        session.save(usersEntitlement);

        Entitlement asteriskEntitlement = ConfigFactory.eINSTANCE.createEntitlement();
        asteriskEntitlement.setName(EntitlementUtils.ENTIT_MANAGE_ASTERISK_SERVERS);
        asteriskEntitlement
            .setDescription("Confers ability to manage Asterisk server instances on the SafiServer");
        asteriskEntitlement.setLastModified(now);
        adminRole.getEntitlements().add(asteriskEntitlement);
        session.save(asteriskEntitlement);

        User user = ConfigFactory.eINSTANCE.createUser();
        user.setName("safiadmin");
        user.setPassword("password");
        user.setFirstname("Admin");
        user.setDescription("Built-in administrative-level password.  "
            + "Use me to create other uses then delete me");

        user.setLastModified(now);
        user.getRoles().add(adminRole);
        server.getUsers().add(user);
        session.save(user);

        user = ConfigFactory.eINSTANCE.createUser();
        user.setName("sa");
        user.setPassword("");
        user.setFirstname("sa");
        user.setDescription("Built-in administrative-level password.  "
            + "Use me to create other uses then delete me");

        user.setLastModified(now);
        user.getRoles().add(adminRole);
        server.getUsers().add(user);
        session.save(user);

        // server.setUser(user);
        int portNum = -1;
        try {
          portNum = Integer.parseInt(this.serverPort);
        } catch (Exception ex) {
        }
        if (portNum != -1) {
          server.setPort(portNum);
        }

        server.setManagementPort(managementPort);
        server.setDescription("Safi Sever");
        session.save(server);

        session.getTransaction().commit();
        initialized = true;
        return true;
      } else {
        initialized = true;
        return false;
      }

    } catch (Exception e) {
      if (e instanceof DBManagerException)
        throw (DBManagerException) e;
      throw new DBManagerException(e);
    } /*
       * finally { session.close(); }
       */

  }

  public User getUser(String username, String password) throws DBManagerException {
    Session session = createSession();
    try {
      List results = session.createCriteria(User.class).add(Restrictions.eq("name", username)).add(
          Restrictions.eq("password", password)).list();
      if (results.isEmpty())
        throw new DBResourceException("Couldn't find user " + username);
      return (User) results.get(0);
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public SafletProject getSafletProject(Integer id) throws DBManagerException {
    Session session = createSession();
    try {
      return (SafletProject) session.createCriteria(SafletProject.class).add(
          Restrictions.eq("id", id)).uniqueResult();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public SafletProject getSafletProject(String name) throws DBManagerException {
    Session session = createSession();
    try {
      return (SafletProject) session.createCriteria(SafletProject.class).add(
          Restrictions.eq("name", name)).uniqueResult();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public SafletProject getSafletProject(Session session, String name) throws DBManagerException {
    try {
      return (SafletProject) session.createCriteria(SafletProject.class).add(
          Restrictions.eq("name", name)).uniqueResult();
    } catch (Exception e) {
      throw new DBManagerException(e);
    }
  }

  public List<Saflet> getSaflets(SafletProject project) throws DBManagerException {
    Session session = createSession();
    try {
      session.lock(project, LockMode.NONE);
      for (Saflet s : project.getSaflets())
        s.getName();

      return (List<Saflet>) project.getSaflets();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public ResourceSet getResourceLoader() {

    if (resourceLoader == null) {
      resourceLoader = new ResourceSetImpl();
      // Register XML resource factory
      XMIResourceFactoryImpl resourceFactoryImpl = new XMIResourceFactoryImpl();

      resourceLoader.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*",
          resourceFactoryImpl);
      DbPackage dbPkg = DbPackage.eINSTANCE;
      resourceLoader.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
    }
    return resourceLoader;
  }

  public SafiDriverManager loadSafiDriverManager(String path, boolean cache) throws IOException {
    SafiDriverManager safiDriverManager = null;
    File file = new File(path);
    if (file.exists()) {
      URI uri = URI.createFileURI(file.getAbsolutePath());
      if (cache)
        unloadSet(getResourceLoader());

      Resource dbResource = getResourceLoader().getResource(uri, true);
      if (dbResource != null) {
        List<EObject> contents = dbResource.getContents();
        if (contents != null && contents.size() >= 1) {
          EObject obj = contents.get(0);
          if (obj instanceof SafiDriverManager) {
            safiDriverManager = (SafiDriverManager) obj;
            if (cache)
              dbResourceTable.put(path, dbResource);
          }
        }
      }

    } else {
      if (defaultDrivers == null)
        loadDefaultDrivers();
      URI uri = URI.createFileURI(file.getAbsolutePath());
      Resource r = getResourceLoader().createResource(uri);
      safiDriverManager = (SafiDriverManager) EcoreUtil.copy(defaultDrivers);
      r.getContents().add(safiDriverManager);
      if (cache)
        dbResourceTable.put(path, r);
      try {
        r.save(null);
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    // TODO Auto-generated method stub
    return safiDriverManager;
  }

  protected void loadDefaultDrivers() throws IOException {
    XMLResourceImpl res = new XMLResourceImpl();
    DbPackage dbPkg = DbPackage.eINSTANCE;
    Map<String, Object> options = new HashMap<String, Object>();
    options.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
    // options.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
    res.doLoad(DBManager.class.getResourceAsStream("/defaultDrivers.db"), options);
    defaultDrivers = (SafiDriverManager) res.getContents().get(0);
    Date now = new Date();
    for (DBDriver d : defaultDrivers.getDrivers()) {
      d.setLastUpdated(now);
    }

  }

  // serverside only
  public SafiDriverManager getDriverManagerFromDB() throws DBManagerException {
    Session session = createSession();
    try {

      SafiDriverManager mgr = (SafiDriverManager) session.createCriteria(SafiDriverManager.class)
          .uniqueResult();
      // touchChildren(mgr, null);
      return mgr;
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public SafiDriverManager getDriverManagerFromDB(Session session) throws DBManagerException {
    try {

      SafiDriverManager mgr = (SafiDriverManager) session.createCriteria(SafiDriverManager.class)
          .uniqueResult();
      return mgr;
    } catch (Exception e) {
      throw new DBManagerException(e);
    }
  }

  // serverside only
  public synchronized void reloadDriverManagerFromDB() throws DBManagerException {
    Session session = createSession();
    try {
      serverDriverManager = (SafiDriverManager) session.createCriteria(SafiDriverManager.class)
          .uniqueResult();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public SafiServer getSafiServerConfig(Integer id) throws DBManagerException {
    Session session = createSession();
    try {

      if (id >= 0)
        return (SafiServer) session.createCriteria(SafiServer.class).add(Restrictions.eq("id", id))
            .uniqueResult();
      else {
        List results = session.createCriteria(SafiServer.class).list();
        if (results.isEmpty())
          return null;
        return (SafiServer) results.get(0);
      }
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public AsteriskServer getAsteriskServerConfig(Integer id) throws DBManagerException {
    Session session = createSession();
    try {
      return (AsteriskServer) session.createCriteria(AsteriskServer.class).add(
          Restrictions.eq("id", id)).uniqueResult();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public List<AsteriskServer> getAsteriskServers() throws DBManagerException {
    Session session = createSession();
    try {
      return (List<AsteriskServer>) session.createCriteria(AsteriskServer.class).list();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public List<SafletProject> getProjects() throws DBManagerException {
    Session session = createSession();
    try {
      return (List<SafletProject>) session.createCriteria(SafletProject.class).setFetchMode(
          "saflets", FetchMode.SELECT).list();

    } catch (Exception ex) {
      throw new DBManagerException(ex);
    } finally {
      session.close();
    }
  }

  public String getSafletCode(int safletId) throws DBManagerException {
    Session session = createSession();
    try {
      org.hibernate.Query q = session.createQuery("select s.code from Saflet s where s.id=:id");
      q.setInteger("id", safletId);
      Object o = q.uniqueResult();
      return (String) o;
    } catch (Exception ex) {
      throw new DBManagerException(ex);
    } finally {
      session.close();
    }
  }

  public AsteriskServer getAsteriskServerConfigByIp(String ip) throws DBManagerException {
    Session session = createSession();
    try {
      return (AsteriskServer) session.createCriteria(AsteriskServer.class).add(
          Restrictions.eq("hostname", ip)).uniqueResult();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public void saveOrUpdateServerResource(ServerResource resource) throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      session.saveOrUpdate(resource);
      session.getTransaction().commit();
    } catch (StaleObjectStateException e) {

      try {
        session.getTransaction().rollback();
        session.beginTransaction();
        session.merge(resource);
        session.getTransaction().commit();
        return;
      } catch (Exception ex) {
        Transaction t = session.getTransaction();
        if (t != null)
          t.rollback();
        throw new DBManagerException(ex);
      }
    } finally {
      session.close();
    }
  }

  public void saveOrUpdateServerResource(Session session, ServerResource resource)
      throws DBManagerException {
    try {
      if (resource.getId() == -1)
        session.saveOrUpdate(resource);
      else {
        Object obj = null;
        try {
          obj = session.get(resource.getClass(), resource.getId());
        } catch (MappingException hme) {
          hme.printStackTrace();
        }
        if (obj != null)
          session.merge(resource);
        else
          session.saveOrUpdate(resource);
      }
    } catch (StaleObjectStateException e) {
      try {
        session.merge(resource);
        return;
      } catch (Exception ex) {
        throw new DBManagerException(ex);
      }
    }

    // try {
    // session.saveOrUpdate(resource);
    // } catch (Exception e) {
    // throw new DBManagerException(e);
    // }
  }

  public void deleteServerResource(Session session, ServerResource resource)
      throws DBManagerException {
    try {
      session.delete(resource);
    } catch (Exception e) {
      throw new DBManagerException(e);
    }
  }

  public List<Prompt> getProjectPrompts(SafletProject project) throws DBManagerException {
    Session session = createSession();
    try {
      session.lock(project, LockMode.NONE);

      List<Prompt> prompts = project.getPrompts();
      boolean changed = false;
      for (Iterator<Prompt> iter = prompts.iterator(); iter.hasNext();) {
        Prompt p = iter.next();
        if (p != null)
          p.getProject();
        else {
          changed = true;
          iter.remove();
        }
      }
      if (changed) {
        session.save(project);
      }
      // for (Prompt p : prompts) {
      // try {
      // p.getProject();// just load them
      // } catch (Exception e) {
      // log.error("Couldn't load project for prompt ", e);
      // }
      // }

      // for (Prompt p : todelete){
      // session.delete(p);
      // }
      return prompts;
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public List<Prompt> getPrompts() throws DBManagerException {
    Session session = createSession();
    try {
      return (List<Prompt>) session.createCriteria(Prompt.class).list();
    } catch (Exception ex) {
      throw new DBManagerException(ex);
    } finally {
      session.close();
    }
  }

  public void delete(Prompt p) throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      session.delete(p);
      session.getTransaction().commit();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public void delete(Session session, Prompt p) throws DBManagerException {
    try {
      session.delete(p);
    } catch (Exception e) {
      throw new DBManagerException(e);
    }
  }

  public List<Prompt> getSharedPrompts() throws DBManagerException {
    Session session = createSession();
    try {
      return (List<Prompt>) session.createCriteria(Prompt.class)
          .add(Restrictions.isNull("project")).setFetchMode("promptDirectories", FetchMode.SELECT)
          .list();
    } catch (Exception ex) {
      throw new DBManagerException(ex);
    } finally {
      session.close();
    }
  }

  public List<Variable> getGlobalVariables() throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      return session.createCriteria(Variable.class).list();
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      try {
        session.getTransaction().commit();
      } catch (HibernateException e) {
        throw new DBManagerException(e);
      } finally {
        session.close();
      }
    }
  }

  public void setGlobalVariables(List<Variable> vars) throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      for (Variable v : vars)
        session.delete(v);
      for (Variable v : vars)
        session.saveOrUpdate(v);
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      try {
        session.getTransaction().commit();
      } catch (HibernateException e) {
        throw new DBManagerException(e);
      } finally {
        session.close();
      }
    }
  }

  public void addGlobalVariable(Variable var) throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      ((SessionImpl) session).save(null, var, var.getName());
      // session.save(var);
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      try {
        session.getTransaction().commit();
      } catch (HibernateException e) {
        throw new DBManagerException(e);
      } finally {
        session.close();
      }
    }
  }

  @SuppressWarnings("unchecked")
  public String getUniqueGlobalVariableName(String prefix) throws DBManagerException {
    Session session = createSession();
    try {
      List<Variable> vars = session.createCriteria(Variable.class).list();
      int i = 0;
      while (true) {
        String candidateName = (++i == 1 ? prefix : (prefix + i));
        boolean collision = false;
        for (Variable v : vars) {
          if ((candidateName).equals(v.getName())) {
            collision = true;
            break;
          }
        }
        if (collision)
          continue;
        return candidateName;
      }

    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
  }

  public Variable changeGlobalVariableName(Variable variable, String newName)
      throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      Variable v = (Variable) session.createCriteria(Variable.class).add(
          Restrictions.eq("name", newName)).uniqueResult();
      if (v != null)
        throw new DBManagerException("Name collision: global variable with name " + newName
            + " already exists");
      
      variable.setName(newName);
      session.save(variable);
      return variable;
//      Variable v2 = (Variable) session.createCriteria(Variable.class).add(
//          Restrictions.eq("name", variable.getName())).uniqueResult();
//      if (v2 != null){
//        v2.setName(newName);
//      }
//      session.save(v2);
      
//      session.delete(variable);
//      Variable v2 = DbFactory.eINSTANCE.createVariable();
//      v2.setName(newName);
//      v2.setDefaultValue(variable.getDefaultValue());
//      v2.setScope(VariableScope.GLOBAL);
//      v2.setType(variable.getType());
//      session.save(v2);
//      return v2;
    } catch (Exception e) {
      if (e instanceof DBManagerException)
        throw (DBManagerException) e;
      throw new DBManagerException(e);
    } finally {
      try {
        session.getTransaction().commit();
      } catch (HibernateException e) {
        throw new DBManagerException(e);
      } finally {
        session.close();
      }
    }

  }

  public Variable getGlobalVariable(String name) throws DBManagerException {
    Session session = createSession();
    try {
      return (Variable) session.createCriteria(Variable.class).add(Restrictions.eq("name", name))
          .uniqueResult();
    } catch (Exception e) {
      if (e instanceof DBManagerException)
        throw (DBManagerException) e;
      throw new DBManagerException(e);
    } finally {
      session.close();
    }

  }

  public synchronized void saveOrUpdateGlobalVariable(Variable var) throws DBManagerException {
    Session session = createSession();
//    try {
//      session.beginTransaction();
//      session.saveOrUpdate(var);
//      
//    } catch (Exception e) {
//      throw new DBManagerException(e);
//    } finally {
//      try {
//        session.getTransaction().commit();
//      } catch (HibernateException e) {
//        throw new DBManagerException(e);
//      } finally {
//        session.close();
//      }
//    }
    
    try {
//      session.lock(var, LockMode.READ);
      session.beginTransaction();
      session.saveOrUpdate(var);
      session.getTransaction().commit();
//    } catch (StaleObjectStateException e) {
    } catch (Exception e) {
      try {
        session.getTransaction().rollback();
        session.beginTransaction();
        session.clear();
        Variable newvar = (Variable)session.createCriteria(Variable.class).add(Restrictions.eq("name", var.getName())).uniqueResult();
//        Variable newvar = (Variable)session.get(Variable.class, var.getName());
        if (newvar != null){
          newvar.setDefaultValue(var.getDefaultValue());
          newvar.setType(var.getType());
          session.update(newvar);
        }
        
        session.getTransaction().commit();
        return;
      } catch (Exception ex) {
        Transaction t = session.getTransaction();
        if (t != null)
          t.rollback();
        throw new DBManagerException(ex);
      }
    } finally {
      session.close();
    }
  }

  public void deleteGlobalVariable(Variable var) throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      session.delete(var);
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      try {
        session.getTransaction().commit();
      } catch (HibernateException e) {
        throw new DBManagerException(e);
      } finally {
        session.close();
      }
    }
  }

  public SafletProject getProjectByName(String name) throws DBManagerException {
    Session session = createSession();
    try {
      return (SafletProject) session.createCriteria(SafletProject.class).add(
          Restrictions.eq("name", name)).setFetchMode("prompts", FetchMode.SELECT).uniqueResult();
    } catch (Exception ex) {
      throw new DBManagerException(ex);
    } finally {
      session.close();
    }
  }

  public List<String> getPromptNames() throws DBManagerException {
    Session session = null;
    Statement stat = null;
    try {
      session = createSession();
      Connection c = ((SessionImpl) session).getJDBCContext().getConnectionManager()
          .getConnection();
      stat = c.createStatement();
      ResultSet rs = stat
          .executeQuery("select distinct \"name\" from \"prompt\" order by \"name\" asc");
      List<String> cats = new ArrayList<String>();
      while (rs.next()) {
        cats.add(rs.getString(1));
      }
      return cats;
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      if (session != null)
        try {
          session.close();
        } catch (Exception e) {
        }
      if (stat != null) {
        try {
          stat.close();
        } catch (Exception e) {
        }
      }
    }
  }

  public List<String> getProjectNames() throws DBManagerException {
    Session session = null;
    Statement stat = null;
    try {
      session = createSession();
      Connection c = ((SessionImpl) session).getJDBCContext().getConnectionManager()
          .getConnection();
      stat = c.createStatement();
      ResultSet rs = stat
          .executeQuery("select \"name\" from \"safletproject\" order by \"name\" asc");
      List<String> cats = new ArrayList<String>();
      while (rs.next()) {
        cats.add(rs.getString(1));
      }
      return cats;
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      if (session != null)
        try {
          session.close();
        } catch (Exception e) {
        }
      if (stat != null) {
        try {
          stat.close();
        } catch (Exception e) {
        }
      }
    }
  }

  public List<String> getProjectPromptNames() throws DBManagerException {
    return getPromptNames(true);
  }

  public List<String> getSharedPromptNames() throws DBManagerException {
    return getPromptNames(false);
  }

  public List<String> getPromptNames(boolean project) throws DBManagerException {
    Session session = null;
    Statement stat = null;
    try {
      session = createSession();
      Connection c = ((SessionImpl) session).getJDBCContext().getConnectionManager()
          .getConnection();
      stat = c.createStatement();
      ResultSet rs = stat.executeQuery("select distinct \"name\" from \"prompt\" where "
          + "\"prompt_project_id\" is " + (project ? "not null" : "null")
          + " order by \"name\" asc");
      List<String> cats = new ArrayList<String>();
      while (rs.next()) {
        cats.add(rs.getString(1));
      }
      return cats;
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      if (session != null)
        try {
          session.close();
        } catch (Exception e) {
        }
      if (stat != null) {
        try {
          stat.close();
        } catch (Exception e) {
        }
      }
    }
  }

  public List<String> getPromptNamesLike(String prefix, boolean project) throws DBManagerException {
    Session session = null;
    Statement stat = null;
    try {
      session = createSession();
      Connection c = ((SessionImpl) session).getJDBCContext().getConnectionManager()
          .getConnection();
      stat = c.createStatement();
      ResultSet rs = stat.executeQuery("select distinct \"name\" from \"prompt\" where "
          + "\"safletproject_project_id\" is " + (project ? "null" : "not null") + " and "
          + "\"name\" like '" + prefix + "%' order by \"name\" asc");
      List<String> cats = new ArrayList<String>();
      while (rs.next()) {
        cats.add(rs.getString(1));
      }
      return cats;
    } catch (Exception e) {
      throw new DBManagerException(e);
    } finally {
      if (session != null)
        try {
          session.close();
        } catch (Exception e) {
        }
      if (stat != null) {
        try {
          stat.close();
        } catch (Exception e) {
        }
      }
    }
  }

  // public String getPromptPath(String name, Integer id) throws DBManagerException{
  // Session session = null;
  // Statement stat = null;
  // try {
  //      
  // session = createSession();
  //      
  // Connection c = ((SessionImpl) session).getJDBCContext().getConnectionManager()
  // .getConnection();
  // stat = c.createStatement();
  // ResultSet rs = stat.executeQuery("select pd.\"name\" from \"promptdirectory\" pd " +
  // "inner join \"promptdirectory_prompts\" pdp on pd.\"id\"=pdp.\"promptdirectory_id\" "
  // +
  // "where pd.\"promptdirectory_asteriskserver_id\"="+id+" and pdp.\"prompt_id\" in " +
  // " (select p.\"id\" p from \"prompt\" p where p.\"name\"='"+id+"')");
  // if (rs.next()){
  // String dir = rs.getString(1);
  // if (dir == null) return null;
  // return dir + (dir.endsWith("/") ? "" : '/')+name;
  // }
  // return null;
  // } catch (Exception e) {
  // throw new DBManagerException(e);
  // } finally {
  // if (session != null)
  // try {
  // session.close();
  // } catch (Exception e) {
  // }
  // if (stat != null) {
  // try {
  // stat.close();
  // } catch (Exception e) {
  // }
  // }
  // }
  // }

  public Object merge(Object resource) throws DBManagerException {
    Session session = createSession();
    try {
      session.beginTransaction();
      resource = session.merge(resource);
      session.getTransaction().commit();
    } catch (Exception e) {
      if (session.getTransaction() != null)
        session.getTransaction().rollback();
      throw new DBManagerException(e);
    } finally {
      session.close();
    }
    return resource;
  }

  protected void unloadSet(ResourceSet resourceLoader) {
    for (Resource r : resourceLoader.getResources()) {
      r.unload();
    }
    resourceLoader.getResources().clear();

  }

  public static String constuctDBResourceId(DBResource resource) {
    if (resource instanceof DBConnection)
      return constructConnectionId((DBConnection) resource);
    if (resource instanceof DBDriver)
      return resource.getName();
    if (resource instanceof Query)
      return constructQueryId((Query) resource);
    if (resource instanceof QueryParameter)
      return constructQueryParamId((QueryParameter) resource);
    return null;
  }

  public static String constructConnectionId(DBConnection conn) {
    if (conn.getDriver() == null) return null;
    StringBuffer buf = new StringBuffer(conn.getDriver().getName());
    buf.append('.').append(conn.getName());
    return buf.toString();
  }

  public static String constructQueryId(Query qry) {
    if (qry.getConnection() == null)
      return null;
    final String constructConnectionId = constructConnectionId(qry.getConnection());
    if (constructConnectionId == null)
      return null;
    StringBuffer buf = new StringBuffer(constructConnectionId);
    buf.append('.').append(qry.getName());
    return buf.toString();
  }

  public static String constructQueryParamId(QueryParameter param) {
    if (param.getQuery() == null)
      return null;
    final String queryId = constructQueryId(param.getQuery());
    if (queryId == null)
      return null;
    StringBuffer buf = new StringBuffer(queryId);
    buf.append('.').append(param.getName());
    return buf.toString();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username, boolean restartDatastore) {
    if (StringUtils.equals(this.username, username))
      return;
    this.username = username;
    if (restartDatastore)
      shutdownDatastore();
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password, boolean restart) {
    if (StringUtils.equals(this.password, password))
      return;
    this.password = password;
    if (restart)
      shutdownDatastore();
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host, boolean restartDatastore) {
    if (StringUtils.equals(this.host, host))
      return;
    this.host = host;
    if (restartDatastore)
      shutdownDatastore();
  }

  public boolean isInitialized() {
    return initialized;
  }

  public void setInitialized(boolean initialized) {
    this.initialized = initialized;
  }

  public boolean isServerMode() {
    return serverMode;
  }

  public void setServerMode(boolean serverMode) {
    this.serverMode = serverMode;
  }

  public void setServerPort(String portNumber) {
    // TODO Auto-generated method stub
    this.serverPort = portNumber;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port, boolean restartDatastore) {
    if (this.port == port)
      return;
    this.port = port;
    if (restartDatastore)
      shutdownDatastore();
  }

  public int getManagementPort() {
    return managementPort;
  }

  public void setManagementPort(int managementPort) {
    this.managementPort = managementPort;
  }

  public int getLoginTimeout() {
    return loginTimeout;
  }

  public void setLoginTimeout(int loginTimeout) {
    this.loginTimeout = loginTimeout;
  }

}
