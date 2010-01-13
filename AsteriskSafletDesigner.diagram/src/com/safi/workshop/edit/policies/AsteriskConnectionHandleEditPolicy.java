package com.safi.workshop.edit.policies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionHandleEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandleLocator;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import com.safi.asterisk.figures.FixedConnectionAnchor;
import com.safi.asterisk.figures.OutputFigure;
import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.Item;
import com.safi.core.initiator.Initiator;
import com.safi.workshop.edit.parts.ActionstepSubItem;
import com.safi.workshop.edit.parts.CaseItemEditPart;
import com.safi.workshop.edit.parts.OutputEditPart;

public class AsteriskConnectionHandleEditPolicy extends ConnectionHandleEditPolicy {

  @Override
  protected String buildTooltip(HandleDirection direction) {

    if (getHost() instanceof OutputEditPart
        && ((direction != HandleDirection.OUTGOING) || ((OutputEditPart) getHost())
            .getOutputModel().getTarget() != null))
      return null;

    if (getHost() instanceof CaseItemEditPart
        && ((direction != HandleDirection.OUTGOING) || ((ActionstepSubItem) getHost())
            .getItemModel().getTargetActionStep() != null))
      return null;

    else if ((getHost().getModel() instanceof View)
        && (((View) getHost().getModel()).getElement() instanceof Item)
        && ((Item) ((View) getHost().getModel()).getElement()).getTargetActionStep() != null) {
      return null;

    }
    // if (getHost().getModel() instanceof Node &&
    // ((Node)getHost().getModel()).getElement() instanceof ActionStep)
    // return null;
    // TODO Auto-generated method stub
    return super.buildTooltip(direction);
  }

  @Override
  protected void addFeedback(IFigure figure) {
    // TODO Auto-generated method stub
    super.addFeedback(figure);

  }

  @Override
  protected void removeFeedback(IFigure figure) {
    // TODO Auto-generated method stub
    super.removeFeedback(figure);

  }

  @Override
  protected void showDiagramAssistant(Point referencePoint) {
    // TODO Auto-generated method stub
    super.showDiagramAssistant(referencePoint);
    if (getHost() instanceof OutputEditPart
        && ((OutputEditPart) getHost()).getOutputModel().getTarget() == null) {
      ((OutputFigure) getHostFigure()).showSelectionFeedback();
    } else if (getHost() instanceof ActionstepSubItem
        && ((ActionstepSubItem) getHost()).getItemModel().getTargetActionStep() == null)
      ((OutputFigure) getHostFigure()).showSelectionFeedback();
    // else if ((getHost().getModel() instanceof View)
    // && (((View) getHost().getModel()).getElement() instanceof CaseItem)
    // && ((CaseItem) ((View) getHost().getModel()).getElement()).getTargetActionStep() ==
    // null) {
    // ((OutputFigure) getHostFigure()).showSelectionFeedback();
    //
    // }
  }

  @Override
  protected void hideDiagramAssistant() {
    // TODO Auto-generated method stub
    super.hideDiagramAssistant();
    if (getHost() instanceof OutputEditPart || getHost() instanceof ActionstepSubItem) {
      ((OutputFigure) getHostFigure()).hideSelectionFeedback();
    }
    // else if ((getHost().getModel() instanceof View)
    // && (((View) getHost().getModel()).getElement() instanceof CaseItem)) {
    // ((OutputFigure) getHostFigure()).showSelectionFeedback();
    // }
  }

  @Override
  protected int getAppearanceDelay() {
    return 0;
  }

  @Override
  protected int getDisappearanceDelayUponExit() {
    // TODO Auto-generated method stub
    return 100;
  }

