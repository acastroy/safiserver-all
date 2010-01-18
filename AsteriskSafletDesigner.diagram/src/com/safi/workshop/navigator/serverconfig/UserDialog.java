package com.safi.workshop.navigator.serverconfig;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.internal.progress.ProgressMonitorJobsDialog;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.SessionImpl;
import org.hsqldb.Trace;
import com.safi.db.server.config.Role;
import com.safi.db.server.config.SafiServer;
import com.safi.db.server.config.User;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.preferences.PreferenceConstants;
import com.safi.server.saflet.manager.DBManager;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.part.AsteriskDiagramEditorUtil;

public class UserDialog extends TitleAreaDialog {

  private Text textDescription;
  private List list_1;
  private List list;

  class ListLabelProvider_1 extends LabelProvider {
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

  class ContentProvider_1 implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      if (assigned != null) {
        // List<Role> listRole=(List<Role>)inputElement;
        return assigned.toArray();
      }
      return null;
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }

  class RolesLabelProvider extends LabelProvider {
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

  class RolesContentProvider implements IStructuredContentProvider {
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

  private Text textLastName;
  private Text textFileName;
  private Text textPass;
  private Text textName;
  private User user;
  private Button buttonAdd;
  private Button buttonRemove;
  private ListViewer listViewerAvailable;
  private ListViewer listViewerAssign;
  private java.util.List<Role> available;
  private java.util.List<Role> assigned;
  private boolean isDisable = false;

  public UserDialog(Shell parentShell, User aUser) {
    super(parentShell);
    this.user = aUser;

  }

  private void disableAll() {
    this.textFileName.setEnabled(false);
    this.textLastName.setEnabled(false);
    this.textName.setEnabled(false);
    this.textPass.setEnabled(false);
    this.textDescription.setEnabled(false);
    this.buttonAdd.setEnabled(false);
    this.buttonRemove.setEnabled(false);
    isDisable = true;
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

    final Composite container_1 = new Composite(container, SWT.NONE);
    container_1.setLayout(new FormLayout());

    final Group userProfileGroup = new Group(container_1, SWT.NONE);
    final FormData fd_userProfileGroup = new FormData();
    fd_userProfileGroup.bottom = new FormAttachment(0, 155);
    fd_userProfileGroup.top = new FormAttachment(0, 10);
    fd_userProfileGroup.right = new FormAttachment(100, -10);
    fd_userProfileGroup.left = new FormAttachment(0, 10);
    userProfileGroup.setLayoutData(fd_userProfileGroup);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    userProfileGroup.setLayout(gridLayout);
    userProfileGroup.setText("User Profile");

    final Label loginLabel = new Label(userProfileGroup, SWT.NONE);
    loginLabel.setText("User ID :");

    textName = new Text(userProfileGroup, SWT.BORDER);
    final GridData gd_text_name = new GridData(SWT.FILL, SWT.CENTER, true, false);
    textName.setLayoutData(gd_text_name);

    final Label passwordLabel = new Label(userProfileGroup, SWT.NONE);
    passwordLabel.setText("Password :");

    textPass = new Text(userProfileGroup, SWT.BORDER | SWT.PASSWORD);
    final GridData gd_text_pass = new GridData(SWT.FILL, SWT.CENTER, true, false);
    textPass.setLayoutData(gd_text_pass);

    final Label firstNameLabel = new Label(userProfileGroup, SWT.NONE);
    firstNameLabel.setText("First Name :");

    textFileName = new Text(userProfileGroup, SWT.BORDER);
    final GridData gd_text_firstName = new GridData(SWT.FILL, SWT.CENTER, true, false);
    textFileName.setLayoutData(gd_text_firstName);

    final Label lastNameLabel = new Label(userProfileGroup, SWT.NONE);
    lastNameLabel.setText("Last Name :");

    textLastName = new Text(userProfileGroup, SWT.BORDER);
    final GridData gd_text_lastName = new GridData(SWT.FILL, SWT.CENTER, true, false);
    textLastName.setLayoutData(gd_text_lastName);

    final Label descriptionLabel = new Label(userProfileGroup, SWT.NONE);
    descriptionLabel.setText("Description:");

    textDescription = new Text(userProfileGroup, SWT.BORDER);
    final GridData gd_textDescription = new GridData(SWT.FILL, SWT.CENTER, true, false);
    textDescription.setLayoutData(gd_textDescription);

    final Group roleAssignmentGroup = new Group(container_1, SWT.NONE);
    final FormData fd_roleAssignmentGroup = new FormData();
    fd_roleAssignmentGroup.bottom = new FormAttachment(100, -7);
    fd_roleAssignmentGroup.top = new FormAttachment(userProfileGroup, 5, SWT.BOTTOM);
    fd_roleAssignmentGroup.right = new FormAttachment(userProfileGroup, 0, SWT.RIGHT);
    fd_roleAssignmentGroup.left = new FormAttachment(userProfileGroup, 0, SWT.LEFT);
    roleAssignmentGroup.setLayoutData(fd_roleAssignmentGroup);
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 7;
    roleAssignmentGroup.setLayout(gridLayout_1);
    roleAssignmentGroup.setText("Role Assignment");

    final Group availableRoleGroup = new Group(roleAssignmentGroup, SWT.NONE);
    availableRoleGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
    final FillLayout fillLayout = new FillLayout();
    fillLayout.spacing = 5;
    fillLayout.marginWidth = 5;
    fillLayout.marginHeight = 5;
    availableRoleGroup.setLayout(fillLayout);
    availableRoleGroup.setText("Available Role");

    listViewerAvailable = new ListViewer(availableRoleGroup, SWT.MULTI | SWT.BORDER);
    list = listViewerAvailable.getList();
    list.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseDoubleClick(final MouseEvent e) {
        add();
      }
    });
    listViewerAvailable.setLabelProvider(new RolesLabelProvider());
    listViewerAvailable.setContentProvider(new RolesContentProvider());

