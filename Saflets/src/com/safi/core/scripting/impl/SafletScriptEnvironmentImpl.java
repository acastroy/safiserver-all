/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.scripting.impl;

import com.safi.core.scripting.SafletScript;
import com.safi.core.scripting.SafletScriptEnvironment;
import com.safi.core.scripting.SafletScriptFactory;
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
 * An implementation of the model object '<em><b>Saflet Script Environment</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.scripting.impl.SafletScriptEnvironmentImpl#getSharedSafletScript <em>Shared Saflet Script</em>}</li>
 *   <li>{@link com.safi.core.scripting.impl.SafletScriptEnvironmentImpl#getSharedScriptScope <em>Shared Script Scope</em>}</li>
 *   <li>{@link com.safi.core.scripting.impl.SafletScriptEnvironmentImpl#getSafletScriptFactory <em>Saflet Script Factory</em>}</li>
 *   <li>{@link com.safi.core.scripting.impl.SafletScriptEnvironmentImpl#getScriptScopeFactory <em>Script Scope Factory</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SafletScriptEnvironmentImpl extends EObjectImpl implements SafletScriptEnvironment {
  /**
   * The cached value of the '{@link #getSharedSafletScript() <em>Shared Saflet Script</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSharedSafletScript()
   * @generated
   * @ordered
   */
  protected SafletScript sharedSafletScript;

  /**
   * The cached value of the '{@link #getSharedScriptScope() <em>Shared Script Scope</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSharedScriptScope()
   * @generated
   * @ordered
   */
  protected ScriptScope sharedScriptScope;

  /**
   * The cached value of the '{@link #getSafletScriptFactory() <em>Saflet Script Factory</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSafletScriptFactory()
   * @generated
   * @ordered
   */
  protected SafletScriptFactory safletScriptFactory;

  /**
   * The cached value of the '{@link #getScriptScopeFactory() <em>Script Scope Factory</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScriptScopeFactory()
   * @generated
   * @ordered
   */
  protected ScriptScopeFactory scriptScopeFactory;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SafletScriptEnvironmentImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ScriptingPackage.Literals.SAFLET_SCRIPT_ENVIRONMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SafletScript getSharedSafletScript() {
    if (sharedSafletScript != null && sharedSafletScript.eIsProxy()) {
      InternalEObject oldSharedSafletScript = (InternalEObject)sharedSafletScript;
      sharedSafletScript = (SafletScript)eResolveProxy(oldSharedSafletScript);
      if (sharedSafletScript != oldSharedSafletScript) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SAFLET_SCRIPT, oldSharedSafletScript, sharedSafletScript));
      }
    }
    return sharedSafletScript;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SafletScript basicGetSharedSafletScript() {
    return sharedSafletScript;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSharedSafletScript(SafletScript newSharedSafletScript) {
    SafletScript oldSharedSafletScript = sharedSafletScript;
    sharedSafletScript = newSharedSafletScript;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SAFLET_SCRIPT, oldSharedSafletScript, sharedSafletScript));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptScope getSharedScriptScope() {
    if (sharedScriptScope != null && sharedScriptScope.eIsProxy()) {
      InternalEObject oldSharedScriptScope = (InternalEObject)sharedScriptScope;
      sharedScriptScope = (ScriptScope)eResolveProxy(oldSharedScriptScope);
      if (sharedScriptScope != oldSharedScriptScope) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SCRIPT_SCOPE, oldSharedScriptScope, sharedScriptScope));
      }
    }
    return sharedScriptScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptScope basicGetSharedScriptScope() {
    return sharedScriptScope;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSharedScriptScope(ScriptScope newSharedScriptScope) {
    ScriptScope oldSharedScriptScope = sharedScriptScope;
    sharedScriptScope = newSharedScriptScope;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SCRIPT_SCOPE, oldSharedScriptScope, sharedScriptScope));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SafletScriptFactory getSafletScriptFactory() {
    if (safletScriptFactory != null && safletScriptFactory.eIsProxy()) {
      InternalEObject oldSafletScriptFactory = (InternalEObject)safletScriptFactory;
      safletScriptFactory = (SafletScriptFactory)eResolveProxy(oldSafletScriptFactory);
      if (safletScriptFactory != oldSafletScriptFactory) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SAFLET_SCRIPT_FACTORY, oldSafletScriptFactory, safletScriptFactory));
      }
    }
    return safletScriptFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SafletScriptFactory basicGetSafletScriptFactory() {
    return safletScriptFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSafletScriptFactory(SafletScriptFactory newSafletScriptFactory) {
    SafletScriptFactory oldSafletScriptFactory = safletScriptFactory;
    safletScriptFactory = newSafletScriptFactory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SAFLET_SCRIPT_FACTORY, oldSafletScriptFactory, safletScriptFactory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptScopeFactory getScriptScopeFactory() {
    if (scriptScopeFactory != null && scriptScopeFactory.eIsProxy()) {
      InternalEObject oldScriptScopeFactory = (InternalEObject)scriptScopeFactory;
      scriptScopeFactory = (ScriptScopeFactory)eResolveProxy(oldScriptScopeFactory);
      if (scriptScopeFactory != oldScriptScopeFactory) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SCRIPT_SCOPE_FACTORY, oldScriptScopeFactory, scriptScopeFactory));
      }
    }
    return scriptScopeFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ScriptScopeFactory basicGetScriptScopeFactory() {
    return scriptScopeFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScriptScopeFactory(ScriptScopeFactory newScriptScopeFactory) {
    ScriptScopeFactory oldScriptScopeFactory = scriptScopeFactory;
    scriptScopeFactory = newScriptScopeFactory;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SCRIPT_SCOPE_FACTORY, oldScriptScopeFactory, scriptScopeFactory));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SAFLET_SCRIPT:
        if (resolve) return getSharedSafletScript();
        return basicGetSharedSafletScript();
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SCRIPT_SCOPE:
        if (resolve) return getSharedScriptScope();
        return basicGetSharedScriptScope();
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SAFLET_SCRIPT_FACTORY:
        if (resolve) return getSafletScriptFactory();
        return basicGetSafletScriptFactory();
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SCRIPT_SCOPE_FACTORY:
        if (resolve) return getScriptScopeFactory();
        return basicGetScriptScopeFactory();
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
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SAFLET_SCRIPT:
        setSharedSafletScript((SafletScript)newValue);
        return;
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SCRIPT_SCOPE:
        setSharedScriptScope((ScriptScope)newValue);
        return;
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SAFLET_SCRIPT_FACTORY:
        setSafletScriptFactory((SafletScriptFactory)newValue);
        return;
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SCRIPT_SCOPE_FACTORY:
        setScriptScopeFactory((ScriptScopeFactory)newValue);
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
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SAFLET_SCRIPT:
        setSharedSafletScript((SafletScript)null);
        return;
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SCRIPT_SCOPE:
        setSharedScriptScope((ScriptScope)null);
        return;
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SAFLET_SCRIPT_FACTORY:
        setSafletScriptFactory((SafletScriptFactory)null);
        return;
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SCRIPT_SCOPE_FACTORY:
        setScriptScopeFactory((ScriptScopeFactory)null);
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
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SAFLET_SCRIPT:
        return sharedSafletScript != null;
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SHARED_SCRIPT_SCOPE:
        return sharedScriptScope != null;
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SAFLET_SCRIPT_FACTORY:
        return safletScriptFactory != null;
      case ScriptingPackage.SAFLET_SCRIPT_ENVIRONMENT__SCRIPT_SCOPE_FACTORY:
        return scriptScopeFactory != null;
    }
    return super.eIsSet(featureID);
  }

} //SafletScriptEnvironmentImpl
