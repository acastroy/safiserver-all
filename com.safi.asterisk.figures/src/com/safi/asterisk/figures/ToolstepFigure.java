package com.safi.asterisk.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public abstract class ToolstepFigure extends RoundedRectangle {

  private IFigure rootPane;

  public ToolstepFigure(IFigure rootPane) {
    if (rootPane != null && rootPane != this) {
      this.rootPane = rootPane;
      setLayoutManager(new StackLayout());
      add(rootPane);
      setBackgroundColor(null);
      setForegroundColor(null);
      // setBackgroundColor(ColorConstants.white);
      // setForegroundColor(ColorConstants.white);
      this.setOpaque(false);
      rootPane.setOpaque(false);
      // setBorder(null);
    } else {
      this.rootPane = this;
      setForegroundColor(ActionstepColors.actionBGBlue);
      setBackgroundColor(ColorConstants.white);
      this.setOpaque(true);
    }

    setCornerDimensions(new Dimension(15, 15));
    buildLayout();
    createContents();
    getRootPane().setBorder(new MarginBorder(5, 5, 0, 5));
  }

  public ToolstepFigure() {
    this(null);
  }

  protected void buildLayout() {
    FlowLayout layoutThis = new FlowLayout();
    layoutThis.setStretchMinorAxis(false);
    layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

    layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
    layoutThis.setMajorSpacing(5);
    layoutThis.setMinorSpacing(5);
    layoutThis.setHorizontal(true);
    getRootPane().setLayoutManager(layoutThis);

  }

  @Override
  protected void paintClientArea(Graphics graphics) {
    // TODO Auto-generated method stub
    super.paintClientArea(graphics);
  }
  
  
  @Override
  public void paintFigure(Graphics graphics) {
    if (rootPane == this)
      super.paintFigure(graphics);
  }
  @Override
  protected void fillShape(Graphics graphics) {
    // Rectangle r = getBounds().getCopy();
    // Point topLeft = r.getTopLeft();
    // Point bottomRight = r.getBottomRight();
    // Pattern pattern = new Pattern(Display.getCurrent(), topLeft.x, topLeft.y,
    // bottomRight.x,
    // bottomRight.y, ColorConstants.white, ColorConstants.darkBlue);
    // graphics.setBackgroundPattern(pattern);
    // graphics.fillRoundRectangle(r, corner.width, corner.height);
    // graphics.setBackgroundPattern(null);
    // pattern.dispose();
    if (rootPane == this) {
      super.fillShape(graphics);
      Rectangle r = getBounds().getCopy();
      r.resize((int) (-r.width * .25d), 0);
      graphics.fillGradient(r, false);
    }
  }

  protected abstract void createContents();

  protected IFigure getRootPane() {
    return rootPane;
  }

  /**
   * @generated
   */
  protected boolean myUseLocalCoordinates = false;

  /**
   * @generated
   */
  protected boolean useLocalCoordinates() {
    return myUseLocalCoordinates;
  }

  /**
   * @generated
   */
  protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
    myUseLocalCoordinates = useLocalCoordinates;
  }
}
