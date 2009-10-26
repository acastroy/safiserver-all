/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Then</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.IfThen#getBooleanExpression <em>Boolean Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getIfThen()
 * @model
 * @generated
 */
public interface IfThen extends ActionStep {
  /**
   * Returns the value of the '<em><b>Boolean Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Boolean Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Boolean Expression</em>' containment reference.
   * @see #setBooleanExpression(DynamicValue)
   * @see com.safi.core.actionstep.ActionStepPackage#getIfThen_BooleanExpression()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='Boolean' isTypeLocked='false' description='The boolean value that determines which output will be activated (true = green, false = red)' expectedReturnType='Boolean' helperClass='com.safi.workshop.sheet.BooleanBuilderDynamicValueEditorPage'"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getBooleanExpression();

  /**
   * Sets the value of the '{@link com.safi.core.actionstep.IfThen#getBooleanExpression <em>Boolean Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Boolean Expression</em>' containment reference.
   * @see #getBooleanExpression()
   * @generated
   */
  void setBooleanExpression(DynamicValue value);

} // IfThen
