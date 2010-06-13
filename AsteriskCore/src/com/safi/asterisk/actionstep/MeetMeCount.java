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
 * A representation of the model object '<em><b>Meet Me Count</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMeCount#getConferenceNumber <em>Conference Number</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMeCount#getVariableName <em>Variable Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMeCount()
 * @model
 * @generated
 */
public interface MeetMeCount extends AsteriskActionStep, CallConsumer1 {
	/**
	 * Returns the value of the '<em><b>Conference Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Conference Number</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Conference Number</em>' containment reference.
	 * @see #setConferenceNumber(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMeCount_ConferenceNumber()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the conference number' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
	DynamicValue getConferenceNumber();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMeCount#getConferenceNumber <em>Conference Number</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conference Number</em>' containment reference.
	 * @see #getConferenceNumber()
	 * @generated
	 */
	void setConferenceNumber(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Variable Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Name</em>' containment reference.
	 * @see #setVariableName(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMeCount_VariableName()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the name of the variable in which to store the count' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 *        annotation="Directionality output='true'"
	 *        annotation="MetaProperty displayText='Variable'"
	 * @generated
	 */
	DynamicValue getVariableName();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMeCount#getVariableName <em>Variable Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Name</em>' containment reference.
	 * @see #getVariableName()
	 * @generated
	 */
	void setVariableName(DynamicValue value);

} // MeetMeCount
