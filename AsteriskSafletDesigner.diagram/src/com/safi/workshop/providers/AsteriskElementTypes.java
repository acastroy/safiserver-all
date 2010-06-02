package com.safi.workshop.providers;

import java.net.URL;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.draw2d.ui.render.RenderedImage;
import org.eclipse.gmf.runtime.draw2d.ui.render.factory.RenderedImageFactory;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;

import com.safi.asterisk.actionstep.ActionstepPackage;
import com.safi.asterisk.initiator.InitiatorPackage;
import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.saflet.SafletPackage;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

/**
 * @generated
 */
public class AsteriskElementTypes extends ElementInitializers {

  /**
   * @generated
   */
  private AsteriskElementTypes() {
  }

  /**
   * @generated
   */
  private static Map elements;

  /**
   * @generated
   */
  private static ImageRegistry imageRegistry;

  /**
   * @generated
   */
  private static Set KNOWN_ELEMENT_TYPES;

  /**
   * @generated
   */
  public static final IElementType Handler_79 = getElementType("AsteriskSafletDesigner.diagram.Handler_79"); //$NON-NLS-1$
  /**
   * @generated
   */
  public static final IElementType Answer_1001 = getElementType("AsteriskSafletDesigner.diagram.Answer_1001"); //$NON-NLS-1$
  /**
   * @generated
   */
  public static final IElementType Assignment_1002 = getElementType("AsteriskSafletDesigner.diagram.Assignment_1002"); //$NON-NLS-1$
  /**
   * @generated
   */
  public static final IElementType Choice_1003 = getElementType("AsteriskSafletDesigner.diagram.Choice_1003"); //$NON-NLS-1$
  /**
   * @generated
   */
  public static final IElementType GetFullVariable_1004 = getElementType("AsteriskSafletDesigner.diagram.GetFullVariable_1004"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType MultiStreamAudio_1005 = getElementType("AsteriskSafletDesigner.diagram.MultiStreamAudio_1005"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Hangup_1006 = getElementType("AsteriskSafletDesigner.diagram.Hangup_1006"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType IfThen_1007 = getElementType("AsteriskSafletDesigner.diagram.IfThen_1007"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType RecordFile_1008 = getElementType("AsteriskSafletDesigner.diagram.RecordFile_1008"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SayAlpha_1009 = getElementType("AsteriskSafletDesigner.diagram.SayAlpha_1009"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SayDateTime_1010 = getElementType("AsteriskSafletDesigner.diagram.SayDateTime_1010"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SayDigits_1011 = getElementType("AsteriskSafletDesigner.diagram.SayDigits_1011"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SayNumber_1012 = getElementType("AsteriskSafletDesigner.diagram.SayNumber_1012"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SayPhonetic_1013 = getElementType("AsteriskSafletDesigner.diagram.SayPhonetic_1013"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SayTime_1014 = getElementType("AsteriskSafletDesigner.diagram.SayTime_1014"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetAutoHangup_1015 = getElementType("AsteriskSafletDesigner.diagram.SetAutoHangup_1015"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetCallerId_1016 = getElementType("AsteriskSafletDesigner.diagram.SetCallerId_1016"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetChannelVariable_1017 = getElementType("AsteriskSafletDesigner.diagram.SetChannelVariable_1017"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetContext_1018 = getElementType("AsteriskSafletDesigner.diagram.SetContext_1018"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetExtension_1019 = getElementType("AsteriskSafletDesigner.diagram.SetExtension_1019"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType StopMusicOnHold_1020 = getElementType("AsteriskSafletDesigner.diagram.StopMusicOnHold_1020"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetMusicOn_1021 = getElementType("AsteriskSafletDesigner.diagram.SetMusicOn_1021"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetPriority_1022 = getElementType("AsteriskSafletDesigner.diagram.SetPriority_1022"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType StreamAudio_1023 = getElementType("AsteriskSafletDesigner.diagram.StreamAudio_1023"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType WaitForDigit_1024 = getElementType("AsteriskSafletDesigner.diagram.WaitForDigit_1024"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType DIDMatcher_1025 = getElementType("AsteriskSafletDesigner.diagram.DIDMatcher_1025"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType GetDigits_1026 = getElementType("AsteriskSafletDesigner.diagram.GetDigits_1026"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType OriginateCall_1027 = getElementType("AsteriskSafletDesigner.diagram.OriginateCall_1027"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType PlayDTMF_1028 = getElementType("AsteriskSafletDesigner.diagram.PlayDTMF_1028"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType RecordCall_1029 = getElementType("AsteriskSafletDesigner.diagram.RecordCall_1029"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType ExecuteApplication_1030 = getElementType("AsteriskSafletDesigner.diagram.ExecuteApplication_1030"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType PlayMusicOnHold_1031 = getElementType("AsteriskSafletDesigner.diagram.PlayMusicOnHold_1031"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType PromptGetDigits_1032 = getElementType("AsteriskSafletDesigner.diagram.PromptGetDigits_1032"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Sleep_1033 = getElementType("AsteriskSafletDesigner.diagram.Sleep_1033"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType StreamAudioExtended_1034 = getElementType("AsteriskSafletDesigner.diagram.StreamAudioExtended_1034"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType IncomingCall_1035 = getElementType("AsteriskSafletDesigner.diagram.IncomingCall_1035"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType GetCallInfo_1036 = getElementType("AsteriskSafletDesigner.diagram.GetCallInfo_1036"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType ExecuteScript_1037 = getElementType("AsteriskSafletDesigner.diagram.ExecuteScript_1037"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType InvokeSaflet_1038 = getElementType("AsteriskSafletDesigner.diagram.InvokeSaflet_1038"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Dial_1039 = getElementType("AsteriskSafletDesigner.diagram.Dial_1039"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Pickup_1040 = getElementType("AsteriskSafletDesigner.diagram.Pickup_1040"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Background_1041 = getElementType("AsteriskSafletDesigner.diagram.Background_1041"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType BackgroundDetect_1042 = getElementType("AsteriskSafletDesigner.diagram.BackgroundDetect_1042"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType WaitExten_1043 = getElementType("AsteriskSafletDesigner.diagram.WaitExten_1043"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SoftHangup_1044 = getElementType("AsteriskSafletDesigner.diagram.SoftHangup_1044"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType PickupChan_1045 = getElementType("AsteriskSafletDesigner.diagram.PickupChan_1045"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Pickdown_1046 = getElementType("AsteriskSafletDesigner.diagram.Pickdown_1046"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Progress_1047 = getElementType("AsteriskSafletDesigner.diagram.Progress_1047"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Bridge_1048 = getElementType("AsteriskSafletDesigner.diagram.Bridge_1048"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType PlaceCall_1049 = getElementType("AsteriskSafletDesigner.diagram.PlaceCall_1049"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Voicemail_1050 = getElementType("AsteriskSafletDesigner.diagram.Voicemail_1050"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType VoicemailMain_1051 = getElementType("AsteriskSafletDesigner.diagram.VoicemailMain_1051"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType VMAuthenticate_1052 = getElementType("AsteriskSafletDesigner.diagram.VMAuthenticate_1052"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType MeetMe_1053 = getElementType("AsteriskSafletDesigner.diagram.MeetMe_1053"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType MeetMeAdmin_1054 = getElementType("AsteriskSafletDesigner.diagram.MeetMeAdmin_1054"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType MeetMeCount_1055 = getElementType("AsteriskSafletDesigner.diagram.MeetMeCount_1055"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType DebugLog_1056 = getElementType("AsteriskSafletDesigner.diagram.DebugLog_1056"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType WaitForRing_1057 = getElementType("AsteriskSafletDesigner.diagram.WaitForRing_1057"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType WaitMusicOnHold_1058 = getElementType("AsteriskSafletDesigner.diagram.WaitMusicOnHold_1058"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType GetAvailableChannel_1059 = getElementType("AsteriskSafletDesigner.diagram.GetAvailableChannel_1059"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Congestion_1060 = getElementType("AsteriskSafletDesigner.diagram.Congestion_1060"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Ringing_1061 = getElementType("AsteriskSafletDesigner.diagram.Ringing_1061"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetCallerPresentation_1062 = getElementType("AsteriskSafletDesigner.diagram.SetCallerPresentation_1062"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetGlobalVariable_1063 = getElementType("AsteriskSafletDesigner.diagram.SetGlobalVariable_1063"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Echo_1064 = getElementType("AsteriskSafletDesigner.diagram.Echo_1064"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Festival_1065 = getElementType("AsteriskSafletDesigner.diagram.Festival_1065"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Playtones_1066 = getElementType("AsteriskSafletDesigner.diagram.Playtones_1066"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType StopPlaytones_1067 = getElementType("AsteriskSafletDesigner.diagram.StopPlaytones_1067"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType ChanSpy_1068 = getElementType("AsteriskSafletDesigner.diagram.ChanSpy_1068"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Dictate_1069 = getElementType("AsteriskSafletDesigner.diagram.Dictate_1069"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType ExtensionSpy_1070 = getElementType("AsteriskSafletDesigner.diagram.ExtensionSpy_1070"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType MixMonitor_1071 = getElementType("AsteriskSafletDesigner.diagram.MixMonitor_1071"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType StopMixmonitor_1072 = getElementType("AsteriskSafletDesigner.diagram.StopMixmonitor_1072"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType StopMonitor_1073 = getElementType("AsteriskSafletDesigner.diagram.StopMonitor_1073"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Monitor_1074 = getElementType("AsteriskSafletDesigner.diagram.Monitor_1074"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Directory_1075 = getElementType("AsteriskSafletDesigner.diagram.Directory_1075"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Transfer_1076 = getElementType("AsteriskSafletDesigner.diagram.Transfer_1076"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType OpenDBConnection_1077 = getElementType("AsteriskSafletDesigner.diagram.OpenDBConnection_1077"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType CloseDBConnection_1078 = getElementType("AsteriskSafletDesigner.diagram.CloseDBConnection_1078"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType OpenQuery_1079 = getElementType("AsteriskSafletDesigner.diagram.OpenQuery_1079"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetQueryParam_1080 = getElementType("AsteriskSafletDesigner.diagram.SetQueryParam_1080"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType ExecuteUpdate_1081 = getElementType("AsteriskSafletDesigner.diagram.ExecuteUpdate_1081"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType ExecuteQuery_1082 = getElementType("AsteriskSafletDesigner.diagram.ExecuteQuery_1082"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType NextRow_1083 = getElementType("AsteriskSafletDesigner.diagram.NextRow_1083"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType GetColValue_1084 = getElementType("AsteriskSafletDesigner.diagram.GetColValue_1084"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetColValue_1085 = getElementType("AsteriskSafletDesigner.diagram.SetColValue_1085"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType UpdatetRow_1086 = getElementType("AsteriskSafletDesigner.diagram.UpdatetRow_1086"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType MoveToRow_1087 = getElementType("AsteriskSafletDesigner.diagram.MoveToRow_1087"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType MoveToLastRow_1088 = getElementType("AsteriskSafletDesigner.diagram.MoveToLastRow_1088"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType DeleteRow_1089 = getElementType("AsteriskSafletDesigner.diagram.DeleteRow_1089"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType MoveToInsertRow_1090 = getElementType("AsteriskSafletDesigner.diagram.MoveToInsertRow_1090"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType InsertRow_1091 = getElementType("AsteriskSafletDesigner.diagram.InsertRow_1091"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType MoveToFirstRow_1092 = getElementType("AsteriskSafletDesigner.diagram.MoveToFirstRow_1092"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType PreviousRow_1093 = getElementType("AsteriskSafletDesigner.diagram.PreviousRow_1093"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType GetColValues_1094 = getElementType("AsteriskSafletDesigner.diagram.GetColValues_1094"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetColValues_1095 = getElementType("AsteriskSafletDesigner.diagram.SetColValues_1095"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType ExtensionTransfer_1096 = getElementType("AsteriskSafletDesigner.diagram.ExtensionTransfer_1096"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType RunQuery_1097 = getElementType("AsteriskSafletDesigner.diagram.RunQuery_1097"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType Output_2001 = getElementType("AsteriskSafletDesigner.diagram.Output_2001"); //$NON-NLS-1$
  /**
   * @generated
   */
  public static final IElementType CaseItem_2002 = getElementType("AsteriskSafletDesigner.diagram.CaseItem_2002"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType AudioFileItem_2003 = getElementType("AsteriskSafletDesigner.diagram.AudioFileItem_2003"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType GetColMapping_2004 = getElementType("AsteriskSafletDesigner.diagram.GetColMapping_2004"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType SetColMapping_2005 = getElementType("AsteriskSafletDesigner.diagram.SetColMapping_2005"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType QueryParamMapping_2006 = getElementType("AsteriskSafletDesigner.diagram.QueryParamMapping_2006"); //$NON-NLS-1$

  /**
   * @generated
   */
  public static final IElementType OutputTarget_3001 = getElementType("AsteriskSafletDesigner.diagram.OutputTarget_3001"); //$NON-NLS-1$
  /**
   * @generated
   */
  /**
   * @generated
   */
  public static final IElementType CaseItemTargetToolstep_3003 = getElementType("AsteriskSafletDesigner.diagram.CaseItemTargetActionStep_3003"); //$NON-NLS-1$

  /** @generated NOT */
  private static RenderedImage actionstepBackgroundImage;

  public static RenderedImage getActionstepBackgroundImage() {
    if (actionstepBackgroundImage == null) {
      URL url = FileLocator.find(AsteriskDiagramEditorPlugin.getDefault().getBundle(), new Path(
          "icons/toolsteps/ActionstepBackground.gif"), null); //$NON-NLS-1$
      actionstepBackgroundImage = RenderedImageFactory.getInstance(url);
    }
    return actionstepBackgroundImage;
  }

  /**
   * @generated
   */
  private static ImageRegistry getImageRegistry() {
    if (imageRegistry == null) {
      imageRegistry = new ImageRegistry();
    }
    return imageRegistry;
  }

  /**
   * @generated
   */
  private static String getImageRegistryKey(ENamedElement element) {
    return element.getName();
  }

  /**
   * @generated
   */
  private static ImageDescriptor getProvidedImageDescriptor(ENamedElement element) {
    if (element instanceof EStructuralFeature) {
      EStructuralFeature feature = ((EStructuralFeature) element);
      EClass eContainingClass = feature.getEContainingClass();
      EClassifier eType = feature.getEType();
      if (eContainingClass != null && !eContainingClass.isAbstract()) {
        element = eContainingClass;
      } else if (eType instanceof EClass && !((EClass) eType).isAbstract()) {
        element = eType;
      }
    }
    if (element instanceof EClass) {
      EClass eClass = (EClass) element;
      if (!eClass.isAbstract()) {
        return AsteriskDiagramEditorPlugin.getInstance().getItemImageDescriptor(
            eClass.getEPackage().getEFactoryInstance().create(eClass));
      }
    }
    // TODO : support structural features
    return null;
  }

  /**
   * @generated
   */
  public static ImageDescriptor getImageDescriptor(ENamedElement element) {
    String key = getImageRegistryKey(element);
    ImageDescriptor imageDescriptor = getImageRegistry().getDescriptor(key);
    if (imageDescriptor == null) {
      imageDescriptor = getProvidedImageDescriptor(element);
      if (imageDescriptor == null) {
        imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
      }
      getImageRegistry().put(key, imageDescriptor);
    }
    return imageDescriptor;
  }

  /**
   * @generated
   */
  public static Image getImage(ENamedElement element) {
    String key = getImageRegistryKey(element);
    Image image = getImageRegistry().get(key);
    if (image == null) {
      ImageDescriptor imageDescriptor = getProvidedImageDescriptor(element);
      if (imageDescriptor == null) {
        imageDescriptor = ImageDescriptor.getMissingImageDescriptor();
      }
      getImageRegistry().put(key, imageDescriptor);
      image = getImageRegistry().get(key);
    }
    return image;
  }

  /**
   * @generated
   */
  public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
    ENamedElement element = getElement(hint);
    if (element == null) {
      return null;
    }
    return getImageDescriptor(element);
  }

  /**
   * @generated
   */
  public static Image getImage(IAdaptable hint) {
    ENamedElement element = getElement(hint);
    if (element == null) {
      return null;
    }
    return getImage(element);
  }

  /**
   * Returns 'type' of the ecore object associated with the hint.
   * 
   * @generated
   */
  public static ENamedElement getElement(IAdaptable hint) {
    Object type = hint.getAdapter(IElementType.class);
    if (elements == null) {
      elements = new IdentityHashMap();

      elements.put(Handler_79, SafletPackage.eINSTANCE.getSaflet());

      elements.put(Answer_1001, ActionstepPackage.eINSTANCE.getAnswer());

      elements.put(Assignment_1002, ActionStepPackage.eINSTANCE.getAssignment());

      elements.put(Choice_1003, ActionStepPackage.eINSTANCE.getChoice());

      elements.put(GetFullVariable_1004, ActionstepPackage.eINSTANCE.getGetFullVariable());

      elements.put(MultiStreamAudio_1005, ActionstepPackage.eINSTANCE.getMultiStreamAudio());

      elements.put(Hangup_1006, ActionstepPackage.eINSTANCE.getHangup());

      elements.put(IfThen_1007, ActionStepPackage.eINSTANCE.getIfThen());

      elements.put(RecordFile_1008, ActionstepPackage.eINSTANCE.getRecordFile());

      elements.put(SayAlpha_1009, ActionstepPackage.eINSTANCE.getSayAlpha());

      elements.put(SayDateTime_1010, ActionstepPackage.eINSTANCE.getSayDateTime());

      elements.put(SayDigits_1011, ActionstepPackage.eINSTANCE.getSayDigits());

      elements.put(SayNumber_1012, ActionstepPackage.eINSTANCE.getSayNumber());

      elements.put(SayPhonetic_1013, ActionstepPackage.eINSTANCE.getSayPhonetic());

      elements.put(SayTime_1014, ActionstepPackage.eINSTANCE.getSayTime());

      elements.put(SetAutoHangup_1015, ActionstepPackage.eINSTANCE.getSetAutoHangup());

      elements.put(SetCallerId_1016, ActionstepPackage.eINSTANCE.getSetCallerId());

      elements.put(SetChannelVariable_1017, ActionstepPackage.eINSTANCE.getSetChannelVariable());

      elements.put(SetContext_1018, ActionstepPackage.eINSTANCE.getSetContext());

      elements.put(SetExtension_1019, ActionstepPackage.eINSTANCE.getSetExtension());

      elements.put(StopMusicOnHold_1020, ActionstepPackage.eINSTANCE.getStopMusicOnHold());

      elements.put(SetMusicOn_1021, ActionstepPackage.eINSTANCE.getSetMusicOn());

      elements.put(SetPriority_1022, ActionstepPackage.eINSTANCE.getSetPriority());

      elements.put(StreamAudio_1023, ActionstepPackage.eINSTANCE.getStreamAudio());

      elements.put(WaitForDigit_1024, ActionstepPackage.eINSTANCE.getWaitForDigit());

      elements.put(DIDMatcher_1025, InitiatorPackage.eINSTANCE.getDIDMatcher());

      elements.put(GetDigits_1026, ActionstepPackage.eINSTANCE.getGetDigits());

      elements.put(OriginateCall_1027, ActionstepPackage.eINSTANCE.getOriginateCall());

      elements.put(PlayDTMF_1028, ActionstepPackage.eINSTANCE.getPlayDTMF());

      elements.put(RecordCall_1029, ActionstepPackage.eINSTANCE.getRecordCall());

      elements.put(ExecuteApplication_1030, ActionstepPackage.eINSTANCE.getExecuteApplication());

      elements.put(PlayMusicOnHold_1031, ActionstepPackage.eINSTANCE.getPlayMusicOnHold());

      elements.put(PromptGetDigits_1032, ActionstepPackage.eINSTANCE.getPromptGetDigits());

      elements.put(Sleep_1033, ActionstepPackage.eINSTANCE.getSleep());

      elements.put(StreamAudioExtended_1034, ActionstepPackage.eINSTANCE.getStreamAudioExtended());

      elements.put(IncomingCall_1035, InitiatorPackage.eINSTANCE.getIncomingCall());

      elements.put(GetCallInfo_1036, ActionstepPackage.eINSTANCE.getGetCallInfo());

      elements.put(ExecuteScript_1037, ActionStepPackage.eINSTANCE.getExecuteScript());

      elements.put(InvokeSaflet_1038, ActionStepPackage.eINSTANCE.getInvokeSaflet());

      elements.put(Dial_1039, ActionstepPackage.eINSTANCE.getDial());

      elements.put(Pickup_1040, ActionstepPackage.eINSTANCE.getPickup());

      elements.put(Background_1041, ActionstepPackage.eINSTANCE.getBackground());

      elements.put(BackgroundDetect_1042, ActionstepPackage.eINSTANCE.getBackgroundDetect());

      elements.put(WaitExten_1043, ActionstepPackage.eINSTANCE.getWaitExten());

      elements.put(SoftHangup_1044, ActionstepPackage.eINSTANCE.getSoftHangup());

      elements.put(PickupChan_1045, ActionstepPackage.eINSTANCE.getPickupChan());

      elements.put(Pickdown_1046, ActionstepPackage.eINSTANCE.getPickdown());

      elements.put(Progress_1047, ActionstepPackage.eINSTANCE.getProgress());

      elements.put(Bridge_1048, ActionstepPackage.eINSTANCE.getBridge());

      elements.put(PlaceCall_1049, ActionstepPackage.eINSTANCE.getPlaceCall());

      elements.put(Voicemail_1050, ActionstepPackage.eINSTANCE.getVoicemail());

      elements.put(VoicemailMain_1051, ActionstepPackage.eINSTANCE.getVoicemailMain());

      elements.put(VMAuthenticate_1052, ActionstepPackage.eINSTANCE.getVMAuthenticate());

      elements.put(MeetMe_1053, ActionstepPackage.eINSTANCE.getMeetMe());

      elements.put(MeetMeAdmin_1054, ActionstepPackage.eINSTANCE.getMeetMeAdmin());

      elements.put(MeetMeCount_1055, ActionstepPackage.eINSTANCE.getMeetMeCount());

      elements.put(DebugLog_1056, ActionStepPackage.eINSTANCE.getDebugLog());

      elements.put(WaitForRing_1057, ActionstepPackage.eINSTANCE.getWaitForRing());

      elements.put(WaitMusicOnHold_1058, ActionstepPackage.eINSTANCE.getWaitMusicOnHold());

      elements.put(GetAvailableChannel_1059, ActionstepPackage.eINSTANCE.getGetAvailableChannel());

      elements.put(Congestion_1060, ActionstepPackage.eINSTANCE.getCongestion());

      elements.put(Ringing_1061, ActionstepPackage.eINSTANCE.getRinging());

      elements.put(SetCallerPresentation_1062, ActionstepPackage.eINSTANCE
          .getSetCallerPresentation());

      elements.put(SetGlobalVariable_1063, ActionstepPackage.eINSTANCE.getSetGlobalVariable());

      elements.put(Echo_1064, ActionstepPackage.eINSTANCE.getEcho());

      elements.put(Festival_1065, ActionstepPackage.eINSTANCE.getFestival());

      elements.put(Playtones_1066, ActionstepPackage.eINSTANCE.getPlaytones());

      elements.put(StopPlaytones_1067, ActionstepPackage.eINSTANCE.getStopPlaytones());

      elements.put(ChanSpy_1068, ActionstepPackage.eINSTANCE.getChanSpy());

      elements.put(Dictate_1069, ActionstepPackage.eINSTANCE.getDictate());

      elements.put(ExtensionSpy_1070, ActionstepPackage.eINSTANCE.getExtensionSpy());

      elements.put(MixMonitor_1071, ActionstepPackage.eINSTANCE.getMixMonitor());

      elements.put(StopMixmonitor_1072, ActionstepPackage.eINSTANCE.getStopMixmonitor());

      elements.put(StopMonitor_1073, ActionstepPackage.eINSTANCE.getStopMonitor());

      elements.put(Monitor_1074, ActionstepPackage.eINSTANCE.getMonitor());

      elements.put(Directory_1075, ActionstepPackage.eINSTANCE.getDirectory());

      elements.put(Transfer_1076, ActionstepPackage.eINSTANCE.getTransfer());

      elements.put(OpenDBConnection_1077, ActionStepPackage.eINSTANCE.getOpenDBConnection());

      elements.put(CloseDBConnection_1078, ActionStepPackage.eINSTANCE.getCloseDBConnection());

      elements.put(OpenQuery_1079, ActionStepPackage.eINSTANCE.getOpenQuery());

      elements.put(SetQueryParam_1080, ActionStepPackage.eINSTANCE.getSetQueryParam());

      elements.put(ExecuteUpdate_1081, ActionStepPackage.eINSTANCE.getExecuteUpdate());

      elements.put(ExecuteQuery_1082, ActionStepPackage.eINSTANCE.getExecuteQuery());

      elements.put(NextRow_1083, ActionStepPackage.eINSTANCE.getNextRow());

      elements.put(GetColValue_1084, ActionStepPackage.eINSTANCE.getGetColValue());

      elements.put(SetColValue_1085, ActionStepPackage.eINSTANCE.getSetColValue());

      elements.put(UpdatetRow_1086, ActionStepPackage.eINSTANCE.getUpdatetRow());

      elements.put(MoveToRow_1087, ActionStepPackage.eINSTANCE.getMoveToRow());

      elements.put(MoveToLastRow_1088, ActionStepPackage.eINSTANCE.getMoveToLastRow());

      elements.put(DeleteRow_1089, ActionStepPackage.eINSTANCE.getDeleteRow());

      elements.put(MoveToInsertRow_1090, ActionStepPackage.eINSTANCE.getMoveToInsertRow());

      elements.put(InsertRow_1091, ActionStepPackage.eINSTANCE.getInsertRow());

      elements.put(MoveToFirstRow_1092, ActionStepPackage.eINSTANCE.getMoveToFirstRow());

      elements.put(PreviousRow_1093, ActionStepPackage.eINSTANCE.getPreviousRow());

      elements.put(GetColValues_1094, ActionStepPackage.eINSTANCE.getGetColValues());

      elements.put(SetColValues_1095, ActionStepPackage.eINSTANCE.getSetColValues());

      elements.put(ExtensionTransfer_1096, ActionstepPackage.eINSTANCE.getExtensionTransfer());

      elements.put(RunQuery_1097, ActionStepPackage.eINSTANCE.getRunQuery());

      elements.put(Output_2001, ActionStepPackage.eINSTANCE.getOutput());

      elements.put(CaseItem_2002, ActionStepPackage.eINSTANCE.getCaseItem());

      elements.put(AudioFileItem_2003, ActionStepPackage.eINSTANCE.getAudioFileItem());

      elements.put(GetColMapping_2004, ActionStepPackage.eINSTANCE.getGetColMapping());

      elements.put(SetColMapping_2005, ActionStepPackage.eINSTANCE.getSetColMapping());

      elements.put(QueryParamMapping_2006, ActionStepPackage.eINSTANCE.getQueryParamMapping());

      elements.put(OutputTarget_3001, ActionStepPackage.eINSTANCE.getOutput_Target());

      // elements.put(InitiatorNextToolstep_3002, InitiatorPackage.eINSTANCE
      // .getInitiator_NextToolstep());

      elements.put(CaseItemTargetToolstep_3003, ActionStepPackage.eINSTANCE
          .getItem_TargetActionStep());
    }
    return (ENamedElement) elements.get(type);
  }

  /**
   * @generated
   */
  private static IElementType getElementType(String id) {
    return ElementTypeRegistry.getInstance().getType(id);
  }

  /**
   * @generated
   */
  public static boolean isKnownElementType(IElementType elementType) {
    if (KNOWN_ELEMENT_TYPES == null) {
      KNOWN_ELEMENT_TYPES = new HashSet();
      KNOWN_ELEMENT_TYPES.add(Handler_79);
      KNOWN_ELEMENT_TYPES.add(Answer_1001);
      KNOWN_ELEMENT_TYPES.add(Assignment_1002);
      KNOWN_ELEMENT_TYPES.add(Choice_1003);
      KNOWN_ELEMENT_TYPES.add(GetFullVariable_1004);
      KNOWN_ELEMENT_TYPES.add(MultiStreamAudio_1005);
      KNOWN_ELEMENT_TYPES.add(Hangup_1006);
      KNOWN_ELEMENT_TYPES.add(IfThen_1007);
      KNOWN_ELEMENT_TYPES.add(RecordFile_1008);
      KNOWN_ELEMENT_TYPES.add(SayAlpha_1009);
      KNOWN_ELEMENT_TYPES.add(SayDateTime_1010);
      KNOWN_ELEMENT_TYPES.add(SayDigits_1011);
      KNOWN_ELEMENT_TYPES.add(SayNumber_1012);
      KNOWN_ELEMENT_TYPES.add(SayPhonetic_1013);
      KNOWN_ELEMENT_TYPES.add(SayTime_1014);
      KNOWN_ELEMENT_TYPES.add(SetAutoHangup_1015);
      KNOWN_ELEMENT_TYPES.add(SetCallerId_1016);
      KNOWN_ELEMENT_TYPES.add(SetChannelVariable_1017);
      KNOWN_ELEMENT_TYPES.add(SetContext_1018);
      KNOWN_ELEMENT_TYPES.add(SetExtension_1019);
      KNOWN_ELEMENT_TYPES.add(StopMusicOnHold_1020);
      KNOWN_ELEMENT_TYPES.add(SetMusicOn_1021);
      KNOWN_ELEMENT_TYPES.add(SetPriority_1022);
      KNOWN_ELEMENT_TYPES.add(StreamAudio_1023);
      KNOWN_ELEMENT_TYPES.add(WaitForDigit_1024);
      KNOWN_ELEMENT_TYPES.add(DIDMatcher_1025);
      KNOWN_ELEMENT_TYPES.add(GetDigits_1026);
      KNOWN_ELEMENT_TYPES.add(OriginateCall_1027);
      KNOWN_ELEMENT_TYPES.add(PlayDTMF_1028);
      KNOWN_ELEMENT_TYPES.add(RecordCall_1029);
      KNOWN_ELEMENT_TYPES.add(ExecuteApplication_1030);
      KNOWN_ELEMENT_TYPES.add(PlayMusicOnHold_1031);
      KNOWN_ELEMENT_TYPES.add(PromptGetDigits_1032);
      KNOWN_ELEMENT_TYPES.add(Sleep_1033);
      KNOWN_ELEMENT_TYPES.add(StreamAudioExtended_1034);
      KNOWN_ELEMENT_TYPES.add(IncomingCall_1035);
      KNOWN_ELEMENT_TYPES.add(GetCallInfo_1036);
      KNOWN_ELEMENT_TYPES.add(ExecuteScript_1037);
      KNOWN_ELEMENT_TYPES.add(InvokeSaflet_1038);
      KNOWN_ELEMENT_TYPES.add(Dial_1039);
      KNOWN_ELEMENT_TYPES.add(Pickup_1040);
      KNOWN_ELEMENT_TYPES.add(Background_1041);
      KNOWN_ELEMENT_TYPES.add(BackgroundDetect_1042);
      KNOWN_ELEMENT_TYPES.add(WaitExten_1043);
      KNOWN_ELEMENT_TYPES.add(SoftHangup_1044);
      KNOWN_ELEMENT_TYPES.add(PickupChan_1045);
      KNOWN_ELEMENT_TYPES.add(Pickdown_1046);
      KNOWN_ELEMENT_TYPES.add(Progress_1047);
      KNOWN_ELEMENT_TYPES.add(Bridge_1048);
      KNOWN_ELEMENT_TYPES.add(PlaceCall_1049);
      KNOWN_ELEMENT_TYPES.add(Voicemail_1050);
      KNOWN_ELEMENT_TYPES.add(VoicemailMain_1051);
      KNOWN_ELEMENT_TYPES.add(VMAuthenticate_1052);
      KNOWN_ELEMENT_TYPES.add(MeetMe_1053);
      KNOWN_ELEMENT_TYPES.add(MeetMeAdmin_1054);
      KNOWN_ELEMENT_TYPES.add(MeetMeCount_1055);
      KNOWN_ELEMENT_TYPES.add(DebugLog_1056);
      KNOWN_ELEMENT_TYPES.add(WaitForRing_1057);
      KNOWN_ELEMENT_TYPES.add(WaitMusicOnHold_1058);
      KNOWN_ELEMENT_TYPES.add(GetAvailableChannel_1059);
      KNOWN_ELEMENT_TYPES.add(Congestion_1060);
      KNOWN_ELEMENT_TYPES.add(Ringing_1061);
      KNOWN_ELEMENT_TYPES.add(SetCallerPresentation_1062);
      KNOWN_ELEMENT_TYPES.add(SetGlobalVariable_1063);
      KNOWN_ELEMENT_TYPES.add(Echo_1064);
      KNOWN_ELEMENT_TYPES.add(Festival_1065);
      KNOWN_ELEMENT_TYPES.add(Playtones_1066);
      KNOWN_ELEMENT_TYPES.add(StopPlaytones_1067);
      KNOWN_ELEMENT_TYPES.add(ChanSpy_1068);
      KNOWN_ELEMENT_TYPES.add(Dictate_1069);
      KNOWN_ELEMENT_TYPES.add(ExtensionSpy_1070);
      KNOWN_ELEMENT_TYPES.add(MixMonitor_1071);
      KNOWN_ELEMENT_TYPES.add(StopMixmonitor_1072);
      KNOWN_ELEMENT_TYPES.add(StopMonitor_1073);
      KNOWN_ELEMENT_TYPES.add(Monitor_1074);
      KNOWN_ELEMENT_TYPES.add(Directory_1075);
      KNOWN_ELEMENT_TYPES.add(Transfer_1076);
      KNOWN_ELEMENT_TYPES.add(OpenDBConnection_1077);
      KNOWN_ELEMENT_TYPES.add(CloseDBConnection_1078);
      KNOWN_ELEMENT_TYPES.add(OpenQuery_1079);
      KNOWN_ELEMENT_TYPES.add(SetQueryParam_1080);
      KNOWN_ELEMENT_TYPES.add(ExecuteUpdate_1081);
      KNOWN_ELEMENT_TYPES.add(ExecuteQuery_1082);
      KNOWN_ELEMENT_TYPES.add(NextRow_1083);
      KNOWN_ELEMENT_TYPES.add(GetColValue_1084);
      KNOWN_ELEMENT_TYPES.add(SetColValue_1085);
      KNOWN_ELEMENT_TYPES.add(UpdatetRow_1086);
      KNOWN_ELEMENT_TYPES.add(MoveToRow_1087);
      KNOWN_ELEMENT_TYPES.add(MoveToLastRow_1088);
      KNOWN_ELEMENT_TYPES.add(DeleteRow_1089);
      KNOWN_ELEMENT_TYPES.add(MoveToInsertRow_1090);
      KNOWN_ELEMENT_TYPES.add(InsertRow_1091);
      KNOWN_ELEMENT_TYPES.add(MoveToFirstRow_1092);
      KNOWN_ELEMENT_TYPES.add(PreviousRow_1093);
      KNOWN_ELEMENT_TYPES.add(GetColValues_1094);
      KNOWN_ELEMENT_TYPES.add(SetColValues_1095);
      KNOWN_ELEMENT_TYPES.add(ExtensionTransfer_1096);
      KNOWN_ELEMENT_TYPES.add(RunQuery_1097);
      KNOWN_ELEMENT_TYPES.add(Output_2001);
      KNOWN_ELEMENT_TYPES.add(CaseItem_2002);
      KNOWN_ELEMENT_TYPES.add(AudioFileItem_2003);
      KNOWN_ELEMENT_TYPES.add(GetColMapping_2004);
      KNOWN_ELEMENT_TYPES.add(SetColMapping_2005);
      KNOWN_ELEMENT_TYPES.add(QueryParamMapping_2006);
      KNOWN_ELEMENT_TYPES.add(OutputTarget_3001);
      KNOWN_ELEMENT_TYPES.add(CaseItemTargetToolstep_3003);
    }
    return KNOWN_ELEMENT_TYPES.contains(elementType);
  }

  public static Map getElements() {
    return elements;
  }

  public static Set getKnownElementTypes() {
    return KNOWN_ELEMENT_TYPES;
  }

}
