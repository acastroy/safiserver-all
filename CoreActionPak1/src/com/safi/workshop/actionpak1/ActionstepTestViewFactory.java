package com.safi.workshop.actionpak1;

import com.safi.workshop.view.factories.ActionPakViewFactory;
import com.safi.workshop.view.factories.ActionstepNameLabelViewFactory;
import com.safi.workshop.view.factories.ActionstepViewFactory;

public class ActionstepTestViewFactory implements ActionPakViewFactory {

  public ActionstepTestViewFactory() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory 
    createShapeViewFactory(int id) {
    if (id == ActionstepTestEditPart.VISUAL_ID){
      ActionstepViewFactory f = new ActionstepViewFactory();
      f.setVisualID(id);
      return f;
    }
    else if (id == ActionstepTestNameEditPart.VISUAL_ID){
      return new ActionstepNameLabelViewFactory();
    }
    return null;
  }

}
