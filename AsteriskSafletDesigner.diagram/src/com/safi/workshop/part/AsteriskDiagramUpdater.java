package com.safi.workshop.part;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.View;
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
import com.safi.asterisk.initiator.IncomingCall;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.Assignment;
import com.safi.core.actionstep.AudioFileItem;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.Choice;
import com.safi.core.actionstep.CloseDBConnection;
import com.safi.core.actionstep.DebugLog;
import com.safi.core.actionstep.DeleteRow;
import com.safi.core.actionstep.ExecuteQuery;
import com.safi.core.actionstep.ExecuteScript;
import com.safi.core.actionstep.ExecuteUpdate;
import com.safi.core.actionstep.GetColMapping;
import com.safi.core.actionstep.GetColValue;
import com.safi.core.actionstep.GetColValues;
import com.safi.core.actionstep.IfThen;
import com.safi.core.actionstep.InsertRow;
import com.safi.core.actionstep.InvokeSaflet;
import com.safi.core.actionstep.MoveToFirstRow;
import com.safi.core.actionstep.MoveToInsertRow;
import com.safi.core.actionstep.MoveToLastRow;
import com.safi.core.actionstep.MoveToRow;
import com.safi.core.actionstep.NextRow;
import com.safi.core.actionstep.OpenDBConnection;
import com.safi.core.actionstep.OpenQuery;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.PreviousRow;
import com.safi.core.actionstep.QueryParamMapping;
import com.safi.core.actionstep.RunQuery;
import com.safi.core.actionstep.SetColMapping;
import com.safi.core.actionstep.SetColValue;
import com.safi.core.actionstep.SetColValues;
import com.safi.core.actionstep.SetQueryParam;
import com.safi.core.actionstep.UpdatetRow;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.workshop.edit.parts.*;
import com.safi.workshop.providers.AsteriskElementTypes;

/**
 * @generated
 */
public class AsteriskDiagramUpdater {

