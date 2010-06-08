/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.impl;

import com.safi.core.CoreFactory;
import com.safi.core.CorePackage;
import com.safi.core.PlatformDisposition;
import com.safi.core.PlatformDependant;
import com.safi.core.ProductIdentifiable;

import com.safi.core.ThreadSensitive;
import com.safi.core.actionstep.ActionStepPackage;

import com.safi.core.actionstep.impl.ActionStepPackageImpl;

import com.safi.core.call.CallPackage;
import com.safi.core.call.impl.CallPackageImpl;
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

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CorePackageImpl extends EPackageImpl implements CorePackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass productIdentifiableEClass = null;

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadSensitiveEClass = null;

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass platformDispositionEClass = null;

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
	 * @see com.safi.core.CorePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private CorePackageImpl() {
		super(eNS_URI, CoreFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CorePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static CorePackage init() {
		if (isInited) return (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Obtain or create and register package
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CorePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DbPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ActionStepPackageImpl theActionStepPackage = (ActionStepPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI) instanceof ActionStepPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI) : ActionStepPackage.eINSTANCE);
		ScriptingPackageImpl theScriptingPackage = (ScriptingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI) instanceof ScriptingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI) : ScriptingPackage.eINSTANCE);
		SafletPackageImpl theSafletPackage = (SafletPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) instanceof SafletPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) : SafletPackage.eINSTANCE);
		InitiatorPackageImpl theInitiatorPackage = (InitiatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) instanceof InitiatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) : InitiatorPackage.eINSTANCE);
		CallPackageImpl theCallPackage = (CallPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI) instanceof CallPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI) : CallPackage.eINSTANCE);

		// Create package meta-data objects
		theCorePackage.createPackageContents();
		theActionStepPackage.createPackageContents();
		theScriptingPackage.createPackageContents();
		theSafletPackage.createPackageContents();
		theInitiatorPackage.createPackageContents();
		theCallPackage.createPackageContents();

		// Initialize created meta-data
		theCorePackage.initializePackageContents();
		theActionStepPackage.initializePackageContents();
		theScriptingPackage.initializePackageContents();
		theSafletPackage.initializePackageContents();
		theInitiatorPackage.initializePackageContents();
		theCallPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCorePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CorePackage.eNS_URI, theCorePackage);
		return theCorePackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getProductIdentifiable() {
		return productIdentifiableEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getProductIdentifiable_ProductId() {
		return (EAttribute)productIdentifiableEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadSensitive() {
		return threadSensitiveEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPlatformDisposition() {
		return platformDispositionEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatformDisposition_PlatformID() {
		return (EAttribute)platformDispositionEClass.getEStructuralFeatures().get(0);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPlatformDisposition_PlatformDependant() {
		return (EAttribute)platformDispositionEClass.getEStructuralFeatures().get(1);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CoreFactory getCoreFactory() {
		return (CoreFactory)getEFactoryInstance();
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
		productIdentifiableEClass = createEClass(PRODUCT_IDENTIFIABLE);
		createEAttribute(productIdentifiableEClass, PRODUCT_IDENTIFIABLE__PRODUCT_ID);

		threadSensitiveEClass = createEClass(THREAD_SENSITIVE);

		platformDispositionEClass = createEClass(PLATFORM_DISPOSITION);
		createEAttribute(platformDispositionEClass, PLATFORM_DISPOSITION__PLATFORM_ID);
		createEAttribute(platformDispositionEClass, PLATFORM_DISPOSITION__PLATFORM_DEPENDANT);
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
		ActionStepPackage theActionStepPackage = (ActionStepPackage)EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI);
		ScriptingPackage theScriptingPackage = (ScriptingPackage)EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI);
		SafletPackage theSafletPackage = (SafletPackage)EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI);
		InitiatorPackage theInitiatorPackage = (InitiatorPackage)EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI);
		CallPackage theCallPackage = (CallPackage)EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theActionStepPackage);
		getESubpackages().add(theScriptingPackage);
		getESubpackages().add(theSafletPackage);
		getESubpackages().add(theInitiatorPackage);
		getESubpackages().add(theCallPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(productIdentifiableEClass, ProductIdentifiable.class, "ProductIdentifiable", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProductIdentifiable_ProductId(), ecorePackage.getEString(), "productId", null, 0, 1, ProductIdentifiable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(threadSensitiveEClass, ThreadSensitive.class, "ThreadSensitive", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(threadSensitiveEClass, null, "cleanup", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(platformDispositionEClass, PlatformDisposition.class, "PlatformDisposition", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlatformDisposition_PlatformID(), ecorePackage.getEString(), "platformID", "", 0, 1, PlatformDisposition.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlatformDisposition_PlatformDependant(), ecorePackage.getEBoolean(), "platformDependant", "false", 0, 1, PlatformDisposition.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //CorePackageImpl
