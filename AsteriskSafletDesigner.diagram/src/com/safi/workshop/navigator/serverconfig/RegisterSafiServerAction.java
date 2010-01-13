package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewActionDelegate;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;
import com.safi.db.server.config.SafiServer;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class RegisterSafiServerAction implements IWorkbenchWindowActionDelegate,
    IViewActionDelegate {

  private SafiServer safiServer;
  private ImageDescriptor loginImage = AsteriskDiagramEditorPlugin
      .getBundledImageDescriptor("icons/server/action/LoginSafiServer.gif");
  private ImageDescriptor adminImage = AsteriskDiagramEditorPlugin
      .getBundledImageDescriptor("icons/server/action/SafiServerManager.gif");

  public RegisterSafiServerAction() {

    // super("ConnectionsView.Actions.AddSafiServer",
    // "ConnectionsView.Actions.AddSafiServerToolTip", "Images.AliasWizard");
  }

  public void run() {
    // SafiServer aSafiServer=SafiServerPlugin.getDefault().getSafiServer();
    /*
     * if(aSafiServer!=null){
     * 
     * }else { SafiServer prod=ConfigFactory.eINSTANCE.createSafiServer();
     * prod.setHostname("Not Configured"); aSafiServer=prod; }
     */

    Shell shell = new Shell();
    {
      SafiserverRegisterDialog safi = new SafiserverRegisterDialog(shell);
      safi.open();
      AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
    }

  }

  @Override
  public void selectionChanged(IAction action, ISelection selection) {
    System.out.println("action:" + action + " selection:" + selection);
    if (!(selection instanceof IStructuredSelection)) {
      return;
    }
    Object elem = ((IStructuredSelection) selection).getFirstElement();
    if (elem instanceof SafiServer) {
      this.safiServer = (SafiServer) elem;
      {
        try {
        		
          action.setImageDescriptor(loginImage);
          if (SafiServerPlugin.getDefault().isConnected()) {
            action.setText("Change SafiServer Login");
          } else {
            action.setText("Login SafiServer");
          }
        } catch (Exception ex) {
        }
      }
    }
    /*
     * if (selection instanceof IStructuredSelection){ Object elem =
     * ((IStructuredSelection)selection).getFirstElement(); if (elem instanceof
     * DriverManager || elem instanceof ManagedDriver || elem instanceof Alias || elem
     * instanceof User || elem instanceof Query || elem instanceof QueryParameter)
     * action.setEnabled(true); else action.setEnabled(false); }
     */
  }

  @Override
  public void dispose() {
    // TODO Auto-generated method stub

  }

  @Override
  public void init(IWorkbenchWindow window) {
    // TODO Auto-generated method stub
    System.out.println("test");

  }

  @Override
  public void run(IAction action) {
    // TODO Auto-generated method stub
    run();
  }

  @Override
  public void init(IViewPart view) {
    // TODO Auto-generated method stub
    System.out.println("test");

  }

  public SafiServer getSafiServer() {
    return safiServer;
  }

  public void setSafiServer(SafiServer safiServer) {
    this.safiServer = safiServer;
  }

}
