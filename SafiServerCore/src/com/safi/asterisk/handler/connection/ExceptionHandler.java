package com.safi.asterisk.handler.connection;

import java.io.Serializable;

public interface ExceptionHandler extends Serializable{

  public abstract void handleException(String message, Exception e);
}
