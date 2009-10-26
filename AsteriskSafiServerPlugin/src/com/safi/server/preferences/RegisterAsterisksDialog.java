package com.safi.server.preferences;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.nebula.jface.gridviewer.CheckEditingSupport;
import org.eclipse.nebula.jface.gridviewer.GridColumnLabelProvider;
import org.eclipse.nebula.jface.gridviewer.GridTableViewer;
import org.eclipse.nebula.jface.gridviewer.GridViewerColumn;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.hibernate.Session;

import com.safi.db.manager.DBManager;
import com.safi.db.manager.EntitlementUtils;
import com.safi.db.server.config.AsteriskServer;
import com.safi.db.server.config.ConfigFactory;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;

public class RegisterAsterisksDialog extends Dialog {

  private static final String ACTIVE = "Active";
  // private static final String DEBUG = "Debug";
  private static final String HOST = "Host";
  private static final String MANAGER_USER = "Manager";
  private static final String MANAGER_PORT = "ManagerPort";
  private static final String SFTP_USER = "SFTPUser";
  private static final String SFTP_PORT = "SFTPPort";
  private static final String DESCRIPTION = "Description";
  // private static final String[] PROPS = { ACTIVE, DEBUG, HOST, MANAGER_USER,
  // MANAGER_PORT,
  // SFTP_USER, SFTP_PORT, DESCRIPTION };

  class TableLabelProvider extends GridColumnLabelProvider implements ITableLabelProvider {
    int colIndex;

    public TableLabelProvider(int colIndex) {
      this.colIndex = colIndex;
    }

    @Override
    public String getText(Object element) {
      return getColumnText(element, colIndex);
    }

    public String getColumnText(Object element, int columnIndex) {
      if (element instanceof AsteriskServer) {
        AsteriskServer as = (AsteriskServer) element;
        if (columnIndex == 0) {
          return "";
          // return Boolean.toString(as == debugServer);
        } else if (columnIndex == 1) {
          return "";
          // return Boolean.toString(as.isActive());
        } else if (columnIndex == 2) {
          return as.getName();
        } else if (columnIndex == 3) {
          return as.getHostname();
        } else if (columnIndex == 4) {
          return as.getManagerName();
        } else if (columnIndex == 5) {
          try {
            return Integer.toString(as.getManagerPort());
          } catch (Exception ex) {
            return "";
          }
        } else if (columnIndex == 6) {
          return as.getSftpUser();
        } else if (columnIndex == 7) {
          try {
            return Integer.toString(as.getSftpPort());
          } catch (Exception ex) {
            return "";
          }
        } else if (columnIndex == 8) {
          return as.getDescription();
        }
      }
      return element.toString();
    }

    public Image getColumnImage(Object element, int columnIndex) {
      return null;
    }

  }

