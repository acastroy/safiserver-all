package com.safi.workshop.edit.parts;

import java.beans.PropertyChangeEvent;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import com.safi.asterisk.figures.OutputTargetFigure;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.workshop.edit.parts.AsteriskRootEditPart.AsteriskConnectionLayerEx;
import com.safi.workshop.edit.policies.OutputTargetItemSemanticEditPolicy;

/**
 * @generated
 */
public class OutputTargetEditPart extends ConnectionNodeEditPart {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 3001;

  /**
   * @generated
   */
  public OutputTargetEditPart(View view) {
    super(view);
  }

  /**
   * @generated
   */
  @Override
  protected void createDefaultEditPolicies() {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new OutputTargetItemSemanticEditPolicy());
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
  protected Connection createConnectionFigure() {
    OutputTargetFigure fig = new OutputTargetFigure();
    fig.setLineWidth(2);
    return fig;
  }

  /**
   * @generated
   */
  public OutputTargetFigure getPrimaryShape() {
    return (OutputTargetFigure) getFigure();
  }

  @Override
  public boolean canAttachNote() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setSelected(int value) {
    // TODO Auto-generated method stub
  	OutputEditPart editPart = (OutputEditPart) getSource();
    if (editPart == null)
      return;
    final Output outputModel = editPart.getOutputModel();
    if (outputModel == null)
    	return;
    
  	int selection = getSelected();
    
    
    boolean wasSelected = selection == EditPart.SELECTED || selection == EditPart.SELECTED_PRIMARY;
    super.setSelected(value);
    selection = getSelected();
    boolean isSelected = selection == EditPart.SELECTED || selection == EditPart.SELECTED_PRIMARY;
    if (wasSelected && !isSelected)
      setLineWidth(2);
    else if (!wasSelected && isSelected) {
      setLineWidth(3);

      // ZOrderRequest zRequest = new ZOrderRequest(ZOrderRequest.REQ_BRING_TO_FRONT);
      // zRequest.setPartsToOrder(getParent().getChildren());
      // Command cmd = getCommand(zRequest);
      // getDiagramEditDomain().getDiagramCommandStack().execute(cmd);
      // Command cmd = getCommand(new ZO)
      // BringToFrontCommand cmd = new BringToFrontCommand(getEditingDomain(),
      // (View)getModel());
      // getDiagramEditDomain().getDiagramCommandStack().execute(new ICommandProxy(cmd));
      AsteriskRootEditPart part = (AsteriskRootEditPart) getParent();
      IFigure fig = part.getLayer(LayerConstants.CONNECTION_LAYER);
      // part.getChildren().remove(this);
      // part.getChildren().add(this);
      if (fig instanceof AsteriskConnectionLayerEx) {
        ((AsteriskConnectionLayerEx) fig).moveToFront(getConnectionFigure());
      }
      // fig.remove(this.getFigure());
      // fig.add(this.getFigure());
    }
    refreshForegroundColor();

  }

  // private ToolstepEditPart getParentActionStep() {
  // EditPart part = this;
  // while (part != null && !(part instanceof ToolstepEditPart))
  // part = part.getParent();
  //
  // return (ToolstepEditPart) part;
  // }

  @Override
  protected void refreshForegroundColor() {
    Color currentColor = getFigure().getForegroundColor();
    Color newColor = null;
    OutputEditPart editPart = (OutputEditPart) getSource();
    if (editPart == null)
      return;
    final Output outputModel = editPart.getOutputModel();
    if (outputModel == null)
    	return;
    int selection = getSelected();

    boolean isSelected = selection == EditPart.SELECTED || selection == EditPart.SELECTED_PRIMARY;

   
		OutputType type = outputModel.getOutputType();
    if (isSelected) {
      newColor = ColorConstants.black;
    } else if (type == OutputType.ERROR)
      newColor = ColorConstants.red;
    else if (type == OutputType.DEFAULT)
      newColor = ColorConstants.darkGreen;
    else
      newColor = ColorConstants.blue;
    final Color color = newColor;
    if (currentColor != newColor)
      setForegroundColor(color);
  }

  @Override
  protected void setLineWidth(int width) {
    getPrimaryShape().setLineWidth(width);
  }

  @Override
  protected void handleNotificationEvent(Notification notification) {
    super.handleNotificationEvent(notification);
  }

  @Override
  protected void handlePropertyChangeEvent(PropertyChangeEvent event) {
    super.handlePropertyChangeEvent(event);
  }
  // @Override
  // public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connEditPart) {
  //    
  // ConnectionAnchor anch = super.getSourceConnectionAnchor(connEditPart);
  //    
  // }
  //  
  // @Override
  // public ConnectionAnchor getSourceConnectionAnchor(Request request) {
  //    
  // IFigure fig = getFigure();
  // Point center = null;
  // if (fig instanceof Triangle){
  // return ((Triangle)fig).getAnchorFigure()
  // }
  // center = fig.getBounds().getCenter();
  // fig.translateToAbsolute(center);
  // Point pt = ((DropRequest)request).getLocation()==null ?
  // center : new Point(((DropRequest)request).getLocation());
  // if (request instanceof CreateRequest) {
  // fig.translateToRelative(pt);
  // }
  // return ((IAnchorableFigure)fig).getSourceConnectionAnchorAt(pt);
  // }

  // public Point getAnchorPoint(){
  // Rectangle r = Rectangle.SINGLETON;
  // r.setBounds(getBox());
  // r.translate(-1, -1);
  // r.resize(1, 1);
  //
  // getOwner().translateToAbsolute(r);
  // float centerX = r.x + 0.5f * r.width;
  // float centerY = r.y + 0.5f * r.height;
  //    
  // if (r.isEmpty() || (reference.x == (int)centerX && reference.y == (int)centerY))
  // return new Point((int)centerX, (int)centerY); //This avoids divide-by-zero
  //
  // float dx = reference.x - centerX;
  // float dy = reference.y - centerY;
  //    
  // //r.width, r.height, dx, and dy are guaranteed to be non-zero.
  // float scale = 0.5f / Math.max(Math.abs(dx) / r.width, Math.abs(dy) / r.height);
  //
  // dx *= scale;
  // dy *= scale;
  // centerX += dx;
  // centerY += dy;
  //
  // return new Point(Math.round(centerX), Math.round(centerY));
  // }
}
