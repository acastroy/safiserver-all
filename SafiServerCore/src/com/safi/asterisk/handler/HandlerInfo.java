package com.safi.asterisk.handler;

import com.safi.core.saflet.Saflet;

public interface HandlerInfo {

  public abstract Saflet getHandler();

  public abstract void setHandler(Saflet h);

  public abstract boolean isDebug();
  

}