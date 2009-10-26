package com.safi.server.launcher;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.apache.mina.common.DefaultIoFilterChainBuilder;
import org.apache.mina.common.IoAcceptor;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.executor.IoEventQueueThrottle;
import org.apache.mina.filter.executor.OrderedThreadPoolExecutor;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.integration.jmx.IoFilterMBean;
import org.apache.mina.integration.jmx.IoServiceMBean;
import org.apache.mina.transport.socket.DefaultSocketSessionConfig;
import org.apache.mina.transport.socket.SocketAcceptor;
import org.apache.mina.transport.socket.nio.NioProcessor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.asteriskjava.fastagi.AbstractAgiServer;
import org.asteriskjava.fastagi.ClassNameMappingStrategy;
import org.asteriskjava.fastagi.CompositeMappingStrategy;
import org.asteriskjava.fastagi.ResourceBundleMappingStrategy;
import org.asteriskjava.util.DaemonThreadFactory;
import org.asteriskjava.util.Log;
import org.asteriskjava.util.LogFactory;

import com.safi.server.SafiFastAgiServer;
import com.safi.server.SafiServerListener;

public class SafiMinaServer extends AbstractAgiServer implements SafiFastAgiServer {

  private static final int PORT = 4573;
  private final Log logger = LogFactory.getLog(getClass());

  public static final int IPv4 = 1;
  public static final int IPv6 = 2;
  /**
   * The default name of the resource bundle that contains the config.
   */
  protected static final String DEFAULT_CONFIG_RESOURCE_BUNDLE_NAME = "fastagi";

  /**
   * The default bind port.
   */
  protected static final int DEFAULT_BIND_PORT = 4573;

  // protected ServerSocketFacade serverSocket;
  protected String configResourceBundleName = DEFAULT_CONFIG_RESOURCE_BUNDLE_NAME;
  protected int port = DEFAULT_BIND_PORT;

//  private ExecutorService executor;
  private ExecutorService acceptExecutor;
  private IoAcceptor acceptor;
  // private IoAcceptorConfig config;
  private DefaultIoFilterChainBuilder chain;
  private Set<SafiServerListener> listeners = new HashSet<SafiServerListener>();

  private boolean running;

  /**
   * The ip address the server will bind to
   */
  private String bindAddr;
  private InetSocketAddress inetSocketAddress;

  public SafiMinaServer() {
    setMappingStrategy(new CompositeMappingStrategy(new ResourceBundleMappingStrategy(),
        new ClassNameMappingStrategy()));
    this.loadConfig();
  }

  public boolean addListener(SafiServerListener listener) {
    return listeners.add(listener);
  }

  public boolean removeListener(SafiServerListener listener) {
    return listeners.remove(listener);
  }

  private void notifyStopped(String reason) {
    for (SafiServerListener l : listeners) {
      l.serverStopped(reason);
    }

  }

  private void loadConfig() {
    final ResourceBundle resourceBundle;

    try {
      resourceBundle = ResourceBundle.getBundle(configResourceBundleName);
    } catch (MissingResourceException e) {
      return;
    }

    try {
      String portString;

      try {
        portString = resourceBundle.getString("port");
      } catch (MissingResourceException e) {
        // for backward compatibility only
        portString = resourceBundle.getString("bindPort");
      }
      port = Integer.parseInt(portString);
    } catch (Exception e) // NOPMD
    {
      // swallow
    }

    try {
      setPoolSize(Integer.parseInt(resourceBundle.getString("poolSize")));
    } catch (Exception e) // NOPMD
    {
      // swallow
    }

    try {
      setMaximumPoolSize(Integer.parseInt(resourceBundle.getString("maximumPoolSize")));
    } catch (Exception e) // NOPMD
    {
      // swallow
    }
  }

  public static void main(String[] args) throws IOException {
    SafiMinaServer safiMinaServer = new SafiMinaServer();
    safiMinaServer.startup();
  }

  private static void addLogger(DefaultIoFilterChainBuilder chain) throws Exception {
    chain.addLast("logger", new LoggingFilter());
  }

  /**
   * Sets the TCP port to listen on for new connections. <p/> The default port is 4573.
   * 
   * @param bindPort
   *            the port to bind to.
   * @deprecated use {@see #setPort(int)} instead
   */
  public void setBindPort(int bindPort) {
    this.port = bindPort;
  }

