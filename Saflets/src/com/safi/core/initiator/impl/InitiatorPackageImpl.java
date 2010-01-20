/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.initiator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.safi.core.CorePackage;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.impl.ActionStepPackageImpl;
import com.safi.core.impl.CorePackageImpl;
import com.safi.core.initiator.Initiator;
import com.safi.core.initiator.InitiatorFactory;
import com.safi.core.initiator.InitiatorInfo;
import com.safi.core.initiator.InitiatorPackage;
import com.safi.core.initiator.InputType;
import com.safi.core.saflet.SafletPackage;
import com.safi.core.saflet.impl.SafletPackageImpl;
import com.safi.core.scripting.ScriptingPackage;
import com.safi.core.scripting.impl.ScriptingPackageImpl;
import com.safi.db.DbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InitiatorPackageImpl extends EPackageImpl implements InitiatorPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass initiatorEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass initiatorInfoEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum inputTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType actionStepExceptionEDataType = null;

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
	 * @see com.safi.core.initiator.InitiatorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private InitiatorPackageImpl() {
		super(eNS_URI, InitiatorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link InitiatorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static InitiatorPackage init() {
		if (isInited) return (InitiatorPackage)EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI);

		// Obtain or create and register package
		InitiatorPackageImpl theInitiatorPackage = (InitiatorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof InitiatorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new InitiatorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DbPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		ActionStepPackageImpl theActionStepPackage = (ActionStepPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI) instanceof ActionStepPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI) : ActionStepPackage.eINSTANCE);
		ScriptingPackageImpl theScriptingPackage = (ScriptingPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI) instanceof ScriptingPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ScriptingPackage.eNS_URI) : ScriptingPackage.eINSTANCE);
		SafletPackageImpl theSafletPackage = (SafletPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) instanceof SafletPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) : SafletPackage.eINSTANCE);

		// Create package meta-data objects
		theInitiatorPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theActionStepPackage.createPackageContents();
		theScriptingPackage.createPackageContents();
		theSafletPackage.createPackageContents();

		// Initialize created meta-data
		theInitiatorPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theActionStepPackage.initializePackageContents();
		theScriptingPackage.initializePackageContents();
		theSafletPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theInitiatorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(InitiatorPackage.eNS_URI, theInitiatorPackage);
		return theInitiatorPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getInitiator() {
		return initiatorEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getInitiatorInfo() {
		return initiatorInfoEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getInputType() {
		return inputTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getActionStepException() {
		return actionStepExceptionEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InitiatorFactory getInitiatorFactory() {
		return (InitiatorFactory)getEFactoryInstance();
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
		initiatorEClass = createEClass(INITIATOR);

		initiatorInfoEClass = createEClass(INITIATOR_INFO);

		// Create enums
		inputTypeEEnum = createEEnum(INPUT_TYPE);

		// Create data types
		actionStepExceptionEDataType = createEDataType(ACTION_STEP_EXCEPTION);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		initiatorEClass.getESuperTypes().add(theActionStepPackage.getActionStep());

		// Initialize classes and features; add operations and parameters
		initEClass(initiatorEClass, Initiator.class, "Initiator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(initiatorEClass, ecorePackage.getEBoolean(), "acceptsRequest", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInitiatorInfo(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(initiatorEClass, null, "initialize", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getInitiatorInfo(), "context", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getActionStepException());

		op = addEOperation(initiatorEClass, null, "beginProcessing", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getActionStepException());

		initEClass(initiatorInfoEClass, InitiatorInfo.class, "InitiatorInfo", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(inputTypeEEnum, InputType.class, "InputType");
		addEEnumLiteral(inputTypeEEnum, InputType.VALUE);
		addEEnumLiteral(inputTypeEEnum, InputType.VARIABLE);

		// Initialize data types
		initEDataType(actionStepExceptionEDataType, ActionStepException.class, "ActionStepException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
	}

} //InitiatorPackageImpl
