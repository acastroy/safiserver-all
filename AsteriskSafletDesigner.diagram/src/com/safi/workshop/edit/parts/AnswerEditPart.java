package com.safi.workshop.edit.parts;

import org.eclipse.core.runtime.Platform;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.common.ui.services.properties.PropertiesServiceAdapterFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.views.properties.IPropertySource;
import com.safi.asterisk.figures.AnswerFigure;
import com.safi.workshop.edit.policies.AnswerCanonicalEditPolicy;
import com.safi.workshop.edit.policies.AnswerItemSemanticEditPolicy;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated NOT
 */
public class AnswerEditPart extends ToolstepEditPart {

  static {
    registerAdapters();
  }
  /**
   * @generated
   */
  public static final int VISUAL_ID = 1001;

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
  public AnswerEditPart(View view) {
    super(view);
  }

  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());

    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AnswerItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new AnswerCanonicalEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    // installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
    // new AsteriskConnectionHandleEditPolicy());
    // XXX need an SCR to runtime to have another abstract superclass that would let
    // children add reasonable editpolicies
    removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
  }

  static private void registerAdapters() {
    // Platform.getAdapterManager().registerAdapters(new IAdapterFactory() {
    //
    // /**
    // * @see org.eclipse.core.runtime.IAdapterFactory
    // */
    // public Object getAdapter(Object adaptableObject, Class adapterType) {
    //
    // IGraphicalEditPart gep = (IGraphicalEditPart) adaptableObject;
    //
    // if (adapterType == IActionFilter.class) {
    // return ActionFilterService.getInstance();
    // } else if (adapterType == View.class) {
    // return gep.getModel();
    // }
    // return null;
    // }
    //
    // /**
    // * @see org.eclipse.core.runtime.IAdapterFactory
    // */
    // public Class[] getAdapterList() {
    // return new Class[] {IActionFilter.class, View.class};
    // }
    //
    // }, IGraphicalEditPart.class);
    Platform.getAdapterManager().registerAdapters(new MyServiceAdapterFactory(),
        AnswerEditPart.class);
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
   * @generated NOT
   */
  @Override
  protected boolean addFixedChild(EditPart childEditPart) {
    if (super.addFixedChild(childEditPart))
      return true;
    if (childEditPart instanceof AnswerNameEditPart) {
      ((AnswerNameEditPart) childEditPart).setLabel(getPrimaryShape().getFigureAnswerNameFigure());
      return true;
    }
    return false;
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
   * @generated
   */
  protected IFigure createNodeShape() {
    return primaryShape = new AnswerFigure();
  }

  /**
   * @generated
   */
  @Override
  public AnswerFigure getPrimaryShape() {
    return (AnswerFigure) primaryShape;
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
    return getChildBySemanticHint(AsteriskVisualIDRegistry.getType(AnswerNameEditPart.VISUAL_ID));
  }

  public static class MyServiceAdapterFactory extends PropertiesServiceAdapterFactory {
    @Override
    public Object getAdapter(Object adaptableObject, Class adapterType) {
      return super.getAdapter(adaptableObject, adapterType);
    }

    @Override
    public IPropertySource getPropertySource(Object object) {
      return super.getPropertySource(object);
    }
  }

}
