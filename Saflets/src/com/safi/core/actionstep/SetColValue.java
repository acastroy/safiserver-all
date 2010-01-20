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
 * A representation of the model object '<em><b>Set Col Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.SetColValue#getResultSet <em>Result Set</em>}</li>
 *   <li>{@link com.safi.core.actionstep.SetColValue#getColumn <em>Column</em>}</li>
 *   <li>{@link com.safi.core.actionstep.SetColValue#getSetAsDatatype <em>Set As Datatype</em>}</li>
 *   <li>{@link com.safi.core.actionstep.SetColValue#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getSetColValue()
 * @model
 * @generated
 */
public interface SetColValue extends ActionStep {
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
	 * @see com.safi.core.actionstep.ActionStepPackage#getSetColValue_ResultSet()
	 * @model resolveProxies="false" ordered="false"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DBResultSetId getResultSet();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.SetColValue#getResultSet <em>Result Set</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result Set</em>' reference.
	 * @see #getResultSet()
	 * @generated
	 */
  void setResultSet(DBResultSetId value);

  /**
	 * Returns the value of the '<em><b>Column</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Column</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Column</em>' containment reference.
	 * @see #setColumn(DynamicValue)
	 * @see com.safi.core.actionstep.ActionStepPackage#getSetColValue_Column()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The resultset column from which to retrieve the value.  If this value is a number, the value will be retrieved by column number.' expectedReturnType='Unknown' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getColumn();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.SetColValue#getColumn <em>Column</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' containment reference.
	 * @see #getColumn()
	 * @generated
	 */
  void setColumn(DynamicValue value);

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
	 * @see com.safi.core.actionstep.ActionStepPackage#getSetColValue_SetAsDatatype()
	 * @model ordered="false"
	 * @generated
	 */
  SQLDataType getSetAsDatatype();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.SetColValue#getSetAsDatatype <em>Set As Datatype</em>}' attribute.
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
	 * @see com.safi.core.actionstep.ActionStepPackage#getSetColValue_Value()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The value to assign to the given column of the resultset. This resultset must be updateable.' expectedReturnType='Unknown' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getValue();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.SetColValue#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
  void setValue(DynamicValue value);

} // SetColValue
