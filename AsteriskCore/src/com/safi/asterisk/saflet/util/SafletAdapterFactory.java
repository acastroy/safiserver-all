/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.saflet.util;

import com.safi.asterisk.saflet.*;
import com.safi.core.ThreadSensitive;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import com.safi.asterisk.saflet.AsteriskSaflet;
import com.safi.asterisk.saflet.AsteriskSafletContext;
import com.safi.asterisk.saflet.AsteriskSafletEnvironment;
import com.safi.asterisk.saflet.SafletPackage;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.saflet.SafletPackage
 * @generated
 */
public class SafletAdapterFactory extends AdapterFactoryImpl {
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static SafletPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafletAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SafletPackage.eINSTANCE;
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
  protected SafletSwitch<Adapter> modelSwitch =
    new SafletSwitch<Adapter>() {
			@Override
			public Adapter caseAsteriskSaflet(AsteriskSaflet object) {
				return createAsteriskSafletAdapter();
			}
			@Override
			public Adapter caseAsteriskSafletContext(AsteriskSafletContext object) {
				return createAsteriskSafletContextAdapter();
			}
			@Override
			public Adapter caseAsteriskSafletEnvironment(AsteriskSafletEnvironment object) {
				return createAsteriskSafletEnvironmentAdapter();
			}
			@Override
			public Adapter caseThreadSensitive(ThreadSensitive object) {
				return createThreadSensitiveAdapter();
			}
			@Override
			public Adapter caseSaflet(Saflet object) {
				return createSafletAdapter();
			}
			@Override
			public Adapter caseSafletContext(SafletContext object) {
				return createSafletContextAdapter();
			}
			@Override
			public Adapter caseSafletEnvironment(SafletEnvironment object) {
				return createSafletEnvironmentAdapter();
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
	 * Creates a new adapter for an object of class '{@link com.safi.asterisk.saflet.AsteriskSaflet <em>Asterisk Saflet</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.asterisk.saflet.AsteriskSaflet
	 * @generated
	 */
  public Adapter createAsteriskSafletAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.asterisk.saflet.AsteriskSafletContext <em>Asterisk Saflet Context</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.asterisk.saflet.AsteriskSafletContext
	 * @generated
	 */
  public Adapter createAsteriskSafletContextAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.asterisk.saflet.AsteriskSafletEnvironment <em>Asterisk Saflet Environment</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.asterisk.saflet.AsteriskSafletEnvironment
	 * @generated
	 */
  public Adapter createAsteriskSafletEnvironmentAdapter() {
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
	 * Creates a new adapter for an object of class '{@link com.safi.core.saflet.Saflet <em>Saflet</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.saflet.Saflet
	 * @generated
	 */
  public Adapter createSafletAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.saflet.SafletContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.saflet.SafletContext
	 * @generated
	 */
  public Adapter createSafletContextAdapter() {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link com.safi.core.saflet.SafletEnvironment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.safi.core.saflet.SafletEnvironment
	 * @generated
	 */
  public Adapter createSafletEnvironmentAdapter() {
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

} //SafletAdapterFactory
