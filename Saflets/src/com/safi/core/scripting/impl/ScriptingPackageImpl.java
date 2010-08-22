/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import com.safi.core.CorePackage;

import com.safi.core.actionstep.ActionStepPackage;

import com.safi.core.actionstep.impl.ActionStepPackageImpl;

import com.safi.core.call.CallPackage;
import com.safi.core.call.impl.CallPackageImpl;
import com.safi.core.impl.CorePackageImpl;

import com.safi.core.initiator.InitiatorPackage;

import com.safi.core.initiator.impl.InitiatorPackageImpl;

import com.safi.core.saflet.SafletPackage;

import com.safi.core.saflet.impl.SafletPackageImpl;

import com.safi.core.scripting.RhinoSafletScript;
import com.safi.core.scripting.RhinoSafletScriptEnvironment;
import com.safi.core.scripting.RhinoSafletScriptFactory;
import com.safi.core.scripting.RhinoScriptScope;
import com.safi.core.scripting.RhinoScriptScopeFactory;
import com.safi.core.scripting.SafletScript;
import com.safi.core.scripting.SafletScriptEnvironment;
import com.safi.core.scripting.SafletScriptException;
import com.safi.core.scripting.SafletScriptFactory;
import com.safi.core.scripting.ScriptScope;
import com.safi.core.scripting.ScriptScopeFactory;
import com.safi.core.scripting.ScriptingFactory;
import com.safi.core.scripting.ScriptingPackage;

