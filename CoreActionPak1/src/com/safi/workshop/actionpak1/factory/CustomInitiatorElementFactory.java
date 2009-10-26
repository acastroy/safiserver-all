package com.safi.workshop.actionpak1.factory;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import com.safi.workshop.actionpak1.ElementTypes;
import com.safi.workshop.actionpak1.editpart.CustomInitiatorEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemEditPart;
import com.safi.workshop.view.factories.ActionstepElementFactory;

public class CustomInitiatorElementFactory implements ActionstepElementFactory {

  @Override
  public IElementType getElementType(int id) {
    if (id == CustomInitiatorEditPart.VISUAL_ID)
      return ElementTypes.elementType_CustomInitiator_10002;
    else
    if (id == InputItemEditPart.VISUAL_ID)
      return ElementTypes.elementType_InputItem_50001;
    if (id == OutputItemEditPart.VISUAL_ID)
      return ElementTypes.elementType_OutputItem_50002;
    return null;
  }

}