  @Override
  protected List getHandleFigures() {
    if (getHost() instanceof OutputEditPart
        && ((OutputEditPart) getHost()).getOutputModel().getTarget() == null) {
      return Collections.singletonList((new ConnectionHandle((IGraphicalEditPart) getHost(),
          HandleDirection.OUTGOING, "Select next toolstep")));
    }

    if (getHost() instanceof ActionstepSubItem
        && ((ActionstepSubItem) getHost()).getItemModel().getTargetActionStep() == null) {
      return Collections.singletonList((new ConnectionHandle((IGraphicalEditPart) getHost(),
          HandleDirection.OUTGOING, "Select next toolstep")));
    }
    // else if ((getHost().getModel() instanceof View)
    // && (((View) getHost().getModel()).getElement() instanceof CaseItem)
    // && ((CaseItem) ((View) getHost().getModel()).getElement()).getTargetActionStep() ==
    // null) {
    // return Collections.singletonList((new ConnectionHandle((IGraphicalEditPart)
    // getHost(),
    // HandleDirection.OUTGOING, "Select next toolstep")));
    //
    // }
    if (getHost().getModel() instanceof Node
        && ((Node) getHost().getModel()).getElement() instanceof ActionStep) {
      // return Collections.singletonList((new ConnectionHandle((IGraphicalEditPart)
      // getHost(),
      // HandleDirection.INCOMING, "Create incoming connection")));
      return null;
    }

    if (getHost().getModel() instanceof Node
        && ((Node) getHost().getModel()).getElement() instanceof Initiator) {
      return Collections.singletonList((new ConnectionHandle((IGraphicalEditPart) getHost(),
          HandleDirection.OUTGOING, "Select next toolstep")));
    }
    // TODO Auto-generated method stub
    return super.getHandleFigures();
  }

  @Override
  protected ConnectionHandleLocator getConnectionHandleLocator(Point referencePoint) {
    return new AsteriskConnectionHandleLocator(getHostFigure(), referencePoint);
  }

  static class AsteriskConnectionHandleLocator extends ConnectionHandleLocator {

    /** number of pixels between connection handles */
    private static int HANDLE_SPACING = 20;

    /** the MARGIN to leave by the edge of the parent figure */
    private static int MARGIN = 2;

    /** list of connection handles for the shape */
    private List handles = new ArrayList();

    /** a point in the shape used when locating the handles */
    private Point cursorPosition = null;

    /** the parent figure */
    private IFigure reference = null;

    /** the side on which the handles will appear, value from PositionConstants */
    private int side = PositionConstants.EAST;

    /** the point on the border where the handles should appear */
    private Point borderPoint = new Point(0, 0);

    /**
     * flag to indicate if the connection handle should only be on the east, west, or
     * south side
     */
    private boolean bEastWestSouth = false;

    /**
     * Constructor for ConnectionHandleLocator.
     * 
     * @param reference
     *          the figure
     * @param cursorPosition
     *          the handles will be located on the border of the shape as close to this
     *          position as possible
     */
    public AsteriskConnectionHandleLocator(IFigure reference, Point cursorPosition) {
      super(reference, cursorPosition);
      this.reference = reference;
      this.cursorPosition = cursorPosition;
    }

    /**
     * Adds a connection handle to the list of handles.
     * 
     * @param handle
     *          the <code>ConnectionHandle</code> to add
     */
    @Override
    public void addHandle(ConnectionHandle handle) {
      handles.add(handle);
    }

