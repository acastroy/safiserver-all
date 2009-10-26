/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see com.safi.core.scripting.ScriptingFactory
 * @model kind="package"
 * @generated
 */
public interface ScriptingPackage extends EPackage {
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "scripting";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http:///com/safi/core.ecore#scripting";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "com.safi.core.scripting";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ScriptingPackage eINSTANCE = com.safi.core.scripting.impl.ScriptingPackageImpl.init();

  /**
   * The meta object id for the '{@link com.safi.core.scripting.impl.SafletScriptImpl <em>Saflet Script</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.core.scripting.impl.SafletScriptImpl
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getSafletScript()
   * @generated
   */
  int SAFLET_SCRIPT = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFLET_SCRIPT__NAME = 0;

  /**
   * The feature id for the '<em><b>Script Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFLET_SCRIPT__SCRIPT_TEXT = 1;

  /**
   * The number of structural features of the '<em>Saflet Script</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFLET_SCRIPT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.safi.core.scripting.impl.SafletScriptEnvironmentImpl <em>Saflet Script Environment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.core.scripting.impl.SafletScriptEnvironmentImpl
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getSafletScriptEnvironment()
   * @generated
   */
  int SAFLET_SCRIPT_ENVIRONMENT = 1;

  /**
   * The feature id for the '<em><b>Shared Saflet Script</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFLET_SCRIPT_ENVIRONMENT__SHARED_SAFLET_SCRIPT = 0;

  /**
   * The feature id for the '<em><b>Shared Script Scope</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFLET_SCRIPT_ENVIRONMENT__SHARED_SCRIPT_SCOPE = 1;

  /**
   * The feature id for the '<em><b>Saflet Script Factory</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFLET_SCRIPT_ENVIRONMENT__SAFLET_SCRIPT_FACTORY = 2;

  /**
   * The feature id for the '<em><b>Script Scope Factory</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFLET_SCRIPT_ENVIRONMENT__SCRIPT_SCOPE_FACTORY = 3;

  /**
   * The number of structural features of the '<em>Saflet Script Environment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFLET_SCRIPT_ENVIRONMENT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link com.safi.core.scripting.impl.SafletScriptFactoryImpl <em>Saflet Script Factory</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.core.scripting.impl.SafletScriptFactoryImpl
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getSafletScriptFactory()
   * @generated
   */
  int SAFLET_SCRIPT_FACTORY = 2;

  /**
   * The feature id for the '<em><b>Saflet Script</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFLET_SCRIPT_FACTORY__SAFLET_SCRIPT = 0;

  /**
   * The number of structural features of the '<em>Saflet Script Factory</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SAFLET_SCRIPT_FACTORY_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.safi.core.scripting.impl.RhinoSafletScriptImpl <em>Rhino Saflet Script</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.core.scripting.impl.RhinoSafletScriptImpl
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getRhinoSafletScript()
   * @generated
   */
  int RHINO_SAFLET_SCRIPT = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SAFLET_SCRIPT__NAME = SAFLET_SCRIPT__NAME;

  /**
   * The feature id for the '<em><b>Script Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SAFLET_SCRIPT__SCRIPT_TEXT = SAFLET_SCRIPT__SCRIPT_TEXT;

  /**
   * The feature id for the '<em><b>Rhino Script</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SAFLET_SCRIPT__RHINO_SCRIPT = SAFLET_SCRIPT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rhino Saflet Script</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SAFLET_SCRIPT_FEATURE_COUNT = SAFLET_SCRIPT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.safi.core.scripting.impl.RhinoSafletScriptEnvironmentImpl <em>Rhino Saflet Script Environment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.core.scripting.impl.RhinoSafletScriptEnvironmentImpl
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getRhinoSafletScriptEnvironment()
   * @generated
   */
  int RHINO_SAFLET_SCRIPT_ENVIRONMENT = 4;

