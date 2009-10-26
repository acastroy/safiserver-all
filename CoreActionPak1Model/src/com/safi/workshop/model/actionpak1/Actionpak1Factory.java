/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.workshop.model.actionpak1.Actionpak1Package
 * @generated
 */
public interface Actionpak1Factory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Actionpak1Factory eINSTANCE = com.safi.workshop.model.actionpak1.impl.Actionpak1FactoryImpl.init();

  /**
   * Returns a new object of class '<em>Actionstep Test</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Actionstep Test</em>'.
   * @generated
   */
  ActionstepTest createActionstepTest();

  /**
   * Returns a new object of class '<em>Custom Initiator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Custom Initiator</em>'.
   * @generated
   */
  CustomInitiator createCustomInitiator();

  /**
   * Returns a new object of class '<em>Incoming Call2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Incoming Call2</em>'.
   * @generated
   */
  IncomingCall2 createIncomingCall2();

  /**
   * Returns a new object of class '<em>Invoke Saflet2</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Invoke Saflet2</em>'.
   * @generated
   */
  InvokeSaflet2 createInvokeSaflet2();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Actionpak1Package getActionpak1Package();

} //Actionpak1Factory
