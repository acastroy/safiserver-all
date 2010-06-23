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
	public static final IElementType Assignment_1002 = getElementType("AsteriskSafletDesigner.diagram.Assignment_1002"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Choice_1003 = getElementType("AsteriskSafletDesigner.diagram.Choice_1003"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType IfThen_1007 = getElementType("AsteriskSafletDesigner.diagram.IfThen_1007"); //$NON-NLS-1$

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
	public static final IElementType DebugLog_1056 = getElementType("AsteriskSafletDesigner.diagram.DebugLog_1056"); //$NON-NLS-1$

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

			elements.put(Assignment_1002, ActionStepPackage.eINSTANCE.getAssignment());

			elements.put(Choice_1003, ActionStepPackage.eINSTANCE.getChoice());

			elements.put(IfThen_1007, ActionStepPackage.eINSTANCE.getIfThen());

			elements.put(ExecuteScript_1037, ActionStepPackage.eINSTANCE.getExecuteScript());

			elements.put(InvokeSaflet_1038, ActionStepPackage.eINSTANCE.getInvokeSaflet());

			elements.put(DebugLog_1056, ActionStepPackage.eINSTANCE.getDebugLog());

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

			elements.put(RunQuery_1097, ActionStepPackage.eINSTANCE.getRunQuery());

			elements.put(Output_2001, ActionStepPackage.eINSTANCE.getOutput());

			elements.put(CaseItem_2002, ActionStepPackage.eINSTANCE.getCaseItem());

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
			KNOWN_ELEMENT_TYPES.add(Assignment_1002);
			KNOWN_ELEMENT_TYPES.add(Choice_1003);
			KNOWN_ELEMENT_TYPES.add(IfThen_1007);
			KNOWN_ELEMENT_TYPES.add(ExecuteScript_1037);
			KNOWN_ELEMENT_TYPES.add(InvokeSaflet_1038);
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
			KNOWN_ELEMENT_TYPES.add(RunQuery_1097);
			KNOWN_ELEMENT_TYPES.add(Output_2001);
			KNOWN_ELEMENT_TYPES.add(CaseItem_2002);
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
