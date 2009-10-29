package com.safi.asterisk.handler;

import com.safi.server.SafiFastAgiServer;

public interface SafiFastAgiServerFactory {

  public abstract SafiFastAgiServer createAgiServer();
}
