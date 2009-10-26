/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import com.safi.db.SQLDataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Query Param Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.QueryParamMapping#getQueryParam <em>Query Param</em>}</li>
 *   <li>{@link com.safi.core.actionstep.QueryParamMapping#getSetAsDatatype <em>Set As Datatype</em>}</li>
 *   <li>{@link com.safi.core.actionstep.QueryParamMapping#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getQueryParamMapping()
 * @model
 * @generated
 */
public interface QueryParamMapping extends Item {
  /**
   * Returns the value of the '<em><b>Query Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Query Param</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Query Param</em>' containment reference.
   * @see #setQueryParam(DBQueryParamId)
   * @see com.safi.core.actionstep.ActionStepPackage#getQueryParamMapping_QueryParam()
   * @model containment="true" ordered="false"
   *        annotation="Directionality output='true'"
   * @generated
   */
  DBQueryParamId getQueryParam();

  /**
   * Sets the value of the '{@link com.safi.core.actionstep.QueryParamMapping#getQueryParam <em>Query Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Query Param</em>' containment reference.
   * @see #getQueryParam()
   * @generated
   */
  void setQueryParam(DBQueryParamId value);

  /**
   * Returns the value of the '<em><b>Set As Datatype</b></em>' attribute.
   * The literals are from the enumeration {@link com.safi.db.SQLDataType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Set As Datatype</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Set As Datatype</em>' attribute.
   * @see com.safi.db.SQLDataType
   * @see #setSetAsDatatype(SQLDataType)
   * @see com.safi.core.actionstep.ActionStepPackage#getQueryParamMapping_SetAsDatatype()
   * @model ordered="false"
   * @generated
   */
  SQLDataType getSetAsDatatype();

  /**
   * Sets the value of the '{@link com.safi.core.actionstep.QueryParamMapping#getSetAsDatatype <em>Set As Datatype</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Set As Datatype</em>' attribute.
   * @see com.safi.db.SQLDataType
   * @see #getSetAsDatatype()
   * @generated
   */
  void setSetAsDatatype(SQLDataType value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(DynamicValue)
   * @see com.safi.core.actionstep.ActionStepPackage#getQueryParamMapping_Value()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The value to assign to the given column of the resultset. This resultset must be updateable.' expectedReturnType='Unknown' helperClass=''"
   * @generated
   */
  DynamicValue getValue();

  /**
   * Sets the value of the '{@link com.safi.core.actionstep.QueryParamMapping#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(DynamicValue value);

} // QueryParamMapping
