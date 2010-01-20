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
 * A representation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.Item#getLabelText <em>Label Text</em>}</li>
 *   <li>{@link com.safi.core.actionstep.Item#getParentActionStep <em>Parent Action Step</em>}</li>
 *   <li>{@link com.safi.core.actionstep.Item#getTargetActionStep <em>Target Action Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getItem()
 * @model
 * @generated
 */
public interface Item extends EObject {
  /**
	 * Returns the value of the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Text</em>' attribute.
	 * @see #setLabelText(String)
	 * @see com.safi.core.actionstep.ActionStepPackage#getItem_LabelText()
	 * @model ordered="false"
	 * @generated
	 */
  String getLabelText();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.Item#getLabelText <em>Label Text</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Text</em>' attribute.
	 * @see #getLabelText()
	 * @generated
	 */
  void setLabelText(String value);

  /**
	 * Returns the value of the '<em><b>Parent Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parent Action Step</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Action Step</em>' reference.
	 * @see #setParentActionStep(ActionStep)
	 * @see com.safi.core.actionstep.ActionStepPackage#getItem_ParentActionStep()
	 * @model ordered="false"
	 * @generated
	 */
  ActionStep getParentActionStep();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.Item#getParentActionStep <em>Parent Action Step</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Action Step</em>' reference.
	 * @see #getParentActionStep()
	 * @generated
	 */
  void setParentActionStep(ActionStep value);

  /**
	 * Returns the value of the '<em><b>Target Action Step</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Action Step</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Action Step</em>' reference.
	 * @see #setTargetActionStep(ActionStep)
	 * @see com.safi.core.actionstep.ActionStepPackage#getItem_TargetActionStep()
	 * @model ordered="false"
	 * @generated
	 */
  ActionStep getTargetActionStep();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.Item#getTargetActionStep <em>Target Action Step</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Action Step</em>' reference.
	 * @see #getTargetActionStep()
	 * @generated
	 */
  void setTargetActionStep(ActionStep value);

} // Item
