package com.safi.workshop.edit.policies;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import com.safi.core.saflet.SafletPackage;
import com.safi.workshop.edit.commands.AnswerCreateCommand;
import com.safi.workshop.edit.commands.AssignmentCreateCommand;
import com.safi.workshop.edit.commands.BackgroundCreateCommand;
import com.safi.workshop.edit.commands.BackgroundDetectCreateCommand;
import com.safi.workshop.edit.commands.BridgeCreateCommand;
import com.safi.workshop.edit.commands.ChanSpyCreateCommand;
import com.safi.workshop.edit.commands.ChoiceCreateCommand;
import com.safi.workshop.edit.commands.CloseDBConnectionCreateCommand;
import com.safi.workshop.edit.commands.CongestionCreateCommand;
import com.safi.workshop.edit.commands.DIDMatcherCreateCommand;
import com.safi.workshop.edit.commands.DebugLogCreateCommand;
import com.safi.workshop.edit.commands.DeleteRowCreateCommand;
import com.safi.workshop.edit.commands.DialCreateCommand;
import com.safi.workshop.edit.commands.DictateCreateCommand;
import com.safi.workshop.edit.commands.DirectoryCreateCommand;
import com.safi.workshop.edit.commands.EchoCreateCommand;
import com.safi.workshop.edit.commands.ExecuteApplicationCreateCommand;
import com.safi.workshop.edit.commands.ExecuteQueryCreateCommand;
import com.safi.workshop.edit.commands.ExecuteScriptCreateCommand;
import com.safi.workshop.edit.commands.ExecuteUpdateCreateCommand;
import com.safi.workshop.edit.commands.ExtensionSpyCreateCommand;
import com.safi.workshop.edit.commands.ExtensionTransferCreateCommand;
import com.safi.workshop.edit.commands.FestivalCreateCommand;
import com.safi.workshop.edit.commands.GetAvailableChannelCreateCommand;
import com.safi.workshop.edit.commands.GetCallInfoCreateCommand;
import com.safi.workshop.edit.commands.GetColValueCreateCommand;
import com.safi.workshop.edit.commands.GetColValuesCreateCommand;
import com.safi.workshop.edit.commands.GetDigitsCreateCommand;
import com.safi.workshop.edit.commands.GetFullVariableCreateCommand;
import com.safi.workshop.edit.commands.HangupCreateCommand;
import com.safi.workshop.edit.commands.IfThenCreateCommand;
import com.safi.workshop.edit.commands.IncomingCallCreateCommand;
import com.safi.workshop.edit.commands.InsertRowCreateCommand;
import com.safi.workshop.edit.commands.InvokeSafletCreateCommand;
import com.safi.workshop.edit.commands.MeetMeAdminCreateCommand;
import com.safi.workshop.edit.commands.MeetMeCountCreateCommand;
import com.safi.workshop.edit.commands.MeetMeCreateCommand;
import com.safi.workshop.edit.commands.MixMonitorCreateCommand;
import com.safi.workshop.edit.commands.MonitorCreateCommand;
import com.safi.workshop.edit.commands.MoveToFirstRowCreateCommand;
import com.safi.workshop.edit.commands.MoveToInsertRowCreateCommand;
import com.safi.workshop.edit.commands.MoveToLastRowCreateCommand;
import com.safi.workshop.edit.commands.MoveToRowCreateCommand;
import com.safi.workshop.edit.commands.MultiStreamAudioCreateCommand;
import com.safi.workshop.edit.commands.NextRowCreateCommand;
import com.safi.workshop.edit.commands.OpenDBConnectionCreateCommand;
import com.safi.workshop.edit.commands.OpenQueryCreateCommand;
import com.safi.workshop.edit.commands.OriginateCallCreateCommand;
import com.safi.workshop.edit.commands.PickdownCreateCommand;
import com.safi.workshop.edit.commands.PickupChanCreateCommand;
import com.safi.workshop.edit.commands.PickupCreateCommand;
import com.safi.workshop.edit.commands.PlaceCallCreateCommand;
import com.safi.workshop.edit.commands.PlayDTMFCreateCommand;
import com.safi.workshop.edit.commands.PlayMusicOnHoldCreateCommand;
import com.safi.workshop.edit.commands.PlaytonesCreateCommand;
import com.safi.workshop.edit.commands.PreviousRowCreateCommand;
import com.safi.workshop.edit.commands.ProgressCreateCommand;
import com.safi.workshop.edit.commands.PromptGetDigitsCreateCommand;
import com.safi.workshop.edit.commands.RecordCallCreateCommand;
import com.safi.workshop.edit.commands.RecordFileCreateCommand;
import com.safi.workshop.edit.commands.RingingCreateCommand;
import com.safi.workshop.edit.commands.RunQueryCreateCommand;
import com.safi.workshop.edit.commands.SayAlphaCreateCommand;
import com.safi.workshop.edit.commands.SayDateTimeCreateCommand;
import com.safi.workshop.edit.commands.SayDigitsCreateCommand;
import com.safi.workshop.edit.commands.SayNumberCreateCommand;
import com.safi.workshop.edit.commands.SayPhoneticCreateCommand;
import com.safi.workshop.edit.commands.SayTimeCreateCommand;
import com.safi.workshop.edit.commands.SetAutoHangupCreateCommand;
import com.safi.workshop.edit.commands.SetCallerIdCreateCommand;
import com.safi.workshop.edit.commands.SetCallerPresentationCreateCommand;
import com.safi.workshop.edit.commands.SetChannelVariableCreateCommand;
import com.safi.workshop.edit.commands.SetColValueCreateCommand;
import com.safi.workshop.edit.commands.SetColValuesCreateCommand;
import com.safi.workshop.edit.commands.SetContextCreateCommand;
import com.safi.workshop.edit.commands.SetExtensionCreateCommand;
import com.safi.workshop.edit.commands.SetGlobalVariableCreateCommand;
import com.safi.workshop.edit.commands.SetMusicOnCreateCommand;
import com.safi.workshop.edit.commands.SetPriorityCreateCommand;
import com.safi.workshop.edit.commands.SetQueryParamCreateCommand;
import com.safi.workshop.edit.commands.SleepCreateCommand;
import com.safi.workshop.edit.commands.SoftHangupCreateCommand;
import com.safi.workshop.edit.commands.StopMixmonitorCreateCommand;
import com.safi.workshop.edit.commands.StopMonitorCreateCommand;
import com.safi.workshop.edit.commands.StopMusicOnHoldCreateCommand;
import com.safi.workshop.edit.commands.StopPlaytonesCreateCommand;
import com.safi.workshop.edit.commands.StreamAudioCreateCommand;
import com.safi.workshop.edit.commands.StreamAudioExtendedCreateCommand;
import com.safi.workshop.edit.commands.TransferCreateCommand;
import com.safi.workshop.edit.commands.UpdatetRowCreateCommand;
import com.safi.workshop.edit.commands.VMAuthenticateCreateCommand;
import com.safi.workshop.edit.commands.VoicemailCreateCommand;
import com.safi.workshop.edit.commands.VoicemailMainCreateCommand;
import com.safi.workshop.edit.commands.WaitExtenCreateCommand;
import com.safi.workshop.edit.commands.WaitForDigitCreateCommand;
import com.safi.workshop.edit.commands.WaitForRingCreateCommand;
import com.safi.workshop.edit.commands.WaitMusicOnHoldCreateCommand;
import com.safi.workshop.providers.AsteriskElementTypes;

