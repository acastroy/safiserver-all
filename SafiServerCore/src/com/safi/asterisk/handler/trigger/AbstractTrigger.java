package com.safi.asterisk.handler.trigger;

import org.hsqldb.Trigger;

public abstract class AbstractTrigger implements Trigger {

  public static String getWhenSpec(int type) {

    switch (type) {

      case INSERT_BEFORE:
      case INSERT_BEFORE_ROW:
      case UPDATE_BEFORE:
      case UPDATE_BEFORE_ROW:
      case DELETE_BEFORE:
      case DELETE_BEFORE_ROW: {
        return "BEFORE";
      }
      case INSERT_AFTER:
      case INSERT_AFTER_ROW:
      case UPDATE_AFTER:
      case UPDATE_AFTER_ROW:
      case DELETE_AFTER:
      case DELETE_AFTER_ROW: {
        return "AFTER";
      }
      default: {
        return "";
      }
    }
  }

  public static String getOperationSpec(int type) {

    switch (type) {

      case INSERT_AFTER:
      case INSERT_AFTER_ROW:
      case INSERT_BEFORE:
      case INSERT_BEFORE_ROW: {
        return "INSERT";
      }
      case UPDATE_AFTER:
      case UPDATE_AFTER_ROW:
      case UPDATE_BEFORE:
      case UPDATE_BEFORE_ROW: {
        return "UPDATE";
      }
      case DELETE_AFTER:
      case DELETE_AFTER_ROW:
      case DELETE_BEFORE:
      case DELETE_BEFORE_ROW: {
        return "DELETE";
      }
      default: {
        return "";
      }
    }
  }

  public static String getQueueSpec(int qs) {
    return (qs < 0) ? "" : ("QUEUE " + qs);
  }

  public static String getForEachSpec(int type) {

    switch (type) {

      case INSERT_BEFORE_ROW:
      case INSERT_AFTER_ROW:
      case UPDATE_BEFORE_ROW:
      case UPDATE_AFTER_ROW:
      case DELETE_AFTER_ROW:
      case DELETE_BEFORE_ROW: {
        return "FOR EACH ROW";
      }
      default: {
        return "";
      }
    }
  }

  public static String getTriggerDDL(String trn, int typ, String tab, int qs, String impl) {

    StringBuffer sb = new StringBuffer();

    sb.append("CREATE TRIGGER ");
    sb.append(trn);
    sb.append(' ');
    sb.append(getWhenSpec(typ));
    sb.append(' ');
    sb.append(getOperationSpec(typ));
    sb.append(" ON ");
    sb.append(tab);
    sb.append(' ');
    sb.append(getForEachSpec(typ));
    sb.append(' ');
    sb.append(getQueueSpec(qs));
    sb.append(" CALL \"");
    sb.append(impl);
    sb.append("\"");

    return sb.toString();
  }

  public static String getTriggerDescriptor(String trn, int typ, String tab) {

    StringBuffer sb = new StringBuffer();

    sb.append("TRIGGER : ");
    sb.append(trn);
    sb.append(' ');
    sb.append(getWhenSpec(typ));
    sb.append(' ');
    sb.append(getOperationSpec(typ));
    sb.append(" ON ");
    sb.append(tab);
    sb.append(' ');
    sb.append(getForEachSpec(typ));

    return sb.toString();
  }

  public static boolean isDeleteTrigger(int triggerType) {
    return triggerType == DELETE_AFTER || triggerType == DELETE_AFTER_ROW
        || triggerType == DELETE_BEFORE || triggerType == DELETE_BEFORE_ROW;
  }

}
