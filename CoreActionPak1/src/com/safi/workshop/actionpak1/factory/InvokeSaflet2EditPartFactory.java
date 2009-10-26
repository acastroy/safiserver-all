package com.safi.workshop.actionpak1.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemLabelTextEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemPanelEditPart;
import com.safi.workshop.actionpak1.editpart.InvokeSaflet2EditPart;
import com.safi.workshop.actionpak1.editpart.InvokeSaflet2NameEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemLabelTextEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemPanelEditPart;
import com.safi.workshop.view.factories.ActionPakEditPartFactory;

public class InvokeSaflet2EditPartFactory implements ActionPakEditPartFactory {

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
    if (id == InputItemPanelEditPart.VISUAL_ID)
      return new InputItemPanelEditPart(view);
    else if (id == OutputItemEditPart.VISUAL_ID)
      return new OutputItemEditPart(view);
    else if (id == OutputItemLabelTextEditPart.VISUAL_ID)
      return new OutputItemLabelTextEditPart(view);
    else if (id == OutputItemPanelEditPart.VISUAL_ID)
      return new OutputItemPanelEditPart(view);
    return null;
  }

}
