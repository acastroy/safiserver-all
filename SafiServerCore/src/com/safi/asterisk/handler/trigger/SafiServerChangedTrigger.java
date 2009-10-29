package com.safi.asterisk.handler.trigger;

import org.apache.log4j.Logger;

import com.safi.asterisk.handler.SafletEngine;

public class SafiServerChangedTrigger extends AbstractTrigger {

  private final static Logger log = Logger.getLogger(AstServerChangedTrigger.class);

  public SafiServerChangedTrigger() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void fire(int triggerType, String triggerName, String tableName, Object[] oldRow,
      Object[] newRow) {
    synchronized (AstServerChangedTrigger.class) {
      if ("safiserver".equals(tableName)) {
        handleSafiServerChange(triggerType, newRow, oldRow);
      }
    }

  }

  private void handleSafiServerChange(final int triggerType, final Object[] newRow, final Object[] oldRow) {
    Runnable runnable = new Runnable(){
      @Override
      public void run() {
        Object[] row = null;
        if (isDeleteTrigger(triggerType))
          row = oldRow;
        else
          row = newRow;
        try {
          Integer id = (Integer) row[0];
          switch (triggerType) {
            case UPDATE_AFTER:
            case UPDATE_AFTER_ROW:
            case UPDATE_BEFORE:
            case UPDATE_BEFORE_ROW:
            case INSERT_AFTER:
            case INSERT_AFTER_ROW:
            case INSERT_BEFORE:
            case INSERT_BEFORE_ROW: 
            case DELETE_BEFORE:
            case DELETE_BEFORE_ROW: {
              SafletEngine.getInstance().getConnectionManager().safiServerChanged(false);
              break;
            }
          }
        } catch (Exception e) {
          log.error("Error caught while executing SafiServer change trigger", e);
        }
      }
    };
    SafletEngine.getInstance().getThreadPool().execute(runnable);
  }
}