  /**
   * @generated NOT
   */
  public static List getSemanticChildren(View view) {
    int visualID = AsteriskVisualIDRegistry.getVisualID(view);
    switch (visualID) {
      case AnswerEditPart.VISUAL_ID:
        return getAnswer_1001SemanticChildren(view);
      case AssignmentEditPart.VISUAL_ID:
        return getAssignment_1002SemanticChildren(view);
      case ChoiceEditPart.VISUAL_ID:
        return getChoice_1003SemanticChildren(view);
      case GetFullVariableEditPart.VISUAL_ID:
        return getGetFullVariable_1004SemanticChildren(view);
      case MultiStreamAudioEditPart.VISUAL_ID:
        return getMultiStreamAudio_1005SemanticChildren(view);
      case HangupEditPart.VISUAL_ID:
        return getHangup_1006SemanticChildren(view);
      case IfThenEditPart.VISUAL_ID:
        return getIfThen_1007SemanticChildren(view);
      case RecordFileEditPart.VISUAL_ID:
        return getRecordFile_1008SemanticChildren(view);
      case SayAlphaEditPart.VISUAL_ID:
        return getSayAlpha_1009SemanticChildren(view);
      case SayDateTimeEditPart.VISUAL_ID:
        return getSayDateTime_1010SemanticChildren(view);
      case SayDigitsEditPart.VISUAL_ID:
        return getSayDigits_1011SemanticChildren(view);
      case SayNumberEditPart.VISUAL_ID:
        return getSayNumber_1012SemanticChildren(view);
      case SayPhoneticEditPart.VISUAL_ID:
        return getSayPhonetic_1013SemanticChildren(view);
      case SayTimeEditPart.VISUAL_ID:
        return getSayTime_1014SemanticChildren(view);
      case SetAutoHangupEditPart.VISUAL_ID:
        return getSetAutoHangup_1015SemanticChildren(view);
      case SetCallerIdEditPart.VISUAL_ID:
        return getSetCallerId_1016SemanticChildren(view);
      case SetChannelVariableEditPart.VISUAL_ID:
        return getSetChannelVariable_1017SemanticChildren(view);
      case SetContextEditPart.VISUAL_ID:
        return getSetContext_1018SemanticChildren(view);
      case SetExtensionEditPart.VISUAL_ID:
        return getSetExtension_1019SemanticChildren(view);
      case StopMusicOnHoldEditPart.VISUAL_ID:
        return getStopMusicOnHold_1020SemanticChildren(view);
      case SetMusicOnEditPart.VISUAL_ID:
        return getSetMusicOn_1021SemanticChildren(view);
      case SetPriorityEditPart.VISUAL_ID:
        return getSetPriority_1022SemanticChildren(view);
      case StreamAudioEditPart.VISUAL_ID:
        return getStreamAudio_1023SemanticChildren(view);
      case WaitForDigitEditPart.VISUAL_ID:
        return getWaitForDigit_1024SemanticChildren(view);
      case GetDigitsEditPart.VISUAL_ID:
        return getGetDigits_1026SemanticChildren(view);
      case OriginateCallEditPart.VISUAL_ID:
        return getOriginateCall_1027SemanticChildren(view);
      case PlayDTMFEditPart.VISUAL_ID:
        return getPlayDTMF_1028SemanticChildren(view);
      case RecordCallEditPart.VISUAL_ID:
        return getRecordCall_1029SemanticChildren(view);
      case ExecuteApplicationEditPart.VISUAL_ID:
        return getExecuteApplication_1030SemanticChildren(view);
      case PlayMusicOnHoldEditPart.VISUAL_ID:
        return getPlayMusicOnHold_1031SemanticChildren(view);
      case PromptGetDigitsEditPart.VISUAL_ID:
        return getPromptGetDigits_1032SemanticChildren(view);
      case SleepEditPart.VISUAL_ID:
        return getSleep_1033SemanticChildren(view);
      case StreamAudioExtendedEditPart.VISUAL_ID:
        return getStreamAudioExtended_1034SemanticChildren(view);
      case GetCallInfoEditPart.VISUAL_ID:
        return getGetCallInfo_1036SemanticChildren(view);
      case ExecuteScriptEditPart.VISUAL_ID:
        return getExecuteScript_1037SemanticChildren(view);
      case InvokeSafletEditPart.VISUAL_ID:
        return getInvokeSaflet_1038SemanticChildren(view);
      case DialEditPart.VISUAL_ID:
        return getDial_1039SemanticChildren(view);
      case PickupEditPart.VISUAL_ID:
        return getPickup_1040SemanticChildren(view);
      case BackgroundEditPart.VISUAL_ID:
        return getBackground_1041SemanticChildren(view);
      case BackgroundDetectEditPart.VISUAL_ID:
        return getBackgroundDetect_1042SemanticChildren(view);
      case WaitExtenEditPart.VISUAL_ID:
        return getWaitExten_1043SemanticChildren(view);
      case SoftHangupEditPart.VISUAL_ID:
        return getSoftHangup_1044SemanticChildren(view);
      case PickupChanEditPart.VISUAL_ID:
        return getPickupChan_1045SemanticChildren(view);
      case PickdownEditPart.VISUAL_ID:
        return getPickdown_1046SemanticChildren(view);
      case ProgressEditPart.VISUAL_ID:
        return getProgress_1047SemanticChildren(view);
      case BridgeEditPart.VISUAL_ID:
        return getBridge_1048SemanticChildren(view);
      case PlaceCallEditPart.VISUAL_ID:
        return getPlaceCall_1049SemanticChildren(view);
      case VoicemailEditPart.VISUAL_ID:
        return getVoicemail_1050SemanticChildren(view);
      case VoicemailMainEditPart.VISUAL_ID:
        return getVoicemailMain_1051SemanticChildren(view);
      case VMAuthenticateEditPart.VISUAL_ID:
        return getVMAuthenticate_1052SemanticChildren(view);
      case MeetMeEditPart.VISUAL_ID:
        return getMeetMe_1053SemanticChildren(view);
      case MeetMeAdminEditPart.VISUAL_ID:
        return getMeetMeAdmin_1054SemanticChildren(view);
      case MeetMeCountEditPart.VISUAL_ID:
        return getMeetMeCount_1055SemanticChildren(view);
      case DebugLogEditPart.VISUAL_ID:
        return getDebugLog_1056SemanticChildren(view);
      case WaitForRingEditPart.VISUAL_ID:
        return getWaitForRing_1057SemanticChildren(view);
      case WaitMusicOnHoldEditPart.VISUAL_ID:
        return getWaitMusicOnHold_1058SemanticChildren(view);
      case GetAvailableChannelEditPart.VISUAL_ID:
        return getGetAvailableChannel_1059SemanticChildren(view);
      case CongestionEditPart.VISUAL_ID:
        return getCongestion_1060SemanticChildren(view);
      case RingingEditPart.VISUAL_ID:
        return getRinging_1061SemanticChildren(view);
      case SetCallerPresentationEditPart.VISUAL_ID:
        return getSetCallerPresentation_1062SemanticChildren(view);
      case SetGlobalVariableEditPart.VISUAL_ID:
        return getSetGlobalVariable_1063SemanticChildren(view);
      case EchoEditPart.VISUAL_ID:
        return getEcho_1064SemanticChildren(view);
      case FestivalEditPart.VISUAL_ID:
        return getFestival_1065SemanticChildren(view);
      case PlaytonesEditPart.VISUAL_ID:
        return getPlaytones_1066SemanticChildren(view);
      case StopPlaytonesEditPart.VISUAL_ID:
        return getStopPlaytones_1067SemanticChildren(view);
      case ChanSpyEditPart.VISUAL_ID:
        return getChanSpy_1068SemanticChildren(view);
      case DictateEditPart.VISUAL_ID:
        return getDictate_1069SemanticChildren(view);
      case ExtensionSpyEditPart.VISUAL_ID:
        return getExtensionSpy_1070SemanticChildren(view);
      case MixMonitorEditPart.VISUAL_ID:
        return getMixMonitor_1071SemanticChildren(view);
      case StopMixmonitorEditPart.VISUAL_ID:
        return getStopMixmonitor_1072SemanticChildren(view);
      case StopMonitorEditPart.VISUAL_ID:
        return getStopMonitor_1073SemanticChildren(view);
      case MonitorEditPart.VISUAL_ID:
        return getMonitor_1074SemanticChildren(view);
      case DirectoryEditPart.VISUAL_ID:
        return getDirectory_1075SemanticChildren(view);
      case TransferEditPart.VISUAL_ID:
        return getTransfer_1076SemanticChildren(view);
      case OpenDBConnectionEditPart.VISUAL_ID:
        return getOpenDBConnection_1077SemanticChildren(view);
      case CloseDBConnectionEditPart.VISUAL_ID:
        return getCloseDBConnection_1078SemanticChildren(view);
      case OpenQueryEditPart.VISUAL_ID:
        return getOpenQuery_1079SemanticChildren(view);
      case SetQueryParamEditPart.VISUAL_ID:
        return getSetQueryParam_1080SemanticChildren(view);
      case ExecuteUpdateEditPart.VISUAL_ID:
        return getExecuteUpdate_1081SemanticChildren(view);
      case ExecuteQueryEditPart.VISUAL_ID:
        return getExecuteQuery_1082SemanticChildren(view);
      case NextRowEditPart.VISUAL_ID:
        return getNextRow_1083SemanticChildren(view);
      case GetColValueEditPart.VISUAL_ID:
        return getGetColValue_1084SemanticChildren(view);
      case SetColValueEditPart.VISUAL_ID:
        return getSetColValue_1085SemanticChildren(view);
      case UpdatetRowEditPart.VISUAL_ID:
        return getUpdatetRow_1086SemanticChildren(view);
      case MoveToRowEditPart.VISUAL_ID:
        return getMoveToRow_1087SemanticChildren(view);
      case MoveToLastRowEditPart.VISUAL_ID:
        return getMoveToLastRow_1088SemanticChildren(view);
      case DeleteRowEditPart.VISUAL_ID:
        return getDeleteRow_1089SemanticChildren(view);
      case MoveToInsertRowEditPart.VISUAL_ID:
        return getMoveToInsertRow_1090SemanticChildren(view);
      case InsertRowEditPart.VISUAL_ID:
        return getInsertRow_1091SemanticChildren(view);
      case MoveToFirstRowEditPart.VISUAL_ID:
        return getMoveToFirstRow_1092SemanticChildren(view);
      case PreviousRowEditPart.VISUAL_ID:
        return getPreviousRow_1093SemanticChildren(view);
      case GetColValuesEditPart.VISUAL_ID:
        return getGetColValues_1094SemanticChildren(view);
      case SetColValuesEditPart.VISUAL_ID:
        return getSetColValues_1095SemanticChildren(view);
      case ExtensionTransferEditPart.VISUAL_ID:
        return getExtensionTransfer_1096SemanticChildren(view);
      case RunQueryEditPart.VISUAL_ID:
        return getRunQuery_1097SemanticChildren(view);
      case ChoiceItemPanelEditPart.VISUAL_ID:
        return getChoiceItemPanel_5001SemanticChildren(view);
      case MultiStreamAudioFilesPanelEditPart.VISUAL_ID:
        return getMultiStreamAudioFilesPanel_5002SemanticChildren(view);
      case GetColValuesValuesPanelEditPart.VISUAL_ID:
        return getGetColValuesValuesPanel_5003SemanticChildren(view);
      case SetColValuesValuesPanelEditPart.VISUAL_ID:
        return getSetColValuesValuesPanel_5004SemanticChildren(view);
      case RunQueryRunQueryValuesPanelEditPart.VISUAL_ID:
        return getRunQueryRunQueryValuesPanel_5005SemanticChildren(view);
      case HandlerEditPart.VISUAL_ID:
        return getHandler_79SemanticChildren(view);
      default: {
        for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
            .getDefault().getActionstepProfiles()) {
          if (p.semanticHint.equals(String.valueOf(visualID))) {
            return getActionstepSemanticChildren(view);
          }
        }
      }

    }
    return Collections.EMPTY_LIST;
  }

  public static List getActionstepSemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    ActionStep modelElement = (ActionStep) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getAnswer_1001SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Answer modelElement = (Answer) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getAssignment_1002SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    com.safi.core.actionstep.Assignment modelElement = (Assignment) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getChoice_1003SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Choice modelElement = (Choice) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getGetFullVariable_1004SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    GetFullVariable modelElement = (GetFullVariable) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getMultiStreamAudio_1005SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    MultiStreamAudio modelElement = (MultiStreamAudio) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getHangup_1006SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Hangup modelElement = (Hangup) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getIfThen_1007SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    IfThen modelElement = (IfThen) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getRecordFile_1008SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    com.safi.asterisk.actionstep.RecordFile modelElement = (RecordFile) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSayAlpha_1009SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SayAlpha modelElement = (SayAlpha) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSayDateTime_1010SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SayDateTime modelElement = (SayDateTime) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSayDigits_1011SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SayDigits modelElement = (SayDigits) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSayNumber_1012SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SayNumber modelElement = (SayNumber) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSayPhonetic_1013SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SayPhonetic modelElement = (SayPhonetic) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSayTime_1014SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SayTime modelElement = (SayTime) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetAutoHangup_1015SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetAutoHangup modelElement = (SetAutoHangup) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetCallerId_1016SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetCallerId modelElement = (SetCallerId) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetChannelVariable_1017SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetChannelVariable modelElement = (SetChannelVariable) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetContext_1018SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetContext modelElement = (SetContext) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetExtension_1019SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetExtension modelElement = (SetExtension) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getStopMusicOnHold_1020SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    StopMusicOnHold modelElement = (StopMusicOnHold) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetMusicOn_1021SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetMusicOn modelElement = (SetMusicOn) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetPriority_1022SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetPriority modelElement = (SetPriority) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getStreamAudio_1023SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    StreamAudio modelElement = (StreamAudio) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getWaitForDigit_1024SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    WaitForDigit modelElement = (WaitForDigit) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getGetDigits_1026SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    GetDigits modelElement = (GetDigits) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getOriginateCall_1027SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    OriginateCall modelElement = (OriginateCall) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getPlayDTMF_1028SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    PlayDTMF modelElement = (PlayDTMF) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getRecordCall_1029SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    RecordCall modelElement = (RecordCall) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getExecuteApplication_1030SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    ExecuteApplication modelElement = (ExecuteApplication) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getPlayMusicOnHold_1031SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    PlayMusicOnHold modelElement = (PlayMusicOnHold) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getPromptGetDigits_1032SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    PromptGetDigits modelElement = (PromptGetDigits) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSleep_1033SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Sleep modelElement = (Sleep) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getStreamAudioExtended_1034SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    StreamAudioExtended modelElement = (StreamAudioExtended) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getGetCallInfo_1036SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    GetCallInfo modelElement = (GetCallInfo) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getExecuteScript_1037SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    ExecuteScript modelElement = (ExecuteScript) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getInvokeSaflet_1038SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    InvokeSaflet modelElement = (InvokeSaflet) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getDial_1039SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Dial modelElement = (Dial) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getPickup_1040SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Pickup modelElement = (Pickup) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getBackground_1041SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Background modelElement = (Background) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getBackgroundDetect_1042SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    BackgroundDetect modelElement = (BackgroundDetect) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getWaitExten_1043SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    WaitExten modelElement = (WaitExten) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSoftHangup_1044SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SoftHangup modelElement = (SoftHangup) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getPickupChan_1045SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    PickupChan modelElement = (PickupChan) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getPickdown_1046SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Pickdown modelElement = (Pickdown) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getProgress_1047SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Progress modelElement = (Progress) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getBridge_1048SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Bridge modelElement = (Bridge) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getPlaceCall_1049SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    PlaceCall modelElement = (PlaceCall) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getVoicemail_1050SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Voicemail modelElement = (Voicemail) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getVoicemailMain_1051SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    VoicemailMain modelElement = (VoicemailMain) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getVMAuthenticate_1052SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    VMAuthenticate modelElement = (VMAuthenticate) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getMeetMe_1053SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    MeetMe modelElement = (MeetMe) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getMeetMeAdmin_1054SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    MeetMeAdmin modelElement = (MeetMeAdmin) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getMeetMeCount_1055SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    MeetMeCount modelElement = (MeetMeCount) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getDebugLog_1056SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    DebugLog modelElement = (DebugLog) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getWaitForRing_1057SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    WaitForRing modelElement = (WaitForRing) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getWaitMusicOnHold_1058SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    WaitMusicOnHold modelElement = (WaitMusicOnHold) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getGetAvailableChannel_1059SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    GetAvailableChannel modelElement = (GetAvailableChannel) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getCongestion_1060SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Congestion modelElement = (Congestion) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getRinging_1061SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Ringing modelElement = (Ringing) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetCallerPresentation_1062SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetCallerPresentation modelElement = (SetCallerPresentation) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetGlobalVariable_1063SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetGlobalVariable modelElement = (SetGlobalVariable) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getEcho_1064SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Echo modelElement = (Echo) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getFestival_1065SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Festival modelElement = (Festival) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getPlaytones_1066SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Playtones modelElement = (Playtones) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getStopPlaytones_1067SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    StopPlaytones modelElement = (StopPlaytones) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getChanSpy_1068SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    ChanSpy modelElement = (ChanSpy) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getDictate_1069SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Dictate modelElement = (Dictate) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getExtensionSpy_1070SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    ExtensionSpy modelElement = (ExtensionSpy) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getMixMonitor_1071SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    MixMonitor modelElement = (MixMonitor) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getStopMixmonitor_1072SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    StopMixmonitor modelElement = (StopMixmonitor) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getStopMonitor_1073SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    StopMonitor modelElement = (StopMonitor) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getMonitor_1074SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Monitor modelElement = (Monitor) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getDirectory_1075SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Directory modelElement = (Directory) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getTransfer_1076SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Transfer modelElement = (Transfer) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getOpenDBConnection_1077SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    OpenDBConnection modelElement = (OpenDBConnection) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getCloseDBConnection_1078SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    CloseDBConnection modelElement = (CloseDBConnection) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getOpenQuery_1079SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    OpenQuery modelElement = (OpenQuery) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetQueryParam_1080SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetQueryParam modelElement = (SetQueryParam) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getExecuteUpdate_1081SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    ExecuteUpdate modelElement = (ExecuteUpdate) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getExecuteQuery_1082SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    ExecuteQuery modelElement = (ExecuteQuery) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getNextRow_1083SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    NextRow modelElement = (NextRow) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getGetColValue_1084SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    GetColValue modelElement = (GetColValue) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetColValue_1085SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetColValue modelElement = (SetColValue) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getUpdatetRow_1086SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    com.safi.core.actionstep.UpdatetRow modelElement = (UpdatetRow) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getMoveToRow_1087SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    MoveToRow modelElement = (MoveToRow) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getMoveToLastRow_1088SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    MoveToLastRow modelElement = (MoveToLastRow) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getDeleteRow_1089SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    DeleteRow modelElement = (DeleteRow) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getMoveToInsertRow_1090SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    MoveToInsertRow modelElement = (MoveToInsertRow) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getInsertRow_1091SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    InsertRow modelElement = (InsertRow) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getMoveToFirstRow_1092SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    MoveToFirstRow modelElement = (MoveToFirstRow) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getPreviousRow_1093SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    PreviousRow modelElement = (PreviousRow) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getGetColValues_1094SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    GetColValues modelElement = (GetColValues) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetColValues_1095SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetColValues modelElement = (SetColValues) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getExtensionTransfer_1096SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    ExtensionTransfer modelElement = (ExtensionTransfer) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getRunQuery_1097SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    RunQuery modelElement = (RunQuery) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getChoiceItemPanel_5001SemanticChildren(View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.EMPTY_LIST;
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Choice modelElement = (Choice) containerView.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getChoices()) {
      CaseItem childElement = (CaseItem) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == CaseItemEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getMultiStreamAudioFilesPanel_5002SemanticChildren(View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.EMPTY_LIST;
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    MultiStreamAudio modelElement = (MultiStreamAudio) containerView.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getAudioFilenames()) {
      AudioFileItem childElement = (AudioFileItem) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == AudioFileItemEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getGetColValuesValuesPanel_5003SemanticChildren(View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.EMPTY_LIST;
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    GetColValues modelElement = (GetColValues) containerView.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getColumnMappings()) {
      GetColMapping childElement = (GetColMapping) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == GetColMappingEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getSetColValuesValuesPanel_5004SemanticChildren(View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.EMPTY_LIST;
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    SetColValues modelElement = (SetColValues) containerView.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getColumnMappings()) {
      SetColMapping childElement = (SetColMapping) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == SetColMappingEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getRunQueryRunQueryValuesPanel_5005SemanticChildren(View view) {
    if (false == view.eContainer() instanceof View) {
      return Collections.EMPTY_LIST;
    }
    View containerView = (View) view.eContainer();
    if (!containerView.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    RunQuery modelElement = (RunQuery) containerView.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getParamMappings()) {
      QueryParamMapping childElement = (QueryParamMapping) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == QueryParamMappingEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated NOT
   */
  public static List getHandler_79SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    Saflet modelElement = (Saflet) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getActionsteps()) {
      ActionStep childElement = (ActionStep) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == AnswerEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == AssignmentEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == ChoiceEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == GetFullVariableEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == MultiStreamAudioEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == HangupEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == IfThenEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == RecordFileEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SayAlphaEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SayDateTimeEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SayDigitsEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SayNumberEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SayPhoneticEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SayTimeEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetAutoHangupEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetCallerIdEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetChannelVariableEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetContextEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetExtensionEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == StopMusicOnHoldEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetMusicOnEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetPriorityEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == StreamAudioEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == WaitForDigitEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == GetDigitsEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == OriginateCallEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == PlayDTMFEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == RecordCallEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == ExecuteApplicationEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == PlayMusicOnHoldEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == PromptGetDigitsEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SleepEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == StreamAudioExtendedEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == GetCallInfoEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == ExecuteScriptEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == InvokeSafletEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == DialEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == PickupEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == BackgroundEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == BackgroundDetectEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == WaitExtenEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SoftHangupEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == PickupChanEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == PickdownEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == ProgressEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == BridgeEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == PlaceCallEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == VoicemailEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == VoicemailMainEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == VMAuthenticateEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == MeetMeEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == MeetMeAdminEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == MeetMeCountEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == DebugLogEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == WaitForRingEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == WaitMusicOnHoldEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == GetAvailableChannelEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == CongestionEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == RingingEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetCallerPresentationEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetGlobalVariableEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == EchoEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == FestivalEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == PlaytonesEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == StopPlaytonesEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == ChanSpyEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == DictateEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == ExtensionSpyEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == MixMonitorEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == StopMixmonitorEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == StopMonitorEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == MonitorEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == DirectoryEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == TransferEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == OpenDBConnectionEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == CloseDBConnectionEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == OpenQueryEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetQueryParamEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == ExecuteUpdateEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == ExecuteQueryEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == NextRowEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == GetColValueEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetColValueEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == UpdatetRowEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == MoveToRowEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == MoveToLastRowEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == DeleteRowEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == MoveToInsertRowEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == InsertRowEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == MoveToFirstRowEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == PreviousRowEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == GetColValuesEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == SetColValuesEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == ExtensionTransferEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == RunQueryEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
          .getDefault().getActionstepProfiles()) {
        if (p.semanticHint.equals(String.valueOf(visualID))) {
          result.add(new AsteriskNodeDescriptor(childElement, visualID));
          break;
        }
      }
    }
    {
      Initiator childElement = modelElement.getInitiator();
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == DIDMatcherEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
      }
      if (visualID == IncomingCallEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getContainedLinks(View view) {
    int visualID = AsteriskVisualIDRegistry.getVisualID(view);
    switch (visualID) {
      case HandlerEditPart.VISUAL_ID:
        return getHandler_79ContainedLinks(view);
      case AnswerEditPart.VISUAL_ID:
        return getAnswer_1001ContainedLinks(view);
      case AssignmentEditPart.VISUAL_ID:
        return getAssignment_1002ContainedLinks(view);
      case ChoiceEditPart.VISUAL_ID:
        return getChoice_1003ContainedLinks(view);
      case GetFullVariableEditPart.VISUAL_ID:
        return getGetFullVariable_1004ContainedLinks(view);
      case MultiStreamAudioEditPart.VISUAL_ID:
        return getMultiStreamAudio_1005ContainedLinks(view);
      case HangupEditPart.VISUAL_ID:
        return getHangup_1006ContainedLinks(view);
      case IfThenEditPart.VISUAL_ID:
        return getIfThen_1007ContainedLinks(view);
      case RecordFileEditPart.VISUAL_ID:
        return getRecordFile_1008ContainedLinks(view);
      case SayAlphaEditPart.VISUAL_ID:
        return getSayAlpha_1009ContainedLinks(view);
      case SayDateTimeEditPart.VISUAL_ID:
        return getSayDateTime_1010ContainedLinks(view);
      case SayDigitsEditPart.VISUAL_ID:
        return getSayDigits_1011ContainedLinks(view);
      case SayNumberEditPart.VISUAL_ID:
        return getSayNumber_1012ContainedLinks(view);
      case SayPhoneticEditPart.VISUAL_ID:
        return getSayPhonetic_1013ContainedLinks(view);
      case SayTimeEditPart.VISUAL_ID:
        return getSayTime_1014ContainedLinks(view);
      case SetAutoHangupEditPart.VISUAL_ID:
        return getSetAutoHangup_1015ContainedLinks(view);
      case SetCallerIdEditPart.VISUAL_ID:
        return getSetCallerId_1016ContainedLinks(view);
      case SetChannelVariableEditPart.VISUAL_ID:
        return getSetChannelVariable_1017ContainedLinks(view);
      case SetContextEditPart.VISUAL_ID:
        return getSetContext_1018ContainedLinks(view);
      case SetExtensionEditPart.VISUAL_ID:
        return getSetExtension_1019ContainedLinks(view);
      case StopMusicOnHoldEditPart.VISUAL_ID:
        return getStopMusicOnHold_1020ContainedLinks(view);
      case SetMusicOnEditPart.VISUAL_ID:
        return getSetMusicOn_1021ContainedLinks(view);
      case SetPriorityEditPart.VISUAL_ID:
        return getSetPriority_1022ContainedLinks(view);
      case StreamAudioEditPart.VISUAL_ID:
        return getStreamAudio_1023ContainedLinks(view);
      case WaitForDigitEditPart.VISUAL_ID:
        return getWaitForDigit_1024ContainedLinks(view);
      case DIDMatcherEditPart.VISUAL_ID:
        return getDIDMatcher_1025ContainedLinks(view);
      case GetDigitsEditPart.VISUAL_ID:
        return getGetDigits_1026ContainedLinks(view);
      case OriginateCallEditPart.VISUAL_ID:
        return getOriginateCall_1027ContainedLinks(view);
      case PlayDTMFEditPart.VISUAL_ID:
        return getPlayDTMF_1028ContainedLinks(view);
      case RecordCallEditPart.VISUAL_ID:
        return getRecordCall_1029ContainedLinks(view);
      case ExecuteApplicationEditPart.VISUAL_ID:
        return getExecuteApplication_1030ContainedLinks(view);
      case PlayMusicOnHoldEditPart.VISUAL_ID:
        return getPlayMusicOnHold_1031ContainedLinks(view);
      case PromptGetDigitsEditPart.VISUAL_ID:
        return getPromptGetDigits_1032ContainedLinks(view);
      case SleepEditPart.VISUAL_ID:
        return getSleep_1033ContainedLinks(view);
      case StreamAudioExtendedEditPart.VISUAL_ID:
        return getStreamAudioExtended_1034ContainedLinks(view);
      case IncomingCallEditPart.VISUAL_ID:
        return getIncomingCall_1035ContainedLinks(view);
      case GetCallInfoEditPart.VISUAL_ID:
        return getGetCallInfo_1036ContainedLinks(view);
      case ExecuteScriptEditPart.VISUAL_ID:
        return getExecuteScript_1037ContainedLinks(view);
      case InvokeSafletEditPart.VISUAL_ID:
        return getInvokeSaflet_1038ContainedLinks(view);
      case DialEditPart.VISUAL_ID:
        return getDial_1039ContainedLinks(view);
      case PickupEditPart.VISUAL_ID:
        return getPickup_1040ContainedLinks(view);
      case BackgroundEditPart.VISUAL_ID:
        return getBackground_1041ContainedLinks(view);
      case BackgroundDetectEditPart.VISUAL_ID:
        return getBackgroundDetect_1042ContainedLinks(view);
      case WaitExtenEditPart.VISUAL_ID:
        return getWaitExten_1043ContainedLinks(view);
      case SoftHangupEditPart.VISUAL_ID:
        return getSoftHangup_1044ContainedLinks(view);
      case PickupChanEditPart.VISUAL_ID:
        return getPickupChan_1045ContainedLinks(view);
      case PickdownEditPart.VISUAL_ID:
        return getPickdown_1046ContainedLinks(view);
      case ProgressEditPart.VISUAL_ID:
        return getProgress_1047ContainedLinks(view);
      case BridgeEditPart.VISUAL_ID:
        return getBridge_1048ContainedLinks(view);
      case PlaceCallEditPart.VISUAL_ID:
        return getPlaceCall_1049ContainedLinks(view);
      case VoicemailEditPart.VISUAL_ID:
        return getVoicemail_1050ContainedLinks(view);
      case VoicemailMainEditPart.VISUAL_ID:
        return getVoicemailMain_1051ContainedLinks(view);
      case VMAuthenticateEditPart.VISUAL_ID:
        return getVMAuthenticate_1052ContainedLinks(view);
      case MeetMeEditPart.VISUAL_ID:
        return getMeetMe_1053ContainedLinks(view);
      case MeetMeAdminEditPart.VISUAL_ID:
        return getMeetMeAdmin_1054ContainedLinks(view);
      case MeetMeCountEditPart.VISUAL_ID:
        return getMeetMeCount_1055ContainedLinks(view);
      case DebugLogEditPart.VISUAL_ID:
        return getDebugLog_1056ContainedLinks(view);
      case WaitForRingEditPart.VISUAL_ID:
        return getWaitForRing_1057ContainedLinks(view);
      case WaitMusicOnHoldEditPart.VISUAL_ID:
        return getWaitMusicOnHold_1058ContainedLinks(view);
      case GetAvailableChannelEditPart.VISUAL_ID:
        return getGetAvailableChannel_1059ContainedLinks(view);
      case CongestionEditPart.VISUAL_ID:
        return getCongestion_1060ContainedLinks(view);
      case RingingEditPart.VISUAL_ID:
        return getRinging_1061ContainedLinks(view);
      case SetCallerPresentationEditPart.VISUAL_ID:
        return getSetCallerPresentation_1062ContainedLinks(view);
      case SetGlobalVariableEditPart.VISUAL_ID:
        return getSetGlobalVariable_1063ContainedLinks(view);
      case EchoEditPart.VISUAL_ID:
        return getEcho_1064ContainedLinks(view);
      case FestivalEditPart.VISUAL_ID:
        return getFestival_1065ContainedLinks(view);
      case PlaytonesEditPart.VISUAL_ID:
        return getPlaytones_1066ContainedLinks(view);
      case StopPlaytonesEditPart.VISUAL_ID:
        return getStopPlaytones_1067ContainedLinks(view);
      case ChanSpyEditPart.VISUAL_ID:
        return getChanSpy_1068ContainedLinks(view);
      case DictateEditPart.VISUAL_ID:
        return getDictate_1069ContainedLinks(view);
      case ExtensionSpyEditPart.VISUAL_ID:
        return getExtensionSpy_1070ContainedLinks(view);
      case MixMonitorEditPart.VISUAL_ID:
        return getMixMonitor_1071ContainedLinks(view);
      case StopMixmonitorEditPart.VISUAL_ID:
        return getStopMixmonitor_1072ContainedLinks(view);
      case StopMonitorEditPart.VISUAL_ID:
        return getStopMonitor_1073ContainedLinks(view);
      case MonitorEditPart.VISUAL_ID:
        return getMonitor_1074ContainedLinks(view);
      case DirectoryEditPart.VISUAL_ID:
        return getDirectory_1075ContainedLinks(view);
      case TransferEditPart.VISUAL_ID:
        return getTransfer_1076ContainedLinks(view);
      case OpenDBConnectionEditPart.VISUAL_ID:
        return getOpenDBConnection_1077ContainedLinks(view);
      case CloseDBConnectionEditPart.VISUAL_ID:
        return getCloseDBConnection_1078ContainedLinks(view);
      case OpenQueryEditPart.VISUAL_ID:
        return getOpenQuery_1079ContainedLinks(view);
      case SetQueryParamEditPart.VISUAL_ID:
        return getSetQueryParam_1080ContainedLinks(view);
      case ExecuteUpdateEditPart.VISUAL_ID:
        return getExecuteUpdate_1081ContainedLinks(view);
      case ExecuteQueryEditPart.VISUAL_ID:
        return getExecuteQuery_1082ContainedLinks(view);
      case NextRowEditPart.VISUAL_ID:
        return getNextRow_1083ContainedLinks(view);
      case GetColValueEditPart.VISUAL_ID:
        return getGetColValue_1084ContainedLinks(view);
      case SetColValueEditPart.VISUAL_ID:
        return getSetColValue_1085ContainedLinks(view);
      case UpdatetRowEditPart.VISUAL_ID:
        return getUpdatetRow_1086ContainedLinks(view);
      case MoveToRowEditPart.VISUAL_ID:
        return getMoveToRow_1087ContainedLinks(view);
      case MoveToLastRowEditPart.VISUAL_ID:
        return getMoveToLastRow_1088ContainedLinks(view);
      case DeleteRowEditPart.VISUAL_ID:
        return getDeleteRow_1089ContainedLinks(view);
      case MoveToInsertRowEditPart.VISUAL_ID:
        return getMoveToInsertRow_1090ContainedLinks(view);
      case InsertRowEditPart.VISUAL_ID:
        return getInsertRow_1091ContainedLinks(view);
      case MoveToFirstRowEditPart.VISUAL_ID:
        return getMoveToFirstRow_1092ContainedLinks(view);
      case PreviousRowEditPart.VISUAL_ID:
        return getPreviousRow_1093ContainedLinks(view);
      case GetColValuesEditPart.VISUAL_ID:
        return getGetColValues_1094ContainedLinks(view);
      case SetColValuesEditPart.VISUAL_ID:
        return getSetColValues_1095ContainedLinks(view);
      case ExtensionTransferEditPart.VISUAL_ID:
        return getExtensionTransfer_1096ContainedLinks(view);
      case RunQueryEditPart.VISUAL_ID:
        return getRunQuery_1097ContainedLinks(view);
      case OutputEditPart.VISUAL_ID:
        return getOutput_2001ContainedLinks(view);
      case CaseItemEditPart.VISUAL_ID:
        return getCaseItem_2002ContainedLinks(view);
      case AudioFileItemEditPart.VISUAL_ID:
        return getAudioFileItem_2003ContainedLinks(view);
      case GetColMappingEditPart.VISUAL_ID:
        return getGetColMapping_2004ContainedLinks(view);
      case SetColMappingEditPart.VISUAL_ID:
        return getSetColMapping_2005ContainedLinks(view);
      case QueryParamMappingEditPart.VISUAL_ID:
        return getQueryParamMapping_2006ContainedLinks(view);
      default:
        // {
        // for (AsteriskDiagramEditorPlugin.ActionStepProfile p :
        // AsteriskDiagramEditorPlugin.getDefault().getActionstepProfiles()){
        // if (p.semanticHint.equals(String.valueOf(visualID))){
        // return getActionstepContainedLinks(view);
        // }
        // }
        // }
    }
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getIncomingLinks(View view) {
    int visualID = AsteriskVisualIDRegistry.getVisualID(view);
    switch (visualID) {
      case AnswerEditPart.VISUAL_ID:
        return getAnswer_1001IncomingLinks(view);
      case AssignmentEditPart.VISUAL_ID:
        return getAssignment_1002IncomingLinks(view);
      case ChoiceEditPart.VISUAL_ID:
        return getChoice_1003IncomingLinks(view);
      case GetFullVariableEditPart.VISUAL_ID:
        return getGetFullVariable_1004IncomingLinks(view);
      case MultiStreamAudioEditPart.VISUAL_ID:
        return getMultiStreamAudio_1005IncomingLinks(view);
      case HangupEditPart.VISUAL_ID:
        return getHangup_1006IncomingLinks(view);
      case IfThenEditPart.VISUAL_ID:
        return getIfThen_1007IncomingLinks(view);
      case RecordFileEditPart.VISUAL_ID:
        return getRecordFile_1008IncomingLinks(view);
      case SayAlphaEditPart.VISUAL_ID:
        return getSayAlpha_1009IncomingLinks(view);
      case SayDateTimeEditPart.VISUAL_ID:
        return getSayDateTime_1010IncomingLinks(view);
      case SayDigitsEditPart.VISUAL_ID:
        return getSayDigits_1011IncomingLinks(view);
      case SayNumberEditPart.VISUAL_ID:
        return getSayNumber_1012IncomingLinks(view);
      case SayPhoneticEditPart.VISUAL_ID:
        return getSayPhonetic_1013IncomingLinks(view);
      case SayTimeEditPart.VISUAL_ID:
        return getSayTime_1014IncomingLinks(view);
      case SetAutoHangupEditPart.VISUAL_ID:
        return getSetAutoHangup_1015IncomingLinks(view);
      case SetCallerIdEditPart.VISUAL_ID:
        return getSetCallerId_1016IncomingLinks(view);
      case SetChannelVariableEditPart.VISUAL_ID:
        return getSetChannelVariable_1017IncomingLinks(view);
      case SetContextEditPart.VISUAL_ID:
        return getSetContext_1018IncomingLinks(view);
      case SetExtensionEditPart.VISUAL_ID:
        return getSetExtension_1019IncomingLinks(view);
      case StopMusicOnHoldEditPart.VISUAL_ID:
        return getStopMusicOnHold_1020IncomingLinks(view);
      case SetMusicOnEditPart.VISUAL_ID:
        return getSetMusicOn_1021IncomingLinks(view);
      case SetPriorityEditPart.VISUAL_ID:
        return getSetPriority_1022IncomingLinks(view);
      case StreamAudioEditPart.VISUAL_ID:
        return getStreamAudio_1023IncomingLinks(view);
      case WaitForDigitEditPart.VISUAL_ID:
        return getWaitForDigit_1024IncomingLinks(view);
      case DIDMatcherEditPart.VISUAL_ID:
        return getDIDMatcher_1025IncomingLinks(view);
      case GetDigitsEditPart.VISUAL_ID:
        return getGetDigits_1026IncomingLinks(view);
      case OriginateCallEditPart.VISUAL_ID:
        return getOriginateCall_1027IncomingLinks(view);
      case PlayDTMFEditPart.VISUAL_ID:
        return getPlayDTMF_1028IncomingLinks(view);
      case RecordCallEditPart.VISUAL_ID:
        return getRecordCall_1029IncomingLinks(view);
      case ExecuteApplicationEditPart.VISUAL_ID:
        return getExecuteApplication_1030IncomingLinks(view);
      case PlayMusicOnHoldEditPart.VISUAL_ID:
        return getPlayMusicOnHold_1031IncomingLinks(view);
      case PromptGetDigitsEditPart.VISUAL_ID:
        return getPromptGetDigits_1032IncomingLinks(view);
      case SleepEditPart.VISUAL_ID:
        return getSleep_1033IncomingLinks(view);
      case StreamAudioExtendedEditPart.VISUAL_ID:
        return getStreamAudioExtended_1034IncomingLinks(view);
      case IncomingCallEditPart.VISUAL_ID:
        return getIncomingCall_1035IncomingLinks(view);
      case GetCallInfoEditPart.VISUAL_ID:
        return getGetCallInfo_1036IncomingLinks(view);
      case ExecuteScriptEditPart.VISUAL_ID:
        return getExecuteScript_1037IncomingLinks(view);
      case InvokeSafletEditPart.VISUAL_ID:
        return getInvokeSaflet_1038IncomingLinks(view);
      case DialEditPart.VISUAL_ID:
        return getDial_1039IncomingLinks(view);
      case PickupEditPart.VISUAL_ID:
        return getPickup_1040IncomingLinks(view);
      case BackgroundEditPart.VISUAL_ID:
        return getBackground_1041IncomingLinks(view);
      case BackgroundDetectEditPart.VISUAL_ID:
        return getBackgroundDetect_1042IncomingLinks(view);
      case WaitExtenEditPart.VISUAL_ID:
        return getWaitExten_1043IncomingLinks(view);
      case SoftHangupEditPart.VISUAL_ID:
        return getSoftHangup_1044IncomingLinks(view);
      case PickupChanEditPart.VISUAL_ID:
        return getPickupChan_1045IncomingLinks(view);
      case PickdownEditPart.VISUAL_ID:
        return getPickdown_1046IncomingLinks(view);
      case ProgressEditPart.VISUAL_ID:
        return getProgress_1047IncomingLinks(view);
      case BridgeEditPart.VISUAL_ID:
        return getBridge_1048IncomingLinks(view);
      case PlaceCallEditPart.VISUAL_ID:
        return getPlaceCall_1049IncomingLinks(view);
      case VoicemailEditPart.VISUAL_ID:
        return getVoicemail_1050IncomingLinks(view);
      case VoicemailMainEditPart.VISUAL_ID:
        return getVoicemailMain_1051IncomingLinks(view);
      case VMAuthenticateEditPart.VISUAL_ID:
        return getVMAuthenticate_1052IncomingLinks(view);
      case MeetMeEditPart.VISUAL_ID:
        return getMeetMe_1053IncomingLinks(view);
      case MeetMeAdminEditPart.VISUAL_ID:
        return getMeetMeAdmin_1054IncomingLinks(view);
      case MeetMeCountEditPart.VISUAL_ID:
        return getMeetMeCount_1055IncomingLinks(view);
      case DebugLogEditPart.VISUAL_ID:
        return getDebugLog_1056IncomingLinks(view);
      case WaitForRingEditPart.VISUAL_ID:
        return getWaitForRing_1057IncomingLinks(view);
      case WaitMusicOnHoldEditPart.VISUAL_ID:
        return getWaitMusicOnHold_1058IncomingLinks(view);
      case GetAvailableChannelEditPart.VISUAL_ID:
        return getGetAvailableChannel_1059IncomingLinks(view);
      case CongestionEditPart.VISUAL_ID:
        return getCongestion_1060IncomingLinks(view);
      case RingingEditPart.VISUAL_ID:
        return getRinging_1061IncomingLinks(view);
      case SetCallerPresentationEditPart.VISUAL_ID:
        return getSetCallerPresentation_1062IncomingLinks(view);
      case SetGlobalVariableEditPart.VISUAL_ID:
        return getSetGlobalVariable_1063IncomingLinks(view);
      case EchoEditPart.VISUAL_ID:
        return getEcho_1064IncomingLinks(view);
      case FestivalEditPart.VISUAL_ID:
        return getFestival_1065IncomingLinks(view);
      case PlaytonesEditPart.VISUAL_ID:
        return getPlaytones_1066IncomingLinks(view);
      case StopPlaytonesEditPart.VISUAL_ID:
        return getStopPlaytones_1067IncomingLinks(view);
      case ChanSpyEditPart.VISUAL_ID:
        return getChanSpy_1068IncomingLinks(view);
      case DictateEditPart.VISUAL_ID:
        return getDictate_1069IncomingLinks(view);
      case ExtensionSpyEditPart.VISUAL_ID:
        return getExtensionSpy_1070IncomingLinks(view);
      case MixMonitorEditPart.VISUAL_ID:
        return getMixMonitor_1071IncomingLinks(view);
      case StopMixmonitorEditPart.VISUAL_ID:
        return getStopMixmonitor_1072IncomingLinks(view);
      case StopMonitorEditPart.VISUAL_ID:
        return getStopMonitor_1073IncomingLinks(view);
      case MonitorEditPart.VISUAL_ID:
        return getMonitor_1074IncomingLinks(view);
      case DirectoryEditPart.VISUAL_ID:
        return getDirectory_1075IncomingLinks(view);
      case TransferEditPart.VISUAL_ID:
        return getTransfer_1076IncomingLinks(view);
      case OpenDBConnectionEditPart.VISUAL_ID:
        return getOpenDBConnection_1077IncomingLinks(view);
      case CloseDBConnectionEditPart.VISUAL_ID:
        return getCloseDBConnection_1078IncomingLinks(view);
      case OpenQueryEditPart.VISUAL_ID:
        return getOpenQuery_1079IncomingLinks(view);
      case SetQueryParamEditPart.VISUAL_ID:
        return getSetQueryParam_1080IncomingLinks(view);
      case ExecuteUpdateEditPart.VISUAL_ID:
        return getExecuteUpdate_1081IncomingLinks(view);
      case ExecuteQueryEditPart.VISUAL_ID:
        return getExecuteQuery_1082IncomingLinks(view);
      case NextRowEditPart.VISUAL_ID:
        return getNextRow_1083IncomingLinks(view);
      case GetColValueEditPart.VISUAL_ID:
        return getGetColValue_1084IncomingLinks(view);
      case SetColValueEditPart.VISUAL_ID:
        return getSetColValue_1085IncomingLinks(view);
      case UpdatetRowEditPart.VISUAL_ID:
        return getUpdatetRow_1086IncomingLinks(view);
      case MoveToRowEditPart.VISUAL_ID:
        return getMoveToRow_1087IncomingLinks(view);
      case MoveToLastRowEditPart.VISUAL_ID:
        return getMoveToLastRow_1088IncomingLinks(view);
      case DeleteRowEditPart.VISUAL_ID:
        return getDeleteRow_1089IncomingLinks(view);
      case MoveToInsertRowEditPart.VISUAL_ID:
        return getMoveToInsertRow_1090IncomingLinks(view);
      case InsertRowEditPart.VISUAL_ID:
        return getInsertRow_1091IncomingLinks(view);
      case MoveToFirstRowEditPart.VISUAL_ID:
        return getMoveToFirstRow_1092IncomingLinks(view);
      case PreviousRowEditPart.VISUAL_ID:
        return getPreviousRow_1093IncomingLinks(view);
      case GetColValuesEditPart.VISUAL_ID:
        return getGetColValues_1094IncomingLinks(view);
      case SetColValuesEditPart.VISUAL_ID:
        return getSetColValues_1095IncomingLinks(view);
      case ExtensionTransferEditPart.VISUAL_ID:
        return getExtensionTransfer_1096IncomingLinks(view);
      case RunQueryEditPart.VISUAL_ID:
        return getRunQuery_1097IncomingLinks(view);
      case OutputEditPart.VISUAL_ID:
        return getOutput_2001IncomingLinks(view);
      case CaseItemEditPart.VISUAL_ID:
        return getCaseItem_2002IncomingLinks(view);
      case AudioFileItemEditPart.VISUAL_ID:
        return getAudioFileItem_2003IncomingLinks(view);
      case GetColMappingEditPart.VISUAL_ID:
        return getGetColMapping_2004IncomingLinks(view);
      case SetColMappingEditPart.VISUAL_ID:
        return getSetColMapping_2005IncomingLinks(view);
      case QueryParamMappingEditPart.VISUAL_ID:
        return getQueryParamMapping_2006IncomingLinks(view);
      default: {
        if (view.getElement() instanceof CaseItem) {
          return getCaseItem_2002IncomingLinks(view);
        }
        for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
            .getDefault().getActionstepProfiles()) {
          if (p.semanticHint.equals(String.valueOf(visualID))) {
            return getActionstepIncomingLinks(view);
          }
        }
      }
    }
    return Collections.EMPTY_LIST;
  }

  public static List getActionstepIncomingLinks(View view) {
    ActionStep modelElement = (ActionStep) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getOutgoingLinks(View view) {
    int visualID = AsteriskVisualIDRegistry.getVisualID(view);
    switch (visualID) {
      case AnswerEditPart.VISUAL_ID:
        return getAnswer_1001OutgoingLinks(view);
      case AssignmentEditPart.VISUAL_ID:
        return getAssignment_1002OutgoingLinks(view);
      case ChoiceEditPart.VISUAL_ID:
        return getChoice_1003OutgoingLinks(view);
      case GetFullVariableEditPart.VISUAL_ID:
        return getGetFullVariable_1004OutgoingLinks(view);
      case MultiStreamAudioEditPart.VISUAL_ID:
        return getMultiStreamAudio_1005OutgoingLinks(view);
      case HangupEditPart.VISUAL_ID:
        return getHangup_1006OutgoingLinks(view);
      case IfThenEditPart.VISUAL_ID:
        return getIfThen_1007OutgoingLinks(view);
      case RecordFileEditPart.VISUAL_ID:
        return getRecordFile_1008OutgoingLinks(view);
      case SayAlphaEditPart.VISUAL_ID:
        return getSayAlpha_1009OutgoingLinks(view);
      case SayDateTimeEditPart.VISUAL_ID:
        return getSayDateTime_1010OutgoingLinks(view);
      case SayDigitsEditPart.VISUAL_ID:
        return getSayDigits_1011OutgoingLinks(view);
      case SayNumberEditPart.VISUAL_ID:
        return getSayNumber_1012OutgoingLinks(view);
      case SayPhoneticEditPart.VISUAL_ID:
        return getSayPhonetic_1013OutgoingLinks(view);
      case SayTimeEditPart.VISUAL_ID:
        return getSayTime_1014OutgoingLinks(view);
      case SetAutoHangupEditPart.VISUAL_ID:
        return getSetAutoHangup_1015OutgoingLinks(view);
      case SetCallerIdEditPart.VISUAL_ID:
        return getSetCallerId_1016OutgoingLinks(view);
      case SetChannelVariableEditPart.VISUAL_ID:
        return getSetChannelVariable_1017OutgoingLinks(view);
      case SetContextEditPart.VISUAL_ID:
        return getSetContext_1018OutgoingLinks(view);
      case SetExtensionEditPart.VISUAL_ID:
        return getSetExtension_1019OutgoingLinks(view);
      case StopMusicOnHoldEditPart.VISUAL_ID:
        return getStopMusicOnHold_1020OutgoingLinks(view);
      case SetMusicOnEditPart.VISUAL_ID:
        return getSetMusicOn_1021OutgoingLinks(view);
      case SetPriorityEditPart.VISUAL_ID:
        return getSetPriority_1022OutgoingLinks(view);
      case StreamAudioEditPart.VISUAL_ID:
        return getStreamAudio_1023OutgoingLinks(view);
      case WaitForDigitEditPart.VISUAL_ID:
        return getWaitForDigit_1024OutgoingLinks(view);
      case DIDMatcherEditPart.VISUAL_ID:
        return getDIDMatcher_1025OutgoingLinks(view);
      case GetDigitsEditPart.VISUAL_ID:
        return getGetDigits_1026OutgoingLinks(view);
      case OriginateCallEditPart.VISUAL_ID:
        return getOriginateCall_1027OutgoingLinks(view);
      case PlayDTMFEditPart.VISUAL_ID:
        return getPlayDTMF_1028OutgoingLinks(view);
      case RecordCallEditPart.VISUAL_ID:
        return getRecordCall_1029OutgoingLinks(view);
      case ExecuteApplicationEditPart.VISUAL_ID:
        return getExecuteApplication_1030OutgoingLinks(view);
      case PlayMusicOnHoldEditPart.VISUAL_ID:
        return getPlayMusicOnHold_1031OutgoingLinks(view);
      case PromptGetDigitsEditPart.VISUAL_ID:
        return getPromptGetDigits_1032OutgoingLinks(view);
      case SleepEditPart.VISUAL_ID:
        return getSleep_1033OutgoingLinks(view);
      case StreamAudioExtendedEditPart.VISUAL_ID:
        return getStreamAudioExtended_1034OutgoingLinks(view);
      case IncomingCallEditPart.VISUAL_ID:
        return getIncomingCall_1035OutgoingLinks(view);
      case GetCallInfoEditPart.VISUAL_ID:
        return getGetCallInfo_1036OutgoingLinks(view);
      case ExecuteScriptEditPart.VISUAL_ID:
        return getExecuteScript_1037OutgoingLinks(view);
      case InvokeSafletEditPart.VISUAL_ID:
        return getInvokeSaflet_1038OutgoingLinks(view);
      case DialEditPart.VISUAL_ID:
        return getDial_1039OutgoingLinks(view);
      case PickupEditPart.VISUAL_ID:
        return getPickup_1040OutgoingLinks(view);
      case BackgroundEditPart.VISUAL_ID:
        return getBackground_1041OutgoingLinks(view);
      case BackgroundDetectEditPart.VISUAL_ID:
        return getBackgroundDetect_1042OutgoingLinks(view);
      case WaitExtenEditPart.VISUAL_ID:
        return getWaitExten_1043OutgoingLinks(view);
      case SoftHangupEditPart.VISUAL_ID:
        return getSoftHangup_1044OutgoingLinks(view);
      case PickupChanEditPart.VISUAL_ID:
        return getPickupChan_1045OutgoingLinks(view);
      case PickdownEditPart.VISUAL_ID:
        return getPickdown_1046OutgoingLinks(view);
      case ProgressEditPart.VISUAL_ID:
        return getProgress_1047OutgoingLinks(view);
      case BridgeEditPart.VISUAL_ID:
        return getBridge_1048OutgoingLinks(view);
      case PlaceCallEditPart.VISUAL_ID:
        return getPlaceCall_1049OutgoingLinks(view);
      case VoicemailEditPart.VISUAL_ID:
        return getVoicemail_1050OutgoingLinks(view);
      case VoicemailMainEditPart.VISUAL_ID:
        return getVoicemailMain_1051OutgoingLinks(view);
      case VMAuthenticateEditPart.VISUAL_ID:
        return getVMAuthenticate_1052OutgoingLinks(view);
      case MeetMeEditPart.VISUAL_ID:
        return getMeetMe_1053OutgoingLinks(view);
      case MeetMeAdminEditPart.VISUAL_ID:
        return getMeetMeAdmin_1054OutgoingLinks(view);
      case MeetMeCountEditPart.VISUAL_ID:
        return getMeetMeCount_1055OutgoingLinks(view);
      case DebugLogEditPart.VISUAL_ID:
        return getDebugLog_1056OutgoingLinks(view);
      case WaitForRingEditPart.VISUAL_ID:
        return getWaitForRing_1057OutgoingLinks(view);
      case WaitMusicOnHoldEditPart.VISUAL_ID:
        return getWaitMusicOnHold_1058OutgoingLinks(view);
      case GetAvailableChannelEditPart.VISUAL_ID:
        return getGetAvailableChannel_1059OutgoingLinks(view);
      case CongestionEditPart.VISUAL_ID:
        return getCongestion_1060OutgoingLinks(view);
      case RingingEditPart.VISUAL_ID:
        return getRinging_1061OutgoingLinks(view);
      case SetCallerPresentationEditPart.VISUAL_ID:
        return getSetCallerPresentation_1062OutgoingLinks(view);
      case SetGlobalVariableEditPart.VISUAL_ID:
        return getSetGlobalVariable_1063OutgoingLinks(view);
      case EchoEditPart.VISUAL_ID:
        return getEcho_1064OutgoingLinks(view);
      case FestivalEditPart.VISUAL_ID:
        return getFestival_1065OutgoingLinks(view);
      case PlaytonesEditPart.VISUAL_ID:
        return getPlaytones_1066OutgoingLinks(view);
      case StopPlaytonesEditPart.VISUAL_ID:
        return getStopPlaytones_1067OutgoingLinks(view);
      case ChanSpyEditPart.VISUAL_ID:
        return getChanSpy_1068OutgoingLinks(view);
      case DictateEditPart.VISUAL_ID:
        return getDictate_1069OutgoingLinks(view);
      case ExtensionSpyEditPart.VISUAL_ID:
        return getExtensionSpy_1070OutgoingLinks(view);
      case MixMonitorEditPart.VISUAL_ID:
        return getMixMonitor_1071OutgoingLinks(view);
      case StopMixmonitorEditPart.VISUAL_ID:
        return getStopMixmonitor_1072OutgoingLinks(view);
      case StopMonitorEditPart.VISUAL_ID:
        return getStopMonitor_1073OutgoingLinks(view);
      case MonitorEditPart.VISUAL_ID:
        return getMonitor_1074OutgoingLinks(view);
      case DirectoryEditPart.VISUAL_ID:
        return getDirectory_1075OutgoingLinks(view);
      case TransferEditPart.VISUAL_ID:
        return getTransfer_1076OutgoingLinks(view);
      case OpenDBConnectionEditPart.VISUAL_ID:
        return getOpenDBConnection_1077OutgoingLinks(view);
      case CloseDBConnectionEditPart.VISUAL_ID:
        return getCloseDBConnection_1078OutgoingLinks(view);
      case OpenQueryEditPart.VISUAL_ID:
        return getOpenQuery_1079OutgoingLinks(view);
      case SetQueryParamEditPart.VISUAL_ID:
        return getSetQueryParam_1080OutgoingLinks(view);
      case ExecuteUpdateEditPart.VISUAL_ID:
        return getExecuteUpdate_1081OutgoingLinks(view);
      case ExecuteQueryEditPart.VISUAL_ID:
        return getExecuteQuery_1082OutgoingLinks(view);
      case NextRowEditPart.VISUAL_ID:
        return getNextRow_1083OutgoingLinks(view);
      case GetColValueEditPart.VISUAL_ID:
        return getGetColValue_1084OutgoingLinks(view);
      case SetColValueEditPart.VISUAL_ID:
        return getSetColValue_1085OutgoingLinks(view);
      case UpdatetRowEditPart.VISUAL_ID:
        return getUpdatetRow_1086OutgoingLinks(view);
      case MoveToRowEditPart.VISUAL_ID:
        return getMoveToRow_1087OutgoingLinks(view);
      case MoveToLastRowEditPart.VISUAL_ID:
        return getMoveToLastRow_1088OutgoingLinks(view);
      case DeleteRowEditPart.VISUAL_ID:
        return getDeleteRow_1089OutgoingLinks(view);
      case MoveToInsertRowEditPart.VISUAL_ID:
        return getMoveToInsertRow_1090OutgoingLinks(view);
      case InsertRowEditPart.VISUAL_ID:
        return getInsertRow_1091OutgoingLinks(view);
      case MoveToFirstRowEditPart.VISUAL_ID:
        return getMoveToFirstRow_1092OutgoingLinks(view);
      case PreviousRowEditPart.VISUAL_ID:
        return getPreviousRow_1093OutgoingLinks(view);
      case GetColValuesEditPart.VISUAL_ID:
        return getGetColValues_1094OutgoingLinks(view);
      case SetColValuesEditPart.VISUAL_ID:
        return getSetColValues_1095OutgoingLinks(view);
      case ExtensionTransferEditPart.VISUAL_ID:
        return getExtensionTransfer_1096OutgoingLinks(view);
      case RunQueryEditPart.VISUAL_ID:
        return getRunQuery_1097OutgoingLinks(view);
      case OutputEditPart.VISUAL_ID:
        return getOutput_2001OutgoingLinks(view);
      case CaseItemEditPart.VISUAL_ID:
        return getCaseItem_2002OutgoingLinks(view);
      case AudioFileItemEditPart.VISUAL_ID:
        return getAudioFileItem_2003OutgoingLinks(view);
      case GetColMappingEditPart.VISUAL_ID:
        return getGetColMapping_2004OutgoingLinks(view);
      case SetColMappingEditPart.VISUAL_ID:
        return getSetColMapping_2005OutgoingLinks(view);
      case QueryParamMappingEditPart.VISUAL_ID:
        return getQueryParamMapping_2006OutgoingLinks(view);
      default:
        if (view.getElement() instanceof CaseItem) {
          return getCaseItem_2002OutgoingLinks(view);
        }

    }
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getHandler_79ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getAnswer_1001ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getAssignment_1002ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getChoice_1003ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetFullVariable_1004ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMultiStreamAudio_1005ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getHangup_1006ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getIfThen_1007ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getRecordFile_1008ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayAlpha_1009ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayDateTime_1010ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayDigits_1011ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayNumber_1012ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayPhonetic_1013ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayTime_1014ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetAutoHangup_1015ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetCallerId_1016ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetChannelVariable_1017ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetContext_1018ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetExtension_1019ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStopMusicOnHold_1020ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetMusicOn_1021ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetPriority_1022ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStreamAudio_1023ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getWaitForDigit_1024ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDIDMatcher_1025ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetDigits_1026ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getOriginateCall_1027ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPlayDTMF_1028ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getRecordCall_1029ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExecuteApplication_1030ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPlayMusicOnHold_1031ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPromptGetDigits_1032ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSleep_1033ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStreamAudioExtended_1034ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  public static List getIncomingCall_1035SemanticChildren(View view) {
    if (!view.isSetElement()) {
      return Collections.EMPTY_LIST;
    }
    IncomingCall modelElement = (IncomingCall) view.getElement();
    List result = new LinkedList();
    for (Object element : modelElement.getOutputs()) {
      Output childElement = (Output) element;
      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
      if (visualID == OutputEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
    }
    return result;
  }

  /**
   * @generated
   */
  public static List getIncomingCall_1035ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetCallInfo_1036ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExecuteScript_1037ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getInvokeSaflet_1038ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDial_1039ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPickup_1040ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getBackground_1041ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getBackgroundDetect_1042ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getWaitExten_1043ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSoftHangup_1044ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPickupChan_1045ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPickdown_1046ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getProgress_1047ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getBridge_1048ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPlaceCall_1049ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getVoicemail_1050ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getVoicemailMain_1051ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getVMAuthenticate_1052ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMeetMe_1053ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMeetMeAdmin_1054ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMeetMeCount_1055ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDebugLog_1056ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getWaitForRing_1057ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getWaitMusicOnHold_1058ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetAvailableChannel_1059ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getCongestion_1060ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getRinging_1061ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetCallerPresentation_1062ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetGlobalVariable_1063ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getEcho_1064ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getFestival_1065ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPlaytones_1066ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStopPlaytones_1067ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getChanSpy_1068ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDictate_1069ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExtensionSpy_1070ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMixMonitor_1071ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStopMixmonitor_1072ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStopMonitor_1073ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMonitor_1074ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDirectory_1075ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getTransfer_1076ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getOpenDBConnection_1077ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getCloseDBConnection_1078ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getOpenQuery_1079ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetQueryParam_1080ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExecuteUpdate_1081ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExecuteQuery_1082ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getNextRow_1083ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetColValue_1084ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetColValue_1085ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getUpdatetRow_1086ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMoveToRow_1087ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMoveToLastRow_1088ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDeleteRow_1089ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMoveToInsertRow_1090ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getInsertRow_1091ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMoveToFirstRow_1092ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPreviousRow_1093ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetColValues_1094ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetColValues_1095ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExtensionTransfer_1096ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getRunQuery_1097ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getOutput_2001ContainedLinks(View view) {
    Output modelElement = (Output) view.getElement();
    List result = new LinkedList();
    result.addAll(getOutgoingFeatureModelFacetLinks_Output_Target_3001(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List getCaseItem_2002ContainedLinks(View view) {
    CaseItem modelElement = (CaseItem) view.getElement();
    List result = new LinkedList();
    result.addAll(getOutgoingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List getAudioFileItem_2003ContainedLinks(View view) {
    AudioFileItem modelElement = (AudioFileItem) view.getElement();
    List result = new LinkedList();
    result.addAll(getOutgoingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List getGetColMapping_2004ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetColMapping_2005ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getQueryParamMapping_2006ContainedLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getAnswer_1001IncomingLinks(View view) {
    Answer modelElement = (Answer) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getAssignment_1002IncomingLinks(View view) {
    Assignment modelElement = (Assignment) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getChoice_1003IncomingLinks(View view) {
    Choice modelElement = (Choice) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getGetFullVariable_1004IncomingLinks(View view) {
    GetFullVariable modelElement = (GetFullVariable) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getMultiStreamAudio_1005IncomingLinks(View view) {
    MultiStreamAudio modelElement = (MultiStreamAudio) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getHangup_1006IncomingLinks(View view) {
    Hangup modelElement = (Hangup) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getIfThen_1007IncomingLinks(View view) {
    IfThen modelElement = (IfThen) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getRecordFile_1008IncomingLinks(View view) {
    RecordFile modelElement = (RecordFile) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSayAlpha_1009IncomingLinks(View view) {
    SayAlpha modelElement = (SayAlpha) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSayDateTime_1010IncomingLinks(View view) {
    SayDateTime modelElement = (SayDateTime) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSayDigits_1011IncomingLinks(View view) {
    SayDigits modelElement = (SayDigits) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSayNumber_1012IncomingLinks(View view) {
    SayNumber modelElement = (SayNumber) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSayPhonetic_1013IncomingLinks(View view) {
    SayPhonetic modelElement = (SayPhonetic) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSayTime_1014IncomingLinks(View view) {
    SayTime modelElement = (SayTime) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetAutoHangup_1015IncomingLinks(View view) {
    SetAutoHangup modelElement = (SetAutoHangup) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetCallerId_1016IncomingLinks(View view) {
    SetCallerId modelElement = (SetCallerId) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetChannelVariable_1017IncomingLinks(View view) {
    SetChannelVariable modelElement = (SetChannelVariable) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetContext_1018IncomingLinks(View view) {
    SetContext modelElement = (SetContext) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetExtension_1019IncomingLinks(View view) {
    SetExtension modelElement = (SetExtension) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getStopMusicOnHold_1020IncomingLinks(View view) {
    StopMusicOnHold modelElement = (StopMusicOnHold) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetMusicOn_1021IncomingLinks(View view) {
    SetMusicOn modelElement = (SetMusicOn) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetPriority_1022IncomingLinks(View view) {
    SetPriority modelElement = (SetPriority) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getStreamAudio_1023IncomingLinks(View view) {
    StreamAudio modelElement = (StreamAudio) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getWaitForDigit_1024IncomingLinks(View view) {
    WaitForDigit modelElement = (WaitForDigit) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getDIDMatcher_1025IncomingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetDigits_1026IncomingLinks(View view) {
    GetDigits modelElement = (GetDigits) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getOriginateCall_1027IncomingLinks(View view) {
    OriginateCall modelElement = (OriginateCall) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getPlayDTMF_1028IncomingLinks(View view) {
    PlayDTMF modelElement = (PlayDTMF) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getRecordCall_1029IncomingLinks(View view) {
    RecordCall modelElement = (RecordCall) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getExecuteApplication_1030IncomingLinks(View view) {
    ExecuteApplication modelElement = (ExecuteApplication) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getPlayMusicOnHold_1031IncomingLinks(View view) {
    PlayMusicOnHold modelElement = (PlayMusicOnHold) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getPromptGetDigits_1032IncomingLinks(View view) {
    PromptGetDigits modelElement = (PromptGetDigits) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSleep_1033IncomingLinks(View view) {
    Sleep modelElement = (Sleep) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getStreamAudioExtended_1034IncomingLinks(View view) {
    StreamAudioExtended modelElement = (StreamAudioExtended) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getIncomingCall_1035IncomingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetCallInfo_1036IncomingLinks(View view) {
    GetCallInfo modelElement = (GetCallInfo) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getExecuteScript_1037IncomingLinks(View view) {
    ExecuteScript modelElement = (ExecuteScript) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getInvokeSaflet_1038IncomingLinks(View view) {
    InvokeSaflet modelElement = (InvokeSaflet) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getDial_1039IncomingLinks(View view) {
    Dial modelElement = (Dial) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getPickup_1040IncomingLinks(View view) {
    Pickup modelElement = (Pickup) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getBackground_1041IncomingLinks(View view) {
    Background modelElement = (Background) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getBackgroundDetect_1042IncomingLinks(View view) {
    BackgroundDetect modelElement = (BackgroundDetect) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getWaitExten_1043IncomingLinks(View view) {
    WaitExten modelElement = (WaitExten) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSoftHangup_1044IncomingLinks(View view) {
    SoftHangup modelElement = (SoftHangup) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getPickupChan_1045IncomingLinks(View view) {
    PickupChan modelElement = (PickupChan) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getPickdown_1046IncomingLinks(View view) {
    Pickdown modelElement = (Pickdown) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getProgress_1047IncomingLinks(View view) {
    Progress modelElement = (Progress) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getBridge_1048IncomingLinks(View view) {
    Bridge modelElement = (Bridge) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getPlaceCall_1049IncomingLinks(View view) {
    PlaceCall modelElement = (PlaceCall) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getVoicemail_1050IncomingLinks(View view) {
    Voicemail modelElement = (Voicemail) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getVoicemailMain_1051IncomingLinks(View view) {
    VoicemailMain modelElement = (VoicemailMain) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getVMAuthenticate_1052IncomingLinks(View view) {
    VMAuthenticate modelElement = (VMAuthenticate) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getMeetMe_1053IncomingLinks(View view) {
    MeetMe modelElement = (MeetMe) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getMeetMeAdmin_1054IncomingLinks(View view) {
    MeetMeAdmin modelElement = (MeetMeAdmin) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getMeetMeCount_1055IncomingLinks(View view) {
    MeetMeCount modelElement = (MeetMeCount) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getDebugLog_1056IncomingLinks(View view) {
    DebugLog modelElement = (DebugLog) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getWaitForRing_1057IncomingLinks(View view) {
    WaitForRing modelElement = (WaitForRing) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getWaitMusicOnHold_1058IncomingLinks(View view) {
    WaitMusicOnHold modelElement = (WaitMusicOnHold) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getGetAvailableChannel_1059IncomingLinks(View view) {
    GetAvailableChannel modelElement = (GetAvailableChannel) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getCongestion_1060IncomingLinks(View view) {
    Congestion modelElement = (Congestion) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getRinging_1061IncomingLinks(View view) {
    Ringing modelElement = (Ringing) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetCallerPresentation_1062IncomingLinks(View view) {
    SetCallerPresentation modelElement = (SetCallerPresentation) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetGlobalVariable_1063IncomingLinks(View view) {
    SetGlobalVariable modelElement = (SetGlobalVariable) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getEcho_1064IncomingLinks(View view) {
    Echo modelElement = (Echo) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getFestival_1065IncomingLinks(View view) {
    Festival modelElement = (Festival) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getPlaytones_1066IncomingLinks(View view) {
    Playtones modelElement = (Playtones) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getStopPlaytones_1067IncomingLinks(View view) {
    StopPlaytones modelElement = (StopPlaytones) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getChanSpy_1068IncomingLinks(View view) {
    ChanSpy modelElement = (ChanSpy) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getDictate_1069IncomingLinks(View view) {
    Dictate modelElement = (Dictate) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getExtensionSpy_1070IncomingLinks(View view) {
    ExtensionSpy modelElement = (ExtensionSpy) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getMixMonitor_1071IncomingLinks(View view) {
    MixMonitor modelElement = (MixMonitor) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getStopMixmonitor_1072IncomingLinks(View view) {
    StopMixmonitor modelElement = (StopMixmonitor) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getStopMonitor_1073IncomingLinks(View view) {
    StopMonitor modelElement = (StopMonitor) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getMonitor_1074IncomingLinks(View view) {
    Monitor modelElement = (Monitor) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getDirectory_1075IncomingLinks(View view) {
    Directory modelElement = (Directory) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getTransfer_1076IncomingLinks(View view) {
    Transfer modelElement = (Transfer) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getOpenDBConnection_1077IncomingLinks(View view) {
    OpenDBConnection modelElement = (OpenDBConnection) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getCloseDBConnection_1078IncomingLinks(View view) {
    CloseDBConnection modelElement = (CloseDBConnection) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getOpenQuery_1079IncomingLinks(View view) {
    OpenQuery modelElement = (OpenQuery) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetQueryParam_1080IncomingLinks(View view) {
    SetQueryParam modelElement = (SetQueryParam) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getExecuteUpdate_1081IncomingLinks(View view) {
    ExecuteUpdate modelElement = (ExecuteUpdate) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getExecuteQuery_1082IncomingLinks(View view) {
    ExecuteQuery modelElement = (ExecuteQuery) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getNextRow_1083IncomingLinks(View view) {
    NextRow modelElement = (NextRow) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getGetColValue_1084IncomingLinks(View view) {
    GetColValue modelElement = (GetColValue) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetColValue_1085IncomingLinks(View view) {
    SetColValue modelElement = (SetColValue) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getUpdatetRow_1086IncomingLinks(View view) {
    UpdatetRow modelElement = (UpdatetRow) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getMoveToRow_1087IncomingLinks(View view) {
    MoveToRow modelElement = (MoveToRow) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getMoveToLastRow_1088IncomingLinks(View view) {
    MoveToLastRow modelElement = (MoveToLastRow) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getDeleteRow_1089IncomingLinks(View view) {
    DeleteRow modelElement = (DeleteRow) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getMoveToInsertRow_1090IncomingLinks(View view) {
    MoveToInsertRow modelElement = (MoveToInsertRow) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getInsertRow_1091IncomingLinks(View view) {
    InsertRow modelElement = (InsertRow) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getMoveToFirstRow_1092IncomingLinks(View view) {
    MoveToFirstRow modelElement = (MoveToFirstRow) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getPreviousRow_1093IncomingLinks(View view) {
    PreviousRow modelElement = (PreviousRow) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getGetColValues_1094IncomingLinks(View view) {
    GetColValues modelElement = (GetColValues) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getSetColValues_1095IncomingLinks(View view) {
    SetColValues modelElement = (SetColValues) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getExtensionTransfer_1096IncomingLinks(View view) {
    ExtensionTransfer modelElement = (ExtensionTransfer) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getRunQuery_1097IncomingLinks(View view) {
    RunQuery modelElement = (RunQuery) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  public static List getDefaultActionstepIncomingLinks(View view) {
    ActionStep modelElement = (ActionStep) view.getElement();
    Map crossReferences = EcoreUtil.CrossReferencer.find(view.eResource().getResourceSet()
        .getResources());
    List result = new LinkedList();
    result.addAll(getIncomingFeatureModelFacetLinks_Output_Target_3001(modelElement,
        crossReferences));
    result.addAll(getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement,
        crossReferences));
    return result;
  }

  /**
   * @generated
   */
  public static List getOutput_2001IncomingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getCaseItem_2002IncomingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getAudioFileItem_2003IncomingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetColMapping_2004IncomingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetColMapping_2005IncomingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getQueryParamMapping_2006IncomingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getAnswer_1001OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getAssignment_1002OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getChoice_1003OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetFullVariable_1004OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMultiStreamAudio_1005OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getHangup_1006OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getIfThen_1007OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getRecordFile_1008OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayAlpha_1009OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayDateTime_1010OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayDigits_1011OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayNumber_1012OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayPhonetic_1013OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSayTime_1014OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetAutoHangup_1015OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetCallerId_1016OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetChannelVariable_1017OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetContext_1018OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetExtension_1019OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStopMusicOnHold_1020OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetMusicOn_1021OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetPriority_1022OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStreamAudio_1023OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getWaitForDigit_1024OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDIDMatcher_1025OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetDigits_1026OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getOriginateCall_1027OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPlayDTMF_1028OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getRecordCall_1029OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExecuteApplication_1030OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPlayMusicOnHold_1031OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPromptGetDigits_1032OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSleep_1033OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStreamAudioExtended_1034OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getIncomingCall_1035OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetCallInfo_1036OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExecuteScript_1037OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getInvokeSaflet_1038OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDial_1039OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPickup_1040OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getBackground_1041OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getBackgroundDetect_1042OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getWaitExten_1043OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSoftHangup_1044OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPickupChan_1045OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPickdown_1046OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getProgress_1047OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getBridge_1048OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPlaceCall_1049OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getVoicemail_1050OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getVoicemailMain_1051OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getVMAuthenticate_1052OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMeetMe_1053OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMeetMeAdmin_1054OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMeetMeCount_1055OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDebugLog_1056OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getWaitForRing_1057OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getWaitMusicOnHold_1058OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetAvailableChannel_1059OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getCongestion_1060OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getRinging_1061OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetCallerPresentation_1062OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetGlobalVariable_1063OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getEcho_1064OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getFestival_1065OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPlaytones_1066OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStopPlaytones_1067OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getChanSpy_1068OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDictate_1069OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExtensionSpy_1070OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMixMonitor_1071OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStopMixmonitor_1072OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getStopMonitor_1073OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMonitor_1074OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDirectory_1075OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getTransfer_1076OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getOpenDBConnection_1077OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getCloseDBConnection_1078OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getOpenQuery_1079OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetQueryParam_1080OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExecuteUpdate_1081OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExecuteQuery_1082OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getNextRow_1083OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetColValue_1084OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetColValue_1085OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getUpdatetRow_1086OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMoveToRow_1087OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMoveToLastRow_1088OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getDeleteRow_1089OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMoveToInsertRow_1090OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getInsertRow_1091OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getMoveToFirstRow_1092OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getPreviousRow_1093OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getGetColValues_1094OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetColValues_1095OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getExtensionTransfer_1096OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getRunQuery_1097OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getOutput_2001OutgoingLinks(View view) {
    Output modelElement = (Output) view.getElement();
    List result = new LinkedList();
    result.addAll(getOutgoingFeatureModelFacetLinks_Output_Target_3001(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List getCaseItem_2002OutgoingLinks(View view) {
    CaseItem modelElement = (CaseItem) view.getElement();
    List result = new LinkedList();
    result.addAll(getOutgoingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List getAudioFileItem_2003OutgoingLinks(View view) {
    AudioFileItem modelElement = (AudioFileItem) view.getElement();
    List result = new LinkedList();
    result.addAll(getOutgoingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement));
    return result;
  }

  /**
   * @generated
   */
  public static List getGetColMapping_2004OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getSetColMapping_2005OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  public static List getQueryParamMapping_2006OutgoingLinks(View view) {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  private static Collection getIncomingFeatureModelFacetLinks_Output_Target_3001(ActionStep target,
      Map crossReferences) {
    Collection result = new LinkedList();
    Collection settings = (Collection) crossReferences.get(target);
    for (Iterator it = settings.iterator(); it.hasNext();) {
      EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
      if (setting.getEStructuralFeature() == ActionStepPackage.eINSTANCE.getOutput_Target()) {
        result.add(new AsteriskLinkDescriptor(setting.getEObject(), target,
            AsteriskElementTypes.OutputTarget_3001, OutputTargetEditPart.VISUAL_ID));
      }
    }
    return result;
  }

  /**
   * @generated
   */
  // private static Collection
  // getIncomingFeatureModelFacetLinks_Initiator_NextToolstep_3002(
  // ActionStep target, Map crossReferences) {
  // Collection result = new LinkedList();
  // Collection settings = (Collection) crossReferences.get(target);
  // for (Iterator it = settings.iterator(); it.hasNext();) {
  // EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
  // if (setting.getEStructuralFeature() ==
  // InitiatorPackage.eINSTANCE.getInitiator_NextToolstep()) {
  // result.add(new AsteriskLinkDescriptor(setting.getEObject(), target,
  // AsteriskElementTypes.InitiatorNextToolstep_3002,
  // InitiatorNextToolstepEditPart.VISUAL_ID));
  // }
  // }
  // return result;
  // }
  /**
   * @generated
   */
  private static Collection getIncomingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(
      ActionStep target, Map crossReferences) {
    Collection result = new LinkedList();
    Collection settings = (Collection) crossReferences.get(target);
    for (Iterator it = settings.iterator(); it.hasNext();) {
      EStructuralFeature.Setting setting = (EStructuralFeature.Setting) it.next();
      if (setting.getEStructuralFeature() == ActionStepPackage.eINSTANCE.getItem_TargetActionStep()) {
        result.add(new AsteriskLinkDescriptor(setting.getEObject(), target,
            AsteriskElementTypes.CaseItemTargetToolstep_3003,
            CaseItemTargetToolstepEditPart.VISUAL_ID));
      }
    }
    return result;
  }

  /**
   * @generated
   */
  private static Collection getOutgoingFeatureModelFacetLinks_Output_Target_3001(Output source) {
    Collection result = new LinkedList();
    ActionStep destination = source.getTarget();
    if (destination == null) {
      return result;
    }
    result.add(new AsteriskLinkDescriptor(source, destination,
        AsteriskElementTypes.OutputTarget_3001, OutputTargetEditPart.VISUAL_ID));
    return result;
  }

  /**
   * @generated
   */
  private static Collection getOutgoingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(
      CaseItem source) {
    Collection result = new LinkedList();
    ActionStep destination = source.getTargetActionStep();
    if (destination == null) {
      return result;
    }
    result
        .add(new AsteriskLinkDescriptor(source, destination,
            AsteriskElementTypes.CaseItemTargetToolstep_3003,
            CaseItemTargetToolstepEditPart.VISUAL_ID));
    return result;
  }

}
