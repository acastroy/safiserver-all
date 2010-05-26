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
 * A representation of the model object '<em><b>Meet Me</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#getConferenceNumber <em>Conference Number</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#getPin <em>Pin</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#getBackgroundScriptAgi <em>Background Script Agi</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#getRecordingFilename <em>Recording Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#getRecordingFormat <em>Recording Format</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isAloneMessageEnabled <em>Alone Message Enabled</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isAdminMode <em>Admin Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isUseAGIScript <em>Use AGI Script</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isAnnounceCount <em>Announce Count</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isDynamicallyAddConference <em>Dynamically Add Conference</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isSelectEmptyConference <em>Select Empty Conference</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isSelectEmptyPinlessConference <em>Select Empty Pinless Conference</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isPassDTMF <em>Pass DTMF</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isAnnounceJoinLeave <em>Announce Join Leave</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isAnnounceJoinLeaveNoReview <em>Announce Join Leave No Review</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isUseMusicOnHold <em>Use Music On Hold</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isMonitorOnlyMode <em>Monitor Only Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isAllowPoundUserExit <em>Allow Pound User Exit</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isAlwaysPromptForPin <em>Always Prompt For Pin</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isQuietMode <em>Quiet Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isRecordConference <em>Record Conference</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isPlayMenuOnStar <em>Play Menu On Star</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isTalkOnlyMode <em>Talk Only Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isTalkerDetection <em>Talker Detection</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isVideoMode <em>Video Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isWaitForMarkedUser <em>Wait For Marked User</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isExitOnExtensionEntered <em>Exit On Extension Entered</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.MeetMe#isCloseOnLastMarkedUserExit <em>Close On Last Marked User Exit</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe()
 * @model
 * @generated
 */
