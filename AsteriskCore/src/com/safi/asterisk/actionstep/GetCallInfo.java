/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.core.actionstep.DynamicValue;

import com.safi.core.call.CallConsumer1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Get Call Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getAccountCodeVar <em>Account Code Var</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getCallerIdNameVar <em>Caller Id Name Var</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getCallerIdNumVar <em>Caller Id Num Var</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getChannelNameVar <em>Channel Name Var</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getContextVar <em>Context Var</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getExtensionVar <em>Extension Var</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getDialedNumber <em>Dialed Number</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getPriorityVar <em>Priority Var</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getStateVar <em>State Var</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getUniqueIdVar <em>Unique Id Var</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getAni2Var <em>Ani2 Var</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getRdnis <em>Rdnis</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetCallInfo#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo()
 * @model
 * @generated
 */
public interface GetCallInfo extends AsteriskActionStep, CallConsumer1 {
	/**
	 * Returns the value of the '<em><b>Account Code Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Account Code Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Account Code Var</em>' containment reference.
	 * @see #setAccountCodeVar(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_AccountCodeVar()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the account code of the current call will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getAccountCodeVar();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getAccountCodeVar <em>Account Code Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account Code Var</em>' containment reference.
	 * @see #getAccountCodeVar()
	 * @generated
	 */
	void setAccountCodeVar(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Caller Id Name Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caller Id Name Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caller Id Name Var</em>' containment reference.
	 * @see #setCallerIdNameVar(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_CallerIdNameVar()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the caller ID name of the current call will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getCallerIdNameVar();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getCallerIdNameVar <em>Caller Id Name Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caller Id Name Var</em>' containment reference.
	 * @see #getCallerIdNameVar()
	 * @generated
	 */
	void setCallerIdNameVar(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Caller Id Num Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caller Id Num Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caller Id Num Var</em>' containment reference.
	 * @see #setCallerIdNumVar(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_CallerIdNumVar()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the caller ID number of the current call will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getCallerIdNumVar();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getCallerIdNumVar <em>Caller Id Num Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caller Id Num Var</em>' containment reference.
	 * @see #getCallerIdNumVar()
	 * @generated
	 */
	void setCallerIdNumVar(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Channel Name Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Channel Name Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Name Var</em>' containment reference.
	 * @see #setChannelNameVar(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_ChannelNameVar()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the channel name of the current call will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getChannelNameVar();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getChannelNameVar <em>Channel Name Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Name Var</em>' containment reference.
	 * @see #getChannelNameVar()
	 * @generated
	 */
	void setChannelNameVar(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Context Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context Var</em>' containment reference.
	 * @see #setContextVar(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_ContextVar()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the context of the current call will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getContextVar();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getContextVar <em>Context Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context Var</em>' containment reference.
	 * @see #getContextVar()
	 * @generated
	 */
	void setContextVar(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Extension Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension Var</em>' containment reference.
	 * @see #setExtensionVar(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_ExtensionVar()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the extension of the current call will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getExtensionVar();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getExtensionVar <em>Extension Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension Var</em>' containment reference.
	 * @see #getExtensionVar()
	 * @generated
	 */
	void setExtensionVar(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Dialed Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dialed Number</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dialed Number</em>' containment reference.
	 * @see #setDialedNumber(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_DialedNumber()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the dialed number (DNID) of the current call will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getDialedNumber();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getDialedNumber <em>Dialed Number</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dialed Number</em>' containment reference.
	 * @see #getDialedNumber()
	 * @generated
	 */
	void setDialedNumber(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Priority Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority Var</em>' containment reference.
	 * @see #setPriorityVar(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_PriorityVar()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the priority of the current call will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getPriorityVar();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getPriorityVar <em>Priority Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority Var</em>' containment reference.
	 * @see #getPriorityVar()
	 * @generated
	 */
	void setPriorityVar(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>State Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Var</em>' containment reference.
	 * @see #setStateVar(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_StateVar()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the state (see below) of the current call will be assigned.\r\n    *  0 Channel is down and available\r\n    * 1 Channel is down, but reserved\r\n    * 2 Channel is off hook\r\n    * 3 Digits (or equivalent) have been dialed\r\n    * 4 Line is ringing\r\n    * 5 Remote end is ringing\r\n    * 6 Line is up\r\n    * 7 Line is busy ' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getStateVar();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getStateVar <em>State Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Var</em>' containment reference.
	 * @see #getStateVar()
	 * @generated
	 */
	void setStateVar(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Unique Id Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unique Id Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique Id Var</em>' containment reference.
	 * @see #setUniqueIdVar(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_UniqueIdVar()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the unique ID of the current call will be assigned.' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getUniqueIdVar();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getUniqueIdVar <em>Unique Id Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique Id Var</em>' containment reference.
	 * @see #getUniqueIdVar()
	 * @generated
	 */
	void setUniqueIdVar(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Ani2 Var</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ani2 Var</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ani2 Var</em>' containment reference.
	 * @see #setAni2Var(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_Ani2Var()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the ani2 info of the current call will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getAni2Var();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getAni2Var <em>Ani2 Var</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ani2 Var</em>' containment reference.
	 * @see #getAni2Var()
	 * @generated
	 */
	void setAni2Var(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Rdnis</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rdnis</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rdnis</em>' containment reference.
	 * @see #setRdnis(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_Rdnis()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the forwarding number (RDNIS) of the current call will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getRdnis();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getRdnis <em>Rdnis</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rdnis</em>' containment reference.
	 * @see #getRdnis()
	 * @generated
	 */
	void setRdnis(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' containment reference.
	 * @see #setType(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetCallInfo_Type()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where the call type (e.g. SIP) of the current call will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getType();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetCallInfo#getType <em>Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' containment reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DynamicValue value);

} // GetCallInfo
