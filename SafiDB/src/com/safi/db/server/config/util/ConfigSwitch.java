/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConfigSwitch.java,v 1.6 2008/10/18 08:31:30 zacw Exp $
 */
package com.safi.db.server.config.util;

import com.safi.db.server.config.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.Entitlement;
import com.safi.db.server.config.Prompt;
import com.safi.db.server.config.Role;
import com.safi.db.server.config.SFTPInfo;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.Saflet;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.db.server.config.TelephonySubsystem;
import com.safi.db.server.config.User;

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
 * @see com.safi.db.server.config.ConfigPackage
 * @generated
 */
public class ConfigSwitch<T> {
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static ConfigPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ConfigSwitch() {
		if (modelPackage == null) {
			modelPackage = ConfigPackage.eINSTANCE;
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
			case ConfigPackage.SERVER_RESOURCE: {
				ServerResource serverResource = (ServerResource)theEObject;
				T result = caseServerResource(serverResource);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.SAFI_SERVER: {
				SafiServer safiServer = (SafiServer)theEObject;
				T result = caseSafiServer(safiServer);
				if (result == null) result = caseServerResource(safiServer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.ROLE: {
				Role role = (Role)theEObject;
				T result = caseRole(role);
				if (result == null) result = caseServerResource(role);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.ENTITLEMENT: {
				Entitlement entitlement = (Entitlement)theEObject;
				T result = caseEntitlement(entitlement);
				if (result == null) result = caseServerResource(entitlement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.USER: {
				User user = (User)theEObject;
				T result = caseUser(user);
				if (result == null) result = caseServerResource(user);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.SAFLET: {
				Saflet saflet = (Saflet)theEObject;
				T result = caseSaflet(saflet);
				if (result == null) result = caseServerResource(saflet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.SAFLET_PROJECT: {
				SafletProject safletProject = (SafletProject)theEObject;
				T result = caseSafletProject(safletProject);
				if (result == null) result = caseServerResource(safletProject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.PROMPT: {
				Prompt prompt = (Prompt)theEObject;
				T result = casePrompt(prompt);
				if (result == null) result = caseServerResource(prompt);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.SFTP_INFO: {
				SFTPInfo sftpInfo = (SFTPInfo)theEObject;
				T result = caseSFTPInfo(sftpInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigPackage.TELEPHONY_SUBSYSTEM: {
				TelephonySubsystem telephonySubsystem = (TelephonySubsystem)theEObject;
				T result = caseTelephonySubsystem(telephonySubsystem);
				if (result == null) result = caseServerResource(telephonySubsystem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Server Resource</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Server Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseServerResource(ServerResource object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Safi Server</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Safi Server</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSafiServer(SafiServer object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Role</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Role</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRole(Role object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Entitlement</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entitlement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseEntitlement(Entitlement object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>User</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseUser(User object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Saflet</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Saflet</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSaflet(Saflet object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Saflet Project</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Saflet Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSafletProject(SafletProject object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Prompt</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prompt</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePrompt(Prompt object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>SFTP Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>SFTP Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSFTPInfo(SFTPInfo object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Telephony Subsystem</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Telephony Subsystem</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTelephonySubsystem(TelephonySubsystem object) {
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

} //ConfigSwitch
