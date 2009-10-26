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
 * A representation of the model object '<em><b>VM Authenticate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.VMAuthenticate#getMailbox <em>Mailbox</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.VMAuthenticate#isSkipInstructions <em>Skip Instructions</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.VMAuthenticate#isSetAccountCode <em>Set Account Code</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getVMAuthenticate()
 * @model
 * @generated
 */
public interface VMAuthenticate extends ActionStep, CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Mailbox</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mailbox</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mailbox</em>' containment reference.
   * @see #setMailbox(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getVMAuthenticate_Mailbox()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the mailbox name' expectedReturnType='Text' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getMailbox();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.VMAuthenticate#getMailbox <em>Mailbox</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mailbox</em>' containment reference.
   * @see #getMailbox()
   * @generated
   */
  void setMailbox(DynamicValue value);

  /**
   * Returns the value of the '<em><b>Skip Instructions</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Skip Instructions</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Skip Instructions</em>' attribute.
   * @see #setSkipInstructions(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getVMAuthenticate_SkipInstructions()
   * @model ordered="false"
   * @generated
   */
  boolean isSkipInstructions();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.VMAuthenticate#isSkipInstructions <em>Skip Instructions</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Skip Instructions</em>' attribute.
   * @see #isSkipInstructions()
   * @generated
   */
  void setSkipInstructions(boolean value);

  /**
   * Returns the value of the '<em><b>Set Account Code</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Set Account Code</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Set Account Code</em>' attribute.
   * @see #setSetAccountCode(boolean)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getVMAuthenticate_SetAccountCode()
   * @model ordered="false"
   * @generated
   */
  boolean isSetAccountCode();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.VMAuthenticate#isSetAccountCode <em>Set Account Code</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Set Account Code</em>' attribute.
   * @see #isSetAccountCode()
   * @generated
   */
  void setSetAccountCode(boolean value);

} // VMAuthenticate
