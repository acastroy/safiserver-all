/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.safi.asterisk.actionstep.ActionstepPackage
 * @generated
 */
public interface ActionstepFactory extends EFactory {
  /**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  ActionstepFactory eINSTANCE = com.safi.asterisk.actionstep.impl.ActionstepFactoryImpl.init();

  /**
	 * Returns a new object of class '<em>Answer</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Answer</em>'.
	 * @generated
	 */
  Answer createAnswer();

  /**
	 * Returns a new object of class '<em>Get Digits</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Digits</em>'.
	 * @generated
	 */
  GetDigits createGetDigits();

  /**
	 * Returns a new object of class '<em>Get Full Variable</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Full Variable</em>'.
	 * @generated
	 */
  GetFullVariable createGetFullVariable();

  /**
	 * Returns a new object of class '<em>Multi Stream Audio</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multi Stream Audio</em>'.
	 * @generated
	 */
  MultiStreamAudio createMultiStreamAudio();

  /**
	 * Returns a new object of class '<em>Hangup</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Hangup</em>'.
	 * @generated
	 */
  Hangup createHangup();

  /**
	 * Returns a new object of class '<em>Record File</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Record File</em>'.
	 * @generated
	 */
  RecordFile createRecordFile();

  /**
	 * Returns a new object of class '<em>Say Alpha</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Say Alpha</em>'.
	 * @generated
	 */
  SayAlpha createSayAlpha();

  /**
	 * Returns a new object of class '<em>Say Date Time</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Say Date Time</em>'.
	 * @generated
	 */
  SayDateTime createSayDateTime();

  /**
	 * Returns a new object of class '<em>Say Digits</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Say Digits</em>'.
	 * @generated
	 */
  SayDigits createSayDigits();

  /**
	 * Returns a new object of class '<em>Say Number</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Say Number</em>'.
	 * @generated
	 */
  SayNumber createSayNumber();

  /**
	 * Returns a new object of class '<em>Say Phonetic</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Say Phonetic</em>'.
	 * @generated
	 */
  SayPhonetic createSayPhonetic();

  /**
	 * Returns a new object of class '<em>Say Time</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Say Time</em>'.
	 * @generated
	 */
  SayTime createSayTime();

  /**
	 * Returns a new object of class '<em>Set Auto Hangup</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Auto Hangup</em>'.
	 * @generated
	 */
  SetAutoHangup createSetAutoHangup();

  /**
	 * Returns a new object of class '<em>Set Caller Id</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Caller Id</em>'.
	 * @generated
	 */
  SetCallerId createSetCallerId();

  /**
	 * Returns a new object of class '<em>Set Channel Variable</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Channel Variable</em>'.
	 * @generated
	 */
  SetChannelVariable createSetChannelVariable();

  /**
	 * Returns a new object of class '<em>Set Context</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Context</em>'.
	 * @generated
	 */
  SetContext createSetContext();

  /**
	 * Returns a new object of class '<em>Set Extension</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Extension</em>'.
	 * @generated
	 */
  SetExtension createSetExtension();

  /**
	 * Returns a new object of class '<em>Stop Music On Hold</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stop Music On Hold</em>'.
	 * @generated
	 */
  StopMusicOnHold createStopMusicOnHold();

  /**
	 * Returns a new object of class '<em>Set Music On</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Music On</em>'.
	 * @generated
	 */
  SetMusicOn createSetMusicOn();

  /**
	 * Returns a new object of class '<em>Set Priority</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Priority</em>'.
	 * @generated
	 */
  SetPriority createSetPriority();

  /**
	 * Returns a new object of class '<em>Stream Audio</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stream Audio</em>'.
	 * @generated
	 */
  StreamAudio createStreamAudio();

  /**
	 * Returns a new object of class '<em>Wait For Digit</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait For Digit</em>'.
	 * @generated
	 */
  WaitForDigit createWaitForDigit();

