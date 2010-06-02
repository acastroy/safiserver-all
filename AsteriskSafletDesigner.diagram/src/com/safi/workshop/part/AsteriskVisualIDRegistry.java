package com.safi.workshop.part;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.saflet.Saflet;
import com.safi.core.saflet.SafletPackage;
import com.safi.workshop.edit.parts.*;

/**
 * This registry is used to determine which type of visual object should be created for
 * the corresponding Diagram, Node, ChildNode or Link represented by a domain model
 * object.
 * 
 * @generated
 */
public class AsteriskVisualIDRegistry {

  /**
   * @generated
   */
  private static final String DEBUG_KEY = AsteriskDiagramEditorPlugin.getInstance().getBundle()
      .getSymbolicName()
      + "/debug/visualID"; //$NON-NLS-1$

  private static Map<EObject, Integer> eobjectToVisualID = new HashMap<EObject, Integer>();

  /**
   * @generated
   */
  public static int getVisualID(View view) {
    if (view instanceof Diagram) {
      if (HandlerEditPart.MODEL_ID.equals(view.getType())) {
        return HandlerEditPart.VISUAL_ID;
      } else {
        return -1;
      }
    }
    return com.safi.workshop.part.AsteriskVisualIDRegistry.getVisualID(view.getType());
  }

  /**
   * @generated
   */
  public static String getModelID(View view) {
    View diagram = view.getDiagram();
    while (view != diagram) {
      EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
      if (annotation != null) {
        return annotation.getDetails().get("modelID"); //$NON-NLS-1$
      }
      view = (View) view.eContainer();
    }
    return diagram != null ? diagram.getType() : null;
  }

