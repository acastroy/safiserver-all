package com.safi.workshop.actionpak1.editpart;

import org.eclipse.draw2d.IFigure;
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
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.asterisk.figures.ParameterizedFigure;
import com.safi.workshop.actionpak1.ElementTypes;
import com.safi.workshop.edit.parts.ActionstepWithOutputParameters;
import com.safi.workshop.edit.parts.InputItemEditPart;
import com.safi.workshop.edit.parts.InputItemPanelEditPart;
import com.safi.workshop.edit.parts.ItemPanelEditPart;
import com.safi.workshop.edit.parts.OutputItemEditPart;
import com.safi.workshop.edit.parts.OutputItemPanelEditPart;
import com.safi.workshop.model.actionpak1.CustomInitiator;
import com.safi.workshop.part.SafletVisualIDRegistry;

/**
 * @generated
 */
public class DefaultActionStepWithOutputParamsEditPart extends DefaultActionStepEditPart
    implements ActionstepWithOutputParameters {


  /**
   * @generated
   */
  public DefaultActionStepWithOutputParamsEditPart(View view, int visualId) {
    super(view, visualId);
  }

  
  @Override
  protected EditPolicy createCreationEditPolicy() {
  	// TODO Auto-generated method stub
  	return new CreationEditPolicy() {
      public Command getCommand(Request request) {
        if (understandsRequest(request)) {
          if (request instanceof CreateViewAndElementRequest) {
            CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
                .getViewAndElementDescriptor().getCreateElementRequestAdapter();
            IElementType type = (IElementType) adapter.getAdapter(IElementType.class);
            if (type == ElementTypes.elementType_InputItem_50001) {
              EditPart compartmentEditPart = getChildBySemanticHint(SafletVisualIDRegistry
                  .getType(InputItemPanelEditPart.VISUAL_ID));
              return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
            }
            else
            if (type == ElementTypes.elementType_OutputItem_50002) {
              EditPart compartmentEditPart = getChildBySemanticHint(SafletVisualIDRegistry
                  .getType(OutputItemPanelEditPart.VISUAL_ID));
              return compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);
            }
          }
          return super.getCommand(request);
        }
        return null;
      }
    };
  }

  @Override
  public boolean canAttachNote() {
    return false;
  }

  public CustomInitiator getCustomInitiatorModel() {
    return (CustomInitiator) getActionStep();
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
    if (childEditPart instanceof InputItemPanelEditPart) {
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
     return super.removeFixedChild(childEditPart);
  }

  /**
   * @generated
   */
  protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

    if (editPart instanceof InputItemEditPart) {
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
