/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Open DB Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.OpenDBConnection#getConnection <em>Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getOpenDBConnection()
 * @model
 * @generated
 */
public interface OpenDBConnection extends ActionStep, Heavyweight {
  /**
   * Returns the value of the '<em><b>Connection</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Connection</em>' containment reference.
   * @see #setConnection(DBConnectionId)
   * @see com.safi.core.actionstep.ActionStepPackage#getOpenDBConnection_Connection()
   * @model containment="true" ordered="false"
   *        annotation="Directionality output='true'"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DBConnectionId getConnection();

  /**
   * Sets the value of the '{@link com.safi.core.actionstep.OpenDBConnection#getConnection <em>Connection</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Connection</em>' containment reference.
   * @see #getConnection()
   * @generated
   */
  void setConnection(DBConnectionId value);

} // OpenDBConnection
