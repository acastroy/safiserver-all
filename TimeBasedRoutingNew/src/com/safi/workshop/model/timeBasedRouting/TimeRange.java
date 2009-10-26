/**
 * <copyright>
 * </copyright>
 *
 * $Id: TimeRange.java,v 1.2 2008/11/16 00:00:28 zacw Exp $
 */
package com.safi.workshop.model.timeBasedRouting;

import java.util.Date;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getOccursModel <em>Occurs Model</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getStartRange <em>Start Range</em>}</li>
 *   <li>{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getEndRange <em>End Range</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getTimeRange()
 * @model
 * @generated
 */
public interface TimeRange extends EObject {
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getTimeRange_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Occurs Model</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Occurs Model</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Occurs Model</em>' containment reference.
   * @see #setOccursModel(OccursModel)
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getTimeRange_OccursModel()
   * @model containment="true"
   * @generated
   */
  OccursModel getOccursModel();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getOccursModel <em>Occurs Model</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Occurs Model</em>' containment reference.
   * @see #getOccursModel()
   * @generated
   */
  void setOccursModel(OccursModel value);

  /**
   * Returns the value of the '<em><b>Start Range</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Start Range</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Start Range</em>' attribute.
   * @see #setStartRange(Date)
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getTimeRange_StartRange()
   * @model
   * @generated
   */
  Date getStartRange();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getStartRange <em>Start Range</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Start Range</em>' attribute.
   * @see #getStartRange()
   * @generated
   */
  void setStartRange(Date value);

  /**
   * Returns the value of the '<em><b>End Range</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End Range</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End Range</em>' attribute.
   * @see #setEndRange(Date)
   * @see com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage#getTimeRange_EndRange()
   * @model
   * @generated
   */
  Date getEndRange();

  /**
   * Sets the value of the '{@link com.safi.workshop.model.timeBasedRouting.TimeRange#getEndRange <em>End Range</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End Range</em>' attribute.
   * @see #getEndRange()
   * @generated
   */
  void setEndRange(Date value);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model
   * @generated
   */
  boolean isMatch(Date date);

} // TimeRange
