package com.safi.server.preferences;

import com.safi.server.saflet.mbean.SysInfo;

public interface SafiServerStatusListener {

  void resourcesChanged();

  void serverConnectionChange(boolean connected);
  
  void serverInfoUpdate(SysInfo info);
}
