/**
 * <copyright>
 * </copyright>
 *
 * $Id: DailyOccursModelImpl.java,v 1.2 2008/11/16 00:00:28 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.core.saflet.impl.SafletImpl;
import com.safi.workshop.model.timeBasedRouting.DailyOccursModel;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage;
import com.safi.workshop.model.timeBasedRouting.util.DateUtils;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Daily Occurs Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.DailyOccursModelImpl#getSkipDays <em>Skip Days</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.DailyOccursModelImpl#getStartDate <em>Start Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DailyOccursModelImpl extends OccursModelImpl implements DailyOccursModel {

  /**
   * The default value of the '{@link #getSkipDays() <em>Skip Days</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getSkipDays()
   * @generated
   * @ordered
   */
  protected static final int SKIP_DAYS_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getSkipDays() <em>Skip Days</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getSkipDays()
   * @generated
   * @ordered
   */
  protected int skipDays = SKIP_DAYS_EDEFAULT;

  /**
   * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getStartDate()
   * @generated NOT
   * @ordered
   */
  protected static final Date START_DATE_EDEFAULT = new Date();

  /**
   * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getStartDate()
   * @generated
   * @ordered
   */
  protected Date startDate = START_DATE_EDEFAULT;

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  protected DailyOccursModelImpl() {
		super();
	}

  @Override
  public boolean isMatch(Date date) {
    final Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    Calendar now = DateUtils.zeroOutTime(cal);
    Calendar start = cal;
    start.setTime(startDate);
    DateUtils.zeroOutTime(start);
    

    if (start.after(now)) {
      if (SafletImpl.debugLog.isLoggable(Level.FINEST))
        SafletImpl.debugLog.log(Level.FINEST, "Start date " + DateUtils.DATE_INSTANCE.format(start.getTime())
            + " is after " + DateUtils.DATE_INSTANCE.format(now.getTime()));
      return false;
    }

    long days = DateUtils.daysBetween(start, now);
    if (SafletImpl.debugLog.isLoggable(Level.FINEST))
      SafletImpl.debugLog.log(Level.FINEST, "days between is "+days+" and skipDays is "+skipDays);
    
    return days % getSkipDays() == 0;
  }

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return TimeBasedRoutingPackage.Literals.DAILY_OCCURS_MODEL;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public int getSkipDays() {
		return skipDays;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public void setSkipDays(int newSkipDays) {
		int oldSkipDays = skipDays;
		skipDays = newSkipDays;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.DAILY_OCCURS_MODEL__SKIP_DAYS, oldSkipDays, skipDays));
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public Date getStartDate() {
		return startDate;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public void setStartDate(Date newStartDate) {
		Date oldStartDate = startDate;
		startDate = newStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.DAILY_OCCURS_MODEL__START_DATE, oldStartDate, startDate));
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimeBasedRoutingPackage.DAILY_OCCURS_MODEL__SKIP_DAYS:
				return getSkipDays();
			case TimeBasedRoutingPackage.DAILY_OCCURS_MODEL__START_DATE:
				return getStartDate();
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
			case TimeBasedRoutingPackage.DAILY_OCCURS_MODEL__SKIP_DAYS:
				setSkipDays((Integer)newValue);
				return;
			case TimeBasedRoutingPackage.DAILY_OCCURS_MODEL__START_DATE:
				setStartDate((Date)newValue);
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
			case TimeBasedRoutingPackage.DAILY_OCCURS_MODEL__SKIP_DAYS:
				setSkipDays(SKIP_DAYS_EDEFAULT);
				return;
			case TimeBasedRoutingPackage.DAILY_OCCURS_MODEL__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
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
			case TimeBasedRoutingPackage.DAILY_OCCURS_MODEL__SKIP_DAYS:
				return skipDays != SKIP_DAYS_EDEFAULT;
			case TimeBasedRoutingPackage.DAILY_OCCURS_MODEL__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (skipDays: ");
		result.append(skipDays);
		result.append(", startDate: ");
		result.append(startDate);
		result.append(')');
		return result.toString();
	}

  @Override
  public String getDescription() {
    return "every " + (skipDays == 1 ? "day" : (skipDays + " days")) + " starting from "
        + DateUtils.DATE_INSTANCE.format(startDate);
  }

  @Override
  public com.safi.workshop.model.timeBasedRouting.OccursMode getMode() {
    // TODO Auto-generated method stub
    return com.safi.workshop.model.timeBasedRouting.OccursMode.DAILY;
  }

} // DailyOccursModelImpl
