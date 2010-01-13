package com.safi.workshop.edit.parts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.workshop.edit.policies.ChoiceItemPanelCanonicalEditPolicy;
import com.safi.workshop.edit.policies.ChoiceItemPanelItemSemanticEditPolicy;
import com.safi.workshop.part.Messages;

/**
 * @generated
 */
public class ChoiceItemPanelEditPart extends ItemPanelEditPart {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 5001;

  /**
   * @generated
   */
  public ChoiceItemPanelEditPart(View view) {
    super(view);
  }

  /**
   * @generated
   */
  @Override
  public String getCompartmentName() {
    return Messages.ChoiceItemPanelEditPart_title;
  }

  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ChoiceItemPanelItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());

    ChoiceReorderEditPolicy policy = new ChoiceReorderEditPolicy();

    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ChoiceItemPanelCanonicalEditPolicy());
    // installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, policy);
    installEditPolicy(EditPolicy.LAYOUT_ROLE, policy);
    removeEditPolicy(EditPolicyRoles.MODIFY_SORT_FILTER_ROLE);
    // removeEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE);

  }

}
