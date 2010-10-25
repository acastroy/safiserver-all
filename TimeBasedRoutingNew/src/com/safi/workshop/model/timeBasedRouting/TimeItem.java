/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeItem.java,v 1.2 2008/11/14 20:22:42 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting;

import com.safi.core.actionstep.CaseItem;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.TimeItem#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getTimeItem()
 * @model annotation="DynamicValueAnnotation superProperty='dynamicValue' type='Custom' isTypeLocked='true' description='The time range of this output' expectedReturnType='TimeRange' helperClass='com.safi.workshop.timeBasedRouting.pak.editpart.TimeRangeEditorPage'"
 *        annotation="Required criteria='non-null'"
 * @generated
 */
public interface TimeItem extends CaseItem {

  /**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getTimeItem_Description()
	 * @model
	 * @generated
	 */
  String getDescription();

  /**
	 * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.TimeItem#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
  void setDescription(String value);
} // TimeItem
