package com.safi.asterisk.handler.connection;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpATTRS;
import com.jcraft.jsch.SftpException;
import com.jcraft.jsch.UserInfo;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.safi.asterisk.handler.SafletEngine;
import com.safi.db.manager.DBManager;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.ConfigFactory;
import com.safi.db.server.config.Prompt;

public class SFTPConnectionManager {

  private static final String PROP_MAX_SAFI_PROMPT_DEPTH = "max.safi.prompt.depth";
	private static final String PROP_MAX_SYSTEM_PROMPT_DEPTH = "max.system.prompt.depth";
	private static final int CONNECT_TIMEOUT = 20000;
  private static final int MAX_SAFIPROMPT_DEPTH = 10;
  private final static Logger log = Logger.getLogger(SFTPConnectionManager.class);
  private static final int MAX_SYSTEMPROMPT_DEPTH = 0;
  
  private static SFTPConnectionManager instance = new SFTPConnectionManager();

  private int maxSystemPromptRecurseDepth;
  private int maxSafiPromptRecurseDepth;
  private SFTPConnectionManager() {
  	try {
	    maxSystemPromptRecurseDepth = Integer.valueOf(SafletEngine.getInstance().getProperty(PROP_MAX_SYSTEM_PROMPT_DEPTH, String.valueOf(MAX_SYSTEMPROMPT_DEPTH)));
    } catch (NumberFormatException e) {
	    log.error("Invalid value for "+PROP_MAX_SYSTEM_PROMPT_DEPTH,e);
	    maxSystemPromptRecurseDepth = MAX_SYSTEMPROMPT_DEPTH;
    }
  	try {
	    maxSafiPromptRecurseDepth = Integer.valueOf(SafletEngine.getInstance().getProperty(PROP_MAX_SAFI_PROMPT_DEPTH, String.valueOf(MAX_SAFIPROMPT_DEPTH)));
    } catch (NumberFormatException e) {
    	log.error("Invalid value for "+PROP_MAX_SAFI_PROMPT_DEPTH,e);
    	maxSafiPromptRecurseDepth = MAX_SAFIPROMPT_DEPTH;
    }
  }

  public static SFTPConnectionManager getInstance() {
    return instance;
  }

