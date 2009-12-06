package com.safi.workshop.sqlexplorer.dbproduct;

import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.squirrel_sql.fw.id.IIdentifier;
import net.sourceforge.squirrel_sql.fw.persist.ValidationException;
import net.sourceforge.squirrel_sql.fw.sql.ISQLDriver;
import net.sourceforge.squirrel_sql.fw.util.beanwrapper.StringWrapper;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Element;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;
import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;

import com.safi.db.DBDriver;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.util.Utils;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.SQLCannotConnectException;

/**
 * Manages a JDBC Driver
 * 
 * @author John Spackman
 */
public class ManagedDriver implements Comparable<ManagedDriver>, IAdaptable {

  // public final static String REGEX_PATT_JDBC_URL =
  // "^[a-zA-Z0-9\\-_]+(?:\\:[a-zA-Z0-9\\-_]+){0,6}:\\W*(?:([a-zA-Z0-9\\-\\.]+)|(?:(?:\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(?:\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(?:\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(?:\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])))(?:\\:([0-9]+))?(?:\\W[a-zA-Z0-9\\-\\._\\?\\,\\'/\\\\\\+&amp;%\\$#\\=~]*)?$";

  public class SQLDriver implements ISQLDriver {

    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }

    public void assignFrom(ISQLDriver rhs) throws ValidationException {
      throw new ValidationException("Not supported");
    }

    public int compareTo(ISQLDriver rhs) {
      return ManagedDriver.this.getDriverClassName().compareTo(rhs.getDriverClassName());
    }

    public String getDriverClassName() {
      return ManagedDriver.this.getDriverClassName();
    }

    public IIdentifier getIdentifier() {
      return null;
    }

    public String getJarFileName() {
      return null;
    }

    public String[] getJarFileNames() {
      return (String[]) ManagedDriver.this.getJars().toArray();
    }

    public StringWrapper getJarFileNameWrapper(int idx) throws ArrayIndexOutOfBoundsException {
      return null;
    }

    public StringWrapper[] getJarFileNameWrappers() {
      return null;
    }

    public String getName() {
      return ManagedDriver.this.getDriverClassName();
    }

    public String getUrl() {
      return ManagedDriver.this.getUrl();
    }

    public String getWebSiteUrl() {
      return null;
    }

    public boolean isJDBCDriverClassLoaded() {
      return ManagedDriver.this.isDriverClassLoaded();
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
    }

    public void setDriverClassName(String driverClassName) throws ValidationException {
    }

    public void setJarFileName(String value) throws ValidationException {
    }

    public void setJarFileNames(String[] values) {
    }

    public void setJarFileNameWrapper(int idx, StringWrapper value)
        throws ArrayIndexOutOfBoundsException {
    }

    public void setJarFileNameWrappers(StringWrapper[] value) {
    }

    public void setJDBCDriverClassLoaded(boolean cl) {
    }

    public void setName(String name) throws ValidationException {
    }

    public void setUrl(String url) throws ValidationException {
    }

