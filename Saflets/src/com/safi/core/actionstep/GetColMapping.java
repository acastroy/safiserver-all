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
 * A representation of the model object '<em><b>Get Col Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.GetColMapping#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link com.safi.core.actionstep.GetColMapping#getColumn <em>Column</em>}</li>
 *   <li>{@link com.safi.core.actionstep.GetColMapping#getGetAsDatatype <em>Get As Datatype</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getGetColMapping()
 * @model
 * @generated
 */
public interface GetColMapping extends Item {
  /**
	 * Returns the value of the '<em><b>Variable Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Name</em>' containment reference.
	 * @see #setVariableName(DynamicValue)
	 * @see com.safi.core.actionstep.ActionStepPackage#getGetColMapping_VariableName()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The variable that will receive the value of the specified column' expectedReturnType='Variable' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
  DynamicValue getVariableName();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.GetColMapping#getVariableName <em>Variable Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Name</em>' containment reference.
	 * @see #getVariableName()
	 * @generated
	 */
  void setVariableName(DynamicValue value);

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
	 * @see com.safi.core.actionstep.ActionStepPackage#getGetColMapping_Column()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='LiteralText' isTypeLocked='false' description='The resultset column from which to retrieve the value.  If this value is a number, the value will be retrieved by column number.' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getColumn();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.GetColMapping#getColumn <em>Column</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column</em>' containment reference.
	 * @see #getColumn()
	 * @generated
	 */
  void setColumn(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Get As Datatype</b></em>' attribute.
	 * The literals are from the enumeration {@link com.safi.db.SQLDataType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Get As Datatype</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Get As Datatype</em>' attribute.
	 * @see com.safi.db.SQLDataType
	 * @see #setGetAsDatatype(SQLDataType)
	 * @see com.safi.core.actionstep.ActionStepPackage#getGetColMapping_GetAsDatatype()
	 * @model ordered="false"
	 * @generated
	 */
  SQLDataType getGetAsDatatype();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.GetColMapping#getGetAsDatatype <em>Get As Datatype</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Get As Datatype</em>' attribute.
	 * @see com.safi.db.SQLDataType
	 * @see #getGetAsDatatype()
	 * @generated
	 */
  void setGetAsDatatype(SQLDataType value);

} // GetColMapping
