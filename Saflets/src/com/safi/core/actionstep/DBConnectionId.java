/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;

import java.sql.Connection;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DB Connection Id</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.DBConnectionId#getId <em>Id</em>}</li>
 *   <li>{@link com.safi.core.actionstep.DBConnectionId#getJdbcConnection <em>Jdbc Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getDBConnectionId()
 * @model
 * @generated
 */
public interface DBConnectionId extends EObject {
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
	 * @see com.safi.core.actionstep.ActionStepPackage#getDBConnectionId_Id()
	 * @model ordered="false"
	 * @generated
	 */
  String getId();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.DBConnectionId#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
  void setId(String value);

  /**
	 * Returns the value of the '<em><b>Jdbc Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jdbc Connection</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Jdbc Connection</em>' attribute.
	 * @see #setJdbcConnection(Connection)
	 * @see com.safi.core.actionstep.ActionStepPackage#getDBConnectionId_JdbcConnection()
	 * @model dataType="com.safi.db.Connection" ordered="false"
	 * @generated
	 */
  Connection getJdbcConnection();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.DBConnectionId#getJdbcConnection <em>Jdbc Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jdbc Connection</em>' attribute.
	 * @see #getJdbcConnection()
	 * @generated
	 */
  void setJdbcConnection(Connection value);

} // DBConnectionId
