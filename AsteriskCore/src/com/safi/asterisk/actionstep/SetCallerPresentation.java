/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.core.call.CallConsumer1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Caller Presentation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SetCallerPresentation#getPresentation <em>Presentation</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetCallerPresentation()
 * @model
 * @generated
 */
public interface SetCallerPresentation extends AsteriskActionStep, CallConsumer1 {
	/**
	 * Returns the value of the '<em><b>Presentation</b></em>' attribute.
	 * The default value is <code>"allowed"</code>.
	 * The literals are from the enumeration {@link com.safi.asterisk.actionstep.PresentationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Presentation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Presentation</em>' attribute.
	 * @see com.safi.asterisk.actionstep.PresentationType
	 * @see #setPresentation(PresentationType)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetCallerPresentation_Presentation()
	 * @model default="allowed" ordered="false"
	 * @generated
	 */
	PresentationType getPresentation();

	/**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.SetCallerPresentation#getPresentation <em>Presentation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Presentation</em>' attribute.
	 * @see com.safi.asterisk.actionstep.PresentationType
	 * @see #getPresentation()
	 * @generated
	 */
	void setPresentation(PresentationType value);

} // SetCallerPresentation
