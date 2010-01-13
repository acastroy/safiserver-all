package com.safi.workshop.sqlexplorer.parsers;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class QueryParameter {

  // private int sqlType = java.sql.Types.OTHER;
  private String name;
  private DataType type;
  private static final DateFormat DATETIME_FMT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
  private static final DateFormat DATE_FMT = new SimpleDateFormat("yyyy-MM-dd");
  private static final DateFormat TIME_FMT = new SimpleDateFormat("HH:mm:ss.SSSZ");

  public enum DataType {
    TEXT, DATE, DATETIME, TIME, INTEGER, LONG, DOUBLE, CLOB, BLOB, ARRAY;
  }

  public QueryParameter(String name, DataType type) {
    this.type = type;
    this.name = name;
  }

  public static int getSqlType(DataType type) {
    switch (type) {
      case ARRAY:
        return java.sql.Types.ARRAY;
      case BLOB:
        return java.sql.Types.BLOB;
      case CLOB:
        return java.sql.Types.CLOB;
      case DATE:
        return java.sql.Types.DATE;
      case DATETIME:
        return java.sql.Types.TIMESTAMP;
      case DOUBLE:
        return java.sql.Types.DOUBLE;
      case INTEGER:
        return java.sql.Types.INTEGER;
      case LONG:
        return java.sql.Types.BIGINT;
      case TEXT:
        return java.sql.Types.VARCHAR;
      case TIME:
        return java.sql.Types.TIME;

    }
    return java.sql.Types.OTHER;
  }

  public static String getDefaultValue(DataType type) {
    switch (type) {
      case ARRAY:
        return "[]";
      case BLOB:
      case CLOB:
        return "";
      case DATE:
        return DATE_FMT.format(new Date());
      case DATETIME:
        return DATETIME_FMT.format(new Date());
      case DOUBLE:
        return "0.0";
      case INTEGER:
      case LONG:
        return "0";
      case TEXT:
        return "";
      case TIME:
        return TIME_FMT.format(new Date());
    }
    return "";
  }

  public static Object getValueFromString(DataType type, String value) throws ParseException,
      NumberFormatException {
    switch (type) {
      case ARRAY:
      case BLOB:
      case CLOB:
        return null;
      case DATE:
        return new java.sql.Date(DATE_FMT.parse(value).getTime());
      case DATETIME:
        return new java.sql.Date(DATETIME_FMT.parse(value).getTime());
      case DOUBLE:
        return new Double(value);
      case INTEGER:
        return new Integer(value);
      case LONG:
        return new Long(value);
      case TEXT:
        return value;
      case TIME:
        return new Timestamp(TIME_FMT.parse(value).getTime());
    }
    return "";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public boolean equals(Object obj) {
    return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }

  public DataType getType() {
    return type;
  }

  public void setType(DataType type) {
    this.type = type;
  }

}
