package com.safi.asterisk.handler.trigger;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.safi.asterisk.handler.SafletEngine;
import com.safi.db.manager.DBManager;
import com.safi.db.server.config.AsteriskServer;

public class AstServerChangedTrigger extends AbstractTrigger {

  private static final int COL_ACTIVE = 16;
  private static final int COL_MGR_PORT = 11;
  private static final int COL_MGR_PASS = 10;
  private static final int COL_MGR_NAME = 9;
  private static final int COL_HOSTNAME = 8;
  private static final int COL_ID = 0;
  private static final int COL_PRIVATE = 17;
  private final static Logger log = Logger.getLogger(AstServerChangedTrigger.class);

  public AstServerChangedTrigger() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void fire(int triggerType, String triggerName, String tableName, Object[] oldRow,
      Object[] newRow) {
    synchronized (AstServerChangedTrigger.class) {
      if ("asteriskserver".equals(tableName)) {
        handleAstServerChange(triggerType, newRow, oldRow);
      }
    }

  }

  private void handleAstServerChange(final int triggerType, final Object[] newRow, final Object[] oldRow) {
    Runnable runnable = new Runnable(){
      @Override
      public void run() {
        Object[] row = null;
        if (isDeleteTrigger(triggerType))
          row = oldRow;
        else
          row = newRow;
        try {
          Integer id = (Integer) row[COL_ID];
          if (((Boolean)row[COL_PRIVATE])){ //is the server private?
            return;
          }
          switch (triggerType) {
            case UPDATE_AFTER:
            case UPDATE_AFTER_ROW:
              if (!StringUtils.equals((String)newRow[COL_HOSTNAME], (String)oldRow[COL_HOSTNAME]) ||
                  !StringUtils.equals((String)newRow[COL_MGR_NAME], (String)oldRow[COL_MGR_NAME]) ||
                  !StringUtils.equals((String)newRow[COL_MGR_PASS], (String)oldRow[COL_MGR_PASS]) ||
                  ((Integer)newRow[COL_MGR_PORT]).intValue() != ((Integer)oldRow[COL_MGR_PORT]).intValue() ||
                  ((Boolean)newRow[COL_ACTIVE]).booleanValue() != ((Boolean)oldRow[COL_ACTIVE]).booleanValue())
              SafletEngine.getInstance().getConnectionManager().asteriskServerModified(id);
              break;
            case INSERT_AFTER:
            case INSERT_AFTER_ROW: {
              AsteriskServer s = DBManager.getInstance().getAsteriskServerConfig(id);
              SafletEngine.getInstance().getConnectionManager().asteriskServerAdded(s);
              break;
            }
            case DELETE_BEFORE:
            case DELETE_BEFORE_ROW: {
              SafletEngine.getInstance().getConnectionManager().asteriskServerRemoved(id);
              break;
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
          log.error("Error caught while executing Asterisk server trigger",  e);
        }
        
      }
    };
    SafletEngine.getInstance().getThreadPool().execute(runnable);
    
  }
}