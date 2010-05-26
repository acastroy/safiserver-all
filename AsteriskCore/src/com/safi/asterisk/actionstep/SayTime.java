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
 * A representation of the model object '<em><b>Say Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SayTime#getEscapeDigits <em>Escape Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.SayTime#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayTime()
 * @model
 * @generated
 */
public interface SayTime extends ActionStep, CallConsumer1 {
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
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayTime_EscapeDigits()
	 * @model default="#" ordered="false"
	 * @generated
	 */
  String getEscapeDigits();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.SayTime#getEscapeDigits <em>Escape Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Escape Digits</em>' attribute.
	 * @see #getEscapeDigits()
	 * @generated
	 */
  void setEscapeDigits(String value);

  /**
	 * Returns the value of the '<em><b>Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Time</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' containment reference.
	 * @see #setTime(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayTime_Time()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The date/time to be verbalized.  May be a number\r\n (representing the number of seconds since 1970) or text in the format\r\n (XX/yy/zzzz) or Date object or variable.' expectedReturnType='Unknown' helperClass=''"
	 * @generated
	 */
  DynamicValue getTime();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.SayTime#getTime <em>Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' containment reference.
	 * @see #getTime()
	 * @generated
	 */
  void setTime(DynamicValue value);

} // SayTime