    /**
     * Sets the point on the West, East, North or South edge of the reference figure
     * nearest to the cursor position passed in to the constructor. Sets the side variable
     * for which side the handles will be on.
     */
    private void resetBorderPointAndSideAllDirections() {

      Rectangle bounds = getReferenceFigureBounds();
      int westDiff = cursorPosition.x - bounds.getLeft().x;
      int eastDiff = bounds.getRight().x - cursorPosition.x;
      int southDiff = bounds.getBottom().y - cursorPosition.y;
      int northDiff = cursorPosition.y - bounds.getTop().y;

      double minLR = Math.min(eastDiff, westDiff);
      double minUD = Math.min(southDiff, northDiff);
      // which directions is closest North/South or East/West?
      boolean bUp = (minUD < minLR);

      if (bUp) {
        if (northDiff < southDiff) {
          // re-evaluate if the north is closer than the east since the
          // handles will be placed in the north-west corner because of
          // the action bar.
          if (eastDiff < westDiff && eastDiff < cursorPosition.getDistance(bounds.getTopLeft())) {
            borderPoint.setLocation(bounds.x + bounds.width, cursorPosition.y);
            side = PositionConstants.EAST;
          } else {
            borderPoint.setLocation(bounds.x, bounds.y);
            side = PositionConstants.NORTH;
          }
        } else {
          borderPoint.setLocation(cursorPosition.x, bounds.y + bounds.height);
          side = PositionConstants.SOUTH;
        }
      } else {
        if (westDiff < eastDiff) {
          borderPoint.setLocation(bounds.x, cursorPosition.y);
          side = PositionConstants.WEST;
        } else {
          //
          borderPoint.setLocation(bounds.x + bounds.width, cursorPosition.y);
          side = PositionConstants.EAST;
        }
      }
    }

    /**
     * Sets the point on the West, East, South edge of the reference figure nearest to the
     * cursor position passed in to the constructor. Sets the side variable for which side
     * the handles will be on.
     */
    private void resetBorderPointAndSideEastWestSouth() {
      Rectangle bounds = getReferenceFigureBounds();

      // Get the point on the West, East, or South edge of the reference
      // figure
      // nearest to the cursor position.
      int westDiff = cursorPosition.x - bounds.x;
      int eastDiff = bounds.x + bounds.width - cursorPosition.x;
      int southDiff = bounds.y + bounds.height - cursorPosition.y;

      int min = Math.min(westDiff, eastDiff);
      if (westDiff > 30 && eastDiff > 30) { // favour East and West
        min = Math.min(min, southDiff);
      }

      if (min == westDiff) {
        borderPoint.setLocation(bounds.x, cursorPosition.y);
        side = PositionConstants.WEST;
      } else if (min == eastDiff) {
        borderPoint.setLocation(bounds.x + bounds.width, cursorPosition.y);
        side = PositionConstants.EAST;
      } else {
        borderPoint.setLocation(cursorPosition.x, bounds.y + bounds.height);
        side = PositionConstants.SOUTH;
      }

    }

    /**
     * Resets the border point and side variables where the connection handles will
     * appear, based on the cursor location.
     */
    private void resetBorderPointAndSide() {

      if (isEastWestSouth())
        resetBorderPointAndSideEastWestSouth();
      else
        resetBorderPointAndSideAllDirections();
    }

    /**
     * Gets the side (West, South, or East) on which the handles will appear, using the
     * cursor position passed in to the constructor.
     * 
     * @return the side, a value in PositionContstants
     */
    @Override
    public int getBorderSide() {
      if (!(reference instanceof OutputFigure)) {
        resetBorderPointAndSide();
      }

      return side;
    }

