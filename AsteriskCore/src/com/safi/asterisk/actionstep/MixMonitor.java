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
 * A representation of the model object '<em><b>Mix Monitor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.MixMonitor#getFilename <em>Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MixMonitor#isRecordOnlyWhenBridged <em>Record Only When Bridged</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MixMonitor#isAppendMode <em>Append Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMixMonitor()
 * @model
 * @generated
 */
public interface MixMonitor extends ActionStep, CallConsumer1 {
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
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMixMonitor_Filename()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the filename (prefix) to use for the recorded files' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getFilename();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MixMonitor#getFilename <em>Filename</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filename</em>' containment reference.
	 * @see #getFilename()
	 * @generated
	 */
  void setFilename(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Record Only When Bridged</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record Only When Bridged</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Record Only When Bridged</em>' attribute.
	 * @see #setRecordOnlyWhenBridged(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMixMonitor_RecordOnlyWhenBridged()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isRecordOnlyWhenBridged();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MixMonitor#isRecordOnlyWhenBridged <em>Record Only When Bridged</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Only When Bridged</em>' attribute.
	 * @see #isRecordOnlyWhenBridged()
	 * @generated
	 */
  void setRecordOnlyWhenBridged(boolean value);

  /**
	 * Returns the value of the '<em><b>Append Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Append Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Append Mode</em>' attribute.
	 * @see #setAppendMode(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMixMonitor_AppendMode()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isAppendMode();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MixMonitor#isAppendMode <em>Append Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Append Mode</em>' attribute.
	 * @see #isAppendMode()
	 * @generated
	 */
  void setAppendMode(boolean value);

} // MixMonitor
