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
 * A representation of the model object '<em><b>Set Auto Hangup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SetAutoHangup#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetAutoHangup()
 * @model
 * @generated
 */
public interface SetAutoHangup extends AsteriskActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(long)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetAutoHangup_Time()
	 * @model ordered="false"
	 *        annotation="unitsTime seconds='true'"
	 *        annotation="Required non-zero='true'"
	 * @generated
	 */
  long getTime();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.SetAutoHangup#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
  void setTime(long value);

} // SetAutoHangup
