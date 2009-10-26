/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import org.asteriskjava.fastagi.AgiChannel;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallConsumer1;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.SetContext;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.db.VariableType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.SetContextImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.SetContextImpl#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetContextImpl extends ActionStepImpl implements SetContext {
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
   * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getContext()
   * @generated
   * @ordered
   */
  protected DynamicValue context;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SetContextImpl() {
    super();
  }

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {
    super.beginProcessing(context);
    if (call1 == null || call1.getChannel() == null) {
      handleException(context, new ActionStepException(call1 == null ? "No current call found" : "No channel found in current context"));
      return;
    }
    AgiChannel channel = call1.getChannel();
    try {
      String valueStr = (String)VariableTranslator.translateValue(VariableType.TEXT, resolveDynamicValue(value, context));
      String varStr = (String)VariableTranslator.translateValue(VariableType.TEXT, variable);
      if (debugLog.isDebugEnabled()) {
        debug("Setting Asterisk channel variable "+varStr+" to value "+valueStr +" for channel "+ channel.getName());
      }
      channel.setVariable(varStr, valueStr);
    } catch (Exception e) {
      handleException(context, e);
      return;
    }

    handleSuccess(context);
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionstepPackage.Literals.SET_CONTEXT;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.SET_CONTEXT__CALL1, oldCall1, call1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.SET_CONTEXT__CALL1, oldCall1, call1));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.SET_CONTEXT__CONTEXT, oldContext, newContext);
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
        msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.SET_CONTEXT__CONTEXT, null, msgs);
      if (newContext != null)
        msgs = ((InternalEObject)newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.SET_CONTEXT__CONTEXT, null, msgs);
      msgs = basicSetContext(newContext, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.SET_CONTEXT__CONTEXT, newContext, newContext));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionstepPackage.SET_CONTEXT__CONTEXT:
        return basicSetContext(null, msgs);
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
      case ActionstepPackage.SET_CONTEXT__CALL1:
        if (resolve) return getCall1();
        return basicGetCall1();
      case ActionstepPackage.SET_CONTEXT__CONTEXT:
        return getContext();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ActionstepPackage.SET_CONTEXT__CALL1:
        setCall1((Call)newValue);
        return;
      case ActionstepPackage.SET_CONTEXT__CONTEXT:
        setContext((DynamicValue)newValue);
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
      case ActionstepPackage.SET_CONTEXT__CALL1:
        setCall1((Call)null);
        return;
      case ActionstepPackage.SET_CONTEXT__CONTEXT:
        setContext((DynamicValue)null);
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
      case ActionstepPackage.SET_CONTEXT__CALL1:
        return call1 != null;
      case ActionstepPackage.SET_CONTEXT__CONTEXT:
        return context != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == CallConsumer1.class) {
      switch (derivedFeatureID) {
        case ActionstepPackage.SET_CONTEXT__CALL1: return AsteriskPackage.CALL_CONSUMER1__CALL1;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == CallConsumer1.class) {
      switch (baseFeatureID) {
        case AsteriskPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.SET_CONTEXT__CALL1;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //SetContextImpl