  /**
	 * Returns a new object of class '<em>Originate Call</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Originate Call</em>'.
	 * @generated
	 */
  OriginateCall createOriginateCall();

  /**
	 * Returns a new object of class '<em>Play DTMF</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Play DTMF</em>'.
	 * @generated
	 */
  PlayDTMF createPlayDTMF();

  /**
	 * Returns a new object of class '<em>Record Call</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Record Call</em>'.
	 * @generated
	 */
  RecordCall createRecordCall();

  /**
	 * Returns a new object of class '<em>Transfer</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transfer</em>'.
	 * @generated
	 */
  Transfer createTransfer();

  /**
	 * Returns a new object of class '<em>Execute Application</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execute Application</em>'.
	 * @generated
	 */
  ExecuteApplication createExecuteApplication();

  /**
	 * Returns a new object of class '<em>Get Call Info</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Call Info</em>'.
	 * @generated
	 */
  GetCallInfo createGetCallInfo();

  /**
	 * Returns a new object of class '<em>Play Music On Hold</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Play Music On Hold</em>'.
	 * @generated
	 */
  PlayMusicOnHold createPlayMusicOnHold();

  /**
	 * Returns a new object of class '<em>Prompt Get Digits</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prompt Get Digits</em>'.
	 * @generated
	 */
  PromptGetDigits createPromptGetDigits();

  /**
	 * Returns a new object of class '<em>Sleep</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sleep</em>'.
	 * @generated
	 */
  Sleep createSleep();

  /**
	 * Returns a new object of class '<em>Stream Audio Extended</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stream Audio Extended</em>'.
	 * @generated
	 */
  StreamAudioExtended createStreamAudioExtended();

  /**
	 * Returns a new object of class '<em>Dial</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dial</em>'.
	 * @generated
	 */
  Dial createDial();

  /**
	 * Returns a new object of class '<em>Pickup</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pickup</em>'.
	 * @generated
	 */
  Pickup createPickup();

  /**
	 * Returns a new object of class '<em>Background</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Background</em>'.
	 * @generated
	 */
  Background createBackground();

  /**
	 * Returns a new object of class '<em>Background Detect</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Background Detect</em>'.
	 * @generated
	 */
  BackgroundDetect createBackgroundDetect();

  /**
	 * Returns a new object of class '<em>Wait Exten</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait Exten</em>'.
	 * @generated
	 */
  WaitExten createWaitExten();

  /**
	 * Returns a new object of class '<em>Soft Hangup</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Soft Hangup</em>'.
	 * @generated
	 */
  SoftHangup createSoftHangup();

  /**
	 * Returns a new object of class '<em>Pickup Chan</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pickup Chan</em>'.
	 * @generated
	 */
  PickupChan createPickupChan();

  /**
	 * Returns a new object of class '<em>Pickdown</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Pickdown</em>'.
	 * @generated
	 */
  Pickdown createPickdown();

  /**
	 * Returns a new object of class '<em>Progress</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Progress</em>'.
	 * @generated
	 */
  Progress createProgress();

  /**
	 * Returns a new object of class '<em>Bridge</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bridge</em>'.
	 * @generated
	 */
  Bridge createBridge();

  /**
	 * Returns a new object of class '<em>Place Call</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Place Call</em>'.
	 * @generated
	 */
  PlaceCall createPlaceCall();

  /**
	 * Returns a new object of class '<em>Voicemail</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Voicemail</em>'.
	 * @generated
	 */
  Voicemail createVoicemail();

  /**
	 * Returns a new object of class '<em>Voicemail Main</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Voicemail Main</em>'.
	 * @generated
	 */
  VoicemailMain createVoicemailMain();

  /**
	 * Returns a new object of class '<em>VM Authenticate</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>VM Authenticate</em>'.
	 * @generated
	 */
  VMAuthenticate createVMAuthenticate();

