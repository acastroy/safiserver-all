package com.safi.workshop.importwiz;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.Query;
import com.safi.db.SafiDriverManager;

public class ImportUtils {

  public static boolean mergeDriverManager(Shell shell, SafiDriverManager driverManager,
      SafiDriverManager newManager) {
    boolean cancel = false, skipAll = false, mergeAll = false, renameAll = false, overwriteAll = false;
    List<DBDriver> drivers = new ArrayList<DBDriver>(newManager.getDrivers());
    for (DBDriver drv : drivers) {
      DBDriver existing = driverManager.getDriver(drv.getName());
      if (existing != null) {
        if (!StringUtils.equals(drv.getDriverClassName(), existing.getDriverClassName())) {
          String newname = getNewDriverName(drv.getName(), driverManager);
          if (!renameAll) {
            MessageDialog dlg = new MessageDialog(shell, "Resource Exists", null,
                "Driver with name " + existing.getName()
                    + " exists but points to a different database driver. It will be renamed to "
                    + newname, MessageDialog.INFORMATION, new String[] { "OK",
                    "Don't show this again" }, 0);
            int result = dlg.open();
            if (result == 1)
              renameAll = true;
          }
          drv.setName(newname);
          driverManager.getDrivers().add(drv);
        } else {
          boolean merge = mergeAll;
          boolean overwrite = overwriteAll;
          cancel = false;
          boolean skip = skipAll;
          if (!mergeAll && !skipAll && !overwriteAll) {
            MessageDialog dlg = new MessageDialog(shell, "Driver Exists", null, "Driver with name "
                + existing.getName() + " exists. Do you wish to skip, overwrite, or merge? ",
                MessageDialog.QUESTION, new String[] { "Skip", "Skip all", "Merge", "Merge all",
                    "Overwrite", "Overwrite All", "Cancel" }, 4);
            int result = dlg.open();

            switch (result) {
              case 0:
                skip = true;
                break;
              case 1:
                skipAll = true;
                break;
              case 2:
                merge = true;
                break;
              case 3:
                merge = mergeAll = true;
                break;
              case 4:
                overwrite = true;
                break;
              case 5:
                overwrite = overwriteAll = true;
                break;
              case 6:
                cancel = true;
            }

            if (cancel) {
              break;
            }
            if (skip)
              continue;

          }
          if (overwrite) {
            driverManager.getDrivers().remove(existing);
            driverManager.getDrivers().add(drv);
            drv.setLastModified(new Date());
            continue;
          } else // merge
          {
            cancel = mergeDrivers(shell, existing, drv, skipAll, skip, mergeAll, merge, renameAll,
                overwriteAll, overwrite);
            existing.setLastModified(new Date());
            if (cancel)
              break;
          }
          continue;
        }
      } else {
        driverManager.getDrivers().add(drv);
        driverManager.setLastModified(new Date());
        drv.setLastModified(new Date());
      }
    }
    return cancel;
  }

