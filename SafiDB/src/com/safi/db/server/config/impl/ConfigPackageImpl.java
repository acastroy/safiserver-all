/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigPackageImpl.java,v 1.21 2008/12/05 06:09:05 zacw Exp $
 */
package com.safi.db.server.config.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.safi.db.DbPackage;
import com.safi.db.impl.DbPackageImpl;
import com.safi.db.server.config.ConfigFactory;
import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.Entitlement;
import com.safi.db.server.config.Prompt;
import com.safi.db.server.config.Role;
import com.safi.db.server.config.SFTPInfo;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.Saflet;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.db.server.config.SynchMode;
import com.safi.db.server.config.TelephonySubsystem;
import com.safi.db.server.config.User;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigPackageImpl extends EPackageImpl implements ConfigPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass serverResourceEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass safiServerEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass roleEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass entitlementEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass userEClass = null;

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
  private EClass safletProjectEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass promptEClass = null;

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sftpInfoEClass = null;

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass telephonySubsystemEClass = null;

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum synchModeEEnum = null;

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
	 * @see com.safi.db.server.config.ConfigPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private ConfigPackageImpl() {
		super(eNS_URI, ConfigFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ConfigPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static ConfigPackage init() {
		if (isInited) return (ConfigPackage)EPackage.Registry.INSTANCE.getEPackage(ConfigPackage.eNS_URI);

		// Obtain or create and register package
		ConfigPackageImpl theConfigPackage = (ConfigPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConfigPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConfigPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DbPackageImpl theDbPackage = (DbPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DbPackage.eNS_URI) instanceof DbPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DbPackage.eNS_URI) : DbPackage.eINSTANCE);

		// Create package meta-data objects
		theConfigPackage.createPackageContents();
		theDbPackage.createPackageContents();

		// Initialize created meta-data
		theConfigPackage.initializePackageContents();
		theDbPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConfigPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConfigPackage.eNS_URI, theConfigPackage);
		return theConfigPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getServerResource() {
		return serverResourceEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getServerResource_Name() {
		return (EAttribute)serverResourceEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getServerResource_LastModified() {
		return (EAttribute)serverResourceEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getServerResource_LastUpdated() {
		return (EAttribute)serverResourceEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getServerResource_Id() {
		return (EAttribute)serverResourceEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getServerResource_CreatedBy() {
		return (EReference)serverResourceEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getServerResource_ModifiedBy() {
		return (EReference)serverResourceEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getServerResource_Description() {
		return (EAttribute)serverResourceEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSafiServer() {
		return safiServerEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafiServer_BindIP() {
		return (EAttribute)safiServerEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafiServer_ManagementPort() {
		return (EAttribute)safiServerEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafiServer_User() {
		return (EReference)safiServerEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafiServer_Users() {
		return (EReference)safiServerEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafiServer_Running() {
		return (EAttribute)safiServerEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafiServer_Debug() {
		return (EAttribute)safiServerEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafiServer_DbPort() {
		return (EAttribute)safiServerEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getRole() {
		return roleEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getRole_Entitlements() {
		return (EReference)roleEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getEntitlement() {
		return entitlementEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getUser() {
		return userEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getUser_Firstname() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getUser_Lastname() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getUser_Roles() {
		return (EReference)userEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getUser_Password() {
		return (EAttribute)userEClass.getEStructuralFeatures().get(3);
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
  public EAttribute getSaflet_Code() {
		return (EAttribute)safletEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSaflet_Project() {
		return (EReference)safletEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSaflet_SubsystemId() {
		return (EAttribute)safletEClass.getEStructuralFeatures().get(2);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSafletProject() {
		return safletProjectEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafletProject_Saflets() {
		return (EReference)safletProjectEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSafletProject_Enabled() {
		return (EAttribute)safletProjectEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSafletProject_Prompts() {
		return (EReference)safletProjectEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPrompt() {
		return promptEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPrompt_Project() {
		return (EReference)promptEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getPrompt_System() {
		return (EAttribute)promptEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getPrompt_Extension() {
		return (EAttribute)promptEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSFTPInfo() {
		return sftpInfoEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSFTPInfo_SftpUser() {
		return (EAttribute)sftpInfoEClass.getEStructuralFeatures().get(0);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSFTPInfo_SftpPassword() {
		return (EAttribute)sftpInfoEClass.getEStructuralFeatures().get(1);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSFTPInfo_SftpPort() {
		return (EAttribute)sftpInfoEClass.getEStructuralFeatures().get(2);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTelephonySubsystem() {
		return telephonySubsystemEClass;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelephonySubsystem_Hostname() {
		return (EAttribute)telephonySubsystemEClass.getEStructuralFeatures().get(0);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelephonySubsystem_Running() {
		return (EAttribute)telephonySubsystemEClass.getEStructuralFeatures().get(1);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTelephonySubsystem_SafiServer() {
		return (EReference)telephonySubsystemEClass.getEStructuralFeatures().get(2);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelephonySubsystem_Private() {
		return (EAttribute)telephonySubsystemEClass.getEStructuralFeatures().get(3);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelephonySubsystem_VisibleSafiServerIP() {
		return (EAttribute)telephonySubsystemEClass.getEStructuralFeatures().get(4);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelephonySubsystem_Enabled() {
		return (EAttribute)telephonySubsystemEClass.getEStructuralFeatures().get(5);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelephonySubsystem_ManagerName() {
		return (EAttribute)telephonySubsystemEClass.getEStructuralFeatures().get(6);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelephonySubsystem_ManagerPassword() {
		return (EAttribute)telephonySubsystemEClass.getEStructuralFeatures().get(7);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelephonySubsystem_ManagerPort() {
		return (EAttribute)telephonySubsystemEClass.getEStructuralFeatures().get(8);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelephonySubsystem_VersionId() {
		return (EAttribute)telephonySubsystemEClass.getEStructuralFeatures().get(9);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelephonySubsystem_PromptDirectory() {
		return (EAttribute)telephonySubsystemEClass.getEStructuralFeatures().get(10);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTelephonySubsystem_PlatformId() {
		return (EAttribute)telephonySubsystemEClass.getEStructuralFeatures().get(11);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getSynchMode() {
		return synchModeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConfigFactory getConfigFactory() {
		return (ConfigFactory)getEFactoryInstance();
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
		serverResourceEClass = createEClass(SERVER_RESOURCE);
		createEAttribute(serverResourceEClass, SERVER_RESOURCE__NAME);
		createEAttribute(serverResourceEClass, SERVER_RESOURCE__LAST_MODIFIED);
		createEAttribute(serverResourceEClass, SERVER_RESOURCE__LAST_UPDATED);
		createEAttribute(serverResourceEClass, SERVER_RESOURCE__ID);
		createEReference(serverResourceEClass, SERVER_RESOURCE__CREATED_BY);
		createEReference(serverResourceEClass, SERVER_RESOURCE__MODIFIED_BY);
		createEAttribute(serverResourceEClass, SERVER_RESOURCE__DESCRIPTION);

		safiServerEClass = createEClass(SAFI_SERVER);
		createEAttribute(safiServerEClass, SAFI_SERVER__BIND_IP);
		createEAttribute(safiServerEClass, SAFI_SERVER__MANAGEMENT_PORT);
		createEReference(safiServerEClass, SAFI_SERVER__USER);
		createEReference(safiServerEClass, SAFI_SERVER__USERS);
		createEAttribute(safiServerEClass, SAFI_SERVER__RUNNING);
		createEAttribute(safiServerEClass, SAFI_SERVER__DEBUG);
		createEAttribute(safiServerEClass, SAFI_SERVER__DB_PORT);

		roleEClass = createEClass(ROLE);
		createEReference(roleEClass, ROLE__ENTITLEMENTS);

		entitlementEClass = createEClass(ENTITLEMENT);

		userEClass = createEClass(USER);
		createEAttribute(userEClass, USER__FIRSTNAME);
		createEAttribute(userEClass, USER__LASTNAME);
		createEReference(userEClass, USER__ROLES);
		createEAttribute(userEClass, USER__PASSWORD);

		safletEClass = createEClass(SAFLET);
		createEAttribute(safletEClass, SAFLET__CODE);
		createEReference(safletEClass, SAFLET__PROJECT);
		createEAttribute(safletEClass, SAFLET__SUBSYSTEM_ID);

		safletProjectEClass = createEClass(SAFLET_PROJECT);
		createEReference(safletProjectEClass, SAFLET_PROJECT__SAFLETS);
		createEAttribute(safletProjectEClass, SAFLET_PROJECT__ENABLED);
		createEReference(safletProjectEClass, SAFLET_PROJECT__PROMPTS);

		promptEClass = createEClass(PROMPT);
		createEReference(promptEClass, PROMPT__PROJECT);
		createEAttribute(promptEClass, PROMPT__SYSTEM);
		createEAttribute(promptEClass, PROMPT__EXTENSION);

		sftpInfoEClass = createEClass(SFTP_INFO);
		createEAttribute(sftpInfoEClass, SFTP_INFO__SFTP_USER);
		createEAttribute(sftpInfoEClass, SFTP_INFO__SFTP_PASSWORD);
		createEAttribute(sftpInfoEClass, SFTP_INFO__SFTP_PORT);

		telephonySubsystemEClass = createEClass(TELEPHONY_SUBSYSTEM);
		createEAttribute(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__HOSTNAME);
		createEAttribute(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__RUNNING);
		createEReference(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__SAFI_SERVER);
		createEAttribute(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__PRIVATE);
		createEAttribute(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__VISIBLE_SAFI_SERVER_IP);
		createEAttribute(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__ENABLED);
		createEAttribute(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__MANAGER_NAME);
		createEAttribute(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__MANAGER_PASSWORD);
		createEAttribute(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__MANAGER_PORT);
		createEAttribute(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__VERSION_ID);
		createEAttribute(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__PROMPT_DIRECTORY);
		createEAttribute(telephonySubsystemEClass, TELEPHONY_SUBSYSTEM__PLATFORM_ID);

		// Create enums
		synchModeEEnum = createEEnum(SYNCH_MODE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		safiServerEClass.getESuperTypes().add(this.getServerResource());
		roleEClass.getESuperTypes().add(this.getServerResource());
		entitlementEClass.getESuperTypes().add(this.getServerResource());
		userEClass.getESuperTypes().add(this.getServerResource());
		safletEClass.getESuperTypes().add(this.getServerResource());
		safletProjectEClass.getESuperTypes().add(this.getServerResource());
		promptEClass.getESuperTypes().add(this.getServerResource());
		telephonySubsystemEClass.getESuperTypes().add(this.getServerResource());

		// Initialize classes and features; add operations and parameters
		initEClass(serverResourceEClass, ServerResource.class, "ServerResource", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServerResource_Name(), ecorePackage.getEString(), "name", null, 1, 1, ServerResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerResource_LastModified(), ecorePackage.getEDate(), "lastModified", null, 0, 1, ServerResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerResource_LastUpdated(), ecorePackage.getEDate(), "lastUpdated", null, 0, 1, ServerResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerResource_Id(), ecorePackage.getEInt(), "id", "-1", 0, 1, ServerResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServerResource_CreatedBy(), this.getUser(), null, "createdBy", null, 0, 1, ServerResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getServerResource_ModifiedBy(), this.getUser(), null, "modifiedBy", null, 0, 1, ServerResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getServerResource_Description(), ecorePackage.getEString(), "description", null, 0, 1, ServerResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(safiServerEClass, SafiServer.class, "SafiServer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSafiServer_BindIP(), ecorePackage.getEString(), "bindIP", null, 0, 1, SafiServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafiServer_ManagementPort(), ecorePackage.getEInt(), "managementPort", "7020", 0, 1, SafiServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafiServer_User(), this.getUser(), null, "user", null, 0, 1, SafiServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafiServer_Users(), this.getUser(), null, "users", null, 0, -1, SafiServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafiServer_Running(), ecorePackage.getEBoolean(), "running", null, 0, 1, SafiServer.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafiServer_Debug(), ecorePackage.getEBoolean(), "debug", null, 0, 1, SafiServer.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafiServer_DbPort(), ecorePackage.getEInt(), "dbPort", "7021", 0, 1, SafiServer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(roleEClass, Role.class, "Role", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRole_Entitlements(), this.getEntitlement(), null, "entitlements", null, 0, -1, Role.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(entitlementEClass, Entitlement.class, "Entitlement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUser_Firstname(), ecorePackage.getEString(), "firstname", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Lastname(), ecorePackage.getEString(), "lastname", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getUser_Roles(), this.getRole(), null, "roles", null, 0, -1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUser_Password(), ecorePackage.getEString(), "password", null, 0, 1, User.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(safletEClass, Saflet.class, "Saflet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSaflet_Code(), ecorePackage.getEByteArray(), "code", null, 0, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSaflet_Project(), this.getSafletProject(), this.getSafletProject_Saflets(), "project", null, 0, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSaflet_SubsystemId(), ecorePackage.getEString(), "subsystemId", "", 0, 1, Saflet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(safletProjectEClass, SafletProject.class, "SafletProject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSafletProject_Saflets(), this.getSaflet(), this.getSaflet_Project(), "saflets", null, 0, -1, SafletProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSafletProject_Enabled(), ecorePackage.getEBoolean(), "enabled", null, 0, 1, SafletProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSafletProject_Prompts(), this.getPrompt(), this.getPrompt_Project(), "prompts", null, 0, -1, SafletProject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(promptEClass, Prompt.class, "Prompt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPrompt_Project(), this.getSafletProject(), this.getSafletProject_Prompts(), "project", null, 0, 1, Prompt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrompt_System(), ecorePackage.getEBoolean(), "system", null, 0, 1, Prompt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPrompt_Extension(), ecorePackage.getEString(), "extension", null, 0, 1, Prompt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sftpInfoEClass, SFTPInfo.class, "SFTPInfo", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSFTPInfo_SftpUser(), ecorePackage.getEString(), "sftpUser", null, 0, 1, SFTPInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSFTPInfo_SftpPassword(), ecorePackage.getEString(), "sftpPassword", null, 0, 1, SFTPInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSFTPInfo_SftpPort(), ecorePackage.getEInt(), "sftpPort", null, 0, 1, SFTPInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(telephonySubsystemEClass, TelephonySubsystem.class, "TelephonySubsystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTelephonySubsystem_Hostname(), ecorePackage.getEString(), "hostname", null, 1, 1, TelephonySubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelephonySubsystem_Running(), ecorePackage.getEBoolean(), "running", null, 0, 1, TelephonySubsystem.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTelephonySubsystem_SafiServer(), this.getSafiServer(), null, "safiServer", null, 0, 1, TelephonySubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelephonySubsystem_Private(), ecorePackage.getEBoolean(), "private", null, 0, 1, TelephonySubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelephonySubsystem_VisibleSafiServerIP(), ecorePackage.getEString(), "visibleSafiServerIP", null, 0, 1, TelephonySubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelephonySubsystem_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1, TelephonySubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelephonySubsystem_ManagerName(), ecorePackage.getEString(), "managerName", null, 0, 1, TelephonySubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelephonySubsystem_ManagerPassword(), ecorePackage.getEString(), "managerPassword", null, 0, 1, TelephonySubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelephonySubsystem_ManagerPort(), ecorePackage.getEInt(), "managerPort", "5038", 0, 1, TelephonySubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelephonySubsystem_VersionId(), ecorePackage.getEString(), "versionId", null, 0, 1, TelephonySubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelephonySubsystem_PromptDirectory(), ecorePackage.getEString(), "promptDirectory", "/var/lib/asterisk/sounds/", 0, 1, TelephonySubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTelephonySubsystem_PlatformId(), ecorePackage.getEString(), "platformId", "", 0, 1, TelephonySubsystem.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(synchModeEEnum, SynchMode.class, "SynchMode");
		addEEnumLiteral(synchModeEEnum, SynchMode.READ_ONLY);
		addEEnumLiteral(synchModeEEnum, SynchMode.SYNCH);

		// Create annotations
		// teneo.jpa
		createTeneoAnnotations();
	}

  /**
	 * Initializes the annotations for <b>teneo.jpa</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createTeneoAnnotations() {
		String source = "teneo.jpa";		
		addAnnotation
		  (getServerResource_Id(), 
		   source, 
		   new String[] {
			 "appinfo", "@GeneratedValue(strategy=\"TABLE\")"
		   });		
		addAnnotation
		  (getSafiServer_Users(), 
		   source, 
		   new String[] {
			 "appinfo", "@OneToMany(fetch=\"EAGER\" indexed=\"false\" cascade=\"ALL\")"
		   });		
		addAnnotation
		  (getSafiServer_Running(), 
		   source, 
		   new String[] {
			 "appinfo", "@Transient"
		   });		
		addAnnotation
		  (getSafiServer_Debug(), 
		   source, 
		   new String[] {
			 "appinfo", "@Transient"
		   });		
		addAnnotation
		  (getRole_Entitlements(), 
		   source, 
		   new String[] {
			 "appinfo", "@ManyToMany(fetch=\"EAGER\" indexed=\"false\" )"
		   });		
		addAnnotation
		  (getUser_Roles(), 
		   source, 
		   new String[] {
			 "appinfo", "@ManyToMany(fetch=\"EAGER\" indexed=\"false\")"
		   });		
		addAnnotation
		  (getSaflet_Code(), 
		   source, 
		   new String[] {
			 "appinfo", "@Basic(fetch=\"LAZY\")\r\n@Lob\r\n@Column(length=\"1048576\")\r\n@Type(type=\"org.hibernate.type.PrimitiveByteArrayBlobType\")"
		   });		
		addAnnotation
		  (getSafletProject_Saflets(), 
		   source, 
		   new String[] {
			 "appinfo", "@OneToMany(fetch=\"EAGER\" mappedBy=\"project\" indexed=\"false\" cascade=\"ALL\")"
		   });		
		addAnnotation
		  (getSafletProject_Enabled(), 
		   source, 
		   new String[] {
			 "appinfo", "@Type(type=\"boolean\")"
		   });		
		addAnnotation
		  (getSafletProject_Prompts(), 
		   source, 
		   new String[] {
			 "appinfo", "@OneToMany(fetch=\"LAZY\" mappedBy=\"project\"  indexed=\"false\" cascade=\"ALL\")"
		   });		
		addAnnotation
		  (getPrompt_System(), 
		   source, 
		   new String[] {
			 "appinfo", "@Type(type=\"boolean\")"
		   });		
		addAnnotation
		  (getTelephonySubsystem_Running(), 
		   source, 
		   new String[] {
			 "appinfo", "@Transient"
		   });		
		addAnnotation
		  (getTelephonySubsystem_Private(), 
		   source, 
		   new String[] {
			 "appinfo", "@Type(type=\"boolean\")"
		   });		
		addAnnotation
		  (getTelephonySubsystem_Enabled(), 
		   source, 
		   new String[] {
			 "appinfo", "@Type(type=\"boolean\")"
		   });
	}

} //ConfigPackageImpl
