package com.safi.asterisk.handler.mbean;

import java.io.Serializable;

import com.safi.db.VariableType;

public class GlobalVarInfo implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 2836839401410066990L;
  private String name;
  private Object value;
  private VariableType type;
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Object getValue() {
    return value;
  }
  public void setValue(Object value) {
    this.value = value;
  }
  public VariableType getType() {
    return type;
  }
  public void setType(VariableType type) {
    this.type = type;
  }
}
