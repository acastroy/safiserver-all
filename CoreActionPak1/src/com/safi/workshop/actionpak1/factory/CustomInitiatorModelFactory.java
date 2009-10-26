package com.safi.workshop.actionpak1.factory;

import org.eclipse.emf.ecore.EObject;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.workshop.actionpak1.editpart.CustomInitiatorEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemEditPart;
import com.safi.workshop.model.actionpak1.Actionpak1Factory;
import com.safi.workshop.view.factories.ActionstepModelFactory;

public class CustomInitiatorModelFactory implements ActionstepModelFactory {

  @Override
  public EObject getModel(int id) {
    if (id == CustomInitiatorEditPart.VISUAL_ID)
      return Actionpak1Factory.eINSTANCE.createCustomInitiator();
    else
    if (id == InputItemEditPart.VISUAL_ID)
      return ActionStepFactory.eINSTANCE.createInputItem();
    if (id == OutputItemEditPart.VISUAL_ID)
      return ActionStepFactory.eINSTANCE.createOutputParameter();
    return null;
  }

}
