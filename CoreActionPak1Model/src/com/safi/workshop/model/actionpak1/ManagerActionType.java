/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.workshop.model.actionpak1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Manager Action Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see com.safi.workshop.model.actionpak1.Actionpak1Package#getManagerActionType()
 * @model
 * @generated
 */
public enum ManagerActionType implements Enumerator {
	/**
	 * The '<em><b>Absolute Timeout Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ABSOLUTE_TIMEOUT_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ABSOLUTE_TIMEOUT_ACTION(0, "AbsoluteTimeoutAction", "AbsoluteTimeoutAction"),

	/**
	 * The '<em><b>Agent Callback Login Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGENT_CALLBACK_LOGIN_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	AGENT_CALLBACK_LOGIN_ACTION(1, "AgentCallbackLoginAction", "AgentCallbackLoginAction"),

	/**
	 * The '<em><b>Agent Logoff Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGENT_LOGOFF_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	AGENT_LOGOFF_ACTION(2, "AgentLogoffAction", "AgentLogoffAction"),

	/**
	 * The '<em><b>Agents Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGENTS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	AGENTS_ACTION(3, "AgentsAction", "AgentsAction"),

	/**
	 * The '<em><b>Agi Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGI_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	AGI_ACTION(4, "AgiAction", "AgiAction"),

	/**
	 * The '<em><b>Atxfer Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ATXFER_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ATXFER_ACTION(5, "AtxferAction", "AtxferAction"),

	/**
	 * The '<em><b>Bridge Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #BRIDGE_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	BRIDGE_ACTION(6, "BridgeAction", "BridgeAction"),

	/**
	 * The '<em><b>Challenge Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHALLENGE_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	CHALLENGE_ACTION(7, "ChallengeAction", "ChallengeAction"),

	/**
	 * The '<em><b>Change Monitor Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CHANGE_MONITOR_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	CHANGE_MONITOR_ACTION(8, "ChangeMonitorAction", "ChangeMonitorAction"),

	/**
	 * The '<em><b>Command Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #COMMAND_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	COMMAND_ACTION(9, "CommandAction", "CommandAction"),

	/**
	 * The '<em><b>Core Settings Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CORE_SETTINGS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	CORE_SETTINGS_ACTION(10, "CoreSettingsAction", "CoreSettingsAction"),

	/**
	 * The '<em><b>Core Show Channels Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CORE_SHOW_CHANNELS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	CORE_SHOW_CHANNELS_ACTION(11, "CoreShowChannelsAction", "CoreShowChannelsAction"),

	/**
	 * The '<em><b>Core Status Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CORE_STATUS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	CORE_STATUS_ACTION(12, "CoreStatusAction", "CoreStatusAction"),

	/**
	 * The '<em><b>Db Del Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DB_DEL_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	DB_DEL_ACTION(13, "DbDelAction", "DbDelAction"),

	/**
	 * The '<em><b>Db Del Tree Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DB_DEL_TREE_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	DB_DEL_TREE_ACTION(14, "DbDelTreeAction", "DbDelTreeAction"),

	/**
	 * The '<em><b>Db Get Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DB_GET_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	DB_GET_ACTION(15, "DbGetAction", "DbGetAction"),

	/**
	 * The '<em><b>Db Put Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #DB_PUT_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	DB_PUT_ACTION(16, "DbPutAction", "DbPutAction"),

	/**
	 * The '<em><b>Events Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EVENTS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	EVENTS_ACTION(17, "EventsAction", "EventsAction"),

	/**
	 * The '<em><b>Extension State Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXTENSION_STATE_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	EXTENSION_STATE_ACTION(18, "ExtensionStateAction", "ExtensionStateAction"),

	/**
	 * The '<em><b>Get Config Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GET_CONFIG_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	GET_CONFIG_ACTION(19, "GetConfigAction", "GetConfigAction"),

	/**
	 * The '<em><b>Get Var Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #GET_VAR_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	GET_VAR_ACTION(20, "GetVarAction", "GetVarAction"),

	/**
	 * The '<em><b>Hangup Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #HANGUP_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	HANGUP_ACTION(21, "HangupAction", "HangupAction"),

	/**
	 * The '<em><b>Iax Peer List Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IAX_PEER_LIST_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	IAX_PEER_LIST_ACTION(22, "IaxPeerListAction", "IaxPeerListAction"),

	/**
	 * The '<em><b>Jabber Send Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #JABBER_SEND_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	JABBER_SEND_ACTION(23, "JabberSendAction", "JabberSendAction"),

	/**
	 * The '<em><b>List Commands Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LIST_COMMANDS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	LIST_COMMANDS_ACTION(24, "ListCommandsAction", "ListCommandsAction"),

	/**
	 * The '<em><b>Login Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOGIN_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	LOGIN_ACTION(25, "LoginAction", "LoginAction"),

	/**
	 * The '<em><b>Logoff Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #LOGOFF_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	LOGOFF_ACTION(26, "LogoffAction", "LogoffAction"),

	/**
	 * The '<em><b>Mailbox Count Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAILBOX_COUNT_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	MAILBOX_COUNT_ACTION(27, "MailboxCountAction", "MailboxCountAction"),

	/**
	 * The '<em><b>Mailbox Status Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MAILBOX_STATUS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	MAILBOX_STATUS_ACTION(28, "MailboxStatusAction", "MailboxStatusAction"),

	/**
	 * The '<em><b>Meet Me Mute Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEET_ME_MUTE_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	MEET_ME_MUTE_ACTION(29, "MeetMeMuteAction", "MeetMeMuteAction"),

	/**
	 * The '<em><b>Meet Me Unmute Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MEET_ME_UNMUTE_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	MEET_ME_UNMUTE_ACTION(30, "MeetMeUnmuteAction", "MeetMeUnmuteAction"),

	/**
	 * The '<em><b>Module Check Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODULE_CHECK_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	MODULE_CHECK_ACTION(31, "ModuleCheckAction", "ModuleCheckAction"),

	/**
	 * The '<em><b>Module Load Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MODULE_LOAD_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	MODULE_LOAD_ACTION(32, "ModuleLoadAction", "ModuleLoadAction"),

	/**
	 * The '<em><b>Monitor Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #MONITOR_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	MONITOR_ACTION(33, "MonitorAction", "MonitorAction"),

	/**
	 * The '<em><b>Originate Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ORIGINATE_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ORIGINATE_ACTION(34, "OriginateAction", "OriginateAction"),

	/**
	 * The '<em><b>Park Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARK_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	PARK_ACTION(35, "ParkAction", "ParkAction"),

	/**
	 * The '<em><b>Parked Calls Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PARKED_CALLS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	PARKED_CALLS_ACTION(36, "ParkedCallsAction", "ParkedCallsAction"),

	/**
	 * The '<em><b>Pause Monitor Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PAUSE_MONITOR_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	PAUSE_MONITOR_ACTION(37, "PauseMonitorAction", "PauseMonitorAction"),

	/**
	 * The '<em><b>Ping Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PING_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	PING_ACTION(38, "PingAction", "PingAction"),

	/**
	 * The '<em><b>Play Dtmf Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PLAY_DTMF_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	PLAY_DTMF_ACTION(39, "PlayDtmfAction", "PlayDtmfAction"),

	/**
	 * The '<em><b>Queue Add Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUEUE_ADD_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	QUEUE_ADD_ACTION(40, "QueueAddAction", "QueueAddAction"),

	/**
	 * The '<em><b>Queue Log Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUEUE_LOG_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	QUEUE_LOG_ACTION(41, "QueueLogAction", "QueueLogAction"),

	/**
	 * The '<em><b>Queue Pause Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUEUE_PAUSE_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	QUEUE_PAUSE_ACTION(42, "QueuePauseAction", "QueuePauseAction"),

	/**
	 * The '<em><b>Queue Penalty Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUEUE_PENALTY_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	QUEUE_PENALTY_ACTION(43, "QueuePenaltyAction", "QueuePenaltyAction"),

	/**
	 * The '<em><b>Queue Remove Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUEUE_REMOVE_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	QUEUE_REMOVE_ACTION(44, "QueueRemoveAction", "QueueRemoveAction"),

	/**
	 * The '<em><b>Queue Reset Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUEUE_RESET_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	QUEUE_RESET_ACTION(45, "QueueResetAction", "QueueResetAction"),

	/**
	 * The '<em><b>Queue Status Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUEUE_STATUS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	QUEUE_STATUS_ACTION(46, "QueueStatusAction", "QueueStatusAction"),

	/**
	 * The '<em><b>Queue Summary Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #QUEUE_SUMMARY_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	QUEUE_SUMMARY_ACTION(47, "QueueSummaryAction", "QueueSummaryAction"),

	/**
	 * The '<em><b>Redirect Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REDIRECT_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	REDIRECT_ACTION(48, "RedirectAction", "RedirectAction"),

	/**
	 * The '<em><b>Send Text Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SEND_TEXT_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SEND_TEXT_ACTION(49, "SendTextAction", "SendTextAction"),

	/**
	 * The '<em><b>Set Cdr User Field Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_CDR_USER_FIELD_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SET_CDR_USER_FIELD_ACTION(50, "SetCdrUserFieldAction", "SetCdrUserFieldAction"),

	/**
	 * The '<em><b>Set Var Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SET_VAR_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SET_VAR_ACTION(51, "SetVarAction", "SetVarAction"),

	/**
	 * The '<em><b>Show Dialplan Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SHOW_DIALPLAN_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SHOW_DIALPLAN_ACTION(52, "ShowDialplanAction", "ShowDialplanAction"),

	/**
	 * The '<em><b>Sip Notify Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIP_NOTIFY_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SIP_NOTIFY_ACTION(53, "SipNotifyAction", "SipNotifyAction"),

	/**
	 * The '<em><b>Sip Peers Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIP_PEERS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SIP_PEERS_ACTION(54, "SipPeersAction", "SipPeersAction"),

	/**
	 * The '<em><b>Sip Show Peer Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIP_SHOW_PEER_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SIP_SHOW_PEER_ACTION(55, "SipShowPeerAction", "SipShowPeerAction"),

	/**
	 * The '<em><b>Sip Show Registry Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SIP_SHOW_REGISTRY_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	SIP_SHOW_REGISTRY_ACTION(56, "SipShowRegistryAction", "SipShowRegistryAction"),

	/**
	 * The '<em><b>Status Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STATUS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	STATUS_ACTION(57, "StatusAction", "StatusAction"),

	/**
	 * The '<em><b>Stop Monitor Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #STOP_MONITOR_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	STOP_MONITOR_ACTION(58, "StopMonitorAction", "StopMonitorAction"),

	/**
	 * The '<em><b>Unpause Monitor Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNPAUSE_MONITOR_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	UNPAUSE_MONITOR_ACTION(59, "UnpauseMonitorAction", "UnpauseMonitorAction"),

	/**
	 * The '<em><b>Update Config Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UPDATE_CONFIG_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	UPDATE_CONFIG_ACTION(60, "UpdateConfigAction", "UpdateConfigAction"),

	/**
	 * The '<em><b>User Event Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #USER_EVENT_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	USER_EVENT_ACTION(61, "UserEventAction", "UserEventAction"),

	/**
	 * The '<em><b>Voicemail Users List Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VOICEMAIL_USERS_LIST_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	VOICEMAIL_USERS_LIST_ACTION(62, "VoicemailUsersListAction", "VoicemailUsersListAction"),

	/**
	 * The '<em><b>Zap Dial Offhook Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZAP_DIAL_OFFHOOK_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ZAP_DIAL_OFFHOOK_ACTION(63, "ZapDialOffhookAction", "ZapDialOffhookAction"),

	/**
	 * The '<em><b>Zap Dnd Off Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZAP_DND_OFF_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ZAP_DND_OFF_ACTION(64, "ZapDndOffAction", "ZapDndOffAction"),

	/**
	 * The '<em><b>Zap Dnd On Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZAP_DND_ON_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ZAP_DND_ON_ACTION(65, "ZapDndOnAction", "ZapDndOnAction"),

	/**
	 * The '<em><b>Zap Hangup Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZAP_HANGUP_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ZAP_HANGUP_ACTION(66, "ZapHangupAction", "ZapHangupAction"),

	/**
	 * The '<em><b>Zap Restart Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZAP_RESTART_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ZAP_RESTART_ACTION(67, "ZapRestartAction", "ZapRestartAction"),

	/**
	 * The '<em><b>Zap Show Channels Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZAP_SHOW_CHANNELS_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ZAP_SHOW_CHANNELS_ACTION(68, "ZapShowChannelsAction", "ZapShowChannelsAction"),

	/**
	 * The '<em><b>Zap Transfer Action</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ZAP_TRANSFER_ACTION_VALUE
	 * @generated
	 * @ordered
	 */
	ZAP_TRANSFER_ACTION(69, "ZapTransferAction", "ZapTransferAction");

