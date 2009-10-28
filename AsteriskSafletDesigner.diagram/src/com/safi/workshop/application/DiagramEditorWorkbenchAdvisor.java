package com.safi.workshop.application;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.IWorkbenchConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;

import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.navigator.ServerResourcesDecorator;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;

/**
 * @generated not
 */
public class DiagramEditorWorkbenchAdvisor extends WorkbenchAdvisorHack {
  /**
   * @generated
   */
  public static final String PERSPECTIVE_ID = "com.safi.workshop.AsteriskPerspective"; //$NON-NLS-1$

  /**
   * @generated
   */
  @Override
  public String getInitialWindowPerspectiveId() {
    return PERSPECTIVE_ID;
  }

  /**
   * @generated
   */
  @Override
  public void initialize(IWorkbenchConfigurer configurer) {
    super.initialize(configurer);
    configurer.setSaveAndRestore(true);
  }

  /**
   * @generated
   */
  @Override
  public WorkbenchWindowAdvisor createWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
    return new DiagramEditorWorkbenchWindowAdvisor(configurer);
  }

  @Override
  public IStatus restoreState(IMemento mento) {
    return super.restoreState(mento);
  }

  @Override
  public IAdaptable getDefaultPageInput() {
    // TODO Auto-generated method stub
    // return super.getDefaultPageInput();
    return ResourcesPlugin.getWorkspace().getRoot();
  }

  @Override
  public boolean openWindows() {
    // TODO Auto-generated method stub
    return super.openWindows();
  }

  @Override
  public boolean preShutdown() {
    AsteriskDiagramEditorUtil.getSafiNavigator().switchToSafletPerspective();
    return super.preShutdown();
  }

  @Override
  public void postStartup() {
    // TODO Auto-generated method stub
    super.postStartup();
    try {
      PlatformUI.getWorkbench().getProgressService().run(true, true, new IRunnableWithProgress() {

        @Override
        public void run(IProgressMonitor monitor) throws InvocationTargetException,
            InterruptedException {
          try {
            boolean isError = false;
            try {
              SafiServerPlugin.getDefault().initializeResources(monitor);
            } catch (Exception ex) {
              isError = true;
            }

            if (SQLExplorerPlugin.getDefault() == null)
              new SQLExplorerPlugin();
            SQLExplorerPlugin.getDefault().initResources(monitor);
            SQLExplorerPlugin.getDefault().getAliasManager().addListener(
                AsteriskDiagramEditorUtil.getSafiNavigator(true));

            if (!isError) {
              AsteriskDiagramEditorPlugin.getInstance().doInit(monitor);
            } else {
              AsteriskDiagramEditorPlugin.getInstance().doSoftInit(monitor);
            }
            // DirtyDecorator.getDirtyDecorator().refresh();
            // AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
            // AsteriskDiagramEditorUtil.getSafiNavigator().expandAll();
            ServerResourcesDecorator.updateServerResourcesDecorators();
          } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }

        }
      });

    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Initialization Error",
          "SafiWorkshop couldn't initialize properly: " + e.getLocalizedMessage());
    }

    // AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged();

  }

}
