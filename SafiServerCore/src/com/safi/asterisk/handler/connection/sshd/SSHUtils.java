package com.safi.asterisk.handler.connection.sshd;

import java.io.IOException;
import java.net.ServerSocket;

public class SSHUtils {

  public static int findFreePort() throws IOException {
    ServerSocket server = new ServerSocket(0);
    try {
      int port = server.getLocalPort();
      return port;
    } finally {
      server.close();
    }

  }

}
