/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.impl;

import java.util.HashMap;
import java.util.Map;
import org.asteriskjava.fastagi.AgiChannel;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallState;
import com.safi.core.impl.ThreadSensitiveImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.impl.CallImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.asterisk.impl.CallImpl#getChannel <em>Channel</em>}</li>
 *   <li>{@link com.safi.asterisk.impl.CallImpl#getCallerIdName <em>Caller Id Name</em>}</li>
 *   <li>{@link com.safi.asterisk.impl.CallImpl#getCallerIdNum <em>Caller Id Num</em>}</li>
 *   <li>{@link com.safi.asterisk.impl.CallImpl#getUniqueId <em>Unique Id</em>}</li>
 *   <li>{@link com.safi.asterisk.impl.CallImpl#getChannelName <em>Channel Name</em>}</li>
 *   <li>{@link com.safi.asterisk.impl.CallImpl#getCallState <em>Call State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CallImpl extends ThreadSensitiveImpl implements Call {
  /**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
  protected static final String NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
  protected String name = NAME_EDEFAULT;

  /**
	 * The default value of the '{@link #getChannel() <em>Channel</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getChannel()
	 * @generated
	 * @ordered
	 */
  protected static final AgiChannel CHANNEL_EDEFAULT = null;

  /**
	 * The default value of the '{@link #getCallerIdName() <em>Caller Id Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallerIdName()
	 * @generated
	 * @ordered
	 */
  protected static final String CALLER_ID_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getCallerIdName() <em>Caller Id Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallerIdName()
	 * @generated
	 * @ordered
	 */
	protected String callerIdName = CALLER_ID_NAME_EDEFAULT;

		/**
	 * The cached value of the '{@link #getCallerIdName() <em>Caller Id Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallerIdName()
	 * @generated NOT
	 * @ordered
	 */
  protected ThreadLocal<String> callerIdNameHolder = new ThreadLocal<String>(){
  	protected String initialValue() {
  		return CALLER_ID_NAME_EDEFAULT;
  	}
  };
//  protected String callerIdName = CALLER_ID_NAME_EDEFAULT;

  /**
	 * The default value of the '{@link #getCallerIdNum() <em>Caller Id Num</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallerIdNum()
	 * @generated
	 * @ordered
	 */
  protected static final String CALLER_ID_NUM_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getCallerIdNum() <em>Caller Id Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallerIdNum()
	 * @generated
	 * @ordered
	 */
	protected String callerIdNum = CALLER_ID_NUM_EDEFAULT;

		/**
	 * The cached value of the '{@link #getCallerIdNum() <em>Caller Id Num</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallerIdNum()
	 * @generated NOT
	 * @ordered
	 */
  
  protected ThreadLocal<String> callerIdNumHolder = new ThreadLocal<String>(){
  	protected String initialValue() {
  		return CALLER_ID_NUM_EDEFAULT;
  	}
  };
//  protected String callerIdNum = CALLER_ID_NUM_EDEFAULT;

  /**
	 * The default value of the '{@link #getUniqueId() <em>Unique Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUniqueId()
	 * @generated
	 * @ordered
	 */
  protected static final String UNIQUE_ID_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getUniqueId() <em>Unique Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueId()
	 * @generated
	 * @ordered
	 */
	protected String uniqueId = UNIQUE_ID_EDEFAULT;

		/**
	 * The cached value of the '{@link #getUniqueId() <em>Unique Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getUniqueId()
	 * @generated NOT
	 * @ordered
	 */
  protected ThreadLocal<String> uniqueIdHolder = new ThreadLocal<String>(){
  	protected String initialValue() {
  		return UNIQUE_ID_EDEFAULT;
  	}
  };
//  protected String uniqueId = UNIQUE_ID_EDEFAULT;

  /**
	 * The default value of the '{@link #getChannelName() <em>Channel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getChannelName()
	 * @generated
	 * @ordered
	 */
  
  
  protected static final String CHANNEL_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getChannelName() <em>Channel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChannelName()
	 * @generated
	 * @ordered
	 */
	protected String channelName = CHANNEL_NAME_EDEFAULT;

		/**
	 * The cached value of the '{@link #getChannelName() <em>Channel Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getChannelName()
	 * @generated NOT
	 * @ordered
	 */
  
  protected ThreadLocal<String> channelNameHolder = new ThreadLocal<String>(){
  	protected String initialValue() {
  		return CHANNEL_NAME_EDEFAULT;
  	}
  };
//  protected String channelName = CHANNEL_NAME_EDEFAULT;

  /**
	 * The default value of the '{@link #getCallState() <em>Call State</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallState()
	 * @generated
	 * @ordered
	 */
  protected static final CallState CALL_STATE_EDEFAULT = CallState.AVAILABLE;

  /**
	 * The cached value of the '{@link #getCallState() <em>Call State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCallState()
	 * @generated
	 * @ordered
	 */
	protected CallState callState = CALL_STATE_EDEFAULT;

		/**
	 * The cached value of the '{@link #getCallState() <em>Call State</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallState()
	 * @generated NOT
	 * @ordered
	 */
  
  protected ThreadLocal<CallState> callStateHolder = new ThreadLocal<CallState>(){
  	protected CallState initialValue() {
  		return CALL_STATE_EDEFAULT;
  	}
  };
//  protected CallState callState = CALL_STATE_EDEFAULT;

  protected ThreadLocal<AgiChannel> channelHolder = new ThreadLocal<AgiChannel>();
//private AgiChannel channel;
  
  protected ThreadLocal<Map<String,Object>> dataMapHolder = new ThreadLocal<Map<String,Object>>(){
  	protected java.util.Map<String,Object> initialValue() {
  		return new HashMap<String, Object>();
  	}
  };
//  private Map<String,Object> dataMap;
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected CallImpl() {
		super();
	}

  @Override
  public void cleanup() {
  	
    callerIdNameHolder.remove();
    callStateHolder.remove();
    channelHolder.remove();
    channelNameHolder.remove();
    dataMapHolder.remove();
    uniqueIdHolder.remove();
    super.cleanup();
  }
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return AsteriskPackage.Literals.CALL;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getName() {
		return name;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AsteriskPackage.CALL__NAME, oldName, name));
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public AgiChannel getChannel() {

    return channelHolder.get();
  
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setChannel(AgiChannel newChannel) {
  	
    channelHolder.set(newChannel);
    if (newChannel == null)
      setChannelName(null);
    else {
      try {
        setChannelName(newChannel.getName());
      } catch (Exception e) {
        setChannelName(null);
      }
    }
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public String getCallerIdName() {
		return callerIdNameHolder.get();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public void setCallerIdName(String newCallerIdName) {
  	String oldCallerIdName = callerIdNameHolder.get();
  	callerIdNameHolder.set(newCallerIdName);
//		callerIdName = newCallerIdName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AsteriskPackage.CALL__CALLER_ID_NAME, oldCallerIdName, callerIdNameHolder.get()));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public String getCallerIdNum() {
		return callerIdNumHolder.get();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public void setCallerIdNum(String newCallerIdNum) {
		String oldCallerIdNum = callerIdNumHolder.get();
		callerIdNumHolder.set(newCallerIdNum);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AsteriskPackage.CALL__CALLER_ID_NUM, oldCallerIdNum, callerIdNumHolder.get()));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public String getUniqueId() {
		return uniqueIdHolder.get();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public void setUniqueId(String newUniqueId) {
		String oldUniqueId = uniqueIdHolder.get();
	
		uniqueIdHolder.set(newUniqueId);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AsteriskPackage.CALL__UNIQUE_ID, oldUniqueId, uniqueIdHolder.get()));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public String getChannelName() {
		return channelNameHolder.get();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setChannelName(String newChannelName) {
		String oldChannelName = channelName;
		channelName = newChannelName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AsteriskPackage.CALL__CHANNEL_NAME, oldChannelName, channelName));
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public CallState getCallState() {
    if (channelHolder.get() != null){
      try {
        return CallState.get(channelHolder.get().getChannelStatus());
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return CallState.UNKNOWN;
    
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public void setCallState(CallState newCallState) {
		CallState oldCallState = callStateHolder.get();
		callStateHolder.set(newCallState == null ? CALL_STATE_EDEFAULT : newCallState);
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AsteriskPackage.CALL__CALL_STATE, oldCallState, callStateHolder.get()));
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setData(String name, Object value) {
    dataMapHolder.get().put(name, value);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public Object getData(String name) {return dataMapHolder.get().get(name);}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AsteriskPackage.CALL__NAME:
				return getName();
			case AsteriskPackage.CALL__CHANNEL:
				return getChannel();
			case AsteriskPackage.CALL__CALLER_ID_NAME:
				return getCallerIdName();
			case AsteriskPackage.CALL__CALLER_ID_NUM:
				return getCallerIdNum();
			case AsteriskPackage.CALL__UNIQUE_ID:
				return getUniqueId();
			case AsteriskPackage.CALL__CHANNEL_NAME:
				return getChannelName();
			case AsteriskPackage.CALL__CALL_STATE:
				return getCallState();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AsteriskPackage.CALL__NAME:
				setName((String)newValue);
				return;
			case AsteriskPackage.CALL__CHANNEL:
				setChannel((AgiChannel)newValue);
				return;
			case AsteriskPackage.CALL__CALLER_ID_NAME:
				setCallerIdName((String)newValue);
				return;
			case AsteriskPackage.CALL__CALLER_ID_NUM:
				setCallerIdNum((String)newValue);
				return;
			case AsteriskPackage.CALL__UNIQUE_ID:
				setUniqueId((String)newValue);
				return;
			case AsteriskPackage.CALL__CHANNEL_NAME:
				setChannelName((String)newValue);
				return;
			case AsteriskPackage.CALL__CALL_STATE:
				setCallState((CallState)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eUnset(int featureID) {
		switch (featureID) {
			case AsteriskPackage.CALL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AsteriskPackage.CALL__CHANNEL:
				setChannel(CHANNEL_EDEFAULT);
				return;
			case AsteriskPackage.CALL__CALLER_ID_NAME:
				setCallerIdName(CALLER_ID_NAME_EDEFAULT);
				return;
			case AsteriskPackage.CALL__CALLER_ID_NUM:
				setCallerIdNum(CALLER_ID_NUM_EDEFAULT);
				return;
			case AsteriskPackage.CALL__UNIQUE_ID:
				setUniqueId(UNIQUE_ID_EDEFAULT);
				return;
			case AsteriskPackage.CALL__CHANNEL_NAME:
				setChannelName(CHANNEL_NAME_EDEFAULT);
				return;
			case AsteriskPackage.CALL__CALL_STATE:
				setCallState(CALL_STATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AsteriskPackage.CALL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AsteriskPackage.CALL__CHANNEL:
				return CHANNEL_EDEFAULT == null ? getChannel() != null : !CHANNEL_EDEFAULT.equals(getChannel());
			case AsteriskPackage.CALL__CALLER_ID_NAME:
				return CALLER_ID_NAME_EDEFAULT == null ? callerIdNameHolder.get() != null : !CALLER_ID_NAME_EDEFAULT.equals(callerIdNameHolder.get());
			case AsteriskPackage.CALL__CALLER_ID_NUM:
				return CALLER_ID_NUM_EDEFAULT == null ? callerIdNumHolder.get() != null : !CALLER_ID_NUM_EDEFAULT.equals(callerIdNumHolder.get());
			case AsteriskPackage.CALL__UNIQUE_ID:
				return UNIQUE_ID_EDEFAULT == null ? uniqueIdHolder.get() != null : !UNIQUE_ID_EDEFAULT.equals(uniqueIdHolder.get());
			case AsteriskPackage.CALL__CHANNEL_NAME:
				return CHANNEL_NAME_EDEFAULT == null ? channelNameHolder.get() != null : !CHANNEL_NAME_EDEFAULT.equals(channelNameHolder.get());
			case AsteriskPackage.CALL__CALL_STATE:
				return callStateHolder.get() != CALL_STATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", callerIdName: ");
		result.append(callerIdNameHolder.get());
		result.append(", callerIdNum: ");
		result.append(callerIdNumHolder.get());
		result.append(", uniqueId: ");
		result.append(uniqueIdHolder.get());
		result.append(", channelName: ");
		result.append(channelNameHolder.get());
		result.append(", callState: ");
		result.append(callStateHolder.get());
		result.append(')');
		return result.toString();
	}

} //CallImpl
