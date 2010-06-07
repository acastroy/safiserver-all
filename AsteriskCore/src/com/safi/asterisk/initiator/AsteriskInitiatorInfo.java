/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator;

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.manager.ManagerConnection;

import com.safi.core.initiator.InitiatorInfo;
import com.safi.db.astdb.AsteriskServer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asterisk Initiator Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getChannel <em>Channel</em>}</li>
 *   <li>{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getRequest <em>Request</em>}</li>
 *   <li>{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getManagerConnection <em>Manager Connection</em>}</li>
 *   <li>{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getAsteriskServer <em>Asterisk Server</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.initiator.InitiatorPackage#getAsteriskInitiatorInfo()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AsteriskInitiatorInfo extends InitiatorInfo {

  /**
	 * Returns the value of the '<em><b>Channel</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Channel</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' attribute.
	 * @see #setChannel(AgiChannel)
	 * @see com.safi.asterisk.initiator.InitiatorPackage#getAsteriskInitiatorInfo_Channel()
	 * @model dataType="com.safi.asterisk.AgiChannel"
	 * @generated
	 */
  AgiChannel getChannel();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getChannel <em>Channel</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' attribute.
	 * @see #getChannel()
	 * @generated
	 */
  void setChannel(AgiChannel value);

  /**
	 * Returns the value of the '<em><b>Request</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Request</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Request</em>' attribute.
	 * @see #setRequest(AgiRequest)
	 * @see com.safi.asterisk.initiator.InitiatorPackage#getAsteriskInitiatorInfo_Request()
	 * @model dataType="com.safi.asterisk.AgiRequest"
	 * @generated
	 */
  AgiRequest getRequest();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getRequest <em>Request</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Request</em>' attribute.
	 * @see #getRequest()
	 * @generated
	 */
  void setRequest(AgiRequest value);

  /**
	 * Returns the value of the '<em><b>Manager Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Manager Connection</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager Connection</em>' attribute.
	 * @see #setManagerConnection(ManagerConnection)
	 * @see com.safi.asterisk.initiator.InitiatorPackage#getAsteriskInitiatorInfo_ManagerConnection()
	 * @model dataType="com.safi.asterisk.ManagerConnection"
	 * @generated
	 */
  ManagerConnection getManagerConnection();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getManagerConnection <em>Manager Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager Connection</em>' attribute.
	 * @see #getManagerConnection()
	 * @generated
	 */
  void setManagerConnection(ManagerConnection value);

		/**
	 * Returns the value of the '<em><b>Asterisk Server</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asterisk Server</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asterisk Server</em>' reference.
	 * @see #setAsteriskServer(AsteriskServer)
	 * @see com.safi.asterisk.initiator.InitiatorPackage#getAsteriskInitiatorInfo_AsteriskServer()
	 * @model
	 * @generated
	 */
	AsteriskServer getAsteriskServer();

		/**
	 * Sets the value of the '{@link com.safi.asterisk.initiator.AsteriskInitiatorInfo#getAsteriskServer <em>Asterisk Server</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Asterisk Server</em>' reference.
	 * @see #getAsteriskServer()
	 * @generated
	 */
	void setAsteriskServer(AsteriskServer value);
} // AsteriskInitiatorInfo
