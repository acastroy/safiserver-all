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

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.Assignment;
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
import com.safi.core.saflet.Saflet;
import com.safi.workshop.edit.parts.AssignmentEditPart;
import com.safi.workshop.edit.parts.CaseItemEditPart;
import com.safi.workshop.edit.parts.CaseItemTargetToolstepEditPart;
import com.safi.workshop.edit.parts.ChoiceEditPart;
import com.safi.workshop.edit.parts.ChoiceItemPanelEditPart;
import com.safi.workshop.edit.parts.CloseDBConnectionEditPart;
import com.safi.workshop.edit.parts.DebugLogEditPart;
import com.safi.workshop.edit.parts.DeleteRowEditPart;
import com.safi.workshop.edit.parts.ExecuteQueryEditPart;
import com.safi.workshop.edit.parts.ExecuteScriptEditPart;
import com.safi.workshop.edit.parts.ExecuteUpdateEditPart;
import com.safi.workshop.edit.parts.GetColMappingEditPart;
import com.safi.workshop.edit.parts.GetColValueEditPart;
import com.safi.workshop.edit.parts.GetColValuesEditPart;
import com.safi.workshop.edit.parts.GetColValuesValuesPanelEditPart;
import com.safi.workshop.edit.parts.HandlerEditPart;
import com.safi.workshop.edit.parts.IfThenEditPart;
import com.safi.workshop.edit.parts.InsertRowEditPart;
import com.safi.workshop.edit.parts.InvokeSafletEditPart;
import com.safi.workshop.edit.parts.MoveToFirstRowEditPart;
import com.safi.workshop.edit.parts.MoveToInsertRowEditPart;
import com.safi.workshop.edit.parts.MoveToLastRowEditPart;
import com.safi.workshop.edit.parts.MoveToRowEditPart;
import com.safi.workshop.edit.parts.NextRowEditPart;
import com.safi.workshop.edit.parts.OpenDBConnectionEditPart;
import com.safi.workshop.edit.parts.OpenQueryEditPart;
import com.safi.workshop.edit.parts.OutputEditPart;
import com.safi.workshop.edit.parts.OutputTargetEditPart;
import com.safi.workshop.edit.parts.PreviousRowEditPart;
import com.safi.workshop.edit.parts.QueryParamMappingEditPart;
import com.safi.workshop.edit.parts.RunQueryEditPart;
import com.safi.workshop.edit.parts.RunQueryRunQueryValuesPanelEditPart;
import com.safi.workshop.edit.parts.SetColMappingEditPart;
import com.safi.workshop.edit.parts.SetColValueEditPart;
import com.safi.workshop.edit.parts.SetColValuesEditPart;
import com.safi.workshop.edit.parts.SetColValuesValuesPanelEditPart;
import com.safi.workshop.edit.parts.SetQueryParamEditPart;
import com.safi.workshop.edit.parts.UpdatetRowEditPart;
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
      case AssignmentEditPart.VISUAL_ID:
        return getAssignment_1002SemanticChildren(view);
      case ChoiceEditPart.VISUAL_ID:
        return getChoice_1003SemanticChildren(view);
      case IfThenEditPart.VISUAL_ID:
        return getIfThen_1007SemanticChildren(view);
      case ExecuteScriptEditPart.VISUAL_ID:
        return getExecuteScript_1037SemanticChildren(view);
      case InvokeSafletEditPart.VISUAL_ID:
        return getInvokeSaflet_1038SemanticChildren(view);
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
      case RunQueryEditPart.VISUAL_ID:
        return getRunQuery_1097SemanticChildren(view);
      case ChoiceItemPanelEditPart.VISUAL_ID:
        return getChoiceItemPanel_5001SemanticChildren(view);
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

