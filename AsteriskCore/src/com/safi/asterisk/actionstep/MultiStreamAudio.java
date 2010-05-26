/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import org.eclipse.emf.common.util.EList;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.AudioFileItem;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.call.CallConsumer1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multi Stream Audio</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.MultiStreamAudio#getEscapeDigits <em>Escape Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MultiStreamAudio#getAudioFilenames <em>Audio Filenames</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMultiStreamAudio()
 * @model
 * @generated
 */
public interface MultiStreamAudio extends ActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Escape Digits</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Escape Digits</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Escape Digits</em>' containment reference.
	 * @see #setEscapeDigits(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMultiStreamAudio_EscapeDigits()
	 * @model containment="true"
	 *        annotation="DynamicValueAnnotation type='ScriptText' isTypeLocked='false' description='DTMF characters that will cause the audio playback to stop' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getEscapeDigits();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MultiStreamAudio#getEscapeDigits <em>Escape Digits</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Escape Digits</em>' containment reference.
	 * @see #getEscapeDigits()
	 * @generated
	 */
  void setEscapeDigits(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Audio Filenames</b></em>' containment reference list.
	 * The list contents are of type {@link com.safi.core.actionstep.AudioFileItem}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Audio Filenames</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Audio Filenames</em>' containment reference list.
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMultiStreamAudio_AudioFilenames()
	 * @model containment="true" ordered="false"
	 *        annotation="Required criteria='non-empty'"
	 * @generated
	 */
  EList<AudioFileItem> getAudioFilenames();

} // MultiStreamAudio
