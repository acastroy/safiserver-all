/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.impl;

import com.safi.core.actionstep.impl.ParameterizedActionstepImpl;

import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.ManagerAction;
import com.safi.workshop.model.actionpak1.ManagerActionType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manager Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.impl.ManagerActionImpl#getManagerActionType <em>Manager Action Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ManagerActionImpl extends ParameterizedActionstepImpl implements ManagerAction {
	/**
	 * The default value of the '{@link #getManagerActionType() <em>Manager Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerActionType()
	 * @generated
	 * @ordered
	 */
	protected static final ManagerActionType MANAGER_ACTION_TYPE_EDEFAULT = ManagerActionType.ABSOLUTE_TIMEOUT_ACTION;

	/**
	 * The cached value of the '{@link #getManagerActionType() <em>Manager Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerActionType()
	 * @generated
	 * @ordered
	 */
	protected ManagerActionType managerActionType = MANAGER_ACTION_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagerActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Actionpak1Package.Literals.MANAGER_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagerActionType getManagerActionType() {
		return managerActionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagerActionType(ManagerActionType newManagerActionType) {
		ManagerActionType oldManagerActionType = managerActionType;
		managerActionType = newManagerActionType == null ? MANAGER_ACTION_TYPE_EDEFAULT : newManagerActionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.MANAGER_ACTION__MANAGER_ACTION_TYPE, oldManagerActionType, managerActionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Actionpak1Package.MANAGER_ACTION__MANAGER_ACTION_TYPE:
				return getManagerActionType();
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
			case Actionpak1Package.MANAGER_ACTION__MANAGER_ACTION_TYPE:
				setManagerActionType((ManagerActionType)newValue);
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
			case Actionpak1Package.MANAGER_ACTION__MANAGER_ACTION_TYPE:
				setManagerActionType(MANAGER_ACTION_TYPE_EDEFAULT);
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
			case Actionpak1Package.MANAGER_ACTION__MANAGER_ACTION_TYPE:
				return managerActionType != MANAGER_ACTION_TYPE_EDEFAULT;
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
		result.append(" (managerActionType: ");
		result.append(managerActionType);
		result.append(')');
		return result.toString();
	}

} //ManagerActionImpl
