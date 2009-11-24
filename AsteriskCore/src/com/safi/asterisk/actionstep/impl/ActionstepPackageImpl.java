/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package com.safi.asterisk.actionstep.impl;

import java.util.Map;

import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import com.safi.asterisk.AsteriskPackage;
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
import com.safi.asterisk.impl.AsteriskPackageImpl;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.asterisk.initiator.impl.InitiatorPackageImpl;
import com.safi.asterisk.saflet.SafletPackage;
import com.safi.asterisk.saflet.impl.SafletPackageImpl;
import com.safi.core.CorePackage;
import com.safi.core.actionstep.ActionStepPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ActionstepPackageImpl extends EPackageImpl implements ActionstepPackage {
  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass answerEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass getDigitsEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass getFullVariableEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass multiStreamAudioEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass hangupEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass recordFileEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass sayAlphaEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass sayDateTimeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass sayDigitsEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass sayNumberEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass sayPhoneticEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass sayTimeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setAutoHangupEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setCallerIdEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setChannelVariableEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setContextEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setExtensionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass stopMusicOnHoldEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setMusicOnEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setPriorityEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass streamAudioEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass waitForDigitEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass originateCallEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass playDTMFEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass recordCallEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass transferEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass executeApplicationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass getCallInfoEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass playMusicOnHoldEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass promptGetDigitsEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass sleepEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass streamAudioExtendedEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dialEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass pickupEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass backgroundEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass backgroundDetectEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass waitExtenEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass softHangupEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass pickupChanEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass pickdownEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass progressEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass bridgeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass placeCallEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass voicemailEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass voicemailMainEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass vmAuthenticateEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass meetMeEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass meetMeAdminEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass meetMeCountEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass waitForRingEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass waitMusicOnHoldEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass getAvailableChannelEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass congestionEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass ringingEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setCallerPresentationEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass setGlobalVariableEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass echoEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass festivalEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass playtonesEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass stopPlaytonesEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass chanSpyEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass dictateEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass extensionSpyEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass mixMonitorEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass stopMixmonitorEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass stopMonitorEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass monitorEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass directoryEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EClass extensionTransferEClass = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum meetMeAdminCommandEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EEnum presentationTypeEEnum = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType mapEDataType = null;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private EDataType basicEMapEDataType = null;

  /**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see com.safi.asterisk.actionstep.ActionstepPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
  private ActionstepPackageImpl() {
		super(eNS_URI, ActionstepFactory.eINSTANCE);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private static boolean isInited = false;

  /**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ActionstepPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
  public static ActionstepPackage init() {
		if (isInited) return (ActionstepPackage)EPackage.Registry.INSTANCE.getEPackage(ActionstepPackage.eNS_URI);

		// Obtain or create and register package
		ActionstepPackageImpl theActionstepPackage = (ActionstepPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ActionstepPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ActionstepPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AsteriskPackageImpl theAsteriskPackage = (AsteriskPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AsteriskPackage.eNS_URI) instanceof AsteriskPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AsteriskPackage.eNS_URI) : AsteriskPackage.eINSTANCE);
		InitiatorPackageImpl theInitiatorPackage = (InitiatorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) instanceof InitiatorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InitiatorPackage.eNS_URI) : InitiatorPackage.eINSTANCE);
		SafletPackageImpl theSafletPackage = (SafletPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) instanceof SafletPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SafletPackage.eNS_URI) : SafletPackage.eINSTANCE);

		// Create package meta-data objects
		theActionstepPackage.createPackageContents();
		theAsteriskPackage.createPackageContents();
		theInitiatorPackage.createPackageContents();
		theSafletPackage.createPackageContents();

		// Initialize created meta-data
		theActionstepPackage.initializePackageContents();
		theAsteriskPackage.initializePackageContents();
		theInitiatorPackage.initializePackageContents();
		theSafletPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActionstepPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ActionstepPackage.eNS_URI, theActionstepPackage);
		return theActionstepPackage;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getAnswer() {
		return answerEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getGetDigits() {
		return getDigitsEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getGetDigits_InputTimeout() {
		return (EAttribute)getDigitsEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getGetDigits_UseBufferedDigits() {
		return (EAttribute)getDigitsEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getGetDigits_EscapeDigits() {
		return (EAttribute)getDigitsEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetDigits_VariableName() {
		return (EReference)getDigitsEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getGetDigits_MaxDigits() {
		return (EAttribute)getDigitsEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getGetDigits_AcceptedDigits() {
		return (EAttribute)getDigitsEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getGetFullVariable() {
		return getFullVariableEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getGetFullVariable_Variable() {
		return (EAttribute)getFullVariableEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetFullVariable_AssignToVar() {
		return (EReference)getFullVariableEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMultiStreamAudio() {
		return multiStreamAudioEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMultiStreamAudio_EscapeDigits() {
		return (EReference)multiStreamAudioEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMultiStreamAudio_AudioFilenames() {
		return (EReference)multiStreamAudioEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getHangup() {
		return hangupEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getRecordFile() {
		return recordFileEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRecordFile_Beep() {
		return (EAttribute)recordFileEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRecordFile_EscapeDigits() {
		return (EAttribute)recordFileEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getRecordFile_File() {
		return (EReference)recordFileEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRecordFile_Format() {
		return (EAttribute)recordFileEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRecordFile_Offset() {
		return (EAttribute)recordFileEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRecordFile_Timeout() {
		return (EAttribute)recordFileEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRecordFile_MaxSilence() {
		return (EAttribute)recordFileEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSayAlpha() {
		return sayAlphaEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSayAlpha_EscapeDigits() {
		return (EAttribute)sayAlphaEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSayAlpha_Text() {
		return (EReference)sayAlphaEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSayDateTime() {
		return sayDateTimeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSayDateTime_EscapeDigits() {
		return (EAttribute)sayDateTimeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSayDateTime_Format() {
		return (EAttribute)sayDateTimeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSayDateTime_DateTime() {
		return (EReference)sayDateTimeEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSayDateTime_Timezone() {
		return (EAttribute)sayDateTimeEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSayDigits() {
		return sayDigitsEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSayDigits_Digits() {
		return (EReference)sayDigitsEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSayDigits_EscapeDigits() {
		return (EAttribute)sayDigitsEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSayNumber() {
		return sayNumberEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSayNumber_EscapeDigits() {
		return (EAttribute)sayNumberEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSayNumber_Number() {
		return (EReference)sayNumberEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSayPhonetic() {
		return sayPhoneticEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSayPhonetic_EscapeDigits() {
		return (EAttribute)sayPhoneticEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSayPhonetic_Text() {
		return (EReference)sayPhoneticEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSayTime() {
		return sayTimeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSayTime_EscapeDigits() {
		return (EAttribute)sayTimeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSayTime_Time() {
		return (EReference)sayTimeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetAutoHangup() {
		return setAutoHangupEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSetAutoHangup_Time() {
		return (EAttribute)setAutoHangupEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetCallerId() {
		return setCallerIdEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetCallerId_CallerId() {
		return (EReference)setCallerIdEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetChannelVariable() {
		return setChannelVariableEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetChannelVariable_Value() {
		return (EReference)setChannelVariableEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSetChannelVariable_Variable() {
		return (EAttribute)setChannelVariableEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetContext() {
		return setContextEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetContext_Context() {
		return (EReference)setContextEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetExtension() {
		return setExtensionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetExtension_Extension() {
		return (EReference)setExtensionEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getStopMusicOnHold() {
		return stopMusicOnHoldEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetMusicOn() {
		return setMusicOnEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetMusicOn_HoldClass() {
		return (EReference)setMusicOnEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetPriority() {
		return setPriorityEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetPriority_Priority() {
		return (EReference)setPriorityEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getStreamAudio() {
		return streamAudioEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getStreamAudio_Filename() {
		return (EReference)streamAudioEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getStreamAudio_EscapeDigits() {
		return (EAttribute)streamAudioEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getWaitForDigit() {
		return waitForDigitEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getWaitForDigit_Timeout() {
		return (EAttribute)waitForDigitEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getWaitForDigit_AcceptedDigits() {
		return (EAttribute)waitForDigitEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getOriginateCall() {
		return originateCallEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOriginateCall_Async() {
		return (EAttribute)originateCallEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOriginateCall_Account() {
		return (EReference)originateCallEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOriginateCall_Application() {
		return (EReference)originateCallEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOriginateCall_CallerId() {
		return (EReference)originateCallEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOriginateCall_Context() {
		return (EReference)originateCallEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOriginateCall_Data() {
		return (EReference)originateCallEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOriginateCall_Extension() {
		return (EReference)originateCallEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOriginateCall_Priority() {
		return (EAttribute)originateCallEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOriginateCall_Timeout() {
		return (EAttribute)originateCallEClass.getEStructuralFeatures().get(8);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOriginateCall_CallingPresentation() {
		return (EAttribute)originateCallEClass.getEStructuralFeatures().get(9);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOriginateCall_Channel() {
		return (EReference)originateCallEClass.getEStructuralFeatures().get(10);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getOriginateCall_TakeControl() {
		return (EAttribute)originateCallEClass.getEStructuralFeatures().get(11);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getOriginateCall_Variables() {
		return (EReference)originateCallEClass.getEStructuralFeatures().get(12);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPlayDTMF() {
		return playDTMFEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPlayDTMF_Digits() {
		return (EReference)playDTMFEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getRecordCall() {
		return recordCallEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getRecordCall_Filename() {
		return (EReference)recordCallEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRecordCall_Format() {
		return (EAttribute)recordCallEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRecordCall_Mix() {
		return (EAttribute)recordCallEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getTransfer() {
		return transferEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTransfer_Context() {
		return (EReference)transferEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getTransfer_Extension() {
		return (EReference)transferEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getTransfer_Priority() {
		return (EAttribute)transferEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getExecuteApplication() {
		return executeApplicationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getExecuteApplication_Application() {
		return (EAttribute)executeApplicationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getExecuteApplication_Arguments() {
		return (EReference)executeApplicationEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getGetCallInfo() {
		return getCallInfoEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_AccountCodeVar() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_CallerIdNameVar() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_CallerIdNumVar() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_ChannelNameVar() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_ContextVar() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_ExtensionVar() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_DialedNumber() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_PriorityVar() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_StateVar() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(8);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_UniqueIdVar() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(9);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_Ani2Var() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(10);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_Rdnis() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(11);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetCallInfo_Type() {
		return (EReference)getCallInfoEClass.getEStructuralFeatures().get(12);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPlayMusicOnHold() {
		return playMusicOnHoldEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPlayMusicOnHold_HoldClass() {
		return (EReference)playMusicOnHoldEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPromptGetDigits() {
		return promptGetDigitsEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPromptGetDigits_Filename() {
		return (EReference)promptGetDigitsEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getPromptGetDigits_Timeout() {
		return (EAttribute)promptGetDigitsEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPromptGetDigits_VariableName() {
		return (EReference)promptGetDigitsEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getPromptGetDigits_MaxDigits() {
		return (EAttribute)promptGetDigitsEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getPromptGetDigits_UseBufferedDigits() {
		return (EAttribute)promptGetDigitsEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSleep() {
		return sleepEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSleep_Duration() {
		return (EAttribute)sleepEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSleep_Native() {
		return (EAttribute)sleepEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getStreamAudioExtended() {
		return streamAudioExtendedEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getStreamAudioExtended_Filename() {
		return (EReference)streamAudioExtendedEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getStreamAudioExtended_EscapeDigits() {
		return (EAttribute)streamAudioExtendedEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getStreamAudioExtended_Offset() {
		return (EAttribute)streamAudioExtendedEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getStreamAudioExtended_ForwardDigit() {
		return (EAttribute)streamAudioExtendedEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getStreamAudioExtended_RewindDigit() {
		return (EAttribute)streamAudioExtendedEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getStreamAudioExtended_PauseDigit() {
		return (EAttribute)streamAudioExtendedEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDial() {
		return dialEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDial_OutgoingChannels() {
		return (EReference)dialEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_Retry() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_Timeout() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_CalleeBlindTransfer() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_CallerBlindTransfer() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_GenerateRingTone() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_RingCallee() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_CalleeMusicOnHold() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_Private() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(8);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_UseOldCallerID() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(9);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_JumpPriority() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(10);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_Macro() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(11);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_CalleeStarHangup() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(12);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_CallerStarHangup() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(13);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_IgnoreForwardingRequests() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(14);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_ResetCDR() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(15);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_EnableScreeningMode() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(16);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_UsePrivacyManager() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(17);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_PrivaceManagerDB() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(18);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_StayAlive() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(19);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_Announcement() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(20);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_AutoHangupTime() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(21);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_CaptureDTMF() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(22);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_DTMFDigits() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(23);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_MaxDuration() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(24);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_CallEndingWarningTime() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(25);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_WarningRepeatTime() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(26);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_LimitPlayAudioCaller() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(27);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_LimitPlayAudioCallee() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(28);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_LimitTimeoutFilename() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(29);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_LimitConnectFilename() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(30);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_LimitWarningFilename() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(31);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_ForceOutgoingCallID() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(32);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_CalleeCanRecord() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(33);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_CallerCanRecord() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(34);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_CalleeCanPark() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(35);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDial_CallerCanPark() {
		return (EAttribute)dialEClass.getEStructuralFeatures().get(36);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPickup() {
		return pickupEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getPickup_Group() {
		return (EAttribute)pickupEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getBackground() {
		return backgroundEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getBackground_Filenames() {
		return (EReference)backgroundEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getBackground_PlayOnlyIfAnswered() {
		return (EAttribute)backgroundEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getBackground_AnswerIfNecessary() {
		return (EAttribute)backgroundEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getBackground_MatchOnlySingleDigit() {
		return (EAttribute)backgroundEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getBackground_Context() {
		return (EAttribute)backgroundEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getBackgroundDetect() {
		return backgroundDetectEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getBackgroundDetect_Filename() {
		return (EAttribute)backgroundDetectEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getBackgroundDetect_Silence() {
		return (EAttribute)backgroundDetectEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getBackgroundDetect_MinTime() {
		return (EAttribute)backgroundDetectEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getBackgroundDetect_MaxTime() {
		return (EAttribute)backgroundDetectEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getWaitExten() {
		return waitExtenEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getWaitExten_MusicOnHoldClass() {
		return (EAttribute)waitExtenEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getWaitExten_Timeout() {
		return (EAttribute)waitExtenEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSoftHangup() {
		return softHangupEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSoftHangup_HangupAllDeviceCalls() {
		return (EAttribute)softHangupEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSoftHangup_ChannelName() {
		return (EReference)softHangupEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPickupChan() {
		return pickupChanEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPickupChan_Channels() {
		return (EReference)pickupChanEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPickdown() {
		return pickdownEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getPickdown_Group() {
		return (EAttribute)pickdownEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getProgress() {
		return progressEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getBridge() {
		return bridgeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getBridge_Channel1() {
		return (EReference)bridgeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getBridge_Channel2() {
		return (EReference)bridgeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getBridge_UseCourtesyTone() {
		return (EAttribute)bridgeEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPlaceCall() {
		return placeCallEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPlaceCall_Extension() {
		return (EReference)placeCallEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPlaceCall_Context() {
		return (EReference)placeCallEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getPlaceCall_Timeout() {
		return (EAttribute)placeCallEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPlaceCall_CallerId() {
		return (EReference)placeCallEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getVoicemail() {
		return voicemailEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getVoicemail_Mailbox() {
		return (EReference)voicemailEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVoicemail_SkipInstructions() {
		return (EAttribute)voicemailEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVoicemail_PlayUnavailableMessage() {
		return (EAttribute)voicemailEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVoicemail_PlayBusyMessage() {
		return (EAttribute)voicemailEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVoicemail_RecordingGain() {
		return (EAttribute)voicemailEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getVoicemailMain() {
		return voicemailMainEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getVoicemailMain_Mailbox() {
		return (EReference)voicemailMainEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVoicemailMain_SkipPasswordCheck() {
		return (EAttribute)voicemailMainEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVoicemailMain_UsePrefix() {
		return (EAttribute)voicemailMainEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVoicemailMain_RecordingGain() {
		return (EAttribute)voicemailMainEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getVoicemailMain_DefaultFolder() {
		return (EReference)voicemailMainEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getVMAuthenticate() {
		return vmAuthenticateEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getVMAuthenticate_Mailbox() {
		return (EReference)vmAuthenticateEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVMAuthenticate_SkipInstructions() {
		return (EAttribute)vmAuthenticateEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getVMAuthenticate_SetAccountCode() {
		return (EAttribute)vmAuthenticateEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMeetMe() {
		return meetMeEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMeetMe_ConferenceNumber() {
		return (EReference)meetMeEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMeetMe_Pin() {
		return (EReference)meetMeEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_BackgroundScriptAgi() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_RecordingFilename() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_RecordingFormat() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_AloneMessageEnabled() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_AdminMode() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_UseAGIScript() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_AnnounceCount() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(8);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_DynamicallyAddConference() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(9);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_SelectEmptyConference() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(10);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_SelectEmptyPinlessConference() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(11);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_PassDTMF() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(12);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_AnnounceJoinLeave() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(13);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_AnnounceJoinLeaveNoReview() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(14);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_UseMusicOnHold() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(15);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_MonitorOnlyMode() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(16);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_AllowPoundUserExit() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(17);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_AlwaysPromptForPin() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(18);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_QuietMode() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(19);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_RecordConference() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(20);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_PlayMenuOnStar() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(21);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_TalkOnlyMode() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(22);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_TalkerDetection() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(23);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_VideoMode() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(24);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_WaitForMarkedUser() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(25);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_ExitOnExtensionEntered() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(26);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMe_CloseOnLastMarkedUserExit() {
		return (EAttribute)meetMeEClass.getEStructuralFeatures().get(27);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMeetMeAdmin() {
		return meetMeAdminEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMeetMeAdmin_ConferenceNumber() {
		return (EReference)meetMeAdminEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMeetMeAdmin_Command() {
		return (EAttribute)meetMeAdminEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMeetMeAdmin_User() {
		return (EReference)meetMeAdminEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMeetMeCount() {
		return meetMeCountEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMeetMeCount_ConferenceNumber() {
		return (EReference)meetMeCountEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMeetMeCount_VariableName() {
		return (EReference)meetMeCountEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getWaitForRing() {
		return waitForRingEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getWaitForRing_Duration() {
		return (EAttribute)waitForRingEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getWaitMusicOnHold() {
		return waitMusicOnHoldEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getWaitMusicOnHold_Duration() {
		return (EAttribute)waitMusicOnHoldEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getGetAvailableChannel() {
		return getAvailableChannelEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetAvailableChannel_Channels() {
		return (EReference)getAvailableChannelEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getGetAvailableChannel_VariableName() {
		return (EReference)getAvailableChannelEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getGetAvailableChannel_IgnoreInUse() {
		return (EAttribute)getAvailableChannelEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getGetAvailableChannel_JumpPriorityOnFail() {
		return (EAttribute)getAvailableChannelEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getCongestion() {
		return congestionEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getRinging() {
		return ringingEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getRinging_Duration() {
		return (EAttribute)ringingEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetCallerPresentation() {
		return setCallerPresentationEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSetCallerPresentation_Presentation() {
		return (EAttribute)setCallerPresentationEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getSetGlobalVariable() {
		return setGlobalVariableEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getSetGlobalVariable_Value() {
		return (EReference)setGlobalVariableEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getSetGlobalVariable_Variable() {
		return (EAttribute)setGlobalVariableEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getEcho() {
		return echoEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getFestival() {
		return festivalEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getFestival_Text() {
		return (EReference)festivalEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getFestival_InterruptKeys() {
		return (EAttribute)festivalEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getPlaytones() {
		return playtonesEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getPlaytones_Tones() {
		return (EReference)playtonesEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getStopPlaytones() {
		return stopPlaytonesEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getChanSpy() {
		return chanSpyEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getChanSpy_ChannelnamePrefix() {
		return (EReference)chanSpyEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getChanSpy_SpyBridgedOnly() {
		return (EAttribute)chanSpyEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getChanSpy_Group() {
		return (EAttribute)chanSpyEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getChanSpy_Beep() {
		return (EAttribute)chanSpyEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getChanSpy_RecordFilenamePrefix() {
		return (EAttribute)chanSpyEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getChanSpy_Volume() {
		return (EAttribute)chanSpyEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getChanSpy_WhisperEnabled() {
		return (EAttribute)chanSpyEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getChanSpy_PrivateWhisperEnabled() {
		return (EAttribute)chanSpyEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDictate() {
		return dictateEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDictate_Directory() {
		return (EReference)dictateEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDictate_Filename() {
		return (EReference)dictateEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getExtensionSpy() {
		return extensionSpyEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getExtensionSpy_Extension() {
		return (EReference)extensionSpyEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getExtensionSpy_Context() {
		return (EReference)extensionSpyEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getExtensionSpy_SpyBridgedOnly() {
		return (EAttribute)extensionSpyEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getExtensionSpy_Group() {
		return (EAttribute)extensionSpyEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getExtensionSpy_Beep() {
		return (EAttribute)extensionSpyEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getExtensionSpy_RecordFilenamePrefix() {
		return (EAttribute)extensionSpyEClass.getEStructuralFeatures().get(5);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getExtensionSpy_Volume() {
		return (EAttribute)extensionSpyEClass.getEStructuralFeatures().get(6);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getExtensionSpy_WhisperEnabled() {
		return (EAttribute)extensionSpyEClass.getEStructuralFeatures().get(7);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getExtensionSpy_PrivateWhisperEnabled() {
		return (EAttribute)extensionSpyEClass.getEStructuralFeatures().get(8);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getExtensionSpy_ChannelName() {
		return (EReference)extensionSpyEClass.getEStructuralFeatures().get(9);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMixMonitor() {
		return mixMonitorEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMixMonitor_Filename() {
		return (EReference)mixMonitorEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMixMonitor_RecordOnlyWhenBridged() {
		return (EAttribute)mixMonitorEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMixMonitor_AppendMode() {
		return (EAttribute)mixMonitorEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getStopMixmonitor() {
		return stopMixmonitorEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getStopMonitor() {
		return stopMonitorEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getMonitor() {
		return monitorEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getMonitor_FilenamePrefix() {
		return (EReference)monitorEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMonitor_Format() {
		return (EAttribute)monitorEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getMonitor_Mix() {
		return (EAttribute)monitorEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getDirectory() {
		return directoryEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDirectory_VMContext() {
		return (EReference)directoryEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getDirectory_DialContext() {
		return (EReference)directoryEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDirectory_ReadExtensionNumber() {
		return (EAttribute)directoryEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDirectory_EnterByFirstName() {
		return (EAttribute)directoryEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getDirectory_EnterByFirstOrLastName() {
		return (EAttribute)directoryEClass.getEStructuralFeatures().get(4);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EClass getExtensionTransfer() {
		return extensionTransferEClass;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getExtensionTransfer_Context() {
		return (EReference)extensionTransferEClass.getEStructuralFeatures().get(0);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EReference getExtensionTransfer_Extension() {
		return (EReference)extensionTransferEClass.getEStructuralFeatures().get(1);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getExtensionTransfer_Priority() {
		return (EAttribute)extensionTransferEClass.getEStructuralFeatures().get(2);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EAttribute getExtensionTransfer_Timeout() {
		return (EAttribute)extensionTransferEClass.getEStructuralFeatures().get(3);
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionTransfer_Options() {
		return (EReference)extensionTransferEClass.getEStructuralFeatures().get(4);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtensionTransfer_DoPreExtenStatusCheck() {
		return (EAttribute)extensionTransferEClass.getEStructuralFeatures().get(5);
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtensionTransfer_ChannelType() {
		return (EReference)extensionTransferEClass.getEStructuralFeatures().get(6);
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getMeetMeAdminCommand() {
		return meetMeAdminCommandEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EEnum getPresentationType() {
		return presentationTypeEEnum;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getMap() {
		return mapEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EDataType getBasicEMap() {
		return basicEMapEDataType;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public ActionstepFactory getActionstepFactory() {
		return (ActionstepFactory)getEFactoryInstance();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isCreated = false;

  /**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		answerEClass = createEClass(ANSWER);

		getDigitsEClass = createEClass(GET_DIGITS);
		createEAttribute(getDigitsEClass, GET_DIGITS__INPUT_TIMEOUT);
		createEAttribute(getDigitsEClass, GET_DIGITS__USE_BUFFERED_DIGITS);
		createEAttribute(getDigitsEClass, GET_DIGITS__ESCAPE_DIGITS);
		createEReference(getDigitsEClass, GET_DIGITS__VARIABLE_NAME);
		createEAttribute(getDigitsEClass, GET_DIGITS__MAX_DIGITS);
		createEAttribute(getDigitsEClass, GET_DIGITS__ACCEPTED_DIGITS);

		getFullVariableEClass = createEClass(GET_FULL_VARIABLE);
		createEAttribute(getFullVariableEClass, GET_FULL_VARIABLE__VARIABLE);
		createEReference(getFullVariableEClass, GET_FULL_VARIABLE__ASSIGN_TO_VAR);

		multiStreamAudioEClass = createEClass(MULTI_STREAM_AUDIO);
		createEReference(multiStreamAudioEClass, MULTI_STREAM_AUDIO__ESCAPE_DIGITS);
		createEReference(multiStreamAudioEClass, MULTI_STREAM_AUDIO__AUDIO_FILENAMES);

		hangupEClass = createEClass(HANGUP);

		recordFileEClass = createEClass(RECORD_FILE);
		createEAttribute(recordFileEClass, RECORD_FILE__BEEP);
		createEAttribute(recordFileEClass, RECORD_FILE__ESCAPE_DIGITS);
		createEReference(recordFileEClass, RECORD_FILE__FILE);
		createEAttribute(recordFileEClass, RECORD_FILE__FORMAT);
		createEAttribute(recordFileEClass, RECORD_FILE__OFFSET);
		createEAttribute(recordFileEClass, RECORD_FILE__TIMEOUT);
		createEAttribute(recordFileEClass, RECORD_FILE__MAX_SILENCE);

		sayAlphaEClass = createEClass(SAY_ALPHA);
		createEAttribute(sayAlphaEClass, SAY_ALPHA__ESCAPE_DIGITS);
		createEReference(sayAlphaEClass, SAY_ALPHA__TEXT);

		sayDateTimeEClass = createEClass(SAY_DATE_TIME);
		createEAttribute(sayDateTimeEClass, SAY_DATE_TIME__ESCAPE_DIGITS);
		createEAttribute(sayDateTimeEClass, SAY_DATE_TIME__FORMAT);
		createEReference(sayDateTimeEClass, SAY_DATE_TIME__DATE_TIME);
		createEAttribute(sayDateTimeEClass, SAY_DATE_TIME__TIMEZONE);

		sayDigitsEClass = createEClass(SAY_DIGITS);
		createEReference(sayDigitsEClass, SAY_DIGITS__DIGITS);
		createEAttribute(sayDigitsEClass, SAY_DIGITS__ESCAPE_DIGITS);

		sayNumberEClass = createEClass(SAY_NUMBER);
		createEAttribute(sayNumberEClass, SAY_NUMBER__ESCAPE_DIGITS);
		createEReference(sayNumberEClass, SAY_NUMBER__NUMBER);

		sayPhoneticEClass = createEClass(SAY_PHONETIC);
		createEAttribute(sayPhoneticEClass, SAY_PHONETIC__ESCAPE_DIGITS);
		createEReference(sayPhoneticEClass, SAY_PHONETIC__TEXT);

		sayTimeEClass = createEClass(SAY_TIME);
		createEAttribute(sayTimeEClass, SAY_TIME__ESCAPE_DIGITS);
		createEReference(sayTimeEClass, SAY_TIME__TIME);

		setAutoHangupEClass = createEClass(SET_AUTO_HANGUP);
		createEAttribute(setAutoHangupEClass, SET_AUTO_HANGUP__TIME);

		setCallerIdEClass = createEClass(SET_CALLER_ID);
		createEReference(setCallerIdEClass, SET_CALLER_ID__CALLER_ID);

		setChannelVariableEClass = createEClass(SET_CHANNEL_VARIABLE);
		createEReference(setChannelVariableEClass, SET_CHANNEL_VARIABLE__VALUE);
		createEAttribute(setChannelVariableEClass, SET_CHANNEL_VARIABLE__VARIABLE);

		setContextEClass = createEClass(SET_CONTEXT);
		createEReference(setContextEClass, SET_CONTEXT__CONTEXT);

		setExtensionEClass = createEClass(SET_EXTENSION);
		createEReference(setExtensionEClass, SET_EXTENSION__EXTENSION);

		stopMusicOnHoldEClass = createEClass(STOP_MUSIC_ON_HOLD);

		setMusicOnEClass = createEClass(SET_MUSIC_ON);
		createEReference(setMusicOnEClass, SET_MUSIC_ON__HOLD_CLASS);

		setPriorityEClass = createEClass(SET_PRIORITY);
		createEReference(setPriorityEClass, SET_PRIORITY__PRIORITY);

		streamAudioEClass = createEClass(STREAM_AUDIO);
		createEReference(streamAudioEClass, STREAM_AUDIO__FILENAME);
		createEAttribute(streamAudioEClass, STREAM_AUDIO__ESCAPE_DIGITS);

		waitForDigitEClass = createEClass(WAIT_FOR_DIGIT);
		createEAttribute(waitForDigitEClass, WAIT_FOR_DIGIT__TIMEOUT);
		createEAttribute(waitForDigitEClass, WAIT_FOR_DIGIT__ACCEPTED_DIGITS);

		originateCallEClass = createEClass(ORIGINATE_CALL);
		createEAttribute(originateCallEClass, ORIGINATE_CALL__ASYNC);
		createEReference(originateCallEClass, ORIGINATE_CALL__ACCOUNT);
		createEReference(originateCallEClass, ORIGINATE_CALL__APPLICATION);
		createEReference(originateCallEClass, ORIGINATE_CALL__CALLER_ID);
		createEReference(originateCallEClass, ORIGINATE_CALL__CONTEXT);
		createEReference(originateCallEClass, ORIGINATE_CALL__DATA);
		createEReference(originateCallEClass, ORIGINATE_CALL__EXTENSION);
		createEAttribute(originateCallEClass, ORIGINATE_CALL__PRIORITY);
		createEAttribute(originateCallEClass, ORIGINATE_CALL__TIMEOUT);
		createEAttribute(originateCallEClass, ORIGINATE_CALL__CALLING_PRESENTATION);
		createEReference(originateCallEClass, ORIGINATE_CALL__CHANNEL);
		createEAttribute(originateCallEClass, ORIGINATE_CALL__TAKE_CONTROL);
		createEReference(originateCallEClass, ORIGINATE_CALL__VARIABLES);

		playDTMFEClass = createEClass(PLAY_DTMF);
		createEReference(playDTMFEClass, PLAY_DTMF__DIGITS);

		recordCallEClass = createEClass(RECORD_CALL);
		createEReference(recordCallEClass, RECORD_CALL__FILENAME);
		createEAttribute(recordCallEClass, RECORD_CALL__FORMAT);
		createEAttribute(recordCallEClass, RECORD_CALL__MIX);

		transferEClass = createEClass(TRANSFER);
		createEReference(transferEClass, TRANSFER__CONTEXT);
		createEReference(transferEClass, TRANSFER__EXTENSION);
		createEAttribute(transferEClass, TRANSFER__PRIORITY);

		executeApplicationEClass = createEClass(EXECUTE_APPLICATION);
		createEAttribute(executeApplicationEClass, EXECUTE_APPLICATION__APPLICATION);
		createEReference(executeApplicationEClass, EXECUTE_APPLICATION__ARGUMENTS);

		getCallInfoEClass = createEClass(GET_CALL_INFO);
		createEReference(getCallInfoEClass, GET_CALL_INFO__ACCOUNT_CODE_VAR);
		createEReference(getCallInfoEClass, GET_CALL_INFO__CALLER_ID_NAME_VAR);
		createEReference(getCallInfoEClass, GET_CALL_INFO__CALLER_ID_NUM_VAR);
		createEReference(getCallInfoEClass, GET_CALL_INFO__CHANNEL_NAME_VAR);
		createEReference(getCallInfoEClass, GET_CALL_INFO__CONTEXT_VAR);
		createEReference(getCallInfoEClass, GET_CALL_INFO__EXTENSION_VAR);
		createEReference(getCallInfoEClass, GET_CALL_INFO__DIALED_NUMBER);
		createEReference(getCallInfoEClass, GET_CALL_INFO__PRIORITY_VAR);
		createEReference(getCallInfoEClass, GET_CALL_INFO__STATE_VAR);
		createEReference(getCallInfoEClass, GET_CALL_INFO__UNIQUE_ID_VAR);
		createEReference(getCallInfoEClass, GET_CALL_INFO__ANI2_VAR);
		createEReference(getCallInfoEClass, GET_CALL_INFO__RDNIS);
		createEReference(getCallInfoEClass, GET_CALL_INFO__TYPE);

		playMusicOnHoldEClass = createEClass(PLAY_MUSIC_ON_HOLD);
		createEReference(playMusicOnHoldEClass, PLAY_MUSIC_ON_HOLD__HOLD_CLASS);

		promptGetDigitsEClass = createEClass(PROMPT_GET_DIGITS);
		createEReference(promptGetDigitsEClass, PROMPT_GET_DIGITS__FILENAME);
		createEAttribute(promptGetDigitsEClass, PROMPT_GET_DIGITS__TIMEOUT);
		createEReference(promptGetDigitsEClass, PROMPT_GET_DIGITS__VARIABLE_NAME);
		createEAttribute(promptGetDigitsEClass, PROMPT_GET_DIGITS__MAX_DIGITS);
		createEAttribute(promptGetDigitsEClass, PROMPT_GET_DIGITS__USE_BUFFERED_DIGITS);

		sleepEClass = createEClass(SLEEP);
		createEAttribute(sleepEClass, SLEEP__DURATION);
		createEAttribute(sleepEClass, SLEEP__NATIVE);

		streamAudioExtendedEClass = createEClass(STREAM_AUDIO_EXTENDED);
		createEReference(streamAudioExtendedEClass, STREAM_AUDIO_EXTENDED__FILENAME);
		createEAttribute(streamAudioExtendedEClass, STREAM_AUDIO_EXTENDED__ESCAPE_DIGITS);
		createEAttribute(streamAudioExtendedEClass, STREAM_AUDIO_EXTENDED__OFFSET);
		createEAttribute(streamAudioExtendedEClass, STREAM_AUDIO_EXTENDED__FORWARD_DIGIT);
		createEAttribute(streamAudioExtendedEClass, STREAM_AUDIO_EXTENDED__REWIND_DIGIT);
		createEAttribute(streamAudioExtendedEClass, STREAM_AUDIO_EXTENDED__PAUSE_DIGIT);

		dialEClass = createEClass(DIAL);
		createEReference(dialEClass, DIAL__OUTGOING_CHANNELS);
		createEAttribute(dialEClass, DIAL__RETRY);
		createEAttribute(dialEClass, DIAL__TIMEOUT);
		createEAttribute(dialEClass, DIAL__CALLEE_BLIND_TRANSFER);
		createEAttribute(dialEClass, DIAL__CALLER_BLIND_TRANSFER);
		createEAttribute(dialEClass, DIAL__GENERATE_RING_TONE);
		createEAttribute(dialEClass, DIAL__RING_CALLEE);
		createEAttribute(dialEClass, DIAL__CALLEE_MUSIC_ON_HOLD);
		createEAttribute(dialEClass, DIAL__PRIVATE);
		createEAttribute(dialEClass, DIAL__USE_OLD_CALLER_ID);
		createEAttribute(dialEClass, DIAL__JUMP_PRIORITY);
		createEAttribute(dialEClass, DIAL__MACRO);
		createEAttribute(dialEClass, DIAL__CALLEE_STAR_HANGUP);
		createEAttribute(dialEClass, DIAL__CALLER_STAR_HANGUP);
		createEAttribute(dialEClass, DIAL__IGNORE_FORWARDING_REQUESTS);
		createEAttribute(dialEClass, DIAL__RESET_CDR);
		createEAttribute(dialEClass, DIAL__ENABLE_SCREENING_MODE);
		createEAttribute(dialEClass, DIAL__USE_PRIVACY_MANAGER);
		createEAttribute(dialEClass, DIAL__PRIVACE_MANAGER_DB);
		createEAttribute(dialEClass, DIAL__STAY_ALIVE);
		createEAttribute(dialEClass, DIAL__ANNOUNCEMENT);
		createEAttribute(dialEClass, DIAL__AUTO_HANGUP_TIME);
		createEAttribute(dialEClass, DIAL__CAPTURE_DTMF);
		createEAttribute(dialEClass, DIAL__DTMF_DIGITS);
		createEAttribute(dialEClass, DIAL__MAX_DURATION);
		createEAttribute(dialEClass, DIAL__CALL_ENDING_WARNING_TIME);
		createEAttribute(dialEClass, DIAL__WARNING_REPEAT_TIME);
		createEAttribute(dialEClass, DIAL__LIMIT_PLAY_AUDIO_CALLER);
		createEAttribute(dialEClass, DIAL__LIMIT_PLAY_AUDIO_CALLEE);
		createEAttribute(dialEClass, DIAL__LIMIT_TIMEOUT_FILENAME);
		createEAttribute(dialEClass, DIAL__LIMIT_CONNECT_FILENAME);
		createEAttribute(dialEClass, DIAL__LIMIT_WARNING_FILENAME);
		createEAttribute(dialEClass, DIAL__FORCE_OUTGOING_CALL_ID);
		createEAttribute(dialEClass, DIAL__CALLEE_CAN_RECORD);
		createEAttribute(dialEClass, DIAL__CALLER_CAN_RECORD);
		createEAttribute(dialEClass, DIAL__CALLEE_CAN_PARK);
		createEAttribute(dialEClass, DIAL__CALLER_CAN_PARK);

		pickupEClass = createEClass(PICKUP);
		createEAttribute(pickupEClass, PICKUP__GROUP);

		backgroundEClass = createEClass(BACKGROUND);
		createEReference(backgroundEClass, BACKGROUND__FILENAMES);
		createEAttribute(backgroundEClass, BACKGROUND__PLAY_ONLY_IF_ANSWERED);
		createEAttribute(backgroundEClass, BACKGROUND__ANSWER_IF_NECESSARY);
		createEAttribute(backgroundEClass, BACKGROUND__MATCH_ONLY_SINGLE_DIGIT);
		createEAttribute(backgroundEClass, BACKGROUND__CONTEXT);

		backgroundDetectEClass = createEClass(BACKGROUND_DETECT);
		createEAttribute(backgroundDetectEClass, BACKGROUND_DETECT__FILENAME);
		createEAttribute(backgroundDetectEClass, BACKGROUND_DETECT__SILENCE);
		createEAttribute(backgroundDetectEClass, BACKGROUND_DETECT__MIN_TIME);
		createEAttribute(backgroundDetectEClass, BACKGROUND_DETECT__MAX_TIME);

		waitExtenEClass = createEClass(WAIT_EXTEN);
		createEAttribute(waitExtenEClass, WAIT_EXTEN__MUSIC_ON_HOLD_CLASS);
		createEAttribute(waitExtenEClass, WAIT_EXTEN__TIMEOUT);

		softHangupEClass = createEClass(SOFT_HANGUP);
		createEAttribute(softHangupEClass, SOFT_HANGUP__HANGUP_ALL_DEVICE_CALLS);
		createEReference(softHangupEClass, SOFT_HANGUP__CHANNEL_NAME);

		pickupChanEClass = createEClass(PICKUP_CHAN);
		createEReference(pickupChanEClass, PICKUP_CHAN__CHANNELS);

		pickdownEClass = createEClass(PICKDOWN);
		createEAttribute(pickdownEClass, PICKDOWN__GROUP);

		progressEClass = createEClass(PROGRESS);

		bridgeEClass = createEClass(BRIDGE);
		createEReference(bridgeEClass, BRIDGE__CHANNEL1);
		createEReference(bridgeEClass, BRIDGE__CHANNEL2);
		createEAttribute(bridgeEClass, BRIDGE__USE_COURTESY_TONE);

		placeCallEClass = createEClass(PLACE_CALL);
		createEReference(placeCallEClass, PLACE_CALL__EXTENSION);
		createEReference(placeCallEClass, PLACE_CALL__CONTEXT);
		createEAttribute(placeCallEClass, PLACE_CALL__TIMEOUT);
		createEReference(placeCallEClass, PLACE_CALL__CALLER_ID);

		voicemailEClass = createEClass(VOICEMAIL);
		createEReference(voicemailEClass, VOICEMAIL__MAILBOX);
		createEAttribute(voicemailEClass, VOICEMAIL__SKIP_INSTRUCTIONS);
		createEAttribute(voicemailEClass, VOICEMAIL__PLAY_UNAVAILABLE_MESSAGE);
		createEAttribute(voicemailEClass, VOICEMAIL__PLAY_BUSY_MESSAGE);
		createEAttribute(voicemailEClass, VOICEMAIL__RECORDING_GAIN);

		voicemailMainEClass = createEClass(VOICEMAIL_MAIN);
		createEReference(voicemailMainEClass, VOICEMAIL_MAIN__MAILBOX);
		createEAttribute(voicemailMainEClass, VOICEMAIL_MAIN__SKIP_PASSWORD_CHECK);
		createEAttribute(voicemailMainEClass, VOICEMAIL_MAIN__USE_PREFIX);
		createEAttribute(voicemailMainEClass, VOICEMAIL_MAIN__RECORDING_GAIN);
		createEReference(voicemailMainEClass, VOICEMAIL_MAIN__DEFAULT_FOLDER);

		vmAuthenticateEClass = createEClass(VM_AUTHENTICATE);
		createEReference(vmAuthenticateEClass, VM_AUTHENTICATE__MAILBOX);
		createEAttribute(vmAuthenticateEClass, VM_AUTHENTICATE__SKIP_INSTRUCTIONS);
		createEAttribute(vmAuthenticateEClass, VM_AUTHENTICATE__SET_ACCOUNT_CODE);

		meetMeEClass = createEClass(MEET_ME);
		createEReference(meetMeEClass, MEET_ME__CONFERENCE_NUMBER);
		createEReference(meetMeEClass, MEET_ME__PIN);
		createEAttribute(meetMeEClass, MEET_ME__BACKGROUND_SCRIPT_AGI);
		createEAttribute(meetMeEClass, MEET_ME__RECORDING_FILENAME);
		createEAttribute(meetMeEClass, MEET_ME__RECORDING_FORMAT);
		createEAttribute(meetMeEClass, MEET_ME__ALONE_MESSAGE_ENABLED);
		createEAttribute(meetMeEClass, MEET_ME__ADMIN_MODE);
		createEAttribute(meetMeEClass, MEET_ME__USE_AGI_SCRIPT);
		createEAttribute(meetMeEClass, MEET_ME__ANNOUNCE_COUNT);
		createEAttribute(meetMeEClass, MEET_ME__DYNAMICALLY_ADD_CONFERENCE);
		createEAttribute(meetMeEClass, MEET_ME__SELECT_EMPTY_CONFERENCE);
		createEAttribute(meetMeEClass, MEET_ME__SELECT_EMPTY_PINLESS_CONFERENCE);
		createEAttribute(meetMeEClass, MEET_ME__PASS_DTMF);
		createEAttribute(meetMeEClass, MEET_ME__ANNOUNCE_JOIN_LEAVE);
		createEAttribute(meetMeEClass, MEET_ME__ANNOUNCE_JOIN_LEAVE_NO_REVIEW);
		createEAttribute(meetMeEClass, MEET_ME__USE_MUSIC_ON_HOLD);
		createEAttribute(meetMeEClass, MEET_ME__MONITOR_ONLY_MODE);
		createEAttribute(meetMeEClass, MEET_ME__ALLOW_POUND_USER_EXIT);
		createEAttribute(meetMeEClass, MEET_ME__ALWAYS_PROMPT_FOR_PIN);
		createEAttribute(meetMeEClass, MEET_ME__QUIET_MODE);
		createEAttribute(meetMeEClass, MEET_ME__RECORD_CONFERENCE);
		createEAttribute(meetMeEClass, MEET_ME__PLAY_MENU_ON_STAR);
		createEAttribute(meetMeEClass, MEET_ME__TALK_ONLY_MODE);
		createEAttribute(meetMeEClass, MEET_ME__TALKER_DETECTION);
		createEAttribute(meetMeEClass, MEET_ME__VIDEO_MODE);
		createEAttribute(meetMeEClass, MEET_ME__WAIT_FOR_MARKED_USER);
		createEAttribute(meetMeEClass, MEET_ME__EXIT_ON_EXTENSION_ENTERED);
		createEAttribute(meetMeEClass, MEET_ME__CLOSE_ON_LAST_MARKED_USER_EXIT);

		meetMeAdminEClass = createEClass(MEET_ME_ADMIN);
		createEReference(meetMeAdminEClass, MEET_ME_ADMIN__CONFERENCE_NUMBER);
		createEAttribute(meetMeAdminEClass, MEET_ME_ADMIN__COMMAND);
		createEReference(meetMeAdminEClass, MEET_ME_ADMIN__USER);

		meetMeCountEClass = createEClass(MEET_ME_COUNT);
		createEReference(meetMeCountEClass, MEET_ME_COUNT__CONFERENCE_NUMBER);
		createEReference(meetMeCountEClass, MEET_ME_COUNT__VARIABLE_NAME);

		waitForRingEClass = createEClass(WAIT_FOR_RING);
		createEAttribute(waitForRingEClass, WAIT_FOR_RING__DURATION);

		waitMusicOnHoldEClass = createEClass(WAIT_MUSIC_ON_HOLD);
		createEAttribute(waitMusicOnHoldEClass, WAIT_MUSIC_ON_HOLD__DURATION);

		getAvailableChannelEClass = createEClass(GET_AVAILABLE_CHANNEL);
		createEReference(getAvailableChannelEClass, GET_AVAILABLE_CHANNEL__CHANNELS);
		createEReference(getAvailableChannelEClass, GET_AVAILABLE_CHANNEL__VARIABLE_NAME);
		createEAttribute(getAvailableChannelEClass, GET_AVAILABLE_CHANNEL__IGNORE_IN_USE);
		createEAttribute(getAvailableChannelEClass, GET_AVAILABLE_CHANNEL__JUMP_PRIORITY_ON_FAIL);

		congestionEClass = createEClass(CONGESTION);

		ringingEClass = createEClass(RINGING);
		createEAttribute(ringingEClass, RINGING__DURATION);

		setCallerPresentationEClass = createEClass(SET_CALLER_PRESENTATION);
		createEAttribute(setCallerPresentationEClass, SET_CALLER_PRESENTATION__PRESENTATION);

		setGlobalVariableEClass = createEClass(SET_GLOBAL_VARIABLE);
		createEReference(setGlobalVariableEClass, SET_GLOBAL_VARIABLE__VALUE);
		createEAttribute(setGlobalVariableEClass, SET_GLOBAL_VARIABLE__VARIABLE);

		echoEClass = createEClass(ECHO);

		festivalEClass = createEClass(FESTIVAL);
		createEReference(festivalEClass, FESTIVAL__TEXT);
		createEAttribute(festivalEClass, FESTIVAL__INTERRUPT_KEYS);

		playtonesEClass = createEClass(PLAYTONES);
		createEReference(playtonesEClass, PLAYTONES__TONES);

		stopPlaytonesEClass = createEClass(STOP_PLAYTONES);

		chanSpyEClass = createEClass(CHAN_SPY);
		createEReference(chanSpyEClass, CHAN_SPY__CHANNELNAME_PREFIX);
		createEAttribute(chanSpyEClass, CHAN_SPY__SPY_BRIDGED_ONLY);
		createEAttribute(chanSpyEClass, CHAN_SPY__GROUP);
		createEAttribute(chanSpyEClass, CHAN_SPY__BEEP);
		createEAttribute(chanSpyEClass, CHAN_SPY__RECORD_FILENAME_PREFIX);
		createEAttribute(chanSpyEClass, CHAN_SPY__VOLUME);
		createEAttribute(chanSpyEClass, CHAN_SPY__WHISPER_ENABLED);
		createEAttribute(chanSpyEClass, CHAN_SPY__PRIVATE_WHISPER_ENABLED);

		dictateEClass = createEClass(DICTATE);
		createEReference(dictateEClass, DICTATE__DIRECTORY);
		createEReference(dictateEClass, DICTATE__FILENAME);

		extensionSpyEClass = createEClass(EXTENSION_SPY);
		createEReference(extensionSpyEClass, EXTENSION_SPY__EXTENSION);
		createEReference(extensionSpyEClass, EXTENSION_SPY__CONTEXT);
		createEAttribute(extensionSpyEClass, EXTENSION_SPY__SPY_BRIDGED_ONLY);
		createEAttribute(extensionSpyEClass, EXTENSION_SPY__GROUP);
		createEAttribute(extensionSpyEClass, EXTENSION_SPY__BEEP);
		createEAttribute(extensionSpyEClass, EXTENSION_SPY__RECORD_FILENAME_PREFIX);
		createEAttribute(extensionSpyEClass, EXTENSION_SPY__VOLUME);
		createEAttribute(extensionSpyEClass, EXTENSION_SPY__WHISPER_ENABLED);
		createEAttribute(extensionSpyEClass, EXTENSION_SPY__PRIVATE_WHISPER_ENABLED);
		createEReference(extensionSpyEClass, EXTENSION_SPY__CHANNEL_NAME);

		mixMonitorEClass = createEClass(MIX_MONITOR);
		createEReference(mixMonitorEClass, MIX_MONITOR__FILENAME);
		createEAttribute(mixMonitorEClass, MIX_MONITOR__RECORD_ONLY_WHEN_BRIDGED);
		createEAttribute(mixMonitorEClass, MIX_MONITOR__APPEND_MODE);

		stopMixmonitorEClass = createEClass(STOP_MIXMONITOR);

		stopMonitorEClass = createEClass(STOP_MONITOR);

		monitorEClass = createEClass(MONITOR);
		createEReference(monitorEClass, MONITOR__FILENAME_PREFIX);
		createEAttribute(monitorEClass, MONITOR__FORMAT);
		createEAttribute(monitorEClass, MONITOR__MIX);

		directoryEClass = createEClass(DIRECTORY);
		createEReference(directoryEClass, DIRECTORY__VM_CONTEXT);
		createEReference(directoryEClass, DIRECTORY__DIAL_CONTEXT);
		createEAttribute(directoryEClass, DIRECTORY__READ_EXTENSION_NUMBER);
		createEAttribute(directoryEClass, DIRECTORY__ENTER_BY_FIRST_NAME);
		createEAttribute(directoryEClass, DIRECTORY__ENTER_BY_FIRST_OR_LAST_NAME);

		extensionTransferEClass = createEClass(EXTENSION_TRANSFER);
		createEReference(extensionTransferEClass, EXTENSION_TRANSFER__CONTEXT);
		createEReference(extensionTransferEClass, EXTENSION_TRANSFER__EXTENSION);
		createEAttribute(extensionTransferEClass, EXTENSION_TRANSFER__PRIORITY);
		createEAttribute(extensionTransferEClass, EXTENSION_TRANSFER__TIMEOUT);
		createEReference(extensionTransferEClass, EXTENSION_TRANSFER__OPTIONS);
		createEAttribute(extensionTransferEClass, EXTENSION_TRANSFER__DO_PRE_EXTEN_STATUS_CHECK);
		createEReference(extensionTransferEClass, EXTENSION_TRANSFER__CHANNEL_TYPE);

		// Create enums
		meetMeAdminCommandEEnum = createEEnum(MEET_ME_ADMIN_COMMAND);
		presentationTypeEEnum = createEEnum(PRESENTATION_TYPE);

		// Create data types
		mapEDataType = createEDataType(MAP);
		basicEMapEDataType = createEDataType(BASIC_EMAP);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  private boolean isInitialized = false;

  /**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ActionStepPackage theActionStepPackage = (ActionStepPackage)EPackage.Registry.INSTANCE.getEPackage(ActionStepPackage.eNS_URI);
		AsteriskPackage theAsteriskPackage = (AsteriskPackage)EPackage.Registry.INSTANCE.getEPackage(AsteriskPackage.eNS_URI);

		// Create type parameters
		addETypeParameter(mapEDataType, "T");
		addETypeParameter(mapEDataType, "T1");
		addETypeParameter(basicEMapEDataType, "T");
		addETypeParameter(basicEMapEDataType, "T1");

		// Set bounds for type parameters

		// Add supertypes to classes
		answerEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		answerEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		getDigitsEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		getDigitsEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		getFullVariableEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		getFullVariableEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		multiStreamAudioEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		multiStreamAudioEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		hangupEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		hangupEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		recordFileEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		recordFileEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		sayAlphaEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		sayAlphaEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		sayDateTimeEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		sayDateTimeEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		sayDigitsEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		sayDigitsEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		sayNumberEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		sayNumberEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		sayPhoneticEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		sayPhoneticEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		sayTimeEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		sayTimeEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		setAutoHangupEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		setAutoHangupEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		setCallerIdEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		setCallerIdEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		setChannelVariableEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		setChannelVariableEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		setContextEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		setContextEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		setExtensionEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		setExtensionEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		stopMusicOnHoldEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		stopMusicOnHoldEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		setMusicOnEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		setMusicOnEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		setPriorityEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		setPriorityEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		streamAudioEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		streamAudioEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		waitForDigitEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		waitForDigitEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		originateCallEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		originateCallEClass.getESuperTypes().add(theAsteriskPackage.getCallSource1());
		playDTMFEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		playDTMFEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		recordCallEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		recordCallEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		transferEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		transferEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer2());
		executeApplicationEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		executeApplicationEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		getCallInfoEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		getCallInfoEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		playMusicOnHoldEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		playMusicOnHoldEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		promptGetDigitsEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		promptGetDigitsEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		sleepEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		sleepEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		streamAudioExtendedEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		streamAudioExtendedEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		dialEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		dialEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		pickupEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		pickupEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		backgroundEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		backgroundEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		backgroundDetectEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		backgroundDetectEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		waitExtenEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		waitExtenEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		softHangupEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		softHangupEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		pickupChanEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		pickupChanEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		pickdownEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		pickdownEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		progressEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		progressEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		bridgeEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		bridgeEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer2());
		placeCallEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		placeCallEClass.getESuperTypes().add(theAsteriskPackage.getCallSource1());
		voicemailEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		voicemailEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		voicemailMainEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		voicemailMainEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		vmAuthenticateEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		vmAuthenticateEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		meetMeEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		meetMeEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		meetMeAdminEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		meetMeAdminEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		meetMeCountEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		meetMeCountEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		waitForRingEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		waitForRingEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		waitMusicOnHoldEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		waitMusicOnHoldEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		getAvailableChannelEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		getAvailableChannelEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		congestionEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		congestionEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		ringingEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		ringingEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		setCallerPresentationEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		setCallerPresentationEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		setGlobalVariableEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		setGlobalVariableEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		echoEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		echoEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		festivalEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		festivalEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		playtonesEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		playtonesEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		stopPlaytonesEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		stopPlaytonesEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		chanSpyEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		chanSpyEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		dictateEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		dictateEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		extensionSpyEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		extensionSpyEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		mixMonitorEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		mixMonitorEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		stopMixmonitorEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		stopMixmonitorEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		stopMonitorEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		stopMonitorEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		monitorEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		monitorEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		directoryEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		directoryEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer1());
		extensionTransferEClass.getESuperTypes().add(theActionStepPackage.getActionStep());
		extensionTransferEClass.getESuperTypes().add(theAsteriskPackage.getCallConsumer2());

		// Initialize classes and features; add operations and parameters
		initEClass(answerEClass, Answer.class, "Answer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(getDigitsEClass, GetDigits.class, "GetDigits", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetDigits_InputTimeout(), ecorePackage.getELong(), "inputTimeout", "-1", 0, 1, GetDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getGetDigits_UseBufferedDigits(), ecorePackage.getEBoolean(), "useBufferedDigits", null, 0, 1, GetDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGetDigits_EscapeDigits(), ecorePackage.getEString(), "escapeDigits", "#", 0, 1, GetDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetDigits_VariableName(), theActionStepPackage.getDynamicValue(), null, "variableName", null, 0, 1, GetDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGetDigits_MaxDigits(), ecorePackage.getEInt(), "maxDigits", "1", 0, 1, GetDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGetDigits_AcceptedDigits(), ecorePackage.getEString(), "acceptedDigits", "0123456789#", 0, 1, GetDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(getFullVariableEClass, GetFullVariable.class, "GetFullVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getGetFullVariable_Variable(), ecorePackage.getEString(), "variable", null, 0, 1, GetFullVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetFullVariable_AssignToVar(), theActionStepPackage.getDynamicValue(), null, "assignToVar", null, 0, 1, GetFullVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(multiStreamAudioEClass, MultiStreamAudio.class, "MultiStreamAudio", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMultiStreamAudio_EscapeDigits(), theActionStepPackage.getDynamicValue(), null, "escapeDigits", null, 0, 1, MultiStreamAudio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMultiStreamAudio_AudioFilenames(), theActionStepPackage.getAudioFileItem(), null, "audioFilenames", null, 0, -1, MultiStreamAudio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(hangupEClass, Hangup.class, "Hangup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(recordFileEClass, RecordFile.class, "RecordFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRecordFile_Beep(), ecorePackage.getEBoolean(), "beep", "true", 0, 1, RecordFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRecordFile_EscapeDigits(), ecorePackage.getEString(), "escapeDigits", "#", 0, 1, RecordFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRecordFile_File(), theActionStepPackage.getDynamicValue(), null, "file", null, 0, 1, RecordFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRecordFile_Format(), ecorePackage.getEString(), "format", "wav", 0, 1, RecordFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRecordFile_Offset(), ecorePackage.getEInt(), "offset", "0", 0, 1, RecordFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRecordFile_Timeout(), ecorePackage.getELong(), "timeout", "-1", 0, 1, RecordFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRecordFile_MaxSilence(), ecorePackage.getELong(), "maxSilence", "5", 0, 1, RecordFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sayAlphaEClass, SayAlpha.class, "SayAlpha", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSayAlpha_EscapeDigits(), ecorePackage.getEString(), "escapeDigits", "#", 0, 1, SayAlpha.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSayAlpha_Text(), theActionStepPackage.getDynamicValue(), null, "text", null, 0, 1, SayAlpha.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sayDateTimeEClass, SayDateTime.class, "SayDateTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSayDateTime_EscapeDigits(), ecorePackage.getEString(), "escapeDigits", "#", 0, 1, SayDateTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSayDateTime_Format(), ecorePackage.getEString(), "format", "ABdY \\\'digits/at\\\' IMp", 0, 1, SayDateTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSayDateTime_DateTime(), theActionStepPackage.getDynamicValue(), null, "dateTime", null, 0, 1, SayDateTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSayDateTime_Timezone(), ecorePackage.getEString(), "timezone", null, 0, 1, SayDateTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sayDigitsEClass, SayDigits.class, "SayDigits", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSayDigits_Digits(), theActionStepPackage.getDynamicValue(), null, "digits", null, 0, 1, SayDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSayDigits_EscapeDigits(), ecorePackage.getEString(), "escapeDigits", "#", 0, 1, SayDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sayNumberEClass, SayNumber.class, "SayNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSayNumber_EscapeDigits(), ecorePackage.getEString(), "escapeDigits", "#", 0, 1, SayNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSayNumber_Number(), theActionStepPackage.getDynamicValue(), null, "number", null, 0, 1, SayNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sayPhoneticEClass, SayPhonetic.class, "SayPhonetic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSayPhonetic_EscapeDigits(), ecorePackage.getEString(), "escapeDigits", "#", 0, 1, SayPhonetic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSayPhonetic_Text(), theActionStepPackage.getDynamicValue(), null, "text", null, 0, 1, SayPhonetic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sayTimeEClass, SayTime.class, "SayTime", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSayTime_EscapeDigits(), ecorePackage.getEString(), "escapeDigits", "#", 0, 1, SayTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSayTime_Time(), theActionStepPackage.getDynamicValue(), null, "time", null, 0, 1, SayTime.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setAutoHangupEClass, SetAutoHangup.class, "SetAutoHangup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetAutoHangup_Time(), ecorePackage.getELong(), "time", null, 0, 1, SetAutoHangup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setCallerIdEClass, SetCallerId.class, "SetCallerId", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetCallerId_CallerId(), theActionStepPackage.getDynamicValue(), null, "callerId", null, 0, 1, SetCallerId.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setChannelVariableEClass, SetChannelVariable.class, "SetChannelVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetChannelVariable_Value(), theActionStepPackage.getDynamicValue(), null, "value", null, 0, 1, SetChannelVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSetChannelVariable_Variable(), ecorePackage.getEString(), "variable", null, 0, 1, SetChannelVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setContextEClass, SetContext.class, "SetContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetContext_Context(), theActionStepPackage.getDynamicValue(), null, "context", null, 0, 1, SetContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setExtensionEClass, SetExtension.class, "SetExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetExtension_Extension(), theActionStepPackage.getDynamicValue(), null, "extension", null, 0, 1, SetExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stopMusicOnHoldEClass, StopMusicOnHold.class, "StopMusicOnHold", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(setMusicOnEClass, SetMusicOn.class, "SetMusicOn", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetMusicOn_HoldClass(), theActionStepPackage.getDynamicValue(), null, "holdClass", null, 0, 1, SetMusicOn.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setPriorityEClass, SetPriority.class, "SetPriority", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetPriority_Priority(), theActionStepPackage.getDynamicValue(), null, "priority", null, 0, 1, SetPriority.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(streamAudioEClass, StreamAudio.class, "StreamAudio", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStreamAudio_Filename(), theActionStepPackage.getDynamicValue(), null, "filename", null, 0, 1, StreamAudio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStreamAudio_EscapeDigits(), ecorePackage.getEString(), "escapeDigits", "#", 0, 1, StreamAudio.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(waitForDigitEClass, WaitForDigit.class, "WaitForDigit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWaitForDigit_Timeout(), ecorePackage.getELong(), "timeout", "-1", 0, 1, WaitForDigit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWaitForDigit_AcceptedDigits(), ecorePackage.getEString(), "acceptedDigits", "0123456789#", 0, 1, WaitForDigit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(originateCallEClass, OriginateCall.class, "OriginateCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOriginateCall_Async(), ecorePackage.getEBoolean(), "async", "false", 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOriginateCall_Account(), theActionStepPackage.getDynamicValue(), null, "account", null, 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOriginateCall_Application(), theActionStepPackage.getDynamicValue(), null, "application", null, 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOriginateCall_CallerId(), theActionStepPackage.getDynamicValue(), null, "callerId", null, 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOriginateCall_Context(), theActionStepPackage.getDynamicValue(), null, "context", null, 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOriginateCall_Data(), theActionStepPackage.getDynamicValue(), null, "data", null, 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOriginateCall_Extension(), theActionStepPackage.getDynamicValue(), null, "extension", null, 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOriginateCall_Priority(), ecorePackage.getEInt(), "priority", "1", 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOriginateCall_Timeout(), ecorePackage.getELong(), "timeout", null, 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOriginateCall_CallingPresentation(), ecorePackage.getEInt(), "callingPresentation", "1", 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOriginateCall_Channel(), theActionStepPackage.getDynamicValue(), null, "channel", null, 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getOriginateCall_TakeControl(), ecorePackage.getEBoolean(), "takeControl", "false", 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getOriginateCall_Variables(), theActionStepPackage.getDynamicValue(), null, "variables", null, 0, 1, OriginateCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(originateCallEClass, null, "setVariable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(playDTMFEClass, PlayDTMF.class, "PlayDTMF", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlayDTMF_Digits(), theActionStepPackage.getDynamicValue(), null, "digits", null, 0, 1, PlayDTMF.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(recordCallEClass, RecordCall.class, "RecordCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRecordCall_Filename(), theActionStepPackage.getDynamicValue(), null, "filename", null, 0, 1, RecordCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRecordCall_Format(), ecorePackage.getEString(), "format", "wav", 0, 1, RecordCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getRecordCall_Mix(), ecorePackage.getEBoolean(), "mix", "true", 0, 1, RecordCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(transferEClass, Transfer.class, "Transfer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTransfer_Context(), theActionStepPackage.getDynamicValue(), null, "context", null, 0, 1, Transfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTransfer_Extension(), theActionStepPackage.getDynamicValue(), null, "extension", null, 0, 1, Transfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTransfer_Priority(), ecorePackage.getEInt(), "priority", "1", 0, 1, Transfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(executeApplicationEClass, ExecuteApplication.class, "ExecuteApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExecuteApplication_Application(), ecorePackage.getEString(), "application", null, 0, 1, ExecuteApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExecuteApplication_Arguments(), theActionStepPackage.getDynamicValue(), null, "arguments", null, 0, 1, ExecuteApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(getCallInfoEClass, GetCallInfo.class, "GetCallInfo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGetCallInfo_AccountCodeVar(), theActionStepPackage.getDynamicValue(), null, "accountCodeVar", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_CallerIdNameVar(), theActionStepPackage.getDynamicValue(), null, "callerIdNameVar", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_CallerIdNumVar(), theActionStepPackage.getDynamicValue(), null, "callerIdNumVar", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_ChannelNameVar(), theActionStepPackage.getDynamicValue(), null, "channelNameVar", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_ContextVar(), theActionStepPackage.getDynamicValue(), null, "contextVar", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_ExtensionVar(), theActionStepPackage.getDynamicValue(), null, "extensionVar", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_DialedNumber(), theActionStepPackage.getDynamicValue(), null, "dialedNumber", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_PriorityVar(), theActionStepPackage.getDynamicValue(), null, "priorityVar", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_StateVar(), theActionStepPackage.getDynamicValue(), null, "stateVar", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_UniqueIdVar(), theActionStepPackage.getDynamicValue(), null, "uniqueIdVar", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_Ani2Var(), theActionStepPackage.getDynamicValue(), null, "ani2Var", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_Rdnis(), theActionStepPackage.getDynamicValue(), null, "rdnis", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetCallInfo_Type(), theActionStepPackage.getDynamicValue(), null, "type", null, 0, 1, GetCallInfo.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(playMusicOnHoldEClass, PlayMusicOnHold.class, "PlayMusicOnHold", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlayMusicOnHold_HoldClass(), theActionStepPackage.getDynamicValue(), null, "holdClass", null, 0, 1, PlayMusicOnHold.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(promptGetDigitsEClass, PromptGetDigits.class, "PromptGetDigits", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPromptGetDigits_Filename(), theActionStepPackage.getDynamicValue(), null, "filename", null, 0, 1, PromptGetDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPromptGetDigits_Timeout(), ecorePackage.getELong(), "timeout", null, 0, 1, PromptGetDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPromptGetDigits_VariableName(), theActionStepPackage.getDynamicValue(), null, "variableName", null, 0, 1, PromptGetDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPromptGetDigits_MaxDigits(), ecorePackage.getEInt(), "maxDigits", "1", 0, 1, PromptGetDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPromptGetDigits_UseBufferedDigits(), ecorePackage.getEBoolean(), "useBufferedDigits", null, 0, 1, PromptGetDigits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sleepEClass, Sleep.class, "Sleep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSleep_Duration(), ecorePackage.getELong(), "duration", null, 0, 1, Sleep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSleep_Native(), ecorePackage.getEBoolean(), "native", null, 0, 1, Sleep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(streamAudioExtendedEClass, StreamAudioExtended.class, "StreamAudioExtended", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStreamAudioExtended_Filename(), theActionStepPackage.getDynamicValue(), null, "filename", null, 0, 1, StreamAudioExtended.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStreamAudioExtended_EscapeDigits(), ecorePackage.getEString(), "escapeDigits", "#", 0, 1, StreamAudioExtended.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStreamAudioExtended_Offset(), ecorePackage.getEInt(), "offset", "1000", 0, 1, StreamAudioExtended.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStreamAudioExtended_ForwardDigit(), ecorePackage.getEString(), "forwardDigit", "3", 0, 1, StreamAudioExtended.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStreamAudioExtended_RewindDigit(), ecorePackage.getEString(), "rewindDigit", "1", 0, 1, StreamAudioExtended.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getStreamAudioExtended_PauseDigit(), ecorePackage.getEString(), "pauseDigit", "2", 0, 1, StreamAudioExtended.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dialEClass, Dial.class, "Dial", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDial_OutgoingChannels(), theActionStepPackage.getDynamicValue(), null, "outgoingChannels", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_Retry(), ecorePackage.getEBoolean(), "retry", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_Timeout(), ecorePackage.getEInt(), "timeout", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_CalleeBlindTransfer(), ecorePackage.getEBoolean(), "calleeBlindTransfer", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_CallerBlindTransfer(), ecorePackage.getEBoolean(), "callerBlindTransfer", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_GenerateRingTone(), ecorePackage.getEBoolean(), "generateRingTone", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_RingCallee(), ecorePackage.getEBoolean(), "ringCallee", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_CalleeMusicOnHold(), ecorePackage.getEBoolean(), "calleeMusicOnHold", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_Private(), ecorePackage.getEBoolean(), "private", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_UseOldCallerID(), ecorePackage.getEBoolean(), "useOldCallerID", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_JumpPriority(), ecorePackage.getEBoolean(), "jumpPriority", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_Macro(), ecorePackage.getEString(), "macro", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_CalleeStarHangup(), ecorePackage.getEBoolean(), "calleeStarHangup", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_CallerStarHangup(), ecorePackage.getEBoolean(), "callerStarHangup", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_IgnoreForwardingRequests(), ecorePackage.getEBoolean(), "ignoreForwardingRequests", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_ResetCDR(), ecorePackage.getEBoolean(), "resetCDR", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_EnableScreeningMode(), ecorePackage.getEBoolean(), "enableScreeningMode", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_UsePrivacyManager(), ecorePackage.getEBoolean(), "usePrivacyManager", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_PrivaceManagerDB(), ecorePackage.getEString(), "privaceManagerDB", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_StayAlive(), ecorePackage.getEBoolean(), "stayAlive", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_Announcement(), ecorePackage.getEString(), "announcement", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_AutoHangupTime(), ecorePackage.getEInt(), "autoHangupTime", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_CaptureDTMF(), ecorePackage.getEBoolean(), "captureDTMF", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_DTMFDigits(), ecorePackage.getEString(), "dTMFDigits", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_MaxDuration(), ecorePackage.getEInt(), "maxDuration", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_CallEndingWarningTime(), ecorePackage.getEInt(), "callEndingWarningTime", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_WarningRepeatTime(), ecorePackage.getEInt(), "warningRepeatTime", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_LimitPlayAudioCaller(), ecorePackage.getEBoolean(), "limitPlayAudioCaller", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_LimitPlayAudioCallee(), ecorePackage.getEBoolean(), "limitPlayAudioCallee", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_LimitTimeoutFilename(), ecorePackage.getEString(), "limitTimeoutFilename", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_LimitConnectFilename(), ecorePackage.getEString(), "limitConnectFilename", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_LimitWarningFilename(), ecorePackage.getEString(), "limitWarningFilename", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_ForceOutgoingCallID(), ecorePackage.getEBoolean(), "forceOutgoingCallID", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_CalleeCanRecord(), ecorePackage.getEBoolean(), "calleeCanRecord", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_CallerCanRecord(), ecorePackage.getEBoolean(), "callerCanRecord", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_CalleeCanPark(), ecorePackage.getEBoolean(), "calleeCanPark", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDial_CallerCanPark(), ecorePackage.getEBoolean(), "callerCanPark", null, 0, 1, Dial.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pickupEClass, Pickup.class, "Pickup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPickup_Group(), ecorePackage.getEString(), "group", null, 0, 1, Pickup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(backgroundEClass, Background.class, "Background", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBackground_Filenames(), theActionStepPackage.getDynamicValue(), null, "filenames", null, 0, 1, Background.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBackground_PlayOnlyIfAnswered(), ecorePackage.getEBoolean(), "playOnlyIfAnswered", null, 0, 1, Background.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBackground_AnswerIfNecessary(), ecorePackage.getEBoolean(), "answerIfNecessary", "true", 0, 1, Background.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBackground_MatchOnlySingleDigit(), ecorePackage.getEBoolean(), "matchOnlySingleDigit", null, 0, 1, Background.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBackground_Context(), ecorePackage.getEString(), "context", null, 0, 1, Background.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(backgroundDetectEClass, BackgroundDetect.class, "BackgroundDetect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBackgroundDetect_Filename(), ecorePackage.getEString(), "filename", null, 0, 1, BackgroundDetect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBackgroundDetect_Silence(), ecorePackage.getEInt(), "silence", "1000", 0, 1, BackgroundDetect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBackgroundDetect_MinTime(), ecorePackage.getEInt(), "minTime", "100", 0, 1, BackgroundDetect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBackgroundDetect_MaxTime(), ecorePackage.getEInt(), "maxTime", null, 0, 1, BackgroundDetect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(waitExtenEClass, WaitExten.class, "WaitExten", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWaitExten_MusicOnHoldClass(), ecorePackage.getEString(), "musicOnHoldClass", null, 0, 1, WaitExten.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getWaitExten_Timeout(), ecorePackage.getEInt(), "timeout", null, 0, 1, WaitExten.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(softHangupEClass, SoftHangup.class, "SoftHangup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSoftHangup_HangupAllDeviceCalls(), ecorePackage.getEBoolean(), "hangupAllDeviceCalls", null, 0, 1, SoftHangup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSoftHangup_ChannelName(), theActionStepPackage.getDynamicValue(), null, "channelName", null, 0, 1, SoftHangup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pickupChanEClass, PickupChan.class, "PickupChan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPickupChan_Channels(), theActionStepPackage.getDynamicValue(), null, "channels", null, 0, 1, PickupChan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pickdownEClass, Pickdown.class, "Pickdown", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPickdown_Group(), ecorePackage.getEString(), "group", null, 0, 1, Pickdown.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(progressEClass, Progress.class, "Progress", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bridgeEClass, Bridge.class, "Bridge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBridge_Channel1(), theActionStepPackage.getDynamicValue(), null, "channel1", null, 0, 1, Bridge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBridge_Channel2(), theActionStepPackage.getDynamicValue(), null, "channel2", null, 0, 1, Bridge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getBridge_UseCourtesyTone(), ecorePackage.getEBoolean(), "useCourtesyTone", null, 0, 1, Bridge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(placeCallEClass, PlaceCall.class, "PlaceCall", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlaceCall_Extension(), theActionStepPackage.getDynamicValue(), null, "extension", null, 0, 1, PlaceCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPlaceCall_Context(), theActionStepPackage.getDynamicValue(), null, "context", null, 0, 1, PlaceCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPlaceCall_Timeout(), ecorePackage.getELong(), "timeout", null, 0, 1, PlaceCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPlaceCall_CallerId(), theActionStepPackage.getDynamicValue(), null, "callerId", null, 0, 1, PlaceCall.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(voicemailEClass, Voicemail.class, "Voicemail", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVoicemail_Mailbox(), theActionStepPackage.getDynamicValue(), null, "mailbox", null, 0, 1, Voicemail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVoicemail_SkipInstructions(), ecorePackage.getEBoolean(), "skipInstructions", null, 0, 1, Voicemail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVoicemail_PlayUnavailableMessage(), ecorePackage.getEBoolean(), "playUnavailableMessage", null, 0, 1, Voicemail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVoicemail_PlayBusyMessage(), ecorePackage.getEBoolean(), "playBusyMessage", null, 0, 1, Voicemail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVoicemail_RecordingGain(), ecorePackage.getEInt(), "recordingGain", "-1", 0, 1, Voicemail.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(voicemailMainEClass, VoicemailMain.class, "VoicemailMain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVoicemailMain_Mailbox(), theActionStepPackage.getDynamicValue(), null, "mailbox", null, 0, 1, VoicemailMain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVoicemailMain_SkipPasswordCheck(), ecorePackage.getEBoolean(), "skipPasswordCheck", null, 0, 1, VoicemailMain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVoicemailMain_UsePrefix(), ecorePackage.getEBoolean(), "usePrefix", null, 0, 1, VoicemailMain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVoicemailMain_RecordingGain(), ecorePackage.getEInt(), "recordingGain", null, 0, 1, VoicemailMain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVoicemailMain_DefaultFolder(), theActionStepPackage.getDynamicValue(), null, "defaultFolder", null, 0, 1, VoicemailMain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(vmAuthenticateEClass, VMAuthenticate.class, "VMAuthenticate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVMAuthenticate_Mailbox(), theActionStepPackage.getDynamicValue(), null, "mailbox", null, 0, 1, VMAuthenticate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVMAuthenticate_SkipInstructions(), ecorePackage.getEBoolean(), "skipInstructions", null, 0, 1, VMAuthenticate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVMAuthenticate_SetAccountCode(), ecorePackage.getEBoolean(), "setAccountCode", null, 0, 1, VMAuthenticate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(meetMeEClass, MeetMe.class, "MeetMe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeetMe_ConferenceNumber(), theActionStepPackage.getDynamicValue(), null, "conferenceNumber", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeetMe_Pin(), theActionStepPackage.getDynamicValue(), null, "pin", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_BackgroundScriptAgi(), ecorePackage.getEString(), "backgroundScriptAgi", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_RecordingFilename(), ecorePackage.getEString(), "recordingFilename", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_RecordingFormat(), ecorePackage.getEString(), "recordingFormat", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_AloneMessageEnabled(), ecorePackage.getEBoolean(), "aloneMessageEnabled", "true", 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_AdminMode(), ecorePackage.getEBoolean(), "adminMode", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_UseAGIScript(), ecorePackage.getEBoolean(), "useAGIScript", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_AnnounceCount(), ecorePackage.getEBoolean(), "announceCount", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_DynamicallyAddConference(), ecorePackage.getEBoolean(), "dynamicallyAddConference", "true", 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_SelectEmptyConference(), ecorePackage.getEBoolean(), "selectEmptyConference", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_SelectEmptyPinlessConference(), ecorePackage.getEBoolean(), "selectEmptyPinlessConference", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_PassDTMF(), ecorePackage.getEBoolean(), "passDTMF", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_AnnounceJoinLeave(), ecorePackage.getEBoolean(), "announceJoinLeave", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_AnnounceJoinLeaveNoReview(), ecorePackage.getEBoolean(), "announceJoinLeaveNoReview", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_UseMusicOnHold(), ecorePackage.getEBoolean(), "useMusicOnHold", "true", 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_MonitorOnlyMode(), ecorePackage.getEBoolean(), "monitorOnlyMode", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_AllowPoundUserExit(), ecorePackage.getEBoolean(), "allowPoundUserExit", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_AlwaysPromptForPin(), ecorePackage.getEBoolean(), "alwaysPromptForPin", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_QuietMode(), ecorePackage.getEBoolean(), "quietMode", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_RecordConference(), ecorePackage.getEBoolean(), "recordConference", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_PlayMenuOnStar(), ecorePackage.getEBoolean(), "playMenuOnStar", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_TalkOnlyMode(), ecorePackage.getEBoolean(), "talkOnlyMode", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_TalkerDetection(), ecorePackage.getEBoolean(), "talkerDetection", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_VideoMode(), ecorePackage.getEBoolean(), "videoMode", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_WaitForMarkedUser(), ecorePackage.getEBoolean(), "waitForMarkedUser", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_ExitOnExtensionEntered(), ecorePackage.getEBoolean(), "exitOnExtensionEntered", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMe_CloseOnLastMarkedUserExit(), ecorePackage.getEBoolean(), "closeOnLastMarkedUserExit", null, 0, 1, MeetMe.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(meetMeAdminEClass, MeetMeAdmin.class, "MeetMeAdmin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeetMeAdmin_ConferenceNumber(), theActionStepPackage.getDynamicValue(), null, "conferenceNumber", null, 0, 1, MeetMeAdmin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMeetMeAdmin_Command(), this.getMeetMeAdminCommand(), "command", null, 0, 1, MeetMeAdmin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeetMeAdmin_User(), theActionStepPackage.getDynamicValue(), null, "user", null, 0, 1, MeetMeAdmin.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(meetMeCountEClass, MeetMeCount.class, "MeetMeCount", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeetMeCount_ConferenceNumber(), theActionStepPackage.getDynamicValue(), null, "conferenceNumber", null, 0, 1, MeetMeCount.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeetMeCount_VariableName(), theActionStepPackage.getDynamicValue(), null, "variableName", null, 0, 1, MeetMeCount.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(waitForRingEClass, WaitForRing.class, "WaitForRing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWaitForRing_Duration(), ecorePackage.getEInt(), "duration", null, 0, 1, WaitForRing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(waitMusicOnHoldEClass, WaitMusicOnHold.class, "WaitMusicOnHold", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWaitMusicOnHold_Duration(), ecorePackage.getEInt(), "duration", null, 0, 1, WaitMusicOnHold.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(getAvailableChannelEClass, GetAvailableChannel.class, "GetAvailableChannel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGetAvailableChannel_Channels(), theActionStepPackage.getDynamicValue(), null, "channels", null, 0, 1, GetAvailableChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getGetAvailableChannel_VariableName(), theActionStepPackage.getDynamicValue(), null, "variableName", null, 0, 1, GetAvailableChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGetAvailableChannel_IgnoreInUse(), ecorePackage.getEBoolean(), "ignoreInUse", null, 0, 1, GetAvailableChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getGetAvailableChannel_JumpPriorityOnFail(), ecorePackage.getEBoolean(), "jumpPriorityOnFail", null, 0, 1, GetAvailableChannel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(congestionEClass, Congestion.class, "Congestion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(ringingEClass, Ringing.class, "Ringing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRinging_Duration(), ecorePackage.getEInt(), "duration", null, 0, 1, Ringing.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setCallerPresentationEClass, SetCallerPresentation.class, "SetCallerPresentation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSetCallerPresentation_Presentation(), this.getPresentationType(), "presentation", "allowed", 0, 1, SetCallerPresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(setGlobalVariableEClass, SetGlobalVariable.class, "SetGlobalVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSetGlobalVariable_Value(), theActionStepPackage.getDynamicValue(), null, "value", null, 0, 1, SetGlobalVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getSetGlobalVariable_Variable(), ecorePackage.getEString(), "variable", null, 0, 1, SetGlobalVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(echoEClass, Echo.class, "Echo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(festivalEClass, Festival.class, "Festival", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFestival_Text(), theActionStepPackage.getDynamicValue(), null, "text", null, 0, 1, Festival.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFestival_InterruptKeys(), ecorePackage.getEString(), "interruptKeys", null, 0, 1, Festival.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(playtonesEClass, Playtones.class, "Playtones", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPlaytones_Tones(), theActionStepPackage.getDynamicValue(), null, "tones", null, 0, 1, Playtones.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stopPlaytonesEClass, StopPlaytones.class, "StopPlaytones", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(chanSpyEClass, ChanSpy.class, "ChanSpy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getChanSpy_ChannelnamePrefix(), theActionStepPackage.getDynamicValue(), null, "channelnamePrefix", null, 0, 1, ChanSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChanSpy_SpyBridgedOnly(), ecorePackage.getEBoolean(), "spyBridgedOnly", null, 0, 1, ChanSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChanSpy_Group(), ecorePackage.getEString(), "group", null, 0, 1, ChanSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChanSpy_Beep(), ecorePackage.getEBoolean(), "beep", "true", 0, 1, ChanSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChanSpy_RecordFilenamePrefix(), ecorePackage.getEString(), "recordFilenamePrefix", null, 0, 1, ChanSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChanSpy_Volume(), ecorePackage.getEInt(), "volume", null, 0, 1, ChanSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChanSpy_WhisperEnabled(), ecorePackage.getEBoolean(), "whisperEnabled", null, 0, 1, ChanSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getChanSpy_PrivateWhisperEnabled(), ecorePackage.getEBoolean(), "privateWhisperEnabled", null, 0, 1, ChanSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(dictateEClass, Dictate.class, "Dictate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDictate_Directory(), theActionStepPackage.getDynamicValue(), null, "directory", null, 0, 1, Dictate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDictate_Filename(), theActionStepPackage.getDynamicValue(), null, "filename", null, 0, 1, Dictate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(extensionSpyEClass, ExtensionSpy.class, "ExtensionSpy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensionSpy_Extension(), theActionStepPackage.getDynamicValue(), null, "extension", null, 0, 1, ExtensionSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtensionSpy_Context(), theActionStepPackage.getDynamicValue(), null, "context", null, 0, 1, ExtensionSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionSpy_SpyBridgedOnly(), ecorePackage.getEBoolean(), "spyBridgedOnly", null, 0, 1, ExtensionSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionSpy_Group(), ecorePackage.getEString(), "group", null, 0, 1, ExtensionSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionSpy_Beep(), ecorePackage.getEBoolean(), "beep", "true", 0, 1, ExtensionSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionSpy_RecordFilenamePrefix(), ecorePackage.getEString(), "recordFilenamePrefix", null, 0, 1, ExtensionSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionSpy_Volume(), ecorePackage.getEInt(), "volume", null, 0, 1, ExtensionSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionSpy_WhisperEnabled(), ecorePackage.getEBoolean(), "whisperEnabled", null, 0, 1, ExtensionSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionSpy_PrivateWhisperEnabled(), ecorePackage.getEBoolean(), "privateWhisperEnabled", null, 0, 1, ExtensionSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtensionSpy_ChannelName(), theActionStepPackage.getDynamicValue(), null, "channelName", null, 0, 1, ExtensionSpy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(mixMonitorEClass, MixMonitor.class, "MixMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMixMonitor_Filename(), theActionStepPackage.getDynamicValue(), null, "filename", null, 0, 1, MixMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMixMonitor_RecordOnlyWhenBridged(), ecorePackage.getEBoolean(), "recordOnlyWhenBridged", null, 0, 1, MixMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMixMonitor_AppendMode(), ecorePackage.getEBoolean(), "appendMode", null, 0, 1, MixMonitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(stopMixmonitorEClass, StopMixmonitor.class, "StopMixmonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stopMonitorEClass, StopMonitor.class, "StopMonitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(monitorEClass, Monitor.class, "Monitor", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMonitor_FilenamePrefix(), theActionStepPackage.getDynamicValue(), null, "filenamePrefix", null, 0, 1, Monitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMonitor_Format(), ecorePackage.getEString(), "format", "wav", 0, 1, Monitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMonitor_Mix(), ecorePackage.getEBoolean(), "mix", null, 0, 1, Monitor.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(directoryEClass, Directory.class, "Directory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDirectory_VMContext(), theActionStepPackage.getDynamicValue(), null, "vMContext", null, 0, 1, Directory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDirectory_DialContext(), theActionStepPackage.getDynamicValue(), null, "dialContext", null, 0, 1, Directory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDirectory_ReadExtensionNumber(), ecorePackage.getEBoolean(), "readExtensionNumber", null, 0, 1, Directory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDirectory_EnterByFirstName(), ecorePackage.getEBoolean(), "enterByFirstName", null, 0, 1, Directory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getDirectory_EnterByFirstOrLastName(), ecorePackage.getEBoolean(), "enterByFirstOrLastName", null, 0, 1, Directory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(extensionTransferEClass, ExtensionTransfer.class, "ExtensionTransfer", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtensionTransfer_Context(), theActionStepPackage.getDynamicValue(), null, "context", null, 0, 1, ExtensionTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtensionTransfer_Extension(), theActionStepPackage.getDynamicValue(), null, "extension", null, 0, 1, ExtensionTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionTransfer_Priority(), ecorePackage.getEInt(), "priority", "1", 0, 1, ExtensionTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionTransfer_Timeout(), ecorePackage.getELong(), "timeout", null, 0, 1, ExtensionTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtensionTransfer_Options(), theActionStepPackage.getDynamicValue(), null, "options", null, 0, 1, ExtensionTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExtensionTransfer_DoPreExtenStatusCheck(), ecorePackage.getEBoolean(), "doPreExtenStatusCheck", null, 0, 1, ExtensionTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtensionTransfer_ChannelType(), theActionStepPackage.getDynamicValue(), null, "channelType", null, 0, 1, ExtensionTransfer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(meetMeAdminCommandEEnum, MeetMeAdminCommand.class, "MeetMeAdminCommand");
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.EJECT_LAST_USER);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.KICK_ONE_USER);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.KICK_ALL_USERS);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.UNLOCK);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.LOCK);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.UNMUTE_USER);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.MUTE_USER);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.UNMUTE_ALL_USERS);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.MUTE_NON_ADMIN);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.RESET_USER_VOLUME);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.RESET_ALL_USERS_VOLUME);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.LOWER_CONF_SPEAK_VOLUME);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.RAISE_CONF_SPEAK_VOLUME);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.LOWER_CONF_LISTEN_VOLUME);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.RAISE_CONF_LISTEN_VOLUME);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.LOWER_USER_TALK_VOLUME);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.RAISE_USER_TALK_VOLUME);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.LOWER_USER_LISTEN_VOLUME);
		addEEnumLiteral(meetMeAdminCommandEEnum, MeetMeAdminCommand.RAISE_USER_LISTEN_VOLUME);

		initEEnum(presentationTypeEEnum, PresentationType.class, "PresentationType");
		addEEnumLiteral(presentationTypeEEnum, PresentationType.ALLOWED);
		addEEnumLiteral(presentationTypeEEnum, PresentationType.ALLOWED_NOT_SCREENED);
		addEEnumLiteral(presentationTypeEEnum, PresentationType.ALLOWED_PASSED_SCREEN);
		addEEnumLiteral(presentationTypeEEnum, PresentationType.ALLOWED_FAILED_SCREEN);
		addEEnumLiteral(presentationTypeEEnum, PresentationType.PROHIB_NOT_SCREENED);
		addEEnumLiteral(presentationTypeEEnum, PresentationType.PROHIB_PASSED_SCREEN);
		addEEnumLiteral(presentationTypeEEnum, PresentationType.PROHIB_FAILED_SCREEN);
		addEEnumLiteral(presentationTypeEEnum, PresentationType.PROHIB);
		addEEnumLiteral(presentationTypeEEnum, PresentationType.UNAVAILABLE);

		// Initialize data types
		initEDataType(mapEDataType, Map.class, "Map", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(basicEMapEDataType, BasicEMap.class, "BasicEMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create annotations
		// unitsTime
		createUnitsTimeAnnotations();
		// DynamicValueAnnotation
		createDynamicValueAnnotationAnnotations();
		// Directionality
		createDirectionalityAnnotations();
		// MetaProperty
		createMetaPropertyAnnotations();
		// Required
		createRequiredAnnotations();
	}

  /**
	 * Initializes the annotations for <b>unitsTime</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createUnitsTimeAnnotations() {
		String source = "unitsTime";		
		addAnnotation
		  (getGetDigits_InputTimeout(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });													
		addAnnotation
		  (getRecordFile_Timeout(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });		
		addAnnotation
		  (getRecordFile_MaxSilence(), 
		   source, 
		   new String[] {
			 "seconds", "true"
		   });												
		addAnnotation
		  (getSetAutoHangup_Time(), 
		   source, 
		   new String[] {
			 "seconds", "true"
		   });																		
		addAnnotation
		  (getWaitForDigit_Timeout(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });										
		addAnnotation
		  (getOriginateCall_Timeout(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });																																								
		addAnnotation
		  (getPromptGetDigits_Timeout(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });					
		addAnnotation
		  (getSleep_Duration(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });							
		addAnnotation
		  (getDial_Timeout(), 
		   source, 
		   new String[] {
			 "seconds", "true"
		   });		
		addAnnotation
		  (getDial_AutoHangupTime(), 
		   source, 
		   new String[] {
			 "seconds", "true"
		   });		
		addAnnotation
		  (getDial_MaxDuration(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });		
		addAnnotation
		  (getDial_CallEndingWarningTime(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });		
		addAnnotation
		  (getDial_WarningRepeatTime(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });				
		addAnnotation
		  (getBackgroundDetect_Silence(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });		
		addAnnotation
		  (getBackgroundDetect_MinTime(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });		
		addAnnotation
		  (getBackgroundDetect_MaxTime(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });		
		addAnnotation
		  (getWaitExten_Timeout(), 
		   source, 
		   new String[] {
			 "seconds", "true"
		   });													
		addAnnotation
		  (getPlaceCall_Timeout(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });																							
		addAnnotation
		  (getWaitForRing_Duration(), 
		   source, 
		   new String[] {
			 "seconds", "true"
		   });		
		addAnnotation
		  (getWaitMusicOnHold_Duration(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });							
		addAnnotation
		  (getRinging_Duration(), 
		   source, 
		   new String[] {
			 "milliseconds", "true"
		   });																							
		addAnnotation
		  (getExtensionTransfer_Timeout(), 
		   source, 
		   new String[] {
			 "seconds", "true"
		   });		
	}

  /**
	 * Initializes the annotations for <b>DynamicValueAnnotation</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createDynamicValueAnnotationAnnotations() {
		String source = "DynamicValueAnnotation";			
		addAnnotation
		  (getGetDigits_VariableName(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The assignee variable",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });					
		addAnnotation
		  (getGetFullVariable_AssignToVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable owning the value that will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });				
		addAnnotation
		  (getMultiStreamAudio_EscapeDigits(), 
		   source, 
		   new String[] {
			 "type", "ScriptText",
			 "isTypeLocked", "false",
			 "description", "DTMF characters that will cause the audio playback to stop",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getRecordFile_File(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The name of the file that will be recorded (file extension omitted). ",
			 "expectedReturnType", "Text",
			 "helperClass", "com.safi.workshop.sheet.assist.FileBrowserAssistant"
		   });					
		addAnnotation
		  (getSayAlpha_Text(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The text to be verbalized letter by letter",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getSayDateTime_DateTime(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The date/time to be verbalized.  May be a number\r\n (representing the number of seconds since 1970) or text in the format\r\n (XX/yy/zzzz) or Date object or variable.",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getSayDigits_Digits(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The text containing only numeric values to be verbalized one digit at a time",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getSayNumber_Number(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The integer value between 0 and 99,999,999 to be verbalized. ",
			 "expectedReturnType", "Integer",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getSayPhonetic_Text(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The text value to be verbalized one letter at a time (eg.  alpha, bravo, charlie, etc)",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getSayTime_Time(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The date/time to be verbalized.  May be a number\r\n (representing the number of seconds since 1970) or text in the format\r\n (XX/yy/zzzz) or Date object or variable.",
			 "expectedReturnType", "Unknown",
			 "helperClass", ""
		   });				
		addAnnotation
		  (getSetCallerId_CallerId(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The  caller ID of the current call will be set to this text value.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getSetChannelVariable_Value(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The specified variable of the current call will be set to this text value.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });				
		addAnnotation
		  (getSetContext_Context(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The context of the current call will be set to this text value.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getSetExtension_Extension(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The extension of the current call will be set to this text value.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getSetMusicOn_HoldClass(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The Asterisk music class to play.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getSetPriority_Priority(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The priority of the current call will be set to this numeric value.",
			 "expectedReturnType", "Integer",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getStreamAudio_Filename(), 
		   source, 
		   new String[] {
			 "type", "Prompt Filename",
			 "isTypeLocked", "false",
			 "description", "The audio prompt file name that will be played",
			 "expectedReturnType", "Prompt Filename",
			 "helperClass", "com.safi.workshop.sheet.PromptChooserDynamicValueEditorPage"
		   });				
		addAnnotation
		  (getOriginateCall_Account(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The account code of the new call will be assigned this text value.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getOriginateCall_Application(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Application to use on connect (use Data for parameters)",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getOriginateCall_CallerId(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "CallerID to use for the call",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getOriginateCall_Context(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Context to use on connect (must use Exten & Priority with it)",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getOriginateCall_Data(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Data if Application parameter is used",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getOriginateCall_Extension(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Extension to use on connect (must use Context & Priority with it)",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getOriginateCall_Priority(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Priority to use on connect (must use Context & Exten with it)",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getOriginateCall_Channel(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Context to use on connect (must use Exten & Priority with it)",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getOriginateCall_Variables(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Array of variables to set [name1, value1, name2, value2...]",
			 "expectedReturnType", "Array",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getRecordCall_Filename(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The name of the file that will be recorded (file extension omitted). ",
			 "expectedReturnType", "Text",
			 "helperClass", "com.safi.workshop.sheet.assist.DirBrowserAssistant"
		   });			
		addAnnotation
		  (getTransfer_Context(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The context of the current call will be set to this text value.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getTransfer_Extension(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The context of the current call will be set to this text value.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });				
		addAnnotation
		  (getExecuteApplication_Arguments(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the parameters to pass to the application.  May be single text entry (ex. \"SIP/123\") or array or text. (ex. [\"Sip/123\",\"300\"...])",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getGetCallInfo_AccountCodeVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the account code of the current call will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_CallerIdNameVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the caller ID name of the current call will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_CallerIdNumVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the caller ID number of the current call will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_ChannelNameVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the channel name of the current call will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_ContextVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the context of the current call will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_ExtensionVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the extension of the current call will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_DialedNumber(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the dialed number (DNID) of the current call will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_PriorityVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the priority of the current call will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_StateVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the state (see below) of the current call will be assigned.\r\n    *  0 Channel is down and available\r\n    * 1 Channel is down, but reserved\r\n    * 2 Channel is off hook\r\n    * 3 Digits (or equivalent) have been dialed\r\n    * 4 Line is ringing\r\n    * 5 Remote end is ringing\r\n    * 6 Line is up\r\n    * 7 Line is busy ",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_UniqueIdVar(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the unique ID of the current call will be assigned.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_Ani2Var(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the ani2 info of the current call will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_Rdnis(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the forwarding number (RDNIS) of the current call will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getGetCallInfo_Type(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where the call type (e.g. SIP) of the current call will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getPlayMusicOnHold_HoldClass(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The Asterisk music class to play.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getPromptGetDigits_Filename(), 
		   source, 
		   new String[] {
			 "type", "Prompt Filename",
			 "isTypeLocked", "false",
			 "description", "The audio prompt file name that will be played",
			 "expectedReturnType", "Text",
			 "helperClass", "com.safi.workshop.sheet.PromptChooserDynamicValueEditorPage"
		   });			
		addAnnotation
		  (getPromptGetDigits_VariableName(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The variable name to where digits pressed will be assigned",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });						
		addAnnotation
		  (getStreamAudioExtended_Filename(), 
		   source, 
		   new String[] {
			 "type", "Prompt Filename",
			 "isTypeLocked", "false",
			 "description", "The audio prompt file name that will be played",
			 "expectedReturnType", "Prompt Filename",
			 "helperClass", "com.safi.workshop.sheet.PromptChooserDynamicValueEditorPage"
		   });			
		addAnnotation
		  (getDial_OutgoingChannels(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Array of channel names to attempt to dial",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });									
		addAnnotation
		  (getBackground_Filenames(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Array file names to play",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });						
		addAnnotation
		  (getSoftHangup_ChannelName(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Name of the channel to hangup",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getPickupChan_Channels(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "An array of channel names.  First one ringing will be chosen",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });				
		addAnnotation
		  (getBridge_Channel1(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Name of channel1",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getBridge_Channel2(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Name of channel2",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getPlaceCall_Extension(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Extension to call",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getPlaceCall_Context(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "Destination context ",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getPlaceCall_CallerId(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "CallerID to use for the call",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getVoicemail_Mailbox(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "an array of mailbox identifiers",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getVoicemailMain_Mailbox(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the mailbox name",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getVoicemailMain_DefaultFolder(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the mailbox folder name to default to. Default is \'INBOX\'",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getVMAuthenticate_Mailbox(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the mailbox name",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getMeetMe_ConferenceNumber(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the conference number",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getMeetMe_Pin(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the optional conference pin",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getMeetMeAdmin_ConferenceNumber(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the conference number",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getMeetMeAdmin_User(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the user at which the command will targeted (if applicable)",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getMeetMeCount_ConferenceNumber(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the conference number",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getMeetMeCount_VariableName(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the name of the variable in which to store the count",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });							
		addAnnotation
		  (getGetAvailableChannel_Channels(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the array of channels that will be iterated over",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getGetAvailableChannel_VariableName(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the name of the variable in which to store the name of the first available channel",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });						
		addAnnotation
		  (getSetGlobalVariable_Value(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the value to be assigned to the asterisk global variable",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });				
		addAnnotation
		  (getFestival_Text(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the text to be vocalized",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getPlaytones_Tones(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the tones or tone name to play",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getChanSpy_ChannelnamePrefix(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the prefix of the channel name to spy on",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getDictate_Directory(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the directory in which to store the audio files",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getDictate_Filename(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the filename (prefix) to use for the recorded files",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getExtensionSpy_Extension(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the extension of the channel name to spy on",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getExtensionSpy_Context(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The context of the channel to spy on",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getExtensionSpy_ChannelName(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the name of the channel name to spy on",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getMixMonitor_Filename(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the filename (prefix) to use for the recorded files",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getMonitor_FilenamePrefix(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the filename (prefix) to use for the recorded files",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getDirectory_VMContext(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the voicemail context",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getDirectory_DialContext(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "the dialed context",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getExtensionTransfer_Context(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The context of the current call will be set to this text value.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getExtensionTransfer_Extension(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "The context of the current call will be set to this text value.",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });			
		addAnnotation
		  (getExtensionTransfer_Options(), 
		   source, 
		   new String[] {
			 "type", "VariableName",
			 "isTypeLocked", "false",
			 "description", "A string containing Asterisk flags and parameters to be applied to the \'Dial\' command",
			 "expectedReturnType", "Text",
			 "helperClass", ""
		   });		
		addAnnotation
		  (getExtensionTransfer_ChannelType(), 
		   source, 
		   new String[] {
			 "type", "Channel Type",
			 "isTypeLocked", "false",
			 "description", "It should be one of the registered channel types, such as \"Zap\", \"SIP\", \"IAX2\", etc",
			 "expectedReturnType", "Text",
			 "helperClass", "com.safi.workshop.sheet.ChannelTypeDVEP",
			 "enumeratedValues", "Local, SIP, Zap, IAX2, MGCP, H.323, Modem, Phone, CAPI, ALSA, Skinny"
		   });
	}

  /**
	 * Initializes the annotations for <b>Directionality</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createDirectionalityAnnotations() {
		String source = "Directionality";				
		addAnnotation
		  (getGetDigits_VariableName(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });					
		addAnnotation
		  (getGetFullVariable_AssignToVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });																																																									
		addAnnotation
		  (getGetCallInfo_AccountCodeVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_CallerIdNameVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_CallerIdNumVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_ChannelNameVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_ContextVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_ExtensionVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_DialedNumber(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_PriorityVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_StateVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_UniqueIdVar(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_Ani2Var(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_Rdnis(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });			
		addAnnotation
		  (getGetCallInfo_Type(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });						
		addAnnotation
		  (getPromptGetDigits_VariableName(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });																																																			
		addAnnotation
		  (getMeetMeCount_VariableName(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });							
		addAnnotation
		  (getGetAvailableChannel_VariableName(), 
		   source, 
		   new String[] {
			 "output", "true"
		   });																											
	}

  /**
	 * Initializes the annotations for <b>MetaProperty</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createMetaPropertyAnnotations() {
		String source = "MetaProperty";					
		addAnnotation
		  (getGetDigits_VariableName(), 
		   source, 
		   new String[] {
			 "displayText", "Variable"
		   });																																																																																										
		addAnnotation
		  (getPromptGetDigits_VariableName(), 
		   source, 
		   new String[] {
			 "displayText", "Variable"
		   });																																																			
		addAnnotation
		  (getMeetMeCount_VariableName(), 
		   source, 
		   new String[] {
			 "displayText", "Variable"
		   });								
		addAnnotation
		  (getGetAvailableChannel_VariableName(), 
		   source, 
		   new String[] {
			 "displayText", "Variable"
		   });																									
	}

  /**
	 * Initializes the annotations for <b>Required</b>.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected void createRequiredAnnotations() {
		String source = "Required";						
		addAnnotation
		  (getGetFullVariable_Variable(), 
		   source, 
		   new String[] {
			 "criteria", "non-blank"
		   });				
		addAnnotation
		  (getGetFullVariable_AssignToVar(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getMultiStreamAudio_AudioFilenames(), 
		   source, 
		   new String[] {
			 "criteria", "non-empty"
		   });			
		addAnnotation
		  (getRecordFile_File(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });					
		addAnnotation
		  (getSayAlpha_Text(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });				
		addAnnotation
		  (getSayDigits_Digits(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getSayNumber_Number(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getSayPhonetic_Text(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });				
		addAnnotation
		  (getSetAutoHangup_Time(), 
		   source, 
		   new String[] {
			 "non-zero", "true"
		   });			
		addAnnotation
		  (getSetCallerId_CallerId(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getSetChannelVariable_Value(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getSetChannelVariable_Variable(), 
		   source, 
		   new String[] {
			 "criteria", "non-blank"
		   });			
		addAnnotation
		  (getSetContext_Context(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getSetExtension_Extension(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getSetMusicOn_HoldClass(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getSetPriority_Priority(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getStreamAudio_Filename(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });									
		addAnnotation
		  (getOriginateCall_Extension(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });						
		addAnnotation
		  (getPlayDTMF_Digits(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getRecordCall_Filename(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });				
		addAnnotation
		  (getTransfer_Extension(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getExecuteApplication_Application(), 
		   source, 
		   new String[] {
			 "criteria", "non-blank"
		   });																																				
		addAnnotation
		  (getSleep_Duration(), 
		   source, 
		   new String[] {
			 "non-zero", "true"
		   });			
		addAnnotation
		  (getStreamAudioExtended_Filename(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getDial_OutgoingChannels(), 
		   source, 
		   new String[] {
			 "criteria", "non-empty"
		   });							
		addAnnotation
		  (getPickup_Group(), 
		   source, 
		   new String[] {
			 "criteria", "non-blank"
		   });								
		addAnnotation
		  (getSoftHangup_ChannelName(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getPickupChan_Channels(), 
		   source, 
		   new String[] {
			 "criteria", "non-empty"
		   });		
		addAnnotation
		  (getPickdown_Group(), 
		   source, 
		   new String[] {
			 "criteria", "non-blank"
		   });				
		addAnnotation
		  (getBridge_Channel2(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getPlaceCall_Extension(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });						
		addAnnotation
		  (getVoicemail_Mailbox(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getVoicemailMain_Mailbox(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });				
		addAnnotation
		  (getVMAuthenticate_Mailbox(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getMeetMe_ConferenceNumber(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });				
		addAnnotation
		  (getMeetMeAdmin_ConferenceNumber(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getMeetMeAdmin_User(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getMeetMeCount_ConferenceNumber(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getMeetMeCount_VariableName(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });									
		addAnnotation
		  (getGetAvailableChannel_VariableName(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });					
		addAnnotation
		  (getSetGlobalVariable_Value(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });		
		addAnnotation
		  (getSetGlobalVariable_Variable(), 
		   source, 
		   new String[] {
			 "criteria", "non-blank"
		   });			
		addAnnotation
		  (getFestival_Text(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getPlaytones_Tones(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });			
		addAnnotation
		  (getChanSpy_ChannelnamePrefix(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });									
		addAnnotation
		  (getMonitor_FilenamePrefix(), 
		   source, 
		   new String[] {
			 "criteria", "non-null"
		   });							
	}

} //ActionstepPackageImpl
