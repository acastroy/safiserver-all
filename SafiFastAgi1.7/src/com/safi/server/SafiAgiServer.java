/*
 *  Copyright 2004-2006 Stefan Reuter
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package com.safi.server;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

import org.asteriskjava.fastagi.AgiServer;
import org.asteriskjava.fastagi.DefaultAgiServer;
import org.asteriskjava.fastagi.internal.AgiConnectionHandler;
import org.asteriskjava.fastagi.internal.FastAgiConnectionHandler;
import org.asteriskjava.mbean.Manager;
import org.asteriskjava.util.Log;
import org.asteriskjava.util.LogFactory;
import org.asteriskjava.util.ServerSocketFacade;
import org.asteriskjava.util.SocketConnectionFacade;
import org.asteriskjava.util.internal.ServerSocketFacadeImpl;

/**
 * Default implementation of the {@link org.asteriskjava.fastagi.AgiServer}
 * interface.
 * 
 * @author srt
 * @version $Id: SafiAgiServer.java,v 1.10 2008/12/12 07:05:03 zacw Exp $
 */
public class SafiAgiServer extends DefaultAgiServer implements
		SafiFastAgiServer {

  public final static int DEFAULT_MAX_CONSECUTIVE_ERRORS = 10;
  public static final int IPv4 = 1;
  public static final int IPv6 = 2;

  /**
   * Instance logger.
   */
  protected final Log logger = LogFactory.getLog(SafiAgiServer.class);

  protected static final String DEFAULT_CONFIG_RESOURCE_BUNDLE_NAME = "fastagi";

  /**
   * The default bind port.
   */
  protected static final int DEFAULT_BIND_PORT = 4573;

  // private ServerSocketFacade serverSocket;
  protected String configResourceBundleName = DEFAULT_CONFIG_RESOURCE_BUNDLE_NAME;
  protected Set<SafiServerListener> listeners = new HashSet<SafiServerListener>();

  protected boolean running;

  /**
   * The ip address the server will bind to
   */
  protected String bindAddr;
  private int maxErrors = DEFAULT_MAX_CONSECUTIVE_ERRORS;
	private JMXServiceURL url;
	private JMXConnectorServer cs;

  /*
   * (non-Javadoc)
   * 
   * @see org.asteriskjava.fastagi.SafiFastAgiServer#addListener(org.asteriskjava.fastagi.SafiServerListener)
   */
  public boolean addListener(SafiServerListener listener) {
    return listeners.add(listener);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.asteriskjava.fastagi.SafiFastAgiServer#removeListener(org.asteriskjava.fastagi.SafiServerListener)
   */
  public boolean removeListener(SafiServerListener listener) {
    return listeners.remove(listener);
  }

  public String getBoundIpAddress() {
		if (!running || serverSocket == null)
			return null;
    return serverSocket.getIpAddr();
  }

  protected ServerSocketFacade createServerSocket() throws IOException {
    InetAddress addr = null;
    if (bindAddr != null) {
      addr = getByAddress(bindAddr);
    }
    ServerSocketFacade impl = new ServerSocketFacadeImpl(port, 0, addr);
    // notifyStarted();
    return impl;
  }

  protected void notifyStarted() {
    for (SafiServerListener l : listeners) {
      l.serverStarted();
    }
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.asteriskjava.fastagi.SafiFastAgiServer#run()
   */
  public void run() {
    try {
      running = true;
      startup();
      
    } catch (Exception e) // NOPMD
    {
			// nothing we can do about that and exceptions have already been
			// logged
      // by startup().
      notifyStopped(e.getLocalizedMessage());
    } finally {
      running = false;
    }
  }

  protected void notifyStopped(String reason) {
    for (SafiServerListener l : listeners) {
      l.serverStopped(reason);
    }

  }

  public static void main(String[] args) throws Exception {
    AgiServer server;

    server = new SafiAgiServer();
    server.startup();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.asteriskjava.fastagi.SafiFastAgiServer#isRunning()
   */
  public boolean isRunning() {
    return running;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.asteriskjava.fastagi.SafiFastAgiServer#getBindAddr()
   */
  public String getBindAddr() {
    return bindAddr;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.asteriskjava.fastagi.SafiFastAgiServer#setBindAddr(java.lang.String)
   */
  public void setBindAddr(String bindAddr) {
    this.bindAddr = bindAddr;
  }
  
  @Override
  public void startup() throws IOException, IllegalStateException {

//		try {
//			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
//
//			ObjectName name = new ObjectName(
//					"org.asteriskjava.mbean:type=Manager");
//           /*
//			Queue<String> queue = new ArrayBlockingQueue<String>(10);
//			queue.add("Request-1");
//			queue.add("Request-2");
//			queue.add("Request-3");
//			QueueSampler mxbean = new QueueSampler(queue);
//           */
//			Manager mxbean=new Manager();
//			mbs.registerMBean(mxbean, name);
//
//			System.out.println("Waiting...");
//			//Thread.sleep(Long.MAX_VALUE);
//			url = new JMXServiceURL(
//					"service:jmx:rmi:///jndi/rmi://localhost:9999/server");
//			cs = JMXConnectorServerFactory
//					.newJMXConnectorServer(url, null, mbs);
//			System.out.println("service:jmx:rmi:///jndi/rmi://localhost:9999/server");
//			cs.start();
//			
//		} catch (Exception ex) {
////		  logger.error("Unable start JMXService: "+ex.getLocalizedMessage(), ex);
//		  throw new IllegalStateException(ex);
//		}

    SocketConnectionFacade socket;
    AgiConnectionHandler connectionHandler;
		try {
        serverSocket = createServerSocket();
		} catch (IOException e) {
			logger.error("Unable start AgiServer: cannot to bind to *:" + port
					+ ".", e);
        throw e;
    }
        System.out.println("Listening on *:" + port + "."); 
    logger.info("Listening on *:" + port + ".");
    notifyStarted();
    int consecutiveErrors = 0;
    // loop will be terminated by accept() throwing an IOException when the
    // ServerSocket is closed.
		while (true) {
			try {
            socket = serverSocket.accept();
				logger.info("Received connection from "
						+ socket.getRemoteAddress());
				connectionHandler = new FastAgiConnectionHandler(
						getMappingStrategy(), socket);
            execute(connectionHandler);
            consecutiveErrors = 0; //reset errors
			} catch (IOException e) {
            // swallow only if shutdown
				if (isDie()) {
                break;
				} else {
					logger.error("IOException while waiting for connections.",
							e);
                // log error but continue
                consecutiveErrors++;
                if (consecutiveErrors > maxErrors){
						logger
								.error(
										"Too many errors. Error probably not recoverable",
										e);
                  break;
                }
            }
        } catch (RejectedExecutionException e){
          logger.error("Executor exception ", e);
          
        } catch (Exception e){
          logger.error("Execution exception ", e);
          
        }
    }
		notifyStopped("AgiServer shut down");
    logger.info("AgiServer shut down.");
}

  private static byte[] parseV4(String s) {
    int numDigits;
    int currentOctet;
    byte[] values = new byte[4];
    int currentValue;
    int length = s.length();

    currentOctet = 0;
    currentValue = 0;
    numDigits = 0;
    for (int i = 0; i < length; i++) {
      char c = s.charAt(i);
      if (c >= '0' && c <= '9') {
        /* Can't have more than 3 digits per octet. */
				if (numDigits == 3)
					return null;
        /* Octets shouldn't start with 0, unless they are 0. */
				if (numDigits > 0 && currentValue == 0)
					return null;
        numDigits++;
        currentValue *= 10;
        currentValue += (c - '0');
        /* 255 is the maximum value for an octet. */
				if (currentValue > 255)
					return null;
      } else if (c == '.') {
        /* Can't have more than 3 dots. */
				if (currentOctet == 3)
					return null;
        /* Two consecutive dots are bad. */
				if (numDigits == 0)
					return null;
        values[currentOctet++] = (byte) currentValue;
        currentValue = 0;
        numDigits = 0;
      } else
        return null;
    }
    /* Must have 4 octets. */
		if (currentOctet != 3)
			return null;
    /* The fourth octet can't be empty. */
		if (numDigits == 0)
			return null;
    values[currentOctet] = (byte) currentValue;
    return values;
  }

  private static byte[] parseV6(String s) {
    boolean parsev4 = false;
    List l = new ArrayList();
    int range = -1;
    byte[] data = new byte[16];

    String[] tokens = s.split(":", -1);

    int first = 0;
    int last = tokens.length - 1;

    if (tokens[0].length() == 0) {
      // If the first two tokens are empty, it means the string
      // started with ::, which is fine. If only the first is
      // empty, the string started with :, which is bad.
      if (last - first > 0 && tokens[1].length() == 0)
        first++;
      else
        return null;
    }

    if (tokens[last].length() == 0) {
      // If the last two tokens are empty, it means the string
      // ended with ::, which is fine. If only the last is
      // empty, the string ended with :, which is bad.
      if (last - first > 0 && tokens[last - 1].length() == 0)
        last--;
      else
        return null;
    }

		if (last - first + 1 > 8)
			return null;

    int i, j;
    for (i = first, j = 0; i <= last; i++) {
      if (tokens[i].length() == 0) {
				if (range >= 0)
					return null;
        range = j;
        continue;
      }

      if (tokens[i].indexOf('.') >= 0) {
        parsev4 = true;
        // An IPv4 address must be the last component
				if (i < last)
					return null;
        // There can't have been more than 6 components.
				if (i > 6)
					return null;
        byte[] v4addr = toByteArray(tokens[i], IPv4);
				if (v4addr == null)
					return null;
        for (int k = 0; k < 4; k++)
          data[j++] = v4addr[k];
        break;
      }

      try {
        for (int k = 0; k < tokens[i].length(); k++) {
          char c = tokens[i].charAt(k);
					if (Character.digit(c, 16) < 0)
						return null;
        }
        int x = Integer.parseInt(tokens[i], 16);
				if (x > 0xFFFF || x < 0)
					return null;
        data[j++] = (byte) (x >>> 8);
        data[j++] = (byte) (x & 0xFF);
      } catch (NumberFormatException e) {
        return null;
      }
    }

		if (j < 16 && range < 0)
			return null;

    if (range >= 0) {
      int empty = 16 - j;
      System.arraycopy(data, range, data, range + empty, j - range);
      for (i = range; i < range + empty; i++)
        data[i] = 0;
    }

    return data;
  }

	public static InetAddress getByAddress(String addr, int family)
			throws UnknownHostException {
    if (family != IPv4 && family != IPv6)
      throw new IllegalArgumentException("unknown address family");
    byte[] bytes;
    bytes = toByteArray(addr, family);
		if (bytes != null)
			return InetAddress.getByAddress(bytes);
    throw new UnknownHostException("Invalid address: " + addr);
  }

  public static byte[] toByteArray(String s, int family) {
    if (family == IPv4)
      return parseV4(s);
    else if (family == IPv6)
      return parseV6(s);
    else
      throw new IllegalArgumentException("unknown address family");
  }

	public static InetAddress getByAddress(String addr)
			throws UnknownHostException {
    byte[] bytes;
    bytes = toByteArray(addr, IPv4);
		if (bytes != null)
			return InetAddress.getByAddress(bytes);
    bytes = toByteArray(addr, IPv6);
		if (bytes != null)
			return InetAddress.getByAddress(bytes);
    throw new UnknownHostException("Invalid address: " + addr);
  }

  @Override
  protected synchronized ThreadPoolExecutor getPool() {
    // TODO Auto-generated method stub
    return super.getPool();
  }
  @Override
  protected synchronized ThreadPoolExecutor createPool() {
    // TODO Auto-generated method stub
    return super.createPool();
  }

  @Override
  public void setPool(ThreadPoolExecutor executor) {
    pool = executor;
  }
  
  @Override
  public synchronized void shutdown() throws IllegalStateException {
    this.die = true;
    if (pool != null) {
//      pool.shutdown(); //don't shutdown since we share
      pool = null;
    }
    if (listeners != null)
      listeners.clear();
    if (serverSocket != null) {
      try {
        // closes the server socket and throws a SocketException on
        // Threads waiting in accept()
        serverSocket.close();
      } catch (IOException e) {
        logger.warn("IOException while closing server socket.", e);
      }
    }
		if (cs != null) {
			try {
				cs.stop();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("\nBye! Bye!");
  }

  public int getMaxErrors() {
    return maxErrors;
  }

  public void setMaxErrors(int maxErrors) {
    this.maxErrors = maxErrors;
  }
}
