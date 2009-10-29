package com.safi.asterisk.handler.connection;

import java.io.IOException;

public interface SSHDProvider {

  public void setSSHPort(int port);
  public void setSSHHost(String host);
  public void setAllowDeniedKEX(boolean b);
  
  public void start() throws IOException;
  public void stop() throws IOException;
  
}
