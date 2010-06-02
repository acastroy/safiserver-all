package com.safi.workshop;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.update.search.BackLevelFilter;
import org.eclipse.update.search.EnvironmentFilter;
import org.eclipse.update.search.UpdateSearchRequest;
import org.eclipse.update.search.UpdateSearchScope;
import org.eclipse.update.ui.UpdateJob;
import org.eclipse.update.ui.UpdateManagerUI;

public class UpdateAction extends Action implements IAction {

  // private IWorkbenchWindow window;
  //
  // public UpdateAction(IWorkbenchWindow window) {
  // this.window = window;
  // setId("com.safi.workshop.updates");
  // setText("&Update...");
  // setToolTipText("Search for updates to Safi Workshop");
  // setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("AsteriskSafletDesigner.diagram",
  // "icons/product/SafiApplication.gif"));
  // //window.getWorkbench().getHelpSystem().setHelp(this,"org.eclipsercp.hyperbola.updates");
  //   
  // }
  // public void run() {
  // BusyIndicator.showWhile(window.getShell().getDisplay(),
  // new Runnable() {
  // public void run() {
  // UpdateJob job = new UpdateJob("Searching for updates", false, false);
  // UpdateManagerUI.openInstaller(window.getShell(), job);
  //            
  // }
  // });
  // }
  //  
  //
  // }

  private IWorkbenchWindow window;

  public UpdateAction(IWorkbenchWindow window) {
    // do nothing
    this.window = window;
    setId("com.safi.workshop.updates");
    setText("&Update...");
    setToolTipText("Search for updates to SafiWorkshop");
    setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin("AsteriskSafletDesigner.diagram",
        "icons/product/SafiApplication.gif"));
  }

  @Override
  public void run() {
    // openInstaller(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
    openInstaller(this.window);
  }

  public void run(IAction action) {
    openInstaller(window);
  }

  private void openInstaller(final IWorkbenchWindow window) {
    try {
      BusyIndicator.showWhile(window.getShell().getDisplay(), new Runnable() {
        public void run() {
          UpdateJob job = new UpdateJob("Search for new updates", getSearchRequest());
          UpdateManagerUI.openInstaller(window.getShell(), job);
        }
      });
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  private UpdateSearchRequest getSearchRequest() {
    UpdateSearchRequest result = new UpdateSearchRequest(UpdateSearchRequest
        .createDefaultSiteSearchCategory(), new UpdateSearchScope());
    result.addFilter(new BackLevelFilter());
    result.addFilter(new EnvironmentFilter());
    UpdateSearchScope scope = new UpdateSearchScope();
    try {
      {
        String homeBase = "http://updates.safisystems.com/";
        URL url = new URL(homeBase);
        scope.addSearchSite("safiworkshop", url, null);
      }

      // {
      // String homeBase = "http://updates.safisystems.com/";
      // URL url = new
      // File("D:\\workspace\\SafiWorkshopUpdateSite\\SafiWorkshopUpdateSite.zip").toURI().toURL();
      // scope.addSearchSite("safiworkshop", url, null);
      //	      
      // }

    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    result.setScope(scope);
    return result;
  }

  public void selectionChanged(IAction action, ISelection selection) {
    // do nothing
  }

  public void dispose() {
    // do nothing
  }

  public void init(IWorkbenchWindow window) {
    this.window = window;
  }
}