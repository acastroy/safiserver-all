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
 * A representation of the model object '<em><b>Set Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.SetExtension#getExtension <em>Extension</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetExtension()
 * @model
 * @generated
 */
public interface SetExtension extends ActionStep, CallConsumer1 {
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
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getSetExtension_Extension()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The extension of the current call will be set to this text value.' expectedReturnType='Text' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getExtension();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.SetExtension#getExtension <em>Extension</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Extension</em>' containment reference.
   * @see #getExtension()
   * @generated
   */
  void setExtension(DynamicValue value);

} // SetExtension