  /**
   * The feature id for the '<em><b>Shared Saflet Script</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SAFLET_SCRIPT_ENVIRONMENT__SHARED_SAFLET_SCRIPT = SAFLET_SCRIPT_ENVIRONMENT__SHARED_SAFLET_SCRIPT;

  /**
   * The feature id for the '<em><b>Shared Script Scope</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SAFLET_SCRIPT_ENVIRONMENT__SHARED_SCRIPT_SCOPE = SAFLET_SCRIPT_ENVIRONMENT__SHARED_SCRIPT_SCOPE;

  /**
   * The feature id for the '<em><b>Saflet Script Factory</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SAFLET_SCRIPT_ENVIRONMENT__SAFLET_SCRIPT_FACTORY = SAFLET_SCRIPT_ENVIRONMENT__SAFLET_SCRIPT_FACTORY;

  /**
   * The feature id for the '<em><b>Script Scope Factory</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SAFLET_SCRIPT_ENVIRONMENT__SCRIPT_SCOPE_FACTORY = SAFLET_SCRIPT_ENVIRONMENT__SCRIPT_SCOPE_FACTORY;

  /**
   * The number of structural features of the '<em>Rhino Saflet Script Environment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SAFLET_SCRIPT_ENVIRONMENT_FEATURE_COUNT = SAFLET_SCRIPT_ENVIRONMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.safi.core.scripting.impl.RhinoSafletScriptFactoryImpl <em>Rhino Saflet Script Factory</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.core.scripting.impl.RhinoSafletScriptFactoryImpl
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getRhinoSafletScriptFactory()
   * @generated
   */
  int RHINO_SAFLET_SCRIPT_FACTORY = 5;

  /**
   * The feature id for the '<em><b>Saflet Script</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SAFLET_SCRIPT_FACTORY__SAFLET_SCRIPT = SAFLET_SCRIPT_FACTORY__SAFLET_SCRIPT;

  /**
   * The number of structural features of the '<em>Rhino Saflet Script Factory</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SAFLET_SCRIPT_FACTORY_FEATURE_COUNT = SAFLET_SCRIPT_FACTORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.safi.core.scripting.impl.ScriptScopeImpl <em>Script Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.core.scripting.impl.ScriptScopeImpl
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getScriptScope()
   * @generated
   */
  int SCRIPT_SCOPE = 8;

  /**
   * The feature id for the '<em><b>Scope Object</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCRIPT_SCOPE__SCOPE_OBJECT = 0;

  /**
   * The number of structural features of the '<em>Script Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCRIPT_SCOPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.safi.core.scripting.impl.RhinoScriptScopeImpl <em>Rhino Script Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.core.scripting.impl.RhinoScriptScopeImpl
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getRhinoScriptScope()
   * @generated
   */
  int RHINO_SCRIPT_SCOPE = 6;

  /**
   * The feature id for the '<em><b>Scope Object</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SCRIPT_SCOPE__SCOPE_OBJECT = SCRIPT_SCOPE__SCOPE_OBJECT;

  /**
   * The number of structural features of the '<em>Rhino Script Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SCRIPT_SCOPE_FEATURE_COUNT = SCRIPT_SCOPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link com.safi.core.scripting.impl.ScriptScopeFactoryImpl <em>Script Scope Factory</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.core.scripting.impl.ScriptScopeFactoryImpl
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getScriptScopeFactory()
   * @generated
   */
  int SCRIPT_SCOPE_FACTORY = 9;

  /**
   * The feature id for the '<em><b>Script Scope</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCRIPT_SCOPE_FACTORY__SCRIPT_SCOPE = 0;

  /**
   * The feature id for the '<em><b>Global Script Scope</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCRIPT_SCOPE_FACTORY__GLOBAL_SCRIPT_SCOPE = 1;

  /**
   * The number of structural features of the '<em>Script Scope Factory</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCRIPT_SCOPE_FACTORY_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.safi.core.scripting.impl.RhinoScriptScopeFactoryImpl <em>Rhino Script Scope Factory</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.core.scripting.impl.RhinoScriptScopeFactoryImpl
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getRhinoScriptScopeFactory()
   * @generated
   */
  int RHINO_SCRIPT_SCOPE_FACTORY = 7;

