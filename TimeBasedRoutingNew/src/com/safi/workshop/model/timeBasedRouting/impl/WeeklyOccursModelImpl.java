/**
 * <copyright>
 * </copyright>
 *
 * $Id: WeeklyOccursModelImpl.java,v 1.2 2008/11/16 00:00:28 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.impl;

import com.safi.workshop.model.timeBasedRouting.Day;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage;
import com.safi.workshop.model.timeBasedRouting.WeeklyOccursModel;
import com.safi.workshop.model.timeBasedRouting.util.DateUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.lang.time.FastDateFormat;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Weekly Occurs Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.WeeklyOccursModelImpl#getSkipWeeks <em>Skip Weeks</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.WeeklyOccursModelImpl#getDays <em>Days</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.WeeklyOccursModelImpl#getStartDate <em>Start Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WeeklyOccursModelImpl extends OccursModelImpl implements WeeklyOccursModel {
  
  private static final FastDateFormat DATE_INSTANCE = FastDateFormat.getDateInstance(SimpleDateFormat.SHORT);
  
  /**
	 * The default value of the '{@link #getSkipWeeks() <em>Skip Weeks</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSkipWeeks()
	 * @generated
	 * @ordered
	 */
  protected static final int SKIP_WEEKS_EDEFAULT = 1;

  /**
	 * The cached value of the '{@link #getSkipWeeks() <em>Skip Weeks</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getSkipWeeks()
	 * @generated
	 * @ordered
	 */
  protected int skipWeeks = SKIP_WEEKS_EDEFAULT;

  /**
	 * The cached value of the '{@link #getDays() <em>Days</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDays()
	 * @generated
	 * @ordered
	 */
  protected EList<Day> days;

  /**
   * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartDate()
   * @generated NOT
   * @ordered
   */
  protected static final Date START_DATE_EDEFAULT = new Date();

  /**
	 * The cached value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getStartDate()
	 * @generated
	 * @ordered
	 */
  protected Date startDate = START_DATE_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected WeeklyOccursModelImpl() {
		super();
	}

  @Override
  public boolean isMatch(Date date) {
    final Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    Calendar now = DateUtils.zeroOutTime(cal);
    Calendar start = Calendar.getInstance();
    start.setTime(startDate);
    DateUtils.zeroOutTime(start);
    start.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    if (start.after(now)) return false;
    
    long weeks = DateUtils.weeksBetween(start, now);
    boolean thisWeek =  weeks % getSkipWeeks() == 0;
    if (!thisWeek) return false;
    
    int dayOfWeek = now.get(Calendar.DAY_OF_WEEK)-1;
    for (Day day : days){
      if (day.getValue() == dayOfWeek)
        return true;
    }
    return false;
  }
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return TimeBasedRoutingPackage.Literals.WEEKLY_OCCURS_MODEL;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getSkipWeeks() {
		return skipWeeks;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSkipWeeks(int newSkipWeeks) {
		int oldSkipWeeks = skipWeeks;
		skipWeeks = newSkipWeeks;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__SKIP_WEEKS, oldSkipWeeks, skipWeeks));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Day> getDays() {
		if (days == null) {
			days = new EDataTypeUniqueEList<Day>(Day.class, this, TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__DAYS);
		}
		return days;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Date getStartDate() {
		return startDate;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setStartDate(Date newStartDate) {
		Date oldStartDate = startDate;
		startDate = newStartDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__START_DATE, oldStartDate, startDate));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__SKIP_WEEKS:
				return getSkipWeeks();
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__DAYS:
				return getDays();
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__START_DATE:
				return getStartDate();
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
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__SKIP_WEEKS:
				setSkipWeeks((Integer)newValue);
				return;
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__DAYS:
				getDays().clear();
				getDays().addAll((Collection<? extends Day>)newValue);
				return;
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__START_DATE:
				setStartDate((Date)newValue);
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
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__SKIP_WEEKS:
				setSkipWeeks(SKIP_WEEKS_EDEFAULT);
				return;
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__DAYS:
				getDays().clear();
				return;
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__START_DATE:
				setStartDate(START_DATE_EDEFAULT);
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
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__SKIP_WEEKS:
				return skipWeeks != SKIP_WEEKS_EDEFAULT;
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__DAYS:
				return days != null && !days.isEmpty();
			case TimeBasedRoutingPackage.WEEKLY_OCCURS_MODEL__START_DATE:
				return START_DATE_EDEFAULT == null ? startDate != null : !START_DATE_EDEFAULT.equals(startDate);
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
		result.append(" (skipWeeks: ");
		result.append(skipWeeks);
		result.append(", days: ");
		result.append(days);
		result.append(", startDate: ");
		result.append(startDate);
		result.append(')');
		return result.toString();
	}

  @Override
  public String getDescription() {
    return "every " + (skipWeeks == 1 ? "week" : skipWeeks + " weeks") + " on " + buildDayString()
        + " starting week of "
        + DATE_INSTANCE.format(startDate);
  }

  private String buildDayString() {
    StringBuffer buf = new StringBuffer();
    int i = 0;
    for (Day day : days){
      if (i > 0)
        buf.append(", ");
      if (i == days.size() - 1)
        buf.append("and ");
      buf.append(day.toString());
      i++;
    }
    // TODO Auto-generated method stub
    return buf.toString();
  }
  
  @Override
  public com.safi.workshop.model.timeBasedRouting.OccursMode getMode() {
    // TODO Auto-generated method stub
    return com.safi.workshop.model.timeBasedRouting.OccursMode.WEEKLY;
  }
} //WeeklyOccursModelImpl
