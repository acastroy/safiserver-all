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
import com.safi.asterisk.actionstep.MixMonitor;

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
 * An implementation of the model object '<em><b>Mix Monitor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MixMonitorImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MixMonitorImpl#getFilename <em>Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MixMonitorImpl#isRecordOnlyWhenBridged <em>Record Only When Bridged</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MixMonitorImpl#isAppendMode <em>Append Mode</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MixMonitorImpl extends ActionStepImpl implements MixMonitor {
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
   * The cached value of the '{@link #getFilename() <em>Filename</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFilename()
   * @generated
   * @ordered
   */
  protected DynamicValue filename;

  /**
   * The default value of the '{@link #isRecordOnlyWhenBridged() <em>Record Only When Bridged</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRecordOnlyWhenBridged()
   * @generated
   * @ordered
   */
  protected static final boolean RECORD_ONLY_WHEN_BRIDGED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRecordOnlyWhenBridged() <em>Record Only When Bridged</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRecordOnlyWhenBridged()
   * @generated
   * @ordered
   */
  protected boolean recordOnlyWhenBridged = RECORD_ONLY_WHEN_BRIDGED_EDEFAULT;

  /**
   * The default value of the '{@link #isAppendMode() <em>Append Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAppendMode()
   * @generated
   * @ordered
   */
  protected static final boolean APPEND_MODE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAppendMode() <em>Append Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAppendMode()
   * @generated
   * @ordered
   */
  protected boolean appendMode = APPEND_MODE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MixMonitorImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionstepPackage.Literals.MIX_MONITOR;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.MIX_MONITOR__CALL1, oldCall1, call1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MIX_MONITOR__CALL1, oldCall1, call1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getFilename() {
    return filename;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFilename(DynamicValue newFilename, NotificationChain msgs) {
    DynamicValue oldFilename = filename;
    filename = newFilename;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.MIX_MONITOR__FILENAME, oldFilename, newFilename);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFilename(DynamicValue newFilename) {
    if (newFilename != filename) {
      NotificationChain msgs = null;
      if (filename != null)
        msgs = ((InternalEObject)filename).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.MIX_MONITOR__FILENAME, null, msgs);
      if (newFilename != null)
        msgs = ((InternalEObject)newFilename).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.MIX_MONITOR__FILENAME, null, msgs);
      msgs = basicSetFilename(newFilename, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MIX_MONITOR__FILENAME, newFilename, newFilename));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRecordOnlyWhenBridged() {
    return recordOnlyWhenBridged;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRecordOnlyWhenBridged(boolean newRecordOnlyWhenBridged) {
    boolean oldRecordOnlyWhenBridged = recordOnlyWhenBridged;
    recordOnlyWhenBridged = newRecordOnlyWhenBridged;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MIX_MONITOR__RECORD_ONLY_WHEN_BRIDGED, oldRecordOnlyWhenBridged, recordOnlyWhenBridged));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAppendMode() {
    return appendMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAppendMode(boolean newAppendMode) {
    boolean oldAppendMode = appendMode;
    appendMode = newAppendMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MIX_MONITOR__APPEND_MODE, oldAppendMode, appendMode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionstepPackage.MIX_MONITOR__FILENAME:
        return basicSetFilename(null, msgs);
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
      case ActionstepPackage.MIX_MONITOR__CALL1:
        if (resolve) return getCall1();
        return basicGetCall1();
      case ActionstepPackage.MIX_MONITOR__FILENAME:
        return getFilename();
      case ActionstepPackage.MIX_MONITOR__RECORD_ONLY_WHEN_BRIDGED:
        return isRecordOnlyWhenBridged() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MIX_MONITOR__APPEND_MODE:
        return isAppendMode() ? Boolean.TRUE : Boolean.FALSE;
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
      case ActionstepPackage.MIX_MONITOR__CALL1:
        setCall1((Call)newValue);
        return;
      case ActionstepPackage.MIX_MONITOR__FILENAME:
        setFilename((DynamicValue)newValue);
        return;
      case ActionstepPackage.MIX_MONITOR__RECORD_ONLY_WHEN_BRIDGED:
        setRecordOnlyWhenBridged(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MIX_MONITOR__APPEND_MODE:
        setAppendMode(((Boolean)newValue).booleanValue());
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
      case ActionstepPackage.MIX_MONITOR__CALL1:
        setCall1((Call)null);
        return;
      case ActionstepPackage.MIX_MONITOR__FILENAME:
        setFilename((DynamicValue)null);
        return;
      case ActionstepPackage.MIX_MONITOR__RECORD_ONLY_WHEN_BRIDGED:
        setRecordOnlyWhenBridged(RECORD_ONLY_WHEN_BRIDGED_EDEFAULT);
        return;
      case ActionstepPackage.MIX_MONITOR__APPEND_MODE:
        setAppendMode(APPEND_MODE_EDEFAULT);
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
      case ActionstepPackage.MIX_MONITOR__CALL1:
        return call1 != null;
      case ActionstepPackage.MIX_MONITOR__FILENAME:
        return filename != null;
      case ActionstepPackage.MIX_MONITOR__RECORD_ONLY_WHEN_BRIDGED:
        return recordOnlyWhenBridged != RECORD_ONLY_WHEN_BRIDGED_EDEFAULT;
      case ActionstepPackage.MIX_MONITOR__APPEND_MODE:
        return appendMode != APPEND_MODE_EDEFAULT;
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
        case ActionstepPackage.MIX_MONITOR__CALL1: return AsteriskPackage.CALL_CONSUMER1__CALL1;
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
        case AsteriskPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.MIX_MONITOR__CALL1;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
    result.append(" (recordOnlyWhenBridged: ");
    result.append(recordOnlyWhenBridged);
    result.append(", appendMode: ");
    result.append(appendMode);
    result.append(')');
    return result.toString();
  }

} //MixMonitorImpl
