/**
 * <copyright>
 * </copyright>
 *
 * $Id: SafiServer.java,v 1.8 2008/07/15 07:04:42 zacw Exp $
 */
package com.safi.db.server.config;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safi Server</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.server.config.SafiServer#getBindIP <em>Bind IP</em>}</li>
 *   <li>{@link com.safi.db.server.config.SafiServer#getPort <em>Port</em>}</li>
 *   <li>{@link com.safi.db.server.config.SafiServer#getManagementPort <em>Management Port</em>}</li>
 *   <li>{@link com.safi.db.server.config.SafiServer#getAsteriskServers <em>Asterisk Servers</em>}</li>
 *   <li>{@link com.safi.db.server.config.SafiServer#getUser <em>User</em>}</li>
 *   <li>{@link com.safi.db.server.config.SafiServer#getUsers <em>Users</em>}</li>
 *   <li>{@link com.safi.db.server.config.SafiServer#isRunning <em>Running</em>}</li>
 *   <li>{@link com.safi.db.server.config.SafiServer#isDebug <em>Debug</em>}</li>
 *   <li>{@link com.safi.db.server.config.SafiServer#getDbPort <em>Db Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.server.config.ConfigPackage#getSafiServer()
 * @model
 * @generated
 */
public interface SafiServer extends ServerResource {
  /**
   * Returns the value of the '<em><b>Bind IP</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bind IP</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bind IP</em>' attribute.
   * @see #setBindIP(String)
   * @see com.safi.db.server.config.ConfigPackage#getSafiServer_BindIP()
   * @model required="true"
   * @generated
   */
  String getBindIP();

  /**
   * Sets the value of the '{@link com.safi.db.server.config.SafiServer#getBindIP <em>Bind IP</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bind IP</em>' attribute.
   * @see #getBindIP()
   * @generated
   */
  void setBindIP(String value);

  /**
   * Returns the value of the '<em><b>Port</b></em>' attribute.
   * The default value is <code>"4573"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Port</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Port</em>' attribute.
   * @see #setPort(int)
   * @see com.safi.db.server.config.ConfigPackage#getSafiServer_Port()
   * @model default="4573"
   * @generated
   */
  int getPort();

  /**
   * Sets the value of the '{@link com.safi.db.server.config.SafiServer#getPort <em>Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Port</em>' attribute.
   * @see #getPort()
   * @generated
   */
  void setPort(int value);

  /**
   * Returns the value of the '<em><b>Management Port</b></em>' attribute.
   * The default value is <code>"7020"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Management Port</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Management Port</em>' attribute.
   * @see #setManagementPort(int)
   * @see com.safi.db.server.config.ConfigPackage#getSafiServer_ManagementPort()
   * @model default="7020"
   * @generated
   */
  int getManagementPort();

  /**
   * Sets the value of the '{@link com.safi.db.server.config.SafiServer#getManagementPort <em>Management Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Management Port</em>' attribute.
   * @see #getManagementPort()
   * @generated
   */
  void setManagementPort(int value);

  /**
   * Returns the value of the '<em><b>Asterisk Servers</b></em>' containment reference list.
   * The list contents are of type {@link com.safi.db.server.config.AsteriskServer}.
   * It is bidirectional and its opposite is '{@link com.safi.db.server.config.AsteriskServer#getSafiServer <em>Safi Server</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Asterisk Servers</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Asterisk Servers</em>' containment reference list.
   * @see com.safi.db.server.config.ConfigPackage#getSafiServer_AsteriskServers()
   * @see com.safi.db.server.config.AsteriskServer#getSafiServer
   * @model opposite="safiServer" containment="true"
   *        annotation="teneo.jpa appinfo='@OneToMany(fetch=\"EAGER\")'"
   * @generated
   */
  EList<AsteriskServer> getAsteriskServers();

  /**
   * Returns the value of the '<em><b>User</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>User</em>' containment reference.
   * @see #setUser(User)
   * @see com.safi.db.server.config.ConfigPackage#getSafiServer_User()
   * @model containment="true"
   * @generated
   */
  User getUser();

  /**
   * Sets the value of the '{@link com.safi.db.server.config.SafiServer#getUser <em>User</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>User</em>' containment reference.
   * @see #getUser()
   * @generated
   */
  void setUser(User value);

  /**
   * Returns the value of the '<em><b>Users</b></em>' containment reference list.
   * The list contents are of type {@link com.safi.db.server.config.User}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Users</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Users</em>' containment reference list.
   * @see com.safi.db.server.config.ConfigPackage#getSafiServer_Users()
   * @model containment="true"
   *        annotation="teneo.jpa appinfo='@OneToMany(fetch=\"EAGER\")'"
   * @generated
   */
  EList<User> getUsers();

  /**
   * Returns the value of the '<em><b>Running</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Running</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Running</em>' attribute.
   * @see #setRunning(boolean)
   * @see com.safi.db.server.config.ConfigPackage#getSafiServer_Running()
   * @model transient="true"
   *        annotation="teneo.jpa appinfo='@Transient'"
   * @generated
   */
  boolean isRunning();

  /**
   * Sets the value of the '{@link com.safi.db.server.config.SafiServer#isRunning <em>Running</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Running</em>' attribute.
   * @see #isRunning()
   * @generated
   */
  void setRunning(boolean value);

  /**
   * Returns the value of the '<em><b>Debug</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Debug</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Debug</em>' attribute.
   * @see #setDebug(boolean)
   * @see com.safi.db.server.config.ConfigPackage#getSafiServer_Debug()
   * @model transient="true"
   *        annotation="teneo.jpa appinfo='@Transient'"
   * @generated
   */
  boolean isDebug();

  /**
   * Sets the value of the '{@link com.safi.db.server.config.SafiServer#isDebug <em>Debug</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Debug</em>' attribute.
   * @see #isDebug()
   * @generated
   */
  void setDebug(boolean value);

  /**
   * Returns the value of the '<em><b>Db Port</b></em>' attribute.
   * The default value is <code>"7021"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Db Port</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Db Port</em>' attribute.
   * @see #setDbPort(int)
   * @see com.safi.db.server.config.ConfigPackage#getSafiServer_DbPort()
   * @model default="7021"
   * @generated
   */
  int getDbPort();

  /**
   * Sets the value of the '{@link com.safi.db.server.config.SafiServer#getDbPort <em>Db Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Db Port</em>' attribute.
   * @see #getDbPort()
   * @generated
   */
  void setDbPort(int value);

} // SafiServer
