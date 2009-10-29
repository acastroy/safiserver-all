package com.safi.asterisk.handler.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.safi.asterisk.handler.SafletEngine;
import com.safi.asterisk.handler.connection.ExceptionHandler;

public class CustomInitiatorInvoker implements Serializable, ICustomInitiatorInvoker{

  /**
   * 
   */
  private static final long serialVersionUID = -3178487278616975910L;

  /* (non-Javadoc)
   * @see com.safi.asterisk.handler.util.ICustomInitiatorInvoker#invoke(java.lang.String, java.lang.String, java.util.Properties)
   */
  public String invoke(String saflet, String astIp, java.util.Properties props){
    final StringBuffer result = new StringBuffer();
    final List<Throwable> exceptionList = new ArrayList<Throwable>();
    ExceptionHandler handler = new ExceptionHandler(){
      /**
       * 
       */
      private static final long serialVersionUID = 1L;

      @Override
      public void handleException(String message, Exception e) {
        Throwable th = getUnderlyingCause(e);
        exceptionList.add(th);
        result.append(message).append(" :").append(th.getLocalizedMessage()).append('\n');
        
      }
    };
    try {
      SafletEngine.getInstance().getConnectionManager().handle(saflet, astIp, props, handler);
    } catch (Exception e) {
      Throwable th = getUnderlyingCause(e);
      result.append(th.getStackTrace()).append('\n');
    }
    return result.toString();
    
  }
  
  
  private Throwable getUnderlyingCause(Throwable e) {
    if (e == null)
      return null;
    Throwable cause = e;
    while (cause.getCause() != null){
      cause = cause.getCause();
    }
    return cause;
  }
}
