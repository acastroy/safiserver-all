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
          case IfThenNameEditPart.VISUAL_ID:
            if (IfThenEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
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
          case DebugLogNameEditPart.VISUAL_ID:
            if (DebugLogEditPart.VISUAL_ID != AsteriskVisualIDRegistry.getVisualID(containerView)
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
      case AssignmentEditPart.VISUAL_ID:
        return AssignmentViewFactory.class;
      case AssignmentNameEditPart.VISUAL_ID:
        return AssignmentNameViewFactory.class;
      case ChoiceEditPart.VISUAL_ID:
        return ChoiceViewFactory.class;
      case ChoiceNameEditPart.VISUAL_ID:
        return ChoiceNameViewFactory.class;
      case IfThenEditPart.VISUAL_ID:
        return IfThenViewFactory.class;
      case IfThenNameEditPart.VISUAL_ID:
        return IfThenNameViewFactory.class;
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
      case DebugLogEditPart.VISUAL_ID:
        return DebugLogViewFactory.class;
      case DebugLogNameEditPart.VISUAL_ID:
        return DebugLogNameViewFactory.class;
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
