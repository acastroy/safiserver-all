/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.saflet.impl;

import java.util.logging.Logger;
import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.saflet.AsteriskSafletContext;
import com.safi.asterisk.saflet.SafletPackage;
import com.safi.core.saflet.impl.SafletContextImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Asterisk Saflet Context</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.saflet.impl.AsteriskSafletContextImpl#getBufferedDigits <em>Buffered Digits</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AsteriskSafletContextImpl extends SafletContextImpl implements AsteriskSafletContext {

  private final static Logger log = Logger.getLogger(AsteriskSafletContextImpl.class.getName());
  /**
	 * The default value of the '{@link #getBufferedDigits() <em>Buffered Digits</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBufferedDigits()
	 * @generated
	 * @ordered
	 */
  protected static final String BUFFERED_DIGITS_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getBufferedDigits() <em>Buffered Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferedDigits()
	 * @generated
	 * @ordered
	 */
	protected String bufferedDigits = BUFFERED_DIGITS_EDEFAULT;
		/**
	 * The cached value of the '{@link #getBufferedDigits() <em>Buffered Digits</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBufferedDigits()
	 * @generated NOT
	 * @ordered
	 */
//  protected String bufferedDigits = BUFFERED_DIGITS_EDEFAULT;
  protected ThreadLocal<StringBuffer> bufferedDigitsHolder = new ThreadLocal<StringBuffer>(){
  	protected StringBuffer initialValue() {
  		return new StringBuffer();
  	}
  };

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  protected AsteriskSafletContextImpl() {
		super();
	}

  @Override
  public void cleanup() {
    bufferedDigitsHolder.remove();
    super.cleanup();
  }
  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return SafletPackage.Literals.ASTERISK_SAFLET_CONTEXT;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
  public String getBufferedDigits() {
		String str = bufferedDigitsHolder.get().toString();
		if (StringUtils.isBlank(str)) return null;
		return str;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
  public void setBufferedDigits(String newBufferedDigits) {
		StringBuffer oldBufferedDigits = bufferedDigitsHolder.get();
		StringBuffer buf = new StringBuffer();
		if (newBufferedDigits != null)
			buf.append(newBufferedDigits);
	  bufferedDigitsHolder.set(buf);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafletPackage.ASTERISK_SAFLET_CONTEXT__BUFFERED_DIGITS, oldBufferedDigits.toString(), newBufferedDigits));
	}

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void appendBufferedDigits(String digits) {
    if (digits == null)
      return;
    bufferedDigitsHolder.get().append(digits);
//    if (bufferedDigits == null)
//      bufferedDigits = digits;
//    else
//      bufferedDigits += digits;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public String flushBufferedDigits() {
  	String temp = bufferedDigitsHolder.get().toString();
  	bufferedDigitsHolder.remove();
    return temp;
  }

  @Override
  public char popBufferedDigit() {
  	StringBuffer buf = bufferedDigitsHolder.get();
  	
    if (StringUtils.isBlank(buf.toString()))
      return (char) 253;
    buf.charAt(0);
    char first = buf.charAt(0);
    buf.deleteCharAt(0);
    return first;
  }

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SafletPackage.ASTERISK_SAFLET_CONTEXT__BUFFERED_DIGITS:
				return getBufferedDigits();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SafletPackage.ASTERISK_SAFLET_CONTEXT__BUFFERED_DIGITS:
				setBufferedDigits((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID) {
		switch (featureID) {
			case SafletPackage.ASTERISK_SAFLET_CONTEXT__BUFFERED_DIGITS:
				setBufferedDigits(BUFFERED_DIGITS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SafletPackage.ASTERISK_SAFLET_CONTEXT__BUFFERED_DIGITS:
				return BUFFERED_DIGITS_EDEFAULT == null ? bufferedDigitsHolder.get() != null : !BUFFERED_DIGITS_EDEFAULT.equals(bufferedDigitsHolder.get().toString());
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (bufferedDigits: ");
		result.append(bufferedDigitsHolder.get());
		result.append(')');
		return result.toString();
	}

  
} // AsteriskSafletContextImpl
