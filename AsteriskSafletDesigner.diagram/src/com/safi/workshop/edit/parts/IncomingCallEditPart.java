package com.safi.workshop.edit.parts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.asterisk.figures.DefaultInitiatorFigure;
import com.safi.asterisk.initiator.IncomingCall;
import com.safi.workshop.edit.policies.InitiatorItemSemanticEditPolicy;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated
 */
public class IncomingCallEditPart extends ToolstepEditPart {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 1035;

  /**
   * @generated
   */
  protected IFigure contentPane;

  /**
   * @generated
   */
  protected IFigure primaryShape;

  /**
   * @generated
   */
  public IncomingCallEditPart(View view) {
    super(view);
  }

  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InitiatorItemSemanticEditPolicy());
    // installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new
    // ActionstepItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
        new com.safi.workshop.edit.policies.IncomingCallCanonicalEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    // XXX need an SCR to runtime to have another abstract superclass that would let
    // children add reasonable editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

  }

  @Override
  public boolean canAttachNote() {
    return false;
  }

  public IncomingCall getIncomingCallModel() {
    return (IncomingCall) getActionStep();
  }

  @Override
  protected List getModelChildren() {
    // TODO Auto-generated method stub
    return super.getModelChildren();
  }

  /**
   * @generated
   */
  protected LayoutEditPolicy createLayoutEditPolicy() {
    LayoutEditPolicy lep = new LayoutEditPolicy() {

      @Override
      protected EditPolicy createChildEditPolicy(EditPart child) {
        if (child instanceof IBorderItemEditPart) {
          return new BorderItemSelectionEditPolicy();
        }
        EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
        if (result == null) {
          result = new NonResizableEditPolicy();
        }
        return result;
      }

      @Override
      protected Command getMoveChildrenCommand(Request request) {
        return null;
      }

      @Override
      protected Command getCreateCommand(CreateRequest request) {
        return null;
      }
    };
    return lep;
  }

  /**
   * @generated
   */
  protected IFigure createNodeShape() {
    return primaryShape = new DefaultInitiatorFigure();
  }

  /**
   * @generated
   */
  @Override
  public DefaultInitiatorFigure getPrimaryShape() {
    return (DefaultInitiatorFigure) primaryShape;
  }

  /**
   * @generated
   */
  @Override
  protected boolean addFixedChild(EditPart childEditPart) {
    if (super.addFixedChild(childEditPart))
      return true;
    if (childEditPart instanceof IncomingCallNameEditPart) {
      ((IncomingCallNameEditPart) childEditPart).setLabel(getPrimaryShape().getToolstepNameLabel());
      return true;
    }
    return false;

  }

  /**
   * @generated
   */
  @Override
  protected boolean removeFixedChild(EditPart childEditPart) {

    return false;
  }

  @Override
  public Command getCommand(Request request) {
    return super.getCommand(request);
  }

  /**
   * @generated
   */
  @Override
  protected void addChildVisual(EditPart childEditPart, int index) {
    if (addFixedChild(childEditPart)) {
      return;
    }
    super.addChildVisual(childEditPart, -1);
  }

  /**
   * @generated
   */
  @Override
  protected void removeChildVisual(EditPart childEditPart) {
    if (removeFixedChild(childEditPart)) {
      return;
    }
    super.removeChildVisual(childEditPart);
  }

  /**
   * @generated
   */
  @Override
  protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

    return super.getContentPaneFor(editPart);
  }

  // /**
  // * Default implementation treats passed figure as content pane. Respects layout one
  // may
  // * have set for generated figure.
  // *
  // * @param nodeShape
  // * instance of generated figure class
  // * @generated
  // */
  // protected IFigure setupContentPane(IFigure nodeShape) {
  // if (nodeShape.getLayoutManager() == null) {
  // ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
  // layout.setSpacing(getMapMode().DPtoLP(5));
  // nodeShape.setLayoutManager(layout);
  // }
  // return nodeShape; // use nodeShape itself as contentPane
  // }

  @Override
  protected void refreshChildren() {
    // TODO Auto-generated method stub
    super.refreshChildren();
  }

  @Override
  protected void refreshVisuals() {
    // TODO Auto-generated method stub
    super.refreshVisuals();
  }

  /**
   * Creates figure for this edit part.
   * 
   * Body of this method does not depend on settings in generation model so you may safely
   * remove <i>generated</i> tag and modify it.
   * 
   * @generated
   */
  @Override
  protected NodeFigure createMainFigure() {
    NodeFigure figure = createNodePlate();
    figure.setLayoutManager(new StackLayout());
    IFigure shape = createNodeShape();
    figure.add(shape);
    contentPane = setupContentPane(shape);
    return figure;
  }

  /**
   * @generated
   */
  @Override
  public IFigure getContentPane() {
    if (contentPane != null) {
      return contentPane;
    }
    return super.getContentPane();
  }

  /**
   * @generated
   */
  @Override
  public EditPart getPrimaryChildEditPart() {
    return getChildBySemanticHint(AsteriskVisualIDRegistry
        .getType(IncomingCallNameEditPart.VISUAL_ID));
  }

}
