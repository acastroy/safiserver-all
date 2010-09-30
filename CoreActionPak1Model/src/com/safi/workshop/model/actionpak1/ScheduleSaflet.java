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
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getTargetSafletPath <em>Target Saflet Path</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getLabelText <em>Label Text</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getCronExpression <em>Cron Expression</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getStartDateTime <em>Start Date Time</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getEndDateTime <em>End Date Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getScheduleSaflet()
 * @model
 * @generated
 */
public interface ScheduleSaflet extends ParameterizedActionstep {
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
	 *        annotation="DynamicValueAnnotation type='Saflet Path' isTypeLocked='false' description='The path of the handler to which control will be transferred' expectedReturnType='Saflet Path' helperClass='com.safi.workshop.sheet.SelectSafletDynamicValueEditorPage'"
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
	 * Returns the value of the '<em><b>Label Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Text</em>' attribute.
	 * @see #setLabelText(String)
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getScheduleSaflet_LabelText()
	 * @model ordered="false"
	 * @generated
	 */
	String getLabelText();

	/**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.ScheduleSaflet#getLabelText <em>Label Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Text</em>' attribute.
	 * @see #getLabelText()
	 * @generated
	 */
	void setLabelText(String value);

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
	 *        annotation="DynamicValueAnnotation type='DateTime' isTypeLocked='false' description='Start DateTime for the the saflet execution schedule' expectedReturnType='VariableName' helperClass=''"
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
	 *        annotation="DynamicValueAnnotation type='DateTime' isTypeLocked='false' description='End DateTime for the the saflet execution schedule' expectedReturnType='VariableName' helperClass=''"
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

} // ScheduleSaflet
