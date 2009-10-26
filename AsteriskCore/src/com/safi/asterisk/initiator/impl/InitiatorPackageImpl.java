/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator.impl;

import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.manager.event.ManagerEvent;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.impl.ActionstepPackageImpl;
import com.safi.asterisk.impl.AsteriskPackageImpl;
import com.safi.asterisk.initiator.AsteriskInitiatorInfo;
import com.safi.asterisk.initiator.DIDMatcher;
import com.safi.asterisk.initiator.IncomingCall;
import com.safi.asterisk.initiator.InitiatorFactory;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.asterisk.saflet.SafletPackage;
import com.safi.asterisk.saflet.impl.SafletPackageImpl;
import com.safi.core.CorePackage;

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
  private EClass didMatcherEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass incomingCallEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asteriskInitiatorInfoEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EDataType managerEventEDataType = null;

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
   * @see com.safi.asterisk.initiator.InitiatorPackage#eNS_URI
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
   * Creates, registers, and initializes the <b>Package</b> for this
   * model, and for any others upon which it depends.  Simple
   * dependencies are satisfied by calling this method on all
   * dependent packages before doing anything else.  This method drives
   * initialization for interdependent packages directly, in parallel
   * with this package, itself.
   * <p>Of this package and its interdependencies, all packages which
   * have not yet been registered by their URI values are first created
   * and registered.  The packages are then initialized in two steps:
   * meta-model objects for all of the packages are created before any
   * are initialized, since one package's meta-model objects may refer to
   * those of another.
   * <p>Invocation of this method will not affect any packages that have
   * already been initialized.
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
    InitiatorPackageImpl theInitiatorPackage = (InitiatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof InitiatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new InitiatorPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    CorePackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    AsteriskPackageImpl theAsteriskPackage = (AsteriskPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AsteriskPackage.eNS_URI) instanceof AsteriskPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AsteriskPackage.eNS_URI) : AsteriskPackage.eINSTANCE);
    ActionstepPackageImpl theActionstepPackage = (ActionstepPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionstepPackage.eNS_URI) instanceof ActionstepPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionstepPackage.eNS_URI) : ActionstepPackage.eINSTANCE);
    SafletPackageImpl theSafletPackage = (SafletPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) instanceof SafletPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) : SafletPackage.eINSTANCE);

    // Create package meta-data objects
    theInitiatorPackage.createPackageContents();
    theAsteriskPackage.createPackageContents();
    theActionstepPackage.createPackageContents();
    theSafletPackage.createPackageContents();

    // Initialize created meta-data
    theInitiatorPackage.initializePackageContents();
    theAsteriskPackage.initializePackageContents();
    theActionstepPackage.initializePackageContents();
    theSafletPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theInitiatorPackage.freeze();

    return theInitiatorPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDIDMatcher() {
    return didMatcherEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDIDMatcher_DNISPattern() {
    return (EAttribute)didMatcherEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDIDMatcher_Call() {
    return (EReference)didMatcherEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDIDMatcher_CallName() {
    return (EAttribute)didMatcherEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIncomingCall() {
    return incomingCallEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIncomingCall_CallName() {
    return (EAttribute)incomingCallEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsteriskInitiatorInfo() {
    return asteriskInitiatorInfoEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsteriskInitiatorInfo_Channel() {
    return (EAttribute)asteriskInitiatorInfoEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsteriskInitiatorInfo_Request() {
    return (EAttribute)asteriskInitiatorInfoEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsteriskInitiatorInfo_ManagerConnection() {
    return (EAttribute)asteriskInitiatorInfoEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EDataType getManagerEvent() {
    return managerEventEDataType;
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
    didMatcherEClass = createEClass(DID_MATCHER);
    createEAttribute(didMatcherEClass, DID_MATCHER__DNIS_PATTERN);
    createEReference(didMatcherEClass, DID_MATCHER__CALL);
    createEAttribute(didMatcherEClass, DID_MATCHER__CALL_NAME);

    incomingCallEClass = createEClass(INCOMING_CALL);
    createEAttribute(incomingCallEClass, INCOMING_CALL__CALL_NAME);

    asteriskInitiatorInfoEClass = createEClass(ASTERISK_INITIATOR_INFO);
    createEAttribute(asteriskInitiatorInfoEClass, ASTERISK_INITIATOR_INFO__CHANNEL);
    createEAttribute(asteriskInitiatorInfoEClass, ASTERISK_INITIATOR_INFO__REQUEST);
    createEAttribute(asteriskInitiatorInfoEClass, ASTERISK_INITIATOR_INFO__MANAGER_CONNECTION);

    // Create data types
    managerEventEDataType = createEDataType(MANAGER_EVENT);
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
    com.safi.core.initiator.InitiatorPackage theInitiatorPackage_1 = (com.safi.core.initiator.InitiatorPackage)EPackage.Registry.INSTANCE.getEPackage(com.safi.core.initiator.InitiatorPackage.eNS_URI);
    AsteriskPackage theAsteriskPackage = (AsteriskPackage)EPackage.Registry.INSTANCE.getEPackage(AsteriskPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    didMatcherEClass.getESuperTypes().add(theInitiatorPackage_1.getInitiator());
    didMatcherEClass.getESuperTypes().add(theAsteriskPackage.getCallSource1());
    incomingCallEClass.getESuperTypes().add(theInitiatorPackage_1.getInitiator());
    incomingCallEClass.getESuperTypes().add(theAsteriskPackage.getCallSource1());
    asteriskInitiatorInfoEClass.getESuperTypes().add(theInitiatorPackage_1.getInitiatorInfo());

    // Initialize classes and features; add operations and parameters
    initEClass(didMatcherEClass, DIDMatcher.class, "DIDMatcher", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDIDMatcher_DNISPattern(), ecorePackage.getEString(), "dNISPattern", null, 0, 1, DIDMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEReference(getDIDMatcher_Call(), theAsteriskPackage.getCall(), null, "call", null, 0, 1, DIDMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getDIDMatcher_CallName(), ecorePackage.getEString(), "callName", "Call1", 0, 1, DIDMatcher.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(incomingCallEClass, IncomingCall.class, "IncomingCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIncomingCall_CallName(), ecorePackage.getEString(), "callName", "Call1", 0, 1, IncomingCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(asteriskInitiatorInfoEClass, AsteriskInitiatorInfo.class, "AsteriskInitiatorInfo", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAsteriskInitiatorInfo_Channel(), theAsteriskPackage.getAgiChannel(), "channel", null, 0, 1, AsteriskInitiatorInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAsteriskInitiatorInfo_Request(), theAsteriskPackage.getAgiRequest(), "request", null, 0, 1, AsteriskInitiatorInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAsteriskInitiatorInfo_ManagerConnection(), theAsteriskPackage.getManagerConnection(), "managerConnection", null, 0, 1, AsteriskInitiatorInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize data types
    initEDataType(managerEventEDataType, ManagerEvent.class, "ManagerEvent", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
  }

} //InitiatorPackageImpl
