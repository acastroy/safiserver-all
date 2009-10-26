package com.safi.workshop.actionpak1.factory;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;

import com.safi.workshop.actionpak1.editpart.CustomInitiatorEditPart;
import com.safi.workshop.actionpak1.editpart.CustomInitiatorNameEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemLabelTextEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemPanelEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemLabelTextEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemPanelEditPart;
import com.safi.workshop.view.factories.ActionPakViewFactory;
import com.safi.workshop.view.factories.ActionstepNameLabelViewFactory;

public class CustomInitiatorActionPakViewFactory implements ActionPakViewFactory {

  public CustomInitiatorActionPakViewFactory() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public BasicNodeViewFactory createShapeViewFactory(int id) {
    
    if (id == CustomInitiatorNameEditPart.VISUAL_ID)
      return new ActionstepNameLabelViewFactory();
    else
    if (id == CustomInitiatorEditPart.VISUAL_ID)
      return new CustomInitiatorViewFactory();
    else if (id == InputItemLabelTextEditPart.VISUAL_ID)
      return new ActionstepNameLabelViewFactory();
    else if (id == InputItemEditPart.VISUAL_ID)
      return new com.safi.workshop.actionpak1.factory.InputItemViewFactory();
    else if (id == InputItemPanelEditPart.VISUAL_ID)
      return new InputItemPanelViewFactory();
    
    else if (id == OutputItemLabelTextEditPart.VISUAL_ID)
      return new ActionstepNameLabelViewFactory();
    else if (id == OutputItemEditPart.VISUAL_ID)
      return new com.safi.workshop.actionpak1.factory.OutputItemViewFactory();
    else if (id == OutputItemPanelEditPart.VISUAL_ID)
      return new OutputItemPanelViewFactory();
    return null;
    
  }

}
