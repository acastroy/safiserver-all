package com.safi.workshop.actionpak1.editpart;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.edit.parts.ActionstepSubitemContainer;
import com.safi.workshop.edit.parts.ItemPanelEditPart;

/**
 * @generated
 */
public class InputItemPanelEditPart extends ItemPanelEditPart implements ActionstepSubitemContainer{

  /**
   * @generated
   */
  public static final int VISUAL_ID = 60001;

  /**
   * @generated
   */
  public InputItemPanelEditPart(View view) {
    super(view);
  }

  /**
   * @generated
   */
  public String getCompartmentName() {
    return "Input Item Panel";
  }

  // /**
  // * @generated
  // */
  // public IFigure createFigure() {
  // ResizableCompartmentFigure result = (ResizableCompartmentFigure)
  // super.createFigure();
  // result.setTitleVisibility(false);
  // return result;
  // }

  /**
   * @generated NOT
   */
  protected void createDefaultEditPolicies() {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InputItemPanelItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());

    InputItemReorderPolicy policy = new InputItemReorderPolicy();

    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new InputItemPanelCanonicalEditPolicy());
    // installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, policy);
    installEditPolicy(EditPolicy.LAYOUT_ROLE, policy);
    removeEditPolicy(EditPolicyRoles.MODIFY_SORT_FILTER_ROLE);
    //    removeEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE);

  }
  
//
//
//  @Override
//  protected void refreshChildren() {
//    // TODO Auto-generated method stub
//    super.refreshChildren();
//    IFigure fig = getCompartmentFigure();
//    if (fig != null){
//      boolean visible = !getModelChildren().isEmpty();
//      fig.setVisible(visible);
//    }
//  }

}