import com.safi.db.DbPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.mozilla.javascript.Script;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ScriptingPackageImpl extends EPackageImpl implements ScriptingPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass safletScriptEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass safletScriptEnvironmentEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass safletScriptFactoryEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass rhinoSafletScriptEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass rhinoSafletScriptEnvironmentEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass rhinoSafletScriptFactoryEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass rhinoScriptScopeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass rhinoScriptScopeFactoryEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass scriptScopeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass scriptScopeFactoryEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType safletScriptExceptionEDataType = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType scriptEDataType = null;

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
	 * @see com.safi.core.scripting.ScriptingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private ScriptingPackageImpl() {
		super(eNS_URI, ScriptingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ScriptingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static ScriptingPackage init() {
		if (isInited) return (ScriptingPackage)EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI);

		// Obtain or create and register package
		ScriptingPackageImpl theScriptingPackage = (ScriptingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ScriptingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ScriptingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DbPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		ActionStepPackageImpl theActionStepPackage = (ActionStepPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI) instanceof ActionStepPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI) : ActionStepPackage.eINSTANCE);
		SafletPackageImpl theSafletPackage = (SafletPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) instanceof SafletPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) : SafletPackage.eINSTANCE);
		InitiatorPackageImpl theInitiatorPackage = (InitiatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) instanceof InitiatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) : InitiatorPackage.eINSTANCE);
		CallPackageImpl theCallPackage = (CallPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI) instanceof CallPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI) : CallPackage.eINSTANCE);

		// Create package meta-data objects
		theScriptingPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theActionStepPackage.createPackageContents();
		theSafletPackage.createPackageContents();
		theInitiatorPackage.createPackageContents();
		theCallPackage.createPackageContents();

		// Initialize created meta-data
		theScriptingPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theActionStepPackage.initializePackageContents();
		theSafletPackage.initializePackageContents();
		theInitiatorPackage.initializePackageContents();
		theCallPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theScriptingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ScriptingPackage.eNS_URI, theScriptingPackage);
		return theScriptingPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSafletScript() {
		return safletScriptEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafletScript_Name() {
		return (EAttribute)safletScriptEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafletScript_ScriptText() {
		return (EAttribute)safletScriptEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSafletScriptEnvironment() {
		return safletScriptEnvironmentEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafletScriptEnvironment_SharedSafletScript() {
		return (EReference)safletScriptEnvironmentEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafletScriptEnvironment_SharedScriptScope() {
		return (EReference)safletScriptEnvironmentEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafletScriptEnvironment_SafletScriptFactory() {
		return (EReference)safletScriptEnvironmentEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafletScriptEnvironment_ScriptScopeFactory() {
		return (EReference)safletScriptEnvironmentEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSafletScriptFactory() {
		return safletScriptFactoryEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafletScriptFactory_SafletScript() {
		return (EReference)safletScriptFactoryEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getRhinoSafletScript() {
		return rhinoSafletScriptEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRhinoSafletScript_RhinoScript() {
		return (EAttribute)rhinoSafletScriptEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getRhinoSafletScriptEnvironment() {
		return rhinoSafletScriptEnvironmentEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getRhinoSafletScriptFactory() {
		return rhinoSafletScriptFactoryEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getRhinoScriptScope() {
		return rhinoScriptScopeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getRhinoScriptScopeFactory() {
		return rhinoScriptScopeFactoryEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getScriptScope() {
		return scriptScopeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getScriptScope_ScopeObject() {
		return (EAttribute)scriptScopeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getScriptScopeFactory() {
		return scriptScopeFactoryEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getScriptScopeFactory_ScriptScope() {
		return (EReference)scriptScopeFactoryEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getScriptScopeFactory_GlobalScriptScope() {
		return (EReference)scriptScopeFactoryEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getSafletScriptException() {
		return safletScriptExceptionEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getScript() {
		return scriptEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ScriptingFactory getScriptingFactory() {
		return (ScriptingFactory)getEFactoryInstance();
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
		safletScriptEClass = createEClass(SAFLET_SCRIPT);
		createEAttribute(safletScriptEClass, SAFLET_SCRIPT__NAME);
		createEAttribute(safletScriptEClass, SAFLET_SCRIPT__SCRIPT_TEXT);

		safletScriptEnvironmentEClass = createEClass(SAFLET_SCRIPT_ENVIRONMENT);
		createEReference(safletScriptEnvironmentEClass, SAFLET_SCRIPT_ENVIRONMENT__SHARED_SAFLET_SCRIPT);
		createEReference(safletScriptEnvironmentEClass, SAFLET_SCRIPT_ENVIRONMENT__SHARED_SCRIPT_SCOPE);
		createEReference(safletScriptEnvironmentEClass, SAFLET_SCRIPT_ENVIRONMENT__SAFLET_SCRIPT_FACTORY);
		createEReference(safletScriptEnvironmentEClass, SAFLET_SCRIPT_ENVIRONMENT__SCRIPT_SCOPE_FACTORY);

		safletScriptFactoryEClass = createEClass(SAFLET_SCRIPT_FACTORY);
		createEReference(safletScriptFactoryEClass, SAFLET_SCRIPT_FACTORY__SAFLET_SCRIPT);

		rhinoSafletScriptEClass = createEClass(RHINO_SAFLET_SCRIPT);
		createEAttribute(rhinoSafletScriptEClass, RHINO_SAFLET_SCRIPT__RHINO_SCRIPT);

		rhinoSafletScriptEnvironmentEClass = createEClass(RHINO_SAFLET_SCRIPT_ENVIRONMENT);

		rhinoSafletScriptFactoryEClass = createEClass(RHINO_SAFLET_SCRIPT_FACTORY);

		rhinoScriptScopeEClass = createEClass(RHINO_SCRIPT_SCOPE);

		rhinoScriptScopeFactoryEClass = createEClass(RHINO_SCRIPT_SCOPE_FACTORY);

		scriptScopeEClass = createEClass(SCRIPT_SCOPE);
		createEAttribute(scriptScopeEClass, SCRIPT_SCOPE__SCOPE_OBJECT);

		scriptScopeFactoryEClass = createEClass(SCRIPT_SCOPE_FACTORY);
		createEReference(scriptScopeFactoryEClass, SCRIPT_SCOPE_FACTORY__SCRIPT_SCOPE);
		createEReference(scriptScopeFactoryEClass, SCRIPT_SCOPE_FACTORY__GLOBAL_SCRIPT_SCOPE);

		// Create data types
		safletScriptExceptionEDataType = createEDataType(SAFLET_SCRIPT_EXCEPTION);
		scriptEDataType = createEDataType(SCRIPT);
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
		SafletPackage theSafletPackage = (SafletPackage)EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI);
		DbPackage theDbPackage = (DbPackage)EPackage.Registry.INSTANCE.getEPackage(DbPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		rhinoSafletScriptEClass.getESuperTypes().add(this.getSafletScript());
		rhinoSafletScriptEnvironmentEClass.getESuperTypes().add(this.getSafletScriptEnvironment());
		rhinoSafletScriptFactoryEClass.getESuperTypes().add(this.getSafletScriptFactory());
		rhinoScriptScopeEClass.getESuperTypes().add(this.getScriptScope());
		rhinoScriptScopeFactoryEClass.getESuperTypes().add(this.getScriptScopeFactory());

		// Initialize classes and features; add operations and parameters
		initEClass(safletScriptEClass, SafletScript.class, "SafletScript", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSafletScript_Name(), ecorePackage.getEString(), "name", null, 0, 1, SafletScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSafletScript_ScriptText(), ecorePackage.getEString(), "scriptText", null, 0, 1, SafletScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(safletScriptEClass, ecorePackage.getEJavaObject(), "execute", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getScriptScope(), "scope", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getSafletScriptException());

		initEClass(safletScriptEnvironmentEClass, SafletScriptEnvironment.class, "SafletScriptEnvironment", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSafletScriptEnvironment_SharedSafletScript(), this.getSafletScript(), null, "sharedSafletScript", null, 0, 1, SafletScriptEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSafletScriptEnvironment_SharedScriptScope(), this.getScriptScope(), null, "sharedScriptScope", null, 0, 1, SafletScriptEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSafletScriptEnvironment_SafletScriptFactory(), this.getSafletScriptFactory(), null, "safletScriptFactory", null, 0, 1, SafletScriptEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSafletScriptEnvironment_ScriptScopeFactory(), this.getScriptScopeFactory(), null, "scriptScopeFactory", null, 0, 1, SafletScriptEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(safletScriptFactoryEClass, SafletScriptFactory.class, "SafletScriptFactory", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSafletScriptFactory_SafletScript(), this.getSafletScript(), null, "safletScript", null, 0, 1, SafletScriptFactory.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(safletScriptFactoryEClass, this.getSafletScript(), "getSafletScript", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "scriptText", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(rhinoSafletScriptEClass, RhinoSafletScript.class, "RhinoSafletScript", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRhinoSafletScript_RhinoScript(), this.getScript(), "rhinoScript", null, 0, 1, RhinoSafletScript.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rhinoSafletScriptEnvironmentEClass, RhinoSafletScriptEnvironment.class, "RhinoSafletScriptEnvironment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rhinoSafletScriptFactoryEClass, RhinoSafletScriptFactory.class, "RhinoSafletScriptFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rhinoScriptScopeEClass, RhinoScriptScope.class, "RhinoScriptScope", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(rhinoScriptScopeFactoryEClass, RhinoScriptScopeFactory.class, "RhinoScriptScopeFactory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(scriptScopeEClass, ScriptScope.class, "ScriptScope", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScriptScope_ScopeObject(), ecorePackage.getEJavaObject(), "scopeObject", null, 0, 1, ScriptScope.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		op = addEOperation(scriptScopeEClass, null, "exposeObjectToScript", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getSafletScriptException());

		op = addEOperation(scriptScopeEClass, null, "removeObjectFromScope", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getSafletScriptException());

		op = addEOperation(scriptScopeEClass, ecorePackage.getEJavaObject(), "getScopedObject", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theSafletPackage.getSafletException());

		op = addEOperation(scriptScopeEClass, null, "updateVariablesFromScope", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDbPackage.getVariable(), "variables", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theSafletPackage.getSafletEnvironment(), "safletEnvironment", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "isDebug", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getSafletScriptException());

		initEClass(scriptScopeFactoryEClass, ScriptScopeFactory.class, "ScriptScopeFactory", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScriptScopeFactory_ScriptScope(), this.getScriptScope(), null, "scriptScope", null, 0, 1, ScriptScopeFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScriptScopeFactory_GlobalScriptScope(), this.getScriptScope(), null, "globalScriptScope", null, 0, 1, ScriptScopeFactory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize data types
		initEDataType(safletScriptExceptionEDataType, SafletScriptException.class, "SafletScriptException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(scriptEDataType, Script.class, "Script", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //ScriptingPackageImpl
