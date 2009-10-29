package com.safi.asterisk.handler.mbean;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMISocketFactory;

/*
 * User: Tim Goffings
 * Date: Oct 3, 2002 - 3:51:34 PM
 */

public class FixedPortRMISocketFactory extends RMISocketFactory {

  int serverPort = 7020;

  public FixedPortRMISocketFactory(int serverPort) {
    super();
    this.serverPort = serverPort;
  }

  public FixedPortRMISocketFactory() {
    super();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof FixedPortRMISocketFactory))
      return false;
    return ((FixedPortRMISocketFactory)obj).getServerPort() == serverPort;
  }
  /**
   * Creates a client socket connected to the specified host and port and writes out
   * debugging info
   * 
   * @param host
   *          the host name
   * @param port
   *          the port number
   * @return a socket connected to the specified host and port.
   * @exception IOException
   *              if an I/O error occurs during socket creation
   * @since JDK1.1
   */
  public Socket createSocket(String host, int port) throws IOException {
    System.err.println("Client socket being created: " + host + ":" + port);
    return new Socket(host, port);
  }

  /**
   * Create a server socket on the specified port (port 0 indicates an anonymous port) and
   * writes out some debugging info
   * 
   * @param port
   *          the port number
   * @return the server socket on the specified port
   * @exception IOException
   *              if an I/O error occurs during server socket creation
   * @since JDK1.1
   */
  public ServerSocket createServerSocket(int port) throws IOException {
    int orig = port;
    port = (port == 0 ? serverPort : port);
    System.err.println("Server socket being created on port " + port + " instead of " + orig);
    return new ServerSocket(port);

  }

  public int getServerPort() {
    return serverPort;
  }

  public void setServerPort(int serverPort) {
    this.serverPort = serverPort;
  }

}
