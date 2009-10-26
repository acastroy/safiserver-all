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
 * A representation of the model object '<em><b>Say Alpha</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SayAlpha#getEscapeDigits <em>Escape Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.SayAlpha#getText <em>Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayAlpha()
 * @model
 * @generated
 */
public interface SayAlpha extends ActionStep, CallConsumer1 {
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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayAlpha_EscapeDigits()
   * @model default="#" ordered="false"
   * @generated
   */
  String getEscapeDigits();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.SayAlpha#getEscapeDigits <em>Escape Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escape Digits</em>' attribute.
   * @see #getEscapeDigits()
   * @generated
   */
  void setEscapeDigits(String value);

  /**
   * Returns the value of the '<em><b>Text</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Text</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' containment reference.
   * @see #setText(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayAlpha_Text()
   * @model containment="true"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The text to be verbalized letter by letter' expectedReturnType='Text' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getText();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.SayAlpha#getText <em>Text</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' containment reference.
   * @see #getText()
   * @generated
   */
  void setText(DynamicValue value);

} // SayAlpha
