package com.safi.workshop.sheet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.safi.workshop.edit.parts.AnswerEditPart;
import com.safi.workshop.edit.parts.AssignmentEditPart;
import com.safi.workshop.edit.parts.ChanSpyEditPart;
import com.safi.workshop.edit.parts.ChoiceEditPart;
import com.safi.workshop.edit.parts.CloseDBConnectionEditPart;
import com.safi.workshop.edit.parts.CongestionEditPart;
import com.safi.workshop.edit.parts.DebugLogEditPart;
import com.safi.workshop.edit.parts.DeleteRowEditPart;
import com.safi.workshop.edit.parts.DictateEditPart;
import com.safi.workshop.edit.parts.DirectoryEditPart;
import com.safi.workshop.edit.parts.EchoEditPart;
import com.safi.workshop.edit.parts.ExecuteApplicationEditPart;
import com.safi.workshop.edit.parts.ExecuteScriptEditPart;
import com.safi.workshop.edit.parts.ExecuteUpdateEditPart;
import com.safi.workshop.edit.parts.ExtensionSpyEditPart;
import com.safi.workshop.edit.parts.ExtensionTransferEditPart;
import com.safi.workshop.edit.parts.FestivalEditPart;
import com.safi.workshop.edit.parts.GetCallInfoEditPart;
import com.safi.workshop.edit.parts.GetColValueEditPart;
import com.safi.workshop.edit.parts.GetColValuesEditPart;
import com.safi.workshop.edit.parts.GetDigitsEditPart;
import com.safi.workshop.edit.parts.GetFullVariableEditPart;
import com.safi.workshop.edit.parts.HangupEditPart;
import com.safi.workshop.edit.parts.IfThenEditPart;
import com.safi.workshop.edit.parts.InsertRowEditPart;
import com.safi.workshop.edit.parts.MeetMeAdminEditPart;
import com.safi.workshop.edit.parts.MeetMeCountEditPart;
import com.safi.workshop.edit.parts.MeetMeEditPart;
import com.safi.workshop.edit.parts.MonitorEditPart;
import com.safi.workshop.edit.parts.MoveToFirstRowEditPart;
import com.safi.workshop.edit.parts.MoveToInsertRowEditPart;
import com.safi.workshop.edit.parts.MoveToLastRowEditPart;
import com.safi.workshop.edit.parts.MoveToRowEditPart;
import com.safi.workshop.edit.parts.MultiStreamAudioEditPart;
import com.safi.workshop.edit.parts.NextRowEditPart;
import com.safi.workshop.edit.parts.OpenDBConnectionEditPart;
import com.safi.workshop.edit.parts.OriginateCallEditPart;
import com.safi.workshop.edit.parts.PlaceCallEditPart;
import com.safi.workshop.edit.parts.PlayDTMFEditPart;
import com.safi.workshop.edit.parts.PlayMusicOnHoldEditPart;
import com.safi.workshop.edit.parts.PreviousRowEditPart;
import com.safi.workshop.edit.parts.ProgressEditPart;
import com.safi.workshop.edit.parts.PromptGetDigitsEditPart;
import com.safi.workshop.edit.parts.RecordCallEditPart;
import com.safi.workshop.edit.parts.RecordFileEditPart;
import com.safi.workshop.edit.parts.RingingEditPart;
import com.safi.workshop.edit.parts.RunQueryEditPart;
import com.safi.workshop.edit.parts.SayAlphaEditPart;
import com.safi.workshop.edit.parts.SayDateTimeEditPart;
import com.safi.workshop.edit.parts.SayDigitsEditPart;
import com.safi.workshop.edit.parts.SayNumberEditPart;
import com.safi.workshop.edit.parts.SayPhoneticEditPart;
import com.safi.workshop.edit.parts.SayTimeEditPart;
import com.safi.workshop.edit.parts.SetAutoHangupEditPart;
import com.safi.workshop.edit.parts.SetCallerIdEditPart;
import com.safi.workshop.edit.parts.SetCallerPresentationEditPart;
import com.safi.workshop.edit.parts.SetChannelVariableEditPart;
import com.safi.workshop.edit.parts.SetColValueEditPart;
import com.safi.workshop.edit.parts.SetColValuesEditPart;
import com.safi.workshop.edit.parts.SetContextEditPart;
import com.safi.workshop.edit.parts.SetGlobalVariableEditPart;
import com.safi.workshop.edit.parts.SetMusicOnEditPart;
import com.safi.workshop.edit.parts.SetPriorityEditPart;
import com.safi.workshop.edit.parts.SleepEditPart;
import com.safi.workshop.edit.parts.StopMonitorEditPart;
import com.safi.workshop.edit.parts.StopMusicOnHoldEditPart;
import com.safi.workshop.edit.parts.StreamAudioEditPart;
import com.safi.workshop.edit.parts.StreamAudioExtendedEditPart;
import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.edit.parts.TransferEditPart;
import com.safi.workshop.edit.parts.UpdatetRowEditPart;
import com.safi.workshop.edit.parts.VoicemailEditPart;
import com.safi.workshop.edit.parts.VoicemailMainEditPart;
import com.safi.workshop.edit.parts.WaitForDigitEditPart;
import com.safi.workshop.edit.parts.WaitForRingEditPart;
import com.safi.workshop.edit.parts.WaitMusicOnHoldEditPart;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.AnswerEditorPage;
import com.safi.workshop.sheet.actionstep.AssignmentEditorPage;
import com.safi.workshop.sheet.actionstep.ChanSpyEditorPage;
import com.safi.workshop.sheet.actionstep.ChoiceEditorPage;
import com.safi.workshop.sheet.actionstep.CloseDBConnectionEditorPage;
import com.safi.workshop.sheet.actionstep.CongestionEditorPage;
import com.safi.workshop.sheet.actionstep.DebugLogEditorPage;
import com.safi.workshop.sheet.actionstep.DictateEditorPage;
import com.safi.workshop.sheet.actionstep.DirectoryEditorPage;
import com.safi.workshop.sheet.actionstep.EchoEditorPage;
import com.safi.workshop.sheet.actionstep.ExecuteApplicationEditorPage;
import com.safi.workshop.sheet.actionstep.ExecuteScriptEditorPage;
import com.safi.workshop.sheet.actionstep.ExecuteUpdateEditorPage;
import com.safi.workshop.sheet.actionstep.ExtensionSpyEditorPage;
import com.safi.workshop.sheet.actionstep.ExtensionTransferEditorPage;
import com.safi.workshop.sheet.actionstep.ExtensionTransferEditorPage2;
import com.safi.workshop.sheet.actionstep.FestivalEditorPage;
import com.safi.workshop.sheet.actionstep.GetAstVarInputEditorPage;
import com.safi.workshop.sheet.actionstep.GetAstVarOutputEditorPage;
import com.safi.workshop.sheet.actionstep.GetCallInfoInputEditorPage;
import com.safi.workshop.sheet.actionstep.GetCallInfoOutputEditorPage;
import com.safi.workshop.sheet.actionstep.GetColValueEditorPage;
import com.safi.workshop.sheet.actionstep.GetColValueOutputEditorPage;
import com.safi.workshop.sheet.actionstep.GetColValuesEditorPage;
import com.safi.workshop.sheet.actionstep.GetDigitsBasicEditorPage;
import com.safi.workshop.sheet.actionstep.GetDigitsOutputEditorPage;
import com.safi.workshop.sheet.actionstep.HangupEditorPage;
import com.safi.workshop.sheet.actionstep.IfThenEditorPage;
import com.safi.workshop.sheet.actionstep.MeetMeAGIScriptEditorPage;
import com.safi.workshop.sheet.actionstep.MeetMeAdminEditorPage;
import com.safi.workshop.sheet.actionstep.MeetMeBasicEditorPage;
import com.safi.workshop.sheet.actionstep.MeetMeCountInputEditorPage;
import com.safi.workshop.sheet.actionstep.MeetMeCountOutputEditorPage;
import com.safi.workshop.sheet.actionstep.MeetMeOptionsEditorPage;
import com.safi.workshop.sheet.actionstep.MonitorEditorPage;
import com.safi.workshop.sheet.actionstep.MoveToRowEditorPage;
import com.safi.workshop.sheet.actionstep.MultiStreamAudioEditorPage;
import com.safi.workshop.sheet.actionstep.OpenDBConnectionEditorPage;
import com.safi.workshop.sheet.actionstep.OriginateCallEditorPage;
import com.safi.workshop.sheet.actionstep.OriginateCallOutputEditorPage;
import com.safi.workshop.sheet.actionstep.PlaceCallEditorPage;
import com.safi.workshop.sheet.actionstep.PlaceCallOutputEditorPage;
import com.safi.workshop.sheet.actionstep.PlayDTMFEditorPage;
import com.safi.workshop.sheet.actionstep.PlayMusicOnHoldEditorPage;
import com.safi.workshop.sheet.actionstep.ProgressEditorPage;
import com.safi.workshop.sheet.actionstep.PromptGetDigitsBasicEditorPage;
import com.safi.workshop.sheet.actionstep.PromptGetDigitsOutputEditorPage;
import com.safi.workshop.sheet.actionstep.RecordCallEditorPage;
import com.safi.workshop.sheet.actionstep.RecordFileEditorPage;
import com.safi.workshop.sheet.actionstep.ResultSetEditorPage;
import com.safi.workshop.sheet.actionstep.RingingEditorPage;
import com.safi.workshop.sheet.actionstep.RunQueryBasicEditorPage;
import com.safi.workshop.sheet.actionstep.RunQueryOutputEditorPage;
import com.safi.workshop.sheet.actionstep.SayAlphaEditorPage;
import com.safi.workshop.sheet.actionstep.SayDateTimeEditorPage;
import com.safi.workshop.sheet.actionstep.SayDigitsEditorPage;
import com.safi.workshop.sheet.actionstep.SayNumberEditorPage;
import com.safi.workshop.sheet.actionstep.SayPhoneticEditorPage;
import com.safi.workshop.sheet.actionstep.SayTimeEditorPage;
import com.safi.workshop.sheet.actionstep.SetAutoHangupEditorPage;
import com.safi.workshop.sheet.actionstep.SetCallerIdEditorPage;
import com.safi.workshop.sheet.actionstep.SetCallerPresentationEditorPage;
import com.safi.workshop.sheet.actionstep.SetChannelVariableEditorPage;
import com.safi.workshop.sheet.actionstep.SetColValueEditorPage;
import com.safi.workshop.sheet.actionstep.SetColValuesEditorPage;
import com.safi.workshop.sheet.actionstep.SetContextEditorPage;
import com.safi.workshop.sheet.actionstep.SetGlobalVariableEditorPage;
import com.safi.workshop.sheet.actionstep.SetMusicOnHoldEditorPage;
import com.safi.workshop.sheet.actionstep.SetPriorityEditorPage;
import com.safi.workshop.sheet.actionstep.SleepEditorPage;
import com.safi.workshop.sheet.actionstep.StopMonitorEditorPage;
import com.safi.workshop.sheet.actionstep.StopMusicOnHoldEditorPage;
import com.safi.workshop.sheet.actionstep.StreamAudioEditorPage;
import com.safi.workshop.sheet.actionstep.StreamAudioExtendedEditorPage;
import com.safi.workshop.sheet.actionstep.TransferEditorPage;
import com.safi.workshop.sheet.actionstep.TransferEditorPage2;
import com.safi.workshop.sheet.actionstep.VoicemailEditorPage;
import com.safi.workshop.sheet.actionstep.VoicemailMainEditorPage;
import com.safi.workshop.sheet.actionstep.WaitForDigitEditorPage;
import com.safi.workshop.sheet.actionstep.WaitForRingEditorPage;
import com.safi.workshop.sheet.actionstep.WaitMusicOnHoldEditorPage;

