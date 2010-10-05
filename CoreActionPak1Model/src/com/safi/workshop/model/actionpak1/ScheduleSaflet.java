/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1;

import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.ParameterizedActionstep;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schedule Saflet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getJobNamePrefix <em>Job Name Prefix</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getTargetSafletPath <em>Target Saflet Path</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getCronExpression <em>Cron Expression</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getStartDateTime <em>Start Date Time</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getEndDateTime <em>End Date Time</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getCalendarName <em>Calendar Name</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getJobName <em>Job Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getScheduleSaflet()
 * @model
 * @generated
 */
public interface ScheduleSaflet extends ParameterizedActionstep {
	/**
	 * Returns the value of the '<em><b>Job Name Prefix</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job Name Prefix</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job Name Prefix</em>' containment reference.
	 * @see #setJobNamePrefix(DynamicValue)
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getScheduleSaflet_JobNamePrefix()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='Text' isTypeLocked='false' description='Optional (unique) name to be assigned to the job ' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
	DynamicValue getJobNamePrefix();

	/**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getJobNamePrefix <em>Job Name Prefix</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Name Prefix</em>' containment reference.
	 * @see #getJobNamePrefix()
	 * @generated
	 */
	void setJobNamePrefix(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Job Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Job Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Job Name</em>' containment reference.
	 * @see #setJobName(DynamicValue)
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getScheduleSaflet_JobName()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='The unique name of the job that was created' expectedReturnType='Text' helperClass=''"
	 *        annotation="Directionality output='true'"
	 * @generated
	 */
	DynamicValue getJobName();

	/**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getJobName <em>Job Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Name</em>' containment reference.
	 * @see #getJobName()
	 * @generated
	 */
	void setJobName(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Target Saflet Path</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Saflet Path</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Saflet Path</em>' containment reference.
	 * @see #setTargetSafletPath(DynamicValue)
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getScheduleSaflet_TargetSafletPath()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='Text' isTypeLocked='false' description='The path of the handler to which control will be transferred' expectedReturnType='Saflet Path' helperClass='com.safi.workshop.sheet.SelectSafletDynamicValueEditorPage'"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
	DynamicValue getTargetSafletPath();

	/**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getTargetSafletPath <em>Target Saflet Path</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Saflet Path</em>' containment reference.
	 * @see #getTargetSafletPath()
	 * @generated
	 */
	void setTargetSafletPath(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Cron Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cron Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cron Expression</em>' containment reference.
	 * @see #setCronExpression(DynamicValue)
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getScheduleSaflet_CronExpression()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='Text' isTypeLocked='false' description='Cron expression defining the saflet execution schedule' expectedReturnType='Crontab Expr' helperClass='com.safi.workshop.sheet.ScheduledSafletDynamicValueEditorPage'"
	 * @generated
	 */
	DynamicValue getCronExpression();

	/**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getCronExpression <em>Cron Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cron Expression</em>' containment reference.
	 * @see #getCronExpression()
	 * @generated
	 */
	void setCronExpression(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Start Date Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Date Time</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Date Time</em>' containment reference.
	 * @see #setStartDateTime(DynamicValue)
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getScheduleSaflet_StartDateTime()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Start DateTime for the the saflet execution schedule' expectedReturnType='DateTime' helperClass=''"
	 * @generated
	 */
	DynamicValue getStartDateTime();

	/**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getStartDateTime <em>Start Date Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Date Time</em>' containment reference.
	 * @see #getStartDateTime()
	 * @generated
	 */
	void setStartDateTime(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>End Date Time</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Date Time</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Date Time</em>' containment reference.
	 * @see #setEndDateTime(DynamicValue)
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getScheduleSaflet_EndDateTime()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='End DateTime for the the saflet execution schedule' expectedReturnType='DateTime' helperClass=''"
	 * @generated
	 */
	DynamicValue getEndDateTime();

	/**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getEndDateTime <em>End Date Time</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Date Time</em>' containment reference.
	 * @see #getEndDateTime()
	 * @generated
	 */
	void setEndDateTime(DynamicValue value);

	/**
	 * Returns the value of the '<em><b>Calendar Name</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Calendar Name</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Calendar Name</em>' containment reference.
	 * @see #setCalendarName(DynamicValue)
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getScheduleSaflet_CalendarName()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='Text' isTypeLocked='false' description='Calendar name for the saflet execution schedule' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
	DynamicValue getCalendarName();

	/**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getCalendarName <em>Calendar Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Calendar Name</em>' containment reference.
	 * @see #getCalendarName()
	 * @generated
	 */
	void setCalendarName(DynamicValue value);

} // ScheduleSaflet
