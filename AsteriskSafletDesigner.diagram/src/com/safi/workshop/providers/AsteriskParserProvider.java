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

//  /**
//   * @generated
//   */
//  private IParser getAudioFileItemLabelText_4006Parser() {
//    if (audioFileItemLabelText_4006Parser == null) {
//      audioFileItemLabelText_4006Parser = createAudioFileItemLabelText_4006Parser();
//    }
//    return audioFileItemLabelText_4006Parser;
//  }
//
//  /**
//   * @generated
//   */
//  protected IParser createAudioFileItemLabelText_4006Parser() {
//    EAttribute[] features = new EAttribute[] { ActionStepPackage.eINSTANCE.getItem_LabelText(), };
//    MessageFormatParser parser = new MessageFormatParser(features);
//    return parser;
//  }

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
      case AssignmentNameEditPart.VISUAL_ID:
        return getAssignmentName_4002Parser();
      case ChoiceNameEditPart.VISUAL_ID:
        return getChoiceName_4004Parser();
      case IfThenNameEditPart.VISUAL_ID:
        return getIfThenName_4009Parser();
     case ExecuteScriptNameEditPart.VISUAL_ID:
        return getExecuteScriptName_4039Parser();
      case InvokeSafletNameEditPart.VISUAL_ID:
        return getInvokeSafletName_4040Parser();
      case InvokeSafletLabelTextEditPart.VISUAL_ID:
        return getInvokeSafletLabelText_4041Parser();
      case DebugLogNameEditPart.VISUAL_ID:
        return getDebugLogName_4059Parser();
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
      case RunQueryNameEditPart.VISUAL_ID:
        return getRunQueryName_4103Parser();
      case CaseItemLabelTextEditPart.VISUAL_ID:
        return getCaseItemLabelText_4003Parser();
//      case AudioFileItemLabelTextEditPart.VISUAL_ID:
//        return getAudioFileItemLabelText_4006Parser();
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
