package com.safi.workshop.sqlexplorer.rcp;

import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchAdvisor;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

/**
 * WorkbenchAdvisor. Controls the workbench layout.
 * 
 * @author Davy Vanherbergen
 * 
 */
public class SQLExplorerWorkbenchAdvisor extends WorkbenchAdvisor {

  /**
   * Allow SQL Explorer to save and restore layout and views
   */
  @Override
  public void initialize(IWorkbenchConfigurer configurer) {
    super.initialize(configurer);
    configurer.setSaveAndRestore(true);
  }

  /**
   * Get unique id for our sql explorer perspective. This should match a perspective
   * defined in the plugin.xml
   * 
   * @see org.eclipse.ui.application.WorkbenchAdvisor#getInitialWindowPerspectiveId()
   */
  @Override
  public String getInitialWindowPerspectiveId() {
    return "com.safi.workshop.sqlexplorer.plugin.perspectives.SQLExplorerPluginPerspective";
  }

  /**
   * Instantiate our own window advisor.
   * 
   * @see org.eclipse.ui.application.WorkbenchAdvisor#createWorkbenchWindowAdvisor(org.eclipse.ui.application.IWorkbenchWindowConfigurer)
   */
  @Override
  public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {

    return new SQLExplorerWorkbenchWindowAdvisor(configurer);
  }

}
