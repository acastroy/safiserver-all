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
 * A representation of the model object '<em><b>Voicemail</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.Voicemail#getMailbox <em>Mailbox</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Voicemail#isSkipInstructions <em>Skip Instructions</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Voicemail#isPlayUnavailableMessage <em>Play Unavailable Message</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Voicemail#isPlayBusyMessage <em>Play Busy Message</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Voicemail#getRecordingGain <em>Recording Gain</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getVoicemail()
 * @model
 * @generated
 */
public interface Voicemail extends ActionStep, CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Mailbox</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mailbox</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mailbox</em>' containment reference.
   * @see #setMailbox(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getVoicemail_Mailbox()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='an array of mailbox identifiers' expectedReturnType='Text' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getMailbox();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Voicemail#getMailbox <em>Mailbox</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mailbox</em>' containment reference.
   * @see #getMailbox()
   * @generated
   */
  void setMailbox(DynamicValue value);

  /**
   * Returns the value of the '<em><b>Skip Instructions</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Skip Instructions</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Skip Instructions</em>' attribute.
   * @see #setSkipInstructions(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getVoicemail_SkipInstructions()
   * @model ordered="false"
   * @generated
   */
  boolean isSkipInstructions();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Voicemail#isSkipInstructions <em>Skip Instructions</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Skip Instructions</em>' attribute.
   * @see #isSkipInstructions()
   * @generated
   */
  void setSkipInstructions(boolean value);

  /**
   * Returns the value of the '<em><b>Play Unavailable Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Play Unavailable Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Play Unavailable Message</em>' attribute.
   * @see #setPlayUnavailableMessage(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getVoicemail_PlayUnavailableMessage()
   * @model ordered="false"
   * @generated
   */
  boolean isPlayUnavailableMessage();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Voicemail#isPlayUnavailableMessage <em>Play Unavailable Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Play Unavailable Message</em>' attribute.
   * @see #isPlayUnavailableMessage()
   * @generated
   */
  void setPlayUnavailableMessage(boolean value);

  /**
   * Returns the value of the '<em><b>Play Busy Message</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Play Busy Message</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Play Busy Message</em>' attribute.
   * @see #setPlayBusyMessage(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getVoicemail_PlayBusyMessage()
   * @model ordered="false"
   * @generated
   */
  boolean isPlayBusyMessage();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Voicemail#isPlayBusyMessage <em>Play Busy Message</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Play Busy Message</em>' attribute.
   * @see #isPlayBusyMessage()
   * @generated
   */
  void setPlayBusyMessage(boolean value);

  /**
   * Returns the value of the '<em><b>Recording Gain</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Recording Gain</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Recording Gain</em>' attribute.
   * @see #setRecordingGain(int)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getVoicemail_RecordingGain()
   * @model default="-1" ordered="false"
   * @generated
   */
  int getRecordingGain();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Voicemail#getRecordingGain <em>Recording Gain</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Recording Gain</em>' attribute.
   * @see #getRecordingGain()
   * @generated
   */
  void setRecordingGain(int value);

} // Voicemail
