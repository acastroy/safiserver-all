package com.safi.db.manager;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class DBConnectionStats implements Serializable{

  private static final long serialVersionUID = 5981749286420459146L;
  private int numBusyConnections;
  private int numIdleConnections;
  private long upTime;
  
  public DBConnectionStats() {
    numBusyConnections = numIdleConnections = 0;
  }
  
  public int getNumBusyConnections() {
    return numBusyConnections;
  }
  public void setNumBusyConnections(int numBusyConnections) {
    this.numBusyConnections = numBusyConnections;
  }
  public int getNumIdleConnections() {
    return numIdleConnections;
  }
  public void setNumIdleConnections(int numIdleConnections) {
    this.numIdleConnections = numIdleConnections;
  }

  public long getUpTime() {
    return upTime;
  }

  public void setUpTime(long upTime) {
    this.upTime = upTime;
  }
  
  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }
  
  @Override
  public int hashCode() {
    return HashCodeBuilder.reflectionHashCode(this);
  }
  
  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
  }
}
