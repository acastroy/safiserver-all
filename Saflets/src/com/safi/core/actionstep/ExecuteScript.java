/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execute Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.ExecuteScript#getScriptText <em>Script Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getExecuteScript()
 * @model
 * @generated
 */
public interface ExecuteScript extends ActionStep {
  /**
	 * Returns the value of the '<em><b>Script Text</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Script Text</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Text</em>' containment reference.
	 * @see #setScriptText(DynamicValue)
	 * @see com.safi.core.actionstep.ActionStepPackage#getExecuteScript_ScriptText()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='ScriptText' isTypeLocked='true' description='The script to be executed.  Error output will taken in case of error, default output for all other cases' expectedReturnType='Script' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getScriptText();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.ExecuteScript#getScriptText <em>Script Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Text</em>' containment reference.
	 * @see #getScriptText()
	 * @generated
	 */
  void setScriptText(DynamicValue value);

} // ExecuteScript
