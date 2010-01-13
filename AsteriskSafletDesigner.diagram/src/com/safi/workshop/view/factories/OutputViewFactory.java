package com.safi.workshop.view.factories;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.AbstractShapeViewFactory;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.ShapeStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.NodeImpl;
import com.safi.core.actionstep.Output;
import com.safi.core.actionstep.OutputType;
import com.safi.workshop.edit.parts.OutputEditPart;
import com.safi.workshop.part.AsteriskVisualIDRegistry;

/**
 * @generated
 */
public class OutputViewFactory extends AbstractShapeViewFactory {

  /**
   * @generated
   */
  @Override
  protected List createStyles(View view) {
    List styles = new ArrayList();
    styles.add(NotationFactory.eINSTANCE.createShapeStyle());
    return styles;
  }

  /**
   * @generated NOT
   */
  @Override
  protected void decorateView(View containerView, View view, IAdaptable semanticAdapter,
      String semanticHint, int index, boolean persisted) {

    if (semanticHint == null) {
      semanticHint = AsteriskVisualIDRegistry.getType(OutputEditPart.VISUAL_ID);
      view.setType(semanticHint);
    }
    super.decorateView(containerView, view, semanticAdapter, semanticHint, index, persisted);
    NodeImpl n = (NodeImpl) view;
    ShapeStyle fillstyle = (ShapeStyle) n.getStyle(NotationPackage.Literals.FILL_STYLE);
    // fillstyle.setLineColor(FigureUtilities.colorToInteger(DiagramColorConstants.red));
    // EList<Style> styles = view.getStyles();

    Output output = (Output) view.getElement();
    if (output.getOutputType() == OutputType.DEFAULT) {
      fillstyle.setFillColor(FigureUtilities.colorToInteger(ColorConstants.green));
    } else if (output.getOutputType() == OutputType.ERROR) {
      fillstyle.setFillColor(FigureUtilities.colorToInteger(ColorConstants.red));
    } else if (output.getOutputType() == OutputType.CHOICE) {
      fillstyle.setFillColor(FigureUtilities.colorToInteger(ColorConstants.blue));
    }

  }
}
