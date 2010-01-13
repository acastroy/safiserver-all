package com.safi.workshop.serverview;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;
import com.safi.db.server.config.SafiServer;

public class ServerViewEditorInput implements IEditorInput {

  private SafiServer safiServer;

  public ServerViewEditorInput(SafiServer server) {
    this.safiServer = server;
  }

  @Override
  public boolean exists() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public ImageDescriptor getImageDescriptor() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getName() {
    // TODO Auto-generated method stub
    return "SafiServer View EditorInput";
  }

  @Override
  public IPersistableElement getPersistable() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getToolTipText() {
    // TODO Auto-generated method stub
    return "SafiServer " + (safiServer == null ? "<none>" : safiServer.getName());
  }

  @Override
  public Object getAdapter(Class adapter) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this)
      return true;
    return obj instanceof ServerViewEditorInput && this.safiServer != null
        && ((ServerViewEditorInput) obj).getSafiServer() != null
        && this.safiServer.getId() == ((ServerViewEditorInput) obj).getSafiServer().getId();
  }

  public SafiServer getSafiServer() {
    return safiServer;
  }

  public void setSafiServer(SafiServer safiServer) {
    this.safiServer = safiServer;
  }

}
