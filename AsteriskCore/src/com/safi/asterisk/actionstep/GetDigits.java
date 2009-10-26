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
 * A representation of the model object '<em><b>Get Digits</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.GetDigits#getInputTimeout <em>Input Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetDigits#isUseBufferedDigits <em>Use Buffered Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetDigits#getEscapeDigits <em>Escape Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetDigits#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetDigits#getMaxDigits <em>Max Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetDigits#getAcceptedDigits <em>Accepted Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetDigits()
 * @model
 * @generated
 */
public interface GetDigits extends ActionStep, CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Input Timeout</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Input Timeout</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Input Timeout</em>' attribute.
   * @see #setInputTimeout(long)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetDigits_InputTimeout()
   * @model default="-1"
   *        annotation="unitsTime milliseconds='true'"
   * @generated
   */
  long getInputTimeout();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.GetDigits#getInputTimeout <em>Input Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Input Timeout</em>' attribute.
   * @see #getInputTimeout()
   * @generated
   */
  void setInputTimeout(long value);

  /**
   * Returns the value of the '<em><b>Use Buffered Digits</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Buffered Digits</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Buffered Digits</em>' attribute.
   * @see #setUseBufferedDigits(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetDigits_UseBufferedDigits()
   * @model ordered="false"
   * @generated
   */
  boolean isUseBufferedDigits();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.GetDigits#isUseBufferedDigits <em>Use Buffered Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Use Buffered Digits</em>' attribute.
   * @see #isUseBufferedDigits()
   * @generated
   */
  void setUseBufferedDigits(boolean value);

  /**
   * Returns the value of the '<em><b>Escape Digits</b></em>' attribute.
   * The default value is <code>"#"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Escape Digits</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Escape Digits</em>' attribute.
   * @see #setEscapeDigits(String)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetDigits_EscapeDigits()
   * @model default="#" ordered="false"
   * @generated
   */
  String getEscapeDigits();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.GetDigits#getEscapeDigits <em>Escape Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escape Digits</em>' attribute.
   * @see #getEscapeDigits()
   * @generated
   */
  void setEscapeDigits(String value);

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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetDigits_VariableName()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The assignee variable' expectedReturnType='Text' helperClass=''"
   *        annotation="Directionality output='true'"
   *        annotation="MetaProperty displayText='Variable'"
   * @generated
   */
  DynamicValue getVariableName();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.GetDigits#getVariableName <em>Variable Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable Name</em>' containment reference.
   * @see #getVariableName()
   * @generated
   */
  void setVariableName(DynamicValue value);

  /**
   * Returns the value of the '<em><b>Max Digits</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Digits</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Digits</em>' attribute.
   * @see #setMaxDigits(int)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetDigits_MaxDigits()
   * @model default="1" ordered="false"
   * @generated
   */
  int getMaxDigits();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.GetDigits#getMaxDigits <em>Max Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Digits</em>' attribute.
   * @see #getMaxDigits()
   * @generated
   */
  void setMaxDigits(int value);

  /**
   * Returns the value of the '<em><b>Accepted Digits</b></em>' attribute.
   * The default value is <code>"0123456789#"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Accepted Digits</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Accepted Digits</em>' attribute.
   * @see #setAcceptedDigits(String)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetDigits_AcceptedDigits()
   * @model default="0123456789#" ordered="false"
   * @generated
   */
  String getAcceptedDigits();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.GetDigits#getAcceptedDigits <em>Accepted Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Accepted Digits</em>' attribute.
   * @see #getAcceptedDigits()
   * @generated
   */
  void setAcceptedDigits(String value);

} // GetDigits
