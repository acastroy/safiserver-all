/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.util;

import com.safi.core.scripting.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.core.scripting.ScriptingPackage
 * @generated
 */
public class ScriptingAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ScriptingPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptingAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = ScriptingPackage.eINSTANCE;
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
  protected ScriptingSwitch<Adapter> modelSwitch =
    new ScriptingSwitch<Adapter>() {
      @Override
      public Adapter caseSafletScript(SafletScript object) {
        return createSafletScriptAdapter();
      }
      @Override
      public Adapter caseSafletScriptEnvironment(SafletScriptEnvironment object) {
        return createSafletScriptEnvironmentAdapter();
      }
      @Override
      public Adapter caseSafletScriptFactory(SafletScriptFactory object) {
        return createSafletScriptFactoryAdapter();
      }
      @Override
      public Adapter caseRhinoSafletScript(RhinoSafletScript object) {
        return createRhinoSafletScriptAdapter();
      }
      @Override
      public Adapter caseRhinoSafletScriptEnvironment(RhinoSafletScriptEnvironment object) {
        return createRhinoSafletScriptEnvironmentAdapter();
      }
      @Override
      public Adapter caseRhinoSafletScriptFactory(RhinoSafletScriptFactory object) {
        return createRhinoSafletScriptFactoryAdapter();
      }
      @Override
      public Adapter caseRhinoScriptScope(RhinoScriptScope object) {
        return createRhinoScriptScopeAdapter();
      }
      @Override
      public Adapter caseRhinoScriptScopeFactory(RhinoScriptScopeFactory object) {
        return createRhinoScriptScopeFactoryAdapter();
      }
      @Override
      public Adapter caseScriptScope(ScriptScope object) {
        return createScriptScopeAdapter();
      }
      @Override
      public Adapter caseScriptScopeFactory(ScriptScopeFactory object) {
        return createScriptScopeFactoryAdapter();
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
   * Creates a new adapter for an object of class '{@link com.safi.core.scripting.SafletScript <em>Saflet Script</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.scripting.SafletScript
   * @generated
   */
  public Adapter createSafletScriptAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.scripting.SafletScriptEnvironment <em>Saflet Script Environment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.scripting.SafletScriptEnvironment
   * @generated
   */
  public Adapter createSafletScriptEnvironmentAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.scripting.SafletScriptFactory <em>Saflet Script Factory</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.scripting.SafletScriptFactory
   * @generated
   */
  public Adapter createSafletScriptFactoryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.scripting.RhinoSafletScript <em>Rhino Saflet Script</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.scripting.RhinoSafletScript
   * @generated
   */
  public Adapter createRhinoSafletScriptAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.scripting.RhinoSafletScriptEnvironment <em>Rhino Saflet Script Environment</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.scripting.RhinoSafletScriptEnvironment
   * @generated
   */
  public Adapter createRhinoSafletScriptEnvironmentAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.scripting.RhinoSafletScriptFactory <em>Rhino Saflet Script Factory</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.scripting.RhinoSafletScriptFactory
   * @generated
   */
  public Adapter createRhinoSafletScriptFactoryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.scripting.RhinoScriptScope <em>Rhino Script Scope</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.scripting.RhinoScriptScope
   * @generated
   */
  public Adapter createRhinoScriptScopeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.scripting.RhinoScriptScopeFactory <em>Rhino Script Scope Factory</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.scripting.RhinoScriptScopeFactory
   * @generated
   */
  public Adapter createRhinoScriptScopeFactoryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.scripting.ScriptScope <em>Script Scope</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.scripting.ScriptScope
   * @generated
   */
  public Adapter createScriptScopeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.scripting.ScriptScopeFactory <em>Script Scope Factory</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.scripting.ScriptScopeFactory
   * @generated
   */
  public Adapter createScriptScopeFactoryAdapter() {
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

} //ScriptingAdapterFactory
