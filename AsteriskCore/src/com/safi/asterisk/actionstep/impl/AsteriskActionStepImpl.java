/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.AsteriskActionStep;

import com.safi.core.actionstep.impl.ActionStepImpl;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Asterisk Action Step</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class AsteriskActionStepImpl extends ActionStepImpl implements AsteriskActionStep {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AsteriskActionStepImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActionstepPackage.Literals.ASTERISK_ACTION_STEP;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getPlatformID() {
		return "Asterisk";
	}

} //AsteriskActionStepImpl
