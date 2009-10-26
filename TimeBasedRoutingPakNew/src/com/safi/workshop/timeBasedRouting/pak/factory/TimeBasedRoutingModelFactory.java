package com.safi.workshop.timeBasedRouting.pak.factory;

import org.eclipse.emf.ecore.EObject;

import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingFactory;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeBasedRoutingEditPart;
import com.safi.workshop.timeBasedRouting.pak.editpart.TimeItemEditPart;
import com.safi.workshop.view.factories.ActionstepModelFactory;

public class TimeBasedRoutingModelFactory implements ActionstepModelFactory {

  @Override
  public EObject getModel(int id) {
    if (id == TimeBasedRoutingEditPart.VISUAL_ID)
      return TimeBasedRoutingFactory.eINSTANCE.createTimeBasedRouting();
    else
    if (id == TimeItemEditPart.VISUAL_ID)
      return TimeBasedRoutingFactory.eINSTANCE.createTimeItem();
    return null;
  }

}