  /**
	 * Returns a new object of class '<em>Meet Me</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meet Me</em>'.
	 * @generated
	 */
  MeetMe createMeetMe();

  /**
	 * Returns a new object of class '<em>Meet Me Admin</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meet Me Admin</em>'.
	 * @generated
	 */
  MeetMeAdmin createMeetMeAdmin();

  /**
	 * Returns a new object of class '<em>Meet Me Count</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meet Me Count</em>'.
	 * @generated
	 */
  MeetMeCount createMeetMeCount();

  /**
	 * Returns a new object of class '<em>Wait For Ring</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait For Ring</em>'.
	 * @generated
	 */
  WaitForRing createWaitForRing();

  /**
	 * Returns a new object of class '<em>Wait Music On Hold</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait Music On Hold</em>'.
	 * @generated
	 */
  WaitMusicOnHold createWaitMusicOnHold();

  /**
	 * Returns a new object of class '<em>Get Available Channel</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Get Available Channel</em>'.
	 * @generated
	 */
  GetAvailableChannel createGetAvailableChannel();

  /**
	 * Returns a new object of class '<em>Congestion</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Congestion</em>'.
	 * @generated
	 */
  Congestion createCongestion();

  /**
	 * Returns a new object of class '<em>Ringing</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Ringing</em>'.
	 * @generated
	 */
  Ringing createRinging();

  /**
	 * Returns a new object of class '<em>Set Caller Presentation</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Caller Presentation</em>'.
	 * @generated
	 */
  SetCallerPresentation createSetCallerPresentation();

  /**
	 * Returns a new object of class '<em>Set Global Variable</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Global Variable</em>'.
	 * @generated
	 */
  SetGlobalVariable createSetGlobalVariable();

  /**
	 * Returns a new object of class '<em>Echo</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Echo</em>'.
	 * @generated
	 */
  Echo createEcho();

  /**
	 * Returns a new object of class '<em>Festival</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Festival</em>'.
	 * @generated
	 */
  Festival createFestival();

  /**
	 * Returns a new object of class '<em>Playtones</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Playtones</em>'.
	 * @generated
	 */
  Playtones createPlaytones();

  /**
	 * Returns a new object of class '<em>Stop Playtones</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stop Playtones</em>'.
	 * @generated
	 */
  StopPlaytones createStopPlaytones();

  /**
	 * Returns a new object of class '<em>Chan Spy</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Chan Spy</em>'.
	 * @generated
	 */
  ChanSpy createChanSpy();

  /**
	 * Returns a new object of class '<em>Dictate</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dictate</em>'.
	 * @generated
	 */
  Dictate createDictate();

  /**
	 * Returns a new object of class '<em>Extension Spy</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Spy</em>'.
	 * @generated
	 */
  ExtensionSpy createExtensionSpy();

  /**
	 * Returns a new object of class '<em>Mix Monitor</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mix Monitor</em>'.
	 * @generated
	 */
  MixMonitor createMixMonitor();

  /**
	 * Returns a new object of class '<em>Stop Mixmonitor</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stop Mixmonitor</em>'.
	 * @generated
	 */
  StopMixmonitor createStopMixmonitor();

  /**
	 * Returns a new object of class '<em>Stop Monitor</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stop Monitor</em>'.
	 * @generated
	 */
  StopMonitor createStopMonitor();

  /**
	 * Returns a new object of class '<em>Monitor</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Monitor</em>'.
	 * @generated
	 */
  Monitor createMonitor();

  /**
	 * Returns a new object of class '<em>Directory</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Directory</em>'.
	 * @generated
	 */
  Directory createDirectory();

  /**
	 * Returns a new object of class '<em>Extension Transfer</em>'.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extension Transfer</em>'.
	 * @generated
	 */
  ExtensionTransfer createExtensionTransfer();

  /**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
  ActionstepPackage getActionstepPackage();

} //ActionstepFactory
