/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.util;

import com.safi.asterisk.*;
import com.safi.core.ThreadSensitive;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallConsumer1;
import com.safi.asterisk.CallConsumer2;
import com.safi.asterisk.CallSource1;
import com.safi.asterisk.CallSource2;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.AsteriskPackage
 * @generated
 */
public class AsteriskAdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static AsteriskPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AsteriskAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = AsteriskPackage.eINSTANCE;
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
  protected AsteriskSwitch<Adapter> modelSwitch =
    new AsteriskSwitch<Adapter>() {
			@Override
			public Adapter caseCall(Call object) {
				return createCallAdapter();
			}
			@Override
			public Adapter caseCallSource1(CallSource1 object) {
				return createCallSource1Adapter();
			}
			@Override
			public Adapter caseCallSource2(CallSource2 object) {
				return createCallSource2Adapter();
			}
			@Override
			public Adapter caseCallConsumer1(CallConsumer1 object) {
				return createCallConsumer1Adapter();
			}
			@Override
			public Adapter caseCallConsumer2(CallConsumer2 object) {
				return createCallConsumer2Adapter();
			}
			@Override
			public Adapter caseThreadSensitive(ThreadSensitive object) {
				return createThreadSensitiveAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.safi.asterisk.Call <em>Call</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.asterisk.Call
	 * @generated
	 */
  public Adapter createCallAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.asterisk.CallSource1 <em>Call Source1</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.asterisk.CallSource1
	 * @generated
	 */
  public Adapter createCallSource1Adapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.asterisk.CallSource2 <em>Call Source2</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.asterisk.CallSource2
	 * @generated
	 */
  public Adapter createCallSource2Adapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.asterisk.CallConsumer1 <em>Call Consumer1</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.asterisk.CallConsumer1
	 * @generated
	 */
  public Adapter createCallConsumer1Adapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.asterisk.CallConsumer2 <em>Call Consumer2</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.asterisk.CallConsumer2
	 * @generated
	 */
  public Adapter createCallConsumer2Adapter() {
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

} //AsteriskAdapterFactory
