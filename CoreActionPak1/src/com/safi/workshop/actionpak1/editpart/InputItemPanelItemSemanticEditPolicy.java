package com.safi.workshop.actionpak1.editpart;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

import com.safi.core.actionstep.ActionStepPackage;
import com.safi.core.actionstep.ParameterizedActionstep;
import com.safi.workshop.actionpak1.ElementTypes;
import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.edit.policies.AsteriskBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class InputItemPanelItemSemanticEditPolicy extends AsteriskBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  protected Command getCreateCommand(CreateElementRequest req) {
    if (ElementTypes.elementType_InputItem_50001 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        if (getHost().getParent() instanceof ToolstepEditPart && ((ToolstepEditPart)getHost().getParent()).getActionStep() instanceof ParameterizedActionstep)
          req.setContainmentFeature(ActionStepPackage.eINSTANCE.getParameterizedActionstep_Inputs()); 
        /*if (getHost().getParent() instanceof CustomInitiatorEditPart)
          req.setContainmentFeature(Actionpak1Package.eINSTANCE.getCustomInitiator_Inputs());
        else
          if (getHost().getParent() instanceof IncomingCall2EditPart)
            req.setContainmentFeature(Actionpak1Package.eINSTANCE.getIncomingCall2_Inputs());*/
      }
      return getGEFWrapper(new com.safi.workshop.actionpak1.command.InputItemCreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

  @Override
  protected Command getMoveCommand(MoveRequest req) {
    return super.getMoveCommand(req);
  }

}
