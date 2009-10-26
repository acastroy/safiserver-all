package com.safi.db.manager;

import org.hibernate.dialect.HSQLDialect;

public class HSQLCachedTableDialect extends HSQLDialect{


  @Override
  public String getCreateTableString() {
    return "create cached table";
  }
}