	/**
	 * The '<em><b>Absolute Timeout Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Absolute Timeout Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ABSOLUTE_TIMEOUT_ACTION
	 * @model name="AbsoluteTimeoutAction"
	 * @generated
	 * @ordered
	 */
	public static final int ABSOLUTE_TIMEOUT_ACTION_VALUE = 0;

	/**
	 * The '<em><b>Agent Callback Login Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Agent Callback Login Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGENT_CALLBACK_LOGIN_ACTION
	 * @model name="AgentCallbackLoginAction"
	 * @generated
	 * @ordered
	 */
	public static final int AGENT_CALLBACK_LOGIN_ACTION_VALUE = 1;

	/**
	 * The '<em><b>Agent Logoff Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Agent Logoff Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGENT_LOGOFF_ACTION
	 * @model name="AgentLogoffAction"
	 * @generated
	 * @ordered
	 */
	public static final int AGENT_LOGOFF_ACTION_VALUE = 2;

	/**
	 * The '<em><b>Agents Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Agents Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGENTS_ACTION
	 * @model name="AgentsAction"
	 * @generated
	 * @ordered
	 */
	public static final int AGENTS_ACTION_VALUE = 3;

	/**
	 * The '<em><b>Agi Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Agi Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #AGI_ACTION
	 * @model name="AgiAction"
	 * @generated
	 * @ordered
	 */
	public static final int AGI_ACTION_VALUE = 4;

