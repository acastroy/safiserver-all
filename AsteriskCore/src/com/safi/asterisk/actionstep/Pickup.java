/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.asterisk.CallConsumer1;

import com.safi.core.actionstep.ActionStep;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pickup</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.Pickup#getGroup <em>Group</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getPickup()
 * @model
 * @generated
 */
public interface Pickup extends CallConsumer1, ActionStep {
  /**
   * Returns the value of the '<em><b>Group</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group</em>' attribute.
   * @see #setGroup(String)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getPickup_Group()
   * @model ordered="false"
   *        annotation="Required criteria='non-blank'"
   * @generated
   */
  String getGroup();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.Pickup#getGroup <em>Group</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group</em>' attribute.
   * @see #getGroup()
   * @generated
   */
  void setGroup(String value);

} // Pickup
