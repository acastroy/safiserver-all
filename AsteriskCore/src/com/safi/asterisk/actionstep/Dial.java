/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.call.CallConsumer1;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dial</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getOutgoingChannels <em>Outgoing Channels</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isRetry <em>Retry</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getTimeout <em>Timeout</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isCalleeBlindTransfer <em>Callee Blind Transfer</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isCallerBlindTransfer <em>Caller Blind Transfer</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isGenerateRingTone <em>Generate Ring Tone</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isRingCallee <em>Ring Callee</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isCalleeMusicOnHold <em>Callee Music On Hold</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isPrivate <em>Private</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isUseOldCallerID <em>Use Old Caller ID</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isJumpPriority <em>Jump Priority</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getMacro <em>Macro</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isCalleeStarHangup <em>Callee Star Hangup</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isCallerStarHangup <em>Caller Star Hangup</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isIgnoreForwardingRequests <em>Ignore Forwarding Requests</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isResetCDR <em>Reset CDR</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isEnableScreeningMode <em>Enable Screening Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isUsePrivacyManager <em>Use Privacy Manager</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getPrivaceManagerDB <em>Privace Manager DB</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isStayAlive <em>Stay Alive</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getAnnouncement <em>Announcement</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getAutoHangupTime <em>Auto Hangup Time</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isCaptureDTMF <em>Capture DTMF</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getDTMFDigits <em>DTMF Digits</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getMaxDuration <em>Max Duration</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getCallEndingWarningTime <em>Call Ending Warning Time</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getWarningRepeatTime <em>Warning Repeat Time</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isLimitPlayAudioCaller <em>Limit Play Audio Caller</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isLimitPlayAudioCallee <em>Limit Play Audio Callee</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getLimitTimeoutFilename <em>Limit Timeout Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getLimitConnectFilename <em>Limit Connect Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#getLimitWarningFilename <em>Limit Warning Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isForceOutgoingCallID <em>Force Outgoing Call ID</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isCalleeCanRecord <em>Callee Can Record</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isCallerCanRecord <em>Caller Can Record</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isCalleeCanPark <em>Callee Can Park</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.Dial#isCallerCanPark <em>Caller Can Park</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial()
 * @model
 * @generated
 */
