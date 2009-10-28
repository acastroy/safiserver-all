package com.safi.workshop.navigator.serverconfig;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.db.manager.EntitlementUtils;
import com.safi.db.server.config.ConfigFactory;
import com.safi.db.server.config.Role;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class UserRoleManagerDialog extends TitleAreaDialog {

  class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
    public String getColumnText(Object element, int columnIndex) {
      Role role = (Role) element;

      if (columnIndex == 0) {
        return role.getName();
      } else if (columnIndex == 1) {
        return role.getDescription();
      }
      return element.toString();
    }

    public Image getColumnImage(Object element, int columnIndex) {
      return null;
    }
  }
  class ContentProvider_1 implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      if (available != null) {
        // List listRole=(List)inputElement;
        return available.toArray();
      }
      return null;
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }
  private Table table;
  class ListLabelProvider extends LabelProvider {
    @Override
    public String getText(Object element) {
      if (element instanceof Role) {
        Role role = (Role) element;
        return role.getName();
      }
      return element.toString();

    }

    @Override
    public Image getImage(Object element) {
      return null;
    }
  }

  class ContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      if (available != null) {
        // List listRole=(List)inputElement;
        return available.toArray();
      }
      return null;
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }

  java.util.List available;
  private Button addButton;
  private Button modifyButton;
  private Button deleteButton;
  private TableViewer tableViewer;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public UserRoleManagerDialog(Shell parentShell) {
    super(parentShell);

  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite area = (Composite) super.createDialogArea(parent);
    Composite container = new Composite(area, SWT.NONE);
    container.setLayout(new FillLayout());
    container.setLayoutData(new GridData(GridData.FILL_BOTH));

    final Group createRoleGroup = new Group(container, SWT.NONE);
    createRoleGroup.setText("Manage User Role");
    createRoleGroup.setLayout(new FormLayout());

    final Composite composite = new Composite(createRoleGroup, SWT.NONE);
    composite.setLayout(new RowLayout(SWT.VERTICAL));
    final FormData fd_composite = new FormData();
    fd_composite.bottom = new FormAttachment(0, 135);
    fd_composite.top = new FormAttachment(0, 31);
    fd_composite.left = new FormAttachment(100, -80);
    fd_composite.right = new FormAttachment(100, -5);
    composite.setLayoutData(fd_composite);

    addButton = new Button(composite, SWT.NONE);
    addButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        add();
      }
    });
    final RowData rd_addButton = new RowData();
    rd_addButton.width = 66;
    addButton.setLayoutData(rd_addButton);
    addButton.setText("Add");

    modifyButton = new Button(composite, SWT.NONE);
    modifyButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        modify();
      }
    });
    final RowData rd_modifyButton = new RowData();
    rd_modifyButton.width = 66;
    modifyButton.setLayoutData(rd_modifyButton);
    modifyButton.setText("Modify");

    deleteButton = new Button(composite, SWT.NONE);
    deleteButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        delete();
      }
    });
    final RowData rd_deleteButton = new RowData();
    rd_deleteButton.width = 66;
    deleteButton.setLayoutData(rd_deleteButton);
    deleteButton.setText("Delete");

    tableViewer = new TableViewer(createRoleGroup, SWT.FULL_SELECTION | SWT.BORDER);
    tableViewer.addDoubleClickListener(new IDoubleClickListener() {
      public void doubleClick(final DoubleClickEvent event) {
        modify();
      }
    });
    tableViewer.setLabelProvider(new TableLabelProvider());
    tableViewer.setContentProvider(new ContentProvider_1());
    table = tableViewer.getTable();
    final FormData fd_table = new FormData();
    fd_table.bottom = new FormAttachment(100, -10);
    fd_table.top = new FormAttachment(composite, 0, SWT.TOP);
    fd_table.left = new FormAttachment(0, 5);
    fd_table.right = new FormAttachment(composite, -5, SWT.LEFT);
    table.setLayoutData(fd_table);
    table.setLinesVisible(true);
    table.setHeaderVisible(true);

    final TableColumn newColumnTableColumn = new TableColumn(table, SWT.NONE);
    newColumnTableColumn.setWidth(103);
    newColumnTableColumn.setText("Role Name");

    final TableColumn newColumnTableColumn_1 = new TableColumn(table, SWT.NONE);
    newColumnTableColumn_1.setWidth(180);
    newColumnTableColumn_1.setText("Description");
    setTitle("User Role Manager");

    com.safi.db.server.config.User user = SafiServerPlugin.getDefault().getCurrentUser();
    if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_MANAGE_USERS)) {
      MessageDialog.openError(AsteriskDiagramEditorUtil.getActiveShell(), "Not Entitled",
          "You do not have sufficient privileges to carry out this operation.");
      disableAll();
    }

    //
    init();
    return area;
  }

  private void init() {
    available = SafiServerPlugin.getDefault().getAvailableRoles();
    this.tableViewer.setInput(available);
    this.tableViewer.refresh();
  }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(404, 386);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("User Role Manager");
  }

  @Override
  protected void buttonPressed(int buttonId) {
    if (buttonId == IDialogConstants.OK_ID) {
      this.close();
      return;
    }
    if (buttonId == IDialogConstants.CANCEL_ID) {
      this.close();
      return;
    }
    super.buttonPressed(buttonId);
  }

  private void disableAll() {
    this.addButton.setEnabled(false);
    this.modifyButton.setEnabled(false);
    this.deleteButton.setEnabled(false);
  }

  private void modify() {
    StructuredSelection ss = (StructuredSelection) this.tableViewer.getSelection();
    Role role = (Role) ss.getFirstElement();
    if (role == null) {
      this.setErrorMessage("Please select role first to modify");
      return;
    }
    // Role copiedRole = (Role) EcoreUtil.copy(role);
    UserRoleDialog urd = new UserRoleDialog(this.getShell(), role);
    if (urd.open() == SWT.OK) {
      // this.available.remove(role);
      // this.available.add(urd.getRole());
      available = SafiServerPlugin.getDefault().getAvailableRoles();
      this.tableViewer.refresh();
    }

  }

  private void add() {
    Role role = ConfigFactory.eINSTANCE.createRole();
    UserRoleDialog urd = new UserRoleDialog(this.getShell(), role);
    if (urd.open() == SWT.OK) {
      this.available.add(role);
      this.tableViewer.refresh();
    }

  }

  private void delete() {
    StructuredSelection ss = (StructuredSelection) this.tableViewer.getSelection();
    Role role = (Role) ss.getFirstElement();
    if (role == null) {
      this.setErrorMessage("Please select role first to modify");
      return;
    }
    Session session = null;
    try {
      session = DBManager.getInstance().createSession();

      session.beginTransaction();
      session.delete(role);
      session.getTransaction().commit();
      this.available.remove(role);
      this.tableViewer.refresh();
    } catch (DBManagerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      this.setErrorMessage(e.getMessage());
      return;
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      this.setErrorMessage(e.getMessage());
      return;
    } finally {
      if (session != null) {
        session.close();
        session = null;
      }
    }

  }
}
