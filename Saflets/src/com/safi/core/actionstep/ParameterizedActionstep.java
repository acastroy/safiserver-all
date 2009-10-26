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
 * A representation of the model object '<em><b>Parameterized Actionstep</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.ParameterizedActionstep#getInputs <em>Inputs</em>}</li>
 *   <li>{@link com.safi.core.actionstep.ParameterizedActionstep#getOutputParameters <em>Output Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getParameterizedActionstep()
 * @model abstract="true"
 * @generated
 */
public interface ParameterizedActionstep extends ActionStep {
  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
   * The list contents are of type {@link com.safi.core.actionstep.InputItem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputs</em>' containment reference list.
   * @see com.safi.core.actionstep.ActionStepPackage#getParameterizedActionstep_Inputs()
   * @model containment="true"
   * @generated
   */
  EList<InputItem> getInputs();

  /**
   * Returns the value of the '<em><b>Output Parameters</b></em>' containment reference list.
   * The list contents are of type {@link com.safi.core.actionstep.OutputParameter}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output Parameters</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Output Parameters</em>' containment reference list.
   * @see com.safi.core.actionstep.ActionStepPackage#getParameterizedActionstep_OutputParameters()
   * @model containment="true"
   * @generated
   */
  EList<OutputParameter> getOutputParameters();

} // ParameterizedActionstep
