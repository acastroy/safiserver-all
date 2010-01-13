/**
 * <copyright>
 * </copyright>
 *
 * $Id: DBConnectionImpl.java,v 1.6 2008/12/16 08:54:27 zacw Exp $
 */
package com.safi.db.impl;

import java.util.Collection;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.DbPackage;
import com.safi.db.Query;
import com.safi.db.TransactionMode;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DB Connection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getUser <em>User</em>}</li>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getPassword <em>Password</em>}</li>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getLoginTimeout <em>Login Timeout</em>}</li>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getTransactionMode <em>Transaction Mode</em>}</li>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getMinPoolSize <em>Min Pool Size</em>}</li>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getMaxPoolSize <em>Max Pool Size</em>}</li>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getAcquireIncrement <em>Acquire Increment</em>}</li>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getMaxIdleTime <em>Max Idle Time</em>}</li>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.safi.db.impl.DBConnectionImpl#getQueries <em>Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DBConnectionImpl extends DBResourceImpl implements DBConnection {
  /**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
  protected static final String URL_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
  protected String url = URL_EDEFAULT;

  /**
	 * The default value of the '{@link #getUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
  protected static final String USER_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getUser() <em>User</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUser()
	 * @generated
	 * @ordered
	 */
  protected String user = USER_EDEFAULT;

  /**
	 * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
  protected static final String PASSWORD_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPassword()
	 * @generated
	 * @ordered
	 */
  protected String password = PASSWORD_EDEFAULT;

  /**
	 * The default value of the '{@link #getLoginTimeout() <em>Login Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLoginTimeout()
	 * @generated
	 * @ordered
	 */
  protected static final int LOGIN_TIMEOUT_EDEFAULT = 240000;

  /**
	 * The cached value of the '{@link #getLoginTimeout() <em>Login Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLoginTimeout()
	 * @generated
	 * @ordered
	 */
  protected int loginTimeout = LOGIN_TIMEOUT_EDEFAULT;

  /**
	 * The default value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
  protected static final Properties PROPERTIES_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
  protected Properties properties = PROPERTIES_EDEFAULT;

  /**
	 * The default value of the '{@link #getTransactionMode() <em>Transaction Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTransactionMode()
	 * @generated
	 * @ordered
	 */
  protected static final TransactionMode TRANSACTION_MODE_EDEFAULT = TransactionMode.NONE;

  /**
	 * The cached value of the '{@link #getTransactionMode() <em>Transaction Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTransactionMode()
	 * @generated
	 * @ordered
	 */
  protected TransactionMode transactionMode = TRANSACTION_MODE_EDEFAULT;

  /**
	 * The default value of the '{@link #getMinPoolSize() <em>Min Pool Size</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMinPoolSize()
	 * @generated
	 * @ordered
	 */
  protected static final int MIN_POOL_SIZE_EDEFAULT = 3;

  /**
	 * The cached value of the '{@link #getMinPoolSize() <em>Min Pool Size</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMinPoolSize()
	 * @generated
	 * @ordered
	 */
  protected int minPoolSize = MIN_POOL_SIZE_EDEFAULT;

  /**
	 * The default value of the '{@link #getMaxPoolSize() <em>Max Pool Size</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMaxPoolSize()
	 * @generated
	 * @ordered
	 */
  protected static final int MAX_POOL_SIZE_EDEFAULT = 15;

  /**
	 * The cached value of the '{@link #getMaxPoolSize() <em>Max Pool Size</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMaxPoolSize()
	 * @generated
	 * @ordered
	 */
  protected int maxPoolSize = MAX_POOL_SIZE_EDEFAULT;

  /**
	 * The default value of the '{@link #getAcquireIncrement() <em>Acquire Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAcquireIncrement()
	 * @generated
	 * @ordered
	 */
  protected static final int ACQUIRE_INCREMENT_EDEFAULT = 3;

  /**
	 * The cached value of the '{@link #getAcquireIncrement() <em>Acquire Increment</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAcquireIncrement()
	 * @generated
	 * @ordered
	 */
  protected int acquireIncrement = ACQUIRE_INCREMENT_EDEFAULT;

  /**
	 * The default value of the '{@link #getMaxIdleTime() <em>Max Idle Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMaxIdleTime()
	 * @generated
	 * @ordered
	 */
  protected static final int MAX_IDLE_TIME_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getMaxIdleTime() <em>Max Idle Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMaxIdleTime()
	 * @generated
	 * @ordered
	 */
  protected int maxIdleTime = MAX_IDLE_TIME_EDEFAULT;

  /**
	 * The cached value of the '{@link #getQueries() <em>Queries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getQueries()
	 * @generated
	 * @ordered
	 */
  protected EList<Query> queries;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DBConnectionImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return DbPackage.Literals.DB_CONNECTION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getUrl() {
		return url;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setUrl(String newUrl) {
		String oldUrl = url;
		url = newUrl;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_CONNECTION__URL, oldUrl, url));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getUser() {
		return user;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setUser(String newUser) {
		String oldUser = user;
		user = newUser;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_CONNECTION__USER, oldUser, user));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getPassword() {
		return password;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPassword(String newPassword) {
		String oldPassword = password;
		password = newPassword;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_CONNECTION__PASSWORD, oldPassword, password));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getLoginTimeout() {
		return loginTimeout;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLoginTimeout(int newLoginTimeout) {
		int oldLoginTimeout = loginTimeout;
		loginTimeout = newLoginTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_CONNECTION__LOGIN_TIMEOUT, oldLoginTimeout, loginTimeout));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Properties getProperties() {
		return properties;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setProperties(Properties newProperties) {
		Properties oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_CONNECTION__PROPERTIES, oldProperties, properties));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TransactionMode getTransactionMode() {
		return transactionMode;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTransactionMode(TransactionMode newTransactionMode) {
		TransactionMode oldTransactionMode = transactionMode;
		transactionMode = newTransactionMode == null ? TRANSACTION_MODE_EDEFAULT : newTransactionMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_CONNECTION__TRANSACTION_MODE, oldTransactionMode, transactionMode));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getMinPoolSize() {
		return minPoolSize;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMinPoolSize(int newMinPoolSize) {
		int oldMinPoolSize = minPoolSize;
		minPoolSize = newMinPoolSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_CONNECTION__MIN_POOL_SIZE, oldMinPoolSize, minPoolSize));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getMaxPoolSize() {
		return maxPoolSize;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMaxPoolSize(int newMaxPoolSize) {
		int oldMaxPoolSize = maxPoolSize;
		maxPoolSize = newMaxPoolSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_CONNECTION__MAX_POOL_SIZE, oldMaxPoolSize, maxPoolSize));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getAcquireIncrement() {
		return acquireIncrement;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAcquireIncrement(int newAcquireIncrement) {
		int oldAcquireIncrement = acquireIncrement;
		acquireIncrement = newAcquireIncrement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_CONNECTION__ACQUIRE_INCREMENT, oldAcquireIncrement, acquireIncrement));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getMaxIdleTime() {
		return maxIdleTime;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMaxIdleTime(int newMaxIdleTime) {
		int oldMaxIdleTime = maxIdleTime;
		maxIdleTime = newMaxIdleTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_CONNECTION__MAX_IDLE_TIME, oldMaxIdleTime, maxIdleTime));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DBDriver getDriver() {
		if (eContainerFeatureID() != DbPackage.DB_CONNECTION__DRIVER) return null;
		return (DBDriver)eContainer();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetDriver(DBDriver newDriver, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newDriver, DbPackage.DB_CONNECTION__DRIVER, msgs);
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDriver(DBDriver newDriver) {
		if (newDriver != eInternalContainer() || (eContainerFeatureID() != DbPackage.DB_CONNECTION__DRIVER && newDriver != null)) {
			if (EcoreUtil.isAncestor(this, newDriver))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDriver != null)
				msgs = ((InternalEObject)newDriver).eInverseAdd(this, DbPackage.DB_DRIVER__CONNECTIONS, DBDriver.class, msgs);
			msgs = basicSetDriver(newDriver, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.DB_CONNECTION__DRIVER, newDriver, newDriver));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Query> getQueries() {
		if (queries == null) {
			queries = new EObjectContainmentWithInverseEList<Query>(Query.class, this, DbPackage.DB_CONNECTION__QUERIES, DbPackage.QUERY__CONNECTION);
		}
		return queries;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Query getQuery(String name) {
    if (queries == null || name == null) return null;
    
    for (Query q : queries){
      if (name.equals(q.getName()))
        return q;
    }
    return null;
  }
  
  @Override
  public String getUniqueQueryName() {
    return getUniqueQueryName("New Query");
  }

  @Override
  public String getUniqueQueryName(String prefix) {
    if (StringUtils.isBlank(prefix))
      prefix = "New Query";
    if (getQuery(prefix) == null)
      return prefix;
    int i = 2;
    while (getQuery(prefix+i) != null) i++;
    return prefix+i;
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
			case DbPackage.DB_CONNECTION__DRIVER:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetDriver((DBDriver)otherEnd, msgs);
			case DbPackage.DB_CONNECTION__QUERIES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getQueries()).basicAdd(otherEnd, msgs);
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
			case DbPackage.DB_CONNECTION__DRIVER:
				return basicSetDriver(null, msgs);
			case DbPackage.DB_CONNECTION__QUERIES:
				return ((InternalEList<?>)getQueries()).basicRemove(otherEnd, msgs);
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
		switch (eContainerFeatureID()) {
			case DbPackage.DB_CONNECTION__DRIVER:
				return eInternalContainer().eInverseRemove(this, DbPackage.DB_DRIVER__CONNECTIONS, DBDriver.class, msgs);
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
			case DbPackage.DB_CONNECTION__URL:
				return getUrl();
			case DbPackage.DB_CONNECTION__USER:
				return getUser();
			case DbPackage.DB_CONNECTION__PASSWORD:
				return getPassword();
			case DbPackage.DB_CONNECTION__LOGIN_TIMEOUT:
				return getLoginTimeout();
			case DbPackage.DB_CONNECTION__PROPERTIES:
				return getProperties();
			case DbPackage.DB_CONNECTION__TRANSACTION_MODE:
				return getTransactionMode();
			case DbPackage.DB_CONNECTION__MIN_POOL_SIZE:
				return getMinPoolSize();
			case DbPackage.DB_CONNECTION__MAX_POOL_SIZE:
				return getMaxPoolSize();
			case DbPackage.DB_CONNECTION__ACQUIRE_INCREMENT:
				return getAcquireIncrement();
			case DbPackage.DB_CONNECTION__MAX_IDLE_TIME:
				return getMaxIdleTime();
			case DbPackage.DB_CONNECTION__DRIVER:
				return getDriver();
			case DbPackage.DB_CONNECTION__QUERIES:
				return getQueries();
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
			case DbPackage.DB_CONNECTION__URL:
				setUrl((String)newValue);
				return;
			case DbPackage.DB_CONNECTION__USER:
				setUser((String)newValue);
				return;
			case DbPackage.DB_CONNECTION__PASSWORD:
				setPassword((String)newValue);
				return;
			case DbPackage.DB_CONNECTION__LOGIN_TIMEOUT:
				setLoginTimeout((Integer)newValue);
				return;
			case DbPackage.DB_CONNECTION__PROPERTIES:
				setProperties((Properties)newValue);
				return;
			case DbPackage.DB_CONNECTION__TRANSACTION_MODE:
				setTransactionMode((TransactionMode)newValue);
				return;
			case DbPackage.DB_CONNECTION__MIN_POOL_SIZE:
				setMinPoolSize((Integer)newValue);
				return;
			case DbPackage.DB_CONNECTION__MAX_POOL_SIZE:
				setMaxPoolSize((Integer)newValue);
				return;
			case DbPackage.DB_CONNECTION__ACQUIRE_INCREMENT:
				setAcquireIncrement((Integer)newValue);
				return;
			case DbPackage.DB_CONNECTION__MAX_IDLE_TIME:
				setMaxIdleTime((Integer)newValue);
				return;
			case DbPackage.DB_CONNECTION__DRIVER:
				setDriver((DBDriver)newValue);
				return;
			case DbPackage.DB_CONNECTION__QUERIES:
				getQueries().clear();
				getQueries().addAll((Collection<? extends Query>)newValue);
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
			case DbPackage.DB_CONNECTION__URL:
				setUrl(URL_EDEFAULT);
				return;
			case DbPackage.DB_CONNECTION__USER:
				setUser(USER_EDEFAULT);
				return;
			case DbPackage.DB_CONNECTION__PASSWORD:
				setPassword(PASSWORD_EDEFAULT);
				return;
			case DbPackage.DB_CONNECTION__LOGIN_TIMEOUT:
				setLoginTimeout(LOGIN_TIMEOUT_EDEFAULT);
				return;
			case DbPackage.DB_CONNECTION__PROPERTIES:
				setProperties(PROPERTIES_EDEFAULT);
				return;
			case DbPackage.DB_CONNECTION__TRANSACTION_MODE:
				setTransactionMode(TRANSACTION_MODE_EDEFAULT);
				return;
			case DbPackage.DB_CONNECTION__MIN_POOL_SIZE:
				setMinPoolSize(MIN_POOL_SIZE_EDEFAULT);
				return;
			case DbPackage.DB_CONNECTION__MAX_POOL_SIZE:
				setMaxPoolSize(MAX_POOL_SIZE_EDEFAULT);
				return;
			case DbPackage.DB_CONNECTION__ACQUIRE_INCREMENT:
				setAcquireIncrement(ACQUIRE_INCREMENT_EDEFAULT);
				return;
			case DbPackage.DB_CONNECTION__MAX_IDLE_TIME:
				setMaxIdleTime(MAX_IDLE_TIME_EDEFAULT);
				return;
			case DbPackage.DB_CONNECTION__DRIVER:
				setDriver((DBDriver)null);
				return;
			case DbPackage.DB_CONNECTION__QUERIES:
				getQueries().clear();
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
			case DbPackage.DB_CONNECTION__URL:
				return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
			case DbPackage.DB_CONNECTION__USER:
				return USER_EDEFAULT == null ? user != null : !USER_EDEFAULT.equals(user);
			case DbPackage.DB_CONNECTION__PASSWORD:
				return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
			case DbPackage.DB_CONNECTION__LOGIN_TIMEOUT:
				return loginTimeout != LOGIN_TIMEOUT_EDEFAULT;
			case DbPackage.DB_CONNECTION__PROPERTIES:
				return PROPERTIES_EDEFAULT == null ? properties != null : !PROPERTIES_EDEFAULT.equals(properties);
			case DbPackage.DB_CONNECTION__TRANSACTION_MODE:
				return transactionMode != TRANSACTION_MODE_EDEFAULT;
			case DbPackage.DB_CONNECTION__MIN_POOL_SIZE:
				return minPoolSize != MIN_POOL_SIZE_EDEFAULT;
			case DbPackage.DB_CONNECTION__MAX_POOL_SIZE:
				return maxPoolSize != MAX_POOL_SIZE_EDEFAULT;
			case DbPackage.DB_CONNECTION__ACQUIRE_INCREMENT:
				return acquireIncrement != ACQUIRE_INCREMENT_EDEFAULT;
			case DbPackage.DB_CONNECTION__MAX_IDLE_TIME:
				return maxIdleTime != MAX_IDLE_TIME_EDEFAULT;
			case DbPackage.DB_CONNECTION__DRIVER:
				return getDriver() != null;
			case DbPackage.DB_CONNECTION__QUERIES:
				return queries != null && !queries.isEmpty();
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
		result.append(" (url: ");
		result.append(url);
		result.append(", user: ");
		result.append(user);
		result.append(", password: ");
		result.append(password);
		result.append(", loginTimeout: ");
		result.append(loginTimeout);
		result.append(", properties: ");
		result.append(properties);
		result.append(", transactionMode: ");
		result.append(transactionMode);
		result.append(", minPoolSize: ");
		result.append(minPoolSize);
		result.append(", maxPoolSize: ");
		result.append(maxPoolSize);
		result.append(", acquireIncrement: ");
		result.append(acquireIncrement);
		result.append(", maxIdleTime: ");
		result.append(maxIdleTime);
		result.append(')');
		return result.toString();
	}

} //DBConnectionImpl
