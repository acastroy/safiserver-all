package com.safi.workshop.actionpak1;

import java.util.logging.Logger;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class ActionPak1Plugin extends Plugin {

  private final static Logger log = Logger.getLogger(ActionPak1Plugin.class.getName());
  private static ActionPak1Plugin instance;
  
  public ActionPak1Plugin() {
    instance = this;
  }

  @Override
  public void start(BundleContext context) throws Exception {
  	log.info("ActionPak1Plugin bundle activated!");
    super.start(context);
    
  }

  
  

}
