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
 * A representation of the model object '<em><b>Say Digits</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SayDigits#getDigits <em>Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.SayDigits#getEscapeDigits <em>Escape Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayDigits()
 * @model
 * @generated
 */
public interface SayDigits extends ActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Digits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Digits</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Digits</em>' containment reference.
	 * @see #setDigits(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayDigits_Digits()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The text containing only numeric values to be verbalized one digit at a time' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getDigits();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.SayDigits#getDigits <em>Digits</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Digits</em>' containment reference.
	 * @see #getDigits()
	 * @generated
	 */
  void setDigits(DynamicValue value);

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
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayDigits_EscapeDigits()
	 * @model default="#" ordered="false"
	 * @generated
	 */
  String getEscapeDigits();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.SayDigits#getEscapeDigits <em>Escape Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Escape Digits</em>' attribute.
	 * @see #getEscapeDigits()
	 * @generated
	 */
  void setEscapeDigits(String value);

} // SayDigits
