package com.safi.workshop.actionpak1.factory;

import org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory;

import com.safi.workshop.actionpak1.editpart.InputItemEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemLabelTextEditPart;
import com.safi.workshop.actionpak1.editpart.InputItemPanelEditPart;
import com.safi.workshop.actionpak1.editpart.ManagerActionEditPart;
import com.safi.workshop.actionpak1.editpart.ManagerActionNameEditPart;
import com.safi.workshop.view.factories.ActionPakViewFactory;
import com.safi.workshop.view.factories.ActionstepNameLabelViewFactory;

public class ManagerActionPakViewFactory implements ActionPakViewFactory {

  public ManagerActionPakViewFactory() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public BasicNodeViewFactory createShapeViewFactory(int id) {
    if (id == ManagerActionNameEditPart.VISUAL_ID)
      return new ActionstepNameLabelViewFactory();
    else if (id == ManagerActionEditPart.VISUAL_ID){
      return new ManagerActionViewFactory();
//      ActionstepViewFactory f =  new ActionstepViewFactory();
//      f.setVisualID(id);
//      return f;
    }
    
    else if (id == InputItemLabelTextEditPart.VISUAL_ID)
      return new ActionstepNameLabelViewFactory();
    else if (id == InputItemEditPart.VISUAL_ID)
      return new InputItemViewFactory();
    else if (id == InputItemPanelEditPart.VISUAL_ID)
      return new InputItemPanelViewFactory();
    
//    else if (id == PropertyMappingItemLabelTextEditPart.VISUAL_ID)
//      return new ActionstepNameLabelViewFactory();
//    else if (id == PropertyMappingItemPanelEditPart.VISUAL_ID)
//      return new PropertyMappingItemPanelViewFactory();
//    else if (id == PropertyMappingItemEditPart.VISUAL_ID)
//      return new PropertyMappingItemViewFactory();
    
//    System.err.println("Couldn't find dam shapeviewfactory for id "+id);
    return null;
    
  }

}
