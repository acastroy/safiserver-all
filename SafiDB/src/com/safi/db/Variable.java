/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.db;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.Variable#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.db.Variable#getDefaultValue <em>Default Value</em>}</li>
 *   <li>{@link com.safi.db.Variable#getType <em>Type</em>}</li>
 *   <li>{@link com.safi.db.Variable#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.DbPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends EObject {
  /**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.safi.db.DbPackage#getVariable_Name()
	 * @model id="true" ordered="false"
	 *        annotation="teneo.jpa appinfo='@GeneratedValue(strategy=\"TABLE\")'"
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link com.safi.db.Variable#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

  /**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(Object)
	 * @see com.safi.db.DbPackage#getVariable_DefaultValue()
	 * @model ordered="false"
	 * @generated
	 */
  Object getDefaultValue();

  /**
	 * Sets the value of the '{@link com.safi.db.Variable#getDefaultValue <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
  void setDefaultValue(Object value);

  /**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"Object"</code>.
	 * The literals are from the enumeration {@link com.safi.db.VariableType}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.safi.db.VariableType
	 * @see #setType(VariableType)
	 * @see com.safi.db.DbPackage#getVariable_Type()
	 * @model default="Object" ordered="false"
	 * @generated
	 */
  VariableType getType();

  /**
	 * Sets the value of the '{@link com.safi.db.Variable#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.safi.db.VariableType
	 * @see #getType()
	 * @generated
	 */
  void setType(VariableType value);

  /**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * The literals are from the enumeration {@link com.safi.db.VariableScope}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scope</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see com.safi.db.VariableScope
	 * @see #setScope(VariableScope)
	 * @see com.safi.db.DbPackage#getVariable_Scope()
	 * @model default="false" ordered="false"
	 * @generated
	 */
  VariableScope getScope();

  /**
	 * Sets the value of the '{@link com.safi.db.Variable#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see com.safi.db.VariableScope
	 * @see #getScope()
	 * @generated
	 */
  void setScope(VariableScope value);

  /**
   * Causes this variable to fire a value changed notification event
   */
  void touch();
} // Variable
