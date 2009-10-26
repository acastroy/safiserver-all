package com.safi.asterisk.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class CappedRectangleFigure extends RectangleFigure {

  private Color tipColor;
  private int tipWidth;

  private boolean hasCap = true;
  @Override
  protected void outlineShape(Graphics graphics) {
    if (!hasCap){
      super.outlineShape(graphics);
      return;
    }
    // TODO Auto-generated method stub
    Rectangle r = getBounds();

    int h = r.height - Math.max(1, lineWidth);
    int w = r.width - Math.max(1, lineWidth) - h / 2;

    int y = r.y + lineWidth / 2;
    int x = r.x + lineWidth / 2 + h / 2;

    graphics.drawLine(x, y, x + w, y);
    graphics.drawLine(x + w, y, x + w, y + h);
    graphics.drawLine(x + w, y + h, x, y + h);

    // graphics.drawRectangle(x, y, w, h);

    Rectangle srect = Rectangle.SINGLETON;
    srect.setBounds(new Rectangle(r.x, r.y, r.height, r.height));
    srect.width--;
    srect.height--;
    srect.shrink((lineWidth - 1) / 2, (lineWidth - 1) / 2);
    graphics.drawArc(srect, 90, 180);
    // graphics.drawOval(srect);
  }

  @Override
  protected void fillShape(Graphics graphics) {
    if (!hasCap){
      super.fillShape(graphics);
      return;
    }
    Rectangle r = getBounds();
    Rectangle srect = Rectangle.SINGLETON;
    srect.height = srect.width = r.height;
    srect.setLocation(r.x, r.y);

    graphics.fillRectangle(r.x + r.height / 2, r.y, r.width - r.height / 2, r.height);
    graphics.fillArc(srect, 90, 180);
    
    if (tipWidth > 0 && tipColor != null && tipColor != graphics.getBackgroundColor()) {
      Color oldColor = graphics.getBackgroundColor();
      graphics.setBackgroundColor(tipColor);
      graphics.fillRectangle(r.x + r.width - tipWidth, r.y, tipWidth , r.height);
      graphics.setBackgroundColor(oldColor);
    }
  }

  public Color getTipColor() {
    return tipColor;
  }

  public void setTipColor(Color capColor) {
    this.tipColor = capColor;
  }

  public int getTipWidth() {
    return tipWidth;
  }

  public void setTipWidth(int tipWidth) {
    this.tipWidth = tipWidth;
  }

  public boolean isHasCap() {
    return hasCap;
  }

  public void setHasCap(boolean hasCap) {
    this.hasCap = hasCap;
  }
}
