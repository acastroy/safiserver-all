/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeBasedRoutingFactoryImpl.java,v 1.3 2008/11/16 00:00:28 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.impl;

import com.safi.workshop.model.timeBasedRouting.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TimeBasedRoutingFactoryImpl extends EFactoryImpl implements TimeBasedRoutingFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TimeBasedRoutingFactory init() {
    try {
      TimeBasedRoutingFactory theTimeBasedRoutingFactory = (TimeBasedRoutingFactory)EPackage.Registry.INSTANCE.getEFactory("http:///com/safi/workshop/timeBasedRouting.ecore"); 
      if (theTimeBasedRoutingFactory != null) {
        return theTimeBasedRoutingFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TimeBasedRoutingFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeBasedRoutingFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case TimeBasedRoutingPackage.TIME_BASED_ROUTING: return createTimeBasedRouting();
      case TimeBasedRoutingPackage.TIME_ITEM: return createTimeItem();
      case TimeBasedRoutingPackage.OCCURS_MODEL: return createOccursModel();
      case TimeBasedRoutingPackage.DAILY_OCCURS_MODEL: return createDailyOccursModel();
      case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL: return createWeeklyOccursModel();
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL: return createMonthlyOccursModel();
      case TimeBasedRoutingPackage.TIME_RANGE: return createTimeRange();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
      case TimeBasedRoutingPackage.OCCURS_MODE:
        return createOccursModeFromString(eDataType, initialValue);
      case TimeBasedRoutingPackage.DAY:
        return createDayFromString(eDataType, initialValue);
      case TimeBasedRoutingPackage.DAY_OCCURRENCE:
        return createDayOccurrenceFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
      case TimeBasedRoutingPackage.OCCURS_MODE:
        return convertOccursModeToString(eDataType, instanceValue);
      case TimeBasedRoutingPackage.DAY:
        return convertDayToString(eDataType, instanceValue);
      case TimeBasedRoutingPackage.DAY_OCCURRENCE:
        return convertDayOccurrenceToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeBasedRouting createTimeBasedRouting() {
    TimeBasedRoutingImpl timeBasedRouting = new TimeBasedRoutingImpl();
    return timeBasedRouting;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeItem createTimeItem() {
    TimeItemImpl timeItem = new TimeItemImpl();
    return timeItem;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OccursModel createOccursModel() {
    OccursModelImpl occursModel = new OccursModelImpl();
    return occursModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DailyOccursModel createDailyOccursModel() {
    DailyOccursModelImpl dailyOccursModel = new DailyOccursModelImpl();
    return dailyOccursModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WeeklyOccursModel createWeeklyOccursModel() {
    WeeklyOccursModelImpl weeklyOccursModel = new WeeklyOccursModelImpl();
    return weeklyOccursModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MonthlyOccursModel createMonthlyOccursModel() {
    MonthlyOccursModelImpl monthlyOccursModel = new MonthlyOccursModelImpl();
    return monthlyOccursModel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeRange createTimeRange() {
    TimeRangeImpl timeRange = new TimeRangeImpl();
    return timeRange;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OccursMode createOccursModeFromString(EDataType eDataType, String initialValue) {
    OccursMode result = OccursMode.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertOccursModeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Day createDayFromString(EDataType eDataType, String initialValue) {
    Day result = Day.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDayToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DayOccurrence createDayOccurrenceFromString(EDataType eDataType, String initialValue) {
    DayOccurrence result = DayOccurrence.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertDayOccurrenceToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TimeBasedRoutingPackage getTimeBasedRoutingPackage() {
    return (TimeBasedRoutingPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TimeBasedRoutingPackage getPackage() {
    return TimeBasedRoutingPackage.eINSTANCE;
  }

} //TimeBasedRoutingFactoryImpl
