package com.safi.workshop.actionpak1.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.actionpak1.editpart.InvokeSaflet2EditPart;
import com.safi.workshop.actionpak1.editpart.InvokeSaflet2NameEditPart;
import com.safi.workshop.actionpak1.editpart.InvokeSafletInputItemPanelEditPart;
import com.safi.workshop.actionpak1.editpart.InvokeSafletOutputItemPanelEditPart;
import com.safi.workshop.edit.parts.InputItemEditPart;
import com.safi.workshop.edit.parts.InputItemLabelTextEditPart;
import com.safi.workshop.edit.parts.InputItemPanelEditPart;
import com.safi.workshop.edit.parts.OutputItemEditPart;
import com.safi.workshop.edit.parts.OutputItemLabelTextEditPart;
import com.safi.workshop.edit.parts.OutputItemPanelEditPart;
import com.safi.workshop.view.factories.ActionstepEditPartFactory;

public class InvokeSaflet2EditPartFactory implements ActionstepEditPartFactory {

  @Override
  public EditPart createEditPart(View view, int id) {
    if (id == InvokeSaflet2EditPart.VISUAL_ID)
      return new InvokeSaflet2EditPart(view);
    else
    if (id == InvokeSaflet2NameEditPart.VISUAL_ID)
      return new InvokeSaflet2NameEditPart(view);
    else
    if (id == InputItemEditPart.VISUAL_ID)
      return new InputItemEditPart(view);
    else
    if (id == InputItemLabelTextEditPart.VISUAL_ID)
      return new InputItemLabelTextEditPart(view);
    else
    if (id == InvokeSafletInputItemPanelEditPart.VISUAL_ID)
      return new InvokeSafletInputItemPanelEditPart(view);
    else if (id == OutputItemEditPart.VISUAL_ID)
      return new OutputItemEditPart(view);
    else if (id == OutputItemLabelTextEditPart.VISUAL_ID)
      return new OutputItemLabelTextEditPart(view);
    else if (id == InvokeSafletOutputItemPanelEditPart.VISUAL_ID)
      return new InvokeSafletOutputItemPanelEditPart(view);
    return null;
  }

}
