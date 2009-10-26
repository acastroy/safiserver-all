package com.safi.db.manager;

import org.apache.commons.lang.StringUtils;

import com.safi.db.server.config.Entitlement;
import com.safi.db.server.config.Role;
import com.safi.db.server.config.User;

public class EntitlementUtils {

  public final static String ENTIT_RETRIEVE_SAFLETS = "Retrieve Saflets";
  public final static String ENTIT_PUBLISH_SAFLETS = "Publish Saflets";
  public final static String ENTIT_UPDATE_SERVER = "Update Server";
  public final static String ENTIT_MANAGE_PROMPTS = "Manage Prompts";
  public final static String ENTIT_MANAGE_USERS = "Manage Users";
  public final static String ENTIT_MANAGE_ASTERISK_SERVERS = "Manage Asterisk Servers";
  public final static String ENTIT_RETRIEVE_DB_RESOURCES = "Retrieve DB Resources";
  public final static String ENTIT_PUBLISH_DB_RESOURCES = "Publish DB Resources";
  
  public static boolean isUserEntitled(User user, String entitlementName) {
    if (user!= null) {
      for (Role role : user.getRoles()) {
        for (Entitlement entitlement : role.getEntitlements()){
          if (StringUtils.equals(entitlementName, entitlement.getName()))
            return true;
        }
      }
    }
    return false;
  }
  
  
}
