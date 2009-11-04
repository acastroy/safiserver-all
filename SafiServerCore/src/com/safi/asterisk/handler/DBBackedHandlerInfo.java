package com.safi.asterisk.handler;

import java.lang.ref.SoftReference;
import com.safi.core.saflet.Saflet;

public class DBBackedHandlerInfo implements HandlerInfo {

  public SoftReference<Saflet> handlerRef;
  public Object lock; // used for debugging
  public DBBackedHandlerInfo(DBBackedHandlerInfo info, Saflet handler){
    this.lock = info.lock;
    setHandler(handler);
  }
  
  public DBBackedHandlerInfo(Saflet handler) {
    setHandler(handler);
  }

  /* (non-Javadoc)
   * @see com.safi.asterisk.handler.HandlerInfo#getHandler()
   */
  public Saflet getHandler() {
    return handlerRef.get();
  }

  /* (non-Javadoc)
   * @see com.safi.asterisk.handler.HandlerInfo#setHandler(com.safi.asterisk.handler.Saflet)
   */
  public void setHandler(Saflet h) {
    handlerRef = new SoftReference<Saflet>(h);
  }

  /* (non-Javadoc)
   * @see com.safi.asterisk.handler.HandlerInfo#isDebug()
   */
  public boolean isDebug() {
    return lock != null;
  }

}