package com.safi.workshop;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionGroup;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.navigator.CommonNavigatorActionGroup;
import org.eclipse.ui.internal.navigator.NavigatorContentService;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonNavigatorManager;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.navigator.ICommonActionConstants;
import org.eclipse.ui.navigator.LinkHelperService;
import org.eclipse.ui.navigator.NavigatorActionService;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.ui.views.properties.IPropertySourceProvider;
import org.eclipse.ui.views.properties.PropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;

import com.ibm.db2.jcc.t4.n;
import com.safi.db.DBConnection;
import com.safi.db.Query;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.EntitlementUtils;
import com.safi.db.manager.PooledDataSourceManager;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.impl.SafiServerImpl;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.preferences.AsteriskConfigurationDialog;
import com.safi.workshop.application.DiagramEditorActionBarAdvisor;
import com.safi.workshop.application.DiagramEditorWorkbenchAdvisor;
import com.safi.workshop.navigator.ServerResourcesDecorator;
import com.safi.workshop.navigator.serverconfig.AddAsteriskServerAction;
import com.safi.workshop.navigator.serverconfig.AsteriskServerList;
import com.safi.workshop.navigator.serverconfig.SafiserverRegisterDialog;
import com.safi.workshop.navigator.serverconfig.UserDialog;
import com.safi.workshop.navigator.serverconfig.UserList;
import com.safi.workshop.navigator.serverconfig.UserManagerAction;
import com.safi.workshop.part.AsteriskDiagramEditor;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;
import com.safi.workshop.sqlexplorer.SQLCannotConnectException;
import com.safi.workshop.sqlexplorer.connections.actions.AbstractConnectionTreeAction;
import com.safi.workshop.sqlexplorer.connections.actions.ChangeAliasAction;
import com.safi.workshop.sqlexplorer.connections.actions.EditDriverAction;
import com.safi.workshop.sqlexplorer.connections.actions.EditUserAction;
import com.safi.workshop.sqlexplorer.connections.actions.OpenQueryInEditorAction;
import com.safi.workshop.sqlexplorer.dbproduct.Alias;
import com.safi.workshop.sqlexplorer.dbproduct.ConnectionListener;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.dbproduct.SQLConnection;
import com.safi.workshop.sqlexplorer.dbproduct.Session;
import com.safi.workshop.sqlexplorer.dbproduct.User;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditor;
import com.safi.workshop.sqlexplorer.plugin.editors.SQLEditorInput;
import com.safi.workshop.sqlexplorer.plugin.views.DatabaseStructureView;
import com.safi.workshop.util.SafletPersistenceManager;

