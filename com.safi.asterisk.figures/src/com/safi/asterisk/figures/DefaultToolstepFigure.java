package com.safi.asterisk.figures;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

/**
 * @generated
 */
public class DefaultToolstepFigure extends ToolstepFigure {

  IFigure tooltip;
  boolean minimized = false;
  public DefaultToolstepFigure(){
    super();
    
  }
  
  public DefaultToolstepFigure(IFigure rootPane){
    super(rootPane);
  }
  /**
   * @generated
   */
  protected ActionstepWrapLabel toolstepNameLabel;

  /**
   * @generated
   */
  protected void createContents() {
    getRootPane().add(createToolstepNameLabel());
  }
  
  protected WrapLabel createToolstepNameLabel(){
    tooltip = new Label();
    toolstepNameLabel = new ActionstepWrapLabel();
    toolstepNameLabel.setToolTip(tooltip);
//    toolstepNameLabel.setText("");
    return toolstepNameLabel;
  }


  /**
   * @generated
   */
  public WrapLabel getToolstepNameLabel() {
    return toolstepNameLabel;
  }

  public boolean isMinimized() {
    return minimized;
  }

  public void setMinimized(boolean minimized) {
    if (minimized){
      toolstepNameLabel.setTextHidden(true);
    }
    else
      toolstepNameLabel.setTextHidden(false);
    invalidate();
//    layout();
      
  }
  
  class ActionstepWrapLabel extends WrapLabel {
    boolean textHidden;
    String cachedText = null;

    public boolean isTextHidden() {
      return textHidden;
    }

    public void setTextHidden(boolean textHidden) {
      this.textHidden = textHidden;
      if (textHidden)
        super.setText("");
      else
        super.setText(cachedText);
      invalidate();
    }
    
    @Override
    public String getText() {
      return textHidden ? "" : super.getText();
    }
    
    @Override
    public void setText(String s) {
      cachedText = s;
      super.setText(s);
      if (tooltip != null)
        ((Label)tooltip).setText(s);
    }
    
  }

}
