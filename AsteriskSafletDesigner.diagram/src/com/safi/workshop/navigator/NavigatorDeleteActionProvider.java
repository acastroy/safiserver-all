package com.safi.workshop.navigator;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.swt.SWT;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonMenuConstants;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;
import com.safi.workshop.sqlexplorer.connections.actions.DeleteAction;

public class NavigatorDeleteActionProvider extends CommonActionProvider {

  // private NavigatorDeleteAction deleteAction;
  private DeleteAction deleteAction;

  private ICommonViewerWorkbenchSite viewSite;

  public NavigatorDeleteActionProvider() {
  }

  @Override
  public void init(ICommonActionExtensionSite aConfig) {
    super.init(aConfig);
    if (aConfig.getViewSite() instanceof ICommonViewerWorkbenchSite) {
      viewSite = (ICommonViewerWorkbenchSite) aConfig.getViewSite();
      deleteAction = new DeleteAction();
      deleteAction.setAccelerator(SWT.DEL);
      viewSite.getActionBars().setGlobalActionHandler(ActionFactory.DELETE.getId(), deleteAction);

    }
    // if (aConfig.getViewSite() instanceof ICommonViewerWorkbenchSite) {
    // viewSite = (ICommonViewerWorkbenchSite) aConfig.getViewSite();
    // deleteAction = new NavigatorDeleteAction(viewSite);
    // IWorkbenchAction daction = ActionFactory.DELETE.create(viewSite.getPage()
    // .getWorkbenchWindow());
    // deleteAction.setDeleteAction(daction);
    // deleteAction.setText("Delete Navigator Resources");
    //
    // }
  }

  @Override
  public void fillContextMenu(IMenuManager manager) {
    manager.appendToGroup(ICommonMenuConstants.GROUP_EDIT, deleteAction);
  }

  @Override
  public void fillActionBars(IActionBars aBar) {

  }

  @Override
  public void updateActionBars() {
    super.updateActionBars();
  }

}
