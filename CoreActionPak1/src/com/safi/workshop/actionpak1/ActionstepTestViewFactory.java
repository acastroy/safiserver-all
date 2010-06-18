package com.safi.workshop.actionpak1;

import java.util.Collections;

import com.safi.workshop.view.factories.ActionstepViewFactoryFactory;
import com.safi.workshop.view.factories.ActionstepNameLabelViewFactory;
import com.safi.workshop.view.factories.ActionstepViewFactory;

public class ActionstepTestViewFactory implements ActionstepViewFactoryFactory {

  public ActionstepTestViewFactory() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public org.eclipse.gmf.runtime.diagram.ui.view.factories.BasicNodeViewFactory 
    createShapeViewFactory(int id) {
    if (id == ActionstepTestEditPart.VISUAL_ID){
      ActionstepViewFactory f = new ActionstepViewFactory(id, ActionstepTestNameEditPart.VISUAL_ID, null);
      return f;
    }
    else if (id == ActionstepTestNameEditPart.VISUAL_ID){
      return new ActionstepNameLabelViewFactory();
    }
    return null;
  }

}
