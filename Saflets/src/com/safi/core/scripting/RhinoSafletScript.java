/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting;

import org.mozilla.javascript.Script;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rhino Saflet Script</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.scripting.RhinoSafletScript#getRhinoScript <em>Rhino Script</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.scripting.ScriptingPackage#getRhinoSafletScript()
 * @model
 * @generated
 */
public interface RhinoSafletScript extends SafletScript {
  /**
   * Returns the value of the '<em><b>Rhino Script</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rhino Script</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhino Script</em>' attribute.
   * @see #setRhinoScript(Script)
   * @see com.safi.core.scripting.ScriptingPackage#getRhinoSafletScript_RhinoScript()
   * @model dataType="com.safi.core.scripting.Script" ordered="false"
   * @generated
   */
  Script getRhinoScript();

  /**
   * Sets the value of the '{@link com.safi.core.scripting.RhinoSafletScript#getRhinoScript <em>Rhino Script</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rhino Script</em>' attribute.
   * @see #getRhinoScript()
   * @generated
   */
  void setRhinoScript(Script value);

} // RhinoSafletScript
