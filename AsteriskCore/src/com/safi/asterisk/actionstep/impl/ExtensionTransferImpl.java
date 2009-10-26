/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import com.safi.asterisk.Call;

import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.ExtensionTransfer;

import com.safi.core.actionstep.DynamicValue;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extension Transfer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getCall2 <em>Call2</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getContext <em>Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.ExtensionTransferImpl#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExtensionTransferImpl extends EObjectImpl implements ExtensionTransfer {
  /**
   * The cached value of the '{@link #getCall1() <em>Call1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall1()
   * @generated
   * @ordered
   */
  protected Call call1;

  /**
   * The cached value of the '{@link #getCall2() <em>Call2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall2()
   * @generated
   * @ordered
   */
  protected Call call2;

  /**
   * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContext()
   * @generated
   * @ordered
   */
  protected DynamicValue context;

  /**
   * The cached value of the '{@link #getExtension() <em>Extension</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtension()
   * @generated
   * @ordered
   */
  protected DynamicValue extension;

  /**
   * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected static final int PRIORITY_EDEFAULT = 1;

  /**
   * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPriority()
   * @generated
   * @ordered
   */
  protected int priority = PRIORITY_EDEFAULT;

  /**
   * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected static final long TIMEOUT_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected long timeout = TIMEOUT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExtensionTransferImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionstepPackage.Literals.EXTENSION_TRANSFER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call getCall1() {
    if (call1 != null && call1.eIsProxy()) {
      InternalEObject oldCall1 = (InternalEObject)call1;
      call1 = (Call)eResolveProxy(oldCall1);
      if (call1 != oldCall1) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.EXTENSION_TRANSFER__CALL1, oldCall1, call1));
      }
    }
    return call1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call basicGetCall1() {
    return call1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall1(Call newCall1) {
    Call oldCall1 = call1;
    call1 = newCall1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_TRANSFER__CALL1, oldCall1, call1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call getCall2() {
    if (call2 != null && call2.eIsProxy()) {
      InternalEObject oldCall2 = (InternalEObject)call2;
      call2 = (Call)eResolveProxy(oldCall2);
      if (call2 != oldCall2) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.EXTENSION_TRANSFER__CALL2, oldCall2, call2));
      }
    }
    return call2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call basicGetCall2() {
    return call2;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall2(Call newCall2) {
    Call oldCall2 = call2;
    call2 = newCall2;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_TRANSFER__CALL2, oldCall2, call2));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getContext() {
    return context;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContext(DynamicValue newContext, NotificationChain msgs) {
    DynamicValue oldContext = context;
    context = newContext;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_TRANSFER__CONTEXT, oldContext, newContext);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setContext(DynamicValue newContext) {
    if (newContext != context) {
      NotificationChain msgs = null;
      if (context != null)
        msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.EXTENSION_TRANSFER__CONTEXT, null, msgs);
      if (newContext != null)
        msgs = ((InternalEObject)newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.EXTENSION_TRANSFER__CONTEXT, null, msgs);
      msgs = basicSetContext(newContext, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_TRANSFER__CONTEXT, newContext, newContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getExtension() {
    return extension;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtension(DynamicValue newExtension, NotificationChain msgs) {
    DynamicValue oldExtension = extension;
    extension = newExtension;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_TRANSFER__EXTENSION, oldExtension, newExtension);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExtension(DynamicValue newExtension) {
    if (newExtension != extension) {
      NotificationChain msgs = null;
      if (extension != null)
        msgs = ((InternalEObject)extension).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.EXTENSION_TRANSFER__EXTENSION, null, msgs);
      if (newExtension != null)
        msgs = ((InternalEObject)newExtension).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.EXTENSION_TRANSFER__EXTENSION, null, msgs);
      msgs = basicSetExtension(newExtension, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_TRANSFER__EXTENSION, newExtension, newExtension));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getPriority() {
    return priority;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPriority(int newPriority) {
    int oldPriority = priority;
    priority = newPriority;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_TRANSFER__PRIORITY, oldPriority, priority));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public long getTimeout() {
    return timeout;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTimeout(long newTimeout) {
    long oldTimeout = timeout;
    timeout = newTimeout;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.EXTENSION_TRANSFER__TIMEOUT, oldTimeout, timeout));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionstepPackage.EXTENSION_TRANSFER__CONTEXT:
        return basicSetContext(null, msgs);
      case ActionstepPackage.EXTENSION_TRANSFER__EXTENSION:
        return basicSetExtension(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ActionstepPackage.EXTENSION_TRANSFER__CALL1:
        if (resolve) return getCall1();
        return basicGetCall1();
      case ActionstepPackage.EXTENSION_TRANSFER__CALL2:
        if (resolve) return getCall2();
        return basicGetCall2();
      case ActionstepPackage.EXTENSION_TRANSFER__CONTEXT:
        return getContext();
      case ActionstepPackage.EXTENSION_TRANSFER__EXTENSION:
        return getExtension();
      case ActionstepPackage.EXTENSION_TRANSFER__PRIORITY:
        return new Integer(getPriority());
      case ActionstepPackage.EXTENSION_TRANSFER__TIMEOUT:
        return new Long(getTimeout());
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
      case ActionstepPackage.EXTENSION_TRANSFER__CALL1:
        setCall1((Call)newValue);
        return;
      case ActionstepPackage.EXTENSION_TRANSFER__CALL2:
        setCall2((Call)newValue);
        return;
      case ActionstepPackage.EXTENSION_TRANSFER__CONTEXT:
        setContext((DynamicValue)newValue);
        return;
      case ActionstepPackage.EXTENSION_TRANSFER__EXTENSION:
        setExtension((DynamicValue)newValue);
        return;
      case ActionstepPackage.EXTENSION_TRANSFER__PRIORITY:
        setPriority(((Integer)newValue).intValue());
        return;
      case ActionstepPackage.EXTENSION_TRANSFER__TIMEOUT:
        setTimeout(((Long)newValue).longValue());
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
      case ActionstepPackage.EXTENSION_TRANSFER__CALL1:
        setCall1((Call)null);
        return;
      case ActionstepPackage.EXTENSION_TRANSFER__CALL2:
        setCall2((Call)null);
        return;
      case ActionstepPackage.EXTENSION_TRANSFER__CONTEXT:
        setContext((DynamicValue)null);
        return;
      case ActionstepPackage.EXTENSION_TRANSFER__EXTENSION:
        setExtension((DynamicValue)null);
        return;
      case ActionstepPackage.EXTENSION_TRANSFER__PRIORITY:
        setPriority(PRIORITY_EDEFAULT);
        return;
      case ActionstepPackage.EXTENSION_TRANSFER__TIMEOUT:
        setTimeout(TIMEOUT_EDEFAULT);
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
      case ActionstepPackage.EXTENSION_TRANSFER__CALL1:
        return call1 != null;
      case ActionstepPackage.EXTENSION_TRANSFER__CALL2:
        return call2 != null;
      case ActionstepPackage.EXTENSION_TRANSFER__CONTEXT:
        return context != null;
      case ActionstepPackage.EXTENSION_TRANSFER__EXTENSION:
        return extension != null;
      case ActionstepPackage.EXTENSION_TRANSFER__PRIORITY:
        return priority != PRIORITY_EDEFAULT;
      case ActionstepPackage.EXTENSION_TRANSFER__TIMEOUT:
        return timeout != TIMEOUT_EDEFAULT;
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
    result.append(" (priority: ");
    result.append(priority);
    result.append(", timeout: ");
    result.append(timeout);
    result.append(')');
    return result.toString();
  }

} //ExtensionTransferImpl
