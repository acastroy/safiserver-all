package com.safi.asterisk.handler.mbean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.safi.db.manager.DBConnectionStats;

public interface SysInfo extends Serializable {

  long getFreeMemory();
  
  long getMaxMemory();
  
  long getTotalMemory();
  
  double getCPUUsage();
  
  Map<String, DBConnectionStats> getConnectionPoolData();
  
  long getUptime();
  
  int getCurrentThreads();
  
  int getIncomingCalls();
  
  int getCustomInitiations();
  
  String getMacAddress();
  
  String getIPAddress();
  
  String getServerID();
  
  int getCoreThreadCount();

  int getMaxCoreThreadCount();

  long getFreeSpace();

  long getTotalSpace();
  
  String getSafiServerVersion();
  
  List<GlobalVarInfo> getGlobalVars();
}
