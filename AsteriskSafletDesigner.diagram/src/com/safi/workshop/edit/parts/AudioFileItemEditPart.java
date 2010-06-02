/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.asterisk.figures.OutputFigure;
import com.safi.core.actionstep.AudioFileItem;
import com.safi.workshop.edit.policies.AudioFileItemItemSemanticEditPolicy;
import com.safi.workshop.edit.policies.EditAudioFilePolicy;
import com.safi.workshop.part.AsteriskVisualIDRegistry;
import com.safi.workshop.part.ValidateAction;

/**
 * @generated
 */
public class AudioFileItemEditPart extends ShapeNodeEditPart {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 2003;

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
  public AudioFileItemEditPart(View view) {
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
    } else if (notification.getFeature() instanceof EStructuralFeature
        && "dynamicValue".equals(((EStructuralFeature) notification.getFeature()).getName())) {
      ValidateAction.runValidation((DiagramEditPart) ((ToolstepEditPart) getParent().getParent())
          .getParent(), getDiagramView());
    } else if (!((HandlerEditPart) getParent().getParent().getParent()).isDebug()
        && (notification.getEventType() == Notification.ADD
            || notification.getEventType() == Notification.ADD_MANY
            || notification.getEventType() == Notification.REMOVE
            || notification.getEventType() == Notification.REMOVE_MANY
            || notification.getEventType() == Notification.SET || notification.getEventType() == Notification.UNSET))
      ValidateAction.runValidation((DiagramEditPart) ((ToolstepEditPart) getParent().getParent())
          .getParent(), getDiagramView());
    // TODO Auto-generated method stub
    super.handleNotificationEvent(notification);

  }

  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {

    super.createDefaultEditPolicies();
    // installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
    // new AsteriskConnectionHandleEditPolicy());
    installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AudioFileItemItemSemanticEditPolicy());
    // installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    installEditPolicy(EditPolicyRoles.OPEN_ROLE, new EditAudioFilePolicy());
    removeEditPolicy("NoteAttachmentReorient");
    // XXX need an SCR to runtime to have another abstract superclass that would let
    // children add reasonable editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
  }

  @Override
  public boolean canAttachNote() {
    return false;
  }

  public AudioFileItem getAudioFileItem() {
    return (AudioFileItem) resolveSemanticElement();
    // Object o = basicGetModel();
    // if (o instanceof AudioFileItem)
    // return (AudioFileItem) o;
    // else
    // return (AudioFileItem) ((Node) o).getElement();
  }

  public com.safi.core.actionstep.Item getItemModel() {
    return (com.safi.core.actionstep.Item) resolveSemanticElement();
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
   * @generated NOT
   */
  protected boolean addFixedChild(EditPart childEditPart) {
    if (childEditPart instanceof AudioFileItemLabelTextEditPart) {
      ((AudioFileItemLabelTextEditPart) childEditPart).setLabel(getPrimaryShape()
          .getFigureOutputNameFigure());
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
    return getChildBySemanticHint(AsteriskVisualIDRegistry
        .getType(AudioFileItemLabelTextEditPart.VISUAL_ID));
  }

}