	/**
	 * The '<em><b>Atxfer Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Atxfer Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ATXFER_ACTION
	 * @model name="AtxferAction"
	 * @generated
	 * @ordered
	 */
	public static final int ATXFER_ACTION_VALUE = 5;

	/**
	 * The '<em><b>Bridge Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Bridge Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #BRIDGE_ACTION
	 * @model name="BridgeAction"
	 * @generated
	 * @ordered
	 */
	public static final int BRIDGE_ACTION_VALUE = 6;

	/**
	 * The '<em><b>Challenge Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Challenge Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHALLENGE_ACTION
	 * @model name="ChallengeAction"
	 * @generated
	 * @ordered
	 */
	public static final int CHALLENGE_ACTION_VALUE = 7;

	/**
	 * The '<em><b>Change Monitor Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Change Monitor Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CHANGE_MONITOR_ACTION
	 * @model name="ChangeMonitorAction"
	 * @generated
	 * @ordered
	 */
	public static final int CHANGE_MONITOR_ACTION_VALUE = 8;

	/**
	 * The '<em><b>Command Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Command Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #COMMAND_ACTION
	 * @model name="CommandAction"
	 * @generated
	 * @ordered
	 */
	public static final int COMMAND_ACTION_VALUE = 9;

	/**
	 * The '<em><b>Core Settings Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Core Settings Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CORE_SETTINGS_ACTION
	 * @model name="CoreSettingsAction"
	 * @generated
	 * @ordered
	 */
	public static final int CORE_SETTINGS_ACTION_VALUE = 10;

