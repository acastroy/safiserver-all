package com.safi.asterisk.handler.mbean;

import java.net.UnknownHostException;

public interface SafiServerMonitor {
  public final static String LOG_EVENT_TYPE = "LogEventType";
  public final static String DEBUG_EVENT_TYPE = "DebugEventType";
  public final static String SYSINFO_EVENT_TYPE = "SysInfoEventType";

  public abstract int getCurrentThreadCount();
  
  public abstract String[] getLocalIPAddresses() throws UnknownHostException;
  
  public abstract void setTracelogLevel(String levelStr);

  public abstract String getTracelogLevel();
  
  public abstract void synchAudioFiles(int asteriskServerID) throws Exception;
  
  byte[] getPromptFile(int promptID) throws Exception;
  
  public abstract void setServerInfoUpdateFrequency(int seconds);
  
  public abstract int getServerInfoUpdateFrequency();
  
  public abstract void requestServerInfoUpdate();
  
  public abstract byte[] getServerLogFile() throws Exception;
  
  public abstract int debugSaflet(String projectName, String safletName) throws Exception;
  
  public abstract void stepDebug(int key) throws Exception;
  public abstract void resumeDebug(int key) throws Exception;
  public abstract void stopDebug(int key) throws Exception;
  public abstract void setBreakPoint(int key, String uid, boolean b) throws Exception;
}