  /**
   * Sets the TCP port to listen on for new connections. <p/> The default port is 4573.
   * 
   * @param port
   *            the port to bind to.
   * @since 0.2
   */
  public void setPort(int port) {
    this.port = port;
  }

  /**
   * Returns the TCP port this server is configured to bind to.
   * 
   * @return the TCP port this server is configured to bind to.
   * @since 1.0.0
   */
  public int getPort() {
    return port;
  }

  @Override
  public void startup() throws IOException, IllegalStateException {
    // ByteBuffer.setUseDirectBuffers(false);
    // ByteBuffer.setAllocator(new SimpleByteBufferAllocator());

//    // TODO Auto-generated method stub
    acceptExecutor = new ThreadPoolExecutor(4, 10, 0L, TimeUnit.MILLISECONDS,
        new LinkedBlockingQueue<Runnable>(), new DaemonThreadFactory());

//    executor = new ThreadPoolExecutor(10, 100, 0L, TimeUnit.MILLISECONDS,
//        new LinkedBlockingQueue<Runnable>(), new DaemonThreadFactory()) {
//
//    };
//    ((ThreadPoolExecutor) executor).setRejectedExecutionHandler(new RejectedExecutionHandler() {
//      @Override
//      public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
//        System.err
//            .println("we are rejecting " + r + " and activeCount " + executor.getActiveCount()
//                + " and largeste has been " + executor.getLargestPoolSize());
//
//      }
//    });
    // executor = Executors.newFixedThreadPool(100);

    acceptor = new NioSocketAcceptor();
    acceptor.setHandler(new AgiProtocolHandler(this, this.getMappingStrategy()));
    DefaultSocketSessionConfig config = (DefaultSocketSessionConfig)acceptor.getSessionConfig();
    config.setTcpNoDelay(true);
    config.setReuseAddress(true);
    

    // IoServiceMBean serviceManager = new IoServiceMBean(acceptor);
    // serviceManager.startCollectingStats(1000);
    // MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
    // ObjectName name;
    // try {
    // name = new ObjectName("mina.example.http.server:type=IoServiceManager");
    // mbs.registerMBean(serviceManager, name);
    // } catch (MalformedObjectNameException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // } catch (NullPointerException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // } catch (InstanceAlreadyExistsException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // } catch (MBeanRegistrationException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // } catch (NotCompliantMBeanException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }

    // config = new SocketAcceptorConfig();
    // chain = config.getFilterChain();

    ExecutorFilter executorFilter = new ExecutorFilter(
        new OrderedThreadPoolExecutor(
                0, 16, 30, TimeUnit.SECONDS,
                new IoEventQueueThrottle(1048576)));
    
    acceptor.getFilterChain().addLast("executor",executorFilter);
    acceptor.getFilterChain().addLast("logger", new LoggingFilter());
    // ((SocketSessionConfig) config.getSessionConfig()).setReuseAddress(true);

    InetAddress addr = null;
    if (bindAddr != null) {
      addr = getByAddress(bindAddr);
    }
    inetSocketAddress = null;
    if (addr != null)
      inetSocketAddress = new InetSocketAddress(addr, PORT);
    else
      inetSocketAddress = new InetSocketAddress(PORT);
    // try {
    // running = true;
    // startup();
    // notifyStopped("Graceful Shutdown");
    // } catch (IOException e) // NOPMD
    // {
    // // nothing we can do about that and exceptions have already been logged
    // // by startup().
    // notifyStopped(e.getLocalizedMessage());
    // } finally {
    // running = false;
    // }
    acceptor.bind(inetSocketAddress);
    
    final MBeanServer server = ManagementFactory.getPlatformMBeanServer();
    try {
      server.registerMBean(new IoServiceMBean(acceptor), new ObjectName(
          "org.apache.mina:type=service,name=SafiServerService"));

      server.registerMBean(new IoFilterMBean(executorFilter), new ObjectName(
          "org.apache.mina:type=filter,name=executor"));

      server.registerMBean(new IoFilterMBean(new LoggingFilter()), new ObjectName(
          "org.apache.mina:type=filter,name=logger"));
    } catch (InstanceAlreadyExistsException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (MBeanRegistrationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NotCompliantMBeanException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (MalformedObjectNameException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (NullPointerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    running = true;
    System.out.println("Listening on port " + PORT);
    notifyStarted();

  }

  private void notifyStarted() {
    for (SafiServerListener l : listeners) {
      l.serverStarted();
    }
  }

  public String getBoundIpAddress() {
    if (!running || inetSocketAddress == null) return bindAddr;
    return inetSocketAddress.getAddress().getHostAddress();
  }

  @Override
  public void shutdown() throws IllegalStateException {
    // TODO Auto-generated method stub
    this.die = true;
      if (pool != null) {
        pool = null;
      }
    this.acceptor.unbind();
    running = false;
    notifyStopped("");
  }

  public void execute(Runnable command) {
//    command.run();
    super.execute(command);
  }

  protected synchronized ThreadPoolExecutor getPool() {
    if (pool == null) {
      pool = createPool();
      logger.info("Thread pool started.");
    }

    return pool;
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

  public boolean isRunning() {
    return running;
  }

  public String getBindAddr() {
    return bindAddr;
  }

  public void setBindAddr(String bindAddr) {
    this.bindAddr = bindAddr;
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
        if (numDigits == 3) return null;
        /* Octets shouldn't start with 0, unless they are 0. */
        if (numDigits > 0 && currentValue == 0) return null;
        numDigits++;
        currentValue *= 10;
        currentValue += (c - '0');
        /* 255 is the maximum value for an octet. */
        if (currentValue > 255) return null;
      } else if (c == '.') {
        /* Can't have more than 3 dots. */
        if (currentOctet == 3) return null;
        /* Two consecutive dots are bad. */
        if (numDigits == 0) return null;
        values[currentOctet++] = (byte) currentValue;
        currentValue = 0;
        numDigits = 0;
      } else
        return null;
    }
    /* Must have 4 octets. */
    if (currentOctet != 3) return null;
    /* The fourth octet can't be empty. */
    if (numDigits == 0) return null;
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

    if (last - first + 1 > 8) return null;

    int i, j;
    for (i = first, j = 0; i <= last; i++) {
      if (tokens[i].length() == 0) {
        if (range >= 0) return null;
        range = j;
        continue;
      }

      if (tokens[i].indexOf('.') >= 0) {
        parsev4 = true;
        // An IPv4 address must be the last component
        if (i < last) return null;
        // There can't have been more than 6 components.
        if (i > 6) return null;
        byte[] v4addr = toByteArray(tokens[i], IPv4);
        if (v4addr == null) return null;
        for (int k = 0; k < 4; k++)
          data[j++] = v4addr[k];
        break;
      }

      try {
        for (int k = 0; k < tokens[i].length(); k++) {
          char c = tokens[i].charAt(k);
          if (Character.digit(c, 16) < 0) return null;
        }
        int x = Integer.parseInt(tokens[i], 16);
        if (x > 0xFFFF || x < 0) return null;
        data[j++] = (byte) (x >>> 8);
        data[j++] = (byte) (x & 0xFF);
      } catch (NumberFormatException e) {
        return null;
      }
    }

    if (j < 16 && range < 0) return null;

    if (range >= 0) {
      int empty = 16 - j;
      System.arraycopy(data, range, data, range + empty, j - range);
      for (i = range; i < range + empty; i++)
        data[i] = 0;
    }

    return data;
  }

  public static InetAddress getByAddress(String addr, int family) throws UnknownHostException {
    if (family != IPv4 && family != IPv6)
      throw new IllegalArgumentException("unknown address family");
    byte[] bytes;
    bytes = toByteArray(addr, family);
    if (bytes != null) return InetAddress.getByAddress(bytes);
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

  public static InetAddress getByAddress(String addr) throws UnknownHostException {
    byte[] bytes;
    bytes = toByteArray(addr, IPv4);
    if (bytes != null) return InetAddress.getByAddress(bytes);
    bytes = toByteArray(addr, IPv6);
    if (bytes != null) return InetAddress.getByAddress(bytes);
    throw new UnknownHostException("Invalid address: " + addr);
  }
}