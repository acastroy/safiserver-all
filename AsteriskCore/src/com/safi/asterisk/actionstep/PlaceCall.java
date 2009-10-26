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
 * A representation of the model object '<em><b>Place Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.PlaceCall#getExtension <em>Extension</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.PlaceCall#getContext <em>Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.PlaceCall#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.PlaceCall#getCallerId <em>Caller Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPlaceCall()
 * @model
 * @generated
 */
public interface PlaceCall extends ActionStep, CallSource1 {
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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getPlaceCall_Extension()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Extension to call' expectedReturnType='Text' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getExtension();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.PlaceCall#getExtension <em>Extension</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extension</em>' containment reference.
   * @see #getExtension()
   * @generated
   */
  void setExtension(DynamicValue value);

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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getPlaceCall_Context()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Destination context ' expectedReturnType='Text' helperClass=''"
   * @generated
   */
  DynamicValue getContext();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.PlaceCall#getContext <em>Context</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Context</em>' containment reference.
   * @see #getContext()
   * @generated
   */
  void setContext(DynamicValue value);

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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getPlaceCall_Timeout()
   * @model ordered="false"
   *        annotation="unitsTime milliseconds='true'"
   * @generated
   */
  long getTimeout();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.PlaceCall#getTimeout <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Timeout</em>' attribute.
   * @see #getTimeout()
   * @generated
   */
  void setTimeout(long value);

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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getPlaceCall_CallerId()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='CallerID to use for the call' expectedReturnType='Text' helperClass=''"
   * @generated
   */
  DynamicValue getCallerId();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.PlaceCall#getCallerId <em>Caller Id</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Caller Id</em>' containment reference.
   * @see #getCallerId()
   * @generated
   */
  void setCallerId(DynamicValue value);

} // PlaceCall
