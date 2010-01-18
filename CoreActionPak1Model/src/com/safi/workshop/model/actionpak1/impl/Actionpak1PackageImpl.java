/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import com.safi.asterisk.AsteriskPackage;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.workshop.model.actionpak1.Actionpak1Factory;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.ActionstepTest;
import com.safi.workshop.model.actionpak1.CustomInitiator;
import com.safi.workshop.model.actionpak1.IncomingCall2;
import com.safi.workshop.model.actionpak1.InvokeSaflet2;
import com.safi.workshop.model.actionpak1.ManagerAction;
import com.safi.workshop.model.actionpak1.ManagerActionType;

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
	private EClass managerActionEClass = null;

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum managerActionTypeEEnum = null;

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
		AsteriskPackage.eINSTANCE.eClass();

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
	public EClass getManagerAction() {
		return managerActionEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getManagerAction_ManagerActionType() {
		return (EAttribute)managerActionEClass.getEStructuralFeatures().get(0);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getManagerAction_ManagerResponse() {
		return (EReference)managerActionEClass.getEStructuralFeatures().get(1);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getManagerActionType() {
		return managerActionTypeEEnum;
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

		managerActionEClass = createEClass(MANAGER_ACTION);
		createEAttribute(managerActionEClass, MANAGER_ACTION__MANAGER_ACTION_TYPE);
		createEReference(managerActionEClass, MANAGER_ACTION__MANAGER_RESPONSE);

		// Create enums
		managerActionTypeEEnum = createEEnum(MANAGER_ACTION_TYPE);
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
		managerActionEClass.getESuperTypes().add(theActionStepPackage.getParameterizedActionstep());

		// Initialize classes and features; add operations and parameters
		initEClass(actionstepTestEClass, ActionstepTest.class, "ActionstepTest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionstepTest_Message(), theActionStepPackage.getDynamicValue(), null, "message", null, 0, 1, ActionstepTest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(customInitiatorEClass, CustomInitiator.class, "CustomInitiator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(incomingCall2EClass, IncomingCall2.class, "IncomingCall2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIncomingCall2_CallName(), ecorePackage.getEString(), "callName", null, 0, 1, IncomingCall2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(invokeSaflet2EClass, InvokeSaflet2.class, "InvokeSaflet2", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInvokeSaflet2_TargetSafletPath(), theActionStepPackage.getDynamicValue(), null, "targetSafletPath", null, 0, 1, InvokeSaflet2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getInvokeSaflet2_LabelText(), ecorePackage.getEString(), "labelText", null, 0, 1, InvokeSaflet2.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(managerActionEClass, ManagerAction.class, "ManagerAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getManagerAction_ManagerActionType(), this.getManagerActionType(), "managerActionType", null, 0, 1, ManagerAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getManagerAction_ManagerResponse(), theActionStepPackage.getDynamicValue(), null, "managerResponse", null, 0, 1, ManagerAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(managerActionTypeEEnum, ManagerActionType.class, "ManagerActionType");
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.ABSOLUTE_TIMEOUT_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.AGENT_CALLBACK_LOGIN_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.AGENT_LOGOFF_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.AGENTS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.AGI_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.ATXFER_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.BRIDGE_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.CHALLENGE_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.CHANGE_MONITOR_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.COMMAND_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.CORE_SETTINGS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.CORE_SHOW_CHANNELS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.CORE_STATUS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.DB_DEL_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.DB_DEL_TREE_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.DB_GET_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.DB_PUT_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.EVENTS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.EXTENSION_STATE_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.GET_CONFIG_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.GET_VAR_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.HANGUP_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.IAX_PEER_LIST_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.JABBER_SEND_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.LIST_COMMANDS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.LOGIN_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.LOGOFF_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.MAILBOX_COUNT_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.MAILBOX_STATUS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.MEET_ME_MUTE_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.MEET_ME_UNMUTE_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.MODULE_CHECK_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.MODULE_LOAD_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.MONITOR_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.ORIGINATE_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.PARK_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.PARKED_CALLS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.PAUSE_MONITOR_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.PING_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.PLAY_DTMF_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.QUEUE_ADD_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.QUEUE_LOG_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.QUEUE_PAUSE_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.QUEUE_PENALTY_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.QUEUE_REMOVE_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.QUEUE_RESET_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.QUEUE_STATUS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.QUEUE_SUMMARY_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.REDIRECT_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.SEND_TEXT_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.SET_CDR_USER_FIELD_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.SET_VAR_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.SHOW_DIALPLAN_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.SIP_NOTIFY_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.SIP_PEERS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.SIP_SHOW_PEER_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.SIP_SHOW_REGISTRY_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.STATUS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.STOP_MONITOR_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.UNPAUSE_MONITOR_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.UPDATE_CONFIG_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.USER_EVENT_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.VOICEMAIL_USERS_LIST_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.ZAP_DIAL_OFFHOOK_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.ZAP_DND_OFF_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.ZAP_DND_ON_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.ZAP_HANGUP_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.ZAP_RESTART_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.ZAP_SHOW_CHANNELS_ACTION);
		addEEnumLiteral(managerActionTypeEEnum, ManagerActionType.ZAP_TRANSFER_ACTION);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// DynamicValueAnnotation
		createDynamicValueAnnotationAnnotations();
		// Required
		createRequiredAnnotations();
		// Directionality
		createDirectionalityAnnotations();
		// MetaProperty
		createMetaPropertyAnnotations();
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
		  (getManagerAction_ManagerResponse(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The assignee variable",
			 "expectedReturnType", "Object",
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
		  (getManagerAction_ManagerResponse(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });	
	}

		/**
	 * Initializes the annotations for <b>MetaProperty</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createMetaPropertyAnnotations() {
		String source = "MetaProperty";								
		addAnnotation
		  (getManagerAction_ManagerResponse(), 
		   source, 
		   new String[] {
			 "displayText", "Variable"
		   });
	}

} //Actionpak1PackageImpl
