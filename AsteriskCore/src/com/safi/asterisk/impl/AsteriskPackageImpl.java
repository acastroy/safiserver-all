/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.impl;

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.manager.ManagerConnection;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.safi.asterisk.AsteriskFactory;
import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallState;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.impl.ActionstepPackageImpl;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.asterisk.initiator.impl.InitiatorPackageImpl;
import com.safi.asterisk.saflet.SafletPackage;
import com.safi.asterisk.saflet.impl.SafletPackageImpl;
import com.safi.core.CorePackage;
import com.safi.core.call.CallPackage;
import com.safi.db.astdb.AstdbPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AsteriskPackageImpl extends EPackageImpl implements AsteriskPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass callEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum callStateEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType agiRequestEDataType = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType agiChannelEDataType = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType managerConnectionEDataType = null;

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
	 * @see com.safi.asterisk.AsteriskPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private AsteriskPackageImpl() {
		super(eNS_URI, AsteriskFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link AsteriskPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static AsteriskPackage init() {
		if (isInited) return (AsteriskPackage)EPackage.Registry.INSTANCE.getEPackage(AsteriskPackage.eNS_URI);

		// Obtain or create and register package
		AsteriskPackageImpl theAsteriskPackage = (AsteriskPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AsteriskPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AsteriskPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		AstdbPackage.eINSTANCE.eClass();
		CorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ActionstepPackageImpl theActionstepPackage = (ActionstepPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionstepPackage.eNS_URI) instanceof ActionstepPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionstepPackage.eNS_URI) : ActionstepPackage.eINSTANCE);
		InitiatorPackageImpl theInitiatorPackage = (InitiatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) instanceof InitiatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) : InitiatorPackage.eINSTANCE);
		SafletPackageImpl theSafletPackage = (SafletPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) instanceof SafletPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) : SafletPackage.eINSTANCE);

		// Create package meta-data objects
		theAsteriskPackage.createPackageContents();
		theActionstepPackage.createPackageContents();
		theInitiatorPackage.createPackageContents();
		theSafletPackage.createPackageContents();

		// Initialize created meta-data
		theAsteriskPackage.initializePackageContents();
		theActionstepPackage.initializePackageContents();
		theInitiatorPackage.initializePackageContents();
		theSafletPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAsteriskPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AsteriskPackage.eNS_URI, theAsteriskPackage);
		return theAsteriskPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getCall() {
		return callEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCall_Name() {
		return (EAttribute)callEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCall_Channel() {
		return (EAttribute)callEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCall_CallerIdName() {
		return (EAttribute)callEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCall_CallerIdNum() {
		return (EAttribute)callEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCall_UniqueId() {
		return (EAttribute)callEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCall_ChannelName() {
		return (EAttribute)callEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getCall_CallState() {
		return (EAttribute)callEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getCallState() {
		return callStateEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getAgiRequest() {
		return agiRequestEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getAgiChannel() {
		return agiChannelEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getManagerConnection() {
		return managerConnectionEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AsteriskFactory getAsteriskFactory() {
		return (AsteriskFactory)getEFactoryInstance();
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
		callEClass = createEClass(CALL);
		createEAttribute(callEClass, CALL__NAME);
		createEAttribute(callEClass, CALL__CHANNEL);
		createEAttribute(callEClass, CALL__CALLER_ID_NAME);
		createEAttribute(callEClass, CALL__CALLER_ID_NUM);
		createEAttribute(callEClass, CALL__UNIQUE_ID);
		createEAttribute(callEClass, CALL__CHANNEL_NAME);
		createEAttribute(callEClass, CALL__CALL_STATE);

		// Create enums
		callStateEEnum = createEEnum(CALL_STATE);

		// Create data types
		agiRequestEDataType = createEDataType(AGI_REQUEST);
		agiChannelEDataType = createEDataType(AGI_CHANNEL);
		managerConnectionEDataType = createEDataType(MANAGER_CONNECTION);
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
		ActionstepPackage theActionstepPackage = (ActionstepPackage)EPackage.Registry.INSTANCE.getEPackage(ActionstepPackage.eNS_URI);
		InitiatorPackage theInitiatorPackage = (InitiatorPackage)EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI);
		SafletPackage theSafletPackage = (SafletPackage)EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI);
		CallPackage theCallPackage = (CallPackage)EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theActionstepPackage);
		getESubpackages().add(theInitiatorPackage);
		getESubpackages().add(theSafletPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		callEClass.getESuperTypes().add(theCallPackage.getSafiCall());

		// Initialize classes and features; add operations and parameters
		initEClass(callEClass, Call.class, "Call", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCall_Name(), ecorePackage.getEString(), "name", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCall_Channel(), this.getAgiChannel(), "channel", null, 0, 1, Call.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCall_CallerIdName(), ecorePackage.getEString(), "callerIdName", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCall_CallerIdNum(), ecorePackage.getEString(), "callerIdNum", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCall_UniqueId(), ecorePackage.getEString(), "uniqueId", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCall_ChannelName(), ecorePackage.getEString(), "channelName", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCall_CallState(), this.getCallState(), "callState", null, 0, 1, Call.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(callEClass, null, "setData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(callEClass, ecorePackage.getEJavaObject(), "getData", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(callStateEEnum, CallState.class, "CallState");
		addEEnumLiteral(callStateEEnum, CallState.AVAILABLE);
		addEEnumLiteral(callStateEEnum, CallState.RESERVED);
		addEEnumLiteral(callStateEEnum, CallState.OFF_HOOK);
		addEEnumLiteral(callStateEEnum, CallState.DIALING);
		addEEnumLiteral(callStateEEnum, CallState.RINGING);
		addEEnumLiteral(callStateEEnum, CallState.RINGING_REMOTE);
		addEEnumLiteral(callStateEEnum, CallState.UP);
		addEEnumLiteral(callStateEEnum, CallState.BUSY);
		addEEnumLiteral(callStateEEnum, CallState.UNKNOWN);

		// Initialize data types
		initEDataType(agiRequestEDataType, AgiRequest.class, "AgiRequest", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(agiChannelEDataType, AgiChannel.class, "AgiChannel", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(managerConnectionEDataType, ManagerConnection.class, "ManagerConnection", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //AsteriskPackageImpl
