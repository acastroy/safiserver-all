package com.safi.workshop.navigator.db;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;

import com.safi.workshop.sqlexplorer.connections.actions.AbstractConnectionTreeAction;

public class DBActionProvider extends CommonActionProvider {

  public DBActionProvider() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void fillActionBars(IActionBars actionBars) {
    // TODO Auto-generated method stub
    super.fillActionBars(actionBars);
  }

  @Override
  public void init(ICommonActionExtensionSite site) {
    // TODO Auto-generated method stub
    super.init(site);
  }

  @Override
  public void fillContextMenu(IMenuManager menu) {
    System.out.println(menu);
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
