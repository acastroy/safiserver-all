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
import com.safi.asterisk.actionstep.SetPriority;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.db.VariableType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Priority</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.SetPriorityImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.SetPriorityImpl#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetPriorityImpl extends ActionStepImpl implements SetPriority {
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
	 * The cached value of the '{@link #getPriority() <em>Priority</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPriority()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue priority;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected SetPriorityImpl() {
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
      String priorityStr = (String)VariableTranslator.translateValue(VariableType.TEXT, resolveDynamicValue(priority, context));
      channel.setPriority(priorityStr);
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
		return ActionstepPackage.Literals.SET_PRIORITY;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.SET_PRIORITY__CALL1, oldCall1, call1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.SET_PRIORITY__CALL1, oldCall1, call1));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getPriority() {
		return priority;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetPriority(DynamicValue newPriority, NotificationChain msgs) {
		DynamicValue oldPriority = priority;
		priority = newPriority;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.SET_PRIORITY__PRIORITY, oldPriority, newPriority);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPriority(DynamicValue newPriority) {
		if (newPriority != priority) {
			NotificationChain msgs = null;
			if (priority != null)
				msgs = ((InternalEObject)priority).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.SET_PRIORITY__PRIORITY, null, msgs);
			if (newPriority != null)
				msgs = ((InternalEObject)newPriority).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.SET_PRIORITY__PRIORITY, null, msgs);
			msgs = basicSetPriority(newPriority, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.SET_PRIORITY__PRIORITY, newPriority, newPriority));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionstepPackage.SET_PRIORITY__PRIORITY:
				return basicSetPriority(null, msgs);
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
			case ActionstepPackage.SET_PRIORITY__CALL1:
				if (resolve) return getCall1();
				return basicGetCall1();
			case ActionstepPackage.SET_PRIORITY__PRIORITY:
				return getPriority();
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
			case ActionstepPackage.SET_PRIORITY__CALL1:
				setCall1((Call)newValue);
				return;
			case ActionstepPackage.SET_PRIORITY__PRIORITY:
				setPriority((DynamicValue)newValue);
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
			case ActionstepPackage.SET_PRIORITY__CALL1:
				setCall1((Call)null);
				return;
			case ActionstepPackage.SET_PRIORITY__PRIORITY:
				setPriority((DynamicValue)null);
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
			case ActionstepPackage.SET_PRIORITY__CALL1:
				return call1 != null;
			case ActionstepPackage.SET_PRIORITY__PRIORITY:
				return priority != null;
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
				case ActionstepPackage.SET_PRIORITY__CALL1: return AsteriskPackage.CALL_CONSUMER1__CALL1;
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
				case AsteriskPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.SET_PRIORITY__CALL1;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //SetPriorityImpl
