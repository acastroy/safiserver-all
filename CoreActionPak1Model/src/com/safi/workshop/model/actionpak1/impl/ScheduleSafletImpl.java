/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.impl;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;

import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.impl.ParameterizedActionstepImpl;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;
import com.safi.db.VariableType;
import com.safi.db.server.config.TelephonySubsystem;
import com.safi.db.util.VariableTranslator;
import com.safi.server.saflet.scheduling.SafiTriggerSpec;
import com.safi.server.saflet.scheduling.SafletExecutionJob;
import com.safi.server.saflet.scheduling.SchedulingConstants;
import com.safi.server.saflet.scheduling.SchedulingManager;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.ScheduleSaflet;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Schedule Saflet</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link com.safi.workshop.model.actionpak1.impl.ScheduleSafletImpl#getTargetSafletPath
 * <em>Target Saflet Path</em>}</li>
 * <li>
 * {@link com.safi.workshop.model.actionpak1.impl.ScheduleSafletImpl#getLabelText
 * <em>Label Text</em>}</li>
 * <li>
 * {@link com.safi.workshop.model.actionpak1.impl.ScheduleSafletImpl#getCronExpression
 * <em>Cron Expression</em>}</li>
 * <li>
 * {@link com.safi.workshop.model.actionpak1.impl.ScheduleSafletImpl#getStartDateTime
 * <em>Start Date Time</em>}</li>
 * <li>
 * {@link com.safi.workshop.model.actionpak1.impl.ScheduleSafletImpl#getEndDateTime
 * <em>End Date Time</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ScheduleSafletImpl extends ParameterizedActionstepImpl implements ScheduleSaflet {
	/**
	 * The cached value of the '{@link #getTargetSafletPath()
	 * <em>Target Saflet Path</em>}' containment reference. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getTargetSafletPath()
	 * @generated
	 * @ordered
	 */
	protected DynamicValue targetSafletPath;

	/**
	 * The default value of the '{@link #getLabelText() <em>Label Text</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLabelText()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabelText() <em>Label Text</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLabelText()
	 * @generated
	 * @ordered
	 */
	protected String labelText = LABEL_TEXT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCronExpression()
	 * <em>Cron Expression</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCronExpression()
	 * @generated
	 * @ordered
	 */
	protected DynamicValue cronExpression;

	/**
	 * The cached value of the '{@link #getStartDateTime()
	 * <em>Start Date Time</em>}' containment reference. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getStartDateTime()
	 * @generated
	 * @ordered
	 */
	protected DynamicValue startDateTime;

	/**
	 * The cached value of the '{@link #getEndDateTime() <em>End Date Time</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getEndDateTime()
	 * @generated
	 * @ordered
	 */
	protected DynamicValue endDateTime;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ScheduleSafletImpl() {
		super();
	}

	@Override
	public void beginProcessing(SafletContext context) throws ActionStepException {
		super.beginProcessing(context);

		Exception exception = null;
		try {
			if (targetSafletPath == null)
				throw new ActionStepException("No target Saflet specified");

			String safletPath = (String) VariableTranslator.translateValue(VariableType.TEXT, resolveDynamicValue(
					targetSafletPath, context));

			if (StringUtils.isBlank(safletPath))
				throw new ActionStepException("No target Saflet specified");
			
			String[] pair = safletPath.split("/");
			if (pair.length != 2)
				throw new ActionStepException("Illegal Saflet path: "+safletPath);
			
			String pname = pair[0];
			String sname = pair[1];
			
			if (StringUtils.isBlank(pname)|| StringUtils.isBlank(sname))
				throw new ActionStepException("Illegal Saflet path: "+safletPath);
			
			TelephonySubsystem server = (TelephonySubsystem) context
					.getVariableRawValue(SafletConstants.VAR_KEY_TELEPHONY_SUBSYSTEM);

			Integer id = server == null ? -1 : server.getId();
			Properties props = new Properties();
			List<InputItem> params = getInputs();
			if (!inputs.isEmpty() && !params.isEmpty()) {
				for (InputItem param : params) {

					DynamicValue paramValue = param.getDynamicValue();
					Object parmVal = resolveDynamicValue(paramValue, context);
					props.put(param.getParameterName(), parmVal);
				}
			}

			Trigger trigger = null;
			String cronStr = null;
			if (cronExpression != null) {
				cronStr = (String) VariableTranslator.translateValue(VariableType.TEXT, resolveDynamicValue(cronExpression,
						context));
			}
			
			Date start = null;
			if (startDateTime != null) {
				start = (Date)VariableTranslator.translateValue(VariableType.DATETIME, resolveDynamicValue(startDateTime,
						context));
			}
			
			Date end = null;
			
			if (endDateTime != null) {
				end = (Date)VariableTranslator.translateValue(VariableType.DATETIME, resolveDynamicValue(endDateTime,
						context));
			}
			
			SafiTriggerSpec triggerSpec = new SafiTriggerSpec();
			
			if (StringUtils.isNotBlank(cronStr)){
				CronTrigger ct = new CronTrigger();
				ct.setCronExpression(cronStr);
				trigger = ct;
			}
			else {
				if (start == null)
					throw new ActionStepException("Start Date/Time is required for scheduled jobs without Cron expressions");
				trigger = new SimpleTrigger();
				
				triggerSpec.setSimpleStartTime(start.getTime());
				triggerSpec.setSimpleRepeatCount(0);
				triggerSpec.setSimpleRepeatInterval(0);
			}
			
			String tname = safletPath.replace('/', '_');
			tname = SchedulingManager.getInstance().getUniqueTriggerName(tname);
			trigger.setName(tname);
			if (start != null)
				trigger.setStartTime(start);

			String jobName = SchedulingManager.getInstance().getUniqueJobDetailName(tname);
			if (end != null)
				trigger.setEndTime(end);
			
			trigger.getJobDataMap().put(SafletExecutionJob.SAFLET_PROJECT_NAME, pname);
			trigger.getJobDataMap().put(SafletExecutionJob.SAFLET_NAME, sname);
			trigger.getJobDataMap().put(SafletExecutionJob.SAFLET_PROPERTIES, props);
			trigger.setGroup(SchedulingConstants.SAFLET_EXECUTION_GROUP_NAME);
			trigger.getJobDataMap().put(String.valueOf(SafiTriggerSpec.getSerialversionuid()), triggerSpec);
			JobDetail jobDetail = new JobDetail(jobName, SchedulingConstants.SAFLET_EXECUTION_GROUP_NAME,
	        SafletExecutionJob.class);
			jobDetail.addJobListener(SafletExecutionJob.SAFLET_EXECUTION_JOB_LISTENER_NAME);
			
			SchedulingManager.getInstance().getScheduler().scheduleJob(jobDetail, trigger);
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Actionpak1Package.Literals.SCHEDULE_SAFLET;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicValue getTargetSafletPath() {
		return targetSafletPath;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetTargetSafletPath(DynamicValue newTargetSafletPath, NotificationChain msgs) {
		DynamicValue oldTargetSafletPath = targetSafletPath;
		targetSafletPath = newTargetSafletPath;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Actionpak1Package.SCHEDULE_SAFLET__TARGET_SAFLET_PATH, oldTargetSafletPath, newTargetSafletPath);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setTargetSafletPath(DynamicValue newTargetSafletPath) {
		if (newTargetSafletPath != targetSafletPath) {
			NotificationChain msgs = null;
			if (targetSafletPath != null)
				msgs = ((InternalEObject) targetSafletPath).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Actionpak1Package.SCHEDULE_SAFLET__TARGET_SAFLET_PATH, null, msgs);
			if (newTargetSafletPath != null)
				msgs = ((InternalEObject) newTargetSafletPath).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Actionpak1Package.SCHEDULE_SAFLET__TARGET_SAFLET_PATH, null, msgs);
			msgs = basicSetTargetSafletPath(newTargetSafletPath, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.SCHEDULE_SAFLET__TARGET_SAFLET_PATH,
					newTargetSafletPath, newTargetSafletPath));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLabelText() {
		return labelText;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setLabelText(String newLabelText) {
		String oldLabelText = labelText;
		labelText = newLabelText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.SCHEDULE_SAFLET__LABEL_TEXT,
					oldLabelText, labelText));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicValue getCronExpression() {
		return cronExpression;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetCronExpression(DynamicValue newCronExpression, NotificationChain msgs) {
		DynamicValue oldCronExpression = cronExpression;
		cronExpression = newCronExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Actionpak1Package.SCHEDULE_SAFLET__CRON_EXPRESSION, oldCronExpression, newCronExpression);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCronExpression(DynamicValue newCronExpression) {
		if (newCronExpression != cronExpression) {
			NotificationChain msgs = null;
			if (cronExpression != null)
				msgs = ((InternalEObject) cronExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Actionpak1Package.SCHEDULE_SAFLET__CRON_EXPRESSION, null, msgs);
			if (newCronExpression != null)
				msgs = ((InternalEObject) newCronExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Actionpak1Package.SCHEDULE_SAFLET__CRON_EXPRESSION, null, msgs);
			msgs = basicSetCronExpression(newCronExpression, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.SCHEDULE_SAFLET__CRON_EXPRESSION,
					newCronExpression, newCronExpression));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicValue getStartDateTime() {
		return startDateTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetStartDateTime(DynamicValue newStartDateTime, NotificationChain msgs) {
		DynamicValue oldStartDateTime = startDateTime;
		startDateTime = newStartDateTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Actionpak1Package.SCHEDULE_SAFLET__START_DATE_TIME, oldStartDateTime, newStartDateTime);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setStartDateTime(DynamicValue newStartDateTime) {
		if (newStartDateTime != startDateTime) {
			NotificationChain msgs = null;
			if (startDateTime != null)
				msgs = ((InternalEObject) startDateTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Actionpak1Package.SCHEDULE_SAFLET__START_DATE_TIME, null, msgs);
			if (newStartDateTime != null)
				msgs = ((InternalEObject) newStartDateTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Actionpak1Package.SCHEDULE_SAFLET__START_DATE_TIME, null, msgs);
			msgs = basicSetStartDateTime(newStartDateTime, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.SCHEDULE_SAFLET__START_DATE_TIME,
					newStartDateTime, newStartDateTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DynamicValue getEndDateTime() {
		return endDateTime;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetEndDateTime(DynamicValue newEndDateTime, NotificationChain msgs) {
		DynamicValue oldEndDateTime = endDateTime;
		endDateTime = newEndDateTime;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					Actionpak1Package.SCHEDULE_SAFLET__END_DATE_TIME, oldEndDateTime, newEndDateTime);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setEndDateTime(DynamicValue newEndDateTime) {
		if (newEndDateTime != endDateTime) {
			NotificationChain msgs = null;
			if (endDateTime != null)
				msgs = ((InternalEObject) endDateTime).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- Actionpak1Package.SCHEDULE_SAFLET__END_DATE_TIME, null, msgs);
			if (newEndDateTime != null)
				msgs = ((InternalEObject) newEndDateTime).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- Actionpak1Package.SCHEDULE_SAFLET__END_DATE_TIME, null, msgs);
			msgs = basicSetEndDateTime(newEndDateTime, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.SCHEDULE_SAFLET__END_DATE_TIME,
					newEndDateTime, newEndDateTime));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Actionpak1Package.SCHEDULE_SAFLET__TARGET_SAFLET_PATH:
				return basicSetTargetSafletPath(null, msgs);
			case Actionpak1Package.SCHEDULE_SAFLET__CRON_EXPRESSION:
				return basicSetCronExpression(null, msgs);
			case Actionpak1Package.SCHEDULE_SAFLET__START_DATE_TIME:
				return basicSetStartDateTime(null, msgs);
			case Actionpak1Package.SCHEDULE_SAFLET__END_DATE_TIME:
				return basicSetEndDateTime(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Actionpak1Package.SCHEDULE_SAFLET__TARGET_SAFLET_PATH:
				return getTargetSafletPath();
			case Actionpak1Package.SCHEDULE_SAFLET__LABEL_TEXT:
				return getLabelText();
			case Actionpak1Package.SCHEDULE_SAFLET__CRON_EXPRESSION:
				return getCronExpression();
			case Actionpak1Package.SCHEDULE_SAFLET__START_DATE_TIME:
				return getStartDateTime();
			case Actionpak1Package.SCHEDULE_SAFLET__END_DATE_TIME:
				return getEndDateTime();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Actionpak1Package.SCHEDULE_SAFLET__TARGET_SAFLET_PATH:
				setTargetSafletPath((DynamicValue) newValue);
				return;
			case Actionpak1Package.SCHEDULE_SAFLET__LABEL_TEXT:
				setLabelText((String) newValue);
				return;
			case Actionpak1Package.SCHEDULE_SAFLET__CRON_EXPRESSION:
				setCronExpression((DynamicValue) newValue);
				return;
			case Actionpak1Package.SCHEDULE_SAFLET__START_DATE_TIME:
				setStartDateTime((DynamicValue) newValue);
				return;
			case Actionpak1Package.SCHEDULE_SAFLET__END_DATE_TIME:
				setEndDateTime((DynamicValue) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Actionpak1Package.SCHEDULE_SAFLET__TARGET_SAFLET_PATH:
				setTargetSafletPath((DynamicValue) null);
				return;
			case Actionpak1Package.SCHEDULE_SAFLET__LABEL_TEXT:
				setLabelText(LABEL_TEXT_EDEFAULT);
				return;
			case Actionpak1Package.SCHEDULE_SAFLET__CRON_EXPRESSION:
				setCronExpression((DynamicValue) null);
				return;
			case Actionpak1Package.SCHEDULE_SAFLET__START_DATE_TIME:
				setStartDateTime((DynamicValue) null);
				return;
			case Actionpak1Package.SCHEDULE_SAFLET__END_DATE_TIME:
				setEndDateTime((DynamicValue) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Actionpak1Package.SCHEDULE_SAFLET__TARGET_SAFLET_PATH:
				return targetSafletPath != null;
			case Actionpak1Package.SCHEDULE_SAFLET__LABEL_TEXT:
				return LABEL_TEXT_EDEFAULT == null ? labelText != null : !LABEL_TEXT_EDEFAULT.equals(labelText);
			case Actionpak1Package.SCHEDULE_SAFLET__CRON_EXPRESSION:
				return cronExpression != null;
			case Actionpak1Package.SCHEDULE_SAFLET__START_DATE_TIME:
				return startDateTime != null;
			case Actionpak1Package.SCHEDULE_SAFLET__END_DATE_TIME:
				return endDateTime != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (labelText: ");
		result.append(labelText);
		result.append(')');
		return result.toString();
	}

} // ScheduleSafletImpl
