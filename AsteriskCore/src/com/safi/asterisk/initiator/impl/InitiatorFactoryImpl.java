/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator.impl;


import com.safi.asterisk.initiator.*;
import org.asteriskjava.manager.event.ManagerEvent;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.safi.asterisk.initiator.DIDMatcher;
import com.safi.asterisk.initiator.IncomingCall;
import com.safi.asterisk.initiator.InitiatorFactory;
import com.safi.asterisk.initiator.InitiatorPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class InitiatorFactoryImpl extends EFactoryImpl implements InitiatorFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static InitiatorFactory init() {
		try {
			InitiatorFactory theInitiatorFactory = (InitiatorFactory)EPackage.Registry.INSTANCE.getEFactory("http:///com/safi/asterisk.ecore#initiator"); 
			if (theInitiatorFactory != null) {
				return theInitiatorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new InitiatorFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InitiatorFactoryImpl() {
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
			case InitiatorPackage.DID_MATCHER: return createDIDMatcher();
			case InitiatorPackage.INCOMING_CALL: return createIncomingCall();
			case InitiatorPackage.ASTERISK_INITIATOR: return createAsteriskInitiator();
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
			case InitiatorPackage.MANAGER_EVENT:
				return createManagerEventFromString(eDataType, initialValue);
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
			case InitiatorPackage.MANAGER_EVENT:
				return convertManagerEventToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DIDMatcher createDIDMatcher() {
		DIDMatcherImpl didMatcher = new DIDMatcherImpl();
		return didMatcher;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IncomingCall createIncomingCall() {
		IncomingCallImpl incomingCall = new IncomingCallImpl();
		return incomingCall;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AsteriskInitiator createAsteriskInitiator() {
		AsteriskInitiatorImpl asteriskInitiator = new AsteriskInitiatorImpl();
		return asteriskInitiator;
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ManagerEvent createManagerEventFromString(EDataType eDataType, String initialValue) {
		return (ManagerEvent)super.createFromString(eDataType, initialValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertManagerEventToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InitiatorPackage getInitiatorPackage() {
		return (InitiatorPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static InitiatorPackage getPackage() {
		return InitiatorPackage.eINSTANCE;
	}

} //InitiatorFactoryImpl
