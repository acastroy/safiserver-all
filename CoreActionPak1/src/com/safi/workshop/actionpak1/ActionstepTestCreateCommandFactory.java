package com.safi.workshop.actionpak1;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.workshop.edit.commands.ToolstepCreateCommand;
import com.safi.workshop.edit.policies.ActionstepCreateCommandFactory;

public class ActionstepTestCreateCommandFactory implements ActionstepCreateCommandFactory {

  @Override
  public ToolstepCreateCommand getCreateCommand(CreateElementRequest req) {
    return new ActionstepTestCreateCommand(req);
  }

}
