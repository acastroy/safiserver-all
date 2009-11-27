package com.safi.asterisk.handler.trigger;

import org.apache.log4j.Logger;
import com.safi.asterisk.handler.SafletEngine;
import com.safi.asterisk.handler.dispatch.SafletDispatch;
import com.safi.db.manager.DBManager;

public class SafletChangedTrigger extends AbstractTrigger {

  private final static Logger log = Logger.getLogger(DBResourceTrigger.class);

  public SafletChangedTrigger() {

  }

  public void fire(int triggerType, String triggerName, String tableName, Object[] oldRow,
      Object[] newRow) {

    synchronized (SafletChangedTrigger.class) {
      if ("saflet".equals(tableName)) {
        handlerSafletChange(triggerType, newRow, oldRow);
      }
    }
  }

  private void handlerSafletChange(final int triggerType, final Object[] newRow,
      final Object[] oldRow) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        Object[] row = null;
        if (isDeleteTrigger(triggerType))
          row = oldRow;
        else
          row = newRow;
        try {
          // TODO Auto-generated method stub
          Integer pid = (Integer) row[row.length - 1];
          switch (triggerType) {
            case DELETE_AFTER:
            case DELETE_AFTER_ROW:
            case DELETE_BEFORE_ROW:
            case UPDATE_AFTER:
            case UPDATE_AFTER_ROW:
            case UPDATE_BEFORE_ROW: {
              SafletDispatch dispatch = SafletEngine.getInstance().getDispatcher();
              com.safi.db.server.config.SafletProject proj = DBManager.getInstance()
                  .getSafletProject(pid);
              if (proj == null && triggerType == UPDATE_BEFORE_ROW) {

                log.error("Saflet trigger Couldn't find Project for id " + pid
                    + " for trigger type " + triggerType);
                return;
              }
              if (proj != null) {
                String path = proj.getName() + "/" + row[2];
                boolean removed = dispatch.unregisterHandler(path);
                dispatch.clearLicenseCache((Integer)row[0]);
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
