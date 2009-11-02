package com.safi.server;

import static org.asteriskjava.manager.ManagerConnectionState.DISCONNECTED;
import static org.asteriskjava.manager.ManagerConnectionState.RECONNECTING;

import java.io.IOException;

import org.asteriskjava.manager.AuthenticationFailedException;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.internal.ManagerConnectionImpl;

public class SafiManagerConnectionImpl extends ManagerConnectionImpl {

  public SafiManagerConnectionImpl() {
    // TODO Auto-generated constructor stub
  }

  protected void reconnect() {
    int numTries;

    // try to reconnect
    numTries = 0;
    while (state == RECONNECTING) {
      try {
        if (numTries < 10) {
          // try to reconnect quite fast for the firt 10 times
          // this succeeds if the server has just been restarted
          Thread.sleep(RECONNECTION_INTERVAL_1);
        } else if (numTries < 50) {
          // slow down after 10 unsuccessful attempts asuming a
          // shutdown of the server
          Thread.sleep(RECONNECTION_INTERVAL_2);
        } else {
          break;
        }
      } catch (InterruptedException e1) {
        // ignore
      }

      try {
        connect();

        try {
          doLogin(defaultResponseTimeout, eventMask);
          logger.info("Successfully reconnected.");
          // everything is ok again, so we leave
          // when successful doLogin set the state to CONNECTED so no
          // need to adjust it
          break;
        } catch (AuthenticationFailedException e1) {
          if (keepAliveAfterAuthenticationFailure) {
            logger.error("Unable to log in after reconnect: " + e1.getMessage());
          } else {
            logger.error("Unable to log in after reconnect: " + e1.getMessage() + ". Giving up.");
            state = DISCONNECTED;
          }
        } catch (TimeoutException e1) {
          // shouldn't happen - but happens!
          logger.error("TimeoutException while trying to log in " + "after reconnect.");
        }
      } catch (IOException e) {
        // server seems to be still down, just continue to attempt
        // reconnection
        logger.warn("Exception while trying to reconnect: " + e.getMessage());
      }
      numTries++;
    }
  }
  
  public boolean isConnected(){
  	return this.socket == null ? false : this.socket.isConnected();
  }
}
