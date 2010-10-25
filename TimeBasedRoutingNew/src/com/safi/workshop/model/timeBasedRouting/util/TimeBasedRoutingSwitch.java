/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeBasedRoutingSwitch.java,v 1.2 2008/11/14 09:53:26 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.util;

import com.safi.core.PlatformDisposition;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.safi.core.ProductIdentifiable;
import com.safi.core.ThreadSensitive;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.Item;
import com.safi.workshop.model.timeBasedRouting.*;
import com.safi.workshop.model.timeBasedRouting.DailyOccursModel;
import com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel;
import com.safi.workshop.model.timeBasedRouting.OccursModel;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRouting;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage;
import com.safi.workshop.model.timeBasedRouting.TimeItem;
import com.safi.workshop.model.timeBasedRouting.TimeRange;
import com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage
 * @generated
 */
public class TimeBasedRoutingSwitch<T> {
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static TimeBasedRoutingPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TimeBasedRoutingSwitch() {
		if (modelPackage == null) {
			modelPackage = TimeBasedRoutingPackage.eINSTANCE;
		}
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case TimeBasedRoutingPackage.TIME_BASED_ROUTING: {
				TimeBasedRouting timeBasedRouting = (TimeBasedRouting)theEObject;
				T result = caseTimeBasedRouting(timeBasedRouting);
				if (result == null) result = caseActionStep(timeBasedRouting);
				if (result == null) result = caseProductIdentifiable(timeBasedRouting);
				if (result == null) result = caseThreadSensitive(timeBasedRouting);
				if (result == null) result = casePlatformDisposition(timeBasedRouting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimeBasedRoutingPackage.TIME_ITEM: {
				TimeItem timeItem = (TimeItem)theEObject;
				T result = caseTimeItem(timeItem);
				if (result == null) result = caseCaseItem(timeItem);
				if (result == null) result = caseItem(timeItem);
				if (result == null) result = caseThreadSensitive(timeItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimeBasedRoutingPackage.OCCURS_MODEL: {
				OccursModel occursModel = (OccursModel)theEObject;
				T result = caseOccursModel(occursModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimeBasedRoutingPackage.DAILY_OCCURS_MODEL: {
				DailyOccursModel dailyOccursModel = (DailyOccursModel)theEObject;
				T result = caseDailyOccursModel(dailyOccursModel);
				if (result == null) result = caseOccursModel(dailyOccursModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL: {
				WeeklyOccursModel weeklyOccursModel = (WeeklyOccursModel)theEObject;
				T result = caseWeeklyOccursModel(weeklyOccursModel);
				if (result == null) result = caseOccursModel(weeklyOccursModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL: {
				MonthlyOccursModel monthlyOccursModel = (MonthlyOccursModel)theEObject;
				T result = caseMonthlyOccursModel(monthlyOccursModel);
				if (result == null) result = caseOccursModel(monthlyOccursModel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case TimeBasedRoutingPackage.TIME_RANGE: {
				TimeRange timeRange = (TimeRange)theEObject;
				T result = caseTimeRange(timeRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Time Based Routing</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Based Routing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTimeBasedRouting(TimeBasedRouting object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Time Item</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTimeItem(TimeItem object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Occurs Model</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Occurs Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseOccursModel(OccursModel object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Daily Occurs Model</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Daily Occurs Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDailyOccursModel(DailyOccursModel object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Weekly Occurs Model</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Weekly Occurs Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseWeeklyOccursModel(WeeklyOccursModel object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Monthly Occurs Model</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Monthly Occurs Model</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMonthlyOccursModel(MonthlyOccursModel object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Time Range</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTimeRange(TimeRange object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Product Identifiable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseProductIdentifiable(ProductIdentifiable object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Sensitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Sensitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadSensitive(ThreadSensitive object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Platform Disposition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Platform Disposition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlatformDisposition(PlatformDisposition object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Step</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseActionStep(ActionStep object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Item</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseItem(Item object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Case Item</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Case Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCaseItem(CaseItem object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  public T defaultCase(EObject object) {
		return null;
	}

} //TimeBasedRoutingSwitch
