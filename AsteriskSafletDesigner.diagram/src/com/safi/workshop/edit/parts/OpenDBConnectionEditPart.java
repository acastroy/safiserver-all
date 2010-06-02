/*
 * Safi Systems LLC, Copyright 2008 All Rights Reserved
 */
package com.safi.workshop.edit.parts;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import com.safi.asterisk.figures.DefaultToolstepFigure;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.core.actionstep.OpenDBConnection;
import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.SafiDriverManager;
import com.safi.server.saflet.manager.DBManager;
import com.safi.workshop.edit.policies.OpenDBConnectionCanonicalEditPolicy;
import com.safi.workshop.edit.policies.OpenDBConnectionItemSemanticEditPolicy;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated NOT
 */
public class OpenDBConnectionEditPart extends ToolstepEditPart {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 1077;

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
  public OpenDBConnectionEditPart(View view) {
    super(view);
  }

  /**
   * @generated NOT
   */
  @Override
  protected void createDefaultEditPolicies() {
    installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CreationEditPolicy());

    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OpenDBConnectionItemSemanticEditPolicy());
    installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
    installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new OpenDBConnectionCanonicalEditPolicy());
    installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
    // installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenConnectionEditPolicy());
    // XXX need an SCR to runtime to have another abstract superclass that would let
    // children add reasonable editpolicies
    // removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
  }

  /**
   * @generated NOT
   */
  @Override
  protected boolean addFixedChild(EditPart childEditPart) {
    if (super.addFixedChild(childEditPart))
      return true;
    if (childEditPart instanceof OpenDBConnectionNameEditPart) {
      ((OpenDBConnectionNameEditPart) childEditPart).setLabel(getPrimaryShape()
          .getToolstepNameLabel());
      return true;
    }
    return false;
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
    return getChildBySemanticHint(AsteriskVisualIDRegistry
        .getType(OpenDBConnectionNameEditPart.VISUAL_ID));
  }

  @Override
  public IStatus validate() {
    // TODO Auto-generated method stub
    try {
      SafiDriverManager dm = DBManager.getInstance().getDriverManager();
      if (dm == null)
        return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID,
            "Safi DB Driver Manager could not be found.  Check your DB configuration");

      OpenDBConnection openConn = (OpenDBConnection) getActionStep();
      DBConnectionId connection = openConn.getConnection();
      if (connection == null)
        return super.validate();

      String id = connection.getId();
      String[] path = id.split("\\.");
      if (path.length != 2)
        return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID,
            "Couldn't find connection from path " + id);
      DBDriver driver = dm.getDriver(path[0]);
      if (driver == null)
        return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID,
            "Couldn't find connection from path " + path[0]);
      DBConnection conn = driver.getConnection(path[1]);
      if (conn == null)
        return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID,
            "Couldn't find connection " + id);
    } catch (Exception exe) {
      return new Status(IStatus.ERROR, AsteriskDiagramEditorPlugin.ID, "Couldn't find connection "
          + exe.getLocalizedMessage());
    }
    return super.validate();
  }

}
