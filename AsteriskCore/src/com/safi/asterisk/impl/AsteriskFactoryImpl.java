/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.impl;

import com.safi.asterisk.*;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.manager.ManagerConnection;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.safi.asterisk.AsteriskFactory;
import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AsteriskFactoryImpl extends EFactoryImpl implements AsteriskFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static AsteriskFactory init() {
		try {
			AsteriskFactory theAsteriskFactory = (AsteriskFactory)EPackage.Registry.INSTANCE.getEFactory("http:///com/safi/asterisk.ecore"); 
			if (theAsteriskFactory != null) {
				return theAsteriskFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AsteriskFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AsteriskFactoryImpl() {
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
			case AsteriskPackage.CALL: return createCall();
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
			case AsteriskPackage.CALL_STATE:
				return createCallStateFromString(eDataType, initialValue);
			case AsteriskPackage.AGI_REQUEST:
				return createAgiRequestFromString(eDataType, initialValue);
			case AsteriskPackage.AGI_CHANNEL:
				return createAgiChannelFromString(eDataType, initialValue);
			case AsteriskPackage.MANAGER_CONNECTION:
				return createManagerConnectionFromString(eDataType, initialValue);
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
			case AsteriskPackage.CALL_STATE:
				return convertCallStateToString(eDataType, instanceValue);
			case AsteriskPackage.AGI_REQUEST:
				return convertAgiRequestToString(eDataType, instanceValue);
			case AsteriskPackage.AGI_CHANNEL:
				return convertAgiChannelToString(eDataType, instanceValue);
			case AsteriskPackage.MANAGER_CONNECTION:
				return convertManagerConnectionToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Call createCall() {
		CallImpl call = new CallImpl();
		return call;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public CallState createCallStateFromString(EDataType eDataType, String initialValue) {
		CallState result = CallState.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertCallStateToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AgiRequest createAgiRequestFromString(EDataType eDataType, String initialValue) {
		return (AgiRequest)super.createFromString(eDataType, initialValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertAgiRequestToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AgiChannel createAgiChannelFromString(EDataType eDataType, String initialValue) {
		return (AgiChannel)super.createFromString(eDataType, initialValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertAgiChannelToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ManagerConnection createManagerConnectionFromString(EDataType eDataType, String initialValue) {
		return (ManagerConnection)super.createFromString(eDataType, initialValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertManagerConnectionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AsteriskPackage getAsteriskPackage() {
		return (AsteriskPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static AsteriskPackage getPackage() {
		return AsteriskPackage.eINSTANCE;
	}

} //AsteriskFactoryImpl
