/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.call.CallConsumer1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Play Music On Hold</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.PlayMusicOnHold#getHoldClass <em>Hold Class</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPlayMusicOnHold()
 * @model
 * @generated
 */
public interface PlayMusicOnHold extends ActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Hold Class</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hold Class</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Hold Class</em>' containment reference.
	 * @see #setHoldClass(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPlayMusicOnHold_HoldClass()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The Asterisk music class to play.' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getHoldClass();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.PlayMusicOnHold#getHoldClass <em>Hold Class</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hold Class</em>' containment reference.
	 * @see #getHoldClass()
	 * @generated
	 */
  void setHoldClass(DynamicValue value);

} // PlayMusicOnHold
