package com.safi.workshop.application;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveRegistry;
import org.eclipse.ui.IWorkbenchPreferenceConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.application.IWorkbenchWindowConfigurer;
import org.eclipse.ui.application.WorkbenchWindowAdvisor;
import org.eclipse.ui.internal.WorkbenchWindow;
import org.eclipse.ui.internal.progress.ProgressRegion;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.Messages;

/**
 * @generated
 */
public class DiagramEditorWorkbenchWindowAdvisor extends WorkbenchWindowAdvisor {

  private ProgressRegion progressRegion;

  /**
   * @generated
   */
  public DiagramEditorWorkbenchWindowAdvisor(IWorkbenchWindowConfigurer configurer) {
    super(configurer);
  }

  private void createProgressIndicator(Shell shell) {
    if (getWindowConfigurer().getShowProgressIndicator()) {
      WorkbenchWindow window = (WorkbenchWindow) getWindowConfigurer().getWindow();
      progressRegion = new ProgressRegion();
      progressRegion.createContents(shell, window);
    }

  }

  @Override
  public void createWindowContents(Shell shell) {
    super.createWindowContents(shell);
    this.createProgressIndicator(shell);
  }

  /**
   * @generated
   */
  @Override
  public ActionBarAdvisor createActionBarAdvisor(IActionBarConfigurer configurer) {
    return new DiagramEditorActionBarAdvisor(configurer);
  }