  /**
   * The feature id for the '<em><b>Script Scope</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SCRIPT_SCOPE_FACTORY__SCRIPT_SCOPE = SCRIPT_SCOPE_FACTORY__SCRIPT_SCOPE;

  /**
   * The feature id for the '<em><b>Global Script Scope</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SCRIPT_SCOPE_FACTORY__GLOBAL_SCRIPT_SCOPE = SCRIPT_SCOPE_FACTORY__GLOBAL_SCRIPT_SCOPE;

  /**
   * The number of structural features of the '<em>Rhino Script Scope Factory</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RHINO_SCRIPT_SCOPE_FACTORY_FEATURE_COUNT = SCRIPT_SCOPE_FACTORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '<em>Saflet Script Exception</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.safi.core.scripting.SafletScriptException
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getSafletScriptException()
   * @generated
   */
  int SAFLET_SCRIPT_EXCEPTION = 10;

  /**
   * The meta object id for the '<em>Script</em>' data type.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.mozilla.javascript.Script
   * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getScript()
   * @generated
   */
  int SCRIPT = 11;


  /**
   * Returns the meta object for class '{@link com.safi.core.scripting.SafletScript <em>Saflet Script</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Saflet Script</em>'.
   * @see com.safi.core.scripting.SafletScript
   * @generated
   */
  EClass getSafletScript();

  /**
   * Returns the meta object for the attribute '{@link com.safi.core.scripting.SafletScript#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.safi.core.scripting.SafletScript#getName()
   * @see #getSafletScript()
   * @generated
   */
  EAttribute getSafletScript_Name();

  /**
   * Returns the meta object for the attribute '{@link com.safi.core.scripting.SafletScript#getScriptText <em>Script Text</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Script Text</em>'.
   * @see com.safi.core.scripting.SafletScript#getScriptText()
   * @see #getSafletScript()
   * @generated
   */
  EAttribute getSafletScript_ScriptText();

  /**
   * Returns the meta object for class '{@link com.safi.core.scripting.SafletScriptEnvironment <em>Saflet Script Environment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Saflet Script Environment</em>'.
   * @see com.safi.core.scripting.SafletScriptEnvironment
   * @generated
   */
  EClass getSafletScriptEnvironment();

  /**
   * Returns the meta object for the reference '{@link com.safi.core.scripting.SafletScriptEnvironment#getSharedSafletScript <em>Shared Saflet Script</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Shared Saflet Script</em>'.
   * @see com.safi.core.scripting.SafletScriptEnvironment#getSharedSafletScript()
   * @see #getSafletScriptEnvironment()
   * @generated
   */
  EReference getSafletScriptEnvironment_SharedSafletScript();

  /**
   * Returns the meta object for the reference '{@link com.safi.core.scripting.SafletScriptEnvironment#getSharedScriptScope <em>Shared Script Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Shared Script Scope</em>'.
   * @see com.safi.core.scripting.SafletScriptEnvironment#getSharedScriptScope()
   * @see #getSafletScriptEnvironment()
   * @generated
   */
  EReference getSafletScriptEnvironment_SharedScriptScope();

  /**
   * Returns the meta object for the reference '{@link com.safi.core.scripting.SafletScriptEnvironment#getSafletScriptFactory <em>Saflet Script Factory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Saflet Script Factory</em>'.
   * @see com.safi.core.scripting.SafletScriptEnvironment#getSafletScriptFactory()
   * @see #getSafletScriptEnvironment()
   * @generated
   */
  EReference getSafletScriptEnvironment_SafletScriptFactory();

  /**
   * Returns the meta object for the reference '{@link com.safi.core.scripting.SafletScriptEnvironment#getScriptScopeFactory <em>Script Scope Factory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Script Scope Factory</em>'.
   * @see com.safi.core.scripting.SafletScriptEnvironment#getScriptScopeFactory()
   * @see #getSafletScriptEnvironment()
   * @generated
   */
  EReference getSafletScriptEnvironment_ScriptScopeFactory();

