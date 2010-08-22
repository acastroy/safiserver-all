/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting;

import com.safi.core.saflet.SafletEnvironment;
import com.safi.core.saflet.SafletException;

import com.safi.db.Variable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Script Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.scripting.ScriptScope#getScopeObject <em>Scope Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.scripting.ScriptingPackage#getScriptScope()
 * @model abstract="true"
 * @generated
 */
public interface ScriptScope extends EObject {
  /**
	 * Returns the value of the '<em><b>Scope Object</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Scope Object</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope Object</em>' attribute.
	 * @see #setScopeObject(Object)
	 * @see com.safi.core.scripting.ScriptingPackage#getScriptScope_ScopeObject()
	 * @model ordered="false"
	 * @generated
	 */
  Object getScopeObject();

  /**
	 * Sets the value of the '{@link com.safi.core.scripting.ScriptScope#getScopeObject <em>Scope Object</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope Object</em>' attribute.
	 * @see #getScopeObject()
	 * @generated
	 */
  void setScopeObject(Object value);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model exceptions="com.safi.core.scripting.SafletScriptException"
	 * @generated
	 */
  void exposeObjectToScript(String name, Object value) throws SafletScriptException;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model exceptions="com.safi.core.scripting.SafletScriptException"
	 * @generated
	 */
  void removeObjectFromScope(String name) throws SafletScriptException;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model exceptions="com.safi.core.saflet.SafletException"
	 * @generated
	 */
  Object getScopedObject(String name) throws SafletException;

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="com.safi.core.scripting.SafletScriptException" variablesMany="true"
	 * @generated
	 */
	void updateVariablesFromScope(EList<Variable> variables, SafletEnvironment safletEnvironment, boolean isDebug) throws SafletScriptException;

} // ScriptScope
