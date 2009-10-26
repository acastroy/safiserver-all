
package com.safi.workshop.actionpak1.command;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.asterisk.AsteriskFactory;
import com.safi.asterisk.Call;
import com.safi.workshop.edit.commands.InitiatorCreateCommand;
import com.safi.workshop.model.actionpak1.IncomingCall2;

/**
 * @generated
 */
public class IncomingCall2CreateCommand extends InitiatorCreateCommand {

  /**
   * @generated
   */
  public IncomingCall2CreateCommand(CreateElementRequest req) {
    super(req);
  }
  
  @Override
  protected EObject doDefaultElementCreation() {
    // TODO Auto-generated method stub
    IncomingCall2 initiator = (IncomingCall2) super.doDefaultElementCreation();
    Call call = AsteriskFactory.eINSTANCE.createCall();
    call.setName("Call1");
    initiator.setNewCall1(call);
    
    return initiator;
  }
}