  /**
   * Returns the meta object for class '{@link com.safi.core.scripting.SafletScriptFactory <em>Saflet Script Factory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Saflet Script Factory</em>'.
   * @see com.safi.core.scripting.SafletScriptFactory
   * @generated
   */
  EClass getSafletScriptFactory();

  /**
   * Returns the meta object for the reference '{@link com.safi.core.scripting.SafletScriptFactory#getSafletScript <em>Saflet Script</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Saflet Script</em>'.
   * @see com.safi.core.scripting.SafletScriptFactory#getSafletScript()
   * @see #getSafletScriptFactory()
   * @generated
   */
  EReference getSafletScriptFactory_SafletScript();

  /**
   * Returns the meta object for class '{@link com.safi.core.scripting.RhinoSafletScript <em>Rhino Saflet Script</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rhino Saflet Script</em>'.
   * @see com.safi.core.scripting.RhinoSafletScript
   * @generated
   */
  EClass getRhinoSafletScript();

  /**
   * Returns the meta object for the attribute '{@link com.safi.core.scripting.RhinoSafletScript#getRhinoScript <em>Rhino Script</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Rhino Script</em>'.
   * @see com.safi.core.scripting.RhinoSafletScript#getRhinoScript()
   * @see #getRhinoSafletScript()
   * @generated
   */
  EAttribute getRhinoSafletScript_RhinoScript();

  /**
   * Returns the meta object for class '{@link com.safi.core.scripting.RhinoSafletScriptEnvironment <em>Rhino Saflet Script Environment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rhino Saflet Script Environment</em>'.
   * @see com.safi.core.scripting.RhinoSafletScriptEnvironment
   * @generated
   */
  EClass getRhinoSafletScriptEnvironment();

  /**
   * Returns the meta object for class '{@link com.safi.core.scripting.RhinoSafletScriptFactory <em>Rhino Saflet Script Factory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rhino Saflet Script Factory</em>'.
   * @see com.safi.core.scripting.RhinoSafletScriptFactory
   * @generated
   */
  EClass getRhinoSafletScriptFactory();

  /**
   * Returns the meta object for class '{@link com.safi.core.scripting.RhinoScriptScope <em>Rhino Script Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rhino Script Scope</em>'.
   * @see com.safi.core.scripting.RhinoScriptScope
   * @generated
   */
  EClass getRhinoScriptScope();

  /**
   * Returns the meta object for class '{@link com.safi.core.scripting.RhinoScriptScopeFactory <em>Rhino Script Scope Factory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rhino Script Scope Factory</em>'.
   * @see com.safi.core.scripting.RhinoScriptScopeFactory
   * @generated
   */
  EClass getRhinoScriptScopeFactory();

  /**
   * Returns the meta object for class '{@link com.safi.core.scripting.ScriptScope <em>Script Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Script Scope</em>'.
   * @see com.safi.core.scripting.ScriptScope
   * @generated
   */
  EClass getScriptScope();

  /**
   * Returns the meta object for the attribute '{@link com.safi.core.scripting.ScriptScope#getScopeObject <em>Scope Object</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Scope Object</em>'.
   * @see com.safi.core.scripting.ScriptScope#getScopeObject()
   * @see #getScriptScope()
   * @generated
   */
  EAttribute getScriptScope_ScopeObject();

  /**
   * Returns the meta object for class '{@link com.safi.core.scripting.ScriptScopeFactory <em>Script Scope Factory</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Script Scope Factory</em>'.
   * @see com.safi.core.scripting.ScriptScopeFactory
   * @generated
   */
  EClass getScriptScopeFactory();

  /**
   * Returns the meta object for the reference '{@link com.safi.core.scripting.ScriptScopeFactory#getScriptScope <em>Script Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Script Scope</em>'.
   * @see com.safi.core.scripting.ScriptScopeFactory#getScriptScope()
   * @see #getScriptScopeFactory()
   * @generated
   */
  EReference getScriptScopeFactory_ScriptScope();

