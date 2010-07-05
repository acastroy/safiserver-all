/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.call.impl;

import com.safi.core.CorePackage;

import com.safi.core.actionstep.ActionStepPackage;

import com.safi.core.actionstep.impl.ActionStepPackageImpl;

import com.safi.core.call.CallConsumer1;
import com.safi.core.call.CallConsumer2;
import com.safi.core.call.CallFactory;
import com.safi.core.call.CallPackage;
import com.safi.core.call.CallSource1;
import com.safi.core.call.CallSource2;
import com.safi.core.call.SafiCall;

import com.safi.core.impl.CorePackageImpl;

import com.safi.core.initiator.InitiatorPackage;

import com.safi.core.initiator.impl.InitiatorPackageImpl;

import com.safi.core.saflet.SafletPackage;

import com.safi.core.saflet.impl.SafletPackageImpl;

import com.safi.core.scripting.ScriptingPackage;

import com.safi.core.scripting.impl.ScriptingPackageImpl;

import com.safi.db.DbPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CallPackageImpl extends EPackageImpl implements CallPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass safiCallEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callSource1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callSource2EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callConsumer1EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass callConsumer2EClass = null;

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
	 * @see com.safi.core.call.CallPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CallPackageImpl() {
		super(eNS_URI, CallFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CallPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CallPackage init() {
		if (isInited) return (CallPackage)EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI);

		// Obtain or create and register package
		CallPackageImpl theCallPackage = (CallPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CallPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CallPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DbPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		ActionStepPackageImpl theActionStepPackage = (ActionStepPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI) instanceof ActionStepPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI) : ActionStepPackage.eINSTANCE);
		ScriptingPackageImpl theScriptingPackage = (ScriptingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI) instanceof ScriptingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI) : ScriptingPackage.eINSTANCE);
		SafletPackageImpl theSafletPackage = (SafletPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) instanceof SafletPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) : SafletPackage.eINSTANCE);
		InitiatorPackageImpl theInitiatorPackage = (InitiatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) instanceof InitiatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) : InitiatorPackage.eINSTANCE);

		// Create package meta-data objects
		theCallPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theActionStepPackage.createPackageContents();
		theScriptingPackage.createPackageContents();
		theSafletPackage.createPackageContents();
		theInitiatorPackage.createPackageContents();

		// Initialize created meta-data
		theCallPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theActionStepPackage.initializePackageContents();
		theScriptingPackage.initializePackageContents();
		theSafletPackage.initializePackageContents();
		theInitiatorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCallPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CallPackage.eNS_URI, theCallPackage);
		return theCallPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSafiCall() {
		return safiCallEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafiCall_Uuid() {
		return (EAttribute)safiCallEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSafiCall_Name() {
		return (EAttribute)safiCallEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallSource1() {
		return callSource1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallSource1_NewCall1() {
		return (EReference)callSource1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallSource2() {
		return callSource2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallSource2_NewCall2() {
		return (EReference)callSource2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallConsumer1() {
		return callConsumer1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallConsumer1_Call1() {
		return (EReference)callConsumer1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCallConsumer2() {
		return callConsumer2EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCallConsumer2_Call2() {
		return (EReference)callConsumer2EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallFactory getCallFactory() {
		return (CallFactory)getEFactoryInstance();
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
		safiCallEClass = createEClass(SAFI_CALL);
		createEAttribute(safiCallEClass, SAFI_CALL__UUID);
		createEAttribute(safiCallEClass, SAFI_CALL__NAME);

		callSource1EClass = createEClass(CALL_SOURCE1);
		createEReference(callSource1EClass, CALL_SOURCE1__NEW_CALL1);

		callSource2EClass = createEClass(CALL_SOURCE2);
		createEReference(callSource2EClass, CALL_SOURCE2__NEW_CALL2);

		callConsumer1EClass = createEClass(CALL_CONSUMER1);
		createEReference(callConsumer1EClass, CALL_CONSUMER1__CALL1);

		callConsumer2EClass = createEClass(CALL_CONSUMER2);
		createEReference(callConsumer2EClass, CALL_CONSUMER2__CALL2);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		safiCallEClass.getESuperTypes().add(theCorePackage.getThreadSensitive());
		safiCallEClass.getESuperTypes().add(theCorePackage.getPlatformDisposition());
		callSource2EClass.getESuperTypes().add(this.getCallSource1());
		callConsumer2EClass.getESuperTypes().add(this.getCallConsumer1());

		// Initialize classes and features; add operations and parameters
		initEClass(safiCallEClass, SafiCall.class, "SafiCall", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSafiCall_Uuid(), ecorePackage.getEString(), "uuid", null, 0, 1, SafiCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafiCall_Name(), ecorePackage.getEString(), "name", null, 0, 1, SafiCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callSource1EClass, CallSource1.class, "CallSource1", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallSource1_NewCall1(), this.getSafiCall(), null, "newCall1", null, 0, 1, CallSource1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callSource2EClass, CallSource2.class, "CallSource2", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallSource2_NewCall2(), this.getSafiCall(), null, "newCall2", null, 0, 1, CallSource2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callConsumer1EClass, CallConsumer1.class, "CallConsumer1", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallConsumer1_Call1(), this.getSafiCall(), null, "call1", null, 0, 1, CallConsumer1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(callConsumer2EClass, CallConsumer2.class, "CallConsumer2", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCallConsumer2_Call2(), this.getSafiCall(), null, "call2", null, 0, 1, CallConsumer2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create annotations
		// Directionality
		createDirectionalityAnnotations();
		// Required
		createRequiredAnnotations();
	}

	/**
	 * Initializes the annotations for <b>Directionality</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createDirectionalityAnnotations() {
		String source = "Directionality";		
		addAnnotation
		  (getCallSource1_NewCall1(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });		
		addAnnotation
		  (getCallSource2_NewCall2(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });	
	}

	/**
	 * Initializes the annotations for <b>Required</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createRequiredAnnotations() {
		String source = "Required";				
		addAnnotation
		  (getCallConsumer1_Call1(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });
	}

} //CallPackageImpl
