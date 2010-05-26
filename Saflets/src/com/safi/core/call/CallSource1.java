/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.call;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.call.CallSource1#getNewCall1 <em>New Call1</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.call.CallPackage#getCallSource1()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface CallSource1 extends EObject {
	/**
	 * Returns the value of the '<em><b>New Call1</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Call1</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Call1</em>' containment reference.
	 * @see #setNewCall1(SafiCall)
	 * @see com.safi.core.call.CallPackage#getCallSource1_NewCall1()
	 * @model containment="true"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	SafiCall getNewCall1();

	/**
	 * Sets the value of the '{@link com.safi.core.call.CallSource1#getNewCall1 <em>New Call1</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Call1</em>' containment reference.
	 * @see #getNewCall1()
	 * @generated
	 */
	void setNewCall1(SafiCall value);

} // CallSource1
