package com.safi.workshop.providers;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.printing.actions.PrintPreviewAction;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.EnhancedPrintActionHelper;
import org.eclipse.gmf.runtime.diagram.ui.printing.render.actions.RenderedPrintPreviewAction;
import org.eclipse.jface.action.IAction;

import com.safi.workshop.actions.MinimizeActionstepToggleAction;

/**
 * @generated
 */
public class AsteriskContributionItemProvider extends AbstractContributionItemProvider {

  /**
   * @generated
   */
  @Override
  protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
    if (actionId.equals(PrintPreviewAction.ID)) {
      return new RenderedPrintPreviewAction(new EnhancedPrintActionHelper());
    }
    if (actionId.equals(MinimizeActionstepToggleAction.ID)) {
      return MinimizeActionstepToggleAction.getAction();
    }
    return super.createAction(actionId, partDescriptor);
  }
}
