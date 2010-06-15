package com.safi.server.manager;

import com.safi.server.saflet.mbean.ENotificationWrapper;


public interface DebugEventListener {

  public abstract void debugEvent(ENotificationWrapper event);
}
