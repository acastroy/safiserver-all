/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeBasedRoutingPackage.java,v 1.4 2008/11/16 00:00:28 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import com.safi.core.actionstep.ActionStepPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingFactory
 * @model kind="package"
 * @generated
 */
public interface TimeBasedRoutingPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "timeBasedRouting";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http:///com/safi/workshop/timeBasedRouting.ecore";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "com.safi.workshop.timeBasedRouting";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TimeBasedRoutingPackage eINSTANCE = com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl.init();

  /**
   * The meta object id for the '{@link com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingImpl <em>Time Based Routing</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingImpl
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getTimeBasedRouting()
   * @generated
   */
  int TIME_BASED_ROUTING = 0;

  /**
   * The feature id for the '<em><b>Product Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_BASED_ROUTING__PRODUCT_ID = ActionStepPackage.ACTION_STEP__PRODUCT_ID;

  /**
   * The feature id for the '<em><b>Paused</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_BASED_ROUTING__PAUSED = ActionStepPackage.ACTION_STEP__PAUSED;

  /**
   * The feature id for the '<em><b>Active</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_BASED_ROUTING__ACTIVE = ActionStepPackage.ACTION_STEP__ACTIVE;

  /**
   * The feature id for the '<em><b>Outputs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_BASED_ROUTING__OUTPUTS = ActionStepPackage.ACTION_STEP__OUTPUTS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_BASED_ROUTING__NAME = ActionStepPackage.ACTION_STEP__NAME;

  /**
   * The feature id for the '<em><b>Saflet</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_BASED_ROUTING__SAFLET = ActionStepPackage.ACTION_STEP__SAFLET;

  /**
   * The feature id for the '<em><b>Default Output</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_BASED_ROUTING__DEFAULT_OUTPUT = ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT;

  /**
   * The feature id for the '<em><b>Error Output</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_BASED_ROUTING__ERROR_OUTPUT = ActionStepPackage.ACTION_STEP__ERROR_OUTPUT;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_BASED_ROUTING__VALUE = ActionStepPackage.ACTION_STEP_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Times</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_BASED_ROUTING__TIMES = ActionStepPackage.ACTION_STEP_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Time Based Routing</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_BASED_ROUTING_FEATURE_COUNT = ActionStepPackage.ACTION_STEP_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.safi.workshop.model.timeBasedRouting.impl.TimeItemImpl <em>Time Item</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeItemImpl
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getTimeItem()
   * @generated
   */
  int TIME_ITEM = 1;

  /**
   * The feature id for the '<em><b>Label Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_ITEM__LABEL_TEXT = ActionStepPackage.CASE_ITEM__LABEL_TEXT;

  /**
   * The feature id for the '<em><b>Parent Action Step</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_ITEM__PARENT_ACTION_STEP = ActionStepPackage.CASE_ITEM__PARENT_ACTION_STEP;

  /**
   * The feature id for the '<em><b>Target Action Step</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_ITEM__TARGET_ACTION_STEP = ActionStepPackage.CASE_ITEM__TARGET_ACTION_STEP;

  /**
   * The feature id for the '<em><b>Dynamic Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_ITEM__DYNAMIC_VALUE = ActionStepPackage.CASE_ITEM__DYNAMIC_VALUE;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_ITEM__DESCRIPTION = ActionStepPackage.CASE_ITEM_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Time Item</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_ITEM_FEATURE_COUNT = ActionStepPackage.CASE_ITEM_FEATURE_COUNT + 1;


  /**
   * The meta object id for the '{@link com.safi.workshop.model.timeBasedRouting.impl.OccursModelImpl <em>Occurs Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.workshop.model.timeBasedRouting.impl.OccursModelImpl
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getOccursModel()
   * @generated
   */
  int OCCURS_MODEL = 2;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCCURS_MODEL__MODE = 0;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCCURS_MODEL__DESCRIPTION = 1;

  /**
   * The number of structural features of the '<em>Occurs Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCCURS_MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.safi.workshop.model.timeBasedRouting.impl.DailyOccursModelImpl <em>Daily Occurs Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.workshop.model.timeBasedRouting.impl.DailyOccursModelImpl
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getDailyOccursModel()
   * @generated
   */
  int DAILY_OCCURS_MODEL = 3;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DAILY_OCCURS_MODEL__MODE = OCCURS_MODEL__MODE;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DAILY_OCCURS_MODEL__DESCRIPTION = OCCURS_MODEL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Skip Days</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DAILY_OCCURS_MODEL__SKIP_DAYS = OCCURS_MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Start Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DAILY_OCCURS_MODEL__START_DATE = OCCURS_MODEL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Daily Occurs Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DAILY_OCCURS_MODEL_FEATURE_COUNT = OCCURS_MODEL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link com.safi.workshop.model.timeBasedRouting.impl.WeeklyOccursModelImpl <em>Weekly Occurs Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.workshop.model.timeBasedRouting.impl.WeeklyOccursModelImpl
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getWeeklyOccursModel()
   * @generated
   */
  int WEEKLY_OCCURS_MODEL = 4;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEEKLY_OCCURS_MODEL__MODE = OCCURS_MODEL__MODE;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEEKLY_OCCURS_MODEL__DESCRIPTION = OCCURS_MODEL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>Skip Weeks</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEEKLY_OCCURS_MODEL__SKIP_WEEKS = OCCURS_MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Days</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEEKLY_OCCURS_MODEL__DAYS = OCCURS_MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Start Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEEKLY_OCCURS_MODEL__START_DATE = OCCURS_MODEL_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Weekly Occurs Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WEEKLY_OCCURS_MODEL_FEATURE_COUNT = OCCURS_MODEL_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.safi.workshop.model.timeBasedRouting.impl.MonthlyOccursModelImpl <em>Monthly Occurs Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.workshop.model.timeBasedRouting.impl.MonthlyOccursModelImpl
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getMonthlyOccursModel()
   * @generated
   */
  int MONTHLY_OCCURS_MODEL = 5;

  /**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONTHLY_OCCURS_MODEL__MODE = OCCURS_MODEL__MODE;

  /**
   * The feature id for the '<em><b>Description</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONTHLY_OCCURS_MODEL__DESCRIPTION = OCCURS_MODEL__DESCRIPTION;

  /**
   * The feature id for the '<em><b>By Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONTHLY_OCCURS_MODEL__BY_INDEX = OCCURS_MODEL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Skip Months</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONTHLY_OCCURS_MODEL__SKIP_MONTHS = OCCURS_MODEL_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Day Index</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONTHLY_OCCURS_MODEL__DAY_INDEX = OCCURS_MODEL_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Day Occurence</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONTHLY_OCCURS_MODEL__DAY_OCCURENCE = OCCURS_MODEL_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Day</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONTHLY_OCCURS_MODEL__DAY = OCCURS_MODEL_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Start Date</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONTHLY_OCCURS_MODEL__START_DATE = OCCURS_MODEL_FEATURE_COUNT + 5;

  /**
   * The number of structural features of the '<em>Monthly Occurs Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MONTHLY_OCCURS_MODEL_FEATURE_COUNT = OCCURS_MODEL_FEATURE_COUNT + 6;

  /**
   * The meta object id for the '{@link com.safi.workshop.model.timeBasedRouting.impl.TimeRangeImpl <em>Time Range</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeRangeImpl
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getTimeRange()
   * @generated
   */
  int TIME_RANGE = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_RANGE__NAME = 0;

  /**
   * The feature id for the '<em><b>Occurs Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_RANGE__OCCURS_MODEL = 1;

  /**
   * The feature id for the '<em><b>Start Range</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_RANGE__START_RANGE = 2;

  /**
   * The feature id for the '<em><b>End Range</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_RANGE__END_RANGE = 3;

  /**
   * The number of structural features of the '<em>Time Range</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_RANGE_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.safi.workshop.model.timeBasedRouting.OccursMode <em>Occurs Mode</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.workshop.model.timeBasedRouting.OccursMode
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getOccursMode()
   * @generated
   */
  int OCCURS_MODE = 7;

  /**
   * The meta object id for the '{@link com.safi.workshop.model.timeBasedRouting.Day <em>Day</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.workshop.model.timeBasedRouting.Day
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getDay()
   * @generated
   */
  int DAY = 8;

  /**
   * The meta object id for the '{@link com.safi.workshop.model.timeBasedRouting.DayOccurrence <em>Day Occurrence</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.workshop.model.timeBasedRouting.DayOccurrence
   * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getDayOccurrence()
   * @generated
   */
  int DAY_OCCURRENCE = 9;


  /**
   * Returns the meta object for class '{@link com.safi.workshop.model.timeBasedRouting.TimeBasedRouting <em>Time Based Routing</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Based Routing</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRouting
   * @generated
   */
  EClass getTimeBasedRouting();

  /**
   * Returns the meta object for the containment reference '{@link com.safi.workshop.model.timeBasedRouting.TimeBasedRouting#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRouting#getValue()
   * @see #getTimeBasedRouting()
   * @generated
   */
  EReference getTimeBasedRouting_Value();

  /**
   * Returns the meta object for the containment reference list '{@link com.safi.workshop.model.timeBasedRouting.TimeBasedRouting#getTimes <em>Times</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Times</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRouting#getTimes()
   * @see #getTimeBasedRouting()
   * @generated
   */
  EReference getTimeBasedRouting_Times();

  /**
   * Returns the meta object for class '{@link com.safi.workshop.model.timeBasedRouting.TimeItem <em>Time Item</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Item</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.TimeItem
   * @generated
   */
  EClass getTimeItem();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.TimeItem#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.TimeItem#getDescription()
   * @see #getTimeItem()
   * @generated
   */
  EAttribute getTimeItem_Description();

  /**
   * Returns the meta object for class '{@link com.safi.workshop.model.timeBasedRouting.OccursModel <em>Occurs Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Occurs Model</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.OccursModel
   * @generated
   */
  EClass getOccursModel();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.OccursModel#getMode <em>Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mode</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.OccursModel#getMode()
   * @see #getOccursModel()
   * @generated
   */
  EAttribute getOccursModel_Mode();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.OccursModel#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Description</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.OccursModel#getDescription()
   * @see #getOccursModel()
   * @generated
   */
  EAttribute getOccursModel_Description();

  /**
   * Returns the meta object for class '{@link com.safi.workshop.model.timeBasedRouting.DailyOccursModel <em>Daily Occurs Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Daily Occurs Model</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.DailyOccursModel
   * @generated
   */
  EClass getDailyOccursModel();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.DailyOccursModel#getSkipDays <em>Skip Days</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Skip Days</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.DailyOccursModel#getSkipDays()
   * @see #getDailyOccursModel()
   * @generated
   */
  EAttribute getDailyOccursModel_SkipDays();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.DailyOccursModel#getStartDate <em>Start Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Date</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.DailyOccursModel#getStartDate()
   * @see #getDailyOccursModel()
   * @generated
   */
  EAttribute getDailyOccursModel_StartDate();

  /**
   * Returns the meta object for class '{@link com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel <em>Weekly Occurs Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Weekly Occurs Model</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel
   * @generated
   */
  EClass getWeeklyOccursModel();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel#getSkipWeeks <em>Skip Weeks</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Skip Weeks</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel#getSkipWeeks()
   * @see #getWeeklyOccursModel()
   * @generated
   */
  EAttribute getWeeklyOccursModel_SkipWeeks();

  /**
   * Returns the meta object for the attribute list '{@link com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel#getDays <em>Days</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Days</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel#getDays()
   * @see #getWeeklyOccursModel()
   * @generated
   */
  EAttribute getWeeklyOccursModel_Days();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel#getStartDate <em>Start Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Date</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel#getStartDate()
   * @see #getWeeklyOccursModel()
   * @generated
   */
  EAttribute getWeeklyOccursModel_StartDate();

  /**
   * Returns the meta object for class '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel <em>Monthly Occurs Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Monthly Occurs Model</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel
   * @generated
   */
  EClass getMonthlyOccursModel();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#isByIndex <em>By Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>By Index</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#isByIndex()
   * @see #getMonthlyOccursModel()
   * @generated
   */
  EAttribute getMonthlyOccursModel_ByIndex();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getSkipMonths <em>Skip Months</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Skip Months</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getSkipMonths()
   * @see #getMonthlyOccursModel()
   * @generated
   */
  EAttribute getMonthlyOccursModel_SkipMonths();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDayIndex <em>Day Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Day Index</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDayIndex()
   * @see #getMonthlyOccursModel()
   * @generated
   */
  EAttribute getMonthlyOccursModel_DayIndex();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDayOccurence <em>Day Occurence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Day Occurence</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDayOccurence()
   * @see #getMonthlyOccursModel()
   * @generated
   */
  EAttribute getMonthlyOccursModel_DayOccurence();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDay <em>Day</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Day</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getDay()
   * @see #getMonthlyOccursModel()
   * @generated
   */
  EAttribute getMonthlyOccursModel_Day();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getStartDate <em>Start Date</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Date</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel#getStartDate()
   * @see #getMonthlyOccursModel()
   * @generated
   */
  EAttribute getMonthlyOccursModel_StartDate();

  /**
   * Returns the meta object for class '{@link com.safi.workshop.model.timeBasedRouting.TimeRange <em>Time Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Range</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.TimeRange
   * @generated
   */
  EClass getTimeRange();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.TimeRange#getName()
   * @see #getTimeRange()
   * @generated
   */
  EAttribute getTimeRange_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getOccursModel <em>Occurs Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Occurs Model</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.TimeRange#getOccursModel()
   * @see #getTimeRange()
   * @generated
   */
  EReference getTimeRange_OccursModel();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getStartRange <em>Start Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Start Range</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.TimeRange#getStartRange()
   * @see #getTimeRange()
   * @generated
   */
  EAttribute getTimeRange_StartRange();

  /**
   * Returns the meta object for the attribute '{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getEndRange <em>End Range</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>End Range</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.TimeRange#getEndRange()
   * @see #getTimeRange()
   * @generated
   */
  EAttribute getTimeRange_EndRange();

  /**
   * Returns the meta object for enum '{@link com.safi.workshop.model.timeBasedRouting.OccursMode <em>Occurs Mode</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Occurs Mode</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.OccursMode
   * @generated
   */
  EEnum getOccursMode();

  /**
   * Returns the meta object for enum '{@link com.safi.workshop.model.timeBasedRouting.Day <em>Day</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Day</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.Day
   * @generated
   */
  EEnum getDay();

  /**
   * Returns the meta object for enum '{@link com.safi.workshop.model.timeBasedRouting.DayOccurrence <em>Day Occurrence</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Day Occurrence</em>'.
   * @see com.safi.workshop.model.timeBasedRouting.DayOccurrence
   * @generated
   */
  EEnum getDayOccurrence();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TimeBasedRoutingFactory getTimeBasedRoutingFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals {
    /**
     * The meta object literal for the '{@link com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingImpl <em>Time Based Routing</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingImpl
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getTimeBasedRouting()
     * @generated
     */
    EClass TIME_BASED_ROUTING = eINSTANCE.getTimeBasedRouting();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIME_BASED_ROUTING__VALUE = eINSTANCE.getTimeBasedRouting_Value();

    /**
     * The meta object literal for the '<em><b>Times</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIME_BASED_ROUTING__TIMES = eINSTANCE.getTimeBasedRouting_Times();

    /**
     * The meta object literal for the '{@link com.safi.workshop.model.timeBasedRouting.impl.TimeItemImpl <em>Time Item</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeItemImpl
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getTimeItem()
     * @generated
     */
    EClass TIME_ITEM = eINSTANCE.getTimeItem();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_ITEM__DESCRIPTION = eINSTANCE.getTimeItem_Description();

    /**
     * The meta object literal for the '{@link com.safi.workshop.model.timeBasedRouting.impl.OccursModelImpl <em>Occurs Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.workshop.model.timeBasedRouting.impl.OccursModelImpl
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getOccursModel()
     * @generated
     */
    EClass OCCURS_MODEL = eINSTANCE.getOccursModel();

    /**
     * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OCCURS_MODEL__MODE = eINSTANCE.getOccursModel_Mode();

    /**
     * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OCCURS_MODEL__DESCRIPTION = eINSTANCE.getOccursModel_Description();

    /**
     * The meta object literal for the '{@link com.safi.workshop.model.timeBasedRouting.impl.DailyOccursModelImpl <em>Daily Occurs Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.workshop.model.timeBasedRouting.impl.DailyOccursModelImpl
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getDailyOccursModel()
     * @generated
     */
    EClass DAILY_OCCURS_MODEL = eINSTANCE.getDailyOccursModel();

    /**
     * The meta object literal for the '<em><b>Skip Days</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DAILY_OCCURS_MODEL__SKIP_DAYS = eINSTANCE.getDailyOccursModel_SkipDays();

    /**
     * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DAILY_OCCURS_MODEL__START_DATE = eINSTANCE.getDailyOccursModel_StartDate();

    /**
     * The meta object literal for the '{@link com.safi.workshop.model.timeBasedRouting.impl.WeeklyOccursModelImpl <em>Weekly Occurs Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.workshop.model.timeBasedRouting.impl.WeeklyOccursModelImpl
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getWeeklyOccursModel()
     * @generated
     */
    EClass WEEKLY_OCCURS_MODEL = eINSTANCE.getWeeklyOccursModel();

    /**
     * The meta object literal for the '<em><b>Skip Weeks</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WEEKLY_OCCURS_MODEL__SKIP_WEEKS = eINSTANCE.getWeeklyOccursModel_SkipWeeks();

    /**
     * The meta object literal for the '<em><b>Days</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WEEKLY_OCCURS_MODEL__DAYS = eINSTANCE.getWeeklyOccursModel_Days();

    /**
     * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute WEEKLY_OCCURS_MODEL__START_DATE = eINSTANCE.getWeeklyOccursModel_StartDate();

    /**
     * The meta object literal for the '{@link com.safi.workshop.model.timeBasedRouting.impl.MonthlyOccursModelImpl <em>Monthly Occurs Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.workshop.model.timeBasedRouting.impl.MonthlyOccursModelImpl
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getMonthlyOccursModel()
     * @generated
     */
    EClass MONTHLY_OCCURS_MODEL = eINSTANCE.getMonthlyOccursModel();

    /**
     * The meta object literal for the '<em><b>By Index</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONTHLY_OCCURS_MODEL__BY_INDEX = eINSTANCE.getMonthlyOccursModel_ByIndex();

    /**
     * The meta object literal for the '<em><b>Skip Months</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONTHLY_OCCURS_MODEL__SKIP_MONTHS = eINSTANCE.getMonthlyOccursModel_SkipMonths();

    /**
     * The meta object literal for the '<em><b>Day Index</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONTHLY_OCCURS_MODEL__DAY_INDEX = eINSTANCE.getMonthlyOccursModel_DayIndex();

    /**
     * The meta object literal for the '<em><b>Day Occurence</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONTHLY_OCCURS_MODEL__DAY_OCCURENCE = eINSTANCE.getMonthlyOccursModel_DayOccurence();

    /**
     * The meta object literal for the '<em><b>Day</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONTHLY_OCCURS_MODEL__DAY = eINSTANCE.getMonthlyOccursModel_Day();

    /**
     * The meta object literal for the '<em><b>Start Date</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MONTHLY_OCCURS_MODEL__START_DATE = eINSTANCE.getMonthlyOccursModel_StartDate();

    /**
     * The meta object literal for the '{@link com.safi.workshop.model.timeBasedRouting.impl.TimeRangeImpl <em>Time Range</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeRangeImpl
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getTimeRange()
     * @generated
     */
    EClass TIME_RANGE = eINSTANCE.getTimeRange();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_RANGE__NAME = eINSTANCE.getTimeRange_Name();

    /**
     * The meta object literal for the '<em><b>Occurs Model</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIME_RANGE__OCCURS_MODEL = eINSTANCE.getTimeRange_OccursModel();

    /**
     * The meta object literal for the '<em><b>Start Range</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_RANGE__START_RANGE = eINSTANCE.getTimeRange_StartRange();

    /**
     * The meta object literal for the '<em><b>End Range</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_RANGE__END_RANGE = eINSTANCE.getTimeRange_EndRange();

    /**
     * The meta object literal for the '{@link com.safi.workshop.model.timeBasedRouting.OccursMode <em>Occurs Mode</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.workshop.model.timeBasedRouting.OccursMode
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getOccursMode()
     * @generated
     */
    EEnum OCCURS_MODE = eINSTANCE.getOccursMode();

    /**
     * The meta object literal for the '{@link com.safi.workshop.model.timeBasedRouting.Day <em>Day</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.workshop.model.timeBasedRouting.Day
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getDay()
     * @generated
     */
    EEnum DAY = eINSTANCE.getDay();

    /**
     * The meta object literal for the '{@link com.safi.workshop.model.timeBasedRouting.DayOccurrence <em>Day Occurrence</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.workshop.model.timeBasedRouting.DayOccurrence
     * @see com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingPackageImpl#getDayOccurrence()
     * @generated
     */
    EEnum DAY_OCCURRENCE = eINSTANCE.getDayOccurrence();

  }

} //TimeBasedRoutingPackage
