/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Output</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.Output#getTarget <em>Target</em>}</li>
 *   <li>{@link com.safi.core.actionstep.Output#getParent <em>Parent</em>}</li>
 *   <li>{@link com.safi.core.actionstep.Output#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.core.actionstep.Output#getOutputType <em>Output Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getOutput()
 * @model
 * @generated
 */
public interface Output extends EObject {
  /**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(ActionStep)
	 * @see com.safi.core.actionstep.ActionStepPackage#getOutput_Target()
	 * @model
	 * @generated
	 */
  ActionStep getTarget();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.Output#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
  void setTarget(ActionStep value);

  /**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link com.safi.core.actionstep.ActionStep#getOutputs <em>Outputs</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see #setParent(ActionStep)
	 * @see com.safi.core.actionstep.ActionStepPackage#getOutput_Parent()
	 * @see com.safi.core.actionstep.ActionStep#getOutputs
	 * @model opposite="outputs" transient="false"
	 * @generated
	 */
  ActionStep getParent();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.Output#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
  void setParent(ActionStep value);

  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.safi.core.actionstep.ActionStepPackage#getOutput_Name()
	 * @model
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.Output#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Output Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.safi.core.actionstep.OutputType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Output Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Type</em>' attribute.
	 * @see com.safi.core.actionstep.OutputType
	 * @see #setOutputType(OutputType)
	 * @see com.safi.core.actionstep.ActionStepPackage#getOutput_OutputType()
	 * @model
	 * @generated
	 */
  OutputType getOutputType();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.Output#getOutputType <em>Output Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Type</em>' attribute.
	 * @see com.safi.core.actionstep.OutputType
	 * @see #getOutputType()
	 * @generated
	 */
  void setOutputType(OutputType value);

} // Output