//  /**
//   * @generated
//   */
//  public static List getMultiStreamAudioFilesPanel_5002SemanticChildren(View view) {
//    if (false == view.eContainer() instanceof View) {
//      return Collections.EMPTY_LIST;
//    }
//    View containerView = (View) view.eContainer();
//    if (!containerView.isSetElement()) {
//      return Collections.EMPTY_LIST;
//    }
//    MultiStreamAudio modelElement = (MultiStreamAudio) containerView.getElement();
//    List result = new LinkedList();
//    for (Object element : modelElement.getAudioFilenames()) {
//      AudioFileItem childElement = (AudioFileItem) element;
//      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
//      if (visualID == AudioFileItemEditPart.VISUAL_ID) {
//        result.add(new AsteriskNodeDescriptor(childElement, visualID));
//        continue;
//      }
//    }
//    return result;
//  }

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
      
      if (visualID == AssignmentEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
      if (visualID == ChoiceEditPart.VISUAL_ID) {
        result.add(new AsteriskNodeDescriptor(childElement, visualID));
        continue;
      }
     
      if (visualID == IfThenEditPart.VISUAL_ID) {
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
      if (visualID == DebugLogEditPart.VISUAL_ID) {
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
//    {
//      Initiator childElement = modelElement.getInitiator();
//      int visualID = AsteriskVisualIDRegistry.getNodeVisualID(view, childElement);
//      if (visualID == DIDMatcherEditPart.VISUAL_ID) {
//        result.add(new AsteriskNodeDescriptor(childElement, visualID));
//      }
//      if (visualID == IncomingCallEditPart.VISUAL_ID) {
//        result.add(new AsteriskNodeDescriptor(childElement, visualID));
//      }
//    }
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
      case ChoiceEditPart.VISUAL_ID:
        return getChoice_1003ContainedLinks(view);
      case IfThenEditPart.VISUAL_ID:
        return getIfThen_1007ContainedLinks(view);
      case ExecuteScriptEditPart.VISUAL_ID:
        return getExecuteScript_1037ContainedLinks(view);
      case InvokeSafletEditPart.VISUAL_ID:
        return getInvokeSaflet_1038ContainedLinks(view);
      case DebugLogEditPart.VISUAL_ID:
        return getDebugLog_1056ContainedLinks(view);

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
      case RunQueryEditPart.VISUAL_ID:
        return getRunQuery_1097ContainedLinks(view);
      case OutputEditPart.VISUAL_ID:
        return getOutput_2001ContainedLinks(view);
      case CaseItemEditPart.VISUAL_ID:
        return getCaseItem_2002ContainedLinks(view);
//      case AudioFileItemEditPart.VISUAL_ID:
//        return getAudioFileItem_2003ContainedLinks(view);
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
      case AssignmentEditPart.VISUAL_ID:
        return getAssignment_1002IncomingLinks(view);
      case ChoiceEditPart.VISUAL_ID:
        return getChoice_1003IncomingLinks(view);
       case IfThenEditPart.VISUAL_ID:
        return getIfThen_1007IncomingLinks(view);
      case ExecuteScriptEditPart.VISUAL_ID:
        return getExecuteScript_1037IncomingLinks(view);
      case InvokeSafletEditPart.VISUAL_ID:
        return getInvokeSaflet_1038IncomingLinks(view);
      case DebugLogEditPart.VISUAL_ID:
        return getDebugLog_1056IncomingLinks(view);
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
      case RunQueryEditPart.VISUAL_ID:
        return getRunQuery_1097IncomingLinks(view);
      case OutputEditPart.VISUAL_ID:
        return getOutput_2001IncomingLinks(view);
      case CaseItemEditPart.VISUAL_ID:
        return getCaseItem_2002IncomingLinks(view);
 
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
      case AssignmentEditPart.VISUAL_ID:
        return getAssignment_1002OutgoingLinks(view);
      case ChoiceEditPart.VISUAL_ID:
        return getChoice_1003OutgoingLinks(view);
      case IfThenEditPart.VISUAL_ID:
        return getIfThen_1007OutgoingLinks(view);
      case ExecuteScriptEditPart.VISUAL_ID:
        return getExecuteScript_1037OutgoingLinks(view);
      case InvokeSafletEditPart.VISUAL_ID:
        return getInvokeSaflet_1038OutgoingLinks(view);
      case DebugLogEditPart.VISUAL_ID:
        return getDebugLog_1056OutgoingLinks(view);
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
      case RunQueryEditPart.VISUAL_ID:
        return getRunQuery_1097OutgoingLinks(view);
      case OutputEditPart.VISUAL_ID:
        return getOutput_2001OutgoingLinks(view);
      case CaseItemEditPart.VISUAL_ID:
        return getCaseItem_2002OutgoingLinks(view);
//      case AudioFileItemEditPart.VISUAL_ID:
//        return getAudioFileItem_2003OutgoingLinks(view);
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
//
//  /**
//   * @generated
//   */
//  public static List getAudioFileItem_2003ContainedLinks(View view) {
//    AudioFileItem modelElement = (AudioFileItem) view.getElement();
//    List result = new LinkedList();
//    result.addAll(getOutgoingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement));
//    return result;
//  }

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
//
//  /**
//   * @generated
//   */
//  public static List getAudioFileItem_2003OutgoingLinks(View view) {
//    AudioFileItem modelElement = (AudioFileItem) view.getElement();
//    List result = new LinkedList();
//    result.addAll(getOutgoingFeatureModelFacetLinks_CaseItem_TargetToolstep_3003(modelElement));
//    return result;
//  }

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