  /**
   * @generated NOT
   */
  @Override
  public void preWindowOpen() {
    IPerspectiveRegistry iPerspectiveRegistry = PlatformUI.getWorkbench().getPerspectiveRegistry();
    // IPerspective [] persepectives=iPerspectiveRegistry.getPerspectives();

    IPerspectiveDescriptor[] perspectiveDescriptors = iPerspectiveRegistry.getPerspectives();
    for (IPerspectiveDescriptor perspectiveDescriptor : perspectiveDescriptors) {
      // System.out.println(perspectiveDescriptors[i].getId());
      if ("org.eclipse.debug.ui.DebugPerspective".equals(perspectiveDescriptor.getId())
          || "org.eclipse.team.ui.TeamSynchronizingPerspective".equals(perspectiveDescriptor
              .getId())) {
        try {
          if (iPerspectiveRegistry instanceof org.eclipse.ui.internal.registry.PerspectiveRegistry) {
            Object[] desc = { perspectiveDescriptor };

            ((org.eclipse.ui.internal.registry.PerspectiveRegistry) iPerspectiveRegistry)
                .removeExtension(null, desc);
          }

        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    }
    IWorkbenchWindowConfigurer configurer = getWindowConfigurer();
    configurer.setInitialSize(new Point(1000, 700));
    configurer.setTitle(Messages.DiagramEditorWorkbenchWindowAdvisor_Title);
    configurer.setShowProgressIndicator(true);

    // configurer.setInitialSize(new Point(400, 300));

    configurer.setShowPerspectiveBar(true);

    // Set the preference toolbar to the left place

    // If other menus exists then this will be on the left of them

    IPreferenceStore apiStore = PlatformUI.getPreferenceStore();

    apiStore.setValue(IWorkbenchPreferenceConstants.DOCK_PERSPECTIVE_BAR,

    "TOP_LEFT");
  }

  /**
   * @generated not
   */
  @Override
  public void postWindowCreate() {

    // remove some menu items
    super.postWindowCreate();
    IPerspectiveRegistry iPerspectiveRegistry = PlatformUI.getWorkbench().getPerspectiveRegistry();
    // IPerspective [] persepectives=iPerspectiveRegistry.getPerspectives();

    IPerspectiveDescriptor[] perspectiveDescriptors = iPerspectiveRegistry.getPerspectives();
    for (IPerspectiveDescriptor perspectiveDescriptor : perspectiveDescriptors) {
      // System.out.println("jjj:"+perspectiveDescriptors[i].getId());

      if ("org.eclipse.debug.ui.DebugPerspective".equals(perspectiveDescriptor.getId())
          || "org.eclipse.team.ui.TeamSynchronizingPerspective".equals(perspectiveDescriptor
              .getId())
          || "org.eclipse.jdt.ui.JavaPerspective".equals(perspectiveDescriptor.getId())
          || "org.eclipse.jdt.ui.JavaHierarchyPerspective".equals(perspectiveDescriptor.getId())
          || "org.eclipse.jdt.ui.JavaBrowsingPerspective".equals(perspectiveDescriptor.getId())
          || "org.eclipse.dltk.javascript.ui.JavascriptPerspective".equals(perspectiveDescriptor
              .getId())) {

        try {
          if (iPerspectiveRegistry instanceof org.eclipse.ui.internal.registry.PerspectiveRegistry) {
            Object[] desc = { perspectiveDescriptor };

            ((org.eclipse.ui.internal.registry.PerspectiveRegistry) iPerspectiveRegistry)
                .removeExtension(null, desc);
          }

        } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    }

    IMenuManager mm = getWindowConfigurer().getActionBarConfigurer().getMenuManager();
    IContributionItem[] mItems = mm.getItems();
    for (IContributionItem item : mItems) {

      if (item.getId().equals("navigate") || item.getId().equals("additions")
          || item.getId().equals("org.eclipse.search.menu")
          || item.getId().equals("org.eclipse.ui.run")
          || item.getId().equals("org.eclipse.ui.WorkingSetActionSet")) {// contribution
        if (item.getId() != null || item.getId() != "") {
          mm.remove(item.getId());
          mm.update(true);
        }

      } else {
        if ("window".equals(item.getId())) {
          ((MenuManager) item).remove("selectWorkingSets");
          ((MenuManager) item).update(true);

        }
      }

      //
      //
      // // remove some tool bar items

      ICoolBarManager cm = getWindowConfigurer().getActionBarConfigurer().getCoolBarManager();
      IContributionItem[] citems = cm.getItems();
      // for(int j=0;j<citems.length;j++){
      //      	 
      // System.out.println("cloo:"+citems[j].getId());
      //      	 
      // }

      // or (int i = 0; i // System.out.println(mItems .getId());
      // }
      // String[] items = new String[] {
      // "org.eclipse.ui.edit.text.actionSet.navigation",
      // "org.eclipse.ui.edit.text.actionSet.annotationNavigation",
      // "org.eclipse.search.searchActionSet" };
      // for (int i = 0; i if (cm.remove(items ) != null)
      // // ...
      // }
      // cm.update(true);
      //
      //
      // // remove preference pages
      // PreferenceManager pm =
      // getWindowConfigurer().getWindow().getWorkbench().getPreferenceManager();
      //
      // String[] pages = new String[] {
      // "org.eclipse.team.ui.TeamPreferences",
      // "org.eclipse.debug.ui.DebugPreferencePage",
      // "de.jayefem.log4e.preferences.RootPage",
      // "org.eclipse.jdt.ui.preferences.JavaBasePreferencePage",
      // "org.eclipse.help.ui.browsersPreferencePage",
      // "org.eclipse.ui.preferencePages.Workspace",
      // "org.eclipse.search.preferences.SearchPreferencePage",
      // "org.eclipse.update.internal.ui.preferences.MainPreferencePage",
      // "org.eclipse.compare.internal.ComparePreferencePage",
      // "org.eclipse.ui.preferencePages.Workbench" };
      // for (int i = 0; i pm.remove(pages );
      // pages );
      // }
    }

    Shell shell = getWindowConfigurer().getWindow().getShell();
    if (!shell.getMaximized())
      shell.setMaximized(true);
    AsteriskDiagramEditorPlugin.getInstance().setWindowAdvisor(this);

  }

  @Override
  public void postWindowOpen() {
    super.postWindowOpen();
    // AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
  }

  @Override
  public IWorkbenchWindowConfigurer getWindowConfigurer() {
    // TODO Auto-generated method stub
    return super.getWindowConfigurer();
  }

}
