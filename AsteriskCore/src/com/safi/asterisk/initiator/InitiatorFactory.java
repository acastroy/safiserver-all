/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.initiator.InitiatorPackage
 * @generated
 */
public interface InitiatorFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  InitiatorFactory eINSTANCE = com.safi.asterisk.initiator.impl.InitiatorFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>DID Matcher</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>DID Matcher</em>'.
	 * @generated
	 */
  DIDMatcher createDIDMatcher();

  /**
	 * Returns a new object of class '<em>Incoming Call</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Incoming Call</em>'.
	 * @generated
	 */
  IncomingCall createIncomingCall();

  /**
	 * Returns a new object of class '<em>Asterisk Initiator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Asterisk Initiator</em>'.
	 * @generated
	 */
	AsteriskInitiator createAsteriskInitiator();

		/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  InitiatorPackage getInitiatorPackage();

} //InitiatorFactory
