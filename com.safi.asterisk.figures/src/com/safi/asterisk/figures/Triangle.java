package com.safi.asterisk.figures;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Orientable;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * A triangular graphical figure.
 */
public class Triangle extends Shape implements Orientable {

  /**
   * The direction this triangle will face. Possible values are
   * {@link PositionConstants#NORTH}, {@link PositionConstants#SOUTH},
   * {@link PositionConstants#EAST} and {@link PositionConstants#WEST}.
   */
  protected int direction = EAST;
  /**
   * The orientation of this triangle. Possible values are {@link Orientable#VERTICAL} and
   * {@link Orientable#HORIZONTAL}.
   */
  protected int orientation = VERTICAL;

  public Triangle() {
    super();
    FlowLayout layoutThis = new FlowLayout();
    layoutThis.setStretchMinorAxis(false);
    layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

    layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
    layoutThis.setMajorSpacing(5);
    layoutThis.setMinorSpacing(5);
    layoutThis.setHorizontal(true);
    
    anchorFigure = new Ellipse();
    anchorFigure.setSize(1, 1);
  }

  /** The points of the triangle. */
  protected PointList triangle = new PointList(3);
  private IFigure anchorFigure;

  /**
   * @see Shape#fillShape(Graphics)
   */
  protected void fillShape(Graphics g) {
    g.fillPolygon(triangle);
  }

  /**
   * @see Shape#outlineShape(Graphics)
   */
  protected void outlineShape(Graphics g) {
    g.drawPolygon(triangle);
  }

  /**
   * @see Figure#primTranslate(int, int)
   */
  public void primTranslate(int dx, int dy) {
    super.primTranslate(dx, dy);
    triangle.translate(dx, dy);
  }

  /**
   * @see Orientable#setDirection(int)
   */
  public void setDirection(int value) {
    if ((value & (NORTH | SOUTH)) != 0)
      orientation = VERTICAL;
    else
      orientation = HORIZONTAL;
    direction = value;
    revalidate();
    repaint();
  }

  /**
   * @see Orientable#setOrientation(int)
   */
  public void setOrientation(int value) {
    if (orientation == VERTICAL && value == HORIZONTAL) {
      if (direction == NORTH)
        setDirection(WEST);
      else
        setDirection(EAST);
    }
    if (orientation == HORIZONTAL && value == VERTICAL) {
      if (direction == WEST)
        setDirection(NORTH);
      else
        setDirection(SOUTH);
    }
  }

  /**
   * @see IFigure#validate()
   */
  public void validate() {
    super.validate();
    Rectangle r = new Rectangle();
    r.setBounds(getBounds());
    r.crop(getInsets());
    r.resize(-1, -1);
    
    Point head, p2, p3;

    switch (direction) {
      case NORTH:
        head = new Point(r.x + r.width / 2, r.y);
        p2 = new Point(r.x, r.y+r.height);
        p3 = new Point(r.x+r.width, r.y+r.height);
        break;
      case SOUTH:
        head = new Point(r.x + r.width / 2, r.y + r.height);
        p2 = new Point(r.x, r.y);
        p3 = new Point(r.x+r.width, r.y);
        break;
      case WEST:
        head = new Point(r.x, r.y + r.height / 2);
        p2 = new Point(r.x+r.width, r.y);
        p3 = new Point(r.x+r.width, r.y+r.height);
        break;
      default:
        head = new Point(r.x + r.width, r.y + r.height / 2);
        p2 = new Point(r.x, r.y);
        p3 = new Point(r.x, r.y+r.height);

    }
    triangle.removeAllPoints();
    triangle.addPoint(head);
    triangle.addPoint(p2);
    triangle.addPoint(p3);
    anchorFigure.setLocation(head);
  }

  public IFigure getAnchorFigure() {
    return anchorFigure;
  }

}
