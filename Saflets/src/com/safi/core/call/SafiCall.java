/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.call;

import com.safi.core.PlatformDisposition;
import com.safi.core.ThreadSensitive;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Safi Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.call.SafiCall#getUuid <em>Uuid</em>}</li>
 *   <li>{@link com.safi.core.call.SafiCall#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.call.CallPackage#getSafiCall()
 * @model abstract="true"
 * @generated
 */
public interface SafiCall extends ThreadSensitive, PlatformDisposition {
	/**
	 * Returns the value of the '<em><b>Uuid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Uuid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Uuid</em>' attribute.
	 * @see #setUuid(String)
	 * @see com.safi.core.call.CallPackage#getSafiCall_Uuid()
	 * @model
	 * @generated
	 */
	String getUuid();

	/**
	 * Sets the value of the '{@link com.safi.core.call.SafiCall#getUuid <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Uuid</em>' attribute.
	 * @see #getUuid()
	 * @generated
	 */
	void setUuid(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.safi.core.call.CallPackage#getSafiCall_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.safi.core.call.SafiCall#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // SafiCall
