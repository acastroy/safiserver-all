/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import com.safi.core.scripting.ScriptScope;
import com.safi.core.scripting.ScriptScopeFactory;
import com.safi.core.scripting.ScriptingPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Script Scope Factory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.scripting.impl.ScriptScopeFactoryImpl#getScriptScope <em>Script Scope</em>}</li>
 *   <li>{@link com.safi.core.scripting.impl.ScriptScopeFactoryImpl#getGlobalScriptScope <em>Global Script Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ScriptScopeFactoryImpl extends EObjectImpl implements ScriptScopeFactory {
  /**
   * The cached value of the '{@link #getScriptScope() <em>Script Scope</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScriptScope()
   * @generated
   * @ordered
   */
  protected ScriptScope scriptScope;

  /**
   * The cached value of the '{@link #getGlobalScriptScope() <em>Global Script Scope</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getGlobalScriptScope()
   * @generated
   * @ordered
   */
  protected ScriptScope globalScriptScope;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ScriptScopeFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ScriptingPackage.Literals.SCRIPT_SCOPE_FACTORY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptScope getScriptScope() {
    if (scriptScope != null && scriptScope.eIsProxy()) {
      InternalEObject oldScriptScope = (InternalEObject)scriptScope;
      scriptScope = (ScriptScope)eResolveProxy(oldScriptScope);
      if (scriptScope != oldScriptScope) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScriptingPackage.SCRIPT_SCOPE_FACTORY__SCRIPT_SCOPE, oldScriptScope, scriptScope));
      }
    }
    return scriptScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptScope basicGetScriptScope() {
    return scriptScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScriptScope(ScriptScope newScriptScope) {
    ScriptScope oldScriptScope = scriptScope;
    scriptScope = newScriptScope;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ScriptingPackage.SCRIPT_SCOPE_FACTORY__SCRIPT_SCOPE, oldScriptScope, scriptScope));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptScope getGlobalScriptScope() {
    if (globalScriptScope != null && globalScriptScope.eIsProxy()) {
      InternalEObject oldGlobalScriptScope = (InternalEObject)globalScriptScope;
      globalScriptScope = (ScriptScope)eResolveProxy(oldGlobalScriptScope);
      if (globalScriptScope != oldGlobalScriptScope) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScriptingPackage.SCRIPT_SCOPE_FACTORY__GLOBAL_SCRIPT_SCOPE, oldGlobalScriptScope, globalScriptScope));
      }
    }
    return globalScriptScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptScope basicGetGlobalScriptScope() {
    return globalScriptScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setGlobalScriptScope(ScriptScope newGlobalScriptScope) {
    ScriptScope oldGlobalScriptScope = globalScriptScope;
    globalScriptScope = newGlobalScriptScope;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ScriptingPackage.SCRIPT_SCOPE_FACTORY__GLOBAL_SCRIPT_SCOPE, oldGlobalScriptScope, globalScriptScope));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ScriptingPackage.SCRIPT_SCOPE_FACTORY__SCRIPT_SCOPE:
        if (resolve) return getScriptScope();
        return basicGetScriptScope();
      case ScriptingPackage.SCRIPT_SCOPE_FACTORY__GLOBAL_SCRIPT_SCOPE:
        if (resolve) return getGlobalScriptScope();
        return basicGetGlobalScriptScope();
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
      case ScriptingPackage.SCRIPT_SCOPE_FACTORY__SCRIPT_SCOPE:
        setScriptScope((ScriptScope)newValue);
        return;
      case ScriptingPackage.SCRIPT_SCOPE_FACTORY__GLOBAL_SCRIPT_SCOPE:
        setGlobalScriptScope((ScriptScope)newValue);
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
      case ScriptingPackage.SCRIPT_SCOPE_FACTORY__SCRIPT_SCOPE:
        setScriptScope((ScriptScope)null);
        return;
      case ScriptingPackage.SCRIPT_SCOPE_FACTORY__GLOBAL_SCRIPT_SCOPE:
        setGlobalScriptScope((ScriptScope)null);
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
      case ScriptingPackage.SCRIPT_SCOPE_FACTORY__SCRIPT_SCOPE:
        return scriptScope != null;
      case ScriptingPackage.SCRIPT_SCOPE_FACTORY__GLOBAL_SCRIPT_SCOPE:
        return globalScriptScope != null;
    }
    return super.eIsSet(featureID);
  }

} //ScriptScopeFactoryImpl
