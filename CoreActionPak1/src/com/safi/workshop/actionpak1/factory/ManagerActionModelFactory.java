package com.safi.workshop.actionpak1.factory;

import org.eclipse.emf.ecore.EObject;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.actionpak1.editpart.ManagerActionEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemEditPart;
import com.safi.workshop.model.actionpak1.Actionpak1Factory;
import com.safi.workshop.view.factories.ActionstepModelFactory;

public class ManagerActionModelFactory implements ActionstepModelFactory {

  @Override
  public EObject getModel(int id) {
    if (id == ManagerActionEditPart.VISUAL_ID)
        return     Actionpak1Factory.eINSTANCE.createManagerAction();
    	//return WebservicesFactory.eINSTANCE.createCallWSByWSDL();
    else
    if (id == InputItemEditPart.VISUAL_ID)
      return ActionStepFactory.eINSTANCE.createInputItem();
    if (id == OutputItemEditPart.VISUAL_ID)
        return ActionStepFactory.eINSTANCE.createOutputParameter();
//    else
//    if (id == PropertyMappingItemEditPart.VISUAL_ID)
//      return WebservicesFactory.eINSTANCE.createPropertyMappingItem();
//    
    System.err.println("Coulldn't find damn model for id "+id);
    return null;
  }

}