public interface Dial extends AsteriskActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Outgoing Channels</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Outgoing Channels</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Channels</em>' containment reference.
	 * @see #setOutgoingChannels(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_OutgoingChannels()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='Array of channel names to attempt to dial' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-empty'"
	 * @generated
	 */
  DynamicValue getOutgoingChannels();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getOutgoingChannels <em>Outgoing Channels</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Outgoing Channels</em>' containment reference.
	 * @see #getOutgoingChannels()
	 * @generated
	 */
  void setOutgoingChannels(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Retry</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Retry</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Retry</em>' attribute.
	 * @see #setRetry(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_Retry()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isRetry();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isRetry <em>Retry</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Retry</em>' attribute.
	 * @see #isRetry()
	 * @generated
	 */
  void setRetry(boolean value);

  /**
	 * Returns the value of the '<em><b>Timeout</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Timeout</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeout</em>' attribute.
	 * @see #setTimeout(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_Timeout()
	 * @model ordered="false"
	 *        annotation="unitsTime seconds='true'"
	 * @generated
	 */
  int getTimeout();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getTimeout <em>Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeout</em>' attribute.
	 * @see #getTimeout()
	 * @generated
	 */
  void setTimeout(int value);

  /**
	 * Returns the value of the '<em><b>Callee Blind Transfer</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Callee Blind Transfer</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Callee Blind Transfer</em>' attribute.
	 * @see #setCalleeBlindTransfer(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_CalleeBlindTransfer()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isCalleeBlindTransfer();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isCalleeBlindTransfer <em>Callee Blind Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Callee Blind Transfer</em>' attribute.
	 * @see #isCalleeBlindTransfer()
	 * @generated
	 */
  void setCalleeBlindTransfer(boolean value);

  /**
	 * Returns the value of the '<em><b>Caller Blind Transfer</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Caller Blind Transfer</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Caller Blind Transfer</em>' attribute.
	 * @see #setCallerBlindTransfer(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_CallerBlindTransfer()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isCallerBlindTransfer();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isCallerBlindTransfer <em>Caller Blind Transfer</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caller Blind Transfer</em>' attribute.
	 * @see #isCallerBlindTransfer()
	 * @generated
	 */
  void setCallerBlindTransfer(boolean value);

  /**
	 * Returns the value of the '<em><b>Generate Ring Tone</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Generate Ring Tone</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Generate Ring Tone</em>' attribute.
	 * @see #setGenerateRingTone(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_GenerateRingTone()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isGenerateRingTone();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isGenerateRingTone <em>Generate Ring Tone</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Generate Ring Tone</em>' attribute.
	 * @see #isGenerateRingTone()
	 * @generated
	 */
  void setGenerateRingTone(boolean value);

  /**
	 * Returns the value of the '<em><b>Ring Callee</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ring Callee</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Ring Callee</em>' attribute.
	 * @see #setRingCallee(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_RingCallee()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isRingCallee();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isRingCallee <em>Ring Callee</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ring Callee</em>' attribute.
	 * @see #isRingCallee()
	 * @generated
	 */
  void setRingCallee(boolean value);

  /**
	 * Returns the value of the '<em><b>Callee Music On Hold</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Callee Music On Hold</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Callee Music On Hold</em>' attribute.
	 * @see #setCalleeMusicOnHold(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_CalleeMusicOnHold()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isCalleeMusicOnHold();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isCalleeMusicOnHold <em>Callee Music On Hold</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Callee Music On Hold</em>' attribute.
	 * @see #isCalleeMusicOnHold()
	 * @generated
	 */
  void setCalleeMusicOnHold(boolean value);

  /**
	 * Returns the value of the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Private</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Private</em>' attribute.
	 * @see #setPrivate(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_Private()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isPrivate();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isPrivate <em>Private</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Private</em>' attribute.
	 * @see #isPrivate()
	 * @generated
	 */
  void setPrivate(boolean value);

  /**
	 * Returns the value of the '<em><b>Use Old Caller ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Old Caller ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Old Caller ID</em>' attribute.
	 * @see #setUseOldCallerID(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_UseOldCallerID()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isUseOldCallerID();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isUseOldCallerID <em>Use Old Caller ID</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Old Caller ID</em>' attribute.
	 * @see #isUseOldCallerID()
	 * @generated
	 */
  void setUseOldCallerID(boolean value);

  /**
	 * Returns the value of the '<em><b>Jump Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Jump Priority</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Jump Priority</em>' attribute.
	 * @see #setJumpPriority(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_JumpPriority()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isJumpPriority();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isJumpPriority <em>Jump Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jump Priority</em>' attribute.
	 * @see #isJumpPriority()
	 * @generated
	 */
  void setJumpPriority(boolean value);

  /**
	 * Returns the value of the '<em><b>Macro</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Macro</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Macro</em>' attribute.
	 * @see #setMacro(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_Macro()
	 * @model ordered="false"
	 * @generated
	 */
  String getMacro();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getMacro <em>Macro</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Macro</em>' attribute.
	 * @see #getMacro()
	 * @generated
	 */
  void setMacro(String value);

  /**
	 * Returns the value of the '<em><b>Callee Star Hangup</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Callee Star Hangup</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Callee Star Hangup</em>' attribute.
	 * @see #setCalleeStarHangup(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_CalleeStarHangup()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isCalleeStarHangup();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isCalleeStarHangup <em>Callee Star Hangup</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Callee Star Hangup</em>' attribute.
	 * @see #isCalleeStarHangup()
	 * @generated
	 */
  void setCalleeStarHangup(boolean value);

  /**
	 * Returns the value of the '<em><b>Caller Star Hangup</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Caller Star Hangup</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Caller Star Hangup</em>' attribute.
	 * @see #setCallerStarHangup(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_CallerStarHangup()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isCallerStarHangup();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isCallerStarHangup <em>Caller Star Hangup</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caller Star Hangup</em>' attribute.
	 * @see #isCallerStarHangup()
	 * @generated
	 */
  void setCallerStarHangup(boolean value);

  /**
	 * Returns the value of the '<em><b>Ignore Forwarding Requests</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ignore Forwarding Requests</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Ignore Forwarding Requests</em>' attribute.
	 * @see #setIgnoreForwardingRequests(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_IgnoreForwardingRequests()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isIgnoreForwardingRequests();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isIgnoreForwardingRequests <em>Ignore Forwarding Requests</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ignore Forwarding Requests</em>' attribute.
	 * @see #isIgnoreForwardingRequests()
	 * @generated
	 */
  void setIgnoreForwardingRequests(boolean value);

  /**
	 * Returns the value of the '<em><b>Reset CDR</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Reset CDR</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Reset CDR</em>' attribute.
	 * @see #setResetCDR(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_ResetCDR()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isResetCDR();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isResetCDR <em>Reset CDR</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reset CDR</em>' attribute.
	 * @see #isResetCDR()
	 * @generated
	 */
  void setResetCDR(boolean value);

  /**
	 * Returns the value of the '<em><b>Enable Screening Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Enable Screening Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Enable Screening Mode</em>' attribute.
	 * @see #setEnableScreeningMode(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_EnableScreeningMode()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isEnableScreeningMode();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isEnableScreeningMode <em>Enable Screening Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enable Screening Mode</em>' attribute.
	 * @see #isEnableScreeningMode()
	 * @generated
	 */
  void setEnableScreeningMode(boolean value);

  /**
	 * Returns the value of the '<em><b>Use Privacy Manager</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Privacy Manager</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Privacy Manager</em>' attribute.
	 * @see #setUsePrivacyManager(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_UsePrivacyManager()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isUsePrivacyManager();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isUsePrivacyManager <em>Use Privacy Manager</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Privacy Manager</em>' attribute.
	 * @see #isUsePrivacyManager()
	 * @generated
	 */
  void setUsePrivacyManager(boolean value);

  /**
	 * Returns the value of the '<em><b>Privace Manager DB</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Privace Manager DB</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Privace Manager DB</em>' attribute.
	 * @see #setPrivaceManagerDB(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_PrivaceManagerDB()
	 * @model ordered="false"
	 * @generated
	 */
  String getPrivaceManagerDB();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getPrivaceManagerDB <em>Privace Manager DB</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Privace Manager DB</em>' attribute.
	 * @see #getPrivaceManagerDB()
	 * @generated
	 */
  void setPrivaceManagerDB(String value);

  /**
	 * Returns the value of the '<em><b>Stay Alive</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Stay Alive</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Stay Alive</em>' attribute.
	 * @see #setStayAlive(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_StayAlive()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isStayAlive();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isStayAlive <em>Stay Alive</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stay Alive</em>' attribute.
	 * @see #isStayAlive()
	 * @generated
	 */
  void setStayAlive(boolean value);

  /**
	 * Returns the value of the '<em><b>Announcement</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Announcement</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Announcement</em>' attribute.
	 * @see #setAnnouncement(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_Announcement()
	 * @model ordered="false"
	 * @generated
	 */
  String getAnnouncement();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getAnnouncement <em>Announcement</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Announcement</em>' attribute.
	 * @see #getAnnouncement()
	 * @generated
	 */
  void setAnnouncement(String value);

  /**
	 * Returns the value of the '<em><b>Auto Hangup Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Auto Hangup Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Auto Hangup Time</em>' attribute.
	 * @see #setAutoHangupTime(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_AutoHangupTime()
	 * @model ordered="false"
	 *        annotation="unitsTime seconds='true'"
	 * @generated
	 */
  int getAutoHangupTime();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getAutoHangupTime <em>Auto Hangup Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Auto Hangup Time</em>' attribute.
	 * @see #getAutoHangupTime()
	 * @generated
	 */
  void setAutoHangupTime(int value);

  /**
	 * Returns the value of the '<em><b>Capture DTMF</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Capture DTMF</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Capture DTMF</em>' attribute.
	 * @see #setCaptureDTMF(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_CaptureDTMF()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isCaptureDTMF();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isCaptureDTMF <em>Capture DTMF</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capture DTMF</em>' attribute.
	 * @see #isCaptureDTMF()
	 * @generated
	 */
  void setCaptureDTMF(boolean value);

  /**
	 * Returns the value of the '<em><b>DTMF Digits</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>DTMF Digits</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>DTMF Digits</em>' attribute.
	 * @see #setDTMFDigits(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_DTMFDigits()
	 * @model ordered="false"
	 * @generated
	 */
  String getDTMFDigits();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getDTMFDigits <em>DTMF Digits</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>DTMF Digits</em>' attribute.
	 * @see #getDTMFDigits()
	 * @generated
	 */
  void setDTMFDigits(String value);

  /**
	 * Returns the value of the '<em><b>Max Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Max Duration</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Duration</em>' attribute.
	 * @see #setMaxDuration(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_MaxDuration()
	 * @model ordered="false"
	 *        annotation="unitsTime milliseconds='true'"
	 * @generated
	 */
  int getMaxDuration();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getMaxDuration <em>Max Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Duration</em>' attribute.
	 * @see #getMaxDuration()
	 * @generated
	 */
  void setMaxDuration(int value);

  /**
	 * Returns the value of the '<em><b>Call Ending Warning Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Call Ending Warning Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Ending Warning Time</em>' attribute.
	 * @see #setCallEndingWarningTime(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_CallEndingWarningTime()
	 * @model ordered="false"
	 *        annotation="unitsTime milliseconds='true'"
	 * @generated
	 */
  int getCallEndingWarningTime();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getCallEndingWarningTime <em>Call Ending Warning Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Ending Warning Time</em>' attribute.
	 * @see #getCallEndingWarningTime()
	 * @generated
	 */
  void setCallEndingWarningTime(int value);

  /**
	 * Returns the value of the '<em><b>Warning Repeat Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Warning Repeat Time</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Warning Repeat Time</em>' attribute.
	 * @see #setWarningRepeatTime(int)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_WarningRepeatTime()
	 * @model ordered="false"
	 *        annotation="unitsTime milliseconds='true'"
	 * @generated
	 */
  int getWarningRepeatTime();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getWarningRepeatTime <em>Warning Repeat Time</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Warning Repeat Time</em>' attribute.
	 * @see #getWarningRepeatTime()
	 * @generated
	 */
  void setWarningRepeatTime(int value);

  /**
	 * Returns the value of the '<em><b>Limit Play Audio Caller</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit Play Audio Caller</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Limit Play Audio Caller</em>' attribute.
	 * @see #setLimitPlayAudioCaller(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_LimitPlayAudioCaller()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isLimitPlayAudioCaller();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isLimitPlayAudioCaller <em>Limit Play Audio Caller</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Limit Play Audio Caller</em>' attribute.
	 * @see #isLimitPlayAudioCaller()
	 * @generated
	 */
  void setLimitPlayAudioCaller(boolean value);

  /**
	 * Returns the value of the '<em><b>Limit Play Audio Callee</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit Play Audio Callee</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Limit Play Audio Callee</em>' attribute.
	 * @see #setLimitPlayAudioCallee(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_LimitPlayAudioCallee()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isLimitPlayAudioCallee();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isLimitPlayAudioCallee <em>Limit Play Audio Callee</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Limit Play Audio Callee</em>' attribute.
	 * @see #isLimitPlayAudioCallee()
	 * @generated
	 */
  void setLimitPlayAudioCallee(boolean value);

  /**
	 * Returns the value of the '<em><b>Limit Timeout Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit Timeout Filename</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Limit Timeout Filename</em>' attribute.
	 * @see #setLimitTimeoutFilename(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_LimitTimeoutFilename()
	 * @model ordered="false"
	 * @generated
	 */
  String getLimitTimeoutFilename();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getLimitTimeoutFilename <em>Limit Timeout Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Limit Timeout Filename</em>' attribute.
	 * @see #getLimitTimeoutFilename()
	 * @generated
	 */
  void setLimitTimeoutFilename(String value);

  /**
	 * Returns the value of the '<em><b>Limit Connect Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit Connect Filename</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Limit Connect Filename</em>' attribute.
	 * @see #setLimitConnectFilename(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_LimitConnectFilename()
	 * @model ordered="false"
	 * @generated
	 */
  String getLimitConnectFilename();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getLimitConnectFilename <em>Limit Connect Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Limit Connect Filename</em>' attribute.
	 * @see #getLimitConnectFilename()
	 * @generated
	 */
  void setLimitConnectFilename(String value);

  /**
	 * Returns the value of the '<em><b>Limit Warning Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Limit Warning Filename</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Limit Warning Filename</em>' attribute.
	 * @see #setLimitWarningFilename(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_LimitWarningFilename()
	 * @model ordered="false"
	 * @generated
	 */
  String getLimitWarningFilename();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#getLimitWarningFilename <em>Limit Warning Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Limit Warning Filename</em>' attribute.
	 * @see #getLimitWarningFilename()
	 * @generated
	 */
  void setLimitWarningFilename(String value);

  /**
	 * Returns the value of the '<em><b>Force Outgoing Call ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Force Outgoing Call ID</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Force Outgoing Call ID</em>' attribute.
	 * @see #setForceOutgoingCallID(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_ForceOutgoingCallID()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isForceOutgoingCallID();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isForceOutgoingCallID <em>Force Outgoing Call ID</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Force Outgoing Call ID</em>' attribute.
	 * @see #isForceOutgoingCallID()
	 * @generated
	 */
  void setForceOutgoingCallID(boolean value);

  /**
	 * Returns the value of the '<em><b>Callee Can Record</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Callee Can Record</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Callee Can Record</em>' attribute.
	 * @see #setCalleeCanRecord(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_CalleeCanRecord()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isCalleeCanRecord();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isCalleeCanRecord <em>Callee Can Record</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Callee Can Record</em>' attribute.
	 * @see #isCalleeCanRecord()
	 * @generated
	 */
  void setCalleeCanRecord(boolean value);

  /**
	 * Returns the value of the '<em><b>Caller Can Record</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Caller Can Record</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Caller Can Record</em>' attribute.
	 * @see #setCallerCanRecord(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_CallerCanRecord()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isCallerCanRecord();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isCallerCanRecord <em>Caller Can Record</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caller Can Record</em>' attribute.
	 * @see #isCallerCanRecord()
	 * @generated
	 */
  void setCallerCanRecord(boolean value);

  /**
	 * Returns the value of the '<em><b>Callee Can Park</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Callee Can Park</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Callee Can Park</em>' attribute.
	 * @see #setCalleeCanPark(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_CalleeCanPark()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isCalleeCanPark();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isCalleeCanPark <em>Callee Can Park</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Callee Can Park</em>' attribute.
	 * @see #isCalleeCanPark()
	 * @generated
	 */
  void setCalleeCanPark(boolean value);

  /**
	 * Returns the value of the '<em><b>Caller Can Park</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Caller Can Park</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Caller Can Park</em>' attribute.
	 * @see #setCallerCanPark(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getDial_CallerCanPark()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isCallerCanPark();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.Dial#isCallerCanPark <em>Caller Can Park</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Caller Can Park</em>' attribute.
	 * @see #isCallerCanPark()
	 * @generated
	 */
  void setCallerCanPark(boolean value);

} // Dial
