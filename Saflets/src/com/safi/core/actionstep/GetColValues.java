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
 * A representation of the model object '<em><b>Get Col Values</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.GetColValues#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link com.safi.core.actionstep.GetColValues#getColumnMappings <em>Column Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getGetColValues()
 * @model
 * @generated
 */
public interface GetColValues extends ActionStep {
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
   * @see com.safi.core.actionstep.ActionStepPackage#getGetColValues_ResultSet()
   * @model resolveProxies="false" ordered="false"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DBResultSetId getResultSet();

  /**
   * Sets the value of the '{@link com.safi.core.actionstep.GetColValues#getResultSet <em>Result Set</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Result Set</em>' reference.
   * @see #getResultSet()
   * @generated
   */
  void setResultSet(DBResultSetId value);

  /**
   * Returns the value of the '<em><b>Column Mappings</b></em>' containment reference list.
   * The list contents are of type {@link com.safi.core.actionstep.GetColMapping}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Column Mappings</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Column Mappings</em>' containment reference list.
   * @see com.safi.core.actionstep.ActionStepPackage#getGetColValues_ColumnMappings()
   * @model containment="true"
   *        annotation="Required criteria='non-empty'"
   * @generated
   */
  EList<GetColMapping> getColumnMappings();

} // GetColValues
