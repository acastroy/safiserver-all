/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeBasedRoutingImpl.java,v 1.2 2008/11/16 00:00:28 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.impl;

import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.db.util.VariableTranslator;
import com.safi.core.saflet.SafletContext;
import com.safi.db.VariableType;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRouting;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage;
import com.safi.workshop.model.timeBasedRouting.TimeItem;
import com.safi.workshop.model.timeBasedRouting.TimeRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Based Routing</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingImpl#getValue <em>Value</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.TimeBasedRoutingImpl#getTimes <em>Times</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeBasedRoutingImpl extends ActionStepImpl implements TimeBasedRouting {
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
	 * The cached value of the '{@link #getTimes() <em>Times</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTimes()
	 * @generated
	 * @ordered
	 */
  protected EList<TimeItem> times;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected TimeBasedRoutingImpl() {
		super();
	}

  @Override
  public void beginProcessing(SafletContext context) throws ActionStepException {
    super.beginProcessing(context);
    TimeItem item = null;
    if (times != null && !times.isEmpty()) {
      try {
        Object criteria = resolveDynamicValue(value, context);
        if (debugLog.isLoggable(Level.FINEST))
          debug("Criterion value is "+criteria);
        
        Date date = null;
        if (criteria != null){
          date = (Date)VariableTranslator.translateValue(VariableType.DATETIME, criteria);
        }
        else {
          date = new Date();
        }
        for (TimeItem caseItem : times) {
          if (caseItem.getDynamicValue() == null)
            continue;
          EObject payload = caseItem.getDynamicValue().getPayload();
          if (payload != null && payload instanceof TimeRange){
            if (((TimeRange)payload).isMatch(date)){
              item = caseItem;
              if (debugLog.isLoggable(Level.FINEST))
                debug("Taking time item "+item.getLabelText());
              break;
            }
          }
          
        }
      } catch (Exception e) {
        handleException(context, e);
        return;
      }
    }
    if (item != null && item.getTargetActionStep() != null){
      setActive(false);
      setNext(item.getTargetActionStep());
    }	
    else
      handleSuccess(context); //take default
  }
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return TimeBasedRoutingPackage.Literals.TIME_BASED_ROUTING;
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.TIME_BASED_ROUTING__VALUE, oldValue, newValue);
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
				msgs = ((InternalEObject)value).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TimeBasedRoutingPackage.TIME_BASED_ROUTING__VALUE, null, msgs);
			if (newValue != null)
				msgs = ((InternalEObject)newValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TimeBasedRoutingPackage.TIME_BASED_ROUTING__VALUE, null, msgs);
			msgs = basicSetValue(newValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.TIME_BASED_ROUTING__VALUE, newValue, newValue));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<TimeItem> getTimes() {
		if (times == null) {
			times = new EObjectContainmentEList<TimeItem>(TimeItem.class, this, TimeBasedRoutingPackage.TIME_BASED_ROUTING__TIMES);
		}
		return times;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TimeBasedRoutingPackage.TIME_BASED_ROUTING__VALUE:
				return basicSetValue(null, msgs);
			case TimeBasedRoutingPackage.TIME_BASED_ROUTING__TIMES:
				return ((InternalEList<?>)getTimes()).basicRemove(otherEnd, msgs);
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
			case TimeBasedRoutingPackage.TIME_BASED_ROUTING__VALUE:
				return getValue();
			case TimeBasedRoutingPackage.TIME_BASED_ROUTING__TIMES:
				return getTimes();
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
			case TimeBasedRoutingPackage.TIME_BASED_ROUTING__VALUE:
				setValue((DynamicValue)newValue);
				return;
			case TimeBasedRoutingPackage.TIME_BASED_ROUTING__TIMES:
				getTimes().clear();
				getTimes().addAll((Collection<? extends TimeItem>)newValue);
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
			case TimeBasedRoutingPackage.TIME_BASED_ROUTING__VALUE:
				setValue((DynamicValue)null);
				return;
			case TimeBasedRoutingPackage.TIME_BASED_ROUTING__TIMES:
				getTimes().clear();
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
			case TimeBasedRoutingPackage.TIME_BASED_ROUTING__VALUE:
				return value != null;
			case TimeBasedRoutingPackage.TIME_BASED_ROUTING__TIMES:
				return times != null && !times.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TimeBasedRoutingImpl
