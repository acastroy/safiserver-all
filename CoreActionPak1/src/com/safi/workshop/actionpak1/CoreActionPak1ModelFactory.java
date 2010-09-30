package com.safi.workshop.actionpak1;

import org.eclipse.emf.ecore.EObject;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.workshop.edit.parts.InputItemEditPart;
import com.safi.workshop.edit.parts.OutputItemEditPart;
import com.safi.workshop.model.actionpak1.Actionpak1Factory;
import com.safi.workshop.view.factories.ActionPakModelFactory;

public class CoreActionPak1ModelFactory implements ActionPakModelFactory {

	@Override
	public EObject getModel(int id) {
		switch (id){
			case InputItemEditPart.VISUAL_ID:
				return ActionStepFactory.eINSTANCE.createInputItem();
			case OutputItemEditPart.VISUAL_ID:
				return ActionStepFactory.eINSTANCE.createOutputParameter();
			case CoreActionPak1Ids.Finally:
				return ActionStepFactory.eINSTANCE.createFinally();
			case CoreActionPak1Ids.ScheduleSaflet:
				return Actionpak1Factory.eINSTANCE.createScheduleSaflet();
			case CoreActionPak1Ids.UnscheduleSaflet:
				return Actionpak1Factory.eINSTANCE.createUnscheduleSaflet();
			
		}
		System.err.println("HEYYYAH....couldn't create coreactionpak1 model for id "+id);
		return null;
	}

}
