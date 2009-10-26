package com.safi.workshop.actionpak1;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import com.safi.workshop.view.factories.ActionstepElementFactory;

public class ActionstepTestElementFactory implements ActionstepElementFactory {


  public IElementType getElementType(int id){
    if (id == ActionstepTestEditPart.VISUAL_ID)
      return ElementTypes.elementType_ActionstepTest_10000;
    return null;
  }
}
