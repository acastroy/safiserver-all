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
import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallConsumer1;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.VMAuthenticate;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.impl.ActionStepImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>VM Authenticate</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VMAuthenticateImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VMAuthenticateImpl#getMailbox <em>Mailbox</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VMAuthenticateImpl#isSkipInstructions <em>Skip Instructions</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.VMAuthenticateImpl#isSetAccountCode <em>Set Account Code</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VMAuthenticateImpl extends ActionStepImpl implements VMAuthenticate {
  /**
	 * The cached value of the '{@link #getCall1() <em>Call1</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCall1()
	 * @generated
	 * @ordered
	 */
  protected Call call1;

  /**
	 * The cached value of the '{@link #getMailbox() <em>Mailbox</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMailbox()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue mailbox;

  /**
	 * The default value of the '{@link #isSkipInstructions() <em>Skip Instructions</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSkipInstructions()
	 * @generated
	 * @ordered
	 */
  protected static final boolean SKIP_INSTRUCTIONS_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isSkipInstructions() <em>Skip Instructions</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSkipInstructions()
	 * @generated
	 * @ordered
	 */
  protected boolean skipInstructions = SKIP_INSTRUCTIONS_EDEFAULT;

  /**
	 * The default value of the '{@link #isSetAccountCode() <em>Set Account Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAccountCode()
	 * @generated
	 * @ordered
	 */
  protected static final boolean SET_ACCOUNT_CODE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isSetAccountCode() <em>Set Account Code</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isSetAccountCode()
	 * @generated
	 * @ordered
	 */
  protected boolean setAccountCode = SET_ACCOUNT_CODE_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected VMAuthenticateImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionstepPackage.Literals.VM_AUTHENTICATE;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Call getCall1() {
		if (call1 != null && call1.eIsProxy()) {
			InternalEObject oldCall1 = (InternalEObject)call1;
			call1 = (Call)eResolveProxy(oldCall1);
			if (call1 != oldCall1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.VM_AUTHENTICATE__CALL1, oldCall1, call1));
			}
		}
		return call1;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Call basicGetCall1() {
		return call1;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCall1(Call newCall1) {
		Call oldCall1 = call1;
		call1 = newCall1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VM_AUTHENTICATE__CALL1, oldCall1, call1));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getMailbox() {
		return mailbox;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetMailbox(DynamicValue newMailbox, NotificationChain msgs) {
		DynamicValue oldMailbox = mailbox;
		mailbox = newMailbox;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.VM_AUTHENTICATE__MAILBOX, oldMailbox, newMailbox);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMailbox(DynamicValue newMailbox) {
		if (newMailbox != mailbox) {
			NotificationChain msgs = null;
			if (mailbox != null)
				msgs = ((InternalEObject)mailbox).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.VM_AUTHENTICATE__MAILBOX, null, msgs);
			if (newMailbox != null)
				msgs = ((InternalEObject)newMailbox).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.VM_AUTHENTICATE__MAILBOX, null, msgs);
			msgs = basicSetMailbox(newMailbox, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VM_AUTHENTICATE__MAILBOX, newMailbox, newMailbox));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSkipInstructions() {
		return skipInstructions;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSkipInstructions(boolean newSkipInstructions) {
		boolean oldSkipInstructions = skipInstructions;
		skipInstructions = newSkipInstructions;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VM_AUTHENTICATE__SKIP_INSTRUCTIONS, oldSkipInstructions, skipInstructions));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isSetAccountCode() {
		return setAccountCode;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setSetAccountCode(boolean newSetAccountCode) {
		boolean oldSetAccountCode = setAccountCode;
		setAccountCode = newSetAccountCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.VM_AUTHENTICATE__SET_ACCOUNT_CODE, oldSetAccountCode, setAccountCode));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionstepPackage.VM_AUTHENTICATE__MAILBOX:
				return basicSetMailbox(null, msgs);
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
			case ActionstepPackage.VM_AUTHENTICATE__CALL1:
				if (resolve) return getCall1();
				return basicGetCall1();
			case ActionstepPackage.VM_AUTHENTICATE__MAILBOX:
				return getMailbox();
			case ActionstepPackage.VM_AUTHENTICATE__SKIP_INSTRUCTIONS:
				return isSkipInstructions();
			case ActionstepPackage.VM_AUTHENTICATE__SET_ACCOUNT_CODE:
				return isSetAccountCode();
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
			case ActionstepPackage.VM_AUTHENTICATE__CALL1:
				setCall1((Call)newValue);
				return;
			case ActionstepPackage.VM_AUTHENTICATE__MAILBOX:
				setMailbox((DynamicValue)newValue);
				return;
			case ActionstepPackage.VM_AUTHENTICATE__SKIP_INSTRUCTIONS:
				setSkipInstructions((Boolean)newValue);
				return;
			case ActionstepPackage.VM_AUTHENTICATE__SET_ACCOUNT_CODE:
				setSetAccountCode((Boolean)newValue);
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
			case ActionstepPackage.VM_AUTHENTICATE__CALL1:
				setCall1((Call)null);
				return;
			case ActionstepPackage.VM_AUTHENTICATE__MAILBOX:
				setMailbox((DynamicValue)null);
				return;
			case ActionstepPackage.VM_AUTHENTICATE__SKIP_INSTRUCTIONS:
				setSkipInstructions(SKIP_INSTRUCTIONS_EDEFAULT);
				return;
			case ActionstepPackage.VM_AUTHENTICATE__SET_ACCOUNT_CODE:
				setSetAccountCode(SET_ACCOUNT_CODE_EDEFAULT);
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
			case ActionstepPackage.VM_AUTHENTICATE__CALL1:
				return call1 != null;
			case ActionstepPackage.VM_AUTHENTICATE__MAILBOX:
				return mailbox != null;
			case ActionstepPackage.VM_AUTHENTICATE__SKIP_INSTRUCTIONS:
				return skipInstructions != SKIP_INSTRUCTIONS_EDEFAULT;
			case ActionstepPackage.VM_AUTHENTICATE__SET_ACCOUNT_CODE:
				return setAccountCode != SET_ACCOUNT_CODE_EDEFAULT;
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
				case ActionstepPackage.VM_AUTHENTICATE__CALL1: return AsteriskPackage.CALL_CONSUMER1__CALL1;
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
				case AsteriskPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.VM_AUTHENTICATE__CALL1;
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
		result.append(" (skipInstructions: ");
		result.append(skipInstructions);
		result.append(", setAccountCode: ");
		result.append(setAccountCode);
		result.append(')');
		return result.toString();
	}

} //VMAuthenticateImpl
