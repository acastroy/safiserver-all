package com.safi.asterisk.handler.mbean;

import org.eclipse.emf.common.notify.Notification;

public class ENotificationWrapperImpl implements ENotificationWrapper {

  /**
   * 
   */
  private static final long serialVersionUID = -171108369133866672L;
  protected int featureID = Notification.NO_FEATURE_ID;
  protected int eventType;
  protected Object newValue;
  protected Object oldValue;
  protected Object notifiderID;
  
  public int getFeatureID() {
    return featureID;
  }
  public void setFeatureID(int featureID) {
    this.featureID = featureID;
  }
  public int getEventType() {
    return eventType;
  }
  public void setEventType(int eventType) {
    this.eventType = eventType;
  }
  public Object getNewValue() {
    return newValue;
  }
  public void setNewValue(Object newValue) {
    this.newValue = newValue;
  }
  public Object getOldValue() {
    return oldValue;
  }
  public void setOldValue(Object oldValue) {
    this.oldValue = oldValue;
  }
  @Override
  public Object getNotifiderID() {
    return notifiderID;
  }
  public void setNotifiderID(Object notifiderID) {
    this.notifiderID = notifiderID;
  }
  

}
