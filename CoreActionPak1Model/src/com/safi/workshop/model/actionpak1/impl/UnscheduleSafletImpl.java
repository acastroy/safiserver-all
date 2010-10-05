/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.impl;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.saflet.SafletContext;
import com.safi.db.VariableType;
import com.safi.db.util.VariableTranslator;
import com.safi.server.saflet.scheduling.SchedulingConstants;
import com.safi.server.saflet.scheduling.SchedulingManager;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.UnscheduleSaflet;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unschedule Saflet</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.impl.UnscheduleSafletImpl#getJobName <em>Job Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnscheduleSafletImpl extends ActionStepImpl implements UnscheduleSaflet {
	/**
	 * The cached value of the '{@link #getJobName() <em>Job Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJobName()
	 * @generated
	 * @ordered
	 */
	protected DynamicValue jobName;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnscheduleSafletImpl() {
		super();
	}

	@Override
	public void beginProcessing(SafletContext context) throws ActionStepException {
		super.beginProcessing(context);

		Exception exception = null;
		try {
			if (jobName == null)
				throw new ActionStepException("No job name specified");

			String jobNameStr = (String) VariableTranslator.translateValue(VariableType.TEXT, resolveDynamicValue(
					jobName, context));

			if (StringUtils.isBlank(jobNameStr))
				throw new ActionStepException("No job name specified");
			
			
			if (!SchedulingManager.getInstance().getScheduler().unscheduleJob(jobNameStr, SchedulingConstants.SAFLET_EXECUTION_GROUP_NAME))
				exception = new ActionStepException("Couldn't unschedule job "+jobNameStr);
			
		} catch (Exception e) {
			exception = e;
		}
		if (exception != null) {
			handleException(context, exception);
			return;
		}
		handleSuccess(context);

	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Actionpak1Package.Literals.UNSCHEDULE_SAFLET;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DynamicValue getJobName() {
		return jobName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetJobName(DynamicValue newJobName, NotificationChain msgs) {
		DynamicValue oldJobName = jobName;
		jobName = newJobName;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Actionpak1Package.UNSCHEDULE_SAFLET__JOB_NAME, oldJobName, newJobName);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJobName(DynamicValue newJobName) {
		if (newJobName != jobName) {
			NotificationChain msgs = null;
			if (jobName != null)
				msgs = ((InternalEObject)jobName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Actionpak1Package.UNSCHEDULE_SAFLET__JOB_NAME, null, msgs);
			if (newJobName != null)
				msgs = ((InternalEObject)newJobName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Actionpak1Package.UNSCHEDULE_SAFLET__JOB_NAME, null, msgs);
			msgs = basicSetJobName(newJobName, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.UNSCHEDULE_SAFLET__JOB_NAME, newJobName, newJobName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Actionpak1Package.UNSCHEDULE_SAFLET__JOB_NAME:
				return basicSetJobName(null, msgs);
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
			case Actionpak1Package.UNSCHEDULE_SAFLET__JOB_NAME:
				return getJobName();
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
			case Actionpak1Package.UNSCHEDULE_SAFLET__JOB_NAME:
				setJobName((DynamicValue)newValue);
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
			case Actionpak1Package.UNSCHEDULE_SAFLET__JOB_NAME:
				setJobName((DynamicValue)null);
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
			case Actionpak1Package.UNSCHEDULE_SAFLET__JOB_NAME:
				return jobName != null;
		}
		return super.eIsSet(featureID);
	}

} //UnscheduleSafletImpl
