package com.safi.workshop.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.asterisk.figures.OutputFigure;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.workshop.edit.policies.AsteriskConnectionHandleEditPolicy;
import com.safi.workshop.edit.policies.OutputItemSemanticEditPolicy;

/**
 * @generated NOT
 */
public class OutputEditPart extends AbstractBorderItemEditPart {

  public static final int OUTPUT_DEFAULT_HEIGHT = 12;

  public static final int OUTPUT_DEFAULT_WIDTH = 55;

  /**
   * @generated
   */
  public static final int VISUAL_ID = 2001;

  /**
   * @generated
   */
  protected IFigure contentPane;

  /**
   * @generated
   */
  protected IFigure primaryShape;

  /**
   * @generated NOT
   */
  private BorderItemLocator locator;

  /**
   * @generated
   */
  public OutputEditPart(View view) {
    super(view);

  }

  @Override
  protected void handleNotificationEvent(Notification notification) {
    Object feature = notification.getFeature();
    if (NotationPackage.eINSTANCE.getFillStyle_FillColor().equals(feature)) {
      Integer c = (Integer) notification.getNewValue();
      setBackgroundColor(DiagramColorRegistry.getInstance().getColor(c));
    } else if (NotationPackage.eINSTANCE.getLineStyle_LineColor().equals(feature)) {
      Integer c = (Integer) notification.getNewValue();
      setForegroundColor(DiagramColorRegistry.getInstance().getColor(c));
    }
    // TODO Auto-generated method stub
    super.handleNotificationEvent(notification);

  }

  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {

    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
    // installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, null);
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OutputItemSemanticEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    installEditPolicy(EditPolicy.COMPONENT_ROLE, getComponentEditPolicy());
    // installEditPolicy("NoteAttachmentReorient", null);
    installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
        new AsteriskConnectionHandleEditPolicy());
    removeEditPolicy("NoteAttachmentReorient");
    // updateColor();
    // XXX need an SCR to runtime to have another abstract superclass that would let
    // children add reasonable editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
  }

  @Override
  public boolean canAttachNote() {
    return false;
  }

  private EditPolicy getComponentEditPolicy() {
    return new ComponentEditPolicy() {
      @Override
      protected Command getDeleteCommand(GroupRequest request) {
        // TODO Auto-generated method stub
        if (getOutputModel().getOutputType() != OutputType.CHOICE)
          return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
        return super.getDeleteCommand(request);
      }

      @Override
      protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
        if (getOutputModel().getOutputType() != OutputType.CHOICE)
          return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
        return super.getDeleteCommand(deleteRequest);
      }

    };
  }

  /**
   * @generated
   */
  protected LayoutEditPolicy createLayoutEditPolicy() {
    LayoutEditPolicy lep = new LayoutEditPolicy() {

      @Override
      protected EditPolicy createChildEditPolicy(EditPart child) {
        EditPolicy result = child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
        if (result == null) {
          result = new NonResizableEditPolicy() {
            @Override
            public EditPart getTargetEditPart(Request request) {
              if (REQ_SELECTION.equals(request.getType())) {
                return getHost().getParent();
              }
              return super.getTargetEditPart(request);
            }

          };
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
  public OutputFigure getPrimaryShape() {
    return (OutputFigure) primaryShape;
  }

  /**
   * @generated NOT
   */
  protected NodeFigure createNodePlate() {
    // DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode().DPtoLP(40),
    // getMapMode()
    // .DPtoLP(75));
    //
    // //FIXME: workaround for #154536
    // result.getBounds().setSize(result.getPreferredSize());
    // return result;

    Dimension d = new Dimension(OUTPUT_DEFAULT_WIDTH, OUTPUT_DEFAULT_HEIGHT);
    // DefaultSizeNodeFigure figure = new DefaultSizeNodeFigure(d);
    OutputFigure figure = new OutputFigure(d);
    primaryShape = figure;
    Output outputModel = getOutputModel();
    // if (outputModel.getOutputType() == OutputType.CHOICE) {
    figure.setLabelText(outputModel.getName());
    // }
    figure.setPreferredSize(d);
    figure.setSize(d);
    // updateColor();
    return figure;
  }

  @Override
  public void activate() {
    // TODO Auto-generated method stub
    super.activate();
    // updateColor();
  }

  public Output getOutputModel() {
    Object o = basicGetModel();
    if (o instanceof Output)
      return (Output) o;
    else
      return (Output) ((Node) o).getElement();
  }

  @Override
  public boolean isSelectable() {
    return false;
    // return true;
  }

  /**
   * @generated
   */
  @Override
  public EditPolicy getPrimaryDragEditPolicy() {
    return new NonResizableEditPolicyEx();
    // return new BorderItemSelectionEditPolicy() {
    // @Override
    // protected Command getMoveCommand(ChangeBoundsRequest request) {
    // // TODO Auto-generated method stub
    // return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
    // }
    //
    // @Override
    // public boolean isDragAllowed() {
    // // TODO Auto-generated method stub
    // return false;
    // }
    //      
    //      
    //
    // };

    // EditPolicy result = super.getPrimaryDragEditPolicy();
    // if (result instanceof ResizableEditPolicy) {
    // ResizableEditPolicy ep = (ResizableEditPolicy) result;
    // ep.setResizeDirections(PositionConstants.NONE);
    // }
    // return result;
  }

  /**
   * Creates figure for this edit part.
   * 
   * Body of this method does not depend on settings in generation model so you may safely
   * remove <i>generated</i> tag and modify it.
   * 
   * @generated NOT
   */
  @Override
  protected NodeFigure createNodeFigure() {
    NodeFigure figure = createNodePlate();
    // figure.setLayoutManager(new StackLayout());
    // IFigure shape = createNodeShape();
    // figure.add(shape);
    contentPane = setupContentPane(figure);

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

  @Override
  public IBorderItemLocator getBorderItemLocator() {
    // TODO Auto-generated method stub
    return locator;
  }

  public void setLocator(BorderItemLocator locator) {
    this.locator = locator;
  }

}
