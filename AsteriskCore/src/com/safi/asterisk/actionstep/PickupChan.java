/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.asterisk.CallConsumer1;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pickup Chan</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.PickupChan#getChannels <em>Channels</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPickupChan()
 * @model
 * @generated
 */
public interface PickupChan extends ActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Channels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Channels</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Channels</em>' containment reference.
	 * @see #setChannels(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPickupChan_Channels()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='An array of channel names.  First one ringing will be chosen' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-empty'"
	 * @generated
	 */
  DynamicValue getChannels();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.PickupChan#getChannels <em>Channels</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channels</em>' containment reference.
	 * @see #getChannels()
	 * @generated
	 */
  void setChannels(DynamicValue value);

} // PickupChan
