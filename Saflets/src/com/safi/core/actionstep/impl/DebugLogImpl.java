/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.util.logging.Level;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DebugLevel;
import com.safi.core.actionstep.DebugLog;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.db.VariableType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Debug Log</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.DebugLogImpl#getMessage <em>Message</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.DebugLogImpl#getDebugLevel <em>Debug Level</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.DebugLogImpl#getLogFilename <em>Log Filename</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DebugLogImpl extends ActionStepImpl implements DebugLog {
  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected DynamicValue message;

  /**
   * The default value of the '{@link #getDebugLevel() <em>Debug Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDebugLevel()
   * @generated
   * @ordered
   */
  protected static final DebugLevel DEBUG_LEVEL_EDEFAULT = DebugLevel.DEBUG;

  /**
   * The cached value of the '{@link #getDebugLevel() <em>Debug Level</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDebugLevel()
   * @generated
   * @ordered
   */
  protected DebugLevel debugLevel = DEBUG_LEVEL_EDEFAULT;

  /**
   * The cached value of the '{@link #getLogFilename() <em>Log Filename</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLogFilename()
   * @generated
   * @ordered
   */
  protected DynamicValue logFilename;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DebugLogImpl() {
    super();
  }
  
  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {
    super.beginProcessing(context);
    try {
      Object result = resolveDynamicValue(message, context);
      if (result == null) result = "";
      String msg = (String)VariableTranslator.translateValue(VariableType.TEXT, result);
      Level lvl = Level.FINEST;
      switch (debugLevel){
        case WARN:
          lvl = Level.WARNING;
          break;
        case ERROR:
          lvl = Level.SEVERE;
          break;
        case INFO:
          lvl = Level.INFO;
          break;
      }
      Object dynValue = resolveDynamicValue(logFilename, context);
      String filenameStr = (String) VariableTranslator
          .translateValue(VariableType.TEXT, dynValue);
      msg = getSaflet().getName()+": "+msg;
      getSaflet().log(lvl, msg, filenameStr);

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
    return ActionStepPackage.eINSTANCE.getDebugLog();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getMessage() {
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMessage(DynamicValue newMessage, NotificationChain msgs) {
    DynamicValue oldMessage = message;
    message = newMessage;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.DEBUG_LOG__MESSAGE, oldMessage, newMessage);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessage(DynamicValue newMessage) {
    if (newMessage != message) {
      NotificationChain msgs = null;
      if (message != null)
        msgs = ((InternalEObject)message).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.DEBUG_LOG__MESSAGE, null, msgs);
      if (newMessage != null)
        msgs = ((InternalEObject)newMessage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.DEBUG_LOG__MESSAGE, null, msgs);
      msgs = basicSetMessage(newMessage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DEBUG_LOG__MESSAGE, newMessage, newMessage));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DebugLevel getDebugLevel() {
    return debugLevel;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDebugLevel(DebugLevel newDebugLevel) {
    DebugLevel oldDebugLevel = debugLevel;
    debugLevel = newDebugLevel == null ? DEBUG_LEVEL_EDEFAULT : newDebugLevel;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DEBUG_LOG__DEBUG_LEVEL, oldDebugLevel, debugLevel));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getLogFilename() {
    return logFilename;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLogFilename(DynamicValue newLogFilename, NotificationChain msgs) {
    DynamicValue oldLogFilename = logFilename;
    logFilename = newLogFilename;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.DEBUG_LOG__LOG_FILENAME, oldLogFilename, newLogFilename);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLogFilename(DynamicValue newLogFilename) {
    if (newLogFilename != logFilename) {
      NotificationChain msgs = null;
      if (logFilename != null)
        msgs = ((InternalEObject)logFilename).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.DEBUG_LOG__LOG_FILENAME, null, msgs);
      if (newLogFilename != null)
        msgs = ((InternalEObject)newLogFilename).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.DEBUG_LOG__LOG_FILENAME, null, msgs);
      msgs = basicSetLogFilename(newLogFilename, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.DEBUG_LOG__LOG_FILENAME, newLogFilename, newLogFilename));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionStepPackage.DEBUG_LOG__MESSAGE:
        return basicSetMessage(null, msgs);
      case ActionStepPackage.DEBUG_LOG__LOG_FILENAME:
        return basicSetLogFilename(null, msgs);
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
      case ActionStepPackage.DEBUG_LOG__MESSAGE:
        return getMessage();
      case ActionStepPackage.DEBUG_LOG__DEBUG_LEVEL:
        return getDebugLevel();
      case ActionStepPackage.DEBUG_LOG__LOG_FILENAME:
        return getLogFilename();
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
      case ActionStepPackage.DEBUG_LOG__MESSAGE:
        setMessage((DynamicValue)newValue);
        return;
      case ActionStepPackage.DEBUG_LOG__DEBUG_LEVEL:
        setDebugLevel((DebugLevel)newValue);
        return;
      case ActionStepPackage.DEBUG_LOG__LOG_FILENAME:
        setLogFilename((DynamicValue)newValue);
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
      case ActionStepPackage.DEBUG_LOG__MESSAGE:
        setMessage((DynamicValue)null);
        return;
      case ActionStepPackage.DEBUG_LOG__DEBUG_LEVEL:
        setDebugLevel(DEBUG_LEVEL_EDEFAULT);
        return;
      case ActionStepPackage.DEBUG_LOG__LOG_FILENAME:
        setLogFilename((DynamicValue)null);
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
      case ActionStepPackage.DEBUG_LOG__MESSAGE:
        return message != null;
      case ActionStepPackage.DEBUG_LOG__DEBUG_LEVEL:
        return debugLevel != DEBUG_LEVEL_EDEFAULT;
      case ActionStepPackage.DEBUG_LOG__LOG_FILENAME:
        return logFilename != null;
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
    result.append(" (debugLevel: ");
    result.append(debugLevel);
    result.append(')');
    return result.toString();
  }

} //DebugLogImpl