  class ContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      if (inputElement instanceof List) {
        List list = (List) inputElement;
        return list.toArray();
      } else if (inputElement instanceof AsteriskServer) {
        Object[] asServer = { inputElement };
        return asServer;
      }
      return null;
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }

  // private Table table;
  // private TableViewer tableViewer_1;
  private List<AsteriskServer> asterisks = new ArrayList<AsteriskServer>();
  private List<AsteriskServer> deleted_asterisks = new ArrayList<AsteriskServer>();
  // private ArrayList<SafiServer> safiServerList = new
  // ArrayList<SafiServer>();
  private SafiServer production;
  private IPreferenceStore store = SafiServerPlugin.getDefault().getPreferenceStore();
  // private AsteriskServer debugServer;
  // private AsteriskServer localServer;

  private GridTableViewer tableViewer;
  private Grid table;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public RegisterAsterisksDialog(Shell parentShell) {
    super(parentShell);
    super.setShellStyle(getShellStyle() | SWT.RESIZE | SWT.MAX);

  }

  private void init() throws Exception {
    production = SafiServerPlugin.getDefault().getSafiServer(true);

    if (production != null) {
      for (AsteriskServer a : production.getAsteriskServers()) {
        asterisks.add(new AstServerProxy(a));
      }
      // int astDebugId = store.getInt(PreferenceConstants.PREF_AST_ID_DEBUG);
      // astDebugId = astDebugId == 0 ? -1 : astDebugId;
      // for (AsteriskServer s : asterisks) {
      // if (s.getId() == astDebugId) {
      // debugServer = s;
      // localServer = s;
      // break;
      // }
      // }

    }

    // AsteriskServer dbg = SafiServerPlugin.getDefault().createDebugAsteriskFromStore();

    // if (dbg != null) {
    // debugServer = new AstServerProxy(dbg);
    // localServer = debugServer;
    // this.asterisks.add(debugServer);
    // }
  }

  @Override
  public int open() {
    try {
      init();
    } catch (Exception e) {
      e.printStackTrace();
      MessageDialog.openError(getShell(), "Connect Error",
          "Production SafiServer could not be retrieved: " + e.getLocalizedMessage());
      return CANCEL;
    }
    return super.open();
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {

    Composite container = (Composite) super.createDialogArea(parent);
    container.setLayout(new FillLayout());

    final Group registerAsteriskServerGroup = new Group(container, SWT.NONE);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    registerAsteriskServerGroup.setLayout(gridLayout);
    registerAsteriskServerGroup.setText("Register Asterisk Server");

    tableViewer = new GridTableViewer(registerAsteriskServerGroup, SWT.FULL_SELECTION | SWT.BORDER
        | SWT.H_SCROLL) {

      @Override
      public void update(Object element, String[] properties) {
        super.update(element, properties);
        AsteriskServer s = (AsteriskServer) element;
        GridItem item = tableViewer.getGrid().getItem(asterisks.indexOf(s));
        item.setChecked(0, s.isActive());
        item.setChecked(1, s.isPrivate());
      }

      @Override
      public void refresh() {
        // TODO Auto-generated method stub
        super.refresh();
        updateAll();
      }
    };
    tableViewer.addDoubleClickListener(new IDoubleClickListener() {
      public void doubleClick(final DoubleClickEvent event) {
        Object o = ((IStructuredSelection) event.getSelection()).getFirstElement();
        if (o != null)
          modify();
      }
    });

    // if (tableViewer.getGrid().getHorizontalBar() != null)
    // tableViewer.getGrid().getHorizontalBar().setVisible(true);
    // tableViewer.setLabelProvider(new TableLabelProvider(1));
    tableViewer.setContentProvider(new ContentProvider());
    table = tableViewer.getGrid();
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    table.setLinesVisible(true);
    table.setHeaderVisible(true);

    final CheckboxCellEditor checkCellEditor = new CheckboxCellEditor(tableViewer.getGrid());

    // final GridViewerColumn tca = new GridViewerColumn(tableViewer, SWT.CHECK |
    // SWT.CENTER);
    // tca.getColumn().setCheckable(true);
    // tca.getColumn().setWidth(50);
    // tca.getColumn().setText("Debug");
    // tca.setEditingSupport(new CheckEditingSupport(tableViewer) {
    // protected boolean canEdit(Object element) {
    // return false;
    // }
    //
    // protected CellEditor getCellEditor(Object element) {
    // return null;
    // }
    //
    // protected Object getValue(Object element) {
    // return ((AsteriskServer) element) == debugServer;
    // }
    //
    // public void setValue(Object element, Object value) {
    // // if (((Boolean) value).booleanValue()) {
    // // debugServer = (AsteriskServer) element;
    // // }
    // tableViewer.update(asterisks.toArray(), null);
    // // else
    // // if (debugServer == element)
    // // debugServer = null;
    //
    // }
    // });
    // tca.setLabelProvider(new TableLabelProvider(0));

    final GridViewerColumn tcb = new GridViewerColumn(tableViewer, SWT.CHECK | SWT.CENTER);
    tcb.getColumn().setCheckable(true);
    tcb.getColumn().setWidth(50);
    tcb.getColumn().setText("Active");
    tcb.setLabelProvider(new TableLabelProvider(1));
    tcb.setEditingSupport(new CheckEditingSupport(tableViewer) {
      protected boolean canEdit(Object element) {
        return true;
      }

      protected CellEditor getCellEditor(Object element) {
        return checkCellEditor;
      }

      protected Object getValue(Object element) {
        return ((AsteriskServer) element).isActive();
      }

      public void setValue(Object element, Object value) {
        Boolean b = (Boolean) value;
        ((AsteriskServer) element).setActive(b);
        if (b)
          ((AsteriskServer) element).setPrivate(false);
        tableViewer.update(element, null);
      }
    });

    final GridViewerColumn tcp = new GridViewerColumn(tableViewer, SWT.CHECK | SWT.CENTER);
    tcp.getColumn().setCheckable(true);
    tcp.getColumn().setWidth(50);
    tcp.getColumn().setText("Private");
    tcp.setLabelProvider(new TableLabelProvider(2));
    tcp.setEditingSupport(new CheckEditingSupport(tableViewer) {
      protected boolean canEdit(Object element) {
        return true;
      }

      protected CellEditor getCellEditor(Object element) {
        return checkCellEditor;
      }

      protected Object getValue(Object element) {
        return ((AsteriskServer) element).isPrivate();
      }

      public void setValue(Object element, Object value) {

        Boolean b = (Boolean) value;
        ((AsteriskServer) element).setPrivate(b);
        if (b)
          ((AsteriskServer) element).setActive(false);
        tableViewer.update(element, null);
      }
    });

    final GridViewerColumn tcn = new GridViewerColumn(tableViewer, SWT.NONE);
    tcn.getColumn().setWidth(110);
    tcn.getColumn().setText("Name");
    tcn.setLabelProvider(new TableLabelProvider(3));

    final GridViewerColumn tc0 = new GridViewerColumn(tableViewer, SWT.NONE);
    tc0.getColumn().setWidth(86);
    tc0.getColumn().setText("Host(IP)");
    tc0.setLabelProvider(new TableLabelProvider(4));

    final GridViewerColumn tc1 = new GridViewerColumn(tableViewer, SWT.NONE);
    tc1.getColumn().setWidth(60);
    tc1.getColumn().setText("Manager");
    tc1.setLabelProvider(new TableLabelProvider(5));

    final GridViewerColumn tc2 = new GridViewerColumn(tableViewer, SWT.NONE);
    tc2.getColumn().setWidth(80);
    tc2.getColumn().setText("Manager Port");
    tc2.setLabelProvider(new TableLabelProvider(6));

    final GridViewerColumn tc3 = new GridViewerColumn(tableViewer, SWT.NONE);
    tc3.getColumn().setWidth(80);
    tc3.getColumn().setText("SFTP user");
    tc3.setLabelProvider(new TableLabelProvider(7));

    final GridViewerColumn tc4 = new GridViewerColumn(tableViewer, SWT.NONE);
    tc4.getColumn().setWidth(80);
    tc4.getColumn().setText("SFTP Port");
    tc4.setLabelProvider(new TableLabelProvider(8));

    final GridViewerColumn tc5 = new GridViewerColumn(tableViewer, SWT.NONE);
    tc5.getColumn().setWidth(80);
    tc5.getColumn().setText("Description");
    tc5.setLabelProvider(new TableLabelProvider(9));

    final Composite composite = new Composite(registerAsteriskServerGroup, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    final RowLayout rowLayout = new RowLayout(SWT.VERTICAL);
    rowLayout.justify = true;
    composite.setLayout(rowLayout);

    final Button addButton = new Button(composite, SWT.NONE);
    addButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        addServer();
      }
    });
    final RowData rd_addButton = new RowData();
    rd_addButton.width = 100;
    addButton.setLayoutData(rd_addButton);
    addButton.setText("Add");

    final Button modifyButton = new Button(composite, SWT.NONE);
    modifyButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        modify();
      }
    });
    final RowData rd_modifyButton = new RowData();
    rd_modifyButton.width = 100;
    modifyButton.setLayoutData(rd_modifyButton);
    modifyButton.setText("Modify");

    final Button deleteButton = new Button(composite, SWT.NONE);
    deleteButton.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(final SelectionEvent e) {
        delete();
      }
    });
    final RowData rd_deleteButton = new RowData();
    rd_deleteButton.width = 100;
    deleteButton.setLayoutData(rd_deleteButton);
    deleteButton.setText("Delete");
    //
    this.tableViewer.setInput(this.asterisks);
    updateAll();
    if (!asterisks.isEmpty())
      tableViewer.setSelection(new StructuredSelection(asterisks.get(0)));
    return container;
  }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(724, 360);
  }

  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Asterisk Server Manager");

  }

  private void addServer() {
    if (this.production != null) {
      addAsterisk();
    } else {
      if (this.asterisks.isEmpty()) {
        addAsterisk();
      } else {
        MessageBox messageBox = new MessageBox(this.getShell(), SWT.ICON_ERROR);
        messageBox.setText("Warning");
        messageBox
            .setMessage("In order to add more asterisk configuration, you have to setup production SafiServer");
        int rc = messageBox.open();
      }
    }
  }

  private void addAsterisk() {
    com.safi.db.server.config.User user = SafiServerPlugin.getDefault().getCurrentUser();
    if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_MANAGE_ASTERISK_SERVERS)) {
      MessageDialog.openError(getShell(), "Not Entitled",
          "You do not have sufficient privileges to carry out this operation.");
      return;
    }
    AsteriskConfigurationDialog astercfg = new AsteriskConfigurationDialog(this.getShell());
    int result = astercfg.open();
    if (result == Dialog.CANCEL)
      return;
    AsteriskServer server = astercfg.getAsteriskServer();
    if (server != null) {
      // if (server.isDebug()) {
      // for (AsteriskServer s : asterisks) {
      // s.setDebug(false);
      // }
      // }
      server = new AstServerProxy(server);
      this.asterisks.add(server);
    }
    // if (astercfg.isDebug()) {
    // if (server != null && server != debugServer && debugServer != null) {
    // // copy settings
    // copyToDebug(server);
    // }
    // // this.debugServer = server;
    // }
    this.tableViewer.refresh();
    // this.tableViewer_1.setInput(this.asterisks);

  }

  // private void copyToDebug(AsteriskServer server) {
  // String name = server.getName();
  // // if (name != null && !name.endsWith(SafiServerPlugin.AST_DEBUG_NAME_SUFFIX))
  // // name += SafiServerPlugin.AST_DEBUG_NAME_SUFFIX;
  // debugServer.setName(name);
  // debugServer.setCreatedBy(server.getCreatedBy());
  // debugServer.setDescription(server.getDescription());
  // debugServer.setHostname(server.getHostname());
  // debugServer.setLastModified(new Date());
  // debugServer.setLastUpdated(server.getLastUpdated());
  // debugServer.setManagerName(server.getManagerName());
  // debugServer.setManagerPassword(server.getManagerPassword());
  // debugServer.setModifiedBy(server.getModifiedBy());
  // debugServer.setSftpPassword(server.getSftpPassword());
  // debugServer.setSftpPort(server.getSftpPort());
  // debugServer.setSftpUser(server.getSftpUser());
  // }

  public void okPressed() {
    if (production != null) {
      if (SafiServerPlugin.getDefault().getCurrentUser() == null) {
        super.okPressed();
        return;
      }
      Session session = null;
      try {

        session = DBManager.getInstance().createSession();
        session.beginTransaction();

        for (AsteriskServer s : asterisks) {
          if (s instanceof AstServerProxy) {
            ((AstServerProxy) s).applyChanges();
            s = ((AstServerProxy) s).original;
          }
          if (s.getId() == -1) {
            production.getAsteriskServers().add(s);
          }
        }
        for (AsteriskServer s : asterisks) {
          if (s instanceof AstServerProxy)
            s = ((AstServerProxy) s).original;
          session.saveOrUpdate(s);
        }

        for (AsteriskServer s : this.deleted_asterisks) {
          if (s instanceof AstServerProxy) {
            s = ((AstServerProxy) s).original;
          }
          production.getAsteriskServers().remove(s);
          session.delete(s);
        }

        session.saveOrUpdate(production);
        // session.save(this.production);
        session.getTransaction().commit();

      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Delete Server Error",
            "An error occurred while deleting resources: " + e.getLocalizedMessage());
      } finally {
        try {
          if (session != null) {
            session.close();
            session = null;
          }
        } catch (Exception ex) {

        }
      }

    }

    SafiServerPlugin.getDefault().notifyResourcesChanged();

    this.tableViewer.refresh();
    super.okPressed();
  }

  private void modify() {
    StructuredSelection sel = (StructuredSelection) this.tableViewer.getSelection();
    AsteriskServer as = (AsteriskServer) sel.getFirstElement();
    if (as == null) {
      return;
    }

    AsteriskConfigurationDialog astercfg = new AsteriskConfigurationDialog(this.getShell(), as);
    astercfg.setActive(as.isActive());
    astercfg.setPrivateServer(as.isPrivate());
    int result = astercfg.open();
    if (result == Dialog.CANCEL)
      return;
    AsteriskServer server = astercfg.getAsteriskServer();
    // this.tableViewer.update(asterisks.toArray(), null);
    this.tableViewer.refresh();

  }

  private void updateAll() {
    this.tableViewer.update(asterisks.toArray(), null);
  }

  private void delete() {
    StructuredSelection sel = (StructuredSelection) this.tableViewer.getSelection();
    AsteriskServer as = (AsteriskServer) sel.getFirstElement();
    if (as == null) {
      return;
    }
    // if (as == debugServer) {
    // this.debugServer = null;
    // }

    this.deleted_asterisks.add(as);
    this.asterisks.remove(as);
    this.tableViewer.refresh();

    // SafiServerPlugin.getDefault().storeDebug(debugServer);

  }

  // protected void buttonPressed(int buttonId) {
  // if (buttonId == IDialogConstants.CANCEL_ID) {
  // this.cancelPressed();
  // return;
  // }
  // if (buttonId == IDialogConstants.OK_ID) {
  // doOK();
  // this.close();
  // return;
  // }
  // super.buttonPressed(buttonId);
  // }

  public static class AstServerProxy extends EObjectImpl implements AsteriskServer {
    AsteriskServer original;
    AsteriskServer copy;
    boolean newInstance;

    public AstServerProxy(AsteriskServer server) {
      this.original = server;
      newInstance = false;
      copy = (AsteriskServer) EcoreUtil.copy(server);
      if (copy.getSafiServer() != null) {
        copy.setSafiServer(null);
        copy.getSafiServer().getAsteriskServers().remove(copy);
      }
    }

    public AstServerProxy() {
      this.copy = ConfigFactory.eINSTANCE.createAsteriskServer();
      newInstance = true;
    }

    void applyChanges() {
      if (newInstance) {
        copy.setLastModified(new Date());
        copy.setPrivate(false);
        original = copy;
      } else {
        original.setActive(copy.isActive());
        original.setDescription(copy.getDescription());
        original.setHostname(copy.getHostname());
        original.setLastModified(new Date());
        original.setManagerName(copy.getManagerName());
        original.setManagerPassword(copy.getManagerPassword());
        original.setManagerPort(copy.getManagerPort());
        original.setName(copy.getName());
        original.setSftpPassword(copy.getSftpPassword());
        original.setSftpPort(copy.getSftpPort());
        original.setSftpUser(copy.getSftpUser());
        original.setPrivate(copy.isPrivate());
        original.setPromptDirectory(copy.getPromptDirectory());
      }
    }

    @Override
    public String getHostname() {

      return copy.getHostname();
    }

    @Override
    public String getManagerName() {
      // TODO Auto-generated method stub
      return copy.getManagerName();
    }

    @Override
    public String getManagerPassword() {
      // TODO Auto-generated method stub
      return copy.getManagerPassword();
    }

    @Override
    public int getManagerPort() {
      // TODO Auto-generated method stub
      return copy.getManagerPort();
    }

    @Override
    public String getPromptDirectory() {
      // TODO Auto-generated method stub
      return copy.getPromptDirectory();
    }

    @Override
    public SafiServer getSafiServer() {
      // TODO Auto-generated method stub
      return copy.getSafiServer();
    }

    @Override
    public String getSftpPassword() {
      // TODO Auto-generated method stub
      return copy.getSftpPassword();
    }

    @Override
    public int getSftpPort() {
      // TODO Auto-generated method stub
      return copy.getSftpPort();
    }

    @Override
    public String getSftpUser() {
      // TODO Auto-generated method stub
      return copy.getSftpUser();
    }

    @Override
    public boolean isActive() {
      // TODO Auto-generated method stub
      return copy.isActive();
    }

    @Override
    public boolean isPrivate() {
      // TODO Auto-generated method stub
      return copy.isPrivate();
    }

    @Override
    public boolean isRunning() {
      // TODO Auto-generated method stub
      return copy.isRunning();
    }

    @Override
    public void setActive(boolean value) {
      copy.setActive(value);

    }

    @Override
    public void setPrivate(boolean value) {
      // TODO Auto-generated method stub
      copy.setPrivate(value);
    }

    @Override
    public void setHostname(String value) {
      // TODO Auto-generated method stub
      copy.setHostname(value);
    }

    @Override
    public void setManagerName(String value) {
      // TODO Auto-generated method stub
      copy.setManagerName(value);
    }

    @Override
    public void setManagerPassword(String value) {
      // TODO Auto-generated method stub
      copy.setManagerPassword(value);
    }

    @Override
    public void setManagerPort(int value) {
      // TODO Auto-generated method stub
      copy.setManagerPort(value);
    }

    @Override
    public void setRunning(boolean value) {
      // TODO Auto-generated method stub
      copy.setRunning(value);
    }

    @Override
    public void setSafiServer(SafiServer value) {
      // TODO Auto-generated method stub
      copy.setSafiServer(value);
    }

    @Override
    public void setSftpPassword(String value) {
      // TODO Auto-generated method stub
      copy.setSftpPassword(value);
    }

    @Override
    public void setSftpPort(int value) {
      // TODO Auto-generated method stub
      copy.setSftpPort(value);
    }

    @Override
    public void setSftpUser(String value) {
      // TODO Auto-generated method stub
      copy.setSftpUser(value);
    }

    @Override
    public User getCreatedBy() {
      return null;
    }

    @Override
    public String getDescription() {
      // TODO Auto-generated method stub
      return copy.getDescription();
    }

    @Override
    public int getId() {
      // TODO Auto-generated method stub
      return copy.getId();
    }

    @Override
    public Date getLastModified() {
      // TODO Auto-generated method stub
      return copy.getLastModified();
    }

    @Override
    public Date getLastUpdated() {
      // TODO Auto-generated method stub
      return copy.getLastUpdated();
    }

    @Override
    public User getModifiedBy() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public String getName() {
      // TODO Auto-generated method stub
      return copy.getName();
    }

    @Override
    public void setCreatedBy(User value) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setDescription(String value) {
      // TODO Auto-generated method stub
      copy.setDescription(value);
    }

    @Override
    public void setId(int value) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setLastModified(Date value) {
      // TODO Auto-generated method stub
      copy.setLastModified(value);
    }

    @Override
    public void setLastUpdated(Date value) {
      // TODO Auto-generated method stub
      copy.setLastUpdated(value);
    }

    @Override
    public void setModifiedBy(User value) {
      // TODO Auto-generated method stub

    }

    @Override
    public void setName(String value) {
      // TODO Auto-generated method stub
      copy.setName(value);
    }

    @Override
    public void setPromptDirectory(String value) {
      // TODO Auto-generated method stub
      copy.setPromptDirectory(value);
    }

    @Override
    public String getAsteriskVersion() {
      // TODO Auto-generated method stub
      return null;
    }

    @Override
    public void setAsteriskVersion(String value) {
      // TODO Auto-generated method stub

    }

  }
}
