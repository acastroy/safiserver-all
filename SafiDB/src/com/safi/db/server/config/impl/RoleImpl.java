/**
 * <copyright>
 * </copyright>
 *
 * $Id: RoleImpl.java,v 1.1 2008/06/29 23:25:29 zacw Exp $
 */
package com.safi.db.server.config.impl;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.Entitlement;
import com.safi.db.server.config.Role;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Role</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.db.server.config.impl.RoleImpl#getEntitlements <em>Entitlements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RoleImpl extends ServerResourceImpl implements Role {
  /**
	 * The cached value of the '{@link #getEntitlements() <em>Entitlements</em>}' reference list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getEntitlements()
	 * @generated
	 * @ordered
	 */
  protected EList<Entitlement> entitlements;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected RoleImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ConfigPackage.Literals.ROLE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<Entitlement> getEntitlements() {
		if (entitlements == null) {
			entitlements = new EObjectResolvingEList<Entitlement>(Entitlement.class, this, ConfigPackage.ROLE__ENTITLEMENTS);
		}
		return entitlements;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ConfigPackage.ROLE__ENTITLEMENTS:
				return getEntitlements();
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
			case ConfigPackage.ROLE__ENTITLEMENTS:
				getEntitlements().clear();
				getEntitlements().addAll((Collection<? extends Entitlement>)newValue);
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
			case ConfigPackage.ROLE__ENTITLEMENTS:
				getEntitlements().clear();
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
			case ConfigPackage.ROLE__ENTITLEMENTS:
				return entitlements != null && !entitlements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RoleImpl
