package com.safi.workshop.actionpak1.factory;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import com.safi.workshop.actionpak1.ElementTypes;
import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.actionpak1.editpart.ManagerActionEditPart;
import com.safi.workshop.view.factories.ActionstepElementFactory;

public class ManagerActionElementFactory implements ActionstepElementFactory {

  @Override
  public IElementType getElementType(int id) {
    if (id == ManagerActionEditPart.VISUAL_ID)
      return ElementTypes.elementType_ManagerAction_10005;
    else
    if (id == InputItemEditPart.VISUAL_ID)
      return ElementTypes.elementType_InputItem_50001;
//    if (id == PropertyMappingItemEditPart.VISUAL_ID)
//      return ElementTypes.elementType_PropertyMappingItem_50003;
//    
    System.err.println("Coulldn't find damn elemtype for id "+id);
    return null;
  }

}
