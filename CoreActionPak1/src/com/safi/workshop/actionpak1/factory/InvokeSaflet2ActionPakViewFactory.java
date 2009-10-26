package com.safi.workshop.actionpak1.factory;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;

import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemLabelTextEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemPanelEditPart;
import com.safi.workshop.actionpak1.editpart.InvokeSaflet2EditPart;
import com.safi.workshop.actionpak1.editpart.InvokeSaflet2NameEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemLabelTextEditPart;
import com.safi.workshop.actionpak1.editpart.OutputItemPanelEditPart;
import com.safi.workshop.view.factories.ActionPakViewFactory;
import com.safi.workshop.view.factories.ActionstepNameLabelViewFactory;

public class InvokeSaflet2ActionPakViewFactory implements ActionPakViewFactory {

  public InvokeSaflet2ActionPakViewFactory() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public BasicNodeViewFactory createShapeViewFactory(int id) {
    if (id == InvokeSaflet2NameEditPart.VISUAL_ID)
      return new ActionstepNameLabelViewFactory();
    else if (id == InvokeSaflet2EditPart.VISUAL_ID){
      return new InvokeSaflet2ViewFactory();
//      ActionstepViewFactory f =  new ActionstepViewFactory();
//      f.setVisualID(id);
//      return f;
    }
    
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
