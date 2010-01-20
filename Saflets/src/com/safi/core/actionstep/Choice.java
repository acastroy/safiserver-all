/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.Choice#getChoices <em>Choices</em>}</li>
 *   <li>{@link com.safi.core.actionstep.Choice#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getChoice()
 * @model
 * @generated
 */
public interface Choice extends ActionStep {
  /**
	 * Returns the value of the '<em><b>Choices</b></em>' containment reference list.
	 * The list contents are of type {@link com.safi.core.actionstep.CaseItem}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Choices</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Choices</em>' containment reference list.
	 * @see com.safi.core.actionstep.ActionStepPackage#getChoice_Choices()
	 * @model containment="true" ordered="false"
	 *        annotation="Required criteria='non-empty'"
	 * @generated
	 */
  EList<CaseItem> getChoices();

  /**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(DynamicValue)
	 * @see com.safi.core.actionstep.ActionStepPackage#getChoice_Value()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The value that will be compared against each choice' expectedReturnType='Unknown' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getValue();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.Choice#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
  void setValue(DynamicValue value);

} // Choice
