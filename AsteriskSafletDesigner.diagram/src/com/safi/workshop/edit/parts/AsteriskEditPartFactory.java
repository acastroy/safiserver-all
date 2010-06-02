package com.safi.workshop.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated
 */
public class AsteriskEditPartFactory implements EditPartFactory {

  /**
   * @generated
   */
  public EditPart createEditPart(EditPart context, Object model) {
    if (model instanceof View) {
      View view = (View) model;
      int visualID = AsteriskVisualIDRegistry.getVisualID(view);
      switch (visualID) {

        case HandlerEditPart.VISUAL_ID:
          return new HandlerEditPart(view);

        case AnswerEditPart.VISUAL_ID:
          return new AnswerEditPart(view);

        case AnswerNameEditPart.VISUAL_ID:
          return new AnswerNameEditPart(view);

        case AssignmentEditPart.VISUAL_ID:
          return new AssignmentEditPart(view);

        case AssignmentNameEditPart.VISUAL_ID:
          return new AssignmentNameEditPart(view);

        case ChoiceEditPart.VISUAL_ID:
          return new ChoiceEditPart(view);

        case ChoiceNameEditPart.VISUAL_ID:
          return new ChoiceNameEditPart(view);

        case GetFullVariableEditPart.VISUAL_ID:
          return new GetFullVariableEditPart(view);

        case GetFullVariableNameEditPart.VISUAL_ID:
          return new GetFullVariableNameEditPart(view);

        case MultiStreamAudioEditPart.VISUAL_ID:
          return new MultiStreamAudioEditPart(view);

        case MultiStreamAudioNameEditPart.VISUAL_ID:
          return new MultiStreamAudioNameEditPart(view);

        case HangupEditPart.VISUAL_ID:
          return new HangupEditPart(view);

        case HangupNameEditPart.VISUAL_ID:
          return new HangupNameEditPart(view);

        case IfThenEditPart.VISUAL_ID:
          return new IfThenEditPart(view);

        case IfThenNameEditPart.VISUAL_ID:
          return new IfThenNameEditPart(view);

        case RecordFileEditPart.VISUAL_ID:
          return new RecordFileEditPart(view);

        case RecordFileNameEditPart.VISUAL_ID:
          return new RecordFileNameEditPart(view);

        case SayAlphaEditPart.VISUAL_ID:
          return new SayAlphaEditPart(view);

        case SayAlphaNameEditPart.VISUAL_ID:
          return new SayAlphaNameEditPart(view);

        case SayDateTimeEditPart.VISUAL_ID:
          return new SayDateTimeEditPart(view);

        case SayDateTimeNameEditPart.VISUAL_ID:
          return new SayDateTimeNameEditPart(view);

        case SayDigitsEditPart.VISUAL_ID:
          return new SayDigitsEditPart(view);

        case SayDigitsNameEditPart.VISUAL_ID:
          return new SayDigitsNameEditPart(view);

        case SayNumberEditPart.VISUAL_ID:
          return new SayNumberEditPart(view);

        case SayNumberNameEditPart.VISUAL_ID:
          return new SayNumberNameEditPart(view);

        case SayPhoneticEditPart.VISUAL_ID:
          return new SayPhoneticEditPart(view);

        case SayPhoneticNameEditPart.VISUAL_ID:
          return new SayPhoneticNameEditPart(view);

        case SayTimeEditPart.VISUAL_ID:
          return new SayTimeEditPart(view);

        case SayTimeNameEditPart.VISUAL_ID:
          return new SayTimeNameEditPart(view);

        case SetAutoHangupEditPart.VISUAL_ID:
          return new SetAutoHangupEditPart(view);

        case SetAutoHangupNameEditPart.VISUAL_ID:
          return new SetAutoHangupNameEditPart(view);

        case SetCallerIdEditPart.VISUAL_ID:
          return new SetCallerIdEditPart(view);

        case SetCallerIdNameEditPart.VISUAL_ID:
          return new SetCallerIdNameEditPart(view);

        case SetChannelVariableEditPart.VISUAL_ID:
          return new SetChannelVariableEditPart(view);

        case SetChannelVariableNameEditPart.VISUAL_ID:
          return new SetChannelVariableNameEditPart(view);

        case SetContextEditPart.VISUAL_ID:
          return new SetContextEditPart(view);

        case SetContextNameEditPart.VISUAL_ID:
          return new SetContextNameEditPart(view);

        case SetExtensionEditPart.VISUAL_ID:
          return new SetExtensionEditPart(view);

        case SetExtensionNameEditPart.VISUAL_ID:
          return new SetExtensionNameEditPart(view);

        case StopMusicOnHoldEditPart.VISUAL_ID:
          return new StopMusicOnHoldEditPart(view);

        case StopMusicOnHoldNameEditPart.VISUAL_ID:
          return new StopMusicOnHoldNameEditPart(view);

        case SetMusicOnEditPart.VISUAL_ID:
          return new SetMusicOnEditPart(view);

        case SetMusicOnNameEditPart.VISUAL_ID:
          return new SetMusicOnNameEditPart(view);

        case SetPriorityEditPart.VISUAL_ID:
          return new SetPriorityEditPart(view);

        case SetPriorityNameEditPart.VISUAL_ID:
          return new SetPriorityNameEditPart(view);

        case StreamAudioEditPart.VISUAL_ID:
          return new StreamAudioEditPart(view);

        case StreamAudioNameEditPart.VISUAL_ID:
          return new StreamAudioNameEditPart(view);

        case WaitForDigitEditPart.VISUAL_ID:
          return new WaitForDigitEditPart(view);

        case WaitForDigitNameEditPart.VISUAL_ID:
          return new WaitForDigitNameEditPart(view);

        case DIDMatcherEditPart.VISUAL_ID:
          return new DIDMatcherEditPart(view);

        case DIDMatcherNameEditPart.VISUAL_ID:
          return new DIDMatcherNameEditPart(view);

        case GetDigitsEditPart.VISUAL_ID:
          return new GetDigitsEditPart(view);

        case GetDigitsNameEditPart.VISUAL_ID:
          return new GetDigitsNameEditPart(view);

        case OriginateCallEditPart.VISUAL_ID:
          return new OriginateCallEditPart(view);

        case OriginateCallNameEditPart.VISUAL_ID:
          return new OriginateCallNameEditPart(view);

        case PlayDTMFEditPart.VISUAL_ID:
          return new PlayDTMFEditPart(view);

        case PlayDTMFNameEditPart.VISUAL_ID:
          return new PlayDTMFNameEditPart(view);

        case RecordCallEditPart.VISUAL_ID:
          return new RecordCallEditPart(view);

        case RecordCallNameEditPart.VISUAL_ID:
          return new RecordCallNameEditPart(view);

        case ExecuteApplicationEditPart.VISUAL_ID:
          return new ExecuteApplicationEditPart(view);

        case ExecuteApplicationNameEditPart.VISUAL_ID:
          return new ExecuteApplicationNameEditPart(view);

        case PlayMusicOnHoldEditPart.VISUAL_ID:
          return new PlayMusicOnHoldEditPart(view);

        case PlayMusicOnHoldNameEditPart.VISUAL_ID:
          return new PlayMusicOnHoldNameEditPart(view);

        case PromptGetDigitsEditPart.VISUAL_ID:
          return new PromptGetDigitsEditPart(view);

        case PromptGetDigitsNameEditPart.VISUAL_ID:
          return new PromptGetDigitsNameEditPart(view);

        case SleepEditPart.VISUAL_ID:
          return new SleepEditPart(view);

        case SleepNameEditPart.VISUAL_ID:
          return new SleepNameEditPart(view);

        case StreamAudioExtendedEditPart.VISUAL_ID:
          return new StreamAudioExtendedEditPart(view);

        case StreamAudioExtendedNameEditPart.VISUAL_ID:
          return new StreamAudioExtendedNameEditPart(view);

        case IncomingCallEditPart.VISUAL_ID:
          return new IncomingCallEditPart(view);

        case IncomingCallNameEditPart.VISUAL_ID:
          return new IncomingCallNameEditPart(view);

        case GetCallInfoEditPart.VISUAL_ID:
          return new GetCallInfoEditPart(view);

        case GetCallInfoNameEditPart.VISUAL_ID:
          return new GetCallInfoNameEditPart(view);

        case ExecuteScriptEditPart.VISUAL_ID:
          return new ExecuteScriptEditPart(view);

        case ExecuteScriptNameEditPart.VISUAL_ID:
          return new ExecuteScriptNameEditPart(view);

        case InvokeSafletEditPart.VISUAL_ID:
          return new InvokeSafletEditPart(view);

        case InvokeSafletNameEditPart.VISUAL_ID:
          return new InvokeSafletNameEditPart(view);

        case InvokeSafletLabelTextEditPart.VISUAL_ID:
          return new InvokeSafletLabelTextEditPart(view);

        case DialEditPart.VISUAL_ID:
          return new DialEditPart(view);

        case DialNameEditPart.VISUAL_ID:
          return new DialNameEditPart(view);

        case PickupEditPart.VISUAL_ID:
          return new PickupEditPart(view);

        case PickupNameEditPart.VISUAL_ID:
          return new PickupNameEditPart(view);

        case BackgroundEditPart.VISUAL_ID:
          return new BackgroundEditPart(view);

        case BackgroundNameEditPart.VISUAL_ID:
          return new BackgroundNameEditPart(view);

        case BackgroundDetectEditPart.VISUAL_ID:
          return new BackgroundDetectEditPart(view);

        case BackgroundDetectNameEditPart.VISUAL_ID:
          return new BackgroundDetectNameEditPart(view);

        case WaitExtenEditPart.VISUAL_ID:
          return new WaitExtenEditPart(view);

        case WaitExtenNameEditPart.VISUAL_ID:
          return new WaitExtenNameEditPart(view);

        case SoftHangupEditPart.VISUAL_ID:
          return new SoftHangupEditPart(view);

        case SoftHangupNameEditPart.VISUAL_ID:
          return new SoftHangupNameEditPart(view);

        case PickupChanEditPart.VISUAL_ID:
          return new PickupChanEditPart(view);

        case PickupChanNameEditPart.VISUAL_ID:
          return new PickupChanNameEditPart(view);

        case PickdownEditPart.VISUAL_ID:
          return new PickdownEditPart(view);

        case PickdownNameEditPart.VISUAL_ID:
          return new PickdownNameEditPart(view);

        case ProgressEditPart.VISUAL_ID:
          return new ProgressEditPart(view);

        case ProgressNameEditPart.VISUAL_ID:
          return new ProgressNameEditPart(view);

        case BridgeEditPart.VISUAL_ID:
          return new BridgeEditPart(view);

        case BridgeNameEditPart.VISUAL_ID:
          return new BridgeNameEditPart(view);

        case PlaceCallEditPart.VISUAL_ID:
          return new PlaceCallEditPart(view);

        case PlaceCallNameEditPart.VISUAL_ID:
          return new PlaceCallNameEditPart(view);

        case VoicemailEditPart.VISUAL_ID:
          return new VoicemailEditPart(view);

        case VoicemailNameEditPart.VISUAL_ID:
          return new VoicemailNameEditPart(view);

        case VoicemailMainEditPart.VISUAL_ID:
          return new VoicemailMainEditPart(view);

        case VoicemailMainNameEditPart.VISUAL_ID:
          return new VoicemailMainNameEditPart(view);

        case VMAuthenticateEditPart.VISUAL_ID:
          return new VMAuthenticateEditPart(view);

        case VMAuthenticateNameEditPart.VISUAL_ID:
          return new VMAuthenticateNameEditPart(view);

        case MeetMeEditPart.VISUAL_ID:
          return new MeetMeEditPart(view);

        case MeetMeNameEditPart.VISUAL_ID:
          return new MeetMeNameEditPart(view);

        case MeetMeAdminEditPart.VISUAL_ID:
          return new MeetMeAdminEditPart(view);

        case MeetMeAdminNameEditPart.VISUAL_ID:
          return new MeetMeAdminNameEditPart(view);

        case MeetMeCountEditPart.VISUAL_ID:
          return new MeetMeCountEditPart(view);

        case MeetMeCountNameEditPart.VISUAL_ID:
          return new MeetMeCountNameEditPart(view);

        case DebugLogEditPart.VISUAL_ID:
          return new DebugLogEditPart(view);

        case DebugLogNameEditPart.VISUAL_ID:
          return new DebugLogNameEditPart(view);

        case WaitForRingEditPart.VISUAL_ID:
          return new WaitForRingEditPart(view);

        case WaitForRingNameEditPart.VISUAL_ID:
          return new WaitForRingNameEditPart(view);

        case WaitMusicOnHoldEditPart.VISUAL_ID:
          return new WaitMusicOnHoldEditPart(view);

        case WaitMusicOnHoldNameEditPart.VISUAL_ID:
          return new WaitMusicOnHoldNameEditPart(view);

        case GetAvailableChannelEditPart.VISUAL_ID:
          return new GetAvailableChannelEditPart(view);

        case GetAvailableChannelNameEditPart.VISUAL_ID:
          return new GetAvailableChannelNameEditPart(view);

        case CongestionEditPart.VISUAL_ID:
          return new CongestionEditPart(view);

        case CongestionNameEditPart.VISUAL_ID:
          return new CongestionNameEditPart(view);

        case RingingEditPart.VISUAL_ID:
          return new RingingEditPart(view);

        case RingingNameEditPart.VISUAL_ID:
          return new RingingNameEditPart(view);

        case SetCallerPresentationEditPart.VISUAL_ID:
          return new SetCallerPresentationEditPart(view);

        case SetCallerPresentationNameEditPart.VISUAL_ID:
          return new SetCallerPresentationNameEditPart(view);

        case SetGlobalVariableEditPart.VISUAL_ID:
          return new SetGlobalVariableEditPart(view);

        case SetGlobalVariableNameEditPart.VISUAL_ID:
          return new SetGlobalVariableNameEditPart(view);

        case EchoEditPart.VISUAL_ID:
          return new EchoEditPart(view);

        case EchoNameEditPart.VISUAL_ID:
          return new EchoNameEditPart(view);

        case FestivalEditPart.VISUAL_ID:
          return new FestivalEditPart(view);

        case FestivalNameEditPart.VISUAL_ID:
          return new FestivalNameEditPart(view);

        case PlaytonesEditPart.VISUAL_ID:
          return new PlaytonesEditPart(view);

        case PlaytonesNameEditPart.VISUAL_ID:
          return new PlaytonesNameEditPart(view);

        case StopPlaytonesEditPart.VISUAL_ID:
          return new StopPlaytonesEditPart(view);

        case StopPlaytonesNameEditPart.VISUAL_ID:
          return new StopPlaytonesNameEditPart(view);

        case ChanSpyEditPart.VISUAL_ID:
          return new ChanSpyEditPart(view);

        case ChanSpyNameEditPart.VISUAL_ID:
          return new ChanSpyNameEditPart(view);

        case DictateEditPart.VISUAL_ID:
          return new DictateEditPart(view);

        case DictateNameEditPart.VISUAL_ID:
          return new DictateNameEditPart(view);

        case ExtensionSpyEditPart.VISUAL_ID:
          return new ExtensionSpyEditPart(view);

        case ExtensionSpyNameEditPart.VISUAL_ID:
          return new ExtensionSpyNameEditPart(view);

        case MixMonitorEditPart.VISUAL_ID:
          return new MixMonitorEditPart(view);

        case MixMonitorNameEditPart.VISUAL_ID:
          return new MixMonitorNameEditPart(view);

        case StopMixmonitorEditPart.VISUAL_ID:
          return new StopMixmonitorEditPart(view);

        case StopMixmonitorNameEditPart.VISUAL_ID:
          return new StopMixmonitorNameEditPart(view);

        case StopMonitorEditPart.VISUAL_ID:
          return new StopMonitorEditPart(view);

        case StopMonitorNameEditPart.VISUAL_ID:
          return new StopMonitorNameEditPart(view);

        case MonitorEditPart.VISUAL_ID:
          return new MonitorEditPart(view);

        case MonitorNameEditPart.VISUAL_ID:
          return new MonitorNameEditPart(view);

        case DirectoryEditPart.VISUAL_ID:
          return new DirectoryEditPart(view);

        case DirectoryNameEditPart.VISUAL_ID:
          return new DirectoryNameEditPart(view);

        case TransferEditPart.VISUAL_ID:
          return new TransferEditPart(view);

        case TransferNameEditPart.VISUAL_ID:
          return new TransferNameEditPart(view);

        case OpenDBConnectionEditPart.VISUAL_ID:
          return new OpenDBConnectionEditPart(view);

        case OpenDBConnectionNameEditPart.VISUAL_ID:
          return new OpenDBConnectionNameEditPart(view);

        case CloseDBConnectionEditPart.VISUAL_ID:
          return new CloseDBConnectionEditPart(view);

        case CloseDBConnectionNameEditPart.VISUAL_ID:
          return new CloseDBConnectionNameEditPart(view);

        case OpenQueryEditPart.VISUAL_ID:
          return new OpenQueryEditPart(view);

        case OpenQueryNameEditPart.VISUAL_ID:
          return new OpenQueryNameEditPart(view);

        case SetQueryParamEditPart.VISUAL_ID:
          return new SetQueryParamEditPart(view);

        case SetQueryParamNameEditPart.VISUAL_ID:
          return new SetQueryParamNameEditPart(view);

        case ExecuteUpdateEditPart.VISUAL_ID:
          return new ExecuteUpdateEditPart(view);

        case ExecuteUpdateNameEditPart.VISUAL_ID:
          return new ExecuteUpdateNameEditPart(view);

        case ExecuteQueryEditPart.VISUAL_ID:
          return new ExecuteQueryEditPart(view);

        case ExecuteQueryNameEditPart.VISUAL_ID:
          return new ExecuteQueryNameEditPart(view);

        case NextRowEditPart.VISUAL_ID:
          return new NextRowEditPart(view);

        case NextRowNameEditPart.VISUAL_ID:
          return new NextRowNameEditPart(view);

        case GetColValueEditPart.VISUAL_ID:
          return new GetColValueEditPart(view);

        case GetColValueNameEditPart.VISUAL_ID:
          return new GetColValueNameEditPart(view);

        case SetColValueEditPart.VISUAL_ID:
          return new SetColValueEditPart(view);

        case SetColValueNameEditPart.VISUAL_ID:
          return new SetColValueNameEditPart(view);

        case UpdatetRowEditPart.VISUAL_ID:
          return new UpdatetRowEditPart(view);

        case UpdatetRowNameEditPart.VISUAL_ID:
          return new UpdatetRowNameEditPart(view);

        case MoveToRowEditPart.VISUAL_ID:
          return new MoveToRowEditPart(view);

        case MoveToRowNameEditPart.VISUAL_ID:
          return new MoveToRowNameEditPart(view);

        case MoveToLastRowEditPart.VISUAL_ID:
          return new MoveToLastRowEditPart(view);

        case MoveToLastRowNameEditPart.VISUAL_ID:
          return new MoveToLastRowNameEditPart(view);

        case DeleteRowEditPart.VISUAL_ID:
          return new DeleteRowEditPart(view);

        case DeleteRowNameEditPart.VISUAL_ID:
          return new DeleteRowNameEditPart(view);

        case MoveToInsertRowEditPart.VISUAL_ID:
          return new MoveToInsertRowEditPart(view);

        case MoveToInsertRowNameEditPart.VISUAL_ID:
          return new MoveToInsertRowNameEditPart(view);

        case InsertRowEditPart.VISUAL_ID:
          return new InsertRowEditPart(view);

        case InsertRowNameEditPart.VISUAL_ID:
          return new InsertRowNameEditPart(view);

        case MoveToFirstRowEditPart.VISUAL_ID:
          return new MoveToFirstRowEditPart(view);

        case MoveToFirstRowNameEditPart.VISUAL_ID:
          return new MoveToFirstRowNameEditPart(view);

        case PreviousRowEditPart.VISUAL_ID:
          return new PreviousRowEditPart(view);

        case PreviousRowNameEditPart.VISUAL_ID:
          return new PreviousRowNameEditPart(view);

        case GetColValuesEditPart.VISUAL_ID:
          return new GetColValuesEditPart(view);

        case GetColValuesNameEditPart.VISUAL_ID:
          return new GetColValuesNameEditPart(view);

        case SetColValuesEditPart.VISUAL_ID:
          return new SetColValuesEditPart(view);

        case SetColValuesNameEditPart.VISUAL_ID:
          return new SetColValuesNameEditPart(view);

        case ExtensionTransferEditPart.VISUAL_ID:
          return new ExtensionTransferEditPart(view);

        case ExtensionTransferNameEditPart.VISUAL_ID:
          return new ExtensionTransferNameEditPart(view);

        case RunQueryEditPart.VISUAL_ID:
          return new RunQueryEditPart(view);

        case RunQueryNameEditPart.VISUAL_ID:
          return new RunQueryNameEditPart(view);

        case OutputEditPart.VISUAL_ID:
          return new OutputEditPart(view);

        case CaseItemEditPart.VISUAL_ID:
          return new CaseItemEditPart(view);

        case CaseItemLabelTextEditPart.VISUAL_ID:
          return new CaseItemLabelTextEditPart(view);

        case AudioFileItemEditPart.VISUAL_ID:
          return new AudioFileItemEditPart(view);

        case AudioFileItemLabelTextEditPart.VISUAL_ID:
          return new AudioFileItemLabelTextEditPart(view);

        case GetColMappingEditPart.VISUAL_ID:
          return new GetColMappingEditPart(view);

        case GetColMappingGetAsDatatypeEditPart.VISUAL_ID:
          return new GetColMappingGetAsDatatypeEditPart(view);

        case SetColMappingEditPart.VISUAL_ID:
          return new SetColMappingEditPart(view);

        case SetColMappingSetAsDatatypeEditPart.VISUAL_ID:
          return new SetColMappingSetAsDatatypeEditPart(view);

        case QueryParamMappingEditPart.VISUAL_ID:
          return new QueryParamMappingEditPart(view);

        case WrapLabelEditPart.VISUAL_ID:
          return new WrapLabelEditPart(view);

        case ChoiceItemPanelEditPart.VISUAL_ID:
          return new ChoiceItemPanelEditPart(view);

        case MultiStreamAudioFilesPanelEditPart.VISUAL_ID:
          return new MultiStreamAudioFilesPanelEditPart(view);

        case GetColValuesValuesPanelEditPart.VISUAL_ID:
          return new GetColValuesValuesPanelEditPart(view);

        case SetColValuesValuesPanelEditPart.VISUAL_ID:
          return new SetColValuesValuesPanelEditPart(view);

        case RunQueryRunQueryValuesPanelEditPart.VISUAL_ID:
          return new RunQueryRunQueryValuesPanelEditPart(view);

        case OutputTargetEditPart.VISUAL_ID:
          return new OutputTargetEditPart(view);

        case CaseItemTargetToolstepEditPart.VISUAL_ID:
          return new CaseItemTargetToolstepEditPart(view);
        default: {
          for (AsteriskDiagramEditorPlugin.ActionStepProfile p : AsteriskDiagramEditorPlugin
              .getInstance().getActionstepProfiles()) {
            String id = String.valueOf(visualID);
            if (p.semanticHint.equals(id) || p.labelSemanticHint.equals(id)
                || id.equals(p.inputItemLabelSemanticHint)
                || id.equals(p.inputItemPanelSemanticHint) || id.equals(p.inputItemSemanticHint)
                || id.equals(p.outputItemLabelSemanticHint)
                || id.equals(p.outputItemPanelSemanticHint) || id.equals(p.outputItemSemanticHint)) {
              return p.editPartFactory.createEditPart(view, visualID);
            }
          }
        }
      }
    }
    return createUnrecognizedEditPart(context, model);
  }

