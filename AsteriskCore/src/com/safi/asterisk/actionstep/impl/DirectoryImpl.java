/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.Directory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.call.CallConsumer1;
import com.safi.core.call.CallPackage;
import com.safi.core.call.SafiCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Directory</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DirectoryImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DirectoryImpl#getVMContext <em>VM Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DirectoryImpl#getDialContext <em>Dial Context</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DirectoryImpl#isReadExtensionNumber <em>Read Extension Number</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DirectoryImpl#isEnterByFirstName <em>Enter By First Name</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DirectoryImpl#isEnterByFirstOrLastName <em>Enter By First Or Last Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DirectoryImpl extends ActionStepImpl implements Directory {
  /**
	 * The cached value of the '{@link #getCall1() <em>Call1</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCall1()
	 * @generated
	 * @ordered
	 */
  protected SafiCall call1;

  /**
	 * The cached value of the '{@link #getVMContext() <em>VM Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVMContext()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue vMContext;

  /**
	 * The cached value of the '{@link #getDialContext() <em>Dial Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDialContext()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue dialContext;

  /**
	 * The default value of the '{@link #isReadExtensionNumber() <em>Read Extension Number</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isReadExtensionNumber()
	 * @generated
	 * @ordered
	 */
  protected static final boolean READ_EXTENSION_NUMBER_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isReadExtensionNumber() <em>Read Extension Number</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isReadExtensionNumber()
	 * @generated
	 * @ordered
	 */
  protected boolean readExtensionNumber = READ_EXTENSION_NUMBER_EDEFAULT;

  /**
	 * The default value of the '{@link #isEnterByFirstName() <em>Enter By First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isEnterByFirstName()
	 * @generated
	 * @ordered
	 */
  protected static final boolean ENTER_BY_FIRST_NAME_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isEnterByFirstName() <em>Enter By First Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isEnterByFirstName()
	 * @generated
	 * @ordered
	 */
  protected boolean enterByFirstName = ENTER_BY_FIRST_NAME_EDEFAULT;

  /**
	 * The default value of the '{@link #isEnterByFirstOrLastName() <em>Enter By First Or Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isEnterByFirstOrLastName()
	 * @generated
	 * @ordered
	 */
  protected static final boolean ENTER_BY_FIRST_OR_LAST_NAME_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isEnterByFirstOrLastName() <em>Enter By First Or Last Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isEnterByFirstOrLastName()
	 * @generated
	 * @ordered
	 */
  protected boolean enterByFirstOrLastName = ENTER_BY_FIRST_OR_LAST_NAME_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DirectoryImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionstepPackage.Literals.DIRECTORY;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafiCall getCall1() {
		if (call1 != null && call1.eIsProxy()) {
			InternalEObject oldCall1 = (InternalEObject)call1;
			call1 = (SafiCall)eResolveProxy(oldCall1);
			if (call1 != oldCall1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.DIRECTORY__CALL1, oldCall1, call1));
			}
		}
		return call1;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafiCall basicGetCall1() {
		return call1;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCall1(SafiCall newCall1) {
		SafiCall oldCall1 = call1;
		call1 = newCall1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIRECTORY__CALL1, oldCall1, call1));
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getVMContext() {
		return vMContext;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetVMContext(DynamicValue newVMContext, NotificationChain msgs) {
		DynamicValue oldVMContext = vMContext;
		vMContext = newVMContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIRECTORY__VM_CONTEXT, oldVMContext, newVMContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setVMContext(DynamicValue newVMContext) {
		if (newVMContext != vMContext) {
			NotificationChain msgs = null;
			if (vMContext != null)
				msgs = ((InternalEObject)vMContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.DIRECTORY__VM_CONTEXT, null, msgs);
			if (newVMContext != null)
				msgs = ((InternalEObject)newVMContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.DIRECTORY__VM_CONTEXT, null, msgs);
			msgs = basicSetVMContext(newVMContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIRECTORY__VM_CONTEXT, newVMContext, newVMContext));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getDialContext() {
		return dialContext;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetDialContext(DynamicValue newDialContext, NotificationChain msgs) {
		DynamicValue oldDialContext = dialContext;
		dialContext = newDialContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIRECTORY__DIAL_CONTEXT, oldDialContext, newDialContext);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDialContext(DynamicValue newDialContext) {
		if (newDialContext != dialContext) {
			NotificationChain msgs = null;
			if (dialContext != null)
				msgs = ((InternalEObject)dialContext).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.DIRECTORY__DIAL_CONTEXT, null, msgs);
			if (newDialContext != null)
				msgs = ((InternalEObject)newDialContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.DIRECTORY__DIAL_CONTEXT, null, msgs);
			msgs = basicSetDialContext(newDialContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIRECTORY__DIAL_CONTEXT, newDialContext, newDialContext));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isReadExtensionNumber() {
		return readExtensionNumber;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setReadExtensionNumber(boolean newReadExtensionNumber) {
		boolean oldReadExtensionNumber = readExtensionNumber;
		readExtensionNumber = newReadExtensionNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIRECTORY__READ_EXTENSION_NUMBER, oldReadExtensionNumber, readExtensionNumber));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isEnterByFirstName() {
		return enterByFirstName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setEnterByFirstName(boolean newEnterByFirstName) {
		boolean oldEnterByFirstName = enterByFirstName;
		enterByFirstName = newEnterByFirstName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIRECTORY__ENTER_BY_FIRST_NAME, oldEnterByFirstName, enterByFirstName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isEnterByFirstOrLastName() {
		return enterByFirstOrLastName;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setEnterByFirstOrLastName(boolean newEnterByFirstOrLastName) {
		boolean oldEnterByFirstOrLastName = enterByFirstOrLastName;
		enterByFirstOrLastName = newEnterByFirstOrLastName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIRECTORY__ENTER_BY_FIRST_OR_LAST_NAME, oldEnterByFirstOrLastName, enterByFirstOrLastName));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionstepPackage.DIRECTORY__VM_CONTEXT:
				return basicSetVMContext(null, msgs);
			case ActionstepPackage.DIRECTORY__DIAL_CONTEXT:
				return basicSetDialContext(null, msgs);
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
			case ActionstepPackage.DIRECTORY__CALL1:
				if (resolve) return getCall1();
				return basicGetCall1();
			case ActionstepPackage.DIRECTORY__VM_CONTEXT:
				return getVMContext();
			case ActionstepPackage.DIRECTORY__DIAL_CONTEXT:
				return getDialContext();
			case ActionstepPackage.DIRECTORY__READ_EXTENSION_NUMBER:
				return isReadExtensionNumber();
			case ActionstepPackage.DIRECTORY__ENTER_BY_FIRST_NAME:
				return isEnterByFirstName();
			case ActionstepPackage.DIRECTORY__ENTER_BY_FIRST_OR_LAST_NAME:
				return isEnterByFirstOrLastName();
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
			case ActionstepPackage.DIRECTORY__CALL1:
				setCall1((SafiCall)newValue);
				return;
			case ActionstepPackage.DIRECTORY__VM_CONTEXT:
				setVMContext((DynamicValue)newValue);
				return;
			case ActionstepPackage.DIRECTORY__DIAL_CONTEXT:
				setDialContext((DynamicValue)newValue);
				return;
			case ActionstepPackage.DIRECTORY__READ_EXTENSION_NUMBER:
				setReadExtensionNumber((Boolean)newValue);
				return;
			case ActionstepPackage.DIRECTORY__ENTER_BY_FIRST_NAME:
				setEnterByFirstName((Boolean)newValue);
				return;
			case ActionstepPackage.DIRECTORY__ENTER_BY_FIRST_OR_LAST_NAME:
				setEnterByFirstOrLastName((Boolean)newValue);
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
			case ActionstepPackage.DIRECTORY__CALL1:
				setCall1((SafiCall)null);
				return;
			case ActionstepPackage.DIRECTORY__VM_CONTEXT:
				setVMContext((DynamicValue)null);
				return;
			case ActionstepPackage.DIRECTORY__DIAL_CONTEXT:
				setDialContext((DynamicValue)null);
				return;
			case ActionstepPackage.DIRECTORY__READ_EXTENSION_NUMBER:
				setReadExtensionNumber(READ_EXTENSION_NUMBER_EDEFAULT);
				return;
			case ActionstepPackage.DIRECTORY__ENTER_BY_FIRST_NAME:
				setEnterByFirstName(ENTER_BY_FIRST_NAME_EDEFAULT);
				return;
			case ActionstepPackage.DIRECTORY__ENTER_BY_FIRST_OR_LAST_NAME:
				setEnterByFirstOrLastName(ENTER_BY_FIRST_OR_LAST_NAME_EDEFAULT);
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
			case ActionstepPackage.DIRECTORY__CALL1:
				return call1 != null;
			case ActionstepPackage.DIRECTORY__VM_CONTEXT:
				return vMContext != null;
			case ActionstepPackage.DIRECTORY__DIAL_CONTEXT:
				return dialContext != null;
			case ActionstepPackage.DIRECTORY__READ_EXTENSION_NUMBER:
				return readExtensionNumber != READ_EXTENSION_NUMBER_EDEFAULT;
			case ActionstepPackage.DIRECTORY__ENTER_BY_FIRST_NAME:
				return enterByFirstName != ENTER_BY_FIRST_NAME_EDEFAULT;
			case ActionstepPackage.DIRECTORY__ENTER_BY_FIRST_OR_LAST_NAME:
				return enterByFirstOrLastName != ENTER_BY_FIRST_OR_LAST_NAME_EDEFAULT;
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
		if (baseClass == CallConsumer1.class) {
			switch (derivedFeatureID) {
				case ActionstepPackage.DIRECTORY__CALL1: return CallPackage.CALL_CONSUMER1__CALL1;
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
		if (baseClass == CallConsumer1.class) {
			switch (baseFeatureID) {
				case CallPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.DIRECTORY__CALL1;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (readExtensionNumber: ");
		result.append(readExtensionNumber);
		result.append(", enterByFirstName: ");
		result.append(enterByFirstName);
		result.append(", enterByFirstOrLastName: ");
		result.append(enterByFirstOrLastName);
		result.append(')');
		return result.toString();
	}

} //DirectoryImpl
