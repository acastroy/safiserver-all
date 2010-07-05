/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator.impl;

import org.eclipse.emf.ecore.EClass;

import com.safi.asterisk.initiator.AsteriskInitiator;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.asterisk.util.AsteriskSafletConstants;
import com.safi.core.initiator.impl.InitiatorImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asterisk Initiator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class AsteriskInitiatorImpl extends InitiatorImpl implements AsteriskInitiator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AsteriskInitiatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return InitiatorPackage.Literals.ASTERISK_INITIATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
  public String getPlatformID() {
  	return AsteriskSafletConstants.PLATFORM_ID;
  }
} //AsteriskInitiatorImpl
