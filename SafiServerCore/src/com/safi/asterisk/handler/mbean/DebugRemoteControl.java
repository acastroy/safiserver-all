package com.safi.asterisk.handler.mbean;

import java.io.Serializable;

public interface DebugRemoteControl extends Serializable, java.rmi.Remote {

  public abstract void next() throws Exception;
  public abstract void resume() throws Exception;
  public abstract void stop() throws Exception;
  public abstract void setBreakPoint(String uid, boolean b) throws Exception;
}
