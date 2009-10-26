/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.workshop.model.actionpak1.Actionpak1Factory;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.ActionstepTest;
import com.safi.workshop.model.actionpak1.CustomInitiator;
import com.safi.workshop.model.actionpak1.IncomingCall2;
import com.safi.workshop.model.actionpak1.InvokeSaflet2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Actionpak1PackageImpl extends EPackageImpl implements Actionpak1Package {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass actionstepTestEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass customInitiatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass incomingCall2EClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invokeSaflet2EClass = null;

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
   * @see com.safi.workshop.model.actionpak1.Actionpak1Package#eNS_URI
   * @see #init()
   * @generated
   */
  private Actionpak1PackageImpl() {
    super(eNS_URI, Actionpak1Factory.eINSTANCE);
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
  public static Actionpak1Package init() {
    if (isInited) return (Actionpak1Package)EPackage.Registry.INSTANCE.getEPackage(Actionpak1Package.eNS_URI);

    // Obtain or create and register package
    Actionpak1PackageImpl theActionpak1Package = (Actionpak1PackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof Actionpak1PackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new Actionpak1PackageImpl());

    isInited = true;

    // Initialize simple dependencies
    AsteriskPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theActionpak1Package.createPackageContents();

    // Initialize created meta-data
    theActionpak1Package.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theActionpak1Package.freeze();

    return theActionpak1Package;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getActionstepTest() {
    return actionstepTestEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getActionstepTest_Message() {
    return (EReference)actionstepTestEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCustomInitiator() {
    return customInitiatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIncomingCall2() {
    return incomingCall2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIncomingCall2_CallName() {
    return (EAttribute)incomingCall2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvokeSaflet2() {
    return invokeSaflet2EClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvokeSaflet2_TargetSafletPath() {
    return (EReference)invokeSaflet2EClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInvokeSaflet2_LabelText() {
    return (EAttribute)invokeSaflet2EClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Actionpak1Factory getActionpak1Factory() {
    return (Actionpak1Factory)getEFactoryInstance();
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
    actionstepTestEClass = createEClass(ACTIONSTEP_TEST);
    createEReference(actionstepTestEClass, ACTIONSTEP_TEST__MESSAGE);

    customInitiatorEClass = createEClass(CUSTOM_INITIATOR);

    incomingCall2EClass = createEClass(INCOMING_CALL2);
    createEAttribute(incomingCall2EClass, INCOMING_CALL2__CALL_NAME);

    invokeSaflet2EClass = createEClass(INVOKE_SAFLET2);
    createEReference(invokeSaflet2EClass, INVOKE_SAFLET2__TARGET_SAFLET_PATH);
    createEAttribute(invokeSaflet2EClass, INVOKE_SAFLET2__LABEL_TEXT);
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
    AsteriskPackage theAsteriskPackage = (AsteriskPackage)EPackage.Registry.INSTANCE.getEPackage(AsteriskPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    actionstepTestEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
    customInitiatorEClass.getESuperTypes().add(theActionStepPackage.getParameterizedInitiator());
    incomingCall2EClass.getESuperTypes().add(theActionStepPackage.getParameterizedInitiator());
    incomingCall2EClass.getESuperTypes().add(theAsteriskPackage.getCallSource1());
    invokeSaflet2EClass.getESuperTypes().add(theActionStepPackage.getParameterizedActionstep());

    // Initialize classes and features; add operations and parameters
    initEClass(actionstepTestEClass, ActionstepTest.class, "ActionstepTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getActionstepTest_Message(), theActionStepPackage.getDynamicValue(), null, "message", null, 0, 1, ActionstepTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    initEClass(customInitiatorEClass, CustomInitiator.class, "CustomInitiator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(incomingCall2EClass, IncomingCall2.class, "IncomingCall2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIncomingCall2_CallName(), ecorePackage.getEString(), "callName", null, 0, 1, IncomingCall2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(invokeSaflet2EClass, InvokeSaflet2.class, "InvokeSaflet2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInvokeSaflet2_TargetSafletPath(), theActionStepPackage.getDynamicValue(), null, "targetSafletPath", null, 0, 1, InvokeSaflet2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    initEAttribute(getInvokeSaflet2_LabelText(), ecorePackage.getEString(), "labelText", null, 0, 1, InvokeSaflet2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // DynamicValueAnnotation
    createDynamicValueAnnotationAnnotations();
    // Required
    createRequiredAnnotations();
  }

  /**
   * Initializes the annotations for <b>DynamicValueAnnotation</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createDynamicValueAnnotationAnnotations() {
    String source = "DynamicValueAnnotation";		
    addAnnotation
      (getActionstepTest_Message(), 
       source, 
       new String[] {
       "type", "Saflet Path",
       "isTypeLocked", "false",
       "description", "The message to be logged",
       "expectedReturnType", "Saflet Path",
       "helperClass", ""
       });			
    addAnnotation
      (getInvokeSaflet2_TargetSafletPath(), 
       source, 
       new String[] {
       "type", "Saflet Path",
       "isTypeLocked", "false",
       "description", "The path of the handler to which control will be transferred",
       "expectedReturnType", "Saflet Path",
       "helperClass", "com.safi.workshop.sheet.SelectSafletDynamicValueEditorPage"
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
      (getActionstepTest_Message(), 
       source, 
       new String[] {
       "criteria", "non-null"
       });			
    addAnnotation
      (getInvokeSaflet2_TargetSafletPath(), 
       source, 
       new String[] {
       "criteria", "non-null"
       });
  }

} //Actionpak1PackageImpl