public interface MeetMe extends ActionStep, CallConsumer1 {
  /**
	 * Returns the value of the '<em><b>Conference Number</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Conference Number</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Conference Number</em>' containment reference.
	 * @see #setConferenceNumber(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_ConferenceNumber()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the conference number' expectedReturnType='Text' helperClass=''"
	 *        annotation="Required criteria='non-null'"
	 * @generated
	 */
  DynamicValue getConferenceNumber();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#getConferenceNumber <em>Conference Number</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Conference Number</em>' containment reference.
	 * @see #getConferenceNumber()
	 * @generated
	 */
  void setConferenceNumber(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Pin</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pin</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Pin</em>' containment reference.
	 * @see #setPin(DynamicValue)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_Pin()
	 * @model containment="true" ordered="false"
	 *        annotation="DynamicValueAnnotation type='VariableName' isTypeLocked='false' description='the optional conference pin' expectedReturnType='Text' helperClass=''"
	 * @generated
	 */
  DynamicValue getPin();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#getPin <em>Pin</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pin</em>' containment reference.
	 * @see #getPin()
	 * @generated
	 */
  void setPin(DynamicValue value);

  /**
	 * Returns the value of the '<em><b>Background Script Agi</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Background Script Agi</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Background Script Agi</em>' attribute.
	 * @see #setBackgroundScriptAgi(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_BackgroundScriptAgi()
	 * @model ordered="false"
	 * @generated
	 */
  String getBackgroundScriptAgi();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#getBackgroundScriptAgi <em>Background Script Agi</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Background Script Agi</em>' attribute.
	 * @see #getBackgroundScriptAgi()
	 * @generated
	 */
  void setBackgroundScriptAgi(String value);

  /**
	 * Returns the value of the '<em><b>Recording Filename</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Recording Filename</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Recording Filename</em>' attribute.
	 * @see #setRecordingFilename(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_RecordingFilename()
	 * @model ordered="false"
	 * @generated
	 */
  String getRecordingFilename();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#getRecordingFilename <em>Recording Filename</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recording Filename</em>' attribute.
	 * @see #getRecordingFilename()
	 * @generated
	 */
  void setRecordingFilename(String value);

  /**
	 * Returns the value of the '<em><b>Recording Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Recording Format</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Recording Format</em>' attribute.
	 * @see #setRecordingFormat(String)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_RecordingFormat()
	 * @model ordered="false"
	 * @generated
	 */
  String getRecordingFormat();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#getRecordingFormat <em>Recording Format</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recording Format</em>' attribute.
	 * @see #getRecordingFormat()
	 * @generated
	 */
  void setRecordingFormat(String value);

  /**
	 * Returns the value of the '<em><b>Alone Message Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alone Message Enabled</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Alone Message Enabled</em>' attribute.
	 * @see #setAloneMessageEnabled(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_AloneMessageEnabled()
	 * @model default="true" ordered="false"
	 * @generated
	 */
  boolean isAloneMessageEnabled();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isAloneMessageEnabled <em>Alone Message Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Alone Message Enabled</em>' attribute.
	 * @see #isAloneMessageEnabled()
	 * @generated
	 */
  void setAloneMessageEnabled(boolean value);

  /**
	 * Returns the value of the '<em><b>Admin Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Admin Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Admin Mode</em>' attribute.
	 * @see #setAdminMode(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_AdminMode()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isAdminMode();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isAdminMode <em>Admin Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Admin Mode</em>' attribute.
	 * @see #isAdminMode()
	 * @generated
	 */
  void setAdminMode(boolean value);

  /**
	 * Returns the value of the '<em><b>Use AGI Script</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use AGI Script</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Use AGI Script</em>' attribute.
	 * @see #setUseAGIScript(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_UseAGIScript()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isUseAGIScript();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isUseAGIScript <em>Use AGI Script</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use AGI Script</em>' attribute.
	 * @see #isUseAGIScript()
	 * @generated
	 */
  void setUseAGIScript(boolean value);

  /**
	 * Returns the value of the '<em><b>Announce Count</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Announce Count</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Announce Count</em>' attribute.
	 * @see #setAnnounceCount(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_AnnounceCount()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isAnnounceCount();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isAnnounceCount <em>Announce Count</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Announce Count</em>' attribute.
	 * @see #isAnnounceCount()
	 * @generated
	 */
  void setAnnounceCount(boolean value);

  /**
	 * Returns the value of the '<em><b>Dynamically Add Conference</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dynamically Add Conference</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Dynamically Add Conference</em>' attribute.
	 * @see #setDynamicallyAddConference(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_DynamicallyAddConference()
	 * @model default="true" ordered="false"
	 * @generated
	 */
  boolean isDynamicallyAddConference();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isDynamicallyAddConference <em>Dynamically Add Conference</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dynamically Add Conference</em>' attribute.
	 * @see #isDynamicallyAddConference()
	 * @generated
	 */
  void setDynamicallyAddConference(boolean value);

  /**
	 * Returns the value of the '<em><b>Select Empty Conference</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Select Empty Conference</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Select Empty Conference</em>' attribute.
	 * @see #setSelectEmptyConference(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_SelectEmptyConference()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isSelectEmptyConference();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isSelectEmptyConference <em>Select Empty Conference</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Select Empty Conference</em>' attribute.
	 * @see #isSelectEmptyConference()
	 * @generated
	 */
  void setSelectEmptyConference(boolean value);

  /**
	 * Returns the value of the '<em><b>Select Empty Pinless Conference</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Select Empty Pinless Conference</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Select Empty Pinless Conference</em>' attribute.
	 * @see #setSelectEmptyPinlessConference(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_SelectEmptyPinlessConference()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isSelectEmptyPinlessConference();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isSelectEmptyPinlessConference <em>Select Empty Pinless Conference</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Select Empty Pinless Conference</em>' attribute.
	 * @see #isSelectEmptyPinlessConference()
	 * @generated
	 */
  void setSelectEmptyPinlessConference(boolean value);

  /**
	 * Returns the value of the '<em><b>Pass DTMF</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Pass DTMF</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Pass DTMF</em>' attribute.
	 * @see #setPassDTMF(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_PassDTMF()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isPassDTMF();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isPassDTMF <em>Pass DTMF</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pass DTMF</em>' attribute.
	 * @see #isPassDTMF()
	 * @generated
	 */
  void setPassDTMF(boolean value);

  /**
	 * Returns the value of the '<em><b>Announce Join Leave</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Announce Join Leave</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Announce Join Leave</em>' attribute.
	 * @see #setAnnounceJoinLeave(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_AnnounceJoinLeave()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isAnnounceJoinLeave();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isAnnounceJoinLeave <em>Announce Join Leave</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Announce Join Leave</em>' attribute.
	 * @see #isAnnounceJoinLeave()
	 * @generated
	 */
  void setAnnounceJoinLeave(boolean value);

  /**
	 * Returns the value of the '<em><b>Announce Join Leave No Review</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Announce Join Leave No Review</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Announce Join Leave No Review</em>' attribute.
	 * @see #setAnnounceJoinLeaveNoReview(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_AnnounceJoinLeaveNoReview()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isAnnounceJoinLeaveNoReview();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isAnnounceJoinLeaveNoReview <em>Announce Join Leave No Review</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Announce Join Leave No Review</em>' attribute.
	 * @see #isAnnounceJoinLeaveNoReview()
	 * @generated
	 */
  void setAnnounceJoinLeaveNoReview(boolean value);

  /**
	 * Returns the value of the '<em><b>Use Music On Hold</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Music On Hold</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Use Music On Hold</em>' attribute.
	 * @see #setUseMusicOnHold(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_UseMusicOnHold()
	 * @model default="true" ordered="false"
	 * @generated
	 */
  boolean isUseMusicOnHold();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isUseMusicOnHold <em>Use Music On Hold</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Use Music On Hold</em>' attribute.
	 * @see #isUseMusicOnHold()
	 * @generated
	 */
  void setUseMusicOnHold(boolean value);

  /**
	 * Returns the value of the '<em><b>Monitor Only Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Monitor Only Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Monitor Only Mode</em>' attribute.
	 * @see #setMonitorOnlyMode(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_MonitorOnlyMode()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isMonitorOnlyMode();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isMonitorOnlyMode <em>Monitor Only Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Monitor Only Mode</em>' attribute.
	 * @see #isMonitorOnlyMode()
	 * @generated
	 */
  void setMonitorOnlyMode(boolean value);

  /**
	 * Returns the value of the '<em><b>Allow Pound User Exit</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Allow Pound User Exit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Pound User Exit</em>' attribute.
	 * @see #setAllowPoundUserExit(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_AllowPoundUserExit()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isAllowPoundUserExit();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isAllowPoundUserExit <em>Allow Pound User Exit</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Pound User Exit</em>' attribute.
	 * @see #isAllowPoundUserExit()
	 * @generated
	 */
  void setAllowPoundUserExit(boolean value);

  /**
	 * Returns the value of the '<em><b>Always Prompt For Pin</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Always Prompt For Pin</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Always Prompt For Pin</em>' attribute.
	 * @see #setAlwaysPromptForPin(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_AlwaysPromptForPin()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isAlwaysPromptForPin();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isAlwaysPromptForPin <em>Always Prompt For Pin</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Always Prompt For Pin</em>' attribute.
	 * @see #isAlwaysPromptForPin()
	 * @generated
	 */
  void setAlwaysPromptForPin(boolean value);

  /**
	 * Returns the value of the '<em><b>Quiet Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quiet Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Quiet Mode</em>' attribute.
	 * @see #setQuietMode(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_QuietMode()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isQuietMode();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isQuietMode <em>Quiet Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quiet Mode</em>' attribute.
	 * @see #isQuietMode()
	 * @generated
	 */
  void setQuietMode(boolean value);

  /**
	 * Returns the value of the '<em><b>Record Conference</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Record Conference</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Record Conference</em>' attribute.
	 * @see #setRecordConference(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_RecordConference()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isRecordConference();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isRecordConference <em>Record Conference</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Record Conference</em>' attribute.
	 * @see #isRecordConference()
	 * @generated
	 */
  void setRecordConference(boolean value);

  /**
	 * Returns the value of the '<em><b>Play Menu On Star</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Play Menu On Star</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Play Menu On Star</em>' attribute.
	 * @see #setPlayMenuOnStar(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_PlayMenuOnStar()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isPlayMenuOnStar();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isPlayMenuOnStar <em>Play Menu On Star</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Play Menu On Star</em>' attribute.
	 * @see #isPlayMenuOnStar()
	 * @generated
	 */
  void setPlayMenuOnStar(boolean value);

  /**
	 * Returns the value of the '<em><b>Talk Only Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Talk Only Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Talk Only Mode</em>' attribute.
	 * @see #setTalkOnlyMode(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_TalkOnlyMode()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isTalkOnlyMode();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isTalkOnlyMode <em>Talk Only Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Talk Only Mode</em>' attribute.
	 * @see #isTalkOnlyMode()
	 * @generated
	 */
  void setTalkOnlyMode(boolean value);

  /**
	 * Returns the value of the '<em><b>Talker Detection</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Talker Detection</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Talker Detection</em>' attribute.
	 * @see #setTalkerDetection(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_TalkerDetection()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isTalkerDetection();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isTalkerDetection <em>Talker Detection</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Talker Detection</em>' attribute.
	 * @see #isTalkerDetection()
	 * @generated
	 */
  void setTalkerDetection(boolean value);

  /**
	 * Returns the value of the '<em><b>Video Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Video Mode</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Video Mode</em>' attribute.
	 * @see #setVideoMode(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_VideoMode()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isVideoMode();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isVideoMode <em>Video Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Video Mode</em>' attribute.
	 * @see #isVideoMode()
	 * @generated
	 */
  void setVideoMode(boolean value);

  /**
	 * Returns the value of the '<em><b>Wait For Marked User</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Wait For Marked User</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait For Marked User</em>' attribute.
	 * @see #setWaitForMarkedUser(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_WaitForMarkedUser()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isWaitForMarkedUser();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isWaitForMarkedUser <em>Wait For Marked User</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait For Marked User</em>' attribute.
	 * @see #isWaitForMarkedUser()
	 * @generated
	 */
  void setWaitForMarkedUser(boolean value);

  /**
	 * Returns the value of the '<em><b>Exit On Extension Entered</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exit On Extension Entered</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit On Extension Entered</em>' attribute.
	 * @see #setExitOnExtensionEntered(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_ExitOnExtensionEntered()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isExitOnExtensionEntered();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isExitOnExtensionEntered <em>Exit On Extension Entered</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit On Extension Entered</em>' attribute.
	 * @see #isExitOnExtensionEntered()
	 * @generated
	 */
  void setExitOnExtensionEntered(boolean value);

  /**
	 * Returns the value of the '<em><b>Close On Last Marked User Exit</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Close On Last Marked User Exit</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Close On Last Marked User Exit</em>' attribute.
	 * @see #setCloseOnLastMarkedUserExit(boolean)
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#getMeetMe_CloseOnLastMarkedUserExit()
	 * @model ordered="false"
	 * @generated
	 */
  boolean isCloseOnLastMarkedUserExit();

  /**
	 * Sets the value of the '{@link com.safi.asterisk.actionstep.MeetMe#isCloseOnLastMarkedUserExit <em>Close On Last Marked User Exit</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Close On Last Marked User Exit</em>' attribute.
	 * @see #isCloseOnLastMarkedUserExit()
	 * @generated
	 */
  void setCloseOnLastMarkedUserExit(boolean value);

} // MeetMe
