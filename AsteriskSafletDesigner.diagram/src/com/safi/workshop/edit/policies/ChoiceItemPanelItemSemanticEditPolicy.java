package com.safi.workshop.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

import com.safi.core.actionstep.ActionStepPackage;
import com.safi.workshop.edit.commands.CaseItemCreateCommand;
import com.safi.workshop.providers.AsteriskElementTypes;

/**
 * @generated
 */
public class ChoiceItemPanelItemSemanticEditPolicy extends AsteriskBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  @Override
  protected Command getCreateCommand(CreateElementRequest req) {
    if (AsteriskElementTypes.CaseItem_2002 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(ActionStepPackage.eINSTANCE.getChoice_Choices());
      }
      return getGEFWrapper(new CaseItemCreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

  @Override
  protected Command getMoveCommand(MoveRequest req) {
    return super.getMoveCommand(req);
  }

}
