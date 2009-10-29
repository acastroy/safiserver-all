package com.safi.asterisk.handler.connection.sshd.maverick;

import java.io.File;
import java.io.IOException;

import com.maverick.nio.Daemon;
import com.maverick.nio.DaemonContext;
import com.maverick.ssh.SshException;
import com.maverick.sshd.AuthorizedKeysStoreImpl;
import com.maverick.sshd.SshContext;
import com.maverick.sshd.events.EventLog;
import com.maverick.sshd.platform.AuthenticationProvider;
import com.maverick.sshd.scp.ScpCommand;
import com.maverick.sshd.vfs.VirtualFileSystem;
import com.safi.asterisk.handler.connection.SSHDProvider;
import com.sshtools.publickey.InvalidPassphraseException;
import com.sshtools.publickey.SshKeyPairGenerator;

public class MaverickSSHProvider  extends Daemon implements SSHDProvider  {

  private boolean deniedKEXAllowed;
  private String host;
  private int port = 22;
  private String authorizedKeysFile=null;
  private String preferredKeyExchange=null;
  
  public void useThisAuthorizedKeysFile(String filepath) {
    this.authorizedKeysFile=filepath;
  }
  public void setPreferredKeyExchange(String preferredKeyExchange){
    this.preferredKeyExchange=preferredKeyExchange;
  }

