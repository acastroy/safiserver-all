package com.safi.workshop.actionpak1.editpart;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.core.actionstep.ActionStepPackage;
import com.safi.workshop.edit.commands.CaseItemTargetToolstepCreateCommand;
import com.safi.workshop.edit.commands.CaseItemTargetToolstepReorientCommand;
import com.safi.workshop.edit.commands.OutputCreateCommand;
import com.safi.workshop.edit.commands.OutputTargetCreateCommand;
import com.safi.workshop.edit.commands.OutputTargetReorientCommand;
import com.safi.workshop.edit.parts.CaseItemTargetToolstepEditPart;
import com.safi.workshop.edit.parts.OutputEditPart;
import com.safi.workshop.edit.parts.OutputTargetEditPart;
import com.safi.workshop.edit.policies.SafiWorkshopBaseItemSemanticEditPolicy;
import com.safi.workshop.part.SafletVisualIDRegistry;
import com.safi.workshop.providers.SafiWorkshopElementTypes;

public class InvokeSaflet2ItemSemanticEditPolicy extends SafiWorkshopBaseItemSemanticEditPolicy {

  /**
   * @generated
   */
  protected Command getCreateCommand(CreateElementRequest req) {
    if (SafiWorkshopElementTypes.Output_2001 == req.getElementType()) {
      if (req.getContainmentFeature() == null) {
        req.setContainmentFeature(ActionStepPackage.eINSTANCE.getActionStep_Outputs());
      }
      return getGEFWrapper(new OutputCreateCommand(req));
    }
    return super.getCreateCommand(req);
  }

  /**
   * @generated
   */
  protected Command getDestroyElementCommand(DestroyElementRequest req) {
    CompoundCommand cc = getDestroyEdgesCommand();
    addDestroyChildNodesCommand(cc);
    addDestroyShortcutsCommand(cc);
    View view = (View) getHost().getModel();
    if (view.getEAnnotation("Shortcut") != null) { //$NON-NLS-1$
      req.setElementToDestroy(view);
    }
    cc.add(getGEFWrapper(new DestroyElementCommand(req)));
    return cc.unwrap();
  }

  /**
   * @generated
   */
  protected void addDestroyChildNodesCommand(CompoundCommand cmd) {
    View view = (View) getHost().getModel();
    EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
    if (annotation != null) {
      return;
    }
    for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
      Node node = (Node) it.next();
      switch (SafletVisualIDRegistry.getVisualID(node)) {
        case OutputEditPart.VISUAL_ID:
          cmd.add(getDestroyElementCommand(node));
          break;
        case InputItemPanelEditPart.VISUAL_ID:
        case OutputItemPanelEditPart.VISUAL_ID:
          for (Iterator cit = node.getChildren().iterator(); cit.hasNext();) {
            Node cnode = (Node) cit.next();
            switch (SafletVisualIDRegistry.getVisualID(cnode)) {
              case InputItemEditPart.VISUAL_ID:
                cmd.add(getDestroyElementCommand(cnode));
                break;
              case OutputItemEditPart.VISUAL_ID:
                cmd.add(getDestroyElementCommand(cnode));
                break;
            }
          }
          break;
      }
    }
  }

  /**
   * @generated
   */
  protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
    Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
        : getCompleteCreateRelationshipCommand(req);
    return command != null ? command : super.getCreateRelationshipCommand(req);
//    return null;
  }

  /**
   * @generated
   */
  protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
    if (SafiWorkshopElementTypes.OutputTarget_3001 == req.getElementType()) {
      return null;
    }
    if (SafiWorkshopElementTypes.CaseItemTargetToolstep_3003 == req.getElementType()) {
      return null;
    }
    return null;
  }

  /**
   * @generated
   */
  protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
    if (SafiWorkshopElementTypes.OutputTarget_3001 == req.getElementType()) {
      return getGEFWrapper(new OutputTargetCreateCommand(req, req.getSource(), req.getTarget()));
    }
    if (SafiWorkshopElementTypes.CaseItemTargetToolstep_3003 == req.getElementType()) {
      return getGEFWrapper(new CaseItemTargetToolstepCreateCommand(req, req.getSource(), req
          .getTarget()));
    }
    return null;
  }

  /**
   * Returns command to reorient EReference based link. New link target or source
   * should be the domain model element associated with this node.
   * 
   * @generated
   */
  protected Command getReorientReferenceRelationshipCommand(ReorientReferenceRelationshipRequest req) {
    switch (getVisualID(req)) {
      case OutputTargetEditPart.VISUAL_ID:
        return getGEFWrapper(new OutputTargetReorientCommand(req));
      case CaseItemTargetToolstepEditPart.VISUAL_ID:
        return getGEFWrapper(new CaseItemTargetToolstepReorientCommand(req));
    }
    return super.getReorientReferenceRelationshipCommand(req);
  }

}
