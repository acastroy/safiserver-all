/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator;

import com.safi.asterisk.CallSource1;
import com.safi.core.initiator.Initiator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Incoming Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.initiator.IncomingCall#getCallName <em>Call Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.initiator.InitiatorPackage#getIncomingCall()
 * @model
 * @generated
 */
public interface IncomingCall extends Initiator, CallSource1 {
  /**
   * Returns the value of the '<em><b>Call Name</b></em>' attribute.
   * The default value is <code>"Call1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call Name</em>' attribute.
   * @see #setCallName(String)
   * @see com.safi.asterisk.initiator.InitiatorPackage#getIncomingCall_CallName()
   * @model default="Call1" ordered="false"
   * @generated
   */
  String getCallName();

  /**
   * Sets the value of the '{@link com.safi.asterisk.initiator.IncomingCall#getCallName <em>Call Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call Name</em>' attribute.
   * @see #getCallName()
   * @generated
   */
  void setCallName(String value);

} // IncomingCall
