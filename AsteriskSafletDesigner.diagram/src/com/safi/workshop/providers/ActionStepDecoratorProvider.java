package com.safi.workshop.providers;

import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Image;
import com.safi.core.actionstep.ActionStep;
import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class ActionStepDecoratorProvider extends AbstractProvider implements IDecoratorProvider {

  public static final String BREAKPOINT_DECORATOR_ID = "breakpoints"; //$NON-NLS-1$

  public ActionStepDecoratorProvider() {
  }

  @Override
  public void createDecorators(IDecoratorTarget decoratorTarget) {

    decoratorTarget.installDecorator(BREAKPOINT_DECORATOR_ID, new BreakPointDecorator(
        decoratorTarget));
  }

  @Override
  public boolean provides(IOperation operation) {
    if (!(operation instanceof CreateDecoratorsOperation)) {
      return false;
    }

    IDecoratorTarget decoratorTarget = ((CreateDecoratorsOperation) operation).getDecoratorTarget();
    View view = (View) decoratorTarget.getAdapter(View.class);
    return view != null && (view instanceof Node) && (view.getElement() instanceof ActionStep)
        && decoratorTarget.getAdapter(CompartmentEditPart.class) == null;

  }

  protected class BreakPointDecorator extends AbstractDecorator {

    /**
     * @generated
     */
    public BreakPointDecorator(IDecoratorTarget decoratorTarget) {
      super(decoratorTarget);
    }

    /**
     * @generated
     */
    public void activate() {
      refresh();
    }

    /**
     * @generated
     */
    public void refresh() {
      removeDecoration();
      ToolstepEditPart editPart = (ToolstepEditPart) getDecoratorTarget().getAdapter(
          ToolstepEditPart.class);
      if (editPart != null && editPart.getActionStep() != null
          && editPart.getActionStep().isBreakpoint()) {
        Image image = AsteriskDiagramEditorPlugin.getDefault().getBundledImage(
            "icons/breakpoint.gif"); //$NON-NLS-1$
        setDecoration(getDecoratorTarget().addShapeDecoration(image,
            IDecoratorTarget.Direction.SOUTH_WEST, -2, true));
      }
    }
  }
}