public class ActionstepEditorDialogFactoryManager {

  private final static ActionstepEditorDialogFactoryManager instance = new ActionstepEditorDialogFactoryManager();

  public static ActionstepEditorDialogFactoryManager getInstance() {
    return instance;
  }

  private Map<String, ActionstepEditorDialogFactory> editorFactories = new HashMap<String, ActionstepEditorDialogFactory>();

  public List<ActionstepEditorPage> createPages(ToolstepEditPart editPart,
      ActionstepEditorDialog dlg) {
    ActionstepEditorDialogFactory factory = editorFactories.get(editPart.getClass().getName());
    if (factory != null) {
      List<ActionstepEditorPage> pages = factory.createEditorPages(dlg);
      if (pages == null)
        return Collections.emptyList();
      else
        return pages;
    }

    List<ActionstepEditorPage> pages = new ArrayList<ActionstepEditorPage>();
    if (editPart instanceof AnswerEditPart) {
      AnswerEditorPage page = new AnswerEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof AssignmentEditPart) {
      AssignmentEditorPage page = new AssignmentEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof ChoiceEditPart) {
      ChoiceEditorPage page = new ChoiceEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof HangupEditPart) {
      HangupEditorPage page = new HangupEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof CongestionEditPart) {
      CongestionEditorPage page = new CongestionEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SleepEditPart) {
      SleepEditorPage page = new SleepEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SayAlphaEditPart) {
      SayAlphaEditorPage page = new SayAlphaEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SayDateTimeEditPart) {
      SayDateTimeEditorPage page = new SayDateTimeEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SayDigitsEditPart) {
      SayDigitsEditorPage page = new SayDigitsEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SayNumberEditPart) {
      SayNumberEditorPage page = new SayNumberEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SayPhoneticEditPart) {
      SayPhoneticEditorPage page = new SayPhoneticEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SayTimeEditPart) {
      SayTimeEditorPage page = new SayTimeEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof ExtensionTransferEditPart) {
      ExtensionTransferEditorPage page = new ExtensionTransferEditorPage(dlg);
      pages.add(page);

      ExtensionTransferEditorPage2 page2 = new ExtensionTransferEditorPage2(dlg);
      pages.add(page2);
    } else if (editPart instanceof GetFullVariableEditPart) {
      GetAstVarInputEditorPage page = new GetAstVarInputEditorPage(dlg);
      pages.add(page);

      GetAstVarOutputEditorPage page2 = new GetAstVarOutputEditorPage(dlg);
      pages.add(page2);
    } else if (editPart instanceof GetCallInfoEditPart) {
      GetCallInfoInputEditorPage page = new GetCallInfoInputEditorPage(dlg);
      pages.add(page);

      GetCallInfoOutputEditorPage page2 = new GetCallInfoOutputEditorPage(dlg);
      pages.add(page2);
    } else if (editPart instanceof StreamAudioEditPart) {
      StreamAudioEditorPage page = new StreamAudioEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof StreamAudioExtendedEditPart) {
      StreamAudioExtendedEditorPage page = new StreamAudioExtendedEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof IfThenEditPart) {
      IfThenEditorPage page = new IfThenEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof DebugLogEditPart) {
      DebugLogEditorPage page = new DebugLogEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof ChanSpyEditPart) {
      ChanSpyEditorPage page = new ChanSpyEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof EchoEditPart) {
      EchoEditorPage page = new EchoEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof DictateEditPart) {
      DictateEditorPage page = new DictateEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof DirectoryEditPart) {
      DirectoryEditorPage page = new DirectoryEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof ExecuteScriptEditPart) {
      ExecuteScriptEditorPage page = new ExecuteScriptEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof ExecuteApplicationEditPart) {
      ExecuteApplicationEditorPage page = new ExecuteApplicationEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof ExtensionSpyEditPart) {
      ExtensionSpyEditorPage page = new ExtensionSpyEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof MeetMeEditPart) {
      MeetMeBasicEditorPage page1 = new MeetMeBasicEditorPage(dlg);
      pages.add(page1);

      MeetMeOptionsEditorPage page2 = new MeetMeOptionsEditorPage(dlg);
      pages.add(page2);

      MeetMeAGIScriptEditorPage page3 = new MeetMeAGIScriptEditorPage(dlg);
      pages.add(page3);
    } else if (editPart instanceof MeetMeCountEditPart) {
      MeetMeCountInputEditorPage page1 = new MeetMeCountInputEditorPage(dlg);
      pages.add(page1);

      MeetMeCountOutputEditorPage page2 = new MeetMeCountOutputEditorPage(dlg);
      pages.add(page2);
    } else if (editPart instanceof MonitorEditPart) {
      MonitorEditorPage page = new MonitorEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof PlayDTMFEditPart) {
      PlayDTMFEditorPage page = new PlayDTMFEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SetCallerIdEditPart) {
      SetCallerIdEditorPage page = new SetCallerIdEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SetCallerPresentationEditPart) {
      SetCallerPresentationEditorPage page = new SetCallerPresentationEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SetChannelVariableEditPart) {
      SetChannelVariableEditorPage page = new SetChannelVariableEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SetContextEditPart) {
      SetContextEditorPage page = new SetContextEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SetPriorityEditPart) {
      SetPriorityEditorPage page = new SetPriorityEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SetGlobalVariableEditPart) {
      SetGlobalVariableEditorPage page = new SetGlobalVariableEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SetMusicOnEditPart) {
      SetMusicOnHoldEditorPage page = new SetMusicOnHoldEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof VoicemailEditPart) {
      VoicemailEditorPage page = new VoicemailEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof VoicemailMainEditPart) {
      VoicemailMainEditorPage page = new VoicemailMainEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof GetDigitsEditPart) {
      GetDigitsBasicEditorPage page1 = new GetDigitsBasicEditorPage(dlg);
      pages.add(page1);

      GetDigitsOutputEditorPage page2 = new GetDigitsOutputEditorPage(dlg);
      pages.add(page2);
    } else if (editPart instanceof PromptGetDigitsEditPart) {
      PromptGetDigitsBasicEditorPage page1 = new PromptGetDigitsBasicEditorPage(dlg);
      pages.add(page1);

      PromptGetDigitsOutputEditorPage page2 = new PromptGetDigitsOutputEditorPage(dlg);
      pages.add(page2);
    } else if (editPart instanceof WaitForDigitEditPart) {
      WaitForDigitEditorPage page = new WaitForDigitEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof MeetMeAdminEditPart) {
      MeetMeAdminEditorPage page = new MeetMeAdminEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof PlaceCallEditPart) {
      PlaceCallEditorPage page = new PlaceCallEditorPage(dlg);
      pages.add(page);
      PlaceCallOutputEditorPage page2 = new PlaceCallOutputEditorPage(dlg);
      pages.add(page2);
    } else if (editPart instanceof RecordCallEditPart) {
      RecordCallEditorPage page = new RecordCallEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof RecordFileEditPart) {
      RecordFileEditorPage page = new RecordFileEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof StopMonitorEditPart) {
      StopMonitorEditorPage page = new StopMonitorEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof TransferEditPart) {
      TransferEditorPage page = new TransferEditorPage(dlg);
      pages.add(page);

      TransferEditorPage2 page2 = new TransferEditorPage2(dlg);
      pages.add(page2);
    } else if (editPart instanceof WaitMusicOnHoldEditPart) {
      WaitMusicOnHoldEditorPage page = new WaitMusicOnHoldEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof ProgressEditPart) {
      ProgressEditorPage page = new ProgressEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof StopMusicOnHoldEditPart) {
      StopMusicOnHoldEditorPage page = new StopMusicOnHoldEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof WaitForRingEditPart) {
      WaitForRingEditorPage page = new WaitForRingEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof SetAutoHangupEditPart) {
      SetAutoHangupEditorPage page = new SetAutoHangupEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof PlayMusicOnHoldEditPart) {
      PlayMusicOnHoldEditorPage page = new PlayMusicOnHoldEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof RingingEditPart) {
      RingingEditorPage page = new RingingEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof CloseDBConnectionEditPart) {
      CloseDBConnectionEditorPage page = new CloseDBConnectionEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof MultiStreamAudioEditPart) {
      MultiStreamAudioEditorPage page = new MultiStreamAudioEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof RunQueryEditPart) {
      RunQueryBasicEditorPage page = new RunQueryBasicEditorPage(dlg);
      RunQueryOutputEditorPage pageoutput = new RunQueryOutputEditorPage(dlg);
      pages.add(page);
      pages.add(pageoutput);
    } else if (editPart instanceof SetColValuesEditPart) {
      SetColValuesEditorPage page = new SetColValuesEditorPage(dlg);
      pages.add(page);

    } else if (editPart instanceof GetColValuesEditPart) {
      GetColValuesEditorPage page = new GetColValuesEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof DeleteRowEditPart || editPart instanceof InsertRowEditPart
        || editPart instanceof MoveToFirstRowEditPart || editPart instanceof MoveToLastRowEditPart
        || editPart instanceof MoveToInsertRowEditPart || editPart instanceof NextRowEditPart
        || editPart instanceof PreviousRowEditPart || editPart instanceof UpdatetRowEditPart) {
      ResultSetEditorPage page = new ResultSetEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof ExecuteUpdateEditPart) {
      ExecuteUpdateEditorPage page = new ExecuteUpdateEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof MoveToRowEditPart) {
      MoveToRowEditorPage page = new MoveToRowEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof GetColValueEditPart) {
      GetColValueEditorPage page1 = new GetColValueEditorPage(dlg);
      pages.add(page1);

      GetColValueOutputEditorPage page2 = new GetColValueOutputEditorPage(dlg);
      pages.add(page2);
    } else if (editPart instanceof SetColValueEditPart) {
      SetColValueEditorPage page = new SetColValueEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof FestivalEditPart) {
      FestivalEditorPage page = new FestivalEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof OpenDBConnectionEditPart) {
      OpenDBConnectionEditorPage page = new OpenDBConnectionEditorPage(dlg);
      pages.add(page);
    } else if (editPart instanceof OriginateCallEditPart) {
      OriginateCallEditorPage page = new OriginateCallEditorPage(dlg);
      pages.add(page);
      OriginateCallOutputEditorPage page2 = new OriginateCallOutputEditorPage(dlg);
      pages.add(page2);
    }

    return pages;
  }

  public void registerActionstepEditorDialogFactory(String actionstepClassName,
      ActionstepEditorDialogFactory factory) {
    this.editorFactories.put(actionstepClassName, factory);
  }
}
