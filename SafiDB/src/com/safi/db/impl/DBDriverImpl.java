/**
 * <copyright>
 * </copyright>
 *
 * $Id: DBDriverImpl.java,v 1.4 2008/06/23 08:43:28 zacw Exp $
 */
package com.safi.db.impl;

import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.DbPackage;

import com.safi.db.SafiDriverManager;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DB Driver</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.impl.DBDriverImpl#getDriverClassName <em>Driver Class Name</em>}</li>
 *   <li>{@link com.safi.db.impl.DBDriverImpl#isPooling <em>Pooling</em>}</li>
 *   <li>{@link com.safi.db.impl.DBDriverImpl#getConnections <em>Connections</em>}</li>
 *   <li>{@link com.safi.db.impl.DBDriverImpl#getExampleUrl <em>Example Url</em>}</li>
 *   <li>{@link com.safi.db.impl.DBDriverImpl#getJars <em>Jars</em>}</li>
 *   <li>{@link com.safi.db.impl.DBDriverImpl#getDriverManager <em>Driver Manager</em>}</li>
 *   <li>{@link com.safi.db.impl.DBDriverImpl#isDefault <em>Default</em>}</li>
 *   <li>{@link com.safi.db.impl.DBDriverImpl#getGuideUrl <em>Guide Url</em>}</li>
 *   <li>{@link com.safi.db.impl.DBDriverImpl#getWebsiteUrl <em>Website Url</em>}</li>
 *   <li>{@link com.safi.db.impl.DBDriverImpl#getDefaultPort <em>Default Port</em>}</li>
 *   <li>{@link com.safi.db.impl.DBDriverImpl#getUrlRegexPattern <em>Url Regex Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DBDriverImpl extends DBResourceImpl implements DBDriver {
  /**
   * The default value of the '{@link #getDriverClassName() <em>Driver Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDriverClassName()
   * @generated
   * @ordered
   */
  protected static final String DRIVER_CLASS_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDriverClassName() <em>Driver Class Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDriverClassName()
   * @generated
   * @ordered
   */
  protected String driverClassName = DRIVER_CLASS_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #isPooling() <em>Pooling</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPooling()
   * @generated
   * @ordered
   */
  protected static final boolean POOLING_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPooling() <em>Pooling</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPooling()
   * @generated
   * @ordered
   */
  protected boolean pooling = POOLING_EDEFAULT;

  /**
   * The cached value of the '{@link #getConnections() <em>Connections</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConnections()
   * @generated
   * @ordered
   */
  protected EList<DBConnection> connections;

  /**
   * The default value of the '{@link #getExampleUrl() <em>Example Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExampleUrl()
   * @generated
   * @ordered
   */
  protected static final String EXAMPLE_URL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExampleUrl() <em>Example Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExampleUrl()
   * @generated
   * @ordered
   */
  protected String exampleUrl = EXAMPLE_URL_EDEFAULT;

  /**
   * The cached value of the '{@link #getJars() <em>Jars</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getJars()
   * @generated
   * @ordered
   */
  protected EList<String> jars;

  /**
   * The default value of the '{@link #isDefault() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefault()
   * @generated
   * @ordered
   */
  protected static final boolean DEFAULT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isDefault() <em>Default</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDefault()
   * @generated
   * @ordered
   */
  protected boolean default_ = DEFAULT_EDEFAULT;

  /**
   * The default value of the '{@link #getGuideUrl() <em>Guide Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuideUrl()
   * @generated
   * @ordered
   */
  protected static final String GUIDE_URL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getGuideUrl() <em>Guide Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGuideUrl()
   * @generated
   * @ordered
   */
  protected String guideUrl = GUIDE_URL_EDEFAULT;

  /**
   * The default value of the '{@link #getWebsiteUrl() <em>Website Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWebsiteUrl()
   * @generated
   * @ordered
   */
  protected static final String WEBSITE_URL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getWebsiteUrl() <em>Website Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getWebsiteUrl()
   * @generated
   * @ordered
   */
  protected String websiteUrl = WEBSITE_URL_EDEFAULT;

  /**
   * The default value of the '{@link #getDefaultPort() <em>Default Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultPort()
   * @generated
   * @ordered
   */
  protected static final int DEFAULT_PORT_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getDefaultPort() <em>Default Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultPort()
   * @generated
   * @ordered
   */
  protected int defaultPort = DEFAULT_PORT_EDEFAULT;

  /**
   * The default value of the '{@link #getUrlRegexPattern() <em>Url Regex Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUrlRegexPattern()
   * @generated
   * @ordered
   */
  protected static final String URL_REGEX_PATTERN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUrlRegexPattern() <em>Url Regex Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getUrlRegexPattern()
   * @generated
   * @ordered
   */
  protected String urlRegexPattern = URL_REGEX_PATTERN_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DBDriverImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return DbPackage.Literals.DB_DRIVER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDriverClassName() {
    return driverClassName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDriverClassName(String newDriverClassName) {
    String oldDriverClassName = driverClassName;
    driverClassName = newDriverClassName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_DRIVER__DRIVER_CLASS_NAME, oldDriverClassName, driverClassName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPooling() {
    return pooling;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPooling(boolean newPooling) {
    boolean oldPooling = pooling;
    pooling = newPooling;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_DRIVER__POOLING, oldPooling, pooling));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DBConnection> getConnections() {
    if (connections == null) {
      connections = new EObjectContainmentWithInverseEList<DBConnection>(DBConnection.class, this, DbPackage.DB_DRIVER__CONNECTIONS, DbPackage.DB_CONNECTION__DRIVER);
    }
    return connections;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExampleUrl() {
    return exampleUrl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExampleUrl(String newExampleUrl) {
    String oldExampleUrl = exampleUrl;
    exampleUrl = newExampleUrl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_DRIVER__EXAMPLE_URL, oldExampleUrl, exampleUrl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getJars() {
    if (jars == null) {
      jars = new EDataTypeUniqueEList<String>(String.class, this, DbPackage.DB_DRIVER__JARS);
    }
    return jars;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SafiDriverManager getDriverManager() {
    if (eContainerFeatureID != DbPackage.DB_DRIVER__DRIVER_MANAGER) return null;
    return (SafiDriverManager)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDriverManager(SafiDriverManager newDriverManager, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newDriverManager, DbPackage.DB_DRIVER__DRIVER_MANAGER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDriverManager(SafiDriverManager newDriverManager) {
    if (newDriverManager != eInternalContainer() || (eContainerFeatureID != DbPackage.DB_DRIVER__DRIVER_MANAGER && newDriverManager != null)) {
      if (EcoreUtil.isAncestor(this, newDriverManager))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newDriverManager != null)
        msgs = ((InternalEObject)newDriverManager).eInverseAdd(this, DbPackage.SAFI_DRIVER_MANAGER__DRIVERS, SafiDriverManager.class, msgs);
      msgs = basicSetDriverManager(newDriverManager, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_DRIVER__DRIVER_MANAGER, newDriverManager, newDriverManager));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDefault() {
    return default_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefault(boolean newDefault) {
    boolean oldDefault = default_;
    default_ = newDefault;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_DRIVER__DEFAULT, oldDefault, default_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getGuideUrl() {
    return guideUrl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGuideUrl(String newGuideUrl) {
    String oldGuideUrl = guideUrl;
    guideUrl = newGuideUrl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_DRIVER__GUIDE_URL, oldGuideUrl, guideUrl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getWebsiteUrl() {
    return websiteUrl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWebsiteUrl(String newWebsiteUrl) {
    String oldWebsiteUrl = websiteUrl;
    websiteUrl = newWebsiteUrl;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_DRIVER__WEBSITE_URL, oldWebsiteUrl, websiteUrl));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDefaultPort() {
    return defaultPort;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultPort(int newDefaultPort) {
    int oldDefaultPort = defaultPort;
    defaultPort = newDefaultPort;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_DRIVER__DEFAULT_PORT, oldDefaultPort, defaultPort));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getUrlRegexPattern() {
    return urlRegexPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUrlRegexPattern(String newUrlRegexPattern) {
    String oldUrlRegexPattern = urlRegexPattern;
    urlRegexPattern = newUrlRegexPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_DRIVER__URL_REGEX_PATTERN, oldUrlRegexPattern, urlRegexPattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DBConnection getConnection(String name) {
    if (connections == null || name == null) return null;
    for (DBConnection c : connections){
      if (name.equals(c.getName()))
        return c;
    }
    
    return null;
   
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case DbPackage.DB_DRIVER__CONNECTIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getConnections()).basicAdd(otherEnd, msgs);
      case DbPackage.DB_DRIVER__DRIVER_MANAGER:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetDriverManager((SafiDriverManager)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case DbPackage.DB_DRIVER__CONNECTIONS:
        return ((InternalEList<?>)getConnections()).basicRemove(otherEnd, msgs);
      case DbPackage.DB_DRIVER__DRIVER_MANAGER:
        return basicSetDriverManager(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID) {
      case DbPackage.DB_DRIVER__DRIVER_MANAGER:
        return eInternalContainer().eInverseRemove(this, DbPackage.SAFI_DRIVER_MANAGER__DRIVERS, SafiDriverManager.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case DbPackage.DB_DRIVER__DRIVER_CLASS_NAME:
        return getDriverClassName();
      case DbPackage.DB_DRIVER__POOLING:
        return isPooling() ? Boolean.TRUE : Boolean.FALSE;
      case DbPackage.DB_DRIVER__CONNECTIONS:
        return getConnections();
      case DbPackage.DB_DRIVER__EXAMPLE_URL:
        return getExampleUrl();
      case DbPackage.DB_DRIVER__JARS:
        return getJars();
      case DbPackage.DB_DRIVER__DRIVER_MANAGER:
        return getDriverManager();
      case DbPackage.DB_DRIVER__DEFAULT:
        return isDefault() ? Boolean.TRUE : Boolean.FALSE;
      case DbPackage.DB_DRIVER__GUIDE_URL:
        return getGuideUrl();
      case DbPackage.DB_DRIVER__WEBSITE_URL:
        return getWebsiteUrl();
      case DbPackage.DB_DRIVER__DEFAULT_PORT:
        return new Integer(getDefaultPort());
      case DbPackage.DB_DRIVER__URL_REGEX_PATTERN:
        return getUrlRegexPattern();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case DbPackage.DB_DRIVER__DRIVER_CLASS_NAME:
        setDriverClassName((String)newValue);
        return;
      case DbPackage.DB_DRIVER__POOLING:
        setPooling(((Boolean)newValue).booleanValue());
        return;
      case DbPackage.DB_DRIVER__CONNECTIONS:
        getConnections().clear();
        getConnections().addAll((Collection<? extends DBConnection>)newValue);
        return;
      case DbPackage.DB_DRIVER__EXAMPLE_URL:
        setExampleUrl((String)newValue);
        return;
      case DbPackage.DB_DRIVER__JARS:
        getJars().clear();
        getJars().addAll((Collection<? extends String>)newValue);
        return;
      case DbPackage.DB_DRIVER__DRIVER_MANAGER:
        setDriverManager((SafiDriverManager)newValue);
        return;
      case DbPackage.DB_DRIVER__DEFAULT:
        setDefault(((Boolean)newValue).booleanValue());
        return;
      case DbPackage.DB_DRIVER__GUIDE_URL:
        setGuideUrl((String)newValue);
        return;
      case DbPackage.DB_DRIVER__WEBSITE_URL:
        setWebsiteUrl((String)newValue);
        return;
      case DbPackage.DB_DRIVER__DEFAULT_PORT:
        setDefaultPort(((Integer)newValue).intValue());
        return;
      case DbPackage.DB_DRIVER__URL_REGEX_PATTERN:
        setUrlRegexPattern((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case DbPackage.DB_DRIVER__DRIVER_CLASS_NAME:
        setDriverClassName(DRIVER_CLASS_NAME_EDEFAULT);
        return;
      case DbPackage.DB_DRIVER__POOLING:
        setPooling(POOLING_EDEFAULT);
        return;
      case DbPackage.DB_DRIVER__CONNECTIONS:
        getConnections().clear();
        return;
      case DbPackage.DB_DRIVER__EXAMPLE_URL:
        setExampleUrl(EXAMPLE_URL_EDEFAULT);
        return;
      case DbPackage.DB_DRIVER__JARS:
        getJars().clear();
        return;
      case DbPackage.DB_DRIVER__DRIVER_MANAGER:
        setDriverManager((SafiDriverManager)null);
        return;
      case DbPackage.DB_DRIVER__DEFAULT:
        setDefault(DEFAULT_EDEFAULT);
        return;
      case DbPackage.DB_DRIVER__GUIDE_URL:
        setGuideUrl(GUIDE_URL_EDEFAULT);
        return;
      case DbPackage.DB_DRIVER__WEBSITE_URL:
        setWebsiteUrl(WEBSITE_URL_EDEFAULT);
        return;
      case DbPackage.DB_DRIVER__DEFAULT_PORT:
        setDefaultPort(DEFAULT_PORT_EDEFAULT);
        return;
      case DbPackage.DB_DRIVER__URL_REGEX_PATTERN:
        setUrlRegexPattern(URL_REGEX_PATTERN_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case DbPackage.DB_DRIVER__DRIVER_CLASS_NAME:
        return DRIVER_CLASS_NAME_EDEFAULT == null ? driverClassName != null : !DRIVER_CLASS_NAME_EDEFAULT.equals(driverClassName);
      case DbPackage.DB_DRIVER__POOLING:
        return pooling != POOLING_EDEFAULT;
      case DbPackage.DB_DRIVER__CONNECTIONS:
        return connections != null && !connections.isEmpty();
      case DbPackage.DB_DRIVER__EXAMPLE_URL:
        return EXAMPLE_URL_EDEFAULT == null ? exampleUrl != null : !EXAMPLE_URL_EDEFAULT.equals(exampleUrl);
      case DbPackage.DB_DRIVER__JARS:
        return jars != null && !jars.isEmpty();
      case DbPackage.DB_DRIVER__DRIVER_MANAGER:
        return getDriverManager() != null;
      case DbPackage.DB_DRIVER__DEFAULT:
        return default_ != DEFAULT_EDEFAULT;
      case DbPackage.DB_DRIVER__GUIDE_URL:
        return GUIDE_URL_EDEFAULT == null ? guideUrl != null : !GUIDE_URL_EDEFAULT.equals(guideUrl);
      case DbPackage.DB_DRIVER__WEBSITE_URL:
        return WEBSITE_URL_EDEFAULT == null ? websiteUrl != null : !WEBSITE_URL_EDEFAULT.equals(websiteUrl);
      case DbPackage.DB_DRIVER__DEFAULT_PORT:
        return defaultPort != DEFAULT_PORT_EDEFAULT;
      case DbPackage.DB_DRIVER__URL_REGEX_PATTERN:
        return URL_REGEX_PATTERN_EDEFAULT == null ? urlRegexPattern != null : !URL_REGEX_PATTERN_EDEFAULT.equals(urlRegexPattern);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (driverClassName: ");
    result.append(driverClassName);
    result.append(", pooling: ");
    result.append(pooling);
    result.append(", exampleUrl: ");
    result.append(exampleUrl);
    result.append(", jars: ");
    result.append(jars);
    result.append(", default: ");
    result.append(default_);
    result.append(", guideUrl: ");
    result.append(guideUrl);
    result.append(", websiteUrl: ");
    result.append(websiteUrl);
    result.append(", defaultPort: ");
    result.append(defaultPort);
    result.append(", urlRegexPattern: ");
    result.append(urlRegexPattern);
    result.append(')');
    return result.toString();
  }

} //DBDriverImpl
