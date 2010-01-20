/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.Item;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.ItemImpl#getLabelText <em>Label Text</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ItemImpl#getParentActionStep <em>Parent Action Step</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ItemImpl#getTargetActionStep <em>Target Action Step</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ItemImpl extends EObjectImpl implements Item {
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
	 * The cached value of the '{@link #getParentActionStep() <em>Parent Action Step</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getParentActionStep()
	 * @generated
	 * @ordered
	 */
  protected ActionStep parentActionStep;

  /**
	 * The cached value of the '{@link #getTargetActionStep() <em>Target Action Step</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTargetActionStep()
	 * @generated
	 * @ordered
	 */
  protected ActionStep targetActionStep;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ItemImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getItem();
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.ITEM__LABEL_TEXT, oldLabelText, labelText));
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public ActionStep getParentActionStep() {
    if (parentActionStep != null && parentActionStep.eIsProxy()) {
      InternalEObject oldParentActionStep = (InternalEObject)parentActionStep;
      parentActionStep = (ActionStep)eResolveProxy(oldParentActionStep);
      if (parentActionStep != oldParentActionStep) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionStepPackage.ITEM__PARENT_ACTION_STEP, oldParentActionStep, parentActionStep));
      }
    }
    if (parentActionStep == null && eContainer() instanceof ActionStep)
      return (ActionStep)eContainer();
    return parentActionStep;
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionStep basicGetParentActionStep() {
		return parentActionStep;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setParentActionStep(ActionStep newParentActionStep) {
		ActionStep oldParentActionStep = parentActionStep;
		parentActionStep = newParentActionStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.ITEM__PARENT_ACTION_STEP, oldParentActionStep, parentActionStep));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionStep getTargetActionStep() {
		if (targetActionStep != null && targetActionStep.eIsProxy()) {
			InternalEObject oldTargetActionStep = (InternalEObject)targetActionStep;
			targetActionStep = (ActionStep)eResolveProxy(oldTargetActionStep);
			if (targetActionStep != oldTargetActionStep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionStepPackage.ITEM__TARGET_ACTION_STEP, oldTargetActionStep, targetActionStep));
			}
		}
		return targetActionStep;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionStep basicGetTargetActionStep() {
		return targetActionStep;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTargetActionStep(ActionStep newTargetActionStep) {
		ActionStep oldTargetActionStep = targetActionStep;
		targetActionStep = newTargetActionStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.ITEM__TARGET_ACTION_STEP, oldTargetActionStep, targetActionStep));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ActionStepPackage.ITEM__LABEL_TEXT:
				return getLabelText();
			case ActionStepPackage.ITEM__PARENT_ACTION_STEP:
				if (resolve) return getParentActionStep();
				return basicGetParentActionStep();
			case ActionStepPackage.ITEM__TARGET_ACTION_STEP:
				if (resolve) return getTargetActionStep();
				return basicGetTargetActionStep();
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
			case ActionStepPackage.ITEM__LABEL_TEXT:
				setLabelText((String)newValue);
				return;
			case ActionStepPackage.ITEM__PARENT_ACTION_STEP:
				setParentActionStep((ActionStep)newValue);
				return;
			case ActionStepPackage.ITEM__TARGET_ACTION_STEP:
				setTargetActionStep((ActionStep)newValue);
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
			case ActionStepPackage.ITEM__LABEL_TEXT:
				setLabelText(LABEL_TEXT_EDEFAULT);
				return;
			case ActionStepPackage.ITEM__PARENT_ACTION_STEP:
				setParentActionStep((ActionStep)null);
				return;
			case ActionStepPackage.ITEM__TARGET_ACTION_STEP:
				setTargetActionStep((ActionStep)null);
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
			case ActionStepPackage.ITEM__LABEL_TEXT:
				return LABEL_TEXT_EDEFAULT == null ? labelText != null : !LABEL_TEXT_EDEFAULT.equals(labelText);
			case ActionStepPackage.ITEM__PARENT_ACTION_STEP:
				return parentActionStep != null;
			case ActionStepPackage.ITEM__TARGET_ACTION_STEP:
				return targetActionStep != null;
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

} //ItemImpl
