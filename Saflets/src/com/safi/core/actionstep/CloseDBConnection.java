/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Close DB Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.CloseDBConnection#getConnection <em>Connection</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.actionstep.ActionStepPackage#getCloseDBConnection()
 * @model
 * @generated
 */
public interface CloseDBConnection extends ActionStep {
  /**
	 * Returns the value of the '<em><b>Connection</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Connection</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Connection</em>' reference.
	 * @see #setConnection(DBConnectionId)
	 * @see com.safi.core.actionstep.ActionStepPackage#getCloseDBConnection_Connection()
	 * @model ordered="false"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DBConnectionId getConnection();

  /**
	 * Sets the value of the '{@link com.safi.core.actionstep.CloseDBConnection#getConnection <em>Connection</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection</em>' reference.
	 * @see #getConnection()
	 * @generated
	 */
  void setConnection(DBConnectionId value);

} // CloseDBConnection
