/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigFactory.java,v 1.6 2008/10/18 08:31:30 zacw Exp $
 */
package com.safi.db.server.config;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.db.server.config.ConfigPackage
 * @generated
 */
public interface ConfigFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ConfigFactory eINSTANCE = com.safi.db.server.config.impl.ConfigFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Server Resource</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Server Resource</em>'.
   * @generated
   */
  ServerResource createServerResource();

  /**
   * Returns a new object of class '<em>Asterisk Server</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Asterisk Server</em>'.
   * @generated
   */
  AsteriskServer createAsteriskServer();

  /**
   * Returns a new object of class '<em>Safi Server</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Safi Server</em>'.
   * @generated
   */
  SafiServer createSafiServer();

  /**
   * Returns a new object of class '<em>Role</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Role</em>'.
   * @generated
   */
  Role createRole();

  /**
   * Returns a new object of class '<em>Entitlement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Entitlement</em>'.
   * @generated
   */
  Entitlement createEntitlement();

  /**
   * Returns a new object of class '<em>User</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>User</em>'.
   * @generated
   */
  User createUser();

  /**
   * Returns a new object of class '<em>Saflet</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Saflet</em>'.
   * @generated
   */
  Saflet createSaflet();

  /**
   * Returns a new object of class '<em>Saflet Project</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Saflet Project</em>'.
   * @generated
   */
  SafletProject createSafletProject();

  /**
   * Returns a new object of class '<em>Prompt</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Prompt</em>'.
   * @generated
   */
  Prompt createPrompt();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ConfigPackage getConfigPackage();

} //ConfigFactory
