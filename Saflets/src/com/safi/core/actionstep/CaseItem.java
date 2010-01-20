/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Case Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.CaseItem#getDynamicValue <em>Dynamic Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getCaseItem()
 * @model
 * @generated
 */
public interface CaseItem extends Item {
  /**
	 * Returns the value of the '<em><b>Dynamic Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dynamic Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamic Value</em>' containment reference.
	 * @see #setDynamicValue(DynamicValue)
	 * @see com.safi.core.actionstep.ActionStepPackage#getCaseItem_DynamicValue()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The value with which to compare against' expectedReturnType='Unknown' helperClass='com.safi.workshop.sheet.BooleanBuilderDynamicValueEditorPage'"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getDynamicValue();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.CaseItem#getDynamicValue <em>Dynamic Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamic Value</em>' containment reference.
	 * @see #getDynamicValue()
	 * @generated
	 */
  void setDynamicValue(DynamicValue value);

} // CaseItem
