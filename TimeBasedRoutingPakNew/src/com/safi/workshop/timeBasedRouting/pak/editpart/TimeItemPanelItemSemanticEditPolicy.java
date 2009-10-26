package com.safi.workshop.timeBasedRouting.pak.editpart;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

import com.safi.workshop.edit.policies.AsteriskBaseItemSemanticEditPolicy;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingPackage;
import com.safi.workshop.timeBasedRouting.pak.ElementTypes;
import com.safi.workshop.timeBasedRouting.pak.command.TimeItemCreateCommand;

/**
 * @generated
 */
public class TimeItemPanelItemSemanticEditPolicy extends AsteriskBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  protected Command getCreateCommand(CreateElementRequest req) {
    if (ElementTypes.elementType_TimeItem_50000 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(TimeBasedRoutingPackage.eINSTANCE.getTimeBasedRouting_Times());
      }
      return getGEFWrapper(new TimeItemCreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

  @Override
  protected Command getMoveCommand(MoveRequest req) {
    return super.getMoveCommand(req);
  }

}
