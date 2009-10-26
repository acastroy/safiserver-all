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
 * A representation of the model object '<em><b>Festival</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.Festival#getText <em>Text</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Festival#getInterruptKeys <em>Interrupt Keys</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getFestival()
 * @model
 * @generated
 */
public interface Festival extends ActionStep, CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Text</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Text</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Text</em>' containment reference.
   * @see #setText(DynamicValue)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getFestival_Text()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the text to be vocalized' expectedReturnType='Text' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getText();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Festival#getText <em>Text</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Text</em>' containment reference.
   * @see #getText()
   * @generated
   */
  void setText(DynamicValue value);

  /**
   * Returns the value of the '<em><b>Interrupt Keys</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interrupt Keys</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interrupt Keys</em>' attribute.
   * @see #setInterruptKeys(String)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getFestival_InterruptKeys()
   * @model ordered="false"
   * @generated
   */
  String getInterruptKeys();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Festival#getInterruptKeys <em>Interrupt Keys</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interrupt Keys</em>' attribute.
   * @see #getInterruptKeys()
   * @generated
   */
  void setInterruptKeys(String value);

} // Festival
