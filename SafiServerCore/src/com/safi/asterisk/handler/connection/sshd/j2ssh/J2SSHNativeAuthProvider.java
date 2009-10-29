package com.safi.asterisk.handler.connection.sshd.j2ssh;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.db.server.config.User;
import com.sshtools.daemon.platform.NativeAuthenticationProvider;
import com.sshtools.daemon.platform.PasswordChangeException;

public class J2SSHNativeAuthProvider extends NativeAuthenticationProvider {
  private final static Logger log = Logger.getLogger(J2SSHNativeAuthProvider.class);

  @Override
  public boolean changePassword(String username, String oldpassword, String newpassword) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public String getHomeDirectory(String username) throws IOException {
    return System.getProperty("user.dir");
  }

  @Override
  public void logoffUser() throws IOException {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean logonUser(String username) throws IOException {
    return false;
  }

  @Override
  public boolean logonUser(String username, String password) throws PasswordChangeException,
      IOException {
    System.err.println("loggin on user " + username + " wit pass " + password);
    try {
      User user = DBManager.getInstance().getUserByUsername(username);
      if (user == null)
        return false;
      return StringUtils.equals(password, user.getPassword());
    } catch (DBManagerException e) {
      e.printStackTrace();
    }
    return false;
  }

}