    /**
     * Locates the figure on the appropriate edge of the parent depending on which side is
     * closest to the reference point. Then adjusts the figure depending on the number of
     * handles that this locator has so that the handles are spaced out from the center
     * along the edge of the shape.
     * 
     * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
     */
    @Override
    public void relocate(IFigure target) {

      if (reference instanceof OutputFigure) {

        OutputFigure fig = (OutputFigure) reference;
        ConnectionAnchor anch = fig.getSourceConnectionAnchorAt(null);

        Point borderPointTranslated = ((FixedConnectionAnchor) anch).getLocation(Point.SINGLETON);
        target.translateToRelative(borderPointTranslated);
        borderPointTranslated.translate(0, -(int) (target.getBounds().height * 0.95 / 2));// fudge
        // factor
        // req'd
        // for
        // unknown
        // reason

        target.setLocation(borderPointTranslated);

      } else {
        Rectangle bounds = getReferenceFigureBounds();
        resetBorderPointAndSide();

        Point borderPointTranslated = borderPoint.getCopy();
        reference.translateToAbsolute(bounds);
        target.translateToRelative(bounds);
        reference.translateToAbsolute(borderPointTranslated);
        target.translateToRelative(borderPointTranslated);

        int width = target.getBounds().width;
        int halfWidth = width / 2;

        int height = target.getBounds().height;
        int halfHeight = height / 2;

        // adjust border point if the handles will extend past the bounds of the
        // shape
        if (side == PositionConstants.WEST || side == PositionConstants.EAST) {
          int halfTotalHeight = (height * handles.size() + HANDLE_SPACING * (handles.size() - 1)) / 2;
          if (borderPointTranslated.y - halfTotalHeight < bounds.getTop().y) {
            borderPointTranslated.y = bounds.getTop().y + halfTotalHeight;
          } else if (borderPointTranslated.y + halfTotalHeight > bounds.getBottom().y) {
            borderPointTranslated.y = bounds.getBottom().y - halfTotalHeight;
          }
        } else {
          int halfTotalWidth = (width * handles.size() + HANDLE_SPACING * (handles.size() - 1)) / 2;
          if (borderPointTranslated.x - halfTotalWidth < bounds.getLeft().x) {
            borderPointTranslated.x = bounds.getLeft().x + halfTotalWidth;
          } else if (borderPointTranslated.x + halfTotalWidth > bounds.getRight().x) {
            borderPointTranslated.x = bounds.getRight().x - halfTotalWidth;
          }
          if (side == PositionConstants.WEST) {
            target.setLocation(borderPointTranslated.getTranslated(new Dimension(-(width + MARGIN),
                -halfHeight)));
          } else if (side == PositionConstants.EAST) {
            target.setLocation(borderPointTranslated.getTranslated(new Dimension(MARGIN,
                -halfHeight)));
          } else if (side == PositionConstants.SOUTH) {
            target.setLocation(borderPointTranslated
                .getTranslated(new Dimension(-halfWidth, MARGIN)));
          } else if (side == PositionConstants.NORTH) {
            target.setLocation(borderPointTranslated.getTranslated(new Dimension(MARGIN, -height
                - MARGIN)));
          }
        }

        // set location based on side

        int index = handles.indexOf(target);
        double centerOffset = index - (handles.size() / 2.0) + 0.5;

        if (side == PositionConstants.WEST || side == PositionConstants.EAST) {
          target.translate(0, (int) (centerOffset * HANDLE_SPACING));
        } else {
          target.translate((int) (centerOffset * HANDLE_SPACING), 0);
        }

      }

      // space out handles

    }

    /**
     * Gets the bounding rectangle of the reference figure.
     * 
     * @return the bounds
     */
    private Rectangle getReferenceFigureBounds() {
      Rectangle bounds = reference instanceof HandleBounds ? ((HandleBounds) reference)
          .getHandleBounds().getCopy() : reference.getBounds().getCopy();
      return bounds;
    }

    /**
     * Gets the reference figure.
     * 
     * @return Returns the reference.
     */
    @Override
    protected IFigure getReference() {
      return reference;
    }

    /**
     * Gets the cursor position.
     * 
     * @return Returns the cursorPosition.
     */
    @Override
    protected Point getCursorPosition() {
      return cursorPosition;
    }

    /**
     * Can the connection handle can only be located on the east, west, or south side of
     * the reference figure.
     * 
     * @return Returns true if the connection handle can only be located on the east,
     *         west, or south side of the reference figure; false otherwise.
     */
    @Override
    public boolean isEastWestSouth() {
      return bEastWestSouth;
    }

    /**
     * Set to true if the connection handle can only be located on the east, west, or
     * south side of the reference figure.
     * 
     * @param eastWestSouth
     *          The bEastWestSouth to set.
     */
    @Override
    public void setEastWestSouth(boolean eastWestSouth) {
      bEastWestSouth = eastWestSouth;
    }

  }

}
