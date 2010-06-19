/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.saflet;

import com.safi.core.call.SafiCall;
import com.safi.core.saflet.SafletContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Asterisk Saflet Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.saflet.AsteriskSafletContext#getBufferedDigits <em>Buffered Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.saflet.SafletPackage#getAsteriskSafletContext()
 * @model
 * @generated
 */
public interface AsteriskSafletContext extends SafletContext {
  /**
	 * Returns the value of the '<em><b>Buffered Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Buffered Digits</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Buffered Digits</em>' attribute.
	 * @see #setBufferedDigits(String)
	 * @see com.safi.asterisk.saflet.SafletPackage#getAsteriskSafletContext_BufferedDigits()
	 * @model
	 * @generated
	 */
  String getBufferedDigits();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.saflet.AsteriskSafletContext#getBufferedDigits <em>Buffered Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buffered Digits</em>' attribute.
	 * @see #getBufferedDigits()
	 * @generated
	 */
  void setBufferedDigits(String value);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  void appendBufferedDigits(String digits);

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  String flushBufferedDigits();

  char popBufferedDigit();

} // AsteriskSafletContext
