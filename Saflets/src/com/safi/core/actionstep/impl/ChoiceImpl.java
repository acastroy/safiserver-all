/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.actionstep.impl;

import java.util.Collection;
import java.util.logging.Level;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.Choice;
import com.safi.core.actionstep.DynamicValue;
import com.safi.db.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Choice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.actionstep.impl.ChoiceImpl#getChoices <em>Choices</em>}</li>
 *   <li>{@link com.safi.core.actionstep.impl.ChoiceImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChoiceImpl extends ActionStepImpl implements Choice {
  /**
	 * The cached value of the '{@link #getChoices() <em>Choices</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getChoices()
	 * @generated
	 * @ordered
	 */
  protected EList<CaseItem> choices;

  /**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue value;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected ChoiceImpl() {
		super();
	}

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {
    super.beginProcessing(context);
    CaseItem item = null;
    if (choices != null && !choices.isEmpty()) {
      try {
        Object criteria = resolveDynamicValue(value, context);
        if (debugLog.isLoggable(Level.FINEST))
          debug("Criterion value is "+criteria);
        for (CaseItem caseItem : choices) {
          Object result = resolveDynamicValue(caseItem.getDynamicValue(), context);
          if (isEquals(criteria, result)) {
            item = caseItem;
            if (debugLog.isLoggable(Level.FINEST))
              debug("Taking choice "+item.getLabelText());
            break;
          }
        }
      } catch (Exception e) {
        handleException(context, e);
        return;
      }
    }
    if (item != null && item.getTargetActionStep() != null){
      setActive(false);
      this.nextHolder.set(item.getTargetActionStep());
    }
    else
      handleSuccess(context); //take default
  }
  
  /**
   * @generated NOT
   */
  private boolean isEquals(Object varValue, Object scriptValue) {
    if (varValue == scriptValue) return true;
    if (varValue == null || scriptValue == null) return false;
    if (varValue.equals(scriptValue))
      return true;
    
    Object translated = null;
    try {
      translated = VariableTranslator.translateValueFromPrototype(varValue, scriptValue);
    } catch (Exception e) {
      e.printStackTrace();
    }
    if (debugLog.isLoggable(Level.FINEST))
      debug("Translated value was "+translated);
    if (translated == null)
      return false;
    if (translated instanceof Number && varValue instanceof Number){
      return ((Number)translated).doubleValue() == ((Number)varValue).doubleValue();
    }
    return translated.equals(varValue);
    
//    if ((varValue instanceof Number) && (scriptValue instanceof Number)) {
//      Number v = (Number) varValue;
//      Number s = (Number) scriptValue;
//      if (v.doubleValue() == s.doubleValue()) return true;
//
//    }
//    return varValue.equals(scriptValue);
  }
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionStepPackage.eINSTANCE.getChoice();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<CaseItem> getChoices() {
		if (choices == null) {
			choices = new EObjectContainmentEList<CaseItem>(CaseItem.class, this, ActionStepPackage.CHOICE__CHOICES);
		}
		return choices;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getValue() {
		return value;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetValue(DynamicValue newValue, NotificationChain msgs) {
		DynamicValue oldValue = value;
		value = newValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionStepPackage.CHOICE__VALUE, oldValue, newValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setValue(DynamicValue newValue) {
		if (newValue != value) {
			NotificationChain msgs = null;
			if (value != null)
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.CHOICE__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionStepPackage.CHOICE__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionStepPackage.CHOICE__VALUE, newValue, newValue));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionStepPackage.CHOICE__CHOICES:
				return ((InternalEList<?>)getChoices()).basicRemove(otherEnd, msgs);
			case ActionStepPackage.CHOICE__VALUE:
				return basicSetValue(null, msgs);
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
			case ActionStepPackage.CHOICE__CHOICES:
				return getChoices();
			case ActionStepPackage.CHOICE__VALUE:
				return getValue();
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
			case ActionStepPackage.CHOICE__CHOICES:
				getChoices().clear();
				getChoices().addAll((Collection<? extends CaseItem>)newValue);
				return;
			case ActionStepPackage.CHOICE__VALUE:
				setValue((DynamicValue)newValue);
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
			case ActionStepPackage.CHOICE__CHOICES:
				getChoices().clear();
				return;
			case ActionStepPackage.CHOICE__VALUE:
				setValue((DynamicValue)null);
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
			case ActionStepPackage.CHOICE__CHOICES:
				return choices != null && !choices.isEmpty();
			case ActionStepPackage.CHOICE__VALUE:
				return value != null;
		}
		return super.eIsSet(featureID);
	}

} //ChoiceImpl
