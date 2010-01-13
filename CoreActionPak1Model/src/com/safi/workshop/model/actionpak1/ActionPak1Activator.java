package com.safi.workshop.model.actionpak1;

import java.util.logging.Logger;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ActionPak1Activator implements BundleActivator {

	private final static Logger log = Logger.getLogger(ActionPak1Activator.class.getName());
	protected static Actionpak1Package actionpak1Package = Actionpak1Package.eINSTANCE;
	public ActionPak1Activator() {
		// TODO Auto-generated constructor stub
	}
	@Override
  public void start(BundleContext context) throws Exception {
	  log.info("ActionPak1Activator bundle started!");
  }
	@Override
  public void stop(BundleContext context) throws Exception {
		log.info("ActionPak1Activator bundle stopped!");
	  
  }

}
