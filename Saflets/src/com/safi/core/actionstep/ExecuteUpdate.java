/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execute Update</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.ExecuteUpdate#getQuery <em>Query</em>}</li>
 *   <li>{@link com.safi.core.actionstep.ExecuteUpdate#getRowsUpdatedVar <em>Rows Updated Var</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getExecuteUpdate()
 * @model
 * @generated
 */
public interface ExecuteUpdate extends ActionStep {
  /**
   * Returns the value of the '<em><b>Query</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Query</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Query</em>' reference.
   * @see #setQuery(DBQueryId)
   * @see com.safi.core.actionstep.ActionStepPackage#getExecuteUpdate_Query()
   * @model resolveProxies="false" ordered="false"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DBQueryId getQuery();

  /**
   * Sets the value of the '{@link com.safi.core.actionstep.ExecuteUpdate#getQuery <em>Query</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Query</em>' reference.
   * @see #getQuery()
   * @generated
   */
  void setQuery(DBQueryId value);

  /**
   * Returns the value of the '<em><b>Rows Updated Var</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rows Updated Var</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rows Updated Var</em>' containment reference.
   * @see #setRowsUpdatedVar(DynamicValue)
   * @see com.safi.core.actionstep.ActionStepPackage#getExecuteUpdate_RowsUpdatedVar()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable that will receive the number of rows updated' expectedReturnType='Text' helperClass=''"
   *        annotation="Directionality output='true'"
   *        annotation="MetaProperty displayText='Update Count Variable'"
   * @generated
   */
  DynamicValue getRowsUpdatedVar();

  /**
   * Sets the value of the '{@link com.safi.core.actionstep.ExecuteUpdate#getRowsUpdatedVar <em>Rows Updated Var</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rows Updated Var</em>' containment reference.
   * @see #getRowsUpdatedVar()
   * @generated
   */
  void setRowsUpdatedVar(DynamicValue value);

} // ExecuteUpdate
