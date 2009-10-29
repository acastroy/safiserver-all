package com.safi.asterisk.handler;

import java.io.File;
import java.lang.ref.WeakReference;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.safi.core.saflet.Saflet;

public class FileBackedHandlerInfo implements HandlerInfo {

  public TransactionalEditingDomain editingDomain;
  public long timestamp;
  public File file;
  public WeakReference<Saflet> handlerRef;
  public Object lock; // used for debugging

  public FileBackedHandlerInfo(FileBackedHandlerInfo info, Saflet handler){
    this.editingDomain = info.editingDomain;
    this.timestamp = info.timestamp;
    this.file = info.file;
    this.lock = info.lock;
    setHandler(handler);
  }
  
  public FileBackedHandlerInfo(Saflet handler, File file) {
    handlerRef = new WeakReference<Saflet>(handler);
    this.file = file;
    if (file != null)
      timestamp = file.lastModified();
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
    handlerRef = new WeakReference<Saflet>(h);
  }

  /* (non-Javadoc)
   * @see com.safi.asterisk.handler.HandlerInfo#isDebug()
   */
  public boolean isDebug() {
    return lock != null;
  }

}