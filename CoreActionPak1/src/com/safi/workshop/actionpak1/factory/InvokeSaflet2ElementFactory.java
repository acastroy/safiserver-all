package com.safi.workshop.actionpak1.factory;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import com.safi.workshop.actionpak1.ElementTypes;
import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.actionpak1.editpart.InvokeSaflet2EditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemEditPart;
import com.safi.workshop.view.factories.ActionstepElementFactory;

public class InvokeSaflet2ElementFactory implements ActionstepElementFactory {

  @Override
  public IElementType getElementType(int id) {
    if (id == InvokeSaflet2EditPart.VISUAL_ID)
      return ElementTypes.elementType_InvokeSaflet2_10004;
    else
    if (id == InputItemEditPart.VISUAL_ID)
      return ElementTypes.elementType_InputItem_50001;
    if (id == OutputItemEditPart.VISUAL_ID)
      return ElementTypes.elementType_OutputItem_50002;
    return null;
  }

}
