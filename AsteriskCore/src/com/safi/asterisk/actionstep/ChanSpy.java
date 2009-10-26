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
 * A representation of the model object '<em><b>Chan Spy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.ChanSpy#getChannelnamePrefix <em>Channelname Prefix</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ChanSpy#isSpyBridgedOnly <em>Spy Bridged Only</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ChanSpy#getGroup <em>Group</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ChanSpy#isBeep <em>Beep</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ChanSpy#getRecordFilenamePrefix <em>Record Filename Prefix</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ChanSpy#getVolume <em>Volume</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ChanSpy#isWhisperEnabled <em>Whisper Enabled</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ChanSpy#isPrivateWhisperEnabled <em>Private Whisper Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getChanSpy()
 * @model
 * @generated
 */
public interface ChanSpy extends ActionStep, CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Channelname Prefix</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Channelname Prefix</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Channelname Prefix</em>' containment reference.
   * @see #setChannelnamePrefix(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getChanSpy_ChannelnamePrefix()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the prefix of the channel name to spy on' expectedReturnType='Text' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getChannelnamePrefix();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ChanSpy#getChannelnamePrefix <em>Channelname Prefix</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Channelname Prefix</em>' containment reference.
   * @see #getChannelnamePrefix()
   * @generated
   */
  void setChannelnamePrefix(DynamicValue value);

  /**
   * Returns the value of the '<em><b>Spy Bridged Only</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Spy Bridged Only</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Spy Bridged Only</em>' attribute.
   * @see #setSpyBridgedOnly(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getChanSpy_SpyBridgedOnly()
   * @model ordered="false"
   * @generated
   */
  boolean isSpyBridgedOnly();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ChanSpy#isSpyBridgedOnly <em>Spy Bridged Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Spy Bridged Only</em>' attribute.
   * @see #isSpyBridgedOnly()
   * @generated
   */
  void setSpyBridgedOnly(boolean value);

  /**
   * Returns the value of the '<em><b>Group</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' attribute.
   * @see #setGroup(String)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getChanSpy_Group()
   * @model ordered="false"
   * @generated
   */
  String getGroup();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ChanSpy#getGroup <em>Group</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group</em>' attribute.
   * @see #getGroup()
   * @generated
   */
  void setGroup(String value);

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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getChanSpy_Beep()
   * @model default="true" ordered="false"
   * @generated
   */
  boolean isBeep();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ChanSpy#isBeep <em>Beep</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Beep</em>' attribute.
   * @see #isBeep()
   * @generated
   */
  void setBeep(boolean value);

  /**
   * Returns the value of the '<em><b>Record Filename Prefix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record Filename Prefix</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Record Filename Prefix</em>' attribute.
   * @see #setRecordFilenamePrefix(String)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getChanSpy_RecordFilenamePrefix()
   * @model ordered="false"
   * @generated
   */
  String getRecordFilenamePrefix();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ChanSpy#getRecordFilenamePrefix <em>Record Filename Prefix</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Record Filename Prefix</em>' attribute.
   * @see #getRecordFilenamePrefix()
   * @generated
   */
  void setRecordFilenamePrefix(String value);

  /**
   * Returns the value of the '<em><b>Volume</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Volume</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Volume</em>' attribute.
   * @see #setVolume(int)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getChanSpy_Volume()
   * @model ordered="false"
   * @generated
   */
  int getVolume();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ChanSpy#getVolume <em>Volume</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Volume</em>' attribute.
   * @see #getVolume()
   * @generated
   */
  void setVolume(int value);

  /**
   * Returns the value of the '<em><b>Whisper Enabled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Whisper Enabled</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Whisper Enabled</em>' attribute.
   * @see #setWhisperEnabled(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getChanSpy_WhisperEnabled()
   * @model ordered="false"
   * @generated
   */
  boolean isWhisperEnabled();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ChanSpy#isWhisperEnabled <em>Whisper Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Whisper Enabled</em>' attribute.
   * @see #isWhisperEnabled()
   * @generated
   */
  void setWhisperEnabled(boolean value);

  /**
   * Returns the value of the '<em><b>Private Whisper Enabled</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Private Whisper Enabled</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Private Whisper Enabled</em>' attribute.
   * @see #setPrivateWhisperEnabled(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getChanSpy_PrivateWhisperEnabled()
   * @model ordered="false"
   * @generated
   */
  boolean isPrivateWhisperEnabled();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ChanSpy#isPrivateWhisperEnabled <em>Private Whisper Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Private Whisper Enabled</em>' attribute.
   * @see #isPrivateWhisperEnabled()
   * @generated
   */
  void setPrivateWhisperEnabled(boolean value);

} // ChanSpy
