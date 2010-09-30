package com.safi.workshop.actionpak1;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import com.safi.workshop.edit.parts.InputItemEditPart;
import com.safi.workshop.edit.parts.OutputItemEditPart;
import com.safi.workshop.view.factories.ActionPakElementFactory;

public class CoreActionPak1ElementFactory implements ActionPakElementFactory {

	@Override
	public IElementType getElementType(int id) {
		switch (id) {

			case InputItemEditPart.VISUAL_ID:
				return com.safi.workshop.actionpak1.ElementTypes.elementType_InputItem_50001;
			case OutputItemEditPart.VISUAL_ID:
				return com.safi.workshop.actionpak1.ElementTypes.elementType_OutputItem_50002;
			case CoreActionPak1Ids.Finally:
				return ElementTypes.elementType_Finally_10006;
			case CoreActionPak1Ids.ScheduleSaflet:
				return ElementTypes.elementType_ScheduleSaflet_10007;
		
		}
		System.err.println("WORNING! coodnt find actiopakka1 element type for "+id);
		return null;
	}

}
