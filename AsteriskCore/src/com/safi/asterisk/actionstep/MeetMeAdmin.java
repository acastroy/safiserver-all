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
 * A representation of the model object '<em><b>Meet Me Admin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMeAdmin#getConferenceNumber <em>Conference Number</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMeAdmin#getCommand <em>Command</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMeAdmin#getUser <em>User</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMeAdmin()
 * @model
 * @generated
 */
public interface MeetMeAdmin extends AsteriskActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Conference Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conference Number</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Conference Number</em>' containment reference.
	 * @see #setConferenceNumber(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMeAdmin_ConferenceNumber()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the conference number' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getConferenceNumber();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMeAdmin#getConferenceNumber <em>Conference Number</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conference Number</em>' containment reference.
	 * @see #getConferenceNumber()
	 * @generated
	 */
  void setConferenceNumber(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Command</b></em>' attribute.
	 * The literals are from the enumeration {@link com.safi.asterisk.actionstep.MeetMeAdminCommand}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Command</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Command</em>' attribute.
	 * @see com.safi.asterisk.actionstep.MeetMeAdminCommand
	 * @see #setCommand(MeetMeAdminCommand)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMeAdmin_Command()
	 * @model ordered="false"
	 * @generated
	 */
  MeetMeAdminCommand getCommand();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMeAdmin#getCommand <em>Command</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Command</em>' attribute.
	 * @see com.safi.asterisk.actionstep.MeetMeAdminCommand
	 * @see #getCommand()
	 * @generated
	 */
  void setCommand(MeetMeAdminCommand value);

  /**
	 * Returns the value of the '<em><b>User</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>User</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>User</em>' containment reference.
	 * @see #setUser(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMeAdmin_User()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the user at which the command will targeted (if applicable)' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getUser();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMeAdmin#getUser <em>User</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User</em>' containment reference.
	 * @see #getUser()
	 * @generated
	 */
  void setUser(DynamicValue value);

} // MeetMeAdmin
