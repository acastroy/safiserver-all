/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator.impl;

import com.safi.asterisk.Call;

import com.safi.asterisk.initiator.DIDMatcher;
import com.safi.asterisk.initiator.InitiatorPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>DID Matcher</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.initiator.impl.DIDMatcherImpl#getDNISPattern <em>DNIS Pattern</em>}</li>
 *   <li>{@link com.safi.asterisk.initiator.impl.DIDMatcherImpl#getCall <em>Call</em>}</li>
 *   <li>{@link com.safi.asterisk.initiator.impl.DIDMatcherImpl#getCallName <em>Call Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DIDMatcherImpl extends EObjectImpl implements DIDMatcher {
  /**
   * The default value of the '{@link #getDNISPattern() <em>DNIS Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDNISPattern()
   * @generated
   * @ordered
   */
  protected static final String DNIS_PATTERN_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDNISPattern() <em>DNIS Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDNISPattern()
   * @generated
   * @ordered
   */
  protected String dNISPattern = DNIS_PATTERN_EDEFAULT;

  /**
   * The cached value of the '{@link #getCall() <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall()
   * @generated
   * @ordered
   */
  protected Call call;

  /**
   * The default value of the '{@link #getCallName() <em>Call Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCallName()
   * @generated
   * @ordered
   */
  protected static final String CALL_NAME_EDEFAULT = "Call1";

  /**
   * The cached value of the '{@link #getCallName() <em>Call Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCallName()
   * @generated
   * @ordered
   */
  protected String callName = CALL_NAME_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DIDMatcherImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return InitiatorPackage.Literals.DID_MATCHER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getDNISPattern() {
    return dNISPattern;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDNISPattern(String newDNISPattern) {
    String oldDNISPattern = dNISPattern;
    dNISPattern = newDNISPattern;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InitiatorPackage.DID_MATCHER__DNIS_PATTERN, oldDNISPattern, dNISPattern));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call getCall() {
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCall(Call newCall, NotificationChain msgs) {
    Call oldCall = call;
    call = newCall;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InitiatorPackage.DID_MATCHER__CALL, oldCall, newCall);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall(Call newCall) {
    if (newCall != call) {
      NotificationChain msgs = null;
      if (call != null)
        msgs = ((InternalEObject)call).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InitiatorPackage.DID_MATCHER__CALL, null, msgs);
      if (newCall != null)
        msgs = ((InternalEObject)newCall).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InitiatorPackage.DID_MATCHER__CALL, null, msgs);
      msgs = basicSetCall(newCall, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InitiatorPackage.DID_MATCHER__CALL, newCall, newCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCallName() {
    return callName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCallName(String newCallName) {
    String oldCallName = callName;
    callName = newCallName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, InitiatorPackage.DID_MATCHER__CALL_NAME, oldCallName, callName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case InitiatorPackage.DID_MATCHER__CALL:
        return basicSetCall(null, msgs);
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
      case InitiatorPackage.DID_MATCHER__DNIS_PATTERN:
        return getDNISPattern();
      case InitiatorPackage.DID_MATCHER__CALL:
        return getCall();
      case InitiatorPackage.DID_MATCHER__CALL_NAME:
        return getCallName();
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
      case InitiatorPackage.DID_MATCHER__DNIS_PATTERN:
        setDNISPattern((String)newValue);
        return;
      case InitiatorPackage.DID_MATCHER__CALL:
        setCall((Call)newValue);
        return;
      case InitiatorPackage.DID_MATCHER__CALL_NAME:
        setCallName((String)newValue);
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
      case InitiatorPackage.DID_MATCHER__DNIS_PATTERN:
        setDNISPattern(DNIS_PATTERN_EDEFAULT);
        return;
      case InitiatorPackage.DID_MATCHER__CALL:
        setCall((Call)null);
        return;
      case InitiatorPackage.DID_MATCHER__CALL_NAME:
        setCallName(CALL_NAME_EDEFAULT);
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
      case InitiatorPackage.DID_MATCHER__DNIS_PATTERN:
        return DNIS_PATTERN_EDEFAULT == null ? dNISPattern != null : !DNIS_PATTERN_EDEFAULT.equals(dNISPattern);
      case InitiatorPackage.DID_MATCHER__CALL:
        return call != null;
      case InitiatorPackage.DID_MATCHER__CALL_NAME:
        return CALL_NAME_EDEFAULT == null ? callName != null : !CALL_NAME_EDEFAULT.equals(callName);
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
    result.append(" (dNISPattern: ");
    result.append(dNISPattern);
    result.append(", callName: ");
    result.append(callName);
    result.append(')');
    return result.toString();
  }

} //DIDMatcherImpl
