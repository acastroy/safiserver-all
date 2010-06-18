/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.saflet.impl;

import com.safi.core.CorePackage;

import com.safi.core.actionstep.ActionStepPackage;

import com.safi.core.actionstep.impl.ActionStepPackageImpl;

import com.safi.core.call.CallPackage;
import com.safi.core.call.impl.CallPackageImpl;
import com.safi.core.impl.CorePackageImpl;

import com.safi.core.initiator.InitiatorPackage;

import com.safi.core.initiator.impl.InitiatorPackageImpl;

import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;
import com.safi.core.saflet.SafletException;
import com.safi.core.saflet.SafletFactory;
import com.safi.core.saflet.SafletPackage;

import com.safi.core.scripting.ScriptingPackage;

import com.safi.core.scripting.impl.ScriptingPackageImpl;

import com.safi.db.DbPackage;

import java.util.concurrent.Executor;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SafletPackageImpl extends EPackageImpl implements SafletPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass safletEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass safletContextEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass safletEnvironmentEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType safletExceptionEDataType = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType exceptionEDataType = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType executorEDataType = null;

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
	 * @see com.safi.core.saflet.SafletPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private SafletPackageImpl() {
		super(eNS_URI, SafletFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SafletPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static SafletPackage init() {
		if (isInited) return (SafletPackage)EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI);

		// Obtain or create and register package
		SafletPackageImpl theSafletPackage = (SafletPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SafletPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SafletPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DbPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		ActionStepPackageImpl theActionStepPackage = (ActionStepPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI) instanceof ActionStepPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI) : ActionStepPackage.eINSTANCE);
		ScriptingPackageImpl theScriptingPackage = (ScriptingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI) instanceof ScriptingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI) : ScriptingPackage.eINSTANCE);
		InitiatorPackageImpl theInitiatorPackage = (InitiatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) instanceof InitiatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) : InitiatorPackage.eINSTANCE);
		CallPackageImpl theCallPackage = (CallPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI) instanceof CallPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI) : CallPackage.eINSTANCE);

		// Create package meta-data objects
		theSafletPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theActionStepPackage.createPackageContents();
		theScriptingPackage.createPackageContents();
		theInitiatorPackage.createPackageContents();
		theCallPackage.createPackageContents();

		// Initialize created meta-data
		theSafletPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theActionStepPackage.initializePackageContents();
		theScriptingPackage.initializePackageContents();
		theInitiatorPackage.initializePackageContents();
		theCallPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSafletPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SafletPackage.eNS_URI, theSafletPackage);
		return theSafletPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSaflet() {
		return safletEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSaflet_Initiator() {
		return (EReference)safletEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSaflet_Active() {
		return (EAttribute)safletEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSaflet_Name() {
		return (EAttribute)safletEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSaflet_SafletContext() {
		return (EReference)safletEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSaflet_SafletScope() {
		return (EReference)safletEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSaflet_Actionsteps() {
		return (EReference)safletEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSaflet_ScriptingEnvironment() {
		return (EReference)safletEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSaflet_SafletEnvironment() {
		return (EReference)safletEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSaflet_Version() {
		return (EAttribute)safletEClass.getEStructuralFeatures().get(8);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSaflet_Description() {
		return (EAttribute)safletEClass.getEStructuralFeatures().get(9);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSaflet_Id() {
		return (EAttribute)safletEClass.getEStructuralFeatures().get(10);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSafletContext() {
		return safletContextEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafletContext_Exceptions() {
		return (EAttribute)safletContextEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafletContext_ParentSaflet() {
		return (EReference)safletContextEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafletContext_Variables() {
		return (EReference)safletContextEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafletContext_SessionVariables() {
		return (EAttribute)safletContextEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSafletEnvironment() {
		return safletEnvironmentEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getSafletException() {
		return safletExceptionEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getException() {
		return exceptionEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getExecutor() {
		return executorEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafletFactory getSafletFactory() {
		return (SafletFactory)getEFactoryInstance();
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
		safletEClass = createEClass(SAFLET);
		createEReference(safletEClass, SAFLET__INITIATOR);
		createEAttribute(safletEClass, SAFLET__ACTIVE);
		createEAttribute(safletEClass, SAFLET__NAME);
		createEReference(safletEClass, SAFLET__SAFLET_CONTEXT);
		createEReference(safletEClass, SAFLET__SAFLET_SCOPE);
		createEReference(safletEClass, SAFLET__ACTIONSTEPS);
		createEReference(safletEClass, SAFLET__SCRIPTING_ENVIRONMENT);
		createEReference(safletEClass, SAFLET__SAFLET_ENVIRONMENT);
		createEAttribute(safletEClass, SAFLET__VERSION);
		createEAttribute(safletEClass, SAFLET__DESCRIPTION);
		createEAttribute(safletEClass, SAFLET__ID);

		safletContextEClass = createEClass(SAFLET_CONTEXT);
		createEAttribute(safletContextEClass, SAFLET_CONTEXT__EXCEPTIONS);
		createEReference(safletContextEClass, SAFLET_CONTEXT__PARENT_SAFLET);
		createEReference(safletContextEClass, SAFLET_CONTEXT__VARIABLES);
		createEAttribute(safletContextEClass, SAFLET_CONTEXT__SESSION_VARIABLES);

		safletEnvironmentEClass = createEClass(SAFLET_ENVIRONMENT);

		// Create data types
		safletExceptionEDataType = createEDataType(SAFLET_EXCEPTION);
		exceptionEDataType = createEDataType(EXCEPTION);
		executorEDataType = createEDataType(EXECUTOR);
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
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);
		InitiatorPackage theInitiatorPackage = (InitiatorPackage)EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI);
		ScriptingPackage theScriptingPackage = (ScriptingPackage)EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI);
		ActionStepPackage theActionStepPackage = (ActionStepPackage)EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI);
		DbPackage theDbPackage = (DbPackage)EPackage.Registry.INSTANCE.getEPackage(DbPackage.eNS_URI);
		CallPackage theCallPackage = (CallPackage)EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		safletEClass.getESuperTypes().add(theCorePackage.getThreadSensitive());
		safletContextEClass.getESuperTypes().add(theCorePackage.getThreadSensitive());
		safletEnvironmentEClass.getESuperTypes().add(theCorePackage.getThreadSensitive());

		// Initialize classes and features; add operations and parameters
		initEClass(safletEClass, Saflet.class, "Saflet", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSaflet_Initiator(), theInitiatorPackage.getInitiator(), null, "initiator", null, 0, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSaflet_Active(), ecorePackage.getEBoolean(), "active", null, 0, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSaflet_Name(), ecorePackage.getEString(), "name", "New Saflet", 1, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSaflet_SafletContext(), this.getSafletContext(), null, "safletContext", null, 0, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSaflet_SafletScope(), theScriptingPackage.getScriptScope(), null, "safletScope", null, 0, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSaflet_Actionsteps(), theActionStepPackage.getActionStep(), theActionStepPackage.getActionStep_Saflet(), "actionsteps", null, 0, -1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSaflet_ScriptingEnvironment(), theScriptingPackage.getSafletScriptEnvironment(), null, "scriptingEnvironment", null, 0, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSaflet_SafletEnvironment(), this.getSafletEnvironment(), null, "safletEnvironment", null, 0, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSaflet_Version(), ecorePackage.getEString(), "version", "", 1, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSaflet_Description(), ecorePackage.getEString(), "description", "", 0, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSaflet_Id(), ecorePackage.getEInt(), "id", "-1", 0, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(safletEClass, theActionStepPackage.getActionStep(), "getActionStep", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletEClass, null, "addActionStep", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theActionStepPackage.getActionStep(), "actionstep", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getSafletException());

		op = addEOperation(safletEClass, theScriptingPackage.getSafletScript(), "getScript", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletEClass, theScriptingPackage.getSafletScript(), "addScript", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "scriptText", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(safletEClass, null, "initializeScriptableObjects", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletEClass, null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, theInitiatorPackage.getActionStepException());

		initEClass(safletContextEClass, SafletContext.class, "SafletContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSafletContext_Exceptions(), this.getException(), "exceptions", null, 0, -1, SafletContext.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSafletContext_ParentSaflet(), this.getSaflet(), null, "parentSaflet", null, 0, 1, SafletContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSafletContext_Variables(), theDbPackage.getVariable(), null, "variables", null, 0, -1, SafletContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		initEAttribute(getSafletContext_SessionVariables(), g1, "sessionVariables", null, 0, 1, SafletContext.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(safletContextEClass, null, "init", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletContextEClass, theDbPackage.getVariable(), "getVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletContextEClass, ecorePackage.getEJavaObject(), "getVariableRawValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletContextEClass, null, "setVariableRawValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletContextEClass, null, "addOrUpdateVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theDbPackage.getVariable(), "v", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletContextEClass, theDbPackage.getVariable(), "removeVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletContextEClass, null, "addException", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getException(), "e", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletContextEClass, null, "merge", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getSafletContext(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletContextEClass, ecorePackage.getEJavaObject(), "getSessionVar", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletContextEClass, null, "setSessionVar", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletContextEClass, null, "preHandoffPrep", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theCallPackage.getSafiCall(), "call", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(safletEnvironmentEClass, SafletEnvironment.class, "SafletEnvironment", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(safletEnvironmentEClass, this.getSaflet(), "getSaflet", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "path", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEInt(), "coreServerId", 1, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(safletEnvironmentEClass, this.getExecutor(), "getGlobalExecutor", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletEnvironmentEClass, ecorePackage.getEJavaObject(), "getGlobalVariableValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletEnvironmentEClass, null, "setGlobalVariableValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(safletEnvironmentEClass, theDbPackage.getVariable(), "getGlobalVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize data types
		initEDataType(safletExceptionEDataType, SafletException.class, "SafletException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(exceptionEDataType, Exception.class, "Exception", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(executorEDataType, Executor.class, "Executor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //SafletPackageImpl
