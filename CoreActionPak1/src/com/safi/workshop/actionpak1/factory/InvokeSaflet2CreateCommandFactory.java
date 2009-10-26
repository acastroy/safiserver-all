package com.safi.workshop.actionpak1.factory;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.workshop.actionpak1.ElementTypes;
import com.safi.workshop.actionpak1.command.InputItemCreateCommand;
import com.safi.workshop.actionpak1.command.InvokeSaflet2CreateCommand;
import com.safi.workshop.edit.policies.ActionstepCreateCommandFactory;

public class InvokeSaflet2CreateCommandFactory implements ActionstepCreateCommandFactory {

  @Override
  public CreateElementCommand getCreateCommand(CreateElementRequest req) {
    if (req.getElementType() == ElementTypes.elementType_InvokeSaflet2_10004)
      return new InvokeSaflet2CreateCommand(req);
    else
    if (req.getElementType() == ElementTypes.elementType_InputItem_50001)
      return new InputItemCreateCommand(req);
    else
      if (req.getElementType() == ElementTypes.elementType_OutputItem_50002)
        return new InputItemCreateCommand(req);
    return null;
  }

}
