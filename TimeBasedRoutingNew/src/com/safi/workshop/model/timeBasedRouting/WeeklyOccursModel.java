/**
 * <copyright>
 * </copyright>
 *
 * $Id: WeeklyOccursModel.java,v 1.1 2008/11/14 09:53:26 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Weekly Occurs Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel#getSkipWeeks <em>Skip Weeks</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel#getDays <em>Days</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel#getStartDate <em>Start Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getWeeklyOccursModel()
 * @model
 * @generated
 */
public interface WeeklyOccursModel extends OccursModel {
  /**
   * Returns the value of the '<em><b>Skip Weeks</b></em>' attribute.
   * The default value is <code>"1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Skip Weeks</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Skip Weeks</em>' attribute.
   * @see #setSkipWeeks(int)
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getWeeklyOccursModel_SkipWeeks()
   * @model default="1" required="true"
   * @generated
   */
  int getSkipWeeks();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel#getSkipWeeks <em>Skip Weeks</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Skip Weeks</em>' attribute.
   * @see #getSkipWeeks()
   * @generated
   */
  void setSkipWeeks(int value);

  /**
   * Returns the value of the '<em><b>Days</b></em>' attribute list.
   * The list contents are of type {@link com.safi.workshop.model.timeBasedRouting.Day}.
   * The literals are from the enumeration {@link com.safi.workshop.model.timeBasedRouting.Day}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Days</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Days</em>' attribute list.
   * @see com.safi.workshop.model.timeBasedRouting.Day
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getWeeklyOccursModel_Days()
   * @model
   * @generated
   */
  EList<Day> getDays();

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
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getWeeklyOccursModel_StartDate()
   * @model
   * @generated
   */
  Date getStartDate();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel#getStartDate <em>Start Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Date</em>' attribute.
   * @see #getStartDate()
   * @generated
   */
  void setStartDate(Date value);

} // WeeklyOccursModel
