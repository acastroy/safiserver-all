/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import com.safi.core.scripting.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.mozilla.javascript.Script;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScriptingFactoryImpl extends EFactoryImpl implements ScriptingFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ScriptingFactory init() {
    try {
      ScriptingFactory theScriptingFactory = (ScriptingFactory)EPackage.Registry.INSTANCE.getEFactory("http:///com/safi/core.ecore#scripting"); 
      if (theScriptingFactory != null) {
        return theScriptingFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ScriptingFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptingFactoryImpl() {
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
      case ScriptingPackage.RHINO_SAFLET_SCRIPT: return createRhinoSafletScript();
      case ScriptingPackage.RHINO_SAFLET_SCRIPT_ENVIRONMENT: return createRhinoSafletScriptEnvironment();
      case ScriptingPackage.RHINO_SAFLET_SCRIPT_FACTORY: return createRhinoSafletScriptFactory();
      case ScriptingPackage.RHINO_SCRIPT_SCOPE: return createRhinoScriptScope();
      case ScriptingPackage.RHINO_SCRIPT_SCOPE_FACTORY: return createRhinoScriptScopeFactory();
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
      case ScriptingPackage.SAFLET_SCRIPT_EXCEPTION:
        return createSafletScriptExceptionFromString(eDataType, initialValue);
      case ScriptingPackage.SCRIPT:
        return createScriptFromString(eDataType, initialValue);
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
      case ScriptingPackage.SAFLET_SCRIPT_EXCEPTION:
        return convertSafletScriptExceptionToString(eDataType, instanceValue);
      case ScriptingPackage.SCRIPT:
        return convertScriptToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RhinoSafletScript createRhinoSafletScript() {
    RhinoSafletScriptImpl rhinoSafletScript = new RhinoSafletScriptImpl();
    return rhinoSafletScript;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RhinoSafletScriptEnvironment createRhinoSafletScriptEnvironment() {
    RhinoSafletScriptEnvironmentImpl rhinoSafletScriptEnvironment = new RhinoSafletScriptEnvironmentImpl();
    return rhinoSafletScriptEnvironment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RhinoSafletScriptFactory createRhinoSafletScriptFactory() {
    RhinoSafletScriptFactoryImpl rhinoSafletScriptFactory = new RhinoSafletScriptFactoryImpl();
    return rhinoSafletScriptFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RhinoScriptScope createRhinoScriptScope() {
    RhinoScriptScopeImpl rhinoScriptScope = new RhinoScriptScopeImpl();
    return rhinoScriptScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RhinoScriptScopeFactory createRhinoScriptScopeFactory() {
    RhinoScriptScopeFactoryImpl rhinoScriptScopeFactory = new RhinoScriptScopeFactoryImpl();
    return rhinoScriptScopeFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SafletScriptException createSafletScriptExceptionFromString(EDataType eDataType, String initialValue) {
    return (SafletScriptException)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSafletScriptExceptionToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Script createScriptFromString(EDataType eDataType, String initialValue) {
    return (Script)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertScriptToString(EDataType eDataType, Object instanceValue) {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptingPackage getScriptingPackage() {
    return (ScriptingPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ScriptingPackage getPackage() {
    return ScriptingPackage.eINSTANCE;
  }

} //ScriptingFactoryImpl
