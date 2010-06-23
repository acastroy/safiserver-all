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
      case AssignmentEditPart.VISUAL_ID:
      case ChoiceEditPart.VISUAL_ID:
      case IfThenEditPart.VISUAL_ID:
      case ExecuteScriptEditPart.VISUAL_ID:
      case InvokeSafletEditPart.VISUAL_ID:
      case DebugLogEditPart.VISUAL_ID:
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
//      case AudioFileItemEditPart.VISUAL_ID: {
//        if (!domain2NotationMap.containsKey(view.getElement())) {
//          result.addAll(AsteriskDiagramUpdater.getAudioFileItem_2003ContainedLinks(view));
//        }
//        if (!domain2NotationMap.containsKey(view.getElement())
//            || view.getEAnnotation("Shortcut") == null) { //$NON-NLS-1$
//          domain2NotationMap.put(view.getElement(), view);
//        }
//        break;
//      }
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