	/**
	 * The '<em><b>Core Show Channels Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Core Show Channels Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CORE_SHOW_CHANNELS_ACTION
	 * @model name="CoreShowChannelsAction"
	 * @generated
	 * @ordered
	 */
	public static final int CORE_SHOW_CHANNELS_ACTION_VALUE = 11;

	/**
	 * The '<em><b>Core Status Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Core Status Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #CORE_STATUS_ACTION
	 * @model name="CoreStatusAction"
	 * @generated
	 * @ordered
	 */
	public static final int CORE_STATUS_ACTION_VALUE = 12;

	/**
	 * The '<em><b>Db Del Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Db Del Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DB_DEL_ACTION
	 * @model name="DbDelAction"
	 * @generated
	 * @ordered
	 */
	public static final int DB_DEL_ACTION_VALUE = 13;

	/**
	 * The '<em><b>Db Del Tree Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Db Del Tree Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DB_DEL_TREE_ACTION
	 * @model name="DbDelTreeAction"
	 * @generated
	 * @ordered
	 */
	public static final int DB_DEL_TREE_ACTION_VALUE = 14;

	/**
	 * The '<em><b>Db Get Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Db Get Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DB_GET_ACTION
	 * @model name="DbGetAction"
	 * @generated
	 * @ordered
	 */
	public static final int DB_GET_ACTION_VALUE = 15;

	/**
	 * The '<em><b>Db Put Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Db Put Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #DB_PUT_ACTION
	 * @model name="DbPutAction"
	 * @generated
	 * @ordered
	 */
	public static final int DB_PUT_ACTION_VALUE = 16;

	/**
	 * The '<em><b>Events Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Events Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EVENTS_ACTION
	 * @model name="EventsAction"
	 * @generated
	 * @ordered
	 */
	public static final int EVENTS_ACTION_VALUE = 17;

	/**
	 * The '<em><b>Extension State Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Extension State Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #EXTENSION_STATE_ACTION
	 * @model name="ExtensionStateAction"
	 * @generated
	 * @ordered
	 */
	public static final int EXTENSION_STATE_ACTION_VALUE = 18;

	/**
	 * The '<em><b>Get Config Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Get Config Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GET_CONFIG_ACTION
	 * @model name="GetConfigAction"
	 * @generated
	 * @ordered
	 */
	public static final int GET_CONFIG_ACTION_VALUE = 19;

	/**
	 * The '<em><b>Get Var Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Get Var Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #GET_VAR_ACTION
	 * @model name="GetVarAction"
	 * @generated
	 * @ordered
	 */
	public static final int GET_VAR_ACTION_VALUE = 20;

	/**
	 * The '<em><b>Hangup Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Hangup Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #HANGUP_ACTION
	 * @model name="HangupAction"
	 * @generated
	 * @ordered
	 */
	public static final int HANGUP_ACTION_VALUE = 21;

	/**
	 * The '<em><b>Iax Peer List Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Iax Peer List Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #IAX_PEER_LIST_ACTION
	 * @model name="IaxPeerListAction"
	 * @generated
	 * @ordered
	 */
	public static final int IAX_PEER_LIST_ACTION_VALUE = 22;

	/**
	 * The '<em><b>Jabber Send Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Jabber Send Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #JABBER_SEND_ACTION
	 * @model name="JabberSendAction"
	 * @generated
	 * @ordered
	 */
	public static final int JABBER_SEND_ACTION_VALUE = 23;

	/**
	 * The '<em><b>List Commands Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>List Commands Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LIST_COMMANDS_ACTION
	 * @model name="ListCommandsAction"
	 * @generated
	 * @ordered
	 */
	public static final int LIST_COMMANDS_ACTION_VALUE = 24;

	/**
	 * The '<em><b>Login Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Login Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOGIN_ACTION
	 * @model name="LoginAction"
	 * @generated
	 * @ordered
	 */
	public static final int LOGIN_ACTION_VALUE = 25;

	/**
	 * The '<em><b>Logoff Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Logoff Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #LOGOFF_ACTION
	 * @model name="LogoffAction"
	 * @generated
	 * @ordered
	 */
	public static final int LOGOFF_ACTION_VALUE = 26;

	/**
	 * The '<em><b>Mailbox Count Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mailbox Count Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAILBOX_COUNT_ACTION
	 * @model name="MailboxCountAction"
	 * @generated
	 * @ordered
	 */
	public static final int MAILBOX_COUNT_ACTION_VALUE = 27;

	/**
	 * The '<em><b>Mailbox Status Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mailbox Status Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MAILBOX_STATUS_ACTION
	 * @model name="MailboxStatusAction"
	 * @generated
	 * @ordered
	 */
	public static final int MAILBOX_STATUS_ACTION_VALUE = 28;

	/**
	 * The '<em><b>Meet Me Mute Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Meet Me Mute Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEET_ME_MUTE_ACTION
	 * @model name="MeetMeMuteAction"
	 * @generated
	 * @ordered
	 */
	public static final int MEET_ME_MUTE_ACTION_VALUE = 29;

	/**
	 * The '<em><b>Meet Me Unmute Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Meet Me Unmute Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MEET_ME_UNMUTE_ACTION
	 * @model name="MeetMeUnmuteAction"
	 * @generated
	 * @ordered
	 */
	public static final int MEET_ME_UNMUTE_ACTION_VALUE = 30;

