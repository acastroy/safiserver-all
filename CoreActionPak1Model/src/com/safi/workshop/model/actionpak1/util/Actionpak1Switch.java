/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.safi.core.ProductIdentifiable;
import com.safi.core.ThreadSensitive;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ParameterizedActionstep;
import com.safi.core.actionstep.ParameterizedInitiator;
import com.safi.core.call.CallSource1;
import com.safi.core.initiator.Initiator;
import com.safi.workshop.model.actionpak1.*;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.ActionstepTest;
import com.safi.workshop.model.actionpak1.CustomInitiator;
import com.safi.workshop.model.actionpak1.IncomingCall2;
import com.safi.workshop.model.actionpak1.InvokeSaflet2;

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
 * @see com.safi.workshop.model.actionpak1.Actionpak1Package
 * @generated
 */
public class Actionpak1Switch<T> {
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static Actionpak1Package modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Actionpak1Switch() {
		if (modelPackage == null) {
			modelPackage = Actionpak1Package.eINSTANCE;
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
			case Actionpak1Package.ACTIONSTEP_TEST: {
				ActionstepTest actionstepTest = (ActionstepTest)theEObject;
				T result = caseActionstepTest(actionstepTest);
				if (result == null) result = caseActionStep(actionstepTest);
				if (result == null) result = caseProductIdentifiable(actionstepTest);
				if (result == null) result = caseThreadSensitive(actionstepTest);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Actionpak1Package.CUSTOM_INITIATOR: {
				CustomInitiator customInitiator = (CustomInitiator)theEObject;
				T result = caseCustomInitiator(customInitiator);
				if (result == null) result = caseParameterizedInitiator(customInitiator);
				if (result == null) result = caseInitiator(customInitiator);
				if (result == null) result = caseParameterizedActionstep(customInitiator);
				if (result == null) result = caseActionStep(customInitiator);
				if (result == null) result = caseProductIdentifiable(customInitiator);
				if (result == null) result = caseThreadSensitive(customInitiator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Actionpak1Package.INCOMING_CALL2: {
				IncomingCall2 incomingCall2 = (IncomingCall2)theEObject;
				T result = caseIncomingCall2(incomingCall2);
				if (result == null) result = caseParameterizedInitiator(incomingCall2);
				if (result == null) result = caseCallSource1(incomingCall2);
				if (result == null) result = caseInitiator(incomingCall2);
				if (result == null) result = caseParameterizedActionstep(incomingCall2);
				if (result == null) result = caseActionStep(incomingCall2);
				if (result == null) result = caseProductIdentifiable(incomingCall2);
				if (result == null) result = caseThreadSensitive(incomingCall2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Actionpak1Package.INVOKE_SAFLET2: {
				InvokeSaflet2 invokeSaflet2 = (InvokeSaflet2)theEObject;
				T result = caseInvokeSaflet2(invokeSaflet2);
				if (result == null) result = caseParameterizedActionstep(invokeSaflet2);
				if (result == null) result = caseActionStep(invokeSaflet2);
				if (result == null) result = caseProductIdentifiable(invokeSaflet2);
				if (result == null) result = caseThreadSensitive(invokeSaflet2);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case Actionpak1Package.MANAGER_ACTION: {
				ManagerAction managerAction = (ManagerAction)theEObject;
				T result = caseManagerAction(managerAction);
				if (result == null) result = caseParameterizedActionstep(managerAction);
				if (result == null) result = caseActionStep(managerAction);
				if (result == null) result = caseProductIdentifiable(managerAction);
				if (result == null) result = caseThreadSensitive(managerAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Actionstep Test</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Actionstep Test</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseActionstepTest(ActionstepTest object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Invoke Saflet2</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Invoke Saflet2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseInvokeSaflet2(InvokeSaflet2 object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Manager Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Manager Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseManagerAction(ManagerAction object) {
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

} //Actionpak1Switch
