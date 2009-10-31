package com.safi.asterisk.handler.connection;

import java.net.InetAddress;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.asteriskjava.fastagi.AgiChannel;
import org.asteriskjava.fastagi.AgiHangupException;
import org.asteriskjava.fastagi.AgiRequest;
import org.asteriskjava.manager.SafiManagerConnection;

import com.safi.asterisk.handler.DBBackedHandlerInfo;
import com.safi.asterisk.handler.SafletEngine;
import com.safi.core.initiator.Initiator;
import com.safi.core.saflet.Saflet;
import com.safi.db.server.config.AsteriskServer;

public class DBBackedConnectionManager extends AbstractConnectionManager {

  public DBBackedConnectionManager() {
  }

  @Override
  public void handle(String saflet, String astIp, Properties properties,
      ExceptionHandler exceptionHandler) {
    super.handle(saflet, astIp, properties, exceptionHandler);
    spawnHandler(null, null, saflet, astIp, properties, exceptionHandler);

  }

  @Override
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
      String hostAddress, final Properties props, ExceptionHandler exceptionHandler) {
    AsteriskServer server = getAsteriskServerByIP(hostAddress);
    if ((request != null && channel != null) && server == null) {
      log.error("Couldn't find Asterisk server for IP " + hostAddress);
      if (exceptionHandler != null)
        exceptionHandler.handleException("Couldn't find Asterisk server for IP " + hostAddress,
            null);
      return;
    }
    
    
    DBBackedHandlerInfo handlerInfo = (DBBackedHandlerInfo) dispatcher.getHandlerInfo(pathArg,
        exceptionHandler);

    if (handlerInfo != null) {
      final Saflet handler = handlerInfo.getHandler();
      try {
        if (request != null && channel != null) {
          applyParameters(request, handler);
        } else {
          applyParametersCustom(props, handler);
        }
        Initiator initiator = handler.getInitiator();
        handler.getSafletContext().setDebugLock(handlerInfo.lock);
        AstInitInfo info = new AstInitInfo();
        info.setRequest(request);
        info.setChannel(channel);
        info.setAsteriskServer(server);
        if (server != null) {
          final SafiManagerConnection managerConnection = SafletEngine.getInstance().getConnectionManager()
              .getManagerConnection(server.getId());
          if (managerConnection == null){
            log.error("Error caught while handling request: no manager connection could be found for Asterisk server "+server.getName());
            if (exceptionHandler != null)
              exceptionHandler.handleException("Error caught while handling request: no manager connection could be found for Asterisk server "+server.getName(), null);
            return;
          }
          info.setManagerConnection(managerConnection);
        }
        initiator.initialize(info);
        initiator.beginProcessing();
      } catch (Exception e) {
        // exe.printStackTrace();
        if ((e instanceof AgiHangupException) || (e.getCause() instanceof AgiHangupException))
          log.info("Call hungup: " + e.getLocalizedMessage());
        else {
          log.error("Error caught while handling request ", e);
          if (exceptionHandler != null)
            exceptionHandler.handleException("Error caught while handling request", e);
        }
      }
      if (handler != null) {
        List<Exception> ex = handler.getSafletContext().getExceptions();
        if (ex != null) {
          for (Exception e : ex) {
            if ((e instanceof AgiHangupException) || (e.getCause() instanceof AgiHangupException))
              log.info(e.getLocalizedMessage());
            else {
              log.error(null, e);
              if (exceptionHandler != null)
                exceptionHandler.handleException("Error caught while handling request", e);
            }
          }

        }
      }
    }
  }

}