    public void setWebSiteUrl(String url) throws ValidationException {
    }
  }

  private String id;
  private String driverClassName;
  private String url;
  private LinkedList<String> jars = new LinkedList<String>();
  private Driver jdbcDriver;
  private DBDriver driver;
  private int defaultPort;
  private String guideUrl;
  private String urlRegexPattern;
  private Map<Integer, Integer> tunnelledPortMap = new HashMap<Integer, Integer>();

  public ManagedDriver(String id) {
    this.id = id;
  }

  public ManagedDriver(DBDriver driver) {
    this.driver = driver;
    id = driver.getName();
    driverClassName = driver.getDriverClassName();
    url = driver.getExampleUrl();
    jars.addAll(driver.getJars());
    defaultPort = driver.getDefaultPort();
    guideUrl = driver.getGuideUrl();
    urlRegexPattern = driver.getUrlRegexPattern();
  }

  /**
   * Constructs a new ManagedDriver from a previously serialised version
   * 
   * @param root
   *          result of previous call to describeAsXml()
   */
  public ManagedDriver(Element root) {
    super();
    id = root.attributeValue(DriverManager.ID);
    driverClassName = root.elementText(DriverManager.DRIVER_CLASS);
    url = root.elementText(DriverManager.URL);
    Element jarsElem = root.element(DriverManager.JARS);
    List<Element> list = jarsElem.elements();
    if (list != null)
      for (Element jarElem : list) {
        String jar = jarElem.getTextTrim();
        if (jar != null)
          jars.add(jar);
      }
  }

  /**
   * Describes this driver in XML; the result can be passed to the constructor to
   * refabricate it late
   * 
   * @return
   */
  // public Element describeAsXml() {
  // Element root = new DefaultElement(DriverManager.DRIVER);
  // root.addAttribute(DriverManager.ID, id);
  // root.addElement(DriverManager.NAME).setText(name);
  // if (driverClassName != null)
  // root.addElement(DriverManager.DRIVER_CLASS).setText(driverClassName);
  // root.addElement(DriverManager.URL).setText(url);
  // Element jarsElem = root.addElement(DriverManager.JARS);
  // for (String jar : jars)
  // jarsElem.addElement(DriverManager.JAR).setText(jar);
  // return root;
  // }
  /**
   * Loads the Driver class
   * 
   * @throws ExplorerException
   * @throws SQLException
   */
  public synchronized void registerSQLDriver() throws ClassNotFoundException {
    if (driverClassName == null || driverClassName.length() == 0)
      return;
    unregisterSQLDriver();
    jdbcDriver = DatabaseProductFactory.loadDriver(this);
  }

  /**
   * Unloads the class
   * 
   */
  public void unregisterSQLDriver() {
    jdbcDriver = null;
  }

  /**
   * Establishes a JDBC connection
   * 
   * @param user
   * @return
   * @throws ExplorerException
   * @throws SQLException
   */
  public SQLConnection getConnection(User user) throws SQLException {
    Properties props = new Properties();
    if (user.getUserName() != null)
      props.put("user", user.getUserName());
    if (user.getPassword() != null)
      props.put("password", user.getPassword());

    Connection jdbcConn = null;

    try {
      jdbcConn = getJDBCConnection(user.getAlias().getUrl(), props);
    } catch (SQLException e) {
      throw e;
    } catch (Exception e) {
      throw new SQLCannotConnectException(user, e);
    }

    if (jdbcConn == null)
      throw new SQLCannotConnectException(user);

    return new SQLConnection(user, jdbcConn, this, getDatabaseProduct()
        .describeConnection(jdbcConn));
  }

  public Connection getJDBCConnection(String url, Properties props) throws Exception {
    Connection jdbcConn = null;
    if (!isDriverClassLoaded())
      try {
        registerSQLDriver();
      } catch (ClassNotFoundException e) {
        throw new SQLException(
            "Cannot load JDBC driver "
                + driverClassName
                + " because the class cannot be found; please check the classpath in Preferences -> SQL Explorer -> JDBC Drivers ");
      }
    if (!isDriverClassLoaded())
      throw new SQLException("Cannot load JDBC driver " + driverClassName);

    if (SafiServerPlugin.getDefault().isUseTunnel()) {

      java.util.regex.Pattern p = Pattern.compile(getDriver().getUrlRegexPattern());
      System.err.println("URL is " + url);
      Matcher m = p.matcher(url);
      int port = defaultPort;

      if (m.matches() && m.groupCount() >= 2) {
        String portString = m.group(2);
        String addr = m.group(1);

        // InetAddress iaddr = InetAddress.getByName(addr);
        // if (iaddr.isReachable(5000)){
        // port = -1;
        // }
        // if (iaddr.isSiteLocalAddress() || iaddr.isAnyLocalAddress() ||
        // iaddr.isLinkLocalAddress() || iaddr.isLoopbackAddress()){
        // port = -1;
        // }
        // else
        if (StringUtils.isNotBlank(portString)) {
          try {
            port = Integer.parseInt(portString.trim());

          } catch (NumberFormatException e) {
            e.printStackTrace();
            port = defaultPort;
          }
        }

      }

      if (m.matches()) {
        Integer tunnelledPort = this.tunnelledPortMap.get(port);

        if (tunnelledPort == null && m.matches()) {
          tunnelledPort = Utils.findFreePort();
          this.tunnelledPortMap.put(port, tunnelledPort);
        }
        else {
        	int oldPort = tunnelledPort;
        	tunnelledPort = SafiServerPlugin.getDefault().updateForwardedPortIfNecessary(tunnelledPort);
        	if (oldPort != tunnelledPort)
        	{
        		tunnelledPortMap.put(port, tunnelledPort);
        	}
        }

        String dbhost = url.substring(m.start(1), m.end(1));
        if (tunnelledPort != -1) {
          url = constructNewURL(url, m, tunnelledPort);
          System.err.println("tunnelled URL is " + url);
        }
        if (tunnelledPort > 0 && !SafiServerPlugin.getDefault().isLocalPortForwarded(tunnelledPort)) {
          SafiServerPlugin.getDefault().addTunnel(tunnelledPort, port, dbhost);
        }
      }
    }

    jdbcConn = jdbcDriver.connect(url, props);
    return jdbcConn;
  }

  private String constructNewURL(String url, Matcher m, int tunnelledPort2) {
    StringBuffer buf = new StringBuffer(url);
    String portString;
    String addr = m.group(1);
    if (m.groupCount() >= 2) {
      portString = m.group(2);
      if (StringUtils.isNotBlank(portString)) {
        int start = m.start(2);
        int end = m.end(2);
        buf.replace(start, end, String.valueOf(tunnelledPort2));
        buf.replace(m.start(1), m.end(1), "localhost");
      } else {
        int start = m.start(1);
        buf.insert(start, ":" + tunnelledPort2);
        buf.replace(m.start(1), m.end(1), "localhost");
      }
    }
    return buf.toString();
  }

  public boolean isDriverClassLoaded() {
    return jdbcDriver != null;
  }

  public String getDriverClassName() {
    return driverClassName;
  }

  public String getId() {
    return id;
  }

  public List<String> getJars() {
    if (driver != null)
      return driver.getJars();
    return jars;
  }

  public Driver getJdbcDriver() {
    return jdbcDriver;
  }

  public String getUrl() {
    return url;
  }

  public void setJars(LinkedList<String> jars) {
    this.jars = jars;
    if (driver != null)
      driver.getJars().addAll(jars);
  }

  public void setJars(String[] jars) {
    this.jars.clear();
    for (String jar : jars) {
      if (driver != null)
        driver.getJars().add(jar);
      this.jars.add(jar);
    }
  }

  public void setJdbcDriver(Driver jdbcDriver) {
    this.jdbcDriver = jdbcDriver;
  }

  public void setUrl(String url) {
    this.url = url;
    if (driver != null)
      driver.setExampleUrl(url);
  }

  public void setDriverClassName(String driverClassName) {
    this.driverClassName = driverClassName;
    if (driver != null)
      driver.setDriverClassName(driverClassName);
  }

  public DatabaseProduct getDatabaseProduct() {
    return DatabaseProductFactory.getInstance(this);
  }

  public int compareTo(ManagedDriver that) {
    return id.compareTo(that.id);
  }

  public DBDriver getDriver() {
    return driver;
  }

  public void setDriver(DBDriver driver) {
    this.driver = driver;
  }

  public void setId(String id) {
    this.id = id;
    if (driver != null) {
      driver.setName(id);
    }
  }

  @Override
  public Object getAdapter(Class adapter) {
    if (adapter == IPropertySource.class) {// || adapter ==
      // IContributorResourceAdapter.class){
      return new DriverProperties(this);
    }
    return null;
  }

  private final static String PROPERTY_NAME = "name";
  private final static String PROPERTY_DRIVER_CLASSNAME = "driver classname";
  private final static String PROPERTY_IS_POOLING = "is pooling";
  private final static String PROPERTY_EXAMPLE_URL = "example url";
  private final static String PROPERTY_IS_DEFAULT = "is default";
  private final static String PROPERTY_GUIDE_URL = "guide url";
  private final static String PROPERTY_WEBSITE_URL = "website url";
  private final static String PROPERTY_DEFAULT_PORT = "default port";
  public class DriverProperties implements IPropertySource, IWorkbenchAdapter {
    ManagedDriver driver;

    private final Object PropertiesTable[][] = {
        { PROPERTY_NAME, new TextPropertyDescriptor(PROPERTY_NAME, PROPERTY_NAME) },
        { PROPERTY_DRIVER_CLASSNAME,
            new TextPropertyDescriptor(PROPERTY_DRIVER_CLASSNAME, PROPERTY_DRIVER_CLASSNAME) },
        { PROPERTY_IS_POOLING, new TextPropertyDescriptor(PROPERTY_IS_POOLING, PROPERTY_IS_POOLING) },
        { PROPERTY_EXAMPLE_URL,
            new TextPropertyDescriptor(PROPERTY_EXAMPLE_URL, PROPERTY_EXAMPLE_URL) },
        { PROPERTY_IS_DEFAULT, new TextPropertyDescriptor(PROPERTY_IS_DEFAULT, PROPERTY_IS_DEFAULT) },
        { PROPERTY_GUIDE_URL, new TextPropertyDescriptor(PROPERTY_GUIDE_URL, PROPERTY_GUIDE_URL) },
        { PROPERTY_DEFAULT_PORT,
            new TextPropertyDescriptor(PROPERTY_DEFAULT_PORT, PROPERTY_DEFAULT_PORT) },
        { PROPERTY_WEBSITE_URL,
            new TextPropertyDescriptor(PROPERTY_WEBSITE_URL, PROPERTY_WEBSITE_URL) } };

    public DriverProperties(ManagedDriver driver) {
      this.driver = driver;
    }

    @Override
    public Object getEditableValue() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public IPropertyDescriptor[] getPropertyDescriptors() {
      // Create the property vector.
      IPropertyDescriptor[] propertyDescriptors = new IPropertyDescriptor[PropertiesTable.length];

      for (int i = 0; i < PropertiesTable.length; i++) {
        // Add each property supported.

        PropertyDescriptor descriptor;

        descriptor = (PropertyDescriptor) PropertiesTable[i][1];
        propertyDescriptors[i] = descriptor;
        descriptor.setCategory("Driver Info");
      }

      // Return it.
      return propertyDescriptors;

    }

    @Override
    public Object getPropertyValue(Object id) {
      if (PROPERTY_NAME.equals(id)) {
        return driver.getDriver().getName();
      } else if (PROPERTY_DRIVER_CLASSNAME.equals(id)) {
        return driver.getDriver().getDriverClassName();
      } else if (PROPERTY_EXAMPLE_URL.equals(id)) {
        return driver.getDriver().getExampleUrl();
      } else if (PROPERTY_GUIDE_URL.equals(id)) {
        return driver.getDriver().getGuideUrl();
      } else if (PROPERTY_IS_DEFAULT.equals(id)) {
        return driver.getDriver().isDefault();
      } else if (PROPERTY_IS_POOLING.equals(id)) {
        return driver.getDriver().isPooling();
      } else if (PROPERTY_WEBSITE_URL.equals(id)) {
        return driver.getDriver().getWebsiteUrl();
      } else if (PROPERTY_DEFAULT_PORT.equals(id)) {
        return driver.getDriver().getDefaultPort();
      } else
        return null;
    }

    @Override
    public boolean isPropertySet(Object id) {
      // TODO Auto-generated method stub
      return false;
    }

    @Override
    public void resetPropertyValue(Object id) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setPropertyValue(Object id, Object value) {
      // TODO Auto-generated method stub

    }

    @Override
    public Object[] getChildren(Object o) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public ImageDescriptor getImageDescriptor(Object object) {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public String getLabel(Object o) {
      return driver.getDriver().getName();
    }

    @Override
    public Object getParent(Object o) {
      // TODO Auto-generated method stub
      return null;
    }
  }

  public int getDefaultPort() {
    return defaultPort;
  }

  public void setDefaultPort(int defaultPort) {
    this.defaultPort = defaultPort;
    if (driver != null)
      driver.setDefaultPort(defaultPort);
  }

  public String getGuideUrl() {
    return guideUrl;
  }

  public void setGuideUrl(String guideUrl) {
    this.guideUrl = guideUrl;
    if (driver != null)
      driver.setGuideUrl(guideUrl);
  }

  public String getUrlRegexPattern() {
    return urlRegexPattern;
  }

  public void setUrlRegexPattern(String urlRegexPattern) {
    this.urlRegexPattern = urlRegexPattern;
    if (driver != null)
      driver.setUrlRegexPattern(urlRegexPattern);
  }
}