  public static boolean mergeDrivers(Shell shell, DBDriver existingDriver, DBDriver drv,
      boolean skipAll, boolean skip, boolean mergeAll, boolean merge, boolean renameAll,
      boolean overwriteAll, boolean overwrite) {
    boolean cancel = false;
    List<DBConnection> connections = new ArrayList<DBConnection>(drv.getConnections());
    for (DBConnection conn : connections) {
      DBConnection existing = existingDriver.getConnection(conn.getName());
      if (existing != null) {
        if (!StringUtils.equals(conn.getUrl(), existing.getUrl())) {
          String newname = getNewConnectionName(existing.getName(), existingDriver);
          if (!renameAll) {
            MessageDialog dlg = new MessageDialog(shell, "Resource Exists", null,
                "Database connection with name " + existing.getName()
                    + " exists but points to a different database resource. It will be renamed to "
                    + newname, MessageDialog.INFORMATION, new String[] { "OK",
                    "Don't show this again" }, 0);
            int result = dlg.open();
            if (result == 1)
              renameAll = true;
          }
          conn.setName(newname);
          existingDriver.getConnections().add(conn);
        } else {
          merge = mergeAll;
          overwrite = overwriteAll;

          skip = skipAll;
          if (!mergeAll && !skipAll && !overwriteAll) {
            MessageDialog dlg = new MessageDialog(shell, "DB Connection Exists", null,
                "Database connection with name " + existing.getName()
                    + " exists. Do you wish to skip, overwrite, or merge? ",
                MessageDialog.QUESTION, new String[] { "Skip", "Skip all", "Merge", "Merge all",
                    "Overwrite", "Overwrite All", "Cancel" }, 4);
            int result = dlg.open();

            switch (result) {
              case 0:
                skip = true;
                break;
              case 1:
                skipAll = true;
                break;
              case 2:
                merge = true;
                break;
              case 3:
                merge = mergeAll = true;
                break;
              case 4:
                overwrite = true;
                break;
              case 5:
                overwrite = overwriteAll = true;
                break;
              case 6:
                cancel = true;
            }

            if (cancel) {
              break;
            }
            if (skip)
              continue;

          }
          if (overwrite) {
            existingDriver.getConnections().remove(existing);
            existingDriver.getConnections().add(conn);
            conn.setLastModified(new Date());
            continue;
          } else // merge
          {
            cancel = mergeConnections(shell, existing, conn, skipAll, skip, mergeAll, merge,
                renameAll, overwriteAll, overwrite);
            if (cancel)
              break;
            existing.setLastModified(new Date());
          }
          continue;
        }
      } else {
        existingDriver.getConnections().add(conn);
        existingDriver.setLastModified(new Date());
        conn.setLastModified(new Date());
      }
    }
    return cancel;
  }

  public static boolean mergeConnections(Shell shell, DBConnection existingConnection,
      DBConnection conn, boolean skipAll, boolean skip, boolean mergeAll, boolean merge,
      boolean renameAll, boolean overwriteAll, boolean overwrite) {
    boolean cancel = false;
    List<Query> queries = new ArrayList<Query>(existingConnection.getQueries());
    for (Query query : queries) {
      Query existing = existingConnection.getQuery(query.getName());
      if (existing != null) {
        if (!StringUtils.equals(query.getQuerySql(), existing.getQuerySql())) {
          String newname = getNewQueryName(existing.getName(), existingConnection);
          if (!renameAll) {
            MessageDialog dlg = new MessageDialog(shell, "Resource Exists", null,
                "Database query with name " + existing.getName()
                    + " exists but contains different sql code. It will be renamed to " + newname,
                MessageDialog.INFORMATION, new String[] { "OK", "Don't show this again" }, 0);
            int result = dlg.open();
            if (result == 1)
              renameAll = true;
          }
          query.setName(newname);
          existingConnection.getQueries().add(query);
        } else {
          overwrite = overwriteAll;

          skip = skipAll;
          if (!skipAll && !overwriteAll) {
            MessageDialog dlg = new MessageDialog(shell, "DB Query Exists", null,
                "Database query with name " + existing.getName()
                    + " exists. Do you wish to skip or overwrite? ", MessageDialog.QUESTION,
                new String[] { "Skip", "Skip all", "Overwrite", "Overwrite All", "Cancel" }, 4);
            int result = dlg.open();

            switch (result) {
              case 0:
                skip = true;
                break;
              case 1:
                skipAll = true;
                break;
              case 2:
                overwrite = true;
                break;
              case 3:
                overwrite = overwriteAll = true;
                break;
              case 4:
                cancel = true;
            }

            if (cancel) {
              break;
            }
            if (skip)
              continue;

          }
          if (overwrite) {
            existingConnection.getQueries().remove(existing);
            existingConnection.getQueries().add(query);
            query.setLastModified(new Date());
            existingConnection.setLastModified(new Date());
            continue;
          }
          continue;
        }
      } else {
        existingConnection.getQueries().add(query);
        existingConnection.setLastModified(new Date());
        query.setLastModified(new Date());
      }
    }

    return cancel;
  }

  public static String getNewQueryName(String prefix, DBConnection existingConnection) {
    int i = 0;
    while (existingConnection.getQuery(prefix + ++i) != null)
      ;
    return prefix + i;
  }

  public static String getNewConnectionName(String prefix, DBDriver existing) {
    int i = 0;
    while (existing.getConnection(prefix + ++i) != null)
      ;
    return prefix + i;
  }

  public static String getNewDriverName(String prefix, SafiDriverManager driverManager) {
    int i = 0;
    while (driverManager.getDriver(prefix + ++i) != null)
      ;
    return prefix + i;
  }

}