  private int authmethods=SshContext.ANY;
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
    this.port  = port;

  }

  @Override
  public void start() throws IOException {
    super.startup();
    
  }

  @Override
  public void stop() throws IOException{
    if (super.isStarted())
      super.shutdown();
    
  }

  @Override
  protected void configure(DaemonContext context) throws IOException {

    /* DEBUG */ EventLog.LogEvent(this,"Configuring Example SSHD");
    
    SshContext sshContext = new SshContext(this);
  
    // Use one of the following to set a preferred key exchange
  try {
    //sshContext.setPreferredKeyExchange(SshContext.KEX_DIFFIE_HELLMAN_GROUP14_SHA1);
    sshContext.setPreferredKeyExchange(SshContext.KEX_DIFFIE_HELLMAN_GROUP1_SHA1);
    //sshContext.setPreferredKeyExchange(SshContext.KEX_DIFFIE_HELLMAN_GROUP_EXCHANGE_SHA1);
  } catch (SshException e1) {
    throw new IOException("Could not set preferred key exchange");
  }
  
  // Use the following to set the preferred ciphers for both client->server and
  // server->client streams
  try {
    sshContext.setPreferredCipherCS(SshContext.CIPHER_AES128_CBC);
    sshContext.setPreferredCipherSC(SshContext.CIPHER_AES128_CBC);
    
    //sshContext.setPreferredCipherCS(SshContext.CIPHER_AES192_CBC);
    //sshContext.setPreferredCipherSC(SshContext.CIPHER_AES192_CBC);
    
    //sshContext.setPreferredCipherCS(SshContext.CIPHER_AES256_CBC);
    //sshContext.setPreferredCipherSC(SshContext.CIPHER_AES256_CBC);
    
    //sshContext.setPreferredCipherCS(SshContext.CIPHER_BLOWFISH_CBC);
    //sshContext.setPreferredCipherSC(SshContext.CIPHER_BLOWFISH_CBC);
    
    //sshContext.setPreferredCipherCS(SshContext.CIPHER_TRIPLEDES_CBC);
    //sshContext.setPreferredCipherSC(SshContext.CIPHER_TRIPLEDES_CBC);
    
  } catch (SshException e1) {
    throw new IOException("Could not set preferred cipher");
  }
  
  // Use the following to set the preferred hmacs for both client->server and
  // server->client streams
  try {
    sshContext.setPreferredMacCS(SshContext.HMAC_MD5);
    sshContext.setPreferredMacSC(SshContext.HMAC_MD5);
    
    //sshContext.setPreferredMacCS(SshContext.HMAC_SHA1);
    //sshContext.setPreferredMacSC(SshContext.HMAC_SHA1);
  } catch (SshException e1) {
    throw new IOException("Could not set preferred hmac");
  }
  
  
  if(authorizedKeysFile!=null) {
    sshContext.setPublicKeyStore(new AuthorizedKeysStoreImpl(authorizedKeysFile));
    sshContext.addRequiredAuthentication(SshContext.PUBLICKEY_AUTHENTICATION);
  }
  
  sshContext.setChannelLimit(1000);
  
    // Add an RSA key and preferably a DSA key as well to avoid connection
    // errors with clients that only support one key type (F-Secure 4.3 for example)
    try {
      try {
        
        sshContext.loadOrGenerateHostKey(new File("ssh_host_rsa_key"),
                            SshKeyPairGenerator.SSH2_RSA,
                            1024);

        sshContext.loadOrGenerateHostKey(new File("ssh_host_dsa_key"),
                                SshKeyPairGenerator.SSH2_DSA,
                                1024);
        
      } catch (SshException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      
    } catch(InvalidPassphraseException ex) { }

    // Listen on multiple ports (on all interfaces)
    context.addListeningInterface(host, 22, sshContext);
    if(port!=-1){
      context.addListeningInterface(host, port, sshContext);
    }
    
    //    context.addListeningInterface("::", 10022,sshContext);

    // Setup an authentication banner
    sshContext.setBannerMessage("Welcome To SafiServer");

    // Setup the authentication provider
    /* DEBUG */ EventLog.LogDebugEvent(this,"setting authentication provider");
    AuthenticationProvider authProv;
    try {
      authProv = new AuthenticationProvider(new ExampleAuthenticationProvider(), sshContext);
    } catch (Exception ex) {
        throw new IOException(ex.getMessage());
    }
    sshContext.setAuthenticationProvider(authProv);
    /* DEBUG */ EventLog.LogDebugEvent(this,"authentication provider set");

    // Setup the process provider (you can alternativley use setShellCommand
    // if you dont want to extend SessionChannel
    sshContext.setSessionProvider(ExampleSession.class);
    
    // Tell the SSHD which file system were using
    sshContext.setFileSystemProvider(VirtualFileSystem.class);

    // Using asynchronous file operations will create a thread for each sftp
    // connection but will ensure the smooth running the server by not
    // allowing networked file system operations to block the connections
    // read/write threads
    sshContext.setAsynchronousFileOperations(false);

    // Should the cancellation of a remote forwarding also kill any
    // active tunnels over the forwarding rule?
    sshContext.setRemoteForwardingCancelKillsTunnels(true);

    // Configure some VirtualFileSystem mounts and the VFS root
    System.setProperty("com.maverick.sshd.vfs.VFSRoot", "\\");
    //System.setProperty("com.maverick.sshd.vfs.VFSMount.1", "/foo=C:\\");
    //System.setProperty("com.maverick.sshd.vfs.VFSMount.2", "/management=M:\\");

    // You can add further mounts by using com.maverick.sshd.vfs.VFSMount.2
    // com.maverick.sshd.vfs.VFSMount.3 etc

    // Configure access permissions on a user by user basis
    sshContext.setAccessManager(new ExampleAccessManager());

    // Add SCP command support
    sshContext.addCommand("scp", ScpCommand.class);

    // Add a custom command
    sshContext.addCommand("users", ExampleCommand.class);

    context.setPermanentTransferThreads(1);

    sshContext.setSoftwareVersionComments("SAFIServer SSHD Tunnel");

    //context.supportedAuthenticationMechanisms().add("none", NoneAuthentication.class);

    // Set available socket options
    sshContext.setSocketOptionKeepAlive(true);
    sshContext.setSocketOptionTcpNoDelay(true);
    sshContext.setSocketOptionReuseAddress(false);

    sshContext.setRequiredAuthenticationMethods(authmethods);

  sshContext.setAllowDeniedKEX(deniedKEXAllowed);
  
  sshContext.setIdleConnectionTimeoutSeconds(-1);
  
    //context.supportedCiphers().add("aes128-cbc", com.sshtools.jce.AES128Cbc.class);
    /* DEBUG */ EventLog.LogEvent(this,"Configuration complete.");
  }

}
