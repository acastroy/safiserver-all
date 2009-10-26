package com.safi.asterisk.figures;

import org.eclipse.draw2d.FlowLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

public class HandlerHandoffFigure extends DefaultToolstepFigure {

  private WrapLabel handlerTargetLabel;
  public HandlerHandoffFigure() {
    // TODO Auto-generated constructor stub
  }

 
  @Override
  protected void buildLayout() {
    FlowLayout layoutThis = new FlowLayout();
    layoutThis.setStretchMinorAxis(false);
    layoutThis.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);

    layoutThis.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
    layoutThis.setMajorSpacing(5);
    layoutThis.setMinorSpacing(5);
    layoutThis.setHorizontal(false);
    getRootPane().setLayoutManager(layoutThis);

  }
  @Override
  protected void createContents() {
    super.createContents();
    handlerTargetLabel = new WrapLabel();

    getRootPane().add(handlerTargetLabel);
  }
  
  public WrapLabel getHandlerHandoffNameLabel() {
    // TODO Auto-generated method stub
    return super.getToolstepNameLabel();
  }

  public WrapLabel getHandlerTargetLabel() {
    return handlerTargetLabel;
  }

  
  

}
