package com.safi.workshop.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.core.actionstep.ActionStepPackage;
import com.safi.workshop.edit.parts.*;
import com.safi.workshop.parsers.MessageFormatParser;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated
 */
public class AsteriskParserProvider extends AbstractProvider implements IParserProvider {

  /**
   * @generated
   */
  private IParser answerName_4001Parser;

  /**
   * @generated
   */
  private IParser getAnswerName_4001Parser() {
    if (answerName_4001Parser == null) {
      answerName_4001Parser = createAnswerName_4001Parser();
    }
    return answerName_4001Parser;
  }

  /**
   * @generated
   */
  protected IParser createAnswerName_4001Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser assignmentName_4002Parser;

  /**
   * @generated
   */
  private IParser getAssignmentName_4002Parser() {
    if (assignmentName_4002Parser == null) {
      assignmentName_4002Parser = createAssignmentName_4002Parser();
    }
    return assignmentName_4002Parser;
  }

  /**
   * @generated
   */
  protected IParser createAssignmentName_4002Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser choiceName_4004Parser;

  /**
   * @generated
   */
  private IParser getChoiceName_4004Parser() {
    if (choiceName_4004Parser == null) {
      choiceName_4004Parser = createChoiceName_4004Parser();
    }
    return choiceName_4004Parser;
  }

  /**
   * @generated
   */
  protected IParser createChoiceName_4004Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser getFullVariableName_4005Parser;

  /**
   * @generated
   */
  private IParser getGetFullVariableName_4005Parser() {
    if (getFullVariableName_4005Parser == null) {
      getFullVariableName_4005Parser = createGetFullVariableName_4005Parser();
    }
    return getFullVariableName_4005Parser;
  }

  /**
   * @generated
   */
  protected IParser createGetFullVariableName_4005Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser multiStreamAudioName_4007Parser;

  /**
   * @generated
   */
  private IParser getMultiStreamAudioName_4007Parser() {
    if (multiStreamAudioName_4007Parser == null) {
      multiStreamAudioName_4007Parser = createMultiStreamAudioName_4007Parser();
    }
    return multiStreamAudioName_4007Parser;
  }

  /**
   * @generated
   */
  protected IParser createMultiStreamAudioName_4007Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser hangupName_4008Parser;

  /**
   * @generated
   */
  private IParser getHangupName_4008Parser() {
    if (hangupName_4008Parser == null) {
      hangupName_4008Parser = createHangupName_4008Parser();
    }
    return hangupName_4008Parser;
  }

  /**
   * @generated
   */
  protected IParser createHangupName_4008Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser ifThenName_4009Parser;

  /**
   * @generated
   */
  private IParser getIfThenName_4009Parser() {
    if (ifThenName_4009Parser == null) {
      ifThenName_4009Parser = createIfThenName_4009Parser();
    }
    return ifThenName_4009Parser;
  }

  /**
   * @generated
   */
  protected IParser createIfThenName_4009Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser recordFileName_4010Parser;

  /**
   * @generated
   */
  private IParser getRecordFileName_4010Parser() {
    if (recordFileName_4010Parser == null) {
      recordFileName_4010Parser = createRecordFileName_4010Parser();
    }
    return recordFileName_4010Parser;
  }

  /**
   * @generated
   */
  protected IParser createRecordFileName_4010Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser sayAlphaName_4011Parser;

  /**
   * @generated
   */
  private IParser getSayAlphaName_4011Parser() {
    if (sayAlphaName_4011Parser == null) {
      sayAlphaName_4011Parser = createSayAlphaName_4011Parser();
    }
    return sayAlphaName_4011Parser;
  }

  /**
   * @generated
   */
  protected IParser createSayAlphaName_4011Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser sayDateTimeName_4012Parser;

  /**
   * @generated
   */
  private IParser getSayDateTimeName_4012Parser() {
    if (sayDateTimeName_4012Parser == null) {
      sayDateTimeName_4012Parser = createSayDateTimeName_4012Parser();
    }
    return sayDateTimeName_4012Parser;
  }

  /**
   * @generated
   */
  protected IParser createSayDateTimeName_4012Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser sayDigitsName_4013Parser;

  /**
   * @generated
   */
  private IParser getSayDigitsName_4013Parser() {
    if (sayDigitsName_4013Parser == null) {
      sayDigitsName_4013Parser = createSayDigitsName_4013Parser();
    }
    return sayDigitsName_4013Parser;
  }

  /**
   * @generated
   */
  protected IParser createSayDigitsName_4013Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser sayNumberName_4014Parser;

  /**
   * @generated
   */
  private IParser getSayNumberName_4014Parser() {
    if (sayNumberName_4014Parser == null) {
      sayNumberName_4014Parser = createSayNumberName_4014Parser();
    }
    return sayNumberName_4014Parser;
  }

  /**
   * @generated
   */
  protected IParser createSayNumberName_4014Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser sayPhoneticName_4015Parser;

  /**
   * @generated
   */
  private IParser getSayPhoneticName_4015Parser() {
    if (sayPhoneticName_4015Parser == null) {
      sayPhoneticName_4015Parser = createSayPhoneticName_4015Parser();
    }
    return sayPhoneticName_4015Parser;
  }

  /**
   * @generated
   */
  protected IParser createSayPhoneticName_4015Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser sayTimeName_4016Parser;

  /**
   * @generated
   */
  private IParser getSayTimeName_4016Parser() {
    if (sayTimeName_4016Parser == null) {
      sayTimeName_4016Parser = createSayTimeName_4016Parser();
    }
    return sayTimeName_4016Parser;
  }

  /**
   * @generated
   */
  protected IParser createSayTimeName_4016Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setAutoHangupName_4017Parser;

