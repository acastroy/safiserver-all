package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import com.safi.workshop.sqlexplorer.connections.actions.AbstractConnectionTreeAction;

public class ServerResourcesActionProvider extends CommonActionProvider {

  private ICommonActionExtensionSite site;

  public ServerResourcesActionProvider() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void init(ICommonActionExtensionSite anActionSite) {
    site = anActionSite;
    // editGroup = new SafiEditActionGroup(site.getViewSite().getShell());
  }

  @Override
  public void fillActionBars(IActionBars actionBars) {
    // TODO Auto-generated method stub
    super.fillActionBars(actionBars);
  }

  @Override
  public void fillContextMenu(IMenuManager menu) {
  }

  private boolean addAction(IMenuManager menu, AbstractConnectionTreeAction action) {
    if (action.isAvailable()) {
      menu.add(action);
      action.setEnabled(true);
      return true;
    }
    return false;
  }
}
