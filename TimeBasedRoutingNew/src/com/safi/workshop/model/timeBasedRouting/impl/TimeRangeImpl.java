/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeRangeImpl.java,v 1.4 2008/11/19 10:45:31 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import org.apache.commons.lang.time.FastDateFormat;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import com.safi.core.saflet.impl.SafletImpl;
import com.safi.workshop.model.timeBasedRouting.OccursModel;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage;
import com.safi.workshop.model.timeBasedRouting.TimeRange;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Time Range</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.TimeRangeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.TimeRangeImpl#getOccursModel <em>Occurs Model</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.TimeRangeImpl#getStartRange <em>Start Range</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.TimeRangeImpl#getEndRange <em>End Range</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TimeRangeImpl extends EObjectImpl implements TimeRange {

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  private static final FastDateFormat TIME_INSTANCE = FastDateFormat
      .getTimeInstance(SimpleDateFormat.SHORT);

  /**
   * The cached value of the '{@link #getOccursModel() <em>Occurs Model</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getOccursModel()
   * @generated
   * @ordered
   */
  protected OccursModel occursModel;

  /**
   * The default value of the '{@link #getStartRange() <em>Start Range</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getStartRange()
   * @generated
   * @ordered
   */
  protected static final Date START_RANGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getStartRange() <em>Start Range</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getStartRange()
   * @generated
   * @ordered
   */
  protected Date startRange = START_RANGE_EDEFAULT;

  /**
   * The default value of the '{@link #getEndRange() <em>End Range</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getEndRange()
   * @generated
   * @ordered
   */
  protected static final Date END_RANGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getEndRange() <em>End Range</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getEndRange()
   * @generated
   * @ordered
   */
  protected Date endRange = END_RANGE_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected TimeRangeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TimeBasedRoutingPackage.Literals.TIME_RANGE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName) {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.TIME_RANGE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public OccursModel getOccursModel() {
    return occursModel;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOccursModel(OccursModel newOccursModel, NotificationChain msgs) {
    OccursModel oldOccursModel = occursModel;
    occursModel = newOccursModel;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.TIME_RANGE__OCCURS_MODEL, oldOccursModel, newOccursModel);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setOccursModel(OccursModel newOccursModel) {
    if (newOccursModel != occursModel) {
      NotificationChain msgs = null;
      if (occursModel != null)
        msgs = ((InternalEObject)occursModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TimeBasedRoutingPackage.TIME_RANGE__OCCURS_MODEL, null, msgs);
      if (newOccursModel != null)
        msgs = ((InternalEObject)newOccursModel).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TimeBasedRoutingPackage.TIME_RANGE__OCCURS_MODEL, null, msgs);
      msgs = basicSetOccursModel(newOccursModel, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.TIME_RANGE__OCCURS_MODEL, newOccursModel, newOccursModel));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Date getStartRange() {
    return startRange;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setStartRange(Date newStartRange) {
    Date oldStartRange = startRange;
    startRange = newStartRange;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.TIME_RANGE__START_RANGE, oldStartRange, startRange));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Date getEndRange() {
    return endRange;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setEndRange(Date newEndRange) {
    Date oldEndRange = endRange;
    endRange = newEndRange;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.TIME_RANGE__END_RANGE, oldEndRange, endRange));
  }


  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated NOT
   */
  public boolean isMatch(Date date) {
    if (occursModel == null)
      return false;

    if (endRange != null && startRange != null) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(startRange);
      cal.set(Calendar.YEAR, 1980);
      cal.set(Calendar.DAY_OF_MONTH, 1);
      cal.set(Calendar.MONTH, 1);
      Date start = cal.getTime();

      cal.setTime(endRange);
      cal.set(Calendar.YEAR, 1980);
      cal.set(Calendar.DAY_OF_MONTH, 1);
      cal.set(Calendar.MONTH, 1);
      Date end = cal.getTime();

      cal.setTimeInMillis(date.getTime());
      cal.set(Calendar.YEAR, 1980);
      cal.set(Calendar.DAY_OF_MONTH, 1);
      cal.set(Calendar.MONTH, 1);
      long now = cal.getTimeInMillis();

      if (now <  start.getTime() || now > end.getTime()) {
        if (SafletImpl.debugLog.isLoggable(Level.FINEST))
          SafletImpl.debugLog.log(Level.FINEST, TIME_INSTANCE.format(cal.getTime())+ " is not in range from " + TIME_INSTANCE.format(start) + " to "
              + TIME_INSTANCE.format(end));
        return false;
      } else if (SafletImpl.debugLog.isLoggable(Level.FINEST))
        SafletImpl.debugLog.log(Level.FINEST, TIME_INSTANCE.format(cal.getTime())+ " is in time range from " + TIME_INSTANCE.format(start) + " to "
            + TIME_INSTANCE.format(end));

    }

    return occursModel.isMatch(date);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID,
      NotificationChain msgs) {
    switch (featureID) {
      case TimeBasedRoutingPackage.TIME_RANGE__OCCURS_MODEL:
        return basicSetOccursModel(null, msgs);
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
      case TimeBasedRoutingPackage.TIME_RANGE__NAME:
        return getName();
      case TimeBasedRoutingPackage.TIME_RANGE__OCCURS_MODEL:
        return getOccursModel();
      case TimeBasedRoutingPackage.TIME_RANGE__START_RANGE:
        return getStartRange();
      case TimeBasedRoutingPackage.TIME_RANGE__END_RANGE:
        return getEndRange();
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
      case TimeBasedRoutingPackage.TIME_RANGE__NAME:
        setName((String)newValue);
        return;
      case TimeBasedRoutingPackage.TIME_RANGE__OCCURS_MODEL:
        setOccursModel((OccursModel)newValue);
        return;
      case TimeBasedRoutingPackage.TIME_RANGE__START_RANGE:
        setStartRange((Date)newValue);
        return;
      case TimeBasedRoutingPackage.TIME_RANGE__END_RANGE:
        setEndRange((Date)newValue);
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
      case TimeBasedRoutingPackage.TIME_RANGE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TimeBasedRoutingPackage.TIME_RANGE__OCCURS_MODEL:
        setOccursModel((OccursModel)null);
        return;
      case TimeBasedRoutingPackage.TIME_RANGE__START_RANGE:
        setStartRange(START_RANGE_EDEFAULT);
        return;
      case TimeBasedRoutingPackage.TIME_RANGE__END_RANGE:
        setEndRange(END_RANGE_EDEFAULT);
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
      case TimeBasedRoutingPackage.TIME_RANGE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TimeBasedRoutingPackage.TIME_RANGE__OCCURS_MODEL:
        return occursModel != null;
      case TimeBasedRoutingPackage.TIME_RANGE__START_RANGE:
        return START_RANGE_EDEFAULT == null ? startRange != null : !START_RANGE_EDEFAULT.equals(startRange);
      case TimeBasedRoutingPackage.TIME_RANGE__END_RANGE:
        return END_RANGE_EDEFAULT == null ? endRange != null : !END_RANGE_EDEFAULT.equals(endRange);
    }
    return super.eIsSet(featureID);
  }

  // /**
  // * <!-- begin-user-doc -->
  // * <!-- end-user-doc -->
  // * @generated
  // */
  // @Override
  // public String toString() {
  // if (eIsProxy()) return super.toString();
  //
  // StringBuffer result = new StringBuffer(super.toString());
  // result.append(" (startRange: ");
  // result.append(startRange);
  // result.append(", endRange: ");
  // result.append(endRange);
  // result.append(')');
  // return result.toString();
  // }

  @Override
  public String toString() {
    StringBuffer buf = new StringBuffer(name == null ? "" : name);
    buf.append(" occurs ").append(getOccursModel().getDescription());

    if (startRange != null && endRange != null) {
      buf.append(" from ").append(TIME_INSTANCE.format(startRange)).append(" to ").append(
          TIME_INSTANCE.format(endRange));
    } else {
      buf.append(" all day");
    }
    return buf.toString();
  }

} // TimeRangeImpl
