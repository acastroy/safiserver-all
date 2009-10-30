package com.safi.asterisk.handler.dispatch;

import java.sql.SQLException;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import com.safi.asterisk.handler.DBBackedHandlerInfo;
import com.safi.asterisk.handler.HandlerInfo;
import com.safi.asterisk.handler.SafletEngine;
import com.safi.asterisk.handler.SafletEngineException;
import com.safi.asterisk.handler.connection.ExceptionHandler;
import com.safi.db.manager.DBManager;
import com.safi.db.server.config.Saflet;

public class DBBackedSafletDispatch extends AbstractSafletDispatch {

  private final static Logger log = Logger.getLogger(DBBackedSafletDispatch.class);

  public DBBackedSafletDispatch() {
    // TODO Auto-generated constructor stub
  }

  public static String normalizeDBPathArg(String pathArg) {
    String[] pa = pathArg.split("[\\\\\\/]");
    if (pa.length != 2) {
      log.error("Illegal Saflet path: " + pathArg);
      return null;
    }
    return pa[0] + "/" + pa[1];
  }

  
  @Override
  public com.safi.core.saflet.Saflet getRunnableHandler(String pathArg, ExceptionHandler handler) {
    DBBackedHandlerInfo info = (DBBackedHandlerInfo)getHandlerInfo(pathArg, handler);
    if (info != null) {
      com.safi.core.saflet.Saflet saflet = info.getHandler();
      if  (saflet != null)
        saflet.getSafletContext().setDebugLock(info.lock);
      return saflet;
    }
    return null;
  }
  
  @Override
  public HandlerInfo getHandlerInfo(String pathArg, 
      ExceptionHandler exceptionHandler) {

    DBBackedHandlerInfo handlerInfo = null;
    if (pathArg.endsWith(".saflet"))
      pathArg = pathArg.substring(0, pathArg.length() - 7);
    if (pathArg.startsWith("/"))
      pathArg = pathArg.substring(1);
    String[] pa = pathArg.split("[\\\\\\/]");

    if (pa.length != 2) {
      log.error("Illegal Saflet path: " + pathArg);
      if (exceptionHandler != null)
        exceptionHandler.handleException("Illegal Saflet path: " + pathArg, null);
      return null;
    }
    pathArg = pa[0] + "/" + pa[1];
    handlerInfo = (DBBackedHandlerInfo) debugRegistry.remove(pathArg);
    if (handlerInfo == null)
      handlerInfo = (DBBackedHandlerInfo) handlerRegistry.get(pathArg);
    com.safi.core.saflet.Saflet h = null;
    if (handlerInfo == null || handlerInfo.getHandler() == null) { // try to load it
      // try to load the handler from disk
      try {
        h = loadHandler(pa[0], pa[1]);
        if (h == null) {
          return null;
        }
       
        registerHandler(pathArg, h);
        handlerInfo = (DBBackedHandlerInfo) handlerRegistry.get(pathArg);
        if (handlerInfo == null) {
          log.error("Couldn't register Saflet with path " + pathArg);
          if (exceptionHandler != null)
            exceptionHandler.handleException("Couldn't register Saflet with path " + pathArg, null);
          return null;
        }
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        log.error("Couldn't register Saflet at " + pathArg, e);
        if (exceptionHandler != null)
          exceptionHandler.handleException("Couldn't register Saflet with path " + pathArg, null);
        return null;
      }
    }

    if (handlerInfo != null) {
      if (h == null)
        h = handlerInfo.getHandler();
      try {
        synchronized (handlerInfo) {
          if (!handlerInfo.isDebug())
            h = (com.safi.core.saflet.Saflet) EcoreUtil.copy(h);
          SafletEngine.getInstance().hookHandler(h);
          handlerInfo = new DBBackedHandlerInfo(handlerInfo, h);
        }
      } catch (Exception exe) {
        exe.printStackTrace();
        log.error("Error caught while handling request ", exe);
        if (exceptionHandler != null)
          exceptionHandler.handleException("Error caught while handling request ", exe);
      }
    }
    return handlerInfo;
  }

  private com.safi.core.saflet.Saflet loadHandler(String projectName, String safletName) {
    try {

      Saflet saflet = DBManager.getInstance().getSaflet(projectName, safletName);
      if (saflet == null) {
        log.error("Couldn't find Saflet " + projectName + "/" + safletName + " in the DB");
        return null;
      }

      return loadHandler(saflet.getCode());
    } catch (Exception e) {
      log.error("Couldn't load Saflet " + projectName + "/" + safletName, e);
    }
    return null;
  }

  
  @Override
  public void registerHandler(String path, com.safi.core.saflet.Saflet handler)
      throws SafletEngineException {
    try {
      if (log.isDebugEnabled())
        log.debug("registering handler " + handler.getName());
      synchronized (handlerRegistry) {
        if (handlerRegistry.containsKey(path)) {
          if (log.isDebugEnabled())
            log.debug("This handler is already there: " + path);
        }

        handlerRegistry.put(path, new DBBackedHandlerInfo(handler));
      }
    } catch (Exception e) {
      throw new SafletEngineException(e);
    }
  }

  @Override
  public HandlerInfo registerDebugHandler(String path, com.safi.core.saflet.Saflet handler, Object lock,
      TransactionalEditingDomain editingDomain) throws SafletEngineException {
    try {

      if (log.isDebugEnabled())
        log.debug("registering debug handler " + handler.getName());

      if (debugRegistry.containsKey(path)) {
        throw new SafletEngineException("Saflet " + handler.getName()
            + " is already being debugged", SafletEngineException.SafletExceptionCode.NOT_SPECIFIED);
      }
      DBBackedHandlerInfo handlerInfo = new DBBackedHandlerInfo(handler);
      handlerInfo.lock = lock;
      if (SafletEngine.debuggerLog.isDebugEnabled())
        SafletEngine.debuggerLog.debug("registering debug application " + handler.getName());

      debugRegistry.put(path, handlerInfo);
      return handlerInfo;
    } catch (Exception e) {
      throw new SafletEngineException(e);
    }
  }

}
