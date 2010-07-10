/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.saflet.impl;

import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiRequest;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.Call;
import com.safi.asterisk.saflet.AsteriskSafletContext;
import com.safi.asterisk.saflet.SafletPackage;
import com.safi.asterisk.util.AsteriskSafletConstants;
import com.safi.core.call.SafiCall;
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
	 * @generated NOT
	 * @ordered
	 */
  protected static final String BUFFERED_DIGITS_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getBufferedDigits() <em>Buffered Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBufferedDigits()
	 * @generated NOT
	 * @ordered
	 */
	protected String bufferedDigits = BUFFERED_DIGITS_EDEFAULT;
		/**
	 * The cached value of the '{@link #getBufferedDigits() <em>Buffered Digits</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getBufferedDigits()
	 * @generated  
	 * @ordered
	 */
 

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  protected AsteriskSafletContextImpl() {
		super();
	}
  
  @Override
  public void preHandoffPrep(SafiCall scall) {
  	super.preHandoffPrep(scall);
  	if (scall != null && scall instanceof Call) {
			Call call = (Call) scall;
			AgiRequest request = (AgiRequest)getVariableRawValue(AsteriskSafletConstants.VAR_KEY_REQUEST);
			AgiChannel channel = (AgiChannel) getVariableRawValue(AsteriskSafletConstants.VAR_KEY_CHANNEL);
			call.setCallerIdName(request.getCallerIdName());
			call.setCallerIdNum(request.getCallerIdNumber());
			call.setChannel(channel);
			call.setChannelName(channel.getName());
			call.setUniqueId(channel.getUniqueId());
		}
  }

  @Override
  public void cleanup() {
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
	 * @generated
	 */
  public String getBufferedDigits() {
		return bufferedDigits;
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  public void setBufferedDigits(String newBufferedDigits) {
		String oldBufferedDigits = bufferedDigits;
		bufferedDigits = newBufferedDigits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SafletPackage.ASTERISK_SAFLET_CONTEXT__BUFFERED_DIGITS, oldBufferedDigits, bufferedDigits));
	}

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public void appendBufferedDigits(String digits) {
    if (digits == null)
      return;
    if (bufferedDigits == null)
    	bufferedDigits = digits;
    else
    	bufferedDigits += digits;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated NOT
   */
  public String flushBufferedDigits() {
  	String temp = bufferedDigits;
  	bufferedDigits = null;
    return temp;
  }

  @Override
  public char popBufferedDigit() {
  	StringBuffer buf = new StringBuffer(bufferedDigits);
  	
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
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SafletPackage.ASTERISK_SAFLET_CONTEXT__BUFFERED_DIGITS:
				return BUFFERED_DIGITS_EDEFAULT == null ? bufferedDigits != null : !BUFFERED_DIGITS_EDEFAULT.equals(bufferedDigits);
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (bufferedDigits: ");
		result.append(bufferedDigits);
		result.append(')');
		return result.toString();
	}

  
} // AsteriskSafletContextImpl
