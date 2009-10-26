/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Call Consumer2</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.CallConsumer2#getCall2 <em>Call2</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.AsteriskPackage#getCallConsumer2()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface CallConsumer2 extends CallConsumer1 {
  /**
   * Returns the value of the '<em><b>Call2</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call2</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Call2</em>' reference.
   * @see #setCall2(Call)
   * @see com.safi.asterisk.AsteriskPackage#getCallConsumer2_Call2()
   * @model
   * @generated
   */
  Call getCall2();

  /**
   * Sets the value of the '{@link com.safi.asterisk.CallConsumer2#getCall2 <em>Call2</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Call2</em>' reference.
   * @see #getCall2()
   * @generated
   */
  void setCall2(Call value);

} // CallConsumer2
