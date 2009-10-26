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
 * A representation of the model object '<em><b>Get Full Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.GetFullVariable#getVariable <em>Variable</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetFullVariable#getAssignToVar <em>Assign To Var</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetFullVariable()
 * @model
 * @generated
 */
public interface GetFullVariable extends ActionStep, CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Variable</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' attribute.
   * @see #setVariable(String)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetFullVariable_Variable()
   * @model ordered="false"
   *        annotation="Required criteria='non-blank'"
   * @generated
   */
  String getVariable();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.GetFullVariable#getVariable <em>Variable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' attribute.
   * @see #getVariable()
   * @generated
   */
  void setVariable(String value);

  /**
   * Returns the value of the '<em><b>Assign To Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Assign To Var</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Assign To Var</em>' containment reference.
   * @see #setAssignToVar(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetFullVariable_AssignToVar()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable owning the value that will be assigned' expectedReturnType='Text' helperClass=''"
   *        annotation="Directionality output='true'"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getAssignToVar();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.GetFullVariable#getAssignToVar <em>Assign To Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Assign To Var</em>' containment reference.
   * @see #getAssignToVar()
   * @generated
   */
  void setAssignToVar(DynamicValue value);

} // GetFullVariable
