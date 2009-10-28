package com.safi.server.actions;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

/**
 * Our sample action implements workbench action delegate. The action proxy will be
 * created by the workbench and shown in the UI. When the user tries to use the action,
 * this delegate will be created and execution will be delegated to it.
 * 
 * @see IWorkbenchWindowActionDelegate
 */
public class StopServerAction implements IWorkbenchWindowActionDelegate {
  protected IWorkbenchWindow window;
  protected IAction action;

  /**
   * The constructor.
   */
  public StopServerAction() {
    // callback = new ServerUtilities.ServerStartupCallback() {
    // @Override
    // public void serverFailedToStart(final String msg) {
    // if (action != null)
    // action.setEnabled(false);
    // Display.getDefault().asyncExec(new Runnable() {
    // @Override
    // public void run() {
    // MessageDialog.openInformation(window.getShell(), "Server Stopped",
    // "Server Stopped: " + msg);
    // }
    // });
    //
    // }
    //
    // @Override
    // public void serverStarted() {
    // if (action != null)
    // action.setEnabled(true);
    // }
    //
    // @Override
    // public void serverStopped() {
    // if (action != null)
    // action.setEnabled(false);
    // Display.getDefault().asyncExec(new Runnable() {
    // @Override
    // public void run() {
    // Shell shell = AsteriskDiagramEditorUtil.getActiveShell();
    // if (shell != null)
    // MessageDialog
    // .openInformation(shell, "Server Stopped", "Server Stopped");
    // }
    // });
    //
    // }
    //
    // public boolean removeOnServerStop() {
    // return false;
    // }
    // };
  }

  /**
   * The action has been activated. The argument of the method represents the 'real'
   * action sitting in the workbench UI.
   * 
   * @see IWorkbenchWindowActionDelegate#run
   */
  public void run(IAction action) {
    if (!ServerUtilities.getInstance().isRunning())
      return;
    this.action = action;
    IRunnableWithProgress job = new IRunnableWithProgress() {

      @Override
      public void run(IProgressMonitor monitor) {
        monitor.beginTask("Stopping Local(Debug) Server", IProgressMonitor.UNKNOWN);
        if (ServerUtilities.getInstance().isRunning()) {
          // ServerUtilities.getInstance().stopServer();
          synchronized (ServerUtilities.lock) {
            ServerUtilities.lock.notifyAll();
          }
        }

      }
    };
    Shell shell = new Shell(Display.getCurrent());
    ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell);
    try {
      dialog.run(true, false, job);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      MessageDialog.openError(window.getShell(), "Update Error",
          "Couldn't update SafiServer settings: " + e.getLocalizedMessage());
      return;
    }

  }

  /**
   * Selection in the workbench has been changed. We can change the state of the 'real'
   * action here if we want, but this can only happen after the delegate has been created.
   * 
   * @see IWorkbenchWindowActionDelegate#selectionChanged
   */
  public void selectionChanged(IAction action, ISelection selection) {
    // if (selection instanceof IStructuredSelection) {
    // Object o = ((IStructuredSelection) selection).getFirstElement();
    // boolean running = ServerUtilities.getInstance().isRunning();
    // if (o == null || !(o instanceof SafiServer)) {
    // action.setEnabled(running);
    // action.setChecked(running);
    // return;
    // }
    //
    // SafiServer server = (SafiServer) o;
    // if (server == SafiServerPlugin.getDefault().getLocalServer()) {
    // if (running) {
    // action.setEnabled(true);
    // action.setChecked(true);
    // } else {
    // action.setEnabled(false);
    // action.setChecked(false);
    // }
    // return;
    // } else {
    // action.setEnabled(false);
    // action.setChecked(false);
    // }
    // }

  }

  /**
   * We can use this method to dispose of any system resources we previously allocated.
   * 
   * @see IWorkbenchWindowActionDelegate#dispose
   */
  public void dispose() {
    // if (callback != null)
    // ServerUtilities.getInstance().removeServerStartupCallback(callback);
  }

  /**
   * We will cache window object in order to be able to provide parent shell for the
   * message dialog.
   * 
   * @see IWorkbenchWindowActionDelegate#init
   */
  public void init(IWorkbenchWindow window) {
    this.window = window;
  }
}