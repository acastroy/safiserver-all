package com.safi.workshop.timeBasedRouting.pak.factory;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.workshop.edit.policies.ActionstepCreateCommandFactory;
import com.safi.workshop.timeBasedRouting.pak.ElementTypes;
import com.safi.workshop.timeBasedRouting.pak.command.TimeBasedRoutingCreateCommand;
import com.safi.workshop.timeBasedRouting.pak.command.TimeItemCreateCommand;

public class TimeBasedRoutingCreateCommandFactory implements ActionstepCreateCommandFactory {

  @Override
  public CreateElementCommand getCreateCommand(CreateElementRequest req) {
    if (req.getElementType() == ElementTypes.elementType_TimeBasedRouting_10001)
      return new TimeBasedRoutingCreateCommand(req);
    else
    if (req.getElementType() == ElementTypes.elementType_TimeItem_50000)
      return new TimeItemCreateCommand(req);
    return null;
  }

}
