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
 * A representation of the model object '<em><b>Saflet Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.scripting.SafletScript#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.core.scripting.SafletScript#getScriptText <em>Script Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.scripting.ScriptingPackage#getSafletScript()
 * @model abstract="true"
 * @generated
 */
public interface SafletScript extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.safi.core.scripting.ScriptingPackage#getSafletScript_Name()
   * @model ordered="false"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.safi.core.scripting.SafletScript#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Script Text</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Script Text</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Script Text</em>' attribute.
   * @see #setScriptText(String)
   * @see com.safi.core.scripting.ScriptingPackage#getSafletScript_ScriptText()
   * @model ordered="false"
   * @generated
   */
  String getScriptText();

  /**
   * Sets the value of the '{@link com.safi.core.scripting.SafletScript#getScriptText <em>Script Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Script Text</em>' attribute.
   * @see #getScriptText()
   * @generated
   */
  void setScriptText(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model exceptions="com.safi.core.scripting.SafletScriptException"
   * @generated
   */
  Object execute(ScriptScope scope) throws SafletScriptException;

} // SafletScript