  /**
   * Returns the meta object for the reference '{@link com.safi.core.scripting.ScriptScopeFactory#getGlobalScriptScope <em>Global Script Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Global Script Scope</em>'.
   * @see com.safi.core.scripting.ScriptScopeFactory#getGlobalScriptScope()
   * @see #getScriptScopeFactory()
   * @generated
   */
  EReference getScriptScopeFactory_GlobalScriptScope();

  /**
   * Returns the meta object for data type '{@link com.safi.core.scripting.SafletScriptException <em>Saflet Script Exception</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Saflet Script Exception</em>'.
   * @see com.safi.core.scripting.SafletScriptException
   * @model instanceClass="com.safi.core.scripting.SafletScriptException"
   * @generated
   */
  EDataType getSafletScriptException();

  /**
   * Returns the meta object for data type '{@link org.mozilla.javascript.Script <em>Script</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Script</em>'.
   * @see org.mozilla.javascript.Script
   * @model instanceClass="org.mozilla.javascript.Script"
   * @generated
   */
  EDataType getScript();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ScriptingFactory getScriptingFactory();

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
     * The meta object literal for the '{@link com.safi.core.scripting.impl.SafletScriptImpl <em>Saflet Script</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.core.scripting.impl.SafletScriptImpl
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getSafletScript()
     * @generated
     */
    EClass SAFLET_SCRIPT = eINSTANCE.getSafletScript();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAFLET_SCRIPT__NAME = eINSTANCE.getSafletScript_Name();

    /**
     * The meta object literal for the '<em><b>Script Text</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SAFLET_SCRIPT__SCRIPT_TEXT = eINSTANCE.getSafletScript_ScriptText();

    /**
     * The meta object literal for the '{@link com.safi.core.scripting.impl.SafletScriptEnvironmentImpl <em>Saflet Script Environment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.core.scripting.impl.SafletScriptEnvironmentImpl
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getSafletScriptEnvironment()
     * @generated
     */
    EClass SAFLET_SCRIPT_ENVIRONMENT = eINSTANCE.getSafletScriptEnvironment();

    /**
     * The meta object literal for the '<em><b>Shared Saflet Script</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFLET_SCRIPT_ENVIRONMENT__SHARED_SAFLET_SCRIPT = eINSTANCE.getSafletScriptEnvironment_SharedSafletScript();

    /**
     * The meta object literal for the '<em><b>Shared Script Scope</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFLET_SCRIPT_ENVIRONMENT__SHARED_SCRIPT_SCOPE = eINSTANCE.getSafletScriptEnvironment_SharedScriptScope();

    /**
     * The meta object literal for the '<em><b>Saflet Script Factory</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFLET_SCRIPT_ENVIRONMENT__SAFLET_SCRIPT_FACTORY = eINSTANCE.getSafletScriptEnvironment_SafletScriptFactory();

    /**
     * The meta object literal for the '<em><b>Script Scope Factory</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFLET_SCRIPT_ENVIRONMENT__SCRIPT_SCOPE_FACTORY = eINSTANCE.getSafletScriptEnvironment_ScriptScopeFactory();

    /**
     * The meta object literal for the '{@link com.safi.core.scripting.impl.SafletScriptFactoryImpl <em>Saflet Script Factory</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.core.scripting.impl.SafletScriptFactoryImpl
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getSafletScriptFactory()
     * @generated
     */
    EClass SAFLET_SCRIPT_FACTORY = eINSTANCE.getSafletScriptFactory();

    /**
     * The meta object literal for the '<em><b>Saflet Script</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SAFLET_SCRIPT_FACTORY__SAFLET_SCRIPT = eINSTANCE.getSafletScriptFactory_SafletScript();

    /**
     * The meta object literal for the '{@link com.safi.core.scripting.impl.RhinoSafletScriptImpl <em>Rhino Saflet Script</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.core.scripting.impl.RhinoSafletScriptImpl
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getRhinoSafletScript()
     * @generated
     */
    EClass RHINO_SAFLET_SCRIPT = eINSTANCE.getRhinoSafletScript();

