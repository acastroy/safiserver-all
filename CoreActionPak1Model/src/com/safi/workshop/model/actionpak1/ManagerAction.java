/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1;

import com.safi.core.actionstep.ParameterizedActionstep;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Manager Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.ManagerAction#getManagerActionType <em>Manager Action Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getManagerAction()
 * @model
 * @generated
 */
public interface ManagerAction extends ParameterizedActionstep {
	/**
	 * Returns the value of the '<em><b>Manager Action Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.safi.workshop.model.actionpak1.ManagerActionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manager Action Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manager Action Type</em>' attribute.
	 * @see com.safi.workshop.model.actionpak1.ManagerActionType
	 * @see #setManagerActionType(ManagerActionType)
	 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getManagerAction_ManagerActionType()
	 * @model
	 * @generated
	 */
	ManagerActionType getManagerActionType();

	/**
	 * Sets the value of the '{@link com.safi.workshop.model.actionpak1.ManagerAction#getManagerActionType <em>Manager Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manager Action Type</em>' attribute.
	 * @see com.safi.workshop.model.actionpak1.ManagerActionType
	 * @see #getManagerActionType()
	 * @generated
	 */
	void setManagerActionType(ManagerActionType value);

} // ManagerAction
