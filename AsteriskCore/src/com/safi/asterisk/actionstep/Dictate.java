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
 * A representation of the model object '<em><b>Dictate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.Dictate#getDirectory <em>Directory</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dictate#getFilename <em>Filename</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDictate()
 * @model
 * @generated
 */
public interface Dictate extends AsteriskActionStep, CallConsumer1 {
	/**
	 * Returns the value of the '<em><b>Directory</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Directory</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Directory</em>' containment reference.
	 * @see #setDirectory(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDictate_Directory()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the directory in which to store the audio files' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
	DynamicValue getDirectory();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dictate#getDirectory <em>Directory</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Directory</em>' containment reference.
	 * @see #getDirectory()
	 * @generated
	 */
	void setDirectory(DynamicValue value);

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
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDictate_Filename()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the filename (prefix) to use for the recorded files' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
	DynamicValue getFilename();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dictate#getFilename <em>Filename</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' containment reference.
	 * @see #getFilename()
	 * @generated
	 */
	void setFilename(DynamicValue value);

} // Dictate
