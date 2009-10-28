package com.safi.workshop.navigator;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

/**
 * @since 3.2
 * 
 */
public class SafiEditActionProvider extends CommonActionProvider {

  private SafiEditActionGroup editGroup;

  private ICommonActionExtensionSite site;

  /*
   * (non-Javadoc)
   * 
   * @seeorg.eclipse.ui.navigator.CommonActionProvider#init(org.eclipse.ui.navigator.
   * ICommonActionExtensionSite)
   */
  @Override
  public void init(ICommonActionExtensionSite anActionSite) {
    site = anActionSite;
    editGroup = new SafiEditActionGroup(site.getViewSite().getShell());

  }

  @Override
  public void dispose() {
    editGroup.dispose();
  }

  @Override
  public void fillActionBars(IActionBars actionBars) {
    editGroup.fillActionBars(actionBars);
  }

  @Override
  public void fillContextMenu(IMenuManager menu) {
    editGroup.fillContextMenu(menu);
  }

  @Override
  public void setContext(ActionContext context) {
    editGroup.setContext(context);
  }

  @Override
  public void updateActionBars() {
    editGroup.updateActionBars();
  }
}
