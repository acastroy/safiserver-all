/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.impl;

import com.safi.workshop.model.actionpak1.*;

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
public class Actionpak1FactoryImpl extends EFactoryImpl implements Actionpak1Factory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static Actionpak1Factory init() {
		try {
			Actionpak1Factory theActionpak1Factory = (Actionpak1Factory)EPackage.Registry.INSTANCE.getEFactory("http:///com/safi/workshop/actionpak1.ecore"); 
			if (theActionpak1Factory != null) {
				return theActionpak1Factory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Actionpak1FactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Actionpak1FactoryImpl() {
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
			case Actionpak1Package.ACTIONSTEP_TEST: return createActionstepTest();
			case Actionpak1Package.CUSTOM_INITIATOR: return createCustomInitiator();
			case Actionpak1Package.INCOMING_CALL2: return createIncomingCall2();
			case Actionpak1Package.INVOKE_SAFLET2: return createInvokeSaflet2();
			case Actionpak1Package.MANAGER_ACTION: return createManagerAction();
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
			case Actionpak1Package.MANAGER_ACTION_TYPE:
				return createManagerActionTypeFromString(eDataType, initialValue);
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
			case Actionpak1Package.MANAGER_ACTION_TYPE:
				return convertManagerActionTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionstepTest createActionstepTest() {
		ActionstepTestImpl actionstepTest = new ActionstepTestImpl();
		return actionstepTest;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CustomInitiator createCustomInitiator() {
		CustomInitiatorImpl customInitiator = new CustomInitiatorImpl();
		return customInitiator;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public IncomingCall2 createIncomingCall2() {
		IncomingCall2Impl incomingCall2 = new IncomingCall2Impl();
		return incomingCall2;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InvokeSaflet2 createInvokeSaflet2() {
		InvokeSaflet2Impl invokeSaflet2 = new InvokeSaflet2Impl();
		return invokeSaflet2;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagerAction createManagerAction() {
		ManagerActionImpl managerAction = new ManagerActionImpl();
		return managerAction;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagerActionType createManagerActionTypeFromString(EDataType eDataType, String initialValue) {
		ManagerActionType result = ManagerActionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertManagerActionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Actionpak1Package getActionpak1Package() {
		return (Actionpak1Package)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static Actionpak1Package getPackage() {
		return Actionpak1Package.eINSTANCE;
	}

} //Actionpak1FactoryImpl
