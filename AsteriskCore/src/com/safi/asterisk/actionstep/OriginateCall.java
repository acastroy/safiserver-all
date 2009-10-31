/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.asterisk.CallSource1;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Originate Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#isAsync <em>Async</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#getAccount <em>Account</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#getApplication <em>Application</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#getCallerId <em>Caller Id</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#getContext <em>Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#getData <em>Data</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#getExtension <em>Extension</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#getCallingPresentation <em>Calling Presentation</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#getChannel <em>Channel</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#isTakeControl <em>Take Control</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.OriginateCall#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall()
 * @model
 * @generated
 */
public interface OriginateCall extends ActionStep, CallSource1 {
  /**
	 * Returns the value of the '<em><b>Async</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Async</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Async</em>' attribute.
	 * @see #setAsync(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_Async()
	 * @model default="false" ordered="false"
	 * @generated
	 */
  boolean isAsync();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#isAsync <em>Async</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Async</em>' attribute.
	 * @see #isAsync()
	 * @generated
	 */
  void setAsync(boolean value);

  /**
	 * Returns the value of the '<em><b>Account</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Account</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Account</em>' containment reference.
	 * @see #setAccount(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_Account()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The account code of the new call will be assigned this text value.' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getAccount();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#getAccount <em>Account</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Account</em>' containment reference.
	 * @see #getAccount()
	 * @generated
	 */
  void setAccount(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Application</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Application</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Application</em>' containment reference.
	 * @see #setApplication(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_Application()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Application to use on connect (use Data for parameters)' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getApplication();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#getApplication <em>Application</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Application</em>' containment reference.
	 * @see #getApplication()
	 * @generated
	 */
  void setApplication(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Caller Id</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Caller Id</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Caller Id</em>' containment reference.
	 * @see #setCallerId(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_CallerId()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='CallerID to use for the call' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getCallerId();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#getCallerId <em>Caller Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caller Id</em>' containment reference.
	 * @see #getCallerId()
	 * @generated
	 */
  void setCallerId(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Context</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference.
	 * @see #setContext(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_Context()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Context to use on connect (must use Exten & Priority with it)' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getContext();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#getContext <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' containment reference.
	 * @see #getContext()
	 * @generated
	 */
  void setContext(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Data</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Data</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' containment reference.
	 * @see #setData(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_Data()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Data if Application parameter is used' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getData();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#getData <em>Data</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' containment reference.
	 * @see #getData()
	 * @generated
	 */
  void setData(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Extension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Extension</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' containment reference.
	 * @see #setExtension(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_Extension()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Extension to use on connect (must use Context & Priority with it)' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getExtension();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#getExtension <em>Extension</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' containment reference.
	 * @see #getExtension()
	 * @generated
	 */
  void setExtension(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see #setPriority(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_Priority()
	 * @model default="1" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Priority to use on connect (must use Context & Exten with it)' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  int getPriority();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see #getPriority()
	 * @generated
	 */
  void setPriority(int value);

  /**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(long)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_Timeout()
	 * @model ordered="false"
	 *        annotation="unitsTime milliseconds='true'"
	 * @generated
	 */
  long getTimeout();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
  void setTimeout(long value);

  /**
	 * Returns the value of the '<em><b>Calling Presentation</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Calling Presentation</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Calling Presentation</em>' attribute.
	 * @see #setCallingPresentation(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_CallingPresentation()
	 * @model default="1" ordered="false"
	 * @generated
	 */
  int getCallingPresentation();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#getCallingPresentation <em>Calling Presentation</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calling Presentation</em>' attribute.
	 * @see #getCallingPresentation()
	 * @generated
	 */
  void setCallingPresentation(int value);

  /**
	 * Returns the value of the '<em><b>Channel</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Channel</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Channel</em>' containment reference.
	 * @see #setChannel(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_Channel()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Context to use on connect (must use Exten & Priority with it)' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getChannel();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#getChannel <em>Channel</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Channel</em>' containment reference.
	 * @see #getChannel()
	 * @generated
	 */
  void setChannel(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Take Control</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Take Control</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Take Control</em>' attribute.
	 * @see #setTakeControl(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_TakeControl()
	 * @model default="false" ordered="false"
	 * @generated
	 */
  boolean isTakeControl();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#isTakeControl <em>Take Control</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Take Control</em>' attribute.
	 * @see #isTakeControl()
	 * @generated
	 */
  void setTakeControl(boolean value);

  /**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variables</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference.
	 * @see #setVariables(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getOriginateCall_Variables()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Array of variables to set [name1, value1, name2, value2...]' expectedReturnType='Array' helperClass=''"
	 * @generated
	 */
  DynamicValue getVariables();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.OriginateCall#getVariables <em>Variables</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variables</em>' containment reference.
	 * @see #getVariables()
	 * @generated
	 */
  void setVariables(DynamicValue value);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void setVariable(String name, String value);

} // OriginateCall
