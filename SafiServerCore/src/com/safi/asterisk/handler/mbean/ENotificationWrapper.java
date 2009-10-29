package com.safi.asterisk.handler.mbean;

import java.io.Serializable;

public interface ENotificationWrapper extends Serializable {

  public abstract int getFeatureID();
  
  public abstract Object getNewValue();
  
  public abstract Object getOldValue();
  
  public abstract int getEventType();

  public abstract Object getNotifiderID();
}
