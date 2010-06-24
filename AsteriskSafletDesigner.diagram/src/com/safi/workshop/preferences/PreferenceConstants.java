package com.safi.workshop.preferences;

import java.util.logging.Level;

public interface PreferenceConstants {
  public static final String PREF_AUDIO_INPUT_DEVICE = "PREF_AUDIO_INPUT_DEVICE";
  public static final String PREF_AUDIO_OUTPUT_DEVICE = "PREF_AUDIO_OUTPUT_DEVICE";
  public static final String PREF_AUDIO_INPUT_DEVICE_STRING = "PREF_AUDIO_INPUT_DEVICE_STRING";
  public static final String PREF_AUDIO_OUTPUT_DEVICE_STRING = "PREF_AUDIO_OUTPUT_DEVICE_STRING";
  
  public static final String PREF_SAFISERVER_HOSTNAME_PROD = "safiServerHostname";

	public static final String PREF_SAFISERVER_USER_PROD = "safiServerUsername";

	public static final String PREF_SAFISERVER_PASS_PROD = "safiServerPassword";

	public static final String PREF_DB_PORT_PROD = "PREF_DB_PORT";
	
	public static final String PREF_SAFISERVER_ID="PREF_SAFISERVER_ID";
  
  public static final String PREF_SERVER_ERROR_NOTIFICATION = "PREF_SERVER_ERROR_NOTIFICATION";
  public static final String PREF_SERVER_INFO_NOTIFICATION = "PREF_SERVER_INFO_NOTIFICATION";

  public static final String PREF_SERVER_TRACELOG_LEVEL  =  "PREF_SERVER_TRACELOG_LEVEL";
  public static final String PREF_LOG_LEVEL_OFF   = Level.OFF.toString();
  public static final String PREF_LOG_LEVEL_DEBUG = Level.FINEST.toString();
  public static final String PREF_LOG_LEVEL_INFO  = Level.INFO.toString();
  public static final String PREF_LOG_LEVEL_WARN  = Level.WARNING.toString();
  public static final String PREF_LOG_LEVEL_ERROR = Level.SEVERE.toString();
  
  public static final String PREF_SERVER_INFO_UPDATE_PERIOD = "PREF_SERVER_INFO_UPDATE_PERIOD";

  public static final String PREF_ACTIONSTEPS_MINIMIZED = "PREF_ACTIONSTEPS_MINIMIZED";

  public static final String PREF_SSH_SERVER_PORT="PREF_SSH_SERVER_PORT";
  
  public static final  String KEY_SSH2HOME="SSH2HOME"; //$NON-NLS-1$ 
}
