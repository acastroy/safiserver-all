package com.safi.server;

import java.util.concurrent.ThreadPoolExecutor;

import org.asteriskjava.fastagi.AgiServer;
import org.asteriskjava.fastagi.MappingStrategy;

public interface SafiFastAgiServer extends AgiServer{

  public abstract boolean addListener(SafiServerListener listener);

  public abstract boolean removeListener(SafiServerListener listener);

//  public abstract void run();

  public abstract boolean isRunning();

  public abstract String getBindAddr();

  public abstract void setBindAddr(String bindAddr);
  
  public abstract String getBoundIpAddress();
  
  public abstract void setPort(int port);
  public abstract void setPoolSize(int size);
  public abstract void setMaximumPoolSize(int size);
  public abstract void setMappingStrategy(MappingStrategy strategy);
  public abstract void setPool(ThreadPoolExecutor executor);
  

}