    final Composite composite = new Composite(roleAssignmentGroup, SWT.NONE);
    composite.setLayout(new RowLayout(SWT.VERTICAL));

    buttonAdd = new Button(composite, SWT.ARROW | SWT.RIGHT);
    buttonAdd.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        add();
      }
    });
    final RowData rd_button_Add = new RowData();
    rd_button_Add.width = 25;
    rd_button_Add.height = 25;
    buttonAdd.setLayoutData(rd_button_Add);
    buttonAdd.setText("button");

    buttonRemove = new Button(composite, SWT.ARROW | SWT.LEFT);
    buttonRemove.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        remove();
      }
    });
    final RowData rd_button_Remove = new RowData();
    rd_button_Remove.width = 25;
    rd_button_Remove.height = 25;
    buttonRemove.setLayoutData(rd_button_Remove);
    buttonRemove.setText("button");

    final Group availableRoleGroup_1 = new Group(roleAssignmentGroup, SWT.NONE);
    availableRoleGroup_1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
    final FillLayout fillLayout_1 = new FillLayout();
    fillLayout_1.spacing = 5;
    fillLayout_1.marginWidth = 5;
    fillLayout_1.marginHeight = 5;
    availableRoleGroup_1.setLayout(fillLayout_1);
    availableRoleGroup_1.setText("Assigned Role");

    listViewerAssign = new ListViewer(availableRoleGroup_1, SWT.MULTI | SWT.BORDER);
    list_1 = listViewerAssign.getList();
    list_1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseDoubleClick(final MouseEvent e) {
        remove();
      }
    });
    listViewerAssign.setLabelProvider(new ListLabelProvider_1());
    listViewerAssign.setContentProvider(new ContentProvider_1());
    setTitle("Add/Modify User");
    if (this.user != null) {
      String login = this.user.getName();
      String first = this.user.getFirstname();
      String last = this.user.getLastname();
      String pass = this.user.getPassword();
      String desc = this.user.getDescription();
      if (login != null)
        this.textName.setText(login);
      if (first != null)
        this.textFileName.setText(first);
      if (last != null)
        this.textLastName.setText(last);
      if (pass != null)
        this.textPass.setText(pass);
      if (desc != null)
        this.textDescription.setText(desc);
      available = SafiServerPlugin.getDefault().getAvailableRoles();

      if (available == null) {
        available = new ArrayList<Role>();
      }
      EList<Role> roles = user.getRoles();
      if (roles != null) {
        assigned = new ArrayList<Role>();
        for (Role role : roles) {
          Role found = null;
          for (Role r : available) {
            if (r.getId() == role.getId()) {
              found = r;
              break;
            }
          }
          if (found != null) {
            assigned.add(found);
            available.remove(found);
          }
        }
        listViewerAssign.setInput(assigned);
        listViewerAvailable.setInput(available);

      }

      // if (!SafiServerPlugin.getDefault().isCurrentUserAdmin()) {
      // disableAll();
      // }

    } else {
      disableAll();
    }

    //

    this.setTitleImage(AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
        "icons/titlearea/EditUser.gif"));

    return area;
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

  private void remove() {
    StructuredSelection ss = (StructuredSelection) this.listViewerAssign.getSelection();
    if (ss.isEmpty())
      return;
    for (Object o : ss.toArray()) {
      Role role = (Role) o;
      this.assigned.remove(role);
      this.available.add(role);
    }

    this.listViewerAssign.refresh();
    this.listViewerAvailable.refresh();
    listViewerAvailable.setSelection(new StructuredSelection(ss.toArray()));
  }

  private void add() {
    StructuredSelection ss = (StructuredSelection) this.listViewerAvailable.getSelection();
    if (ss.isEmpty())
      return;

    for (Object o : ss.toArray()) {
      Role role = (Role) o;
      assigned.add(role);
      available.remove(role);
    }
    // if (!this.containRole(this.assigned, role)) {
    // this.assigned.add(role);
    // }

    this.listViewerAssign.refresh();
    this.listViewerAvailable.refresh();
    listViewerAssign.setSelection(new StructuredSelection(ss.toArray()));
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(500, 446);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("User Configuration");
  }

  @Override
  protected void buttonPressed(int buttonId) {
    if (buttonId == IDialogConstants.CANCEL_ID) {
      cancelPressed();
      return;
    }
    if (buttonId == IDialogConstants.OK_ID) {
      if (this.isDisable) {
        this.close();
      }
      IRunnableWithProgress job = new IRunnableWithProgress() {

        @Override
        public void run(IProgressMonitor monitor) {
          Display.getDefault().asyncExec(new Runnable() {
            @Override
            public void run() {
              try {
                if (apply()) {
                  okPressed();
                }
                return;
              } catch (final Exception e) {
                e.printStackTrace();
                Display.getDefault().asyncExec(new Runnable() {
                  public void run() {
                    MessageDialog.openError(getShell(), "Update Error",
                        "Couldn't update SafiServer settings: " + e.getLocalizedMessage());
                  }

                });
              }

            }
          });
        }

      };
      ProgressMonitorJobsDialog dialog = new ProgressMonitorJobsDialog(getShell());
      try {
        dialog.run(true, true, job);
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        MessageDialog.openError(getShell(), "Update Error", "Couldn't update SafiServer settings: "
            + e.getLocalizedMessage());
        return;
      }
    }
    super.buttonPressed(buttonId);
  }

  @SuppressWarnings("unchecked")
  public boolean apply() {
    if (this.assigned.size() == 0) {
      this.setMessage("Please assign at least 1 role");
      return false;
    }
    String firstName = this.textFileName.getText().trim();
    String lastName = this.textLastName.getText().trim();
    String loginName = this.textName.getText().trim();
    String pass = this.textPass.getText();
    String desc = this.textDescription.getText().trim();
    User currUser = SafiServerPlugin.getDefault().getCurrentUser();
    Session session = null;
    try {
      final String oldUsername = user.getName();
      boolean newName = !StringUtils.equals(oldUsername, loginName);
      session = DBManager.getInstance().createSession();
      boolean doMerge = false;
      SafiServer safiServer = SafiServerPlugin.getDefault().getSafiServer(true);
      java.util.List<User> users = safiServer.getUsers();
      if (newName) {

        for (User u : users) {
          if (u == null)
            continue;
          if (loginName.equals(u.getName())) {
            if (u.getId() != this.user.getId()) {
              Display.getDefault().asyncExec(new Runnable() {
                public void run() {
                  setErrorMessage("Multiple users with same user ID found.  Please contact your administrator.");
                }

              });
              return false;
            } else
              doMerge = true;
          }
        }
        // Criteria criteria = session.createCriteria(User.class).add(
        // (Restrictions.eq("name", loginName)));
        // if (users.size() > 1) {
        // Display.getDefault().asyncExec(new Runnable() {
        // public void run() {
        // setErrorMessage("Multiple users with same user ID found.  Please contact your administrator.");
        // }
        //
        // });
        //
        // return false;
        // } else if (users.size() == 1) {
        // User aUser = (User) users.get(0);
        // if (aUser.getId() != this.user.getId()) {
        // Display.getDefault().asyncExec(new Runnable() {
        // public void run() {
        // setErrorMessage("login name has to be unique!");
        // }
        // });
        //
        // return false;
        // } else
        // doMerge = true;
        //
        // // user = aUser;
        // }
      }
      boolean isCurrentUser = currUser.getId() == user.getId();

      boolean isNew = user.getId() == -1;
      session.beginTransaction();
      if (firstName != null) {
        user.setFirstname(firstName);
      }
      if (lastName != null) {
        user.setLastname(lastName);
      }
      if (desc != null) {
        user.setDescription(desc);
      }

      if (newName && isCurrentUser) {
        Display.getDefault().asyncExec(new Runnable() {
          public void run() {
            setErrorMessage("Changing the user ID for the currently logged in user is not permitted.");
            textLastName.setText(oldUsername);
          }

        });

        return false;
      }
      if (newName && "sa".equals(oldUsername)) {
        Display.getDefault().asyncExec(new Runnable() {
          public void run() {
            setErrorMessage("Changing the user ID for 'sa' is not permitted.");
            textLastName.setText("sa");
          }

        });

        return false;
      }
      if (loginName != null) {
        user.setName(loginName);
      }
      String oldPass = user.getPassword();
      if (pass != null) {
        user.setPassword(pass);
      }
      user.getRoles().clear();
      for (Role role : this.assigned) {
        // Role r = (Role) session.load(Role.class, role.getId());
        Role r = (Role) session.createCriteria(Role.class).add(
            (Restrictions.eq("id", role.getId()))).uniqueResult();
        if (r != null)
          user.getRoles().add(r);
      }

      // for (Role role : user.getRoles()) {
      // try{
      // session.saveOrUpdate(role);
      // }catch(Exception ex){
      // ex.printStackTrace();
      // }
      // }

      if (isNew || !newName) {
        Connection connection = ((SessionImpl) session).getJDBCContext().getConnectionManager()
            .getConnection();
        Statement stat = null;
        try {
          stat = connection.createStatement();
          if (!isNew && !"sa".equalsIgnoreCase(oldUsername)) {
            try {
              stat.execute("drop user '" + oldUsername + "';");
            } catch (SQLException sqle) {
              if (sqle.getErrorCode() != -Trace.NO_SUCH_GRANTEE) {
                throw sqle;
              }
            }
          }
          try {
            stat.execute("create user '" + loginName + "'password '" + pass + "' ADMIN;");
          } catch (SQLException sqle) {
            if (sqle.getErrorCode() != -Trace.GRANTEE_ALREADY_EXISTS)
              throw sqle;
            if (!"sa".equalsIgnoreCase(loginName))
              stat.execute("alter user '" + loginName + "' set password '" + pass + "';");
          }
        } finally {
          if (stat != null)
            stat.close();
        }
      } else if (!"sa".equalsIgnoreCase(loginName) && !isNew && !StringUtils.equals(oldPass, pass)) {
        Connection connection = ((SessionImpl) session).getJDBCContext().getConnectionManager()
            .getConnection();
        Statement stat = null;
        try {
          stat = connection.createStatement();
          stat.execute("alter user '" + loginName + "' set password '" + pass + "';");
        } finally {
          if (stat != null)
            stat.close();
        }
      }
      if (isNew) {
        users.add(user);
        user.setCreatedBy(SafiServerPlugin.getDefault().getCurrentUser());
        user.setLastModified(new Date(System.currentTimeMillis()));
        session.saveOrUpdate(user);
        session.merge(safiServer);
        // Object entry =
        // ((SessionImpl)session).getPersistenceContext().getEntry(safiServer);
        // DBManager.getInstance().saveOrUpdateServerResource(session, safiServer);
        // System.err.println("entry of is "+entry);
        //         
        // session.saveOrUpdate(safiServer);
      } else {
        user.setModifiedBy(SafiServerPlugin.getDefault().getCurrentUser());
        user.setLastModified(new Date(System.currentTimeMillis()));
        // DBManager.getInstance().saveOrUpdateServerResource(session, user);

        if (doMerge || (!isNew && newName))
          session.merge(user);
        else {
          session.saveOrUpdate(user);
        }
      }
      // session.flush();
      session.getTransaction().commit();

      if (!isNew && isCurrentUser) {
        IPreferenceStore store = SafiServerPlugin.getDefault().getPreferenceStore();
        store.setValue(PreferenceConstants.PREF_SAFISERVER_USER_PROD, user.getName());
        store.setValue(PreferenceConstants.PREF_SAFISERVER_PASS_PROD, user.getPassword());
        SafiServerPlugin.getDefault().updateServerResources(new NullProgressMonitor());
      } else {

        AsteriskDiagramEditorUtil.getSafiNavigator().refresh();
      }
    } catch (final Exception e) {
      if (e instanceof HibernateException)
        try {
          session.getTransaction().rollback();
        } catch (Exception e2) {
        }
      e.printStackTrace();
      Display.getDefault().asyncExec(new Runnable() {
        public void run() {
          setMessage(e.getMessage());
        }

      });
      // this.setMessage(e.getMessage());
      return false;
    } finally {
      if (session != null) {
        session.close();
        session = null;
      }
    }

    return true;
  }

}
