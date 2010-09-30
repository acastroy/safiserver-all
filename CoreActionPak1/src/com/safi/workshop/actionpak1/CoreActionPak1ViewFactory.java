package com.safi.workshop.actionpak1;

import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;

import com.safi.workshop.edit.parts.ActionStepItemLabelTextEditPart;
import com.safi.workshop.edit.parts.ActionStepNameEditPart;
import com.safi.workshop.edit.parts.InputItemEditPart;
import com.safi.workshop.edit.parts.InputItemLabelTextEditPart;
import com.safi.workshop.edit.parts.InputItemPanelEditPart;
import com.safi.workshop.edit.parts.OutputItemEditPart;
import com.safi.workshop.edit.parts.OutputItemLabelTextEditPart;
import com.safi.workshop.edit.parts.OutputItemPanelEditPart;
import com.safi.workshop.view.factories.ActionPakViewFactoryFactory;
import com.safi.workshop.view.factories.ActionstepNameLabelViewFactory;
import com.safi.workshop.view.factories.ActionstepViewFactory;
import com.safi.workshop.view.factories.InputItemPanelViewFactory;
import com.safi.workshop.view.factories.InputItemViewFactory;
import com.safi.workshop.view.factories.OutputItemPanelViewFactory;
import com.safi.workshop.view.factories.OutputItemViewFactory;

public class CoreActionPak1ViewFactory implements ActionPakViewFactoryFactory {

	private Map<Integer, BasicNodeViewFactory> factoryCache = new WeakHashMap<Integer, BasicNodeViewFactory>();

	@Override
	public BasicNodeViewFactory createShapeViewFactory(int id) {
		BasicNodeViewFactory f = factoryCache.get(id);
		if (f != null)
			return f;

		f = createShapeViewFactoryInternal(id);
		if (f != null)
			factoryCache.put(id, f);
		return f;

	}
	
	private BasicNodeViewFactory createShapeViewFactoryInternal(int id) {
		switch (id) {
			case CoreActionPak1Ids.Finally:
				return new ActionstepViewFactory(id, ActionStepNameEditPart.VISUAL_ID,	null);
			case CoreActionPak1Ids.ScheduleSaflet:
				return new ActionstepViewFactory(id, ActionStepNameEditPart.VISUAL_ID,	Collections.singletonList(InputItemPanelEditPart.VISUAL_ID));
			case InputItemEditPart.VISUAL_ID:
				return new InputItemViewFactory();
			case OutputItemEditPart.VISUAL_ID:
				return new OutputItemViewFactory();
			case InputItemPanelEditPart.VISUAL_ID:
				return new InputItemPanelViewFactory();
			case InputItemLabelTextEditPart.VISUAL_ID:
				return new ActionstepNameLabelViewFactory();
			case ActionStepItemLabelTextEditPart.VISUAL_ID:
    		return new ActionstepNameLabelViewFactory();
			case ActionStepNameEditPart.VISUAL_ID:
				return new ActionstepNameLabelViewFactory();
			case OutputItemPanelEditPart.VISUAL_ID:
				return new OutputItemPanelViewFactory();
			case OutputItemLabelTextEditPart.VISUAL_ID:
				return new ActionstepNameLabelViewFactory();
			
		}
		System.err.println("castel WOOOPS couldn't find view factory for id "+id);
		return null;
	}

}
