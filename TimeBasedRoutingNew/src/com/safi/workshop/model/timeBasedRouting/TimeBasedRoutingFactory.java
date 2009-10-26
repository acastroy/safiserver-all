/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeBasedRoutingFactory.java,v 1.2 2008/11/14 09:53:26 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage
 * @generated
 */
public interface TimeBasedRoutingFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TimeBasedRoutingFactory eINSTANCE = com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Time Based Routing</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Based Routing</em>'.
   * @generated
   */
  TimeBasedRouting createTimeBasedRouting();

  /**
   * Returns a new object of class '<em>Time Item</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Item</em>'.
   * @generated
   */
  TimeItem createTimeItem();

  /**
   * Returns a new object of class '<em>Occurs Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Occurs Model</em>'.
   * @generated
   */
  OccursModel createOccursModel();

  /**
   * Returns a new object of class '<em>Daily Occurs Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Daily Occurs Model</em>'.
   * @generated
   */
  DailyOccursModel createDailyOccursModel();

  /**
   * Returns a new object of class '<em>Weekly Occurs Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Weekly Occurs Model</em>'.
   * @generated
   */
  WeeklyOccursModel createWeeklyOccursModel();

  /**
   * Returns a new object of class '<em>Monthly Occurs Model</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Monthly Occurs Model</em>'.
   * @generated
   */
  MonthlyOccursModel createMonthlyOccursModel();

  /**
   * Returns a new object of class '<em>Time Range</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Time Range</em>'.
   * @generated
   */
  TimeRange createTimeRange();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TimeBasedRoutingPackage getTimeBasedRoutingPackage();

} //TimeBasedRoutingFactory
