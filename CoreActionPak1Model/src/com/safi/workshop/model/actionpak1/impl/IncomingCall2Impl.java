/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.manager.ManagerConnection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.AsteriskPackage;
import com.safi.asterisk.Call;
import com.safi.asterisk.CallSource1;
import com.safi.asterisk.initiator.AsteriskInitiatorInfo;
import com.safi.asterisk.util.AsteriskSafletConstants;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.core.actionstep.impl.ParameterizedInitiatorImpl;
import com.safi.core.actionstep.util.VariableTranslator;
import com.safi.core.initiator.InitiatorInfo;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletConstants;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletEnvironment;
import com.safi.db.DbFactory;
import com.safi.db.Variable;
import com.safi.db.VariableScope;
import com.safi.db.VariableType;
import com.safi.db.server.config.AsteriskServer;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.IncomingCall2;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Incoming Call2</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.impl.IncomingCall2Impl#getNewCall1 <em>New Call1</em>}</li>
 *   <li>{@link com.safi.workshop.model.actionpak1.impl.IncomingCall2Impl#getCallName <em>Call Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IncomingCall2Impl extends ParameterizedInitiatorImpl implements IncomingCall2 {
  /**
	 * The cached value of the '{@link #getNewCall1() <em>New Call1</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getNewCall1()
	 * @generated
	 * @ordered
	 */
  protected Call newCall1;

  /**
	 * The default value of the '{@link #getCallName() <em>Call Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallName()
	 * @generated
	 * @ordered
	 */
  protected static final String CALL_NAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getCallName() <em>Call Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallName()
	 * @generated
	 * @ordered
	 */
  protected String callName = CALL_NAME_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected IncomingCall2Impl() {
		super();
	}

  @Override
  public void beginProcessing() throws ActionStepException {
    SafletContext handlerContext = getSaflet().getSafletContext();
    Object o = handlerContext.getVariableRawValue(SafletConstants.VAR_KEY_PROPS);
    Map map = null;
    if (o instanceof Map) {
      map = (Map) o;

      List<InputItem> inputs = getInputs();
      if (!inputs.isEmpty()) {
        for (InputItem item : inputs) {
          String paramName = item.getParameterName();
          Object val = map.get(paramName);
          if (val != null) {
            DynamicValue variableName = item.getDynamicValue();
            Variable v = resolveVariableFromName(variableName, handlerContext);
            if (v != null) {
              if (debugLog.isDebugEnabled())
                debug("Got variable " + v.getName() + " of type " + v.getType());

              final Object translated = VariableTranslator.translateValue(v.getType(), val);
              if (v.getScope() != VariableScope.GLOBAL)
                handlerContext.setVariableRawValue(v.getName(), translated);
              else {
                if (handlerContext.getDebugLock() != null) {
                  handlerContext.setVariableRawValue(v.getName(), translated);
                  v.setDefaultValue(v.getDefaultValue()); //trigger update
                } else {
                  SafletEnvironment env = getSaflet().getSafletEnvironment();
                  env.setGlobalVariableValue(v.getName(), translated);
                }
              }
            }
          }
        }
      }
    }
    super.beginProcessing();
  }
  

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public boolean acceptsRequest(InitiatorInfo context) {
    return context instanceof AsteriskInitiatorInfo;
  }
  
  
  @Override
  public void createDefaultOutputs() {
    
    Output o = ActionStepFactory.eINSTANCE.createOutput();
    o.setOutputType(OutputType.DEFAULT);
    o.setName("start");
    setDefaultOutput(o);
    getOutputs().add(o);
    
  }
  
//  /**
//   * <!-- begin-user-doc -->
//   * <!-- end-user-doc -->
//   * @generated NOT
//   */
//  @Override
//  public boolean handleEvent(ManagerEvent event) {
//    // TODO Auto-generated method stub
//    return false;
//  }
  
  @Override
  public void initialize(InitiatorInfo info) throws ActionStepException {
    super.initialize(info);
    if (newCall1 == null)
      throw new ActionStepException("No call found for IncomingCall initiator "+getName());
    AgiRequest request = ((AsteriskInitiatorInfo)info).getRequest();
    AgiChannel channel = ((AsteriskInitiatorInfo)info).getChannel();
    AsteriskServer server = ((AsteriskInitiatorInfo)info).getAsteriskServer();
    ManagerConnection connection = ((AsteriskInitiatorInfo)info).getManagerConnection();
    Saflet handler = getSaflet();
    SafletContext context = handler.getSafletContext();
    
    if (request != null) {
      Variable requestVar = context.getVariable(AsteriskSafletConstants.VAR_KEY_REQUEST);
      if (requestVar == null) {
        requestVar = DbFactory.eINSTANCE.createVariable();
        requestVar.setName(AsteriskSafletConstants.VAR_KEY_REQUEST);
      }

      requestVar.setName(AsteriskSafletConstants.VAR_KEY_REQUEST);
      requestVar.setType(VariableType.OBJECT);
      requestVar.setScope(VariableScope.RUNTIME);
      requestVar.setDefaultValue(request);
      context.addOrUpdateVariable(requestVar);
    }

    if (channel != null) {
      Variable channelVar = DbFactory.eINSTANCE.createVariable();
      channelVar.setName(AsteriskSafletConstants.VAR_KEY_CHANNEL);
      channelVar.setType(VariableType.OBJECT);
      channelVar.setScope(VariableScope.RUNTIME);
      channelVar.setDefaultValue(channel);
      context.addOrUpdateVariable(channelVar);
    }

    if (connection != null) {
      Variable connectionVar = DbFactory.eINSTANCE.createVariable();
      connectionVar.setName(AsteriskSafletConstants.VAR_KEY_MANAGER_CONNECTION);
      connectionVar.setType(VariableType.OBJECT);
      connectionVar.setScope(VariableScope.RUNTIME);
      connectionVar.setDefaultValue(connection);
      context.addOrUpdateVariable(connectionVar);
    }
    
    if (server != null) {
      Variable serverVar = DbFactory.eINSTANCE.createVariable();
      serverVar.setName(AsteriskSafletConstants.VAR_KEY_ASTERISK_SERVER);
      serverVar.setType(VariableType.OBJECT);
      serverVar.setScope(VariableScope.RUNTIME);
      serverVar.setDefaultValue(server);
      context.addOrUpdateVariable(serverVar);
    }
    
    
    newCall1.setCallerIdName(request.getCallerIdName());
    newCall1.setCallerIdNum(request.getCallerIdNumber());
    newCall1.setChannel(channel);
    newCall1.setChannelName(channel.getName());
    newCall1.setUniqueId(channel.getUniqueId());
    super.initialize(info);
  }
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return Actionpak1Package.Literals.INCOMING_CALL2;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Call getNewCall1() {
		return newCall1;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetNewCall1(Call newNewCall1, NotificationChain msgs) {
		Call oldNewCall1 = newCall1;
		newCall1 = newNewCall1;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, Actionpak1Package.INCOMING_CALL2__NEW_CALL1, oldNewCall1, newNewCall1);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setNewCall1(Call newNewCall1) {
		if (newNewCall1 != newCall1) {
			NotificationChain msgs = null;
			if (newCall1 != null)
				msgs = ((InternalEObject)newCall1).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - Actionpak1Package.INCOMING_CALL2__NEW_CALL1, null, msgs);
			if (newNewCall1 != null)
				msgs = ((InternalEObject)newNewCall1).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - Actionpak1Package.INCOMING_CALL2__NEW_CALL1, null, msgs);
			msgs = basicSetNewCall1(newNewCall1, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.INCOMING_CALL2__NEW_CALL1, newNewCall1, newNewCall1));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getCallName() {
		return callName;
	}

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  public void setCallName(String newCallName) {
    if (StringUtils.isBlank(newCallName) && getNewCall1() != null)
      throw new IllegalArgumentException("Call Name must not be blank");
    String oldCallName = callName;
    callName = newCallName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.INCOMING_CALL2__CALL_NAME, oldCallName, callName));
    if (!StringUtils.equals(oldCallName, callName) && getNewCall1() != null){
      Call call = getNewCall1();
      call.setName(callName);
    }
  }

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Actionpak1Package.INCOMING_CALL2__NEW_CALL1:
				return basicSetNewCall1(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Actionpak1Package.INCOMING_CALL2__NEW_CALL1:
				return getNewCall1();
			case Actionpak1Package.INCOMING_CALL2__CALL_NAME:
				return getCallName();
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
			case Actionpak1Package.INCOMING_CALL2__NEW_CALL1:
				setNewCall1((Call)newValue);
				return;
			case Actionpak1Package.INCOMING_CALL2__CALL_NAME:
				setCallName((String)newValue);
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
			case Actionpak1Package.INCOMING_CALL2__NEW_CALL1:
				setNewCall1((Call)null);
				return;
			case Actionpak1Package.INCOMING_CALL2__CALL_NAME:
				setCallName(CALL_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Actionpak1Package.INCOMING_CALL2__NEW_CALL1:
				return newCall1 != null;
			case Actionpak1Package.INCOMING_CALL2__CALL_NAME:
				return CALL_NAME_EDEFAULT == null ? callName != null : !CALL_NAME_EDEFAULT.equals(callName);
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == CallSource1.class) {
			switch (derivedFeatureID) {
				case Actionpak1Package.INCOMING_CALL2__NEW_CALL1: return AsteriskPackage.CALL_SOURCE1__NEW_CALL1;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == CallSource1.class) {
			switch (baseFeatureID) {
				case AsteriskPackage.CALL_SOURCE1__NEW_CALL1: return Actionpak1Package.INCOMING_CALL2__NEW_CALL1;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (callName: ");
		result.append(callName);
		result.append(')');
		return result.toString();
	}

} //IncomingCall2Impl