	/**
	 * The '<em><b>Module Check Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Module Check Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODULE_CHECK_ACTION
	 * @model name="ModuleCheckAction"
	 * @generated
	 * @ordered
	 */
	public static final int MODULE_CHECK_ACTION_VALUE = 31;

	/**
	 * The '<em><b>Module Load Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Module Load Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MODULE_LOAD_ACTION
	 * @model name="ModuleLoadAction"
	 * @generated
	 * @ordered
	 */
	public static final int MODULE_LOAD_ACTION_VALUE = 32;

	/**
	 * The '<em><b>Monitor Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Monitor Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #MONITOR_ACTION
	 * @model name="MonitorAction"
	 * @generated
	 * @ordered
	 */
	public static final int MONITOR_ACTION_VALUE = 33;

	/**
	 * The '<em><b>Originate Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Originate Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ORIGINATE_ACTION
	 * @model name="OriginateAction"
	 * @generated
	 * @ordered
	 */
	public static final int ORIGINATE_ACTION_VALUE = 34;

	/**
	 * The '<em><b>Park Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Park Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARK_ACTION
	 * @model name="ParkAction"
	 * @generated
	 * @ordered
	 */
	public static final int PARK_ACTION_VALUE = 35;

	/**
	 * The '<em><b>Parked Calls Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Parked Calls Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PARKED_CALLS_ACTION
	 * @model name="ParkedCallsAction"
	 * @generated
	 * @ordered
	 */
	public static final int PARKED_CALLS_ACTION_VALUE = 36;

	/**
	 * The '<em><b>Pause Monitor Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pause Monitor Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PAUSE_MONITOR_ACTION
	 * @model name="PauseMonitorAction"
	 * @generated
	 * @ordered
	 */
	public static final int PAUSE_MONITOR_ACTION_VALUE = 37;

	/**
	 * The '<em><b>Ping Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Ping Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PING_ACTION
	 * @model name="PingAction"
	 * @generated
	 * @ordered
	 */
	public static final int PING_ACTION_VALUE = 38;

	/**
	 * The '<em><b>Play Dtmf Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Play Dtmf Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #PLAY_DTMF_ACTION
	 * @model name="PlayDtmfAction"
	 * @generated
	 * @ordered
	 */
	public static final int PLAY_DTMF_ACTION_VALUE = 39;

	/**
	 * The '<em><b>Queue Add Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Queue Add Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUEUE_ADD_ACTION
	 * @model name="QueueAddAction"
	 * @generated
	 * @ordered
	 */
	public static final int QUEUE_ADD_ACTION_VALUE = 40;

	/**
	 * The '<em><b>Queue Log Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Queue Log Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUEUE_LOG_ACTION
	 * @model name="QueueLogAction"
	 * @generated
	 * @ordered
	 */
	public static final int QUEUE_LOG_ACTION_VALUE = 41;

	/**
	 * The '<em><b>Queue Pause Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Queue Pause Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUEUE_PAUSE_ACTION
	 * @model name="QueuePauseAction"
	 * @generated
	 * @ordered
	 */
	public static final int QUEUE_PAUSE_ACTION_VALUE = 42;

	/**
	 * The '<em><b>Queue Penalty Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Queue Penalty Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUEUE_PENALTY_ACTION
	 * @model name="QueuePenaltyAction"
	 * @generated
	 * @ordered
	 */
	public static final int QUEUE_PENALTY_ACTION_VALUE = 43;

	/**
	 * The '<em><b>Queue Remove Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Queue Remove Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUEUE_REMOVE_ACTION
	 * @model name="QueueRemoveAction"
	 * @generated
	 * @ordered
	 */
	public static final int QUEUE_REMOVE_ACTION_VALUE = 44;

	/**
	 * The '<em><b>Queue Reset Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Queue Reset Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUEUE_RESET_ACTION
	 * @model name="QueueResetAction"
	 * @generated
	 * @ordered
	 */
	public static final int QUEUE_RESET_ACTION_VALUE = 45;

	/**
	 * The '<em><b>Queue Status Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Queue Status Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUEUE_STATUS_ACTION
	 * @model name="QueueStatusAction"
	 * @generated
	 * @ordered
	 */
	public static final int QUEUE_STATUS_ACTION_VALUE = 46;

	/**
	 * The '<em><b>Queue Summary Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Queue Summary Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #QUEUE_SUMMARY_ACTION
	 * @model name="QueueSummaryAction"
	 * @generated
	 * @ordered
	 */
	public static final int QUEUE_SUMMARY_ACTION_VALUE = 47;

	/**
	 * The '<em><b>Redirect Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Redirect Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #REDIRECT_ACTION
	 * @model name="RedirectAction"
	 * @generated
	 * @ordered
	 */
	public static final int REDIRECT_ACTION_VALUE = 48;

	/**
	 * The '<em><b>Send Text Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Send Text Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SEND_TEXT_ACTION
	 * @model name="SendTextAction"
	 * @generated
	 * @ordered
	 */
	public static final int SEND_TEXT_ACTION_VALUE = 49;

	/**
	 * The '<em><b>Set Cdr User Field Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Set Cdr User Field Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SET_CDR_USER_FIELD_ACTION
	 * @model name="SetCdrUserFieldAction"
	 * @generated
	 * @ordered
	 */
	public static final int SET_CDR_USER_FIELD_ACTION_VALUE = 50;

