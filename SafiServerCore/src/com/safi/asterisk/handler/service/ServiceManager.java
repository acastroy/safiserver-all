package com.safi.asterisk.handler.service;

import org.apache.log4j.Logger;
import org.tanukisoftware.wrapper.WrapperListener;
import org.tanukisoftware.wrapper.WrapperManager;

import com.safi.asterisk.handler.SafletEngine;

public class ServiceManager implements WrapperListener {
  private final static Logger log = Logger.getLogger(ServiceManager.class);
  private SafletEngine engine;
  
  @Override
  public void controlEvent(int arg0) {
    // TODO Auto-generated method stub

  }

  @Override
  public Integer start(String[] args) {
    try {
      SafletEngine.setServiceManager(this);
      SafletEngine.main(args);
      engine = SafletEngine.getInstance();
    } catch (Exception e) {
      e.printStackTrace();
      return Integer.valueOf(1);
    }
    WrapperManager.log(WrapperManager.WRAPPER_LOG_LEVEL_INFO, "SafiServer started successfully");
    return null;
  }

  @Override
  public int stop(int arg0) {
    SafletEngine.getInstance().stopProcessing();
    return 0;
  }

  public static void main(String[] args) {
    WrapperManager.start(new ServiceManager(), args );
  }
  
  
}
