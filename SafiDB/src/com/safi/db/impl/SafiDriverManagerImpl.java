/**
 * <copyright>
 * </copyright>
 *
 * $Id: SafiDriverManagerImpl.java,v 1.2 2008/06/23 08:43:28 zacw Exp $
 */
package com.safi.db.impl;

import com.safi.db.DBDriver;
import com.safi.db.DbPackage;
import com.safi.db.SafiDriverManager;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safi Driver Manager</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.impl.SafiDriverManagerImpl#getDrivers <em>Drivers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SafiDriverManagerImpl extends DBResourceImpl implements SafiDriverManager {
  /**
	 * The cached value of the '{@link #getDrivers() <em>Drivers</em>}' containment reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDrivers()
	 * @generated
	 * @ordered
	 */
  protected EList<DBDriver> drivers;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected SafiDriverManagerImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return DbPackage.Literals.SAFI_DRIVER_MANAGER;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<DBDriver> getDrivers() {
		if (drivers == null) {
			drivers = new EObjectContainmentWithInverseEList<DBDriver>(DBDriver.class, this, DbPackage.SAFI_DRIVER_MANAGER__DRIVERS, DbPackage.DB_DRIVER__DRIVER_MANAGER);
		}
		return drivers;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public DBDriver getDriver(String name) {
    if (drivers == null || name == null) return null;
    for (DBDriver d : drivers){
      if (name.equals(d.getName()))
        return d;
    }
    return null;
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DbPackage.SAFI_DRIVER_MANAGER__DRIVERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getDrivers()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DbPackage.SAFI_DRIVER_MANAGER__DRIVERS:
				return ((InternalEList<?>)getDrivers()).basicRemove(otherEnd, msgs);
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
			case DbPackage.SAFI_DRIVER_MANAGER__DRIVERS:
				return getDrivers();
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
			case DbPackage.SAFI_DRIVER_MANAGER__DRIVERS:
				getDrivers().clear();
				getDrivers().addAll((Collection<? extends DBDriver>)newValue);
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
			case DbPackage.SAFI_DRIVER_MANAGER__DRIVERS:
				getDrivers().clear();
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
			case DbPackage.SAFI_DRIVER_MANAGER__DRIVERS:
				return drivers != null && !drivers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SafiDriverManagerImpl
