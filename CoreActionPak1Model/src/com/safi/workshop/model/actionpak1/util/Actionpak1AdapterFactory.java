/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.safi.core.ProductIdentifiable;
import com.safi.core.ThreadSensitive;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ParameterizedActionstep;
import com.safi.core.actionstep.ParameterizedInitiator;
import com.safi.core.call.CallSource1;
import com.safi.core.initiator.Initiator;
import com.safi.workshop.model.actionpak1.*;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.ActionstepTest;
import com.safi.workshop.model.actionpak1.CustomInitiator;
import com.safi.workshop.model.actionpak1.IncomingCall2;
import com.safi.workshop.model.actionpak1.InvokeSaflet2;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.workshop.model.actionpak1.Actionpak1Package
 * @generated
 */
public class Actionpak1AdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static Actionpak1Package modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Actionpak1AdapterFactory() {
		if (modelPackage == null) {
			modelPackage = Actionpak1Package.eINSTANCE;
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
  protected Actionpak1Switch<Adapter> modelSwitch =
    new Actionpak1Switch<Adapter>() {
			@Override
			public Adapter caseActionstepTest(ActionstepTest object) {
				return createActionstepTestAdapter();
			}
			@Override
			public Adapter caseCustomInitiator(CustomInitiator object) {
				return createCustomInitiatorAdapter();
			}
			@Override
			public Adapter caseIncomingCall2(IncomingCall2 object) {
				return createIncomingCall2Adapter();
			}
			@Override
			public Adapter caseInvokeSaflet2(InvokeSaflet2 object) {
				return createInvokeSaflet2Adapter();
			}
			@Override
			public Adapter caseManagerAction(ManagerAction object) {
				return createManagerActionAdapter();
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
			public Adapter caseActionStep(ActionStep object) {
				return createActionStepAdapter();
			}
			@Override
			public Adapter caseInitiator(Initiator object) {
				return createInitiatorAdapter();
			}
			@Override
			public Adapter caseParameterizedActionstep(ParameterizedActionstep object) {
				return createParameterizedActionstepAdapter();
			}
			@Override
			public Adapter caseParameterizedInitiator(ParameterizedInitiator object) {
				return createParameterizedInitiatorAdapter();
			}
			@Override
			public Adapter caseCallSource1(CallSource1 object) {
				return createCallSource1Adapter();
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
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.actionpak1.ActionstepTest <em>Actionstep Test</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.actionpak1.ActionstepTest
	 * @generated
	 */
  public Adapter createActionstepTestAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.actionpak1.CustomInitiator <em>Custom Initiator</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.actionpak1.CustomInitiator
	 * @generated
	 */
  public Adapter createCustomInitiatorAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.actionpak1.IncomingCall2 <em>Incoming Call2</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.actionpak1.IncomingCall2
	 * @generated
	 */
  public Adapter createIncomingCall2Adapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.actionpak1.InvokeSaflet2 <em>Invoke Saflet2</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.actionpak1.InvokeSaflet2
	 * @generated
	 */
  public Adapter createInvokeSaflet2Adapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.workshop.model.actionpak1.ManagerAction <em>Manager Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.workshop.model.actionpak1.ManagerAction
	 * @generated
	 */
	public Adapter createManagerActionAdapter() {
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
	 * Creates a new adapter for an object of class '{@link com.safi.core.initiator.Initiator <em>Initiator</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.initiator.Initiator
	 * @generated
	 */
  public Adapter createInitiatorAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.ParameterizedActionstep <em>Parameterized Actionstep</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.ParameterizedActionstep
	 * @generated
	 */
  public Adapter createParameterizedActionstepAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.ParameterizedInitiator <em>Parameterized Initiator</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.actionstep.ParameterizedInitiator
	 * @generated
	 */
  public Adapter createParameterizedInitiatorAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.call.CallSource1 <em>Source1</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.call.CallSource1
	 * @generated
	 */
  public Adapter createCallSource1Adapter() {
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

} //Actionpak1AdapterFactory
