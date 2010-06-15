package com.safi.workshop.part;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import com.safi.workshop.providers.AsteriskElementTypes;

/**
 * @generated
 */
public class AsteriskPaletteFactory {

  /**
   * @generated NOT
   */
  public void fillPalette(PaletteRoot paletteRoot) {
//    paletteRoot.add(createCallManagement1Group());
//    paletteRoot.add(createInput2Group());
//    paletteRoot.add(createAudioPlayback3Group());
//    paletteRoot.add(createCallInfo4Group());
//    paletteRoot.add(createAudioRealtime5Group());
    paletteRoot.add(createLogic6Group());
//    paletteRoot.add(createVMConf7Group());
    paletteRoot.add(createMisc8Group());
    paletteRoot.add(createInitiators9Group());
//    paletteRoot.add(createAdvancedCallHandling10Group());
    paletteRoot.add(createDatabase11Group());
    addActionPaks(paletteRoot);
  }

  private void addActionPaks(PaletteRoot paletteRoot) {
    for (AsteriskDiagramEditorPlugin.ActionStepProfile a : AsteriskDiagramEditorPlugin
        .getInstance().getActionstepProfiles()) {
      String palettePath = a.palettePath;
      PaletteDrawer drawer = null;
      boolean isBlank = StringUtils.isBlank(palettePath);
      
      if (!isBlank)
	      for (Object o : paletteRoot.getChildren()) {
	        if (o instanceof PaletteDrawer) {
	          if (palettePath.equals(((PaletteDrawer) o).getLabel())) {
	            drawer = (PaletteDrawer) o;
	            break;
	          }
	        }
	      }
      
      if (drawer == null && !isBlank){
      	drawer = new PaletteDrawer(palettePath);
      	paletteRoot.add(drawer);
      }
      
      if (drawer == null) {
        for (Object o : paletteRoot.getChildren()) {
          if (o instanceof PaletteDrawer) {
            if (Messages.Misc8Group_title.equals(((PaletteDrawer) o).getLabel())) {
              drawer = (PaletteDrawer) o;
              break;
            }
          }
        }
      }
      if (drawer != null) {
        List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
        int id = Integer.parseInt(a.semanticHint);
        types.add(a.elementFactory.getElementType(id));
        NodeToolEntry entry = new NodeToolEntry(a.displayName, a.tooltip, types);
        entry.setSmallIcon(AsteriskElementTypes.getImageDescriptor(a.elementFactory
            .getElementType(id)));
        entry.setLargeIcon(entry.getSmallIcon());
        drawer.add(entry);
      }
    }

  }

//  /**
//   * Creates "Call Management" palette tool group
//   * 
//   * @generated
//   */
//  private PaletteContainer createCallManagement1Group() {
//    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.CallManagement1Group_title);
//    paletteContainer.setDescription(Messages.CallManagement1Group_desc);
//    paletteContainer.add(createAnswer1CreationTool());
//    paletteContainer.add(createHangup2CreationTool());
//    paletteContainer.add(createTransfer3CreationTool());
//    paletteContainer.add(createTransferExtension4CreationTool());
//    paletteContainer.add(createSleep5CreationTool());
//    paletteContainer.add(createPlaceCall6CreationTool());
//    paletteContainer.add(createCongestion7CreationTool());
//    return paletteContainer;
//  }
//
//  /**
//   * Creates "Input" palette tool group
//   * 
//   * @generated
//   */
//  private PaletteContainer createInput2Group() {
//    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Input2Group_title);
//    paletteContainer.setDescription(Messages.Input2Group_desc);
//    paletteContainer.add(createWaitForDigit1CreationTool());
//    paletteContainer.add(createGetDigits2CreationTool());
//    paletteContainer.add(createPromptGetDigits3CreationTool());
//    return paletteContainer;
//  }
//
//  /**
//   * Creates "Audio: Playback" palette tool group
//   * 
//   * @generated
//   */
//  private PaletteContainer createAudioPlayback3Group() {
//    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.AudioPlayback3Group_title);
//    paletteContainer.setDescription(Messages.AudioPlayback3Group_desc);
//    paletteContainer.add(createSayAlpha1CreationTool());
//    paletteContainer.add(createSayDateTime2CreationTool());
//    paletteContainer.add(createSayDigits3CreationTool());
//    paletteContainer.add(createSayNumber4CreationTool());
//    paletteContainer.add(createSayPhonetic5CreationTool());
//    paletteContainer.add(createSayTime6CreationTool());
//
//    paletteContainer.add(createStreamAudio9CreationTool());
//    paletteContainer.add(createMultiStreamAudio10CreationTool());
//    paletteContainer.add(createPlayDTMF11CreationTool());
//
//    paletteContainer.add(createStreamAudioExtended13CreationTool());
//    paletteContainer.add(createFestival14CreationTool());
//    paletteContainer.add(createWaitMusicOnHold15CreationTool());
//    return paletteContainer;
//  }
//
//  /**
//   * Creates "Call Info" palette tool group
//   * 
//   * @generated
//   */
//  private PaletteContainer createCallInfo4Group() {
//    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.CallInfo4Group_title);
//    paletteContainer.setDescription(Messages.CallInfo4Group_desc);
//    paletteContainer.add(createGetFullVariable1CreationTool());
//    paletteContainer.add(createSetChannelVariable2CreationTool());
//    paletteContainer.add(createSetContext3CreationTool());
//    paletteContainer.add(createSetPriority4CreationTool());
//    paletteContainer.add(createGetCallInfo5CreationTool());
//    paletteContainer.add(createSetGlobalVariable6CreationTool());
//    paletteContainer.add(createSetCallerId7CreationTool());
//    paletteContainer.add(createSetCallerPresentation8CreationTool());
//    paletteContainer.add(createSetMusicOnHold8CreationTool());
//    return paletteContainer;
//  }

//  /**
//   * Creates "Audio: Realtime" palette tool group
//   * 
//   * @generated
//   */
//  private PaletteContainer createAudioRealtime5Group() {
//    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.AudioRealtime5Group_title);
//    paletteContainer.setDescription(Messages.AudioRealtime5Group_desc);
//    paletteContainer.add(createRecordFile1CreationTool());
//    paletteContainer.add(createRecordCall2CreationTool());
//    paletteContainer.add(createMonitor3CreationTool());
//    paletteContainer.add(createStopMonitor4CreationTool());
//    paletteContainer.add(createChanSpy5CreationTool());
//    paletteContainer.add(createExtensionSpy6CreationTool());
//    return paletteContainer;
//  }

