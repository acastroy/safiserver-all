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
 * A representation of the model object '<em><b>Script Scope Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.scripting.ScriptScopeFactory#getScriptScope <em>Script Scope</em>}</li>
 *   <li>{@link com.safi.core.scripting.ScriptScopeFactory#getGlobalScriptScope <em>Global Script Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.scripting.ScriptingPackage#getScriptScopeFactory()
 * @model abstract="true"
 * @generated
 */
public interface ScriptScopeFactory extends EObject {
  /**
   * Returns the value of the '<em><b>Script Scope</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Script Scope</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Script Scope</em>' reference.
   * @see #setScriptScope(ScriptScope)
   * @see com.safi.core.scripting.ScriptingPackage#getScriptScopeFactory_ScriptScope()
   * @model ordered="false"
   * @generated
   */
  ScriptScope getScriptScope();

  /**
   * Sets the value of the '{@link com.safi.core.scripting.ScriptScopeFactory#getScriptScope <em>Script Scope</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Script Scope</em>' reference.
   * @see #getScriptScope()
   * @generated
   */
  void setScriptScope(ScriptScope value);

  /**
   * Returns the value of the '<em><b>Global Script Scope</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Global Script Scope</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Global Script Scope</em>' reference.
   * @see #setGlobalScriptScope(ScriptScope)
   * @see com.safi.core.scripting.ScriptingPackage#getScriptScopeFactory_GlobalScriptScope()
   * @model ordered="false"
   * @generated
   */
  ScriptScope getGlobalScriptScope();

  /**
   * Sets the value of the '{@link com.safi.core.scripting.ScriptScopeFactory#getGlobalScriptScope <em>Global Script Scope</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Global Script Scope</em>' reference.
   * @see #getGlobalScriptScope()
   * @generated
   */
  void setGlobalScriptScope(ScriptScope value);

} // ScriptScopeFactory
