package com.safi.workshop.providers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.util.Trace;
import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.ContributionItemService;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIDebugOptions;
import org.eclipse.gmf.runtime.diagram.ui.internal.DiagramUIPlugin;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContextMenuProvider;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchPart;

public class AsteriskDiagramContextMenuProvider extends DiagramContextMenuProvider {

  private IWorkbenchPart part;

  public AsteriskDiagramContextMenuProvider(IWorkbenchPart part, EditPartViewer viewer) {
    super(part, viewer);
    this.part = part;
  }

  @Override
  protected boolean allowItem(IContributionItem itemToAdd) {
    // TODO Auto-generated method stub
    return super.allowItem(itemToAdd);
  }

  @Override
  public void buildContextMenu(IMenuManager menu) {
    getViewer().flush();

    try {
      TransactionUtil.getEditingDomain((EObject) getViewer().getContents().getModel())
          .runExclusive(new Runnable() {
            public void run() {
              ContributionItemService.getInstance().contributeToPopupMenu(
                  AsteriskDiagramContextMenuProvider.this, part);
            }
          });
    } catch (Exception e) {
      Trace.catching(DiagramUIPlugin.getInstance(), DiagramUIDebugOptions.EXCEPTIONS_CATCHING,
          getClass(), "buildContextMenu()", //$NON-NLS-1$
          e);
    }

  }

}
