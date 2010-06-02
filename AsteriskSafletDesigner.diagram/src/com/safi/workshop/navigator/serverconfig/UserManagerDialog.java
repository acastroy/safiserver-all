package com.safi.workshop.navigator.serverconfig;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
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
import org.eclipse.jface.window.Window;
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
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.hibernate.Session;
import org.hibernate.impl.SessionImpl;

import com.safi.db.server.config.ConfigFactory;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.DBManager;
import com.safi.server.saflet.manager.DBManagerException;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;

public class UserManagerDialog extends TitleAreaDialog {

	class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object element, int columnIndex) {
			if (element instanceof User) {
				User user = (User) element;
				if (columnIndex == 0) {
					return user.getName();
				} else if (columnIndex == 1) {
					return user.getFirstname();
				} else if (columnIndex == 2) {
					return user.getLastname();
				} else if (columnIndex == 3) {
					return user.getDescription();
				}
				return element.toString();

			} else
				return element.toString();
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}
	}

	class ContentProvider implements IStructuredContentProvider {
		public Object[] getElements(Object inputElement) {
			return ((List<User>) inputElement).toArray();
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}
	}

	private Table table;
	private Button addButton;
	private Button modifyButton;
	private Button deleteButton;
	private SafiServer safiServer;
	private TableViewer tableViewer;
	private Button buttonRole;
	private boolean needsRefresh;

	/**
	 * Create the dialog
	 * 
	 * @param parentShell
	 */
	public UserManagerDialog(Shell parentShell) {
		super(parentShell);

	}

	private void disable() {
		this.addButton.setEnabled(false);
		this.modifyButton.setEnabled(false);
		this.deleteButton.setEnabled(false);
		this.buttonRole.setEnabled(false);
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
		container.setLayout(new FormLayout());
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		final Group usersGroup = new Group(container, SWT.NONE);
		usersGroup.setText("Users");
		usersGroup.setLayout(new FillLayout());
		final FormData fd_usersGroup = new FormData();
		fd_usersGroup.left = new FormAttachment(0, 10);
		fd_usersGroup.top = new FormAttachment(0, 5);
		fd_usersGroup.bottom = new FormAttachment(0, 280);
		fd_usersGroup.right = new FormAttachment(0, 430);
		usersGroup.setLayoutData(fd_usersGroup);

		tableViewer = new TableViewer(usersGroup, SWT.FULL_SELECTION | SWT.BORDER);
		tableViewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(final DoubleClickEvent event) {
				modify();
			}
		});
		tableViewer.setLabelProvider(new TableLabelProvider());
		tableViewer.setContentProvider(new ContentProvider());
		table = tableViewer.getTable();
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		final TableColumn newColumnTableColumn = new TableColumn(table, SWT.NONE);
		newColumnTableColumn.setWidth(86);
		newColumnTableColumn.setText("Login");

		final TableColumn newColumnTableColumn_1 = new TableColumn(table, SWT.NONE);
		newColumnTableColumn_1.setWidth(100);
		newColumnTableColumn_1.setText("First Name");

		final TableColumn newColumnTableColumn_2 = new TableColumn(table, SWT.NONE);
		newColumnTableColumn_2.setWidth(100);
		newColumnTableColumn_2.setText("Last Name");

		final TableColumn newColumnTableColumn_3 = new TableColumn(table, SWT.NONE);
		newColumnTableColumn_3.setWidth(200);
		newColumnTableColumn_3.setText("Description");

		final Composite composite = new Composite(container, SWT.NONE);
		composite.setLayout(new RowLayout(SWT.VERTICAL));
		final FormData fd_composite = new FormData();
		fd_composite.right = new FormAttachment(100, -9);
		fd_composite.bottom = new FormAttachment(0, 135);
		fd_composite.left = new FormAttachment(100, -94);
		fd_composite.top = new FormAttachment(0, 10);
		composite.setLayoutData(fd_composite);

		addButton = new Button(composite, SWT.NONE);
		addButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				add();
			}
		});
		final RowData rd_addButton = new RowData();
		rd_addButton.width = 80;
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
		rd_modifyButton.width = 80;
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
		rd_deleteButton.width = 80;
		deleteButton.setLayoutData(rd_deleteButton);
		deleteButton.setText("Delete");

		buttonRole = new Button(composite, SWT.NONE);
		buttonRole.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				manageRole();
			}
		});
		final RowData rd_buttonRole = new RowData();
		rd_buttonRole.width = 80;
		buttonRole.setLayoutData(rd_buttonRole);
		buttonRole.setText("Manage Roles");
		//
		SafiServer aSafiServer = null;
		try {
			aSafiServer = SafiServerPlugin.getDefault().getSafiServer(true);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		if (aSafiServer == null) {
			disable();
		} else {
			this.safiServer = aSafiServer;

			reloadTable();
		}

		setTitle("Manage User");
		this.setTitleImage(AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
		    "icons/titlearea/UserManager.gif"));
		// setTitleImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
		// "icons/titlearea/UserManager.gif"));
		return area;
	}

	private void reloadTable() {
		try {
			this.tableViewer.setInput(DBManager.getInstance().getUsers());
			this.tableViewer.refresh();
		} catch (DBManagerException e) {
			AsteriskDiagramEditorPlugin.getInstance().logError("Couldn't retrieve users", e);
			MessageDialog.openError(tableViewer.getControl().getShell(), "Database Error",
			    "Couldn't retrieve users from server: " + e.getLocalizedMessage());
		}
	}

	@Override
	protected void okPressed() {
		
		super.okPressed();
	}
	
	@Override
	public boolean close() {
		try {
			SafiServerPlugin.getDefault().updateServerResources(new NullProgressMonitor());
		} catch (Exception e) {
			e.printStackTrace();
			MessageDialog.openError(tableViewer.getControl().getShell(), "Database Error",
			    "Couldn't refresh from production SafiServer: " + e.getLocalizedMessage());
		}
	  return super.close();
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

	private void modify() {
		StructuredSelection ss = (StructuredSelection) this.tableViewer.getSelection();
		if (ss == null) {
			return;
		}
		User user = (User) ss.getFirstElement();
		if (user == null)
			return;
		// Shell shell=new Shell();
		// User aUser=(User)EcoreUtil.copy(user);
		UserDialog userDialog = new UserDialog(this.getShell(), user);
		int result = userDialog.open();
		if (Window.OK == result) {
			reloadTable();
			needsRefresh = true;
		}
	}

	private void add() {

		User user = ConfigFactory.eINSTANCE.createUser();
		// Shell shell=new Shell();
		// User aUser=(User)EcoreUtil.copy(user);
		UserDialog userDialog = new UserDialog(this.getShell(), user);
		int result = userDialog.open();
		if (Window.OK == result) {
			reloadTable();
			needsRefresh = true;
		}
	}

	/**
	 * Return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return getShell().computeSize(537, SWT.DEFAULT);// new Point(537, 429);
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("User Manager");
	}

	public void delete() {
		StructuredSelection ss = (StructuredSelection) this.tableViewer.getSelection();

		User user = (User) ss.getFirstElement();
		if (user == null)
			return;
		if (user.getName().equals("sa")) {
			this.setErrorMessage("sa is not deletable!");
			return;
		}
		MessageBox messageBox = new MessageBox(this.getShell(), SWT.ICON_QUESTION | SWT.YES
		    | SWT.NO);
		messageBox
		    .setMessage("Do you really want to delete user?\n This process is not reversible");
		messageBox.setText("Deleting User");
		if (messageBox.open() == SWT.NO) {
			return;
		}

		// SafiServerPlugin.getDefault().getSafiServer().getUsers().remove(user);
		Session session = null;
		try {
			this.safiServer.getUsers().remove(user);
			session = DBManager.getInstance().createSession();
			session.beginTransaction();
			// session.save(this.safiServer);
			session.delete(user);
			session.getTransaction().commit();
			Connection connection = ((SessionImpl) session).getJDBCContext()
			    .getConnectionManager().getConnection();
			Statement stat = null;
			try {
				stat = connection.createStatement();
				stat.execute("drop user '" + user.getName() + "';");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				this.safiServer.getUsers().add(user);
			} finally {
				if (stat != null)
					try {
						stat.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}

		} catch (Exception e) {
			e.printStackTrace();
			this.setErrorMessage("User Deletion failed!:" + e.getMessage());
		} finally {
			if (session != null) {
				session.close();
				session = null;
			}
		}

		reloadTable();
		needsRefresh = true;
		
//		 AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged(true);

	}

	private void manageRole() {
		UserRoleManagerDialog userRoleManager = new UserRoleManagerDialog(this.getShell());
		userRoleManager.open();
	}

}
