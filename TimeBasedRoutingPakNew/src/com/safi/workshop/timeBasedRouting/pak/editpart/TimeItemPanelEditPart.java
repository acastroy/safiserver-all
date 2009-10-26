package com.safi.workshop.timeBasedRouting.pak.editpart;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.edit.parts.ActionstepSubitemContainer;
import com.safi.workshop.edit.parts.ItemPanelEditPart;

/**
 * @generated
 */
public class TimeItemPanelEditPart extends ItemPanelEditPart implements ActionstepSubitemContainer{

  /**
   * @generated
   */
  public static final int VISUAL_ID = 60000;

  /**
   * @generated
   */
  public TimeItemPanelEditPart(View view) {
    super(view);
  }

  /**
   * @generated
   */
  public String getCompartmentName() {
    return "Time Item Panel";
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
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new TimeItemPanelItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());

    TimeItemReorderPolicy policy = new TimeItemReorderPolicy();

    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new TimeItemPanelCanonicalEditPolicy());
    // installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, policy);
    installEditPolicy(EditPolicy.LAYOUT_ROLE, policy);
    removeEditPolicy(EditPolicyRoles.MODIFY_SORT_FILTER_ROLE);
    //    removeEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE);

  }


}
