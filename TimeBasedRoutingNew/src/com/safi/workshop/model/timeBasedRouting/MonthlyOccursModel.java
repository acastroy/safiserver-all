/**
 * <copyright>
 * </copyright>
 *
 * $Id: MonthlyOccursModel.java,v 1.2 2008/11/16 00:00:28 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting;

import java.util.Date;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Monthly Occurs Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#isByIndex <em>By Index</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getSkipMonths <em>Skip Months</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDayIndex <em>Day Index</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDayOccurence <em>Day Occurence</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDay <em>Day</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getStartDate <em>Start Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getMonthlyOccursModel()
 * @model
 * @generated
 */
public interface MonthlyOccursModel extends OccursModel {
  /**
	 * Returns the value of the '<em><b>By Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>By Index</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>By Index</em>' attribute.
	 * @see #setByIndex(boolean)
	 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getMonthlyOccursModel_ByIndex()
	 * @model
	 * @generated
	 */
  boolean isByIndex();

  /**
	 * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#isByIndex <em>By Index</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>By Index</em>' attribute.
	 * @see #isByIndex()
	 * @generated
	 */
  void setByIndex(boolean value);

  /**
	 * Returns the value of the '<em><b>Skip Months</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Skip Months</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Skip Months</em>' attribute.
	 * @see #setSkipMonths(int)
	 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getMonthlyOccursModel_SkipMonths()
	 * @model default="1" required="true"
	 * @generated
	 */
  int getSkipMonths();

  /**
	 * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getSkipMonths <em>Skip Months</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skip Months</em>' attribute.
	 * @see #getSkipMonths()
	 * @generated
	 */
  void setSkipMonths(int value);

  /**
	 * Returns the value of the '<em><b>Day Index</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Day Index</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Day Index</em>' attribute.
	 * @see #setDayIndex(int)
	 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getMonthlyOccursModel_DayIndex()
	 * @model default="1" required="true"
	 * @generated
	 */
  int getDayIndex();

  /**
	 * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDayIndex <em>Day Index</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day Index</em>' attribute.
	 * @see #getDayIndex()
	 * @generated
	 */
  void setDayIndex(int value);

  /**
	 * Returns the value of the '<em><b>Day Occurence</b></em>' attribute.
	 * The literals are from the enumeration {@link com.safi.workshop.model.timeBasedRouting.DayOccurrence}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Day Occurence</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Day Occurence</em>' attribute.
	 * @see com.safi.workshop.model.timeBasedRouting.DayOccurrence
	 * @see #setDayOccurence(DayOccurrence)
	 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getMonthlyOccursModel_DayOccurence()
	 * @model
	 * @generated
	 */
  DayOccurrence getDayOccurence();

  /**
	 * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDayOccurence <em>Day Occurence</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day Occurence</em>' attribute.
	 * @see com.safi.workshop.model.timeBasedRouting.DayOccurrence
	 * @see #getDayOccurence()
	 * @generated
	 */
  void setDayOccurence(DayOccurrence value);

  /**
	 * Returns the value of the '<em><b>Day</b></em>' attribute.
	 * The literals are from the enumeration {@link com.safi.workshop.model.timeBasedRouting.Day}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Day</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Day</em>' attribute.
	 * @see com.safi.workshop.model.timeBasedRouting.Day
	 * @see #setDay(Day)
	 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getMonthlyOccursModel_Day()
	 * @model
	 * @generated
	 */
  Day getDay();

  /**
	 * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDay <em>Day</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Day</em>' attribute.
	 * @see com.safi.workshop.model.timeBasedRouting.Day
	 * @see #getDay()
	 * @generated
	 */
  void setDay(Day value);

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
	 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getMonthlyOccursModel_StartDate()
	 * @model
	 * @generated
	 */
  Date getStartDate();

  /**
	 * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getStartDate <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Date</em>' attribute.
	 * @see #getStartDate()
	 * @generated
	 */
  void setStartDate(Date value);

} // MonthlyOccursModel
