/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigFactoryImpl.java,v 1.7 2008/10/18 08:31:29 zacw Exp $
 */
package com.safi.db.server.config.impl;

import com.safi.db.server.config.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ConfigFactoryImpl extends EFactoryImpl implements ConfigFactory {
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static ConfigFactory init() {
    try {
      ConfigFactory theConfigFactory = (ConfigFactory)EPackage.Registry.INSTANCE.getEFactory("http:///com/safi/db.ecore#config"); 
      if (theConfigFactory != null) {
        return theConfigFactory;
      }
    }
    catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ConfigFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConfigFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case ConfigPackage.SERVER_RESOURCE: return createServerResource();
      case ConfigPackage.ASTERISK_SERVER: return createAsteriskServer();
      case ConfigPackage.SAFI_SERVER: return createSafiServer();
      case ConfigPackage.ROLE: return createRole();
      case ConfigPackage.ENTITLEMENT: return createEntitlement();
      case ConfigPackage.USER: return createUser();
      case ConfigPackage.SAFLET: return createSaflet();
      case ConfigPackage.SAFLET_PROJECT: return createSafletProject();
      case ConfigPackage.PROMPT: return createPrompt();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
    switch (eDataType.getClassifierID()) {
      case ConfigPackage.SYNCH_MODE:
        return createSynchModeFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
    switch (eDataType.getClassifierID()) {
      case ConfigPackage.SYNCH_MODE:
        return convertSynchModeToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ServerResource createServerResource() {
    ServerResourceImpl serverResource = new ServerResourceImpl();
    return serverResource;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AsteriskServer createAsteriskServer() {
    AsteriskServerImpl asteriskServer = new AsteriskServerImpl();
    return asteriskServer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SafiServer createSafiServer() {
    SafiServerImpl safiServer = new SafiServerImpl();
    return safiServer;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Role createRole() {
    RoleImpl role = new RoleImpl();
    return role;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entitlement createEntitlement() {
    EntitlementImpl entitlement = new EntitlementImpl();
    return entitlement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public User createUser() {
    UserImpl user = new UserImpl();
    return user;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Saflet createSaflet() {
    SafletImpl saflet = new SafletImpl();
    return saflet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SafletProject createSafletProject() {
    SafletProjectImpl safletProject = new SafletProjectImpl();
    return safletProject;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Prompt createPrompt() {
    PromptImpl prompt = new PromptImpl();
    return prompt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SynchMode createSynchModeFromString(EDataType eDataType, String initialValue) {
    SynchMode result = SynchMode.get(initialValue);
    if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
    return result;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String convertSynchModeToString(EDataType eDataType, Object instanceValue) {
    return instanceValue == null ? null : instanceValue.toString();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConfigPackage getConfigPackage() {
    return (ConfigPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ConfigPackage getPackage() {
    return ConfigPackage.eINSTANCE;
  }

} //ConfigFactoryImpl