    /**
     * The meta object literal for the '<em><b>Rhino Script</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RHINO_SAFLET_SCRIPT__RHINO_SCRIPT = eINSTANCE.getRhinoSafletScript_RhinoScript();

    /**
     * The meta object literal for the '{@link com.safi.core.scripting.impl.RhinoSafletScriptEnvironmentImpl <em>Rhino Saflet Script Environment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.core.scripting.impl.RhinoSafletScriptEnvironmentImpl
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getRhinoSafletScriptEnvironment()
     * @generated
     */
    EClass RHINO_SAFLET_SCRIPT_ENVIRONMENT = eINSTANCE.getRhinoSafletScriptEnvironment();

    /**
     * The meta object literal for the '{@link com.safi.core.scripting.impl.RhinoSafletScriptFactoryImpl <em>Rhino Saflet Script Factory</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.core.scripting.impl.RhinoSafletScriptFactoryImpl
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getRhinoSafletScriptFactory()
     * @generated
     */
    EClass RHINO_SAFLET_SCRIPT_FACTORY = eINSTANCE.getRhinoSafletScriptFactory();

    /**
     * The meta object literal for the '{@link com.safi.core.scripting.impl.RhinoScriptScopeImpl <em>Rhino Script Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.core.scripting.impl.RhinoScriptScopeImpl
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getRhinoScriptScope()
     * @generated
     */
    EClass RHINO_SCRIPT_SCOPE = eINSTANCE.getRhinoScriptScope();

    /**
     * The meta object literal for the '{@link com.safi.core.scripting.impl.RhinoScriptScopeFactoryImpl <em>Rhino Script Scope Factory</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.core.scripting.impl.RhinoScriptScopeFactoryImpl
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getRhinoScriptScopeFactory()
     * @generated
     */
    EClass RHINO_SCRIPT_SCOPE_FACTORY = eINSTANCE.getRhinoScriptScopeFactory();

    /**
     * The meta object literal for the '{@link com.safi.core.scripting.impl.ScriptScopeImpl <em>Script Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.core.scripting.impl.ScriptScopeImpl
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getScriptScope()
     * @generated
     */
    EClass SCRIPT_SCOPE = eINSTANCE.getScriptScope();

    /**
     * The meta object literal for the '<em><b>Scope Object</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SCRIPT_SCOPE__SCOPE_OBJECT = eINSTANCE.getScriptScope_ScopeObject();

    /**
     * The meta object literal for the '{@link com.safi.core.scripting.impl.ScriptScopeFactoryImpl <em>Script Scope Factory</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.core.scripting.impl.ScriptScopeFactoryImpl
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getScriptScopeFactory()
     * @generated
     */
    EClass SCRIPT_SCOPE_FACTORY = eINSTANCE.getScriptScopeFactory();

    /**
     * The meta object literal for the '<em><b>Script Scope</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCRIPT_SCOPE_FACTORY__SCRIPT_SCOPE = eINSTANCE.getScriptScopeFactory_ScriptScope();

    /**
     * The meta object literal for the '<em><b>Global Script Scope</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCRIPT_SCOPE_FACTORY__GLOBAL_SCRIPT_SCOPE = eINSTANCE.getScriptScopeFactory_GlobalScriptScope();

    /**
     * The meta object literal for the '<em>Saflet Script Exception</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.safi.core.scripting.SafletScriptException
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getSafletScriptException()
     * @generated
     */
    EDataType SAFLET_SCRIPT_EXCEPTION = eINSTANCE.getSafletScriptException();

    /**
     * The meta object literal for the '<em>Script</em>' data type.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.mozilla.javascript.Script
     * @see com.safi.core.scripting.impl.ScriptingPackageImpl#getScript()
     * @generated
     */
    EDataType SCRIPT = eINSTANCE.getScript();

  }

} //ScriptingPackage
