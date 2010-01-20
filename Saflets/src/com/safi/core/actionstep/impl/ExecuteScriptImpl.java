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
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.ExecuteScript;
import com.safi.core.saflet.SafletContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execute Script</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.ExecuteScriptImpl#getScriptText <em>Script Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecuteScriptImpl extends ActionStepImpl implements ExecuteScript {
  /**
	 * The cached value of the '{@link #getScriptText() <em>Script Text</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getScriptText()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue scriptText;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ExecuteScriptImpl() {
		super();
	}

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {
    super.beginProcessing(context);
    try {
      
      if (scriptText != null)
        resolveDynamicValue(scriptText, context);
      if (debugLog.isLoggable(Level.FINEST))
        debug("Script "+name+" executed successfully");
    } catch (Exception e) {
    	e.printStackTrace();
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
		return ActionStepPackage.eINSTANCE.getExecuteScript();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getScriptText() {
		return scriptText;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetScriptText(DynamicValue newScriptText, NotificationChain msgs) {
		DynamicValue oldScriptText = scriptText;
		scriptText = newScriptText;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.EXECUTE_SCRIPT__SCRIPT_TEXT, oldScriptText, newScriptText);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setScriptText(DynamicValue newScriptText) {
		if (newScriptText != scriptText) {
			NotificationChain msgs = null;
			if (scriptText != null)
				msgs = ((InternalEObject)scriptText).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.EXECUTE_SCRIPT__SCRIPT_TEXT, null, msgs);
			if (newScriptText != null)
				msgs = ((InternalEObject)newScriptText).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.EXECUTE_SCRIPT__SCRIPT_TEXT, null, msgs);
			msgs = basicSetScriptText(newScriptText, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.EXECUTE_SCRIPT__SCRIPT_TEXT, newScriptText, newScriptText));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionStepPackage.EXECUTE_SCRIPT__SCRIPT_TEXT:
				return basicSetScriptText(null, msgs);
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
			case ActionStepPackage.EXECUTE_SCRIPT__SCRIPT_TEXT:
				return getScriptText();
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
			case ActionStepPackage.EXECUTE_SCRIPT__SCRIPT_TEXT:
				setScriptText((DynamicValue)newValue);
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
			case ActionStepPackage.EXECUTE_SCRIPT__SCRIPT_TEXT:
				setScriptText((DynamicValue)null);
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
			case ActionStepPackage.EXECUTE_SCRIPT__SCRIPT_TEXT:
				return scriptText != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecuteScriptImpl
