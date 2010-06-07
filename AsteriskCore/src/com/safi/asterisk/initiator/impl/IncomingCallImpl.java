/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.initiator.IncomingCall;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.core.call.CallPackage;
import com.safi.core.call.CallSource1;
import com.safi.core.call.SafiCall;
import com.safi.core.initiator.impl.InitiatorImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Incoming Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.initiator.impl.IncomingCallImpl#getNewCall1 <em>New Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.initiator.impl.IncomingCallImpl#getCallName <em>Call Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IncomingCallImpl extends AsteriskInitiatorImpl implements IncomingCall {
  /**
	 * The cached value of the '{@link #getNewCall1() <em>New Call1</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNewCall1()
	 * @generated
	 * @ordered
	 */
  protected SafiCall newCall1;

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
  protected IncomingCallImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return InitiatorPackage.Literals.INCOMING_CALL;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafiCall getNewCall1() {
		return newCall1;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNewCall1(SafiCall newNewCall1, NotificationChain msgs) {
		SafiCall oldNewCall1 = newCall1;
		newCall1 = newNewCall1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, InitiatorPackage.INCOMING_CALL__NEW_CALL1, oldNewCall1, newNewCall1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewCall1(SafiCall newNewCall1) {
		if (newNewCall1 != newCall1) {
			NotificationChain msgs = null;
			if (newCall1 != null)
				msgs = ((InternalEObject)newCall1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - InitiatorPackage.INCOMING_CALL__NEW_CALL1, null, msgs);
			if (newNewCall1 != null)
				msgs = ((InternalEObject)newNewCall1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - InitiatorPackage.INCOMING_CALL__NEW_CALL1, null, msgs);
			msgs = basicSetNewCall1(newNewCall1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, InitiatorPackage.INCOMING_CALL__NEW_CALL1, newNewCall1, newNewCall1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, InitiatorPackage.INCOMING_CALL__CALL_NAME, oldCallName, callName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case InitiatorPackage.INCOMING_CALL__NEW_CALL1:
				return basicSetNewCall1(null, msgs);
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
			case InitiatorPackage.INCOMING_CALL__NEW_CALL1:
				return getNewCall1();
			case InitiatorPackage.INCOMING_CALL__CALL_NAME:
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
			case InitiatorPackage.INCOMING_CALL__NEW_CALL1:
				setNewCall1((SafiCall)newValue);
				return;
			case InitiatorPackage.INCOMING_CALL__CALL_NAME:
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
			case InitiatorPackage.INCOMING_CALL__NEW_CALL1:
				setNewCall1((SafiCall)null);
				return;
			case InitiatorPackage.INCOMING_CALL__CALL_NAME:
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
			case InitiatorPackage.INCOMING_CALL__NEW_CALL1:
				return newCall1 != null;
			case InitiatorPackage.INCOMING_CALL__CALL_NAME:
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
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CallSource1.class) {
			switch (derivedFeatureID) {
				case InitiatorPackage.INCOMING_CALL__NEW_CALL1: return CallPackage.CALL_SOURCE1__NEW_CALL1;
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
		if (baseClass == CallSource1.class) {
			switch (baseFeatureID) {
				case CallPackage.CALL_SOURCE1__NEW_CALL1: return InitiatorPackage.INCOMING_CALL__NEW_CALL1;
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
		result.append(" (callName: ");
		result.append(callName);
		result.append(')');
		return result.toString();
	}

} //IncomingCallImpl
