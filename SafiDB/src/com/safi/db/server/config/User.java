/**
 * <copyright>
 * </copyright>
 *
 * $Id: User.java,v 1.4 2008/07/04 11:06:40 zacw Exp $
 */
package com.safi.db.server.config;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.server.config.User#getFirstname <em>Firstname</em>}</li>
 *   <li>{@link com.safi.db.server.config.User#getLastname <em>Lastname</em>}</li>
 *   <li>{@link com.safi.db.server.config.User#getRoles <em>Roles</em>}</li>
 *   <li>{@link com.safi.db.server.config.User#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.server.config.ConfigPackage#getUser()
 * @model
 * @generated
 */
public interface User extends ServerResource {
  /**
	 * Returns the value of the '<em><b>Firstname</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Firstname</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Firstname</em>' attribute.
	 * @see #setFirstname(String)
	 * @see com.safi.db.server.config.ConfigPackage#getUser_Firstname()
	 * @model
	 * @generated
	 */
  String getFirstname();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.User#getFirstname <em>Firstname</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Firstname</em>' attribute.
	 * @see #getFirstname()
	 * @generated
	 */
  void setFirstname(String value);

  /**
	 * Returns the value of the '<em><b>Lastname</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lastname</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Lastname</em>' attribute.
	 * @see #setLastname(String)
	 * @see com.safi.db.server.config.ConfigPackage#getUser_Lastname()
	 * @model
	 * @generated
	 */
  String getLastname();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.User#getLastname <em>Lastname</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lastname</em>' attribute.
	 * @see #getLastname()
	 * @generated
	 */
  void setLastname(String value);

  /**
	 * Returns the value of the '<em><b>Roles</b></em>' reference list.
	 * The list contents are of type {@link com.safi.db.server.config.Role}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Roles</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Roles</em>' reference list.
	 * @see com.safi.db.server.config.ConfigPackage#getUser_Roles()
	 * @model annotation="teneo.jpa appinfo='@ManyToMany(fetch=\"EAGER\")'"
	 * @generated
	 */
  EList<Role> getRoles();

  /**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Password</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see com.safi.db.server.config.ConfigPackage#getUser_Password()
	 * @model
	 * @generated
	 */
  String getPassword();

  /**
	 * Sets the value of the '{@link com.safi.db.server.config.User#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
  void setPassword(String value);

} // User
