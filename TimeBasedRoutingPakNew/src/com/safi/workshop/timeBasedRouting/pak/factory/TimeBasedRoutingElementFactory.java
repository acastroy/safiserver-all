package com.safi.workshop.timeBasedRouting.pak.factory;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import com.safi.workshop.timeBasedRouting.pak.ElementTypes;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeBasedRoutingEditPart;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeItemEditPart;
import com.safi.workshop.view.factories.ActionstepElementFactory;

public class TimeBasedRoutingElementFactory implements ActionstepElementFactory {

  @Override
  public IElementType getElementType(int id) {
    if (id == TimeBasedRoutingEditPart.VISUAL_ID)
      return ElementTypes.elementType_TimeBasedRouting_10001;
    else
    if (id == TimeItemEditPart.VISUAL_ID)
      return ElementTypes.elementType_TimeItem_50000;
    return null;
  }

}
