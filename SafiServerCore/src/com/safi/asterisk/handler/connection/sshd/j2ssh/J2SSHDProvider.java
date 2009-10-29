package com.safi.asterisk.handler.connection.sshd.j2ssh;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.safi.asterisk.handler.SafletEngine;
import com.safi.asterisk.handler.connection.SSHDProvider;
import com.safi.asterisk.handler.connection.sshd.SSHUtils;
import com.sshtools.daemon.SshDaemon;
import com.sshtools.daemon.configuration.AllowedSubsystem;
import com.sshtools.daemon.configuration.PlatformConfiguration;
import com.sshtools.daemon.configuration.ServerConfiguration;
import com.sshtools.j2ssh.configuration.ConfigurationContext;
import com.sshtools.j2ssh.configuration.ConfigurationException;
import com.sshtools.j2ssh.configuration.ConfigurationLoader;
import com.sshtools.j2ssh.transport.publickey.InvalidSshKeyException;
import com.sshtools.j2ssh.transport.publickey.SshPrivateKey;
import com.sshtools.j2ssh.transport.publickey.SshPrivateKeyFile;

public class J2SSHDProvider implements SSHDProvider {
  private final static Logger log = Logger.getLogger(J2SSHDProvider.class);
  private boolean deniedKEXAllowed;
  private String host;
  private int port = 22;
  private J2SSHServerConfig serverConfig;
  private J2SSHPlatformConfig platformConfig;

  @Override
  public void setAllowDeniedKEX(boolean b) {
    this.deniedKEXAllowed = b;

  }

  @Override
  public void setSSHHost(String host) {
    this.host = host;

  }

  @Override
  public void setSSHPort(int port) {
    this.port = port;

  }

  @Override
  public void start() throws IOException {

    try {

      serverConfig = new J2SSHServerConfig();
      serverConfig.setAllowedAuthentications(Arrays.asList("password", "publickey"));

      Map<String, AllowedSubsystem> subsys = new HashMap<String, AllowedSubsystem>();
//      subsys.put("sftp", new AllowedSubsystem("class", "sftp",
//          "com.sshtools.j2ssh.sftp.SftpSubsystemServer"));

      serverConfig.setAllowedSubsystems(subsys);
      serverConfig.setAllowTcpForwarding(true);
//      serverConfig.setAuthenticationBanner("Welcome to SafiServer");
      serverConfig.setCommandPort(SSHUtils.findFreePort());
//      serverConfig.setUserConfigDirectory("resources");
      serverConfig.setListenAddress(host);
      serverConfig.setMaxConnections(50);
      serverConfig.setPort(port);
      serverConfig.setAuthorizationFile("resources/authorization.xml");
      serverConfig.setRequiredAuthentications(Arrays.asList("password"));
      serverConfig.setBlocking(false);
      Map<String, SshPrivateKey> serverHostKeys = new HashMap<String, SshPrivateKey>();
//      addKey(serverHostKeys, "resources/ssh_host_dsa_key");
      addKey(serverHostKeys, SafletEngine.HOST_KEY_NAME);
      serverConfig.setServerHostKeys(serverHostKeys);

      platformConfig = new J2SSHPlatformConfig();
      platformConfig.setNativeAuthenticationProvider("com.safi.asterisk.handler.connection.sshd.j2ssh.J2SSHNativeAuthProvider");
//      platformConfig.setNativeFileSystemProvider("com.sshtools.daemon.vfs.VirtualFileSystem");
      DefaultConfigurationContext context = new DefaultConfigurationContext();
      ConfigurationLoader.initialize(true, context);

      SshDaemon.start();

    } catch (Exception e) {
      e.printStackTrace();
      log.error("Couldn't Start SSHD service", e);
    }

  }

  public void addKey(Map<String, SshPrivateKey> serverHostKeys, String privateKey) {
    File f = new File(privateKey);
    if (!f.exists()) {
      privateKey = ConfigurationLoader.getConfigurationDirectory() + privateKey;
      f = new File(privateKey);
    }

    try {
      if (f.exists()) {
        SshPrivateKeyFile pkf = SshPrivateKeyFile.parse(f);
        SshPrivateKey key = pkf.toPrivateKey(SafletEngine.DEFAULT_KEY_PASSPHRASE);
        serverHostKeys.put(key.getAlgorithmName(), key);
      } else {
        log.warn("Private key file '" + privateKey + "' could not be found");
      }
    } catch (InvalidSshKeyException ex) {
      log.warn("Failed to load private key '" + privateKey, ex);
    } catch (IOException ioe) {
      log.warn("Failed to load private key '" + privateKey, ioe);
    }
  }

  @Override
  public void stop() throws IOException {
    if (serverConfig != null) {
      SshDaemon.stop("SafiServer SSHD is stopping");
      serverConfig = null;
      platformConfig = null;
    }
  }

  class DefaultConfigurationContext implements ConfigurationContext {
    public void initialize() throws ConfigurationException {
      // Do nothing
    }

    public boolean isConfigurationAvailable(Class cls) {
      return cls == ServerConfiguration.class || cls == PlatformConfiguration.class;
    }

    public Object getConfiguration(Class cls) throws ConfigurationException {
      if (cls == ServerConfiguration.class)
        return serverConfig;
      else if (cls == PlatformConfiguration.class)
        return platformConfig;

      throw new ConfigurationException("Default configuration does not contain " + cls.getName());
    }
  }
}
