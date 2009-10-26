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
 * A representation of the model object '<em><b>Record Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.RecordCall#getFilename <em>Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.RecordCall#getFormat <em>Format</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.RecordCall#isMix <em>Mix</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordCall()
 * @model
 * @generated
 */
public interface RecordCall extends ActionStep, CallConsumer1 {
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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordCall_Filename()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The name of the file that will be recorded (file extension omitted). ' expectedReturnType='Text' helperClass='com.safi.asterisk.diagram.sheet.assist.DirBrowserAssistant'"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getFilename();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.RecordCall#getFilename <em>Filename</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filename</em>' containment reference.
   * @see #getFilename()
   * @generated
   */
  void setFilename(DynamicValue value);

  /**
   * Returns the value of the '<em><b>Format</b></em>' attribute.
   * The default value is <code>"wav"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Format</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Format</em>' attribute.
   * @see #setFormat(String)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordCall_Format()
   * @model default="wav" ordered="false"
   * @generated
   */
  String getFormat();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.RecordCall#getFormat <em>Format</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Format</em>' attribute.
   * @see #getFormat()
   * @generated
   */
  void setFormat(String value);

  /**
   * Returns the value of the '<em><b>Mix</b></em>' attribute.
   * The default value is <code>"true"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mix</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mix</em>' attribute.
   * @see #setMix(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordCall_Mix()
   * @model default="true" ordered="false"
   * @generated
   */
  boolean isMix();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.RecordCall#isMix <em>Mix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mix</em>' attribute.
   * @see #isMix()
   * @generated
   */
  void setMix(boolean value);

} // RecordCall
