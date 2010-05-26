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
 * A representation of the model object '<em><b>Sleep</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.Sleep#getDuration <em>Duration</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Sleep#isNative <em>Native</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSleep()
 * @model
 * @generated
 */
public interface Sleep extends ActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Duration</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(long)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSleep_Duration()
	 * @model ordered="false"
	 *        annotation="unitsTime milliseconds='true'"
	 *        annotation="Required non-zero='true'"
	 * @generated
	 */
  long getDuration();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Sleep#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
  void setDuration(long value);

  /**
	 * Returns the value of the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Native</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Native</em>' attribute.
	 * @see #setNative(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSleep_Native()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isNative();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Sleep#isNative <em>Native</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Native</em>' attribute.
	 * @see #isNative()
	 * @generated
	 */
  void setNative(boolean value);

} // Sleep