  /**
   * Creates "Logic" palette tool group
   * 
   * @generated
   */
  private PaletteContainer createLogic6Group() {
    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Logic6Group_title);
    paletteContainer.setDescription(Messages.Logic6Group_desc);
    paletteContainer.add(createAssignment1CreationTool());
    paletteContainer.add(createChoice2CreationTool());
    paletteContainer.add(createIfThen3CreationTool());
    // paletteContainer.add(createInvokeSaflet4CreationTool());
    paletteContainer.add(createExecuteScript5CreationTool());
    return paletteContainer;
  }

//  /**
//   * Creates "VM/Conf" palette tool group
//   * 
//   * @generated
//   */
//  private PaletteContainer createVMConf7Group() {
//    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.VMConf7Group_title);
//    paletteContainer.setDescription(Messages.VMConf7Group_desc);
//    paletteContainer.add(createVoicemail1CreationTool());
//    paletteContainer.add(createVoicemailMain2CreationTool());
//    paletteContainer.add(createMeetMe3CreationTool());
//    paletteContainer.add(createMeetMeAdmin4CreationTool());
//    paletteContainer.add(createMeetMeCount5CreationTool());
//    paletteContainer.add(createDirectory6CreationTool());
//    paletteContainer.add(createDictate7CreationTool());
//    return paletteContainer;
//  }

  /**
   * Creates "Misc" palette tool group
   * 
   * @generated
   */
  private PaletteContainer createMisc8Group() {
    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Misc8Group_title);
    paletteContainer.setDescription(Messages.Misc8Group_desc);
//    paletteContainer.add(createExecuteApplication1CreationTool());
//    paletteContainer.add(createEcho2CreationTool());
    paletteContainer.add(createDebugLog3CreationTool());
    return paletteContainer;
  }

  /**
   * Creates "Initiators" palette tool group
   * 
   * @generated
   */
  private PaletteContainer createInitiators9Group() {
    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Initiators9Group_title);
    paletteContainer.setDescription(Messages.Initiators9Group_desc);
    // paletteContainer.add(createIncomingCall1CreationTool());
    return paletteContainer;
  }
