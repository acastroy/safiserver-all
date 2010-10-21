/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import org.apache.commons.js2j.SugarWrapFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Wrapper;

import com.safi.core.scripting.RhinoSafletScript;
import com.safi.core.scripting.SafletScriptException;
import com.safi.core.scripting.ScriptingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rhino Saflet Script</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.scripting.impl.RhinoSafletScriptImpl#getRhinoScript <em>Rhino Script</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RhinoSafletScriptImpl extends SafletScriptImpl implements RhinoSafletScript {
  /**
	 * The default value of the '{@link #getRhinoScript() <em>Rhino Script</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRhinoScript()
	 * @generated
	 * @ordered
	 */
  protected static final Script RHINO_SCRIPT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getRhinoScript() <em>Rhino Script</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRhinoScript()
	 * @generated
	 * @ordered
	 */
  protected Script rhinoScript = RHINO_SCRIPT_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected RhinoSafletScriptImpl() {
		super();
	}

  @Override
  public Object execute(com.safi.core.scripting.ScriptScope scope) throws SafletScriptException {
    try {
      Context cx = ContextFactory.getGlobal().enterContext();
      if (!(cx.getWrapFactory() instanceof SugarWrapFactory))
      	cx.setWrapFactory(new SugarWrapFactory());
      if (rhinoScript == null) {
      	
        rhinoScript = cx.compileString(scriptText, name, 1, null);
      }
      
      // TODO: share the engine among all handlers and keep a per-handler
      // Bindings object instead
      
      Scriptable scopeObject = (Scriptable) scope.getScopeObject();
      Scriptable newScope = cx.newObject(scopeObject);
      newScope.setParentScope(scopeObject);
//      newScope.setPrototype(scopeObject);
			Object result = rhinoScript.exec(cx, newScope);
      if (result instanceof Wrapper) result = ((Wrapper) result).unwrap();
      return result;
    } catch (Exception exe) {
      throw new SafletScriptException("Error caught while executing script " + name, exe);
    } finally {
      if (Context.getCurrentContext() != null) Context.exit();
    }
  
  }
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ScriptingPackage.Literals.RHINO_SAFLET_SCRIPT;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Script getRhinoScript() {
		return rhinoScript;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRhinoScript(Script newRhinoScript) {
		Script oldRhinoScript = rhinoScript;
		rhinoScript = newRhinoScript;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptingPackage.RHINO_SAFLET_SCRIPT__RHINO_SCRIPT, oldRhinoScript, rhinoScript));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScriptingPackage.RHINO_SAFLET_SCRIPT__RHINO_SCRIPT:
				return getRhinoScript();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ScriptingPackage.RHINO_SAFLET_SCRIPT__RHINO_SCRIPT:
				setRhinoScript((Script)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID) {
		switch (featureID) {
			case ScriptingPackage.RHINO_SAFLET_SCRIPT__RHINO_SCRIPT:
				setRhinoScript(RHINO_SCRIPT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ScriptingPackage.RHINO_SAFLET_SCRIPT__RHINO_SCRIPT:
				return RHINO_SCRIPT_EDEFAULT == null ? rhinoScript != null : !RHINO_SCRIPT_EDEFAULT.equals(rhinoScript);
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (rhinoScript: ");
		result.append(rhinoScript);
		result.append(')');
		return result.toString();
	}

} //RhinoSafletScriptImpl
