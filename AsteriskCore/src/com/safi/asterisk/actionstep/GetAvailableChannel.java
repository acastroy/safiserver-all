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
 * A representation of the model object '<em><b>Get Available Channel</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.GetAvailableChannel#getChannels <em>Channels</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetAvailableChannel#getVariableName <em>Variable Name</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetAvailableChannel#isIgnoreInUse <em>Ignore In Use</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.GetAvailableChannel#isJumpPriorityOnFail <em>Jump Priority On Fail</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetAvailableChannel()
 * @model
 * @generated
 */
public interface GetAvailableChannel extends AsteriskActionStep, CallConsumer1 {
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
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetAvailableChannel_Channels()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the array of channels that will be iterated over' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getChannels();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetAvailableChannel#getChannels <em>Channels</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channels</em>' containment reference.
	 * @see #getChannels()
	 * @generated
	 */
  void setChannels(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Variable Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Name</em>' containment reference.
	 * @see #setVariableName(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetAvailableChannel_VariableName()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the name of the variable in which to store the name of the first available channel' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 *        annotation="Required criteria='non-null'"
	 *        annotation="MetaProperty displayText='Variable'"
	 * @generated
	 */
  DynamicValue getVariableName();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetAvailableChannel#getVariableName <em>Variable Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Name</em>' containment reference.
	 * @see #getVariableName()
	 * @generated
	 */
  void setVariableName(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Ignore In Use</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ignore In Use</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignore In Use</em>' attribute.
	 * @see #setIgnoreInUse(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetAvailableChannel_IgnoreInUse()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isIgnoreInUse();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetAvailableChannel#isIgnoreInUse <em>Ignore In Use</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ignore In Use</em>' attribute.
	 * @see #isIgnoreInUse()
	 * @generated
	 */
  void setIgnoreInUse(boolean value);

  /**
	 * Returns the value of the '<em><b>Jump Priority On Fail</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jump Priority On Fail</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Jump Priority On Fail</em>' attribute.
	 * @see #setJumpPriorityOnFail(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getGetAvailableChannel_JumpPriorityOnFail()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isJumpPriorityOnFail();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.GetAvailableChannel#isJumpPriorityOnFail <em>Jump Priority On Fail</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jump Priority On Fail</em>' attribute.
	 * @see #isJumpPriorityOnFail()
	 * @generated
	 */
  void setJumpPriorityOnFail(boolean value);

} // GetAvailableChannel
