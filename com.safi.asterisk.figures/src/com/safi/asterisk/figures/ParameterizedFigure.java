package com.safi.asterisk.figures;

import org.eclipse.draw2d.AncestorListener;
import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FigureListener;
import org.eclipse.draw2d.FlowLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.swt.graphics.Color;

/**
 * @generated NOT
 */
public class ParameterizedFigure extends DefaultToolstepFigure {

  private static final Color OUTPUT_BG = new Color(null, 233,242,166);

  public enum SpacerSize {EMPTY, SMALL, NORMAL};
  /**
   * @generated
   */
  private Figure inputItemPanel;
  private Figure outputItemPanel;
  private static final Dimension SPACER_SIZE = new Dimension(5,38);
  private static final Dimension SMALL_SPACER_SIZE = new Dimension(5,19);
  private static final Dimension EMPTY_SPACER_SIZE = new Dimension(5,0);
  private Figure spacer;

  /**
   * @generated
   */
  public ParameterizedFigure() {
    super();
    setBorder(new MarginBorder(2));
  }

 
  protected void buildLayout() {
    
    BorderLayout layoutLabelPanel = new BorderLayout();
    layoutLabelPanel.setObserveVisibility(true);
    
//    LayoutManager layoutThis = new FreeformLayout();
    
//    FlowLayout flowLayout = new FlowLayout();
//    flowLayout.setStretchMinorAxis(false);
//    flowLayout.setMinorAlignment(FlowLayout.ALIGN_LEFTTOP);
//    flowLayout.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
//    flowLayout.setMajorSpacing(5);
//    flowLayout.setMinorSpacing(5);
//    flowLayout.setHorizontal(false);
//    labelPanel = new Panel();
//    labelPanel.setOpaque(false);
//    labelPanel.setLayoutManager(flowLayout);
    
    
    getRootPane().setLayoutManager(layoutLabelPanel);
//    setBorder(new MarginBorder(5));
    
    inputItemPanel = new Figure();
    inputItemPanel.setMinimumSize(new Dimension(20,10));
    inputItemPanel.setBorder(null);
    inputItemPanel.setOpaque(false);
    inputItemPanel.setBackgroundColor(null);
    inputItemPanel.setToolTip(null);
    StackLayout stackLayout = new StackLayout();
    stackLayout.setObserveVisibility(true);
    inputItemPanel.setLayoutManager(stackLayout);
   
    outputItemPanel = new Figure();
    outputItemPanel.setMinimumSize(new Dimension(20,10));
    outputItemPanel.setBorder(null);
    outputItemPanel.setOpaque(false);
    outputItemPanel.setBackgroundColor(OUTPUT_BG);
    outputItemPanel.setToolTip(null);
    stackLayout = new StackLayout();
    stackLayout.setObserveVisibility(true);
    outputItemPanel.setLayoutManager(stackLayout);
  }
  /**
   * @generated
   */
  protected void createContents() {
    createToolstepNameLabel();
    toolstepNameLabel.setTextWrap(false);
//    labelPanel.add(fFigureChoiceNameFigure);
//    labelPanel.setBackgroundColor(null);
//    this.add(labelPanel, BorderLayout.TOP);
    Figure f = new Figure();
    FlowLayout fl = new FlowLayout(false);
    fl.setMajorAlignment(FlowLayout.ALIGN_LEFTTOP);
    fl.setStretchMinorAxis(true);
    f.setLayoutManager(fl);
    f.add(toolstepNameLabel);
    getRootPane().add(f, BorderLayout.TOP);
    getRootPane().add(inputItemPanel, BorderLayout.CENTER);
    getRootPane().add(outputItemPanel, BorderLayout.RIGHT);
    spacer = new Figure();
    spacer.setOpaque(false);
    spacer.setBackgroundColor(null);
    //spacer.setVisible(false);
    
    setSpacerSize(SpacerSize.NORMAL);
    //labelPanel.add(spacer);
    getRootPane().add(spacer, BorderLayout.BOTTOM);
    
  }

  public void setSpacerSize(SpacerSize size){
    Dimension sz;
    switch (size){
      case EMPTY:
        sz = EMPTY_SPACER_SIZE;
        break;
      case SMALL:
        sz = SMALL_SPACER_SIZE;
        break;
      default:
        sz = SPACER_SIZE;
        break;
    }
    spacer.setMinimumSize(sz);
    spacer.setPreferredSize(sz);
  }
  
  /**
   * @generated
   */
  public WrapLabel getFigureChoiceNameFigure() {
    return getToolstepNameLabel();
  }


  public IFigure getInputItemPanel() {
    return inputItemPanel;
  }
  
  public IFigure getOutputItemPanel() {
    return outputItemPanel;
  }

}
