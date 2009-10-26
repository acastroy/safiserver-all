
package com.safi.workshop.actionpak1.command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import com.safi.core.actionstep.ActionStep;
import com.safi.workshop.edit.commands.ToolstepCreateCommand;

/**
 * @generated
 */
public class InvokeSaflet2CreateCommand extends ToolstepCreateCommand {

  /**
   * @generated
   */
  public InvokeSaflet2CreateCommand(CreateElementRequest req) {
    super(req);
  }
  
  @Override
  protected String getDefaultDisplayName(ActionStep ts) {
    // TODO Auto-generated method stub
    return "InvokeSaflet";
  }
  
//  @Override
//  protected EObject doDefaultElementCreation() {
//    // TODO Auto-generated method stub
//    InvokeSaflet2 initiator = (InvokeSaflet2) super.doDefaultElementCreation();
//    Call call = AsteriskFactory.eINSTANCE.createCall();
//    call.setName("Call1");
//    initiator.setNewCall1(call);
//    
//    return initiator;
//  }
}
