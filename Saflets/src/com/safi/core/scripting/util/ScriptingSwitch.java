/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.util;

import com.safi.core.scripting.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see com.safi.core.scripting.ScriptingPackage
 * @generated
 */
public class ScriptingSwitch<T> {
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ScriptingPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptingSwitch() {
    if (modelPackage == null) {
      modelPackage = ScriptingPackage.eINSTANCE;
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
      case ScriptingPackage.SAFLET_SCRIPT: {
        SafletScript safletScript = (SafletScript)theEObject;
        T result = caseSafletScript(safletScript);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT: {
        SafletScriptEnvironment safletScriptEnvironment = (SafletScriptEnvironment)theEObject;
        T result = caseSafletScriptEnvironment(safletScriptEnvironment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ScriptingPackage.SAFLET_SCRIPT_FACTORY: {
        SafletScriptFactory safletScriptFactory = (SafletScriptFactory)theEObject;
        T result = caseSafletScriptFactory(safletScriptFactory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ScriptingPackage.RHINO_SAFLET_SCRIPT: {
        RhinoSafletScript rhinoSafletScript = (RhinoSafletScript)theEObject;
        T result = caseRhinoSafletScript(rhinoSafletScript);
        if (result == null) result = caseSafletScript(rhinoSafletScript);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ScriptingPackage.RHINO_SAFLET_SCRIPT_ENVIRONMENT: {
        RhinoSafletScriptEnvironment rhinoSafletScriptEnvironment = (RhinoSafletScriptEnvironment)theEObject;
        T result = caseRhinoSafletScriptEnvironment(rhinoSafletScriptEnvironment);
        if (result == null) result = caseSafletScriptEnvironment(rhinoSafletScriptEnvironment);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ScriptingPackage.RHINO_SAFLET_SCRIPT_FACTORY: {
        RhinoSafletScriptFactory rhinoSafletScriptFactory = (RhinoSafletScriptFactory)theEObject;
        T result = caseRhinoSafletScriptFactory(rhinoSafletScriptFactory);
        if (result == null) result = caseSafletScriptFactory(rhinoSafletScriptFactory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ScriptingPackage.RHINO_SCRIPT_SCOPE: {
        RhinoScriptScope rhinoScriptScope = (RhinoScriptScope)theEObject;
        T result = caseRhinoScriptScope(rhinoScriptScope);
        if (result == null) result = caseScriptScope(rhinoScriptScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ScriptingPackage.RHINO_SCRIPT_SCOPE_FACTORY: {
        RhinoScriptScopeFactory rhinoScriptScopeFactory = (RhinoScriptScopeFactory)theEObject;
        T result = caseRhinoScriptScopeFactory(rhinoScriptScopeFactory);
        if (result == null) result = caseScriptScopeFactory(rhinoScriptScopeFactory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ScriptingPackage.SCRIPT_SCOPE: {
        ScriptScope scriptScope = (ScriptScope)theEObject;
        T result = caseScriptScope(scriptScope);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case ScriptingPackage.SCRIPT_SCOPE_FACTORY: {
        ScriptScopeFactory scriptScopeFactory = (ScriptScopeFactory)theEObject;
        T result = caseScriptScopeFactory(scriptScopeFactory);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Saflet Script</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Saflet Script</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSafletScript(SafletScript object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Saflet Script Environment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Saflet Script Environment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSafletScriptEnvironment(SafletScriptEnvironment object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Saflet Script Factory</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Saflet Script Factory</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSafletScriptFactory(SafletScriptFactory object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rhino Saflet Script</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rhino Saflet Script</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRhinoSafletScript(RhinoSafletScript object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rhino Saflet Script Environment</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rhino Saflet Script Environment</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRhinoSafletScriptEnvironment(RhinoSafletScriptEnvironment object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rhino Saflet Script Factory</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rhino Saflet Script Factory</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRhinoSafletScriptFactory(RhinoSafletScriptFactory object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rhino Script Scope</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rhino Script Scope</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRhinoScriptScope(RhinoScriptScope object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rhino Script Scope Factory</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rhino Script Scope Factory</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRhinoScriptScopeFactory(RhinoScriptScopeFactory object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Script Scope</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Script Scope</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScriptScope(ScriptScope object) {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Script Scope Factory</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Script Scope Factory</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseScriptScopeFactory(ScriptScopeFactory object) {
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

} //ScriptingSwitch
