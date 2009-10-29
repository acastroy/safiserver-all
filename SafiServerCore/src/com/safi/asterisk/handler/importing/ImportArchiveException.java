package com.safi.asterisk.handler.importing;

public class ImportArchiveException extends Exception {

  public enum Type {
    RESOURCE_EXISTS, SYSTEM
  }
  /**
   * 
   */
  private static final long serialVersionUID = -4081053052501971780L;

  private Type type = Type.SYSTEM;
  public ImportArchiveException(Type type) {
    this.type = type;
  }

  public ImportArchiveException(Type type, String message) {
    super(message);
    this.type = type;
  }

  public ImportArchiveException(Type type, String message, Throwable cause) {
    super(message, cause);
    this.type = type;
  }

  public Type getType() {
    return type;
  }

}
