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
 * A representation of the model object '<em><b>Set Caller Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SetCallerId#getCallerId <em>Caller Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetCallerId()
 * @model
 * @generated
 */
public interface SetCallerId extends AsteriskActionStep, CallConsumer1 {
	/**
	 * Returns the value of the '<em><b>Caller Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caller Id</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caller Id</em>' containment reference.
	 * @see #setCallerId(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetCallerId_CallerId()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The  caller ID of the current call will be set to this text value.' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
	DynamicValue getCallerId();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.SetCallerId#getCallerId <em>Caller Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caller Id</em>' containment reference.
	 * @see #getCallerId()
	 * @generated
	 */
	void setCallerId(DynamicValue value);

} // SetCallerId