public class SafiNavigator extends CommonNavigator implements IPropertyChangeListener,
    IPropertyListener, IWorkbenchListener, IPartListener, ISelectionChangedListener,
    ISelectionListener, ITabbedPropertySheetPageContributor, IPropertySourceProvider,
    ConnectionListener, IMenuListener, MenuListener {

  private static final Set<SQLConnection> EMPTY_CONNECTIONS = Collections.emptySet();
  private static final Set<ManagedDriver> EMPTY_DRIVERS = Collections.emptySet();
  private static final Set<Alias> EMPTY_ALIASES = Collections.emptySet();
  private static final Set<User> EMPTY_USERS = Collections.emptySet();
  private static final Set<Query> EMPTY_QUERIES = Collections.emptySet();
  private Clipboard clipboard;
  private User defaultUser;
//  private LinkHelperService linkService;
  private static IStructuredSelection cachedSelection;

  private ExecutorService executor = Executors.newSingleThreadExecutor();

  public SafiNavigator() {
    // TODO Auto-generated constructor stub
    // this.setSite(this.getViewSite().);
    super();
    this.setLinkingEnabled(true);

    // MenuManager menuManager=new MenuManager();
    // this.getSite().
    // this.getSite().registerContextMenu(menuManager,super.getSite().getSelectionProvider()
    // );
    // ServerUtilities.getInstance().addServerStartupCallback(
    // new ServerUtilities.ServerStartupCallback() {
    // @Override
    // public void serverFailedToStart(String msg) {
    // synchronized (ServerUtilities.lock) {
    // ServerUtilities.lock.notifyAll();
    // }
    // refresh();
    // }
    //
    // @Override
    // public void serverStarted() {
    //
    // // refresh();
    // }
    //
    // @Override
    // public void serverStopped() {
    // synchronized (ServerUtilities.lock) {
    // ServerUtilities.lock.notifyAll();
    // }
    // // refresh();
    // }
    //
    // public boolean removeOnServerStop() {
    // // refresh();
    // return false;
    // }
    // });

  }

  @Override
  public void init(IViewSite site) throws PartInitException {
    super.init(site);
    this.addPartPropertyListener(this);
    this.addPropertyListener(this);

    // IPartService.addPartListener(this);

  }

  @Override
  public void dispose() {
    if (clipboard != null) {
      clipboard.dispose();
      clipboard = null;
    }
    if (SQLExplorerPlugin.getDefault() != null
        && SQLExplorerPlugin.getDefault().getAliasManager() != null)
      SQLExplorerPlugin.getDefault().getAliasManager().removeListener(this);
    super.dispose();
  }

  @Override
  protected CommonNavigatorManager createCommonManager() {
    // TODO Auto-generated method stub
    return super.createCommonManager();
  }

  @Override
  protected CommonViewer createCommonViewer(Composite parent) {
    // TODO Auto-generated method stub

    final CommonViewer _treeViewer = super.createCommonViewer(parent);

    // SQLExplorerPlugin.getDefault().getAliasManager().addListener(this);
    // doubleclick on alias opens session
    _treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

      @Override
      public void selectionChanged(SelectionChangedEvent event) {
        // TODO Auto-generated method stub
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        if (selection != null) {
          // User user = null;
          Object selected = selection.getFirstElement();
          if (selected != null) {
            _treeViewer.setExpandedState(selected, true);
          }
        }
      }

    });
    _treeViewer.addDoubleClickListener(new IDoubleClickListener() {
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        if (selection != null) {
          // User user = null;
          Object selected = selection.getFirstElement();
          if (selected != null) {
            _treeViewer.setExpandedState(selected, true);
          }
          if (selected instanceof ManagedDriver) {
            new EditDriverAction().run();
          } else if (selected instanceof Alias) {
            // Alias alias = (Alias) selection.getFirstElement();
            // user = alias.getDefaultUser();
            ChangeAliasAction ca = new ChangeAliasAction();
            ca.run();
          } else if (selected instanceof User) {
            // user = (User) selected;
            EditUserAction eu = new EditUserAction();
            eu.run();
          } else if (selected instanceof SQLConnection) {
            ChangeAliasAction ca = new ChangeAliasAction();
            ca.run();
            // user = ((SQLConnection) selected).getUser();
          } else if (selected instanceof Query) {
            // Alias alias = getAliasForQuery((Query)selected);
            // user = alias.getDefaultUser();

            DatabaseStructureView dsView = SQLExplorerPlugin.getDefault()
                .getDatabaseStructureView();
            Alias alias = getAliasForQuery((Query) selected);
            if (alias != null && alias.getDefaultUser() != null
                && !alias.getDefaultUser().isOfflineMode()
                && !alias.getDefaultUser().hasAuthenticated()) {
              try {
                dsView.addUser(alias.getDefaultUser());
              } catch (SQLCannotConnectException e) {
                // MessageDialog.openError(Display.getDefault().getActiveShell(), "Cannot
                // connect", e
                // .getMessage());
                SQLExplorerPlugin.error("Couldn't connect", e);
              } catch (Throwable e) {
                SQLExplorerPlugin.error("Error creating sql editor", e);
              }
            }

            OpenQueryInEditorAction action = new OpenQueryInEditorAction();
            action.run();

          }
          // if (user != null) {
          // NewQueryAction action = new NewQueryAction();
          // action.run();
          // // openNewEditor(user);
          // }
          /*
           * else if (selected instanceof EList<?>) {
           * 
           * if (selected instanceof AsteriskServerList){ new
           * AddAsteriskServerAction().run(); } if (!(selected instanceof
           * HibernatePersistableEList)) return; HibernatePersistableEList elementElist =
           * (HibernatePersistableEList) selected; PersistentList pList = (PersistentList)
           * elementElist.getDelegate(); if
           * ("SafiServer.asteriskServers".equals(pList.getRole())) { new
           * AddAsteriskServerAction().run(); } else if
           * ("SafiServer.users".equals(pList.getRole())) { UserManagerAction action = new
           * UserManagerAction(); action.run(); // try { // EList<User> server =
           * (EList<User>) selected; // } catch (Exception ex) { // } } }
           */
          else if (selected instanceof AsteriskServerList) {
            com.safi.db.server.config.User user = SafiServerPlugin.getDefault().getCurrentUser();
            if (!EntitlementUtils.isUserEntitled(user,
                EntitlementUtils.ENTIT_MANAGE_ASTERISK_SERVERS)) {
              MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                  "You do not have sufficient privileges to carry out this operation.");
              return;
            }
            new AddAsteriskServerAction().run();
          } else if (selected instanceof UserList) {

            new UserManagerAction().run();
          }

          else if (selected instanceof SafiServer) {
            SafiServer safiSelected = (SafiServer) selected;
            {
              SafiserverRegisterDialog dlg = new SafiserverRegisterDialog(_treeViewer.getTree()
                  .getShell());
              int result = dlg.open();
              if (result == Window.OK)
                refresh();
            }
            /*
             * if (safiSelected.getId() == -1 &&
             * SafiServerPlugin.getDefault().getLocalServer() != safiSelected) {
             * SafiserverRegisterDialog dlg = new
             * SafiserverRegisterDialog(_treeViewer.getTree() .getShell()); dlg.open(); }
             * else { SafiServerAdminDialog safi = new
             * SafiServerAdminDialog(_treeViewer.getTree() .getShell(), safiSelected); int
             * result = safi.open(); if (result == Dialog.OK) refresh(selected); }
             */
            // }
          } else if (selected instanceof AsteriskServer) {
            AsteriskServer asteriskSelected = (AsteriskServer) selected;
            {
              com.safi.db.server.config.User user = SafiServerPlugin.getDefault().getCurrentUser();
              if (!EntitlementUtils.isUserEntitled(user,
                  EntitlementUtils.ENTIT_MANAGE_ASTERISK_SERVERS)) {
                MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                    "You do not have sufficient privileges to carry out this operation.");
                return;
              }
              AsteriskConfigurationDialog astercfg = new AsteriskConfigurationDialog(_treeViewer
                  .getTree().getShell(), asteriskSelected);
              int result = astercfg.open();
              if (result == Window.OK) {
                astercfg.commit();
                refresh();
              }
            }
          } else if (selected instanceof com.safi.db.server.config.User) {
            com.safi.db.server.config.User user = SafiServerPlugin.getDefault().getCurrentUser();
            if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_MANAGE_USERS)) {
              MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
                  "You do not have sufficient privileges to carry out this operation.");
              return;
            }
            com.safi.db.server.config.User userSelected = (com.safi.db.server.config.User) selected;
            UserDialog userDialog = new UserDialog(_treeViewer.getTree().getShell(), userSelected);
            userDialog.open();
          } else if (selected instanceof IFile) {
            IFile file = (IFile) selected;
            String fileName = file.toString();
            IWorkbenchPage page = getSite().getPage();
            if (fileName != null && fileName.endsWith(".saflet")) {
              // URI uri = URI.createFileURI(file.getFullPath().toOSString());
              URI uri = URI.createFileURI(file.getRawLocation().toString());

              DiagramEditorActionBarAdvisor.openEditor(page.getWorkbenchWindow().getWorkbench(),
                  uri);
            } else {
              try {
                IDE.openEditor(page, file);
              } catch (PartInitException e) {
                e.printStackTrace();
              }
            }
          }
        }
      }
    });

    _treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      // _treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        cachedSelection = new StructuredSelection(((IStructuredSelection) event.getSelection())
            .toList());
        refreshToolbar();
      }

    });
    getSite().setSelectionProvider(_treeViewer);
    return _treeViewer;
  }

  // private void buildContextMenu() {
  //	
  // MenuManager mgr = new MenuManager("SafiNavigatorContextMenu");
  // Menu menu = mgr.createContextMenu(getCommonViewer().getTree());
  // mgr.add(new org.eclipse.jface.action.ContributionItem(){
  // @Override
  // public void fill(Menu menu, int index) {
  // // TODO Auto-generated method stub
  // super.fill(menu, index);
  // MenuItem closeItem = new MenuItem(menu, SWT.PUSH, index);
  // closeItem.setText("Hi Niggler");
  // }
  // });
  //    
  // getViewSite().registerContextMenu(mgr, getCommonViewer());
  //    
  // }

  @Override
  protected ActionGroup createCommonActionGroup() {

    CommonNavigatorActionGroup ag = new CommonNavigatorActionGroup(this, getCommonViewer(),
        getLinkHelperService()) {
      @Override
      public void fillActionBars(IActionBars theActionBars) {
        // TODO Auto-generated method stub
        super.fillActionBars(theActionBars);
        // fillContextMenu(theActionBars.getMenuManager());
      }

      @Override
      public void fillContextMenu(IMenuManager menu) {
        // super.fillContextMenu(menu);
        // SafiNavigator view = AsteriskDi;agramEditorUtil
        // .getSafiNavigator();
        //
        // // ConnectionsView view =
        // // SQLExplorerPlugin.getDefault().getConnectionsView();
        // Object[] selection = (view == null) ? null : view.getSelected();
        //
        // // If nothing is selected, then show the default ones
        // if (selection == null || selection.length != 1) {

        addAction(menu, new UpdateAction(PlatformUI.getWorkbench().getActiveWorkbenchWindow()));
        // addAction(menu, new CloseConnectionAction());
        // addAction(menu, new CloseAllConnectionsAction());
        // return;
        // }
        //
        // if (selection[0] instanceof Alias) {
        // Alias alias = (Alias) selection[0];
        //
        // addAction(menu, new NewEditorAction());
        // addAction(menu, new NewDatabaseStructureViewAction());
        // addAction(menu, new ConnectAliasAction());
        // menu.add(new Separator());
        // for (User user : alias.getUsers())
        // if (!user.isAutoCommit()) {
        // addAction(menu, new CommitAction());
        // addAction(menu, new RollbackAction());
        // menu.add(new Separator());
        // break;
        // }
        //
        // addAction(menu, new ChangeAliasAction());
        // addAction(menu, new CopyAliasAction());
        // addAction(menu, new DeleteAction());
        // addAction(menu, new NewQueryAction());
        //
        // } else if (selection[0] instanceof Query) {
        // Query qry = (Query) selection[0];
        //
        // addAction(menu, new OpenQueryInEditorAction());
        // addAction(menu, new NewDatabaseStructureViewAction());
        // addAction(menu, new ConnectAliasAction());
        // // addAction(menu, new ChangeQueryAction());
        // addAction(menu, new NewQueryAction());
        // menu.add(new Separator());
        //
        // addAction(menu, new DeleteAction());
        //
        // } else if (selection[0] instanceof User) {
        // User user = (User) selection[0];
        //
        // addAction(menu, new NewEditorAction());
        // addAction(menu, new NewDatabaseStructureViewAction());
        // addAction(menu, new ConnectAliasAction());
        // addAction(menu, new NewQueryAction());
        // menu.add(new Separator());
        // if (!user.isAutoCommit()) {
        // addAction(menu, new CommitAction());
        // addAction(menu, new RollbackAction());
        // menu.add(new Separator());
        // }
        //
        // addAction(menu, new NewUserAction());
        // addAction(menu, new EditUserAction());
        // addAction(menu, new CopyUserAction());
        // addAction(menu, new DeleteAction());
        //
        // } else if (selection[0] instanceof SQLConnection) {
        // SQLConnection connection = (SQLConnection) selection[0];
        //
        // addAction(menu, new NewEditorAction());
        // addAction(menu, new NewDatabaseStructureViewAction());
        // menu.add(new Separator());
        //
        // if (!connection.getUser().isAutoCommit()) {
        // addAction(menu, new CommitAction());
        // addAction(menu, new RollbackAction());
        // menu.add(new Separator());
        // }
        //
        // addAction(menu, new CloseConnectionAction());
        // } else if (selection[0] instanceof ManagedDriver) {
        // addAction(menu, new DeleteAction());
        // addAction(
        // menu,
        // new com.safi.workshop.sqlexplorer.connections.actions.EditDriverAction());
        // addAction(menu, new NewDriverAction());
        // }
      }

      private boolean addAction(IMenuManager menu, Action action) {
        if (true || action.isEnabled()) {
          menu.add(action);
          action.setEnabled(true);
          return true;
        }
        return false;
      }
    };

    return ag;
  }

