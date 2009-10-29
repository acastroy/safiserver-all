package com.safi.asterisk.handler.mbean;

public class EObjectReferenceImpl implements EObjectReference {

  /**
   * 
   */
  private static final long serialVersionUID = 5030204293745442087L;
  private String uid;
  private boolean globalVar;
  public EObjectReferenceImpl(String uid) {
    this.uid = uid;
  }

  public EObjectReferenceImpl(String uid, boolean globalVar) {
    this.uid = uid;
    this.globalVar = globalVar;
  }
  @Override
  public String getUID() {
    return uid;
  }

  public void setUID(String uid){
    this.uid = uid;
  }

  public boolean isGlobalVar() {
    return globalVar;
  }

  public void setGlobalVar(boolean globalVar) {
    this.globalVar = globalVar;
  }
}
