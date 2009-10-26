package com.safi.server.actions;

import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

public class ServerUtilities implements IPropertyChangeListener {

//  private SafletEngine handlerEngine;

  private static ServerUtilities instance = new ServerUtilities();

//  private Set<ServerStartupCallback> callbackList;

  private volatile Job serverJob;

  public final static Object lock = new Object();
  public final static Object startLock = new Object();

//  private static final List<String> fundamentalProps = new ArrayList<String>();

  protected static final long STARTUP_TIMEOUT = 90000l;// 90 secs

//  static {
//    fundamentalProps.add(PreferenceConstants.PREF_AST_IP_DEBUG);
//    fundamentalProps.add(PreferenceConstants.PREF_MGR_USER_DEBUG);
//    fundamentalProps.add(PreferenceConstants.PREF_MGR_PWD_DEBUG);
//    fundamentalProps.add(PreferenceConstants.PREF_SAFI_BIND_ADDR_LOCAL);
//    fundamentalProps.add(PreferenceConstants.PREF_FASTAGI_PORT_DEBUG);
//    fundamentalProps.add(PreferenceConstants.PREF_MANAGER_PORT_DEBUG);
//  }

  protected ServerUtilities() {}

  public static ServerUtilities getInstance() {
    return instance;
  }

  public synchronized boolean isRunning() {
    return serverJob != null && serverJob.getState() == Job.RUNNING;
  }

  //
  // public void setManagerPort(int port) {
  // handlerEngine.getConnectionManager().setManagerPort(port);
  // }
  //
  // public void setFastAgiPort(int port) {
  // handlerEngine.getConnectionManager().setFastAgiPort(port);
  // }

  // public void setManagerUsername(String user) {
  // handlerEngine.setUserName(user);
  // }

  // public void setManagerPassword(String password) {
  // handlerEngine.setPassword(password);
  // }
  //
  // public void setAsteriskHostname(String host) {
  // handlerEngine.setHostName(host);
  // }

//  public void registerDebugHandler(String path, Saflet handler, Object lock,
//      TransactionalEditingDomain editingDomain) throws SafletEngineException {
////    handlerEngine.getDispatcher().registerDebugHandler(path, handler, lock, editingDomain);
//  }
  
//  public void registerDebugHandlerRemote(String path, Saflet handler, Object lock,
//      TransactionalEditingDomain editingDomain) throws SafletEngineException {
//    SafiServerRemoteManager.getInstance().
//    handlerEngine.getDispatcher().registerDebugHandler(path, handler, lock, editingDomain);
//  }

//  public void unregisterHandler(Saflet handler) {
//    handlerEngine.getDispatcher().unregisterDebugHandler(handler);
//
//  }
//
//  public void addServerStartupCallback(ServerStartupCallback callback) {
//    
//    if (callbackList == null)
//      callbackList = new HashSet<ServerStartupCallback>();
//    callbackList.add(callback);
//  }
//
//  public void removeServerStartupCallback(ServerStartupCallback callback) {
//    if (callbackList == null)
//      return;
//
//    callbackList.remove(callback);
//  }
//
//  private volatile boolean cancelling;

//  public void startServer() throws SafletEngineException {}
//
//  // private void setBindAddr(String bindAddr) {
//  // handlerEngine.setServerBindAddr(bindAddr);
//  //
//  // }
//
//  public void stopServer() {
//    synchronized (startLock) {
//      startLock.notifyAll();
//    }
//    SafiServerPlugin serverPlugin = SafiServerPlugin.getDefault();
//    if (serverPlugin != null)
//      serverPlugin.stopDebugLog();
//    if (handlerEngine != null)
//      handlerEngine.stopProcessing();
//    SafiServerPlugin.getDefault().notifyResourcesChanged();
//  }

//  public static interface ServerStartupCallback {
//    public abstract void serverStarted();
//
//    public abstract void serverFailedToStart(String msg);
//
//    public abstract void serverStopped();
//
//    public abstract boolean removeOnServerStop();
//  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    
  }

  
}
