/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execute Query</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.ExecuteQuery#getQuery <em>Query</em>}</li>
 *   <li>{@link com.safi.core.actionstep.ExecuteQuery#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link com.safi.core.actionstep.ExecuteQuery#getResultSetName <em>Result Set Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getExecuteQuery()
 * @model
 * @generated
 */
public interface ExecuteQuery extends ActionStep, Heavyweight {
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
   * @see com.safi.core.actionstep.ActionStepPackage#getExecuteQuery_Query()
   * @model resolveProxies="false" ordered="false"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DBQueryId getQuery();

  /**
   * Sets the value of the '{@link com.safi.core.actionstep.ExecuteQuery#getQuery <em>Query</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Query</em>' reference.
   * @see #getQuery()
   * @generated
   */
  void setQuery(DBQueryId value);

  /**
   * Returns the value of the '<em><b>Result Set</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Set</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result Set</em>' containment reference.
   * @see #setResultSet(DBResultSetId)
   * @see com.safi.core.actionstep.ActionStepPackage#getExecuteQuery_ResultSet()
   * @model containment="true" ordered="false"
   *        annotation="Directionality output='true'"
   * @generated
   */
  DBResultSetId getResultSet();

  /**
   * Sets the value of the '{@link com.safi.core.actionstep.ExecuteQuery#getResultSet <em>Result Set</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result Set</em>' containment reference.
   * @see #getResultSet()
   * @generated
   */
  void setResultSet(DBResultSetId value);

  /**
   * Returns the value of the '<em><b>Result Set Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Result Set Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Result Set Name</em>' attribute.
   * @see #setResultSetName(String)
   * @see com.safi.core.actionstep.ActionStepPackage#getExecuteQuery_ResultSetName()
   * @model ordered="false"
   *        annotation="Required criteria='non-blank'"
   * @generated
   */
  String getResultSetName();

  /**
   * Sets the value of the '{@link com.safi.core.actionstep.ExecuteQuery#getResultSetName <em>Result Set Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result Set Name</em>' attribute.
   * @see #getResultSetName()
   * @generated
   */
  void setResultSetName(String value);

} // ExecuteQuery
