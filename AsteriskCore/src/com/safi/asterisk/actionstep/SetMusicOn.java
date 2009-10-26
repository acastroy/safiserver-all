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
 * A representation of the model object '<em><b>Set Music On</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SetMusicOn#getHoldClass <em>Hold Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetMusicOn()
 * @model
 * @generated
 */
public interface SetMusicOn extends ActionStep, CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Hold Class</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hold Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Hold Class</em>' containment reference.
   * @see #setHoldClass(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetMusicOn_HoldClass()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The Asterisk music class to play.' expectedReturnType='Text' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getHoldClass();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.SetMusicOn#getHoldClass <em>Hold Class</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Hold Class</em>' containment reference.
   * @see #getHoldClass()
   * @generated
   */
  void setHoldClass(DynamicValue value);

} // SetMusicOn
