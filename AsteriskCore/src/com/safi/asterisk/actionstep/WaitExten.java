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
 * A representation of the model object '<em><b>Wait Exten</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.WaitExten#getMusicOnHoldClass <em>Music On Hold Class</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.WaitExten#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getWaitExten()
 * @model
 * @generated
 */
public interface WaitExten extends ActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Music On Hold Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Music On Hold Class</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Music On Hold Class</em>' attribute.
	 * @see #setMusicOnHoldClass(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getWaitExten_MusicOnHoldClass()
	 * @model ordered="false"
	 * @generated
	 */
  String getMusicOnHoldClass();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.WaitExten#getMusicOnHoldClass <em>Music On Hold Class</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Music On Hold Class</em>' attribute.
	 * @see #getMusicOnHoldClass()
	 * @generated
	 */
  void setMusicOnHoldClass(String value);

  /**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getWaitExten_Timeout()
	 * @model ordered="false"
	 *        annotation="unitsTime seconds='true'"
	 * @generated
	 */
  int getTimeout();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.WaitExten#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
  void setTimeout(int value);

} // WaitExten
