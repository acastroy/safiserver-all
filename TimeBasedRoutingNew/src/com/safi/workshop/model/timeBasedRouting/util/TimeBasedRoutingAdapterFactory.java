/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeBasedRoutingAdapterFactory.java,v 1.2 2008/11/14 09:53:26 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.util;

import com.safi.core.PlatformDisposition;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage
 * @generated
 */
public class TimeBasedRoutingAdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static TimeBasedRoutingPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TimeBasedRoutingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = TimeBasedRoutingPackage.eINSTANCE;
		}
	}

  /**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
  @Override
  public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

  /**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TimeBasedRoutingSwitch<Adapter> modelSwitch =
    new TimeBasedRoutingSwitch<Adapter>() {
			@Override
			public Adapter caseTimeBasedRouting(TimeBasedRouting object) {
				return createTimeBasedRoutingAdapter();
			}
			@Override
			public Adapter caseTimeItem(TimeItem object) {
				return createTimeItemAdapter();
			}
			@Override
			public Adapter caseOccursModel(OccursModel object) {
				return createOccursModelAdapter();
			}
			@Override
			public Adapter caseDailyOccursModel(DailyOccursModel object) {
				return createDailyOccursModelAdapter();
			}
			@Override
			public Adapter caseWeeklyOccursModel(WeeklyOccursModel object) {
				return createWeeklyOccursModelAdapter();
			}
			@Override
			public Adapter caseMonthlyOccursModel(MonthlyOccursModel object) {
				return createMonthlyOccursModelAdapter();
			}
			@Override
			public Adapter caseTimeRange(TimeRange object) {
				return createTimeRangeAdapter();
			}
			@Override
			public Adapter caseProductIdentifiable(ProductIdentifiable object) {
				return createProductIdentifiableAdapter();
			}
			@Override
			public Adapter caseThreadSensitive(ThreadSensitive object) {
				return createThreadSensitiveAdapter();
			}
			@Override
			public Adapter casePlatformDisposition(PlatformDisposition object) {
				return createPlatformDispositionAdapter();
			}
			@Override
			public Adapter caseActionStep(ActionStep object) {
				return createActionStepAdapter();
			}
			@Override
			public Adapter caseItem(Item object) {
				return createItemAdapter();
			}
			@Override
			public Adapter caseCaseItem(CaseItem object) {
				return createCaseItemAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

  /**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
  @Override
  public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


  /**
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.timeBasedRouting.TimeBasedRouting <em>Time Based Routing</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRouting
	 * @generated
	 */
  public Adapter createTimeBasedRoutingAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.timeBasedRouting.TimeItem <em>Time Item</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.timeBasedRouting.TimeItem
	 * @generated
	 */
  public Adapter createTimeItemAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.timeBasedRouting.OccursModel <em>Occurs Model</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.timeBasedRouting.OccursModel
	 * @generated
	 */
  public Adapter createOccursModelAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.timeBasedRouting.DailyOccursModel <em>Daily Occurs Model</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.timeBasedRouting.DailyOccursModel
	 * @generated
	 */
  public Adapter createDailyOccursModelAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel <em>Weekly Occurs Model</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel
	 * @generated
	 */
  public Adapter createWeeklyOccursModelAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel <em>Monthly Occurs Model</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel
	 * @generated
	 */
  public Adapter createMonthlyOccursModelAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.timeBasedRouting.TimeRange <em>Time Range</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.timeBasedRouting.TimeRange
	 * @generated
	 */
  public Adapter createTimeRangeAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.ProductIdentifiable <em>Product Identifiable</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.ProductIdentifiable
	 * @generated
	 */
  public Adapter createProductIdentifiableAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.ThreadSensitive <em>Thread Sensitive</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.ThreadSensitive
	 * @generated
	 */
	public Adapter createThreadSensitiveAdapter() {
		return null;
	}

		/**
	 * Creates a new adapter for an object of class '{@link com.safi.core.PlatformDisposition <em>Platform Disposition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.PlatformDisposition
	 * @generated
	 */
	public Adapter createPlatformDispositionAdapter() {
		return null;
	}

		/**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.ActionStep <em>Action Step</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.ActionStep
	 * @generated
	 */
  public Adapter createActionStepAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.Item <em>Item</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.Item
	 * @generated
	 */
  public Adapter createItemAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.CaseItem <em>Case Item</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.CaseItem
	 * @generated
	 */
  public Adapter createCaseItemAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
  public Adapter createEObjectAdapter() {
		return null;
	}

} //TimeBasedRoutingAdapterFactory
