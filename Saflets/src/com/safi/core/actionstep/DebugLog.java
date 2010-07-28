/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Debug Log</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.DebugLog#getMessage <em>Message</em>}</li>
 *   <li>{@link com.safi.core.actionstep.DebugLog#getDebugLevel <em>Debug Level</em>}</li>
 *   <li>{@link com.safi.core.actionstep.DebugLog#getLogFilename <em>Log Filename</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getDebugLog()
 * @model
 * @generated
 */
public interface DebugLog extends ActionStep {
  /**
	 * Returns the value of the '<em><b>Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' containment reference.
	 * @see #setMessage(DynamicValue)
	 * @see com.safi.core.actionstep.ActionStepPackage#getDebugLog_Message()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='ScriptText' isTypeLocked='false' description='The message to be logged' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getMessage();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.DebugLog#getMessage <em>Message</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' containment reference.
	 * @see #getMessage()
	 * @generated
	 */
  void setMessage(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Debug Level</b></em>' attribute.
	 * The default value is <code>"Debug"</code>.
	 * The literals are from the enumeration {@link com.safi.core.actionstep.DebugLevel}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Debug Level</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Debug Level</em>' attribute.
	 * @see com.safi.core.actionstep.DebugLevel
	 * @see #setDebugLevel(DebugLevel)
	 * @see com.safi.core.actionstep.ActionStepPackage#getDebugLog_DebugLevel()
	 * @model default="Debug" ordered="false"
	 * @generated
	 */
  DebugLevel getDebugLevel();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.DebugLog#getDebugLevel <em>Debug Level</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Debug Level</em>' attribute.
	 * @see com.safi.core.actionstep.DebugLevel
	 * @see #getDebugLevel()
	 * @generated
	 */
  void setDebugLevel(DebugLevel value);

  /**
	 * Returns the value of the '<em><b>Log Filename</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Log Filename</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Log Filename</em>' containment reference.
	 * @see #setLogFilename(DynamicValue)
	 * @see com.safi.core.actionstep.ActionStepPackage#getDebugLog_LogFilename()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The full path of the log file to be written to' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getLogFilename();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.DebugLog#getLogFilename <em>Log Filename</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Filename</em>' containment reference.
	 * @see #getLogFilename()
	 * @generated
	 */
  void setLogFilename(DynamicValue value);

} // DebugLog
