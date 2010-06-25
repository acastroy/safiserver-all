package com.safi.server.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.preferences.PreferenceConstants;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

  public PreferenceInitializer() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void initializeDefaultPreferences() {
    // TODO Auto-generated method stub

    IPreferenceStore store = getPreferenceStore();
    store.setDefault(PreferenceConstants.PREF_DB_PORT_PROD, 7021); //store.setDefault(PreferenceConstants.PREF_DB_PORT_PROD, 7021);
//    store.setDefault(PreferenceConstants.AST_DESCRIPTION_DEBUG, "Local debug Asterisk server");
//    store.setDefault(PreferenceConstants.PREF_AST_IP_DEBUG, "");
//    store.setDefault(PreferenceConstants.PREF_MGR_USER_DEBUG, "");
//    store.setDefault(PreferenceConstants.PREF_MGR_PWD_DEBUG, "");
//    store.setDefault(PreferenceConstants.PREF_MANAGER_PORT_DEBUG, 5038); //    store.setDefault(PreferenceConstants.PREF_MANAGER_PORT_DEBUG, 5038); 
//    store.setDefault(PreferenceConstants.AST_NAME_DEBUG, "Local"+SafiServerPlugin.AST_DEBUG_NAME_SUFFIX);
//    store.setDefault(PreferenceConstants.AST_SFTP_USER_DEBUG, "");
//    store.setDefault(PreferenceConstants.AST_SFTP_PASSWORD_DEBUG, "");
//    store.setDefault(PreferenceConstants.AST_SFTP_PORT_DEBUG, -1);
//    store.setDefault(PreferenceConstants.AST_ACTIVE_DEBUG, false);
//    store.setDefault(PreferenceConstants.PREF_AST_ID_DEBUG, -1);
//    store.setDefault(PreferenceConstants.AST_PRIVATE_DEBUG, true);
//    store.setDefault(PreferenceConstants.PREF_FASTAGI_PORT_DEBUG, 3573);//store.setDefault(PreferenceConstants.PREF_FASTAGI_PORT_DEBUG, 4573);
    store.setDefault(PreferenceConstants.PREF_SERVER_ERROR_NOTIFICATION, true);
    store.setDefault(PreferenceConstants.PREF_SERVER_INFO_NOTIFICATION, true);
    store.setDefault(PreferenceConstants.PREF_SERVER_TRACELOG_LEVEL, PreferenceConstants.PREF_LOG_LEVEL_DEBUG);
//    store.setDefault(PreferenceConstants.PREF_SERVER_MGT_PORT_DEBUG, 6020); // store.setDefault(PreferenceConstants.PREF_SERVER_MGT_PORT_DEBUG, 7020);
//    store.setDefault(PreferenceConstants.PREF_SAFI_BIND_ADDR_LOCAL, "0.0.0.0");
    store.setDefault(PreferenceConstants.PREF_SERVER_INFO_UPDATE_PERIOD, 30);
    store.setDefault(PreferenceConstants.PREF_SSH_SERVER_PORT, 8822);
//    store.setDefault(PreferenceConstants.PREF_PORT_FORWARDING_ENABLED, true);
  }

  protected IPreferenceStore getPreferenceStore() {
    return AsteriskDiagramEditorPlugin.getInstance().getPreferenceStore();
  }
}
