package com.safi.workshop.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import com.safi.asterisk.figures.OutputTargetFigure;
import com.safi.workshop.edit.parts.AsteriskRootEditPart.AsteriskConnectionLayerEx;
import com.safi.workshop.edit.policies.CaseItemTargetToolstepItemSemanticEditPolicy;

/**
 * @generated
 */
public class CaseItemTargetToolstepEditPart extends ConnectionNodeEditPart {

  /**
   * @generated
   */
  public static final int VISUAL_ID = 3003;

  /**
   * @generated
   */
  public CaseItemTargetToolstepEditPart(View view) {
    super(view);
  }

  /**
   * @generated
   */
  @Override
  protected void createDefaultEditPolicies() {
    super.createDefaultEditPolicies();
    installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
        new CaseItemTargetToolstepItemSemanticEditPolicy());
  }

  @Override
  public boolean canAttachNote() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setSelected(int value) {
    // TODO Auto-generated method stub
    int selection = getSelected();
    boolean wasSelected = selection == EditPart.SELECTED || selection == EditPart.SELECTED_PRIMARY;
    super.setSelected(value);
    selection = getSelected();
    boolean isSelected = selection == EditPart.SELECTED || selection == EditPart.SELECTED_PRIMARY;
    if (wasSelected && !isSelected)
      setLineWidth(2);
    else if (!wasSelected && isSelected) {
      setLineWidth(3);

      AsteriskRootEditPart part = (AsteriskRootEditPart) getParent();
      IFigure fig = part.getLayer(LayerConstants.CONNECTION_LAYER);
      if (fig instanceof AsteriskConnectionLayerEx) {
        ((AsteriskConnectionLayerEx) fig).moveToFront(getConnectionFigure());
      }
    }
    refreshForegroundColor();

  }

  // @Override
  // public void refresh() {
  // super.refresh();
  // if (getSource() != null && getSource() instanceof CaseItemEditPart && getTarget() !=
  // null) {
  // try {
  // getEditingDomain().runExclusive(new Runnable() {
  //
  // public void run() {
  // setForegroundColor(ColorConstants.blue);
  // }
  // });
  // } catch (InterruptedException e) {
  // Trace.catching(DiagramUIPlugin.getInstance(),
  // DiagramUIDebugOptions.EXCEPTIONS_CATCHING,
  //            getClass(), "refresh", e); //$NON-NLS-1$
  // Log.error(DiagramUIPlugin.getInstance(),
  // DiagramUIStatusCodes.IGNORED_EXCEPTION_WARNING,
  //            "refresh", e); //$NON-NLS-1$
  // }
  // }
  //
  // }

  @Override
  protected void refreshForegroundColor() {
    Color currentColor = getFigure().getForegroundColor();
    // Color newColor = ColorConstants.blue;
    int selection = getSelected();
    boolean isSelected = selection == EditPart.SELECTED || selection == EditPart.SELECTED_PRIMARY;
    if (isSelected) {
      setForegroundColor(ColorConstants.black);
    } else {
      GraphicalEditPart gep = (GraphicalEditPart) getSource();
      if (gep == null)
        return;
      IFigure iFigure = gep.getFigure();
      if (iFigure == null)
        return;
      Color c = iFigure.getBackgroundColor();
      if (c == null)
        return;
      if (!c.equals(currentColor)) {
        setForegroundColor(c);
      }
    }
    // OutputType type = ((OutputEditPart) getSource()).getOutputModel().getOutputType();
    // if (type == OutputType.ERROR)
    // newColor = ColorConstants.red;
    // else if (type == OutputType.DEFAULT)
    // newColor = ColorConstants.darkGreen;
    // else
    // newColor = ColorConstants.blue;
    // final Color color = newColor;
    // if (currentColor != newColor) setForegroundColor(newColor);
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

}
