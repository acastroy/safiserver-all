package com.safi.server.manager;

import com.safi.asterisk.handler.mbean.ENotificationWrapper;

public interface DebugEventListener {

  public abstract void debugEvent(ENotificationWrapper event);
}
