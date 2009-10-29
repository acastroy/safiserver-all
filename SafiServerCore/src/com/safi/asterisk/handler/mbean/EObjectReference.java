package com.safi.asterisk.handler.mbean;

import java.io.Serializable;

public interface EObjectReference extends Serializable {

  public abstract String getUID();
  
  public abstract boolean isGlobalVar();
}
