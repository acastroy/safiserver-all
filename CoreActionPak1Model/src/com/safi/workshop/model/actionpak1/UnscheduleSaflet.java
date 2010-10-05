/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unschedule Saflet</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.UnscheduleSaflet#getJobName <em>Job Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getUnscheduleSaflet()
 * @model
 * @generated
 */
public interface UnscheduleSaflet extends ActionStep {
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
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getUnscheduleSaflet_JobName()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Name of the job to be unscheduled' expectedReturnType='VariableName' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
	DynamicValue getJobName();

	/**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.UnscheduleSaflet#getJobName <em>Job Name</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Job Name</em>' containment reference.
	 * @see #getJobName()
	 * @generated
	 */
	void setJobName(DynamicValue value);

} // UnscheduleSaflet
