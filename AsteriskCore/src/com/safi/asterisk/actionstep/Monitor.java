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
 * A representation of the model object '<em><b>Monitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.Monitor#getFilenamePrefix <em>Filename Prefix</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Monitor#getFormat <em>Format</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Monitor#isMix <em>Mix</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMonitor()
 * @model
 * @generated
 */
public interface Monitor extends ActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Filename Prefix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filename Prefix</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Filename Prefix</em>' containment reference.
	 * @see #setFilenamePrefix(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMonitor_FilenamePrefix()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the filename (prefix) to use for the recorded files' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getFilenamePrefix();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Monitor#getFilenamePrefix <em>Filename Prefix</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename Prefix</em>' containment reference.
	 * @see #getFilenamePrefix()
	 * @generated
	 */
  void setFilenamePrefix(DynamicValue value);

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
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMonitor_Format()
	 * @model default="wav" ordered="false"
	 * @generated
	 */
  String getFormat();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Monitor#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
  void setFormat(String value);

  /**
	 * Returns the value of the '<em><b>Mix</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mix</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Mix</em>' attribute.
	 * @see #setMix(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMonitor_Mix()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isMix();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Monitor#isMix <em>Mix</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mix</em>' attribute.
	 * @see #isMix()
	 * @generated
	 */
  void setMix(boolean value);

} // Monitor
