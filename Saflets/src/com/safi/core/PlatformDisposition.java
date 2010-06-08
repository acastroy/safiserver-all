/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Platform Disposition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.PlatformDisposition#getPlatformID <em>Platform ID</em>}</li>
 *   <li>{@link com.safi.core.PlatformDisposition#isPlatformDependant <em>Platform Dependant</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.CorePackage#getPlatformDisposition()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PlatformDisposition extends EObject {
	/**
	 * Returns the value of the '<em><b>Platform ID</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform ID</em>' attribute.
	 * @see #isSetPlatformID()
	 * @see com.safi.core.CorePackage#getPlatformDisposition_PlatformID()
	 * @model default="" unsettable="true" transient="true" changeable="false"
	 * @generated
	 */
	String getPlatformID();

	/**
	 * Returns whether the value of the '{@link com.safi.core.PlatformDisposition#getPlatformID <em>Platform ID</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Platform ID</em>' attribute is set.
	 * @see #getPlatformID()
	 * @generated
	 */
	boolean isSetPlatformID();

	/**
	 * Returns the value of the '<em><b>Platform Dependant</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform Dependant</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform Dependant</em>' attribute.
	 * @see #isSetPlatformDependant()
	 * @see com.safi.core.CorePackage#getPlatformDisposition_PlatformDependant()
	 * @model default="false" unsettable="true" transient="true" changeable="false"
	 * @generated
	 */
	boolean isPlatformDependant();

	/**
	 * Returns whether the value of the '{@link com.safi.core.PlatformDisposition#isPlatformDependant <em>Platform Dependant</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Platform Dependant</em>' attribute is set.
	 * @see #isPlatformDependant()
	 * @generated
	 */
	boolean isSetPlatformDependant();

} // PlatformDisposition
