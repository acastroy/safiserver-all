/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import org.asteriskjava.fastagi.AgiChannel;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallConsumer1;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.PresentationType;
import com.safi.asterisk.actionstep.SetCallerPresentation;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.saflet.SafletContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Set Caller Presentation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.SetCallerPresentationImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.SetCallerPresentationImpl#getPresentation <em>Presentation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SetCallerPresentationImpl extends ActionStepImpl implements SetCallerPresentation {
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
   * The default value of the '{@link #getPresentation() <em>Presentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPresentation()
   * @generated
   * @ordered
   */
  protected static final PresentationType PRESENTATION_EDEFAULT = PresentationType.ALLOWED;

  /**
   * The cached value of the '{@link #getPresentation() <em>Presentation</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPresentation()
   * @generated
   * @ordered
   */
  protected PresentationType presentation = PRESENTATION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SetCallerPresentationImpl() {
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

        if (debugLog.isDebugEnabled())
          debug("SetCallerPresentation is starting with presentation "
              + presentation);

        int result = channel.exec("SetCallerPres", presentation.toString());

        if (debugLog.isDebugEnabled())
          debug("Dictate return value was " + translateAppReturnValue(result));
        if (result == -1) {
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
    return ActionstepPackage.Literals.SET_CALLER_PRESENTATION;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.SET_CALLER_PRESENTATION__CALL1, oldCall1, call1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.SET_CALLER_PRESENTATION__CALL1, oldCall1, call1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PresentationType getPresentation() {
    return presentation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPresentation(PresentationType newPresentation) {
    PresentationType oldPresentation = presentation;
    presentation = newPresentation == null ? PRESENTATION_EDEFAULT : newPresentation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.SET_CALLER_PRESENTATION__PRESENTATION, oldPresentation, presentation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ActionstepPackage.SET_CALLER_PRESENTATION__CALL1:
        if (resolve) return getCall1();
        return basicGetCall1();
      case ActionstepPackage.SET_CALLER_PRESENTATION__PRESENTATION:
        return getPresentation();
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
      case ActionstepPackage.SET_CALLER_PRESENTATION__CALL1:
        setCall1((Call)newValue);
        return;
      case ActionstepPackage.SET_CALLER_PRESENTATION__PRESENTATION:
        setPresentation((PresentationType)newValue);
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
      case ActionstepPackage.SET_CALLER_PRESENTATION__CALL1:
        setCall1((Call)null);
        return;
      case ActionstepPackage.SET_CALLER_PRESENTATION__PRESENTATION:
        setPresentation(PRESENTATION_EDEFAULT);
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
      case ActionstepPackage.SET_CALLER_PRESENTATION__CALL1:
        return call1 != null;
      case ActionstepPackage.SET_CALLER_PRESENTATION__PRESENTATION:
        return presentation != PRESENTATION_EDEFAULT;
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
        case ActionstepPackage.SET_CALLER_PRESENTATION__CALL1: return AsteriskPackage.CALL_CONSUMER1__CALL1;
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
        case AsteriskPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.SET_CALLER_PRESENTATION__CALL1;
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
    result.append(" (presentation: ");
    result.append(presentation);
    result.append(')');
    return result.toString();
  }

} //SetCallerPresentationImpl
