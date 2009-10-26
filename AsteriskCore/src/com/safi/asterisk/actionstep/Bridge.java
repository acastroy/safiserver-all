/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.asterisk.CallConsumer2;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Bridge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.Bridge#getChannel1 <em>Channel1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Bridge#getChannel2 <em>Channel2</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Bridge#isUseCourtesyTone <em>Use Courtesy Tone</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getBridge()
 * @model
 * @generated
 */
public interface Bridge extends ActionStep, CallConsumer2 {
  /**
   * Returns the value of the '<em><b>Channel1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Channel1</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Channel1</em>' containment reference.
   * @see #setChannel1(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getBridge_Channel1()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Name of channel1' expectedReturnType='Text' helperClass=''"
   * @generated
   */
  DynamicValue getChannel1();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Bridge#getChannel1 <em>Channel1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Channel1</em>' containment reference.
   * @see #getChannel1()
   * @generated
   */
  void setChannel1(DynamicValue value);

  /**
   * Returns the value of the '<em><b>Channel2</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Channel2</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Channel2</em>' containment reference.
   * @see #setChannel2(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getBridge_Channel2()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Name of channel2' expectedReturnType='Text' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getChannel2();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Bridge#getChannel2 <em>Channel2</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Channel2</em>' containment reference.
   * @see #getChannel2()
   * @generated
   */
  void setChannel2(DynamicValue value);

  /**
   * Returns the value of the '<em><b>Use Courtesy Tone</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Courtesy Tone</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Courtesy Tone</em>' attribute.
   * @see #setUseCourtesyTone(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getBridge_UseCourtesyTone()
   * @model ordered="false"
   * @generated
   */
  boolean isUseCourtesyTone();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Bridge#isUseCourtesyTone <em>Use Courtesy Tone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use Courtesy Tone</em>' attribute.
   * @see #isUseCourtesyTone()
   * @generated
   */
  void setUseCourtesyTone(boolean value);

} // Bridge
