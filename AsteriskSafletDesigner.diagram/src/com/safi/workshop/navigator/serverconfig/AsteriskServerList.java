/**
 * 
 */
package com.safi.workshop.navigator.serverconfig;

import java.util.ArrayList;
import java.util.List;

import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.SafiServer;

public class AsteriskServerList extends ArrayList<AsteriskServer> {
  /**
   * 
   */
  private static final long serialVersionUID = 6408958598023026615L;
  public SafiServer server;
  public boolean debug;
  public List<? extends AsteriskServer> original;

  public AsteriskServerList(List<? extends AsteriskServer> c, SafiServer server, boolean debug) {
    super(c);
    this.original = c;
    this.debug = debug;
    this.server = server;
  }

  public SafiServer getServer() {
    return server;
  }

  public boolean isDebug() {
    return debug;
  }

}