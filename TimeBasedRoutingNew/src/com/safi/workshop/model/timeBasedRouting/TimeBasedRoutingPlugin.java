package com.safi.workshop.model.timeBasedRouting;

import org.eclipse.core.runtime.Plugin;

public class TimeBasedRoutingPlugin extends Plugin {

	private static TimeBasedRoutingPlugin instance;
	
	public TimeBasedRoutingPlugin() {
		instance = this;
	}

	public static TimeBasedRoutingPlugin getInstance() {
  	return instance;
  }

}
