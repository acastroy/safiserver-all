/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.Dial;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.impl.ActionStepImpl;
import com.safi.core.call.CallConsumer1;
import com.safi.core.call.CallPackage;
import com.safi.core.call.SafiCall;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dial</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getOutgoingChannels <em>Outgoing Channels</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isRetry <em>Retry</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isCalleeBlindTransfer <em>Callee Blind Transfer</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isCallerBlindTransfer <em>Caller Blind Transfer</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isGenerateRingTone <em>Generate Ring Tone</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isRingCallee <em>Ring Callee</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isCalleeMusicOnHold <em>Callee Music On Hold</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isPrivate <em>Private</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isUseOldCallerID <em>Use Old Caller ID</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isJumpPriority <em>Jump Priority</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getMacro <em>Macro</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isCalleeStarHangup <em>Callee Star Hangup</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isCallerStarHangup <em>Caller Star Hangup</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isIgnoreForwardingRequests <em>Ignore Forwarding Requests</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isResetCDR <em>Reset CDR</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isEnableScreeningMode <em>Enable Screening Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isUsePrivacyManager <em>Use Privacy Manager</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getPrivaceManagerDB <em>Privace Manager DB</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isStayAlive <em>Stay Alive</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getAnnouncement <em>Announcement</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getAutoHangupTime <em>Auto Hangup Time</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isCaptureDTMF <em>Capture DTMF</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getDTMFDigits <em>DTMF Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getMaxDuration <em>Max Duration</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getCallEndingWarningTime <em>Call Ending Warning Time</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getWarningRepeatTime <em>Warning Repeat Time</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isLimitPlayAudioCaller <em>Limit Play Audio Caller</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isLimitPlayAudioCallee <em>Limit Play Audio Callee</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getLimitTimeoutFilename <em>Limit Timeout Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getLimitConnectFilename <em>Limit Connect Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#getLimitWarningFilename <em>Limit Warning Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isForceOutgoingCallID <em>Force Outgoing Call ID</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isCalleeCanRecord <em>Callee Can Record</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isCallerCanRecord <em>Caller Can Record</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isCalleeCanPark <em>Callee Can Park</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.DialImpl#isCallerCanPark <em>Caller Can Park</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DialImpl extends AsteriskActionStepImpl implements Dial {
  /**
	 * The cached value of the '{@link #getCall1() <em>Call1</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCall1()
	 * @generated
	 * @ordered
	 */
  protected SafiCall call1;

  /**
	 * The cached value of the '{@link #getOutgoingChannels() <em>Outgoing Channels</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOutgoingChannels()
	 * @generated
	 * @ordered
	 */
  protected DynamicValue outgoingChannels;

  /**
	 * The default value of the '{@link #isRetry() <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isRetry()
	 * @generated
	 * @ordered
	 */
  protected static final boolean RETRY_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isRetry() <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isRetry()
	 * @generated
	 * @ordered
	 */
  protected boolean retry = RETRY_EDEFAULT;

  /**
	 * The default value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
  protected static final int TIMEOUT_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getTimeout() <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getTimeout()
	 * @generated
	 * @ordered
	 */
  protected int timeout = TIMEOUT_EDEFAULT;

  /**
	 * The default value of the '{@link #isCalleeBlindTransfer() <em>Callee Blind Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCalleeBlindTransfer()
	 * @generated
	 * @ordered
	 */
  protected static final boolean CALLEE_BLIND_TRANSFER_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isCalleeBlindTransfer() <em>Callee Blind Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCalleeBlindTransfer()
	 * @generated
	 * @ordered
	 */
  protected boolean calleeBlindTransfer = CALLEE_BLIND_TRANSFER_EDEFAULT;

  /**
	 * The default value of the '{@link #isCallerBlindTransfer() <em>Caller Blind Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCallerBlindTransfer()
	 * @generated
	 * @ordered
	 */
  protected static final boolean CALLER_BLIND_TRANSFER_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isCallerBlindTransfer() <em>Caller Blind Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCallerBlindTransfer()
	 * @generated
	 * @ordered
	 */
  protected boolean callerBlindTransfer = CALLER_BLIND_TRANSFER_EDEFAULT;

  /**
	 * The default value of the '{@link #isGenerateRingTone() <em>Generate Ring Tone</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isGenerateRingTone()
	 * @generated
	 * @ordered
	 */
  protected static final boolean GENERATE_RING_TONE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isGenerateRingTone() <em>Generate Ring Tone</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isGenerateRingTone()
	 * @generated
	 * @ordered
	 */
  protected boolean generateRingTone = GENERATE_RING_TONE_EDEFAULT;

  /**
	 * The default value of the '{@link #isRingCallee() <em>Ring Callee</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isRingCallee()
	 * @generated
	 * @ordered
	 */
  protected static final boolean RING_CALLEE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isRingCallee() <em>Ring Callee</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isRingCallee()
	 * @generated
	 * @ordered
	 */
  protected boolean ringCallee = RING_CALLEE_EDEFAULT;

  /**
	 * The default value of the '{@link #isCalleeMusicOnHold() <em>Callee Music On Hold</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCalleeMusicOnHold()
	 * @generated
	 * @ordered
	 */
  protected static final boolean CALLEE_MUSIC_ON_HOLD_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isCalleeMusicOnHold() <em>Callee Music On Hold</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCalleeMusicOnHold()
	 * @generated
	 * @ordered
	 */
  protected boolean calleeMusicOnHold = CALLEE_MUSIC_ON_HOLD_EDEFAULT;

  /**
	 * The default value of the '{@link #isPrivate() <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isPrivate()
	 * @generated
	 * @ordered
	 */
  protected static final boolean PRIVATE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isPrivate() <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isPrivate()
	 * @generated
	 * @ordered
	 */
  protected boolean private_ = PRIVATE_EDEFAULT;

  /**
	 * The default value of the '{@link #isUseOldCallerID() <em>Use Old Caller ID</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isUseOldCallerID()
	 * @generated
	 * @ordered
	 */
  protected static final boolean USE_OLD_CALLER_ID_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isUseOldCallerID() <em>Use Old Caller ID</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isUseOldCallerID()
	 * @generated
	 * @ordered
	 */
  protected boolean useOldCallerID = USE_OLD_CALLER_ID_EDEFAULT;

  /**
	 * The default value of the '{@link #isJumpPriority() <em>Jump Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isJumpPriority()
	 * @generated
	 * @ordered
	 */
  protected static final boolean JUMP_PRIORITY_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isJumpPriority() <em>Jump Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isJumpPriority()
	 * @generated
	 * @ordered
	 */
  protected boolean jumpPriority = JUMP_PRIORITY_EDEFAULT;

  /**
	 * The default value of the '{@link #getMacro() <em>Macro</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMacro()
	 * @generated
	 * @ordered
	 */
  protected static final String MACRO_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getMacro() <em>Macro</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMacro()
	 * @generated
	 * @ordered
	 */
  protected String macro = MACRO_EDEFAULT;

  /**
	 * The default value of the '{@link #isCalleeStarHangup() <em>Callee Star Hangup</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCalleeStarHangup()
	 * @generated
	 * @ordered
	 */
  protected static final boolean CALLEE_STAR_HANGUP_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isCalleeStarHangup() <em>Callee Star Hangup</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCalleeStarHangup()
	 * @generated
	 * @ordered
	 */
  protected boolean calleeStarHangup = CALLEE_STAR_HANGUP_EDEFAULT;

  /**
	 * The default value of the '{@link #isCallerStarHangup() <em>Caller Star Hangup</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCallerStarHangup()
	 * @generated
	 * @ordered
	 */
  protected static final boolean CALLER_STAR_HANGUP_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isCallerStarHangup() <em>Caller Star Hangup</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCallerStarHangup()
	 * @generated
	 * @ordered
	 */
  protected boolean callerStarHangup = CALLER_STAR_HANGUP_EDEFAULT;

  /**
	 * The default value of the '{@link #isIgnoreForwardingRequests() <em>Ignore Forwarding Requests</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isIgnoreForwardingRequests()
	 * @generated
	 * @ordered
	 */
  protected static final boolean IGNORE_FORWARDING_REQUESTS_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isIgnoreForwardingRequests() <em>Ignore Forwarding Requests</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isIgnoreForwardingRequests()
	 * @generated
	 * @ordered
	 */
  protected boolean ignoreForwardingRequests = IGNORE_FORWARDING_REQUESTS_EDEFAULT;

  /**
	 * The default value of the '{@link #isResetCDR() <em>Reset CDR</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isResetCDR()
	 * @generated
	 * @ordered
	 */
  protected static final boolean RESET_CDR_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isResetCDR() <em>Reset CDR</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isResetCDR()
	 * @generated
	 * @ordered
	 */
  protected boolean resetCDR = RESET_CDR_EDEFAULT;

  /**
	 * The default value of the '{@link #isEnableScreeningMode() <em>Enable Screening Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isEnableScreeningMode()
	 * @generated
	 * @ordered
	 */
  protected static final boolean ENABLE_SCREENING_MODE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isEnableScreeningMode() <em>Enable Screening Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isEnableScreeningMode()
	 * @generated
	 * @ordered
	 */
  protected boolean enableScreeningMode = ENABLE_SCREENING_MODE_EDEFAULT;

  /**
	 * The default value of the '{@link #isUsePrivacyManager() <em>Use Privacy Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isUsePrivacyManager()
	 * @generated
	 * @ordered
	 */
  protected static final boolean USE_PRIVACY_MANAGER_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isUsePrivacyManager() <em>Use Privacy Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isUsePrivacyManager()
	 * @generated
	 * @ordered
	 */
  protected boolean usePrivacyManager = USE_PRIVACY_MANAGER_EDEFAULT;

  /**
	 * The default value of the '{@link #getPrivaceManagerDB() <em>Privace Manager DB</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPrivaceManagerDB()
	 * @generated
	 * @ordered
	 */
  protected static final String PRIVACE_MANAGER_DB_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getPrivaceManagerDB() <em>Privace Manager DB</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getPrivaceManagerDB()
	 * @generated
	 * @ordered
	 */
  protected String privaceManagerDB = PRIVACE_MANAGER_DB_EDEFAULT;

  /**
	 * The default value of the '{@link #isStayAlive() <em>Stay Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isStayAlive()
	 * @generated
	 * @ordered
	 */
  protected static final boolean STAY_ALIVE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isStayAlive() <em>Stay Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isStayAlive()
	 * @generated
	 * @ordered
	 */
  protected boolean stayAlive = STAY_ALIVE_EDEFAULT;

  /**
	 * The default value of the '{@link #getAnnouncement() <em>Announcement</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAnnouncement()
	 * @generated
	 * @ordered
	 */
  protected static final String ANNOUNCEMENT_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getAnnouncement() <em>Announcement</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAnnouncement()
	 * @generated
	 * @ordered
	 */
  protected String announcement = ANNOUNCEMENT_EDEFAULT;

  /**
	 * The default value of the '{@link #getAutoHangupTime() <em>Auto Hangup Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAutoHangupTime()
	 * @generated
	 * @ordered
	 */
  protected static final int AUTO_HANGUP_TIME_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getAutoHangupTime() <em>Auto Hangup Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAutoHangupTime()
	 * @generated
	 * @ordered
	 */
  protected int autoHangupTime = AUTO_HANGUP_TIME_EDEFAULT;

  /**
	 * The default value of the '{@link #isCaptureDTMF() <em>Capture DTMF</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCaptureDTMF()
	 * @generated
	 * @ordered
	 */
  protected static final boolean CAPTURE_DTMF_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isCaptureDTMF() <em>Capture DTMF</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCaptureDTMF()
	 * @generated
	 * @ordered
	 */
  protected boolean captureDTMF = CAPTURE_DTMF_EDEFAULT;

  /**
	 * The default value of the '{@link #getDTMFDigits() <em>DTMF Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDTMFDigits()
	 * @generated
	 * @ordered
	 */
  protected static final String DTMF_DIGITS_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getDTMFDigits() <em>DTMF Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getDTMFDigits()
	 * @generated
	 * @ordered
	 */
  protected String dTMFDigits = DTMF_DIGITS_EDEFAULT;

  /**
	 * The default value of the '{@link #getMaxDuration() <em>Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMaxDuration()
	 * @generated
	 * @ordered
	 */
  protected static final int MAX_DURATION_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getMaxDuration() <em>Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getMaxDuration()
	 * @generated
	 * @ordered
	 */
  protected int maxDuration = MAX_DURATION_EDEFAULT;

  /**
	 * The default value of the '{@link #getCallEndingWarningTime() <em>Call Ending Warning Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallEndingWarningTime()
	 * @generated
	 * @ordered
	 */
  protected static final int CALL_ENDING_WARNING_TIME_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getCallEndingWarningTime() <em>Call Ending Warning Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getCallEndingWarningTime()
	 * @generated
	 * @ordered
	 */
  protected int callEndingWarningTime = CALL_ENDING_WARNING_TIME_EDEFAULT;

  /**
	 * The default value of the '{@link #getWarningRepeatTime() <em>Warning Repeat Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWarningRepeatTime()
	 * @generated
	 * @ordered
	 */
  protected static final int WARNING_REPEAT_TIME_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getWarningRepeatTime() <em>Warning Repeat Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getWarningRepeatTime()
	 * @generated
	 * @ordered
	 */
  protected int warningRepeatTime = WARNING_REPEAT_TIME_EDEFAULT;

  /**
	 * The default value of the '{@link #isLimitPlayAudioCaller() <em>Limit Play Audio Caller</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isLimitPlayAudioCaller()
	 * @generated
	 * @ordered
	 */
  protected static final boolean LIMIT_PLAY_AUDIO_CALLER_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isLimitPlayAudioCaller() <em>Limit Play Audio Caller</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isLimitPlayAudioCaller()
	 * @generated
	 * @ordered
	 */
  protected boolean limitPlayAudioCaller = LIMIT_PLAY_AUDIO_CALLER_EDEFAULT;

  /**
	 * The default value of the '{@link #isLimitPlayAudioCallee() <em>Limit Play Audio Callee</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isLimitPlayAudioCallee()
	 * @generated
	 * @ordered
	 */
  protected static final boolean LIMIT_PLAY_AUDIO_CALLEE_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isLimitPlayAudioCallee() <em>Limit Play Audio Callee</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isLimitPlayAudioCallee()
	 * @generated
	 * @ordered
	 */
  protected boolean limitPlayAudioCallee = LIMIT_PLAY_AUDIO_CALLEE_EDEFAULT;

  /**
	 * The default value of the '{@link #getLimitTimeoutFilename() <em>Limit Timeout Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLimitTimeoutFilename()
	 * @generated
	 * @ordered
	 */
  protected static final String LIMIT_TIMEOUT_FILENAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getLimitTimeoutFilename() <em>Limit Timeout Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLimitTimeoutFilename()
	 * @generated
	 * @ordered
	 */
  protected String limitTimeoutFilename = LIMIT_TIMEOUT_FILENAME_EDEFAULT;

  /**
	 * The default value of the '{@link #getLimitConnectFilename() <em>Limit Connect Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLimitConnectFilename()
	 * @generated
	 * @ordered
	 */
  protected static final String LIMIT_CONNECT_FILENAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getLimitConnectFilename() <em>Limit Connect Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLimitConnectFilename()
	 * @generated
	 * @ordered
	 */
  protected String limitConnectFilename = LIMIT_CONNECT_FILENAME_EDEFAULT;

  /**
	 * The default value of the '{@link #getLimitWarningFilename() <em>Limit Warning Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLimitWarningFilename()
	 * @generated
	 * @ordered
	 */
  protected static final String LIMIT_WARNING_FILENAME_EDEFAULT = null;

  /**
	 * The cached value of the '{@link #getLimitWarningFilename() <em>Limit Warning Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getLimitWarningFilename()
	 * @generated
	 * @ordered
	 */
  protected String limitWarningFilename = LIMIT_WARNING_FILENAME_EDEFAULT;

  /**
	 * The default value of the '{@link #isForceOutgoingCallID() <em>Force Outgoing Call ID</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isForceOutgoingCallID()
	 * @generated
	 * @ordered
	 */
  protected static final boolean FORCE_OUTGOING_CALL_ID_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isForceOutgoingCallID() <em>Force Outgoing Call ID</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isForceOutgoingCallID()
	 * @generated
	 * @ordered
	 */
  protected boolean forceOutgoingCallID = FORCE_OUTGOING_CALL_ID_EDEFAULT;

  /**
	 * The default value of the '{@link #isCalleeCanRecord() <em>Callee Can Record</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCalleeCanRecord()
	 * @generated
	 * @ordered
	 */
  protected static final boolean CALLEE_CAN_RECORD_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isCalleeCanRecord() <em>Callee Can Record</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCalleeCanRecord()
	 * @generated
	 * @ordered
	 */
  protected boolean calleeCanRecord = CALLEE_CAN_RECORD_EDEFAULT;

  /**
	 * The default value of the '{@link #isCallerCanRecord() <em>Caller Can Record</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCallerCanRecord()
	 * @generated
	 * @ordered
	 */
  protected static final boolean CALLER_CAN_RECORD_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isCallerCanRecord() <em>Caller Can Record</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCallerCanRecord()
	 * @generated
	 * @ordered
	 */
  protected boolean callerCanRecord = CALLER_CAN_RECORD_EDEFAULT;

  /**
	 * The default value of the '{@link #isCalleeCanPark() <em>Callee Can Park</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCalleeCanPark()
	 * @generated
	 * @ordered
	 */
  protected static final boolean CALLEE_CAN_PARK_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isCalleeCanPark() <em>Callee Can Park</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCalleeCanPark()
	 * @generated
	 * @ordered
	 */
  protected boolean calleeCanPark = CALLEE_CAN_PARK_EDEFAULT;

  /**
	 * The default value of the '{@link #isCallerCanPark() <em>Caller Can Park</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCallerCanPark()
	 * @generated
	 * @ordered
	 */
  protected static final boolean CALLER_CAN_PARK_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isCallerCanPark() <em>Caller Can Park</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isCallerCanPark()
	 * @generated
	 * @ordered
	 */
  protected boolean callerCanPark = CALLER_CAN_PARK_EDEFAULT;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected DialImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass() {
		return ActionstepPackage.Literals.DIAL;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafiCall getCall1() {
		if (call1 != null && call1.eIsProxy()) {
			InternalEObject oldCall1 = (InternalEObject)call1;
			call1 = (SafiCall)eResolveProxy(oldCall1);
			if (call1 != oldCall1) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.DIAL__CALL1, oldCall1, call1));
			}
		}
		return call1;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SafiCall basicGetCall1() {
		return call1;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCall1(SafiCall newCall1) {
		SafiCall oldCall1 = call1;
		call1 = newCall1;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CALL1, oldCall1, call1));
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public DynamicValue getOutgoingChannels() {
		return outgoingChannels;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetOutgoingChannels(DynamicValue newOutgoingChannels, NotificationChain msgs) {
		DynamicValue oldOutgoingChannels = outgoingChannels;
		outgoingChannels = newOutgoingChannels;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__OUTGOING_CHANNELS, oldOutgoingChannels, newOutgoingChannels);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setOutgoingChannels(DynamicValue newOutgoingChannels) {
		if (newOutgoingChannels != outgoingChannels) {
			NotificationChain msgs = null;
			if (outgoingChannels != null)
				msgs = ((InternalEObject)outgoingChannels).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.DIAL__OUTGOING_CHANNELS, null, msgs);
			if (newOutgoingChannels != null)
				msgs = ((InternalEObject)newOutgoingChannels).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.DIAL__OUTGOING_CHANNELS, null, msgs);
			msgs = basicSetOutgoingChannels(newOutgoingChannels, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__OUTGOING_CHANNELS, newOutgoingChannels, newOutgoingChannels));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isRetry() {
		return retry;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRetry(boolean newRetry) {
		boolean oldRetry = retry;
		retry = newRetry;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__RETRY, oldRetry, retry));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getTimeout() {
		return timeout;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setTimeout(int newTimeout) {
		int oldTimeout = timeout;
		timeout = newTimeout;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__TIMEOUT, oldTimeout, timeout));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isCalleeBlindTransfer() {
		return calleeBlindTransfer;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCalleeBlindTransfer(boolean newCalleeBlindTransfer) {
		boolean oldCalleeBlindTransfer = calleeBlindTransfer;
		calleeBlindTransfer = newCalleeBlindTransfer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CALLEE_BLIND_TRANSFER, oldCalleeBlindTransfer, calleeBlindTransfer));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isCallerBlindTransfer() {
		return callerBlindTransfer;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCallerBlindTransfer(boolean newCallerBlindTransfer) {
		boolean oldCallerBlindTransfer = callerBlindTransfer;
		callerBlindTransfer = newCallerBlindTransfer;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CALLER_BLIND_TRANSFER, oldCallerBlindTransfer, callerBlindTransfer));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isGenerateRingTone() {
		return generateRingTone;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setGenerateRingTone(boolean newGenerateRingTone) {
		boolean oldGenerateRingTone = generateRingTone;
		generateRingTone = newGenerateRingTone;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__GENERATE_RING_TONE, oldGenerateRingTone, generateRingTone));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isRingCallee() {
		return ringCallee;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRingCallee(boolean newRingCallee) {
		boolean oldRingCallee = ringCallee;
		ringCallee = newRingCallee;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__RING_CALLEE, oldRingCallee, ringCallee));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isCalleeMusicOnHold() {
		return calleeMusicOnHold;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCalleeMusicOnHold(boolean newCalleeMusicOnHold) {
		boolean oldCalleeMusicOnHold = calleeMusicOnHold;
		calleeMusicOnHold = newCalleeMusicOnHold;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CALLEE_MUSIC_ON_HOLD, oldCalleeMusicOnHold, calleeMusicOnHold));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isPrivate() {
		return private_;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPrivate(boolean newPrivate) {
		boolean oldPrivate = private_;
		private_ = newPrivate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__PRIVATE, oldPrivate, private_));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isUseOldCallerID() {
		return useOldCallerID;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setUseOldCallerID(boolean newUseOldCallerID) {
		boolean oldUseOldCallerID = useOldCallerID;
		useOldCallerID = newUseOldCallerID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__USE_OLD_CALLER_ID, oldUseOldCallerID, useOldCallerID));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isJumpPriority() {
		return jumpPriority;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setJumpPriority(boolean newJumpPriority) {
		boolean oldJumpPriority = jumpPriority;
		jumpPriority = newJumpPriority;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__JUMP_PRIORITY, oldJumpPriority, jumpPriority));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getMacro() {
		return macro;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMacro(String newMacro) {
		String oldMacro = macro;
		macro = newMacro;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__MACRO, oldMacro, macro));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isCalleeStarHangup() {
		return calleeStarHangup;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCalleeStarHangup(boolean newCalleeStarHangup) {
		boolean oldCalleeStarHangup = calleeStarHangup;
		calleeStarHangup = newCalleeStarHangup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CALLEE_STAR_HANGUP, oldCalleeStarHangup, calleeStarHangup));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isCallerStarHangup() {
		return callerStarHangup;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCallerStarHangup(boolean newCallerStarHangup) {
		boolean oldCallerStarHangup = callerStarHangup;
		callerStarHangup = newCallerStarHangup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CALLER_STAR_HANGUP, oldCallerStarHangup, callerStarHangup));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isIgnoreForwardingRequests() {
		return ignoreForwardingRequests;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setIgnoreForwardingRequests(boolean newIgnoreForwardingRequests) {
		boolean oldIgnoreForwardingRequests = ignoreForwardingRequests;
		ignoreForwardingRequests = newIgnoreForwardingRequests;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__IGNORE_FORWARDING_REQUESTS, oldIgnoreForwardingRequests, ignoreForwardingRequests));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isResetCDR() {
		return resetCDR;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setResetCDR(boolean newResetCDR) {
		boolean oldResetCDR = resetCDR;
		resetCDR = newResetCDR;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__RESET_CDR, oldResetCDR, resetCDR));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isEnableScreeningMode() {
		return enableScreeningMode;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setEnableScreeningMode(boolean newEnableScreeningMode) {
		boolean oldEnableScreeningMode = enableScreeningMode;
		enableScreeningMode = newEnableScreeningMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__ENABLE_SCREENING_MODE, oldEnableScreeningMode, enableScreeningMode));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isUsePrivacyManager() {
		return usePrivacyManager;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setUsePrivacyManager(boolean newUsePrivacyManager) {
		boolean oldUsePrivacyManager = usePrivacyManager;
		usePrivacyManager = newUsePrivacyManager;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__USE_PRIVACY_MANAGER, oldUsePrivacyManager, usePrivacyManager));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getPrivaceManagerDB() {
		return privaceManagerDB;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setPrivaceManagerDB(String newPrivaceManagerDB) {
		String oldPrivaceManagerDB = privaceManagerDB;
		privaceManagerDB = newPrivaceManagerDB;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__PRIVACE_MANAGER_DB, oldPrivaceManagerDB, privaceManagerDB));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isStayAlive() {
		return stayAlive;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setStayAlive(boolean newStayAlive) {
		boolean oldStayAlive = stayAlive;
		stayAlive = newStayAlive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__STAY_ALIVE, oldStayAlive, stayAlive));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getAnnouncement() {
		return announcement;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAnnouncement(String newAnnouncement) {
		String oldAnnouncement = announcement;
		announcement = newAnnouncement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__ANNOUNCEMENT, oldAnnouncement, announcement));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getAutoHangupTime() {
		return autoHangupTime;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setAutoHangupTime(int newAutoHangupTime) {
		int oldAutoHangupTime = autoHangupTime;
		autoHangupTime = newAutoHangupTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__AUTO_HANGUP_TIME, oldAutoHangupTime, autoHangupTime));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isCaptureDTMF() {
		return captureDTMF;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCaptureDTMF(boolean newCaptureDTMF) {
		boolean oldCaptureDTMF = captureDTMF;
		captureDTMF = newCaptureDTMF;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CAPTURE_DTMF, oldCaptureDTMF, captureDTMF));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getDTMFDigits() {
		return dTMFDigits;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setDTMFDigits(String newDTMFDigits) {
		String oldDTMFDigits = dTMFDigits;
		dTMFDigits = newDTMFDigits;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__DTMF_DIGITS, oldDTMFDigits, dTMFDigits));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getMaxDuration() {
		return maxDuration;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setMaxDuration(int newMaxDuration) {
		int oldMaxDuration = maxDuration;
		maxDuration = newMaxDuration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__MAX_DURATION, oldMaxDuration, maxDuration));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getCallEndingWarningTime() {
		return callEndingWarningTime;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCallEndingWarningTime(int newCallEndingWarningTime) {
		int oldCallEndingWarningTime = callEndingWarningTime;
		callEndingWarningTime = newCallEndingWarningTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CALL_ENDING_WARNING_TIME, oldCallEndingWarningTime, callEndingWarningTime));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getWarningRepeatTime() {
		return warningRepeatTime;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setWarningRepeatTime(int newWarningRepeatTime) {
		int oldWarningRepeatTime = warningRepeatTime;
		warningRepeatTime = newWarningRepeatTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__WARNING_REPEAT_TIME, oldWarningRepeatTime, warningRepeatTime));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isLimitPlayAudioCaller() {
		return limitPlayAudioCaller;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLimitPlayAudioCaller(boolean newLimitPlayAudioCaller) {
		boolean oldLimitPlayAudioCaller = limitPlayAudioCaller;
		limitPlayAudioCaller = newLimitPlayAudioCaller;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__LIMIT_PLAY_AUDIO_CALLER, oldLimitPlayAudioCaller, limitPlayAudioCaller));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isLimitPlayAudioCallee() {
		return limitPlayAudioCallee;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLimitPlayAudioCallee(boolean newLimitPlayAudioCallee) {
		boolean oldLimitPlayAudioCallee = limitPlayAudioCallee;
		limitPlayAudioCallee = newLimitPlayAudioCallee;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__LIMIT_PLAY_AUDIO_CALLEE, oldLimitPlayAudioCallee, limitPlayAudioCallee));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getLimitTimeoutFilename() {
		return limitTimeoutFilename;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLimitTimeoutFilename(String newLimitTimeoutFilename) {
		String oldLimitTimeoutFilename = limitTimeoutFilename;
		limitTimeoutFilename = newLimitTimeoutFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__LIMIT_TIMEOUT_FILENAME, oldLimitTimeoutFilename, limitTimeoutFilename));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getLimitConnectFilename() {
		return limitConnectFilename;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLimitConnectFilename(String newLimitConnectFilename) {
		String oldLimitConnectFilename = limitConnectFilename;
		limitConnectFilename = newLimitConnectFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__LIMIT_CONNECT_FILENAME, oldLimitConnectFilename, limitConnectFilename));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String getLimitWarningFilename() {
		return limitWarningFilename;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setLimitWarningFilename(String newLimitWarningFilename) {
		String oldLimitWarningFilename = limitWarningFilename;
		limitWarningFilename = newLimitWarningFilename;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__LIMIT_WARNING_FILENAME, oldLimitWarningFilename, limitWarningFilename));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isForceOutgoingCallID() {
		return forceOutgoingCallID;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setForceOutgoingCallID(boolean newForceOutgoingCallID) {
		boolean oldForceOutgoingCallID = forceOutgoingCallID;
		forceOutgoingCallID = newForceOutgoingCallID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__FORCE_OUTGOING_CALL_ID, oldForceOutgoingCallID, forceOutgoingCallID));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isCalleeCanRecord() {
		return calleeCanRecord;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCalleeCanRecord(boolean newCalleeCanRecord) {
		boolean oldCalleeCanRecord = calleeCanRecord;
		calleeCanRecord = newCalleeCanRecord;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CALLEE_CAN_RECORD, oldCalleeCanRecord, calleeCanRecord));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isCallerCanRecord() {
		return callerCanRecord;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCallerCanRecord(boolean newCallerCanRecord) {
		boolean oldCallerCanRecord = callerCanRecord;
		callerCanRecord = newCallerCanRecord;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CALLER_CAN_RECORD, oldCallerCanRecord, callerCanRecord));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isCalleeCanPark() {
		return calleeCanPark;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCalleeCanPark(boolean newCalleeCanPark) {
		boolean oldCalleeCanPark = calleeCanPark;
		calleeCanPark = newCalleeCanPark;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CALLEE_CAN_PARK, oldCalleeCanPark, calleeCanPark));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public boolean isCallerCanPark() {
		return callerCanPark;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setCallerCanPark(boolean newCallerCanPark) {
		boolean oldCallerCanPark = callerCanPark;
		callerCanPark = newCallerCanPark;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.DIAL__CALLER_CAN_PARK, oldCallerCanPark, callerCanPark));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ActionstepPackage.DIAL__OUTGOING_CHANNELS:
				return basicSetOutgoingChannels(null, msgs);
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
			case ActionstepPackage.DIAL__CALL1:
				if (resolve) return getCall1();
				return basicGetCall1();
			case ActionstepPackage.DIAL__OUTGOING_CHANNELS:
				return getOutgoingChannels();
			case ActionstepPackage.DIAL__RETRY:
				return isRetry();
			case ActionstepPackage.DIAL__TIMEOUT:
				return getTimeout();
			case ActionstepPackage.DIAL__CALLEE_BLIND_TRANSFER:
				return isCalleeBlindTransfer();
			case ActionstepPackage.DIAL__CALLER_BLIND_TRANSFER:
				return isCallerBlindTransfer();
			case ActionstepPackage.DIAL__GENERATE_RING_TONE:
				return isGenerateRingTone();
			case ActionstepPackage.DIAL__RING_CALLEE:
				return isRingCallee();
			case ActionstepPackage.DIAL__CALLEE_MUSIC_ON_HOLD:
				return isCalleeMusicOnHold();
			case ActionstepPackage.DIAL__PRIVATE:
				return isPrivate();
			case ActionstepPackage.DIAL__USE_OLD_CALLER_ID:
				return isUseOldCallerID();
			case ActionstepPackage.DIAL__JUMP_PRIORITY:
				return isJumpPriority();
			case ActionstepPackage.DIAL__MACRO:
				return getMacro();
			case ActionstepPackage.DIAL__CALLEE_STAR_HANGUP:
				return isCalleeStarHangup();
			case ActionstepPackage.DIAL__CALLER_STAR_HANGUP:
				return isCallerStarHangup();
			case ActionstepPackage.DIAL__IGNORE_FORWARDING_REQUESTS:
				return isIgnoreForwardingRequests();
			case ActionstepPackage.DIAL__RESET_CDR:
				return isResetCDR();
			case ActionstepPackage.DIAL__ENABLE_SCREENING_MODE:
				return isEnableScreeningMode();
			case ActionstepPackage.DIAL__USE_PRIVACY_MANAGER:
				return isUsePrivacyManager();
			case ActionstepPackage.DIAL__PRIVACE_MANAGER_DB:
				return getPrivaceManagerDB();
			case ActionstepPackage.DIAL__STAY_ALIVE:
				return isStayAlive();
			case ActionstepPackage.DIAL__ANNOUNCEMENT:
				return getAnnouncement();
			case ActionstepPackage.DIAL__AUTO_HANGUP_TIME:
				return getAutoHangupTime();
			case ActionstepPackage.DIAL__CAPTURE_DTMF:
				return isCaptureDTMF();
			case ActionstepPackage.DIAL__DTMF_DIGITS:
				return getDTMFDigits();
			case ActionstepPackage.DIAL__MAX_DURATION:
				return getMaxDuration();
			case ActionstepPackage.DIAL__CALL_ENDING_WARNING_TIME:
				return getCallEndingWarningTime();
			case ActionstepPackage.DIAL__WARNING_REPEAT_TIME:
				return getWarningRepeatTime();
			case ActionstepPackage.DIAL__LIMIT_PLAY_AUDIO_CALLER:
				return isLimitPlayAudioCaller();
			case ActionstepPackage.DIAL__LIMIT_PLAY_AUDIO_CALLEE:
				return isLimitPlayAudioCallee();
			case ActionstepPackage.DIAL__LIMIT_TIMEOUT_FILENAME:
				return getLimitTimeoutFilename();
			case ActionstepPackage.DIAL__LIMIT_CONNECT_FILENAME:
				return getLimitConnectFilename();
			case ActionstepPackage.DIAL__LIMIT_WARNING_FILENAME:
				return getLimitWarningFilename();
			case ActionstepPackage.DIAL__FORCE_OUTGOING_CALL_ID:
				return isForceOutgoingCallID();
			case ActionstepPackage.DIAL__CALLEE_CAN_RECORD:
				return isCalleeCanRecord();
			case ActionstepPackage.DIAL__CALLER_CAN_RECORD:
				return isCallerCanRecord();
			case ActionstepPackage.DIAL__CALLEE_CAN_PARK:
				return isCalleeCanPark();
			case ActionstepPackage.DIAL__CALLER_CAN_PARK:
				return isCallerCanPark();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ActionstepPackage.DIAL__CALL1:
				setCall1((SafiCall)newValue);
				return;
			case ActionstepPackage.DIAL__OUTGOING_CHANNELS:
				setOutgoingChannels((DynamicValue)newValue);
				return;
			case ActionstepPackage.DIAL__RETRY:
				setRetry((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__TIMEOUT:
				setTimeout((Integer)newValue);
				return;
			case ActionstepPackage.DIAL__CALLEE_BLIND_TRANSFER:
				setCalleeBlindTransfer((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__CALLER_BLIND_TRANSFER:
				setCallerBlindTransfer((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__GENERATE_RING_TONE:
				setGenerateRingTone((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__RING_CALLEE:
				setRingCallee((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__CALLEE_MUSIC_ON_HOLD:
				setCalleeMusicOnHold((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__PRIVATE:
				setPrivate((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__USE_OLD_CALLER_ID:
				setUseOldCallerID((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__JUMP_PRIORITY:
				setJumpPriority((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__MACRO:
				setMacro((String)newValue);
				return;
			case ActionstepPackage.DIAL__CALLEE_STAR_HANGUP:
				setCalleeStarHangup((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__CALLER_STAR_HANGUP:
				setCallerStarHangup((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__IGNORE_FORWARDING_REQUESTS:
				setIgnoreForwardingRequests((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__RESET_CDR:
				setResetCDR((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__ENABLE_SCREENING_MODE:
				setEnableScreeningMode((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__USE_PRIVACY_MANAGER:
				setUsePrivacyManager((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__PRIVACE_MANAGER_DB:
				setPrivaceManagerDB((String)newValue);
				return;
			case ActionstepPackage.DIAL__STAY_ALIVE:
				setStayAlive((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__ANNOUNCEMENT:
				setAnnouncement((String)newValue);
				return;
			case ActionstepPackage.DIAL__AUTO_HANGUP_TIME:
				setAutoHangupTime((Integer)newValue);
				return;
			case ActionstepPackage.DIAL__CAPTURE_DTMF:
				setCaptureDTMF((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__DTMF_DIGITS:
				setDTMFDigits((String)newValue);
				return;
			case ActionstepPackage.DIAL__MAX_DURATION:
				setMaxDuration((Integer)newValue);
				return;
			case ActionstepPackage.DIAL__CALL_ENDING_WARNING_TIME:
				setCallEndingWarningTime((Integer)newValue);
				return;
			case ActionstepPackage.DIAL__WARNING_REPEAT_TIME:
				setWarningRepeatTime((Integer)newValue);
				return;
			case ActionstepPackage.DIAL__LIMIT_PLAY_AUDIO_CALLER:
				setLimitPlayAudioCaller((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__LIMIT_PLAY_AUDIO_CALLEE:
				setLimitPlayAudioCallee((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__LIMIT_TIMEOUT_FILENAME:
				setLimitTimeoutFilename((String)newValue);
				return;
			case ActionstepPackage.DIAL__LIMIT_CONNECT_FILENAME:
				setLimitConnectFilename((String)newValue);
				return;
			case ActionstepPackage.DIAL__LIMIT_WARNING_FILENAME:
				setLimitWarningFilename((String)newValue);
				return;
			case ActionstepPackage.DIAL__FORCE_OUTGOING_CALL_ID:
				setForceOutgoingCallID((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__CALLEE_CAN_RECORD:
				setCalleeCanRecord((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__CALLER_CAN_RECORD:
				setCallerCanRecord((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__CALLEE_CAN_PARK:
				setCalleeCanPark((Boolean)newValue);
				return;
			case ActionstepPackage.DIAL__CALLER_CAN_PARK:
				setCallerCanPark((Boolean)newValue);
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
			case ActionstepPackage.DIAL__CALL1:
				setCall1((SafiCall)null);
				return;
			case ActionstepPackage.DIAL__OUTGOING_CHANNELS:
				setOutgoingChannels((DynamicValue)null);
				return;
			case ActionstepPackage.DIAL__RETRY:
				setRetry(RETRY_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__TIMEOUT:
				setTimeout(TIMEOUT_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__CALLEE_BLIND_TRANSFER:
				setCalleeBlindTransfer(CALLEE_BLIND_TRANSFER_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__CALLER_BLIND_TRANSFER:
				setCallerBlindTransfer(CALLER_BLIND_TRANSFER_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__GENERATE_RING_TONE:
				setGenerateRingTone(GENERATE_RING_TONE_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__RING_CALLEE:
				setRingCallee(RING_CALLEE_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__CALLEE_MUSIC_ON_HOLD:
				setCalleeMusicOnHold(CALLEE_MUSIC_ON_HOLD_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__PRIVATE:
				setPrivate(PRIVATE_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__USE_OLD_CALLER_ID:
				setUseOldCallerID(USE_OLD_CALLER_ID_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__JUMP_PRIORITY:
				setJumpPriority(JUMP_PRIORITY_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__MACRO:
				setMacro(MACRO_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__CALLEE_STAR_HANGUP:
				setCalleeStarHangup(CALLEE_STAR_HANGUP_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__CALLER_STAR_HANGUP:
				setCallerStarHangup(CALLER_STAR_HANGUP_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__IGNORE_FORWARDING_REQUESTS:
				setIgnoreForwardingRequests(IGNORE_FORWARDING_REQUESTS_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__RESET_CDR:
				setResetCDR(RESET_CDR_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__ENABLE_SCREENING_MODE:
				setEnableScreeningMode(ENABLE_SCREENING_MODE_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__USE_PRIVACY_MANAGER:
				setUsePrivacyManager(USE_PRIVACY_MANAGER_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__PRIVACE_MANAGER_DB:
				setPrivaceManagerDB(PRIVACE_MANAGER_DB_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__STAY_ALIVE:
				setStayAlive(STAY_ALIVE_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__ANNOUNCEMENT:
				setAnnouncement(ANNOUNCEMENT_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__AUTO_HANGUP_TIME:
				setAutoHangupTime(AUTO_HANGUP_TIME_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__CAPTURE_DTMF:
				setCaptureDTMF(CAPTURE_DTMF_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__DTMF_DIGITS:
				setDTMFDigits(DTMF_DIGITS_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__MAX_DURATION:
				setMaxDuration(MAX_DURATION_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__CALL_ENDING_WARNING_TIME:
				setCallEndingWarningTime(CALL_ENDING_WARNING_TIME_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__WARNING_REPEAT_TIME:
				setWarningRepeatTime(WARNING_REPEAT_TIME_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__LIMIT_PLAY_AUDIO_CALLER:
				setLimitPlayAudioCaller(LIMIT_PLAY_AUDIO_CALLER_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__LIMIT_PLAY_AUDIO_CALLEE:
				setLimitPlayAudioCallee(LIMIT_PLAY_AUDIO_CALLEE_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__LIMIT_TIMEOUT_FILENAME:
				setLimitTimeoutFilename(LIMIT_TIMEOUT_FILENAME_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__LIMIT_CONNECT_FILENAME:
				setLimitConnectFilename(LIMIT_CONNECT_FILENAME_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__LIMIT_WARNING_FILENAME:
				setLimitWarningFilename(LIMIT_WARNING_FILENAME_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__FORCE_OUTGOING_CALL_ID:
				setForceOutgoingCallID(FORCE_OUTGOING_CALL_ID_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__CALLEE_CAN_RECORD:
				setCalleeCanRecord(CALLEE_CAN_RECORD_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__CALLER_CAN_RECORD:
				setCallerCanRecord(CALLER_CAN_RECORD_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__CALLEE_CAN_PARK:
				setCalleeCanPark(CALLEE_CAN_PARK_EDEFAULT);
				return;
			case ActionstepPackage.DIAL__CALLER_CAN_PARK:
				setCallerCanPark(CALLER_CAN_PARK_EDEFAULT);
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
			case ActionstepPackage.DIAL__CALL1:
				return call1 != null;
			case ActionstepPackage.DIAL__OUTGOING_CHANNELS:
				return outgoingChannels != null;
			case ActionstepPackage.DIAL__RETRY:
				return retry != RETRY_EDEFAULT;
			case ActionstepPackage.DIAL__TIMEOUT:
				return timeout != TIMEOUT_EDEFAULT;
			case ActionstepPackage.DIAL__CALLEE_BLIND_TRANSFER:
				return calleeBlindTransfer != CALLEE_BLIND_TRANSFER_EDEFAULT;
			case ActionstepPackage.DIAL__CALLER_BLIND_TRANSFER:
				return callerBlindTransfer != CALLER_BLIND_TRANSFER_EDEFAULT;
			case ActionstepPackage.DIAL__GENERATE_RING_TONE:
				return generateRingTone != GENERATE_RING_TONE_EDEFAULT;
			case ActionstepPackage.DIAL__RING_CALLEE:
				return ringCallee != RING_CALLEE_EDEFAULT;
			case ActionstepPackage.DIAL__CALLEE_MUSIC_ON_HOLD:
				return calleeMusicOnHold != CALLEE_MUSIC_ON_HOLD_EDEFAULT;
			case ActionstepPackage.DIAL__PRIVATE:
				return private_ != PRIVATE_EDEFAULT;
			case ActionstepPackage.DIAL__USE_OLD_CALLER_ID:
				return useOldCallerID != USE_OLD_CALLER_ID_EDEFAULT;
			case ActionstepPackage.DIAL__JUMP_PRIORITY:
				return jumpPriority != JUMP_PRIORITY_EDEFAULT;
			case ActionstepPackage.DIAL__MACRO:
				return MACRO_EDEFAULT == null ? macro != null : !MACRO_EDEFAULT.equals(macro);
			case ActionstepPackage.DIAL__CALLEE_STAR_HANGUP:
				return calleeStarHangup != CALLEE_STAR_HANGUP_EDEFAULT;
			case ActionstepPackage.DIAL__CALLER_STAR_HANGUP:
				return callerStarHangup != CALLER_STAR_HANGUP_EDEFAULT;
			case ActionstepPackage.DIAL__IGNORE_FORWARDING_REQUESTS:
				return ignoreForwardingRequests != IGNORE_FORWARDING_REQUESTS_EDEFAULT;
			case ActionstepPackage.DIAL__RESET_CDR:
				return resetCDR != RESET_CDR_EDEFAULT;
			case ActionstepPackage.DIAL__ENABLE_SCREENING_MODE:
				return enableScreeningMode != ENABLE_SCREENING_MODE_EDEFAULT;
			case ActionstepPackage.DIAL__USE_PRIVACY_MANAGER:
				return usePrivacyManager != USE_PRIVACY_MANAGER_EDEFAULT;
			case ActionstepPackage.DIAL__PRIVACE_MANAGER_DB:
				return PRIVACE_MANAGER_DB_EDEFAULT == null ? privaceManagerDB != null : !PRIVACE_MANAGER_DB_EDEFAULT.equals(privaceManagerDB);
			case ActionstepPackage.DIAL__STAY_ALIVE:
				return stayAlive != STAY_ALIVE_EDEFAULT;
			case ActionstepPackage.DIAL__ANNOUNCEMENT:
				return ANNOUNCEMENT_EDEFAULT == null ? announcement != null : !ANNOUNCEMENT_EDEFAULT.equals(announcement);
			case ActionstepPackage.DIAL__AUTO_HANGUP_TIME:
				return autoHangupTime != AUTO_HANGUP_TIME_EDEFAULT;
			case ActionstepPackage.DIAL__CAPTURE_DTMF:
				return captureDTMF != CAPTURE_DTMF_EDEFAULT;
			case ActionstepPackage.DIAL__DTMF_DIGITS:
				return DTMF_DIGITS_EDEFAULT == null ? dTMFDigits != null : !DTMF_DIGITS_EDEFAULT.equals(dTMFDigits);
			case ActionstepPackage.DIAL__MAX_DURATION:
				return maxDuration != MAX_DURATION_EDEFAULT;
			case ActionstepPackage.DIAL__CALL_ENDING_WARNING_TIME:
				return callEndingWarningTime != CALL_ENDING_WARNING_TIME_EDEFAULT;
			case ActionstepPackage.DIAL__WARNING_REPEAT_TIME:
				return warningRepeatTime != WARNING_REPEAT_TIME_EDEFAULT;
			case ActionstepPackage.DIAL__LIMIT_PLAY_AUDIO_CALLER:
				return limitPlayAudioCaller != LIMIT_PLAY_AUDIO_CALLER_EDEFAULT;
			case ActionstepPackage.DIAL__LIMIT_PLAY_AUDIO_CALLEE:
				return limitPlayAudioCallee != LIMIT_PLAY_AUDIO_CALLEE_EDEFAULT;
			case ActionstepPackage.DIAL__LIMIT_TIMEOUT_FILENAME:
				return LIMIT_TIMEOUT_FILENAME_EDEFAULT == null ? limitTimeoutFilename != null : !LIMIT_TIMEOUT_FILENAME_EDEFAULT.equals(limitTimeoutFilename);
			case ActionstepPackage.DIAL__LIMIT_CONNECT_FILENAME:
				return LIMIT_CONNECT_FILENAME_EDEFAULT == null ? limitConnectFilename != null : !LIMIT_CONNECT_FILENAME_EDEFAULT.equals(limitConnectFilename);
			case ActionstepPackage.DIAL__LIMIT_WARNING_FILENAME:
				return LIMIT_WARNING_FILENAME_EDEFAULT == null ? limitWarningFilename != null : !LIMIT_WARNING_FILENAME_EDEFAULT.equals(limitWarningFilename);
			case ActionstepPackage.DIAL__FORCE_OUTGOING_CALL_ID:
				return forceOutgoingCallID != FORCE_OUTGOING_CALL_ID_EDEFAULT;
			case ActionstepPackage.DIAL__CALLEE_CAN_RECORD:
				return calleeCanRecord != CALLEE_CAN_RECORD_EDEFAULT;
			case ActionstepPackage.DIAL__CALLER_CAN_RECORD:
				return callerCanRecord != CALLER_CAN_RECORD_EDEFAULT;
			case ActionstepPackage.DIAL__CALLEE_CAN_PARK:
				return calleeCanPark != CALLEE_CAN_PARK_EDEFAULT;
			case ActionstepPackage.DIAL__CALLER_CAN_PARK:
				return callerCanPark != CALLER_CAN_PARK_EDEFAULT;
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
		if (baseClass == CallConsumer1.class) {
			switch (derivedFeatureID) {
				case ActionstepPackage.DIAL__CALL1: return CallPackage.CALL_CONSUMER1__CALL1;
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
		if (baseClass == CallConsumer1.class) {
			switch (baseFeatureID) {
				case CallPackage.CALL_CONSUMER1__CALL1: return ActionstepPackage.DIAL__CALL1;
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
		result.append(" (retry: ");
		result.append(retry);
		result.append(", timeout: ");
		result.append(timeout);
		result.append(", calleeBlindTransfer: ");
		result.append(calleeBlindTransfer);
		result.append(", callerBlindTransfer: ");
		result.append(callerBlindTransfer);
		result.append(", generateRingTone: ");
		result.append(generateRingTone);
		result.append(", ringCallee: ");
		result.append(ringCallee);
		result.append(", calleeMusicOnHold: ");
		result.append(calleeMusicOnHold);
		result.append(", private: ");
		result.append(private_);
		result.append(", useOldCallerID: ");
		result.append(useOldCallerID);
		result.append(", jumpPriority: ");
		result.append(jumpPriority);
		result.append(", macro: ");
		result.append(macro);
		result.append(", calleeStarHangup: ");
		result.append(calleeStarHangup);
		result.append(", callerStarHangup: ");
		result.append(callerStarHangup);
		result.append(", ignoreForwardingRequests: ");
		result.append(ignoreForwardingRequests);
		result.append(", resetCDR: ");
		result.append(resetCDR);
		result.append(", enableScreeningMode: ");
		result.append(enableScreeningMode);
		result.append(", usePrivacyManager: ");
		result.append(usePrivacyManager);
		result.append(", privaceManagerDB: ");
		result.append(privaceManagerDB);
		result.append(", stayAlive: ");
		result.append(stayAlive);
		result.append(", announcement: ");
		result.append(announcement);
		result.append(", autoHangupTime: ");
		result.append(autoHangupTime);
		result.append(", captureDTMF: ");
		result.append(captureDTMF);
		result.append(", dTMFDigits: ");
		result.append(dTMFDigits);
		result.append(", maxDuration: ");
		result.append(maxDuration);
		result.append(", callEndingWarningTime: ");
		result.append(callEndingWarningTime);
		result.append(", warningRepeatTime: ");
		result.append(warningRepeatTime);
		result.append(", limitPlayAudioCaller: ");
		result.append(limitPlayAudioCaller);
		result.append(", limitPlayAudioCallee: ");
		result.append(limitPlayAudioCallee);
		result.append(", limitTimeoutFilename: ");
		result.append(limitTimeoutFilename);
		result.append(", limitConnectFilename: ");
		result.append(limitConnectFilename);
		result.append(", limitWarningFilename: ");
		result.append(limitWarningFilename);
		result.append(", forceOutgoingCallID: ");
		result.append(forceOutgoingCallID);
		result.append(", calleeCanRecord: ");
		result.append(calleeCanRecord);
		result.append(", callerCanRecord: ");
		result.append(callerCanRecord);
		result.append(", calleeCanPark: ");
		result.append(calleeCanPark);
		result.append(", callerCanPark: ");
		result.append(callerCanPark);
		result.append(')');
		return result.toString();
	}

} //DialImpl
