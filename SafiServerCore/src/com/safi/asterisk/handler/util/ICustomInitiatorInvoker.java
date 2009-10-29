package com.safi.asterisk.handler.util;


public interface ICustomInitiatorInvoker {

  public abstract String invoke(String saflet, String astIp, java.util.Properties props) throws Exception;

}