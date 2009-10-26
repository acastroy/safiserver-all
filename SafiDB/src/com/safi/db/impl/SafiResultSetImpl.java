/**
 * <copyright>
 * </copyright>
 *
 * $Id: SafiResultSetImpl.java,v 1.3 2008/06/23 08:43:28 zacw Exp $
 */
package com.safi.db.impl;

import com.safi.db.DbPackage;
import com.safi.db.Query;
import com.safi.db.RSHoldabilityMode;
import com.safi.db.RSScrollMode;
import com.safi.db.SafiResultSet;

import java.sql.ResultSet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safi Result Set</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.impl.SafiResultSetImpl#isUseCache <em>Use Cache</em>}</li>
 *   <li>{@link com.safi.db.impl.SafiResultSetImpl#isScrollable <em>Scrollable</em>}</li>
 *   <li>{@link com.safi.db.impl.SafiResultSetImpl#isReadOnly <em>Read Only</em>}</li>
 *   <li>{@link com.safi.db.impl.SafiResultSetImpl#getScrollMode <em>Scroll Mode</em>}</li>
 *   <li>{@link com.safi.db.impl.SafiResultSetImpl#getHoldabilityMode <em>Holdability Mode</em>}</li>
 *   <li>{@link com.safi.db.impl.SafiResultSetImpl#getQuery <em>Query</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SafiResultSetImpl extends DBResourceImpl implements SafiResultSet {
  /**
   * The default value of the '{@link #isUseCache() <em>Use Cache</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseCache()
   * @generated
   * @ordered
   */
  protected static final boolean USE_CACHE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUseCache() <em>Use Cache</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseCache()
   * @generated
   * @ordered
   */
  protected boolean useCache = USE_CACHE_EDEFAULT;

  /**
   * The default value of the '{@link #isScrollable() <em>Scrollable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isScrollable()
   * @generated
   * @ordered
   */
  protected static final boolean SCROLLABLE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isScrollable() <em>Scrollable</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isScrollable()
   * @generated
   * @ordered
   */
  protected boolean scrollable = SCROLLABLE_EDEFAULT;

  /**
   * The default value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadOnly()
   * @generated
   * @ordered
   */
  protected static final boolean READ_ONLY_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isReadOnly() <em>Read Only</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isReadOnly()
   * @generated
   * @ordered
   */
  protected boolean readOnly = READ_ONLY_EDEFAULT;

  /**
   * The default value of the '{@link #getScrollMode() <em>Scroll Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScrollMode()
   * @generated
   * @ordered
   */
  protected static final RSScrollMode SCROLL_MODE_EDEFAULT = RSScrollMode.FORWARD_ONLY;

  /**
   * The cached value of the '{@link #getScrollMode() <em>Scroll Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getScrollMode()
   * @generated
   * @ordered
   */
  protected RSScrollMode scrollMode = SCROLL_MODE_EDEFAULT;

  /**
   * The default value of the '{@link #getHoldabilityMode() <em>Holdability Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHoldabilityMode()
   * @generated
   * @ordered
   */
  protected static final RSHoldabilityMode HOLDABILITY_MODE_EDEFAULT = RSHoldabilityMode.CLOSE_CURSORS_OVER_COMMIT;

  /**
   * The cached value of the '{@link #getHoldabilityMode() <em>Holdability Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getHoldabilityMode()
   * @generated
   * @ordered
   */
  protected RSHoldabilityMode holdabilityMode = HOLDABILITY_MODE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SafiResultSetImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return DbPackage.Literals.SAFI_RESULT_SET;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUseCache() {
    return useCache;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUseCache(boolean newUseCache) {
    boolean oldUseCache = useCache;
    useCache = newUseCache;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.SAFI_RESULT_SET__USE_CACHE, oldUseCache, useCache));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isScrollable() {
    return scrollable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScrollable(boolean newScrollable) {
    boolean oldScrollable = scrollable;
    scrollable = newScrollable;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.SAFI_RESULT_SET__SCROLLABLE, oldScrollable, scrollable));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isReadOnly() {
    return readOnly;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReadOnly(boolean newReadOnly) {
    boolean oldReadOnly = readOnly;
    readOnly = newReadOnly;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.SAFI_RESULT_SET__READ_ONLY, oldReadOnly, readOnly));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RSScrollMode getScrollMode() {
    return scrollMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setScrollMode(RSScrollMode newScrollMode) {
    RSScrollMode oldScrollMode = scrollMode;
    scrollMode = newScrollMode == null ? SCROLL_MODE_EDEFAULT : newScrollMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.SAFI_RESULT_SET__SCROLL_MODE, oldScrollMode, scrollMode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RSHoldabilityMode getHoldabilityMode() {
    return holdabilityMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setHoldabilityMode(RSHoldabilityMode newHoldabilityMode) {
    RSHoldabilityMode oldHoldabilityMode = holdabilityMode;
    holdabilityMode = newHoldabilityMode == null ? HOLDABILITY_MODE_EDEFAULT : newHoldabilityMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.SAFI_RESULT_SET__HOLDABILITY_MODE, oldHoldabilityMode, holdabilityMode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Query getQuery() {
    if (eContainerFeatureID != DbPackage.SAFI_RESULT_SET__QUERY) return null;
    return (Query)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetQuery(Query newQuery, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newQuery, DbPackage.SAFI_RESULT_SET__QUERY, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuery(Query newQuery) {
    if (newQuery != eInternalContainer() || (eContainerFeatureID != DbPackage.SAFI_RESULT_SET__QUERY && newQuery != null)) {
      if (EcoreUtil.isAncestor(this, newQuery))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newQuery != null)
        msgs = ((InternalEObject)newQuery).eInverseAdd(this, DbPackage.QUERY__RESULT_SETS, Query.class, msgs);
      msgs = basicSetQuery(newQuery, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DbPackage.SAFI_RESULT_SET__QUERY, newQuery, newQuery));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case DbPackage.SAFI_RESULT_SET__QUERY:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetQuery((Query)otherEnd, msgs);
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
      case DbPackage.SAFI_RESULT_SET__QUERY:
        return basicSetQuery(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID) {
      case DbPackage.SAFI_RESULT_SET__QUERY:
        return eInternalContainer().eInverseRemove(this, DbPackage.QUERY__RESULT_SETS, Query.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case DbPackage.SAFI_RESULT_SET__USE_CACHE:
        return isUseCache() ? Boolean.TRUE : Boolean.FALSE;
      case DbPackage.SAFI_RESULT_SET__SCROLLABLE:
        return isScrollable() ? Boolean.TRUE : Boolean.FALSE;
      case DbPackage.SAFI_RESULT_SET__READ_ONLY:
        return isReadOnly() ? Boolean.TRUE : Boolean.FALSE;
      case DbPackage.SAFI_RESULT_SET__SCROLL_MODE:
        return getScrollMode();
      case DbPackage.SAFI_RESULT_SET__HOLDABILITY_MODE:
        return getHoldabilityMode();
      case DbPackage.SAFI_RESULT_SET__QUERY:
        return getQuery();
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
      case DbPackage.SAFI_RESULT_SET__USE_CACHE:
        setUseCache(((Boolean)newValue).booleanValue());
        return;
      case DbPackage.SAFI_RESULT_SET__SCROLLABLE:
        setScrollable(((Boolean)newValue).booleanValue());
        return;
      case DbPackage.SAFI_RESULT_SET__READ_ONLY:
        setReadOnly(((Boolean)newValue).booleanValue());
        return;
      case DbPackage.SAFI_RESULT_SET__SCROLL_MODE:
        setScrollMode((RSScrollMode)newValue);
        return;
      case DbPackage.SAFI_RESULT_SET__HOLDABILITY_MODE:
        setHoldabilityMode((RSHoldabilityMode)newValue);
        return;
      case DbPackage.SAFI_RESULT_SET__QUERY:
        setQuery((Query)newValue);
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
      case DbPackage.SAFI_RESULT_SET__USE_CACHE:
        setUseCache(USE_CACHE_EDEFAULT);
        return;
      case DbPackage.SAFI_RESULT_SET__SCROLLABLE:
        setScrollable(SCROLLABLE_EDEFAULT);
        return;
      case DbPackage.SAFI_RESULT_SET__READ_ONLY:
        setReadOnly(READ_ONLY_EDEFAULT);
        return;
      case DbPackage.SAFI_RESULT_SET__SCROLL_MODE:
        setScrollMode(SCROLL_MODE_EDEFAULT);
        return;
      case DbPackage.SAFI_RESULT_SET__HOLDABILITY_MODE:
        setHoldabilityMode(HOLDABILITY_MODE_EDEFAULT);
        return;
      case DbPackage.SAFI_RESULT_SET__QUERY:
        setQuery((Query)null);
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
      case DbPackage.SAFI_RESULT_SET__USE_CACHE:
        return useCache != USE_CACHE_EDEFAULT;
      case DbPackage.SAFI_RESULT_SET__SCROLLABLE:
        return scrollable != SCROLLABLE_EDEFAULT;
      case DbPackage.SAFI_RESULT_SET__READ_ONLY:
        return readOnly != READ_ONLY_EDEFAULT;
      case DbPackage.SAFI_RESULT_SET__SCROLL_MODE:
        return scrollMode != SCROLL_MODE_EDEFAULT;
      case DbPackage.SAFI_RESULT_SET__HOLDABILITY_MODE:
        return holdabilityMode != HOLDABILITY_MODE_EDEFAULT;
      case DbPackage.SAFI_RESULT_SET__QUERY:
        return getQuery() != null;
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
    result.append(" (useCache: ");
    result.append(useCache);
    result.append(", scrollable: ");
    result.append(scrollable);
    result.append(", readOnly: ");
    result.append(readOnly);
    result.append(", scrollMode: ");
    result.append(scrollMode);
    result.append(", holdabilityMode: ");
    result.append(holdabilityMode);
    result.append(')');
    return result.toString();
  }

} //SafiResultSetImpl
