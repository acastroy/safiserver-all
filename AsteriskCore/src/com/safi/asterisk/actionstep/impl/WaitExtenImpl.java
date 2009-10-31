/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallConsumer1;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.WaitExten;
import com.safi.core.actionstep.impl.ActionStepImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Wait Exten</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.WaitExtenImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.WaitExtenImpl#getMusicOnHoldClass <em>Music On Hold Class</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.WaitExtenImpl#getTimeout <em>Timeout</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WaitExtenImpl extends ActionStepImpl implements WaitExten {
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
	 * The default value of the '{@link #getMusicOnHoldClass() <em>Music On Hold Class</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMusicOnHoldClass()
	 * @generated
	 * @ordered
	 */
  protected static final String MUSIC_ON_HOLD_CLASS_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getMusicOnHoldClass() <em>Music On Hold Class</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMusicOnHoldClass()
	 * @generated
	 * @ordered
	 */
  protected String musicOnHoldClass = MUSIC_ON_HOLD_CLASS_EDEFAULT;

  /**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
  protected static final int TIMEOUT_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
  protected int timeout = TIMEOUT_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected WaitExtenImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionstepPackage.Literals.WAIT_EXTEN;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.WAIT_EXTEN__CALL1, oldCall1, call1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.WAIT_EXTEN__CALL1, oldCall1, call1));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getMusicOnHoldClass() {
		return musicOnHoldClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMusicOnHoldClass(String newMusicOnHoldClass) {
		String oldMusicOnHoldClass = musicOnHoldClass;
		musicOnHoldClass = newMusicOnHoldClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.WAIT_EXTEN__MUSIC_ON_HOLD_CLASS, oldMusicOnHoldClass, musicOnHoldClass));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getTimeout() {
		return timeout;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTimeout(int newTimeout) {
		int oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.WAIT_EXTEN__TIMEOUT, oldTimeout, timeout));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionstepPackage.WAIT_EXTEN__CALL1:
				if (resolve) return getCall1();
				return basicGetCall1();
			case ActionstepPackage.WAIT_EXTEN__MUSIC_ON_HOLD_CLASS:
				return getMusicOnHoldClass();
			case ActionstepPackage.WAIT_EXTEN__TIMEOUT:
				return getTimeout();
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
			case ActionstepPackage.WAIT_EXTEN__CALL1:
				setCall1((Call)newValue);
				return;
			case ActionstepPackage.WAIT_EXTEN__MUSIC_ON_HOLD_CLASS:
				setMusicOnHoldClass((String)newValue);
				return;
			case ActionstepPackage.WAIT_EXTEN__TIMEOUT:
				setTimeout((Integer)newValue);
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
			case ActionstepPackage.WAIT_EXTEN__CALL1:
				setCall1((Call)null);
				return;
			case ActionstepPackage.WAIT_EXTEN__MUSIC_ON_HOLD_CLASS:
				setMusicOnHoldClass(MUSIC_ON_HOLD_CLASS_EDEFAULT);
				return;
			case ActionstepPackage.WAIT_EXTEN__TIMEOUT:
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
			case ActionstepPackage.WAIT_EXTEN__CALL1:
				return call1 != null;
			case ActionstepPackage.WAIT_EXTEN__MUSIC_ON_HOLD_CLASS:
				return MUSIC_ON_HOLD_CLASS_EDEFAULT == null ? musicOnHoldClass != null : !MUSIC_ON_HOLD_CLASS_EDEFAULT.equals(musicOnHoldClass);
			case ActionstepPackage.WAIT_EXTEN__TIMEOUT:
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
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CallConsumer1.class) {
			switch (derivedFeatureID) {
				case ActionstepPackage.WAIT_EXTEN__CALL1: return AsteriskPackage.CALL_CONSUMER1__CALL1;
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
				case AsteriskPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.WAIT_EXTEN__CALL1;
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
		result.append(" (musicOnHoldClass: ");
		result.append(musicOnHoldClass);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(')');
		return result.toString();
	}

} //WaitExtenImpl
