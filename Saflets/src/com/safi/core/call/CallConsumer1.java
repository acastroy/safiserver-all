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
 * A representation of the model object '<em><b>Consumer1</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.call.CallConsumer1#getCall1 <em>Call1</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.call.CallPackage#getCallConsumer1()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface CallConsumer1 extends EObject {
	/**
	 * Returns the value of the '<em><b>Call1</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call1</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call1</em>' reference.
	 * @see #setCall1(SafiCall)
	 * @see com.safi.core.call.CallPackage#getCallConsumer1_Call1()
	 * @model annotation="Required criteria='non-null'"
	 * @generated
	 */
	SafiCall getCall1();

	/**
	 * Sets the value of the '{@link com.safi.core.call.CallConsumer1#getCall1 <em>Call1</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call1</em>' reference.
	 * @see #getCall1()
	 * @generated
	 */
	void setCall1(SafiCall value);

} // CallConsumer1