  /**
   * @generated
   */
  private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
    // Handle creation of unrecognized child node EditParts here
    // for (AsteriskDiagramEditorPlugin.ActionStepProfile a : AsteriskDiagramEditorPlugin
    // .getInstance().getActionstepProfiles()) {
    //
    // }
    return null;
  }

  /**
   * @generated
   */
  public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
    if (source.getFigure() instanceof WrapLabel)
      return new TextCellEditorLocator((WrapLabel) source.getFigure());
    else {
      return new LabelCellEditorLocator((Label) source.getFigure());
    }
  }

  /**
   * @generated
   */
  static private class TextCellEditorLocator implements CellEditorLocator {

    /**
     * @generated
     */
    private WrapLabel wrapLabel;

    /**
     * @generated
     */
    public TextCellEditorLocator(WrapLabel wrapLabel) {
      this.wrapLabel = wrapLabel;
    }

    /**
     * @generated
     */
    public WrapLabel getWrapLabel() {
      return wrapLabel;
    }

    /**
     * @generated
     */
    public void relocate(CellEditor celleditor) {
      Text text = (Text) celleditor.getControl();
      Rectangle rect = getWrapLabel().getTextBounds().getCopy();
      getWrapLabel().translateToAbsolute(rect);
      if (getWrapLabel().isTextWrapped() && getWrapLabel().getText().length() > 0) {
        rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
      } else {
        int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
        rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
      }
      if (!rect.equals(new Rectangle(text.getBounds()))) {
        text.setBounds(rect.x, rect.y, rect.width, rect.height);
      }
    }

  }

  /**
   * @generated
   */
  private static class LabelCellEditorLocator implements CellEditorLocator {

    /**
     * @generated
     */
    private Label label;

    /**
     * @generated
     */
    public LabelCellEditorLocator(Label label) {
      this.label = label;
    }

    /**
     * @generated
     */
    public Label getLabel() {
      return label;
    }

    /**
     * @generated
     */
    public void relocate(CellEditor celleditor) {
      Text text = (Text) celleditor.getControl();
      Rectangle rect = getLabel().getTextBounds().getCopy();
      getLabel().translateToAbsolute(rect);
      int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
      rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
      if (!rect.equals(new Rectangle(text.getBounds()))) {
        text.setBounds(rect.x, rect.y, rect.width, rect.height);
      }
    }
  }
}