	/**
	 * The '<em><b>Set Var Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Set Var Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SET_VAR_ACTION
	 * @model name="SetVarAction"
	 * @generated
	 * @ordered
	 */
	public static final int SET_VAR_ACTION_VALUE = 51;

	/**
	 * The '<em><b>Show Dialplan Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Show Dialplan Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SHOW_DIALPLAN_ACTION
	 * @model name="ShowDialplanAction"
	 * @generated
	 * @ordered
	 */
	public static final int SHOW_DIALPLAN_ACTION_VALUE = 52;

	/**
	 * The '<em><b>Sip Notify Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sip Notify Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIP_NOTIFY_ACTION
	 * @model name="SipNotifyAction"
	 * @generated
	 * @ordered
	 */
	public static final int SIP_NOTIFY_ACTION_VALUE = 53;

	/**
	 * The '<em><b>Sip Peers Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sip Peers Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIP_PEERS_ACTION
	 * @model name="SipPeersAction"
	 * @generated
	 * @ordered
	 */
	public static final int SIP_PEERS_ACTION_VALUE = 54;

	/**
	 * The '<em><b>Sip Show Peer Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sip Show Peer Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIP_SHOW_PEER_ACTION
	 * @model name="SipShowPeerAction"
	 * @generated
	 * @ordered
	 */
	public static final int SIP_SHOW_PEER_ACTION_VALUE = 55;

	/**
	 * The '<em><b>Sip Show Registry Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Sip Show Registry Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #SIP_SHOW_REGISTRY_ACTION
	 * @model name="SipShowRegistryAction"
	 * @generated
	 * @ordered
	 */
	public static final int SIP_SHOW_REGISTRY_ACTION_VALUE = 56;

	/**
	 * The '<em><b>Status Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Status Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STATUS_ACTION
	 * @model name="StatusAction"
	 * @generated
	 * @ordered
	 */
	public static final int STATUS_ACTION_VALUE = 57;

	/**
	 * The '<em><b>Stop Monitor Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Stop Monitor Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #STOP_MONITOR_ACTION
	 * @model name="StopMonitorAction"
	 * @generated
	 * @ordered
	 */
	public static final int STOP_MONITOR_ACTION_VALUE = 58;

	/**
	 * The '<em><b>Unpause Monitor Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Unpause Monitor Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UNPAUSE_MONITOR_ACTION
	 * @model name="UnpauseMonitorAction"
	 * @generated
	 * @ordered
	 */
	public static final int UNPAUSE_MONITOR_ACTION_VALUE = 59;

	/**
	 * The '<em><b>Update Config Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Update Config Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #UPDATE_CONFIG_ACTION
	 * @model name="UpdateConfigAction"
	 * @generated
	 * @ordered
	 */
	public static final int UPDATE_CONFIG_ACTION_VALUE = 60;

	/**
	 * The '<em><b>User Event Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>User Event Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #USER_EVENT_ACTION
	 * @model name="UserEventAction"
	 * @generated
	 * @ordered
	 */
	public static final int USER_EVENT_ACTION_VALUE = 61;

	/**
	 * The '<em><b>Voicemail Users List Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Voicemail Users List Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #VOICEMAIL_USERS_LIST_ACTION
	 * @model name="VoicemailUsersListAction"
	 * @generated
	 * @ordered
	 */
	public static final int VOICEMAIL_USERS_LIST_ACTION_VALUE = 62;

	/**
	 * The '<em><b>Zap Dial Offhook Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Zap Dial Offhook Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZAP_DIAL_OFFHOOK_ACTION
	 * @model name="ZapDialOffhookAction"
	 * @generated
	 * @ordered
	 */
	public static final int ZAP_DIAL_OFFHOOK_ACTION_VALUE = 63;

	/**
	 * The '<em><b>Zap Dnd Off Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Zap Dnd Off Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZAP_DND_OFF_ACTION
	 * @model name="ZapDndOffAction"
	 * @generated
	 * @ordered
	 */
	public static final int ZAP_DND_OFF_ACTION_VALUE = 64;

	/**
	 * The '<em><b>Zap Dnd On Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Zap Dnd On Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZAP_DND_ON_ACTION
	 * @model name="ZapDndOnAction"
	 * @generated
	 * @ordered
	 */
	public static final int ZAP_DND_ON_ACTION_VALUE = 65;

	/**
	 * The '<em><b>Zap Hangup Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Zap Hangup Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZAP_HANGUP_ACTION
	 * @model name="ZapHangupAction"
	 * @generated
	 * @ordered
	 */
	public static final int ZAP_HANGUP_ACTION_VALUE = 66;

	/**
	 * The '<em><b>Zap Restart Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Zap Restart Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZAP_RESTART_ACTION
	 * @model name="ZapRestartAction"
	 * @generated
	 * @ordered
	 */
	public static final int ZAP_RESTART_ACTION_VALUE = 67;

	/**
	 * The '<em><b>Zap Show Channels Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Zap Show Channels Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZAP_SHOW_CHANNELS_ACTION
	 * @model name="ZapShowChannelsAction"
	 * @generated
	 * @ordered
	 */
	public static final int ZAP_SHOW_CHANNELS_ACTION_VALUE = 68;

	/**
	 * The '<em><b>Zap Transfer Action</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Zap Transfer Action</b></em>' literal object isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @see #ZAP_TRANSFER_ACTION
	 * @model name="ZapTransferAction"
	 * @generated
	 * @ordered
	 */
	public static final int ZAP_TRANSFER_ACTION_VALUE = 69;

