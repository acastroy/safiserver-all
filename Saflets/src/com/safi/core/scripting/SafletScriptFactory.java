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
 * A representation of the model object '<em><b>Saflet Script Factory</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.core.scripting.SafletScriptFactory#getSafletScript <em>Saflet Script</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.core.scripting.ScriptingPackage#getSafletScriptFactory()
 * @model abstract="true"
 * @generated
 */
public interface SafletScriptFactory extends EObject {
  /**
	 * Returns the value of the '<em><b>Saflet Script</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Saflet Script</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Saflet Script</em>' reference.
	 * @see com.safi.core.scripting.ScriptingPackage#getSafletScriptFactory_SafletScript()
	 * @model changeable="false" ordered="false"
	 * @generated
	 */
  SafletScript getSafletScript();

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  SafletScript getSafletScript(String name, String scriptText);

} // SafletScriptFactory
