package com.safi.workshop.edit.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import com.safi.asterisk.AsteriskFactory;
import com.safi.asterisk.Call;
import com.safi.asterisk.initiator.IncomingCall;

/**
 * @generated
 */
public class IncomingCallCreateCommand extends InitiatorCreateCommand {

  /**
   * @generated
   */
  public IncomingCallCreateCommand(CreateElementRequest req) {
    super(req);
  }

  /**
   * @generated NOT
   */
  @Override
  protected EObject doDefaultElementCreation() {
    // TODO Auto-generated method stub
    IncomingCall initiator = (IncomingCall) super.doDefaultElementCreation();
    Call call = AsteriskFactory.eINSTANCE.createCall();
    call.setName("Call1");
    initiator.setNewCall1(call);

    return initiator;
  }
}
