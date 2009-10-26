package com.safi.asterisk.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

/**
 * @generated
 */
public class GetColValuesFigure extends DefaultToolstepFigure {

  /**
   * @generated
   */
  protected Figure valuesPanel;
  /**
   * @generated
   */
  public GetColValuesFigure() {
    super();
    setBorder(new MarginBorder(2));
  }

protected void buildLayout() {
    
    BorderLayout layoutLabelPanel = new BorderLayout();
    layoutLabelPanel.setObserveVisibility(true);
    
    getRootPane().setLayoutManager(layoutLabelPanel);
    
    valuesPanel = new Figure();
    valuesPanel.setMinimumSize(new Dimension(20,10));
    valuesPanel.setBorder(null);
    valuesPanel.setOpaque(false);
    valuesPanel.setBackgroundColor(null);
    valuesPanel.setToolTip(null);
    StackLayout stackLayout = new StackLayout();
    stackLayout.setObserveVisibility(true);
    valuesPanel.setLayoutManager(stackLayout);
    
  }
  /**
   * @generated
   */
  protected void createContents() {
    createToolstepNameLabel();
    toolstepNameLabel.setTextWrap(false);
    
    getRootPane().add(toolstepNameLabel, BorderLayout.TOP);
    getRootPane().add(valuesPanel, BorderLayout.RIGHT);
    Figure spacer = new Figure();
    spacer.setOpaque(false);
    spacer.setBackgroundColor(null);
    //spacer.setVisible(false);
    
    spacer.setMinimumSize(new Dimension(5,38));
    spacer.setPreferredSize(new Dimension(5,38));
    //labelPanel.add(spacer);
    getRootPane().add(spacer, BorderLayout.BOTTOM);

  }

  /**
   * @generated
   */
  public WrapLabel getFigureMultiStreamAudioNameFigure() {
    return getToolstepNameLabel();
  }


  public IFigure getValuesPanel() {
    return valuesPanel;
  }

}
