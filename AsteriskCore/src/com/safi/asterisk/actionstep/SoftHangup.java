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
 * A representation of the model object '<em><b>Soft Hangup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SoftHangup#isHangupAllDeviceCalls <em>Hangup All Device Calls</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.SoftHangup#getChannelName <em>Channel Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSoftHangup()
 * @model
 * @generated
 */
public interface SoftHangup extends AsteriskActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Hangup All Device Calls</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Hangup All Device Calls</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Hangup All Device Calls</em>' attribute.
	 * @see #setHangupAllDeviceCalls(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSoftHangup_HangupAllDeviceCalls()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isHangupAllDeviceCalls();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.SoftHangup#isHangupAllDeviceCalls <em>Hangup All Device Calls</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hangup All Device Calls</em>' attribute.
	 * @see #isHangupAllDeviceCalls()
	 * @generated
	 */
  void setHangupAllDeviceCalls(boolean value);

  /**
	 * Returns the value of the '<em><b>Channel Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Channel Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel Name</em>' containment reference.
	 * @see #setChannelName(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSoftHangup_ChannelName()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Name of the channel to hangup' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getChannelName();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.SoftHangup#getChannelName <em>Channel Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel Name</em>' containment reference.
	 * @see #getChannelName()
	 * @generated
	 */
  void setChannelName(DynamicValue value);

} // SoftHangup
