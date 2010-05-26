/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
import com.safi.core.ProductIdentifiable;
import com.safi.core.ThreadSensitive;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.call.CallConsumer1;
import com.safi.core.call.CallConsumer2;
import com.safi.core.call.CallSource1;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.actionstep.ActionstepPackage
 * @generated
 */
public class ActionstepSwitch<T> {
  /**
	 * The cached model package
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static ActionstepPackage modelPackage;

  /**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionstepSwitch() {
		if (modelPackage == null) {
			modelPackage = ActionstepPackage.eINSTANCE;
		}
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

  /**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
  protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ActionstepPackage.ANSWER: {
				Answer answer = (Answer)theEObject;
				T result = caseAnswer(answer);
				if (result == null) result = caseActionStep(answer);
				if (result == null) result = caseCallConsumer1(answer);
				if (result == null) result = caseProductIdentifiable(answer);
				if (result == null) result = caseThreadSensitive(answer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.GET_DIGITS: {
				GetDigits getDigits = (GetDigits)theEObject;
				T result = caseGetDigits(getDigits);
				if (result == null) result = caseActionStep(getDigits);
				if (result == null) result = caseCallConsumer1(getDigits);
				if (result == null) result = caseProductIdentifiable(getDigits);
				if (result == null) result = caseThreadSensitive(getDigits);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.GET_FULL_VARIABLE: {
				GetFullVariable getFullVariable = (GetFullVariable)theEObject;
				T result = caseGetFullVariable(getFullVariable);
				if (result == null) result = caseActionStep(getFullVariable);
				if (result == null) result = caseCallConsumer1(getFullVariable);
				if (result == null) result = caseProductIdentifiable(getFullVariable);
				if (result == null) result = caseThreadSensitive(getFullVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.MULTI_STREAM_AUDIO: {
				MultiStreamAudio multiStreamAudio = (MultiStreamAudio)theEObject;
				T result = caseMultiStreamAudio(multiStreamAudio);
				if (result == null) result = caseActionStep(multiStreamAudio);
				if (result == null) result = caseCallConsumer1(multiStreamAudio);
				if (result == null) result = caseProductIdentifiable(multiStreamAudio);
				if (result == null) result = caseThreadSensitive(multiStreamAudio);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.HANGUP: {
				Hangup hangup = (Hangup)theEObject;
				T result = caseHangup(hangup);
				if (result == null) result = caseActionStep(hangup);
				if (result == null) result = caseCallConsumer1(hangup);
				if (result == null) result = caseProductIdentifiable(hangup);
				if (result == null) result = caseThreadSensitive(hangup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.RECORD_FILE: {
				RecordFile recordFile = (RecordFile)theEObject;
				T result = caseRecordFile(recordFile);
				if (result == null) result = caseActionStep(recordFile);
				if (result == null) result = caseCallConsumer1(recordFile);
				if (result == null) result = caseProductIdentifiable(recordFile);
				if (result == null) result = caseThreadSensitive(recordFile);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SAY_ALPHA: {
				SayAlpha sayAlpha = (SayAlpha)theEObject;
				T result = caseSayAlpha(sayAlpha);
				if (result == null) result = caseActionStep(sayAlpha);
				if (result == null) result = caseCallConsumer1(sayAlpha);
				if (result == null) result = caseProductIdentifiable(sayAlpha);
				if (result == null) result = caseThreadSensitive(sayAlpha);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SAY_DATE_TIME: {
				SayDateTime sayDateTime = (SayDateTime)theEObject;
				T result = caseSayDateTime(sayDateTime);
				if (result == null) result = caseActionStep(sayDateTime);
				if (result == null) result = caseCallConsumer1(sayDateTime);
				if (result == null) result = caseProductIdentifiable(sayDateTime);
				if (result == null) result = caseThreadSensitive(sayDateTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SAY_DIGITS: {
				SayDigits sayDigits = (SayDigits)theEObject;
				T result = caseSayDigits(sayDigits);
				if (result == null) result = caseActionStep(sayDigits);
				if (result == null) result = caseCallConsumer1(sayDigits);
				if (result == null) result = caseProductIdentifiable(sayDigits);
				if (result == null) result = caseThreadSensitive(sayDigits);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SAY_NUMBER: {
				SayNumber sayNumber = (SayNumber)theEObject;
				T result = caseSayNumber(sayNumber);
				if (result == null) result = caseActionStep(sayNumber);
				if (result == null) result = caseCallConsumer1(sayNumber);
				if (result == null) result = caseProductIdentifiable(sayNumber);
				if (result == null) result = caseThreadSensitive(sayNumber);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SAY_PHONETIC: {
				SayPhonetic sayPhonetic = (SayPhonetic)theEObject;
				T result = caseSayPhonetic(sayPhonetic);
				if (result == null) result = caseActionStep(sayPhonetic);
				if (result == null) result = caseCallConsumer1(sayPhonetic);
				if (result == null) result = caseProductIdentifiable(sayPhonetic);
				if (result == null) result = caseThreadSensitive(sayPhonetic);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SAY_TIME: {
				SayTime sayTime = (SayTime)theEObject;
				T result = caseSayTime(sayTime);
				if (result == null) result = caseActionStep(sayTime);
				if (result == null) result = caseCallConsumer1(sayTime);
				if (result == null) result = caseProductIdentifiable(sayTime);
				if (result == null) result = caseThreadSensitive(sayTime);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SET_AUTO_HANGUP: {
				SetAutoHangup setAutoHangup = (SetAutoHangup)theEObject;
				T result = caseSetAutoHangup(setAutoHangup);
				if (result == null) result = caseActionStep(setAutoHangup);
				if (result == null) result = caseCallConsumer1(setAutoHangup);
				if (result == null) result = caseProductIdentifiable(setAutoHangup);
				if (result == null) result = caseThreadSensitive(setAutoHangup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SET_CALLER_ID: {
				SetCallerId setCallerId = (SetCallerId)theEObject;
				T result = caseSetCallerId(setCallerId);
				if (result == null) result = caseActionStep(setCallerId);
				if (result == null) result = caseCallConsumer1(setCallerId);
				if (result == null) result = caseProductIdentifiable(setCallerId);
				if (result == null) result = caseThreadSensitive(setCallerId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SET_CHANNEL_VARIABLE: {
				SetChannelVariable setChannelVariable = (SetChannelVariable)theEObject;
				T result = caseSetChannelVariable(setChannelVariable);
				if (result == null) result = caseActionStep(setChannelVariable);
				if (result == null) result = caseCallConsumer1(setChannelVariable);
				if (result == null) result = caseProductIdentifiable(setChannelVariable);
				if (result == null) result = caseThreadSensitive(setChannelVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SET_CONTEXT: {
				SetContext setContext = (SetContext)theEObject;
				T result = caseSetContext(setContext);
				if (result == null) result = caseActionStep(setContext);
				if (result == null) result = caseCallConsumer1(setContext);
				if (result == null) result = caseProductIdentifiable(setContext);
				if (result == null) result = caseThreadSensitive(setContext);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SET_EXTENSION: {
				SetExtension setExtension = (SetExtension)theEObject;
				T result = caseSetExtension(setExtension);
				if (result == null) result = caseActionStep(setExtension);
				if (result == null) result = caseCallConsumer1(setExtension);
				if (result == null) result = caseProductIdentifiable(setExtension);
				if (result == null) result = caseThreadSensitive(setExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.STOP_MUSIC_ON_HOLD: {
				StopMusicOnHold stopMusicOnHold = (StopMusicOnHold)theEObject;
				T result = caseStopMusicOnHold(stopMusicOnHold);
				if (result == null) result = caseActionStep(stopMusicOnHold);
				if (result == null) result = caseCallConsumer1(stopMusicOnHold);
				if (result == null) result = caseProductIdentifiable(stopMusicOnHold);
				if (result == null) result = caseThreadSensitive(stopMusicOnHold);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SET_MUSIC_ON: {
				SetMusicOn setMusicOn = (SetMusicOn)theEObject;
				T result = caseSetMusicOn(setMusicOn);
				if (result == null) result = caseActionStep(setMusicOn);
				if (result == null) result = caseCallConsumer1(setMusicOn);
				if (result == null) result = caseProductIdentifiable(setMusicOn);
				if (result == null) result = caseThreadSensitive(setMusicOn);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SET_PRIORITY: {
				SetPriority setPriority = (SetPriority)theEObject;
				T result = caseSetPriority(setPriority);
				if (result == null) result = caseActionStep(setPriority);
				if (result == null) result = caseCallConsumer1(setPriority);
				if (result == null) result = caseProductIdentifiable(setPriority);
				if (result == null) result = caseThreadSensitive(setPriority);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.STREAM_AUDIO: {
				StreamAudio streamAudio = (StreamAudio)theEObject;
				T result = caseStreamAudio(streamAudio);
				if (result == null) result = caseActionStep(streamAudio);
				if (result == null) result = caseCallConsumer1(streamAudio);
				if (result == null) result = caseProductIdentifiable(streamAudio);
				if (result == null) result = caseThreadSensitive(streamAudio);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.WAIT_FOR_DIGIT: {
				WaitForDigit waitForDigit = (WaitForDigit)theEObject;
				T result = caseWaitForDigit(waitForDigit);
				if (result == null) result = caseActionStep(waitForDigit);
				if (result == null) result = caseCallConsumer1(waitForDigit);
				if (result == null) result = caseProductIdentifiable(waitForDigit);
				if (result == null) result = caseThreadSensitive(waitForDigit);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.ORIGINATE_CALL: {
				OriginateCall originateCall = (OriginateCall)theEObject;
				T result = caseOriginateCall(originateCall);
				if (result == null) result = caseActionStep(originateCall);
				if (result == null) result = caseCallSource1(originateCall);
				if (result == null) result = caseProductIdentifiable(originateCall);
				if (result == null) result = caseThreadSensitive(originateCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.PLAY_DTMF: {
				PlayDTMF playDTMF = (PlayDTMF)theEObject;
				T result = casePlayDTMF(playDTMF);
				if (result == null) result = caseActionStep(playDTMF);
				if (result == null) result = caseCallConsumer1(playDTMF);
				if (result == null) result = caseProductIdentifiable(playDTMF);
				if (result == null) result = caseThreadSensitive(playDTMF);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.RECORD_CALL: {
				RecordCall recordCall = (RecordCall)theEObject;
				T result = caseRecordCall(recordCall);
				if (result == null) result = caseActionStep(recordCall);
				if (result == null) result = caseCallConsumer1(recordCall);
				if (result == null) result = caseProductIdentifiable(recordCall);
				if (result == null) result = caseThreadSensitive(recordCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.TRANSFER: {
				Transfer transfer = (Transfer)theEObject;
				T result = caseTransfer(transfer);
				if (result == null) result = caseActionStep(transfer);
				if (result == null) result = caseCallConsumer2(transfer);
				if (result == null) result = caseProductIdentifiable(transfer);
				if (result == null) result = caseThreadSensitive(transfer);
				if (result == null) result = caseCallConsumer1(transfer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.EXECUTE_APPLICATION: {
				ExecuteApplication executeApplication = (ExecuteApplication)theEObject;
				T result = caseExecuteApplication(executeApplication);
				if (result == null) result = caseActionStep(executeApplication);
				if (result == null) result = caseCallConsumer1(executeApplication);
				if (result == null) result = caseProductIdentifiable(executeApplication);
				if (result == null) result = caseThreadSensitive(executeApplication);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.GET_CALL_INFO: {
				GetCallInfo getCallInfo = (GetCallInfo)theEObject;
				T result = caseGetCallInfo(getCallInfo);
				if (result == null) result = caseActionStep(getCallInfo);
				if (result == null) result = caseCallConsumer1(getCallInfo);
				if (result == null) result = caseProductIdentifiable(getCallInfo);
				if (result == null) result = caseThreadSensitive(getCallInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.PLAY_MUSIC_ON_HOLD: {
				PlayMusicOnHold playMusicOnHold = (PlayMusicOnHold)theEObject;
				T result = casePlayMusicOnHold(playMusicOnHold);
				if (result == null) result = caseActionStep(playMusicOnHold);
				if (result == null) result = caseCallConsumer1(playMusicOnHold);
				if (result == null) result = caseProductIdentifiable(playMusicOnHold);
				if (result == null) result = caseThreadSensitive(playMusicOnHold);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.PROMPT_GET_DIGITS: {
				PromptGetDigits promptGetDigits = (PromptGetDigits)theEObject;
				T result = casePromptGetDigits(promptGetDigits);
				if (result == null) result = caseActionStep(promptGetDigits);
				if (result == null) result = caseCallConsumer1(promptGetDigits);
				if (result == null) result = caseProductIdentifiable(promptGetDigits);
				if (result == null) result = caseThreadSensitive(promptGetDigits);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SLEEP: {
				Sleep sleep = (Sleep)theEObject;
				T result = caseSleep(sleep);
				if (result == null) result = caseActionStep(sleep);
				if (result == null) result = caseCallConsumer1(sleep);
				if (result == null) result = caseProductIdentifiable(sleep);
				if (result == null) result = caseThreadSensitive(sleep);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.STREAM_AUDIO_EXTENDED: {
				StreamAudioExtended streamAudioExtended = (StreamAudioExtended)theEObject;
				T result = caseStreamAudioExtended(streamAudioExtended);
				if (result == null) result = caseActionStep(streamAudioExtended);
				if (result == null) result = caseCallConsumer1(streamAudioExtended);
				if (result == null) result = caseProductIdentifiable(streamAudioExtended);
				if (result == null) result = caseThreadSensitive(streamAudioExtended);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.DIAL: {
				Dial dial = (Dial)theEObject;
				T result = caseDial(dial);
				if (result == null) result = caseActionStep(dial);
				if (result == null) result = caseCallConsumer1(dial);
				if (result == null) result = caseProductIdentifiable(dial);
				if (result == null) result = caseThreadSensitive(dial);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.PICKUP: {
				Pickup pickup = (Pickup)theEObject;
				T result = casePickup(pickup);
				if (result == null) result = caseActionStep(pickup);
				if (result == null) result = caseCallConsumer1(pickup);
				if (result == null) result = caseProductIdentifiable(pickup);
				if (result == null) result = caseThreadSensitive(pickup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.BACKGROUND: {
				Background background = (Background)theEObject;
				T result = caseBackground(background);
				if (result == null) result = caseActionStep(background);
				if (result == null) result = caseCallConsumer1(background);
				if (result == null) result = caseProductIdentifiable(background);
				if (result == null) result = caseThreadSensitive(background);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.BACKGROUND_DETECT: {
				BackgroundDetect backgroundDetect = (BackgroundDetect)theEObject;
				T result = caseBackgroundDetect(backgroundDetect);
				if (result == null) result = caseActionStep(backgroundDetect);
				if (result == null) result = caseCallConsumer1(backgroundDetect);
				if (result == null) result = caseProductIdentifiable(backgroundDetect);
				if (result == null) result = caseThreadSensitive(backgroundDetect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.WAIT_EXTEN: {
				WaitExten waitExten = (WaitExten)theEObject;
				T result = caseWaitExten(waitExten);
				if (result == null) result = caseActionStep(waitExten);
				if (result == null) result = caseCallConsumer1(waitExten);
				if (result == null) result = caseProductIdentifiable(waitExten);
				if (result == null) result = caseThreadSensitive(waitExten);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SOFT_HANGUP: {
				SoftHangup softHangup = (SoftHangup)theEObject;
				T result = caseSoftHangup(softHangup);
				if (result == null) result = caseActionStep(softHangup);
				if (result == null) result = caseCallConsumer1(softHangup);
				if (result == null) result = caseProductIdentifiable(softHangup);
				if (result == null) result = caseThreadSensitive(softHangup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.PICKUP_CHAN: {
				PickupChan pickupChan = (PickupChan)theEObject;
				T result = casePickupChan(pickupChan);
				if (result == null) result = caseActionStep(pickupChan);
				if (result == null) result = caseCallConsumer1(pickupChan);
				if (result == null) result = caseProductIdentifiable(pickupChan);
				if (result == null) result = caseThreadSensitive(pickupChan);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.PICKDOWN: {
				Pickdown pickdown = (Pickdown)theEObject;
				T result = casePickdown(pickdown);
				if (result == null) result = caseActionStep(pickdown);
				if (result == null) result = caseCallConsumer1(pickdown);
				if (result == null) result = caseProductIdentifiable(pickdown);
				if (result == null) result = caseThreadSensitive(pickdown);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.PROGRESS: {
				Progress progress = (Progress)theEObject;
				T result = caseProgress(progress);
				if (result == null) result = caseActionStep(progress);
				if (result == null) result = caseCallConsumer1(progress);
				if (result == null) result = caseProductIdentifiable(progress);
				if (result == null) result = caseThreadSensitive(progress);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.BRIDGE: {
				Bridge bridge = (Bridge)theEObject;
				T result = caseBridge(bridge);
				if (result == null) result = caseActionStep(bridge);
				if (result == null) result = caseCallConsumer2(bridge);
				if (result == null) result = caseProductIdentifiable(bridge);
				if (result == null) result = caseThreadSensitive(bridge);
				if (result == null) result = caseCallConsumer1(bridge);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.PLACE_CALL: {
				PlaceCall placeCall = (PlaceCall)theEObject;
				T result = casePlaceCall(placeCall);
				if (result == null) result = caseActionStep(placeCall);
				if (result == null) result = caseCallSource1(placeCall);
				if (result == null) result = caseProductIdentifiable(placeCall);
				if (result == null) result = caseThreadSensitive(placeCall);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.VOICEMAIL: {
				Voicemail voicemail = (Voicemail)theEObject;
				T result = caseVoicemail(voicemail);
				if (result == null) result = caseActionStep(voicemail);
				if (result == null) result = caseCallConsumer1(voicemail);
				if (result == null) result = caseProductIdentifiable(voicemail);
				if (result == null) result = caseThreadSensitive(voicemail);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.VOICEMAIL_MAIN: {
				VoicemailMain voicemailMain = (VoicemailMain)theEObject;
				T result = caseVoicemailMain(voicemailMain);
				if (result == null) result = caseActionStep(voicemailMain);
				if (result == null) result = caseCallConsumer1(voicemailMain);
				if (result == null) result = caseProductIdentifiable(voicemailMain);
				if (result == null) result = caseThreadSensitive(voicemailMain);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.VM_AUTHENTICATE: {
				VMAuthenticate vmAuthenticate = (VMAuthenticate)theEObject;
				T result = caseVMAuthenticate(vmAuthenticate);
				if (result == null) result = caseActionStep(vmAuthenticate);
				if (result == null) result = caseCallConsumer1(vmAuthenticate);
				if (result == null) result = caseProductIdentifiable(vmAuthenticate);
				if (result == null) result = caseThreadSensitive(vmAuthenticate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.MEET_ME: {
				MeetMe meetMe = (MeetMe)theEObject;
				T result = caseMeetMe(meetMe);
				if (result == null) result = caseActionStep(meetMe);
				if (result == null) result = caseCallConsumer1(meetMe);
				if (result == null) result = caseProductIdentifiable(meetMe);
				if (result == null) result = caseThreadSensitive(meetMe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.MEET_ME_ADMIN: {
				MeetMeAdmin meetMeAdmin = (MeetMeAdmin)theEObject;
				T result = caseMeetMeAdmin(meetMeAdmin);
				if (result == null) result = caseActionStep(meetMeAdmin);
				if (result == null) result = caseCallConsumer1(meetMeAdmin);
				if (result == null) result = caseProductIdentifiable(meetMeAdmin);
				if (result == null) result = caseThreadSensitive(meetMeAdmin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.MEET_ME_COUNT: {
				MeetMeCount meetMeCount = (MeetMeCount)theEObject;
				T result = caseMeetMeCount(meetMeCount);
				if (result == null) result = caseActionStep(meetMeCount);
				if (result == null) result = caseCallConsumer1(meetMeCount);
				if (result == null) result = caseProductIdentifiable(meetMeCount);
				if (result == null) result = caseThreadSensitive(meetMeCount);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.WAIT_FOR_RING: {
				WaitForRing waitForRing = (WaitForRing)theEObject;
				T result = caseWaitForRing(waitForRing);
				if (result == null) result = caseActionStep(waitForRing);
				if (result == null) result = caseCallConsumer1(waitForRing);
				if (result == null) result = caseProductIdentifiable(waitForRing);
				if (result == null) result = caseThreadSensitive(waitForRing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.WAIT_MUSIC_ON_HOLD: {
				WaitMusicOnHold waitMusicOnHold = (WaitMusicOnHold)theEObject;
				T result = caseWaitMusicOnHold(waitMusicOnHold);
				if (result == null) result = caseActionStep(waitMusicOnHold);
				if (result == null) result = caseCallConsumer1(waitMusicOnHold);
				if (result == null) result = caseProductIdentifiable(waitMusicOnHold);
				if (result == null) result = caseThreadSensitive(waitMusicOnHold);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.GET_AVAILABLE_CHANNEL: {
				GetAvailableChannel getAvailableChannel = (GetAvailableChannel)theEObject;
				T result = caseGetAvailableChannel(getAvailableChannel);
				if (result == null) result = caseActionStep(getAvailableChannel);
				if (result == null) result = caseCallConsumer1(getAvailableChannel);
				if (result == null) result = caseProductIdentifiable(getAvailableChannel);
				if (result == null) result = caseThreadSensitive(getAvailableChannel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.CONGESTION: {
				Congestion congestion = (Congestion)theEObject;
				T result = caseCongestion(congestion);
				if (result == null) result = caseActionStep(congestion);
				if (result == null) result = caseCallConsumer1(congestion);
				if (result == null) result = caseProductIdentifiable(congestion);
				if (result == null) result = caseThreadSensitive(congestion);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.RINGING: {
				Ringing ringing = (Ringing)theEObject;
				T result = caseRinging(ringing);
				if (result == null) result = caseActionStep(ringing);
				if (result == null) result = caseCallConsumer1(ringing);
				if (result == null) result = caseProductIdentifiable(ringing);
				if (result == null) result = caseThreadSensitive(ringing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SET_CALLER_PRESENTATION: {
				SetCallerPresentation setCallerPresentation = (SetCallerPresentation)theEObject;
				T result = caseSetCallerPresentation(setCallerPresentation);
				if (result == null) result = caseActionStep(setCallerPresentation);
				if (result == null) result = caseCallConsumer1(setCallerPresentation);
				if (result == null) result = caseProductIdentifiable(setCallerPresentation);
				if (result == null) result = caseThreadSensitive(setCallerPresentation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.SET_GLOBAL_VARIABLE: {
				SetGlobalVariable setGlobalVariable = (SetGlobalVariable)theEObject;
				T result = caseSetGlobalVariable(setGlobalVariable);
				if (result == null) result = caseActionStep(setGlobalVariable);
				if (result == null) result = caseCallConsumer1(setGlobalVariable);
				if (result == null) result = caseProductIdentifiable(setGlobalVariable);
				if (result == null) result = caseThreadSensitive(setGlobalVariable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.ECHO: {
				Echo echo = (Echo)theEObject;
				T result = caseEcho(echo);
				if (result == null) result = caseActionStep(echo);
				if (result == null) result = caseCallConsumer1(echo);
				if (result == null) result = caseProductIdentifiable(echo);
				if (result == null) result = caseThreadSensitive(echo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.FESTIVAL: {
				Festival festival = (Festival)theEObject;
				T result = caseFestival(festival);
				if (result == null) result = caseActionStep(festival);
				if (result == null) result = caseCallConsumer1(festival);
				if (result == null) result = caseProductIdentifiable(festival);
				if (result == null) result = caseThreadSensitive(festival);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.PLAYTONES: {
				Playtones playtones = (Playtones)theEObject;
				T result = casePlaytones(playtones);
				if (result == null) result = caseActionStep(playtones);
				if (result == null) result = caseCallConsumer1(playtones);
				if (result == null) result = caseProductIdentifiable(playtones);
				if (result == null) result = caseThreadSensitive(playtones);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.STOP_PLAYTONES: {
				StopPlaytones stopPlaytones = (StopPlaytones)theEObject;
				T result = caseStopPlaytones(stopPlaytones);
				if (result == null) result = caseActionStep(stopPlaytones);
				if (result == null) result = caseCallConsumer1(stopPlaytones);
				if (result == null) result = caseProductIdentifiable(stopPlaytones);
				if (result == null) result = caseThreadSensitive(stopPlaytones);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.CHAN_SPY: {
				ChanSpy chanSpy = (ChanSpy)theEObject;
				T result = caseChanSpy(chanSpy);
				if (result == null) result = caseActionStep(chanSpy);
				if (result == null) result = caseCallConsumer1(chanSpy);
				if (result == null) result = caseProductIdentifiable(chanSpy);
				if (result == null) result = caseThreadSensitive(chanSpy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.DICTATE: {
				Dictate dictate = (Dictate)theEObject;
				T result = caseDictate(dictate);
				if (result == null) result = caseActionStep(dictate);
				if (result == null) result = caseCallConsumer1(dictate);
				if (result == null) result = caseProductIdentifiable(dictate);
				if (result == null) result = caseThreadSensitive(dictate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.EXTENSION_SPY: {
				ExtensionSpy extensionSpy = (ExtensionSpy)theEObject;
				T result = caseExtensionSpy(extensionSpy);
				if (result == null) result = caseActionStep(extensionSpy);
				if (result == null) result = caseCallConsumer1(extensionSpy);
				if (result == null) result = caseProductIdentifiable(extensionSpy);
				if (result == null) result = caseThreadSensitive(extensionSpy);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.MIX_MONITOR: {
				MixMonitor mixMonitor = (MixMonitor)theEObject;
				T result = caseMixMonitor(mixMonitor);
				if (result == null) result = caseActionStep(mixMonitor);
				if (result == null) result = caseCallConsumer1(mixMonitor);
				if (result == null) result = caseProductIdentifiable(mixMonitor);
				if (result == null) result = caseThreadSensitive(mixMonitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.STOP_MIXMONITOR: {
				StopMixmonitor stopMixmonitor = (StopMixmonitor)theEObject;
				T result = caseStopMixmonitor(stopMixmonitor);
				if (result == null) result = caseActionStep(stopMixmonitor);
				if (result == null) result = caseCallConsumer1(stopMixmonitor);
				if (result == null) result = caseProductIdentifiable(stopMixmonitor);
				if (result == null) result = caseThreadSensitive(stopMixmonitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.STOP_MONITOR: {
				StopMonitor stopMonitor = (StopMonitor)theEObject;
				T result = caseStopMonitor(stopMonitor);
				if (result == null) result = caseActionStep(stopMonitor);
				if (result == null) result = caseCallConsumer1(stopMonitor);
				if (result == null) result = caseProductIdentifiable(stopMonitor);
				if (result == null) result = caseThreadSensitive(stopMonitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.MONITOR: {
				Monitor monitor = (Monitor)theEObject;
				T result = caseMonitor(monitor);
				if (result == null) result = caseActionStep(monitor);
				if (result == null) result = caseCallConsumer1(monitor);
				if (result == null) result = caseProductIdentifiable(monitor);
				if (result == null) result = caseThreadSensitive(monitor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.DIRECTORY: {
				Directory directory = (Directory)theEObject;
				T result = caseDirectory(directory);
				if (result == null) result = caseActionStep(directory);
				if (result == null) result = caseCallConsumer1(directory);
				if (result == null) result = caseProductIdentifiable(directory);
				if (result == null) result = caseThreadSensitive(directory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ActionstepPackage.EXTENSION_TRANSFER: {
				ExtensionTransfer extensionTransfer = (ExtensionTransfer)theEObject;
				T result = caseExtensionTransfer(extensionTransfer);
				if (result == null) result = caseActionStep(extensionTransfer);
				if (result == null) result = caseCallConsumer2(extensionTransfer);
				if (result == null) result = caseProductIdentifiable(extensionTransfer);
				if (result == null) result = caseThreadSensitive(extensionTransfer);
				if (result == null) result = caseCallConsumer1(extensionTransfer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Answer</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Answer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseAnswer(Answer object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Get Digits</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Digits</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseGetDigits(GetDigits object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Get Full Variable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Full Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseGetFullVariable(GetFullVariable object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Stream Audio</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Stream Audio</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMultiStreamAudio(MultiStreamAudio object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Hangup</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Hangup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseHangup(Hangup object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Record File</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Record File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRecordFile(RecordFile object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Say Alpha</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Say Alpha</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSayAlpha(SayAlpha object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Say Date Time</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Say Date Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSayDateTime(SayDateTime object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Say Digits</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Say Digits</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSayDigits(SayDigits object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Say Number</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Say Number</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSayNumber(SayNumber object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Say Phonetic</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Say Phonetic</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSayPhonetic(SayPhonetic object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Say Time</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Say Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSayTime(SayTime object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Auto Hangup</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Auto Hangup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetAutoHangup(SetAutoHangup object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Caller Id</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Caller Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetCallerId(SetCallerId object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Channel Variable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Channel Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetChannelVariable(SetChannelVariable object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Context</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetContext(SetContext object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Extension</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetExtension(SetExtension object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Stop Music On Hold</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stop Music On Hold</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseStopMusicOnHold(StopMusicOnHold object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Music On</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Music On</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetMusicOn(SetMusicOn object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Priority</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Priority</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetPriority(SetPriority object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Stream Audio</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stream Audio</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseStreamAudio(StreamAudio object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Wait For Digit</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wait For Digit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseWaitForDigit(WaitForDigit object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Originate Call</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Originate Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseOriginateCall(OriginateCall object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Play DTMF</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Play DTMF</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePlayDTMF(PlayDTMF object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Record Call</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Record Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRecordCall(RecordCall object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Transfer</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transfer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseTransfer(Transfer object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Execute Application</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Execute Application</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseExecuteApplication(ExecuteApplication object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Get Call Info</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Call Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseGetCallInfo(GetCallInfo object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Play Music On Hold</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Play Music On Hold</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePlayMusicOnHold(PlayMusicOnHold object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Prompt Get Digits</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prompt Get Digits</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePromptGetDigits(PromptGetDigits object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Sleep</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sleep</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSleep(Sleep object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Stream Audio Extended</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stream Audio Extended</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseStreamAudioExtended(StreamAudioExtended object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Dial</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dial</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDial(Dial object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pickup</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pickup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePickup(Pickup object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Background</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Background</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseBackground(Background object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Background Detect</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Background Detect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseBackgroundDetect(BackgroundDetect object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Wait Exten</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wait Exten</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseWaitExten(WaitExten object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Soft Hangup</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Soft Hangup</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSoftHangup(SoftHangup object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pickup Chan</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pickup Chan</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePickupChan(PickupChan object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Pickdown</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pickdown</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePickdown(Pickdown object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Progress</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Progress</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseProgress(Progress object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Bridge</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bridge</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseBridge(Bridge object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Place Call</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Place Call</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePlaceCall(PlaceCall object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Voicemail</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Voicemail</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVoicemail(Voicemail object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Voicemail Main</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Voicemail Main</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVoicemailMain(VoicemailMain object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>VM Authenticate</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>VM Authenticate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseVMAuthenticate(VMAuthenticate object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Meet Me</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meet Me</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMeetMe(MeetMe object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Meet Me Admin</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meet Me Admin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMeetMeAdmin(MeetMeAdmin object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Meet Me Count</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meet Me Count</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMeetMeCount(MeetMeCount object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Wait For Ring</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wait For Ring</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseWaitForRing(WaitForRing object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Wait Music On Hold</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Wait Music On Hold</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseWaitMusicOnHold(WaitMusicOnHold object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Get Available Channel</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Get Available Channel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseGetAvailableChannel(GetAvailableChannel object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Congestion</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Congestion</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCongestion(Congestion object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Ringing</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ringing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseRinging(Ringing object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Caller Presentation</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Caller Presentation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetCallerPresentation(SetCallerPresentation object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Set Global Variable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Global Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseSetGlobalVariable(SetGlobalVariable object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Echo</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Echo</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseEcho(Echo object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Festival</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Festival</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseFestival(Festival object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Playtones</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Playtones</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T casePlaytones(Playtones object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Stop Playtones</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stop Playtones</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseStopPlaytones(StopPlaytones object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Chan Spy</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Chan Spy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseChanSpy(ChanSpy object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Dictate</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dictate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDictate(Dictate object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Spy</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Spy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseExtensionSpy(ExtensionSpy object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Mix Monitor</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mix Monitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMixMonitor(MixMonitor object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Stop Mixmonitor</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stop Mixmonitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseStopMixmonitor(StopMixmonitor object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Stop Monitor</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stop Monitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseStopMonitor(StopMonitor object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Monitor</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Monitor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseMonitor(Monitor object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Directory</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Directory</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseDirectory(Directory object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Extension Transfer</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Extension Transfer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseExtensionTransfer(ExtensionTransfer object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Consumer1</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consumer1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCallConsumer1(CallConsumer1 object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Product Identifiable</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product Identifiable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseProductIdentifiable(ProductIdentifiable object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Sensitive</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Sensitive</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadSensitive(ThreadSensitive object) {
		return null;
	}

		/**
	 * Returns the result of interpreting the object as an instance of '<em>Action Step</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Action Step</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseActionStep(ActionStep object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Source1</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCallSource1(CallSource1 object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>Consumer2</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consumer2</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
  public T caseCallConsumer2(CallConsumer2 object) {
		return null;
	}

  /**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
  public T defaultCase(EObject object) {
		return null;
	}

} //ActionstepSwitch
