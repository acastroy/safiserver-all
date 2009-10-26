/**
 * <copyright>
 * </copyright>
 *
 * $Id: DBConnection.java,v 1.9 2008/12/16 08:54:27 zacw Exp $
 */
package com.safi.db;

import java.sql.Connection;
import java.util.Properties;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DB Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.DBConnection#getUrl <em>Url</em>}</li>
 *   <li>{@link com.safi.db.DBConnection#getUser <em>User</em>}</li>
 *   <li>{@link com.safi.db.DBConnection#getPassword <em>Password</em>}</li>
 *   <li>{@link com.safi.db.DBConnection#getLoginTimeout <em>Login Timeout</em>}</li>
 *   <li>{@link com.safi.db.DBConnection#getProperties <em>Properties</em>}</li>
 *   <li>{@link com.safi.db.DBConnection#getTransactionMode <em>Transaction Mode</em>}</li>
 *   <li>{@link com.safi.db.DBConnection#getMinPoolSize <em>Min Pool Size</em>}</li>
 *   <li>{@link com.safi.db.DBConnection#getMaxPoolSize <em>Max Pool Size</em>}</li>
 *   <li>{@link com.safi.db.DBConnection#getAcquireIncrement <em>Acquire Increment</em>}</li>
 *   <li>{@link com.safi.db.DBConnection#getMaxIdleTime <em>Max Idle Time</em>}</li>
 *   <li>{@link com.safi.db.DBConnection#getDriver <em>Driver</em>}</li>
 *   <li>{@link com.safi.db.DBConnection#getQueries <em>Queries</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.DbPackage#getDBConnection()
 * @model
 * @generated
 */
public interface DBConnection extends DBResource {
  /**
   * Returns the value of the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Url</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Url</em>' attribute.
   * @see #setUrl(String)
   * @see com.safi.db.DbPackage#getDBConnection_Url()
   * @model
   * @generated
   */
  String getUrl();

  /**
   * Sets the value of the '{@link com.safi.db.DBConnection#getUrl <em>Url</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Url</em>' attribute.
   * @see #getUrl()
   * @generated
   */
  void setUrl(String value);

  /**
   * Returns the value of the '<em><b>User</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User</em>' attribute.
   * @see #setUser(String)
   * @see com.safi.db.DbPackage#getDBConnection_User()
   * @model
   * @generated
   */
  String getUser();

  /**
   * Sets the value of the '{@link com.safi.db.DBConnection#getUser <em>User</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User</em>' attribute.
   * @see #getUser()
   * @generated
   */
  void setUser(String value);

  /**
   * Returns the value of the '<em><b>Password</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Password</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Password</em>' attribute.
   * @see #setPassword(String)
   * @see com.safi.db.DbPackage#getDBConnection_Password()
   * @model
   * @generated
   */
  String getPassword();

  /**
   * Sets the value of the '{@link com.safi.db.DBConnection#getPassword <em>Password</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Password</em>' attribute.
   * @see #getPassword()
   * @generated
   */
  void setPassword(String value);

  /**
   * Returns the value of the '<em><b>Login Timeout</b></em>' attribute.
   * The default value is <code>"240000"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Login Timeout</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Login Timeout</em>' attribute.
   * @see #setLoginTimeout(int)
   * @see com.safi.db.DbPackage#getDBConnection_LoginTimeout()
   * @model default="240000"
   * @generated
   */
  int getLoginTimeout();

  /**
   * Sets the value of the '{@link com.safi.db.DBConnection#getLoginTimeout <em>Login Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Login Timeout</em>' attribute.
   * @see #getLoginTimeout()
   * @generated
   */
  void setLoginTimeout(int value);

  /**
   * Returns the value of the '<em><b>Properties</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' attribute.
   * @see #setProperties(Properties)
   * @see com.safi.db.DbPackage#getDBConnection_Properties()
   * @model dataType="com.safi.db.Properties"
   * @generated
   */
  Properties getProperties();

  /**
   * Sets the value of the '{@link com.safi.db.DBConnection#getProperties <em>Properties</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Properties</em>' attribute.
   * @see #getProperties()
   * @generated
   */
  void setProperties(Properties value);

  /**
   * Returns the value of the '<em><b>Transaction Mode</b></em>' attribute.
   * The default value is <code>"None"</code>.
   * The literals are from the enumeration {@link com.safi.db.TransactionMode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transaction Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transaction Mode</em>' attribute.
   * @see com.safi.db.TransactionMode
   * @see #setTransactionMode(TransactionMode)
   * @see com.safi.db.DbPackage#getDBConnection_TransactionMode()
   * @model default="None"
   * @generated
   */
  TransactionMode getTransactionMode();

  /**
   * Sets the value of the '{@link com.safi.db.DBConnection#getTransactionMode <em>Transaction Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transaction Mode</em>' attribute.
   * @see com.safi.db.TransactionMode
   * @see #getTransactionMode()
   * @generated
   */
  void setTransactionMode(TransactionMode value);

  /**
   * Returns the value of the '<em><b>Min Pool Size</b></em>' attribute.
   * The default value is <code>"3"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Min Pool Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Min Pool Size</em>' attribute.
   * @see #setMinPoolSize(int)
   * @see com.safi.db.DbPackage#getDBConnection_MinPoolSize()
   * @model default="3"
   * @generated
   */
  int getMinPoolSize();

  /**
   * Sets the value of the '{@link com.safi.db.DBConnection#getMinPoolSize <em>Min Pool Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Min Pool Size</em>' attribute.
   * @see #getMinPoolSize()
   * @generated
   */
  void setMinPoolSize(int value);

  /**
   * Returns the value of the '<em><b>Max Pool Size</b></em>' attribute.
   * The default value is <code>"15"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Pool Size</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Pool Size</em>' attribute.
   * @see #setMaxPoolSize(int)
   * @see com.safi.db.DbPackage#getDBConnection_MaxPoolSize()
   * @model default="15"
   * @generated
   */
  int getMaxPoolSize();

  /**
   * Sets the value of the '{@link com.safi.db.DBConnection#getMaxPoolSize <em>Max Pool Size</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Pool Size</em>' attribute.
   * @see #getMaxPoolSize()
   * @generated
   */
  void setMaxPoolSize(int value);

  /**
   * Returns the value of the '<em><b>Acquire Increment</b></em>' attribute.
   * The default value is <code>"3"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Acquire Increment</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Acquire Increment</em>' attribute.
   * @see #setAcquireIncrement(int)
   * @see com.safi.db.DbPackage#getDBConnection_AcquireIncrement()
   * @model default="3"
   * @generated
   */
  int getAcquireIncrement();

  /**
   * Sets the value of the '{@link com.safi.db.DBConnection#getAcquireIncrement <em>Acquire Increment</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Acquire Increment</em>' attribute.
   * @see #getAcquireIncrement()
   * @generated
   */
  void setAcquireIncrement(int value);

  /**
   * Returns the value of the '<em><b>Max Idle Time</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Idle Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Idle Time</em>' attribute.
   * @see #setMaxIdleTime(int)
   * @see com.safi.db.DbPackage#getDBConnection_MaxIdleTime()
   * @model default="0"
   * @generated
   */
  int getMaxIdleTime();

  /**
   * Sets the value of the '{@link com.safi.db.DBConnection#getMaxIdleTime <em>Max Idle Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Idle Time</em>' attribute.
   * @see #getMaxIdleTime()
   * @generated
   */
  void setMaxIdleTime(int value);

  /**
   * Returns the value of the '<em><b>Driver</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link com.safi.db.DBDriver#getConnections <em>Connections</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Driver</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Driver</em>' container reference.
   * @see #setDriver(DBDriver)
   * @see com.safi.db.DbPackage#getDBConnection_Driver()
   * @see com.safi.db.DBDriver#getConnections
   * @model opposite="connections" transient="false"
   * @generated
   */
  DBDriver getDriver();

  /**
   * Sets the value of the '{@link com.safi.db.DBConnection#getDriver <em>Driver</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Driver</em>' container reference.
   * @see #getDriver()
   * @generated
   */
  void setDriver(DBDriver value);

  /**
   * Returns the value of the '<em><b>Queries</b></em>' containment reference list.
   * The list contents are of type {@link com.safi.db.Query}.
   * It is bidirectional and its opposite is '{@link com.safi.db.Query#getConnection <em>Connection</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Queries</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Queries</em>' containment reference list.
   * @see com.safi.db.DbPackage#getDBConnection_Queries()
   * @see com.safi.db.Query#getConnection
   * @model opposite="connection" containment="true"
   *        annotation="teneo.jpa appinfo='@OneToMany(cascade={MERGE,PERSIST,REMOVE} fetch=\"EAGER\")'"
   * @generated
   */
  EList<Query> getQueries();

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Query getQuery(String name);

  String getUniqueQueryName();

  String getUniqueQueryName(String prefix);

} // DBConnection
