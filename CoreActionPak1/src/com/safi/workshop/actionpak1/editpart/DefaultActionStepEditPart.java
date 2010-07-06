package com.safi.workshop.actionpak1.editpart;

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
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.asterisk.figures.DefaultToolstepFigure;
import com.safi.workshop.actionpak1.policy.ActionStepItemSemanticEditPolicy2;
import com.safi.workshop.edit.parts.ActionStepNameEditPart;
import com.safi.workshop.edit.parts.OutputEditPart;
import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.edit.policies.ActionstepCanonicalEditPolicy;
import com.safi.workshop.part.SafletVisualIDRegistry;

/**
 * @generated NOT
 */
public class DefaultActionStepEditPart extends ToolstepEditPart {

  /**
   * @generated
   */
  protected int visualId;
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
  public DefaultActionStepEditPart(View view, int visualId) {
    super(view);
    this.visualId = visualId;
  }

  @Override
  public int getVisualId() {
  	return visualId;
  }
  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, createCreationEditPolicy());

    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, createSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, createDragDropEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, createCanonicalEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    // installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
    // new SafiWorkshopConnectionHandleEditPolicy());
    // XXX need an SCR to runtime to have another abstract superclass that would let
    // children add reasonable editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
  }

	protected EditPolicy createCreationEditPolicy() {
		return new CreationEditPolicy();
	}

	protected EditPolicy createCanonicalEditPolicy() {
		return new ActionstepCanonicalEditPolicy();
	}

	protected EditPolicy createDragDropEditPolicy() {
		return new DragDropEditPolicy();
	}

	protected EditPolicy createSemanticEditPolicy() {
		return new ActionStepItemSemanticEditPolicy2();
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
    return primaryShape = new DefaultToolstepFigure();
  }

  /**
   * @generated
   */
  @Override
  public DefaultToolstepFigure getPrimaryShape() {
    return (DefaultToolstepFigure) primaryShape;
  }

  /**
   * @generated NOT
   */
  @Override
  protected boolean addFixedChild(EditPart childEditPart) {
    if (super.addFixedChild(childEditPart))
      return true;
    if (childEditPart instanceof ActionStepNameEditPart) {
      ((ActionStepNameEditPart) childEditPart).setLabel(getPrimaryShape().getToolstepNameLabel());
      return true;
    }

    return false;
  }

  /**
   * @generated
   */
  @Override
  protected boolean removeFixedChild(EditPart childEditPart) {

    if (childEditPart instanceof OutputEditPart) {
      getBorderedFigure().getBorderItemContainer().remove(
          ((OutputEditPart) childEditPart).getFigure());
      return true;
    }
    return false;
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

    if (editPart instanceof OutputEditPart) {
      return getBorderedFigure().getBorderItemContainer();
    }
    return super.getContentPaneFor(editPart);
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
   * Default implementation treats passed figure as content pane. Respects layout one may
   * have set for generated figure.
   * 
   * @param nodeShape
   *          instance of generated figure class
   * @generated
   */
  @Override
  protected IFigure setupContentPane(IFigure nodeShape) {
    if (nodeShape.getLayoutManager() == null) {
      ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
      layout.setSpacing(getMapMode().DPtoLP(5));
      nodeShape.setLayoutManager(layout);
    }
    return nodeShape; // use nodeShape itself as contentPane
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
    return getChildBySemanticHint(SafletVisualIDRegistry.getType(ActionStepNameEditPart.VISUAL_ID));
  }

}
