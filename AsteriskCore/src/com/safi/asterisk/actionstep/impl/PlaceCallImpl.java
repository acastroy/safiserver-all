/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import java.io.IOException;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiException;
import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerError;
import org.asteriskjava.manager.response.ManagerResponse;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallSource1;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.PlaceCall;
import com.safi.asterisk.impl.AsteriskFactoryImpl;
import com.safi.asterisk.saflet.AsteriskSafletEnvironment;
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
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Place Call</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.PlaceCallImpl#getNewCall1 <em>New Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.PlaceCallImpl#getExtension <em>Extension</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.PlaceCallImpl#getContext <em>Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.PlaceCallImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.PlaceCallImpl#getCallerId <em>Caller Id</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PlaceCallImpl extends ActionStepImpl implements PlaceCall {
  /**
   * The cached value of the '{@link #getNewCall1() <em>New Call1</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getNewCall1()
   * @generated
   * @ordered
   */
  protected Call newCall1;

  /**
   * The cached value of the '{@link #getExtension() <em>Extension</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getExtension()
   * @generated
   * @ordered
   */
  protected DynamicValue extension;

  /**
   * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getContext()
   * @generated
   * @ordered
   */
  protected DynamicValue context;

  /**
   * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected static final long TIMEOUT_EDEFAULT = 0L;

  /**
   * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getTimeout()
   * @generated
   * @ordered
   */
  protected long timeout = TIMEOUT_EDEFAULT;

  /**
   * The cached value of the '{@link #getCallerId() <em>Caller Id</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getCallerId()
   * @generated
   * @ordered
   */
  protected DynamicValue callerId;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected PlaceCallImpl() {
    super();
  }

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {
    super.beginProcessing(context);
    Exception exception = null;
    int idx = 1;
    Object variableRawValue = context
        .getVariableRawValue(AsteriskSafletConstants.VAR_KEY_MANAGER_CONNECTION);
    if (variableRawValue == null || !(variableRawValue instanceof ManagerConnection))
      exception = new ActionStepException("No manager connection found in current context");
    else {
      ManagerConnection connection = (ManagerConnection) variableRawValue;

      try {
        exception = takeControl(connection, context);
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

  private Exception takeControl(ManagerConnection connection, SafletContext context)
      throws ActionStepException, IOException, IllegalArgumentException, IllegalStateException,
      TimeoutException, AgiException {
    OriginateAction action = new OriginateAction();

    Object dynValue = resolveDynamicValue(this.extension, context);
    String exten = (String) VariableTranslator.translateValue(VariableType.TEXT, dynValue);
    if (StringUtils.isBlank(exten)) {
      return new ActionStepException("Extension must be specified");
    }
    if (debugLog.isDebugEnabled())
      debug("Placing call to " + exten);

    action.setContext("default");
    action.setApplication("Agi");
    
    if (callerId != null){
    	String callerIdStr = (String)VariableTranslator.translateValue(VariableType.TEXT, resolveDynamicValue(callerId, context));
    	action.setCallerId(callerIdStr);
    }
    
    
    // TODO: get looback address from handler environment

    // InetAddress addr = InetAddress.getLocalHost();
    // String _hostname = addr.getHostName();

    // for (int i=0; i < ip.length; i++){
    // byte b = ip[i];
    // }

    AsteriskSafletEnvironment handlerEnvironment = (AsteriskSafletEnvironment)getSaflet().getSafletEnvironment();
    String serverAddr = handlerEnvironment.getServerIpAddr();

    int fastAgiPort = handlerEnvironment.getFastAgiPort();
    String addr = "agi://" + serverAddr + ":" + fastAgiPort + "/safletEngine.agi?loopback=true";
    action.setData(addr);
    if (debugLog.isDebugEnabled())
      debug("Loopback address " + addr);
    // action.setExten("5555");
    dynValue = resolveDynamicValue(this.context, context);
    String ctx = (String) VariableTranslator.translateValue(VariableType.TEXT, dynValue);

    // dynValue = resolveDynamicValue(data, context);
    // String dat = (String) VariableTranslator.translateValue(VariableType.TEXT,
    // dynValue);
    // action.setData(dat);

    dynValue = resolveDynamicValue(extension, context);
    String ext = (String) VariableTranslator.translateValue(VariableType.TEXT, dynValue);

    action.setContext(ctx);
    String originatingChannel = "Local/" + ext + "@" + ctx;
    action.setChannel(originatingChannel);
    if (debugLog.isDebugEnabled())
      debug("Originating channel: " + originatingChannel);
    // action.setPriority(1);
    action.setAsync(true);

    UUID uuid = UUID.randomUUID();
    
    Long timeoutVal = new Long(timeout <= 0 ? Saflet.DEFAULT_MANAGER_ACTION_TIMEOUT : timeout);
    handlerEnvironment.setLoopbackLock(uuid.toString(), timeoutVal);
    action.setVariable("SafiUUID", uuid.toString());
    ManagerResponse response = connection
        .sendAction(action, Saflet.DEFAULT_MANAGER_ACTION_TIMEOUT);
    if (response instanceof ManagerError)
      return new ActionStepException("Couldn't place call: " + response.getMessage());
    Object returned = handlerEnvironment.getLoopbackCall(uuid.toString());
    if (returned instanceof Object[]) {
      Object[] pair = (Object[]) returned;
      if (newCall1 == null)
        setNewCall1(AsteriskFactoryImpl.eINSTANCE.createCall());
      newCall1.setChannel((AgiChannel) pair[0]);
      newCall1.setData("AgiRequest", pair[1]);

    } else {
      return new ActionStepException("Loopback for call failed!");
    }

    // RedirectAction rAction = new RedirectAction();
    // rAction.setChannel(chan);
    // dynValue = resolveDynamicValue(application, context);
    // String app = (String) VariableTranslator.translateValue(VariableType.TEXT,
    // dynValue);
    // action.setApplication(app);

    // if (variables != null) action.setVariables(variables);

    return null;
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
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionstepPackage.Literals.PLACE_CALL;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Call getNewCall1() {
    return newCall1;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetNewCall1(Call newNewCall1, NotificationChain msgs) {
    Call oldNewCall1 = newCall1;
    newCall1 = newNewCall1;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLACE_CALL__NEW_CALL1, oldNewCall1, newNewCall1);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setNewCall1(Call newNewCall1) {
    if (newNewCall1 != newCall1) {
      NotificationChain msgs = null;
      if (newCall1 != null)
        msgs = ((InternalEObject)newCall1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLACE_CALL__NEW_CALL1, null, msgs);
      if (newNewCall1 != null)
        msgs = ((InternalEObject)newNewCall1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLACE_CALL__NEW_CALL1, null, msgs);
      msgs = basicSetNewCall1(newNewCall1, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLACE_CALL__NEW_CALL1, newNewCall1, newNewCall1));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getExtension() {
    return extension;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExtension(DynamicValue newExtension, NotificationChain msgs) {
    DynamicValue oldExtension = extension;
    extension = newExtension;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLACE_CALL__EXTENSION, oldExtension, newExtension);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setExtension(DynamicValue newExtension) {
    if (newExtension != extension) {
      NotificationChain msgs = null;
      if (extension != null)
        msgs = ((InternalEObject)extension).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLACE_CALL__EXTENSION, null, msgs);
      if (newExtension != null)
        msgs = ((InternalEObject)newExtension).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLACE_CALL__EXTENSION, null, msgs);
      msgs = basicSetExtension(newExtension, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLACE_CALL__EXTENSION, newExtension, newExtension));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getContext() {
    return context;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetContext(DynamicValue newContext, NotificationChain msgs) {
    DynamicValue oldContext = context;
    context = newContext;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLACE_CALL__CONTEXT, oldContext, newContext);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setContext(DynamicValue newContext) {
    if (newContext != context) {
      NotificationChain msgs = null;
      if (context != null)
        msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLACE_CALL__CONTEXT, null, msgs);
      if (newContext != null)
        msgs = ((InternalEObject)newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLACE_CALL__CONTEXT, null, msgs);
      msgs = basicSetContext(newContext, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLACE_CALL__CONTEXT, newContext, newContext));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public long getTimeout() {
    return timeout;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setTimeout(long newTimeout) {
    long oldTimeout = timeout;
    timeout = newTimeout;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLACE_CALL__TIMEOUT, oldTimeout, timeout));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getCallerId() {
    return callerId;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCallerId(DynamicValue newCallerId, NotificationChain msgs) {
    DynamicValue oldCallerId = callerId;
    callerId = newCallerId;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLACE_CALL__CALLER_ID, oldCallerId, newCallerId);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setCallerId(DynamicValue newCallerId) {
    if (newCallerId != callerId) {
      NotificationChain msgs = null;
      if (callerId != null)
        msgs = ((InternalEObject)callerId).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLACE_CALL__CALLER_ID, null, msgs);
      if (newCallerId != null)
        msgs = ((InternalEObject)newCallerId).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.PLACE_CALL__CALLER_ID, null, msgs);
      msgs = basicSetCallerId(newCallerId, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.PLACE_CALL__CALLER_ID, newCallerId, newCallerId));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
      case ActionstepPackage.PLACE_CALL__NEW_CALL1:
        return basicSetNewCall1(null, msgs);
      case ActionstepPackage.PLACE_CALL__EXTENSION:
        return basicSetExtension(null, msgs);
      case ActionstepPackage.PLACE_CALL__CONTEXT:
        return basicSetContext(null, msgs);
      case ActionstepPackage.PLACE_CALL__CALLER_ID:
        return basicSetCallerId(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ActionstepPackage.PLACE_CALL__NEW_CALL1:
        return getNewCall1();
      case ActionstepPackage.PLACE_CALL__EXTENSION:
        return getExtension();
      case ActionstepPackage.PLACE_CALL__CONTEXT:
        return getContext();
      case ActionstepPackage.PLACE_CALL__TIMEOUT:
        return new Long(getTimeout());
      case ActionstepPackage.PLACE_CALL__CALLER_ID:
        return getCallerId();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
    switch (featureID) {
      case ActionstepPackage.PLACE_CALL__NEW_CALL1:
        setNewCall1((Call)newValue);
        return;
      case ActionstepPackage.PLACE_CALL__EXTENSION:
        setExtension((DynamicValue)newValue);
        return;
      case ActionstepPackage.PLACE_CALL__CONTEXT:
        setContext((DynamicValue)newValue);
        return;
      case ActionstepPackage.PLACE_CALL__TIMEOUT:
        setTimeout(((Long)newValue).longValue());
        return;
      case ActionstepPackage.PLACE_CALL__CALLER_ID:
        setCallerId((DynamicValue)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID) {
    switch (featureID) {
      case ActionstepPackage.PLACE_CALL__NEW_CALL1:
        setNewCall1((Call)null);
        return;
      case ActionstepPackage.PLACE_CALL__EXTENSION:
        setExtension((DynamicValue)null);
        return;
      case ActionstepPackage.PLACE_CALL__CONTEXT:
        setContext((DynamicValue)null);
        return;
      case ActionstepPackage.PLACE_CALL__TIMEOUT:
        setTimeout(TIMEOUT_EDEFAULT);
        return;
      case ActionstepPackage.PLACE_CALL__CALLER_ID:
        setCallerId((DynamicValue)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID) {
    switch (featureID) {
      case ActionstepPackage.PLACE_CALL__NEW_CALL1:
        return newCall1 != null;
      case ActionstepPackage.PLACE_CALL__EXTENSION:
        return extension != null;
      case ActionstepPackage.PLACE_CALL__CONTEXT:
        return context != null;
      case ActionstepPackage.PLACE_CALL__TIMEOUT:
        return timeout != TIMEOUT_EDEFAULT;
      case ActionstepPackage.PLACE_CALL__CALLER_ID:
        return callerId != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
    if (baseClass == CallSource1.class) {
      switch (derivedFeatureID) {
        case ActionstepPackage.PLACE_CALL__NEW_CALL1: return AsteriskPackage.CALL_SOURCE1__NEW_CALL1;
        default: return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
    if (baseClass == CallSource1.class) {
      switch (baseFeatureID) {
        case AsteriskPackage.CALL_SOURCE1__NEW_CALL1: return ActionstepPackage.PLACE_CALL__NEW_CALL1;
        default: return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (timeout: ");
    result.append(timeout);
    result.append(')');
    return result.toString();
  }

} // PlaceCallImpl
