/**
 * <copyright>
 * </copyright>
 *
 * $Id: EntitlementImpl.java,v 1.2 2008/06/29 23:41:40 zacw Exp $
 */
package com.safi.db.server.config.impl;

import com.safi.db.server.config.ConfigPackage;
import com.safi.db.server.config.Entitlement;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entitlement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class EntitlementImpl extends ServerResourceImpl implements Entitlement {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected EntitlementImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ConfigPackage.Literals.ENTITLEMENT;
	}

} //EntitlementImpl
