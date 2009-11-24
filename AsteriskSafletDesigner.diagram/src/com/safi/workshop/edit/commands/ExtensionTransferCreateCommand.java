/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.asterisk.actionstep.ExtensionTransfer;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.DynamicValueType;

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
  
  @Override
  protected EObject doDefaultElementCreation() {
    // TODO Auto-generated method stub
    ExtensionTransfer xfer = (ExtensionTransfer) super.doDefaultElementCreation();
    DynamicValue val = ActionStepFactory.eINSTANCE.createDynamicValue();
    val.setType(DynamicValueType.LITERAL_TEXT);
    val.setText("Local");
    xfer.setChannelType(val);
    return xfer;
  }
}
