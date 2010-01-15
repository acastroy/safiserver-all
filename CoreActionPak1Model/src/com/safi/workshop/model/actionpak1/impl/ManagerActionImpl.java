/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1.impl;

import java.lang.reflect.Method;
import java.util.Map;

import org.asteriskjava.manager.ManagerConnection;
import org.asteriskjava.manager.action.AbsoluteTimeoutAction;
import org.asteriskjava.manager.action.AgentCallbackLoginAction;
import org.asteriskjava.manager.action.AgentLogoffAction;
import org.asteriskjava.manager.action.AgentsAction;
import org.asteriskjava.manager.action.AgiAction;
import org.asteriskjava.manager.action.AtxferAction;
import org.asteriskjava.manager.action.BridgeAction;
import org.asteriskjava.manager.action.ChallengeAction;
import org.asteriskjava.manager.action.ChangeMonitorAction;
import org.asteriskjava.manager.action.CommandAction;
import org.asteriskjava.manager.action.CoreSettingsAction;
import org.asteriskjava.manager.action.CoreShowChannelsAction;
import org.asteriskjava.manager.action.CoreStatusAction;
import org.asteriskjava.manager.action.DbDelAction;
import org.asteriskjava.manager.action.DbDelTreeAction;
import org.asteriskjava.manager.action.DbGetAction;
import org.asteriskjava.manager.action.DbPutAction;
import org.asteriskjava.manager.action.EventsAction;
import org.asteriskjava.manager.action.ExtensionStateAction;
import org.asteriskjava.manager.action.GetConfigAction;
import org.asteriskjava.manager.action.GetVarAction;
import org.asteriskjava.manager.action.HangupAction;
import org.asteriskjava.manager.action.IaxPeerListAction;
import org.asteriskjava.manager.action.JabberSendAction;
import org.asteriskjava.manager.action.ListCommandsAction;
import org.asteriskjava.manager.action.LoginAction;
import org.asteriskjava.manager.action.LogoffAction;
import org.asteriskjava.manager.action.MailboxCountAction;
import org.asteriskjava.manager.action.MailboxStatusAction;
import org.asteriskjava.manager.action.MeetMeMuteAction;
import org.asteriskjava.manager.action.MeetMeUnmuteAction;
import org.asteriskjava.manager.action.ModuleCheckAction;
import org.asteriskjava.manager.action.ModuleLoadAction;
import org.asteriskjava.manager.action.MonitorAction;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.action.ParkAction;
import org.asteriskjava.manager.action.ParkedCallsAction;
import org.asteriskjava.manager.action.PauseMonitorAction;
import org.asteriskjava.manager.action.PingAction;
import org.asteriskjava.manager.action.PlayDtmfAction;
import org.asteriskjava.manager.action.QueueAddAction;
import org.asteriskjava.manager.action.QueueLogAction;
import org.asteriskjava.manager.action.QueuePauseAction;
import org.asteriskjava.manager.action.QueuePenaltyAction;
import org.asteriskjava.manager.action.QueueRemoveAction;
import org.asteriskjava.manager.action.QueueResetAction;
import org.asteriskjava.manager.action.QueueStatusAction;
import org.asteriskjava.manager.action.QueueSummaryAction;
import org.asteriskjava.manager.action.RedirectAction;
import org.asteriskjava.manager.action.SendTextAction;
import org.asteriskjava.manager.action.SetCdrUserFieldAction;
import org.asteriskjava.manager.action.SetVarAction;
import org.asteriskjava.manager.action.ShowDialplanAction;
import org.asteriskjava.manager.action.SipNotifyAction;
import org.asteriskjava.manager.action.SipPeersAction;
import org.asteriskjava.manager.action.SipShowRegistryAction;
import org.asteriskjava.manager.action.StatusAction;
import org.asteriskjava.manager.action.StopMonitorAction;
import org.asteriskjava.manager.action.UnpauseMonitorAction;
import org.asteriskjava.manager.action.UpdateConfigAction;
import org.asteriskjava.manager.action.UserEventAction;
import org.asteriskjava.manager.action.VoicemailUsersListAction;
import org.asteriskjava.manager.action.ZapDialOffhookAction;
import org.asteriskjava.manager.action.ZapDndOffAction;
import org.asteriskjava.manager.action.ZapDndOnAction;
import org.asteriskjava.manager.action.ZapHangupAction;
import org.asteriskjava.manager.action.ZapRestartAction;
import org.asteriskjava.manager.action.ZapShowChannelsAction;
import org.asteriskjava.manager.action.ZapTransferAction;
import org.asteriskjava.manager.response.ManagerError;
import org.asteriskjava.manager.response.ManagerResponse;
import org.asteriskjava.util.ReflectionUtil;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.util.AsteriskSafletConstants;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.OutputParameter;
import com.safi.core.actionstep.impl.ParameterizedActionstepImpl;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.workshop.model.actionpak1.Actionpak1Package;
import com.safi.workshop.model.actionpak1.ManagerAction;
import com.safi.workshop.model.actionpak1.ManagerActionType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manager Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.workshop.model.actionpak1.impl.ManagerActionImpl#getManagerActionType <em>Manager Action Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ManagerActionImpl extends ParameterizedActionstepImpl implements ManagerAction {
	/**
	 * The default value of the '{@link #getManagerActionType() <em>Manager Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerActionType()
	 * @generated
	 * @ordered
	 */
	protected static final ManagerActionType MANAGER_ACTION_TYPE_EDEFAULT = ManagerActionType.ABSOLUTE_TIMEOUT_ACTION;

	/**
	 * The cached value of the '{@link #getManagerActionType() <em>Manager Action Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getManagerActionType()
	 * @generated
	 * @ordered
	 */
	protected ManagerActionType managerActionType = MANAGER_ACTION_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManagerActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Actionpak1Package.Literals.MANAGER_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagerActionType getManagerActionType() {
		return managerActionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setManagerActionType(ManagerActionType newManagerActionType) {
		ManagerActionType oldManagerActionType = managerActionType;
		managerActionType = newManagerActionType == null ? MANAGER_ACTION_TYPE_EDEFAULT : newManagerActionType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, Actionpak1Package.MANAGER_ACTION__MANAGER_ACTION_TYPE, oldManagerActionType, managerActionType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Actionpak1Package.MANAGER_ACTION__MANAGER_ACTION_TYPE:
				return getManagerActionType();
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
			case Actionpak1Package.MANAGER_ACTION__MANAGER_ACTION_TYPE:
				setManagerActionType((ManagerActionType)newValue);
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
			case Actionpak1Package.MANAGER_ACTION__MANAGER_ACTION_TYPE:
				setManagerActionType(MANAGER_ACTION_TYPE_EDEFAULT);
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
			case Actionpak1Package.MANAGER_ACTION__MANAGER_ACTION_TYPE:
				return managerActionType != MANAGER_ACTION_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
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
		result.append(" (managerActionType: ");
		result.append(managerActionType);
		result.append(')');
		return result.toString();
	}
	/**
	   * <!-- begin-user-doc -->
	   * <!-- end-user-doc -->
	   * @generated NOT
	   */
	@Override
	public void beginProcessing(SafletContext context) throws ActionStepException {
		super.beginProcessing(context);
		if (managerActionType == null)
			handleException(context, new ActionStepException("ManagerActionType is not specified"));
		 Object variableRawValue = context
	        .getVariableRawValue(AsteriskSafletConstants.VAR_KEY_MANAGER_CONNECTION);
	    if (variableRawValue == null || !(variableRawValue instanceof ManagerConnection)) {
	      handleException(context, new ActionStepException(
	          "No manager connection found in current context"));
	      return;
	    }
	    ManagerConnection connection = (ManagerConnection) variableRawValue;
	    if(connection==null){
	    	handleException(context, new ActionStepException(
	          "No manager connection found in current context"));
	      return;
	    }
	   
	    Exception exception = null;
		try{
		  Class managerActionClass=getClassInfo(managerActionType);
			Map<String, Method> reflectMap = ReflectionUtil.getSetters(managerActionClass);
		  org.asteriskjava.manager.action.ManagerAction managerActionObject=(org.asteriskjava.manager.action.ManagerAction)managerActionClass.newInstance();
		  EList<InputItem> inputItemList=this.getInputs();
		  for(InputItem inputItem :inputItemList){
			  DynamicValue dynamicValue=inputItem.getDynamicValue();
			  if(dynamicValue!=null){
				  String paraName=inputItem.getParameterName();
				  if(paraName!=null){
				    String setMethod="set".concat(paraName);
				    Method method=reflectMap.get(setMethod);
				    Object dynaObject=this.resolveDynamicValue(dynamicValue, context);
				    Object []args={dynaObject};
				    method.invoke(managerActionObject, args);
				  }
			  }
		  }
		  EList<OutputParameter> outputs=this.getOutputParameters();
		  OutputParameter outputVal=(OutputParameter)outputs.get(0);
		  
		  ManagerResponse managerResponse=null;
		  ManagerResponse response = connection.sendAction(managerActionObject,
		          Saflet.DEFAULT_MANAGER_ACTION_TIMEOUT);
		      if (debugLog.isDebugEnabled())
		        debug("Monitor returned " + response.getMessage() + " of type " + response.getResponse());
		      if (response instanceof ManagerError)
		        exception = new ActionStepException("Couldn't monitor channel: " + response.getMessage());

		  if(outputVal!=null){
		   DynamicValue val=outputVal.getDynamicValue();
		   val.setText(managerResponse.getMessage());
		   //outputVal.setDynamicValue(val);
		  }
		}catch(Exception ex){
		  exception = ex;
		}
		  if (exception != null) {
		      handleException(context, exception);
		      return;
		    }

		    handleSuccess(context);
	}
	
	
	
	protected Class getClassInfo(ManagerActionType selectedManagerAction) {
		switch (selectedManagerAction) {
		case ABSOLUTE_TIMEOUT_ACTION:
			return (AbsoluteTimeoutAction.class);

		case AGENT_CALLBACK_LOGIN_ACTION:
			return (AgentCallbackLoginAction.class);

		case AGENT_LOGOFF_ACTION:
			return (AgentLogoffAction.class);

		case AGENTS_ACTION:
			return (AgentsAction.class);

		case AGI_ACTION:
			return (AgiAction.class);

		case ATXFER_ACTION:
			return (AtxferAction.class);

		case BRIDGE_ACTION:
			return (BridgeAction.class);

		case CHALLENGE_ACTION:
			return (ChallengeAction.class);

		case CHANGE_MONITOR_ACTION:
			return (ChangeMonitorAction.class);

		case COMMAND_ACTION:
			return (CommandAction.class);

		case CORE_SETTINGS_ACTION:
			return (CoreSettingsAction.class);

		case CORE_SHOW_CHANNELS_ACTION:
			return (CoreShowChannelsAction.class);

		case CORE_STATUS_ACTION:
			return (CoreStatusAction.class);

		case DB_DEL_ACTION:
			return (DbDelAction.class);

		case DB_DEL_TREE_ACTION:
			return (DbDelTreeAction.class);

		case DB_GET_ACTION:
			return (DbGetAction.class);

		case DB_PUT_ACTION:
			return (DbPutAction.class);

		case EVENTS_ACTION:
			return (EventsAction.class);

		case EXTENSION_STATE_ACTION:
			return (ExtensionStateAction.class);

		case GET_CONFIG_ACTION:
			return (GetConfigAction.class);

		case GET_VAR_ACTION:
			return (GetVarAction.class);

		case HANGUP_ACTION:
			return (HangupAction.class);

		case IAX_PEER_LIST_ACTION:
			return (IaxPeerListAction.class);

		case JABBER_SEND_ACTION:
			return (JabberSendAction.class);

		case LIST_COMMANDS_ACTION:
			return (ListCommandsAction.class);

		case LOGIN_ACTION:
			return (LoginAction.class);

		case LOGOFF_ACTION:
			return (LogoffAction.class);

		case MAILBOX_COUNT_ACTION:
			return (MailboxCountAction.class);

		case MAILBOX_STATUS_ACTION:
			return (MailboxStatusAction.class);

		case MEET_ME_MUTE_ACTION:
			return (MeetMeMuteAction.class);

		case MEET_ME_UNMUTE_ACTION:
			return (MeetMeUnmuteAction.class);

		case MODULE_CHECK_ACTION:
			return (ModuleCheckAction.class);

		case MODULE_LOAD_ACTION:
			return (ModuleLoadAction.class);

		case MONITOR_ACTION:
			return (MonitorAction.class);

		case ORIGINATE_ACTION:
			return (OriginateAction.class);

		case PARK_ACTION:
			return (ParkAction.class);

		case PARKED_CALLS_ACTION:
			return (ParkedCallsAction.class);

		case PAUSE_MONITOR_ACTION:
			return (PauseMonitorAction.class);

		case PING_ACTION:
			return (PingAction.class);

		case PLAY_DTMF_ACTION:
			return (PlayDtmfAction.class);

		case QUEUE_ADD_ACTION:
			return (QueueAddAction.class);

		case QUEUE_LOG_ACTION:
			return (QueueLogAction.class);

		case QUEUE_PAUSE_ACTION:
			return (QueuePauseAction.class);

		case QUEUE_PENALTY_ACTION:
			return (QueuePenaltyAction.class);

		case QUEUE_REMOVE_ACTION:
			return (QueueRemoveAction.class);

		case QUEUE_RESET_ACTION:
			return (QueueResetAction.class);

		case QUEUE_STATUS_ACTION:
			return (QueueStatusAction.class);

		case QUEUE_SUMMARY_ACTION:
			return (QueueSummaryAction.class);

		case REDIRECT_ACTION:
			return (RedirectAction.class);

		case SEND_TEXT_ACTION:
			return (SendTextAction.class);

		case SET_CDR_USER_FIELD_ACTION:
			return (SetCdrUserFieldAction.class);

		case SET_VAR_ACTION:
			return (SetVarAction.class);

		case SHOW_DIALPLAN_ACTION:
			return (ShowDialplanAction.class);

		case SIP_NOTIFY_ACTION:
			return (SipNotifyAction.class);

		case SIP_PEERS_ACTION:
			return (SipPeersAction.class);

		case SIP_SHOW_REGISTRY_ACTION:
			return (SipShowRegistryAction.class);

		case STATUS_ACTION:
			return (StatusAction.class);

		case STOP_MONITOR_ACTION:
			return (StopMonitorAction.class);

		case UNPAUSE_MONITOR_ACTION:
			return (UnpauseMonitorAction.class);

		case UPDATE_CONFIG_ACTION:
			return (UpdateConfigAction.class);

		case USER_EVENT_ACTION:
			return (UserEventAction.class);

		case VOICEMAIL_USERS_LIST_ACTION:
			return (VoicemailUsersListAction.class);

		case ZAP_DIAL_OFFHOOK_ACTION:
			return (ZapDialOffhookAction.class);

		case ZAP_DND_OFF_ACTION:
			return (ZapDndOffAction.class);

		case ZAP_DND_ON_ACTION:
			return (ZapDndOnAction.class);

		case ZAP_HANGUP_ACTION:
			return (ZapHangupAction.class);

		case ZAP_RESTART_ACTION:
			return (ZapRestartAction.class);

		case ZAP_SHOW_CHANNELS_ACTION:
			return (ZapShowChannelsAction.class);

		case ZAP_TRANSFER_ACTION:
			return (ZapTransferAction.class);

		default:
			return (AbsoluteTimeoutAction.class);

		}

	}
} //ManagerActionImpl
