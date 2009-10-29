package com.safi.asterisk.handler.dispatch;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.safi.asterisk.handler.FileBackedHandlerInfo;
import com.safi.asterisk.handler.HandlerInfo;
import com.safi.asterisk.handler.SafletEngine;
import com.safi.asterisk.handler.SafletEngineException;
import com.safi.asterisk.handler.connection.ExceptionHandler;
import com.safi.core.saflet.Saflet;

public class FileBackedSafletDispatch extends AbstractSafletDispatch {
  private final static Logger log = Logger.getLogger(FileBackedSafletDispatch.class);

  private String rootDirectory;

  public FileBackedSafletDispatch() {

  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.asterisk.handler.SafletDispatch#registerHandler(java.lang.String,
   *      java.lang.String)
   */
  public void registerHandler(String path, String file) throws SafletEngineException {
    registerHandler(path, loadHandler(file));
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.asterisk.handler.SafletDispatch#registerHandler(java.lang.String,
   *      com.safi.asterisk.handler.Saflet)
   */
  public void registerHandler(String path, Saflet handler) throws SafletEngineException {
    try {

      if (log.isDebugEnabled())
        log.debug("registering handler " + handler.getName());

      File file = new File(path);
      String canonicalPath = file.getCanonicalPath();
      if (handlerRegistry.containsKey(canonicalPath)) {
        if (log.isDebugEnabled())
          log.debug("This handler is already there: " + canonicalPath);
      }
      handlerRegistry.put(canonicalPath, new FileBackedHandlerInfo(handler, file));
    } catch (Exception e) {
      throw new SafletEngineException(e);
    }
  }


  /*
   * (non-Javadoc)
   * 
   * @see com.safi.asterisk.handler.SafletDispatch#registerDebugHandler(java.lang.String,
   *      com.safi.asterisk.handler.Saflet, java.lang.Object,
   *      org.eclipse.emf.transaction.TransactionalEditingDomain)
   */
  public HandlerInfo registerDebugHandler(String path, Saflet handler, Object lock,
      TransactionalEditingDomain editingDomain) throws SafletEngineException {
    try {

      if (log.isDebugEnabled())
        log.debug("registering debug handler " + handler.getName());

      if (debugRegistry.containsKey(path)) {
        throw new SafletEngineException("Saflet " + handler.getName()
            + " is already being debugged", SafletEngineException.SafletExceptionCode.NOT_SPECIFIED);
      }
      FileBackedHandlerInfo handlerInfo = new FileBackedHandlerInfo(handler, null);
      handlerInfo.lock = lock;
      handlerInfo.editingDomain = editingDomain;

      if (SafletEngine.debuggerLog.isDebugEnabled())
        SafletEngine.debuggerLog.debug("registering debug application " + handler.getName());

      debugRegistry.put(path, handlerInfo);
      return handlerInfo;
    } catch (Exception e) {
      throw new SafletEngineException(e);
    }
  }

