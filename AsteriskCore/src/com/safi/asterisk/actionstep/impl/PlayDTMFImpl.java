/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import org.apache.commons.lang.StringUtils;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.PlayDtmfAction;
import org.asteriskjava.manager.response.ManagerError;
import org.asteriskjava.manager.response.ManagerResponse;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallConsumer1;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.PlayDTMF;
import com.safi.asterisk.util.AsteriskSafletConstants;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.db.VariableType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Play DTMF</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.PlayDTMFImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.PlayDTMFImpl#getDigits <em>Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlayDTMFImpl extends ActionStepImpl implements PlayDTMF {
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
   * The cached value of the '{@link #getDigits() <em>Digits</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDigits()
   * @generated
   * @ordered
   */
  protected DynamicValue digits;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PlayDTMFImpl() {
    super();
  }

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {
    super.beginProcessing(context);
    Exception exception = null;
    int idx = 1;
    ManagerConnection connection = (ManagerConnection) context
        .getVariableRawValue(AsteriskSafletConstants.VAR_KEY_MANAGER_CONNECTION);
    if (connection == null) {
      exception = new ActionStepException("No manager connection found in current context");
    } else if (call1 == null || StringUtils.isBlank(call1.getChannelName())) {
      exception = new ActionStepException(call1 == null ? "No current call found"
          : "No channel name set");
    } else {
      try {
        Object dynValue = resolveDynamicValue(digits, context);
        String digitsStr = (String) VariableTranslator.translateValue(VariableType.TEXT, dynValue);
        if (StringUtils.isBlank(digitsStr))
          exception = new ActionStepException("No digits specified");
        else {
          PlayDtmfAction action = new PlayDtmfAction();
          action.setChannel(call1.getChannelName());
          
          for (int i=0; i<digitsStr.length(); i++){
            char ch = digitsStr.charAt(i);
            if (',' == ch){
              try {
                Thread.sleep(300);
              } catch (Exception e) {
                // TODO: handle exception
              }
              continue;
            }
            else
              if (!(ch == '#' || ch == '*' || Character.isDigit(ch))){
                if (debugLog.isDebugEnabled())
                  getSaflet().warn("skipping char "+ch);
              }
            action.setDigit(String.valueOf(ch));
            ManagerResponse response = connection.sendAction(action, Saflet.DEFAULT_MANAGER_ACTION_TIMEOUT);
            if (response instanceof ManagerError){
              exception = new ActionStepException("Couldn't redirect call to extension: " + response);
              break;
            }
            
          }
        }
      } catch (Exception e) {
        exception = e;
      }

    }
    if (exception != null) {
      if (exception instanceof TimeoutException) {
        idx = 2;
      } else {
        handleException(context, exception);
        return;
      }
    }
    handleSuccess(context, idx);

  }
  
  @Override
  public void createDefaultOutputs() {
    // TODO Auto-generated method stub
    super.createDefaultOutputs();
    Output o = ActionStepFactory.eINSTANCE.createOutput();
    o.setOutputType(OutputType.CHOICE);
    o.setName("timeout");
    setErrorOutput(o);
    getOutputs().add(o);
  }  
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionstepPackage.Literals.PLAY_DTMF;
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
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.PLAY_DTMF__CALL1, oldCall1, call1));
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLAY_DTMF__CALL1, oldCall1, call1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getDigits() {
    return digits;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDigits(DynamicValue newDigits, NotificationChain msgs) {
    DynamicValue oldDigits = digits;
    digits = newDigits;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLAY_DTMF__DIGITS, oldDigits, newDigits);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDigits(DynamicValue newDigits) {
    if (newDigits != digits) {
      NotificationChain msgs = null;
      if (digits != null)
        msgs = ((InternalEObject)digits).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLAY_DTMF__DIGITS, null, msgs);
      if (newDigits != null)
        msgs = ((InternalEObject)newDigits).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLAY_DTMF__DIGITS, null, msgs);
      msgs = basicSetDigits(newDigits, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLAY_DTMF__DIGITS, newDigits, newDigits));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionstepPackage.PLAY_DTMF__DIGITS:
        return basicSetDigits(null, msgs);
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
      case ActionstepPackage.PLAY_DTMF__CALL1:
        if (resolve) return getCall1();
        return basicGetCall1();
      case ActionstepPackage.PLAY_DTMF__DIGITS:
        return getDigits();
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
      case ActionstepPackage.PLAY_DTMF__CALL1:
        setCall1((Call)newValue);
        return;
      case ActionstepPackage.PLAY_DTMF__DIGITS:
        setDigits((DynamicValue)newValue);
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
      case ActionstepPackage.PLAY_DTMF__CALL1:
        setCall1((Call)null);
        return;
      case ActionstepPackage.PLAY_DTMF__DIGITS:
        setDigits((DynamicValue)null);
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
      case ActionstepPackage.PLAY_DTMF__CALL1:
        return call1 != null;
      case ActionstepPackage.PLAY_DTMF__DIGITS:
        return digits != null;
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
        case ActionstepPackage.PLAY_DTMF__CALL1: return AsteriskPackage.CALL_CONSUMER1__CALL1;
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
        case AsteriskPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.PLAY_DTMF__CALL1;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

} //PlayDTMFImpl
