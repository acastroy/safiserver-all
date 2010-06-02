package com.safi.workshop.sheet;

import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.dltk.compiler.CharOperation;
import org.eclipse.dltk.core.IModelStatus;
import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.internal.core.DefaultWorkingCopyOwner;
import org.eclipse.dltk.internal.core.SourceModule;
import org.eclipse.dltk.internal.core.util.Util;

public class SafiSourceModule extends SourceModule {

  IFile currentFile;
  IScriptProject scriptProject;

  public SafiSourceModule(IFile file, URI location) {
    super(null, location == null ? file.getFullPath().toString() : location.getPath(),
        DefaultWorkingCopyOwner.PRIMARY/*
                                        * encoding is used only when retrieving the
                                        * contents
                                        */);
    currentFile = file;
    this.scriptProject = this.getScriptProject();
    // TODO Auto-generated constructor stub
  }

  @Override
  public IResource getResource() {
    /*
     * ProjectFragment root = this.getProjectFragment(); if (root.isArchive()) { return
     * root.getResource(); }
     * 
     * return ((IContainer) this.getParent().getResource()).getFile(new Path(
     * this.getElementName()));
     */
    return currentFile;

  }

  @Override
  public IScriptProject getScriptProject() {
    if (this.scriptProject == null) {
      if (this.currentFile != null) {
        this.scriptProject = new SafiScriptProject(this.currentFile.getProject(), null);
        try {
          this.scriptProject.setRawBuildpath(null, null);
        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }

    }
    return this.scriptProject;
  }

  @Override
  public boolean isPrimary() {

    return true;
  }

  @Override
  protected IStatus validateSourceModule(IResource resource) throws CoreException {
    return IModelStatus.VERIFIED_OK;

  }

  @Override
  public boolean isWorkingCopy() {
    return true;
  }

  public char[] getContents() {
    // otherwise retrieve it
    try {
      if (this.currentFile != null)
        return Util.getResourceContentsAsCharArray(this.currentFile);
    } catch (CoreException e) {
      return CharOperation.NO_CHAR;
    }
    return CharOperation.NO_CHAR;
  }

}