  @Override
  public FileBackedHandlerInfo getHandlerInfo(String pathArg, ExceptionHandler exceptionHandler) {

    FileBackedHandlerInfo handlerInfo = null;
    boolean didReloadCheck = false;


    if (pathArg.startsWith("/")|| pathArg.startsWith("\\"))
      pathArg = pathArg.substring(1);
    if (pathArg.toLowerCase().endsWith(".saflet"))
      pathArg = pathArg.substring(0, pathArg.length() - 7);
    // Check for specific handler path
    //    

    HandlerInfo info = debugRegistry.remove(pathArg);
    if (info == null) {
      if (rootDirectory != null)
        pathArg = rootDirectory
            + ((rootDirectory.endsWith("/") || rootDirectory.endsWith("\\")) ? "" : File.separator)
            + pathArg;
      if (!pathArg.toLowerCase().endsWith(".saflet"))
        pathArg += ".saflet";
      File f = new File(pathArg);
      String canonicalPath = null;
      try {
        canonicalPath = f.getCanonicalPath();
      } catch (Exception e) {
        log.error("Couldn't obtain canonical path from " + pathArg, e);
        if (exceptionHandler != null)
          exceptionHandler.handleException("Couldn't obtain canonical path from " + pathArg, e);
        return null;
      }
      info = handlerRegistry.get(canonicalPath);
      if (info == null) { // try to load it
        // try to load the handler from disk
        synchronized (handlerRegistry) {
          try {
            registerHandler(canonicalPath, loadHandler(canonicalPath));
            info = handlerRegistry.get(canonicalPath);
            didReloadCheck = true;
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.error("Couldn't register handler at " + pathArg, e);
            if (exceptionHandler != null)
              exceptionHandler.handleException("Couldn't register handler at " + pathArg, e);
          }
        }
      }
    }
    

    if (info != null) {
      Saflet handler = info.getHandler();
      handlerInfo = (FileBackedHandlerInfo) info;
      if (handler == null) {
        try {
          reloadIfNecessary(info);
          didReloadCheck = true;

        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          log.error("Error caught while loading Saflet " + info, e);
          if (exceptionHandler != null)
            exceptionHandler.handleException("Error caught while loading Saflet " + info, e);
          handlerInfo = null;
        }
      }
    }

    if (handlerInfo != null) {
      if (handlerInfo.isDebug()) {
        SafletEngine.getInstance().hookHandler(handlerInfo.getHandler());
        return handlerInfo;
      }
      Saflet copy = null;
      try {
        synchronized (handlerInfo) {
          if (!didReloadCheck)
            reloadIfNecessary(handlerInfo);
          copy = (Saflet) EcoreUtil.copy(handlerInfo.getHandler());
          SafletEngine.getInstance().hookHandler(copy);
          handlerInfo = new FileBackedHandlerInfo(handlerInfo, copy);
          // handlerInfo.setHandler(copy);
        }
      } catch (Exception exe) {
        exe.printStackTrace();
        log.error("Error caught while handling request ", exe);
        if (exceptionHandler != null)
          exceptionHandler.handleException("Error caught while handling request " + info, exe);
      }
    }
    return handlerInfo;
  }

  protected void reloadIfNecessary(HandlerInfo handlerInfo) throws Exception {
    FileBackedHandlerInfo info = (FileBackedHandlerInfo) handlerInfo;

    synchronized (info) {
      if (info.isDebug())
        return;
      long last = info.file.lastModified();
      boolean stale = info.file.lastModified() > info.timestamp;
      if (info.getHandler() == null || stale) {
        final ResourceSet resourceLoader2 = getResourceLoader();
        Resource resource = resourceLoader2.getResource(URI.createFileURI(info.file
            .getAbsolutePath()), false);
        if (resource.isLoaded() && stale) {
          resourceLoader2.getResources().remove(resource);
        }
        info.setHandler(loadHandler(info.file.getAbsolutePath()));
        info.timestamp = last;
      }
    }
  }

  public synchronized Saflet loadHandler(String file) throws SafletEngineException {
    final URI createFileURI = URI.createFileURI(file);
    final ResourceSet resourceLoader2 = getResourceLoader();
    Resource resource = resourceLoader2.getResource(createFileURI, false);
    if (resource == null)
      resource = resourceLoader2.getResource(createFileURI, true);
    else if (!resource.isLoaded()) {
      try {
        resource.load(resourceLoader2.getLoadOptions());
      } catch (IOException e) {
        throw new SafletEngineException("Coudln't load resource " + file, e, SafletEngineException.SafletExceptionCode.LOAD_SAFLET_ERROR);
      }
    }
    List<EObject> list = resource.getContents();
    if (list != null && !list.isEmpty()) {
      Saflet handler = (Saflet) list.get(0);
      return handler;
    } else
      throw new SafletEngineException("Couldn't load Saflet from file " + file, SafletEngineException.SafletExceptionCode.LOAD_SAFLET_ERROR);
  }

  public String getRootDirectory() {
    return rootDirectory;
  }

  public void setRootDirectory(String rootDirectory) {
    this.rootDirectory = rootDirectory;
  }

}
