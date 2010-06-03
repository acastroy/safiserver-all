/**
 * 
 */
package com.safi.workshop.navigator.serverconfig;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.safi.db.server.config.FreeSwitchServer;
import com.safi.db.server.config.SafiServer;

public class FreeSwitchServerList extends ArrayList<FreeSwitchServer> {
  /**
	 * 
	 */
	private static final long serialVersionUID = -8509126641957856525L;
	/**
   * 
   */
	private SoftReference<SafiServer> server;
//  public List<? extends FreeSwitchServer> original;

  public FreeSwitchServerList(List<? extends FreeSwitchServer> c, SafiServer server) {
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
  
  public void replace(List<? extends FreeSwitchServer> c) {
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