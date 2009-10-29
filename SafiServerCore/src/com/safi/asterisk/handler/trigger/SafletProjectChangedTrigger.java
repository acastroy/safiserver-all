package com.safi.asterisk.handler.trigger;

import org.apache.log4j.Logger;

import com.safi.asterisk.handler.SafletEngine;
import com.safi.asterisk.handler.dispatch.SafletDispatch;
import com.safi.db.manager.DBManager;
import com.safi.db.server.config.Saflet;

public class SafletProjectChangedTrigger extends AbstractTrigger {

  private final static Logger log = Logger.getLogger(SafletProjectChangedTrigger.class);

  public SafletProjectChangedTrigger() {

  }

  public void fire(int triggerType, String triggerName, String tableName, Object[] oldRow,
      Object[] newRow) {

    synchronized (SafletProjectChangedTrigger.class) {
      if ("safletproject".equals(tableName)) {
        handleSafletProjectChange(triggerType, newRow, oldRow);
      }
    }
  }

  private void handleSafletProjectChange(final int triggerType, final Object[] newRow, final Object[] oldRow) {
    Runnable runnable = new Runnable(){
      @Override
      public void run() {
        Object[] row = null;
        if (isDeleteTrigger(triggerType))
          row = oldRow;
        else
          row = newRow;
        try {
          // TODO Auto-generated method stub
          Integer pid = (Integer) row[0];
          switch (triggerType) {
            case DELETE_AFTER:
            case DELETE_AFTER_ROW:
            case DELETE_BEFORE:
            case DELETE_BEFORE_ROW:
             {
              SafletDispatch dispatch = SafletEngine.getInstance().getDispatcher();
              com.safi.db.server.config.SafletProject proj = DBManager.getInstance().getSafletProject(
                  pid);
              if (proj == null && DELETE_BEFORE == triggerType) {
                log.error("SafletProject trigger Couldn't find Project for id " + pid+" for trigger type "+triggerType);
                return;
              }
              for (Saflet s : proj.getSaflets()){
                String path = proj.getName() + "/" +s.getName();
                boolean removed = dispatch.unregisterHandler(path);
                if (log.isDebugEnabled()) {
                  log.debug("Saflet " + path + " was changed and " + (removed ? "was" : "was not")
                      + " previously loaded");
                }
              }
              
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
