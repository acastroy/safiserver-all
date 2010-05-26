/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import java.util.Map;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import com.safi.asterisk.actionstep.ActionstepFactory;
import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.actionstep.Answer;
import com.safi.asterisk.actionstep.Background;
import com.safi.asterisk.actionstep.BackgroundDetect;
import com.safi.asterisk.actionstep.Bridge;
import com.safi.asterisk.actionstep.ChanSpy;
import com.safi.asterisk.actionstep.Congestion;
import com.safi.asterisk.actionstep.Dial;
import com.safi.asterisk.actionstep.Dictate;
import com.safi.asterisk.actionstep.Directory;
import com.safi.asterisk.actionstep.Echo;
import com.safi.asterisk.actionstep.ExecuteApplication;
import com.safi.asterisk.actionstep.ExtensionSpy;
import com.safi.asterisk.actionstep.ExtensionTransfer;
import com.safi.asterisk.actionstep.Festival;
import com.safi.asterisk.actionstep.GetAvailableChannel;
import com.safi.asterisk.actionstep.GetCallInfo;
import com.safi.asterisk.actionstep.GetDigits;
import com.safi.asterisk.actionstep.GetFullVariable;
import com.safi.asterisk.actionstep.Hangup;
import com.safi.asterisk.actionstep.MeetMe;
import com.safi.asterisk.actionstep.MeetMeAdmin;
import com.safi.asterisk.actionstep.MeetMeAdminCommand;
import com.safi.asterisk.actionstep.MeetMeCount;
import com.safi.asterisk.actionstep.MixMonitor;
import com.safi.asterisk.actionstep.Monitor;
import com.safi.asterisk.actionstep.MultiStreamAudio;
import com.safi.asterisk.actionstep.OriginateCall;
import com.safi.asterisk.actionstep.Pickdown;
import com.safi.asterisk.actionstep.Pickup;
import com.safi.asterisk.actionstep.PickupChan;
import com.safi.asterisk.actionstep.PlaceCall;
import com.safi.asterisk.actionstep.PlayDTMF;
import com.safi.asterisk.actionstep.PlayMusicOnHold;
import com.safi.asterisk.actionstep.Playtones;
import com.safi.asterisk.actionstep.PresentationType;
import com.safi.asterisk.actionstep.Progress;
import com.safi.asterisk.actionstep.PromptGetDigits;
import com.safi.asterisk.actionstep.RecordCall;
import com.safi.asterisk.actionstep.RecordFile;
import com.safi.asterisk.actionstep.Ringing;
import com.safi.asterisk.actionstep.SayAlpha;
import com.safi.asterisk.actionstep.SayDateTime;
import com.safi.asterisk.actionstep.SayDigits;
import com.safi.asterisk.actionstep.SayNumber;
import com.safi.asterisk.actionstep.SayPhonetic;
import com.safi.asterisk.actionstep.SayTime;
import com.safi.asterisk.actionstep.SetAutoHangup;
import com.safi.asterisk.actionstep.SetCallerId;
import com.safi.asterisk.actionstep.SetCallerPresentation;
import com.safi.asterisk.actionstep.SetChannelVariable;
import com.safi.asterisk.actionstep.SetContext;
import com.safi.asterisk.actionstep.SetExtension;
import com.safi.asterisk.actionstep.SetGlobalVariable;
import com.safi.asterisk.actionstep.SetMusicOn;
import com.safi.asterisk.actionstep.SetPriority;
import com.safi.asterisk.actionstep.Sleep;
import com.safi.asterisk.actionstep.SoftHangup;
import com.safi.asterisk.actionstep.StopMixmonitor;
import com.safi.asterisk.actionstep.StopMonitor;
import com.safi.asterisk.actionstep.StopMusicOnHold;
import com.safi.asterisk.actionstep.StopPlaytones;
import com.safi.asterisk.actionstep.StreamAudio;
import com.safi.asterisk.actionstep.StreamAudioExtended;
import com.safi.asterisk.actionstep.Transfer;
import com.safi.asterisk.actionstep.VMAuthenticate;
import com.safi.asterisk.actionstep.Voicemail;
import com.safi.asterisk.actionstep.VoicemailMain;
import com.safi.asterisk.actionstep.WaitExten;
import com.safi.asterisk.actionstep.WaitForDigit;
import com.safi.asterisk.actionstep.WaitForRing;
import com.safi.asterisk.actionstep.WaitMusicOnHold;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionstepFactoryImpl extends EFactoryImpl implements ActionstepFactory {
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public static ActionstepFactory init() {
		try {
			ActionstepFactory theActionstepFactory = (ActionstepFactory)EPackage.Registry.INSTANCE.getEFactory("http:///com/safi/asterisk.ecore#actionstep"); 
			if (theActionstepFactory != null) {
				return theActionstepFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActionstepFactoryImpl();
	}

  /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionstepFactoryImpl() {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ActionstepPackage.ANSWER: return createAnswer();
			case ActionstepPackage.GET_DIGITS: return createGetDigits();
			case ActionstepPackage.GET_FULL_VARIABLE: return createGetFullVariable();
			case ActionstepPackage.MULTI_STREAM_AUDIO: return createMultiStreamAudio();
			case ActionstepPackage.HANGUP: return createHangup();
			case ActionstepPackage.RECORD_FILE: return createRecordFile();
			case ActionstepPackage.SAY_ALPHA: return createSayAlpha();
			case ActionstepPackage.SAY_DATE_TIME: return createSayDateTime();
			case ActionstepPackage.SAY_DIGITS: return createSayDigits();
			case ActionstepPackage.SAY_NUMBER: return createSayNumber();
			case ActionstepPackage.SAY_PHONETIC: return createSayPhonetic();
			case ActionstepPackage.SAY_TIME: return createSayTime();
			case ActionstepPackage.SET_AUTO_HANGUP: return createSetAutoHangup();
			case ActionstepPackage.SET_CALLER_ID: return createSetCallerId();
			case ActionstepPackage.SET_CHANNEL_VARIABLE: return createSetChannelVariable();
			case ActionstepPackage.SET_CONTEXT: return createSetContext();
			case ActionstepPackage.SET_EXTENSION: return createSetExtension();
			case ActionstepPackage.STOP_MUSIC_ON_HOLD: return createStopMusicOnHold();
			case ActionstepPackage.SET_MUSIC_ON: return createSetMusicOn();
			case ActionstepPackage.SET_PRIORITY: return createSetPriority();
			case ActionstepPackage.STREAM_AUDIO: return createStreamAudio();
			case ActionstepPackage.WAIT_FOR_DIGIT: return createWaitForDigit();
			case ActionstepPackage.ORIGINATE_CALL: return createOriginateCall();
			case ActionstepPackage.PLAY_DTMF: return createPlayDTMF();
			case ActionstepPackage.RECORD_CALL: return createRecordCall();
			case ActionstepPackage.TRANSFER: return createTransfer();
			case ActionstepPackage.EXECUTE_APPLICATION: return createExecuteApplication();
			case ActionstepPackage.GET_CALL_INFO: return createGetCallInfo();
			case ActionstepPackage.PLAY_MUSIC_ON_HOLD: return createPlayMusicOnHold();
			case ActionstepPackage.PROMPT_GET_DIGITS: return createPromptGetDigits();
			case ActionstepPackage.SLEEP: return createSleep();
			case ActionstepPackage.STREAM_AUDIO_EXTENDED: return createStreamAudioExtended();
			case ActionstepPackage.DIAL: return createDial();
			case ActionstepPackage.PICKUP: return createPickup();
			case ActionstepPackage.BACKGROUND: return createBackground();
			case ActionstepPackage.BACKGROUND_DETECT: return createBackgroundDetect();
			case ActionstepPackage.WAIT_EXTEN: return createWaitExten();
			case ActionstepPackage.SOFT_HANGUP: return createSoftHangup();
			case ActionstepPackage.PICKUP_CHAN: return createPickupChan();
			case ActionstepPackage.PICKDOWN: return createPickdown();
			case ActionstepPackage.PROGRESS: return createProgress();
			case ActionstepPackage.BRIDGE: return createBridge();
			case ActionstepPackage.PLACE_CALL: return createPlaceCall();
			case ActionstepPackage.VOICEMAIL: return createVoicemail();
			case ActionstepPackage.VOICEMAIL_MAIN: return createVoicemailMain();
			case ActionstepPackage.VM_AUTHENTICATE: return createVMAuthenticate();
			case ActionstepPackage.MEET_ME: return createMeetMe();
			case ActionstepPackage.MEET_ME_ADMIN: return createMeetMeAdmin();
			case ActionstepPackage.MEET_ME_COUNT: return createMeetMeCount();
			case ActionstepPackage.WAIT_FOR_RING: return createWaitForRing();
			case ActionstepPackage.WAIT_MUSIC_ON_HOLD: return createWaitMusicOnHold();
			case ActionstepPackage.GET_AVAILABLE_CHANNEL: return createGetAvailableChannel();
			case ActionstepPackage.CONGESTION: return createCongestion();
			case ActionstepPackage.RINGING: return createRinging();
			case ActionstepPackage.SET_CALLER_PRESENTATION: return createSetCallerPresentation();
			case ActionstepPackage.SET_GLOBAL_VARIABLE: return createSetGlobalVariable();
			case ActionstepPackage.ECHO: return createEcho();
			case ActionstepPackage.FESTIVAL: return createFestival();
			case ActionstepPackage.PLAYTONES: return createPlaytones();
			case ActionstepPackage.STOP_PLAYTONES: return createStopPlaytones();
			case ActionstepPackage.CHAN_SPY: return createChanSpy();
			case ActionstepPackage.DICTATE: return createDictate();
			case ActionstepPackage.EXTENSION_SPY: return createExtensionSpy();
			case ActionstepPackage.MIX_MONITOR: return createMixMonitor();
			case ActionstepPackage.STOP_MIXMONITOR: return createStopMixmonitor();
			case ActionstepPackage.STOP_MONITOR: return createStopMonitor();
			case ActionstepPackage.MONITOR: return createMonitor();
			case ActionstepPackage.DIRECTORY: return createDirectory();
			case ActionstepPackage.EXTENSION_TRANSFER: return createExtensionTransfer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ActionstepPackage.MEET_ME_ADMIN_COMMAND:
				return createMeetMeAdminCommandFromString(eDataType, initialValue);
			case ActionstepPackage.PRESENTATION_TYPE:
				return createPresentationTypeFromString(eDataType, initialValue);
			case ActionstepPackage.MAP:
				return createMapFromString(eDataType, initialValue);
			case ActionstepPackage.BASIC_EMAP:
				return createBasicEMapFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ActionstepPackage.MEET_ME_ADMIN_COMMAND:
				return convertMeetMeAdminCommandToString(eDataType, instanceValue);
			case ActionstepPackage.PRESENTATION_TYPE:
				return convertPresentationTypeToString(eDataType, instanceValue);
			case ActionstepPackage.MAP:
				return convertMapToString(eDataType, instanceValue);
			case ActionstepPackage.BASIC_EMAP:
				return convertBasicEMapToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Answer createAnswer() {
		AnswerImpl answer = new AnswerImpl();
		return answer;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GetDigits createGetDigits() {
		GetDigitsImpl getDigits = new GetDigitsImpl();
		return getDigits;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GetFullVariable createGetFullVariable() {
		GetFullVariableImpl getFullVariable = new GetFullVariableImpl();
		return getFullVariable;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MultiStreamAudio createMultiStreamAudio() {
		MultiStreamAudioImpl multiStreamAudio = new MultiStreamAudioImpl();
		return multiStreamAudio;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Hangup createHangup() {
		HangupImpl hangup = new HangupImpl();
		return hangup;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RecordFile createRecordFile() {
		RecordFileImpl recordFile = new RecordFileImpl();
		return recordFile;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SayAlpha createSayAlpha() {
		SayAlphaImpl sayAlpha = new SayAlphaImpl();
		return sayAlpha;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SayDateTime createSayDateTime() {
		SayDateTimeImpl sayDateTime = new SayDateTimeImpl();
		return sayDateTime;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SayDigits createSayDigits() {
		SayDigitsImpl sayDigits = new SayDigitsImpl();
		return sayDigits;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SayNumber createSayNumber() {
		SayNumberImpl sayNumber = new SayNumberImpl();
		return sayNumber;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SayPhonetic createSayPhonetic() {
		SayPhoneticImpl sayPhonetic = new SayPhoneticImpl();
		return sayPhonetic;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SayTime createSayTime() {
		SayTimeImpl sayTime = new SayTimeImpl();
		return sayTime;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetAutoHangup createSetAutoHangup() {
		SetAutoHangupImpl setAutoHangup = new SetAutoHangupImpl();
		return setAutoHangup;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetCallerId createSetCallerId() {
		SetCallerIdImpl setCallerId = new SetCallerIdImpl();
		return setCallerId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetChannelVariable createSetChannelVariable() {
		SetChannelVariableImpl setChannelVariable = new SetChannelVariableImpl();
		return setChannelVariable;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetContext createSetContext() {
		SetContextImpl setContext = new SetContextImpl();
		return setContext;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetExtension createSetExtension() {
		SetExtensionImpl setExtension = new SetExtensionImpl();
		return setExtension;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StopMusicOnHold createStopMusicOnHold() {
		StopMusicOnHoldImpl stopMusicOnHold = new StopMusicOnHoldImpl();
		return stopMusicOnHold;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetMusicOn createSetMusicOn() {
		SetMusicOnImpl setMusicOn = new SetMusicOnImpl();
		return setMusicOn;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetPriority createSetPriority() {
		SetPriorityImpl setPriority = new SetPriorityImpl();
		return setPriority;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StreamAudio createStreamAudio() {
		StreamAudioImpl streamAudio = new StreamAudioImpl();
		return streamAudio;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public WaitForDigit createWaitForDigit() {
		WaitForDigitImpl waitForDigit = new WaitForDigitImpl();
		return waitForDigit;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public OriginateCall createOriginateCall() {
		OriginateCallImpl originateCall = new OriginateCallImpl();
		return originateCall;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PlayDTMF createPlayDTMF() {
		PlayDTMFImpl playDTMF = new PlayDTMFImpl();
		return playDTMF;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public RecordCall createRecordCall() {
		RecordCallImpl recordCall = new RecordCallImpl();
		return recordCall;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Transfer createTransfer() {
		TransferImpl transfer = new TransferImpl();
		return transfer;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ExecuteApplication createExecuteApplication() {
		ExecuteApplicationImpl executeApplication = new ExecuteApplicationImpl();
		return executeApplication;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GetCallInfo createGetCallInfo() {
		GetCallInfoImpl getCallInfo = new GetCallInfoImpl();
		return getCallInfo;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PlayMusicOnHold createPlayMusicOnHold() {
		PlayMusicOnHoldImpl playMusicOnHold = new PlayMusicOnHoldImpl();
		return playMusicOnHold;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PromptGetDigits createPromptGetDigits() {
		PromptGetDigitsImpl promptGetDigits = new PromptGetDigitsImpl();
		return promptGetDigits;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Sleep createSleep() {
		SleepImpl sleep = new SleepImpl();
		return sleep;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StreamAudioExtended createStreamAudioExtended() {
		StreamAudioExtendedImpl streamAudioExtended = new StreamAudioExtendedImpl();
		return streamAudioExtended;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Dial createDial() {
		DialImpl dial = new DialImpl();
		return dial;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Pickup createPickup() {
		PickupImpl pickup = new PickupImpl();
		return pickup;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Background createBackground() {
		BackgroundImpl background = new BackgroundImpl();
		return background;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BackgroundDetect createBackgroundDetect() {
		BackgroundDetectImpl backgroundDetect = new BackgroundDetectImpl();
		return backgroundDetect;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public WaitExten createWaitExten() {
		WaitExtenImpl waitExten = new WaitExtenImpl();
		return waitExten;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SoftHangup createSoftHangup() {
		SoftHangupImpl softHangup = new SoftHangupImpl();
		return softHangup;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PickupChan createPickupChan() {
		PickupChanImpl pickupChan = new PickupChanImpl();
		return pickupChan;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Pickdown createPickdown() {
		PickdownImpl pickdown = new PickdownImpl();
		return pickdown;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Progress createProgress() {
		ProgressImpl progress = new ProgressImpl();
		return progress;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Bridge createBridge() {
		BridgeImpl bridge = new BridgeImpl();
		return bridge;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PlaceCall createPlaceCall() {
		PlaceCallImpl placeCall = new PlaceCallImpl();
		return placeCall;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Voicemail createVoicemail() {
		VoicemailImpl voicemail = new VoicemailImpl();
		return voicemail;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VoicemailMain createVoicemailMain() {
		VoicemailMainImpl voicemailMain = new VoicemailMainImpl();
		return voicemailMain;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public VMAuthenticate createVMAuthenticate() {
		VMAuthenticateImpl vmAuthenticate = new VMAuthenticateImpl();
		return vmAuthenticate;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MeetMe createMeetMe() {
		MeetMeImpl meetMe = new MeetMeImpl();
		return meetMe;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MeetMeAdmin createMeetMeAdmin() {
		MeetMeAdminImpl meetMeAdmin = new MeetMeAdminImpl();
		return meetMeAdmin;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MeetMeCount createMeetMeCount() {
		MeetMeCountImpl meetMeCount = new MeetMeCountImpl();
		return meetMeCount;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public WaitForRing createWaitForRing() {
		WaitForRingImpl waitForRing = new WaitForRingImpl();
		return waitForRing;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public WaitMusicOnHold createWaitMusicOnHold() {
		WaitMusicOnHoldImpl waitMusicOnHold = new WaitMusicOnHoldImpl();
		return waitMusicOnHold;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public GetAvailableChannel createGetAvailableChannel() {
		GetAvailableChannelImpl getAvailableChannel = new GetAvailableChannelImpl();
		return getAvailableChannel;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Congestion createCongestion() {
		CongestionImpl congestion = new CongestionImpl();
		return congestion;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Ringing createRinging() {
		RingingImpl ringing = new RingingImpl();
		return ringing;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetCallerPresentation createSetCallerPresentation() {
		SetCallerPresentationImpl setCallerPresentation = new SetCallerPresentationImpl();
		return setCallerPresentation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public SetGlobalVariable createSetGlobalVariable() {
		SetGlobalVariableImpl setGlobalVariable = new SetGlobalVariableImpl();
		return setGlobalVariable;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Echo createEcho() {
		EchoImpl echo = new EchoImpl();
		return echo;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Festival createFestival() {
		FestivalImpl festival = new FestivalImpl();
		return festival;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Playtones createPlaytones() {
		PlaytonesImpl playtones = new PlaytonesImpl();
		return playtones;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StopPlaytones createStopPlaytones() {
		StopPlaytonesImpl stopPlaytones = new StopPlaytonesImpl();
		return stopPlaytones;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ChanSpy createChanSpy() {
		ChanSpyImpl chanSpy = new ChanSpyImpl();
		return chanSpy;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Dictate createDictate() {
		DictateImpl dictate = new DictateImpl();
		return dictate;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ExtensionSpy createExtensionSpy() {
		ExtensionSpyImpl extensionSpy = new ExtensionSpyImpl();
		return extensionSpy;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MixMonitor createMixMonitor() {
		MixMonitorImpl mixMonitor = new MixMonitorImpl();
		return mixMonitor;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StopMixmonitor createStopMixmonitor() {
		StopMixmonitorImpl stopMixmonitor = new StopMixmonitorImpl();
		return stopMixmonitor;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public StopMonitor createStopMonitor() {
		StopMonitorImpl stopMonitor = new StopMonitorImpl();
		return stopMonitor;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Monitor createMonitor() {
		MonitorImpl monitor = new MonitorImpl();
		return monitor;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Directory createDirectory() {
		DirectoryImpl directory = new DirectoryImpl();
		return directory;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ExtensionTransfer createExtensionTransfer() {
		ExtensionTransferImpl extensionTransfer = new ExtensionTransferImpl();
		return extensionTransfer;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public MeetMeAdminCommand createMeetMeAdminCommandFromString(EDataType eDataType, String initialValue) {
		MeetMeAdminCommand result = MeetMeAdminCommand.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertMeetMeAdminCommandToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public PresentationType createPresentationTypeFromString(EDataType eDataType, String initialValue) {
		PresentationType result = PresentationType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertPresentationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Map<?, ?> createMapFromString(EDataType eDataType, String initialValue) {
		return (Map<?, ?>)super.createFromString(initialValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public BasicEMap<?, ?> createBasicEMapFromString(EDataType eDataType, String initialValue) {
		return (BasicEMap<?, ?>)super.createFromString(initialValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public String convertBasicEMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionstepPackage getActionstepPackage() {
		return (ActionstepPackage)getEPackage();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
  @Deprecated
  public static ActionstepPackage getPackage() {
		return ActionstepPackage.eINSTANCE;
	}

} //ActionstepFactoryImpl
