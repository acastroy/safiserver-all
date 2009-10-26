package com.safi.workshop.actionpak1.editpart;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.asterisk.figures.ParameterizedFigure;
import com.safi.workshop.actionpak1.ElementTypes;
import com.safi.workshop.edit.parts.ActionstepWithOutputParameters;
import com.safi.workshop.edit.parts.ItemPanelEditPart;
import com.safi.workshop.edit.parts.OutputEditPart;
import com.safi.workshop.edit.policies.ActionstepCanonicalEditPolicy;
import com.safi.workshop.edit.policies.InitiatorItemSemanticEditPolicy;
import com.safi.workshop.model.actionpak1.CustomInitiator;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated
 */
public class CustomInitiatorEditPart extends com.safi.workshop.edit.parts.ToolstepEditPart
    implements ActionstepWithOutputParameters {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 10002;

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
  public CustomInitiatorEditPart(View view) {
    super(view);
  }

  /**
   * @generated NOT
   */
  protected void createDefaultEditPolicies() {
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy() {
      public Command getCommand(Request request) {
        if (understandsRequest(request)) {
          if (request instanceof CreateViewAndElementRequest) {
            CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
                .getViewAndElementDescriptor().getCreateElementRequestAdapter();
            IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
            if (type == ElementTypes.elementType_InputItem_50001) {
              EditPart compartmentEditPart = getChildBySemanticHint(AsteriskVisualIDRegistry
                  .getType(InputItemPanelEditPart.VISUAL_ID));
              return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
            }
            else
            if (type == ElementTypes.elementType_OutputItem_50002) {
              EditPart compartmentEditPart = getChildBySemanticHint(AsteriskVisualIDRegistry
                  .getType(OutputItemPanelEditPart.VISUAL_ID));
              return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
            }
          }
          return super.getCommand(request);
        }
        return null;
      }
    });
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InitiatorItemSemanticEditPolicy());
    // installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new
    // ActionstepItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ActionstepCanonicalEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    // XXX need an SCR to runtime to have another abstract superclass that would let
    // children add reasonable editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

  }

  @Override
  protected void refreshChildren() {
    // TODO Auto-generated method stub
    super.refreshChildren();
  }

  @Override
  public boolean canAttachNote() {
    return false;
  }

  public CustomInitiator getCustomInitiatorModel() {
    return (CustomInitiator) getActionStep();
  }

  @Override
  protected List getModelChildren() {
    // TODO Auto-generated method stub
    return super.getModelChildren();
  }

  @Override
  public Command getCommand(Request request) {
    if (request instanceof ChangeBoundsRequest) {
      Dimension sizeDelta = ((ChangeBoundsRequest) request).getSizeDelta();
      if (sizeDelta.height != 0 || sizeDelta.width != 0)
        return null;
    }
    // TODO Auto-generated method stub
    // return super.getCommand(request);
    Command cmd = super.getCommand(request);
    return cmd;
  }

  /**
   * @generated
   */
  protected LayoutEditPolicy createLayoutEditPolicy() {
    LayoutEditPolicy lep = new LayoutEditPolicy() {

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

      protected Command getMoveChildrenCommand(Request request) {
        return null;
      }

      protected Command getCreateCommand(CreateRequest request) {
        return null;
      }

      @Override
      public Command getCommand(Request request) {
        if (REQ_RESIZE.equals(request.getType()))
          return null;
        return super.getCommand(request);
      }
    };
    return lep;
  }

  /**
   * @generated
   */
  protected IFigure createNodeShape() {
    return primaryShape = new ParameterizedFigure();
  }

  /**
   * @generated
   */
  public ParameterizedFigure getPrimaryShape() {
    return (ParameterizedFigure) primaryShape;
  }

  /**
   * @generated
   */
  protected boolean addFixedChild(EditPart childEditPart) {
    if (super.addFixedChild(childEditPart))
      return true;
    if (childEditPart instanceof CustomInitiatorNameEditPart) {
      ((CustomInitiatorNameEditPart) childEditPart).setLabel(getPrimaryShape()
          .getToolstepNameLabel());
      return true;
    } else if (childEditPart instanceof InputItemPanelEditPart) {
      IFigure pane = getPrimaryShape().getInputItemPanel();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in
                              // his own way
      pane.add(((InputItemPanelEditPart) childEditPart).getFigure());
      return true;
    } else if (childEditPart instanceof OutputItemPanelEditPart) {
      IFigure pane = getPrimaryShape().getOutputItemPanel();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in
                              // his own way
      pane.add(((OutputItemPanelEditPart) childEditPart).getFigure());
      return true;
    }
    return false;

  }

  /**
   * @generated
   */
  protected boolean removeFixedChild(EditPart childEditPart) {

    if (childEditPart instanceof InputItemPanelEditPart) {
      IFigure pane = getPrimaryShape().getInputItemPanel();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in
                              // his own way
      pane.remove(((InputItemPanelEditPart) childEditPart).getFigure());
      return true;
    } else if (childEditPart instanceof OutputItemPanelEditPart) {
      IFigure pane = getPrimaryShape().getOutputItemPanel();
      setupContentPane(pane); // FIXME each comparment should handle his content pane in
                              // his own way
      pane.remove(((OutputItemPanelEditPart) childEditPart).getFigure());
      return true;
    }
    else
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
  protected void addChildVisual(EditPart childEditPart, int index) {
    if (addFixedChild(childEditPart)) {
      return;
    }
    super.addChildVisual(childEditPart, -1);
  }

  /**
   * @generated
   */
  protected void removeChildVisual(EditPart childEditPart) {
    if (removeFixedChild(childEditPart)) {
      return;
    }
    super.removeChildVisual(childEditPart);
  }

  /**
   * @generated
   */
  protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

    if (editPart instanceof CustomInitiatorNameEditPart) {
      return getPrimaryShape();
    } else if (editPart instanceof OutputEditPart) {
      return getBorderedFigure().getBorderItemContainer();
    } else if (editPart instanceof InputItemEditPart) {
      return getPrimaryShape().getInputItemPanel();
    } else if (editPart instanceof OutputItemEditPart) {
      return getPrimaryShape().getOutputItemPanel();
    } else
    if (editPart instanceof InputItemPanelEditPart)
      return getPrimaryShape().getInputItemPanel();
    else
    if (editPart instanceof OutputItemPanelEditPart)
      return getPrimaryShape().getOutputItemPanel();
    else
      return super.getContentPaneFor(editPart);
  }

  protected int getDefaultWidth() {
    return 75;
  }

  /**
   * Creates figure for this edit part.
   * 
   * Body of this method does not depend on settings in generation model so you may safely
   * remove <i>generated</i> tag and modify it.
   * 
   * @generated
   */
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
  public IFigure getContentPane() {
    if (contentPane != null) {
      return contentPane;
    }
    return super.getContentPane();
  }

  /**
   * @generated
   */
  public EditPart getPrimaryChildEditPart() {
    return getChildBySemanticHint(AsteriskVisualIDRegistry
        .getType(CustomInitiatorNameEditPart.VISUAL_ID));
  }

  private ItemPanelEditPart inputListCompartmentPart;
  
  private ItemPanelEditPart outputListCompartmentPart;

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.workshop.edit.parts.ActionstepWithCompartment#getCompartmentPart()
   */
  public ItemPanelEditPart getInputCompartmentPart() {
    if (inputListCompartmentPart == null) {
      for (Object o : getChildren()) {
        if (o instanceof InputItemPanelEditPart) {
          inputListCompartmentPart = (ItemPanelEditPart) o;
          break;
        }
      }
    }

    return inputListCompartmentPart;
  }
  
  @Override
  public ItemPanelEditPart getOutputCompartmentPart() {
    if (outputListCompartmentPart == null) {
      for (Object o : getChildren()) {
        if (o instanceof OutputItemPanelEditPart) {
          outputListCompartmentPart = (ItemPanelEditPart) o;
          break;
        }
      }
    }

    return outputListCompartmentPart;
  }

}
