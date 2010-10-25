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
 * A representation of the model object '<em><b>Set Query Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.SetQueryParam#getValue <em>Value</em>}</li>
 *   <li>{@link com.safi.core.actionstep.SetQueryParam#getParameter <em>Parameter</em>}</li>
 *   <li>{@link com.safi.core.actionstep.SetQueryParam#getParamDatatype <em>Param Datatype</em>}</li>
 *   <li>{@link com.safi.core.actionstep.SetQueryParam#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getSetQueryParam()
 * @model
 * @generated
 */
public interface SetQueryParam extends ActionStep {
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
	 * @see com.safi.core.actionstep.ActionStepPackage#getSetQueryParam_Value()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The value to assign to the parameter' expectedReturnType='Variable' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getValue();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.SetQueryParam#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
  void setValue(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Parameter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameter</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' containment reference.
	 * @see #setParameter(DBQueryParamId)
	 * @see com.safi.core.actionstep.ActionStepPackage#getSetQueryParam_Parameter()
	 * @model containment="true" ordered="false"
	 *        annotation="Directionality output='true'"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DBQueryParamId getParameter();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.SetQueryParam#getParameter <em>Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' containment reference.
	 * @see #getParameter()
	 * @generated
	 */
  void setParameter(DBQueryParamId value);

  /**
	 * Returns the value of the '<em><b>Param Datatype</b></em>' attribute.
	 * The literals are from the enumeration {@link com.safi.db.SQLDataType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Param Datatype</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Param Datatype</em>' attribute.
	 * @see com.safi.db.SQLDataType
	 * @see #setParamDatatype(SQLDataType)
	 * @see com.safi.core.actionstep.ActionStepPackage#getSetQueryParam_ParamDatatype()
	 * @model ordered="false"
	 * @generated
	 */
  SQLDataType getParamDatatype();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.SetQueryParam#getParamDatatype <em>Param Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param Datatype</em>' attribute.
	 * @see com.safi.db.SQLDataType
	 * @see #getParamDatatype()
	 * @generated
	 */
  void setParamDatatype(SQLDataType value);

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
	 * @see com.safi.core.actionstep.ActionStepPackage#getSetQueryParam_Query()
	 * @model resolveProxies="false" ordered="false"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DBQueryId getQuery();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.SetQueryParam#getQuery <em>Query</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Query</em>' reference.
	 * @see #getQuery()
	 * @generated
	 */
  void setQuery(DBQueryId value);

} // SetQueryParam
