package com.safi.db.manager;

import java.util.logging.Logger;
import org.hibernate.dialect.HSQLDialect;

public class HSQLCachedTableDialect extends HSQLDialect{

	private final static Logger log = Logger.getLogger(HSQLCachedTableDialect.class.getName());

	public HSQLCachedTableDialect() {
	  super();
//	  registerColumnType( Types.BLOB, "org.hibernate.type.PrimitiveByteArrayBlobType" );
//		registerColumnType( Types.CLOB, "clob" );
//		registerColumnType( Types.BOOLEAN, "bit" );
  }
  @Override
  public String getCreateTableString() {
    return "create cached table";
  }
  
  @Override
  public boolean supportsExpectedLobUsagePattern() {
    // TODO Auto-generated method stub
  	return super.supportsExpectedLobUsagePattern();
//    return true;
  }
  
  @Override
  public boolean useInputStreamToInsertBlob() {
    // TODO Auto-generated method stub
    return super.useInputStreamToInsertBlob();
  }
  @Override
  public boolean supportsUnboundedLobLocatorMaterialization() {
    // TODO Auto-generated method stub
    return super.supportsUnboundedLobLocatorMaterialization();
  }
  
  @Override
  public boolean supportsLobValueChangePropogation() {
    // TODO Auto-generated method stub
    return super.supportsLobValueChangePropogation();
  }
  
//  public LockingStrategy getLockingStrategy(Lockable lockable, LockMode lockMode) {
//  	return new SelectLockingStrategy( lockable, lockMode );
//	}

}
