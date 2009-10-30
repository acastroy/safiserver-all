package com.safi.asterisk.handler.dispatch;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.safi.asterisk.handler.HandlerInfo;
import com.safi.asterisk.handler.SafletEngineException;
import com.safi.asterisk.handler.connection.ExceptionHandler;
import com.safi.core.saflet.Saflet;

public interface SafletDispatch {

  public abstract void registerHandler(String path, String file) throws SafletEngineException;

  public abstract void registerHandler(String path, Saflet handler) throws SafletEngineException;

  public abstract boolean unregisterHandler(String path);
  public abstract void unregisterDebugHandler(Saflet handler);

  public abstract HandlerInfo registerDebugHandler(String path, Saflet handler, Object lock,
      TransactionalEditingDomain editingDomain) throws SafletEngineException;

  public abstract HandlerInfo getHandlerInfo(String pathArg, ExceptionHandler exceptionHandler);
  public abstract Saflet getRunnableHandler(String pathArg, ExceptionHandler exceptionHandler);
  
//  public abstract void loadJar(File file) throws Exception;
//  
//  public void loadJars(File[] file) throws Exception;

  public abstract boolean clearLicenseCache(Integer integer);

  public Saflet loadHandler(byte[] xml) throws SafletEngineException;
}