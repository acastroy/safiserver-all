/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import java.sql.Statement;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DB Query Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.DBQueryId#getId <em>Id</em>}</li>
 *   <li>{@link com.safi.core.actionstep.DBQueryId#getJdbcStatement <em>Jdbc Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getDBQueryId()
 * @model
 * @generated
 */
public interface DBQueryId extends EObject {
  /**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see com.safi.core.actionstep.ActionStepPackage#getDBQueryId_Id()
	 * @model ordered="false"
	 * @generated
	 */
  String getId();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.DBQueryId#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
  void setId(String value);

  /**
	 * Returns the value of the '<em><b>Jdbc Statement</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jdbc Statement</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Statement</em>' attribute.
	 * @see #setJdbcStatement(Statement)
	 * @see com.safi.core.actionstep.ActionStepPackage#getDBQueryId_JdbcStatement()
	 * @model dataType="com.safi.db.Statement" ordered="false"
	 * @generated
	 */
  Statement getJdbcStatement();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.DBQueryId#getJdbcStatement <em>Jdbc Statement</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Statement</em>' attribute.
	 * @see #getJdbcStatement()
	 * @generated
	 */
  void setJdbcStatement(Statement value);

} // DBQueryId
