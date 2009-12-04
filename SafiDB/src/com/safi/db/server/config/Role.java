/**
 * <copyright>
 * </copyright>
 *
 * $Id: Role.java,v 1.2 2008/07/04 11:06:40 zacw Exp $
 */
package com.safi.db.server.config;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.server.config.Role#getEntitlements <em>Entitlements</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.server.config.ConfigPackage#getRole()
 * @model
 * @generated
 */
public interface Role extends ServerResource {
  /**
	 * Returns the value of the '<em><b>Entitlements</b></em>' reference list.
	 * The list contents are of type {@link com.safi.db.server.config.Entitlement}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entitlements</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Entitlements</em>' reference list.
	 * @see com.safi.db.server.config.ConfigPackage#getRole_Entitlements()
	 * @model annotation="teneo.jpa appinfo='@ManyToMany(fetch=\"EAGER\" indexed=\"false\" )'"
	 * @generated
	 */
  EList<Entitlement> getEntitlements();

} // Role
