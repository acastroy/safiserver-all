package com.safi.workshop.edit.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.asterisk.actionstep.MeetMeCount;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.saflet.Saflet;

/**
 * @generated NOT
 */
public class MeetMeCountCreateCommand extends ToolstepCreateCommand {

  /**
   * @generated
   */
  public MeetMeCountCreateCommand(CreateElementRequest req) {
    super(req);
  }

  @Override
  protected EObject doDefaultElementCreation() {
    // TODO Auto-generated method stub
    MeetMeCount mmc = (MeetMeCount) super.doDefaultElementCreation();
    Saflet handler = (Saflet) getElementToEdit();

    String prefix = "count";
    DynamicValue dyn = addVariable(handler, prefix);
    mmc.setVariableName(dyn);

    return mmc;
  }
}
