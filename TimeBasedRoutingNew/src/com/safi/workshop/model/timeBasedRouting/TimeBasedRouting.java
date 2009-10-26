/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeBasedRouting.java,v 1.1 2008/11/13 11:18:39 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting;

import org.eclipse.emf.common.util.EList;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Based Routing</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.TimeBasedRouting#getValue <em>Value</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.TimeBasedRouting#getTimes <em>Times</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getTimeBasedRouting()
 * @model
 * @generated
 */
public interface TimeBasedRouting extends ActionStep {
  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(DynamicValue)
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getTimeBasedRouting_Value()
   * @model containment="true" ordered="false"
   *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The value to assign' expectedReturnType='Unknown' helperClass=''"
   * @generated
   */
  DynamicValue getValue();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.TimeBasedRouting#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(DynamicValue value);

  /**
   * Returns the value of the '<em><b>Times</b></em>' containment reference list.
   * The list contents are of type {@link com.safi.workshop.model.timeBasedRouting.TimeItem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Times</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Times</em>' containment reference list.
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getTimeBasedRouting_Times()
   * @model containment="true"
   *        annotation="Required criteria='non-empty'"
   * @generated
   */
  EList<TimeItem> getTimes();

} // TimeBasedRouting
