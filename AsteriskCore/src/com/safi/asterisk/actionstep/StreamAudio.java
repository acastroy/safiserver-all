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
 * A representation of the model object '<em><b>Stream Audio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.StreamAudio#getFilename <em>Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.StreamAudio#getEscapeDigits <em>Escape Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getStreamAudio()
 * @model
 * @generated
 */
public interface StreamAudio extends ActionStep, CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Filename</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filename</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filename</em>' containment reference.
   * @see #setFilename(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getStreamAudio_Filename()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='Prompt Filename' isTypeLocked='false' description='The audio prompt file name that will be played' expectedReturnType='Prompt Filename' helperClass='com.safi.asterisk.diagram.sheet.PromptChooserDynamicValueEditorPage'"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getFilename();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.StreamAudio#getFilename <em>Filename</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filename</em>' containment reference.
   * @see #getFilename()
   * @generated
   */
  void setFilename(DynamicValue value);

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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getStreamAudio_EscapeDigits()
   * @model default="#" ordered="false"
   * @generated
   */
  String getEscapeDigits();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.StreamAudio#getEscapeDigits <em>Escape Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escape Digits</em>' attribute.
   * @see #getEscapeDigits()
   * @generated
   */
  void setEscapeDigits(String value);

} // StreamAudio
