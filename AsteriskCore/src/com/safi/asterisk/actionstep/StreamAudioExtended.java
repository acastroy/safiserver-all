/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.core.actionstep.DynamicValue;

import com.safi.core.call.CallConsumer1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stream Audio Extended</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.StreamAudioExtended#getFilename <em>Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.StreamAudioExtended#getEscapeDigits <em>Escape Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.StreamAudioExtended#getOffset <em>Offset</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.StreamAudioExtended#getForwardDigit <em>Forward Digit</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.StreamAudioExtended#getRewindDigit <em>Rewind Digit</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.StreamAudioExtended#getPauseDigit <em>Pause Digit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getStreamAudioExtended()
 * @model
 * @generated
 */
public interface StreamAudioExtended extends AsteriskActionStep, CallConsumer1 {
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
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getStreamAudioExtended_Filename()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='Prompt Filename' isTypeLocked='false' description='The audio prompt file name that will be played' expectedReturnType='Text' helperClass='com.safi.workshop.sheet.PromptChooserDynamicValueEditorPage'"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
	DynamicValue getFilename();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getFilename <em>Filename</em>}' containment reference.
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
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getStreamAudioExtended_EscapeDigits()
	 * @model default="#" ordered="false"
	 * @generated
	 */
	String getEscapeDigits();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getEscapeDigits <em>Escape Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Escape Digits</em>' attribute.
	 * @see #getEscapeDigits()
	 * @generated
	 */
	void setEscapeDigits(String value);

	/**
	 * Returns the value of the '<em><b>Offset</b></em>' attribute.
	 * The default value is <code>"1000"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset</em>' attribute.
	 * @see #setOffset(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getStreamAudioExtended_Offset()
	 * @model default="1000" ordered="false"
	 * @generated
	 */
	int getOffset();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getOffset <em>Offset</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset</em>' attribute.
	 * @see #getOffset()
	 * @generated
	 */
	void setOffset(int value);

	/**
	 * Returns the value of the '<em><b>Forward Digit</b></em>' attribute.
	 * The default value is <code>"3"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Forward Digit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Forward Digit</em>' attribute.
	 * @see #setForwardDigit(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getStreamAudioExtended_ForwardDigit()
	 * @model default="3" ordered="false"
	 * @generated
	 */
	String getForwardDigit();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getForwardDigit <em>Forward Digit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Forward Digit</em>' attribute.
	 * @see #getForwardDigit()
	 * @generated
	 */
	void setForwardDigit(String value);

	/**
	 * Returns the value of the '<em><b>Rewind Digit</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rewind Digit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rewind Digit</em>' attribute.
	 * @see #setRewindDigit(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getStreamAudioExtended_RewindDigit()
	 * @model default="1" ordered="false"
	 * @generated
	 */
	String getRewindDigit();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getRewindDigit <em>Rewind Digit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rewind Digit</em>' attribute.
	 * @see #getRewindDigit()
	 * @generated
	 */
	void setRewindDigit(String value);

	/**
	 * Returns the value of the '<em><b>Pause Digit</b></em>' attribute.
	 * The default value is <code>"2"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pause Digit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pause Digit</em>' attribute.
	 * @see #setPauseDigit(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getStreamAudioExtended_PauseDigit()
	 * @model default="2" ordered="false"
	 * @generated
	 */
	String getPauseDigit();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.StreamAudioExtended#getPauseDigit <em>Pause Digit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pause Digit</em>' attribute.
	 * @see #getPauseDigit()
	 * @generated
	 */
	void setPauseDigit(String value);

} // StreamAudioExtended
