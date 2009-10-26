/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.asterisk.CallConsumer1;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Priority</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SetPriority#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetPriority()
 * @model
 * @generated
 */
public interface SetPriority extends ActionStep, CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Priority</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority</em>' containment reference.
   * @see #setPriority(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetPriority_Priority()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The priority of the current call will be set to this numeric value.' expectedReturnType='Integer' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getPriority();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.SetPriority#getPriority <em>Priority</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority</em>' containment reference.
   * @see #getPriority()
   * @generated
   */
  void setPriority(DynamicValue value);

} // SetPriority
