/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.util;

import com.safi.asterisk.CallConsumer1;
import com.safi.asterisk.CallConsumer2;
import com.safi.asterisk.CallSource1;

import com.safi.asterisk.actionstep.*;

import com.safi.core.ProductIdentifiable;

import com.safi.core.actionstep.ActionStep;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.actionstep.ActionstepPackage
 * @generated
 */
public class ActionstepAdapterFactory extends AdapterFactoryImpl {
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static ActionstepPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ActionstepAdapterFactory() {
    if (modelPackage == null) {
      modelPackage = ActionstepPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object) {
    if (object == modelPackage) {
      return true;
    }
    if (object instanceof EObject) {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ActionstepSwitch<Adapter> modelSwitch =
    new ActionstepSwitch<Adapter>() {
      @Override
      public Adapter caseAnswer(Answer object) {
        return createAnswerAdapter();
      }
      @Override
      public Adapter caseGetDigits(GetDigits object) {
        return createGetDigitsAdapter();
      }
      @Override
      public Adapter caseGetFullVariable(GetFullVariable object) {
        return createGetFullVariableAdapter();
      }
      @Override
      public Adapter caseMultiStreamAudio(MultiStreamAudio object) {
        return createMultiStreamAudioAdapter();
      }
      @Override
      public Adapter caseHangup(Hangup object) {
        return createHangupAdapter();
      }
      @Override
      public Adapter caseRecordFile(RecordFile object) {
        return createRecordFileAdapter();
      }
      @Override
      public Adapter caseSayAlpha(SayAlpha object) {
        return createSayAlphaAdapter();
      }
      @Override
      public Adapter caseSayDateTime(SayDateTime object) {
        return createSayDateTimeAdapter();
      }
      @Override
      public Adapter caseSayDigits(SayDigits object) {
        return createSayDigitsAdapter();
      }
      @Override
      public Adapter caseSayNumber(SayNumber object) {
        return createSayNumberAdapter();
      }
      @Override
      public Adapter caseSayPhonetic(SayPhonetic object) {
        return createSayPhoneticAdapter();
      }
      @Override
      public Adapter caseSayTime(SayTime object) {
        return createSayTimeAdapter();
      }
      @Override
      public Adapter caseSetAutoHangup(SetAutoHangup object) {
        return createSetAutoHangupAdapter();
      }
      @Override
      public Adapter caseSetCallerId(SetCallerId object) {
        return createSetCallerIdAdapter();
      }
      @Override
      public Adapter caseSetChannelVariable(SetChannelVariable object) {
        return createSetChannelVariableAdapter();
      }
      @Override
      public Adapter caseSetContext(SetContext object) {
        return createSetContextAdapter();
      }
      @Override
      public Adapter caseSetExtension(SetExtension object) {
        return createSetExtensionAdapter();
      }
      @Override
      public Adapter caseStopMusicOnHold(StopMusicOnHold object) {
        return createStopMusicOnHoldAdapter();
      }
      @Override
      public Adapter caseSetMusicOn(SetMusicOn object) {
        return createSetMusicOnAdapter();
      }
      @Override
      public Adapter caseSetPriority(SetPriority object) {
        return createSetPriorityAdapter();
      }
      @Override
      public Adapter caseStreamAudio(StreamAudio object) {
        return createStreamAudioAdapter();
      }
      @Override
      public Adapter caseWaitForDigit(WaitForDigit object) {
        return createWaitForDigitAdapter();
      }
      @Override
      public Adapter caseOriginateCall(OriginateCall object) {
        return createOriginateCallAdapter();
      }
      @Override
      public Adapter casePlayDTMF(PlayDTMF object) {
        return createPlayDTMFAdapter();
      }
      @Override
      public Adapter caseRecordCall(RecordCall object) {
        return createRecordCallAdapter();
      }
      @Override
      public Adapter caseTransfer(Transfer object) {
        return createTransferAdapter();
      }
      @Override
      public Adapter caseExecuteApplication(ExecuteApplication object) {
        return createExecuteApplicationAdapter();
      }
      @Override
      public Adapter caseGetCallInfo(GetCallInfo object) {
        return createGetCallInfoAdapter();
      }
      @Override
      public Adapter casePlayMusicOnHold(PlayMusicOnHold object) {
        return createPlayMusicOnHoldAdapter();
      }
      @Override
      public Adapter casePromptGetDigits(PromptGetDigits object) {
        return createPromptGetDigitsAdapter();
      }
      @Override
      public Adapter caseSleep(Sleep object) {
        return createSleepAdapter();
      }
      @Override
      public Adapter caseStreamAudioExtended(StreamAudioExtended object) {
        return createStreamAudioExtendedAdapter();
      }
      @Override
      public Adapter caseDial(Dial object) {
        return createDialAdapter();
      }
      @Override
      public Adapter casePickup(Pickup object) {
        return createPickupAdapter();
      }
      @Override
      public Adapter caseBackground(Background object) {
        return createBackgroundAdapter();
      }
      @Override
      public Adapter caseBackgroundDetect(BackgroundDetect object) {
        return createBackgroundDetectAdapter();
      }
      @Override
      public Adapter caseWaitExten(WaitExten object) {
        return createWaitExtenAdapter();
      }
      @Override
      public Adapter caseSoftHangup(SoftHangup object) {
        return createSoftHangupAdapter();
      }
      @Override
      public Adapter casePickupChan(PickupChan object) {
        return createPickupChanAdapter();
      }
      @Override
      public Adapter casePickdown(Pickdown object) {
        return createPickdownAdapter();
      }
      @Override
      public Adapter caseProgress(Progress object) {
        return createProgressAdapter();
      }
      @Override
      public Adapter caseBridge(Bridge object) {
        return createBridgeAdapter();
      }
      @Override
      public Adapter casePlaceCall(PlaceCall object) {
        return createPlaceCallAdapter();
      }
      @Override
      public Adapter caseVoicemail(Voicemail object) {
        return createVoicemailAdapter();
      }
      @Override
      public Adapter caseVoicemailMain(VoicemailMain object) {
        return createVoicemailMainAdapter();
      }
      @Override
      public Adapter caseVMAuthenticate(VMAuthenticate object) {
        return createVMAuthenticateAdapter();
      }
      @Override
      public Adapter caseMeetMe(MeetMe object) {
        return createMeetMeAdapter();
      }
      @Override
      public Adapter caseMeetMeAdmin(MeetMeAdmin object) {
        return createMeetMeAdminAdapter();
      }
      @Override
      public Adapter caseMeetMeCount(MeetMeCount object) {
        return createMeetMeCountAdapter();
      }
      @Override
      public Adapter caseWaitForRing(WaitForRing object) {
        return createWaitForRingAdapter();
      }
      @Override
      public Adapter caseWaitMusicOnHold(WaitMusicOnHold object) {
        return createWaitMusicOnHoldAdapter();
      }
      @Override
      public Adapter caseGetAvailableChannel(GetAvailableChannel object) {
        return createGetAvailableChannelAdapter();
      }
      @Override
      public Adapter caseCongestion(Congestion object) {
        return createCongestionAdapter();
      }
      @Override
      public Adapter caseRinging(Ringing object) {
        return createRingingAdapter();
      }
      @Override
      public Adapter caseSetCallerPresentation(SetCallerPresentation object) {
        return createSetCallerPresentationAdapter();
      }
      @Override
      public Adapter caseSetGlobalVariable(SetGlobalVariable object) {
        return createSetGlobalVariableAdapter();
      }
      @Override
      public Adapter caseEcho(Echo object) {
        return createEchoAdapter();
      }
      @Override
      public Adapter caseFestival(Festival object) {
        return createFestivalAdapter();
      }
      @Override
      public Adapter casePlaytones(Playtones object) {
        return createPlaytonesAdapter();
      }
      @Override
      public Adapter caseStopPlaytones(StopPlaytones object) {
        return createStopPlaytonesAdapter();
      }
      @Override
      public Adapter caseChanSpy(ChanSpy object) {
        return createChanSpyAdapter();
      }
      @Override
      public Adapter caseDictate(Dictate object) {
        return createDictateAdapter();
      }
      @Override
      public Adapter caseExtensionSpy(ExtensionSpy object) {
        return createExtensionSpyAdapter();
      }
      @Override
      public Adapter caseMixMonitor(MixMonitor object) {
        return createMixMonitorAdapter();
      }
      @Override
      public Adapter caseStopMixmonitor(StopMixmonitor object) {
        return createStopMixmonitorAdapter();
      }
      @Override
      public Adapter caseStopMonitor(StopMonitor object) {
        return createStopMonitorAdapter();
      }
      @Override
      public Adapter caseMonitor(Monitor object) {
        return createMonitorAdapter();
      }
      @Override
      public Adapter caseDirectory(Directory object) {
        return createDirectoryAdapter();
      }
      @Override
      public Adapter caseExtensionTransfer(ExtensionTransfer object) {
        return createExtensionTransferAdapter();
      }
      @Override
      public Adapter caseProductIdentifiable(ProductIdentifiable object) {
        return createProductIdentifiableAdapter();
      }
      @Override
      public Adapter caseActionStep(ActionStep object) {
        return createActionStepAdapter();
      }
      @Override
      public Adapter caseCallConsumer1(CallConsumer1 object) {
        return createCallConsumer1Adapter();
      }
      @Override
      public Adapter caseCallSource1(CallSource1 object) {
        return createCallSource1Adapter();
      }
      @Override
      public Adapter caseCallConsumer2(CallConsumer2 object) {
        return createCallConsumer2Adapter();
      }
      @Override
      public Adapter defaultCase(EObject object) {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target) {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Answer <em>Answer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Answer
   * @generated
   */
  public Adapter createAnswerAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.GetDigits <em>Get Digits</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.GetDigits
   * @generated
   */
  public Adapter createGetDigitsAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.GetFullVariable <em>Get Full Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.GetFullVariable
   * @generated
   */
  public Adapter createGetFullVariableAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.MultiStreamAudio <em>Multi Stream Audio</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.MultiStreamAudio
   * @generated
   */
  public Adapter createMultiStreamAudioAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Hangup <em>Hangup</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Hangup
   * @generated
   */
  public Adapter createHangupAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.RecordFile <em>Record File</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.RecordFile
   * @generated
   */
  public Adapter createRecordFileAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SayAlpha <em>Say Alpha</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SayAlpha
   * @generated
   */
  public Adapter createSayAlphaAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SayDateTime <em>Say Date Time</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SayDateTime
   * @generated
   */
  public Adapter createSayDateTimeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SayDigits <em>Say Digits</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SayDigits
   * @generated
   */
  public Adapter createSayDigitsAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SayNumber <em>Say Number</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SayNumber
   * @generated
   */
  public Adapter createSayNumberAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SayPhonetic <em>Say Phonetic</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SayPhonetic
   * @generated
   */
  public Adapter createSayPhoneticAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SayTime <em>Say Time</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SayTime
   * @generated
   */
  public Adapter createSayTimeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SetAutoHangup <em>Set Auto Hangup</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SetAutoHangup
   * @generated
   */
  public Adapter createSetAutoHangupAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SetCallerId <em>Set Caller Id</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SetCallerId
   * @generated
   */
  public Adapter createSetCallerIdAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SetChannelVariable <em>Set Channel Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SetChannelVariable
   * @generated
   */
  public Adapter createSetChannelVariableAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SetContext <em>Set Context</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SetContext
   * @generated
   */
  public Adapter createSetContextAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SetExtension <em>Set Extension</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SetExtension
   * @generated
   */
  public Adapter createSetExtensionAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.StopMusicOnHold <em>Stop Music On Hold</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.StopMusicOnHold
   * @generated
   */
  public Adapter createStopMusicOnHoldAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SetMusicOn <em>Set Music On</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SetMusicOn
   * @generated
   */
  public Adapter createSetMusicOnAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SetPriority <em>Set Priority</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SetPriority
   * @generated
   */
  public Adapter createSetPriorityAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.StreamAudio <em>Stream Audio</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.StreamAudio
   * @generated
   */
  public Adapter createStreamAudioAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.WaitForDigit <em>Wait For Digit</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.WaitForDigit
   * @generated
   */
  public Adapter createWaitForDigitAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.OriginateCall <em>Originate Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.OriginateCall
   * @generated
   */
  public Adapter createOriginateCallAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.PlayDTMF <em>Play DTMF</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.PlayDTMF
   * @generated
   */
  public Adapter createPlayDTMFAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.RecordCall <em>Record Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.RecordCall
   * @generated
   */
  public Adapter createRecordCallAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Transfer <em>Transfer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Transfer
   * @generated
   */
  public Adapter createTransferAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.ExecuteApplication <em>Execute Application</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.ExecuteApplication
   * @generated
   */
  public Adapter createExecuteApplicationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.GetCallInfo <em>Get Call Info</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.GetCallInfo
   * @generated
   */
  public Adapter createGetCallInfoAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.PlayMusicOnHold <em>Play Music On Hold</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.PlayMusicOnHold
   * @generated
   */
  public Adapter createPlayMusicOnHoldAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.PromptGetDigits <em>Prompt Get Digits</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.PromptGetDigits
   * @generated
   */
  public Adapter createPromptGetDigitsAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Sleep <em>Sleep</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Sleep
   * @generated
   */
  public Adapter createSleepAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.StreamAudioExtended <em>Stream Audio Extended</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.StreamAudioExtended
   * @generated
   */
  public Adapter createStreamAudioExtendedAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Dial <em>Dial</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Dial
   * @generated
   */
  public Adapter createDialAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Pickup <em>Pickup</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Pickup
   * @generated
   */
  public Adapter createPickupAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Background <em>Background</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Background
   * @generated
   */
  public Adapter createBackgroundAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.BackgroundDetect <em>Background Detect</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.BackgroundDetect
   * @generated
   */
  public Adapter createBackgroundDetectAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.WaitExten <em>Wait Exten</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.WaitExten
   * @generated
   */
  public Adapter createWaitExtenAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SoftHangup <em>Soft Hangup</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SoftHangup
   * @generated
   */
  public Adapter createSoftHangupAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.PickupChan <em>Pickup Chan</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.PickupChan
   * @generated
   */
  public Adapter createPickupChanAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Pickdown <em>Pickdown</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Pickdown
   * @generated
   */
  public Adapter createPickdownAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Progress <em>Progress</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Progress
   * @generated
   */
  public Adapter createProgressAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Bridge <em>Bridge</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Bridge
   * @generated
   */
  public Adapter createBridgeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.PlaceCall <em>Place Call</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.PlaceCall
   * @generated
   */
  public Adapter createPlaceCallAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Voicemail <em>Voicemail</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Voicemail
   * @generated
   */
  public Adapter createVoicemailAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.VoicemailMain <em>Voicemail Main</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.VoicemailMain
   * @generated
   */
  public Adapter createVoicemailMainAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.VMAuthenticate <em>VM Authenticate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.VMAuthenticate
   * @generated
   */
  public Adapter createVMAuthenticateAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.MeetMe <em>Meet Me</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.MeetMe
   * @generated
   */
  public Adapter createMeetMeAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.MeetMeAdmin <em>Meet Me Admin</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.MeetMeAdmin
   * @generated
   */
  public Adapter createMeetMeAdminAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.MeetMeCount <em>Meet Me Count</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.MeetMeCount
   * @generated
   */
  public Adapter createMeetMeCountAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.WaitForRing <em>Wait For Ring</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.WaitForRing
   * @generated
   */
  public Adapter createWaitForRingAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.WaitMusicOnHold <em>Wait Music On Hold</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.WaitMusicOnHold
   * @generated
   */
  public Adapter createWaitMusicOnHoldAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.GetAvailableChannel <em>Get Available Channel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.GetAvailableChannel
   * @generated
   */
  public Adapter createGetAvailableChannelAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Congestion <em>Congestion</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Congestion
   * @generated
   */
  public Adapter createCongestionAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Ringing <em>Ringing</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Ringing
   * @generated
   */
  public Adapter createRingingAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SetCallerPresentation <em>Set Caller Presentation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SetCallerPresentation
   * @generated
   */
  public Adapter createSetCallerPresentationAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.SetGlobalVariable <em>Set Global Variable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.SetGlobalVariable
   * @generated
   */
  public Adapter createSetGlobalVariableAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Echo <em>Echo</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Echo
   * @generated
   */
  public Adapter createEchoAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Festival <em>Festival</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Festival
   * @generated
   */
  public Adapter createFestivalAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Playtones <em>Playtones</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Playtones
   * @generated
   */
  public Adapter createPlaytonesAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.StopPlaytones <em>Stop Playtones</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.StopPlaytones
   * @generated
   */
  public Adapter createStopPlaytonesAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.ChanSpy <em>Chan Spy</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.ChanSpy
   * @generated
   */
  public Adapter createChanSpyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Dictate <em>Dictate</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Dictate
   * @generated
   */
  public Adapter createDictateAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.ExtensionSpy <em>Extension Spy</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.ExtensionSpy
   * @generated
   */
  public Adapter createExtensionSpyAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.MixMonitor <em>Mix Monitor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.MixMonitor
   * @generated
   */
  public Adapter createMixMonitorAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.StopMixmonitor <em>Stop Mixmonitor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.StopMixmonitor
   * @generated
   */
  public Adapter createStopMixmonitorAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.StopMonitor <em>Stop Monitor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.StopMonitor
   * @generated
   */
  public Adapter createStopMonitorAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Monitor <em>Monitor</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Monitor
   * @generated
   */
  public Adapter createMonitorAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.Directory <em>Directory</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.Directory
   * @generated
   */
  public Adapter createDirectoryAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.actionstep.ExtensionTransfer <em>Extension Transfer</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.actionstep.ExtensionTransfer
   * @generated
   */
  public Adapter createExtensionTransferAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.CallConsumer1 <em>Call Consumer1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.CallConsumer1
   * @generated
   */
  public Adapter createCallConsumer1Adapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.ProductIdentifiable <em>Product Identifiable</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.ProductIdentifiable
   * @generated
   */
  public Adapter createProductIdentifiableAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.core.actionstep.ActionStep <em>Action Step</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.core.actionstep.ActionStep
   * @generated
   */
  public Adapter createActionStepAdapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.CallSource1 <em>Call Source1</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.CallSource1
   * @generated
   */
  public Adapter createCallSource1Adapter() {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link com.safi.asterisk.CallConsumer2 <em>Call Consumer2</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see com.safi.asterisk.CallConsumer2
   * @generated
   */
  public Adapter createCallConsumer2Adapter() {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter() {
    return null;
  }

} //ActionstepAdapterFactory
