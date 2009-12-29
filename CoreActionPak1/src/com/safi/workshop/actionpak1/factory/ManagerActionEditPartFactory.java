package com.safi.workshop.actionpak1.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemLabelTextEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemPanelEditPart;
import com.safi.workshop.actionpak1.editpart.ManagerActionEditPart;
import com.safi.workshop.actionpak1.editpart.ManagerActionNameEditPart;
import com.safi.workshop.view.factories.ActionPakEditPartFactory;

public class ManagerActionEditPartFactory implements ActionPakEditPartFactory {

  @Override
  public EditPart createEditPart(View view, int id) {
    if (id == ManagerActionEditPart.VISUAL_ID)
      return new ManagerActionEditPart(view);
    else
    if (id == ManagerActionNameEditPart.VISUAL_ID)
      return new ManagerActionNameEditPart(view);
    else
    if (id == InputItemEditPart.VISUAL_ID)
      return new InputItemEditPart(view);
    else
    if (id == InputItemLabelTextEditPart.VISUAL_ID)
      return new InputItemLabelTextEditPart(view);
    else
    if (id == InputItemPanelEditPart.VISUAL_ID)
      return new InputItemPanelEditPart(view);
//    else if (id == PropertyMappingItemLabelTextEditPart.VISUAL_ID)
//      return new PropertyMappingItemLabelTextEditPart(view);
//    else if (id == PropertyMappingItemPanelEditPart.VISUAL_ID)
//      return new PropertyMappingItemPanelEditPart(view);
//    
//    else if (id == PropertyMappingItemEditPart.VISUAL_ID)
//    	return new PropertyMappingItemEditPart(view);
//    
    System.err.println("Couldn't find dam editpart for id "+id);
    return null;
  }

}
