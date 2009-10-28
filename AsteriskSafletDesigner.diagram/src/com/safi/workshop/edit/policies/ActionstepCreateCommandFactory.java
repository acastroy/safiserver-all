package com.safi.workshop.edit.policies;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

public interface ActionstepCreateCommandFactory {

  CreateElementCommand getCreateCommand(CreateElementRequest req);
}
