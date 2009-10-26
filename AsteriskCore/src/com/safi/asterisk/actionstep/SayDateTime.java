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
 * A representation of the model object '<em><b>Say Date Time</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SayDateTime#getEscapeDigits <em>Escape Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.SayDateTime#getFormat <em>Format</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.SayDateTime#getDateTime <em>Date Time</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.SayDateTime#getTimezone <em>Timezone</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayDateTime()
 * @model
 * @generated
 */
public interface SayDateTime extends ActionStep, CallConsumer1 {
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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayDateTime_EscapeDigits()
   * @model default="#" ordered="false"
   * @generated
   */
  String getEscapeDigits();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.SayDateTime#getEscapeDigits <em>Escape Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escape Digits</em>' attribute.
   * @see #getEscapeDigits()
   * @generated
   */
  void setEscapeDigits(String value);

  /**
   * Returns the value of the '<em><b>Format</b></em>' attribute.
   * The default value is <code>"ABdY \\\'digits/at\\\' IMp"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Format</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Format</em>' attribute.
   * @see #setFormat(String)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayDateTime_Format()
   * @model default="ABdY \\\'digits/at\\\' IMp" ordered="false"
   * @generated
   */
  String getFormat();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.SayDateTime#getFormat <em>Format</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Format</em>' attribute.
   * @see #getFormat()
   * @generated
   */
  void setFormat(String value);

  /**
   * Returns the value of the '<em><b>Date Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Date Time</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Date Time</em>' containment reference.
   * @see #setDateTime(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayDateTime_DateTime()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The date/time to be verbalized.  May be a number\r\n (representing the number of seconds since 1970) or text in the format\r\n (XX/yy/zzzz) or Date object or variable.' expectedReturnType='Unknown' helperClass=''"
   * @generated
   */
  DynamicValue getDateTime();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.SayDateTime#getDateTime <em>Date Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Date Time</em>' containment reference.
   * @see #getDateTime()
   * @generated
   */
  void setDateTime(DynamicValue value);

  /**
   * Returns the value of the '<em><b>Timezone</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timezone</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timezone</em>' attribute.
   * @see #setTimezone(String)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getSayDateTime_Timezone()
   * @model ordered="false"
   * @generated
   */
  String getTimezone();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.SayDateTime#getTimezone <em>Timezone</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timezone</em>' attribute.
   * @see #getTimezone()
   * @generated
   */
  void setTimezone(String value);

} // SayDateTime