	/**
	 * An array of all the '<em><b>Manager Action Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final ManagerActionType[] VALUES_ARRAY =
		new ManagerActionType[] {
			ABSOLUTE_TIMEOUT_ACTION,
			AGENT_CALLBACK_LOGIN_ACTION,
			AGENT_LOGOFF_ACTION,
			AGENTS_ACTION,
			AGI_ACTION,
			ATXFER_ACTION,
			BRIDGE_ACTION,
			CHALLENGE_ACTION,
			CHANGE_MONITOR_ACTION,
			COMMAND_ACTION,
			CORE_SETTINGS_ACTION,
			CORE_SHOW_CHANNELS_ACTION,
			CORE_STATUS_ACTION,
			DB_DEL_ACTION,
			DB_DEL_TREE_ACTION,
			DB_GET_ACTION,
			DB_PUT_ACTION,
			EVENTS_ACTION,
			EXTENSION_STATE_ACTION,
			GET_CONFIG_ACTION,
			GET_VAR_ACTION,
			HANGUP_ACTION,
			IAX_PEER_LIST_ACTION,
			JABBER_SEND_ACTION,
			LIST_COMMANDS_ACTION,
			LOGIN_ACTION,
			LOGOFF_ACTION,
			MAILBOX_COUNT_ACTION,
			MAILBOX_STATUS_ACTION,
			MEET_ME_MUTE_ACTION,
			MEET_ME_UNMUTE_ACTION,
			MODULE_CHECK_ACTION,
			MODULE_LOAD_ACTION,
			MONITOR_ACTION,
			ORIGINATE_ACTION,
			PARK_ACTION,
			PARKED_CALLS_ACTION,
			PAUSE_MONITOR_ACTION,
			PING_ACTION,
			PLAY_DTMF_ACTION,
			QUEUE_ADD_ACTION,
			QUEUE_LOG_ACTION,
			QUEUE_PAUSE_ACTION,
			QUEUE_PENALTY_ACTION,
			QUEUE_REMOVE_ACTION,
			QUEUE_RESET_ACTION,
			QUEUE_STATUS_ACTION,
			QUEUE_SUMMARY_ACTION,
			REDIRECT_ACTION,
			SEND_TEXT_ACTION,
			SET_CDR_USER_FIELD_ACTION,
			SET_VAR_ACTION,
			SHOW_DIALPLAN_ACTION,
			SIP_NOTIFY_ACTION,
			SIP_PEERS_ACTION,
			SIP_SHOW_PEER_ACTION,
			SIP_SHOW_REGISTRY_ACTION,
			STATUS_ACTION,
			STOP_MONITOR_ACTION,
			UNPAUSE_MONITOR_ACTION,
			UPDATE_CONFIG_ACTION,
			USER_EVENT_ACTION,
			VOICEMAIL_USERS_LIST_ACTION,
			ZAP_DIAL_OFFHOOK_ACTION,
			ZAP_DND_OFF_ACTION,
			ZAP_DND_ON_ACTION,
			ZAP_HANGUP_ACTION,
			ZAP_RESTART_ACTION,
			ZAP_SHOW_CHANNELS_ACTION,
			ZAP_TRANSFER_ACTION,
		};

	/**
	 * A public read-only list of all the '<em><b>Manager Action Type</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<ManagerActionType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Manager Action Type</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ManagerActionType get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ManagerActionType result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Manager Action Type</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ManagerActionType getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			ManagerActionType result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Manager Action Type</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ManagerActionType get(int value) {
		switch (value) {
			case ABSOLUTE_TIMEOUT_ACTION_VALUE: return ABSOLUTE_TIMEOUT_ACTION;
			case AGENT_CALLBACK_LOGIN_ACTION_VALUE: return AGENT_CALLBACK_LOGIN_ACTION;
			case AGENT_LOGOFF_ACTION_VALUE: return AGENT_LOGOFF_ACTION;
			case AGENTS_ACTION_VALUE: return AGENTS_ACTION;
			case AGI_ACTION_VALUE: return AGI_ACTION;
			case ATXFER_ACTION_VALUE: return ATXFER_ACTION;
			case BRIDGE_ACTION_VALUE: return BRIDGE_ACTION;
			case CHALLENGE_ACTION_VALUE: return CHALLENGE_ACTION;
			case CHANGE_MONITOR_ACTION_VALUE: return CHANGE_MONITOR_ACTION;
			case COMMAND_ACTION_VALUE: return COMMAND_ACTION;
			case CORE_SETTINGS_ACTION_VALUE: return CORE_SETTINGS_ACTION;
			case CORE_SHOW_CHANNELS_ACTION_VALUE: return CORE_SHOW_CHANNELS_ACTION;
			case CORE_STATUS_ACTION_VALUE: return CORE_STATUS_ACTION;
			case DB_DEL_ACTION_VALUE: return DB_DEL_ACTION;
			case DB_DEL_TREE_ACTION_VALUE: return DB_DEL_TREE_ACTION;
			case DB_GET_ACTION_VALUE: return DB_GET_ACTION;
			case DB_PUT_ACTION_VALUE: return DB_PUT_ACTION;
			case EVENTS_ACTION_VALUE: return EVENTS_ACTION;
			case EXTENSION_STATE_ACTION_VALUE: return EXTENSION_STATE_ACTION;
			case GET_CONFIG_ACTION_VALUE: return GET_CONFIG_ACTION;
			case GET_VAR_ACTION_VALUE: return GET_VAR_ACTION;
			case HANGUP_ACTION_VALUE: return HANGUP_ACTION;
			case IAX_PEER_LIST_ACTION_VALUE: return IAX_PEER_LIST_ACTION;
			case JABBER_SEND_ACTION_VALUE: return JABBER_SEND_ACTION;
			case LIST_COMMANDS_ACTION_VALUE: return LIST_COMMANDS_ACTION;
			case LOGIN_ACTION_VALUE: return LOGIN_ACTION;
			case LOGOFF_ACTION_VALUE: return LOGOFF_ACTION;
			case MAILBOX_COUNT_ACTION_VALUE: return MAILBOX_COUNT_ACTION;
			case MAILBOX_STATUS_ACTION_VALUE: return MAILBOX_STATUS_ACTION;
			case MEET_ME_MUTE_ACTION_VALUE: return MEET_ME_MUTE_ACTION;
			case MEET_ME_UNMUTE_ACTION_VALUE: return MEET_ME_UNMUTE_ACTION;
			case MODULE_CHECK_ACTION_VALUE: return MODULE_CHECK_ACTION;
			case MODULE_LOAD_ACTION_VALUE: return MODULE_LOAD_ACTION;
			case MONITOR_ACTION_VALUE: return MONITOR_ACTION;
			case ORIGINATE_ACTION_VALUE: return ORIGINATE_ACTION;
			case PARK_ACTION_VALUE: return PARK_ACTION;
			case PARKED_CALLS_ACTION_VALUE: return PARKED_CALLS_ACTION;
			case PAUSE_MONITOR_ACTION_VALUE: return PAUSE_MONITOR_ACTION;
			case PING_ACTION_VALUE: return PING_ACTION;
			case PLAY_DTMF_ACTION_VALUE: return PLAY_DTMF_ACTION;
			case QUEUE_ADD_ACTION_VALUE: return QUEUE_ADD_ACTION;
			case QUEUE_LOG_ACTION_VALUE: return QUEUE_LOG_ACTION;
			case QUEUE_PAUSE_ACTION_VALUE: return QUEUE_PAUSE_ACTION;
			case QUEUE_PENALTY_ACTION_VALUE: return QUEUE_PENALTY_ACTION;
			case QUEUE_REMOVE_ACTION_VALUE: return QUEUE_REMOVE_ACTION;
			case QUEUE_RESET_ACTION_VALUE: return QUEUE_RESET_ACTION;
			case QUEUE_STATUS_ACTION_VALUE: return QUEUE_STATUS_ACTION;
			case QUEUE_SUMMARY_ACTION_VALUE: return QUEUE_SUMMARY_ACTION;
			case REDIRECT_ACTION_VALUE: return REDIRECT_ACTION;
			case SEND_TEXT_ACTION_VALUE: return SEND_TEXT_ACTION;
			case SET_CDR_USER_FIELD_ACTION_VALUE: return SET_CDR_USER_FIELD_ACTION;
			case SET_VAR_ACTION_VALUE: return SET_VAR_ACTION;
			case SHOW_DIALPLAN_ACTION_VALUE: return SHOW_DIALPLAN_ACTION;
			case SIP_NOTIFY_ACTION_VALUE: return SIP_NOTIFY_ACTION;
			case SIP_PEERS_ACTION_VALUE: return SIP_PEERS_ACTION;
			case SIP_SHOW_PEER_ACTION_VALUE: return SIP_SHOW_PEER_ACTION;
			case SIP_SHOW_REGISTRY_ACTION_VALUE: return SIP_SHOW_REGISTRY_ACTION;
			case STATUS_ACTION_VALUE: return STATUS_ACTION;
			case STOP_MONITOR_ACTION_VALUE: return STOP_MONITOR_ACTION;
			case UNPAUSE_MONITOR_ACTION_VALUE: return UNPAUSE_MONITOR_ACTION;
			case UPDATE_CONFIG_ACTION_VALUE: return UPDATE_CONFIG_ACTION;
			case USER_EVENT_ACTION_VALUE: return USER_EVENT_ACTION;
			case VOICEMAIL_USERS_LIST_ACTION_VALUE: return VOICEMAIL_USERS_LIST_ACTION;
			case ZAP_DIAL_OFFHOOK_ACTION_VALUE: return ZAP_DIAL_OFFHOOK_ACTION;
			case ZAP_DND_OFF_ACTION_VALUE: return ZAP_DND_OFF_ACTION;
			case ZAP_DND_ON_ACTION_VALUE: return ZAP_DND_ON_ACTION;
			case ZAP_HANGUP_ACTION_VALUE: return ZAP_HANGUP_ACTION;
			case ZAP_RESTART_ACTION_VALUE: return ZAP_RESTART_ACTION;
			case ZAP_SHOW_CHANNELS_ACTION_VALUE: return ZAP_SHOW_CHANNELS_ACTION;
			case ZAP_TRANSFER_ACTION_VALUE: return ZAP_TRANSFER_ACTION;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private ManagerActionType(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
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
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //ManagerActionType
