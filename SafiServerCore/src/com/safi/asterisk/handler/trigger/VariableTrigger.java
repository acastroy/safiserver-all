package com.safi.asterisk.handler.trigger;

import org.apache.log4j.Logger;

import com.safi.asterisk.handler.DBResourceTrigger;
import com.safi.asterisk.handler.GlobalVariableManager;
import com.safi.asterisk.handler.SafletEngine;
import com.safi.db.Variable;

public class VariableTrigger extends AbstractTrigger {

  private final static Logger log = Logger.getLogger(DBResourceTrigger.class);

  public VariableTrigger() {

  }

  public void fire(int triggerType, String triggerName, String tableName, Object[] oldRow,
      Object[] newRow) {

    synchronized (VariableTrigger.class) {
      if ("variable".equals(tableName)) {
        handleVarChange(triggerType, newRow, oldRow);
      }
    }
  }

  private void handleVarChange(final int triggerType, final Object[] newRow, final Object[] oldRow) {
//    if (isDeleteTrigger(triggerType))
//      return;
    final String name = newRow == null ? null : (String) newRow[0];
    final String oldname = oldRow != null ? (String)oldRow[0] : null;
    
    
    Runnable runnable = new Runnable(){
      @Override
      public void run() {
        
        try {
          // TODO Auto-generated method stub
          
          switch (triggerType) {
            case DELETE_BEFORE:
            case DELETE_BEFORE_ROW:
            {
              GlobalVariableManager.getInstance().globalVariableRemoved(name);
              break;
            }
            case INSERT_AFTER:
            case INSERT_AFTER_ROW:
            {
              GlobalVariableManager.getInstance().globalVariableAdded(name);
              break;
            }
            case UPDATE_AFTER:
            case UPDATE_AFTER_ROW: {
//              Variable var = GlobalVariableManager.getInstance().getGlobalVariable(oldname, true);
//              if (var == null) {
//                log.error("Couldn't find updated variable with name "+oldname);
//                return;
//              }
              
              GlobalVariableManager.getInstance().updateVariable(oldname, name);
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
