package com.safi.asterisk.handler;

import com.safi.server.SafiAgiServer;
import com.safi.server.SafiFastAgiServer;

public class BlockingAgiServerFactory implements SafiFastAgiServerFactory {

  @Override
  public SafiFastAgiServer createAgiServer() {
    // TODO Auto-generated method stub
    return new SafiAgiServer();
  }

  
}
