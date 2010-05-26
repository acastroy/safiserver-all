/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.call;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Source2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.call.CallSource2#getNewCall2 <em>New Call2</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.call.CallPackage#getCallSource2()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface CallSource2 extends CallSource1 {
	/**
	 * Returns the value of the '<em><b>New Call2</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Call2</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Call2</em>' containment reference.
	 * @see #setNewCall2(SafiCall)
	 * @see com.safi.core.call.CallPackage#getCallSource2_NewCall2()
	 * @model containment="true"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	SafiCall getNewCall2();

	/**
	 * Sets the value of the '{@link com.safi.core.call.CallSource2#getNewCall2 <em>New Call2</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Call2</em>' containment reference.
	 * @see #getNewCall2()
	 * @generated
	 */
	void setNewCall2(SafiCall value);

} // CallSource2
