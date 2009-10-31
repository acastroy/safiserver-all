/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import org.apache.commons.lang.StringUtils;
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
import com.safi.asterisk.actionstep.SetCallerId;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.db.VariableType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Caller Id</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.SetCallerIdImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.SetCallerIdImpl#getCallerId <em>Caller Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetCallerIdImpl extends ActionStepImpl implements SetCallerId {
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
	 * The cached value of the '{@link #getCallerId() <em>Caller Id</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallerId()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue callerId;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected SetCallerIdImpl() {
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
      String callerIdStr = (String)VariableTranslator.translateValue(VariableType.TEXT, resolveDynamicValue(callerId, context));
//      if (StringUtils.isBlank(callerIdStr))
//        channel.setVariable("CALLERIDNUM", "");
//      else
      channel.setCallerId(StringUtils.isBlank(callerIdStr)?"":callerIdStr);
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
		return ActionstepPackage.Literals.SET_CALLER_ID;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.SET_CALLER_ID__CALL1, oldCall1, call1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.SET_CALLER_ID__CALL1, oldCall1, call1));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getCallerId() {
		return callerId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetCallerId(DynamicValue newCallerId, NotificationChain msgs) {
		DynamicValue oldCallerId = callerId;
		callerId = newCallerId;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.SET_CALLER_ID__CALLER_ID, oldCallerId, newCallerId);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCallerId(DynamicValue newCallerId) {
		if (newCallerId != callerId) {
			NotificationChain msgs = null;
			if (callerId != null)
				msgs = ((InternalEObject)callerId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.SET_CALLER_ID__CALLER_ID, null, msgs);
			if (newCallerId != null)
				msgs = ((InternalEObject)newCallerId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.SET_CALLER_ID__CALLER_ID, null, msgs);
			msgs = basicSetCallerId(newCallerId, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.SET_CALLER_ID__CALLER_ID, newCallerId, newCallerId));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionstepPackage.SET_CALLER_ID__CALLER_ID:
				return basicSetCallerId(null, msgs);
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
			case ActionstepPackage.SET_CALLER_ID__CALL1:
				if (resolve) return getCall1();
				return basicGetCall1();
			case ActionstepPackage.SET_CALLER_ID__CALLER_ID:
				return getCallerId();
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
			case ActionstepPackage.SET_CALLER_ID__CALL1:
				setCall1((Call)newValue);
				return;
			case ActionstepPackage.SET_CALLER_ID__CALLER_ID:
				setCallerId((DynamicValue)newValue);
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
			case ActionstepPackage.SET_CALLER_ID__CALL1:
				setCall1((Call)null);
				return;
			case ActionstepPackage.SET_CALLER_ID__CALLER_ID:
				setCallerId((DynamicValue)null);
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
			case ActionstepPackage.SET_CALLER_ID__CALL1:
				return call1 != null;
			case ActionstepPackage.SET_CALLER_ID__CALLER_ID:
				return callerId != null;
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
				case ActionstepPackage.SET_CALLER_ID__CALL1: return AsteriskPackage.CALL_CONSUMER1__CALL1;
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
				case AsteriskPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.SET_CALLER_ID__CALL1;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SetCallerIdImpl
