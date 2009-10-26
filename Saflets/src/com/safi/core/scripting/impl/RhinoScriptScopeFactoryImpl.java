/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import org.eclipse.emf.ecore.EClass;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import com.safi.core.scripting.RhinoScriptScope;
import com.safi.core.scripting.RhinoScriptScopeFactory;
import com.safi.core.scripting.ScriptScope;
import com.safi.core.scripting.ScriptingFactory;
import com.safi.core.scripting.ScriptingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rhino Script Scope Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class RhinoScriptScopeFactoryImpl extends ScriptScopeFactoryImpl implements RhinoScriptScopeFactory {
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RhinoScriptScopeFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ScriptingPackage.Literals.RHINO_SCRIPT_SCOPE_FACTORY;
  }
  
  @Override
  public ScriptScope getScriptScope() {
    Context cx = ContextFactory.getGlobal().enterContext();
    try {
      if (Context.isValidLanguageVersion(170))
        cx.setLanguageVersion(170);
      Scriptable handlerScope = null;
      ScriptableObject sharedScope = (ScriptableObject) getGlobalScriptScope().getScopeObject();
      handlerScope = cx.newObject(sharedScope);
      handlerScope.setPrototype(sharedScope);
      handlerScope.setParentScope(null);

      RhinoScriptScope scope = ScriptingFactory.eINSTANCE.createRhinoScriptScope();
      scope.setScopeObject(handlerScope);
      return scope;
    } finally {
      Context.exit();
    }
  }

} //RhinoScriptScopeFactoryImpl
