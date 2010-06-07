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
 * A representation of the model object '<em><b>Wait For Ring</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.WaitForRing#getDuration <em>Duration</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getWaitForRing()
 * @model
 * @generated
 */
public interface WaitForRing extends AsteriskActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Duration</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getWaitForRing_Duration()
	 * @model ordered="false"
	 *        annotation="unitsTime seconds='true'"
	 * @generated
	 */
  int getDuration();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.WaitForRing#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
  void setDuration(int value);

} // WaitForRing
