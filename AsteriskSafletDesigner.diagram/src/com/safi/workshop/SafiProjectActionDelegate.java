package com.safi.workshop;

import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.actions.ActionDelegate;

public class SafiProjectActionDelegate extends ActionDelegate implements IViewActionDelegate {

  public SafiProjectActionDelegate() {

  }
  NewSafiProjectAction nsp;

  @Override
  public void run(IAction action) {
    // NewSafiProjectAction nsp=new NewSafiProjectAction();
    nsp.run();
  }

  @Override
  public void init(IViewPart view) {
    // TODO Auto-generated method stub

    nsp = new NewSafiProjectAction(view.getViewSite().getWorkbenchWindow());
    // nsp.run();

  }

}
