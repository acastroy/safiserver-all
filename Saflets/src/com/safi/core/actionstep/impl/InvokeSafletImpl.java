/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.InvokeSaflet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Invoke Saflet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.InvokeSafletImpl#getTargetSafletPath <em>Target Saflet Path</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.InvokeSafletImpl#getLabelText <em>Label Text</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvokeSafletImpl extends ActionStepImpl implements InvokeSaflet {
  /**
   * The cached value of the '{@link #getTargetSafletPath() <em>Target Saflet Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetSafletPath()
   * @generated
   * @ordered
   */
  protected DynamicValue targetSafletPath;

  /**
   * The default value of the '{@link #getLabelText() <em>Label Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabelText()
   * @generated
   * @ordered
   */
  protected static final String LABEL_TEXT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLabelText() <em>Label Text</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLabelText()
   * @generated
   * @ordered
   */
  protected String labelText = LABEL_TEXT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvokeSafletImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionStepPackage.eINSTANCE.getInvokeSaflet();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getTargetSafletPath() {
    return targetSafletPath;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTargetSafletPath(DynamicValue newTargetSafletPath, NotificationChain msgs) {
    DynamicValue oldTargetSafletPath = targetSafletPath;
    targetSafletPath = newTargetSafletPath;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.INVOKE_SAFLET__TARGET_SAFLET_PATH, oldTargetSafletPath, newTargetSafletPath);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetSafletPath(DynamicValue newTargetSafletPath) {
    if (newTargetSafletPath != targetSafletPath) {
      NotificationChain msgs = null;
      if (targetSafletPath != null)
        msgs = ((InternalEObject)targetSafletPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.INVOKE_SAFLET__TARGET_SAFLET_PATH, null, msgs);
      if (newTargetSafletPath != null)
        msgs = ((InternalEObject)newTargetSafletPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.INVOKE_SAFLET__TARGET_SAFLET_PATH, null, msgs);
      msgs = basicSetTargetSafletPath(newTargetSafletPath, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.INVOKE_SAFLET__TARGET_SAFLET_PATH, newTargetSafletPath, newTargetSafletPath));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLabelText() {
    return labelText;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLabelText(String newLabelText) {
    String oldLabelText = labelText;
    labelText = newLabelText;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.INVOKE_SAFLET__LABEL_TEXT, oldLabelText, labelText));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionStepPackage.INVOKE_SAFLET__TARGET_SAFLET_PATH:
        return basicSetTargetSafletPath(null, msgs);
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
      case ActionStepPackage.INVOKE_SAFLET__TARGET_SAFLET_PATH:
        return getTargetSafletPath();
      case ActionStepPackage.INVOKE_SAFLET__LABEL_TEXT:
        return getLabelText();
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
      case ActionStepPackage.INVOKE_SAFLET__TARGET_SAFLET_PATH:
        setTargetSafletPath((DynamicValue)newValue);
        return;
      case ActionStepPackage.INVOKE_SAFLET__LABEL_TEXT:
        setLabelText((String)newValue);
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
      case ActionStepPackage.INVOKE_SAFLET__TARGET_SAFLET_PATH:
        setTargetSafletPath((DynamicValue)null);
        return;
      case ActionStepPackage.INVOKE_SAFLET__LABEL_TEXT:
        setLabelText(LABEL_TEXT_EDEFAULT);
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
      case ActionStepPackage.INVOKE_SAFLET__TARGET_SAFLET_PATH:
        return targetSafletPath != null;
      case ActionStepPackage.INVOKE_SAFLET__LABEL_TEXT:
        return LABEL_TEXT_EDEFAULT == null ? labelText != null : !LABEL_TEXT_EDEFAULT.equals(labelText);
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
    result.append(" (labelText: ");
    result.append(labelText);
    result.append(')');
    return result.toString();
  }

} //InvokeSafletImpl
