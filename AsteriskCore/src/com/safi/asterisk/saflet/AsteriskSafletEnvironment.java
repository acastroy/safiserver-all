/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.saflet;

import com.safi.core.saflet.SafletEnvironment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asterisk Saflet Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment#getServerIpAddr <em>Server Ip Addr</em>}</li>
 *   <li>{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment#getFastAgiPort <em>Fast Agi Port</em>}</li>
 *   <li>{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment#getManagementPort <em>Management Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.saflet.SafletPackage#getAsteriskSafletEnvironment()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AsteriskSafletEnvironment extends SafletEnvironment {
  /**
   * Returns the value of the '<em><b>Server Ip Addr</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Server Ip Addr</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Server Ip Addr</em>' attribute.
   * @see #setServerIpAddr(String)
   * @see com.safi.asterisk.saflet.SafletPackage#getAsteriskSafletEnvironment_ServerIpAddr()
   * @model
   * @generated
   */
  String getServerIpAddr();

  /**
   * Sets the value of the '{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment#getServerIpAddr <em>Server Ip Addr</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Server Ip Addr</em>' attribute.
   * @see #getServerIpAddr()
   * @generated
   */
  void setServerIpAddr(String value);

  /**
   * Returns the value of the '<em><b>Fast Agi Port</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fast Agi Port</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fast Agi Port</em>' attribute.
   * @see #setFastAgiPort(int)
   * @see com.safi.asterisk.saflet.SafletPackage#getAsteriskSafletEnvironment_FastAgiPort()
   * @model
   * @generated
   */
  int getFastAgiPort();

  /**
   * Sets the value of the '{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment#getFastAgiPort <em>Fast Agi Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fast Agi Port</em>' attribute.
   * @see #getFastAgiPort()
   * @generated
   */
  void setFastAgiPort(int value);

  /**
   * Returns the value of the '<em><b>Management Port</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Management Port</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Management Port</em>' attribute.
   * @see #setManagementPort(int)
   * @see com.safi.asterisk.saflet.SafletPackage#getAsteriskSafletEnvironment_ManagementPort()
   * @model
   * @generated
   */
  int getManagementPort();

  /**
   * Sets the value of the '{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment#getManagementPort <em>Management Port</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Management Port</em>' attribute.
   * @see #getManagementPort()
   * @generated
   */
  void setManagementPort(int value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Object getLoopbackCall(String uuid);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Object getLoopbackLock(String uuid);

  void setLoopbackLock(String string);

} // AsteriskSafletEnvironment
