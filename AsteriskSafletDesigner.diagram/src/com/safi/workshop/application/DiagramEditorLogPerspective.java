package com.safi.workshop.application;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import org.eclipse.ui.console.IConsoleConstants;

/**
 * @generated
 */
public class DiagramEditorLogPerspective implements IPerspectiveFactory {
  /**
   * @generated
   */
  public void createInitialLayout(IPageLayout layout) {
    layout.setEditorAreaVisible(true);
    layout.addPerspectiveShortcut(DiagramEditorWorkbenchAdvisor.PERSPECTIVE_ID);
    IFolderLayout right = layout.createFolder(
        "right", IPageLayout.RIGHT, 0.6f, layout.getEditorArea()); //$NON-NLS-1$
    right.addView(IPageLayout.ID_OUTLINE);
    IFolderLayout bottomRight = layout.createFolder(
        "bottomRight", IPageLayout.BOTTOM, 0.6f, "right"); //$NON-NLS-1$	//$NON-NLS-2$
    bottomRight.addView(IPageLayout.ID_PROBLEM_VIEW);
    bottomRight.addView(IConsoleConstants.ID_CONSOLE_VIEW);
    bottomRight.addView(IPageLayout.ID_PROP_SHEET);
    layout.addView("com.safi.workshop.view.VariablesView", IPageLayout.BOTTOM, 0.5f, "right");
  }
}
