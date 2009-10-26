/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.initiator;

import com.safi.asterisk.Call;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>DID Matcher</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.initiator.DIDMatcher#getDNISPattern <em>DNIS Pattern</em>}</li>
 *   <li>{@link com.safi.asterisk.initiator.DIDMatcher#getCall <em>Call</em>}</li>
 *   <li>{@link com.safi.asterisk.initiator.DIDMatcher#getCallName <em>Call Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.initiator.InitiatorPackage#getDIDMatcher()
 * @model
 * @generated
 */
public interface DIDMatcher extends EObject {
  /**
   * Returns the value of the '<em><b>DNIS Pattern</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>DNIS Pattern</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>DNIS Pattern</em>' attribute.
   * @see #setDNISPattern(String)
   * @see com.safi.asterisk.initiator.InitiatorPackage#getDIDMatcher_DNISPattern()
   * @model ordered="false"
   * @generated
   */
  String getDNISPattern();

  /**
   * Sets the value of the '{@link com.safi.asterisk.initiator.DIDMatcher#getDNISPattern <em>DNIS Pattern</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>DNIS Pattern</em>' attribute.
   * @see #getDNISPattern()
   * @generated
   */
  void setDNISPattern(String value);

  /**
   * Returns the value of the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call</em>' containment reference.
   * @see #setCall(Call)
   * @see com.safi.asterisk.initiator.InitiatorPackage#getDIDMatcher_Call()
   * @model containment="true" ordered="false"
   * @generated
   */
  Call getCall();

  /**
   * Sets the value of the '{@link com.safi.asterisk.initiator.DIDMatcher#getCall <em>Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call</em>' containment reference.
   * @see #getCall()
   * @generated
   */
  void setCall(Call value);

  /**
   * Returns the value of the '<em><b>Call Name</b></em>' attribute.
   * The default value is <code>"Call1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call Name</em>' attribute.
   * @see #setCallName(String)
   * @see com.safi.asterisk.initiator.InitiatorPackage#getDIDMatcher_CallName()
   * @model default="Call1" ordered="false"
   * @generated
   */
  String getCallName();

  /**
   * Sets the value of the '{@link com.safi.asterisk.initiator.DIDMatcher#getCallName <em>Call Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call Name</em>' attribute.
   * @see #getCallName()
   * @generated
   */
  void setCallName(String value);

} // DIDMatcher
