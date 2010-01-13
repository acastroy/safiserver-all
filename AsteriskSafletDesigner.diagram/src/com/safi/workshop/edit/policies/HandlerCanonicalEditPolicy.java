package com.safi.workshop.edit.policies;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.DeferredLayoutCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.saflet.SafletPackage;
import com.safi.workshop.edit.parts.*;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramUpdater;
import com.safi.workshop.part.AsteriskLinkDescriptor;
import com.safi.workshop.part.AsteriskNodeDescriptor;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated
 */
public class HandlerCanonicalEditPolicy extends CanonicalConnectionEditPolicy {

  /**
   * @generated
   */
  Set myFeaturesToSynchronize;

  /**
   * @generated
   */
  @Override
  protected List getSemanticChildrenList() {
    View viewObject = (View) getHost().getModel();
    List result = new LinkedList();
    for (Iterator it = AsteriskDiagramUpdater.getHandler_79SemanticChildren(viewObject).iterator(); it
        .hasNext();) {
      result.add(((AsteriskNodeDescriptor) it.next()).getModelElement());
    }
    return result;
  }

  /**
   * @generated
   */
  @Override
  protected boolean shouldDeleteView(View view) {
    return true;
  }

  /**
   * @generated NOT
   */
  @Override
  protected boolean isOrphaned(Collection semanticChildren, final View view) {
    int visualID = AsteriskVisualIDRegistry.getVisualID(view);
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
        return !semanticChildren.contains(view.getElement())
            || visualID != AsteriskVisualIDRegistry.getNodeVisualID((View) getHost().getModel(),
                view.getElement());
      default: {
        for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
            .getInstance().getActionstepProfiles()) {
          if (p.semanticHint.equals(String.valueOf(visualID))) {
            return !semanticChildren.contains(view.getElement())
                || visualID != AsteriskVisualIDRegistry.getNodeVisualID(
                    (View) getHost().getModel(), view.getElement());
          }
        }
      }
    }
    return false;
  }

  /**
   * @generated
   */
  @Override
  protected String getDefaultFactoryHint() {
    return null;
  }

  /**
   * @generated
   */
  @Override
  protected Set getFeaturesToSynchronize() {
    if (myFeaturesToSynchronize == null) {
      myFeaturesToSynchronize = new HashSet();
      myFeaturesToSynchronize.add(SafletPackage.eINSTANCE.getSaflet_Actionsteps());
      myFeaturesToSynchronize.add(SafletPackage.eINSTANCE.getSaflet_Initiator());
    }
    return myFeaturesToSynchronize;
  }

  /**
   * @generated
   */
  @Override
  protected List getSemanticConnectionsList() {
    return Collections.EMPTY_LIST;
  }

  /**
   * @generated
   */
  @Override
  protected EObject getSourceElement(EObject relationship) {
    return null;
  }

  /**
   * @generated
   */
  @Override
  protected EObject getTargetElement(EObject relationship) {
    return null;
  }

  /**
   * @generated
   */
  @Override
  protected boolean shouldIncludeConnection(Edge connector, Collection children) {
    return false;
  }

  /**
   * @generated
   */
  @Override
  protected void refreshSemantic() {
    List createdViews = new LinkedList();
    createdViews.addAll(refreshSemanticChildren());
    List createdConnectionViews = new LinkedList();
    createdConnectionViews.addAll(refreshSemanticConnections());
    createdConnectionViews.addAll(refreshConnections());

    if (createdViews.size() > 1) {
      // perform a layout of the container
      DeferredLayoutCommand layoutCmd = new DeferredLayoutCommand(host().getEditingDomain(),
          createdViews, host());
      executeCommand(new ICommandProxy(layoutCmd));
    }

    createdViews.addAll(createdConnectionViews);
    makeViewsImmutable(createdViews);
  }

  /**
   * @generated
   */
  private Diagram getDiagram() {
    return ((View) getHost().getModel()).getDiagram();
  }

  /**
   * @generated
   */
  private Collection refreshConnections() {
    Map domain2NotationMap = new HashMap();
    Collection linkDescriptors = collectAllLinks(getDiagram(), domain2NotationMap);
    Collection existingLinks = new LinkedList(getDiagram().getEdges());
    for (Iterator linksIterator = existingLinks.iterator(); linksIterator.hasNext();) {
      Edge nextDiagramLink = (Edge) linksIterator.next();
      int diagramLinkVisualID = AsteriskVisualIDRegistry.getVisualID(nextDiagramLink);
      if (diagramLinkVisualID == -1) {
        if (nextDiagramLink.getSource() != null && nextDiagramLink.getTarget() != null) {
          linksIterator.remove();
        }
        continue;
      }
      EObject diagramLinkObject = nextDiagramLink.getElement();
      EObject diagramLinkSrc = nextDiagramLink.getSource().getElement();
      EObject diagramLinkDst = nextDiagramLink.getTarget().getElement();
      for (Iterator LinkDescriptorsIterator = linkDescriptors.iterator(); LinkDescriptorsIterator
          .hasNext();) {
        AsteriskLinkDescriptor nextLinkDescriptor = (AsteriskLinkDescriptor) LinkDescriptorsIterator
            .next();
        if (diagramLinkObject == nextLinkDescriptor.getModelElement()
            && diagramLinkSrc == nextLinkDescriptor.getSource()
            && diagramLinkDst == nextLinkDescriptor.getDestination()
            && diagramLinkVisualID == nextLinkDescriptor.getVisualID()) {
          linksIterator.remove();
          LinkDescriptorsIterator.remove();
        }
      }
    }
    deleteViews(existingLinks.iterator());
    return createConnections(linkDescriptors, domain2NotationMap);
  }

  /**
   * @generated
   */
  private Collection collectAllLinks(View view, Map domain2NotationMap) {
    if (!HandlerEditPart.MODEL_ID.equals(AsteriskVisualIDRegistry.getModelID(view))) {
      return Collections.EMPTY_LIST;
    }
    Collection result = new LinkedList();
    switch (AsteriskVisualIDRegistry.getVisualID(view)) {
      case HandlerEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getHandler_79ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case AnswerEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getAnswer_1001ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case AssignmentEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getAssignment_1002ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case ChoiceEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getChoice_1003ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case GetFullVariableEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getGetFullVariable_1004ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case MultiStreamAudioEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getMultiStreamAudio_1005ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case HangupEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getHangup_1006ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case IfThenEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getIfThen_1007ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case RecordFileEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getRecordFile_1008ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SayAlphaEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSayAlpha_1009ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SayDateTimeEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSayDateTime_1010ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SayDigitsEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSayDigits_1011ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SayNumberEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSayNumber_1012ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SayPhoneticEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSayPhonetic_1013ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SayTimeEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSayTime_1014ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetAutoHangupEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetAutoHangup_1015ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetCallerIdEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetCallerId_1016ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetChannelVariableEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetChannelVariable_1017ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetContextEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetContext_1018ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetExtensionEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetExtension_1019ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case StopMusicOnHoldEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getStopMusicOnHold_1020ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetMusicOnEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetMusicOn_1021ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetPriorityEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetPriority_1022ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case StreamAudioEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getStreamAudio_1023ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case WaitForDigitEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getWaitForDigit_1024ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case DIDMatcherEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getDIDMatcher_1025ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case GetDigitsEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getGetDigits_1026ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case OriginateCallEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getOriginateCall_1027ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case PlayDTMFEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getPlayDTMF_1028ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case RecordCallEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getRecordCall_1029ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case ExecuteApplicationEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getExecuteApplication_1030ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case PlayMusicOnHoldEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getPlayMusicOnHold_1031ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case PromptGetDigitsEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getPromptGetDigits_1032ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SleepEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSleep_1033ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case StreamAudioExtendedEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getStreamAudioExtended_1034ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case IncomingCallEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getIncomingCall_1035ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case GetCallInfoEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getGetCallInfo_1036ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case ExecuteScriptEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getExecuteScript_1037ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case InvokeSafletEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getInvokeSaflet_1038ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case DialEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getDial_1039ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case PickupEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getPickup_1040ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case BackgroundEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getBackground_1041ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case BackgroundDetectEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getBackgroundDetect_1042ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case WaitExtenEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getWaitExten_1043ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SoftHangupEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSoftHangup_1044ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case PickupChanEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getPickupChan_1045ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case PickdownEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getPickdown_1046ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case ProgressEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getProgress_1047ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case BridgeEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getBridge_1048ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case PlaceCallEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getPlaceCall_1049ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case VoicemailEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getVoicemail_1050ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case VoicemailMainEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getVoicemailMain_1051ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case VMAuthenticateEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getVMAuthenticate_1052ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case MeetMeEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getMeetMe_1053ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case MeetMeAdminEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getMeetMeAdmin_1054ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case MeetMeCountEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getMeetMeCount_1055ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case DebugLogEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getDebugLog_1056ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case WaitForRingEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getWaitForRing_1057ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case WaitMusicOnHoldEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getWaitMusicOnHold_1058ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case GetAvailableChannelEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getGetAvailableChannel_1059ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case CongestionEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getCongestion_1060ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case RingingEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getRinging_1061ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetCallerPresentationEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetCallerPresentation_1062ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetGlobalVariableEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetGlobalVariable_1063ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case EchoEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getEcho_1064ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case FestivalEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getFestival_1065ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case PlaytonesEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getPlaytones_1066ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case StopPlaytonesEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getStopPlaytones_1067ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case ChanSpyEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getChanSpy_1068ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case DictateEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getDictate_1069ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case ExtensionSpyEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getExtensionSpy_1070ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case MixMonitorEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getMixMonitor_1071ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case StopMixmonitorEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getStopMixmonitor_1072ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case StopMonitorEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getStopMonitor_1073ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case MonitorEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getMonitor_1074ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case DirectoryEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getDirectory_1075ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case TransferEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getTransfer_1076ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case OpenDBConnectionEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getOpenDBConnection_1077ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case CloseDBConnectionEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getCloseDBConnection_1078ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case OpenQueryEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getOpenQuery_1079ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetQueryParamEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetQueryParam_1080ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case ExecuteUpdateEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getExecuteUpdate_1081ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case ExecuteQueryEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getExecuteQuery_1082ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case NextRowEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getNextRow_1083ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case GetColValueEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getGetColValue_1084ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetColValueEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetColValue_1085ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case UpdatetRowEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getUpdatetRow_1086ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case MoveToRowEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getMoveToRow_1087ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case MoveToLastRowEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getMoveToLastRow_1088ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case DeleteRowEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getDeleteRow_1089ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case MoveToInsertRowEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getMoveToInsertRow_1090ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case InsertRowEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getInsertRow_1091ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case MoveToFirstRowEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getMoveToFirstRow_1092ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case PreviousRowEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getPreviousRow_1093ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case GetColValuesEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getGetColValues_1094ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetColValuesEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetColValues_1095ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case ExtensionTransferEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getExtensionTransfer_1096ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case RunQueryEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getRunQuery_1097ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case OutputEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getOutput_2001ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case CaseItemEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getCaseItem_2002ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case AudioFileItemEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getAudioFileItem_2003ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case GetColMappingEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getGetColMapping_2004ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case SetColMappingEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getSetColMapping_2005ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      case QueryParamMappingEditPart.VISUAL_ID: {
        if (!domain2NotationMap.containsKey(view.getElement())) {
          result.addAll(AsteriskDiagramUpdater.getQueryParamMapping_2006ContainedLinks(view));
        }
        if (!domain2NotationMap.containsKey(view.getElement())
            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
          domain2NotationMap.put(view.getElement(), view);
        }
        break;
      }
      default: {
        if (view.getElement() instanceof CaseItem) {
          if (!domain2NotationMap.containsKey(view.getElement())) {
            result.addAll(AsteriskDiagramUpdater.getCaseItem_2002ContainedLinks(view));
          }
          if (!domain2NotationMap.containsKey(view.getElement())
              || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
            domain2NotationMap.put(view.getElement(), view);
          }
          // result.addAll(AsteriskDiagramUpdater.getCaseItem_2002ContainedLinks(view));
        }
      }
        // default: {
        // if (!domain2NotationMap.containsKey(view.getElement())) {
        // result.addAll(AsteriskDiagramUpdater.getDefaultActionstepIncomingLinks(view));
        // }
        // if (!domain2NotationMap.containsKey(view.getElement())
        // || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
        // domain2NotationMap.put(view.getElement(), view);
        // }
        // break;
        // }
    }

    for (Iterator children = view.getChildren().iterator(); children.hasNext();) {
      result.addAll(collectAllLinks((View) children.next(), domain2NotationMap));
    }
    for (Iterator edges = view.getSourceEdges().iterator(); edges.hasNext();) {
      result.addAll(collectAllLinks((View) edges.next(), domain2NotationMap));
    }
    return result;
  }

  /**
   * @generated
   */
  private Collection createConnections(Collection linkDescriptors, Map domain2NotationMap) {
    List adapters = new LinkedList();
    for (Iterator linkDescriptorsIterator = linkDescriptors.iterator(); linkDescriptorsIterator
        .hasNext();) {
      final AsteriskLinkDescriptor nextLinkDescriptor = (AsteriskLinkDescriptor) linkDescriptorsIterator
          .next();
      EditPart sourceEditPart = getEditPart(nextLinkDescriptor.getSource(), domain2NotationMap);
      EditPart targetEditPart = getEditPart(nextLinkDescriptor.getDestination(), domain2NotationMap);
      if (sourceEditPart == null || targetEditPart == null) {
        continue;
      }
      CreateConnectionViewRequest.ConnectionViewDescriptor descriptor = new CreateConnectionViewRequest.ConnectionViewDescriptor(
          nextLinkDescriptor.getSemanticAdapter(), null, ViewUtil.APPEND, false,
          ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint());
      CreateConnectionViewRequest ccr = new CreateConnectionViewRequest(descriptor);
      ccr.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_START);
      ccr.setSourceEditPart(sourceEditPart);
      sourceEditPart.getCommand(ccr);
      ccr.setTargetEditPart(targetEditPart);
      ccr.setType(org.eclipse.gef.RequestConstants.REQ_CONNECTION_END);
      Command cmd = targetEditPart.getCommand(ccr);
      if (cmd != null && cmd.canExecute()) {
        executeCommand(cmd);
        IAdaptable viewAdapter = (IAdaptable) ccr.getNewObject();
        if (viewAdapter != null) {
          adapters.add(viewAdapter);
        }
      }
    }
    return adapters;
  }

  /**
   * @generated
   */
  private EditPart getEditPart(EObject domainModelElement, Map domain2NotationMap) {
    View view = (View) domain2NotationMap.get(domainModelElement);
    if (view != null) {
      return (EditPart) getHost().getViewer().getEditPartRegistry().get(view);
    }
    return null;
  }
}