  /**
   * @generated
   */
  public static int getVisualID(String type) {
    try {
      return Integer.parseInt(type);
    } catch (NumberFormatException e) {
      if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
        AsteriskDiagramEditorPlugin.getInstance().logError(
            "Unable to parse view type as a visualID number: " + type);
      }
    }
    return -1;
  }

  /**
   * @generated
   */
  public static String getType(int visualID) {
    return String.valueOf(visualID);
  }

  /**
   * @generated
   */
  public static int getDiagramVisualID(EObject domainElement) {
    if (domainElement == null) {
      return -1;
    }
    if (SafletPackage.eINSTANCE.getSaflet().isSuperTypeOf(domainElement.eClass())
        && isDiagram((Saflet) domainElement)) {
      return HandlerEditPart.VISUAL_ID;
    }
    return -1;
  }

  public static void registerVisualId(EClass clz, int id) {
    eobjectToVisualID.put(clz, id);
  }

  /**
   * @generated NOT
   */
  public static int getNodeVisualID(View containerView, EObject domainElement) {
    if (domainElement == null) {
      return -1;
    }
    Integer id = eobjectToVisualID.get(domainElement.eClass());
    if (id != null)
      return id;

    String containerModelID = com.safi.workshop.part.AsteriskVisualIDRegistry
        .getModelID(containerView);
    if (!HandlerEditPart.MODEL_ID.equals(containerModelID)) {
      return -1;
    }
    int containerVisualID;
    if (HandlerEditPart.MODEL_ID.equals(containerModelID)) {
      containerVisualID = com.safi.workshop.part.AsteriskVisualIDRegistry
          .getVisualID(containerView);
    } else {
      if (containerView instanceof Diagram) {
        containerVisualID = HandlerEditPart.VISUAL_ID;
      } else {
        return -1;
      }
    }
    switch (containerVisualID) {
      case AnswerEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case AssignmentEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case ChoiceEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case GetFullVariableEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case MultiStreamAudioEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case HangupEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case IfThenEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case RecordFileEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SayAlphaEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SayDateTimeEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SayDigitsEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SayNumberEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SayPhoneticEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SayTimeEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetAutoHangupEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetCallerIdEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetChannelVariableEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetContextEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetExtensionEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case StopMusicOnHoldEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetMusicOnEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetPriorityEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case StreamAudioEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case WaitForDigitEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case GetDigitsEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case OriginateCallEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case PlayDTMFEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case RecordCallEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case ExecuteApplicationEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case PlayMusicOnHoldEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case PromptGetDigitsEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SleepEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case StreamAudioExtendedEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case GetCallInfoEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case ExecuteScriptEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case InvokeSafletEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case DialEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case PickupEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case BackgroundEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case BackgroundDetectEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case WaitExtenEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SoftHangupEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case PickupChanEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case PickdownEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case ProgressEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case BridgeEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case PlaceCallEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case VoicemailEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case VoicemailMainEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case VMAuthenticateEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case MeetMeEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case MeetMeAdminEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case MeetMeCountEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case DebugLogEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case WaitForRingEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case WaitMusicOnHoldEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case GetAvailableChannelEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case CongestionEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case RingingEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetCallerPresentationEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetGlobalVariableEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case EchoEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case FestivalEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case PlaytonesEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case StopPlaytonesEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case ChanSpyEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case DictateEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case ExtensionSpyEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case MixMonitorEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case StopMixmonitorEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case StopMonitorEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case MonitorEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case DirectoryEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case TransferEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case OpenDBConnectionEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case CloseDBConnectionEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case OpenQueryEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetQueryParamEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case ExecuteUpdateEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case ExecuteQueryEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case NextRowEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case GetColValueEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetColValueEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case UpdatetRowEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case MoveToRowEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case MoveToLastRowEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case DeleteRowEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case MoveToInsertRowEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case InsertRowEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case MoveToFirstRowEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case PreviousRowEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case GetColValuesEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case SetColValuesEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case ExtensionTransferEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case RunQueryEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case ChoiceItemPanelEditPart.VISUAL_ID:
        if (ActionStepPackage.eINSTANCE.getCaseItem().isSuperTypeOf(domainElement.eClass())) {
          return CaseItemEditPart.VISUAL_ID;
        }
        break;
      case MultiStreamAudioFilesPanelEditPart.VISUAL_ID:
        if (ActionStepPackage.eINSTANCE.getAudioFileItem().isSuperTypeOf(domainElement.eClass())) {
          return AudioFileItemEditPart.VISUAL_ID;
        }
        break;
      case GetColValuesValuesPanelEditPart.VISUAL_ID:
        if (ActionStepPackage.eINSTANCE.getGetColMapping().isSuperTypeOf(domainElement.eClass())) {
          return GetColMappingEditPart.VISUAL_ID;
        }
        break;
      case SetColValuesValuesPanelEditPart.VISUAL_ID:
        if (ActionStepPackage.eINSTANCE.getSetColMapping().isSuperTypeOf(domainElement.eClass())) {
          return SetColMappingEditPart.VISUAL_ID;
        }
        break;
      case RunQueryRunQueryValuesPanelEditPart.VISUAL_ID:
        if (ActionStepPackage.eINSTANCE.getQueryParamMapping()
            .isSuperTypeOf(domainElement.eClass())) {
          return QueryParamMappingEditPart.VISUAL_ID;
        }
        break;
      case IncomingCallEditPart.VISUAL_ID:
        if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
            domainElement.eClass())) {
          return OutputEditPart.VISUAL_ID;
        }
        break;
      case HandlerEditPart.VISUAL_ID:
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getAnswer().isSuperTypeOf(
            domainElement.eClass())) {
          return AnswerEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getAssignment().isSuperTypeOf(domainElement.eClass())) {
          return AssignmentEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getChoice().isSuperTypeOf(domainElement.eClass())) {
          return ChoiceEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getGetFullVariable()
            .isSuperTypeOf(domainElement.eClass())) {
          return GetFullVariableEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getMultiStreamAudio()
            .isSuperTypeOf(domainElement.eClass())) {
          return MultiStreamAudioEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getHangup().isSuperTypeOf(
            domainElement.eClass())) {
          return HangupEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getIfThen().isSuperTypeOf(domainElement.eClass())) {
          return IfThenEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getRecordFile().isSuperTypeOf(
            domainElement.eClass())) {
          return RecordFileEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSayAlpha().isSuperTypeOf(
            domainElement.eClass())) {
          return SayAlphaEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSayDateTime()
            .isSuperTypeOf(domainElement.eClass())) {
          return SayDateTimeEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSayDigits().isSuperTypeOf(
            domainElement.eClass())) {
          return SayDigitsEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSayNumber().isSuperTypeOf(
            domainElement.eClass())) {
          return SayNumberEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSayPhonetic()
            .isSuperTypeOf(domainElement.eClass())) {
          return SayPhoneticEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSayTime().isSuperTypeOf(
            domainElement.eClass())) {
          return SayTimeEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSetAutoHangup()
            .isSuperTypeOf(domainElement.eClass())) {
          return SetAutoHangupEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSetCallerId()
            .isSuperTypeOf(domainElement.eClass())) {
          return SetCallerIdEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSetChannelVariable()
            .isSuperTypeOf(domainElement.eClass())) {
          return SetChannelVariableEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSetContext().isSuperTypeOf(
            domainElement.eClass())) {
          return SetContextEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSetExtension()
            .isSuperTypeOf(domainElement.eClass())) {
          return SetExtensionEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getStopMusicOnHold()
            .isSuperTypeOf(domainElement.eClass())) {
          return StopMusicOnHoldEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSetMusicOn().isSuperTypeOf(
            domainElement.eClass())) {
          return SetMusicOnEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSetPriority()
            .isSuperTypeOf(domainElement.eClass())) {
          return SetPriorityEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getStreamAudio()
            .isSuperTypeOf(domainElement.eClass())) {
          return StreamAudioEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getWaitForDigit()
            .isSuperTypeOf(domainElement.eClass())) {
          return WaitForDigitEditPart.VISUAL_ID;
        }
        if (InitiatorPackage.eINSTANCE.getDIDMatcher().isSuperTypeOf(domainElement.eClass())) {
          return DIDMatcherEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getGetDigits().isSuperTypeOf(
            domainElement.eClass())) {
          return GetDigitsEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getOriginateCall()
            .isSuperTypeOf(domainElement.eClass())) {
          return OriginateCallEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getPlayDTMF().isSuperTypeOf(
            domainElement.eClass())) {
          return PlayDTMFEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getRecordCall().isSuperTypeOf(
            domainElement.eClass())) {
          return RecordCallEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getExecuteApplication()
            .isSuperTypeOf(domainElement.eClass())) {
          return ExecuteApplicationEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getPlayMusicOnHold()
            .isSuperTypeOf(domainElement.eClass())) {
          return PlayMusicOnHoldEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getPromptGetDigits()
            .isSuperTypeOf(domainElement.eClass())) {
          return PromptGetDigitsEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSleep().isSuperTypeOf(
            domainElement.eClass())) {
          return SleepEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getStreamAudioExtended()
            .isSuperTypeOf(domainElement.eClass())) {
          return StreamAudioExtendedEditPart.VISUAL_ID;
        }
        if (InitiatorPackage.eINSTANCE.getIncomingCall().isSuperTypeOf(domainElement.eClass())) {
          return IncomingCallEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getGetCallInfo()
            .isSuperTypeOf(domainElement.eClass())) {
          return GetCallInfoEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getExecuteScript().isSuperTypeOf(domainElement.eClass())) {
          return ExecuteScriptEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getInvokeSaflet().isSuperTypeOf(domainElement.eClass())) {
          return InvokeSafletEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getDial().isSuperTypeOf(
            domainElement.eClass())) {
          return DialEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getPickup().isSuperTypeOf(
            domainElement.eClass())) {
          return PickupEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getBackground().isSuperTypeOf(
            domainElement.eClass())) {
          return BackgroundEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getBackgroundDetect()
            .isSuperTypeOf(domainElement.eClass())) {
          return BackgroundDetectEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getWaitExten().isSuperTypeOf(
            domainElement.eClass())) {
          return WaitExtenEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSoftHangup().isSuperTypeOf(
            domainElement.eClass())) {
          return SoftHangupEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getPickupChan().isSuperTypeOf(
            domainElement.eClass())) {
          return PickupChanEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getPickdown().isSuperTypeOf(
            domainElement.eClass())) {
          return PickdownEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getProgress().isSuperTypeOf(
            domainElement.eClass())) {
          return ProgressEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getBridge().isSuperTypeOf(
            domainElement.eClass())) {
          return BridgeEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getPlaceCall().isSuperTypeOf(
            domainElement.eClass())) {
          return PlaceCallEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getVoicemail().isSuperTypeOf(
            domainElement.eClass())) {
          return VoicemailEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getVoicemailMain()
            .isSuperTypeOf(domainElement.eClass())) {
          return VoicemailMainEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getVMAuthenticate()
            .isSuperTypeOf(domainElement.eClass())) {
          return VMAuthenticateEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getMeetMe().isSuperTypeOf(
            domainElement.eClass())) {
          return MeetMeEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getMeetMeAdmin()
            .isSuperTypeOf(domainElement.eClass())) {
          return MeetMeAdminEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getMeetMeCount()
            .isSuperTypeOf(domainElement.eClass())) {
          return MeetMeCountEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getDebugLog().isSuperTypeOf(domainElement.eClass())) {
          return DebugLogEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getWaitForRing()
            .isSuperTypeOf(domainElement.eClass())) {
          return WaitForRingEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getWaitMusicOnHold()
            .isSuperTypeOf(domainElement.eClass())) {
          return WaitMusicOnHoldEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getGetAvailableChannel()
            .isSuperTypeOf(domainElement.eClass())) {
          return GetAvailableChannelEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getCongestion().isSuperTypeOf(
            domainElement.eClass())) {
          return CongestionEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getRinging().isSuperTypeOf(
            domainElement.eClass())) {
          return RingingEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSetCallerPresentation()
            .isSuperTypeOf(domainElement.eClass())) {
          return SetCallerPresentationEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getSetGlobalVariable()
            .isSuperTypeOf(domainElement.eClass())) {
          return SetGlobalVariableEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getEcho().isSuperTypeOf(
            domainElement.eClass())) {
          return EchoEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getFestival().isSuperTypeOf(
            domainElement.eClass())) {
          return FestivalEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getPlaytones().isSuperTypeOf(
            domainElement.eClass())) {
          return PlaytonesEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getStopPlaytones()
            .isSuperTypeOf(domainElement.eClass())) {
          return StopPlaytonesEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getChanSpy().isSuperTypeOf(
            domainElement.eClass())) {
          return ChanSpyEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getDictate().isSuperTypeOf(
            domainElement.eClass())) {
          return DictateEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getExtensionSpy()
            .isSuperTypeOf(domainElement.eClass())) {
          return ExtensionSpyEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getMixMonitor().isSuperTypeOf(
            domainElement.eClass())) {
          return MixMonitorEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getStopMixmonitor()
            .isSuperTypeOf(domainElement.eClass())) {
          return StopMixmonitorEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getStopMonitor()
            .isSuperTypeOf(domainElement.eClass())) {
          return StopMonitorEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getMonitor().isSuperTypeOf(
            domainElement.eClass())) {
          return MonitorEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getDirectory().isSuperTypeOf(
            domainElement.eClass())) {
          return DirectoryEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getTransfer().isSuperTypeOf(
            domainElement.eClass())) {
          return TransferEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getOpenDBConnection().isSuperTypeOf(domainElement.eClass())) {
          return OpenDBConnectionEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getCloseDBConnection()
            .isSuperTypeOf(domainElement.eClass())) {
          return CloseDBConnectionEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getOpenQuery().isSuperTypeOf(domainElement.eClass())) {
          return OpenQueryEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getSetQueryParam().isSuperTypeOf(domainElement.eClass())) {
          return SetQueryParamEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getExecuteUpdate().isSuperTypeOf(domainElement.eClass())) {
          return ExecuteUpdateEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getExecuteQuery().isSuperTypeOf(domainElement.eClass())) {
          return ExecuteQueryEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getNextRow().isSuperTypeOf(domainElement.eClass())) {
          return NextRowEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getGetColValue().isSuperTypeOf(domainElement.eClass())) {
          return GetColValueEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getSetColValue().isSuperTypeOf(domainElement.eClass())) {
          return SetColValueEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getUpdatetRow().isSuperTypeOf(domainElement.eClass())) {
          return UpdatetRowEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getMoveToRow().isSuperTypeOf(domainElement.eClass())) {
          return MoveToRowEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getMoveToLastRow().isSuperTypeOf(domainElement.eClass())) {
          return MoveToLastRowEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getDeleteRow().isSuperTypeOf(domainElement.eClass())) {
          return DeleteRowEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getMoveToInsertRow().isSuperTypeOf(domainElement.eClass())) {
          return MoveToInsertRowEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getInsertRow().isSuperTypeOf(domainElement.eClass())) {
          return InsertRowEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getMoveToFirstRow().isSuperTypeOf(domainElement.eClass())) {
          return MoveToFirstRowEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getPreviousRow().isSuperTypeOf(domainElement.eClass())) {
          return PreviousRowEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getGetColValues().isSuperTypeOf(domainElement.eClass())) {
          return GetColValuesEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getSetColValues().isSuperTypeOf(domainElement.eClass())) {
          return SetColValuesEditPart.VISUAL_ID;
        }
        if (com.safi.asterisk.actionstep.ActionstepPackage.eINSTANCE.getExtensionTransfer()
            .isSuperTypeOf(domainElement.eClass())) {
          return ExtensionTransferEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getRunQuery().isSuperTypeOf(domainElement.eClass())) {
          return RunQueryEditPart.VISUAL_ID;
        }
        if (InitiatorPackage.eINSTANCE.getIncomingCall().isSuperTypeOf(domainElement.eClass())) {
          return IncomingCallEditPart.VISUAL_ID;
        }
        break;
      default: {
        for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
            .getInstance().getActionstepProfiles()) {
          if (p.semanticHint.equals(String.valueOf(containerVisualID))) {
            if (com.safi.core.actionstep.ActionStepPackage.eINSTANCE.getOutput().isSuperTypeOf(
                domainElement.eClass())) {
              return OutputEditPart.VISUAL_ID;
            }
            break;
          }

        }
      }
    }
    return -1;
  }

  /**
   * @generated NOT
   */
  public static boolean canCreateNode(View containerView, int nodeVisualID) {
    String containerModelID = com.safi.workshop.part.AsteriskVisualIDRegistry
        .getModelID(containerView);
    if (!HandlerEditPart.MODEL_ID.equals(containerModelID)) {
      return false;
    }
    int containerVisualID;
    if (HandlerEditPart.MODEL_ID.equals(containerModelID)) {
      containerVisualID = com.safi.workshop.part.AsteriskVisualIDRegistry
          .getVisualID(containerView);
    } else {
      if (containerView instanceof Diagram) {
        containerVisualID = HandlerEditPart.VISUAL_ID;
      } else {
        return false;
      }
    }
    switch (containerVisualID) {
      case AnswerEditPart.VISUAL_ID:
        if (AnswerNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case AssignmentEditPart.VISUAL_ID:
        if (AssignmentNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case ChoiceEditPart.VISUAL_ID:
        if (ChoiceNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ChoiceItemPanelEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case GetFullVariableEditPart.VISUAL_ID:
        if (GetFullVariableNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case MultiStreamAudioEditPart.VISUAL_ID:
        if (MultiStreamAudioNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (MultiStreamAudioFilesPanelEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case HangupEditPart.VISUAL_ID:
        if (HangupNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case IfThenEditPart.VISUAL_ID:
        if (IfThenNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case RecordFileEditPart.VISUAL_ID:
        if (RecordFileNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SayAlphaEditPart.VISUAL_ID:
        if (SayAlphaNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SayDateTimeEditPart.VISUAL_ID:
        if (SayDateTimeNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SayDigitsEditPart.VISUAL_ID:
        if (SayDigitsNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SayNumberEditPart.VISUAL_ID:
        if (SayNumberNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SayPhoneticEditPart.VISUAL_ID:
        if (SayPhoneticNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SayTimeEditPart.VISUAL_ID:
        if (SayTimeNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetAutoHangupEditPart.VISUAL_ID:
        if (SetAutoHangupNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetCallerIdEditPart.VISUAL_ID:
        if (SetCallerIdNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetChannelVariableEditPart.VISUAL_ID:
        if (SetChannelVariableNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetContextEditPart.VISUAL_ID:
        if (SetContextNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetExtensionEditPart.VISUAL_ID:
        if (SetExtensionNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case StopMusicOnHoldEditPart.VISUAL_ID:
        if (StopMusicOnHoldNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetMusicOnEditPart.VISUAL_ID:
        if (SetMusicOnNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetPriorityEditPart.VISUAL_ID:
        if (SetPriorityNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case StreamAudioEditPart.VISUAL_ID:
        if (StreamAudioNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case WaitForDigitEditPart.VISUAL_ID:
        if (WaitForDigitNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case DIDMatcherEditPart.VISUAL_ID:
        if (DIDMatcherNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case GetDigitsEditPart.VISUAL_ID:
        if (GetDigitsNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case OriginateCallEditPart.VISUAL_ID:
        if (OriginateCallNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case PlayDTMFEditPart.VISUAL_ID:
        if (PlayDTMFNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case RecordCallEditPart.VISUAL_ID:
        if (RecordCallNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case ExecuteApplicationEditPart.VISUAL_ID:
        if (ExecuteApplicationNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case PlayMusicOnHoldEditPart.VISUAL_ID:
        if (PlayMusicOnHoldNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case PromptGetDigitsEditPart.VISUAL_ID:
        if (PromptGetDigitsNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SleepEditPart.VISUAL_ID:
        if (SleepNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case StreamAudioExtendedEditPart.VISUAL_ID:
        if (StreamAudioExtendedNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case IncomingCallEditPart.VISUAL_ID:
        if (IncomingCallNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case GetCallInfoEditPart.VISUAL_ID:
        if (GetCallInfoNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case ExecuteScriptEditPart.VISUAL_ID:
        if (ExecuteScriptNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case InvokeSafletEditPart.VISUAL_ID:
        if (InvokeSafletNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (InvokeSafletLabelTextEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case DialEditPart.VISUAL_ID:
        if (DialNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case PickupEditPart.VISUAL_ID:
        if (PickupNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case BackgroundEditPart.VISUAL_ID:
        if (BackgroundNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case BackgroundDetectEditPart.VISUAL_ID:
        if (BackgroundDetectNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case WaitExtenEditPart.VISUAL_ID:
        if (WaitExtenNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SoftHangupEditPart.VISUAL_ID:
        if (SoftHangupNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case PickupChanEditPart.VISUAL_ID:
        if (PickupChanNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case PickdownEditPart.VISUAL_ID:
        if (PickdownNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case ProgressEditPart.VISUAL_ID:
        if (ProgressNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case BridgeEditPart.VISUAL_ID:
        if (BridgeNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case PlaceCallEditPart.VISUAL_ID:
        if (PlaceCallNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case VoicemailEditPart.VISUAL_ID:
        if (VoicemailNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case VoicemailMainEditPart.VISUAL_ID:
        if (VoicemailMainNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case VMAuthenticateEditPart.VISUAL_ID:
        if (VMAuthenticateNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case MeetMeEditPart.VISUAL_ID:
        if (MeetMeNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case MeetMeAdminEditPart.VISUAL_ID:
        if (MeetMeAdminNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case MeetMeCountEditPart.VISUAL_ID:
        if (MeetMeCountNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case DebugLogEditPart.VISUAL_ID:
        if (DebugLogNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case WaitForRingEditPart.VISUAL_ID:
        if (WaitForRingNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case WaitMusicOnHoldEditPart.VISUAL_ID:
        if (WaitMusicOnHoldNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case GetAvailableChannelEditPart.VISUAL_ID:
        if (GetAvailableChannelNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case CongestionEditPart.VISUAL_ID:
        if (CongestionNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case RingingEditPart.VISUAL_ID:
        if (RingingNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetCallerPresentationEditPart.VISUAL_ID:
        if (SetCallerPresentationNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetGlobalVariableEditPart.VISUAL_ID:
        if (SetGlobalVariableNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case EchoEditPart.VISUAL_ID:
        if (EchoNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case FestivalEditPart.VISUAL_ID:
        if (FestivalNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case PlaytonesEditPart.VISUAL_ID:
        if (PlaytonesNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case StopPlaytonesEditPart.VISUAL_ID:
        if (StopPlaytonesNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case ChanSpyEditPart.VISUAL_ID:
        if (ChanSpyNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case DictateEditPart.VISUAL_ID:
        if (DictateNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case ExtensionSpyEditPart.VISUAL_ID:
        if (ExtensionSpyNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case MixMonitorEditPart.VISUAL_ID:
        if (MixMonitorNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case StopMixmonitorEditPart.VISUAL_ID:
        if (StopMixmonitorNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case StopMonitorEditPart.VISUAL_ID:
        if (StopMonitorNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case MonitorEditPart.VISUAL_ID:
        if (MonitorNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case DirectoryEditPart.VISUAL_ID:
        if (DirectoryNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case TransferEditPart.VISUAL_ID:
        if (TransferNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case OpenDBConnectionEditPart.VISUAL_ID:
        if (OpenDBConnectionNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case CloseDBConnectionEditPart.VISUAL_ID:
        if (CloseDBConnectionNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case OpenQueryEditPart.VISUAL_ID:
        if (OpenQueryNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetQueryParamEditPart.VISUAL_ID:
        if (SetQueryParamNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case ExecuteUpdateEditPart.VISUAL_ID:
        if (ExecuteUpdateNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case ExecuteQueryEditPart.VISUAL_ID:
        if (ExecuteQueryNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case NextRowEditPart.VISUAL_ID:
        if (NextRowNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case GetColValueEditPart.VISUAL_ID:
        if (GetColValueNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetColValueEditPart.VISUAL_ID:
        if (SetColValueNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case UpdatetRowEditPart.VISUAL_ID:
        if (UpdatetRowNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case MoveToRowEditPart.VISUAL_ID:
        if (MoveToRowNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case MoveToLastRowEditPart.VISUAL_ID:
        if (MoveToLastRowNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case DeleteRowEditPart.VISUAL_ID:
        if (DeleteRowNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case MoveToInsertRowEditPart.VISUAL_ID:
        if (MoveToInsertRowNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case InsertRowEditPart.VISUAL_ID:
        if (InsertRowNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case MoveToFirstRowEditPart.VISUAL_ID:
        if (MoveToFirstRowNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case PreviousRowEditPart.VISUAL_ID:
        if (PreviousRowNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case GetColValuesEditPart.VISUAL_ID:
        if (GetColValuesNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (GetColValuesValuesPanelEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetColValuesEditPart.VISUAL_ID:
        if (SetColValuesNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetColValuesValuesPanelEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case ExtensionTransferEditPart.VISUAL_ID:
        if (ExtensionTransferNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case RunQueryEditPart.VISUAL_ID:
        if (RunQueryNameEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (RunQueryRunQueryValuesPanelEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OutputEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case CaseItemEditPart.VISUAL_ID:
        if (CaseItemLabelTextEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case AudioFileItemEditPart.VISUAL_ID:
        if (AudioFileItemLabelTextEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case GetColMappingEditPart.VISUAL_ID:
        if (GetColMappingGetAsDatatypeEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetColMappingEditPart.VISUAL_ID:
        if (SetColMappingSetAsDatatypeEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case QueryParamMappingEditPart.VISUAL_ID:
        if (WrapLabelEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case ChoiceItemPanelEditPart.VISUAL_ID:
        if (CaseItemEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case MultiStreamAudioFilesPanelEditPart.VISUAL_ID:
        if (AudioFileItemEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case GetColValuesValuesPanelEditPart.VISUAL_ID:
        if (GetColMappingEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case SetColValuesValuesPanelEditPart.VISUAL_ID:
        if (SetColMappingEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case RunQueryRunQueryValuesPanelEditPart.VISUAL_ID:
        if (QueryParamMappingEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        break;
      case HandlerEditPart.VISUAL_ID:
        if (AnswerEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (AssignmentEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ChoiceEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (GetFullVariableEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (MultiStreamAudioEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (HangupEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (IfThenEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (RecordFileEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SayAlphaEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SayDateTimeEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SayDigitsEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SayNumberEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SayPhoneticEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SayTimeEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetAutoHangupEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetCallerIdEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetChannelVariableEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetContextEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetExtensionEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (StopMusicOnHoldEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetMusicOnEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetPriorityEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (StreamAudioEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (WaitForDigitEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (DIDMatcherEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (GetDigitsEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OriginateCallEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (PlayDTMFEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (RecordCallEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ExecuteApplicationEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (PlayMusicOnHoldEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (PromptGetDigitsEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SleepEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (StreamAudioExtendedEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (IncomingCallEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (GetCallInfoEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ExecuteScriptEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (InvokeSafletEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (DialEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (PickupEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (BackgroundEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (BackgroundDetectEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (WaitExtenEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SoftHangupEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (PickupChanEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (PickdownEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ProgressEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (BridgeEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (PlaceCallEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (VoicemailEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (VoicemailMainEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (VMAuthenticateEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (MeetMeEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (MeetMeAdminEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (MeetMeCountEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (DebugLogEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (WaitForRingEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (WaitMusicOnHoldEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (GetAvailableChannelEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (CongestionEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (RingingEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetCallerPresentationEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetGlobalVariableEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (EchoEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (FestivalEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (PlaytonesEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (StopPlaytonesEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ChanSpyEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (DictateEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ExtensionSpyEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (MixMonitorEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (StopMixmonitorEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (StopMonitorEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (MonitorEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (DirectoryEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (TransferEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OpenDBConnectionEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (CloseDBConnectionEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (OpenQueryEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetQueryParamEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ExecuteUpdateEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ExecuteQueryEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (NextRowEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (GetColValueEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetColValueEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (UpdatetRowEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (MoveToRowEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (MoveToLastRowEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (DeleteRowEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (MoveToInsertRowEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (InsertRowEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (MoveToFirstRowEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (PreviousRowEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (GetColValuesEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (SetColValuesEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ExtensionTransferEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (RunQueryEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
            .getInstance().getActionstepProfiles()) {
          if (p.semanticHint.equals(String.valueOf(nodeVisualID)))
            return true;
        }
        break;
      default: {
        AsteriskDiagramEditorPlugin.ActionStepProfile profile = null;
        for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
            .getInstance().getActionstepProfiles()) {
          if (p.semanticHint.equals(String.valueOf(containerVisualID))) {
            profile = p;
            if (OutputEditPart.VISUAL_ID == nodeVisualID) {
              return true;
            }
            if (StringUtils.equals(profile.labelSemanticHint, String.valueOf(nodeVisualID)))
              return true;

            if (StringUtils
                .equals(profile.inputItemPanelSemanticHint, String.valueOf(nodeVisualID)))
              return true;

            if (StringUtils.equals(profile.outputItemPanelSemanticHint, String
                .valueOf(nodeVisualID)))
              return true;
            break;
          } else if (StringUtils.equals(p.inputItemPanelSemanticHint, String
              .valueOf(containerVisualID))) {
            profile = p;

            if (StringUtils.equals(profile.inputItemSemanticHint, String.valueOf(nodeVisualID)))
              return true;

            break;
          } else if (StringUtils.equals(p.inputItemSemanticHint, String.valueOf(containerVisualID))) {
            profile = p;

            if (StringUtils
                .equals(profile.inputItemLabelSemanticHint, String.valueOf(nodeVisualID)))
              return true;

            break;
          } else if (StringUtils.equals(p.outputItemPanelSemanticHint, String
              .valueOf(containerVisualID))) {
            profile = p;

            if (StringUtils.equals(profile.outputItemSemanticHint, String.valueOf(nodeVisualID)))
              return true;

            break;
          } else if (StringUtils
              .equals(p.outputItemSemanticHint, String.valueOf(containerVisualID))) {
            profile = p;

            if (StringUtils.equals(profile.outputItemLabelSemanticHint, String
                .valueOf(nodeVisualID)))
              return true;

            break;
          }
        }

      }
    }
    return false;
  }

  /**
   * @generated
   */
  public static int getLinkWithClassVisualID(EObject domainElement) {
    if (domainElement == null) {
      return -1;
    }
    return -1;
  }

  /**
   * User can change implementation of this method to handle some specific situations not
   * covered by default logic.
   * 
   * @generated
   */
  private static boolean isDiagram(Saflet element) {
    return true;
  }

  /**
   * @generated
   */
  private static class JavaConstraints {

  }

}
