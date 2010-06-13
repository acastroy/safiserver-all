/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.ParameterizedActionstep;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manager Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.ManagerAction#getManagerActionType <em>Manager Action Type</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ManagerAction#getManagerResponse <em>Manager Response</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getManagerAction()
 * @model
 * @generated
 */
public interface ManagerAction extends ParameterizedActionstep {
	/**
	 * Returns the value of the '<em><b>Manager Action Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.safi.asterisk.actionstep.ManagerActionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager Action Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager Action Type</em>' attribute.
	 * @see com.safi.asterisk.actionstep.ManagerActionType
	 * @see #setManagerActionType(ManagerActionType)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getManagerAction_ManagerActionType()
	 * @model
	 * @generated
	 */
	ManagerActionType getManagerActionType();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.ManagerAction#getManagerActionType <em>Manager Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager Action Type</em>' attribute.
	 * @see com.safi.asterisk.actionstep.ManagerActionType
	 * @see #getManagerActionType()
	 * @generated
	 */
	void setManagerActionType(ManagerActionType value);

	/**
	 * Returns the value of the '<em><b>Manager Response</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager Response</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager Response</em>' containment reference.
	 * @see #setManagerResponse(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getManagerAction_ManagerResponse()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The assignee variable' expectedReturnType='Object' helperClass=''"
	 *        annotation="Directionality output='true'"
	 *        annotation="MetaProperty displayText='Variable'"
	 * @generated
	 */
	DynamicValue getManagerResponse();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.ManagerAction#getManagerResponse <em>Manager Response</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager Response</em>' containment reference.
	 * @see #getManagerResponse()
	 * @generated
	 */
	void setManagerResponse(DynamicValue value);

} // ManagerAction
