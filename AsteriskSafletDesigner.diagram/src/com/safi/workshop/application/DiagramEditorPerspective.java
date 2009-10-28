package com.safi.workshop.application;

import org.eclipse.gef.ui.views.palette.PaletteView;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.IViewLayout;
import org.eclipse.ui.console.IConsoleConstants;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

/**
 * @generated
 */
public class DiagramEditorPerspective implements IPerspectiveFactory {

  public DiagramEditorPerspective() {
    super();
    AsteriskDiagramEditorPlugin.getInstance().setSafletPerspective(this);
  }

  /**
   * @generated NOT
   */
  public void createInitialLayout(IPageLayout layout) {
    layout.setEditorAreaVisible(true);
    layout.addPerspectiveShortcut(DiagramEditorWorkbenchAdvisor.PERSPECTIVE_ID);
    IViewLayout navView = layout.getViewLayout("com.safi.eclipse.NavigatorView");
    navView.setCloseable(false);

    IFolderLayout folderLayout_1 = layout.createFolder("bottomRight", IPageLayout.BOTTOM, 0.72f,
        layout.getEditorArea());
    layout.getViewLayout(PaletteView.ID).setCloseable(false);
    folderLayout_1.addView(IPageLayout.ID_PROP_SHEET);
    layout.getViewLayout(IPageLayout.ID_PROP_SHEET).setCloseable(false);
    layout.getViewLayout("org.eclipse.target.ui.SiteExplorerView").setCloseable(false);
    IFolderLayout folderLayout = layout.createFolder("folder", IPageLayout.RIGHT, .5f,
        "bottomRight");
    folderLayout.addView("com.safi.workshop.view.VariablesView");
    folderLayout.addView(IPageLayout.ID_OUTLINE);
    folderLayout.addView(IConsoleConstants.ID_CONSOLE_VIEW);
    layout.getViewLayout("com.safi.workshop.view.VariablesView").setCloseable(false);
    layout.getViewLayout(IPageLayout.ID_OUTLINE).setCloseable(false);
    IFolderLayout folderLayout_3 = layout.createFolder("folder0", IPageLayout.LEFT, 0.22f, layout
        .getEditorArea());
    folderLayout_3.addView("com.safi.eclipse.NavigatorView");
    folderLayout_3.addView(PaletteView.ID);
    layout.getViewLayout(IConsoleConstants.ID_CONSOLE_VIEW).setCloseable(true);
    layout.getViewLayout("com.jcraft.eclipse.jcterm.view").setCloseable(false);

    // layout.getFolderForView("dd").
  }
  //
  // @Override
  // public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor
  // perspective) {
  // SafiDBPerspective db = AsteriskDiagramEditorPlugin.getInstance().getDBPerspective();
  // }
  //
  // @Override
  // public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor
  // perspective,
  // String changeId) {
  // // TODO Auto-generated method stub
  //
  // }

}
