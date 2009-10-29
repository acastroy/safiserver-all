package com.safi.asterisk.handler.mbean;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.safi.db.manager.DBConnectionStats;

public class SysInfoImpl implements SysInfo {

  private static final long serialVersionUID = -8559362668310677218L;
  private Map<String, DBConnectionStats> connectionPoolData;
  private int currentThreads;
  private int customInitiations;
  private long freeMemory;
  private long maxMemory;
  private long totalMemory;
  private long uptime;
  private double cpuUsage;
  private String ipAddress;
  private String serverID;
  private String macAddress;
  private int incomingCalls;
  private int coreThreadCount;
  private int maxCoreThreadCount;
  private long freeSpace;
  private long totalSpace;
  private String safiServerVersion;
  private List<GlobalVarInfo> globalVars;
  
  public SysInfoImpl() {
  }
  public Map<String, DBConnectionStats> getConnectionPoolData() {
    return connectionPoolData;
  }
  public void setConnectionPoolData(Map<String, DBConnectionStats> connectionPoolData) {
    this.connectionPoolData = connectionPoolData;
  }
  public int getCurrentThreads() {
    return currentThreads;
  }
  public void setCurrentThreads(int currentThreads) {
    this.currentThreads = currentThreads;
  }
  public int getCustomInitiations() {
    return customInitiations;
  }
  public void setCustomInitiations(int customInitiations) {
    this.customInitiations = customInitiations;
  }
  public long getFreeMemory() {
    return freeMemory;
  }
  public void setFreeMemory(long freeMemory) {
    this.freeMemory = freeMemory;
  }
  public long getMaxMemory() {
    return maxMemory;
  }
  public void setMaxMemory(long maxMemory) {
    this.maxMemory = maxMemory;
  }
  public long getTotalMemory() {
    return totalMemory;
  }
  public void setTotalMemory(long totalMemory) {
    this.totalMemory = totalMemory;
  }
  public long getUptime() {
    return uptime;
  }
  public void setUptime(long uptime) {
    this.uptime = uptime;
  }
  public String getServerID() {
    return serverID;
  }
  public void setServerID(String serverID) {
    this.serverID = serverID;
  }
  public String getMacAddress() {
    return macAddress;
  }
  public void setMacAddress(String macAddress) {
    this.macAddress = macAddress;
  }
  @Override
  public String getIPAddress() {
    return ipAddress;
  }
  @Override
  public int getIncomingCalls() {
    return incomingCalls;
  }
  public String getIpAddress() {
    return ipAddress;
  }
  public void setIpAddress(String ipAddress) {
    this.ipAddress = ipAddress;
  }
  public void setNumAgiRequests(int incomingCalls) {
    this.incomingCalls = incomingCalls;
  }
  
  @Override
  public int getCoreThreadCount() {
    return coreThreadCount;
  }
  
 
  public void setCoreThreadCount(int coreThreadCount) {
    this.coreThreadCount = coreThreadCount;
  }
  public void setMaxCoreThreadCount(int maxThreadCount) {
    this.maxCoreThreadCount = maxThreadCount;
    
  }
  
  @Override
  public int getMaxCoreThreadCount() {
    return maxCoreThreadCount;
  }
  public void setFreeSpace(long freeSpace) {
    this.freeSpace = freeSpace;
    
  }
  public void setTotalSpace(long totalSpace) {
    this.totalSpace = totalSpace;
    
  }
  
  @Override
  public long getFreeSpace() {
    return freeSpace;
  }
  @Override
  public long getTotalSpace() {
    return totalSpace;
  }
  
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
  
  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(obj, this);
  }
  
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
  public String getSafiServerVersion() {
    return safiServerVersion;
  }
  public void setSafiServerVersion(String safiServerVersion) {
    this.safiServerVersion = safiServerVersion;
  }
  public List<GlobalVarInfo> getGlobalVars() {
    return globalVars;
  }
  public void setGlobalVars(List<GlobalVarInfo> globalVars) {
    this.globalVars = globalVars;
  }
  public double getCPUUsage() {
    return cpuUsage;
  }
  public void setCPUUsage(double cpuUsage) {
    this.cpuUsage = cpuUsage;
  }
}