package com.safi.workshop;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class SafiProjectNature implements IProjectNature {

  private IProject project;
  public final static String NATURE_ID = "com.safi.workshop.SafiProjectNature";

  @Override
  public void configure() throws CoreException {
    // TODO Auto-generated method stub
    // project.getFolder("conf").create(true,true, null);
    // project.getFolder("safi").create(true,true,null);

  }

  @Override
  public void deconfigure() throws CoreException {
    // TODO Auto-generated method stub

  }

  @Override
  public IProject getProject() {
    // TODO Auto-generated method stub
    return project;
  }

  @Override
  public void setProject(IProject project) {
    // TODO Auto-generated method stub
    this.project = project;

  }

}
