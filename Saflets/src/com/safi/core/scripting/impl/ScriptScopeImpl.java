/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import com.safi.core.saflet.SafletException;

import com.safi.core.scripting.SafletScriptException;
import com.safi.core.scripting.ScriptScope;
import com.safi.core.scripting.ScriptingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Scope</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.scripting.impl.ScriptScopeImpl#getScopeObject <em>Scope Object</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ScriptScopeImpl extends EObjectImpl implements ScriptScope {
  /**
	 * The default value of the '{@link #getScopeObject() <em>Scope Object</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getScopeObject()
	 * @generated
	 * @ordered
	 */
  protected static final Object SCOPE_OBJECT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getScopeObject() <em>Scope Object</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getScopeObject()
	 * @generated
	 * @ordered
	 */
  protected Object scopeObject = SCOPE_OBJECT_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ScriptScopeImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ScriptingPackage.Literals.SCRIPT_SCOPE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object getScopeObject() {
		return scopeObject;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setScopeObject(Object newScopeObject) {
		Object oldScopeObject = scopeObject;
		scopeObject = newScopeObject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ScriptingPackage.SCRIPT_SCOPE__SCOPE_OBJECT, oldScopeObject, scopeObject));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void exposeObjectToScript(String name, Object value) throws SafletScriptException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void removeObjectFromScope(String name) throws SafletScriptException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Object getScopedObject(String name) throws SafletException {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ScriptingPackage.SCRIPT_SCOPE__SCOPE_OBJECT:
				return getScopeObject();
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
			case ScriptingPackage.SCRIPT_SCOPE__SCOPE_OBJECT:
				setScopeObject(newValue);
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
			case ScriptingPackage.SCRIPT_SCOPE__SCOPE_OBJECT:
				setScopeObject(SCOPE_OBJECT_EDEFAULT);
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
			case ScriptingPackage.SCRIPT_SCOPE__SCOPE_OBJECT:
				return SCOPE_OBJECT_EDEFAULT == null ? scopeObject != null : !SCOPE_OBJECT_EDEFAULT.equals(scopeObject);
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
		result.append(" (scopeObject: ");
		result.append(scopeObject);
		result.append(')');
		return result.toString();
	}

} //ScriptScopeImpl
