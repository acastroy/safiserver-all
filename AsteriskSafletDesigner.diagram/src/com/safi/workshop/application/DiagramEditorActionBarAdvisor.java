package com.safi.workshop.application;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.action.WorkbenchWindowActionDelegate;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.action.LoadResourceAction;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.osgi.util.NLS;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Event;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.registry.ActionSetRegistry;
import org.eclipse.ui.internal.registry.IActionSetDescriptor;

import com.safi.workshop.NewSafiProjectAction;
import com.safi.workshop.SafletCreationWizard;
import com.safi.workshop.UpdateAction;
import com.safi.workshop.actions.ActionSwitchWorkspace;
import com.safi.workshop.navigator.NavRefreshAction;
import com.safi.workshop.navigator.serverconfig.ServerViewAction;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.Messages;
import com.safi.workshop.sqlexplorer.connections.actions.DeleteAction;
import com.safi.workshop.sqlexplorer.connections.actions.NewAliasAction;
import com.safi.workshop.sqlexplorer.connections.actions.NewQueryAction;

/**
 * @generated NOT
 */
public class DiagramEditorActionBarAdvisor extends ActionBarAdvisor implements
    IPropertyChangeListener {

  private NavRefreshAction refreshAction;
  private IWorkbenchAction dynamicHelpAction;
  private IWorkbenchAction introAction;
  private IWorkbenchAction savePerspectiveAction;
  private IWorkbenchAction showViewMenuAction;
  // private IWorkbenchAction openPerspectiveDialogAction;
  private NewSafiProjectAction newSafiProjectAction;
  private IWorkbenchAction preferencesAction;
  private IWorkbenchAction newWizardDropDownAction;
  private IWorkbenchAction resetPerspectiveAction_2;
  private UpdateAction updateAction;
  private NewDiagramCustomAction newDiagramAction;
  private IWorkbenchAction showHelpAction;
  private IWorkbenchAction searchHelpAction;
  private ServerViewAction serverViewAction;
  private ActionSwitchWorkspace switchWorkspaceAction;
  // private IWorkbenchAction switchWorskspaceAction;
  // private NewAliasAction newDBConnectionAction;
  // private NewQueryAction newQueryAction;
  /**
   * @generated
   */
  private ActionFactory.IWorkbenchAction lockToolBarAction;

  /**
   * @generated
   */
  private ActionFactory.IWorkbenchAction toggleCoolbarAction;
  private OpenWorkspaceAction switchWorkspaceAction2;

  /**
   * @generated
   */
  public DiagramEditorActionBarAdvisor(IActionBarConfigurer configurer) {
    super(configurer);
  }

  /**
   * @generated
   */
  private IWorkbenchWindow getWindow() {
    return getActionBarConfigurer().getWindowConfigurer().getWindow();
  }

  /**
   * @generated NOT
   */
  @Override
  protected void makeActions(IWorkbenchWindow window) {

    toggleCoolbarAction = ActionFactory.TOGGLE_COOLBAR.create(window);
    // switchWorkspaceAction = new ActionSwitchWorkspace(null);
    switchWorkspaceAction2 = new OpenWorkspaceAction(window);
    // this.switchWorskspaceAction=IDEActionFactory.OPEN_WORKSPACE.create(window);
    // licenseAction=new LicenseManagerAction(window);
    serverViewAction = new ServerViewAction(window);
    register(toggleCoolbarAction);
    lockToolBarAction = ActionFactory.LOCK_TOOL_BAR.create(window);
    register(lockToolBarAction);

    register(ActionFactory.CLOSE.create(window));

    register(ActionFactory.CLOSE_ALL.create(window));

    register(ActionFactory.SAVE.create(window));
    IWorkbenchAction saveAs = ActionFactory.SAVE_AS.create(window);
    saveAs.setEnabled(true);
    register(saveAs);
    saveAs.setEnabled(true);

    register(ActionFactory.SAVE_ALL.create(window));

    register(ActionFactory.QUIT.create(window));

    register(ActionFactory.UNDO.create(window));

    register(ActionFactory.REDO.create(window));

    register(ActionFactory.CUT.create(window));

    register(ActionFactory.COPY.create(window));

    register(ActionFactory.PASTE.create(window));
    register(ActionFactory.RENAME.create(window));
    // register(ActionFactory.REFRESH.create(window));
    IWorkbenchAction delAction = ActionFactory.DELETE.create(window);
    delAction.addPropertyChangeListener(this);
    this.getActionBarConfigurer().registerGlobalAction(delAction);

    disposeAction(ActionFactory.DELETE.create(window));
    DeleteAction navDelAction = new DeleteAction();
    // com.safi.workshop.navigator.DeleteAction navDelAction = new
    // com.safi.workshop.navigator.DeleteAction();

    navDelAction.setEnabled(true);
    navDelAction.setActionDefinitionId("org.eclipse.ui.edit.delete");
    navDelAction.setAccelerator(SWT.DEL);
    navDelAction.setId("com.safi.navigator.deleteAction");
    register(navDelAction);

    // register(this.switchWorkspaceAction);
    register(this.switchWorkspaceAction2);

    // register(ActionFactory.DELETE.create(window));
    // System.out.println("id:"+iaction.getActionDefinitionId());
    // register(iaction);
    /*
     * SAFIDeleteAction safiDelete=new SAFIDeleteAction(window);
     * safiDelete.setId("org.eclipse.ui.edit.delete");
     * safiDelete.setActionDefinitionId("org.eclipse.ui.edit.delete");
     * register(safiDelete);
     */

    register(ActionFactory.SELECT_ALL.create(window));

    register(ActionFactory.OPEN_NEW_WINDOW.create(window));

    register(ActionFactory.PRINT.create(window));
    {
      resetPerspectiveAction_2 = ActionFactory.RESET_PERSPECTIVE.create(window);
      register(resetPerspectiveAction_2);
    }
    {
      newWizardDropDownAction = ActionFactory.NEW_WIZARD_DROP_DOWN.create(window);
      register(newWizardDropDownAction);
    }
    {
      preferencesAction = ActionFactory.PREFERENCES.create(window);
      register(preferencesAction);
    }

    newSafiProjectAction = new NewSafiProjectAction(window);

    newSafiProjectAction.setText("New Safi Project");
    {

      // openPerspectiveDialogAction
      // =ActionFactory.OPEN_PERSPECTIVE_DIALOG .create(window);
      // register(openPerspectiveDialogAction);

    }
    this.newDiagramAction = new NewDiagramCustomAction(window);
    this.newDiagramAction.setText("New Callflow Diagram");

    // this.newDBConnectionAction = new NewAliasAction();
    // this.newQueryAction = new NewQueryAction();
    {
      showViewMenuAction = ActionFactory.SHOW_VIEW_MENU.create(window);
      register(showViewMenuAction);
    }
    {
      savePerspectiveAction = ActionFactory.SAVE_PERSPECTIVE.create(window);
      register(savePerspectiveAction);
      register(savePerspectiveAction);

    }

    // erice added help
    showHelpAction = ActionFactory.HELP_CONTENTS.create(window);
    register(showHelpAction);
    searchHelpAction = ActionFactory.HELP_SEARCH.create(window);
    register(searchHelpAction);

    // contextHelpAction = ActionFactory.HELP_CONTENTS.create(window);
    // register(contextHelpAction);

    dynamicHelpAction = ActionFactory.DYNAMIC_HELP.create(window); // NEW
    register(dynamicHelpAction); // NEW

    updateAction = new UpdateAction(window);
    updateAction.setText("Update");
    updateAction.setImageDescriptor(AsteriskDiagramEditorPlugin.getDefault()
        .getBundledImageDescriptor("icons/updatesw.gif"));
    register(updateAction);
    // register(licenseAction);
    register(serverViewAction);
    introAction = ActionFactory.INTRO.create(window);
    introAction.setText("Welcome Page");
    introAction.setImageDescriptor(AsteriskDiagramEditorPlugin.getDefault()
        .getBundledImageDescriptor("icons/welcome.gif"));
    register(introAction);
    {
      refreshAction = new NavRefreshAction(ActionFactory.REFRESH.create(window));

      refreshAction.setEnabled(true);
      register(refreshAction);
    }

    ActionSetRegistry reg = WorkbenchPlugin.getDefault().getActionSetRegistry();
    IActionSetDescriptor[] actionSets = reg.getActionSets();
    // removing annoying gotoLastPosition Message.

    Set<String> actionSetIds = new HashSet<String>();
    String actionSetId = "org.eclipse.gmf.runtime.diagram.ui.DiagramActionSet"; //$NON-NLS-1$
    actionSetIds.add(actionSetId);

    actionSetId = "org.eclipse.ui.edit.text.actionSet.navigation"; //$NON-NLS-1$
    actionSetIds.add(actionSetId);

    // Removing convert line delimiters menu.
    actionSetId = "org.eclipse.ui.edit.text.actionSet.convertLineDelimitersTo"; //$NON-NLS-1$
    actionSetIds.add(actionSetId);

    actionSetId = "org.eclipse.ui.externaltools"; //$NON-NLS-1$
    actionSetIds.add(actionSetId);

    actionSetId = "org.eclipse.search.searchActionSet"; //$NON-NLS-1$
    actionSetIds.add(actionSetId);

    actionSetId = "org.eclipse.ui.WorkingSet"; //$NON-NLS-1$
    actionSetIds.add(actionSetId);

    actionSetId = "org.eclipse.ui.edit.text.actionSet.annotationNavigation"; //$NON-NLS-1$
    actionSetIds.add(actionSetId);

    removeActionSets(reg, actionSets, actionSetIds);
    //    actionSetId = "org.eclipse.ui.NavigateActionSet"; //$NON-NLS-1$
    // for (int i = 0; i < actionSets.length; i++) {
    // IExtension ext = actionSets[i].getConfigurationElement().getDeclaringExtension();
    // printAllChildren(ext.getConfigurationElements());
    // }

  }

  private void removeActionSets(ActionSetRegistry reg, IActionSetDescriptor[] actionSets,
      Set<String> actionSetIds) {
    for (int i = 0; i < actionSets.length; i++) {
      if (!actionSetIds.contains(actionSets[i].getId())) {
        continue;
      }
      IExtension ext = actionSets[i].getConfigurationElement().getDeclaringExtension();
      System.err.println("I'm removing ext "+ext);
      reg.removeExtension(ext, new Object[] { actionSets[i] });
    }
  }

  // private void printAllChildren(IConfigurationElement[] elements){
  // for (IConfigurationElement elem : elements){
  // System.out.println("i've got configelem "+elem.getName()+" wit value "+elem.getValue());
  // printAllChildren(elem.getChildren());
  // }
  // }

  /**
   * @generated not
   */
  @Override
  protected void fillMenuBar(IMenuManager menu) {

    {

      menu.removeAll();
      IMenuManager menuX = new MenuManager("File", IWorkbenchActionConstants.M_FILE);

      menuX.add(new GroupMarker(IWorkbenchActionConstants.FILE_START));

      {
        IMenuManager menuXX = new MenuManager("New", "new");
        menuXX.add(newSafiProjectAction);

        menuXX.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
        menuX.add(menuXX);
        menuX.add(new Separator());
        menuX.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));

      }

      menuX.add(new Separator());

      // menuX.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));

      menuX.add(new Separator());

      // menuX.add(getAction(ActionFactory.REFRESH.getId()));
      // getAction(ActionFactory.REFRESH.getId()).setEnabled(true);

      menuX.add(getAction(ActionFactory.CLOSE.getId()));

      menuX.add(getAction(ActionFactory.CLOSE_ALL.getId()));

      menuX.add(new Separator());

      menuX.add(getAction(ActionFactory.SAVE.getId()));

      menuX.add(getAction(ActionFactory.SAVE_AS.getId()));

      menuX.add(getAction(ActionFactory.SAVE_ALL.getId()));

      menuX.add(new Separator());

      menuX.add(refreshAction);
      // menuX.add(this.switchWorkspaceAction);
      menuX.add(this.switchWorkspaceAction2);
      menuX.add(new Separator());
      menuX.add(getAction(ActionFactory.QUIT.getId()));
      menuX.add(new Separator());
      menuX.add(new GroupMarker(IWorkbenchActionConstants.FILE_END));
      menu.add(menuX);
    }

    {
      IMenuManager menuX = new MenuManager("Edit", IWorkbenchActionConstants.M_EDIT);

      menuX.add(new GroupMarker(IWorkbenchActionConstants.EDIT_START));

      menuX.add(getAction(ActionFactory.UNDO.getId()));

      menuX.add(getAction(ActionFactory.REDO.getId()));

      menuX.add(new GroupMarker(IWorkbenchActionConstants.UNDO_EXT));

      menuX.add(new Separator());

      menuX.add(getAction(ActionFactory.CUT.getId()));

      menuX.add(getAction(ActionFactory.COPY.getId()));

      menuX.add(getAction(ActionFactory.PASTE.getId()));

      menuX.add(getAction(ActionFactory.RENAME.getId()));

      menuX.add(new GroupMarker(IWorkbenchActionConstants.CUT_EXT));

      menuX.add(new Separator());

      // menuX.add(getAction(ActionFactory.DELETE.getId()));

      menuX.add(getAction(ActionFactory.SELECT_ALL.getId()));

      // menuX.add(new Separator());

      // menuX.add(new GroupMarker(IWorkbenchActionConstants.ADD_EXT));

      menuX.add(new GroupMarker(IWorkbenchActionConstants.EDIT_END));

      // menuX.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
      menu.add(menuX);
    }

    menu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));

    {
      IMenuManager menuX = new MenuManager("Window", IWorkbenchActionConstants.M_WINDOW);

      // menuX.add(getAction(ActionFactory.OPEN_NEW_WINDOW.getId()));
      menuX.add(savePerspectiveAction);
      // ConsoleViewAction console=new ConsoleViewAction();
      // console.setText("Console");
      // menuX.add(console);
      // menuX.add(this.showViewMenuAction);
      menuX.add(getAction(ActionFactory.RESET_PERSPECTIVE.getId()));
      menuX.add(getAction(ActionFactory.PREFERENCES.getId()));

      menuX.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
      menu.add(menuX);

      // menuX.add(openPerspectiveDialogAction);

    }

    {
      IMenuManager menuX = new MenuManager("Help", "safi_help");

      // erice help menu additions
      menuX.add(introAction);
      menuX.add(showHelpAction);
      menuX.add(searchHelpAction);
      menuX.add(dynamicHelpAction);
      menuX.add(new Separator());

      menuX.add(updateAction);
      // menuX.add(this.licenseAction);
      menuX.add(this.serverViewAction);
      SafiHelpAction sh = new SafiHelpAction();
      sh.setText("Online Help...");
      menuX.add(sh);

      /*
       * menuX.remove(IWorkbenchActionConstants.HELP_START);
       * menuX.remove(IWorkbenchActionConstants.HELP_END); menuX.add(new
       * GroupMarker(IWorkbenchActionConstants.HELP_START));
       * 
       * menuX.add(new GroupMarker(IWorkbenchActionConstants.HELP_END));
       */

      // menuX.add(new
      // GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
      menu.add(menuX);
    }
  }

  /**
   * @generated NOT
   */
  @Override
  protected void fillCoolBar(ICoolBarManager toolBar) {
    IMenuManager popUpMenu = new MenuManager();
    popUpMenu.add(new ActionContributionItem(lockToolBarAction));
    popUpMenu.add(new ActionContributionItem(toggleCoolbarAction));
    toolBar.setContextMenuManager(popUpMenu);

    toolBar.add(new GroupMarker("group.file"));

    {
      IToolBarManager toolBarX = new ToolBarManager(SWT.FLAT);

      toolBarX.add(new Separator(IWorkbenchActionConstants.NEW_GROUP));

      // toolBarX.add(getAction(ActionFactory.NEW_WIZARD_DROP_DOWN.getId()));
      // toolBarX.add(getAction(ContributionItemFactory.NEW_WIZARD_SHORTLIST.getId()));

      toolBarX.add(newSafiProjectAction);
      toolBarX.add(this.newDiagramAction);
      // toolBarX.add(this.newDBConnectionAction);
      // toolBarX.add(this.newQueryAction);

      toolBarX.add(new GroupMarker(IWorkbenchActionConstants.NEW_EXT));

      toolBarX.add(new GroupMarker(IWorkbenchActionConstants.SAVE_GROUP));

      final IAction action_1 = getAction(ActionFactory.SAVE.getId());
      action_1.setText("Save");
      toolBarX.add(action_1);

      toolBarX.add(new GroupMarker(IWorkbenchActionConstants.SAVE_EXT));

      final IAction action_2 = getAction(ActionFactory.PRINT.getId());
      action_2.setText("Print");
      toolBarX.add(action_2);

      toolBarX.add(new GroupMarker(IWorkbenchActionConstants.PRINT_EXT));

      toolBarX.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
      toolBar.add(new ToolBarContributionItem(toolBarX, IWorkbenchActionConstants.TOOLBAR_FILE));
    }

    toolBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));

    toolBar.add(new GroupMarker("group.nav"));

    toolBar.add(new GroupMarker(IWorkbenchActionConstants.GROUP_EDITOR));

    toolBar.add(new GroupMarker(IWorkbenchActionConstants.GROUP_HELP));

    {
      IToolBarManager toolBarX = new ToolBarManager();

      toolBarX.add(new Separator(IWorkbenchActionConstants.GROUP_HELP));

      toolBarX.add(new GroupMarker(IWorkbenchActionConstants.GROUP_APP));
      toolBar.add(new ToolBarContributionItem(toolBarX, IWorkbenchActionConstants.TOOLBAR_HELP));
    }
  }

  /**
   * @generated NOT
   */
  public static boolean openEditor(IWorkbench workbench, URI fileURI) {

    IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
    IWorkbenchPage page = workbenchWindow.getActivePage();
    IEditorDescriptor editorDescriptor = workbench.getEditorRegistry().getDefaultEditor(
        fileURI.toFileString());
    if (editorDescriptor == null) {
      MessageDialog.openError(workbenchWindow.getShell(),
          Messages.DiagramEditorActionBarAdvisor_DefaultFileEditorTitle, NLS.bind(
              Messages.DiagramEditorActionBarAdvisor_DefaultFileEditorMessage, fileURI
                  .toFileString()));
      return false;
    } else {
      try {
        page.openEditor(new URIEditorInput(fileURI), editorDescriptor.getId());
      } catch (PartInitException exception) {
        MessageDialog.openError(workbenchWindow.getShell(),
            Messages.DiagramEditorActionBarAdvisor_DefaultEditorOpenErrorTitle, exception
                .getMessage());
        return false;
      }
    }
    return true;
  }

  // /**
  // * @generated
  // */
  // public static class NewDiagramAction extends WorkbenchWindowActionDelegate {
  //
  // /**
  // * @generated
  // */
  // public void run(IAction action) {
  // AsteriskCreationWizard wizard = new AsteriskCreationWizard();
  // wizard.init(getWindow().getWorkbench(), StructuredSelection.EMPTY);
  // WizardDialog wizardDialog = new WizardDialog(getWindow().getShell(), wizard);
  // wizardDialog.open();
  // }
  // }

  /**
   * @generated NOT
   */
  public static class SafiHelpAction extends Action {

    @Override
    public void run() {
      try {
        SafiHelpShell sshell = new SafiHelpShell(PlatformUI.getWorkbench()
            .getActiveWorkbenchWindow().getShell());
        sshell.open();
      } catch (Exception ex) {
      }
    }

    public void run(IAction action) {
      try {
        SafiHelpShell sshell = new SafiHelpShell(PlatformUI.getWorkbench()
            .getActiveWorkbenchWindow().getShell());
        sshell.open();
      } catch (Exception ex) {
      }
    }

    @Override
    public void runWithEvent(Event event) {
      try {
        SafiHelpShell sshell = new SafiHelpShell(PlatformUI.getWorkbench()
            .getActiveWorkbenchWindow().getShell());
        sshell.open();
      } catch (Exception ex) {
      }
    }
  }

  /**
   * @generated NOT
   */
  public class NewDiagramCustomAction extends Action {
    private IWorkbenchWindow window;

    public NewDiagramCustomAction() {
      this(PlatformUI.getWorkbench().getActiveWorkbenchWindow());
    }

    public NewDiagramCustomAction(IWorkbenchWindow window) {
      // TODO Auto-generated constructor stub
      super("NewCallFlowAction");
      if (window == null) {
        throw new IllegalArgumentException();
      }
      this.window = window;
      Image bi = AsteriskDiagramEditorPlugin.getDefault().getBundledImage(
          "icons/obj16/newsaflet.gif");
      // setImageDescriptor(bi.getImageDescriptor(""));
      // setDisabledImageDescriptor(images.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD_DISABLED));
      setImageDescriptor(AsteriskDiagramEditorPlugin.getDefault().getBundledImageDescriptor(
          "icons/obj16/newsaflet.gif"));

      setToolTipText("New saflet");
      PlatformUI.getWorkbench().getHelpSystem().setHelp(this,
          org.eclipse.ui.internal.IWorkbenchHelpContextIds.NEW_ACTION);
    }

    @Override
    public void run() {
      try {
        SafletCreationWizard wizard = new SafletCreationWizard();
        ISelection select = getWindow().getSelectionService().getSelection();
        if (select instanceof IStructuredSelection) {
          IStructuredSelection sselect = (IStructuredSelection) select;
          wizard.init(getWindow().getWorkbench(), sselect);

        } else {
          wizard.init(getWindow().getWorkbench(), StructuredSelection.EMPTY);
        }
        WizardDialog wizardDialog = new WizardDialog(getWindow().getShell(), wizard);
        wizardDialog.open();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    @Override
    public void runWithEvent(Event event) {
      try {
        SafletCreationWizard wizard = new SafletCreationWizard();
        ISelection select = getWindow().getSelectionService().getSelection();
        if (select instanceof IStructuredSelection) {
          IStructuredSelection sselect = (IStructuredSelection) select;
          wizard.init(getWindow().getWorkbench(), sselect);

        } else {
          wizard.init(getWindow().getWorkbench(), StructuredSelection.EMPTY);
        }
        WizardDialog wizardDialog = new WizardDialog(getWindow().getShell(), wizard);
        wizardDialog.open();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }
  }

  /**
   * @generated not
   */
  public static class NewDiagramAction2 extends WorkbenchWindowActionDelegate {

    /**
     * @generated not
     */
    public void run(IAction action) {
      try {
        SafletCreationWizard wizard = new SafletCreationWizard();
        ISelection select = getWindow().getSelectionService().getSelection();
        if (select instanceof IStructuredSelection) {
          IStructuredSelection sselect = (IStructuredSelection) select;
          wizard.init(getWindow().getWorkbench(), sselect);

        } else {
          wizard.init(getWindow().getWorkbench(), StructuredSelection.EMPTY);
        }
        WizardDialog wizardDialog = new WizardDialog(getWindow().getShell(), wizard);
        wizardDialog.open();
      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
    	action.setEnabled(true);
//      if (selection instanceof IStructuredSelection) {
//        Object elem = ((IStructuredSelection) selection).getFirstElement();
//        if (elem instanceof IResource || elem instanceof SafletProject || elem instanceof Saflet
//            || elem instanceof ServerResource)
//          action.setEnabled(true);
//        else
//          action.setEnabled(false);
//      }
    }

  }

  /**
   * @generated NOT
   */
  public static class OpenURIAction extends WorkbenchWindowActionDelegate {

    /**
     * @generated NOT
     */
    public void run(IAction action) {
      LoadResourceAction.LoadResourceDialog loadResourceDialog = new LoadResourceAction.LoadResourceDialog(
          getWindow().getShell());
      if (Window.OK == loadResourceDialog.open()) {
        for (Object element : loadResourceDialog.getURIs()) {
          openEditor(getWindow().getWorkbench(), (URI) element);
        }
      }
    }
  }

  // public static class ConsoleViewAction extends Action{
  //
  // @Override
  // public void run() {
  // // TODO Auto-generated method stub
  // AsteriskDiagramEditorPlugin.getInstance().initDebugConsole();
  //		
  // }
  //
  //	
  // }

  /**
   * @generated
   */
  public static class AboutAction extends WorkbenchWindowActionDelegate {

    /**
     * @generated
     */
    public void run(IAction action) {
      MessageDialog.openInformation(getWindow().getShell(),
          Messages.DiagramEditorActionBarAdvisor_AboutDialogTitle,
          Messages.DiagramEditorActionBarAdvisor_AboutDialogMessage);
    }

  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {

    /*
     * // TODO Auto-generated method stub System.out.println("deleteAction:" + event);
     * Object obj = event.getSource(); RetargetAction ra = null; if (obj instanceof
     * RetargetAction) { ra = (RetargetAction) obj; } if (ra == null) { return; } if
     * (!ra.getActionDefinitionId().equals("org.eclipse.ui.edit.delete")) { return; }
     * if(!ra.isHandled()){ return; }
     * 
     * IEditorReference[] editors = this.getWindow().getActivePage()
     * .getEditorReferences(); // editors[i]. for (int i = 0; i < editors.length; i++) {
     * try {
     * 
     * Object filelo = editors[i].getEditorInput(); URI uri = null; if (filelo instanceof
     * URIEditorInput) { URIEditorInput uriFile = (URIEditorInput) filelo;
     * 
     * if (!uriFile.exists()) { this.getWindow().getActivePage().closeEditor(
     * editors[i].getEditor(false), false); } } } catch (Exception ex) {
     * ex.printStackTrace(); } }
     */

  }

  public static class NewDBConnectionDelegate extends WorkbenchWindowActionDelegate {

    /**
     * @generated not
     */
    public void run(IAction action) {
      new NewAliasAction().run();
    }
  }

  public static class NewQueryDelegate extends WorkbenchWindowActionDelegate {

    /**
     * @generated not
     */
    public void run(IAction action) {
      new NewQueryAction().run();
    }
  }

}
