package com.safi.asterisk.handler.connection;

import java.net.InetAddress;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiHangupException;
import org.asteriskjava.fastagi.AgiRequest;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;

import com.safi.asterisk.handler.FileBackedHandlerInfo;
import com.safi.asterisk.handler.SafletEngine;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.db.server.config.AsteriskServer;

//import com.safi.server.launcher.SafiMinaServer;

public class FileBackedConnectionManager extends AbstractConnectionManager {

  /*
   * (non-Javadoc)
   * 
   * @see com.safi.asterisk.handler.AsteriskConnectionManager#beginProcessing()
   */

  @Override
  public void handle(String saflet, String astIp, Properties properties,
      ExceptionHandler exceptionHandler) {
    super.handle(saflet, astIp, properties, exceptionHandler);
    spawnHandler(null, null, saflet, astIp, properties, exceptionHandler);

  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * com.safi.asterisk.handler.AsteriskConnectionManager#handle(org.asteriskjava.fastagi
   * .AgiRequest, org.asteriskjava.fastagi.AgiChannel)
   */
  public void handle(final AgiRequest request, final AgiChannel channel) {
    super.handle(request, channel);
    if (log.isDebugEnabled())
      log.debug("Handling request " + request.getType() + " for chan " + channel.getClass());

    String loopback = request.getParameter("loopback");
    if (Boolean.valueOf(loopback)) {
      handleLoopback(request, channel);
      return;
    }
    String pathArg = request.getParameter("saflet");
    if (StringUtils.isBlank(pathArg))
      pathArg = request.getParameter("handler");
    if (StringUtils.isBlank(pathArg)) {
      log.warn("Request " + request + " did not specify a saflet. Ignoring...");
      return;
    }
    InetAddress address = request.getRemoteAddress();
    String hostAddress = address.getHostAddress();
    spawnHandler(request, channel, pathArg, hostAddress, null, null);
  }

  private void spawnHandler(final AgiRequest request, final AgiChannel channel, String pathArg,
      String hostAddress, final Properties props, final ExceptionHandler exceptionHandler) {
    final AsteriskServer server = getAsteriskServerByIP(hostAddress);
    if ((request != null && channel != null) && server == null) {
      log.error("Couldn't find Asterisk server for IP " + hostAddress);
      if (SafletEngine.debuggerLog.isDebugEnabled())
        SafletEngine.debuggerLog.error("Couldn't find Asterisk server for IP " + hostAddress);
      if (exceptionHandler != null)
        exceptionHandler.handleException("Couldn't find Asterisk server for IP " + hostAddress,
            null);
      return;
    }
    FileBackedHandlerInfo handlerInfo = (FileBackedHandlerInfo) dispatcher.getHandlerInfo(pathArg,
        exceptionHandler);

    if (handlerInfo != null) {
      try {
        if (handlerInfo.isDebug()) {
          if (SafletEngine.debuggerLog.isDebugEnabled())
            SafletEngine.debuggerLog.debug("Invoking application "
                + handlerInfo.getHandler().getName());

          final Saflet h = handlerInfo.getHandler();
          h.getSafletContext().setDebugLock(handlerInfo.lock);
          final Initiator initiator = h.getInitiator();
          final TransactionalEditingDomainImpl editingDomain = (TransactionalEditingDomainImpl) handlerInfo.editingDomain;

          AbstractCommand cmd = new AbstractCommand() {
            @Override
            public void execute() {

              try {

                if (request != null && channel != null) {
                  applyParameters(request, h);
                } else {
                  applyParametersCustom(props, h);
                }
                AstInitInfo info = new AstInitInfo();
                info.setRequest(request);
                info.setChannel(channel);
                if (server != null) {
                  info.setManagerConnection(SafletEngine.getInstance().getConnectionManager()
                      .getManagerConnection(server.getId()));
                }
                initiator.initialize(info);
              } catch (Exception exe) {
                exe.printStackTrace();
                log.error("Error caught while handling request ", exe);
                if (SafletEngine.debuggerLog.isDebugEnabled())
                  SafletEngine.debuggerLog.error("Error caught while handling request "
                      + exe.getLocalizedMessage());
                if (exceptionHandler != null)
                  exceptionHandler.handleException("Error caught while handling request", exe);
              }
            }

            @Override
            public void redo() {
            }

            @Override
            public boolean canExecute() {
              return true;
            }

          };

          editingDomain.getCommandStack().execute(cmd);
          initiator.beginProcessing();

        } else {
          Initiator initiator = handlerInfo.getHandler().getInitiator();
          if (request != null && channel != null) {
            applyParameters(request, handlerInfo.getHandler());
          } else {
            applyParametersCustom(props, handlerInfo.getHandler());
          }

          AstInitInfo info = new AstInitInfo();
          info.setRequest(request);
          info.setChannel(channel);
          initiator.initialize(info);
          initiator.beginProcessing();
        }

      } catch (Exception e) {
        // exe.printStackTrace();
        if ((e instanceof AgiHangupException) || (e.getCause() instanceof AgiHangupException)) {
          log.info("Call hungup: " + e.getLocalizedMessage());
          if (SafletEngine.debuggerLog.isDebugEnabled())
            SafletEngine.debuggerLog.info("Call hungup: " + e.getLocalizedMessage());
        } else {
          log.error("Error caught while handling request", e);
          SafletEngine.debuggerLog.error("Error caught while handling request", e);
          if (exceptionHandler != null)
            exceptionHandler.handleException("Error caught while handling request", e);
        }
      }
      if (handlerInfo.getHandler() != null) {
        List<Exception> ex = handlerInfo.getHandler().getSafletContext().getExceptions();
        if (ex != null) {
          for (Exception e : ex) {
            if ((e instanceof AgiHangupException) || (e.getCause() instanceof AgiHangupException)) {
              log.info(e.getLocalizedMessage());
              if (SafletEngine.debuggerLog.isInfoEnabled())
                SafletEngine.debuggerLog.info(e.getLocalizedMessage());
            } else {
              log.error(null, e);
              SafletEngine.debuggerLog.error(e.getLocalizedMessage(), e);
              if (exceptionHandler != null)
                exceptionHandler.handleException("Error caught while handling request", e);
            }
          }

        }
      }
    }
  }

}
