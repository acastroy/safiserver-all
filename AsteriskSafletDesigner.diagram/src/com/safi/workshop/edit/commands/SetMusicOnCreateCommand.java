package com.safi.workshop.edit.commands;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import com.safi.core.actionstep.ActionStep;

/**
 * @generated NOT
 */
public class SetMusicOnCreateCommand extends ToolstepCreateCommand {

  /**
   * @generated
   */
  public SetMusicOnCreateCommand(CreateElementRequest req) {
    super(req);
  }

  @Override
  protected String getDefaultDisplayName(ActionStep ts) {
    return "SetMusicOnHold";
  }

}
