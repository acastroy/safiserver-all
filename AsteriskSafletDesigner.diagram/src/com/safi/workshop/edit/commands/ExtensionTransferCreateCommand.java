/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.commands;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.core.actionstep.ActionStep;

/**
 * @generated NOT
 */
public class ExtensionTransferCreateCommand extends ToolstepCreateCommand {

  /**
   * @generated
   */
  public ExtensionTransferCreateCommand(CreateElementRequest req) {
    super(req);
  }

  @Override
  protected String getDefaultDisplayName(ActionStep ts) {
    return "Extension";
  }
}
