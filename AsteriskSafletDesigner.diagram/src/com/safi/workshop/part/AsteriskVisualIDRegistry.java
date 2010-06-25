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
      case IfThenEditPart.VISUAL_ID:
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
      case DebugLogEditPart.VISUAL_ID:
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
      case HandlerEditPart.VISUAL_ID:
        
        if (ActionStepPackage.eINSTANCE.getAssignment().isSuperTypeOf(domainElement.eClass())) {
          return AssignmentEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getChoice().isSuperTypeOf(domainElement.eClass())) {
          return ChoiceEditPart.VISUAL_ID;
        }

        if (ActionStepPackage.eINSTANCE.getIfThen().isSuperTypeOf(domainElement.eClass())) {
          return IfThenEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getExecuteScript().isSuperTypeOf(domainElement.eClass())) {
          return ExecuteScriptEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getInvokeSaflet().isSuperTypeOf(domainElement.eClass())) {
          return InvokeSafletEditPart.VISUAL_ID;
        }
        if (ActionStepPackage.eINSTANCE.getDebugLog().isSuperTypeOf(domainElement.eClass())) {
          return DebugLogEditPart.VISUAL_ID;
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
       if (ActionStepPackage.eINSTANCE.getRunQuery().isSuperTypeOf(domainElement.eClass())) {
          return RunQueryEditPart.VISUAL_ID;
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
      case IfThenEditPart.VISUAL_ID:
        if (IfThenNameEditPart.VISUAL_ID == nodeVisualID) {
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
      case DebugLogEditPart.VISUAL_ID:
        if (DebugLogNameEditPart.VISUAL_ID == nodeVisualID) {
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
        if (AssignmentEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ChoiceEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (IfThenEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (ExecuteScriptEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (InvokeSafletEditPart.VISUAL_ID == nodeVisualID) {
          return true;
        }
        if (DebugLogEditPart.VISUAL_ID == nodeVisualID) {
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
