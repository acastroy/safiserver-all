package com.safi.asterisk.handler.mbean;

import java.util.Date;

import com.safi.asterisk.handler.importing.OverwriteMode;

public interface FileTransfer {

  void transferJar(String filename, byte[] data) throws Exception;

  boolean needsUpdateActionPak(String filename);

  void transferAudioFile(String project, String filename, byte[] data) throws Exception;
  
  void renamePromptFile(int promptId, String projectName, String name, String extension) throws Exception;
  
  boolean needsUpdateAudioFile(String project,String filename, Date timestamp);
  
  void transferWorkspaceArchive(String filename, byte[] data, OverwriteMode mode) throws Exception;
  
  void transferServerJar(String filename, byte[] data) throws Exception;
  
  boolean needsUpdateServerJar(String filename);
}