/**
 * @generated
 */
public class HandlerItemSemanticEditPolicy extends AsteriskBaseItemSemanticEditPolicy {

  private static Map<IElementType, ActionstepCreateCommandFactory> elementToCreateCommandFactory = new HashMap<IElementType, ActionstepCreateCommandFactory>();

  /**
   * @generated NOT
   */
  @Override
  protected Command getCreateCommand(CreateElementRequest req) {
    if (AsteriskElementTypes.Answer_1001 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new AnswerCreateCommand(req));
    }
    if (AsteriskElementTypes.Assignment_1002 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new AssignmentCreateCommand(req));
    }
    if (AsteriskElementTypes.Choice_1003 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ChoiceCreateCommand(req));
    }
    if (AsteriskElementTypes.GetFullVariable_1004 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new GetFullVariableCreateCommand(req));
    }
    if (AsteriskElementTypes.MultiStreamAudio_1005 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MultiStreamAudioCreateCommand(req));
    }
    if (AsteriskElementTypes.Hangup_1006 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new HangupCreateCommand(req));
    }
    if (AsteriskElementTypes.IfThen_1007 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new IfThenCreateCommand(req));
    }
    if (AsteriskElementTypes.RecordFile_1008 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new RecordFileCreateCommand(req));
    }
    if (AsteriskElementTypes.SayAlpha_1009 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SayAlphaCreateCommand(req));
    }
    if (AsteriskElementTypes.SayDateTime_1010 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SayDateTimeCreateCommand(req));
    }
    if (AsteriskElementTypes.SayDigits_1011 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SayDigitsCreateCommand(req));
    }
    if (AsteriskElementTypes.SayNumber_1012 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SayNumberCreateCommand(req));
    }
    if (AsteriskElementTypes.SayPhonetic_1013 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SayPhoneticCreateCommand(req));
    }
    if (AsteriskElementTypes.SayTime_1014 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SayTimeCreateCommand(req));
    }
    if (AsteriskElementTypes.SetAutoHangup_1015 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetAutoHangupCreateCommand(req));
    }
    if (AsteriskElementTypes.SetCallerId_1016 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetCallerIdCreateCommand(req));
    }
    if (AsteriskElementTypes.SetChannelVariable_1017 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetChannelVariableCreateCommand(req));
    }
    if (AsteriskElementTypes.SetContext_1018 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetContextCreateCommand(req));
    }
    if (AsteriskElementTypes.SetExtension_1019 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetExtensionCreateCommand(req));
    }
    if (AsteriskElementTypes.StopMusicOnHold_1020 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new StopMusicOnHoldCreateCommand(req));
    }
    if (AsteriskElementTypes.SetMusicOn_1021 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetMusicOnCreateCommand(req));
    }
    if (AsteriskElementTypes.SetPriority_1022 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetPriorityCreateCommand(req));
    }
    if (AsteriskElementTypes.StreamAudio_1023 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new StreamAudioCreateCommand(req));
    }
    if (AsteriskElementTypes.WaitForDigit_1024 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new WaitForDigitCreateCommand(req));
    }
    if (AsteriskElementTypes.DIDMatcher_1025 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Initiator());
      }
      return getGEFWrapper(new DIDMatcherCreateCommand(req));
    }
    if (AsteriskElementTypes.GetDigits_1026 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new GetDigitsCreateCommand(req));
    }
    if (AsteriskElementTypes.OriginateCall_1027 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new OriginateCallCreateCommand(req));
    }
    if (AsteriskElementTypes.PlayDTMF_1028 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new PlayDTMFCreateCommand(req));
    }
    if (AsteriskElementTypes.RecordCall_1029 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new RecordCallCreateCommand(req));
    }
    if (AsteriskElementTypes.ExecuteApplication_1030 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ExecuteApplicationCreateCommand(req));
    }
    if (AsteriskElementTypes.PlayMusicOnHold_1031 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new PlayMusicOnHoldCreateCommand(req));
    }
    if (AsteriskElementTypes.PromptGetDigits_1032 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new PromptGetDigitsCreateCommand(req));
    }
    if (AsteriskElementTypes.Sleep_1033 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SleepCreateCommand(req));
    }
    if (AsteriskElementTypes.StreamAudioExtended_1034 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new StreamAudioExtendedCreateCommand(req));
    }
    if (AsteriskElementTypes.IncomingCall_1035 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        // req.setContainmentFeature(HandlerPackage.eINSTANCE.getHandler_Initiator());
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new IncomingCallCreateCommand(req));
    }
    if (AsteriskElementTypes.GetCallInfo_1036 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new GetCallInfoCreateCommand(req));
    }
    if (AsteriskElementTypes.ExecuteScript_1037 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ExecuteScriptCreateCommand(req));
    }
    if (AsteriskElementTypes.InvokeSaflet_1038 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new InvokeSafletCreateCommand(req));
    }
    if (AsteriskElementTypes.Dial_1039 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new DialCreateCommand(req));
    }
    if (AsteriskElementTypes.Pickup_1040 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new PickupCreateCommand(req));
    }
    if (AsteriskElementTypes.Background_1041 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new BackgroundCreateCommand(req));
    }
    if (AsteriskElementTypes.BackgroundDetect_1042 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new BackgroundDetectCreateCommand(req));
    }
    if (AsteriskElementTypes.WaitExten_1043 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new WaitExtenCreateCommand(req));
    }
    if (AsteriskElementTypes.SoftHangup_1044 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SoftHangupCreateCommand(req));
    }
    if (AsteriskElementTypes.PickupChan_1045 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new PickupChanCreateCommand(req));
    }
    if (AsteriskElementTypes.Pickdown_1046 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new PickdownCreateCommand(req));
    }
    if (AsteriskElementTypes.Progress_1047 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ProgressCreateCommand(req));
    }
    if (AsteriskElementTypes.Bridge_1048 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new BridgeCreateCommand(req));
    }
    if (AsteriskElementTypes.PlaceCall_1049 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new PlaceCallCreateCommand(req));
    }
    if (AsteriskElementTypes.Voicemail_1050 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new VoicemailCreateCommand(req));
    }
    if (AsteriskElementTypes.VoicemailMain_1051 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new VoicemailMainCreateCommand(req));
    }
    if (AsteriskElementTypes.VMAuthenticate_1052 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new VMAuthenticateCreateCommand(req));
    }
    if (AsteriskElementTypes.MeetMe_1053 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MeetMeCreateCommand(req));
    }
    if (AsteriskElementTypes.MeetMeAdmin_1054 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MeetMeAdminCreateCommand(req));
    }
    if (AsteriskElementTypes.MeetMeCount_1055 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MeetMeCountCreateCommand(req));
    }
    if (AsteriskElementTypes.DebugLog_1056 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new DebugLogCreateCommand(req));
    }
    if (AsteriskElementTypes.WaitForRing_1057 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new WaitForRingCreateCommand(req));
    }
    if (AsteriskElementTypes.WaitMusicOnHold_1058 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new WaitMusicOnHoldCreateCommand(req));
    }
    if (AsteriskElementTypes.GetAvailableChannel_1059 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new GetAvailableChannelCreateCommand(req));
    }
    if (AsteriskElementTypes.Congestion_1060 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new CongestionCreateCommand(req));
    }
    if (AsteriskElementTypes.Ringing_1061 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new RingingCreateCommand(req));
    }
    if (AsteriskElementTypes.SetCallerPresentation_1062 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetCallerPresentationCreateCommand(req));
    }
    if (AsteriskElementTypes.SetGlobalVariable_1063 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetGlobalVariableCreateCommand(req));
    }
    if (AsteriskElementTypes.Echo_1064 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new EchoCreateCommand(req));
    }
    if (AsteriskElementTypes.Festival_1065 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new FestivalCreateCommand(req));
    }
    if (AsteriskElementTypes.Playtones_1066 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new PlaytonesCreateCommand(req));
    }
    if (AsteriskElementTypes.StopPlaytones_1067 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new StopPlaytonesCreateCommand(req));
    }
    if (AsteriskElementTypes.ChanSpy_1068 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ChanSpyCreateCommand(req));
    }
    if (AsteriskElementTypes.Dictate_1069 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new DictateCreateCommand(req));
    }
    if (AsteriskElementTypes.ExtensionSpy_1070 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ExtensionSpyCreateCommand(req));
    }
    if (AsteriskElementTypes.MixMonitor_1071 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MixMonitorCreateCommand(req));
    }
    if (AsteriskElementTypes.StopMixmonitor_1072 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new StopMixmonitorCreateCommand(req));
    }
    if (AsteriskElementTypes.StopMonitor_1073 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new StopMonitorCreateCommand(req));
    }
    if (AsteriskElementTypes.Monitor_1074 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MonitorCreateCommand(req));
    }
    if (AsteriskElementTypes.Directory_1075 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new DirectoryCreateCommand(req));
    }
    if (AsteriskElementTypes.Transfer_1076 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new TransferCreateCommand(req));
    }
    if (AsteriskElementTypes.OpenDBConnection_1077 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new OpenDBConnectionCreateCommand(req));
    }
    if (AsteriskElementTypes.CloseDBConnection_1078 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new CloseDBConnectionCreateCommand(req));
    }
    if (AsteriskElementTypes.OpenQuery_1079 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new OpenQueryCreateCommand(req));
    }
    if (AsteriskElementTypes.SetQueryParam_1080 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetQueryParamCreateCommand(req));
    }
    if (AsteriskElementTypes.ExecuteUpdate_1081 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ExecuteUpdateCreateCommand(req));
    }
    if (AsteriskElementTypes.ExecuteQuery_1082 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ExecuteQueryCreateCommand(req));
    }
    if (AsteriskElementTypes.NextRow_1083 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new NextRowCreateCommand(req));
    }
    if (AsteriskElementTypes.GetColValue_1084 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new GetColValueCreateCommand(req));
    }
    if (AsteriskElementTypes.SetColValue_1085 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetColValueCreateCommand(req));
    }
    if (AsteriskElementTypes.UpdatetRow_1086 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new UpdatetRowCreateCommand(req));
    }
    if (AsteriskElementTypes.MoveToRow_1087 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MoveToRowCreateCommand(req));
    }
    if (AsteriskElementTypes.MoveToLastRow_1088 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MoveToLastRowCreateCommand(req));
    }
    if (AsteriskElementTypes.DeleteRow_1089 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new DeleteRowCreateCommand(req));
    }
    if (AsteriskElementTypes.MoveToInsertRow_1090 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MoveToInsertRowCreateCommand(req));
    }
    if (AsteriskElementTypes.InsertRow_1091 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new InsertRowCreateCommand(req));
    }
    if (AsteriskElementTypes.MoveToFirstRow_1092 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new MoveToFirstRowCreateCommand(req));
    }
    if (AsteriskElementTypes.PreviousRow_1093 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new PreviousRowCreateCommand(req));
    }
    if (AsteriskElementTypes.GetColValues_1094 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new GetColValuesCreateCommand(req));
    }
    if (AsteriskElementTypes.SetColValues_1095 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new SetColValuesCreateCommand(req));
    }
    if (AsteriskElementTypes.ExtensionTransfer_1096 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new ExtensionTransferCreateCommand(req));
    }
    if (AsteriskElementTypes.RunQuery_1097 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(new RunQueryCreateCommand(req));
    }
    ActionstepCreateCommandFactory factory = elementToCreateCommandFactory
        .get(req.getElementType());
    if (factory != null) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      }
      return getGEFWrapper(factory.getCreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

  public static void registerCreateCommandFactory(IElementType type,
      ActionstepCreateCommandFactory factory) {
    elementToCreateCommandFactory.put(type, factory);
  }

  /**
   * @generated
   */
  @Override
  protected Command getDuplicateCommand(DuplicateElementsRequest req) {
    TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
    return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
  }

  @Override
  public Command getCommand(Request request) {
    // TODO Auto-generated method stub
    return super.getCommand(request);
  }
  /**
   * @generated
   */
  private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

    /**
     * @generated
     */
    public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain,
        DuplicateElementsRequest req) {
      super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req
          .getAllDuplicatedElementsMap());
    }

    @Override
    protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info)
        throws ExecutionException {
      // TODO Auto-generated method stub
      CommandResult result = super.doExecuteWithResult(progressMonitor, info);

      return result;
    }

    @Override
    public boolean canExecute() {
      // TODO Auto-generated method stub
      boolean b = super.canExecute();
      return b;
    }

  }

}
