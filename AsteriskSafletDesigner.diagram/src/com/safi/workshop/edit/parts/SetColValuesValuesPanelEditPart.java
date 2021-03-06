/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.parts;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.edit.policies.SetColValuesValuesPanelCanonicalEditPolicy;
import com.safi.workshop.edit.policies.SetColValuesValuesPanelItemSemanticEditPolicy;
import com.safi.workshop.part.Messages;

/**
 * @generated
 */
public class SetColValuesValuesPanelEditPart extends ItemPanelEditPart {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 5004;

  /**
   * @generated
   */
  public SetColValuesValuesPanelEditPart(View view) {
    super(view);
  }

  /**
   * @generated
   */
  @Override
  public String getCompartmentName() {
    return Messages.SetColValuesValuesPanelEditPart_title;
  }

  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
        new SetColValuesValuesPanelItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
    SetColMappingReorderEditPolicy policy = new SetColMappingReorderEditPolicy();
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, policy);
    installEditPolicy(EditPolicy.LAYOUT_ROLE, policy);

    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
        new SetColValuesValuesPanelCanonicalEditPolicy());
    removeEditPolicy(EditPolicyRoles.MODIFY_SORT_FILTER_ROLE);
  }

}
