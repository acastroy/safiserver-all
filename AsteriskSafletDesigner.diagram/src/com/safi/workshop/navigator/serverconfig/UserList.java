/**
 * 
 */
package com.safi.workshop.navigator.serverconfig;

import java.util.ArrayList;
import java.util.List;

import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;

public class UserList extends ArrayList<User> {
  /**
   * 
   */
  private static final long serialVersionUID = -8280712609393329062L;
  public SafiServer server;
  public List<? extends User> original;

  public UserList(List<? extends User> c, SafiServer server) {
    super(c);
    this.original = c;
    this.server = server;
  }

  public SafiServer getServer() {
    return server;
  }

}