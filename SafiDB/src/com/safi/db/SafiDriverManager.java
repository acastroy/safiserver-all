/**
 * <copyright>
 * </copyright>
 *
 * $Id: SafiDriverManager.java,v 1.4 2008/08/08 15:07:14 zacw Exp $
 */
package com.safi.db;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safi Driver Manager</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.db.SafiDriverManager#getDrivers <em>Drivers</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.db.DbPackage#getSafiDriverManager()
 * @model
 * @generated
 */
public interface SafiDriverManager extends DBResource {
  /**
	 * Returns the value of the '<em><b>Drivers</b></em>' containment reference list.
	 * The list contents are of type {@link com.safi.db.DBDriver}.
	 * It is bidirectional and its opposite is '{@link com.safi.db.DBDriver#getDriverManager <em>Driver Manager</em>}'.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Drivers</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Drivers</em>' containment reference list.
	 * @see com.safi.db.DbPackage#getSafiDriverManager_Drivers()
	 * @see com.safi.db.DBDriver#getDriverManager
	 * @model opposite="driverManager" containment="true"
	 *        annotation="teneo.jpa appinfo='@OneToMany(cascade={MERGE,PERSIST,REMOVE} fetch=\"EAGER\"  indexed=\"false\")'"
	 * @generated
	 */
  EList<DBDriver> getDrivers();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  DBDriver getDriver(String name);

} // SafiDriverManager
