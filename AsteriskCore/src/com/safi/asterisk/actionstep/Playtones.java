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
 * A representation of the model object '<em><b>Playtones</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.Playtones#getTones <em>Tones</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPlaytones()
 * @model
 * @generated
 */
public interface Playtones extends ActionStep, CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Tones</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Tones</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Tones</em>' containment reference.
   * @see #setTones(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getPlaytones_Tones()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the tones or tone name to play' expectedReturnType='Text' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getTones();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Playtones#getTones <em>Tones</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Tones</em>' containment reference.
   * @see #getTones()
   * @generated
   */
  void setTones(DynamicValue value);

} // Playtones
