/******************************************************************************
 * Copyright (c) 2004, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package com.safi.asterisk.figures;

import java.util.List;
import java.util.ListIterator;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeUtil;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.swt.graphics.Color;

import com.safi.asterisk.figures.fonts.FontConstants;


/**
 * @author qili
 * 
 * To manage fixed connection anchors
 */
public class OutputFigure extends NodeFigure {

  private static final double INSET_PCT_H = 0.4;
  private static final double INSET_PCT_V = 0.1;
  protected FixedConnectionAnchor fixedAnchor;
  // protected Dimension prefSize;
  protected CappedRectangleFigure rectangleFigure;
  private Insets insets;
  private Border selectionBorder;
  private Color oldColor;
  private Label tooltip;
  private boolean capped = true;
  

  // /**
  // * @param gate
  // * @param parentFigure
  // */
  // public TerminalLocator(IFigure parentFigure, Dimension initDim, int side) {
  // super(parentFigure, initDim, side);
  // this.initDim = initDim;
  // }
  //    

  private WrapLabel outputNameLabel;
  
  public OutputFigure() {
    this(new Dimension(20, 20));
  }

  /**
   * @param preferredSide
   */
  public OutputFigure(Dimension prefSize) {
    super();
    insets = new Insets(0, 0, 0, 0);
    setPreferredSize(new Dimension(prefSize));
    
    // RectangularDropShadowLineBorder rectangularDropShadowLineBorder = new
    // RectangularDropShadowLineBorder(2);
    // rectangularDropShadowLineBorder.setShouldDrawDropShadow(false);
    // setBorder(rectangularDropShadowLineBorder);
    setBorder(null);
    StackLayout stackLayout = new StackLayout();
    setLayoutManager(stackLayout);
    createContents();
    
  }

  private void createContents() {
    tooltip = new Label();
    
    rectangleFigure = new CappedRectangleFigure();
    rectangleFigure.setTipWidth(8);
    rectangleFigure.setForegroundColor(ColorConstants.black);
    add(rectangleFigure);
    fixedAnchor = (FixedConnectionAnchor) createDefaultAnchor();
    
    outputNameLabel = new WrapLabel();
    outputNameLabel.setVisible(false);
    outputNameLabel.setTextWrap(false);
    
    
    outputNameLabel.setFont(FontConstants.OUTPUT_FONT);
    outputNameLabel.setTextAlignment(PositionConstants.RIGHT);
    outputNameLabel.setAlignment(PositionConstants.CENTER);
    FlowLayout layoutThis = new FlowLayout();
    layoutThis.setStretchMinorAxis(false);
    layoutThis.setMinorAlignment(FlowLayout.ALIGN_CENTER);

    layoutThis.setMajorAlignment(FlowLayout.ALIGN_CENTER);
    layoutThis.setMajorSpacing(0);
    layoutThis.setMinorSpacing(0);
    
    layoutThis.setHorizontal(true);
    
    rectangleFigure.setLayoutManager(layoutThis);
    rectangleFigure.add(outputNameLabel);
  }
  
  @Override
  public IFigure getToolTip() {
    // TODO Auto-generated method stub
    return super.getToolTip();
  }

  public void showSelectionFeedback(){
//    if (selectionBorder == null)
//      selectionBorder = new LineBorder(ColorConstants.black, 1);
//    setBorder(selectionBorder);
//    if (oldColor == null){
//      oldColor = rectangleFigure.getBackgroundColor();
//      rectangleFigure.setBackgroundColor( ColorConstants.lightBlue);
//    }
  }
  
  public void hideSelectionFeedback(){
//    setBorder(null);
//    if (oldColor != null){
//      rectangleFigure.setBackgroundColor(oldColor);
//      oldColor = null;
//      rectangleFigure.repaint();
//    }
  }
  @Override
  public void setSize(int w, int h) {
    // TODO Auto-generated method stub
    super.setSize(w, h);
    Rectangle r = getClientArea();
    rectangleFigure.setSize(r.width, r.height);
  }

