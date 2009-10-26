package com.safi.server;

public interface SafiServerListener {

  void serverStarted();
  
  void serverStopped(String reason);
}
