package com.safi.workshop.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;

/**
 * @generated
 */
public class InitiatorItemSemanticEditPolicy extends ActionstepItemSemanticEditPolicy {

  
  /**
   * @generated
   */
  @Override
  protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
    // Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
    // : getCompleteCreateRelationshipCommand(req);
    // return command != null ? command : super.getCreateRelationshipCommand(req);
    return null;
  }

  /**
   * @generated
   */
  @Override
  protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
    return null;
  }

  /**
   * @generated
   */
  @Override
  protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
    return null;
  }

  
 
}
