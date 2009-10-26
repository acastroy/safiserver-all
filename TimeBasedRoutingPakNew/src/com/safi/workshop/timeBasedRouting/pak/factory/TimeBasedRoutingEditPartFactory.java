package com.safi.workshop.timeBasedRouting.pak.factory;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.timeBasedRouting.pak.editpart.TimeBasedRoutingEditPart;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeBasedRoutingNameEditPart;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeItemEditPart;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeItemLabelTextEditPart;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeItemPanelEditPart;
import com.safi.workshop.view.factories.ActionPakEditPartFactory;

public class TimeBasedRoutingEditPartFactory implements ActionPakEditPartFactory {

  @Override
  public EditPart createEditPart(View view, int id) {
    if (id == TimeBasedRoutingEditPart.VISUAL_ID)
      return new TimeBasedRoutingEditPart(view);
    else
    if (id == TimeBasedRoutingNameEditPart.VISUAL_ID)
      return new TimeBasedRoutingNameEditPart(view);
    else
    if (id == TimeItemEditPart.VISUAL_ID)
      return new TimeItemEditPart(view);
    else
    if (id == TimeItemLabelTextEditPart.VISUAL_ID)
      return new TimeItemLabelTextEditPart(view);
    else
    if (id == TimeItemPanelEditPart.VISUAL_ID)
      return new TimeItemPanelEditPart(view);
    return null;
  }

}