  /**
   * @generated
   */
  private IParser getSetAutoHangupName_4017Parser() {
    if (setAutoHangupName_4017Parser == null) {
      setAutoHangupName_4017Parser = createSetAutoHangupName_4017Parser();
    }
    return setAutoHangupName_4017Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetAutoHangupName_4017Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setCallerIdName_4018Parser;

  /**
   * @generated
   */
  private IParser getSetCallerIdName_4018Parser() {
    if (setCallerIdName_4018Parser == null) {
      setCallerIdName_4018Parser = createSetCallerIdName_4018Parser();
    }
    return setCallerIdName_4018Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetCallerIdName_4018Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setChannelVariableName_4019Parser;

  /**
   * @generated
   */
  private IParser getSetChannelVariableName_4019Parser() {
    if (setChannelVariableName_4019Parser == null) {
      setChannelVariableName_4019Parser = createSetChannelVariableName_4019Parser();
    }
    return setChannelVariableName_4019Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetChannelVariableName_4019Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setContextName_4020Parser;

  /**
   * @generated
   */
  private IParser getSetContextName_4020Parser() {
    if (setContextName_4020Parser == null) {
      setContextName_4020Parser = createSetContextName_4020Parser();
    }
    return setContextName_4020Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetContextName_4020Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setExtensionName_4021Parser;

  /**
   * @generated
   */
  private IParser getSetExtensionName_4021Parser() {
    if (setExtensionName_4021Parser == null) {
      setExtensionName_4021Parser = createSetExtensionName_4021Parser();
    }
    return setExtensionName_4021Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetExtensionName_4021Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser stopMusicOnHoldName_4022Parser;

  /**
   * @generated
   */
  private IParser getStopMusicOnHoldName_4022Parser() {
    if (stopMusicOnHoldName_4022Parser == null) {
      stopMusicOnHoldName_4022Parser = createStopMusicOnHoldName_4022Parser();
    }
    return stopMusicOnHoldName_4022Parser;
  }

  /**
   * @generated
   */
  protected IParser createStopMusicOnHoldName_4022Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setMusicOnName_4023Parser;

  /**
   * @generated
   */
  private IParser getSetMusicOnName_4023Parser() {
    if (setMusicOnName_4023Parser == null) {
      setMusicOnName_4023Parser = createSetMusicOnName_4023Parser();
    }
    return setMusicOnName_4023Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetMusicOnName_4023Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setPriorityName_4024Parser;

  /**
   * @generated
   */
  private IParser getSetPriorityName_4024Parser() {
    if (setPriorityName_4024Parser == null) {
      setPriorityName_4024Parser = createSetPriorityName_4024Parser();
    }
    return setPriorityName_4024Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetPriorityName_4024Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser streamAudioName_4025Parser;

  /**
   * @generated
   */
  private IParser getStreamAudioName_4025Parser() {
    if (streamAudioName_4025Parser == null) {
      streamAudioName_4025Parser = createStreamAudioName_4025Parser();
    }
    return streamAudioName_4025Parser;
  }

  /**
   * @generated
   */
  protected IParser createStreamAudioName_4025Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser waitForDigitName_4026Parser;

  /**
   * @generated
   */
  private IParser getWaitForDigitName_4026Parser() {
    if (waitForDigitName_4026Parser == null) {
      waitForDigitName_4026Parser = createWaitForDigitName_4026Parser();
    }
    return waitForDigitName_4026Parser;
  }

  /**
   * @generated
   */
  protected IParser createWaitForDigitName_4026Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser dIDMatcherName_4027Parser;

  /**
   * @generated
   */
  private IParser getDIDMatcherName_4027Parser() {
    if (dIDMatcherName_4027Parser == null) {
      dIDMatcherName_4027Parser = createDIDMatcherName_4027Parser();
    }
    return dIDMatcherName_4027Parser;
  }

  /**
   * @generated
   */
  protected IParser createDIDMatcherName_4027Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser getDigitsName_4028Parser;

  /**
   * @generated
   */
  private IParser getGetDigitsName_4028Parser() {
    if (getDigitsName_4028Parser == null) {
      getDigitsName_4028Parser = createGetDigitsName_4028Parser();
    }
    return getDigitsName_4028Parser;
  }

  /**
   * @generated
   */
  protected IParser createGetDigitsName_4028Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser originateCallName_4029Parser;

  /**
   * @generated
   */
  private IParser getOriginateCallName_4029Parser() {
    if (originateCallName_4029Parser == null) {
      originateCallName_4029Parser = createOriginateCallName_4029Parser();
    }
    return originateCallName_4029Parser;
  }

  /**
   * @generated
   */
  protected IParser createOriginateCallName_4029Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser playDTMFName_4030Parser;

  /**
   * @generated
   */
  private IParser getPlayDTMFName_4030Parser() {
    if (playDTMFName_4030Parser == null) {
      playDTMFName_4030Parser = createPlayDTMFName_4030Parser();
    }
    return playDTMFName_4030Parser;
  }

  /**
   * @generated
   */
  protected IParser createPlayDTMFName_4030Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser recordCallName_4031Parser;

  /**
   * @generated
   */
  private IParser getRecordCallName_4031Parser() {
    if (recordCallName_4031Parser == null) {
      recordCallName_4031Parser = createRecordCallName_4031Parser();
    }
    return recordCallName_4031Parser;
  }

  /**
   * @generated
   */
  protected IParser createRecordCallName_4031Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser executeApplicationName_4032Parser;

  /**
   * @generated
   */
  private IParser getExecuteApplicationName_4032Parser() {
    if (executeApplicationName_4032Parser == null) {
      executeApplicationName_4032Parser = createExecuteApplicationName_4032Parser();
    }
    return executeApplicationName_4032Parser;
  }

  /**
   * @generated
   */
  protected IParser createExecuteApplicationName_4032Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser playMusicOnHoldName_4033Parser;

  /**
   * @generated
   */
  private IParser getPlayMusicOnHoldName_4033Parser() {
    if (playMusicOnHoldName_4033Parser == null) {
      playMusicOnHoldName_4033Parser = createPlayMusicOnHoldName_4033Parser();
    }
    return playMusicOnHoldName_4033Parser;
  }

  /**
   * @generated
   */
  protected IParser createPlayMusicOnHoldName_4033Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser promptGetDigitsName_4034Parser;

  /**
   * @generated
   */
  private IParser getPromptGetDigitsName_4034Parser() {
    if (promptGetDigitsName_4034Parser == null) {
      promptGetDigitsName_4034Parser = createPromptGetDigitsName_4034Parser();
    }
    return promptGetDigitsName_4034Parser;
  }

  /**
   * @generated
   */
  protected IParser createPromptGetDigitsName_4034Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser sleepName_4035Parser;

  /**
   * @generated
   */
  private IParser getSleepName_4035Parser() {
    if (sleepName_4035Parser == null) {
      sleepName_4035Parser = createSleepName_4035Parser();
    }
    return sleepName_4035Parser;
  }

  /**
   * @generated
   */
  protected IParser createSleepName_4035Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser streamAudioExtendedName_4036Parser;

  /**
   * @generated
   */
  private IParser getStreamAudioExtendedName_4036Parser() {
    if (streamAudioExtendedName_4036Parser == null) {
      streamAudioExtendedName_4036Parser = createStreamAudioExtendedName_4036Parser();
    }
    return streamAudioExtendedName_4036Parser;
  }

  /**
   * @generated
   */
  protected IParser createStreamAudioExtendedName_4036Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser incomingCallName_4037Parser;

  /**
   * @generated
   */
  private IParser getIncomingCallName_4037Parser() {
    if (incomingCallName_4037Parser == null) {
      incomingCallName_4037Parser = createIncomingCallName_4037Parser();
    }
    return incomingCallName_4037Parser;
  }

  /**
   * @generated
   */
  protected IParser createIncomingCallName_4037Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser getCallInfoName_4038Parser;

  /**
   * @generated
   */
  private IParser getGetCallInfoName_4038Parser() {
    if (getCallInfoName_4038Parser == null) {
      getCallInfoName_4038Parser = createGetCallInfoName_4038Parser();
    }
    return getCallInfoName_4038Parser;
  }

  /**
   * @generated
   */
  protected IParser createGetCallInfoName_4038Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser executeScriptName_4039Parser;

  /**
   * @generated
   */
  private IParser getExecuteScriptName_4039Parser() {
    if (executeScriptName_4039Parser == null) {
      executeScriptName_4039Parser = createExecuteScriptName_4039Parser();
    }
    return executeScriptName_4039Parser;
  }

  /**
   * @generated
   */
  protected IParser createExecuteScriptName_4039Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser invokeSafletName_4040Parser;

  /**
   * @generated
   */
  private IParser getInvokeSafletName_4040Parser() {
    if (invokeSafletName_4040Parser == null) {
      invokeSafletName_4040Parser = createInvokeSafletName_4040Parser();
    }
    return invokeSafletName_4040Parser;
  }

  /**
   * @generated
   */
  protected IParser createInvokeSafletName_4040Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser invokeSafletLabelText_4041Parser;

  /**
   * @generated
   */
  private IParser getInvokeSafletLabelText_4041Parser() {
    if (invokeSafletLabelText_4041Parser == null) {
      invokeSafletLabelText_4041Parser = createInvokeSafletLabelText_4041Parser();
    }
    return invokeSafletLabelText_4041Parser;
  }

  /**
   * @generated
   */
  protected IParser createInvokeSafletLabelText_4041Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE
        .getInvokeSaflet_LabelText(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser dialName_4042Parser;

  /**
   * @generated
   */
  private IParser getDialName_4042Parser() {
    if (dialName_4042Parser == null) {
      dialName_4042Parser = createDialName_4042Parser();
    }
    return dialName_4042Parser;
  }

  /**
   * @generated
   */
  protected IParser createDialName_4042Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser pickupName_4043Parser;

  /**
   * @generated
   */
  private IParser getPickupName_4043Parser() {
    if (pickupName_4043Parser == null) {
      pickupName_4043Parser = createPickupName_4043Parser();
    }
    return pickupName_4043Parser;
  }

  /**
   * @generated
   */
  protected IParser createPickupName_4043Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser backgroundName_4044Parser;

  /**
   * @generated
   */
  private IParser getBackgroundName_4044Parser() {
    if (backgroundName_4044Parser == null) {
      backgroundName_4044Parser = createBackgroundName_4044Parser();
    }
    return backgroundName_4044Parser;
  }

  /**
   * @generated
   */
  protected IParser createBackgroundName_4044Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser backgroundDetectName_4045Parser;

  /**
   * @generated
   */
  private IParser getBackgroundDetectName_4045Parser() {
    if (backgroundDetectName_4045Parser == null) {
      backgroundDetectName_4045Parser = createBackgroundDetectName_4045Parser();
    }
    return backgroundDetectName_4045Parser;
  }

  /**
   * @generated
   */
  protected IParser createBackgroundDetectName_4045Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser waitExtenName_4046Parser;

  /**
   * @generated
   */
  private IParser getWaitExtenName_4046Parser() {
    if (waitExtenName_4046Parser == null) {
      waitExtenName_4046Parser = createWaitExtenName_4046Parser();
    }
    return waitExtenName_4046Parser;
  }

  /**
   * @generated
   */
  protected IParser createWaitExtenName_4046Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser softHangupName_4047Parser;

  /**
   * @generated
   */
  private IParser getSoftHangupName_4047Parser() {
    if (softHangupName_4047Parser == null) {
      softHangupName_4047Parser = createSoftHangupName_4047Parser();
    }
    return softHangupName_4047Parser;
  }

  /**
   * @generated
   */
  protected IParser createSoftHangupName_4047Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser pickupChanName_4048Parser;

  /**
   * @generated
   */
  private IParser getPickupChanName_4048Parser() {
    if (pickupChanName_4048Parser == null) {
      pickupChanName_4048Parser = createPickupChanName_4048Parser();
    }
    return pickupChanName_4048Parser;
  }

  /**
   * @generated
   */
  protected IParser createPickupChanName_4048Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser pickdownName_4049Parser;

  /**
   * @generated
   */
  private IParser getPickdownName_4049Parser() {
    if (pickdownName_4049Parser == null) {
      pickdownName_4049Parser = createPickdownName_4049Parser();
    }
    return pickdownName_4049Parser;
  }

  /**
   * @generated
   */
  protected IParser createPickdownName_4049Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser progressName_4050Parser;

  /**
   * @generated
   */
  private IParser getProgressName_4050Parser() {
    if (progressName_4050Parser == null) {
      progressName_4050Parser = createProgressName_4050Parser();
    }
    return progressName_4050Parser;
  }

  /**
   * @generated
   */
  protected IParser createProgressName_4050Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser bridgeName_4051Parser;

  /**
   * @generated
   */
  private IParser getBridgeName_4051Parser() {
    if (bridgeName_4051Parser == null) {
      bridgeName_4051Parser = createBridgeName_4051Parser();
    }
    return bridgeName_4051Parser;
  }

  /**
   * @generated
   */
  protected IParser createBridgeName_4051Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser placeCallName_4052Parser;

  /**
   * @generated
   */
  private IParser getPlaceCallName_4052Parser() {
    if (placeCallName_4052Parser == null) {
      placeCallName_4052Parser = createPlaceCallName_4052Parser();
    }
    return placeCallName_4052Parser;
  }

  /**
   * @generated
   */
  protected IParser createPlaceCallName_4052Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser voicemailName_4053Parser;

  /**
   * @generated
   */
  private IParser getVoicemailName_4053Parser() {
    if (voicemailName_4053Parser == null) {
      voicemailName_4053Parser = createVoicemailName_4053Parser();
    }
    return voicemailName_4053Parser;
  }

  /**
   * @generated
   */
  protected IParser createVoicemailName_4053Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser voicemailMainName_4054Parser;

  /**
   * @generated
   */
  private IParser getVoicemailMainName_4054Parser() {
    if (voicemailMainName_4054Parser == null) {
      voicemailMainName_4054Parser = createVoicemailMainName_4054Parser();
    }
    return voicemailMainName_4054Parser;
  }

  /**
   * @generated
   */
  protected IParser createVoicemailMainName_4054Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser vMAuthenticateName_4055Parser;

  /**
   * @generated
   */
  private IParser getVMAuthenticateName_4055Parser() {
    if (vMAuthenticateName_4055Parser == null) {
      vMAuthenticateName_4055Parser = createVMAuthenticateName_4055Parser();
    }
    return vMAuthenticateName_4055Parser;
  }

  /**
   * @generated
   */
  protected IParser createVMAuthenticateName_4055Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser meetMeName_4056Parser;

  /**
   * @generated
   */
  private IParser getMeetMeName_4056Parser() {
    if (meetMeName_4056Parser == null) {
      meetMeName_4056Parser = createMeetMeName_4056Parser();
    }
    return meetMeName_4056Parser;
  }

  /**
   * @generated
   */
  protected IParser createMeetMeName_4056Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser meetMeAdminName_4057Parser;

  /**
   * @generated
   */
  private IParser getMeetMeAdminName_4057Parser() {
    if (meetMeAdminName_4057Parser == null) {
      meetMeAdminName_4057Parser = createMeetMeAdminName_4057Parser();
    }
    return meetMeAdminName_4057Parser;
  }

  /**
   * @generated
   */
  protected IParser createMeetMeAdminName_4057Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser meetMeCountName_4058Parser;

  /**
   * @generated
   */
  private IParser getMeetMeCountName_4058Parser() {
    if (meetMeCountName_4058Parser == null) {
      meetMeCountName_4058Parser = createMeetMeCountName_4058Parser();
    }
    return meetMeCountName_4058Parser;
  }

  /**
   * @generated
   */
  protected IParser createMeetMeCountName_4058Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser debugLogName_4059Parser;

  /**
   * @generated
   */
  private IParser getDebugLogName_4059Parser() {
    if (debugLogName_4059Parser == null) {
      debugLogName_4059Parser = createDebugLogName_4059Parser();
    }
    return debugLogName_4059Parser;
  }

  /**
   * @generated
   */
  protected IParser createDebugLogName_4059Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser waitForRingName_4060Parser;

  /**
   * @generated
   */
  private IParser getWaitForRingName_4060Parser() {
    if (waitForRingName_4060Parser == null) {
      waitForRingName_4060Parser = createWaitForRingName_4060Parser();
    }
    return waitForRingName_4060Parser;
  }

  /**
   * @generated
   */
  protected IParser createWaitForRingName_4060Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser waitMusicOnHoldName_4061Parser;

  /**
   * @generated
   */
  private IParser getWaitMusicOnHoldName_4061Parser() {
    if (waitMusicOnHoldName_4061Parser == null) {
      waitMusicOnHoldName_4061Parser = createWaitMusicOnHoldName_4061Parser();
    }
    return waitMusicOnHoldName_4061Parser;
  }

  /**
   * @generated
   */
  protected IParser createWaitMusicOnHoldName_4061Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser getAvailableChannelName_4062Parser;

  /**
   * @generated
   */
  private IParser getGetAvailableChannelName_4062Parser() {
    if (getAvailableChannelName_4062Parser == null) {
      getAvailableChannelName_4062Parser = createGetAvailableChannelName_4062Parser();
    }
    return getAvailableChannelName_4062Parser;
  }

  /**
   * @generated
   */
  protected IParser createGetAvailableChannelName_4062Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser congestionName_4063Parser;

  /**
   * @generated
   */
  private IParser getCongestionName_4063Parser() {
    if (congestionName_4063Parser == null) {
      congestionName_4063Parser = createCongestionName_4063Parser();
    }
    return congestionName_4063Parser;
  }

  /**
   * @generated
   */
  protected IParser createCongestionName_4063Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser ringingName_4064Parser;

  /**
   * @generated
   */
  private IParser getRingingName_4064Parser() {
    if (ringingName_4064Parser == null) {
      ringingName_4064Parser = createRingingName_4064Parser();
    }
    return ringingName_4064Parser;
  }

  /**
   * @generated
   */
  protected IParser createRingingName_4064Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setCallerPresentationName_4065Parser;

  /**
   * @generated
   */
  private IParser getSetCallerPresentationName_4065Parser() {
    if (setCallerPresentationName_4065Parser == null) {
      setCallerPresentationName_4065Parser = createSetCallerPresentationName_4065Parser();
    }
    return setCallerPresentationName_4065Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetCallerPresentationName_4065Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setGlobalVariableName_4066Parser;

  /**
   * @generated
   */
  private IParser getSetGlobalVariableName_4066Parser() {
    if (setGlobalVariableName_4066Parser == null) {
      setGlobalVariableName_4066Parser = createSetGlobalVariableName_4066Parser();
    }
    return setGlobalVariableName_4066Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetGlobalVariableName_4066Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser echoName_4067Parser;

  /**
   * @generated
   */
  private IParser getEchoName_4067Parser() {
    if (echoName_4067Parser == null) {
      echoName_4067Parser = createEchoName_4067Parser();
    }
    return echoName_4067Parser;
  }

  /**
   * @generated
   */
  protected IParser createEchoName_4067Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser festivalName_4068Parser;

  /**
   * @generated
   */
  private IParser getFestivalName_4068Parser() {
    if (festivalName_4068Parser == null) {
      festivalName_4068Parser = createFestivalName_4068Parser();
    }
    return festivalName_4068Parser;
  }

  /**
   * @generated
   */
  protected IParser createFestivalName_4068Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser playtonesName_4069Parser;

  /**
   * @generated
   */
  private IParser getPlaytonesName_4069Parser() {
    if (playtonesName_4069Parser == null) {
      playtonesName_4069Parser = createPlaytonesName_4069Parser();
    }
    return playtonesName_4069Parser;
  }

  /**
   * @generated
   */
  protected IParser createPlaytonesName_4069Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser stopPlaytonesName_4070Parser;

  /**
   * @generated
   */
  private IParser getStopPlaytonesName_4070Parser() {
    if (stopPlaytonesName_4070Parser == null) {
      stopPlaytonesName_4070Parser = createStopPlaytonesName_4070Parser();
    }
    return stopPlaytonesName_4070Parser;
  }

  /**
   * @generated
   */
  protected IParser createStopPlaytonesName_4070Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser chanSpyName_4071Parser;

  /**
   * @generated
   */
  private IParser getChanSpyName_4071Parser() {
    if (chanSpyName_4071Parser == null) {
      chanSpyName_4071Parser = createChanSpyName_4071Parser();
    }
    return chanSpyName_4071Parser;
  }

  /**
   * @generated
   */
  protected IParser createChanSpyName_4071Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser dictateName_4072Parser;

  /**
   * @generated
   */
  private IParser getDictateName_4072Parser() {
    if (dictateName_4072Parser == null) {
      dictateName_4072Parser = createDictateName_4072Parser();
    }
    return dictateName_4072Parser;
  }

  /**
   * @generated
   */
  protected IParser createDictateName_4072Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser extensionSpyName_4073Parser;

  /**
   * @generated
   */
  private IParser getExtensionSpyName_4073Parser() {
    if (extensionSpyName_4073Parser == null) {
      extensionSpyName_4073Parser = createExtensionSpyName_4073Parser();
    }
    return extensionSpyName_4073Parser;
  }

  /**
   * @generated
   */
  protected IParser createExtensionSpyName_4073Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser mixMonitorName_4074Parser;

  /**
   * @generated
   */
  private IParser getMixMonitorName_4074Parser() {
    if (mixMonitorName_4074Parser == null) {
      mixMonitorName_4074Parser = createMixMonitorName_4074Parser();
    }
    return mixMonitorName_4074Parser;
  }

  /**
   * @generated
   */
  protected IParser createMixMonitorName_4074Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser stopMixmonitorName_4075Parser;

  /**
   * @generated
   */
  private IParser getStopMixmonitorName_4075Parser() {
    if (stopMixmonitorName_4075Parser == null) {
      stopMixmonitorName_4075Parser = createStopMixmonitorName_4075Parser();
    }
    return stopMixmonitorName_4075Parser;
  }

  /**
   * @generated
   */
  protected IParser createStopMixmonitorName_4075Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser stopMonitorName_4076Parser;

  /**
   * @generated
   */
  private IParser getStopMonitorName_4076Parser() {
    if (stopMonitorName_4076Parser == null) {
      stopMonitorName_4076Parser = createStopMonitorName_4076Parser();
    }
    return stopMonitorName_4076Parser;
  }

  /**
   * @generated
   */
  protected IParser createStopMonitorName_4076Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser monitorName_4077Parser;

  /**
   * @generated
   */
  private IParser getMonitorName_4077Parser() {
    if (monitorName_4077Parser == null) {
      monitorName_4077Parser = createMonitorName_4077Parser();
    }
    return monitorName_4077Parser;
  }

  /**
   * @generated
   */
  protected IParser createMonitorName_4077Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser directoryName_4078Parser;

  /**
   * @generated
   */
  private IParser getDirectoryName_4078Parser() {
    if (directoryName_4078Parser == null) {
      directoryName_4078Parser = createDirectoryName_4078Parser();
    }
    return directoryName_4078Parser;
  }

  /**
   * @generated
   */
  protected IParser createDirectoryName_4078Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser transferName_4079Parser;

  /**
   * @generated
   */
  private IParser getTransferName_4079Parser() {
    if (transferName_4079Parser == null) {
      transferName_4079Parser = createTransferName_4079Parser();
    }
    return transferName_4079Parser;
  }

  /**
   * @generated
   */
  protected IParser createTransferName_4079Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser openDBConnectionName_4080Parser;

  /**
   * @generated
   */
  private IParser getOpenDBConnectionName_4080Parser() {
    if (openDBConnectionName_4080Parser == null) {
      openDBConnectionName_4080Parser = createOpenDBConnectionName_4080Parser();
    }
    return openDBConnectionName_4080Parser;
  }

  /**
   * @generated
   */
  protected IParser createOpenDBConnectionName_4080Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser closeDBConnectionName_4081Parser;

  /**
   * @generated
   */
  private IParser getCloseDBConnectionName_4081Parser() {
    if (closeDBConnectionName_4081Parser == null) {
      closeDBConnectionName_4081Parser = createCloseDBConnectionName_4081Parser();
    }
    return closeDBConnectionName_4081Parser;
  }

  /**
   * @generated
   */
  protected IParser createCloseDBConnectionName_4081Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser openQueryName_4082Parser;

  /**
   * @generated
   */
  private IParser getOpenQueryName_4082Parser() {
    if (openQueryName_4082Parser == null) {
      openQueryName_4082Parser = createOpenQueryName_4082Parser();
    }
    return openQueryName_4082Parser;
  }

  /**
   * @generated
   */
  protected IParser createOpenQueryName_4082Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setQueryParamName_4083Parser;

  /**
   * @generated
   */
  private IParser getSetQueryParamName_4083Parser() {
    if (setQueryParamName_4083Parser == null) {
      setQueryParamName_4083Parser = createSetQueryParamName_4083Parser();
    }
    return setQueryParamName_4083Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetQueryParamName_4083Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser executeUpdateName_4084Parser;

  /**
   * @generated
   */
  private IParser getExecuteUpdateName_4084Parser() {
    if (executeUpdateName_4084Parser == null) {
      executeUpdateName_4084Parser = createExecuteUpdateName_4084Parser();
    }
    return executeUpdateName_4084Parser;
  }

  /**
   * @generated
   */
  protected IParser createExecuteUpdateName_4084Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser executeQueryName_4085Parser;

  /**
   * @generated
   */
  private IParser getExecuteQueryName_4085Parser() {
    if (executeQueryName_4085Parser == null) {
      executeQueryName_4085Parser = createExecuteQueryName_4085Parser();
    }
    return executeQueryName_4085Parser;
  }

  /**
   * @generated
   */
  protected IParser createExecuteQueryName_4085Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser nextRowName_4086Parser;

  /**
   * @generated
   */
  private IParser getNextRowName_4086Parser() {
    if (nextRowName_4086Parser == null) {
      nextRowName_4086Parser = createNextRowName_4086Parser();
    }
    return nextRowName_4086Parser;
  }

  /**
   * @generated
   */
  protected IParser createNextRowName_4086Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser getColValueName_4087Parser;

  /**
   * @generated
   */
  private IParser getGetColValueName_4087Parser() {
    if (getColValueName_4087Parser == null) {
      getColValueName_4087Parser = createGetColValueName_4087Parser();
    }
    return getColValueName_4087Parser;
  }

  /**
   * @generated
   */
  protected IParser createGetColValueName_4087Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setColValueName_4088Parser;

  /**
   * @generated
   */
  private IParser getSetColValueName_4088Parser() {
    if (setColValueName_4088Parser == null) {
      setColValueName_4088Parser = createSetColValueName_4088Parser();
    }
    return setColValueName_4088Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetColValueName_4088Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser updatetRowName_4089Parser;

  /**
   * @generated
   */
  private IParser getUpdatetRowName_4089Parser() {
    if (updatetRowName_4089Parser == null) {
      updatetRowName_4089Parser = createUpdatetRowName_4089Parser();
    }
    return updatetRowName_4089Parser;
  }

  /**
   * @generated
   */
  protected IParser createUpdatetRowName_4089Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser moveToRowName_4090Parser;

  /**
   * @generated
   */
  private IParser getMoveToRowName_4090Parser() {
    if (moveToRowName_4090Parser == null) {
      moveToRowName_4090Parser = createMoveToRowName_4090Parser();
    }
    return moveToRowName_4090Parser;
  }

  /**
   * @generated
   */
  protected IParser createMoveToRowName_4090Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser moveToLastRowName_4091Parser;

  /**
   * @generated
   */
  private IParser getMoveToLastRowName_4091Parser() {
    if (moveToLastRowName_4091Parser == null) {
      moveToLastRowName_4091Parser = createMoveToLastRowName_4091Parser();
    }
    return moveToLastRowName_4091Parser;
  }

  /**
   * @generated
   */
  protected IParser createMoveToLastRowName_4091Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser deleteRowName_4092Parser;

  /**
   * @generated
   */
  private IParser getDeleteRowName_4092Parser() {
    if (deleteRowName_4092Parser == null) {
      deleteRowName_4092Parser = createDeleteRowName_4092Parser();
    }
    return deleteRowName_4092Parser;
  }

  /**
   * @generated
   */
  protected IParser createDeleteRowName_4092Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser moveToInsertRowName_4093Parser;

  /**
   * @generated
   */
  private IParser getMoveToInsertRowName_4093Parser() {
    if (moveToInsertRowName_4093Parser == null) {
      moveToInsertRowName_4093Parser = createMoveToInsertRowName_4093Parser();
    }
    return moveToInsertRowName_4093Parser;
  }

  /**
   * @generated
   */
  protected IParser createMoveToInsertRowName_4093Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser insertRowName_4094Parser;

  /**
   * @generated
   */
  private IParser getInsertRowName_4094Parser() {
    if (insertRowName_4094Parser == null) {
      insertRowName_4094Parser = createInsertRowName_4094Parser();
    }
    return insertRowName_4094Parser;
  }

  /**
   * @generated
   */
  protected IParser createInsertRowName_4094Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser moveToFirstRowName_4095Parser;

  /**
   * @generated
   */
  private IParser getMoveToFirstRowName_4095Parser() {
    if (moveToFirstRowName_4095Parser == null) {
      moveToFirstRowName_4095Parser = createMoveToFirstRowName_4095Parser();
    }
    return moveToFirstRowName_4095Parser;
  }

  /**
   * @generated
   */
  protected IParser createMoveToFirstRowName_4095Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser previousRowName_4096Parser;

  /**
   * @generated
   */
  private IParser getPreviousRowName_4096Parser() {
    if (previousRowName_4096Parser == null) {
      previousRowName_4096Parser = createPreviousRowName_4096Parser();
    }
    return previousRowName_4096Parser;
  }

  /**
   * @generated
   */
  protected IParser createPreviousRowName_4096Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser getColValuesName_4098Parser;

  /**
   * @generated
   */
  private IParser getGetColValuesName_4098Parser() {
    if (getColValuesName_4098Parser == null) {
      getColValuesName_4098Parser = createGetColValuesName_4098Parser();
    }
    return getColValuesName_4098Parser;
  }

  /**
   * @generated
   */
  protected IParser createGetColValuesName_4098Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setColValuesName_4100Parser;

  /**
   * @generated
   */
  private IParser getSetColValuesName_4100Parser() {
    if (setColValuesName_4100Parser == null) {
      setColValuesName_4100Parser = createSetColValuesName_4100Parser();
    }
    return setColValuesName_4100Parser;
  }

  /**
   * @generated
   */
  protected IParser createSetColValuesName_4100Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser extensionTransferName_4101Parser;

  /**
   * @generated
   */
  private IParser getExtensionTransferName_4101Parser() {
    if (extensionTransferName_4101Parser == null) {
      extensionTransferName_4101Parser = createExtensionTransferName_4101Parser();
    }
    return extensionTransferName_4101Parser;
  }

  /**
   * @generated
   */
  protected IParser createExtensionTransferName_4101Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser runQueryName_4103Parser;

  /**
   * @generated
   */
  private IParser getRunQueryName_4103Parser() {
    if (runQueryName_4103Parser == null) {
      runQueryName_4103Parser = createRunQueryName_4103Parser();
    }
    return runQueryName_4103Parser;
  }

  /**
   * @generated
   */
  protected IParser createRunQueryName_4103Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser caseItemLabelText_4003Parser;

  /**
   * @generated
   */
  private IParser getCaseItemLabelText_4003Parser() {
    if (caseItemLabelText_4003Parser == null) {
      caseItemLabelText_4003Parser = createCaseItemLabelText_4003Parser();
    }
    return caseItemLabelText_4003Parser;
  }

  /**
   * @generated
   */
  protected IParser createCaseItemLabelText_4003Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getItem_LabelText(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser audioFileItemLabelText_4006Parser;

  /**
   * @generated
   */
  private IParser getAudioFileItemLabelText_4006Parser() {
    if (audioFileItemLabelText_4006Parser == null) {
      audioFileItemLabelText_4006Parser = createAudioFileItemLabelText_4006Parser();
    }
    return audioFileItemLabelText_4006Parser;
  }

  /**
   * @generated
   */
  protected IParser createAudioFileItemLabelText_4006Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getItem_LabelText(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser getColMappingGetAsDatatype_4097Parser;

  /**
   * @generated
   */
  private IParser getGetColMappingGetAsDatatype_4097Parser() {
    if (getColMappingGetAsDatatype_4097Parser == null) {
      getColMappingGetAsDatatype_4097Parser = createGetColMappingGetAsDatatype_4097Parser();
    }
    return getColMappingGetAsDatatype_4097Parser;
  }

  /**
   * @generated
   */
  protected IParser createGetColMappingGetAsDatatype_4097Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE
        .getGetColMapping_GetAsDatatype(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  private IParser setColMappingSetAsDatatype_4099Parser;
  private IParser queryParamMapping_2006Parser;

  /**
   * @generated
   */
  private IParser getSetColMappingSetAsDatatype_4099Parser() {
    if (setColMappingSetAsDatatype_4099Parser == null) {
      setColMappingSetAsDatatype_4099Parser = createSetColMappingSetAsDatatype_4099Parser();
    }
    return setColMappingSetAsDatatype_4099Parser;
  }

  /**
   * @generated NOT
   */
  protected IParser createSetColMappingSetAsDatatype_4099Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE
        .getSetColMapping_SetAsDatatype(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated NOT
   */
  protected IParser getParser(int visualID) {
    switch (visualID) {
      case AnswerNameEditPart.VISUAL_ID:
        return getAnswerName_4001Parser();
      case AssignmentNameEditPart.VISUAL_ID:
        return getAssignmentName_4002Parser();
      case ChoiceNameEditPart.VISUAL_ID:
        return getChoiceName_4004Parser();
      case GetFullVariableNameEditPart.VISUAL_ID:
        return getGetFullVariableName_4005Parser();
      case MultiStreamAudioNameEditPart.VISUAL_ID:
        return getMultiStreamAudioName_4007Parser();
      case HangupNameEditPart.VISUAL_ID:
        return getHangupName_4008Parser();
      case IfThenNameEditPart.VISUAL_ID:
        return getIfThenName_4009Parser();
      case RecordFileNameEditPart.VISUAL_ID:
        return getRecordFileName_4010Parser();
      case SayAlphaNameEditPart.VISUAL_ID:
        return getSayAlphaName_4011Parser();
      case SayDateTimeNameEditPart.VISUAL_ID:
        return getSayDateTimeName_4012Parser();
      case SayDigitsNameEditPart.VISUAL_ID:
        return getSayDigitsName_4013Parser();
      case SayNumberNameEditPart.VISUAL_ID:
        return getSayNumberName_4014Parser();
      case SayPhoneticNameEditPart.VISUAL_ID:
        return getSayPhoneticName_4015Parser();
      case SayTimeNameEditPart.VISUAL_ID:
        return getSayTimeName_4016Parser();
      case SetAutoHangupNameEditPart.VISUAL_ID:
        return getSetAutoHangupName_4017Parser();
      case SetCallerIdNameEditPart.VISUAL_ID:
        return getSetCallerIdName_4018Parser();
      case SetChannelVariableNameEditPart.VISUAL_ID:
        return getSetChannelVariableName_4019Parser();
      case SetContextNameEditPart.VISUAL_ID:
        return getSetContextName_4020Parser();
      case SetExtensionNameEditPart.VISUAL_ID:
        return getSetExtensionName_4021Parser();
      case StopMusicOnHoldNameEditPart.VISUAL_ID:
        return getStopMusicOnHoldName_4022Parser();
      case SetMusicOnNameEditPart.VISUAL_ID:
        return getSetMusicOnName_4023Parser();
      case SetPriorityNameEditPart.VISUAL_ID:
        return getSetPriorityName_4024Parser();
      case StreamAudioNameEditPart.VISUAL_ID:
        return getStreamAudioName_4025Parser();
      case WaitForDigitNameEditPart.VISUAL_ID:
        return getWaitForDigitName_4026Parser();
      case DIDMatcherNameEditPart.VISUAL_ID:
        return getDIDMatcherName_4027Parser();
      case GetDigitsNameEditPart.VISUAL_ID:
        return getGetDigitsName_4028Parser();
      case OriginateCallNameEditPart.VISUAL_ID:
        return getOriginateCallName_4029Parser();
      case PlayDTMFNameEditPart.VISUAL_ID:
        return getPlayDTMFName_4030Parser();
      case RecordCallNameEditPart.VISUAL_ID:
        return getRecordCallName_4031Parser();
      case ExecuteApplicationNameEditPart.VISUAL_ID:
        return getExecuteApplicationName_4032Parser();
      case PlayMusicOnHoldNameEditPart.VISUAL_ID:
        return getPlayMusicOnHoldName_4033Parser();
      case PromptGetDigitsNameEditPart.VISUAL_ID:
        return getPromptGetDigitsName_4034Parser();
      case SleepNameEditPart.VISUAL_ID:
        return getSleepName_4035Parser();
      case StreamAudioExtendedNameEditPart.VISUAL_ID:
        return getStreamAudioExtendedName_4036Parser();
      case IncomingCallNameEditPart.VISUAL_ID:
        return getIncomingCallName_4037Parser();
      case GetCallInfoNameEditPart.VISUAL_ID:
        return getGetCallInfoName_4038Parser();
      case ExecuteScriptNameEditPart.VISUAL_ID:
        return getExecuteScriptName_4039Parser();
      case InvokeSafletNameEditPart.VISUAL_ID:
        return getInvokeSafletName_4040Parser();
      case InvokeSafletLabelTextEditPart.VISUAL_ID:
        return getInvokeSafletLabelText_4041Parser();
      case DialNameEditPart.VISUAL_ID:
        return getDialName_4042Parser();
      case PickupNameEditPart.VISUAL_ID:
        return getPickupName_4043Parser();
      case BackgroundNameEditPart.VISUAL_ID:
        return getBackgroundName_4044Parser();
      case BackgroundDetectNameEditPart.VISUAL_ID:
        return getBackgroundDetectName_4045Parser();
      case WaitExtenNameEditPart.VISUAL_ID:
        return getWaitExtenName_4046Parser();
      case SoftHangupNameEditPart.VISUAL_ID:
        return getSoftHangupName_4047Parser();
      case PickupChanNameEditPart.VISUAL_ID:
        return getPickupChanName_4048Parser();
      case PickdownNameEditPart.VISUAL_ID:
        return getPickdownName_4049Parser();
      case ProgressNameEditPart.VISUAL_ID:
        return getProgressName_4050Parser();
      case BridgeNameEditPart.VISUAL_ID:
        return getBridgeName_4051Parser();
      case PlaceCallNameEditPart.VISUAL_ID:
        return getPlaceCallName_4052Parser();
      case VoicemailNameEditPart.VISUAL_ID:
        return getVoicemailName_4053Parser();
      case VoicemailMainNameEditPart.VISUAL_ID:
        return getVoicemailMainName_4054Parser();
      case VMAuthenticateNameEditPart.VISUAL_ID:
        return getVMAuthenticateName_4055Parser();
      case MeetMeNameEditPart.VISUAL_ID:
        return getMeetMeName_4056Parser();
      case MeetMeAdminNameEditPart.VISUAL_ID:
        return getMeetMeAdminName_4057Parser();
      case MeetMeCountNameEditPart.VISUAL_ID:
        return getMeetMeCountName_4058Parser();
      case DebugLogNameEditPart.VISUAL_ID:
        return getDebugLogName_4059Parser();
      case WaitForRingNameEditPart.VISUAL_ID:
        return getWaitForRingName_4060Parser();
      case WaitMusicOnHoldNameEditPart.VISUAL_ID:
        return getWaitMusicOnHoldName_4061Parser();
      case GetAvailableChannelNameEditPart.VISUAL_ID:
        return getGetAvailableChannelName_4062Parser();
      case CongestionNameEditPart.VISUAL_ID:
        return getCongestionName_4063Parser();
      case RingingNameEditPart.VISUAL_ID:
        return getRingingName_4064Parser();
      case SetCallerPresentationNameEditPart.VISUAL_ID:
        return getSetCallerPresentationName_4065Parser();
      case SetGlobalVariableNameEditPart.VISUAL_ID:
        return getSetGlobalVariableName_4066Parser();
      case EchoNameEditPart.VISUAL_ID:
        return getEchoName_4067Parser();
      case FestivalNameEditPart.VISUAL_ID:
        return getFestivalName_4068Parser();
      case PlaytonesNameEditPart.VISUAL_ID:
        return getPlaytonesName_4069Parser();
      case StopPlaytonesNameEditPart.VISUAL_ID:
        return getStopPlaytonesName_4070Parser();
      case ChanSpyNameEditPart.VISUAL_ID:
        return getChanSpyName_4071Parser();
      case DictateNameEditPart.VISUAL_ID:
        return getDictateName_4072Parser();
      case ExtensionSpyNameEditPart.VISUAL_ID:
        return getExtensionSpyName_4073Parser();
      case MixMonitorNameEditPart.VISUAL_ID:
        return getMixMonitorName_4074Parser();
      case StopMixmonitorNameEditPart.VISUAL_ID:
        return getStopMixmonitorName_4075Parser();
      case StopMonitorNameEditPart.VISUAL_ID:
        return getStopMonitorName_4076Parser();
      case MonitorNameEditPart.VISUAL_ID:
        return getMonitorName_4077Parser();
      case DirectoryNameEditPart.VISUAL_ID:
        return getDirectoryName_4078Parser();
      case TransferNameEditPart.VISUAL_ID:
        return getTransferName_4079Parser();
      case OpenDBConnectionNameEditPart.VISUAL_ID:
        return getOpenDBConnectionName_4080Parser();
      case CloseDBConnectionNameEditPart.VISUAL_ID:
        return getCloseDBConnectionName_4081Parser();
      case OpenQueryNameEditPart.VISUAL_ID:
        return getOpenQueryName_4082Parser();
      case SetQueryParamNameEditPart.VISUAL_ID:
        return getSetQueryParamName_4083Parser();
      case ExecuteUpdateNameEditPart.VISUAL_ID:
        return getExecuteUpdateName_4084Parser();
      case ExecuteQueryNameEditPart.VISUAL_ID:
        return getExecuteQueryName_4085Parser();
      case NextRowNameEditPart.VISUAL_ID:
        return getNextRowName_4086Parser();
      case GetColValueNameEditPart.VISUAL_ID:
        return getGetColValueName_4087Parser();
      case SetColValueNameEditPart.VISUAL_ID:
        return getSetColValueName_4088Parser();
      case UpdatetRowNameEditPart.VISUAL_ID:
        return getUpdatetRowName_4089Parser();
      case MoveToRowNameEditPart.VISUAL_ID:
        return getMoveToRowName_4090Parser();
      case MoveToLastRowNameEditPart.VISUAL_ID:
        return getMoveToLastRowName_4091Parser();
      case DeleteRowNameEditPart.VISUAL_ID:
        return getDeleteRowName_4092Parser();
      case MoveToInsertRowNameEditPart.VISUAL_ID:
        return getMoveToInsertRowName_4093Parser();
      case InsertRowNameEditPart.VISUAL_ID:
        return getInsertRowName_4094Parser();
      case MoveToFirstRowNameEditPart.VISUAL_ID:
        return getMoveToFirstRowName_4095Parser();
      case PreviousRowNameEditPart.VISUAL_ID:
        return getPreviousRowName_4096Parser();
      case GetColValuesNameEditPart.VISUAL_ID:
        return getGetColValuesName_4098Parser();
      case SetColValuesNameEditPart.VISUAL_ID:
        return getSetColValuesName_4100Parser();
      case ExtensionTransferNameEditPart.VISUAL_ID:
        return getExtensionTransferName_4101Parser();
      case RunQueryNameEditPart.VISUAL_ID:
        return getRunQueryName_4103Parser();
      case CaseItemLabelTextEditPart.VISUAL_ID:
        return getCaseItemLabelText_4003Parser();
      case AudioFileItemLabelTextEditPart.VISUAL_ID:
        return getAudioFileItemLabelText_4006Parser();
      case GetColMappingGetAsDatatypeEditPart.VISUAL_ID:
        return getGetColMappingGetAsDatatype_4097Parser();
      case SetColMappingSetAsDatatypeEditPart.VISUAL_ID:
        return getSetColMappingSetAsDatatype_4099Parser();
      case WrapLabelEditPart.VISUAL_ID:
        return getQueryParamMapping_2006Parser();
      default: {
        IParser parser = customActionstepNameParserMap.get(visualID);
        if (parser != null)
          return parser;
        String id = String.valueOf(visualID);

        for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
            .getInstance().getActionstepProfiles()) {

          if (p.labelSemanticHint.equals(id)) {
            parser = createActionstepNameParser();
            customActionstepNameParserMap.put(visualID, parser);
            return parser;
          }
        }
      }
    }
    return null;
  }

  private IParser createActionstepNameParser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getActionStep_Name(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  private Map<Integer, IParser> customActionstepNameParserMap = new HashMap<Integer, IParser>();

  private IParser getQueryParamMapping_2006Parser() {
    if (queryParamMapping_2006Parser == null) {
      queryParamMapping_2006Parser = createQueryParamMapping_2006Parser();
    }
    return queryParamMapping_2006Parser;
  }

  protected IParser createQueryParamMapping_2006Parser() {
    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getDBQueryParamId_Id(), };
    MessageFormatParser parser = new MessageFormatParser(features);
    return parser;
  }

  /**
   * @generated
   */
  public IParser getParser(IAdaptable hint) {
    String vid = (String) hint.getAdapter(String.class);
    if (vid != null) {
      return getParser(AsteriskVisualIDRegistry.getVisualID(vid));
    }
    View view = (View) hint.getAdapter(View.class);
    if (view != null) {
      return getParser(AsteriskVisualIDRegistry.getVisualID(view));
    }
    return null;
  }

  /**
   * @generated
   */
  public boolean provides(IOperation operation) {
    if (operation instanceof GetParserOperation) {
      IAdaptable hint = ((GetParserOperation) operation).getHint();
      if (AsteriskElementTypes.getElement(hint) == null) {
        return false;
      }
      return getParser(hint) != null;
    }
    return false;
  }

  /**
   * @generated
   */
  public static class HintAdapter extends ParserHintAdapter {

    /**
     * @generated
     */
    private final IElementType elementType;

    /**
     * @generated
     */
    public HintAdapter(IElementType type, EObject object, String parserHint) {
      super(object, parserHint);
      assert type != null;
      elementType = type;
    }

    /**
     * @generated
     */
    @Override
    public Object getAdapter(Class adapter) {
      if (IElementType.class.equals(adapter)) {
        return elementType;
      }
      return super.getAdapter(adapter);
    }
  }

}
