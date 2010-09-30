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

import com.safi.core.CorePackage;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.call.CallPackage;
import com.safi.workshop.model.actionpak1.Actionpak1Factory;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.ActionstepTest;
import com.safi.workshop.model.actionpak1.CustomInitiator;
import com.safi.workshop.model.actionpak1.IncomingCall2;
import com.safi.workshop.model.actionpak1.InvokeSaflet2;
import com.safi.workshop.model.actionpak1.ScheduleSaflet;
import com.safi.workshop.model.actionpak1.UnscheduleSaflet;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass scheduleSafletEClass = null;

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unscheduleSafletEClass = null;

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
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link Actionpak1Package#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
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
		Actionpak1PackageImpl theActionpak1Package = (Actionpak1PackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Actionpak1PackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Actionpak1PackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theActionpak1Package.createPackageContents();

		// Initialize created meta-data
		theActionpak1Package.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActionpak1Package.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Actionpak1Package.eNS_URI, theActionpak1Package);
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
	public EClass getScheduleSaflet() {
		return scheduleSafletEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduleSaflet_JobNamePrefix() {
		return (EReference)scheduleSafletEClass.getEStructuralFeatures().get(0);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduleSaflet_JobName() {
		return (EReference)scheduleSafletEClass.getEStructuralFeatures().get(6);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnscheduleSaflet() {
		return unscheduleSafletEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnscheduleSaflet_JobName() {
		return (EReference)unscheduleSafletEClass.getEStructuralFeatures().get(0);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduleSaflet_TargetSafletPath() {
		return (EReference)scheduleSafletEClass.getEStructuralFeatures().get(1);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduleSaflet_CronExpression() {
		return (EReference)scheduleSafletEClass.getEStructuralFeatures().get(2);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduleSaflet_StartDateTime() {
		return (EReference)scheduleSafletEClass.getEStructuralFeatures().get(3);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduleSaflet_EndDateTime() {
		return (EReference)scheduleSafletEClass.getEStructuralFeatures().get(4);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScheduleSaflet_CalendarName() {
		return (EReference)scheduleSafletEClass.getEStructuralFeatures().get(5);
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

		scheduleSafletEClass = createEClass(SCHEDULE_SAFLET);
		createEReference(scheduleSafletEClass, SCHEDULE_SAFLET__JOB_NAME_PREFIX);
		createEReference(scheduleSafletEClass, SCHEDULE_SAFLET__TARGET_SAFLET_PATH);
		createEReference(scheduleSafletEClass, SCHEDULE_SAFLET__CRON_EXPRESSION);
		createEReference(scheduleSafletEClass, SCHEDULE_SAFLET__START_DATE_TIME);
		createEReference(scheduleSafletEClass, SCHEDULE_SAFLET__END_DATE_TIME);
		createEReference(scheduleSafletEClass, SCHEDULE_SAFLET__CALENDAR_NAME);
		createEReference(scheduleSafletEClass, SCHEDULE_SAFLET__JOB_NAME);

		unscheduleSafletEClass = createEClass(UNSCHEDULE_SAFLET);
		createEReference(unscheduleSafletEClass, UNSCHEDULE_SAFLET__JOB_NAME);
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
		CallPackage theCallPackage = (CallPackage)EPackage.Registry.INSTANCE.getEPackage(CallPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		actionstepTestEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		customInitiatorEClass.getESuperTypes().add(theActionStepPackage.getParameterizedInitiator());
		incomingCall2EClass.getESuperTypes().add(theActionStepPackage.getParameterizedInitiator());
		incomingCall2EClass.getESuperTypes().add(theCallPackage.getCallSource1());
		invokeSaflet2EClass.getESuperTypes().add(theActionStepPackage.getParameterizedActionstep());
		scheduleSafletEClass.getESuperTypes().add(theActionStepPackage.getParameterizedActionstep());
		unscheduleSafletEClass.getESuperTypes().add(theActionStepPackage.getActionStep());

		// Initialize classes and features; add operations and parameters
		initEClass(actionstepTestEClass, ActionstepTest.class, "ActionstepTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionstepTest_Message(), theActionStepPackage.getDynamicValue(), null, "message", null, 0, 1, ActionstepTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(customInitiatorEClass, CustomInitiator.class, "CustomInitiator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(incomingCall2EClass, IncomingCall2.class, "IncomingCall2", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIncomingCall2_CallName(), ecorePackage.getEString(), "callName", null, 0, 1, IncomingCall2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invokeSaflet2EClass, InvokeSaflet2.class, "InvokeSaflet2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInvokeSaflet2_TargetSafletPath(), theActionStepPackage.getDynamicValue(), null, "targetSafletPath", null, 0, 1, InvokeSaflet2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInvokeSaflet2_LabelText(), ecorePackage.getEString(), "labelText", null, 0, 1, InvokeSaflet2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(scheduleSafletEClass, ScheduleSaflet.class, "ScheduleSaflet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getScheduleSaflet_JobNamePrefix(), theActionStepPackage.getDynamicValue(), null, "jobNamePrefix", null, 0, 1, ScheduleSaflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScheduleSaflet_TargetSafletPath(), theActionStepPackage.getDynamicValue(), null, "targetSafletPath", null, 0, 1, ScheduleSaflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScheduleSaflet_CronExpression(), theActionStepPackage.getDynamicValue(), null, "cronExpression", null, 0, 1, ScheduleSaflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScheduleSaflet_StartDateTime(), theActionStepPackage.getDynamicValue(), null, "startDateTime", null, 0, 1, ScheduleSaflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScheduleSaflet_EndDateTime(), theActionStepPackage.getDynamicValue(), null, "endDateTime", null, 0, 1, ScheduleSaflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScheduleSaflet_CalendarName(), theActionStepPackage.getDynamicValue(), null, "calendarName", null, 0, 1, ScheduleSaflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScheduleSaflet_JobName(), theActionStepPackage.getDynamicValue(), null, "jobName", null, 0, 1, ScheduleSaflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(unscheduleSafletEClass, UnscheduleSaflet.class, "UnscheduleSaflet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnscheduleSaflet_JobName(), theActionStepPackage.getDynamicValue(), null, "jobName", null, 0, 1, UnscheduleSaflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// DynamicValueAnnotation
		createDynamicValueAnnotationAnnotations();
		// Required
		createRequiredAnnotations();
		// Directionality
		createDirectionalityAnnotations();
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
		addAnnotation
		  (getScheduleSaflet_JobNamePrefix(), 
		   source, 
		   new String[] {
			 "type", "Text",
			 "isTypeLocked", "false",
			 "description", "Optional (unique) name to be assigned to the job ",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getScheduleSaflet_TargetSafletPath(), 
		   source, 
		   new String[] {
			 "type", "Saflet Path",
			 "isTypeLocked", "false",
			 "description", "The path of the handler to which control will be transferred",
			 "expectedReturnType", "Saflet Path",
			 "helperClass", "com.safi.workshop.sheet.SelectSafletDynamicValueEditorPage"
		   });			
		addAnnotation
		  (getScheduleSaflet_CronExpression(), 
		   source, 
		   new String[] {
			 "type", "Text",
			 "isTypeLocked", "false",
			 "description", "Cron expression defining the saflet execution schedule",
			 "expectedReturnType", "Crontab Expr",
			 "helperClass", "com.safi.workshop.sheet.ScheduledSafletDynamicValueEditorPage"
		   });		
		addAnnotation
		  (getScheduleSaflet_StartDateTime(), 
		   source, 
		   new String[] {
			 "type", "DateTime",
			 "isTypeLocked", "false",
			 "description", "Start DateTime for the the saflet execution schedule",
			 "expectedReturnType", "VariableName",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getScheduleSaflet_EndDateTime(), 
		   source, 
		   new String[] {
			 "type", "DateTime",
			 "isTypeLocked", "false",
			 "description", "End DateTime for the the saflet execution schedule",
			 "expectedReturnType", "VariableName",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getScheduleSaflet_CalendarName(), 
		   source, 
		   new String[] {
			 "type", "Text",
			 "isTypeLocked", "false",
			 "description", "Calendar name for the saflet execution schedule",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getScheduleSaflet_JobName(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The unique name of the job that was created",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getUnscheduleSaflet_JobName(), 
		   source, 
		   new String[] {
			 "type", "Text",
			 "isTypeLocked", "false",
			 "description", "Name of the job to be unscheduled",
			 "expectedReturnType", "VariableName",
			 "helperClass", ""
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
		addAnnotation
		  (getScheduleSaflet_TargetSafletPath(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });									
		addAnnotation
		  (getUnscheduleSaflet_JobName(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });
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
		  (getScheduleSaflet_JobName(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });		
	}

} //Actionpak1PackageImpl
