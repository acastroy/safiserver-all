/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import org.eclipse.emf.ecore.EClass;

import com.safi.core.scripting.RhinoSafletScriptFactory;
import com.safi.core.scripting.SafletScript;
import com.safi.core.scripting.ScriptingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rhino Saflet Script Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RhinoSafletScriptFactoryImpl extends SafletScriptFactoryImpl implements RhinoSafletScriptFactory {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RhinoSafletScriptFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ScriptingPackage.Literals.RHINO_SAFLET_SCRIPT_FACTORY;
  }

  @Override
  public SafletScript getSafletScript(String name, String scriptText) {
    SafletScript script = new RhinoSafletScriptImpl();
    script.setName(name);
    script.setScriptText(scriptText);
    return script;
  }
} //RhinoSafletScriptFactoryImpl
