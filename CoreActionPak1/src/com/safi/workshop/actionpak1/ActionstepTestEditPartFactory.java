package com.safi.workshop.actionpak1;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.view.factories.ActionstepEditPartFactory;

public class ActionstepTestEditPartFactory implements ActionstepEditPartFactory {

  @Override
  public EditPart createEditPart(View view, int id) {
    if (id == ActionstepTestEditPart.VISUAL_ID)
      return new ActionstepTestEditPart(view);
    else
    if (id == ActionstepTestNameEditPart.VISUAL_ID)
      return new ActionstepTestNameEditPart(view);
    return null;
  }

}