  @SuppressWarnings("unchecked")
  public boolean synchronizePrompts(AsteriskServer server) throws SSHException {
    String user = server.getSftpUser();
    if (StringUtils.isBlank(user))
      throw new SSHException("Username was not specified for Asterisk server "+server.getName());
    

    String promptDir = server.getPromptDirectory();
    if (StringUtils.isBlank(promptDir))
      throw new SSHException("Prompt directory was not specified for Asterisk server "+server.getName());
    if (promptDir.endsWith("/"))
      promptDir.subSequence(0, promptDir.length() - 1);
    // String safiDir = promptDir + "/safi";

    int baseDepth = getDepth(promptDir);
    if (log.isInfoEnabled())
      log.info("Synchronizing prompts for Asterisk server " + server.getHostname());
    final String password = server.getSftpPassword();
    int port = server.getSftpPort();
    String host = server.getHostname();

    Session session = null;
    try {

      JSch jsch = new JSch();

      session = jsch.getSession(user, host, port);

      // username and password will be given via UserInfo interface.
      session.setUserInfo(new UserInfo() {
        @Override
        public String getPassphrase() {
          return null;
        }

        @Override
        public String getPassword() {
          return password;
        }

        @Override
        public boolean promptYesNo(String message) {
          return true;
        }

        @Override
        public boolean promptPassphrase(String message) {
          return true;
        }

        @Override
        public boolean promptPassword(String message) {
          return true;
        }

        @Override
        public void showMessage(String message) {
        }

      });

      session.setTimeout(CONNECT_TIMEOUT);
      session.connect();
      Channel channel = session.openChannel("sftp");
      channel.connect();
      ChannelSftp c = (ChannelSftp) channel;

      Map<String, Prompt> promptMap = new HashMap<String, Prompt>();
      List<Prompt> promptsToDelete = new ArrayList<Prompt>();
      boolean dirty = false;

      List<Prompt> prompts = DBManager.getInstance().getPrompts();
      for (Prompt p : prompts) {
        if (p.isSystem())
          promptMap.put(p.getName(), p);
        else {
          String name = "safi/"
              + (p.getProject() == null ? "shared/" : "project/" + p.getProject().getName()) + "/"
              + p.getName();
          name = name.replaceAll("//", "/");
          promptMap.put(name, p);
        }
      }
      Set<String> paths = new HashSet<String>();
      Set<String> verifiedDirs = new HashSet<String>();
      Set<String> failedDirs = new HashSet<String>();

      String safiSubdirPrefix = promptDir + "/safi";
      paths.add(promptDir);
      // String currentPath = "";
      int currentDepth = 0;
      while (!paths.isEmpty()) {
        Iterator<String> iterator = paths.iterator();
        String path = iterator.next();
        iterator.remove();
        java.util.Vector vv = c.ls(path);
        String subdirPath = path.substring(promptDir.length());
        if (subdirPath.startsWith("/"))
          subdirPath = subdirPath.substring(1);
        currentDepth = getDepth(subdirPath);
        if (vv != null) {
          for (int ii = 0; ii < vv.size(); ii++) {
            // out.println(vv.elementAt(ii).toString());

            Object obj = vv.elementAt(ii);
            if (obj instanceof com.jcraft.jsch.ChannelSftp.LsEntry) {
              LsEntry entry = ((com.jcraft.jsch.ChannelSftp.LsEntry) obj);
              SftpATTRS attrs = entry.getAttrs();
              if (attrs.isDir()) {

                
                  if (!(".".equals(entry.getFilename()) || "..".equals(entry.getFilename()))) {

                    String subdir = path + '/' + entry.getFilename();
                    final boolean isSafiSubdir = subdir.startsWith(safiSubdirPrefix);
										if (!isSafiSubdir
                        && currentDepth >= maxSystemPromptRecurseDepth) {
                      continue;
                    }
                    else
                    if (isSafiSubdir && currentDepth >= maxSafiPromptRecurseDepth) {
                    	continue;
                    }
                    // currentPath += entry.getFilename() + '/';

                    System.out.println("Adding subdir " + subdir);
                    if (log.isDebugEnabled())
                      log.debug("Adding subdir " + subdir);
                    paths.add(subdir);
                  }
              } else if (!attrs.isLink()) {
                String name = entry.getFilename();
                int i = name.lastIndexOf('.');
                String exten = null;
                if (i >= 0) {
                  exten = name.substring(i + 1, name.length());
                  name = name.substring(0, i);
                }
                name = StringUtils.isBlank(subdirPath) ? name : subdirPath + '/' + name;
                Prompt p = promptMap.get(name);
                boolean startsWithSafi = subdirPath.startsWith("safi");
                Date lastMod = new Date(((long)attrs.getMTime())*1000);
                if (p == null && !startsWithSafi) {
                  p = DBManager.getInstance().getPromptByName(name);
                  if (p == null) {
                    p = ConfigFactory.eINSTANCE.createPrompt();
                    p.setName(name);
                    p.setExtension(exten);
                    p.setLastModified(lastMod);
                    p.setSystem(true);
                    // prompts.add(p);
                    // DBManager.getInstance().saveOrUpdateServerResource(p);
                    // dirty = true;
                  } 
                  prompts.add(p);
                  DBManager.getInstance().saveOrUpdateServerResource(p);
                  dirty = true;

                } else if (p != null) {
                  if (log.isDebugEnabled())
                    log.debug("found existing prompt " + name);
                  if (!startsWithSafi)
                    promptMap.remove(name);
                } else if (p == null && startsWithSafi) { // p == null && safi
                  // !readOnly
                  // String destRoot = currentPath;
                  // if (!(destRoot.endsWith("/") || destRoot.endsWith("\\")))
                  // destRoot += "/";
                  String fullname = promptDir + '/' + name + '.' + exten;
                  if (log.isInfoEnabled())
                    log.info("Found orphan audio file " + fullname);
                  try {
                    c.rm(fullname);
                    removeEmptyParentDirs(c, safiSubdirPrefix, getParentDir(fullname));
                  } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    log.error("Couldn't delete prompt " + fullname + " from Asterisk server "
                        + server.getHostname(), e);
                  }
                }
                
              }
            }

          }
        }
        // currentDepth--;
      }

      for (Map.Entry<String, Prompt> entry : promptMap.entrySet()) {
        Prompt p = entry.getValue();
        if (p.isSystem()) {
          if (log.isInfoEnabled())
            log.info("System prompt " + p.getName() + " no longer exists.  Removing from DB...");
          prompts.remove(p);
          dirty = true;
          promptsToDelete.add(p); // do we really want to delete it from the DB?

          continue;
        }
        String root = SafletEngine.getInstance().getAudioDirectoryRoot();
        if (root == null)
          root = "";
        else {
          if (!(root.endsWith("/") || root.endsWith("\\")))
            root += File.separatorChar;
        }
        String localFile = null;
        String fileName = null;

        if (p.getProject() != null)
          fileName = "safi" + File.separatorChar + "project" + File.separatorChar
              + p.getProject().getName() + File.separatorChar + p.getName() + '.'
              + p.getExtension();
        else
          fileName = "safi" + File.separatorChar + "shared/" + File.separatorChar + p.getName()
              + '.' + p.getExtension();

        fileName = fileName.replace('\\', '/');
        fileName = fileName.replaceAll("//", "/");
        localFile = root + fileName;
        String destRoot = promptDir;
        if (!(destRoot.endsWith("/") || destRoot.endsWith("\\")))
          destRoot += "/";
        destRoot = destRoot.replace('\\', '/');
        if (!verifiedDirs.contains(destRoot) && !failedDirs.contains(destRoot)) {
          if (log.isInfoEnabled())
            log.info("Ensuring existence of destination root " + destRoot);
          if (!mkDirs(destRoot, c)) {
            failedDirs.add(destRoot);

            log.error("Couldn't create all sub-directories of  " + destRoot);
            continue;
          }
          verifiedDirs.add(destRoot);
        }
        String fullPath = destRoot + fileName.substring(0, fileName.lastIndexOf('/'));
        // fullPath = fullPath.replace('\\', '/');
        if (!verifiedDirs.contains(fullPath) && !failedDirs.contains(fullPath)) {
          if (log.isInfoEnabled())
            log.info("Ensuring existence of destination root " + fullPath);
          if (!mkDirs(fullPath, c)) {
            failedDirs.add(fullPath);

            log.error("Couldn't create all sub-directories of  " + fullPath);
            continue;
          }
          verifiedDirs.add(fullPath);
        }

        try {
          String dest = destRoot + fileName;
          dest = dest.replace('\\', '/');
          if (log.isDebugEnabled())
            log.debug("Transferring local prompt " + localFile + " to " + (dest));
          c.put(localFile, dest, ChannelSftp.OVERWRITE);
        } catch (Exception e) {
          e.printStackTrace();
          log.error("Couldn't copy prompt " + p.getName() + " to Asterisk server "
              + server.getHostname(), e);
        }
      }
      for (Prompt p : promptsToDelete) {
        DBManager.getInstance().delete(p);
      }
      if (dirty) {
        DBManager.getInstance().saveOrUpdateServerResource(server);
      }

      return true;
    } catch (Exception e) {
      e.printStackTrace();
      log.error("Error caught while synchronizing prompts", e);
      throw new SSHException(e.getCause() == null ? e.getLocalizedMessage() : e.getCause()
          .getLocalizedMessage());
    } finally {
      if (session != null) {
        try {
          session.disconnect();
        } catch (Exception e) {
        }
      }
    }
  }

  private void removeEmptyParentDirs(ChannelSftp c, String safiPromptDir, String current)
      throws SftpException {
    if (StringUtils.equals(current, safiPromptDir))
      return;

    java.util.Vector vv = c.ls(current);
    for (int ii = 0; ii < vv.size(); ii++) {
      Object obj = vv.elementAt(ii);
      if (obj instanceof com.jcraft.jsch.ChannelSftp.LsEntry) {
        LsEntry entry = ((com.jcraft.jsch.ChannelSftp.LsEntry) obj);
        SftpATTRS attrs = entry.getAttrs();

        if (!attrs.isLink()) {
          if (!attrs.isDir()
              || (attrs.isDir() && !(".".equals(entry.getFilename()) || "..".equals(entry
                  .getFilename())))) {
            return;
          }

        }
      }
    }

    String parent = getParentDir(current);
    c.cd(parent);
    c.rmdir(current);
    removeEmptyParentDirs(c, safiPromptDir, parent);
  }

  private String getParentDir(String current) {
    if (current.charAt(current.length() - 1) == '/')
      current = current.substring(0, current.length() - 2);
    int idx = current.lastIndexOf('/');
    if (idx < 0)
      return "";
    else
      return current.substring(0, idx);
  }

  private int getDepth(String promptDir) {
    int i = 0;
    int count = 0;
    while ((i = promptDir.indexOf('/', i + 1)) != -1)
      count++;
    return count;
  }

  private boolean mkDirs(String destRoot, ChannelSftp c) {
    try {
      String[] segs = destRoot.split("/");
      String sofar = "";
      for (String seg : segs) {
        try {
          if (log.isDebugEnabled())
            log.debug("Creating segment " + seg + " of remote dir " + destRoot);
          if (StringUtils.isBlank(seg))
            continue;
          sofar += "/" + seg;
          c.mkdir(sofar);
        } catch (SftpException e) {
          if (e.id == 4)
            continue;// probly already exists
          log.error("Couldn't create seg " + seg + " of remote directory " + destRoot, e);
          return false;
        }
      }
    } catch (Exception e) {
      log.error("Couldn't create remote directory " + destRoot, e);
      return false;
    }
    // TODO Auto-generated method stub
    return true;
  }

  public boolean retrieveAudioFile(String filePath, AsteriskServer server) throws SSHException {
    String user = server.getSftpUser();
    if (StringUtils.isBlank(user))
      return false;

    String promptDir = server.getPromptDirectory();
    if (StringUtils.isBlank(promptDir))
      return false;
    if (promptDir.endsWith("/"))
      promptDir.subSequence(0, promptDir.length() - 1);
    // String safiDir = promptDir + "/safi";

    if (log.isInfoEnabled())
      log.info("Retrieving prompt " + filePath + " from Asterisk server " + server.getHostname());
    final String password = server.getSftpPassword();
    int port = server.getSftpPort();
    String host = server.getHostname();
    Session session = null;
    try {

      JSch jsch = new JSch();

      session = jsch.getSession(user, host, port);
      // username and password will be given via UserInfo interface.
      session.setUserInfo(new UserInfo() {
        @Override
        public String getPassphrase() {
          return null;
        }

        @Override
        public String getPassword() {
          return password;
        }

        @Override
        public boolean promptYesNo(String message) {
          return true;
        }

        @Override
        public boolean promptPassphrase(String message) {
          return true;
        }

        @Override
        public boolean promptPassword(String message) {
          return true;
        }

        @Override
        public void showMessage(String message) {
        }

      });

      session.connect();
      Channel channel = session.openChannel("sftp");
      channel.connect();
      ChannelSftp c = (ChannelSftp) channel;

      String root = SafletEngine.getInstance().getAudioDirectoryRoot();
      if (root == null)
        root = "";
      else {
        if (!(root.endsWith("/") || root.endsWith("\\")))
          root += File.separatorChar;
      }
      String localFile = root + filePath;

      String remoteFile = promptDir;
      if (!(remoteFile.endsWith("/") || remoteFile.endsWith("\\")))
        remoteFile += "/";

      remoteFile = remoteFile + filePath;
      remoteFile = remoteFile.replace('\\', '/');

      int mode = ChannelSftp.OVERWRITE;
      c.get(remoteFile, localFile, null, mode);
      return true;
    } catch (SftpException e) {

      if (e.id == ChannelSftp.SSH_FX_NO_SUCH_FILE) {
        log.warn("File " + filePath + " couldn't be found on Asterisk server " + server.getName(),
            e);
        return false;
      } else {
        log.error("Error caught while retrieving prompts", e);
        throw new SSHException(e.getCause() == null ? e.getLocalizedMessage() : e.getCause()
            .getLocalizedMessage());
      }
    } catch (Exception e) {
      log.error("Error caught while retrieving prompts", e);
      throw new SSHException(e.getCause() == null ? e.getLocalizedMessage() : e.getCause()
          .getLocalizedMessage());
    } finally {
      if (session != null) {
        try {
          session.disconnect();
        } catch (Exception e) {
        }
      }
    }
  }

	public int getMaxSystemPromptRecurseDepth() {
  	return maxSystemPromptRecurseDepth;
  }

	public void setMaxSystemPromptRecurseDepth(int maxSystemPromptRecurseDepth) {
  	this.maxSystemPromptRecurseDepth = maxSystemPromptRecurseDepth;
  }

	public int getMaxSafiPromptRecurseDepth() {
  	return maxSafiPromptRecurseDepth;
  }

	public void setMaxSafiPromptRecurseDepth(int maxSafiPromptRecurseDepth) {
  	this.maxSafiPromptRecurseDepth = maxSafiPromptRecurseDepth;
  }
}
