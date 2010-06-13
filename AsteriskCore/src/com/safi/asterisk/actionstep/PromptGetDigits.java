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
 * A representation of the model object '<em><b>Prompt Get Digits</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.PromptGetDigits#getFilename <em>Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.PromptGetDigits#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.PromptGetDigits#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.PromptGetDigits#getMaxDigits <em>Max Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.PromptGetDigits#isUseBufferedDigits <em>Use Buffered Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPromptGetDigits()
 * @model
 * @generated
 */
public interface PromptGetDigits extends AsteriskActionStep, CallConsumer1 {
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
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPromptGetDigits_Filename()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='Prompt Filename' isTypeLocked='false' description='The audio prompt file name that will be played' expectedReturnType='Text' helperClass='com.safi.workshop.sheet.PromptChooserDynamicValueEditorPage'"
	 * @generated
	 */
	DynamicValue getFilename();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.PromptGetDigits#getFilename <em>Filename</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' containment reference.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(long)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPromptGetDigits_Timeout()
	 * @model ordered="false"
	 *        annotation="unitsTime milliseconds='true'"
	 * @generated
	 */
	long getTimeout();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.PromptGetDigits#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
	void setTimeout(long value);

	/**
	 * Returns the value of the '<em><b>Variable Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Name</em>' containment reference.
	 * @see #setVariableName(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPromptGetDigits_VariableName()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable name to where digits pressed will be assigned' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 *        annotation="MetaProperty displayText='Variable'"
	 * @generated
	 */
	DynamicValue getVariableName();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.PromptGetDigits#getVariableName <em>Variable Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Name</em>' containment reference.
	 * @see #getVariableName()
	 * @generated
	 */
	void setVariableName(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Max Digits</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Digits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Digits</em>' attribute.
	 * @see #setMaxDigits(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPromptGetDigits_MaxDigits()
	 * @model default="1" ordered="false"
	 * @generated
	 */
	int getMaxDigits();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.PromptGetDigits#getMaxDigits <em>Max Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Digits</em>' attribute.
	 * @see #getMaxDigits()
	 * @generated
	 */
	void setMaxDigits(int value);

	/**
	 * Returns the value of the '<em><b>Use Buffered Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Use Buffered Digits</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Buffered Digits</em>' attribute.
	 * @see #setUseBufferedDigits(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPromptGetDigits_UseBufferedDigits()
	 * @model ordered="false"
	 * @generated
	 */
	boolean isUseBufferedDigits();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.PromptGetDigits#isUseBufferedDigits <em>Use Buffered Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Buffered Digits</em>' attribute.
	 * @see #isUseBufferedDigits()
	 * @generated
	 */
	void setUseBufferedDigits(boolean value);

} // PromptGetDigits
