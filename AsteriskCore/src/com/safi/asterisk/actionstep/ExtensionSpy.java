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
 * A representation of the model object '<em><b>Extension Spy</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionSpy#getExtension <em>Extension</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionSpy#getContext <em>Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionSpy#isSpyBridgedOnly <em>Spy Bridged Only</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionSpy#getGroup <em>Group</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionSpy#isBeep <em>Beep</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionSpy#getRecordFilenamePrefix <em>Record Filename Prefix</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionSpy#getVolume <em>Volume</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionSpy#isWhisperEnabled <em>Whisper Enabled</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionSpy#isPrivateWhisperEnabled <em>Private Whisper Enabled</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.ExtensionSpy#getChannelName <em>Channel Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionSpy()
 * @model
 * @generated
 */
public interface ExtensionSpy extends ActionStep, CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Extension</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Extension</em>' containment reference.
   * @see #setExtension(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionSpy_Extension()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the extension of the channel name to spy on' expectedReturnType='Text' helperClass=''"
   * @generated
   */
  DynamicValue getExtension();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionSpy#getExtension <em>Extension</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extension</em>' containment reference.
   * @see #getExtension()
   * @generated
   */
  void setExtension(DynamicValue value);

  /**
   * Returns the value of the '<em><b>Context</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Context</em>' containment reference.
   * @see #setContext(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionSpy_Context()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The context of the channel to spy on' expectedReturnType='Text' helperClass=''"
   * @generated
   */
  DynamicValue getContext();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionSpy#getContext <em>Context</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context</em>' containment reference.
   * @see #getContext()
   * @generated
   */
  void setContext(DynamicValue value);

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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionSpy_SpyBridgedOnly()
   * @model ordered="false"
   * @generated
   */
  boolean isSpyBridgedOnly();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionSpy#isSpyBridgedOnly <em>Spy Bridged Only</em>}' attribute.
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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionSpy_Group()
   * @model ordered="false"
   * @generated
   */
  String getGroup();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionSpy#getGroup <em>Group</em>}' attribute.
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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionSpy_Beep()
   * @model default="true" ordered="false"
   * @generated
   */
  boolean isBeep();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionSpy#isBeep <em>Beep</em>}' attribute.
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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionSpy_RecordFilenamePrefix()
   * @model ordered="false"
   * @generated
   */
  String getRecordFilenamePrefix();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionSpy#getRecordFilenamePrefix <em>Record Filename Prefix</em>}' attribute.
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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionSpy_Volume()
   * @model ordered="false"
   * @generated
   */
  int getVolume();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionSpy#getVolume <em>Volume</em>}' attribute.
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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionSpy_WhisperEnabled()
   * @model ordered="false"
   * @generated
   */
  boolean isWhisperEnabled();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionSpy#isWhisperEnabled <em>Whisper Enabled</em>}' attribute.
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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionSpy_PrivateWhisperEnabled()
   * @model ordered="false"
   * @generated
   */
  boolean isPrivateWhisperEnabled();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionSpy#isPrivateWhisperEnabled <em>Private Whisper Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Private Whisper Enabled</em>' attribute.
   * @see #isPrivateWhisperEnabled()
   * @generated
   */
  void setPrivateWhisperEnabled(boolean value);

  /**
   * Returns the value of the '<em><b>Channel Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Channel Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Channel Name</em>' containment reference.
   * @see #setChannelName(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getExtensionSpy_ChannelName()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the name of the channel name to spy on' expectedReturnType='Text' helperClass=''"
   * @generated
   */
  DynamicValue getChannelName();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.ExtensionSpy#getChannelName <em>Channel Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Channel Name</em>' containment reference.
   * @see #getChannelName()
   * @generated
   */
  void setChannelName(DynamicValue value);

} // ExtensionSpy
