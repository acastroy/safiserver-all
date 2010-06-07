/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.call.CallConsumer1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Global Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SetGlobalVariable#getValue <em>Value</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.SetGlobalVariable#getVariable <em>Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetGlobalVariable()
 * @model
 * @generated
 */
public interface SetGlobalVariable extends AsteriskActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetGlobalVariable_Value()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the value to be assigned to the asterisk global variable' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getValue();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.SetGlobalVariable#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
  void setValue(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' attribute.
	 * @see #setVariable(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetGlobalVariable_Variable()
	 * @model ordered="false"
	 *        annotation="Required criteria='non-blank'"
	 * @generated
	 */
  String getVariable();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.SetGlobalVariable#getVariable <em>Variable</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' attribute.
	 * @see #getVariable()
	 * @generated
	 */
  void setVariable(String value);

} // SetGlobalVariable
