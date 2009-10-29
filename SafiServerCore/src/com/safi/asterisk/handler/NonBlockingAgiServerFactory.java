package com.safi.asterisk.handler;

import com.safi.server.SafiFastAgiServer;

public class NonBlockingAgiServerFactory implements SafiFastAgiServerFactory {

  @Override
  public SafiFastAgiServer createAgiServer() {
    // TODO Auto-generated method stub
    return new com.safi.server.launcher.SafiMinaServer();
  }
  
}
