/**
 * <copyright>
 * </copyright>
 *
 * $Id: UserImpl.java,v 1.3 2008/06/30 01:15:43 zacw Exp $
 */
package com.safi.db.server.config.impl;

import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.Role;
import com.safi.db.server.config.User;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>User</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.server.config.impl.UserImpl#getFirstname <em>Firstname</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.UserImpl#getLastname <em>Lastname</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.UserImpl#getRoles <em>Roles</em>}</li>
 *   <li>{@link com.safi.db.server.config.impl.UserImpl#getPassword <em>Password</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UserImpl extends ServerResourceImpl implements User {
  /**
   * The default value of the '{@link #getFirstname() <em>Firstname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstname()
   * @generated
   * @ordered
   */
  protected static final String FIRSTNAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFirstname() <em>Firstname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstname()
   * @generated
   * @ordered
   */
  protected String firstname = FIRSTNAME_EDEFAULT;

  /**
   * The default value of the '{@link #getLastname() <em>Lastname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastname()
   * @generated
   * @ordered
   */
  protected static final String LASTNAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getLastname() <em>Lastname</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastname()
   * @generated
   * @ordered
   */
  protected String lastname = LASTNAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getRoles() <em>Roles</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRoles()
   * @generated
   * @ordered
   */
  protected EList<Role> roles;

  /**
   * The default value of the '{@link #getPassword() <em>Password</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPassword()
   * @generated
   * @ordered
   */
  protected static final String PASSWORD_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getPassword() <em>Password</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPassword()
   * @generated
   * @ordered
   */
  protected String password = PASSWORD_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected UserImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ConfigPackage.Literals.USER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFirstname() {
    return firstname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFirstname(String newFirstname) {
    String oldFirstname = firstname;
    firstname = newFirstname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.USER__FIRSTNAME, oldFirstname, firstname));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLastname() {
    return lastname;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLastname(String newLastname) {
    String oldLastname = lastname;
    lastname = newLastname;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.USER__LASTNAME, oldLastname, lastname));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Role> getRoles() {
    if (roles == null) {
      roles = new EObjectResolvingEList<Role>(Role.class, this, ConfigPackage.USER__ROLES);
    }
    return roles;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getPassword() {
    return password;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPassword(String newPassword) {
    String oldPassword = password;
    password = newPassword;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ConfigPackage.USER__PASSWORD, oldPassword, password));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ConfigPackage.USER__FIRSTNAME:
        return getFirstname();
      case ConfigPackage.USER__LASTNAME:
        return getLastname();
      case ConfigPackage.USER__ROLES:
        return getRoles();
      case ConfigPackage.USER__PASSWORD:
        return getPassword();
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
      case ConfigPackage.USER__FIRSTNAME:
        setFirstname((String)newValue);
        return;
      case ConfigPackage.USER__LASTNAME:
        setLastname((String)newValue);
        return;
      case ConfigPackage.USER__ROLES:
        getRoles().clear();
        getRoles().addAll((Collection<? extends Role>)newValue);
        return;
      case ConfigPackage.USER__PASSWORD:
        setPassword((String)newValue);
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
      case ConfigPackage.USER__FIRSTNAME:
        setFirstname(FIRSTNAME_EDEFAULT);
        return;
      case ConfigPackage.USER__LASTNAME:
        setLastname(LASTNAME_EDEFAULT);
        return;
      case ConfigPackage.USER__ROLES:
        getRoles().clear();
        return;
      case ConfigPackage.USER__PASSWORD:
        setPassword(PASSWORD_EDEFAULT);
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
      case ConfigPackage.USER__FIRSTNAME:
        return FIRSTNAME_EDEFAULT == null ? firstname != null : !FIRSTNAME_EDEFAULT.equals(firstname);
      case ConfigPackage.USER__LASTNAME:
        return LASTNAME_EDEFAULT == null ? lastname != null : !LASTNAME_EDEFAULT.equals(lastname);
      case ConfigPackage.USER__ROLES:
        return roles != null && !roles.isEmpty();
      case ConfigPackage.USER__PASSWORD:
        return PASSWORD_EDEFAULT == null ? password != null : !PASSWORD_EDEFAULT.equals(password);
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
    result.append(" (firstname: ");
    result.append(firstname);
    result.append(", lastname: ");
    result.append(lastname);
    result.append(", password: ");
    result.append(password);
    result.append(')');
    return result.toString();
  }

} //UserImpl
