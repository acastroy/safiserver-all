package com.safi.workshop.edit.commands;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import com.safi.core.actionstep.ActionStep;

/**
 * @generated NOT
 */
public class SetGlobalVariableCreateCommand extends ToolstepCreateCommand {

  /**
   * @generated
   */
  public SetGlobalVariableCreateCommand(CreateElementRequest req) {
    super(req);
  }

  @Override
  protected String getDefaultDisplayName(ActionStep ts) {
    return "SetAstGlobalVar";
  }
}
