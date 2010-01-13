/**
 * <copyright>
 * </copyright>
 *
 * $Id: MonthlyOccursModelImpl.java,v 1.2 2008/11/16 00:00:28 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.core.saflet.impl.SafletImpl;
import com.safi.workshop.model.timeBasedRouting.Day;
import com.safi.workshop.model.timeBasedRouting.DayOccurrence;
import com.safi.workshop.model.timeBasedRouting.MonthlyOccursModel;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage;
import com.safi.workshop.model.timeBasedRouting.util.DateUtils;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Monthly Occurs Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.MonthlyOccursModelImpl#isByIndex <em>By Index</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.MonthlyOccursModelImpl#getSkipMonths <em>Skip Months</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.MonthlyOccursModelImpl#getDayIndex <em>Day Index</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.MonthlyOccursModelImpl#getDayOccurence <em>Day Occurence</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.MonthlyOccursModelImpl#getDay <em>Day</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.MonthlyOccursModelImpl#getStartDate <em>Start Date</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MonthlyOccursModelImpl extends OccursModelImpl implements MonthlyOccursModel {
  /**
   * The default value of the '{@link #isByIndex() <em>By Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isByIndex()
   * @generated
   * @ordered
   */
  protected static final boolean BY_INDEX_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isByIndex() <em>By Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isByIndex()
   * @generated
   * @ordered
   */
  protected boolean byIndex = BY_INDEX_EDEFAULT;

  /**
   * The default value of the '{@link #getSkipMonths() <em>Skip Months</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSkipMonths()
   * @generated
   * @ordered
   */
  protected static final int SKIP_MONTHS_EDEFAULT = 1;

  /**
   * The cached value of the '{@link #getSkipMonths() <em>Skip Months</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSkipMonths()
   * @generated
   * @ordered
   */
  protected int skipMonths = SKIP_MONTHS_EDEFAULT;

  /**
   * The default value of the '{@link #getDayIndex() <em>Day Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDayIndex()
   * @generated
   * @ordered
   */
  protected static final int DAY_INDEX_EDEFAULT = 1;

  /**
   * The cached value of the '{@link #getDayIndex() <em>Day Index</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDayIndex()
   * @generated
   * @ordered
   */
  protected int dayIndex = DAY_INDEX_EDEFAULT;

  /**
   * The default value of the '{@link #getDayOccurence() <em>Day Occurence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDayOccurence()
   * @generated
   * @ordered
   */
  protected static final DayOccurrence DAY_OCCURENCE_EDEFAULT = DayOccurrence.FIRST;

  /**
   * The cached value of the '{@link #getDayOccurence() <em>Day Occurence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDayOccurence()
   * @generated
   * @ordered
   */
  protected DayOccurrence dayOccurence = DAY_OCCURENCE_EDEFAULT;

  /**
   * The default value of the '{@link #getDay() <em>Day</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDay()
   * @generated
   * @ordered
   */
  protected static final Day DAY_EDEFAULT = Day.SUNDAY;

  /**
   * The cached value of the '{@link #getDay() <em>Day</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDay()
   * @generated
   * @ordered
   */
  protected Day day = DAY_EDEFAULT;

  /**
   * The default value of the '{@link #getStartDate() <em>Start Date</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStartDate()
   * @generated
   * @ordered
   */
  protected static final Date START_DATE_EDEFAULT = null;

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
  protected MonthlyOccursModelImpl() {
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
    
    if (start.after(now)) {
      if (SafletImpl.debugLog.isLoggable(Level.FINEST))
        SafletImpl.debugLog.log(Level.FINEST, "Start date " + DateUtils.DATE_INSTANCE.format(start.getTime())
            + " is after " + DateUtils.DATE_INSTANCE.format(now.getTime()));
      return false;
    }
    
    if (byIndex){
      int dayOfMonth = now.get(Calendar.DAY_OF_MONTH);
      if (dayOfMonth != dayIndex) return false;
      int months = DateUtils.monthsBetween(start, now);
      return months % getSkipMonths() == 0;
    }
    else {
      if ((getDay().getValue()+1) != now.get(Calendar.DAY_OF_WEEK))
        return false;
      
      int daySeqVal = now.get(Calendar.DAY_OF_WEEK_IN_MONTH);
      if (dayOccurence != DayOccurrence.LAST){
        if (dayOccurence.getValue() + 1 != daySeqVal)
          return false;
      }
      else {
        Calendar nowClone = (Calendar)now.clone();
        nowClone.set(Calendar.DAY_OF_WEEK_IN_MONTH, -1);
        int last = nowClone.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        if (daySeqVal != last) return false;
      }
      int months = DateUtils.monthsBetween(start, now);
      return months % getSkipMonths() == 0;
    }
  }
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TimeBasedRoutingPackage.Literals.MONTHLY_OCCURS_MODEL;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isByIndex() {
    return byIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setByIndex(boolean newByIndex) {
    boolean oldByIndex = byIndex;
    byIndex = newByIndex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__BY_INDEX, oldByIndex, byIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getSkipMonths() {
    return skipMonths;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSkipMonths(int newSkipMonths) {
    int oldSkipMonths = skipMonths;
    skipMonths = newSkipMonths;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__SKIP_MONTHS, oldSkipMonths, skipMonths));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getDayIndex() {
    return dayIndex;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDayIndex(int newDayIndex) {
    int oldDayIndex = dayIndex;
    dayIndex = newDayIndex;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_INDEX, oldDayIndex, dayIndex));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DayOccurrence getDayOccurence() {
    return dayOccurence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDayOccurence(DayOccurrence newDayOccurence) {
    DayOccurrence oldDayOccurence = dayOccurence;
    dayOccurence = newDayOccurence == null ? DAY_OCCURENCE_EDEFAULT : newDayOccurence;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_OCCURENCE, oldDayOccurence, dayOccurence));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Day getDay() {
    return day;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDay(Day newDay) {
    Day oldDay = day;
    day = newDay == null ? DAY_EDEFAULT : newDay;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY, oldDay, day));
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
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__START_DATE, oldStartDate, startDate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__BY_INDEX:
        return isByIndex() ? Boolean.TRUE : Boolean.FALSE;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__SKIP_MONTHS:
        return new Integer(getSkipMonths());
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_INDEX:
        return new Integer(getDayIndex());
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_OCCURENCE:
        return getDayOccurence();
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY:
        return getDay();
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__START_DATE:
        return getStartDate();
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
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__BY_INDEX:
        setByIndex(((Boolean)newValue).booleanValue());
        return;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__SKIP_MONTHS:
        setSkipMonths(((Integer)newValue).intValue());
        return;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_INDEX:
        setDayIndex(((Integer)newValue).intValue());
        return;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_OCCURENCE:
        setDayOccurence((DayOccurrence)newValue);
        return;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY:
        setDay((Day)newValue);
        return;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__START_DATE:
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
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__BY_INDEX:
        setByIndex(BY_INDEX_EDEFAULT);
        return;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__SKIP_MONTHS:
        setSkipMonths(SKIP_MONTHS_EDEFAULT);
        return;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_INDEX:
        setDayIndex(DAY_INDEX_EDEFAULT);
        return;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_OCCURENCE:
        setDayOccurence(DAY_OCCURENCE_EDEFAULT);
        return;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY:
        setDay(DAY_EDEFAULT);
        return;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__START_DATE:
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
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__BY_INDEX:
        return byIndex != BY_INDEX_EDEFAULT;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__SKIP_MONTHS:
        return skipMonths != SKIP_MONTHS_EDEFAULT;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_INDEX:
        return dayIndex != DAY_INDEX_EDEFAULT;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY_OCCURENCE:
        return dayOccurence != DAY_OCCURENCE_EDEFAULT;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__DAY:
        return day != DAY_EDEFAULT;
      case TimeBasedRoutingPackage.MONTHLY_OCCURS_MODEL__START_DATE:
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
    result.append(" (byIndex: ");
    result.append(byIndex);
    result.append(", skipMonths: ");
    result.append(skipMonths);
    result.append(", dayIndex: ");
    result.append(dayIndex);
    result.append(", dayOccurence: ");
    result.append(dayOccurence);
    result.append(", day: ");
    result.append(day);
    result.append(", startDate: ");
    result.append(startDate);
    result.append(')');
    return result.toString();
  }

  @Override
  public String getDescription() {
    if (byIndex){
      return "on the "+ DateUtils.numToNth(dayIndex)+" day of every "+ 
      (skipMonths == 1 ? "month" : (skipMonths+" months")+" starting from "+DateUtils.DATE_INSTANCE.format(startDate));
    }
    else {
      return "on the "+dayOccurence+" "+day+" of every "+ 
      (skipMonths == 1 ? "month" : (skipMonths+" months")+" starting from "+DateUtils.DATE_INSTANCE.format(startDate));
    }
  }
  

  @Override
  public com.safi.workshop.model.timeBasedRouting.OccursMode getMode() {
    // TODO Auto-generated method stub
    return com.safi.workshop.model.timeBasedRouting.OccursMode.MONTHLY;
  }
} //MonthlyOccursModelImpl