  // @Override
  // public Rectangle getClientArea(Rectangle rect) {
  // rect.setBounds(getBounds());
  // rect.crop(getInsets());
  // if (useLocalCoordinates())
  // rect.setLocation(0, 0);
  // return rect;
  // }

  @Override
  public Insets getInsets() {
    if (getBorder() == null)
      return insets;
    return getBorder().getInsets(this);
//    return insets.add(getBorder().getInsets(this));
    
//    return insets;
//     return NO_INSETS;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getSourceConnectionAnchorAt(org.eclipse.draw2d.geometry.Point)
   */
  public ConnectionAnchor getSourceConnectionAnchorAt(Point p) {
//    if (p == null) {
//      return getConnectionAnchor(szAnchor);
//    }
    
    return fixedAnchor;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure#getTargetConnectionAnchorAt(org.eclipse.draw2d.geometry.Point)
   */
  public ConnectionAnchor getTargetConnectionAnchorAt(Point p) {
//    if (p == null) {
//      return getConnectionAnchor(szAnchor);
//    }
    return fixedAnchor;
  }

  // /**
  // * @see org.eclipse.draw2d.Figure#getPreferredSize(int, int)
  // */
  // public Dimension getPreferredSize(int wHint, int hHint) {
  // return new Dimension(prefSize);
  // }

  @Override
  public void setPreferredSize(Dimension size) {
    // TODO Auto-generated method stub
//    int hInset = Math.max((int) Math.min(size.width  * INSET_PCT_H, 5), 2);
//    int vInset = Math.max((int) Math.min(size.height * INSET_PCT_V, 5), 2);
//    insets = new Insets(vInset, 0, vInset, hInset);
    
    super.setPreferredSize(size);

  }

  @Override
  public void revalidate() {
    // TODO Auto-generated method stub
    super.revalidate();
  }
  
  @Override
  public void setBounds(Rectangle rect) {
    // TODO Auto-generated method stub
    super.setBounds(rect);
    updateAnchorOffsets(fixedAnchor);
  }
  
  
  @Override
  protected ConnectionAnchor createDefaultAnchor() {
    FixedConnectionAnchor fixedAnchor = new FixedConnectionAnchor(this);

    // fixedAnchor.offsetH = prefSize.width;
    updateAnchorOffsets(fixedAnchor);
    fixedAnchor.topDown = false;
    return fixedAnchor;
  }

  private void updateAnchorOffsets(FixedConnectionAnchor fixedAnchor) {
    Dimension size = getSize();
    Insets i = getInsets();
    fixedAnchor.offsetH = i.left + size.width;
    fixedAnchor.setOffsetV(size.height / 2); //trigger update
  }

  public CappedRectangleFigure getPrimaryFigure() {
    return rectangleFigure;
  }
  
  @Override
  public void setBackgroundColor(Color bg) {
    rectangleFigure.setTipColor(bg);
//    super.setBackgroundColor(bg);
  }
  
  @Override
  public Color getBackgroundColor() {
    if (rectangleFigure.getTipColor() != null)
      return rectangleFigure.getTipColor();
    return rectangleFigure.getBackgroundColor();
  }
  
  public void setLabelText(String text){
    if (text == null || text.trim().equals("")){
      outputNameLabel.setText("");
      outputNameLabel.setVisible(false);
      outputNameLabel.setToolTip(null);
    }
    else{
      outputNameLabel.setText(text);
      outputNameLabel.setVisible(true);
      tooltip.setText(text);
      outputNameLabel.setToolTip(tooltip);
      invalidateTree();
    }
  }

  // @Override
  // public Rectangle getBounds() {
  // Rectangle rec = super.getBounds();
  // return rec.expand(5, 5);
  // }

  /**
   * @author sshaw
   * 
   * Override for BorderItemLocator that will fix the location for the connection point
   * based on an initial position. This locator will also scale the location of the
   * connection if the parent figure changes.
   */
  static public class TerminalLocator extends BorderItemLocator {

    public TerminalLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
      super(borderItem, parentFigure, constraint);
      // TODO Auto-generated constructor stub
    }

    public TerminalLocator(IFigure parentFigure, int preferredSide) {
      super(parentFigure, preferredSide);
      // TODO Auto-generated constructor stub
    }

    public TerminalLocator(IFigure parentFigure) {
      super(parentFigure);
      // TODO Auto-generated constructor stub
    }

    public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
      Rectangle realLocation = new Rectangle(proposedLocation);
      Point newTopLeft = locateOnBorder(realLocation.getBottomRight(), 0, borderItem);
      realLocation.setLocation(newTopLeft);
      return realLocation;
    }

    public void relocateOrig(IFigure borderItem) {
      Dimension size = getSize(borderItem);

      Point ptNewLocation = locateOnBorder(getPreferredLocation(borderItem), 0, borderItem);
      borderItem.setLocation(ptNewLocation);
      borderItem.setSize(size);

      setCurrentSideOfParent(PositionConstants.EAST);
    }
    
    public void relocate(IFigure borderItem) {
      Dimension size = getSize(borderItem);
      int idx = borderItem.getParent().getChildren().indexOf(borderItem);
      Rectangle rect = getParentBorder();
      int y = rect.y + rect.height;
      int vertical_gap = MapModeUtil.getMapMode(getParentFigure()).DPtoLP(5);
      y -= (size.height+vertical_gap)*(idx+1);
      borderItem.setSize(size);
      Rectangle bounds = getParentBorder();
      int x = bounds.x + bounds.width - (getBorderItemOffset().width);
      borderItem.setLocation(new Point(x,y));
//      return new Point(x,y);
//      locateOnParent(getPreferredLocation(borderItem))
//      Point ptNewLocation = locateOnBorder(getPreferredLocation(borderItem), 0, borderItem);
//      ptNewLocation.y = y;
//      borderItem.setLocation(ptNewLocation);
//      borderItem.setSize(size);
//
//      setCurrentSideOfParent(PositionConstants.EAST);
    }
    
    /**
     * Get the preferred location. If none has been previously set, use the
     * preferred side to take an initial guess.
     * 
     * @return point
     */
    protected Point getPreferredLocation(IFigure borderItem) {
      return getPreferredLocation(PositionConstants.EAST, borderItem);
//        Point constraintLocation = getConstraint().getLocation();
//        Point ptAbsoluteLocation = this.getAbsoluteToBorder(constraintLocation);
//
//        if (constraintLocation.x == 0 || constraintLocation.y == 0) {
//            return getPreferredLocation(getPreferredSideOfParent(), borderItem);
//        } else {
//            return ptAbsoluteLocation;
//        }
    }

    private Point locateOnBorder(Point suggestedLocation, int circuitCount,
        IFigure borderItem) {
      Point recommendedLocation = locateOnParent(suggestedLocation, borderItem);
      // if (true) return recommendedLocation;
      int vertical_gap = MapModeUtil.getMapMode(getParentFigure()).DPtoLP(5);
//      int horizontal_gap = MapModeUtil.getMapMode(getParentFigure()).DPtoLP(8);
      Dimension borderItemSize = getSize(borderItem);
//      int nextY = getMaxY(recommendedLocation, borderItem);
      
//      recommendedLocation.y = nextY;
      if (circuitCount < 10 && conflicts(recommendedLocation, borderItem, vertical_gap)) {

        // move up the east side
        do {
//          recommendedLocation.y -= (borderItemSize.height + vertical_gap);
          recommendedLocation.y -= 2;
        } while (conflicts(recommendedLocation, borderItem, vertical_gap));
//        if (recommendedLocation.y < getParentBorder().getTopRight().y) {
//          // east is full, try north.
//        }
      }
//      recommendedLocation.y = nextY;
      return recommendedLocation;
    }
    
    private int getMaxY(Point recommendedLocation, IFigure targetBorderItem){
      recommendedLocation = getPreferredLocation(targetBorderItem);
      Rectangle recommendedRect = new Rectangle(recommendedLocation, targetBorderItem.getSize());
      List borderItems = targetBorderItem.getParent().getChildren();
      
      ListIterator iterator = borderItems.listIterator();
      int maxY = Integer.MIN_VALUE;
      while (iterator.hasNext()) {
        IFigure borderItem = (IFigure) iterator.next();
        if (borderItem.isVisible()) {
          if (borderItem != targetBorderItem && (borderItem.getBounds().y-(5+recommendedRect.height)) > maxY){
            maxY = borderItem.getBounds().y;
          }
        }
      }
      if (maxY == Integer.MIN_VALUE)
        maxY = recommendedLocation.y;
//      if (maxY == -1)
//        return maxY = getPreferredLocation(targetBorderItem).y;
      return maxY;
    }

    private boolean conflicts(Point recommendedLocation, IFigure targetBorderItem, int vGap) {
      Rectangle recommendedRect = new Rectangle(recommendedLocation, targetBorderItem.getSize());
      recommendedRect.expand(0, vGap);
      List borderItems = targetBorderItem.getParent().getChildren();
      ListIterator iterator = borderItems.listIterator();
      while (iterator.hasNext()) {
        IFigure borderItem = (IFigure) iterator.next();
        if (borderItem.isVisible()) {
          Rectangle rect = borderItem.getBounds().getCopy();
          if (borderItem != targetBorderItem && rect.intersects(recommendedRect)) {
            return true;
          }
        }
      }
      return false;
    }
    
    /**
     * Get an initial location based on the side. ( choose middle of the side )
     * 
     * @param side
     *            the preferred side of the parent figure on which to place this
     *            border item as defined in {@link PositionConstants}
     * @return point
     */
    protected Point getPreferredLocation(int side, IFigure borderItem) {
        Rectangle bounds = getParentBorder();
        int parentFigureWidth = bounds.width;
        int parentFigureHeight = bounds.height;
        int parentFigureX = bounds.x;
        int parentFigureY = bounds.y;
        int x = parentFigureX;
        int y = parentFigureY;

//        Dimension borderItemSize = getSize(borderItem);

        x = parentFigureX + parentFigureWidth - getBorderItemOffset().width;
//      y += parentFigureHeight / 2;
        y += parentFigureHeight - (borderItem.getSize().height + 8);
        return new Point(x, y);
        
    }
    

    private Point locateOnParent(Point suggestedLocation, IFigure borderItem) {
      
      Rectangle bounds = getParentBorder();
      int parentFigureWidth = bounds.width;
      int parentFigureHeight = bounds.height;
      int parentFigureX = bounds.x;
      int parentFigureY = bounds.y;
      Dimension borderItemSize = getSize(borderItem);
      int newX = suggestedLocation.x;
      int newY = suggestedLocation.y;
//      int westX = parentFigureX - borderItemSize.width + getBorderItemOffset().width;
      int eastX = parentFigureX + parentFigureWidth - getBorderItemOffset().width;
      int southY = parentFigureY + parentFigureHeight - getBorderItemOffset().height;
      int height = borderItemSize.height;
      int northY = parentFigureY - height + getBorderItemOffset().height;
      
      if (suggestedLocation.x != eastX) {
        newX = eastX;
      }
      if (suggestedLocation.y < bounds.getTopLeft().y) {
        newY = northY + height;
      } else if (suggestedLocation.y > (bounds.getBottomLeft().y - height)) {
        newY = southY;// - height;
      }
      return new Point(newX, newY);
      
    }
  }

  public WrapLabel getFigureOutputNameFigure() {
    return outputNameLabel;
  }

  public boolean isCapped() {
    return capped;
  }

  public void setCapped(boolean capped) {
    this.capped = capped;
    if (rectangleFigure != null){
      rectangleFigure.setHasCap(capped);
    }
  }
}
