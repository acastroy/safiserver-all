/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.asterisk.CallConsumer1;

import com.safi.core.actionstep.ActionStep;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Background Detect</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.BackgroundDetect#getFilename <em>Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.BackgroundDetect#getSilence <em>Silence</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.BackgroundDetect#getMinTime <em>Min Time</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.BackgroundDetect#getMaxTime <em>Max Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getBackgroundDetect()
 * @model
 * @generated
 */
public interface BackgroundDetect extends CallConsumer1, ActionStep {
  /**
   * Returns the value of the '<em><b>Filename</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Filename</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Filename</em>' attribute.
   * @see #setFilename(String)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getBackgroundDetect_Filename()
   * @model ordered="false"
   * @generated
   */
  String getFilename();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.BackgroundDetect#getFilename <em>Filename</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Filename</em>' attribute.
   * @see #getFilename()
   * @generated
   */
  void setFilename(String value);

  /**
   * Returns the value of the '<em><b>Silence</b></em>' attribute.
   * The default value is <code>"1000"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Silence</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Silence</em>' attribute.
   * @see #setSilence(int)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getBackgroundDetect_Silence()
   * @model default="1000" ordered="false"
   *        annotation="unitsTime milliseconds='true'"
   * @generated
   */
  int getSilence();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.BackgroundDetect#getSilence <em>Silence</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Silence</em>' attribute.
   * @see #getSilence()
   * @generated
   */
  void setSilence(int value);

  /**
   * Returns the value of the '<em><b>Min Time</b></em>' attribute.
   * The default value is <code>"100"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Min Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Min Time</em>' attribute.
   * @see #setMinTime(int)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getBackgroundDetect_MinTime()
   * @model default="100" ordered="false"
   *        annotation="unitsTime milliseconds='true'"
   * @generated
   */
  int getMinTime();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.BackgroundDetect#getMinTime <em>Min Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Min Time</em>' attribute.
   * @see #getMinTime()
   * @generated
   */
  void setMinTime(int value);

  /**
   * Returns the value of the '<em><b>Max Time</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Max Time</em>' attribute.
   * @see #setMaxTime(int)
   * @see com.safi.asterisk.actionstep.ActionstepPackage#getBackgroundDetect_MaxTime()
   * @model ordered="false"
   *        annotation="unitsTime milliseconds='true'"
   * @generated
   */
  int getMaxTime();

  /**
   * Sets the value of the '{@link com.safi.asterisk.actionstep.BackgroundDetect#getMaxTime <em>Max Time</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Max Time</em>' attribute.
   * @see #getMaxTime()
   * @generated
   */
  void setMaxTime(int value);

} // BackgroundDetect
