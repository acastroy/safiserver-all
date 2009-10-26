package com.safi.workshop.actionpak1;

import org.eclipse.emf.ecore.EObject;

import com.safi.workshop.model.actionpak1.Actionpak1Factory;
import com.safi.workshop.view.factories.ActionstepModelFactory;

public class ActionstepTestModelFactory implements ActionstepModelFactory {

  @Override
  public EObject getModel(int id) {
    if (id == ActionstepTestEditPart.VISUAL_ID)
    return Actionpak1Factory.eINSTANCE.createActionstepTest();
    return null;
  }

}
