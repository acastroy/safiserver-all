/**
 * 
 */
package com.safi.workshop.navigator.serverconfig;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.HashCodeBuilder;

import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;

public class UserList extends ArrayList<User> {
  /**
   * 
   */
  private static final long serialVersionUID = -8280712609393329062L;
  private SoftReference<SafiServer> server;
//  public List<? extends User> original;

  public UserList(List<? extends User> c, SafiServer server) {
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
  
  public void replace(List<? extends User> c) {
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