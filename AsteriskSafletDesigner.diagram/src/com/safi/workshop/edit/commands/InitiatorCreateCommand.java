package com.safi.workshop.edit.commands;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;

/**
 * @generated
 */
public class InitiatorCreateCommand extends ToolstepCreateCommand {

  /**
   * @generated
   */
  public InitiatorCreateCommand(CreateElementRequest req) {
    super(req);
  }

  @Override
  public boolean canExecute() {
    if (!super.canExecute())
      return false;
    EObject obj = getElementToEdit();
    if (!(obj instanceof Saflet))
      return false;
    Initiator init = ((Saflet) obj).getInitiator();
    return init == null;
  }

  /**
   * @generated NOT
   */
  @Override
  protected EObject doDefaultElementCreation() {
    // TODO Auto-generated method stub
    Initiator initiator = (Initiator) super.doDefaultElementCreation();
    EObject object = getElementToEdit();
    if (object instanceof Saflet) {
      ((Saflet) object).setInitiator(initiator);
    }

    return initiator;
  }
}
