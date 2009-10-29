package com.safi.asterisk.handler.connection.sshd.j2ssh;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

import com.sshtools.daemon.configuration.ServerConfiguration;
import com.sshtools.daemon.session.SessionChannelServer;

public class J2SSHServerConfig extends ServerConfiguration {

  private static Log log = LogFactory.getLog(ServerConfiguration.class);
  private Map allowedSubsystems = new HashMap();
  private Map serverHostKeys = new HashMap();
  private List allowedAuthentications = new ArrayList();
  private List requiredAuthentications = new ArrayList();
  private int commandPort = 12222;
  private int port = 22;
  private String listenAddress = "0.0.0.0";
  private int maxConnections = 10;
  private int maxAuthentications = 5;
  private String terminalProvider = "";
  private String authorizationFile = "authorization.xml";
  private String userConfigDirectory = "%D/.ssh2";
  private String authenticationBanner = "";
  private boolean allowTcpForwarding = true;
  private Class sessionChannelImpl = SessionChannelServer.class;
  
  public J2SSHServerConfig() throws SAXException, ParserConfigurationException,
      IOException {
    super(null);
  }

  @Override
  public void reload(InputStream in) throws SAXException, ParserConfigurationException, IOException {
    
  }
  public Map getAllowedSubsystems() {
    return allowedSubsystems;
  }

  public void setAllowedSubsystems(Map allowedSubsystems) {
    this.allowedSubsystems = allowedSubsystems;
  }

  public Map getServerHostKeys() {
    return serverHostKeys;
  }

  public void setServerHostKeys(Map serverHostKeys) {
    this.serverHostKeys = serverHostKeys;
  }

  public List getAllowedAuthentications() {
    return allowedAuthentications;
  }

  public void setAllowedAuthentications(List allowedAuthentications) {
    this.allowedAuthentications = allowedAuthentications;
  }

  public List getRequiredAuthentications() {
    return requiredAuthentications;
  }

  public void setRequiredAuthentications(List requiredAuthentications) {
    this.requiredAuthentications = requiredAuthentications;
  }

  public int getCommandPort() {
    return commandPort;
  }

  public void setCommandPort(int commandPort) {
    this.commandPort = commandPort;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getListenAddress() {
    return listenAddress;
  }

  public void setListenAddress(String listenAddress) {
    this.listenAddress = listenAddress;
  }

  public int getMaxConnections() {
    return maxConnections;
  }

  public void setMaxConnections(int maxConnections) {
    this.maxConnections = maxConnections;
  }

  public int getMaxAuthentications() {
    return maxAuthentications;
  }

  public void setMaxAuthentications(int maxAuthentications) {
    this.maxAuthentications = maxAuthentications;
  }

  public String getTerminalProvider() {
    return terminalProvider;
  }

  public void setTerminalProvider(String terminalProvider) {
    this.terminalProvider = terminalProvider;
  }

  public String getAuthorizationFile() {
    return authorizationFile;
  }

  public void setAuthorizationFile(String authorizationFile) {
    this.authorizationFile = authorizationFile;
  }

  public String getUserConfigDirectory() {
    return userConfigDirectory;
  }

  public void setUserConfigDirectory(String userConfigDirectory) {
    this.userConfigDirectory = userConfigDirectory;
  }

  public String getAuthenticationBanner() {
    return authenticationBanner;
  }

  public void setAuthenticationBanner(String authenticationBanner) {
    this.authenticationBanner = authenticationBanner;
  }

  public boolean isAllowTcpForwarding() {
    return allowTcpForwarding;
  }

  public void setAllowTcpForwarding(boolean allowTcpForwarding) {
    this.allowTcpForwarding = allowTcpForwarding;
  }
  
  

}
