/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1;

import com.safi.core.actionstep.ParameterizedInitiator;
import com.safi.core.call.CallSource1;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Incoming Call2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.IncomingCall2#getCallName <em>Call Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getIncomingCall2()
 * @model abstract="true"
 * @generated
 */
public interface IncomingCall2 extends ParameterizedInitiator, CallSource1 {
  /**
	 * Returns the value of the '<em><b>Call Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Name</em>' attribute.
	 * @see #setCallName(String)
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getIncomingCall2_CallName()
	 * @model
	 * @generated
	 */
  String getCallName();

  /**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.IncomingCall2#getCallName <em>Call Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Name</em>' attribute.
	 * @see #getCallName()
	 * @generated
	 */
  void setCallName(String value);

} // IncomingCall2
