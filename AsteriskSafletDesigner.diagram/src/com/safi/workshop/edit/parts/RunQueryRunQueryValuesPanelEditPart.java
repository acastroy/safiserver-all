/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.NestedResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.workshop.edit.policies.RunQueryRunQueryValuesPanelCanonicalEditPolicy;
import com.safi.workshop.edit.policies.RunQueryRunQueryValuesPanelItemSemanticEditPolicy;
import com.safi.workshop.part.Messages;

/**
 * @generated
 */
public class RunQueryRunQueryValuesPanelEditPart extends ItemPanelEditPart {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 5005;

  /**
   * @generated
   */
  public RunQueryRunQueryValuesPanelEditPart(View view) {
    super(view);
  }

  /**
   * @generated
   */
  @Override
  public String getCompartmentName() {
    return Messages.RunQueryRunQueryValuesPanelEditPart_title;
  }

  /**
   * @generated NOT
   */
  @Override
  public IFigure createFigure() {
    ResizableCompartmentFigure rcf;
    if (getParent() == getTopGraphicEditPart()) {
      rcf = new ResizableCompartmentFigure(getCompartmentName(), getMapMode()) {
        @Override
        public Dimension getPreferredSize(int wHint, int hHint) {

          Dimension p = super.getPreferredSize(wHint, hHint);
          @SuppressWarnings("unused")
          List children = RunQueryRunQueryValuesPanelEditPart.this.getChildren();
          if (children == null || children.size() == 0)
            return p;
          return p.expand(0, 20);
        }
      };
    } else {
      rcf = new NestedResizableCompartmentFigure(getMapMode());
    }

    rcf.setTitleVisibility(false);

    ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
    layout.setStretchMajorAxis(false);
    layout.setStretchMinorAxis(true);
    layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
    layout.setSpacing(5);

    rcf.getScrollPane().setScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
    rcf.getScrollPane().setVerticalScrollBarVisibility(org.eclipse.draw2d.ScrollPane.NEVER);
    rcf.getScrollPane().getViewport().setContentsTracksHeight(true);

    rcf.getContentPane().setLayoutManager(layout);
    // rcf.setBorder(null);
    // rcf.getContentPane().setBorder(null);
    return rcf;
  }

  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
        new RunQueryRunQueryValuesPanelItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
    // QueryParamMappingReorderEditPolicy policy = new
    // QueryParamMappingReorderEditPolicy();
    // installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, policy);
    // installEditPolicy(EditPolicy.LAYOUT_ROLE, policy);
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
        new RunQueryRunQueryValuesPanelCanonicalEditPolicy());
    removeEditPolicy(EditPolicyRoles.MODIFY_SORT_FILTER_ROLE);
  }

}
