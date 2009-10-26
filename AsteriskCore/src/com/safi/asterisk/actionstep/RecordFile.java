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
 * A representation of the model object '<em><b>Record File</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.RecordFile#isBeep <em>Beep</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.RecordFile#getEscapeDigits <em>Escape Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.RecordFile#getFile <em>File</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.RecordFile#getFormat <em>Format</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.RecordFile#getOffset <em>Offset</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.RecordFile#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.RecordFile#getMaxSilence <em>Max Silence</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordFile()
 * @model
 * @generated
 */
public interface RecordFile extends CallConsumer1, ActionStep {
  /**
   * Returns the value of the '<em><b>Beep</b></em>' attribute.
   * The default value is <code>"true"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Beep</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Beep</em>' attribute.
   * @see #setBeep(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordFile_Beep()
   * @model default="true" ordered="false"
   * @generated
   */
  boolean isBeep();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.RecordFile#isBeep <em>Beep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Beep</em>' attribute.
   * @see #isBeep()
   * @generated
   */
  void setBeep(boolean value);

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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordFile_EscapeDigits()
   * @model default="#" ordered="false"
   * @generated
   */
  String getEscapeDigits();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.RecordFile#getEscapeDigits <em>Escape Digits</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Escape Digits</em>' attribute.
   * @see #getEscapeDigits()
   * @generated
   */
  void setEscapeDigits(String value);

  /**
   * Returns the value of the '<em><b>File</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File</em>' containment reference.
   * @see #setFile(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordFile_File()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The name of the file that will be recorded (file extension omitted). ' expectedReturnType='Text' helperClass='com.safi.asterisk.diagram.sheet.assist.FileBrowserAssistant'"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getFile();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.RecordFile#getFile <em>File</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' containment reference.
   * @see #getFile()
   * @generated
   */
  void setFile(DynamicValue value);

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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordFile_Format()
   * @model default="wav" ordered="false"
   * @generated
   */
  String getFormat();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.RecordFile#getFormat <em>Format</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Format</em>' attribute.
   * @see #getFormat()
   * @generated
   */
  void setFormat(String value);

  /**
   * Returns the value of the '<em><b>Offset</b></em>' attribute.
   * The default value is <code>"0"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Offset</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Offset</em>' attribute.
   * @see #setOffset(int)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordFile_Offset()
   * @model default="0" ordered="false"
   * @generated
   */
  int getOffset();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.RecordFile#getOffset <em>Offset</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Offset</em>' attribute.
   * @see #getOffset()
   * @generated
   */
  void setOffset(int value);

  /**
   * Returns the value of the '<em><b>Timeout</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Timeout</em>' attribute.
   * @see #setTimeout(long)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordFile_Timeout()
   * @model default="-1" ordered="false"
   *        annotation="unitsTime milliseconds='true'"
   * @generated
   */
  long getTimeout();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.RecordFile#getTimeout <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timeout</em>' attribute.
   * @see #getTimeout()
   * @generated
   */
  void setTimeout(long value);

  /**
   * Returns the value of the '<em><b>Max Silence</b></em>' attribute.
   * The default value is <code>"5"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Silence</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Silence</em>' attribute.
   * @see #setMaxSilence(long)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getRecordFile_MaxSilence()
   * @model default="5" ordered="false"
   *        annotation="unitsTime seconds='true'"
   * @generated
   */
  long getMaxSilence();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.RecordFile#getMaxSilence <em>Max Silence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Silence</em>' attribute.
   * @see #getMaxSilence()
   * @generated
   */
  void setMaxSilence(long value);

} // RecordFile
