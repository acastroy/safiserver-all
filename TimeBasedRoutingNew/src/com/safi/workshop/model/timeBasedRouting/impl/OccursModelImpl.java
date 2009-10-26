/**
 * <copyright>
 * </copyright>
 *
 * $Id: OccursModelImpl.java,v 1.3 2008/11/16 00:00:28 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting.impl;

import java.util.Calendar;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.safi.workshop.model.timeBasedRouting.OccursMode;
import com.safi.workshop.model.timeBasedRouting.OccursModel;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage;
import java.util.Date;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Occurs Model</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.OccursModelImpl#getMode <em>Mode</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.impl.OccursModelImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OccursModelImpl extends EObjectImpl implements OccursModel {

  /**
   * All minutes have this many milliseconds except the last minute of the day on a day
   * defined with a leap second.
   */
  public static final long MILLISECS_PER_MINUTE = 60 * 1000;

  /**
   * Number of milliseconds per hour, except when a leap second is inserted.
   */
  public static final long MILLISECS_PER_HOUR = 60 * MILLISECS_PER_MINUTE;

  /**
   * Number of leap seconds per day expect on <BR/>
   * 1. days when a leap second has been inserted, e.g. 1999 JAN 1. <BR/>
   * 2. Daylight-savings "spring forward" or "fall back" days.
   */
  protected static final long MILLISECS_PER_DAY = 24 * MILLISECS_PER_HOUR;

  /**
   * The default value of the '{@link #getMode() <em>Mode</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getMode()
   * @generated
   * @ordered
   */
  protected static final OccursMode MODE_EDEFAULT = OccursMode.DAILY;

  /**
   * The cached value of the '{@link #getMode() <em>Mode</em>}' attribute. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   * 
   * @see #getMode()
   * @generated
   * @ordered
   */
  protected OccursMode mode = MODE_EDEFAULT;

  /**
   * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected static final String DESCRIPTION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getDescription()
   * @generated
   * @ordered
   */
  protected String description = DESCRIPTION_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected OccursModelImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return TimeBasedRoutingPackage.Literals.OCCURS_MODEL;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public OccursMode getMode() {
    return mode;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setMode(OccursMode newMode) {
    OccursMode oldMode = mode;
    mode = newMode == null ? MODE_EDEFAULT : newMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.OCCURS_MODEL__MODE, oldMode, mode));
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getDescription() {
    return description;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setDescription(String newDescription) {
    String oldDescription = description;
    description = newDescription;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TimeBasedRoutingPackage.OCCURS_MODEL__DESCRIPTION, oldDescription, description));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMatch(Date date) {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case TimeBasedRoutingPackage.OCCURS_MODEL__MODE:
        return getMode();
      case TimeBasedRoutingPackage.OCCURS_MODEL__DESCRIPTION:
        return getDescription();
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
      case TimeBasedRoutingPackage.OCCURS_MODEL__MODE:
        setMode((OccursMode)newValue);
        return;
      case TimeBasedRoutingPackage.OCCURS_MODEL__DESCRIPTION:
        setDescription((String)newValue);
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
      case TimeBasedRoutingPackage.OCCURS_MODEL__MODE:
        setMode(MODE_EDEFAULT);
        return;
      case TimeBasedRoutingPackage.OCCURS_MODEL__DESCRIPTION:
        setDescription(DESCRIPTION_EDEFAULT);
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
      case TimeBasedRoutingPackage.OCCURS_MODEL__MODE:
        return mode != MODE_EDEFAULT;
      case TimeBasedRoutingPackage.OCCURS_MODEL__DESCRIPTION:
        return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
    result.append(" (mode: ");
    result.append(mode);
    result.append(", description: ");
    result.append(description);
    result.append(')');
    return result.toString();
  }

  
} // OccursModelImpl
