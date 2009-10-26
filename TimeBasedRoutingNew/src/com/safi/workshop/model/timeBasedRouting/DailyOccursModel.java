/**
 * <copyright>
 * </copyright>
 *
 * $Id: DailyOccursModel.java,v 1.2 2008/11/16 00:00:28 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting;

import java.util.Date;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Daily Occurs Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.DailyOccursModel#getSkipDays <em>Skip Days</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.DailyOccursModel#getStartDate <em>Start Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getDailyOccursModel()
 * @model
 * @generated
 */
public interface DailyOccursModel extends OccursModel {
  /**
   * Returns the value of the '<em><b>Skip Days</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Skip Days</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Skip Days</em>' attribute.
   * @see #setSkipDays(int)
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getDailyOccursModel_SkipDays()
   * @model
   * @generated
   */
  int getSkipDays();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.DailyOccursModel#getSkipDays <em>Skip Days</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Skip Days</em>' attribute.
   * @see #getSkipDays()
   * @generated
   */
  void setSkipDays(int value);

  /**
   * Returns the value of the '<em><b>Start Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Date</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Date</em>' attribute.
   * @see #setStartDate(Date)
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getDailyOccursModel_StartDate()
   * @model
   * @generated
   */
  Date getStartDate();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.DailyOccursModel#getStartDate <em>Start Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Date</em>' attribute.
   * @see #getStartDate()
   * @generated
   */
  void setStartDate(Date value);

} // DailyOccursModel