//  @Override 
//  protected synchronized LinkHelperService getLinkHelperService() {
//    if (linkService==null){
//      linkService = super.getLinkHelperService();
//    }
//    if (linkService == null)
//      linkService = new LinkHelperService((NavigatorContentService) getCommonViewer()
//          .getNavigatorContentService());
//    return linkService;
//  }

  // public Object[] getSelected() {
  // IStructuredSelection selection = getViewerSelection();
  // if (selection == null)
  // return null;
  // Object[] result = selection.toArray();
  // if (result.length == 0)
  // return null;
  // return result;
  // }

  public void refresh() {
    // CommonViewer common = this.getCommonViewer();
    // super.getSite().getWorkbenchWindo
    Shell shell = getSite().getShell();
    if (shell == null || shell.isDisposed())
      return;
    Runnable runnable = new Runnable() {
      public void run() {

        Object select = getCommonViewer().getSelection();
        IStructuredSelection selection = null;
        if (select != null && select instanceof IStructuredSelection) {
          selection = (IStructuredSelection) select;
        }
        if (!getCommonViewer().getTree().isDisposed()) {
          TreePath[] p = null;
          Object[] ee = null;
          try {
            p = getCommonViewer().getExpandedTreePaths();
            ee = getCommonViewer().getExpandedElements();
          } catch (Exception e) {
            e.printStackTrace();
          }
          getCommonViewer().refresh(true);
          ServerResourcesDecorator.updateServerResourcesDecorators();// why should i have
          // to do this?
          if (selection != null && !selection.isEmpty()) {
            // User user = null;
            Object selected = selection.getFirstElement();
            if (selected != null) {
              if (ee != null)
                getCommonViewer().setExpandedElements(ee);

              if (p != null)
                getCommonViewer().setExpandedTreePaths(p);
              getCommonViewer().reveal(selected);
              getCommonViewer().setExpandedState(selected, true);
            }
          }

        }
      }
    };
    if (Thread.currentThread() != shell.getDisplay().getThread())
      shell.getDisplay().asyncExec(runnable);
    else
      runnable.run();

  }

  public void expandAll() {
    getCommonViewer().expandAll();
  }

  public void refresh(final Object item) {
    // CommonViewer common = this.getCommonViewer();
    Shell shell = getSite().getShell();
    if (shell == null || shell.isDisposed())
      return;
    shell.getDisplay().asyncExec(new Runnable() {
      public void run() {
        Object select = getCommonViewer().getSelection();
        IStructuredSelection selection = null;
        if (select != null && select instanceof IStructuredSelection) {
          selection = (IStructuredSelection) select;
        }

        if (!getCommonViewer().getTree().isDisposed()) {
          TreePath[] p = getCommonViewer().getExpandedTreePaths();
          getCommonViewer().refresh(item);
          // getCommonViewer().setExpandedTreePaths(treePaths)
          if (selection != null) {
            // User user = null;
            Object selected = selection.getFirstElement();
            if (selected != null) {
              getCommonViewer().setExpandedTreePaths(p);
              getCommonViewer().reveal(selected);
              getCommonViewer().setExpandedState(selected, true);
            }
          }

        }

      }
    });
  }

  public void modelChanged() {
    modelChanged(false);
  }
  public void modelChanged(final boolean rebuildModel) {
    // final Shell shell = getCommonViewer().getControl().getShell();
    Display d = Display.getCurrent();
    if (d == null) {
      d = Display.getDefault();
    }
    if (d.isDisposed())
      return;
    final Runnable runnable = new Runnable() {
      public void run() {

        Control control = getCommonViewer().getControl();
        if (control.isDisposed())
          return;
        Shell shell = control.getShell();

        if (shell == null || shell.isDisposed()) {
          return;
        }
        // this will clear any existing connections.
        PooledDataSourceManager.getInstance().shutdown();
        try {
          DBManager.getInstance().saveSafiDriverManagerToDisk(
              SafiServerPlugin.getDefault().getDriverManager());
        } catch (final Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
          AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't save manager to disk", e);
          MessageDialog.openError(getCommonViewer().getTree().getShell(), "Write Error",
              "Coudln't save DB resources to disk: " + e.getLocalizedMessage());

        }

        if (!getCommonViewer().getTree().isDisposed()) {
          // IDecoratorManager decoratorManager =
          // AsteriskDiagramEditorPlugin.getInstance()
          // .getWorkbench().getDecoratorManager();
          //          
          // decoratorManager.update(DirtyDecorator.DECORATOR_ID);
          // DirtyDecorator.getDirtyDecorator().refresh();
          // DirtyDecorator2.getDirtyDecorator().refresh();
          ISelection selected = getCommonViewer().getSelection();
//          getCommonViewer().setInput(getCommonViewer().getInput());
          if (rebuildModel)
            rebuildModel();
          else
           getCommonViewer().refresh(true);
          refreshToolbar();
          getCommonViewer().setSelection(selected, true);

          // DirtyDecorator.getDirtyDecorator().refresh(getAllItems());
        }
      }
    };
    if (d.getThread() == Thread.currentThread())
      runnable.run();
    else
      d.asyncExec(runnable);
  }

  //warning...this takes awhile
  public void rebuildModel(){
    getCommonViewer().setInput(getCommonViewer().getInput());
  }
  
  private void refreshToolbar() {
    IToolBarManager toolbar = getViewSite().getActionBars().getToolBarManager();
    IContributionItem[] items = toolbar.getItems();
    for (IContributionItem item : items) {
      if (item instanceof ActionContributionItem) {
        ActionContributionItem contrib = (ActionContributionItem) item;
        if (contrib.getAction() instanceof AbstractConnectionTreeAction) {
          AbstractConnectionTreeAction action = (AbstractConnectionTreeAction) contrib.getAction();
          action.setEnabled(action.isAvailable());
        }
      }
    }

  }

  // public List<Object> getAllItems() {
  // Object input = getCommonViewer().getInput();
  // // WorkspaceRoot root = (WorkspaceRoot)input;
  // final List<Object> obs = new ArrayList<Object>();
  // for (TreeItem item : getCommonViewer().getTree().getItems()) {
  // Object data = item.getData();
  // if (data != null) {
  // addElements(obs, data, ((ITreeContentProvider)
  // getCommonViewer().getContentProvider()));
  // }
  // }
  // return obs;
  // }
  //
  // private void addElements(List<Object> list, Object parent, ITreeContentProvider
  // provider) {
  // for (Object o : provider.getChildren(parent)) {
  // addElements(list, o, provider);
  // }
  // list.add(parent);
  // }

  public void openNewEditor(User user) {
    try {
      // First time we connect, get the database structure view up too
      if (!user.hasAuthenticated()) {
        DatabaseStructureView dsView = SQLExplorerPlugin.getDefault().getDatabaseStructureView();
        dsView.addUser(user);
      }

      SQLEditorInput input = new SQLEditorInput("SQL Editor ("
          + SQLExplorerPlugin.getDefault().getEditorSerialNo() + ").sql");
      input.setUser(user);
      IWorkbenchPage page = AsteriskDiagramEditorPlugin.getDefault().getWorkbench()
          .getActiveWorkbenchWindow().getActivePage();
      page.openEditor(input, SQLEditor.class.getName());
      switchToDBPerspective();
    } catch (SQLCannotConnectException e) {
      // MessageDialog.openError(Display.getDefault().getActiveShell(), "Cannot connect",
      // e
      // .getMessage());
      SQLExplorerPlugin.error("Couldn't connect", e);
    } catch (Throwable e) {
      SQLExplorerPlugin.error("Error creating sql editor", e);
    }
  }

  public IStructuredSelection getViewerSelection() {
    if (getCommonViewer() == null || getCommonViewer().getTree().isDisposed())
      return null;
    IStructuredSelection selection = (IStructuredSelection) getCommonViewer().getSelection();
    if (selection != null && !selection.isEmpty())
      return selection;
    return cachedSelection;
  }

  /**
   * Returns a list of the selected Aliases. If recurse is true then the result will
   * include any aliases associated with other objects; eg, if a connection is selected
   * and recurse is true, then the connection's alias will also be returned
   * 
   * @param recurse
   * @return Set of Aliases, never returns null
   */
  public Set<Alias> getSelectedAliases(boolean recurse) {

    IStructuredSelection selection = getViewerSelection();
    if (selection == null || selection.isEmpty())
      return EMPTY_ALIASES;

    java.util.LinkedHashSet<Alias> result = new LinkedHashSet<Alias>();
    Iterator iter = selection.iterator();
    while (iter.hasNext()) {
      Object obj = iter.next();
      if (obj instanceof Alias)
        result.add((Alias) obj);
      else if (recurse) {
        if (obj instanceof User) {
          User user = (User) obj;
          result.add(user.getAlias());
        } else if (obj instanceof SQLConnection) {
          SQLConnection connection = (SQLConnection) obj;
          result.add(connection.getUser().getAlias());
        } else if (obj instanceof Query) {
          result.add(getAliasForQuery((Query) obj));
        }
      }
    }

    return result;
  }

  public Alias getAliasForQuery(Query obj) {
    DBConnection conn = obj.getConnection();
    for (Alias a : SQLExplorerPlugin.getDefault().getAliasManager().getAliases()) {
      if (a.getConnection() == conn)
        return a;
    }
    return null;
  }

  public Set<Query> getSelectedQueries(boolean recurse) {
    IStructuredSelection selection = getViewerSelection();
    // if (selection == null)
    // selection = cachedSelection;
    if (selection == null || selection.isEmpty()) {
      return EMPTY_QUERIES;
    }

    LinkedHashSet<Query> result = new LinkedHashSet<Query>();
    Iterator iter = selection.iterator();
    while (iter.hasNext()) {
      Object obj = iter.next();
      if (obj instanceof Query)
        result.add((Query) obj);
      else if (recurse) {
        if (obj instanceof Alias) {
          Alias alias = (Alias) obj;
          result.addAll(alias.getConnection().getQueries());
        }
      }
    }

    return result;
  }

  /**
   * Returns the first available selected alias; if recurse is true, then indirectly
   * selected aliases are included (eg a selected connection's alias)
   * 
   * @param recurse
   * @return
   */
  public Alias getSelectedAlias(boolean recurse) {
    return (Alias) getFirstOf(getSelectedAliases(recurse));
  }

  /**
   * Returns a list of selected Users; if recurse is true, indirectly selected users are
   * included also (eg a session's user)
   * 
   * @param recurse
   * @return Set of Users, never returns null
   */
  public Set<User> getSelectedUsers(boolean recurse) {
    IStructuredSelection selection = getViewerSelection();

    // TreeItem[] selection = getCommonViewer().getTree().getSelection();
    if (selection == null || selection.isEmpty())
      return EMPTY_USERS;

    LinkedHashSet<User> result = new LinkedHashSet<User>();
    Iterator iter = selection.iterator();
    while (iter.hasNext()) {
      Object obj = iter.next();
      if (obj instanceof User)
        result.add((User) obj);
      else if (recurse) {
        if (obj instanceof Alias) {
          Alias alias = (Alias) obj;
          result.addAll(alias.getUsers());
        } else if (obj instanceof SQLConnection) {
          SQLConnection connection = (SQLConnection) obj;
          result.add(connection.getUser());
        }
      }
    }

    return result;
  }

  /**
   * Returns the first selected user; if recurse is true, this includes indirectly
   * selected users (eg an Alias' user)
   * 
   * @param recurse
   * @return
   */
  public User getSelectedUser(boolean recurse) {
    return (User) getFirstOf(getSelectedUsers(recurse));
  }

  /**
   * Returns a list of selected sessions; if recurse is true, then it includes indirectly
   * selected sessions (eg a selected user's sessions)
   * 
   * @param recurse
   * @return Set of Sessions, never returns null
   */
  public Set<SQLConnection> getSelectedConnections(boolean recurse) {
    IStructuredSelection selection = getViewerSelection();
    if (selection == null || selection.isEmpty())
      return EMPTY_CONNECTIONS;

    LinkedHashSet<SQLConnection> result = new LinkedHashSet<SQLConnection>();
    Iterator iter = selection.iterator();
    while (iter.hasNext()) {
      Object obj = iter.next();
      if (obj instanceof SQLConnection)
        result.add((SQLConnection) obj);
      else if (recurse) {
        if (obj instanceof Alias) {
          Alias alias = (Alias) obj;
          for (User user : alias.getUsers())
            result.addAll(user.getConnections());
        } else if (obj instanceof User) {
          User user = (User) obj;
          result.addAll(user.getConnections());
        }
      }
    }

    return result;
  }

  /**
   * Returns the first selected connection; if recurse is true, then includes indirectly
   * selected sessions
   * 
   * @param recurse
   * @return
   */
  public SQLConnection getSelectedConnection(boolean recurse) {
    return (SQLConnection) getFirstOf(getSelectedConnections(recurse));
  }

  public Set<ManagedDriver> getSelectedDrivers(boolean recurse) {
    IStructuredSelection selection = getViewerSelection();
    if (selection == null || selection.isEmpty())
      return EMPTY_DRIVERS;

    LinkedHashSet<ManagedDriver> result = new LinkedHashSet<ManagedDriver>();
    Iterator iter = selection.iterator();
    while (iter.hasNext()) {
      Object obj = iter.next();
      if (obj instanceof ManagedDriver)
        result.add((ManagedDriver) obj);
      else if (recurse) {
        if (obj instanceof Alias) {
          result.add(((Alias) obj).getDriver());
        } else if (obj instanceof User) {
          User user = (User) obj;
          result.add(user.getAlias().getDriver());
        } else if (obj instanceof SQLConnection) {
          SQLConnection connection = (SQLConnection) obj;
          result.add(connection.getUser().getAlias().getDriver());
        } else if (obj instanceof Query) {
          result.add(getAliasForQuery((Query) obj).getDriver());
        }
      }
    }

    return result;
  }

  public ManagedDriver getSelectedDriver(boolean recurse) {
    return (ManagedDriver) getFirstOf(getSelectedDrivers(recurse));
  }

  /**
   * Helper method which returns the first element of a set, or null if the set is empty
   * (or if the set is null)
   * 
   * @param set
   *          the set to look into (may be null)
   * @return
   */
  private Object getFirstOf(Set set) {
    if (set == null)
      return null;
    Iterator iter = set.iterator();
    if (iter.hasNext())
      return iter.next();
    return null;
  }

  /**
   * @return the defaultUser
   */
  public User getDefaultUser() {
    if (defaultUser == null) {
      Alias alias = getDefaultAlias();
      if (alias != null)
        return alias.getDefaultUser();
    }
    return defaultUser;
  }

  /**
   * @param defaultUser
   *          the defaultUser to set
   */
  public void setDefaultUser(User lastSelectedUser) {
    this.defaultUser = lastSelectedUser;
  }

  private Alias getDefaultAlias() {
    IStructuredSelection selection = getViewerSelection();
    if (selection == null || selection.isEmpty())
      return null;

    Object element = selection.getFirstElement();

    if (element instanceof Alias)
      return (Alias) element;
    else if (element instanceof Session) {
      ITreeContentProvider provider = (ITreeContentProvider) getCommonViewer().getContentProvider();
      return (Alias) provider.getParent(element);
    }

    return null;
  }

  /**
   * @return the clipboard
   */
  public Clipboard getClipboard() {
    if (clipboard == null)
      clipboard = new Clipboard(getSite().getShell().getDisplay());
    return clipboard;
  }

  /**
   * @param clipboard
   *          the clipboard to set
   */
  public void setClipboard(Clipboard clipboard) {
    this.clipboard = clipboard;
  }

  @Override
  public void propertyChange(PropertyChangeEvent event) {
    // TODO Auto-generated method stub
    // System.out.println("propertyChanged:" + event);
  }

  @Override
  public void propertyChanged(Object source, int propId) {
    // TODO Auto-generated method stub
    // System.out.println("propertyChanged2" + source + ":" + propId);
    // this.getViewSite().getPage().
  }

  @Override
  public void postShutdown(IWorkbench workbench) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean preShutdown(IWorkbench workbench, boolean forced) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void partActivated(IWorkbenchPart part) {
    if (part instanceof com.safi.workshop.part.AsteriskDiagramEditor) {

      switchToSafletPerspective();

    } else if (part instanceof SQLEditor) {
      switchToDBPerspective();

    }

  }

  @Override
  public void partBroughtToTop(IWorkbenchPart part) {

  }

  @Override
  public void partClosed(IWorkbenchPart part) {
    // TODO Auto-generated method stub

  }

  @Override
  public void partDeactivated(IWorkbenchPart part) {
    // TODO Auto-generated method stub

  }

  @Override
  public void partOpened(IWorkbenchPart part) {
  }

  @Override
  public void selectionChanged(SelectionChangedEvent event) {
    // TODO Auto-generated method stub
    ISelection select = event.getSelection();
    StructuredSelection ss = (StructuredSelection) select;
    refreshToolbar();
    if (!this.isLinkingEnabled())
      return;

    /*
     * Iterator ssIter=ss.iterator(); while(ssIter.hasNext()){ Object
     * object=ssIter.next(); if(object instanceof IFile){ IFile ff=(IFile) object; } }
     */
    this.activateEditor(this.getViewSite().getPage(), ss);
  }

  @Override
  public void createPartControl(Composite aParent) {

    super.createPartControl(aParent);
    Menu menu = this.getCommonViewer().getTree().getMenu();
    menu.addMenuListener(this);
    /*
     * MenuManager menuManager=new MenuManager(); Menu menu =
     * menuManager.createContextMenu(this.getCommonViewer().getTree());
     * //this.getCommonViewer().getTree().setMenu(menu);
     * this.getSite().registerContextMenu(menuManager, this.getCommonViewer());
     * menuManager.addMenuListener(this);
     */

    IResourceChangeListener resourceChangeListener = new IResourceChangeListener() {
      public void resourceChanged(IResourceChangeEvent event) {
        // Only listening to these.
        if (event.getType() == IResourceChangeEvent.POST_CHANGE) {

          IResourceDelta delta = event.getDelta();
          try {
            class ResourceDeltaVisitor implements IResourceDeltaVisitor {

              public boolean visit(IResourceDelta delta) {
                if (delta.getFlags() != IResourceDelta.MARKERS
                    && (delta.getResource().getType() == IResource.FILE || delta.getResource()
                        .getType() == IResource.PROJECT)) {
                  if ((delta.getFlags() & IResourceDelta.MOVED_FROM) != 0) {
                    IPath from = delta.getMovedFromPath();
                    IPath to = delta.getResource().getFullPath();
                    if (from == null || to == null)
                      return true;
                    String oldName = from.toFile().getName();
                    String newName = to.toFile().getName();
                    if (delta.getResource().getType() == IResource.FILE) {
                      String ext = delta.getResource().getFullPath().getFileExtension();
                      if (!"saflet".equalsIgnoreCase(ext))
                        return true;
                    }
                    if (!StringUtils.equals(oldName, newName)) {
                      try {
                        if (delta.getResource().getType() == IResource.FILE) {
                          final IFile f = (IFile) delta.getResource();
                          final String fname = newName;
                          Runnable runna = new Runnable() {
                            public void run() {
                              int count = 0;
                              while (count++ < 10
                                  && !SafletPersistenceManager.getInstance().renameSaflet(f, fname)) {
                                try {
                                  Thread.sleep(500);
                                } catch (Exception e) {
                                }
                              }
                            }
                          };
                          executor.execute(runna);
                          // delta.getResource().setPersistentProperty(
                          // SafletPersistenceManager.SAFLET_NAME_KEY, newName);
                        } else {
                          delta.getResource().setPersistentProperty(
                              SafletPersistenceManager.MODIFIED_KEY,
                              String.valueOf(System.currentTimeMillis()));
                        }
                      } catch (CoreException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        AsteriskDiagramEditorPlugin.getInstance().logError(
                            "Couldn't update Safi Persistence Properties for "
                                + delta.getResource(), e);
                      }

                    }

                  }
                  refreshEditor();
                }

                return true;
              }

            }

            ResourceDeltaVisitor visitor = new ResourceDeltaVisitor();
            delta.accept(visitor);

          } catch (CoreException exception) {
            AsteriskDiagramEditorPlugin.getInstance().logError("Resource Change Error", exception);
          }
        }

      }
    };

    ResourcesPlugin.getWorkspace().addResourceChangeListener(resourceChangeListener,
        IResourceChangeEvent.POST_CHANGE);

    this.getViewSite().getPage().addSelectionListener(this);
    this.getCommonViewer().addSelectionChangedListener(this);

  }

  public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {
    if (aSelection == null || aSelection.isEmpty())
      return;
    if (aSelection.getFirstElement() instanceof IFile) {
      IFile file = (IFile) aSelection.getFirstElement();
      URI uri = URI.createFileURI(file.getRawLocation().toString());
      URIEditorInput fileInput = new URIEditorInput(uri);
      IEditorPart editor = null;
      if ((editor = aPage.findEditor(fileInput)) != null) {
        aPage.bringToTop(editor);
        this.switchToSafletPerspective();
      }

    } else if (aSelection.getFirstElement() instanceof Query) {
      Query query = (Query) aSelection.getFirstElement();
      SQLEditorInput sqlEditorInput = new SQLEditorInput(query);
      IEditorPart editor = null;
      if ((editor = aPage.findEditor(sqlEditorInput)) != null) {
        aPage.bringToTop(editor);
        this.switchToDBPerspective();
      }
    }

  }

  private void refreshEditor() {
    final IEditorReference[] editors = this.getViewSite().getWorkbenchWindow().getActivePage()
        .getEditorReferences();
    // editors[i].
    for (IEditorReference editor : editors) {
      try {

        Object filelo = editor.getEditorInput();
        URI uri = null;
        if (filelo instanceof URIEditorInput) {
          URIEditorInput uriFile = (URIEditorInput) filelo;
          uri = uriFile.getURI();
          // IStatus status
          // =ResourcesPlugin.getWorkspace().validatePath(uri.path(),
          // IResource.FILE);
          if (uriFile.exists()) {

          } else {

            close(editor);

          }
        }

      } catch (Exception ex) {
        ex.printStackTrace();
      }
    }

  }

  private void close(final IEditorReference ref) {

    this.getCommonViewer().getTree().getDisplay().asyncExec(new Runnable() {

      @Override
      public void run() {
        // TODO Auto-generated method stub
        getViewSite().getWorkbenchWindow().getActivePage().closeEditor(ref.getEditor(false), false);
      }

    });

  }

  @Override
  public void init(IViewSite site, IMemento memento) throws PartInitException {
    // TODO Auto-generated method stub
    super.init(site, memento);
    AsteriskDiagramEditorUtil.setSafiNavigator(this);
  }

  public void resetPerspective() {

    getViewSite().getWorkbenchWindow().getActivePage().resetPerspective();
  }

  public void setSafletPespective() {

  }

  public void switchToSafletPerspective() {
    try {
      // if(
      // getViewSite().getWorkbenchWindow().getWorkbench().getPerspectiveRegistry().getPerspectives().length==0)
      // return;

      if (getViewSite().getWorkbenchWindow().getActivePage() == null)
        return;
      if (getViewSite().getWorkbenchWindow().getActivePage().getPerspective() == null)
        return;
      if (!DiagramEditorWorkbenchAdvisor.PERSPECTIVE_ID.equals(getViewSite().getWorkbenchWindow()
          .getActivePage().getPerspective().getId())) {
        getViewSite().getWorkbenchWindow().getWorkbench().showPerspective(
            DiagramEditorWorkbenchAdvisor.PERSPECTIVE_ID, getViewSite().getWorkbenchWindow());
        DatabaseStructureView view = (DatabaseStructureView) getSite().getPage().findView(
            "com.safi.workshop.sqlexplorer.plugin.views.DatabaseStructureView");
        // IViewDescriptor
        // iViewDescriptor=getViewSite().getWorkbenchWindow().getWorkbench().getViewRegistry().find("com.safi.workshop.sqlexplorer.plugin.views.DatabaseStructureView");
        if (view != null) {
          getViewSite().getWorkbenchWindow().getActivePage().hideView(view);
        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void switchToDBPerspective() {
    try {
      if (getViewSite().getWorkbenchWindow().getActivePage() == null)
        return;
      if (getViewSite().getWorkbenchWindow().getActivePage().getPerspective() == null)
        return;
      // if(
      // getViewSite().getWorkbenchWindow().getWorkbench().getPerspectiveRegistry().getPerspectives().length==0)
      // return;
      if (!"com.safi.workshop.application.SafiDBPerspective".equals(getViewSite()
          .getWorkbenchWindow().getActivePage().getPerspective().getId())) {

        getViewSite().getWorkbenchWindow().getWorkbench().showPerspective(
            "com.safi.workshop.application.SafiDBPerspective", getViewSite().getWorkbenchWindow());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public void selectionChanged(IWorkbenchPart part, ISelection selection) {
    // TODO Auto-generated method stub

    // if (part instanceof com.safi.workshop.part.AsteriskDiagramEditor) {
    //
    // switchToSafletPerspective();
    //
    // } else if (part instanceof SQLEditor) {
    // switchToDBPerspective();
    //
    // }

  	if (part instanceof com.safi.workshop.part.AsteriskDiagramEditor) {
      AsteriskDiagramEditor ade = (AsteriskDiagramEditor) part;
      
      AsteriskDiagramEditorUtil.setCurrentAsteriskEditor(ade);
  	}
  	else 
  		AsteriskDiagramEditorUtil.setCurrentAsteriskEditor(null);
  	
    if (!this.isLinkingEnabled())
      return;

    if (part instanceof com.safi.workshop.part.AsteriskDiagramEditor) {

      AsteriskDiagramEditor ade = (AsteriskDiagramEditor) part;
      IStructuredSelection ss = this.findSelection(ade.getEditorInput());
      // IResource res=(IResource)ss.getFirstElement();

      // // Object obj= Platform.getAdapterManager().getAdapter(ss,
      // TreeSelection.class);
      // this.getSite().getSelectionProvider().setSelection((ISelection)
      // obj);
      // this.selectReveal(ss);
      this.getCommonViewer().setSelection(ss, true);

    } else if (part instanceof com.safi.workshop.SafiNavigator
        && selection instanceof StructuredSelection) {

      StructuredSelection ss = (StructuredSelection) selection;
      this.activateEditor(this.getViewSite().getPage(), ss);
      // this.firePropertyChange(((IResource)ss.getFirstElement()).get);
    }

  }

  public IStructuredSelection findSelection(IEditorInput anInput) {
    URIEditorInput uInput = (URIEditorInput) anInput;
    IPath p = Path.fromOSString(uInput.getURI().toFileString());
    IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
    IPath rpath = root.getRawLocation();

    String s = p.toOSString();
    String spath = rpath.toOSString();
    if (s.contains(spath)) {
      String newpath = s.replace(spath, "");
    }
    IFile file = root.getFileForLocation(p);

    if (file != null) {
      IProject proj = file.getProject();
      String name = proj.getName();
      TreePath tp = new TreePath(file.getFullPath().segments());
      TreeSelection ts = new TreeSelection(tp);

      return ts;
    }
    return TreeSelection.EMPTY;
  }

  @Override
  public Object getAdapter(Class adapter) {
    if (adapter == IPropertySheetPage.class) {

      PropertySheetPage nsp = new PropertySheetPage();
      nsp.setPropertySourceProvider(this);
      return nsp;

    }
    return super.getAdapter(adapter);
  }

  @Override
  public String getContributorId() {
    // TODO Auto-generated method stub
    return this.getSite().getId();
  }

  @Override
  public IPropertySource getPropertySource(Object object) {
    if (object == null)
      return null;
    if (object instanceof IAdaptable) {
      IPropertySource source = (IPropertySource) ((IAdaptable) object)
          .getAdapter(IPropertySource.class);
      if (source != null)
        return source;
    }
    // TODO Auto-generated method stub
    // StructuredSelection ss = (StructuredSelection)
    // this.getCommonViewer().getSelection();
    // Object irc = ss.getFirstElement();
    return (IPropertySource) Platform.getAdapterManager().getAdapter(object, IPropertySource.class);

  }

  @Override
  public NavigatorActionService getNavigatorActionService() {
    // TODO Auto-generated method stub

    return super.getNavigatorActionService();

  }

  @Override
  protected void handleDoubleClick(DoubleClickEvent anEvent) {

    IAction openHandler = getViewSite().getActionBars().getGlobalActionHandler(
        ICommonActionConstants.OPEN);

    if (openHandler == null) {
      IStructuredSelection selection = (IStructuredSelection) anEvent.getSelection();
      if (selection == null || selection.isEmpty())
        return;
      Object element = selection.getFirstElement();

      TreeViewer viewer = getCommonViewer();
      if (viewer.isExpandable(element)) {
        viewer.setExpandedState(element, !viewer.getExpandedState(element));
      }
    }
  }

  @Override
  public void menuAboutToShow(IMenuManager manager) {

    // TODO Auto-generated method stub
    /*
     * M:org.eclipse.debug.ui.actions.WatchCommand M:additions
     * M:org.eclipse.debug.ui.contextualLaunch.run.submenu
     * M:org.eclipse.debug.ui.contextualLaunch.debug.submenu
     * M:org.eclipse.debug.ui.contextualLaunch.profile.submenu M:team.main
     * M:compareWithMenu M:replaceWithMenu M:addFromHistoryAction
     * M:org.eclipse.ui.articles.action.contribution.navigator.subMenu
     * M:com.safi.workshop.audio.ImportAudioAction
     * M:com.safi.workshop.part.AsteriskCreationWizardDelegate M:com.safi.db.Menu
     * M:com.safi.workshop.navigator.db.DeleteSafletAction
     * M:com.safi.workshop.navigator.DeleteAction
     * M:com.safi.workshop.navigator.db.RetrieveSafletAction
     * M:com.safi.workshop.navigator.db.UpdateResourceAction
     * M:com.safi.workshop.navigator.db.CommitResourceAction M:null M:group.new
     * M:org.eclipse.ui.articles.action.contribution.navigator.subMenu
     */
    // StructuredSelection selection = (StructuredSelection)
    // this.getCommonViewer().getSelection();
    // Object obj = selection.getFirstElement();
    // SafiServerImpl serverImpl = null;
    // if (obj instanceof SafiServerImpl) {
    // serverImpl = (SafiServerImpl) obj;
    // }
    // String id_asteriskCreationWizardDelegate =
    // "com.safi.workshop.part.AsteriskCreationWizardDelegate";
    // String id_ImportAudioAction = "com.safi.workshop.audio.ImportAudioAction";
    // String id_start = "com.safi.server.actions.StartServerAction2";
    // String id_stop = "com.safi.server.actions.StopServerAction2";
    // String id_restart = "AsteriskSafletDesigner.diagram.action1.restartServerAction";
    // IContributionItem[] items = manager.getItems();
    // IContributionItem importAudioAction = null;
    // // "org.eclipse.debug.ui.actions.WatchCommand".equals(items[i].getId())||
    // for (int i = 0; i < items.length; i++) {
    // // System.out.println("M:"+items[i].getId());
    // if ("org.eclipse.debug.ui.actions.WatchCommand".equals(items[i].getId())
    // || "org.eclipse.debug.ui.contextualLaunch.run.submenu".equals(items[i].getId())
    // || "org.eclipse.debug.ui.contextualLaunch.debug.submenu".equals(items[i].getId())
    // || "org.eclipse.debug.ui.contextualLaunch.profile.submenu".equals(items[i].getId())
    // || "team.main".equals(items[i].getId()) ||
    // "compareWithMenu".equals(items[i].getId())
    // || "replaceWithMenu".equals(items[i].getId())
    // || "addFromHistoryAction".equals(items[i].getId())) {
    // // "null".equals(items[i].getId())){
    // // manager.remove(items[i].getId());
    // // items[i].dispose();
    // } else if (id_ImportAudioAction.equals(items[i].getId())) {
    // importAudioAction = items[i];
    // // manager.remove(items[i].getId());
    // // items[i].dispose();
    // }
    //
    // if (serverImpl != null) {
    // if ("Debug".equals(serverImpl.getName())) {
    // if (id_restart.equals(items[i].getId())) {
    // // manager.remove(items[i].getId());
    // }
    //
    // } else {
    // if (id_start.equals(items[i].getId()) || id_stop.equals(items[i].getId())) {
    // // manager.remove(items[i].getId());
    // }
    //
    // }
    //
    // }
    // }
    //
    // if (importAudioAction != null) {
    // // manager.insertAfter(id_asteriskCreationWizardDelegate,importAudioAction );
    // }
  }

  @Override
  public void menuHidden(MenuEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void menuShown(MenuEvent e) {
    // TODO Auto-generated method stub
    Object obj = e.getSource();
    // System.out.println(obj);
    StructuredSelection selection = (StructuredSelection) this.getCommonViewer().getSelection();
    Object aObj = selection.getFirstElement();
    // System.out.println("aboj"+aObj);
    SafiServerImpl serverImpl = null;
    if (aObj instanceof SafiServerImpl) {
      serverImpl = (SafiServerImpl) aObj;
    }

    if (obj instanceof Menu) {
      Menu menu = (Menu) obj;
      MenuItem[] items = menu.getItems();
      if (items == null)
        return;
      for (int i = 0; i < items.length; i++) {
        // System.out.println("Menu:"+i+":"+items[i].getText());
        String anObject = items[i].getText().trim();
        if ("&Run As".equals(anObject) || "&Debug As".equals(anObject)
            || "&Profile As".equals(anObject) || "T&eam".equals(anObject)
            || "Comp&are With".equals(anObject)
            || "Restore from Local Histor&y...".equals(anObject)
            || "Rep&lace With".equals(anObject)) {
          System.err.println("fukter disposing " + anObject);
          items[i].dispose();
        }
        if (aObj instanceof File) {
          if ("".equals(anObject) && (i == 9)) {
            System.err.println("we gotshitfuile " + items[i]);
            items[i].dispose();
          }

        } else {
          if ("".equals(anObject) && (i == 5)) {
            System.err.println("Emptyfuckingitem " + items[i]);
            items[i].dispose();
          }

        }

        if (serverImpl != null) {
          if ("Debug".equals(serverImpl.getName())) {
            if ("Restart Server".equals(items[i].getText())) {
              // manager.remove(items[i].getId());
              items[i].dispose();
            }

          } else {
            if ("&Start SafiServer".equals(items[i].getText())
                || "&Stop SafiServer".equals(items[i].getText())) {
              // manager.remove(items[i].getId());
              items[i].dispose();
            }

          }

        }

      }

    }

  }
}
