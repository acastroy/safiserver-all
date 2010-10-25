/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeBasedRoutingPackageImpl.java,v 1.4 2008/11/16 00:00:28 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.safi.core.CorePackage;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.workshop.model.timeBasedRouting.DailyOccursModel;
import com.safi.workshop.model.timeBasedRouting.Day;
import com.safi.workshop.model.timeBasedRouting.DayOccurrence;
import com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel;
import com.safi.workshop.model.timeBasedRouting.OccursMode;
import com.safi.workshop.model.timeBasedRouting.OccursModel;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRouting;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingFactory;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage;
import com.safi.workshop.model.timeBasedRouting.TimeItem;
import com.safi.workshop.model.timeBasedRouting.TimeRange;
import com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel;
import org.eclipse.emf.common.util.URI;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TimeBasedRoutingPackageImpl extends EPackageImpl implements TimeBasedRoutingPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass timeBasedRoutingEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass timeItemEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass occursModelEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dailyOccursModelEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass weeklyOccursModelEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass monthlyOccursModelEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass timeRangeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum occursModeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum dayEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum dayOccurrenceEEnum = null;

  /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private TimeBasedRoutingPackageImpl() {
		super(eNS_URI, TimeBasedRoutingFactory.eINSTANCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static boolean isInited = false;

  /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link TimeBasedRoutingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static TimeBasedRoutingPackage init() {
		if (isInited) return (TimeBasedRoutingPackage)EPackage.Registry.INSTANCE.getEPackage(TimeBasedRoutingPackage.eNS_URI);

		// Obtain or create and register package
		TimeBasedRoutingPackageImpl theTimeBasedRoutingPackage = (TimeBasedRoutingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TimeBasedRoutingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TimeBasedRoutingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theTimeBasedRoutingPackage.createPackageContents();

		// Initialize created meta-data
		theTimeBasedRoutingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theTimeBasedRoutingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(TimeBasedRoutingPackage.eNS_URI, theTimeBasedRoutingPackage);
		return theTimeBasedRoutingPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTimeBasedRouting() {
		return timeBasedRoutingEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTimeBasedRouting_Value() {
		return (EReference)timeBasedRoutingEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTimeBasedRouting_Times() {
		return (EReference)timeBasedRoutingEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTimeItem() {
		return timeItemEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTimeItem_Description() {
		return (EAttribute)timeItemEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getOccursModel() {
		return occursModelEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOccursModel_Mode() {
		return (EAttribute)occursModelEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOccursModel_Description() {
		return (EAttribute)occursModelEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDailyOccursModel() {
		return dailyOccursModelEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDailyOccursModel_SkipDays() {
		return (EAttribute)dailyOccursModelEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDailyOccursModel_StartDate() {
		return (EAttribute)dailyOccursModelEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getWeeklyOccursModel() {
		return weeklyOccursModelEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getWeeklyOccursModel_SkipWeeks() {
		return (EAttribute)weeklyOccursModelEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getWeeklyOccursModel_Days() {
		return (EAttribute)weeklyOccursModelEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getWeeklyOccursModel_StartDate() {
		return (EAttribute)weeklyOccursModelEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMonthlyOccursModel() {
		return monthlyOccursModelEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMonthlyOccursModel_ByIndex() {
		return (EAttribute)monthlyOccursModelEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMonthlyOccursModel_SkipMonths() {
		return (EAttribute)monthlyOccursModelEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMonthlyOccursModel_DayIndex() {
		return (EAttribute)monthlyOccursModelEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMonthlyOccursModel_DayOccurence() {
		return (EAttribute)monthlyOccursModelEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMonthlyOccursModel_Day() {
		return (EAttribute)monthlyOccursModelEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMonthlyOccursModel_StartDate() {
		return (EAttribute)monthlyOccursModelEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTimeRange() {
		return timeRangeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTimeRange_Name() {
		return (EAttribute)timeRangeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTimeRange_OccursModel() {
		return (EReference)timeRangeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTimeRange_StartRange() {
		return (EAttribute)timeRangeEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTimeRange_EndRange() {
		return (EAttribute)timeRangeEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getOccursMode() {
		return occursModeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getDay() {
		return dayEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getDayOccurrence() {
		return dayOccurrenceEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TimeBasedRoutingFactory getTimeBasedRoutingFactory() {
		return (TimeBasedRoutingFactory)getEFactoryInstance();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isCreated = false;

  /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		timeBasedRoutingEClass = createEClass(TIME_BASED_ROUTING);
		createEReference(timeBasedRoutingEClass, TIME_BASED_ROUTING__VALUE);
		createEReference(timeBasedRoutingEClass, TIME_BASED_ROUTING__TIMES);

		timeItemEClass = createEClass(TIME_ITEM);
		createEAttribute(timeItemEClass, TIME_ITEM__DESCRIPTION);

		occursModelEClass = createEClass(OCCURS_MODEL);
		createEAttribute(occursModelEClass, OCCURS_MODEL__MODE);
		createEAttribute(occursModelEClass, OCCURS_MODEL__DESCRIPTION);

		dailyOccursModelEClass = createEClass(DAILY_OCCURS_MODEL);
		createEAttribute(dailyOccursModelEClass, DAILY_OCCURS_MODEL__SKIP_DAYS);
		createEAttribute(dailyOccursModelEClass, DAILY_OCCURS_MODEL__START_DATE);

		weeklyOccursModelEClass = createEClass(WEEKLY_OCCURS_MODEL);
		createEAttribute(weeklyOccursModelEClass, WEEKLY_OCCURS_MODEL__SKIP_WEEKS);
		createEAttribute(weeklyOccursModelEClass, WEEKLY_OCCURS_MODEL__DAYS);
		createEAttribute(weeklyOccursModelEClass, WEEKLY_OCCURS_MODEL__START_DATE);

		monthlyOccursModelEClass = createEClass(MONTHLY_OCCURS_MODEL);
		createEAttribute(monthlyOccursModelEClass, MONTHLY_OCCURS_MODEL__BY_INDEX);
		createEAttribute(monthlyOccursModelEClass, MONTHLY_OCCURS_MODEL__SKIP_MONTHS);
		createEAttribute(monthlyOccursModelEClass, MONTHLY_OCCURS_MODEL__DAY_INDEX);
		createEAttribute(monthlyOccursModelEClass, MONTHLY_OCCURS_MODEL__DAY_OCCURENCE);
		createEAttribute(monthlyOccursModelEClass, MONTHLY_OCCURS_MODEL__DAY);
		createEAttribute(monthlyOccursModelEClass, MONTHLY_OCCURS_MODEL__START_DATE);

		timeRangeEClass = createEClass(TIME_RANGE);
		createEAttribute(timeRangeEClass, TIME_RANGE__NAME);
		createEReference(timeRangeEClass, TIME_RANGE__OCCURS_MODEL);
		createEAttribute(timeRangeEClass, TIME_RANGE__START_RANGE);
		createEAttribute(timeRangeEClass, TIME_RANGE__END_RANGE);

		// Create enums
		occursModeEEnum = createEEnum(OCCURS_MODE);
		dayEEnum = createEEnum(DAY);
		dayOccurrenceEEnum = createEEnum(DAY_OCCURRENCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isInitialized = false;

  /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ActionStepPackage theActionStepPackage = (ActionStepPackage)EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		timeBasedRoutingEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		timeItemEClass.getESuperTypes().add(theActionStepPackage.getCaseItem());
		dailyOccursModelEClass.getESuperTypes().add(this.getOccursModel());
		weeklyOccursModelEClass.getESuperTypes().add(this.getOccursModel());
		monthlyOccursModelEClass.getESuperTypes().add(this.getOccursModel());

		// Initialize classes and features; add operations and parameters
		initEClass(timeBasedRoutingEClass, TimeBasedRouting.class, "TimeBasedRouting", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTimeBasedRouting_Value(), theActionStepPackage.getDynamicValue(), null, "value", null, 0, 1, TimeBasedRouting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTimeBasedRouting_Times(), this.getTimeItem(), null, "times", null, 0, -1, TimeBasedRouting.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeItemEClass, TimeItem.class, "TimeItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeItem_Description(), ecorePackage.getEString(), "description", null, 0, 1, TimeItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(occursModelEClass, OccursModel.class, "OccursModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOccursModel_Mode(), this.getOccursMode(), "mode", null, 0, 1, OccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getOccursModel_Description(), ecorePackage.getEString(), "description", null, 0, 1, OccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(occursModelEClass, ecorePackage.getEBoolean(), "isMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDate(), "date", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(dailyOccursModelEClass, DailyOccursModel.class, "DailyOccursModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDailyOccursModel_SkipDays(), ecorePackage.getEInt(), "skipDays", null, 0, 1, DailyOccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDailyOccursModel_StartDate(), ecorePackage.getEDate(), "startDate", null, 0, 1, DailyOccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(weeklyOccursModelEClass, WeeklyOccursModel.class, "WeeklyOccursModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWeeklyOccursModel_SkipWeeks(), ecorePackage.getEInt(), "skipWeeks", "1", 1, 1, WeeklyOccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWeeklyOccursModel_Days(), this.getDay(), "days", null, 0, -1, WeeklyOccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWeeklyOccursModel_StartDate(), ecorePackage.getEDate(), "startDate", null, 0, 1, WeeklyOccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(monthlyOccursModelEClass, MonthlyOccursModel.class, "MonthlyOccursModel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMonthlyOccursModel_ByIndex(), ecorePackage.getEBoolean(), "byIndex", null, 0, 1, MonthlyOccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonthlyOccursModel_SkipMonths(), ecorePackage.getEInt(), "skipMonths", "1", 1, 1, MonthlyOccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonthlyOccursModel_DayIndex(), ecorePackage.getEInt(), "dayIndex", "1", 1, 1, MonthlyOccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonthlyOccursModel_DayOccurence(), this.getDayOccurrence(), "dayOccurence", null, 0, 1, MonthlyOccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonthlyOccursModel_Day(), this.getDay(), "day", null, 0, 1, MonthlyOccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMonthlyOccursModel_StartDate(), ecorePackage.getEDate(), "startDate", null, 0, 1, MonthlyOccursModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(timeRangeEClass, TimeRange.class, "TimeRange", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTimeRange_Name(), ecorePackage.getEString(), "name", null, 0, 1, TimeRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTimeRange_OccursModel(), this.getOccursModel(), null, "occursModel", null, 0, 1, TimeRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeRange_StartRange(), ecorePackage.getEDate(), "startRange", null, 0, 1, TimeRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTimeRange_EndRange(), ecorePackage.getEDate(), "endRange", null, 0, 1, TimeRange.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(timeRangeEClass, ecorePackage.getEBoolean(), "isMatch", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDate(), "date", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(occursModeEEnum, OccursMode.class, "OccursMode");
		addEEnumLiteral(occursModeEEnum, OccursMode.DAILY);
		addEEnumLiteral(occursModeEEnum, OccursMode.WEEKLY);
		addEEnumLiteral(occursModeEEnum, OccursMode.MONTHLY);

		initEEnum(dayEEnum, Day.class, "Day");
		addEEnumLiteral(dayEEnum, Day.SUNDAY);
		addEEnumLiteral(dayEEnum, Day.MONDAY);
		addEEnumLiteral(dayEEnum, Day.TUESDAY);
		addEEnumLiteral(dayEEnum, Day.WEDNESDAY);
		addEEnumLiteral(dayEEnum, Day.THURSDAY);
		addEEnumLiteral(dayEEnum, Day.FRIDAY);
		addEEnumLiteral(dayEEnum, Day.SATURDAY);

		initEEnum(dayOccurrenceEEnum, DayOccurrence.class, "DayOccurrence");
		addEEnumLiteral(dayOccurrenceEEnum, DayOccurrence.FIRST);
		addEEnumLiteral(dayOccurrenceEEnum, DayOccurrence.SECOND);
		addEEnumLiteral(dayOccurrenceEEnum, DayOccurrence.THIRD);
		addEEnumLiteral(dayOccurrenceEEnum, DayOccurrence.FOURTH);
		addEEnumLiteral(dayOccurrenceEEnum, DayOccurrence.LAST);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// DynamicValueAnnotation
		createDynamicValueAnnotationAnnotations();
		// Required
		createRequiredAnnotations();
	}

  /**
	 * Initializes the annotations for <b>DynamicValueAnnotation</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createDynamicValueAnnotationAnnotations() {
		String source = "DynamicValueAnnotation";		
		addAnnotation
		  (getTimeBasedRouting_Value(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The DateTime value to be compared against provided time range(s). Defaults to current date/time",
			 "expectedReturnType", "DateTime",
			 "helperClass", ""
		   });			
		addAnnotation
		  (timeItemEClass, 
		   source, 
		   new String[] {
			 "superProperty", "dynamicValue",
			 "type", "Custom",
			 "isTypeLocked", "true",
			 "description", "The time range of this output",
			 "expectedReturnType", "TimeRange",
			 "helperClass", "com.safi.workshop.timeBasedRouting.pak.editpart.TimeRangeEditorPage"
		   },
		   new URI[] {
			 URI.createURI(CorePackage.eNS_URI).appendFragment("//actionstep/CaseItem/dynamicValue")
		   });	
	}

  /**
	 * Initializes the annotations for <b>Required</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createRequiredAnnotations() {
		String source = "Required";			
		addAnnotation
		  (getTimeBasedRouting_Times(), 
		   source, 
		   new String[] {
			 "criteria", "non-empty"
		   });			
		addAnnotation
		  (timeItemEClass, 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });
	}

} //TimeBasedRoutingPackageImpl
