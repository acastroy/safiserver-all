package com.safi.asterisk.handler.trigger;

import org.apache.log4j.Logger;

import com.safi.asterisk.handler.SafletEngine;
import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.SafiDriverManager;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.PooledDataSourceManager;

public class DBResourceTrigger extends AbstractTrigger {

  private final static Logger log = Logger.getLogger(DBResourceTrigger.class);

  public DBResourceTrigger() {

  }

  public void fire(int triggerType, String triggerName, String tableName, Object[] oldRow,
      Object[] newRow) {

    synchronized (DBResourceTrigger.class) {
      if ("dbconnection".equals(tableName)) {
        handleConnectionChange(triggerType, newRow, oldRow);
      } else if ("query".equals(tableName)) {
        handleQueryChange(triggerType, newRow, oldRow);
      }
    }
  }

  private void handleConnectionChange(final int triggerType, final Object[] newRow,
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
          switch (triggerType) {
            case UPDATE_AFTER:
            case UPDATE_AFTER_ROW:
            case UPDATE_BEFORE_ROW:
            case INSERT_AFTER:
            case INSERT_AFTER_ROW:
            case INSERT_BEFORE_ROW: {
              DBManager.getInstance().reloadDriverManagerFromDB();
              SafiDriverManager manager = DBManager.getInstance().getDriverManager();
              Integer id = (Integer) row[0];
              Integer did = (Integer) row[row.length - 2];
              DBDriver drv = null;
              for (DBDriver d : manager.getDrivers()) {
                if (d==null) continue;
                if (d.getId() == did) {
                  drv = d;
                  break;
                }
              }
              if (drv == null) {
                log.error("Couldn't find DriverManager for id " + did);
                return;
              }
              DBConnection connection = null;
              for (DBConnection conn : drv.getConnections()) {
                if (conn == null) continue;
                if (conn.getId() == id) {
                  connection = conn;
                  break;
                }
              }
              if (connection == null) {
                log.error("Couldn't find DBConnection for id " + id + " from driver "
                    + drv.getName());
                return;
              }
              PooledDataSourceManager.getInstance().connectionChanged(connection);
              break;
            }

            case DELETE_AFTER:
            case DELETE_AFTER_ROW: {
              DBManager.getInstance().reloadDriverManagerFromDB();
              break;
            }
            case DELETE_BEFORE_ROW: {
              SafiDriverManager manager = DBManager.getInstance().getDriverManager();
              Integer id = (Integer) row[0];
              Integer did = (Integer) row[row.length - 2];
              DBDriver drv = null;
              for (DBDriver d : manager.getDrivers()) {
                if (d == null) continue;
                if (d.getId() == did) {
                  drv = d;
                  break;
                }
              }
              if (drv == null) {
                log.error("Couldn't find DriverManager for id " + did);
                return;
              }
              DBConnection connection = null;
              for (DBConnection conn : drv.getConnections()) {
                if (conn == null) continue;
                if (conn.getId() == id) {
                  connection = conn;
                  break;
                }
              }
              if (connection == null) {
                log.error("Couldn't find DBConnection for id " + id + " from driver "
                    + drv.getName());
                return;
              }
              PooledDataSourceManager.getInstance().connectionDeleted(connection);
            }
          }
        } catch (Exception e) {
          log.error("Error caught while executing DBResource trigger", e);
        }

      }
    };
    SafletEngine.getInstance().getThreadPool().execute(runnable);
  }

  private void handleQueryChange(final int triggerType, final Object[] newRow, final Object[] oldRow) {
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
          switch (triggerType) {
            case UPDATE_AFTER:
            case UPDATE_AFTER_ROW:
            case UPDATE_BEFORE_ROW:
            case INSERT_AFTER:
            case INSERT_AFTER_ROW:
            case INSERT_BEFORE_ROW: {
              DBManager.getInstance().reloadDriverManagerFromDB();
              // SafiDriverManager manager = DBManager.getInstance().getDriverManager();
              break;
            }

            case DELETE_AFTER:
            case DELETE_AFTER_ROW:
            case DELETE_BEFORE_ROW: {
              DBManager.getInstance().reloadDriverManagerFromDB();
              break;
            }
          }
        } catch (Exception e) {
          log.error("Error caught while executing DBResource trigger", e);
        }

      }
    };
    SafletEngine.getInstance().getThreadPool().execute(runnable);
  }
}
