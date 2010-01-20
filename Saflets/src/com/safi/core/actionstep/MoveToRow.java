/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Move To Row</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.MoveToRow#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link com.safi.core.actionstep.MoveToRow#getRowNum <em>Row Num</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getMoveToRow()
 * @model
 * @generated
 */
public interface MoveToRow extends ActionStep {
  /**
	 * Returns the value of the '<em><b>Result Set</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Set</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Set</em>' reference.
	 * @see #setResultSet(DBResultSetId)
	 * @see com.safi.core.actionstep.ActionStepPackage#getMoveToRow_ResultSet()
	 * @model resolveProxies="false" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable that will receive the number of rows updated' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DBResultSetId getResultSet();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.MoveToRow#getResultSet <em>Result Set</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Set</em>' reference.
	 * @see #getResultSet()
	 * @generated
	 */
  void setResultSet(DBResultSetId value);

  /**
	 * Returns the value of the '<em><b>Row Num</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Row Num</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Row Num</em>' containment reference.
	 * @see #setRowNum(DynamicValue)
	 * @see com.safi.core.actionstep.ActionStepPackage#getMoveToRow_RowNum()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The row number of the resultset to move to.  The resultset must be scrollable.' expectedReturnType='Integer' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getRowNum();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.MoveToRow#getRowNum <em>Row Num</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Row Num</em>' containment reference.
	 * @see #getRowNum()
	 * @generated
	 */
  void setRowNum(DynamicValue value);

} // MoveToRow
