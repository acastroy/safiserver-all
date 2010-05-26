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
import com.safi.asterisk.actionstep.Background;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.call.CallConsumer1;
import com.safi.core.call.CallPackage;
import com.safi.core.call.SafiCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Background</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.BackgroundImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.BackgroundImpl#getFilenames <em>Filenames</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.BackgroundImpl#isPlayOnlyIfAnswered <em>Play Only If Answered</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.BackgroundImpl#isAnswerIfNecessary <em>Answer If Necessary</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.BackgroundImpl#isMatchOnlySingleDigit <em>Match Only Single Digit</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.BackgroundImpl#getContext <em>Context</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class BackgroundImpl extends ActionStepImpl implements Background {
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
	 * The cached value of the '{@link #getFilenames() <em>Filenames</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFilenames()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue filenames;

  /**
	 * The default value of the '{@link #isPlayOnlyIfAnswered() <em>Play Only If Answered</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isPlayOnlyIfAnswered()
	 * @generated
	 * @ordered
	 */
  protected static final boolean PLAY_ONLY_IF_ANSWERED_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isPlayOnlyIfAnswered() <em>Play Only If Answered</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isPlayOnlyIfAnswered()
	 * @generated
	 * @ordered
	 */
  protected boolean playOnlyIfAnswered = PLAY_ONLY_IF_ANSWERED_EDEFAULT;

  /**
	 * The default value of the '{@link #isAnswerIfNecessary() <em>Answer If Necessary</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isAnswerIfNecessary()
	 * @generated
	 * @ordered
	 */
  protected static final boolean ANSWER_IF_NECESSARY_EDEFAULT = true;

  /**
	 * The cached value of the '{@link #isAnswerIfNecessary() <em>Answer If Necessary</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isAnswerIfNecessary()
	 * @generated
	 * @ordered
	 */
  protected boolean answerIfNecessary = ANSWER_IF_NECESSARY_EDEFAULT;

  /**
	 * The default value of the '{@link #isMatchOnlySingleDigit() <em>Match Only Single Digit</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isMatchOnlySingleDigit()
	 * @generated
	 * @ordered
	 */
  protected static final boolean MATCH_ONLY_SINGLE_DIGIT_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isMatchOnlySingleDigit() <em>Match Only Single Digit</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isMatchOnlySingleDigit()
	 * @generated
	 * @ordered
	 */
  protected boolean matchOnlySingleDigit = MATCH_ONLY_SINGLE_DIGIT_EDEFAULT;

  /**
	 * The default value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
  protected static final String CONTEXT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
  protected String context = CONTEXT_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected BackgroundImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionstepPackage.Literals.BACKGROUND;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.BACKGROUND__CALL1, oldCall1, call1));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.BACKGROUND__CALL1, oldCall1, call1));
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getFilenames() {
		return filenames;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetFilenames(DynamicValue newFilenames, NotificationChain msgs) {
		DynamicValue oldFilenames = filenames;
		filenames = newFilenames;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.BACKGROUND__FILENAMES, oldFilenames, newFilenames);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setFilenames(DynamicValue newFilenames) {
		if (newFilenames != filenames) {
			NotificationChain msgs = null;
			if (filenames != null)
				msgs = ((InternalEObject)filenames).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.BACKGROUND__FILENAMES, null, msgs);
			if (newFilenames != null)
				msgs = ((InternalEObject)newFilenames).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.BACKGROUND__FILENAMES, null, msgs);
			msgs = basicSetFilenames(newFilenames, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.BACKGROUND__FILENAMES, newFilenames, newFilenames));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isPlayOnlyIfAnswered() {
		return playOnlyIfAnswered;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPlayOnlyIfAnswered(boolean newPlayOnlyIfAnswered) {
		boolean oldPlayOnlyIfAnswered = playOnlyIfAnswered;
		playOnlyIfAnswered = newPlayOnlyIfAnswered;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.BACKGROUND__PLAY_ONLY_IF_ANSWERED, oldPlayOnlyIfAnswered, playOnlyIfAnswered));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isAnswerIfNecessary() {
		return answerIfNecessary;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAnswerIfNecessary(boolean newAnswerIfNecessary) {
		boolean oldAnswerIfNecessary = answerIfNecessary;
		answerIfNecessary = newAnswerIfNecessary;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.BACKGROUND__ANSWER_IF_NECESSARY, oldAnswerIfNecessary, answerIfNecessary));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isMatchOnlySingleDigit() {
		return matchOnlySingleDigit;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMatchOnlySingleDigit(boolean newMatchOnlySingleDigit) {
		boolean oldMatchOnlySingleDigit = matchOnlySingleDigit;
		matchOnlySingleDigit = newMatchOnlySingleDigit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.BACKGROUND__MATCH_ONLY_SINGLE_DIGIT, oldMatchOnlySingleDigit, matchOnlySingleDigit));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getContext() {
		return context;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setContext(String newContext) {
		String oldContext = context;
		context = newContext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.BACKGROUND__CONTEXT, oldContext, context));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionstepPackage.BACKGROUND__FILENAMES:
				return basicSetFilenames(null, msgs);
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
			case ActionstepPackage.BACKGROUND__CALL1:
				if (resolve) return getCall1();
				return basicGetCall1();
			case ActionstepPackage.BACKGROUND__FILENAMES:
				return getFilenames();
			case ActionstepPackage.BACKGROUND__PLAY_ONLY_IF_ANSWERED:
				return isPlayOnlyIfAnswered();
			case ActionstepPackage.BACKGROUND__ANSWER_IF_NECESSARY:
				return isAnswerIfNecessary();
			case ActionstepPackage.BACKGROUND__MATCH_ONLY_SINGLE_DIGIT:
				return isMatchOnlySingleDigit();
			case ActionstepPackage.BACKGROUND__CONTEXT:
				return getContext();
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
			case ActionstepPackage.BACKGROUND__CALL1:
				setCall1((SafiCall)newValue);
				return;
			case ActionstepPackage.BACKGROUND__FILENAMES:
				setFilenames((DynamicValue)newValue);
				return;
			case ActionstepPackage.BACKGROUND__PLAY_ONLY_IF_ANSWERED:
				setPlayOnlyIfAnswered((Boolean)newValue);
				return;
			case ActionstepPackage.BACKGROUND__ANSWER_IF_NECESSARY:
				setAnswerIfNecessary((Boolean)newValue);
				return;
			case ActionstepPackage.BACKGROUND__MATCH_ONLY_SINGLE_DIGIT:
				setMatchOnlySingleDigit((Boolean)newValue);
				return;
			case ActionstepPackage.BACKGROUND__CONTEXT:
				setContext((String)newValue);
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
			case ActionstepPackage.BACKGROUND__CALL1:
				setCall1((SafiCall)null);
				return;
			case ActionstepPackage.BACKGROUND__FILENAMES:
				setFilenames((DynamicValue)null);
				return;
			case ActionstepPackage.BACKGROUND__PLAY_ONLY_IF_ANSWERED:
				setPlayOnlyIfAnswered(PLAY_ONLY_IF_ANSWERED_EDEFAULT);
				return;
			case ActionstepPackage.BACKGROUND__ANSWER_IF_NECESSARY:
				setAnswerIfNecessary(ANSWER_IF_NECESSARY_EDEFAULT);
				return;
			case ActionstepPackage.BACKGROUND__MATCH_ONLY_SINGLE_DIGIT:
				setMatchOnlySingleDigit(MATCH_ONLY_SINGLE_DIGIT_EDEFAULT);
				return;
			case ActionstepPackage.BACKGROUND__CONTEXT:
				setContext(CONTEXT_EDEFAULT);
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
			case ActionstepPackage.BACKGROUND__CALL1:
				return call1 != null;
			case ActionstepPackage.BACKGROUND__FILENAMES:
				return filenames != null;
			case ActionstepPackage.BACKGROUND__PLAY_ONLY_IF_ANSWERED:
				return playOnlyIfAnswered != PLAY_ONLY_IF_ANSWERED_EDEFAULT;
			case ActionstepPackage.BACKGROUND__ANSWER_IF_NECESSARY:
				return answerIfNecessary != ANSWER_IF_NECESSARY_EDEFAULT;
			case ActionstepPackage.BACKGROUND__MATCH_ONLY_SINGLE_DIGIT:
				return matchOnlySingleDigit != MATCH_ONLY_SINGLE_DIGIT_EDEFAULT;
			case ActionstepPackage.BACKGROUND__CONTEXT:
				return CONTEXT_EDEFAULT == null ? context != null : !CONTEXT_EDEFAULT.equals(context);
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
				case ActionstepPackage.BACKGROUND__CALL1: return CallPackage.CALL_CONSUMER1__CALL1;
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
				case CallPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.BACKGROUND__CALL1;
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
		result.append(" (playOnlyIfAnswered: ");
		result.append(playOnlyIfAnswered);
		result.append(", answerIfNecessary: ");
		result.append(answerIfNecessary);
		result.append(", matchOnlySingleDigit: ");
		result.append(matchOnlySingleDigit);
		result.append(", context: ");
		result.append(context);
		result.append(')');
		return result.toString();
	}

} //BackgroundImpl
