package com.safi.workshop.actionpak1;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class ActionPak1Plugin extends Plugin {

  
  private static ActionPak1Plugin instance;
  public ActionPak1Plugin() {
    instance = this;
  }

  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    
  }

  
  

}
