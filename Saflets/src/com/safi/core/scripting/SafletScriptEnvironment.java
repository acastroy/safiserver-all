/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Saflet Script Environment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.scripting.SafletScriptEnvironment#getSharedSafletScript <em>Shared Saflet Script</em>}</li>
 *   <li>{@link com.safi.core.scripting.SafletScriptEnvironment#getSharedScriptScope <em>Shared Script Scope</em>}</li>
 *   <li>{@link com.safi.core.scripting.SafletScriptEnvironment#getSafletScriptFactory <em>Saflet Script Factory</em>}</li>
 *   <li>{@link com.safi.core.scripting.SafletScriptEnvironment#getScriptScopeFactory <em>Script Scope Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.scripting.ScriptingPackage#getSafletScriptEnvironment()
 * @model abstract="true"
 * @generated
 */
public interface SafletScriptEnvironment extends EObject {
  /**
	 * Returns the value of the '<em><b>Shared Saflet Script</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Shared Saflet Script</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Saflet Script</em>' reference.
	 * @see #setSharedSafletScript(SafletScript)
	 * @see com.safi.core.scripting.ScriptingPackage#getSafletScriptEnvironment_SharedSafletScript()
	 * @model ordered="false"
	 * @generated
	 */
  SafletScript getSharedSafletScript();

  /**
	 * Sets the value of the '{@link com.safi.core.scripting.SafletScriptEnvironment#getSharedSafletScript <em>Shared Saflet Script</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared Saflet Script</em>' reference.
	 * @see #getSharedSafletScript()
	 * @generated
	 */
  void setSharedSafletScript(SafletScript value);

  /**
	 * Returns the value of the '<em><b>Shared Script Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Shared Script Scope</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Script Scope</em>' reference.
	 * @see #setSharedScriptScope(ScriptScope)
	 * @see com.safi.core.scripting.ScriptingPackage#getSafletScriptEnvironment_SharedScriptScope()
	 * @model ordered="false"
	 * @generated
	 */
  ScriptScope getSharedScriptScope();

  /**
	 * Sets the value of the '{@link com.safi.core.scripting.SafletScriptEnvironment#getSharedScriptScope <em>Shared Script Scope</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared Script Scope</em>' reference.
	 * @see #getSharedScriptScope()
	 * @generated
	 */
  void setSharedScriptScope(ScriptScope value);

  /**
	 * Returns the value of the '<em><b>Saflet Script Factory</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Saflet Script Factory</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Saflet Script Factory</em>' reference.
	 * @see #setSafletScriptFactory(SafletScriptFactory)
	 * @see com.safi.core.scripting.ScriptingPackage#getSafletScriptEnvironment_SafletScriptFactory()
	 * @model ordered="false"
	 * @generated
	 */
  SafletScriptFactory getSafletScriptFactory();

  /**
	 * Sets the value of the '{@link com.safi.core.scripting.SafletScriptEnvironment#getSafletScriptFactory <em>Saflet Script Factory</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Saflet Script Factory</em>' reference.
	 * @see #getSafletScriptFactory()
	 * @generated
	 */
  void setSafletScriptFactory(SafletScriptFactory value);

  /**
	 * Returns the value of the '<em><b>Script Scope Factory</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Script Scope Factory</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Script Scope Factory</em>' reference.
	 * @see #setScriptScopeFactory(ScriptScopeFactory)
	 * @see com.safi.core.scripting.ScriptingPackage#getSafletScriptEnvironment_ScriptScopeFactory()
	 * @model ordered="false"
	 * @generated
	 */
  ScriptScopeFactory getScriptScopeFactory();

  /**
	 * Sets the value of the '{@link com.safi.core.scripting.SafletScriptEnvironment#getScriptScopeFactory <em>Script Scope Factory</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Script Scope Factory</em>' reference.
	 * @see #getScriptScopeFactory()
	 * @generated
	 */
  void setScriptScopeFactory(ScriptScopeFactory value);

} // SafletScriptEnvironment
