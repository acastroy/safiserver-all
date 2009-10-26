/**
 * <copyright>
 * </copyright>
 *
 * $Id: ActionstepTest.java,v 1.1 2008/08/19 06:45:08 zacw Exp $
 */
package com.safi.workshop.model.actionpak1;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actionstep Test</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.ActionstepTest#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getActionstepTest()
 * @model
 * @generated
 */
public interface ActionstepTest extends ActionStep {
  /**
   * Returns the value of the '<em><b>Message</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message</em>' containment reference.
   * @see #setMessage(DynamicValue)
   * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getActionstepTest_Message()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='Saflet Path' isTypeLocked='false' description='The message to be logged' expectedReturnType='Saflet Path' helperClass=''"
   *        annotation="Required criteria='non-null'"
   * @generated
   */
  DynamicValue getMessage();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.actionpak1.ActionstepTest#getMessage <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message</em>' containment reference.
   * @see #getMessage()
   * @generated
   */
  void setMessage(DynamicValue value);

} // ActionstepTest
