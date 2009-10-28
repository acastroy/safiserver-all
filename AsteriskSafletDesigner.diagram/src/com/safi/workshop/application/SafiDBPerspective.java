package com.safi.workshop.application;

import org.eclipse.gef.ui.views.palette.PaletteView;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IPerspectiveListener4;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public class SafiDBPerspective implements IPerspectiveFactory, IPerspectiveListener4 {

  private boolean activated;

  public SafiDBPerspective() {
    super();
    IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    window.addPerspectiveListener(this);
    // AsteriskDiagramEditorPlugin.getInstance().setDBPerspective(this);
  }

  /**
   * Creates the initial layout for a page.
   */
  public void createInitialLayout(IPageLayout layout) {
    String editorArea = layout.getEditorArea();
    addFastViews(layout);
    addViewShortcuts(layout);
    addPerspectiveShortcuts(layout);
    IFolderLayout folderLayout = layout.createFolder("folder", IPageLayout.LEFT, 0.22f, editorArea);
    folderLayout.addView("com.safi.eclipse.NavigatorView");
    layout.getViewLayout("com.safi.eclipse.NavigatorView").setCloseable(false);
    folderLayout.addView(PaletteView.ID);
    layout.getViewLayout(PaletteView.ID).setCloseable(false);
    // layout.addView("com.safi.workshop.sqlexplorer.plugin.views.DataPreviewView",
    // IPageLayout.BOTTOM,
    // 0.68f, editorArea);
    layout.addPlaceholder("com.safi.workshop.sqlexplorer.plugin.views.DataPreviewView",
        IPageLayout.BOTTOM, 0.68f, editorArea);
    IFolderLayout folderLayout_1 = layout.createFolder("folder0", IPageLayout.LEFT, 0.5f,
        "com.safi.workshop.sqlexplorer.plugin.views.DataPreviewView");
    layout.getViewLayout("com.safi.workshop.sqlexplorer.plugin.views.DataPreviewView")
        .setCloseable(false);
    folderLayout_1.addView("com.safi.workshop.sqlexplorer.plugin.views.SQLHistoryView");
    folderLayout_1.addView("com.safi.workshop.sqlexplorer.plugin.views.DatabaseStructureView");
    layout.addView("com.safi.workshop.sqlexplorer.plugin.views.DatabaseDetailView",
        IPageLayout.LEFT, 0.5f, "com.safi.workshop.sqlexplorer.plugin.views.DataPreviewView");
    layout.getViewLayout("com.safi.workshop.sqlexplorer.plugin.views.SQLHistoryView").setCloseable(
        false);
    layout.getViewLayout("com.safi.workshop.sqlexplorer.plugin.views.DatabaseStructureView")
        .setCloseable(false);
    layout.getViewLayout("com.safi.workshop.sqlexplorer.plugin.views.DatabaseDetailView")
        .setCloseable(false);

  }

  /**
   * Add fast views to the perspective.
   */
  private void addFastViews(IPageLayout layout) {
  }

  /**
   * Add view shortcuts to the perspective.
   */
  private void addViewShortcuts(IPageLayout layout) {
  }

  /**
   * Add perspective shortcuts to the perspective.
   */
  private void addPerspectiveShortcuts(IPageLayout layout) {
  }

  @Override
  public void perspectivePreDeactivate(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
  }

  @Override
  public void perspectiveClosed(IWorkbenchPage page, IPerspectiveDescriptor perspective) {

  }

  @Override
  public void perspectiveDeactivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
    // TODO Auto-generated method stub
    activated = false;
  }

  @Override
  public void perspectiveOpened(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
    // TODO Auto-generated method stub
  }

  @Override
  public void perspectiveSavedAs(IWorkbenchPage page, IPerspectiveDescriptor oldPerspective,
      IPerspectiveDescriptor newPerspective) {
  }

  @Override
  public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective,
      IWorkbenchPartReference partRef, String changeId) {
    // TODO Auto-generated method stub
  }

  @Override
  public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
    // TODO Auto-generated method stub
    // AsteriskDiagramEditorPlugin.getInstance().setDBPerspective(this);
    activated = true;
  }

  @Override
  public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective,
      String changeId) {
    // TODO Auto-generated method stub
  }

  public boolean isActivated() {
    return activated;
  }

  public void setActivated(boolean activated) {
    this.activated = activated;
  }

}
