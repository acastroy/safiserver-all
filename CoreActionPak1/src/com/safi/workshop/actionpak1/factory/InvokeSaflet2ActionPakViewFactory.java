package com.safi.workshop.actionpak1.factory;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;

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
import com.safi.workshop.view.factories.ActionstepViewFactoryFactory;
import com.safi.workshop.view.factories.ActionstepNameLabelViewFactory;
import com.safi.workshop.view.factories.InputItemPanelViewFactory;
import com.safi.workshop.view.factories.OutputItemPanelViewFactory;

public class InvokeSaflet2ActionPakViewFactory implements ActionstepViewFactoryFactory {

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
      return new com.safi.workshop.view.factories.InputItemViewFactory();
    else if (id == InvokeSafletInputItemPanelEditPart.VISUAL_ID)
      return new InputItemPanelViewFactory();
    
    else if (id == OutputItemLabelTextEditPart.VISUAL_ID)
      return new ActionstepNameLabelViewFactory();
    else if (id == OutputItemEditPart.VISUAL_ID)
      return new com.safi.workshop.view.factories.OutputItemViewFactory();
    else if (id == InvokeSafletOutputItemPanelEditPart.VISUAL_ID)
      return new InvokeSafletOutputItemPanelViewFactory();
    return null;
    
  }

}
