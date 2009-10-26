/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import com.safi.asterisk.Call;

import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.MeetMe;

import com.safi.core.CorePackage;
import com.safi.core.ProductIdentifiable;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepException;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.Output;

import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletContext;
import com.safi.core.saflet.SafletPackage;

import com.safi.core.scripting.SafletScriptException;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meet Me</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getCall1 <em>Call1</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getProductId <em>Product Id</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isPaused <em>Paused</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isActive <em>Active</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getOutputs <em>Outputs</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getName <em>Name</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getSaflet <em>Saflet</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getDefaultOutput <em>Default Output</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getErrorOutput <em>Error Output</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getConferenceNumber <em>Conference Number</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getPin <em>Pin</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getBackgroundScriptAgi <em>Background Script Agi</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getRecordingFilename <em>Recording Filename</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#getRecordingFormat <em>Recording Format</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isAloneMessageEnabled <em>Alone Message Enabled</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isAdminMode <em>Admin Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isUseAGIScript <em>Use AGI Script</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isAnnounceCount <em>Announce Count</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isDynamicallyAddConference <em>Dynamically Add Conference</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isSelectEmptyConference <em>Select Empty Conference</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isSelectEmptyPinlessConference <em>Select Empty Pinless Conference</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isPassDTMF <em>Pass DTMF</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isAnnounceJoinLeave <em>Announce Join Leave</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isAnnounceJoinLeaveNoReview <em>Announce Join Leave No Review</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isUseMusicOnHold <em>Use Music On Hold</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isMonitorOnlyMode <em>Monitor Only Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isAllowPoundUserExit <em>Allow Pound User Exit</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isAlwaysPromptForPin <em>Always Prompt For Pin</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isQuietMode <em>Quiet Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isRecordConference <em>Record Conference</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isPlayMenuOnStar <em>Play Menu On Star</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isTalkOnlyMode <em>Talk Only Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isTalkerDetection <em>Talker Detection</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isVideoMode <em>Video Mode</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isWaitForMarkedUser <em>Wait For Marked User</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isExitOnExtensionEntered <em>Exit On Extension Entered</em>}</li>
 *   <li>{@link com.safi.asterisk.actionstep.impl.MeetMeImpl#isCloseOnLastMarkedUserExit <em>Close On Last Marked User Exit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MeetMeImpl extends EObjectImpl implements MeetMe {
  /**
   * The cached value of the '{@link #getCall1() <em>Call1</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCall1()
   * @generated
   * @ordered
   */
  protected Call call1;

  /**
   * The default value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProductId()
   * @generated
   * @ordered
   */
  protected static final String PRODUCT_ID_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProductId() <em>Product Id</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProductId()
   * @generated
   * @ordered
   */
  protected String productId = PRODUCT_ID_EDEFAULT;

  /**
   * The default value of the '{@link #isPaused() <em>Paused</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPaused()
   * @generated
   * @ordered
   */
  protected static final boolean PAUSED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPaused() <em>Paused</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPaused()
   * @generated
   * @ordered
   */
  protected boolean paused = PAUSED_EDEFAULT;

  /**
   * The default value of the '{@link #isActive() <em>Active</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActive()
   * @generated
   * @ordered
   */
  protected static final boolean ACTIVE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isActive() <em>Active</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isActive()
   * @generated
   * @ordered
   */
  protected boolean active = ACTIVE_EDEFAULT;

  /**
   * The cached value of the '{@link #getOutputs() <em>Outputs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutputs()
   * @generated
   * @ordered
   */
  protected EList<Output> outputs;

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
   * The cached value of the '{@link #getDefaultOutput() <em>Default Output</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultOutput()
   * @generated
   * @ordered
   */
  protected Output defaultOutput;

  /**
   * The cached value of the '{@link #getErrorOutput() <em>Error Output</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getErrorOutput()
   * @generated
   * @ordered
   */
  protected Output errorOutput;

  /**
   * The cached value of the '{@link #getConferenceNumber() <em>Conference Number</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getConferenceNumber()
   * @generated
   * @ordered
   */
  protected DynamicValue conferenceNumber;

  /**
   * The cached value of the '{@link #getPin() <em>Pin</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPin()
   * @generated
   * @ordered
   */
  protected DynamicValue pin;

  /**
   * The default value of the '{@link #getBackgroundScriptAgi() <em>Background Script Agi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBackgroundScriptAgi()
   * @generated
   * @ordered
   */
  protected static final String BACKGROUND_SCRIPT_AGI_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBackgroundScriptAgi() <em>Background Script Agi</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBackgroundScriptAgi()
   * @generated
   * @ordered
   */
  protected String backgroundScriptAgi = BACKGROUND_SCRIPT_AGI_EDEFAULT;

  /**
   * The default value of the '{@link #getRecordingFilename() <em>Recording Filename</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordingFilename()
   * @generated
   * @ordered
   */
  protected static final String RECORDING_FILENAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRecordingFilename() <em>Recording Filename</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordingFilename()
   * @generated
   * @ordered
   */
  protected String recordingFilename = RECORDING_FILENAME_EDEFAULT;

  /**
   * The default value of the '{@link #getRecordingFormat() <em>Recording Format</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordingFormat()
   * @generated
   * @ordered
   */
  protected static final String RECORDING_FORMAT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getRecordingFormat() <em>Recording Format</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRecordingFormat()
   * @generated
   * @ordered
   */
  protected String recordingFormat = RECORDING_FORMAT_EDEFAULT;

  /**
   * The default value of the '{@link #isAloneMessageEnabled() <em>Alone Message Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAloneMessageEnabled()
   * @generated
   * @ordered
   */
  protected static final boolean ALONE_MESSAGE_ENABLED_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isAloneMessageEnabled() <em>Alone Message Enabled</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAloneMessageEnabled()
   * @generated
   * @ordered
   */
  protected boolean aloneMessageEnabled = ALONE_MESSAGE_ENABLED_EDEFAULT;

  /**
   * The default value of the '{@link #isAdminMode() <em>Admin Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdminMode()
   * @generated
   * @ordered
   */
  protected static final boolean ADMIN_MODE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAdminMode() <em>Admin Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAdminMode()
   * @generated
   * @ordered
   */
  protected boolean adminMode = ADMIN_MODE_EDEFAULT;

  /**
   * The default value of the '{@link #isUseAGIScript() <em>Use AGI Script</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseAGIScript()
   * @generated
   * @ordered
   */
  protected static final boolean USE_AGI_SCRIPT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isUseAGIScript() <em>Use AGI Script</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseAGIScript()
   * @generated
   * @ordered
   */
  protected boolean useAGIScript = USE_AGI_SCRIPT_EDEFAULT;

  /**
   * The default value of the '{@link #isAnnounceCount() <em>Announce Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnnounceCount()
   * @generated
   * @ordered
   */
  protected static final boolean ANNOUNCE_COUNT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnnounceCount() <em>Announce Count</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnnounceCount()
   * @generated
   * @ordered
   */
  protected boolean announceCount = ANNOUNCE_COUNT_EDEFAULT;

  /**
   * The default value of the '{@link #isDynamicallyAddConference() <em>Dynamically Add Conference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDynamicallyAddConference()
   * @generated
   * @ordered
   */
  protected static final boolean DYNAMICALLY_ADD_CONFERENCE_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isDynamicallyAddConference() <em>Dynamically Add Conference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isDynamicallyAddConference()
   * @generated
   * @ordered
   */
  protected boolean dynamicallyAddConference = DYNAMICALLY_ADD_CONFERENCE_EDEFAULT;

  /**
   * The default value of the '{@link #isSelectEmptyConference() <em>Select Empty Conference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelectEmptyConference()
   * @generated
   * @ordered
   */
  protected static final boolean SELECT_EMPTY_CONFERENCE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSelectEmptyConference() <em>Select Empty Conference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelectEmptyConference()
   * @generated
   * @ordered
   */
  protected boolean selectEmptyConference = SELECT_EMPTY_CONFERENCE_EDEFAULT;

  /**
   * The default value of the '{@link #isSelectEmptyPinlessConference() <em>Select Empty Pinless Conference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelectEmptyPinlessConference()
   * @generated
   * @ordered
   */
  protected static final boolean SELECT_EMPTY_PINLESS_CONFERENCE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isSelectEmptyPinlessConference() <em>Select Empty Pinless Conference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isSelectEmptyPinlessConference()
   * @generated
   * @ordered
   */
  protected boolean selectEmptyPinlessConference = SELECT_EMPTY_PINLESS_CONFERENCE_EDEFAULT;

  /**
   * The default value of the '{@link #isPassDTMF() <em>Pass DTMF</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPassDTMF()
   * @generated
   * @ordered
   */
  protected static final boolean PASS_DTMF_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPassDTMF() <em>Pass DTMF</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPassDTMF()
   * @generated
   * @ordered
   */
  protected boolean passDTMF = PASS_DTMF_EDEFAULT;

  /**
   * The default value of the '{@link #isAnnounceJoinLeave() <em>Announce Join Leave</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnnounceJoinLeave()
   * @generated
   * @ordered
   */
  protected static final boolean ANNOUNCE_JOIN_LEAVE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnnounceJoinLeave() <em>Announce Join Leave</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnnounceJoinLeave()
   * @generated
   * @ordered
   */
  protected boolean announceJoinLeave = ANNOUNCE_JOIN_LEAVE_EDEFAULT;

  /**
   * The default value of the '{@link #isAnnounceJoinLeaveNoReview() <em>Announce Join Leave No Review</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnnounceJoinLeaveNoReview()
   * @generated
   * @ordered
   */
  protected static final boolean ANNOUNCE_JOIN_LEAVE_NO_REVIEW_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAnnounceJoinLeaveNoReview() <em>Announce Join Leave No Review</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAnnounceJoinLeaveNoReview()
   * @generated
   * @ordered
   */
  protected boolean announceJoinLeaveNoReview = ANNOUNCE_JOIN_LEAVE_NO_REVIEW_EDEFAULT;

  /**
   * The default value of the '{@link #isUseMusicOnHold() <em>Use Music On Hold</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseMusicOnHold()
   * @generated
   * @ordered
   */
  protected static final boolean USE_MUSIC_ON_HOLD_EDEFAULT = true;

  /**
   * The cached value of the '{@link #isUseMusicOnHold() <em>Use Music On Hold</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isUseMusicOnHold()
   * @generated
   * @ordered
   */
  protected boolean useMusicOnHold = USE_MUSIC_ON_HOLD_EDEFAULT;

  /**
   * The default value of the '{@link #isMonitorOnlyMode() <em>Monitor Only Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMonitorOnlyMode()
   * @generated
   * @ordered
   */
  protected static final boolean MONITOR_ONLY_MODE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isMonitorOnlyMode() <em>Monitor Only Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isMonitorOnlyMode()
   * @generated
   * @ordered
   */
  protected boolean monitorOnlyMode = MONITOR_ONLY_MODE_EDEFAULT;

  /**
   * The default value of the '{@link #isAllowPoundUserExit() <em>Allow Pound User Exit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllowPoundUserExit()
   * @generated
   * @ordered
   */
  protected static final boolean ALLOW_POUND_USER_EXIT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAllowPoundUserExit() <em>Allow Pound User Exit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAllowPoundUserExit()
   * @generated
   * @ordered
   */
  protected boolean allowPoundUserExit = ALLOW_POUND_USER_EXIT_EDEFAULT;

  /**
   * The default value of the '{@link #isAlwaysPromptForPin() <em>Always Prompt For Pin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAlwaysPromptForPin()
   * @generated
   * @ordered
   */
  protected static final boolean ALWAYS_PROMPT_FOR_PIN_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAlwaysPromptForPin() <em>Always Prompt For Pin</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAlwaysPromptForPin()
   * @generated
   * @ordered
   */
  protected boolean alwaysPromptForPin = ALWAYS_PROMPT_FOR_PIN_EDEFAULT;

  /**
   * The default value of the '{@link #isQuietMode() <em>Quiet Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isQuietMode()
   * @generated
   * @ordered
   */
  protected static final boolean QUIET_MODE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isQuietMode() <em>Quiet Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isQuietMode()
   * @generated
   * @ordered
   */
  protected boolean quietMode = QUIET_MODE_EDEFAULT;

  /**
   * The default value of the '{@link #isRecordConference() <em>Record Conference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRecordConference()
   * @generated
   * @ordered
   */
  protected static final boolean RECORD_CONFERENCE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isRecordConference() <em>Record Conference</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isRecordConference()
   * @generated
   * @ordered
   */
  protected boolean recordConference = RECORD_CONFERENCE_EDEFAULT;

  /**
   * The default value of the '{@link #isPlayMenuOnStar() <em>Play Menu On Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPlayMenuOnStar()
   * @generated
   * @ordered
   */
  protected static final boolean PLAY_MENU_ON_STAR_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isPlayMenuOnStar() <em>Play Menu On Star</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isPlayMenuOnStar()
   * @generated
   * @ordered
   */
  protected boolean playMenuOnStar = PLAY_MENU_ON_STAR_EDEFAULT;

  /**
   * The default value of the '{@link #isTalkOnlyMode() <em>Talk Only Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTalkOnlyMode()
   * @generated
   * @ordered
   */
  protected static final boolean TALK_ONLY_MODE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTalkOnlyMode() <em>Talk Only Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTalkOnlyMode()
   * @generated
   * @ordered
   */
  protected boolean talkOnlyMode = TALK_ONLY_MODE_EDEFAULT;

  /**
   * The default value of the '{@link #isTalkerDetection() <em>Talker Detection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTalkerDetection()
   * @generated
   * @ordered
   */
  protected static final boolean TALKER_DETECTION_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isTalkerDetection() <em>Talker Detection</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isTalkerDetection()
   * @generated
   * @ordered
   */
  protected boolean talkerDetection = TALKER_DETECTION_EDEFAULT;

  /**
   * The default value of the '{@link #isVideoMode() <em>Video Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVideoMode()
   * @generated
   * @ordered
   */
  protected static final boolean VIDEO_MODE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isVideoMode() <em>Video Mode</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isVideoMode()
   * @generated
   * @ordered
   */
  protected boolean videoMode = VIDEO_MODE_EDEFAULT;

  /**
   * The default value of the '{@link #isWaitForMarkedUser() <em>Wait For Marked User</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWaitForMarkedUser()
   * @generated
   * @ordered
   */
  protected static final boolean WAIT_FOR_MARKED_USER_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isWaitForMarkedUser() <em>Wait For Marked User</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isWaitForMarkedUser()
   * @generated
   * @ordered
   */
  protected boolean waitForMarkedUser = WAIT_FOR_MARKED_USER_EDEFAULT;

  /**
   * The default value of the '{@link #isExitOnExtensionEntered() <em>Exit On Extension Entered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExitOnExtensionEntered()
   * @generated
   * @ordered
   */
  protected static final boolean EXIT_ON_EXTENSION_ENTERED_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isExitOnExtensionEntered() <em>Exit On Extension Entered</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isExitOnExtensionEntered()
   * @generated
   * @ordered
   */
  protected boolean exitOnExtensionEntered = EXIT_ON_EXTENSION_ENTERED_EDEFAULT;

  /**
   * The default value of the '{@link #isCloseOnLastMarkedUserExit() <em>Close On Last Marked User Exit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCloseOnLastMarkedUserExit()
   * @generated
   * @ordered
   */
  protected static final boolean CLOSE_ON_LAST_MARKED_USER_EXIT_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isCloseOnLastMarkedUserExit() <em>Close On Last Marked User Exit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isCloseOnLastMarkedUserExit()
   * @generated
   * @ordered
   */
  protected boolean closeOnLastMarkedUserExit = CLOSE_ON_LAST_MARKED_USER_EXIT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected MeetMeImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass() {
    return ActionstepPackage.Literals.MEET_ME;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call getCall1() {
    if (call1 != null && call1.eIsProxy()) {
      InternalEObject oldCall1 = (InternalEObject)call1;
      call1 = (Call)eResolveProxy(oldCall1);
      if (call1 != oldCall1) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.MEET_ME__CALL1, oldCall1, call1));
      }
    }
    return call1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call basicGetCall1() {
    return call1;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCall1(Call newCall1) {
    Call oldCall1 = call1;
    call1 = newCall1;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__CALL1, oldCall1, call1));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getProductId() {
    return productId;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProductId(String newProductId) {
    String oldProductId = productId;
    productId = newProductId;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__PRODUCT_ID, oldProductId, productId));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPaused() {
    return paused;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPaused(boolean newPaused) {
    boolean oldPaused = paused;
    paused = newPaused;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__PAUSED, oldPaused, paused));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isActive() {
    return active;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setActive(boolean newActive) {
    boolean oldActive = active;
    active = newActive;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__ACTIVE, oldActive, active));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Output> getOutputs() {
    if (outputs == null) {
      outputs = new EObjectContainmentWithInverseEList<Output>(Output.class, this, ActionstepPackage.MEET_ME__OUTPUTS, ActionStepPackage.OUTPUT__PARENT);
    }
    return outputs;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Saflet getSaflet() {
    if (eContainerFeatureID != ActionstepPackage.MEET_ME__SAFLET) return null;
    return (Saflet)eContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSaflet(Saflet newSaflet, NotificationChain msgs) {
    msgs = eBasicSetContainer((InternalEObject)newSaflet, ActionstepPackage.MEET_ME__SAFLET, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSaflet(Saflet newSaflet) {
    if (newSaflet != eInternalContainer() || (eContainerFeatureID != ActionstepPackage.MEET_ME__SAFLET && newSaflet != null)) {
      if (EcoreUtil.isAncestor(this, newSaflet))
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
        msgs = eBasicRemoveFromContainer(msgs);
      if (newSaflet != null)
        msgs = ((InternalEObject)newSaflet).eInverseAdd(this, SafletPackage.SAFLET__ACTIONSTEPS, Saflet.class, msgs);
      msgs = basicSetSaflet(newSaflet, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__SAFLET, newSaflet, newSaflet));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Output getDefaultOutput() {
    if (defaultOutput != null && defaultOutput.eIsProxy()) {
      InternalEObject oldDefaultOutput = (InternalEObject)defaultOutput;
      defaultOutput = (Output)eResolveProxy(oldDefaultOutput);
      if (defaultOutput != oldDefaultOutput) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.MEET_ME__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
      }
    }
    return defaultOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Output basicGetDefaultOutput() {
    return defaultOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDefaultOutput(Output newDefaultOutput) {
    Output oldDefaultOutput = defaultOutput;
    defaultOutput = newDefaultOutput;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__DEFAULT_OUTPUT, oldDefaultOutput, defaultOutput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Output getErrorOutput() {
    if (errorOutput != null && errorOutput.eIsProxy()) {
      InternalEObject oldErrorOutput = (InternalEObject)errorOutput;
      errorOutput = (Output)eResolveProxy(oldErrorOutput);
      if (errorOutput != oldErrorOutput) {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActionstepPackage.MEET_ME__ERROR_OUTPUT, oldErrorOutput, errorOutput));
      }
    }
    return errorOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Output basicGetErrorOutput() {
    return errorOutput;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setErrorOutput(Output newErrorOutput) {
    Output oldErrorOutput = errorOutput;
    errorOutput = newErrorOutput;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__ERROR_OUTPUT, oldErrorOutput, errorOutput));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getConferenceNumber() {
    return conferenceNumber;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetConferenceNumber(DynamicValue newConferenceNumber, NotificationChain msgs) {
    DynamicValue oldConferenceNumber = conferenceNumber;
    conferenceNumber = newConferenceNumber;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__CONFERENCE_NUMBER, oldConferenceNumber, newConferenceNumber);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setConferenceNumber(DynamicValue newConferenceNumber) {
    if (newConferenceNumber != conferenceNumber) {
      NotificationChain msgs = null;
      if (conferenceNumber != null)
        msgs = ((InternalEObject)conferenceNumber).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.MEET_ME__CONFERENCE_NUMBER, null, msgs);
      if (newConferenceNumber != null)
        msgs = ((InternalEObject)newConferenceNumber).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.MEET_ME__CONFERENCE_NUMBER, null, msgs);
      msgs = basicSetConferenceNumber(newConferenceNumber, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__CONFERENCE_NUMBER, newConferenceNumber, newConferenceNumber));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DynamicValue getPin() {
    return pin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPin(DynamicValue newPin, NotificationChain msgs) {
    DynamicValue oldPin = pin;
    pin = newPin;
    if (eNotificationRequired()) {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__PIN, oldPin, newPin);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPin(DynamicValue newPin) {
    if (newPin != pin) {
      NotificationChain msgs = null;
      if (pin != null)
        msgs = ((InternalEObject)pin).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.MEET_ME__PIN, null, msgs);
      if (newPin != null)
        msgs = ((InternalEObject)newPin).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ActionstepPackage.MEET_ME__PIN, null, msgs);
      msgs = basicSetPin(newPin, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__PIN, newPin, newPin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getBackgroundScriptAgi() {
    return backgroundScriptAgi;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBackgroundScriptAgi(String newBackgroundScriptAgi) {
    String oldBackgroundScriptAgi = backgroundScriptAgi;
    backgroundScriptAgi = newBackgroundScriptAgi;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__BACKGROUND_SCRIPT_AGI, oldBackgroundScriptAgi, backgroundScriptAgi));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRecordingFilename() {
    return recordingFilename;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRecordingFilename(String newRecordingFilename) {
    String oldRecordingFilename = recordingFilename;
    recordingFilename = newRecordingFilename;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__RECORDING_FILENAME, oldRecordingFilename, recordingFilename));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getRecordingFormat() {
    return recordingFormat;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRecordingFormat(String newRecordingFormat) {
    String oldRecordingFormat = recordingFormat;
    recordingFormat = newRecordingFormat;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__RECORDING_FORMAT, oldRecordingFormat, recordingFormat));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAloneMessageEnabled() {
    return aloneMessageEnabled;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAloneMessageEnabled(boolean newAloneMessageEnabled) {
    boolean oldAloneMessageEnabled = aloneMessageEnabled;
    aloneMessageEnabled = newAloneMessageEnabled;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__ALONE_MESSAGE_ENABLED, oldAloneMessageEnabled, aloneMessageEnabled));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAdminMode() {
    return adminMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAdminMode(boolean newAdminMode) {
    boolean oldAdminMode = adminMode;
    adminMode = newAdminMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__ADMIN_MODE, oldAdminMode, adminMode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUseAGIScript() {
    return useAGIScript;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUseAGIScript(boolean newUseAGIScript) {
    boolean oldUseAGIScript = useAGIScript;
    useAGIScript = newUseAGIScript;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__USE_AGI_SCRIPT, oldUseAGIScript, useAGIScript));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnnounceCount() {
    return announceCount;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnounceCount(boolean newAnnounceCount) {
    boolean oldAnnounceCount = announceCount;
    announceCount = newAnnounceCount;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__ANNOUNCE_COUNT, oldAnnounceCount, announceCount));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isDynamicallyAddConference() {
    return dynamicallyAddConference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDynamicallyAddConference(boolean newDynamicallyAddConference) {
    boolean oldDynamicallyAddConference = dynamicallyAddConference;
    dynamicallyAddConference = newDynamicallyAddConference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__DYNAMICALLY_ADD_CONFERENCE, oldDynamicallyAddConference, dynamicallyAddConference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSelectEmptyConference() {
    return selectEmptyConference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelectEmptyConference(boolean newSelectEmptyConference) {
    boolean oldSelectEmptyConference = selectEmptyConference;
    selectEmptyConference = newSelectEmptyConference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__SELECT_EMPTY_CONFERENCE, oldSelectEmptyConference, selectEmptyConference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isSelectEmptyPinlessConference() {
    return selectEmptyPinlessConference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelectEmptyPinlessConference(boolean newSelectEmptyPinlessConference) {
    boolean oldSelectEmptyPinlessConference = selectEmptyPinlessConference;
    selectEmptyPinlessConference = newSelectEmptyPinlessConference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__SELECT_EMPTY_PINLESS_CONFERENCE, oldSelectEmptyPinlessConference, selectEmptyPinlessConference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPassDTMF() {
    return passDTMF;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPassDTMF(boolean newPassDTMF) {
    boolean oldPassDTMF = passDTMF;
    passDTMF = newPassDTMF;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__PASS_DTMF, oldPassDTMF, passDTMF));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnnounceJoinLeave() {
    return announceJoinLeave;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnounceJoinLeave(boolean newAnnounceJoinLeave) {
    boolean oldAnnounceJoinLeave = announceJoinLeave;
    announceJoinLeave = newAnnounceJoinLeave;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__ANNOUNCE_JOIN_LEAVE, oldAnnounceJoinLeave, announceJoinLeave));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAnnounceJoinLeaveNoReview() {
    return announceJoinLeaveNoReview;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAnnounceJoinLeaveNoReview(boolean newAnnounceJoinLeaveNoReview) {
    boolean oldAnnounceJoinLeaveNoReview = announceJoinLeaveNoReview;
    announceJoinLeaveNoReview = newAnnounceJoinLeaveNoReview;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__ANNOUNCE_JOIN_LEAVE_NO_REVIEW, oldAnnounceJoinLeaveNoReview, announceJoinLeaveNoReview));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isUseMusicOnHold() {
    return useMusicOnHold;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setUseMusicOnHold(boolean newUseMusicOnHold) {
    boolean oldUseMusicOnHold = useMusicOnHold;
    useMusicOnHold = newUseMusicOnHold;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__USE_MUSIC_ON_HOLD, oldUseMusicOnHold, useMusicOnHold));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isMonitorOnlyMode() {
    return monitorOnlyMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMonitorOnlyMode(boolean newMonitorOnlyMode) {
    boolean oldMonitorOnlyMode = monitorOnlyMode;
    monitorOnlyMode = newMonitorOnlyMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__MONITOR_ONLY_MODE, oldMonitorOnlyMode, monitorOnlyMode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAllowPoundUserExit() {
    return allowPoundUserExit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAllowPoundUserExit(boolean newAllowPoundUserExit) {
    boolean oldAllowPoundUserExit = allowPoundUserExit;
    allowPoundUserExit = newAllowPoundUserExit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__ALLOW_POUND_USER_EXIT, oldAllowPoundUserExit, allowPoundUserExit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAlwaysPromptForPin() {
    return alwaysPromptForPin;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAlwaysPromptForPin(boolean newAlwaysPromptForPin) {
    boolean oldAlwaysPromptForPin = alwaysPromptForPin;
    alwaysPromptForPin = newAlwaysPromptForPin;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__ALWAYS_PROMPT_FOR_PIN, oldAlwaysPromptForPin, alwaysPromptForPin));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isQuietMode() {
    return quietMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQuietMode(boolean newQuietMode) {
    boolean oldQuietMode = quietMode;
    quietMode = newQuietMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__QUIET_MODE, oldQuietMode, quietMode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isRecordConference() {
    return recordConference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setRecordConference(boolean newRecordConference) {
    boolean oldRecordConference = recordConference;
    recordConference = newRecordConference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__RECORD_CONFERENCE, oldRecordConference, recordConference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isPlayMenuOnStar() {
    return playMenuOnStar;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPlayMenuOnStar(boolean newPlayMenuOnStar) {
    boolean oldPlayMenuOnStar = playMenuOnStar;
    playMenuOnStar = newPlayMenuOnStar;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__PLAY_MENU_ON_STAR, oldPlayMenuOnStar, playMenuOnStar));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTalkOnlyMode() {
    return talkOnlyMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTalkOnlyMode(boolean newTalkOnlyMode) {
    boolean oldTalkOnlyMode = talkOnlyMode;
    talkOnlyMode = newTalkOnlyMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__TALK_ONLY_MODE, oldTalkOnlyMode, talkOnlyMode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isTalkerDetection() {
    return talkerDetection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTalkerDetection(boolean newTalkerDetection) {
    boolean oldTalkerDetection = talkerDetection;
    talkerDetection = newTalkerDetection;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__TALKER_DETECTION, oldTalkerDetection, talkerDetection));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isVideoMode() {
    return videoMode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setVideoMode(boolean newVideoMode) {
    boolean oldVideoMode = videoMode;
    videoMode = newVideoMode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__VIDEO_MODE, oldVideoMode, videoMode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isWaitForMarkedUser() {
    return waitForMarkedUser;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setWaitForMarkedUser(boolean newWaitForMarkedUser) {
    boolean oldWaitForMarkedUser = waitForMarkedUser;
    waitForMarkedUser = newWaitForMarkedUser;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__WAIT_FOR_MARKED_USER, oldWaitForMarkedUser, waitForMarkedUser));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isExitOnExtensionEntered() {
    return exitOnExtensionEntered;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExitOnExtensionEntered(boolean newExitOnExtensionEntered) {
    boolean oldExitOnExtensionEntered = exitOnExtensionEntered;
    exitOnExtensionEntered = newExitOnExtensionEntered;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__EXIT_ON_EXTENSION_ENTERED, oldExitOnExtensionEntered, exitOnExtensionEntered));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isCloseOnLastMarkedUserExit() {
    return closeOnLastMarkedUserExit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCloseOnLastMarkedUserExit(boolean newCloseOnLastMarkedUserExit) {
    boolean oldCloseOnLastMarkedUserExit = closeOnLastMarkedUserExit;
    closeOnLastMarkedUserExit = newCloseOnLastMarkedUserExit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ActionstepPackage.MEET_ME__CLOSE_ON_LAST_MARKED_USER_EXIT, oldCloseOnLastMarkedUserExit, closeOnLastMarkedUserExit));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void beginProcessing(SafletContext context) throws ActionStepException {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object executeScript(String scriptName, String scriptText) throws SafletScriptException {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void handleException(SafletContext context, Exception e) throws ActionStepException {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Object resolveDynamicValue(DynamicValue dynamicValue, SafletContext context) throws ActionStepException {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createDefaultOutputs() {
    // TODO: implement this method
    // Ensure that you remove @generated or mark it @generated NOT
    throw new UnsupportedOperationException();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionstepPackage.MEET_ME__OUTPUTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputs()).basicAdd(otherEnd, msgs);
      case ActionstepPackage.MEET_ME__SAFLET:
        if (eInternalContainer() != null)
          msgs = eBasicRemoveFromContainer(msgs);
        return basicSetSaflet((Saflet)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
    switch (featureID) {
      case ActionstepPackage.MEET_ME__OUTPUTS:
        return ((InternalEList<?>)getOutputs()).basicRemove(otherEnd, msgs);
      case ActionstepPackage.MEET_ME__SAFLET:
        return basicSetSaflet(null, msgs);
      case ActionstepPackage.MEET_ME__CONFERENCE_NUMBER:
        return basicSetConferenceNumber(null, msgs);
      case ActionstepPackage.MEET_ME__PIN:
        return basicSetPin(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
    switch (eContainerFeatureID) {
      case ActionstepPackage.MEET_ME__SAFLET:
        return eInternalContainer().eInverseRemove(this, SafletPackage.SAFLET__ACTIONSTEPS, Saflet.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID) {
      case ActionstepPackage.MEET_ME__CALL1:
        if (resolve) return getCall1();
        return basicGetCall1();
      case ActionstepPackage.MEET_ME__PRODUCT_ID:
        return getProductId();
      case ActionstepPackage.MEET_ME__PAUSED:
        return isPaused() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__ACTIVE:
        return isActive() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__OUTPUTS:
        return getOutputs();
      case ActionstepPackage.MEET_ME__NAME:
        return getName();
      case ActionstepPackage.MEET_ME__SAFLET:
        return getSaflet();
      case ActionstepPackage.MEET_ME__DEFAULT_OUTPUT:
        if (resolve) return getDefaultOutput();
        return basicGetDefaultOutput();
      case ActionstepPackage.MEET_ME__ERROR_OUTPUT:
        if (resolve) return getErrorOutput();
        return basicGetErrorOutput();
      case ActionstepPackage.MEET_ME__CONFERENCE_NUMBER:
        return getConferenceNumber();
      case ActionstepPackage.MEET_ME__PIN:
        return getPin();
      case ActionstepPackage.MEET_ME__BACKGROUND_SCRIPT_AGI:
        return getBackgroundScriptAgi();
      case ActionstepPackage.MEET_ME__RECORDING_FILENAME:
        return getRecordingFilename();
      case ActionstepPackage.MEET_ME__RECORDING_FORMAT:
        return getRecordingFormat();
      case ActionstepPackage.MEET_ME__ALONE_MESSAGE_ENABLED:
        return isAloneMessageEnabled() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__ADMIN_MODE:
        return isAdminMode() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__USE_AGI_SCRIPT:
        return isUseAGIScript() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__ANNOUNCE_COUNT:
        return isAnnounceCount() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__DYNAMICALLY_ADD_CONFERENCE:
        return isDynamicallyAddConference() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__SELECT_EMPTY_CONFERENCE:
        return isSelectEmptyConference() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__SELECT_EMPTY_PINLESS_CONFERENCE:
        return isSelectEmptyPinlessConference() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__PASS_DTMF:
        return isPassDTMF() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__ANNOUNCE_JOIN_LEAVE:
        return isAnnounceJoinLeave() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__ANNOUNCE_JOIN_LEAVE_NO_REVIEW:
        return isAnnounceJoinLeaveNoReview() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__USE_MUSIC_ON_HOLD:
        return isUseMusicOnHold() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__MONITOR_ONLY_MODE:
        return isMonitorOnlyMode() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__ALLOW_POUND_USER_EXIT:
        return isAllowPoundUserExit() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__ALWAYS_PROMPT_FOR_PIN:
        return isAlwaysPromptForPin() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__QUIET_MODE:
        return isQuietMode() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__RECORD_CONFERENCE:
        return isRecordConference() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__PLAY_MENU_ON_STAR:
        return isPlayMenuOnStar() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__TALK_ONLY_MODE:
        return isTalkOnlyMode() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__TALKER_DETECTION:
        return isTalkerDetection() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__VIDEO_MODE:
        return isVideoMode() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__WAIT_FOR_MARKED_USER:
        return isWaitForMarkedUser() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__EXIT_ON_EXTENSION_ENTERED:
        return isExitOnExtensionEntered() ? Boolean.TRUE : Boolean.FALSE;
      case ActionstepPackage.MEET_ME__CLOSE_ON_LAST_MARKED_USER_EXIT:
        return isCloseOnLastMarkedUserExit() ? Boolean.TRUE : Boolean.FALSE;
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
      case ActionstepPackage.MEET_ME__CALL1:
        setCall1((Call)newValue);
        return;
      case ActionstepPackage.MEET_ME__PRODUCT_ID:
        setProductId((String)newValue);
        return;
      case ActionstepPackage.MEET_ME__PAUSED:
        setPaused(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__ACTIVE:
        setActive(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__OUTPUTS:
        getOutputs().clear();
        getOutputs().addAll((Collection<? extends Output>)newValue);
        return;
      case ActionstepPackage.MEET_ME__NAME:
        setName((String)newValue);
        return;
      case ActionstepPackage.MEET_ME__SAFLET:
        setSaflet((Saflet)newValue);
        return;
      case ActionstepPackage.MEET_ME__DEFAULT_OUTPUT:
        setDefaultOutput((Output)newValue);
        return;
      case ActionstepPackage.MEET_ME__ERROR_OUTPUT:
        setErrorOutput((Output)newValue);
        return;
      case ActionstepPackage.MEET_ME__CONFERENCE_NUMBER:
        setConferenceNumber((DynamicValue)newValue);
        return;
      case ActionstepPackage.MEET_ME__PIN:
        setPin((DynamicValue)newValue);
        return;
      case ActionstepPackage.MEET_ME__BACKGROUND_SCRIPT_AGI:
        setBackgroundScriptAgi((String)newValue);
        return;
      case ActionstepPackage.MEET_ME__RECORDING_FILENAME:
        setRecordingFilename((String)newValue);
        return;
      case ActionstepPackage.MEET_ME__RECORDING_FORMAT:
        setRecordingFormat((String)newValue);
        return;
      case ActionstepPackage.MEET_ME__ALONE_MESSAGE_ENABLED:
        setAloneMessageEnabled(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__ADMIN_MODE:
        setAdminMode(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__USE_AGI_SCRIPT:
        setUseAGIScript(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__ANNOUNCE_COUNT:
        setAnnounceCount(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__DYNAMICALLY_ADD_CONFERENCE:
        setDynamicallyAddConference(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__SELECT_EMPTY_CONFERENCE:
        setSelectEmptyConference(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__SELECT_EMPTY_PINLESS_CONFERENCE:
        setSelectEmptyPinlessConference(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__PASS_DTMF:
        setPassDTMF(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__ANNOUNCE_JOIN_LEAVE:
        setAnnounceJoinLeave(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__ANNOUNCE_JOIN_LEAVE_NO_REVIEW:
        setAnnounceJoinLeaveNoReview(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__USE_MUSIC_ON_HOLD:
        setUseMusicOnHold(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__MONITOR_ONLY_MODE:
        setMonitorOnlyMode(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__ALLOW_POUND_USER_EXIT:
        setAllowPoundUserExit(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__ALWAYS_PROMPT_FOR_PIN:
        setAlwaysPromptForPin(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__QUIET_MODE:
        setQuietMode(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__RECORD_CONFERENCE:
        setRecordConference(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__PLAY_MENU_ON_STAR:
        setPlayMenuOnStar(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__TALK_ONLY_MODE:
        setTalkOnlyMode(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__TALKER_DETECTION:
        setTalkerDetection(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__VIDEO_MODE:
        setVideoMode(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__WAIT_FOR_MARKED_USER:
        setWaitForMarkedUser(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__EXIT_ON_EXTENSION_ENTERED:
        setExitOnExtensionEntered(((Boolean)newValue).booleanValue());
        return;
      case ActionstepPackage.MEET_ME__CLOSE_ON_LAST_MARKED_USER_EXIT:
        setCloseOnLastMarkedUserExit(((Boolean)newValue).booleanValue());
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
      case ActionstepPackage.MEET_ME__CALL1:
        setCall1((Call)null);
        return;
      case ActionstepPackage.MEET_ME__PRODUCT_ID:
        setProductId(PRODUCT_ID_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__PAUSED:
        setPaused(PAUSED_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__ACTIVE:
        setActive(ACTIVE_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__OUTPUTS:
        getOutputs().clear();
        return;
      case ActionstepPackage.MEET_ME__NAME:
        setName(NAME_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__SAFLET:
        setSaflet((Saflet)null);
        return;
      case ActionstepPackage.MEET_ME__DEFAULT_OUTPUT:
        setDefaultOutput((Output)null);
        return;
      case ActionstepPackage.MEET_ME__ERROR_OUTPUT:
        setErrorOutput((Output)null);
        return;
      case ActionstepPackage.MEET_ME__CONFERENCE_NUMBER:
        setConferenceNumber((DynamicValue)null);
        return;
      case ActionstepPackage.MEET_ME__PIN:
        setPin((DynamicValue)null);
        return;
      case ActionstepPackage.MEET_ME__BACKGROUND_SCRIPT_AGI:
        setBackgroundScriptAgi(BACKGROUND_SCRIPT_AGI_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__RECORDING_FILENAME:
        setRecordingFilename(RECORDING_FILENAME_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__RECORDING_FORMAT:
        setRecordingFormat(RECORDING_FORMAT_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__ALONE_MESSAGE_ENABLED:
        setAloneMessageEnabled(ALONE_MESSAGE_ENABLED_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__ADMIN_MODE:
        setAdminMode(ADMIN_MODE_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__USE_AGI_SCRIPT:
        setUseAGIScript(USE_AGI_SCRIPT_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__ANNOUNCE_COUNT:
        setAnnounceCount(ANNOUNCE_COUNT_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__DYNAMICALLY_ADD_CONFERENCE:
        setDynamicallyAddConference(DYNAMICALLY_ADD_CONFERENCE_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__SELECT_EMPTY_CONFERENCE:
        setSelectEmptyConference(SELECT_EMPTY_CONFERENCE_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__SELECT_EMPTY_PINLESS_CONFERENCE:
        setSelectEmptyPinlessConference(SELECT_EMPTY_PINLESS_CONFERENCE_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__PASS_DTMF:
        setPassDTMF(PASS_DTMF_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__ANNOUNCE_JOIN_LEAVE:
        setAnnounceJoinLeave(ANNOUNCE_JOIN_LEAVE_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__ANNOUNCE_JOIN_LEAVE_NO_REVIEW:
        setAnnounceJoinLeaveNoReview(ANNOUNCE_JOIN_LEAVE_NO_REVIEW_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__USE_MUSIC_ON_HOLD:
        setUseMusicOnHold(USE_MUSIC_ON_HOLD_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__MONITOR_ONLY_MODE:
        setMonitorOnlyMode(MONITOR_ONLY_MODE_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__ALLOW_POUND_USER_EXIT:
        setAllowPoundUserExit(ALLOW_POUND_USER_EXIT_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__ALWAYS_PROMPT_FOR_PIN:
        setAlwaysPromptForPin(ALWAYS_PROMPT_FOR_PIN_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__QUIET_MODE:
        setQuietMode(QUIET_MODE_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__RECORD_CONFERENCE:
        setRecordConference(RECORD_CONFERENCE_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__PLAY_MENU_ON_STAR:
        setPlayMenuOnStar(PLAY_MENU_ON_STAR_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__TALK_ONLY_MODE:
        setTalkOnlyMode(TALK_ONLY_MODE_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__TALKER_DETECTION:
        setTalkerDetection(TALKER_DETECTION_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__VIDEO_MODE:
        setVideoMode(VIDEO_MODE_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__WAIT_FOR_MARKED_USER:
        setWaitForMarkedUser(WAIT_FOR_MARKED_USER_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__EXIT_ON_EXTENSION_ENTERED:
        setExitOnExtensionEntered(EXIT_ON_EXTENSION_ENTERED_EDEFAULT);
        return;
      case ActionstepPackage.MEET_ME__CLOSE_ON_LAST_MARKED_USER_EXIT:
        setCloseOnLastMarkedUserExit(CLOSE_ON_LAST_MARKED_USER_EXIT_EDEFAULT);
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
      case ActionstepPackage.MEET_ME__CALL1:
        return call1 != null;
      case ActionstepPackage.MEET_ME__PRODUCT_ID:
        return PRODUCT_ID_EDEFAULT == null ? productId != null : !PRODUCT_ID_EDEFAULT.equals(productId);
      case ActionstepPackage.MEET_ME__PAUSED:
        return paused != PAUSED_EDEFAULT;
      case ActionstepPackage.MEET_ME__ACTIVE:
        return active != ACTIVE_EDEFAULT;
      case ActionstepPackage.MEET_ME__OUTPUTS:
        return outputs != null && !outputs.isEmpty();
      case ActionstepPackage.MEET_ME__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case ActionstepPackage.MEET_ME__SAFLET:
        return getSaflet() != null;
      case ActionstepPackage.MEET_ME__DEFAULT_OUTPUT:
        return defaultOutput != null;
      case ActionstepPackage.MEET_ME__ERROR_OUTPUT:
        return errorOutput != null;
      case ActionstepPackage.MEET_ME__CONFERENCE_NUMBER:
        return conferenceNumber != null;
      case ActionstepPackage.MEET_ME__PIN:
        return pin != null;
      case ActionstepPackage.MEET_ME__BACKGROUND_SCRIPT_AGI:
        return BACKGROUND_SCRIPT_AGI_EDEFAULT == null ? backgroundScriptAgi != null : !BACKGROUND_SCRIPT_AGI_EDEFAULT.equals(backgroundScriptAgi);
      case ActionstepPackage.MEET_ME__RECORDING_FILENAME:
        return RECORDING_FILENAME_EDEFAULT == null ? recordingFilename != null : !RECORDING_FILENAME_EDEFAULT.equals(recordingFilename);
      case ActionstepPackage.MEET_ME__RECORDING_FORMAT:
        return RECORDING_FORMAT_EDEFAULT == null ? recordingFormat != null : !RECORDING_FORMAT_EDEFAULT.equals(recordingFormat);
      case ActionstepPackage.MEET_ME__ALONE_MESSAGE_ENABLED:
        return aloneMessageEnabled != ALONE_MESSAGE_ENABLED_EDEFAULT;
      case ActionstepPackage.MEET_ME__ADMIN_MODE:
        return adminMode != ADMIN_MODE_EDEFAULT;
      case ActionstepPackage.MEET_ME__USE_AGI_SCRIPT:
        return useAGIScript != USE_AGI_SCRIPT_EDEFAULT;
      case ActionstepPackage.MEET_ME__ANNOUNCE_COUNT:
        return announceCount != ANNOUNCE_COUNT_EDEFAULT;
      case ActionstepPackage.MEET_ME__DYNAMICALLY_ADD_CONFERENCE:
        return dynamicallyAddConference != DYNAMICALLY_ADD_CONFERENCE_EDEFAULT;
      case ActionstepPackage.MEET_ME__SELECT_EMPTY_CONFERENCE:
        return selectEmptyConference != SELECT_EMPTY_CONFERENCE_EDEFAULT;
      case ActionstepPackage.MEET_ME__SELECT_EMPTY_PINLESS_CONFERENCE:
        return selectEmptyPinlessConference != SELECT_EMPTY_PINLESS_CONFERENCE_EDEFAULT;
      case ActionstepPackage.MEET_ME__PASS_DTMF:
        return passDTMF != PASS_DTMF_EDEFAULT;
      case ActionstepPackage.MEET_ME__ANNOUNCE_JOIN_LEAVE:
        return announceJoinLeave != ANNOUNCE_JOIN_LEAVE_EDEFAULT;
      case ActionstepPackage.MEET_ME__ANNOUNCE_JOIN_LEAVE_NO_REVIEW:
        return announceJoinLeaveNoReview != ANNOUNCE_JOIN_LEAVE_NO_REVIEW_EDEFAULT;
      case ActionstepPackage.MEET_ME__USE_MUSIC_ON_HOLD:
        return useMusicOnHold != USE_MUSIC_ON_HOLD_EDEFAULT;
      case ActionstepPackage.MEET_ME__MONITOR_ONLY_MODE:
        return monitorOnlyMode != MONITOR_ONLY_MODE_EDEFAULT;
      case ActionstepPackage.MEET_ME__ALLOW_POUND_USER_EXIT:
        return allowPoundUserExit != ALLOW_POUND_USER_EXIT_EDEFAULT;
      case ActionstepPackage.MEET_ME__ALWAYS_PROMPT_FOR_PIN:
        return alwaysPromptForPin != ALWAYS_PROMPT_FOR_PIN_EDEFAULT;
      case ActionstepPackage.MEET_ME__QUIET_MODE:
        return quietMode != QUIET_MODE_EDEFAULT;
      case ActionstepPackage.MEET_ME__RECORD_CONFERENCE:
        return recordConference != RECORD_CONFERENCE_EDEFAULT;
      case ActionstepPackage.MEET_ME__PLAY_MENU_ON_STAR:
        return playMenuOnStar != PLAY_MENU_ON_STAR_EDEFAULT;
      case ActionstepPackage.MEET_ME__TALK_ONLY_MODE:
        return talkOnlyMode != TALK_ONLY_MODE_EDEFAULT;
      case ActionstepPackage.MEET_ME__TALKER_DETECTION:
        return talkerDetection != TALKER_DETECTION_EDEFAULT;
      case ActionstepPackage.MEET_ME__VIDEO_MODE:
        return videoMode != VIDEO_MODE_EDEFAULT;
      case ActionstepPackage.MEET_ME__WAIT_FOR_MARKED_USER:
        return waitForMarkedUser != WAIT_FOR_MARKED_USER_EDEFAULT;
      case ActionstepPackage.MEET_ME__EXIT_ON_EXTENSION_ENTERED:
        return exitOnExtensionEntered != EXIT_ON_EXTENSION_ENTERED_EDEFAULT;
      case ActionstepPackage.MEET_ME__CLOSE_ON_LAST_MARKED_USER_EXIT:
        return closeOnLastMarkedUserExit != CLOSE_ON_LAST_MARKED_USER_EXIT_EDEFAULT;
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
    if (baseClass == ProductIdentifiable.class) {
      switch (derivedFeatureID) {
        case ActionstepPackage.MEET_ME__PRODUCT_ID: return CorePackage.PRODUCT_IDENTIFIABLE__PRODUCT_ID;
        default: return -1;
      }
    }
    if (baseClass == ActionStep.class) {
      switch (derivedFeatureID) {
        case ActionstepPackage.MEET_ME__PAUSED: return ActionStepPackage.ACTION_STEP__PAUSED;
        case ActionstepPackage.MEET_ME__ACTIVE: return ActionStepPackage.ACTION_STEP__ACTIVE;
        case ActionstepPackage.MEET_ME__OUTPUTS: return ActionStepPackage.ACTION_STEP__OUTPUTS;
        case ActionstepPackage.MEET_ME__NAME: return ActionStepPackage.ACTION_STEP__NAME;
        case ActionstepPackage.MEET_ME__SAFLET: return ActionStepPackage.ACTION_STEP__SAFLET;
        case ActionstepPackage.MEET_ME__DEFAULT_OUTPUT: return ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT;
        case ActionstepPackage.MEET_ME__ERROR_OUTPUT: return ActionStepPackage.ACTION_STEP__ERROR_OUTPUT;
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
    if (baseClass == ProductIdentifiable.class) {
      switch (baseFeatureID) {
        case CorePackage.PRODUCT_IDENTIFIABLE__PRODUCT_ID: return ActionstepPackage.MEET_ME__PRODUCT_ID;
        default: return -1;
      }
    }
    if (baseClass == ActionStep.class) {
      switch (baseFeatureID) {
        case ActionStepPackage.ACTION_STEP__PAUSED: return ActionstepPackage.MEET_ME__PAUSED;
        case ActionStepPackage.ACTION_STEP__ACTIVE: return ActionstepPackage.MEET_ME__ACTIVE;
        case ActionStepPackage.ACTION_STEP__OUTPUTS: return ActionstepPackage.MEET_ME__OUTPUTS;
        case ActionStepPackage.ACTION_STEP__NAME: return ActionstepPackage.MEET_ME__NAME;
        case ActionStepPackage.ACTION_STEP__SAFLET: return ActionstepPackage.MEET_ME__SAFLET;
        case ActionStepPackage.ACTION_STEP__DEFAULT_OUTPUT: return ActionstepPackage.MEET_ME__DEFAULT_OUTPUT;
        case ActionStepPackage.ACTION_STEP__ERROR_OUTPUT: return ActionstepPackage.MEET_ME__ERROR_OUTPUT;
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
    result.append(" (productId: ");
    result.append(productId);
    result.append(", paused: ");
    result.append(paused);
    result.append(", active: ");
    result.append(active);
    result.append(", name: ");
    result.append(name);
    result.append(", backgroundScriptAgi: ");
    result.append(backgroundScriptAgi);
    result.append(", recordingFilename: ");
    result.append(recordingFilename);
    result.append(", recordingFormat: ");
    result.append(recordingFormat);
    result.append(", aloneMessageEnabled: ");
    result.append(aloneMessageEnabled);
    result.append(", adminMode: ");
    result.append(adminMode);
    result.append(", useAGIScript: ");
    result.append(useAGIScript);
    result.append(", announceCount: ");
    result.append(announceCount);
    result.append(", dynamicallyAddConference: ");
    result.append(dynamicallyAddConference);
    result.append(", selectEmptyConference: ");
    result.append(selectEmptyConference);
    result.append(", selectEmptyPinlessConference: ");
    result.append(selectEmptyPinlessConference);
    result.append(", passDTMF: ");
    result.append(passDTMF);
    result.append(", announceJoinLeave: ");
    result.append(announceJoinLeave);
    result.append(", announceJoinLeaveNoReview: ");
    result.append(announceJoinLeaveNoReview);
    result.append(", useMusicOnHold: ");
    result.append(useMusicOnHold);
    result.append(", monitorOnlyMode: ");
    result.append(monitorOnlyMode);
    result.append(", allowPoundUserExit: ");
    result.append(allowPoundUserExit);
    result.append(", alwaysPromptForPin: ");
    result.append(alwaysPromptForPin);
    result.append(", quietMode: ");
    result.append(quietMode);
    result.append(", recordConference: ");
    result.append(recordConference);
    result.append(", playMenuOnStar: ");
    result.append(playMenuOnStar);
    result.append(", talkOnlyMode: ");
    result.append(talkOnlyMode);
    result.append(", talkerDetection: ");
    result.append(talkerDetection);
    result.append(", videoMode: ");
    result.append(videoMode);
    result.append(", waitForMarkedUser: ");
    result.append(waitForMarkedUser);
    result.append(", exitOnExtensionEntered: ");
    result.append(exitOnExtensionEntered);
    result.append(", closeOnLastMarkedUserExit: ");
    result.append(closeOnLastMarkedUserExit);
    result.append(')');
    return result.toString();
  }

} //MeetMeImpl
