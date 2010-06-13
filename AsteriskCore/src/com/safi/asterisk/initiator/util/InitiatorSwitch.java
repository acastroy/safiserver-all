/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.safi.asterisk.initiator.AsteriskInitiator;
import com.safi.asterisk.initiator.AsteriskInitiatorInfo;
import com.safi.asterisk.initiator.CustomInitiatorAsterisk;
import com.safi.asterisk.initiator.DIDMatcher;
import com.safi.asterisk.initiator.IncomingAsteriskCall;
import com.safi.asterisk.initiator.IncomingCall;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.core.PlatformDisposition;
import com.safi.core.ProductIdentifiable;
import com.safi.core.ThreadSensitive;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ParameterizedActionstep;
import com.safi.core.actionstep.ParameterizedInitiator;
import com.safi.core.call.CallSource1;
import com.safi.core.initiator.Initiator;
import com.safi.core.initiator.InitiatorInfo;
import com.safi.workshop.model.actionpak1.CustomInitiator;
import com.safi.workshop.model.actionpak1.IncomingCall2;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.initiator.InitiatorPackage
 * @generated
 */
public class InitiatorSwitch<T> {
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static InitiatorPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public InitiatorSwitch() {
		if (modelPackage == null) {
			modelPackage = InitiatorPackage.eINSTANCE;
		}
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case InitiatorPackage.DID_MATCHER: {
				DIDMatcher didMatcher = (DIDMatcher)theEObject;
				T result = caseDIDMatcher(didMatcher);
				if (result == null) result = caseAsteriskInitiator(didMatcher);
				if (result == null) result = caseCallSource1(didMatcher);
				if (result == null) result = caseInitiator(didMatcher);
				if (result == null) result = caseActionStep(didMatcher);
				if (result == null) result = caseProductIdentifiable(didMatcher);
				if (result == null) result = caseThreadSensitive(didMatcher);
				if (result == null) result = casePlatformDisposition(didMatcher);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InitiatorPackage.INCOMING_CALL: {
				IncomingCall incomingCall = (IncomingCall)theEObject;
				T result = caseIncomingCall(incomingCall);
				if (result == null) result = caseAsteriskInitiator(incomingCall);
				if (result == null) result = caseCallSource1(incomingCall);
				if (result == null) result = caseInitiator(incomingCall);
				if (result == null) result = caseActionStep(incomingCall);
				if (result == null) result = caseProductIdentifiable(incomingCall);
				if (result == null) result = caseThreadSensitive(incomingCall);
				if (result == null) result = casePlatformDisposition(incomingCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InitiatorPackage.ASTERISK_INITIATOR_INFO: {
				AsteriskInitiatorInfo asteriskInitiatorInfo = (AsteriskInitiatorInfo)theEObject;
				T result = caseAsteriskInitiatorInfo(asteriskInitiatorInfo);
				if (result == null) result = caseInitiatorInfo(asteriskInitiatorInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InitiatorPackage.ASTERISK_INITIATOR: {
				AsteriskInitiator asteriskInitiator = (AsteriskInitiator)theEObject;
				T result = caseAsteriskInitiator(asteriskInitiator);
				if (result == null) result = caseInitiator(asteriskInitiator);
				if (result == null) result = caseActionStep(asteriskInitiator);
				if (result == null) result = caseProductIdentifiable(asteriskInitiator);
				if (result == null) result = caseThreadSensitive(asteriskInitiator);
				if (result == null) result = casePlatformDisposition(asteriskInitiator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InitiatorPackage.INCOMING_ASTERISK_CALL: {
				IncomingAsteriskCall incomingAsteriskCall = (IncomingAsteriskCall)theEObject;
				T result = caseIncomingAsteriskCall(incomingAsteriskCall);
				if (result == null) result = caseIncomingCall2(incomingAsteriskCall);
				if (result == null) result = caseParameterizedInitiator(incomingAsteriskCall);
				if (result == null) result = caseCallSource1(incomingAsteriskCall);
				if (result == null) result = caseInitiator(incomingAsteriskCall);
				if (result == null) result = caseParameterizedActionstep(incomingAsteriskCall);
				if (result == null) result = caseActionStep(incomingAsteriskCall);
				if (result == null) result = caseProductIdentifiable(incomingAsteriskCall);
				if (result == null) result = caseThreadSensitive(incomingAsteriskCall);
				if (result == null) result = casePlatformDisposition(incomingAsteriskCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case InitiatorPackage.CUSTOM_INITIATOR_ASTERISK: {
				CustomInitiatorAsterisk customInitiatorAsterisk = (CustomInitiatorAsterisk)theEObject;
				T result = caseCustomInitiatorAsterisk(customInitiatorAsterisk);
				if (result == null) result = caseCustomInitiator(customInitiatorAsterisk);
				if (result == null) result = caseParameterizedInitiator(customInitiatorAsterisk);
				if (result == null) result = caseInitiator(customInitiatorAsterisk);
				if (result == null) result = caseParameterizedActionstep(customInitiatorAsterisk);
				if (result == null) result = caseActionStep(customInitiatorAsterisk);
				if (result == null) result = caseProductIdentifiable(customInitiatorAsterisk);
				if (result == null) result = caseThreadSensitive(customInitiatorAsterisk);
				if (result == null) result = casePlatformDisposition(customInitiatorAsterisk);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>DID Matcher</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>DID Matcher</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDIDMatcher(DIDMatcher object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Incoming Call</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Incoming Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseIncomingCall(IncomingCall object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Asterisk Initiator Info</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Asterisk Initiator Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAsteriskInitiatorInfo(AsteriskInitiatorInfo object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Asterisk Initiator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Asterisk Initiator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAsteriskInitiator(AsteriskInitiator object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Incoming Asterisk Call</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Incoming Asterisk Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncomingAsteriskCall(IncomingAsteriskCall object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Initiator Asterisk</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Initiator Asterisk</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomInitiatorAsterisk(CustomInitiatorAsterisk object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Product Identifiable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseProductIdentifiable(ProductIdentifiable object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Sensitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Sensitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadSensitive(ThreadSensitive object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Platform Disposition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Platform Disposition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlatformDisposition(PlatformDisposition object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Step</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseActionStep(ActionStep object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Initiator</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Initiator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInitiator(Initiator object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Source1</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCallSource1(CallSource1 object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Info</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInitiatorInfo(InitiatorInfo object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Actionstep</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Actionstep</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedActionstep(ParameterizedActionstep object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameterized Initiator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameterized Initiator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterizedInitiator(ParameterizedInitiator object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Incoming Call2</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Incoming Call2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncomingCall2(IncomingCall2 object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Initiator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Initiator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCustomInitiator(CustomInitiator object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  public T defaultCase(EObject object) {
		return null;
	}

} //InitiatorSwitch
