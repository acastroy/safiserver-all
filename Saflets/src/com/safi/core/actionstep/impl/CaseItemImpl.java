/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.DynamicValue;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Case Item</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.CaseItemImpl#getDynamicValue <em>Dynamic Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CaseItemImpl extends ItemImpl implements CaseItem {
  /**
	 * The cached value of the '{@link #getDynamicValue() <em>Dynamic Value</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDynamicValue()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue dynamicValue;

  private Adapter adapter = new CaseAdapter();

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  protected CaseItemImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getCaseItem();
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getDynamicValue() {
		return dynamicValue;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetDynamicValue(DynamicValue newDynamicValue, NotificationChain msgs) {
		DynamicValue oldDynamicValue = dynamicValue;
		dynamicValue = newDynamicValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.CASE_ITEM__DYNAMIC_VALUE, oldDynamicValue, newDynamicValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void setDynamicValue(DynamicValue newDynamicValue) {
    if (newDynamicValue != dynamicValue) {
      NotificationChain msgs = null;
      if (dynamicValue != null) {
        this.eAdapters().remove(dynamicValue);
        msgs = ((InternalEObject) dynamicValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
            - ActionStepPackage.CASE_ITEM__DYNAMIC_VALUE, null, msgs);
        dynamicValue.eAdapters().remove(adapter);
      }
      if (newDynamicValue != null) {
        msgs = ((InternalEObject) newDynamicValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
            - ActionStepPackage.CASE_ITEM__DYNAMIC_VALUE, null, msgs);
        newDynamicValue.eAdapters().add(adapter);
        updateLabelText(newDynamicValue);
      } else
        setLabelText("");
      msgs = basicSetDynamicValue(newDynamicValue, msgs);
      if (msgs != null)
        msgs.dispatch();
    } else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET,
          ActionStepPackage.CASE_ITEM__DYNAMIC_VALUE, newDynamicValue, newDynamicValue));
  }


  private void updateLabelText(DynamicValue val) {

    String text = null;
    if (val != null && val.getText() != null)
      text = val.getText().trim().replaceAll("\\s", " ");
    else
      text = "";

    if (text.length() > 15) {
      text = text.substring(0, 12) + "...";
    }
    setLabelText(text);
  }

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
		switch (featureID) {
			case ActionStepPackage.CASE_ITEM__DYNAMIC_VALUE:
				return basicSetDynamicValue(null, msgs);
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
			case ActionStepPackage.CASE_ITEM__DYNAMIC_VALUE:
				return getDynamicValue();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActionStepPackage.CASE_ITEM__DYNAMIC_VALUE:
				setDynamicValue((DynamicValue)newValue);
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
			case ActionStepPackage.CASE_ITEM__DYNAMIC_VALUE:
				setDynamicValue((DynamicValue)null);
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
			case ActionStepPackage.CASE_ITEM__DYNAMIC_VALUE:
				return dynamicValue != null;
		}
		return super.eIsSet(featureID);
	}

  private class CaseAdapter implements  Adapter {

    private Notifier myTarger;

    public Notifier getTarget() {
      return myTarger;
    }

    public boolean isAdapterForType(Object type) {
      return false;
    }

    public void notifyChanged(Notification notification) {
      updateLabelText((DynamicValue)notification.getNotifier());
      
    }

    public void setTarget(Notifier newTarget) {
      myTarger = newTarget;
    }
    
  }
} // CaseItemImpl
