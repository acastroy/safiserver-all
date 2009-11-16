/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.saflet.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletException;
import com.safi.core.saflet.SafletPackage;
import com.safi.db.Variable;
import com.safi.db.VariableScope;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Context</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link com.safi.core.saflet.impl.SafletContextImpl#getExceptions <em>Exceptions
 * </em>}</li>
 * <li>{@link com.safi.core.saflet.impl.SafletContextImpl#getParentSaflet <em>Parent
 * Saflet</em>}</li>
 * <li>{@link com.safi.core.saflet.impl.SafletContextImpl#getVariables <em>Variables</em>}
 * </li>
 * <li>{@link com.safi.core.saflet.impl.SafletContextImpl#getSessionVariables <em>Session
 * Variables</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public abstract class SafletContextImpl extends EObjectImpl implements SafletContext {

  private final static Logger log = Logger.getLogger(SafletContextImpl.class);
  /**
   * The cached value of the '{@link #getExceptions() <em>Exceptions</em>}' attribute
   * list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getExceptions()
   * @generated
   * @ordered
   */
  protected EList<Exception> exceptions;

  /**
   * The cached value of the '{@link #getParentSaflet() <em>Parent Saflet</em>}'
   * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getParentSaflet()
   * @generated
   * @ordered
   */
  protected Saflet parentSaflet;

  /**
   * The cached value of the '{@link #getVariables() <em>Variables</em>}' containment
   * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getVariables()
   * @generated
   * @ordered
   */
  protected EList<Variable> variables;

  /**
   * The cached value of the '{@link #getSessionVariables() <em>Session Variables</em>}'
   * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getSessionVariables()
   * @generated
   * @ordered
   */
  protected Map<String, Object> sessionVariables;

  protected Object debugLock;
  private Object suspendedLock;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  protected SafletContextImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return SafletPackage.Literals.SAFLET_CONTEXT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EList<Exception> getExceptions() {
    if (exceptions == null) {
      exceptions = new EDataTypeUniqueEList<Exception>(Exception.class, this,
          SafletPackage.SAFLET_CONTEXT__EXCEPTIONS);
    }
    return exceptions;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Saflet getParentSaflet() {
    if (parentSaflet != null && parentSaflet.eIsProxy()) {
      InternalEObject oldParentSaflet = (InternalEObject) parentSaflet;
      parentSaflet = (Saflet) eResolveProxy(oldParentSaflet);
      if (parentSaflet != oldParentSaflet) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE,
              SafletPackage.SAFLET_CONTEXT__PARENT_SAFLET, oldParentSaflet, parentSaflet));
      }
    }
    return parentSaflet;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Saflet basicGetParentSaflet() {
    return parentSaflet;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setParentSaflet(Saflet newParentSaflet) {
    Saflet oldParentSaflet = parentSaflet;
    parentSaflet = newParentSaflet;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          SafletPackage.SAFLET_CONTEXT__PARENT_SAFLET, oldParentSaflet, parentSaflet));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EList<Variable> getVariables() {
    if (variables == null) {
      variables = new EObjectContainmentEList<Variable>(Variable.class, this,
          SafletPackage.SAFLET_CONTEXT__VARIABLES);
    }
    return variables;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Map<String, Object> getSessionVariables() {
    return sessionVariables;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void setSessionVariables(Map<String, Object> newSessionVariables) {
    Map<String, Object> oldSessionVariables = sessionVariables;
    sessionVariables = newSessionVariables;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          SafletPackage.SAFLET_CONTEXT__SESSION_VARIABLES, oldSessionVariables, sessionVariables));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void init() {
    if (parentSaflet == null)
      throw new SafletContextException(
          "Attempted to initiate SafletContext with null parent Saflet");
    if (variables != null && variables.size() > 0) {
      for (Variable entry : variables) {
        parentSaflet.getSafletScope()
            .exposeObjectToScript(entry.getName(), entry.getDefaultValue());
      }
    }
    // parentSaflet.getSafletScope().exposeObjectToScript
    // for (Variable entry : parentSaflet.getSafletEnvironment().getGlobalVariables()){
    // parentSaflet.getSafletScope().exposeObjectToScript(entry.getName(),
    // entry.getDefaultValue());`
    // }

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Variable getVariable(String name) {
    if (name == null)
      return null;
    for (Variable v : getVariables()) {
      if (name.equals(v.getName()))
        return v;
    }
    if (getParentSaflet() != null && getParentSaflet().getSafletEnvironment() != null)
    	return getParentSaflet().getSafletEnvironment().getGlobalVariable(name);
    
    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Object getVariableRawValue(String name) {
    if (parentSaflet != null && parentSaflet.getSafletScope() != null) {
      try {
        return parentSaflet.getSafletScope().getScopedObject(name);
      } catch (SafletException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        log.error("Couldn't get variable raw value with name " + name, e);
      }
    }
    Variable v = getVariable(name);

    return v == null ? null : v.getDefaultValue();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void setVariableRawValue(String name, Object value) {
    if (isDebugging()) {
      // we're debuggin
      Variable v = getVariable(name);
      if (v != null) {
        v.setDefaultValue(value);
      }
    } else {
    	Variable v = getVariable(name);
      if (v != null) {
      	if (v.getScope() == VariableScope.GLOBAL){
      		parentSaflet.getSafletEnvironment().setGlobalVariableValue(name, value);
      	}
      	else
      		v.setDefaultValue(value);
      }
    }
    if (parentSaflet != null && parentSaflet.getSafletScope() != null) {// && newVar){
      parentSaflet.getSafletScope().exposeObjectToScript(name, value);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void addOrUpdateVariable(Variable v) {

    Variable v2 = getVariable(v.getName());
    if (v2 != v) {
      if (log.isDebugEnabled())
        log.debug("Saflet context setting var " + v);
      removeVariable(v.getName());
      getVariables().add(v);
    }
    if (parentSaflet != null && parentSaflet.getSafletScope() != null) {// && newVar){
      parentSaflet.getSafletScope().exposeObjectToScript(v.getName(), v.getDefaultValue());
    }
    // if (eNotificationRequired())
    // eNotify(new ENotificationImpl(this, Notification.ADD,
    // SafletPackage.HANDLER_CONTEXT__VARIABLES, v2, v));

  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Variable removeVariable(String name) {
    if (variables == null)
      return null;
    Variable removed = getVariable(name);
    if (removed != null)
    	variables.remove(removed);
    
//    for (Iterator<Variable> iter = variables.iterator(); iter.hasNext();) {
//      Variable v = iter.next();
//      if (name.equals(v.getName())) {
//        iter.remove();
//        removed = v;
//        break;
//      }
//    }
    
    if (removed != null && parentSaflet != null && parentSaflet.getSafletScope() != null) {
      parentSaflet.getSafletScope().removeObjectFromScope(name);
    }
    
    // if (eNotificationRequired())
    // eNotify(new ENotificationImpl(this, Notification.REMOVE,
    // SafletPackage.HANDLER_CONTEXT__VARIABLES, removed, null));
    return removed;
  }

  @Override
  public void touchVariables() {
    for (Variable v : getVariables()) {
      v.touch();
    }
  }

  @Override
  public EList<Variable> getLocalVariables() {
    EList<Variable> result = new BasicEList<Variable>();
    for (Variable v : getVariables()) {
      if (v.getScope() == VariableScope.LOCAL)
        result.add(v);
    }
    return result;
  }

  @Override
  public EList<Variable> getRuntimeVariables() {
    EList<Variable> result = new BasicEList<Variable>();
    for (Variable v : getVariables()) {
      if (v.getScope() == VariableScope.RUNTIME)
        result.add(v);
    }
    return result;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void addException(Exception e) {
    if (exceptions == null)
      exceptions = new BasicEList<Exception>();
    exceptions.add(e);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public void merge(SafletContext context) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public Object getSessionVar(String name) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    Map<String, Object> map = getSessionVariables();
    if (map == null)
      return null;
    return map.get(name);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void setSessionVar(String name, Object value) {
    Map<String, Object> map = getSessionVariables();
    if (map == null) {
      map = new HashMap<String, Object>();
      setSessionVariables(map);
    }
    map.put(name, value);
  }

  public Object getDebugLock() {
    return debugLock;
  }

  public void setDebugLock(Object debugLock) {
    this.debugLock = debugLock;
  }

  @Override
  public void suspendDebugLock() {
    this.suspendedLock = debugLock;
    this.debugLock = null;

  }

  @Override
  public Object restoreDebugLock() {
    debugLock = suspendedLock;
    suspendedLock = null;
    return debugLock;
  }

  @Override
  public boolean isDebugging() {
    return debugLock != null  || suspendedLock != null;
  }
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
      case SafletPackage.SAFLET_CONTEXT__VARIABLES:
        return ((InternalEList<?>) getVariables()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case SafletPackage.SAFLET_CONTEXT__EXCEPTIONS:
        return getExceptions();
      case SafletPackage.SAFLET_CONTEXT__PARENT_SAFLET:
        if (resolve)
          return getParentSaflet();
        return basicGetParentSaflet();
      case SafletPackage.SAFLET_CONTEXT__VARIABLES:
        return getVariables();
      case SafletPackage.SAFLET_CONTEXT__SESSION_VARIABLES:
        return getSessionVariables();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case SafletPackage.SAFLET_CONTEXT__PARENT_SAFLET:
        setParentSaflet((Saflet) newValue);
        return;
      case SafletPackage.SAFLET_CONTEXT__VARIABLES:
        getVariables().clear();
        getVariables().addAll((Collection<? extends Variable>) newValue);
        return;
      case SafletPackage.SAFLET_CONTEXT__SESSION_VARIABLES:
        setSessionVariables((Map<String, Object>) newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case SafletPackage.SAFLET_CONTEXT__PARENT_SAFLET:
        setParentSaflet((Saflet) null);
        return;
      case SafletPackage.SAFLET_CONTEXT__VARIABLES:
        getVariables().clear();
        return;
      case SafletPackage.SAFLET_CONTEXT__SESSION_VARIABLES:
        setSessionVariables((Map<String, Object>) null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case SafletPackage.SAFLET_CONTEXT__EXCEPTIONS:
        return exceptions != null && !exceptions.isEmpty();
      case SafletPackage.SAFLET_CONTEXT__PARENT_SAFLET:
        return parentSaflet != null;
      case SafletPackage.SAFLET_CONTEXT__VARIABLES:
        return variables != null && !variables.isEmpty();
      case SafletPackage.SAFLET_CONTEXT__SESSION_VARIABLES:
        return sessionVariables != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy())
      return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (exceptions: ");
    result.append(exceptions);
    result.append(", sessionVariables: ");
    result.append(sessionVariables);
    result.append(')');
    return result.toString();
  }

} // SafletContextImpl
