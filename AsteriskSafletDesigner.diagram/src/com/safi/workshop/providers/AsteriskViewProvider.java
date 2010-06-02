package com.safi.workshop.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation;
import org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.edit.parts.*;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskVisualIDRegistry;
import com.safi.workshop.view.factories.*;

/**
 * @generated
 */
public class AsteriskViewProvider extends AbstractViewProvider {

  /**
   * @generated
   */
  @Override
  protected Class getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
    EObject semanticElement = getSemanticElement(semanticAdapter);
    if (HandlerEditPart.MODEL_ID.equals(diagramKind)
        && AsteriskVisualIDRegistry.getDiagramVisualID(semanticElement) != -1) {
      return HandlerViewFactory.class;
    }
    return null;
  }

  // public final Node createNode(IAdaptable semanticAdapter,
  // View containerView, String semanticHint, int index,
  // boolean persisted, PreferencesHint preferencesHint) {
  //
  // return (Node) createNewView(getNodeViewClass(semanticAdapter,
  // containerView, semanticHint), new Object[] {semanticAdapter,
  // containerView, semanticHint, new Integer(index),
  // Boolean.valueOf(persisted), preferencesHint});
  // }

  /**
   * @generated NOT
   */
  @Override
  protected Class getNodeViewClass(IAdaptable semanticAdapter, View containerView,
      String semanticHint) {
    if (containerView == null) {
      return null;
    }
    IElementType elementType = getSemanticElementType(semanticAdapter);
    EObject domainElement = getSemanticElement(semanticAdapter);
    int visualID;
    if (semanticHint == null) {
      // Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
      // In this situation there should be NO elementType, visualID will be determined
      // by VisualIDRegistry.getNodeVisualID() for domainElement.
      if (elementType != null || domainElement == null) {
        return null;
      }
      visualID = AsteriskVisualIDRegistry.getNodeVisualID(containerView, domainElement);
    } else {
      visualID = AsteriskVisualIDRegistry.getVisualID(semanticHint);
      if (elementType != null) {
        // Semantic hint is specified together with element type.
        // Both parameters should describe exactly the same diagram element.
        // In addition we check that visualID returned by
        // VisualIDRegistry.getNodeVisualID() for
        // domainElement (if specified) is the same as in element type.
        if (!AsteriskElementTypes.isKnownElementType(elementType)
            || (!(elementType instanceof IHintedType))) {
          return null; // foreign element type
        }
        String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
        if (!semanticHint.equals(elementTypeHint)) {
          return null; // if semantic hint is specified it should be the same as in
          // element type
        }
        if (domainElement != null
            && visualID != AsteriskVisualIDRegistry.getNodeVisualID(containerView, domainElement)) {
          return null; // visual id for node EClass should match visual id from element
          // type
        }
      } else {
        // Element type is not specified. Domain element should be present (except pure
        // design elements).
        // This method is called with EObjectAdapter as parameter from:
        // - ViewService.createNode(View container, EObject eObject, String type,
        // PreferencesHint preferencesHint)
        // - generated ViewFactory.decorateView() for parent element
        if (!HandlerEditPart.MODEL_ID.equals(AsteriskVisualIDRegistry.getModelID(containerView))) {
          return null; // foreign diagram
        }
        switch (visualID) {
          case AnswerEditPart.VISUAL_ID:
          case AssignmentEditPart.VISUAL_ID:
          case ChoiceEditPart.VISUAL_ID:
          case GetFullVariableEditPart.VISUAL_ID:
          case MultiStreamAudioEditPart.VISUAL_ID:
          case HangupEditPart.VISUAL_ID:
          case IfThenEditPart.VISUAL_ID:
          case RecordFileEditPart.VISUAL_ID:
          case SayAlphaEditPart.VISUAL_ID:
          case SayDateTimeEditPart.VISUAL_ID:
          case SayDigitsEditPart.VISUAL_ID:
          case SayNumberEditPart.VISUAL_ID:
          case SayPhoneticEditPart.VISUAL_ID:
          case SayTimeEditPart.VISUAL_ID:
          case SetAutoHangupEditPart.VISUAL_ID:
          case SetCallerIdEditPart.VISUAL_ID:
          case SetChannelVariableEditPart.VISUAL_ID:
          case SetContextEditPart.VISUAL_ID:
          case SetExtensionEditPart.VISUAL_ID:
          case StopMusicOnHoldEditPart.VISUAL_ID:
          case SetMusicOnEditPart.VISUAL_ID:
          case SetPriorityEditPart.VISUAL_ID:
          case StreamAudioEditPart.VISUAL_ID:
          case WaitForDigitEditPart.VISUAL_ID:
          case DIDMatcherEditPart.VISUAL_ID:
          case GetDigitsEditPart.VISUAL_ID:
          case OriginateCallEditPart.VISUAL_ID:
          case PlayDTMFEditPart.VISUAL_ID:
          case RecordCallEditPart.VISUAL_ID:
          case ExecuteApplicationEditPart.VISUAL_ID:
          case PlayMusicOnHoldEditPart.VISUAL_ID:
          case PromptGetDigitsEditPart.VISUAL_ID:
          case SleepEditPart.VISUAL_ID:
          case StreamAudioExtendedEditPart.VISUAL_ID:
          case IncomingCallEditPart.VISUAL_ID:
          case GetCallInfoEditPart.VISUAL_ID:
          case ExecuteScriptEditPart.VISUAL_ID:
          case InvokeSafletEditPart.VISUAL_ID:
          case DialEditPart.VISUAL_ID:
          case PickupEditPart.VISUAL_ID:
          case BackgroundEditPart.VISUAL_ID:
          case BackgroundDetectEditPart.VISUAL_ID:
          case WaitExtenEditPart.VISUAL_ID:
          case SoftHangupEditPart.VISUAL_ID:
          case PickupChanEditPart.VISUAL_ID:
          case PickdownEditPart.VISUAL_ID:
          case ProgressEditPart.VISUAL_ID:
          case BridgeEditPart.VISUAL_ID:
          case PlaceCallEditPart.VISUAL_ID:
          case VoicemailEditPart.VISUAL_ID:
          case VoicemailMainEditPart.VISUAL_ID:
          case VMAuthenticateEditPart.VISUAL_ID:
          case MeetMeEditPart.VISUAL_ID:
          case MeetMeAdminEditPart.VISUAL_ID:
          case MeetMeCountEditPart.VISUAL_ID:
          case DebugLogEditPart.VISUAL_ID:
          case WaitForRingEditPart.VISUAL_ID:
          case WaitMusicOnHoldEditPart.VISUAL_ID:
          case GetAvailableChannelEditPart.VISUAL_ID:
          case CongestionEditPart.VISUAL_ID:
          case RingingEditPart.VISUAL_ID:
          case SetCallerPresentationEditPart.VISUAL_ID:
          case SetGlobalVariableEditPart.VISUAL_ID:
          case EchoEditPart.VISUAL_ID:
          case FestivalEditPart.VISUAL_ID:
          case PlaytonesEditPart.VISUAL_ID:
          case StopPlaytonesEditPart.VISUAL_ID:
          case ChanSpyEditPart.VISUAL_ID:
          case DictateEditPart.VISUAL_ID:
          case ExtensionSpyEditPart.VISUAL_ID:
          case MixMonitorEditPart.VISUAL_ID:
          case StopMixmonitorEditPart.VISUAL_ID:
          case StopMonitorEditPart.VISUAL_ID:
          case MonitorEditPart.VISUAL_ID:
          case DirectoryEditPart.VISUAL_ID:
          case TransferEditPart.VISUAL_ID:
          case OpenDBConnectionEditPart.VISUAL_ID:
          case CloseDBConnectionEditPart.VISUAL_ID:
          case OpenQueryEditPart.VISUAL_ID:
          case SetQueryParamEditPart.VISUAL_ID:
          case ExecuteUpdateEditPart.VISUAL_ID:
          case ExecuteQueryEditPart.VISUAL_ID:
          case NextRowEditPart.VISUAL_ID:
          case GetColValueEditPart.VISUAL_ID:
          case SetColValueEditPart.VISUAL_ID:
          case UpdatetRowEditPart.VISUAL_ID:
          case MoveToRowEditPart.VISUAL_ID:
          case MoveToLastRowEditPart.VISUAL_ID:
          case DeleteRowEditPart.VISUAL_ID:
          case MoveToInsertRowEditPart.VISUAL_ID:
          case InsertRowEditPart.VISUAL_ID:
          case MoveToFirstRowEditPart.VISUAL_ID:
          case PreviousRowEditPart.VISUAL_ID:
          case GetColValuesEditPart.VISUAL_ID:
          case SetColValuesEditPart.VISUAL_ID:
          case ExtensionTransferEditPart.VISUAL_ID:
          case RunQueryEditPart.VISUAL_ID:
          case OutputEditPart.VISUAL_ID:
          case CaseItemEditPart.VISUAL_ID:
          case AudioFileItemEditPart.VISUAL_ID:
          case GetColMappingEditPart.VISUAL_ID:
          case SetColMappingEditPart.VISUAL_ID:
          case QueryParamMappingEditPart.VISUAL_ID:
            if (domainElement == null
                || visualID != AsteriskVisualIDRegistry.getNodeVisualID(containerView,
                    domainElement)) {
              return null; // visual id in semantic hint should match visual id for
              // domain element
            }
            break;
          case AnswerNameEditPart.VISUAL_ID:
            if (AnswerEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case AssignmentNameEditPart.VISUAL_ID:
            if (AssignmentEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ChoiceNameEditPart.VISUAL_ID:
          case ChoiceItemPanelEditPart.VISUAL_ID:
            if (ChoiceEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case GetFullVariableNameEditPart.VISUAL_ID:
            if (GetFullVariableEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MultiStreamAudioNameEditPart.VISUAL_ID:
          case MultiStreamAudioFilesPanelEditPart.VISUAL_ID:
            if (MultiStreamAudioEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case HangupNameEditPart.VISUAL_ID:
            if (HangupEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case IfThenNameEditPart.VISUAL_ID:
            if (IfThenEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case RecordFileNameEditPart.VISUAL_ID:
            if (RecordFileEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SayAlphaNameEditPart.VISUAL_ID:
            if (SayAlphaEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SayDateTimeNameEditPart.VISUAL_ID:
            if (SayDateTimeEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SayDigitsNameEditPart.VISUAL_ID:
            if (SayDigitsEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SayNumberNameEditPart.VISUAL_ID:
            if (SayNumberEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SayPhoneticNameEditPart.VISUAL_ID:
            if (SayPhoneticEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SayTimeNameEditPart.VISUAL_ID:
            if (SayTimeEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetAutoHangupNameEditPart.VISUAL_ID:
            if (SetAutoHangupEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetCallerIdNameEditPart.VISUAL_ID:
            if (SetCallerIdEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetChannelVariableNameEditPart.VISUAL_ID:
            if (SetChannelVariableEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetContextNameEditPart.VISUAL_ID:
            if (SetContextEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetExtensionNameEditPart.VISUAL_ID:
            if (SetExtensionEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case StopMusicOnHoldNameEditPart.VISUAL_ID:
            if (StopMusicOnHoldEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetMusicOnNameEditPart.VISUAL_ID:
            if (SetMusicOnEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetPriorityNameEditPart.VISUAL_ID:
            if (SetPriorityEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case StreamAudioNameEditPart.VISUAL_ID:
            if (StreamAudioEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case WaitForDigitNameEditPart.VISUAL_ID:
            if (WaitForDigitEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case DIDMatcherNameEditPart.VISUAL_ID:
            if (DIDMatcherEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case GetDigitsNameEditPart.VISUAL_ID:
            if (GetDigitsEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case OriginateCallNameEditPart.VISUAL_ID:
            if (OriginateCallEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case PlayDTMFNameEditPart.VISUAL_ID:
            if (PlayDTMFEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case RecordCallNameEditPart.VISUAL_ID:
            if (RecordCallEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ExecuteApplicationNameEditPart.VISUAL_ID:
            if (ExecuteApplicationEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case PlayMusicOnHoldNameEditPart.VISUAL_ID:
            if (PlayMusicOnHoldEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case PromptGetDigitsNameEditPart.VISUAL_ID:
            if (PromptGetDigitsEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SleepNameEditPart.VISUAL_ID:
            if (SleepEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case StreamAudioExtendedNameEditPart.VISUAL_ID:
            if (StreamAudioExtendedEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case IncomingCallNameEditPart.VISUAL_ID:
            if (IncomingCallEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case GetCallInfoNameEditPart.VISUAL_ID:
            if (GetCallInfoEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ExecuteScriptNameEditPart.VISUAL_ID:
            if (ExecuteScriptEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case InvokeSafletNameEditPart.VISUAL_ID:
          case InvokeSafletLabelTextEditPart.VISUAL_ID:
            if (InvokeSafletEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case DialNameEditPart.VISUAL_ID:
            if (DialEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case PickupNameEditPart.VISUAL_ID:
            if (PickupEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case BackgroundNameEditPart.VISUAL_ID:
            if (BackgroundEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case BackgroundDetectNameEditPart.VISUAL_ID:
            if (BackgroundDetectEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case WaitExtenNameEditPart.VISUAL_ID:
            if (WaitExtenEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SoftHangupNameEditPart.VISUAL_ID:
            if (SoftHangupEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case PickupChanNameEditPart.VISUAL_ID:
            if (PickupChanEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case PickdownNameEditPart.VISUAL_ID:
            if (PickdownEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ProgressNameEditPart.VISUAL_ID:
            if (ProgressEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case BridgeNameEditPart.VISUAL_ID:
            if (BridgeEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case PlaceCallNameEditPart.VISUAL_ID:
            if (PlaceCallEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case VoicemailNameEditPart.VISUAL_ID:
            if (VoicemailEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case VoicemailMainNameEditPart.VISUAL_ID:
            if (VoicemailMainEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case VMAuthenticateNameEditPart.VISUAL_ID:
            if (VMAuthenticateEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MeetMeNameEditPart.VISUAL_ID:
            if (MeetMeEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MeetMeAdminNameEditPart.VISUAL_ID:
            if (MeetMeAdminEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MeetMeCountNameEditPart.VISUAL_ID:
            if (MeetMeCountEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case DebugLogNameEditPart.VISUAL_ID:
            if (DebugLogEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case WaitForRingNameEditPart.VISUAL_ID:
            if (WaitForRingEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case WaitMusicOnHoldNameEditPart.VISUAL_ID:
            if (WaitMusicOnHoldEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case GetAvailableChannelNameEditPart.VISUAL_ID:
            if (GetAvailableChannelEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case CongestionNameEditPart.VISUAL_ID:
            if (CongestionEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case RingingNameEditPart.VISUAL_ID:
            if (RingingEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetCallerPresentationNameEditPart.VISUAL_ID:
            if (SetCallerPresentationEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetGlobalVariableNameEditPart.VISUAL_ID:
            if (SetGlobalVariableEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case EchoNameEditPart.VISUAL_ID:
            if (EchoEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case FestivalNameEditPart.VISUAL_ID:
            if (FestivalEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case PlaytonesNameEditPart.VISUAL_ID:
            if (PlaytonesEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case StopPlaytonesNameEditPart.VISUAL_ID:
            if (StopPlaytonesEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ChanSpyNameEditPart.VISUAL_ID:
            if (ChanSpyEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case DictateNameEditPart.VISUAL_ID:
            if (DictateEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ExtensionSpyNameEditPart.VISUAL_ID:
            if (ExtensionSpyEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MixMonitorNameEditPart.VISUAL_ID:
            if (MixMonitorEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case StopMixmonitorNameEditPart.VISUAL_ID:
            if (StopMixmonitorEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case StopMonitorNameEditPart.VISUAL_ID:
            if (StopMonitorEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MonitorNameEditPart.VISUAL_ID:
            if (MonitorEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case DirectoryNameEditPart.VISUAL_ID:
            if (DirectoryEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case TransferNameEditPart.VISUAL_ID:
            if (TransferEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case OpenDBConnectionNameEditPart.VISUAL_ID:
            if (OpenDBConnectionEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case CloseDBConnectionNameEditPart.VISUAL_ID:
            if (CloseDBConnectionEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case OpenQueryNameEditPart.VISUAL_ID:
            if (OpenQueryEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetQueryParamNameEditPart.VISUAL_ID:
            if (SetQueryParamEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ExecuteUpdateNameEditPart.VISUAL_ID:
            if (ExecuteUpdateEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ExecuteQueryNameEditPart.VISUAL_ID:
            if (ExecuteQueryEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case NextRowNameEditPart.VISUAL_ID:
            if (NextRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case GetColValueNameEditPart.VISUAL_ID:
            if (GetColValueEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetColValueNameEditPart.VISUAL_ID:
            if (SetColValueEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case UpdatetRowNameEditPart.VISUAL_ID:
            if (UpdatetRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MoveToRowNameEditPart.VISUAL_ID:
            if (MoveToRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MoveToLastRowNameEditPart.VISUAL_ID:
            if (MoveToLastRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case DeleteRowNameEditPart.VISUAL_ID:
            if (DeleteRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MoveToInsertRowNameEditPart.VISUAL_ID:
            if (MoveToInsertRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case InsertRowNameEditPart.VISUAL_ID:
            if (InsertRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case MoveToFirstRowNameEditPart.VISUAL_ID:
            if (MoveToFirstRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case PreviousRowNameEditPart.VISUAL_ID:
            if (PreviousRowEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case GetColValuesNameEditPart.VISUAL_ID:
          case GetColValuesValuesPanelEditPart.VISUAL_ID:
            if (GetColValuesEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetColValuesNameEditPart.VISUAL_ID:
          case SetColValuesValuesPanelEditPart.VISUAL_ID:
            if (SetColValuesEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case ExtensionTransferNameEditPart.VISUAL_ID:
            if (ExtensionTransferEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case RunQueryNameEditPart.VISUAL_ID:
          case RunQueryRunQueryValuesPanelEditPart.VISUAL_ID:
            if (RunQueryEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case CaseItemLabelTextEditPart.VISUAL_ID:
            if (CaseItemEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case AudioFileItemLabelTextEditPart.VISUAL_ID:
            if (AudioFileItemEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case GetColMappingGetAsDatatypeEditPart.VISUAL_ID:
            if (GetColMappingEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case SetColMappingSetAsDatatypeEditPart.VISUAL_ID:
            if (SetColMappingEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;
          case WrapLabelEditPart.VISUAL_ID:
            if (QueryParamMappingEditPart.VISUAL_ID != AsteriskVisualIDRegistry
                .getVisualID(containerView)
                || containerView.getElement() != domainElement) {
              return null; // wrong container
            }
            break;

          default: {
            boolean found = false;
            for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
                .getInstance().getActionstepProfiles()) {
              if (p.labelSemanticHint.equals(String.valueOf(visualID))) {
                found = true;

                if (!p.semanticHint.equals(String.valueOf(AsteriskVisualIDRegistry
                    .getVisualID(containerView)))
                    || containerView.getElement() != domainElement) {
                  return null; // wrong container
                }
                break;
              } else if (p.semanticHint.equals(String.valueOf(visualID))) {
                found = true;
                if (domainElement == null
                    || visualID != AsteriskVisualIDRegistry.getNodeVisualID(containerView,
                        domainElement)) {
                  return null; // visual id in semantic hint should match visual id for
                  // domain element
                }
                break;
              }
              if (String.valueOf(visualID).equals(p.inputItemLabelSemanticHint)) {
                found = true;

                if (!String.valueOf(AsteriskVisualIDRegistry.getVisualID(containerView)).equals(
                    p.inputItemSemanticHint)
                    || containerView.getElement() != domainElement) {
                  return null; // wrong container
                }
                break;
              } else if (String.valueOf(visualID).equals(p.inputItemSemanticHint)) {
                found = true;
                if (domainElement == null
                    || visualID != AsteriskVisualIDRegistry.getNodeVisualID(containerView,
                        domainElement)) {
                  return null; // visual id in semantic hint should match visual id for
                  // domain element
                }
                break;
              } else if (String.valueOf(visualID).equals(p.inputItemPanelSemanticHint)) {
                found = true;
                if (Integer.parseInt(p.semanticHint) != AsteriskVisualIDRegistry
                    .getVisualID(containerView)
                    || containerView.getElement() != domainElement) {
                  // return null; // wrong container
                  found = false;
                  continue;
                }

                break;
              } else if (String.valueOf(visualID).equals(p.outputItemLabelSemanticHint)) {
                found = true;

                if (!String.valueOf(AsteriskVisualIDRegistry.getVisualID(containerView)).equals(
                    p.outputItemSemanticHint)
                    || containerView.getElement() != domainElement) {
                  return null; // wrong container
                }
                break;
              } else if (String.valueOf(visualID).equals(p.outputItemSemanticHint)) {
                found = true;
                if (domainElement == null
                    || visualID != AsteriskVisualIDRegistry.getNodeVisualID(containerView,
                        domainElement)) {
                  return null; // visual id in semantic hint should match visual id for
                  // domain element
                }
                break;
              } else if (String.valueOf(visualID).equals(p.outputItemPanelSemanticHint)) {
                found = true;
                if (Integer.parseInt(p.semanticHint) != AsteriskVisualIDRegistry
                    .getVisualID(containerView)
                    || containerView.getElement() != domainElement) {
                  // return null; // wrong container
                  found = false;
                  continue;
                }

                break;
              }
            }
            if (!found) {
              return null;
            }
          }
        }
      }
    }
    return getNodeViewClass(containerView, visualID);
  }

  @Override
  protected boolean provides(CreateNodeViewOperation operation) {
    // TODO Auto-generated method stub
    return super.provides(operation);
  }

  @Override
  protected boolean provides(CreateViewForKindOperation op) {
    // TODO Auto-generated method stub
    return super.provides(op);
  }

  /**
   * @generated NOT
   */
  protected Class getNodeViewClass(View containerView, int visualID) {
    if (containerView == null || !AsteriskVisualIDRegistry.canCreateNode(containerView, visualID)) {
      return null;
    }
    switch (visualID) {
      case AnswerEditPart.VISUAL_ID:
        return AnswerViewFactory.class;
      case AnswerNameEditPart.VISUAL_ID:
        return AnswerNameViewFactory.class;
      case AssignmentEditPart.VISUAL_ID:
        return AssignmentViewFactory.class;
      case AssignmentNameEditPart.VISUAL_ID:
        return AssignmentNameViewFactory.class;
      case ChoiceEditPart.VISUAL_ID:
        return ChoiceViewFactory.class;
      case ChoiceNameEditPart.VISUAL_ID:
        return ChoiceNameViewFactory.class;
      case GetFullVariableEditPart.VISUAL_ID:
        return GetFullVariableViewFactory.class;
      case GetFullVariableNameEditPart.VISUAL_ID:
        return GetFullVariableNameViewFactory.class;
      case MultiStreamAudioEditPart.VISUAL_ID:
        return MultiStreamAudioViewFactory.class;
      case MultiStreamAudioNameEditPart.VISUAL_ID:
        return MultiStreamAudioNameViewFactory.class;
      case HangupEditPart.VISUAL_ID:
        return HangupViewFactory.class;
      case HangupNameEditPart.VISUAL_ID:
        return HangupNameViewFactory.class;
      case IfThenEditPart.VISUAL_ID:
        return IfThenViewFactory.class;
      case IfThenNameEditPart.VISUAL_ID:
        return IfThenNameViewFactory.class;
      case RecordFileEditPart.VISUAL_ID:
        return RecordFileViewFactory.class;
      case RecordFileNameEditPart.VISUAL_ID:
        return RecordFileNameViewFactory.class;
      case SayAlphaEditPart.VISUAL_ID:
        return SayAlphaViewFactory.class;
      case SayAlphaNameEditPart.VISUAL_ID:
        return SayAlphaNameViewFactory.class;
      case SayDateTimeEditPart.VISUAL_ID:
        return SayDateTimeViewFactory.class;
      case SayDateTimeNameEditPart.VISUAL_ID:
        return SayDateTimeNameViewFactory.class;
      case SayDigitsEditPart.VISUAL_ID:
        return SayDigitsViewFactory.class;
      case SayDigitsNameEditPart.VISUAL_ID:
        return SayDigitsNameViewFactory.class;
      case SayNumberEditPart.VISUAL_ID:
        return SayNumberViewFactory.class;
      case SayNumberNameEditPart.VISUAL_ID:
        return SayNumberNameViewFactory.class;
      case SayPhoneticEditPart.VISUAL_ID:
        return SayPhoneticViewFactory.class;
      case SayPhoneticNameEditPart.VISUAL_ID:
        return SayPhoneticNameViewFactory.class;
      case SayTimeEditPart.VISUAL_ID:
        return SayTimeViewFactory.class;
      case SayTimeNameEditPart.VISUAL_ID:
        return SayTimeNameViewFactory.class;
      case SetAutoHangupEditPart.VISUAL_ID:
        return SetAutoHangupViewFactory.class;
      case SetAutoHangupNameEditPart.VISUAL_ID:
        return SetAutoHangupNameViewFactory.class;
      case SetCallerIdEditPart.VISUAL_ID:
        return SetCallerIdViewFactory.class;
      case SetCallerIdNameEditPart.VISUAL_ID:
        return SetCallerIdNameViewFactory.class;
      case SetChannelVariableEditPart.VISUAL_ID:
        return SetChannelVariableViewFactory.class;
      case SetChannelVariableNameEditPart.VISUAL_ID:
        return SetChannelVariableNameViewFactory.class;
      case SetContextEditPart.VISUAL_ID:
        return SetContextViewFactory.class;
      case SetContextNameEditPart.VISUAL_ID:
        return SetContextNameViewFactory.class;
      case SetExtensionEditPart.VISUAL_ID:
        return SetExtensionViewFactory.class;
      case SetExtensionNameEditPart.VISUAL_ID:
        return SetExtensionNameViewFactory.class;
      case StopMusicOnHoldEditPart.VISUAL_ID:
        return StopMusicOnHoldViewFactory.class;
      case StopMusicOnHoldNameEditPart.VISUAL_ID:
        return StopMusicOnHoldNameViewFactory.class;
      case SetMusicOnEditPart.VISUAL_ID:
        return SetMusicOnViewFactory.class;
      case SetMusicOnNameEditPart.VISUAL_ID:
        return SetMusicOnNameViewFactory.class;
      case SetPriorityEditPart.VISUAL_ID:
        return SetPriorityViewFactory.class;
      case SetPriorityNameEditPart.VISUAL_ID:
        return SetPriorityNameViewFactory.class;
      case StreamAudioEditPart.VISUAL_ID:
        return StreamAudioViewFactory.class;
      case StreamAudioNameEditPart.VISUAL_ID:
        return StreamAudioNameViewFactory.class;
      case WaitForDigitEditPart.VISUAL_ID:
        return WaitForDigitViewFactory.class;
      case WaitForDigitNameEditPart.VISUAL_ID:
        return WaitForDigitNameViewFactory.class;
      case DIDMatcherEditPart.VISUAL_ID:
        return DIDMatcherViewFactory.class;
      case DIDMatcherNameEditPart.VISUAL_ID:
        return DIDMatcherNameViewFactory.class;
      case GetDigitsEditPart.VISUAL_ID:
        return GetDigitsViewFactory.class;
      case GetDigitsNameEditPart.VISUAL_ID:
        return GetDigitsNameViewFactory.class;
      case OriginateCallEditPart.VISUAL_ID:
        return OriginateCallViewFactory.class;
      case OriginateCallNameEditPart.VISUAL_ID:
        return OriginateCallNameViewFactory.class;
      case PlayDTMFEditPart.VISUAL_ID:
        return PlayDTMFViewFactory.class;
      case PlayDTMFNameEditPart.VISUAL_ID:
        return PlayDTMFNameViewFactory.class;
      case RecordCallEditPart.VISUAL_ID:
        return RecordCallViewFactory.class;
      case RecordCallNameEditPart.VISUAL_ID:
        return RecordCallNameViewFactory.class;
      case ExecuteApplicationEditPart.VISUAL_ID:
        return ExecuteApplicationViewFactory.class;
      case ExecuteApplicationNameEditPart.VISUAL_ID:
        return ExecuteApplicationNameViewFactory.class;
      case PlayMusicOnHoldEditPart.VISUAL_ID:
        return PlayMusicOnHoldViewFactory.class;
      case PlayMusicOnHoldNameEditPart.VISUAL_ID:
        return PlayMusicOnHoldNameViewFactory.class;
      case PromptGetDigitsEditPart.VISUAL_ID:
        return PromptGetDigitsViewFactory.class;
      case PromptGetDigitsNameEditPart.VISUAL_ID:
        return PromptGetDigitsNameViewFactory.class;
      case SleepEditPart.VISUAL_ID:
        return SleepViewFactory.class;
      case SleepNameEditPart.VISUAL_ID:
        return SleepNameViewFactory.class;
      case StreamAudioExtendedEditPart.VISUAL_ID:
        return StreamAudioExtendedViewFactory.class;
      case StreamAudioExtendedNameEditPart.VISUAL_ID:
        return StreamAudioExtendedNameViewFactory.class;
      case IncomingCallEditPart.VISUAL_ID:
        return IncomingCallViewFactory.class;
      case IncomingCallNameEditPart.VISUAL_ID:
        return IncomingCallNameViewFactory.class;
      case GetCallInfoEditPart.VISUAL_ID:
        return GetCallInfoViewFactory.class;
      case GetCallInfoNameEditPart.VISUAL_ID:
        return GetCallInfoNameViewFactory.class;
      case ExecuteScriptEditPart.VISUAL_ID:
        return ExecuteScriptViewFactory.class;
      case ExecuteScriptNameEditPart.VISUAL_ID:
        return ExecuteScriptNameViewFactory.class;
      case InvokeSafletEditPart.VISUAL_ID:
        return InvokeSafletViewFactory.class;
      case InvokeSafletNameEditPart.VISUAL_ID:
        return InvokeSafletNameViewFactory.class;
      case InvokeSafletLabelTextEditPart.VISUAL_ID:
        return InvokeSafletLabelTextViewFactory.class;
      case DialEditPart.VISUAL_ID:
        return DialViewFactory.class;
      case DialNameEditPart.VISUAL_ID:
        return DialNameViewFactory.class;
      case PickupEditPart.VISUAL_ID:
        return PickupViewFactory.class;
      case PickupNameEditPart.VISUAL_ID:
        return PickupNameViewFactory.class;
      case BackgroundEditPart.VISUAL_ID:
        return BackgroundViewFactory.class;
      case BackgroundNameEditPart.VISUAL_ID:
        return BackgroundNameViewFactory.class;
      case BackgroundDetectEditPart.VISUAL_ID:
        return BackgroundDetectViewFactory.class;
      case BackgroundDetectNameEditPart.VISUAL_ID:
        return BackgroundDetectNameViewFactory.class;
      case WaitExtenEditPart.VISUAL_ID:
        return WaitExtenViewFactory.class;
      case WaitExtenNameEditPart.VISUAL_ID:
        return WaitExtenNameViewFactory.class;
      case SoftHangupEditPart.VISUAL_ID:
        return SoftHangupViewFactory.class;
      case SoftHangupNameEditPart.VISUAL_ID:
        return SoftHangupNameViewFactory.class;
      case PickupChanEditPart.VISUAL_ID:
        return PickupChanViewFactory.class;
      case PickupChanNameEditPart.VISUAL_ID:
        return PickupChanNameViewFactory.class;
      case PickdownEditPart.VISUAL_ID:
        return PickdownViewFactory.class;
      case PickdownNameEditPart.VISUAL_ID:
        return PickdownNameViewFactory.class;
      case ProgressEditPart.VISUAL_ID:
        return ProgressViewFactory.class;
      case ProgressNameEditPart.VISUAL_ID:
        return ProgressNameViewFactory.class;
      case BridgeEditPart.VISUAL_ID:
        return BridgeViewFactory.class;
      case BridgeNameEditPart.VISUAL_ID:
        return BridgeNameViewFactory.class;
      case PlaceCallEditPart.VISUAL_ID:
        return PlaceCallViewFactory.class;
      case PlaceCallNameEditPart.VISUAL_ID:
        return PlaceCallNameViewFactory.class;
      case VoicemailEditPart.VISUAL_ID:
        return VoicemailViewFactory.class;
      case VoicemailNameEditPart.VISUAL_ID:
        return VoicemailNameViewFactory.class;
      case VoicemailMainEditPart.VISUAL_ID:
        return VoicemailMainViewFactory.class;
      case VoicemailMainNameEditPart.VISUAL_ID:
        return VoicemailMainNameViewFactory.class;
      case VMAuthenticateEditPart.VISUAL_ID:
        return VMAuthenticateViewFactory.class;
      case VMAuthenticateNameEditPart.VISUAL_ID:
        return VMAuthenticateNameViewFactory.class;
      case MeetMeEditPart.VISUAL_ID:
        return MeetMeViewFactory.class;
      case MeetMeNameEditPart.VISUAL_ID:
        return MeetMeNameViewFactory.class;
      case MeetMeAdminEditPart.VISUAL_ID:
        return MeetMeAdminViewFactory.class;
      case MeetMeAdminNameEditPart.VISUAL_ID:
        return MeetMeAdminNameViewFactory.class;
      case MeetMeCountEditPart.VISUAL_ID:
        return MeetMeCountViewFactory.class;
      case MeetMeCountNameEditPart.VISUAL_ID:
        return MeetMeCountNameViewFactory.class;
      case DebugLogEditPart.VISUAL_ID:
        return DebugLogViewFactory.class;
      case DebugLogNameEditPart.VISUAL_ID:
        return DebugLogNameViewFactory.class;
      case WaitForRingEditPart.VISUAL_ID:
        return WaitForRingViewFactory.class;
      case WaitForRingNameEditPart.VISUAL_ID:
        return WaitForRingNameViewFactory.class;
      case WaitMusicOnHoldEditPart.VISUAL_ID:
        return WaitMusicOnHoldViewFactory.class;
      case WaitMusicOnHoldNameEditPart.VISUAL_ID:
        return WaitMusicOnHoldNameViewFactory.class;
      case GetAvailableChannelEditPart.VISUAL_ID:
        return GetAvailableChannelViewFactory.class;
      case GetAvailableChannelNameEditPart.VISUAL_ID:
        return GetAvailableChannelNameViewFactory.class;
      case CongestionEditPart.VISUAL_ID:
        return CongestionViewFactory.class;
      case CongestionNameEditPart.VISUAL_ID:
        return CongestionNameViewFactory.class;
      case RingingEditPart.VISUAL_ID:
        return RingingViewFactory.class;
      case RingingNameEditPart.VISUAL_ID:
        return RingingNameViewFactory.class;
      case SetCallerPresentationEditPart.VISUAL_ID:
        return SetCallerPresentationViewFactory.class;
      case SetCallerPresentationNameEditPart.VISUAL_ID:
        return SetCallerPresentationNameViewFactory.class;
      case SetGlobalVariableEditPart.VISUAL_ID:
        return SetGlobalVariableViewFactory.class;
      case SetGlobalVariableNameEditPart.VISUAL_ID:
        return SetGlobalVariableNameViewFactory.class;
      case EchoEditPart.VISUAL_ID:
        return EchoViewFactory.class;
      case EchoNameEditPart.VISUAL_ID:
        return EchoNameViewFactory.class;
      case FestivalEditPart.VISUAL_ID:
        return FestivalViewFactory.class;
      case FestivalNameEditPart.VISUAL_ID:
        return FestivalNameViewFactory.class;
      case PlaytonesEditPart.VISUAL_ID:
        return PlaytonesViewFactory.class;
      case PlaytonesNameEditPart.VISUAL_ID:
        return PlaytonesNameViewFactory.class;
      case StopPlaytonesEditPart.VISUAL_ID:
        return StopPlaytonesViewFactory.class;
      case StopPlaytonesNameEditPart.VISUAL_ID:
        return StopPlaytonesNameViewFactory.class;
      case ChanSpyEditPart.VISUAL_ID:
        return ChanSpyViewFactory.class;
      case ChanSpyNameEditPart.VISUAL_ID:
        return ChanSpyNameViewFactory.class;
      case DictateEditPart.VISUAL_ID:
        return DictateViewFactory.class;
      case DictateNameEditPart.VISUAL_ID:
        return DictateNameViewFactory.class;
      case ExtensionSpyEditPart.VISUAL_ID:
        return ExtensionSpyViewFactory.class;
      case ExtensionSpyNameEditPart.VISUAL_ID:
        return ExtensionSpyNameViewFactory.class;
      case MixMonitorEditPart.VISUAL_ID:
        return MixMonitorViewFactory.class;
      case MixMonitorNameEditPart.VISUAL_ID:
        return MixMonitorNameViewFactory.class;
      case StopMixmonitorEditPart.VISUAL_ID:
        return StopMixmonitorViewFactory.class;
      case StopMixmonitorNameEditPart.VISUAL_ID:
        return StopMixmonitorNameViewFactory.class;
      case StopMonitorEditPart.VISUAL_ID:
        return StopMonitorViewFactory.class;
      case StopMonitorNameEditPart.VISUAL_ID:
        return StopMonitorNameViewFactory.class;
      case MonitorEditPart.VISUAL_ID:
        return MonitorViewFactory.class;
      case MonitorNameEditPart.VISUAL_ID:
        return MonitorNameViewFactory.class;
      case DirectoryEditPart.VISUAL_ID:
        return DirectoryViewFactory.class;
      case DirectoryNameEditPart.VISUAL_ID:
        return DirectoryNameViewFactory.class;
      case TransferEditPart.VISUAL_ID:
        return TransferViewFactory.class;
      case TransferNameEditPart.VISUAL_ID:
        return TransferNameViewFactory.class;
      case OpenDBConnectionEditPart.VISUAL_ID:
        return OpenDBConnectionViewFactory.class;
      case OpenDBConnectionNameEditPart.VISUAL_ID:
        return OpenDBConnectionNameViewFactory.class;
      case CloseDBConnectionEditPart.VISUAL_ID:
        return CloseDBConnectionViewFactory.class;
      case CloseDBConnectionNameEditPart.VISUAL_ID:
        return CloseDBConnectionNameViewFactory.class;
      case OpenQueryEditPart.VISUAL_ID:
        return OpenQueryViewFactory.class;
      case OpenQueryNameEditPart.VISUAL_ID:
        return OpenQueryNameViewFactory.class;
      case SetQueryParamEditPart.VISUAL_ID:
        return SetQueryParamViewFactory.class;
      case SetQueryParamNameEditPart.VISUAL_ID:
        return SetQueryParamNameViewFactory.class;
      case ExecuteUpdateEditPart.VISUAL_ID:
        return ExecuteUpdateViewFactory.class;
      case ExecuteUpdateNameEditPart.VISUAL_ID:
        return ExecuteUpdateNameViewFactory.class;
      case ExecuteQueryEditPart.VISUAL_ID:
        return ExecuteQueryViewFactory.class;
      case ExecuteQueryNameEditPart.VISUAL_ID:
        return ExecuteQueryNameViewFactory.class;
      case NextRowEditPart.VISUAL_ID:
        return NextRowViewFactory.class;
      case NextRowNameEditPart.VISUAL_ID:
        return NextRowNameViewFactory.class;
      case GetColValueEditPart.VISUAL_ID:
        return GetColValueViewFactory.class;
      case GetColValueNameEditPart.VISUAL_ID:
        return GetColValueNameViewFactory.class;
      case SetColValueEditPart.VISUAL_ID:
        return SetColValueViewFactory.class;
      case SetColValueNameEditPart.VISUAL_ID:
        return SetColValueNameViewFactory.class;
      case UpdatetRowEditPart.VISUAL_ID:
        return UpdatetRowViewFactory.class;
      case UpdatetRowNameEditPart.VISUAL_ID:
        return UpdatetRowNameViewFactory.class;
      case MoveToRowEditPart.VISUAL_ID:
        return MoveToRowViewFactory.class;
      case MoveToRowNameEditPart.VISUAL_ID:
        return MoveToRowNameViewFactory.class;
      case MoveToLastRowEditPart.VISUAL_ID:
        return MoveToLastRowViewFactory.class;
      case MoveToLastRowNameEditPart.VISUAL_ID:
        return MoveToLastRowNameViewFactory.class;
      case DeleteRowEditPart.VISUAL_ID:
        return DeleteRowViewFactory.class;
      case DeleteRowNameEditPart.VISUAL_ID:
        return DeleteRowNameViewFactory.class;
      case MoveToInsertRowEditPart.VISUAL_ID:
        return MoveToInsertRowViewFactory.class;
      case MoveToInsertRowNameEditPart.VISUAL_ID:
        return MoveToInsertRowNameViewFactory.class;
      case InsertRowEditPart.VISUAL_ID:
        return InsertRowViewFactory.class;
      case InsertRowNameEditPart.VISUAL_ID:
        return InsertRowNameViewFactory.class;
      case MoveToFirstRowEditPart.VISUAL_ID:
        return MoveToFirstRowViewFactory.class;
      case MoveToFirstRowNameEditPart.VISUAL_ID:
        return MoveToFirstRowNameViewFactory.class;
      case PreviousRowEditPart.VISUAL_ID:
        return PreviousRowViewFactory.class;
      case PreviousRowNameEditPart.VISUAL_ID:
        return PreviousRowNameViewFactory.class;
      case GetColValuesEditPart.VISUAL_ID:
        return GetColValuesViewFactory.class;
      case GetColValuesNameEditPart.VISUAL_ID:
        return GetColValuesNameViewFactory.class;
      case SetColValuesEditPart.VISUAL_ID:
        return SetColValuesViewFactory.class;
      case SetColValuesNameEditPart.VISUAL_ID:
        return SetColValuesNameViewFactory.class;
      case ExtensionTransferEditPart.VISUAL_ID:
        return ExtensionTransferViewFactory.class;
      case ExtensionTransferNameEditPart.VISUAL_ID:
        return ExtensionTransferNameViewFactory.class;
      case RunQueryEditPart.VISUAL_ID:
        return RunQueryViewFactory.class;
      case RunQueryNameEditPart.VISUAL_ID:
        return RunQueryNameViewFactory.class;
      case OutputEditPart.VISUAL_ID:
        return OutputViewFactory.class;
      case CaseItemEditPart.VISUAL_ID:
        return CaseItemViewFactory.class;
      case CaseItemLabelTextEditPart.VISUAL_ID:
        return CaseItemLabelTextViewFactory.class;
      case AudioFileItemEditPart.VISUAL_ID:
        return AudioFileItemViewFactory.class;
      case AudioFileItemLabelTextEditPart.VISUAL_ID:
        return AudioFileItemLabelTextViewFactory.class;
      case GetColMappingEditPart.VISUAL_ID:
        return GetColMappingViewFactory.class;
      case GetColMappingGetAsDatatypeEditPart.VISUAL_ID:
        return GetColMappingGetAsDatatypeViewFactory.class;
      case SetColMappingEditPart.VISUAL_ID:
        return SetColMappingViewFactory.class;
      case SetColMappingSetAsDatatypeEditPart.VISUAL_ID:
        return SetColMappingSetAsDatatypeViewFactory.class;
      case QueryParamMappingEditPart.VISUAL_ID:
        return QueryParamMappingViewFactory.class;
      case WrapLabelEditPart.VISUAL_ID:
        return WrapLabelViewFactory.class;
      case ChoiceItemPanelEditPart.VISUAL_ID:
        return ChoiceItemPanelViewFactory.class;
      case MultiStreamAudioFilesPanelEditPart.VISUAL_ID:
        return MultiStreamAudioFilesPanelViewFactory.class;
      case GetColValuesValuesPanelEditPart.VISUAL_ID:
        return GetColValuesValuesPanelViewFactory.class;
      case SetColValuesValuesPanelEditPart.VISUAL_ID:
        return SetColValuesValuesPanelViewFactory.class;
      case RunQueryRunQueryValuesPanelEditPart.VISUAL_ID:
        return RunQueryRunQueryValuesPanelViewFactory.class;
      default:
        String id = String.valueOf(visualID);
        for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
            .getInstance().getActionstepProfiles()) {
          BasicNodeViewFactory f = p.viewFactory.createShapeViewFactory(visualID);
          if (f != null)
            return f.getClass();
          // if (p.semanticHint.equals(id))
          // return ActionstepViewFactory.class;
          // else
          // if (p.labelSemanticHint.equals(id))
          // return ActionstepNameLabelViewFactory.class;
        }
        return null;
    }
  }

  /**
   * @generated
   */
  @Override
  protected Class getEdgeViewClass(IAdaptable semanticAdapter, View containerView,
      String semanticHint) {
    IElementType elementType = getSemanticElementType(semanticAdapter);
    if (!AsteriskElementTypes.isKnownElementType(elementType)
        || (!(elementType instanceof IHintedType))) {
      return null; // foreign element type
    }
    String elementTypeHint = ((IHintedType) elementType).getSemanticHint();
    if (elementTypeHint == null) {
      return null; // our hint is visual id and must be specified
    }
    if (semanticHint != null && !semanticHint.equals(elementTypeHint)) {
      return null; // if semantic hint is specified it should be the same as in element
      // type
    }
    int visualID = AsteriskVisualIDRegistry.getVisualID(elementTypeHint);
    EObject domainElement = getSemanticElement(semanticAdapter);
    if (domainElement != null
        && visualID != AsteriskVisualIDRegistry.getLinkWithClassVisualID(domainElement)) {
      return null; // visual id for link EClass should match visual id from element type
    }
    return getEdgeViewClass(visualID);
  }

  /**
   * @generated
   */
  protected Class getEdgeViewClass(int visualID) {
    switch (visualID) {
      case OutputTargetEditPart.VISUAL_ID:
        return OutputTargetViewFactory.class;
      case CaseItemTargetToolstepEditPart.VISUAL_ID:
        return CaseItemTargetToolstepViewFactory.class;
    }
    return null;
  }

  /**
   * @generated
   */
  private IElementType getSemanticElementType(IAdaptable semanticAdapter) {
    if (semanticAdapter == null) {
      return null;
    }
    return (IElementType) semanticAdapter.getAdapter(IElementType.class);
  }
}
