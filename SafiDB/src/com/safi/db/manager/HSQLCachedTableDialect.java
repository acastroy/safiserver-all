package com.safi.db.manager;

import java.io.Serializable;
import java.sql.Types;
import org.apache.log4j.Logger;
import org.hibernate.JDBCException;
import org.hibernate.LockMode;
import org.hibernate.StaleObjectStateException;
import org.hibernate.dialect.HSQLDialect;
import org.hibernate.dialect.HSQLDialect.ReadUncommittedLockingStrategy;
import org.hibernate.dialect.lock.LockingStrategy;
import org.hibernate.dialect.lock.SelectLockingStrategy;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.persister.entity.Lockable;

public class HSQLCachedTableDialect extends HSQLDialect{

	private final static Logger log = Logger.getLogger(HSQLCachedTableDialect.class);

	public HSQLCachedTableDialect() {
	  super();
//	  registerColumnType( Types.BLOB, "org.hibernate.type.PrimitiveByteArrayBlobType" );
		registerColumnType( Types.CLOB, "clob" );
		registerColumnType( Types.BOOLEAN, "bit" );
  }
  @Override
  public String getCreateTableString() {
    return "create cached table";
  }
  
  @Override
  public boolean supportsExpectedLobUsagePattern() {
    // TODO Auto-generated method stub
//  	return super.supportsExpectedLobUsagePattern()
    return true;
  }
  
  @Override
  public boolean useInputStreamToInsertBlob() {
    // TODO Auto-generated method stub
    return true;
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
  
  public LockingStrategy getLockingStrategy(Lockable lockable, LockMode lockMode) {
  	return new SelectLockingStrategy( lockable, lockMode );
	}

}
