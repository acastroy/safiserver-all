package com.safi.asterisk.figures;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

/**
 * @generated
 */
public class SayDigitsFigure extends DefaultToolstepFigure {

  /**
   * @generated
   */
  private WrapLabel fFigureSayDigitsEscapeDigitsFigure;

  /**
   * @generated
   */
  public SayDigitsFigure() {}

  /**
   * @generated
   */
  protected void createContents() {
    createToolstepNameLabel();

    getRootPane().add(toolstepNameLabel);

    fFigureSayDigitsEscapeDigitsFigure = new WrapLabel();

    getRootPane().add(fFigureSayDigitsEscapeDigitsFigure);

  }

  /**
   * @generated
   */
  public WrapLabel getFigureSayDigitsNameFigure() {
    return getToolstepNameLabel();
  }

  /**
   * @generated
   */
  public WrapLabel getFigureSayDigitsEscapeDigitsFigure() {
    return fFigureSayDigitsEscapeDigitsFigure;
  }

}
