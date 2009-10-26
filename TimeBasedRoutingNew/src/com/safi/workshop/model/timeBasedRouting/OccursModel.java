/**
 * <copyright>
 * </copyright>
 *
 * $Id: OccursModel.java,v 1.2 2008/11/14 20:22:42 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting;

import java.util.Date;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Occurs Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.OccursModel#getMode <em>Mode</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.OccursModel#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getOccursModel()
 * @model
 * @generated
 */
public interface OccursModel extends EObject {
  /**
   * Returns the value of the '<em><b>Mode</b></em>' attribute.
   * The literals are from the enumeration {@link com.safi.workshop.model.timeBasedRouting.OccursMode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mode</em>' attribute.
   * @see com.safi.workshop.model.timeBasedRouting.OccursMode
   * @see #setMode(OccursMode)
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getOccursModel_Mode()
   * @model
   * @generated
   */
  OccursMode getMode();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.OccursModel#getMode <em>Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mode</em>' attribute.
   * @see com.safi.workshop.model.timeBasedRouting.OccursMode
   * @see #getMode()
   * @generated
   */
  void setMode(OccursMode value);

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
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getOccursModel_Description()
   * @model
   * @generated
   */
  String getDescription();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.OccursModel#getDescription <em>Description</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' attribute.
   * @see #getDescription()
   * @generated
   */
  void setDescription(String value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  boolean isMatch(Date date);

} // OccursModel
