package com.safi.workshop.edit.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import com.safi.asterisk.AsteriskFactory;
import com.safi.asterisk.Call;
import com.safi.asterisk.actionstep.PlaceCall;

/**
 * @generated NOT
 */
public class PlaceCallCreateCommand extends ToolstepCreateCommand {

  /**
   * @generated
   */
  public PlaceCallCreateCommand(CreateElementRequest req) {
    super(req);
  }

  @Override
  protected EObject doDefaultElementCreation() {
    PlaceCall pc = (PlaceCall) super.doDefaultElementCreation();
    if (pc.getNewCall1() == null && pc.getSaflet() != null) {
      Call call = AsteriskFactory.eINSTANCE.createCall();
      call.setName(pc.getSaflet().getUniqueCallName("Call"));
      pc.setNewCall1(call);
    }

    return pc;
  }
}
