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
 * A representation of the model object '<em><b>Platform Dependant</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.PlatformDependant#getPlatformID <em>Platform ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.CorePackage#getPlatformDependant()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface PlatformDependant extends EObject {
	/**
	 * Returns the value of the '<em><b>Platform ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Platform ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Platform ID</em>' attribute.
	 * @see #isSetPlatformID()
	 * @see com.safi.core.CorePackage#getPlatformDependant_PlatformID()
	 * @model unsettable="true" transient="true" changeable="false"
	 * @generated
	 */
	String getPlatformID();

	/**
	 * Returns whether the value of the '{@link com.safi.core.PlatformDependant#getPlatformID <em>Platform ID</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Platform ID</em>' attribute is set.
	 * @see #getPlatformID()
	 * @generated
	 */
	boolean isSetPlatformID();

} // PlatformDependant
