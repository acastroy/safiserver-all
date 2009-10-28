package com.safi.workshop.navigator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

public class NavigatorDeleteAction extends Action {
  IWorkbenchAction deleteAction;
  ICommonViewerWorkbenchSite viewSite;

  public void setDeleteAction(IWorkbenchAction daction) {
    // TODO Auto-generated method stub
    deleteAction = daction;

  }

  public NavigatorDeleteAction(ICommonViewerWorkbenchSite viewSite) {
    this.viewSite = viewSite;
  }

  @Override
  public void run() {
    StructuredSelection ss = (StructuredSelection) viewSite.getSelectionProvider().getSelection();
    for (Object o : ss.toArray()) {
    }

  }
}
