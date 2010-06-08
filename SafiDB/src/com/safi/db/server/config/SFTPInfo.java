/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.db.server.config;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>SFTP Info</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.server.config.SFTPInfo#getSftpUser <em>Sftp User</em>}</li>
 *   <li>{@link com.safi.db.server.config.SFTPInfo#getSftpPassword <em>Sftp Password</em>}</li>
 *   <li>{@link com.safi.db.server.config.SFTPInfo#getSftpPort <em>Sftp Port</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.server.config.ConfigPackage#getSFTPInfo()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface SFTPInfo extends EObject {
	/**
	 * Returns the value of the '<em><b>Sftp User</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sftp User</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sftp User</em>' attribute.
	 * @see #setSftpUser(String)
	 * @see com.safi.db.server.config.ConfigPackage#getSFTPInfo_SftpUser()
	 * @model
	 * @generated
	 */
	String getSftpUser();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.SFTPInfo#getSftpUser <em>Sftp User</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sftp User</em>' attribute.
	 * @see #getSftpUser()
	 * @generated
	 */
	void setSftpUser(String value);

	/**
	 * Returns the value of the '<em><b>Sftp Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sftp Password</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sftp Password</em>' attribute.
	 * @see #setSftpPassword(String)
	 * @see com.safi.db.server.config.ConfigPackage#getSFTPInfo_SftpPassword()
	 * @model
	 * @generated
	 */
	String getSftpPassword();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.SFTPInfo#getSftpPassword <em>Sftp Password</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sftp Password</em>' attribute.
	 * @see #getSftpPassword()
	 * @generated
	 */
	void setSftpPassword(String value);

	/**
	 * Returns the value of the '<em><b>Sftp Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sftp Port</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sftp Port</em>' attribute.
	 * @see #setSftpPort(int)
	 * @see com.safi.db.server.config.ConfigPackage#getSFTPInfo_SftpPort()
	 * @model
	 * @generated
	 */
	int getSftpPort();

	/**
	 * Sets the value of the '{@link com.safi.db.server.config.SFTPInfo#getSftpPort <em>Sftp Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sftp Port</em>' attribute.
	 * @see #getSftpPort()
	 * @generated
	 */
	void setSftpPort(int value);

} // SFTPInfo
