/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.asterisk.figures.OutputFigure;
import com.safi.core.actionstep.QueryParamMapping;
import com.safi.workshop.edit.policies.QueryParamMappingItemSemanticEditPolicy;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated
 */
public class QueryParamMappingEditPart extends ShapeNodeEditPart implements Adapter {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 2006;

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
  public QueryParamMappingEditPart(View view) {
    super(view);
  }

  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new QueryParamMappingItemSemanticEditPolicy());
    installEditPolicy(EditPolicy.COMPONENT_ROLE, getComponentEditPolicy());
    // installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    // XXX need an SCR to runtime to have another abstract superclass that would let
    // children add reasonable editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);

    // installEditPolicy(EditPolicyRoles.OPEN_ROLE, new EditAudioFilePolicy());
    removeEditPolicy("NoteAttachmentReorient");
  }

  @Override
  public Command getCommand(Request _request) {
    return super.getCommand(_request);
  }

  private EditPolicy getComponentEditPolicy() {
    return new ComponentEditPolicy() {

      @Override
      protected Command getDeleteCommand(GroupRequest request) {
        return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
      }

      @Override
      protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
        return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
      }

    };
  }

  @Override
  public boolean canAttachNote() {
    return false;
  }

  public QueryParamMapping getQueryParamMapping() {
    return (QueryParamMapping) resolveSemanticElement();
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
  protected IFigure createNodeShape() {

    primaryShape = new OutputFigure();
    ((OutputFigure) primaryShape).setCapped(false);
    return primaryShape;
  }

  /**
   * @generated
   */
  public OutputFigure getPrimaryShape() {
    return (OutputFigure) primaryShape;
  }

  /**
   * @generated
   */
  protected boolean addFixedChild(EditPart childEditPart) {
    if (childEditPart instanceof WrapLabelEditPart) {
      ((WrapLabelEditPart) childEditPart).setLabel(getPrimaryShape().getFigureOutputNameFigure());
      return true;
    }
    return false;
  }

  /**
   * @generated
   */
  protected boolean removeFixedChild(EditPart childEditPart) {

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

    return super.getContentPaneFor(editPart);
  }

  /**
   * @generated NOT
   */
  protected NodeFigure createNodePlate() {
    return (NodeFigure) createNodeShape();
  }

  /**
   * @generated
   */
  @Override
  public EditPolicy getPrimaryDragEditPolicy() {
    EditPolicy result = super.getPrimaryDragEditPolicy();
    if (result instanceof ResizableEditPolicy) {
      ResizableEditPolicy ep = (ResizableEditPolicy) result;
      ep.setResizeDirections(PositionConstants.NONE);
    }
    return result;
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
    Dimension d = new Dimension(80, 17);
    // DefaultSizeNodeFigure figure = new DefaultSizeNodeFigure(d);

    figure.setPreferredSize(d);
    figure.setSize(d);
    // figure.setLayoutManager(new StackLayout());
    // IFigure shape = createNodeShape();
    // figure.add(shape);
    contentPane = figure;
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
    return getChildBySemanticHint(AsteriskVisualIDRegistry.getType(WrapLabelEditPart.VISUAL_ID));
  }

  // @Override
  // public void setModel(Object model) {
  // QueryParamMapping map = (QueryParamMapping)resolveSemanticElement();
  // if (map != null){
  // map.eAdapters().add(this);
  // }
  // super.setModel(model);
  // }

  @Override
  public Notifier getTarget() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean isAdapterForType(Object type) {
    if (type instanceof QueryParamMapping)
      return true;
    return false;
  }

  @Override
  public void setTarget(Notifier newTarget) {
    // TODO Auto-generated method stub

  }

  @Override
  public void notifyChanged(Notification notification) {
    super.notifyChanged(notification);
  }

}
