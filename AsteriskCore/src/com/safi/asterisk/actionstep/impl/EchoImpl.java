/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import java.util.logging.Level;
import org.asteriskjava.fastagi.AgiChannel;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallConsumer1;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.Echo;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.saflet.SafletContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Echo</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.EchoImpl#getCall1 <em>Call1</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EchoImpl extends ActionStepImpl implements Echo {
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
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EchoImpl() {
		super();
	}

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {
    super.beginProcessing(context);
    Exception exception = null;
    if (call1 == null || call1.getChannel() == null) {
      exception = new ActionStepException(call1 == null ? "No current call found"
          : "No channel found in current context");
    } else {
      AgiChannel channel = call1.getChannel();
      try {
        
        int result = channel.exec("Echo");
        
        if (debugLog.isLoggable(Level.FINEST))
          debug("Echo return value was "+translateAppReturnValue(result));
        if (result == -1){
          exception = new ActionStepException("Channel was hung up");
        }
        
      } catch (Exception e) {
        exception = e;
      }
    }

    if (exception != null) {
      handleException(context, exception);
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
		return ActionstepPackage.Literals.ECHO;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.ECHO__CALL1, oldCall1, call1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.ECHO__CALL1, oldCall1, call1));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionstepPackage.ECHO__CALL1:
				if (resolve) return getCall1();
				return basicGetCall1();
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
			case ActionstepPackage.ECHO__CALL1:
				setCall1((Call)newValue);
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
			case ActionstepPackage.ECHO__CALL1:
				setCall1((Call)null);
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
			case ActionstepPackage.ECHO__CALL1:
				return call1 != null;
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
				case ActionstepPackage.ECHO__CALL1: return AsteriskPackage.CALL_CONSUMER1__CALL1;
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
				case AsteriskPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.ECHO__CALL1;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //EchoImpl
