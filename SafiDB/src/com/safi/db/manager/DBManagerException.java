package com.safi.db.manager;

public class DBManagerException extends Exception {

  /**
   * 
   */
  private static final long serialVersionUID = -5593585053187065324L;

  public DBManagerException() {
  }

  public DBManagerException(String message) {
    super(message);
  }

  public DBManagerException(Throwable cause) {
    super(cause);
  }

  public DBManagerException(String message, Throwable cause) {
    super(message, cause);
  }

}
