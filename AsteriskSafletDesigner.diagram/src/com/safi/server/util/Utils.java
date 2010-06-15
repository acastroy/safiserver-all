package com.safi.server.util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Pattern;

public class Utils {

  public final static String PATTERN_IP = "\\b(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\b";
  
  public static int findFreePort() throws IOException {
    ServerSocket server = new ServerSocket(0);
    try {
      int port = server.getLocalPort();
      return port;
    } finally {
      try {
        server.close();
      } catch (IOException e) {
      }
    }

  }
  
//  public static boolean isPortInUse(int port){
//    try {
//      new ServerSocket(port);
//    } catch (IOException e) {
//      return true;
//    } 
//    return false;
//    
//  }

  public static boolean isServerPortAvail(int port) {
    ServerSocket server = null;
    try {
      server = new ServerSocket(port);
      return true;
    } catch (Exception e) {
      return false;
    } finally {
      try {
        server.close();
      } catch (Exception e) {
      }
    }

  }

  private static List<String> iplist;

  public static List<String> getLocalIPAddresses() {
    // List<String> iplist = new ArrayList<String>();
    if (iplist == null) {
      iplist = new ArrayList<String>();
      NetworkInterface iface = null;
      try {
        for (Enumeration<NetworkInterface> ifaces = NetworkInterface.getNetworkInterfaces(); ifaces
            .hasMoreElements();) {
          iface = ifaces.nextElement();
          System.out.println("Interface:" + iface.getDisplayName());
          InetAddress ia = null;
          for (Enumeration<InetAddress> ips = iface.getInetAddresses(); ips.hasMoreElements();) {
            ia = ips.nextElement();
            if (Pattern.matches(PATTERN_IP, ia.getHostAddress())) {
              iplist.add(ia.getHostAddress());
            }
          }
        }
      } catch (SocketException e) {
        e.printStackTrace();
      }

    }

    return new ArrayList<String>(iplist);
  }

  public static boolean isLocalIP(String ipaddr) {
    return getLocalIPAddresses().contains(ipaddr);
  }
  
  public static String getLocalIPAddress(){
  	for (String ip : getLocalIPAddresses()){
  		if (!("127.0.0.1".equals(ip) || "0.0.0.0".equals(ip) || "localhost".equalsIgnoreCase(ip)))
  			return ip;
  	}
  	
  	return null;
  }
}
