/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.InputItem#getParameterName <em>Parameter Name</em>}</li>
 *   <li>{@link com.safi.core.actionstep.InputItem#isRequired <em>Required</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getInputItem()
 * @model
 * @generated
 */
public interface InputItem extends CaseItem {
  /**
	 * Returns the value of the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Name</em>' attribute.
	 * @see #setParameterName(String)
	 * @see com.safi.core.actionstep.ActionStepPackage#getInputItem_ParameterName()
	 * @model
	 * @generated
	 */
  String getParameterName();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.InputItem#getParameterName <em>Parameter Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Name</em>' attribute.
	 * @see #getParameterName()
	 * @generated
	 */
  void setParameterName(String value);

  /**
	 * Returns the value of the '<em><b>Required</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Required</em>' attribute.
	 * @see #setRequired(boolean)
	 * @see com.safi.core.actionstep.ActionStepPackage#getInputItem_Required()
	 * @model default="true"
	 * @generated
	 */
  boolean isRequired();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.InputItem#isRequired <em>Required</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required</em>' attribute.
	 * @see #isRequired()
	 * @generated
	 */
  void setRequired(boolean value);

} // InputItem
