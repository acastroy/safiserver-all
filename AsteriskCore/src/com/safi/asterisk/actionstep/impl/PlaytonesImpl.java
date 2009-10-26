/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;

import com.safi.asterisk.CallConsumer1;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.Playtones;

import com.safi.core.CorePackage;
import com.safi.core.ProductIdentifiable;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.actionstep.Output;

import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletPackage;

import com.safi.core.scripting.SafletScriptException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Playtones</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.PlaytonesImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.PlaytonesImpl#getTones <em>Tones</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlaytonesImpl extends ActionStepImpl implements Playtones {
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
   * The cached value of the '{@link #getTones() <em>Tones</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTones()
   * @generated
   * @ordered
   */
  protected DynamicValue tones;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PlaytonesImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionstepPackage.Literals.PLAYTONES;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.PLAYTONES__CALL1, oldCall1, call1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLAYTONES__CALL1, oldCall1, call1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getTones() {
    return tones;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTones(DynamicValue newTones, NotificationChain msgs) {
    DynamicValue oldTones = tones;
    tones = newTones;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLAYTONES__TONES, oldTones, newTones);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTones(DynamicValue newTones) {
    if (newTones != tones) {
      NotificationChain msgs = null;
      if (tones != null)
        msgs = ((InternalEObject)tones).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLAYTONES__TONES, null, msgs);
      if (newTones != null)
        msgs = ((InternalEObject)newTones).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLAYTONES__TONES, null, msgs);
      msgs = basicSetTones(newTones, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLAYTONES__TONES, newTones, newTones));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionstepPackage.PLAYTONES__TONES:
        return basicSetTones(null, msgs);
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
      case ActionstepPackage.PLAYTONES__CALL1:
        if (resolve) return getCall1();
        return basicGetCall1();
      case ActionstepPackage.PLAYTONES__TONES:
        return getTones();
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
      case ActionstepPackage.PLAYTONES__CALL1:
        setCall1((Call)newValue);
        return;
      case ActionstepPackage.PLAYTONES__TONES:
        setTones((DynamicValue)newValue);
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
      case ActionstepPackage.PLAYTONES__CALL1:
        setCall1((Call)null);
        return;
      case ActionstepPackage.PLAYTONES__TONES:
        setTones((DynamicValue)null);
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
      case ActionstepPackage.PLAYTONES__CALL1:
        return call1 != null;
      case ActionstepPackage.PLAYTONES__TONES:
        return tones != null;
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
        case ActionstepPackage.PLAYTONES__CALL1: return AsteriskPackage.CALL_CONSUMER1__CALL1;
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
        case AsteriskPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.PLAYTONES__CALL1;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //PlaytonesImpl
