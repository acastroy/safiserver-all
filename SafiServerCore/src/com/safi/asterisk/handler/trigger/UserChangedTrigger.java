package com.safi.asterisk.handler.trigger;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.safi.asterisk.handler.SafletEngine;
import com.safi.db.manager.DBManager;

public class UserChangedTrigger extends AbstractTrigger {

  private final static Logger log = Logger.getLogger(DBResourceTrigger.class);

  public UserChangedTrigger() {

  }

  public void fire(int triggerType, String triggerName, String tableName, Object[] oldRow,
      Object[] newRow) {

    synchronized (UserChangedTrigger.class) {
      if ("user".equals(tableName)) {
        handleUserChange(triggerType, newRow, oldRow);
      }
    }
  }

  private void handleUserChange(final int triggerType, final Object[] newRow, final Object[] oldRow) {
    if (isDeleteTrigger(triggerType))
      return;
    final String name = (String) newRow[2];
    if (!SafletEngine.SA_USER.equalsIgnoreCase(name))
      return;
    final String oldPassword = (String)oldRow[10];
    final String newPassword = (String) newRow[10];
    if (StringUtils.equals(oldPassword, newPassword))
      return;
    Runnable runnable = new Runnable(){
      @Override
      public void run() {
        
        try {
          // TODO Auto-generated method stub
          
          switch (triggerType) {
            case UPDATE_AFTER:
            case UPDATE_AFTER_ROW: {
              DBManager.getInstance().setSAPassword(newPassword, false);
              SafletEngine.getInstance().setDefaultPass(newPassword);
              break;
            }
          }
        } catch (Exception e) {
          log.error("Error caught while executing Saflet change trigger", e);
        }
      }
    };
    
    
    SafletEngine.getInstance().getThreadPool().execute(runnable);
  }
}
