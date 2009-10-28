package com.safi.server.actions;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.safi.db.server.config.SafiServer;

/**
 * Our sample action implements workbench action delegate. The action proxy will be
 * created by the workbench and shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be delegated to it.
 * 
 * @see IWorkbenchWindowActionDelegate
 */
public class StopServerAction2 extends StopServerAction {

  /**
   * The constructor.
   */
  public StopServerAction2() {
    super();
  }

  /**
   * Selection in the workbench has been changed. We can change the state of the 'real'
   * action here if we want, but this can only happen after the delegate has been created.
   * 
   * @see IWorkbenchWindowActionDelegate#selectionChanged
   */
  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    if (selection instanceof IStructuredSelection) {
      Object o = ((IStructuredSelection) selection).getFirstElement();
      boolean running = ServerUtilities.getInstance().isRunning();
      if (o == null || !(o instanceof SafiServer)) {
        action.setEnabled(running);
        action.setChecked(running);
        return;
      }

      SafiServer server = (SafiServer) o;
      /*
       * if (server == SafiServerPlugin.getDefault().getLocalServer()) { if (running) {
       * action.setEnabled(true); action.setChecked(true); } else {
       * action.setEnabled(false); action.setChecked(false); } return; } else
       */{
        action.setEnabled(false);
        action.setChecked(false);
      }
    }

  }

}