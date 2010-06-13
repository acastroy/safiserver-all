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
 * A representation of the model object '<em><b>Execute Application</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.ExecuteApplication#getArguments <em>Arguments</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExecuteApplication#getApplication <em>Application</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getExecuteApplication()
 * @model
 * @generated
 */
public interface ExecuteApplication extends AsteriskActionStep, CallConsumer1 {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference.
	 * @see #setArguments(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getExecuteApplication_Arguments()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the parameters to pass to the application.  May be single text entry (ex. \"SIP/123\") or array or text. (ex. [\"Sip/123\",\"300\"...])' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
	DynamicValue getArguments();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.ExecuteApplication#getArguments <em>Arguments</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arguments</em>' containment reference.
	 * @see #getArguments()
	 * @generated
	 */
	void setArguments(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Application</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Application</em>' containment reference.
	 * @see #setApplication(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getExecuteApplication_Application()
	 * @model containment="true"
	 *        annotation="DynamicValueAnnotation type='ScriptText' isTypeLocked='false' description='The name of the application' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
	DynamicValue getApplication();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.ExecuteApplication#getApplication <em>Application</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application</em>' containment reference.
	 * @see #getApplication()
	 * @generated
	 */
	void setApplication(DynamicValue value);

} // ExecuteApplication
