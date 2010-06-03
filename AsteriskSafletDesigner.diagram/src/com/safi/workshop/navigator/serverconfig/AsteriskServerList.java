/**
 * 
 */
package com.safi.workshop.navigator.serverconfig;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;

public class AsteriskServerList extends ArrayList<AsteriskServer> {
  /**
   * 
   */
  private static final long serialVersionUID = 6408958598023026615L;
  private SoftReference<SafiServer> server;
//  public List<? extends AsteriskServer> original;

  public AsteriskServerList(List<? extends AsteriskServer> c, SafiServer server) {
    super(c);
//    this.original = c;
    this.server = new SoftReference<SafiServer>(server);
  }

  public SafiServer getServer() {
    return server.get();
  }
  
  public void setSafiServer(SafiServer server){
  	this.server = new SoftReference<SafiServer>(server);
  }
  
  public void replace(List<? extends AsteriskServer> c) {
  	clear();
  	addAll(c);
  }
  
  @Override
  public int hashCode() {
  	if (isEmpty())
  		return HashCodeBuilder.reflectionHashCode(this);
  	return super.hashCode();
  }

}