/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk;

import org.asteriskjava.fastagi.AgiChannel;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.Call#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.asterisk.Call#getChannel <em>Channel</em>}</li>
 *   <li>{@link com.safi.asterisk.Call#getCallerIdName <em>Caller Id Name</em>}</li>
 *   <li>{@link com.safi.asterisk.Call#getCallerIdNum <em>Caller Id Num</em>}</li>
 *   <li>{@link com.safi.asterisk.Call#getUniqueId <em>Unique Id</em>}</li>
 *   <li>{@link com.safi.asterisk.Call#getChannelName <em>Channel Name</em>}</li>
 *   <li>{@link com.safi.asterisk.Call#getCallState <em>Call State</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.AsteriskPackage#getCall()
 * @model
 * @generated
 */
public interface Call extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.safi.asterisk.AsteriskPackage#getCall_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.safi.asterisk.Call#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see com.safi.asterisk.AsteriskPackage#getCall_Channel()
   * @model dataType="com.safi.asterisk.AgiChannel" transient="true" volatile="true"
   * @generated
   */
  AgiChannel getChannel();

  /**
   * Sets the value of the '{@link com.safi.asterisk.Call#getChannel <em>Channel</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Channel</em>' attribute.
   * @see #getChannel()
   * @generated
   */
  void setChannel(AgiChannel value);

  /**
   * Returns the value of the '<em><b>Caller Id Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Caller Id Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Caller Id Name</em>' attribute.
   * @see #setCallerIdName(String)
   * @see com.safi.asterisk.AsteriskPackage#getCall_CallerIdName()
   * @model
   * @generated
   */
  String getCallerIdName();

  /**
   * Sets the value of the '{@link com.safi.asterisk.Call#getCallerIdName <em>Caller Id Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Caller Id Name</em>' attribute.
   * @see #getCallerIdName()
   * @generated
   */
  void setCallerIdName(String value);

  /**
   * Returns the value of the '<em><b>Caller Id Num</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Caller Id Num</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Caller Id Num</em>' attribute.
   * @see #setCallerIdNum(String)
   * @see com.safi.asterisk.AsteriskPackage#getCall_CallerIdNum()
   * @model
   * @generated
   */
  String getCallerIdNum();

  /**
   * Sets the value of the '{@link com.safi.asterisk.Call#getCallerIdNum <em>Caller Id Num</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Caller Id Num</em>' attribute.
   * @see #getCallerIdNum()
   * @generated
   */
  void setCallerIdNum(String value);

  /**
   * Returns the value of the '<em><b>Unique Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Unique Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Unique Id</em>' attribute.
   * @see #setUniqueId(String)
   * @see com.safi.asterisk.AsteriskPackage#getCall_UniqueId()
   * @model
   * @generated
   */
  String getUniqueId();

  /**
   * Sets the value of the '{@link com.safi.asterisk.Call#getUniqueId <em>Unique Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Unique Id</em>' attribute.
   * @see #getUniqueId()
   * @generated
   */
  void setUniqueId(String value);

  /**
   * Returns the value of the '<em><b>Channel Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Channel Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Channel Name</em>' attribute.
   * @see #setChannelName(String)
   * @see com.safi.asterisk.AsteriskPackage#getCall_ChannelName()
   * @model
   * @generated
   */
  String getChannelName();

  /**
   * Sets the value of the '{@link com.safi.asterisk.Call#getChannelName <em>Channel Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Channel Name</em>' attribute.
   * @see #getChannelName()
   * @generated
   */
  void setChannelName(String value);

  /**
   * Returns the value of the '<em><b>Call State</b></em>' attribute.
   * The literals are from the enumeration {@link com.safi.asterisk.CallState}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call State</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call State</em>' attribute.
   * @see com.safi.asterisk.CallState
   * @see #setCallState(CallState)
   * @see com.safi.asterisk.AsteriskPackage#getCall_CallState()
   * @model
   * @generated
   */
  CallState getCallState();

  /**
   * Sets the value of the '{@link com.safi.asterisk.Call#getCallState <em>Call State</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call State</em>' attribute.
   * @see com.safi.asterisk.CallState
   * @see #getCallState()
   * @generated
   */
  void setCallState(CallState value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  void setData(String name, Object value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  Object getData(String name);

} // Call
