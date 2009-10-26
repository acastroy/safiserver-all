/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.saflet.impl;

import com.safi.asterisk.AsteriskPackage;

import com.safi.asterisk.actionstep.ActionstepPackage;

import com.safi.asterisk.actionstep.impl.ActionstepPackageImpl;

import com.safi.asterisk.impl.AsteriskPackageImpl;

import com.safi.asterisk.initiator.InitiatorPackage;

import com.safi.asterisk.initiator.impl.InitiatorPackageImpl;

import com.safi.asterisk.saflet.AsteriskSaflet;
import com.safi.asterisk.saflet.AsteriskSafletContext;
import com.safi.asterisk.saflet.AsteriskSafletEnvironment;
import com.safi.asterisk.saflet.SafletFactory;
import com.safi.asterisk.saflet.SafletPackage;

import com.safi.core.CorePackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

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
  private EClass asteriskSafletEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asteriskSafletContextEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass asteriskSafletEnvironmentEClass = null;

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
   * @see com.safi.asterisk.saflet.SafletPackage#eNS_URI
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
  public static SafletPackage init() {
    if (isInited) return (SafletPackage)EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI);

    // Obtain or create and register package
    SafletPackageImpl theSafletPackage = (SafletPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SafletPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SafletPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    CorePackage.eINSTANCE.eClass();

    // Obtain or create and register interdependencies
    AsteriskPackageImpl theAsteriskPackage = (AsteriskPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AsteriskPackage.eNS_URI) instanceof AsteriskPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AsteriskPackage.eNS_URI) : AsteriskPackage.eINSTANCE);
    ActionstepPackageImpl theActionstepPackage = (ActionstepPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActionstepPackage.eNS_URI) instanceof ActionstepPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActionstepPackage.eNS_URI) : ActionstepPackage.eINSTANCE);
    InitiatorPackageImpl theInitiatorPackage = (InitiatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) instanceof InitiatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) : InitiatorPackage.eINSTANCE);

    // Create package meta-data objects
    theSafletPackage.createPackageContents();
    theAsteriskPackage.createPackageContents();
    theActionstepPackage.createPackageContents();
    theInitiatorPackage.createPackageContents();

    // Initialize created meta-data
    theSafletPackage.initializePackageContents();
    theAsteriskPackage.initializePackageContents();
    theActionstepPackage.initializePackageContents();
    theInitiatorPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theSafletPackage.freeze();

    return theSafletPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsteriskSaflet() {
    return asteriskSafletEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsteriskSafletContext() {
    return asteriskSafletContextEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsteriskSafletContext_BufferedDigits() {
    return (EAttribute)asteriskSafletContextEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAsteriskSafletEnvironment() {
    return asteriskSafletEnvironmentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsteriskSafletEnvironment_ServerIpAddr() {
    return (EAttribute)asteriskSafletEnvironmentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsteriskSafletEnvironment_FastAgiPort() {
    return (EAttribute)asteriskSafletEnvironmentEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAsteriskSafletEnvironment_ManagementPort() {
    return (EAttribute)asteriskSafletEnvironmentEClass.getEStructuralFeatures().get(2);
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
    asteriskSafletEClass = createEClass(ASTERISK_SAFLET);

    asteriskSafletContextEClass = createEClass(ASTERISK_SAFLET_CONTEXT);
    createEAttribute(asteriskSafletContextEClass, ASTERISK_SAFLET_CONTEXT__BUFFERED_DIGITS);

    asteriskSafletEnvironmentEClass = createEClass(ASTERISK_SAFLET_ENVIRONMENT);
    createEAttribute(asteriskSafletEnvironmentEClass, ASTERISK_SAFLET_ENVIRONMENT__SERVER_IP_ADDR);
    createEAttribute(asteriskSafletEnvironmentEClass, ASTERISK_SAFLET_ENVIRONMENT__FAST_AGI_PORT);
    createEAttribute(asteriskSafletEnvironmentEClass, ASTERISK_SAFLET_ENVIRONMENT__MANAGEMENT_PORT);
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
    com.safi.core.saflet.SafletPackage theSafletPackage_1 = (com.safi.core.saflet.SafletPackage)EPackage.Registry.INSTANCE.getEPackage(com.safi.core.saflet.SafletPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    asteriskSafletEClass.getESuperTypes().add(theSafletPackage_1.getSaflet());
    asteriskSafletContextEClass.getESuperTypes().add(theSafletPackage_1.getSafletContext());
    asteriskSafletEnvironmentEClass.getESuperTypes().add(theSafletPackage_1.getSafletEnvironment());

    // Initialize classes and features; add operations and parameters
    initEClass(asteriskSafletEClass, AsteriskSaflet.class, "AsteriskSaflet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(asteriskSafletContextEClass, AsteriskSafletContext.class, "AsteriskSafletContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAsteriskSafletContext_BufferedDigits(), ecorePackage.getEString(), "bufferedDigits", null, 0, 1, AsteriskSafletContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    EOperation op = addEOperation(asteriskSafletContextEClass, null, "appendBufferedDigits", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "digits", 0, 1, IS_UNIQUE, IS_ORDERED);

    addEOperation(asteriskSafletContextEClass, ecorePackage.getEString(), "flushBufferedDigits", 0, 1, IS_UNIQUE, IS_ORDERED);

    initEClass(asteriskSafletEnvironmentEClass, AsteriskSafletEnvironment.class, "AsteriskSafletEnvironment", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAsteriskSafletEnvironment_ServerIpAddr(), ecorePackage.getEString(), "serverIpAddr", null, 0, 1, AsteriskSafletEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAsteriskSafletEnvironment_FastAgiPort(), ecorePackage.getEInt(), "fastAgiPort", null, 0, 1, AsteriskSafletEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAsteriskSafletEnvironment_ManagementPort(), ecorePackage.getEInt(), "managementPort", null, 0, 1, AsteriskSafletEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    op = addEOperation(asteriskSafletEnvironmentEClass, ecorePackage.getEJavaObject(), "getLoopbackCall", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "uuid", 0, 1, IS_UNIQUE, IS_ORDERED);

    op = addEOperation(asteriskSafletEnvironmentEClass, ecorePackage.getEJavaObject(), "getLoopbackLock", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, ecorePackage.getEString(), "uuid", 0, 1, IS_UNIQUE, IS_ORDERED);
  }

} //SafletPackageImpl