//
//  /**
//   * Creates "Advanced Call Handling" palette tool group
//   * 
//   * @generated
//   */
//  private PaletteContainer createAdvancedCallHandling10Group() {
//    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.AdvancedCallHandling10Group_title);
//    paletteContainer.setDescription(Messages.AdvancedCallHandling10Group_desc);
//    paletteContainer.add(createOriginateCall1CreationTool());
//    paletteContainer.add(createProgress2CreationTool());
//    paletteContainer.add(createSetAutoHangup3CreationTool());
//    paletteContainer.add(createWaitForRing4CreationTool());
//    paletteContainer.add(createRinging5CreationTool());
//    paletteContainer.add(createStopMusicOnHold7CreationTool());
//    paletteContainer.add(createPlayMusicOnHold12CreationTool());
//    return paletteContainer;
//  }

  /**
   * Creates "Database" palette tool group
   * 
   * @generated NOT
   */
  private PaletteContainer createDatabase11Group() {
    PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Database11Group_title);
    paletteContainer.setDescription(Messages.Database11Group_desc);
    paletteContainer.add(createOpenDBConnection1CreationTool());
    paletteContainer.add(createCloseDBConnection2CreationTool());
    paletteContainer.add(createRunQuery3CreationTool());
    // paletteContainer.add(createExecuteUpdate4CreationTool());
    paletteContainer.add(createNextRow5CreationTool());
    paletteContainer.add(createGetColValue6CreationTool());
    paletteContainer.add(createGetColValues7CreationTool());
    paletteContainer.add(createSetColValue8CreationTool());
    paletteContainer.add(createSetColValues9CreationTool());
    paletteContainer.add(createUpdateRow10CreationTool());
    paletteContainer.add(createMoveToRow11CreationTool());
    paletteContainer.add(createMoveToLastRow12CreationTool());
    paletteContainer.add(createDeleteRow13CreationTool());
    paletteContainer.add(createMoveToInsertRow14CreationTool());
    paletteContainer.add(createInsertRow15CreationTool());
    paletteContainer.add(createMoveToFirstRow16CreationTool());
    paletteContainer.add(createPreviousRow17CreationTool());
    return paletteContainer;
  }

  /**
   * @generated
   */
  private ToolEntry createAssignment1CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.Assignment_1002);
    NodeToolEntry entry = new NodeToolEntry(Messages.Assignment1CreationTool_title,
        Messages.Assignment1CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.Assignment_1002));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createChoice2CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.Choice_1003);
    NodeToolEntry entry = new NodeToolEntry(Messages.Choice2CreationTool_title,
        Messages.Choice2CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes.getImageDescriptor(AsteriskElementTypes.Choice_1003));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createIfThen3CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.IfThen_1007);
    NodeToolEntry entry = new NodeToolEntry(Messages.IfThen3CreationTool_title,
        Messages.IfThen3CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes.getImageDescriptor(AsteriskElementTypes.IfThen_1007));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated NOT
   */
  private ToolEntry createInvokeSaflet4CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.InvokeSaflet_1038);
    NodeToolEntry entry = new NodeToolEntry(Messages.InvokeSaflet4CreationTool_title,
        Messages.InvokeSaflet4CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.InvokeSaflet_1038));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createExecuteScript5CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.ExecuteScript_1037);
    NodeToolEntry entry = new NodeToolEntry(Messages.ExecuteScript5CreationTool_title,
        Messages.ExecuteScript5CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.ExecuteScript_1037));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createDebugLog3CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.DebugLog_1056);
    NodeToolEntry entry = new NodeToolEntry(Messages.DebugLog3CreationTool_title,
        Messages.DebugLog3CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes.getImageDescriptor(AsteriskElementTypes.DebugLog_1056));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createOpenDBConnection1CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.OpenDBConnection_1077);
    NodeToolEntry entry = new NodeToolEntry(Messages.OpenDBConnection1CreationTool_title,
        Messages.OpenDBConnection1CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.OpenDBConnection_1077));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createCloseDBConnection2CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.CloseDBConnection_1078);
    NodeToolEntry entry = new NodeToolEntry(Messages.CloseDBConnection2CreationTool_title,
        Messages.CloseDBConnection2CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.CloseDBConnection_1078));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createRunQuery3CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.RunQuery_1097);
    NodeToolEntry entry = new NodeToolEntry(Messages.RunQuery3CreationTool_title,
        Messages.RunQuery3CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes.getImageDescriptor(AsteriskElementTypes.RunQuery_1097));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createExecuteUpdate4CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.ExecuteUpdate_1081);
    NodeToolEntry entry = new NodeToolEntry(Messages.ExecuteUpdate4CreationTool_title,
        Messages.ExecuteUpdate4CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.ExecuteUpdate_1081));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createNextRow5CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.NextRow_1083);
    NodeToolEntry entry = new NodeToolEntry(Messages.NextRow5CreationTool_title,
        Messages.NextRow5CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes.getImageDescriptor(AsteriskElementTypes.NextRow_1083));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createGetColValue6CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.GetColValue_1084);
    NodeToolEntry entry = new NodeToolEntry(Messages.GetColValue6CreationTool_title,
        Messages.GetColValue6CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.GetColValue_1084));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createGetColValues7CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.GetColValues_1094);
    NodeToolEntry entry = new NodeToolEntry(Messages.GetColValues7CreationTool_title,
        Messages.GetColValues7CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.GetColValues_1094));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createSetColValue8CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.SetColValue_1085);
    NodeToolEntry entry = new NodeToolEntry(Messages.SetColValue8CreationTool_title,
        Messages.SetColValue8CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.SetColValue_1085));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createSetColValues9CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.SetColValues_1095);
    NodeToolEntry entry = new NodeToolEntry(Messages.SetColValues9CreationTool_title,
        Messages.SetColValues9CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.SetColValues_1095));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createUpdateRow10CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.UpdatetRow_1086);
    NodeToolEntry entry = new NodeToolEntry(Messages.UpdateRow10CreationTool_title,
        Messages.UpdateRow10CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.UpdatetRow_1086));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createMoveToRow11CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.MoveToRow_1087);
    NodeToolEntry entry = new NodeToolEntry(Messages.MoveToRow11CreationTool_title,
        Messages.MoveToRow11CreationTool_desc, types);
    entry
        .setSmallIcon(AsteriskElementTypes.getImageDescriptor(AsteriskElementTypes.MoveToRow_1087));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createMoveToLastRow12CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.MoveToLastRow_1088);
    NodeToolEntry entry = new NodeToolEntry(Messages.MoveToLastRow12CreationTool_title,
        Messages.MoveToLastRow12CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.MoveToLastRow_1088));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createDeleteRow13CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.DeleteRow_1089);
    NodeToolEntry entry = new NodeToolEntry(Messages.DeleteRow13CreationTool_title,
        Messages.DeleteRow13CreationTool_desc, types);
    entry
        .setSmallIcon(AsteriskElementTypes.getImageDescriptor(AsteriskElementTypes.DeleteRow_1089));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createMoveToInsertRow14CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.MoveToInsertRow_1090);
    NodeToolEntry entry = new NodeToolEntry(Messages.MoveToInsertRow14CreationTool_title,
        Messages.MoveToInsertRow14CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.MoveToInsertRow_1090));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createInsertRow15CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.InsertRow_1091);
    NodeToolEntry entry = new NodeToolEntry(Messages.InsertRow15CreationTool_title,
        Messages.InsertRow15CreationTool_desc, types);
    entry
        .setSmallIcon(AsteriskElementTypes.getImageDescriptor(AsteriskElementTypes.InsertRow_1091));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createMoveToFirstRow16CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.MoveToFirstRow_1092);
    NodeToolEntry entry = new NodeToolEntry(Messages.MoveToFirstRow16CreationTool_title,
        Messages.MoveToFirstRow16CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.MoveToFirstRow_1092));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated
   */
  private ToolEntry createPreviousRow17CreationTool() {
    List/* <IElementType> */types = new ArrayList/* <IElementType> */(1);
    types.add(AsteriskElementTypes.PreviousRow_1093);
    NodeToolEntry entry = new NodeToolEntry(Messages.PreviousRow17CreationTool_title,
        Messages.PreviousRow17CreationTool_desc, types);
    entry.setSmallIcon(AsteriskElementTypes
        .getImageDescriptor(AsteriskElementTypes.PreviousRow_1093));
    entry.setLargeIcon(entry.getSmallIcon());
    return entry;
  }

  /**
   * @generated NOT
   */
  public static class NodeToolEntry extends PaletteToolEntry  {

    /**
     * @generated
     */
    private final List elementTypes;

    /**
     * @generated NOT
     */
    private NodeToolEntry(String title, String description, List elementTypes) {
    	super(null, title, null);
    	this.setDescription(description);
      this.elementTypes = elementTypes;
    }

    // added by zac
    public List getElementTypes() {
      return elementTypes;
    }

    /**
     * @generated
     */
    @Override
    public Tool createTool() {
      Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
      tool.setProperties(getToolProperties());
      return tool;
    }
  }
}
