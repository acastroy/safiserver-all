/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.call.CallConsumer1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Wait For Digit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.WaitForDigit#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.WaitForDigit#getAcceptedDigits <em>Accepted Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getWaitForDigit()
 * @model
 * @generated
 */
public interface WaitForDigit extends ActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * The default value is <code>"-1"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(long)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getWaitForDigit_Timeout()
	 * @model default="-1" ordered="false"
	 *        annotation="unitsTime milliseconds='true'"
	 * @generated
	 */
  long getTimeout();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.WaitForDigit#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
  void setTimeout(long value);

  /**
	 * Returns the value of the '<em><b>Accepted Digits</b></em>' attribute.
	 * The default value is <code>"0123456789#"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Accepted Digits</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Accepted Digits</em>' attribute.
	 * @see #setAcceptedDigits(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getWaitForDigit_AcceptedDigits()
	 * @model default="0123456789#" ordered="false"
	 * @generated
	 */
  String getAcceptedDigits();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.WaitForDigit#getAcceptedDigits <em>Accepted Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accepted Digits</em>' attribute.
	 * @see #getAcceptedDigits()
	 * @generated
	 */
  void setAcceptedDigits(String value);

} // WaitForDigit
