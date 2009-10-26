package com.safi.server;

import java.lang.Thread.UncaughtExceptionHandler;

import org.asteriskjava.fastagi.AgiServer;
import org.asteriskjava.fastagi.AgiServerThread;

public class SafiAgiServerThread extends AgiServerThread {

  private UncaughtExceptionHandler exceptionHandler;
  public SafiAgiServerThread() {
  }

  public SafiAgiServerThread(AgiServer agiServer, UncaughtExceptionHandler exceptionHandler) {
    super(agiServer);
    this.exceptionHandler = exceptionHandler;
  }

  @Override
  protected UncaughtExceptionHandler getUncaughtExceptionHandler() {
    if (exceptionHandler != null)
      return exceptionHandler;
    return super.getUncaughtExceptionHandler();
  }
}
