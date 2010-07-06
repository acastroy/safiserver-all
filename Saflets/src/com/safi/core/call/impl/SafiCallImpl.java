/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.core.call.impl;

import com.safi.core.CorePackage;
import com.safi.core.PlatformDisposition;
import com.safi.core.call.CallPackage;
import com.safi.core.call.SafiCall;

import com.safi.core.impl.ThreadSensitiveImpl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Safi Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.core.call.impl.SafiCallImpl#getPlatformID <em>Platform ID</em>}</li>
 *   <li>{@link com.safi.core.call.impl.SafiCallImpl#isPlatformDependant <em>Platform Dependant</em>}</li>
 *   <li>{@link com.safi.core.call.impl.SafiCallImpl#getUuid <em>Uuid</em>}</li>
 *   <li>{@link com.safi.core.call.impl.SafiCallImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SafiCallImpl extends ThreadSensitiveImpl implements SafiCall {
	/**
	 * The default value of the '{@link #getPlatformID() <em>Platform ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatformID()
	 * @generated
	 * @ordered
	 */
	protected static final String PLATFORM_ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getPlatformID() <em>Platform ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlatformID()
	 * @generated
	 * @ordered
	 */
	protected String platformID = PLATFORM_ID_EDEFAULT;

	/**
	 * This is true if the Platform ID attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean platformIDESet;

	/**
	 * The default value of the '{@link #isPlatformDependant() <em>Platform Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPlatformDependant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PLATFORM_DEPENDANT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPlatformDependant() <em>Platform Dependant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPlatformDependant()
	 * @generated
	 * @ordered
	 */
	protected boolean platformDependant = PLATFORM_DEPENDANT_EDEFAULT;

	/**
	 * This is true if the Platform Dependant attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean platformDependantESet;

	/**
	 * The default value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected static final String UUID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
	protected String uuid = UUID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated
	 * @ordered
	 */
//	protected String uuid = UUID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUuid() <em>Uuid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUuid()
	 * @generated NOT
	 * @ordered
	 */
	
	 protected ThreadLocal<String> uuidHolder = new ThreadLocal<String>(){
	  	protected String initialValue() {
	  		return UUID_EDEFAULT;
	  	}
	  };
//	protected String uuid = UUID_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SafiCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CallPackage.Literals.SAFI_CALL;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPlatformID() {
		return platformID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlatformID() {
		return platformIDESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isPlatformDependant() {
		return platformDependant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetPlatformDependant() {
		return platformDependantESet;
	}

	@Override
	public void cleanup() {
		uuidHolder.remove();
		super.cleanup();
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getUuid() {
		return uuidHolder.get();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setUuid(String newUuid) {
		String oldUuid = uuidHolder.get();
		uuidHolder.set(newUuid);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CallPackage.SAFI_CALL__UUID, oldUuid, newUuid));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CallPackage.SAFI_CALL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CallPackage.SAFI_CALL__PLATFORM_ID:
				return getPlatformID();
			case CallPackage.SAFI_CALL__PLATFORM_DEPENDANT:
				return isPlatformDependant();
			case CallPackage.SAFI_CALL__UUID:
				return getUuid();
			case CallPackage.SAFI_CALL__NAME:
				return getName();
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
			case CallPackage.SAFI_CALL__UUID:
				setUuid((String)newValue);
				return;
			case CallPackage.SAFI_CALL__NAME:
				setName((String)newValue);
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
			case CallPackage.SAFI_CALL__UUID:
				setUuid(UUID_EDEFAULT);
				return;
			case CallPackage.SAFI_CALL__NAME:
				setName(NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CallPackage.SAFI_CALL__UUID:
				return UUID_EDEFAULT == null ? uuidHolder.get() != null : !UUID_EDEFAULT.equals(uuidHolder.get());
			case CallPackage.SAFI_CALL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CallPackage.SAFI_CALL__PLATFORM_ID:
				return PLATFORM_ID_EDEFAULT == null ? platformID != null : !PLATFORM_ID_EDEFAULT.equals(platformID);
			case CallPackage.SAFI_CALL__PLATFORM_DEPENDANT:
				return isSetPlatformDependant();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == PlatformDisposition.class) {
			switch (derivedFeatureID) {
				case CallPackage.SAFI_CALL__PLATFORM_ID: return CorePackage.PLATFORM_DISPOSITION__PLATFORM_ID;
				case CallPackage.SAFI_CALL__PLATFORM_DEPENDANT: return CorePackage.PLATFORM_DISPOSITION__PLATFORM_DEPENDANT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == PlatformDisposition.class) {
			switch (baseFeatureID) {
				case CorePackage.PLATFORM_DISPOSITION__PLATFORM_ID: return CallPackage.SAFI_CALL__PLATFORM_ID;
				case CorePackage.PLATFORM_DISPOSITION__PLATFORM_DEPENDANT: return CallPackage.SAFI_CALL__PLATFORM_DEPENDANT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (uuid: ");
		result.append(uuidHolder.get());
		result.append(')');
		return result.toString();
	}

} //SafiCallImpl
