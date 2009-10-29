package com.safi.asterisk.handler.connection.sshd.j2ssh;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.sshtools.daemon.configuration.PlatformConfiguration;
import com.sshtools.daemon.vfs.VFSMount;

public class J2SSHPlatformConfig extends PlatformConfiguration {

  private static final String PLATFORM_ELEMENT = "PlatformConfiguration";
  private static final String NATIVE_PROCESS_ELEMENT = "NativeProcessProvider";
  private static final String NATIVE_AUTH_ELEMENT = "NativeAuthenticationProvider";
  private static final String NFS_ELEMENT = "NativeFileSystemProvider";
  private static final String NATIVE_SETTING_ELEMENT = "NativeSetting";
  private static final String VFSMOUNT_ELEMENT = "VFSMount";
  private static final String VFSROOT_ELEMENT = "VFSRoot";
  private static final String VFSPERMISSION_ELEMENT = "VFSPermission";
  private static final String PATH_ATTRIBUTE = "path";
  private static final String MOUNT_ATTRIBUTE = "mount";
  private static final String NAME_ATTRIBUTE = "name";
  private static final String VALUE_ATTRIBUTE = "value";
  private static final String PERMISSIONS_ATTRIBUTE = "permissions";
  
  private Map nativeSettings = new HashMap();
  private String nativeProcessProvider = null;
  private String nativeAuthenticationProvider = null;
  private String nativeFileSystemProvider = null;
  private Map vfsMounts = new HashMap();
  private VFSMount vfsRoot = null;
  
  public J2SSHPlatformConfig() throws SAXException, ParserConfigurationException,
      IOException {
    super(null);
  }

  @Override
  public void reload(InputStream in) throws SAXException, ParserConfigurationException, IOException {
  }

  public Map getNativeSettings() {
    return nativeSettings;
  }

  public void setNativeSettings(Map nativeSettings) {
    this.nativeSettings = nativeSettings;
  }

  public String getNativeProcessProvider() {
    return nativeProcessProvider;
  }

  public void setNativeProcessProvider(String nativeProcessProvider) {
    this.nativeProcessProvider = nativeProcessProvider;
  }

  public String getNativeAuthenticationProvider() {
    return nativeAuthenticationProvider;
  }

  public void setNativeAuthenticationProvider(String nativeAuthenticationProvider) {
    this.nativeAuthenticationProvider = nativeAuthenticationProvider;
  }

  public String getNativeFileSystemProvider() {
    return nativeFileSystemProvider;
  }

  public void setNativeFileSystemProvider(String nativeFileSystemProvider) {
    this.nativeFileSystemProvider = nativeFileSystemProvider;
  }

  public Map getVfsMounts() {
    return vfsMounts;
  }

  public void setVfsMounts(Map vfsMounts) {
    this.vfsMounts = vfsMounts;
  }

  public VFSMount getVfsRoot() {
    return vfsRoot;
  }

  public void setVfsRoot(VFSMount vfsRoot) {
    this.vfsRoot = vfsRoot;
  }
  
  
}
