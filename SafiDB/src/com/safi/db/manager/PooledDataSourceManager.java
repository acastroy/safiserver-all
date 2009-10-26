package com.safi.db.manager;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.safi.db.DBConnection;

public class PooledDataSourceManager {

  public static final int MAX_STATEMENTS_PER_CONN_CACHE = 3;
  private static final String ENV_DEBUG_SERVER_MODE = "DebugServerMode";
  public static final int UNRETURNED_CONNECTION_TIMETOUT = 60 * 60;// 1 hour

  private Map<String, DataSource> datasourceMap = new Hashtable<String, DataSource>();

  private Map<String, DBConnectionStats> stats = new Hashtable<String, DBConnectionStats>();

  private static final PooledDataSourceManager instance = new PooledDataSourceManager();

  private final static Logger log = Logger.getLogger(PooledDataSourceManager.class);

  private final Executor initThreadPool = Executors.newSingleThreadExecutor();

  private final boolean isDebug;
  
  public PooledDataSourceManager() {
    isDebug = Boolean.valueOf(System.getProperty(ENV_DEBUG_SERVER_MODE, "false")).booleanValue();
  }
  public static PooledDataSourceManager getInstance() {
    return instance;
  }

  public void connectionChanged(DBConnection safiConn) {
    synchronized (safiConn) {
      String scopedName = getScopedName(safiConn);
      DataSource ds = datasourceMap.remove(scopedName);
      if (ds != null) {
        ComboPooledDataSource cpds = (ComboPooledDataSource) ds;
        cpds.close();
      }

      try {
        ds = refreshDS(safiConn, scopedName);
        updateStats(scopedName, ds);
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        log.error("Couldn't refresh datasource " + scopedName, e);
      }
    }
  }

  private void updateStats(String scopedName, DataSource ds) throws SQLException {
    if (ds != null) {
      DBConnectionStats s = stats.get(scopedName);
      if (s == null) {
        s = new DBConnectionStats();
        stats.put(scopedName, s);
      }
      s.setNumBusyConnections(((ComboPooledDataSource) ds).getNumBusyConnectionsAllUsers());
      s.setNumIdleConnections(((ComboPooledDataSource) ds).getNumIdleConnectionsAllUsers());
      s.setUpTime(((ComboPooledDataSource) ds).getUpTimeMillisDefaultUser());
    }
  }

  public void connectionDeleted(DBConnection safiConn) {
    synchronized (safiConn) {
      String scopedName = getScopedName(safiConn);
      DataSource ds = datasourceMap.remove(scopedName);
      if (ds != null) {
        stats.remove(scopedName);
        ComboPooledDataSource cpds = (ComboPooledDataSource) ds;
        cpds.close();
      }
    }
  }

  public Connection getConnection(DBConnection safiConn) throws SQLException {
    String scopedName = getScopedName(safiConn);
    DataSource ds = null;
    synchronized (safiConn) {
      ds = datasourceMap.get(scopedName);
      if (ds == null) {
        ds = refreshDS(safiConn, scopedName);
      }
      updateStats(scopedName, ds);
    }

    return ds.getConnection();
  }

  private DataSource refreshDS(final DBConnection safiConn, String scopedName) throws SQLException {
    DataSource ds;
    ds = datasourceMap.get(scopedName);// check again
    if (ds == null) {
      final ComboPooledDataSource pds = new ComboPooledDataSource(true);

      try {
        pds.setDriverClass(safiConn.getDriver().getDriverClassName());
      } catch (PropertyVetoException e) {
        // TODO Auto-generated catch block
        log.error("PropertyVetoException from driver class initialization", e);
        throw new SQLException("PropertyVetoException from driver class initialization", e);
      }
      Properties props = safiConn.getProperties();
      if (props != null && !props.isEmpty())
        pds.setProperties(props);
      pds.setUser(safiConn.getUser());
      pds.setPassword(safiConn.getPassword());
      pds.setAcquireIncrement(isDebug ? 1 : safiConn.getAcquireIncrement());

      pds.setCheckoutTimeout(safiConn.getLoginTimeout() * 1000);

      pds.setDescription(safiConn.getName());
      pds.setInitialPoolSize(isDebug ? 1 : safiConn.getMinPoolSize());
      pds.setJdbcUrl(safiConn.getUrl());
      pds.setMaxIdleTime(safiConn.getMaxIdleTime());

      pds.setMaxPoolSize(safiConn.getMaxPoolSize());
      pds.setMinPoolSize(isDebug ? 1 : safiConn.getMinPoolSize());
      if (isDebug){
        pds.setMaxIdleTimeExcessConnections(30);
        pds.setMaxIdleTime(120);
      }
      if (safiConn.getMinPoolSize() > 0) {
        Runnable runnable = new Runnable() {
          @Override
          public void run() {
            List<Connection> conns = new ArrayList<Connection>();
            try {
              for (int i = 0; i < safiConn.getMinPoolSize(); i++) {
                conns.add(pds.getConnection());
              }
            } catch (SQLException e) {
              e.printStackTrace();
              log.error("Couldn't initialize connection " + safiConn.getName() + ":"
                  + safiConn.getId(), e);
            } finally {
              for (Connection c : conns) {
                try {
                  c.close();
                } catch (Exception e) {
                }
              }
            }

          }
        };
        initThreadPool.execute(runnable);
      }
      // if (safiConn.getMinPoolSize() > 0) {
      // List<Connection> conns = new ArrayList<Connection>();
      // try {
      // for (int i = 0; i < safiConn.getMinPoolSize(); i++) {
      // conns.add(pds.getConnection());
      // }
      // } catch (SQLException e) {
      // e.printStackTrace();
      // log.error("Couldn't initialize connection " + safiConn.getName() + ":"
      // + safiConn.getId(), e);
      // } finally {
      // for (Connection c : conns) {
      // try {
      // c.close();
      // } catch (Exception e) {
      // }
      // }
      // }
      // }
      // pds.setAutoCommitOnClose(safiConn.get
      datasourceMap.put(scopedName, pds);
      ds = pds;

      // system-wide defaults
      // pds.setUnreturnedConnectionTimeout(UNRETURNED_CONNECTION_TIMETOUT);
      // pds.setDebugUnreturnedConnectionStackTraces(true);
      // pds.setAutoCommitOnClose(true);
      // pds.setMaxStatementsPerConnection(MAX_STATEMENTS_PER_CONN_CACHE);
    }

    return ds;
  }

  public void shutdown() {
    stats.clear();
    for (DataSource ds : datasourceMap.values()) {
      try {
        ((ComboPooledDataSource) ds).close();
      } catch (Exception e) {
        log.error("Error caught while closing datasource", e);
      }
    }
    datasourceMap.clear();
  }

  private String getScopedName(DBConnection safiConn) {
    return safiConn.getDriver() == null ? safiConn.getName() : safiConn.getDriver().getName() + "."
        + safiConn.getName();
  }

  public Map<String, DBConnectionStats> getStats() {
    return stats;
  }

}
