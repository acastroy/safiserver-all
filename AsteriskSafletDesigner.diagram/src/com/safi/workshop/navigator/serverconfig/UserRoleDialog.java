package com.safi.workshop.navigator.serverconfig;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.StructuredSelection;
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
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.safi.db.server.config.Entitlement;
import com.safi.db.server.config.Role;
import com.safi.server.plugin.SafiServerPlugin;
import com.safi.server.saflet.manager.DBManager;
import com.safi.server.saflet.manager.DBManagerException;
import com.safi.server.saflet.manager.EntitlementUtils;
import com.safi.workshop.part.SafiWorkshopEditorUtil;

public class UserRoleDialog extends TitleAreaDialog {

  private Text textDesc;

  class AssignedListLabelProvider extends LabelProvider {
    @Override
    public String getText(Object element) {
      if (element instanceof Entitlement) {
        Entitlement ent = (Entitlement) element;
        return ent.getName();
      }
      return element.toString();
    }

    @Override
    public Image getImage(Object element) {
      return null;
    }
  }

  class AssignedContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      if (role != null) {
        return role.getEntitlements().toArray();
      }
      return null;
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }

  class AvailableListLabelProvider extends LabelProvider {
    @Override
    public String getText(Object element) {
      if (element instanceof Entitlement) {
        Entitlement ent = (Entitlement) element;
        return ent.getName();
      }
      return element.toString();
    }

    @Override
    public Image getImage(Object element) {
      return null;
    }
  }

  class AvailableContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {

      if (available != null) {
        return available.toArray();
      }
      return null;
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }

  private Text text;
  private Button buttonAdd;
  private Button buttonRemove;
  private ListViewer availableEntitlements;
  private ListViewer assignedEntitlements;
  private List available;
  private Role role;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public UserRoleDialog(Shell parentShell) {
    super(parentShell);
  }

  public UserRoleDialog(Shell parentShell, Role aRole) {
    super(parentShell);
    this.role = aRole;
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

    final Label roleNameLabel = new Label(container, SWT.NONE);
    final FormData fd_roleNameLabel = new FormData();
    fd_roleNameLabel.top = new FormAttachment(0, 10);
    fd_roleNameLabel.left = new FormAttachment(0, 20);
    roleNameLabel.setLayoutData(fd_roleNameLabel);
    roleNameLabel.setText("Role Name:");

    text = new Text(container, SWT.BORDER);
    final FormData fd_text = new FormData();
    fd_text.right = new FormAttachment(0, 225);
    fd_text.top = new FormAttachment(roleNameLabel, 0, SWT.TOP);
    fd_text.left = new FormAttachment(roleNameLabel, 0, SWT.RIGHT);
    text.setLayoutData(fd_text);

    final Group roleAssignmentGroup = new Group(container, SWT.NONE);
    FormData fd_roleAssignmentGroup;
    fd_roleAssignmentGroup = new FormData();
    fd_roleAssignmentGroup.bottom = new FormAttachment(100, -15);
    fd_roleAssignmentGroup.left = new FormAttachment(0, 10);
    fd_roleAssignmentGroup.right = new FormAttachment(100, -16);
    fd_roleAssignmentGroup.top = new FormAttachment(0, 34);
    roleAssignmentGroup.setLayoutData(fd_roleAssignmentGroup);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 7;
    roleAssignmentGroup.setLayout(gridLayout);
    roleAssignmentGroup.setText("Entitlement Assignment");

    final Group availableRoleGroup = new Group(roleAssignmentGroup, SWT.NONE);
    availableRoleGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
    final FillLayout fillLayout = new FillLayout();
    fillLayout.marginWidth = 5;
    fillLayout.marginHeight = 5;
    availableRoleGroup.setLayout(fillLayout);
    availableRoleGroup.setText("Available Entitlements");

    availableEntitlements = new ListViewer(availableRoleGroup, SWT.MULTI | SWT.BORDER);
    availableEntitlements.addDoubleClickListener(new IDoubleClickListener() {
      public void doubleClick(final DoubleClickEvent event) {
        add();
      }
    });
    availableEntitlements.setLabelProvider(new AvailableListLabelProvider());
    availableEntitlements.setContentProvider(new AvailableContentProvider());

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
    fillLayout_1.marginWidth = 5;
    fillLayout_1.marginHeight = 5;
    availableRoleGroup_1.setLayout(fillLayout_1);
    availableRoleGroup_1.setText("Assigned Entitlements");

    assignedEntitlements = new ListViewer(availableRoleGroup_1, SWT.MULTI | SWT.BORDER);
    assignedEntitlements.addDoubleClickListener(new IDoubleClickListener() {
      public void doubleClick(final DoubleClickEvent event) {
        remove();
      }
    });
    assignedEntitlements.setLabelProvider(new AssignedListLabelProvider());
    assignedEntitlements.setContentProvider(new AssignedContentProvider());

    final Label descriptionLabel = new Label(container, SWT.NONE);
    final FormData fd_descriptionLabel = new FormData();
    fd_descriptionLabel.top = new FormAttachment(text, 0, SWT.TOP);
    fd_descriptionLabel.left = new FormAttachment(0, 280);
    descriptionLabel.setLayoutData(fd_descriptionLabel);
    descriptionLabel.setText("Description:");

    textDesc = new Text(container, SWT.BORDER);
    final FormData fd_textDesc = new FormData();
    fd_textDesc.right = new FormAttachment(roleAssignmentGroup, 0, SWT.RIGHT);
    fd_textDesc.top = new FormAttachment(descriptionLabel, 0, SWT.TOP);
    fd_textDesc.left = new FormAttachment(descriptionLabel, 0, SWT.RIGHT);
    textDesc.setLayoutData(fd_textDesc);
    setTitle("Assign Entitlements");
    init();
    //
    return area;
  }

  private void init() {
    com.safi.db.server.config.User user = SafiServerPlugin.getDefault().getCurrentUser();
    if (!EntitlementUtils.isUserEntitled(user, EntitlementUtils.ENTIT_MANAGE_USERS)) {
      MessageDialog.openError(SafiWorkshopEditorUtil.getActiveShell(), "Not Entitled",
          "You do not have sufficient privileges to carry out this operation.");
      disableAll();
    }
    this.available = (List) EcoreUtil.copyAll(SafiServerPlugin.getDefault()
        .getAvailableEntitlements());

    if (this.role != null) {
      String name = this.role.getName();
      if (name != null) {
        this.text.setText(name);
      }
      String desc = this.role.getDescription();
      if (desc != null) {
        this.textDesc.setText(desc);
      }
      SafiServerPlugin.getDefault().remove(this.available, role.getEntitlements());
      this.assignedEntitlements.setInput(role.getEntitlements());
      this.assignedEntitlements.refresh();
      this.availableEntitlements.setInput(this.available);
      this.assignedEntitlements.refresh();
    }

  }

  private void disableAll() {
    this.text.setEnabled(false);
    this.buttonAdd.setEnabled(false);
    this.buttonRemove.setEnabled(false);
    this.textDesc.setEnabled(false);
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
    return new Point(564, 375);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Role Assignment Dialog");
  }

  @Override
  protected void buttonPressed(int buttonId) {
    if (buttonId == IDialogConstants.CANCEL_ID) {
      this.close();
      return;
    }
    if (buttonId == IDialogConstants.OK_ID) {
      if (apply()) {
        this.setReturnCode(SWT.OK);
        this.close();

      }
      return;
    }
    super.buttonPressed(buttonId);
  }

  private void add() {

    StructuredSelection ss = (StructuredSelection) this.availableEntitlements.getSelection();
    if (ss.isEmpty())
      return;

    for (Object o : ss.toArray()) {
      Entitlement ent = (Entitlement) o;
      this.role.getEntitlements().add(ent);
      available.remove(ent);
    }

    this.availableEntitlements.refresh();
    this.assignedEntitlements.refresh();

  }

  private void remove() {
    StructuredSelection ss = (StructuredSelection) this.assignedEntitlements.getSelection();

    if (ss.isEmpty()) {
      return;
    }
    for (Object o : ss.toArray()) {
      Entitlement ent = (Entitlement) o;
      this.role.getEntitlements().remove(ent);
      this.available.add(ent);
    }

    this.availableEntitlements.refresh();
    this.assignedEntitlements.refresh();

  }

  public boolean apply() {
    String roleName = this.text.getText();
    String desc = this.textDesc.getText();
    if (roleName != null) {
      roleName = roleName.trim();
      if (roleName.length() == 0) {
        this.setErrorMessage("Valid role name is required!");
        return false;
      }
    } else {
      this.setErrorMessage("Valid role name is required!");
    }
    boolean isNewUser = false;
    if (this.role.getId() == -1) {
      isNewUser = true;
    }
    Session session = null;
    try {
      session = DBManager.getInstance().createSession();
      EList<Entitlement> listEnt = null;
      Criteria criteria = session.createCriteria(Role.class).add(
          (Restrictions.eq("name", roleName)));
      java.util.List roles = criteria.list();
      if (roles.size() > 1) {
        this
            .setErrorMessage("Multiple roles with same role name found.  Please contact your administrator.");
        return false;
      }
      if (roles.size() == 1 && isNewUser) {
        this.setErrorMessage("Unique role name is required!");
        return false;
      } else if (roles.size() == 1) {
        Role aRole = (Role) roles.get(0);
        if (aRole.getId() != role.getId()) {
          this.setErrorMessage("Modifying Role has different id!");
          return false;
        }
        listEnt = this.role.getEntitlements();
        this.role = aRole;
      } else if (roles.size() == 0 && isNewUser) {
        // listEnt=this.role.getEntitlements()
      }
      session.beginTransaction();
      this.role.setName(roleName);
      if (desc != null) {
        this.role.setDescription(desc);
      }
      if (listEnt != null) {
        this.role.getEntitlements().clear();
        for (Entitlement ent : listEnt) {
          // this.role.getEntitlements().add(ent);
          Criteria criteria2 = session.createCriteria(Entitlement.class).add(
              (Restrictions.eq("id", ent.getId())));
          List list2 = criteria2.list();
          Entitlement entitle = null;
          if (list2.size() == 0) {
            session.saveOrUpdate(ent);
            entitle = ent;
          } else {
            entitle = (Entitlement) list2.get(0);
          }
          if (entitle != null) {
            this.role.getEntitlements().add(entitle);
          }
        }
      } else {
        ArrayList<Entitlement> aList = new ArrayList<Entitlement>();
        for (Entitlement ent : this.role.getEntitlements()) {
          // this.role.getEntitlements().add(ent);
          Criteria criteria2 = session.createCriteria(Entitlement.class).add(
              (Restrictions.eq("id", ent.getId())));
          List list2 = criteria2.list();
          Entitlement entitle = null;
          if (list2.size() == 0) {
            session.saveOrUpdate(ent);
            entitle = ent;
          } else {
            entitle = (Entitlement) list2.get(0);
          }
          if (entitle != null) {
            aList.add(entitle);
          }
        }
        this.role.getEntitlements().clear();
        for (Entitlement ent : aList) {
          this.role.getEntitlements().add(ent);
        }

      }

      if (!isNewUser) {
        this.role.setModifiedBy(SafiServerPlugin.getDefault().getCurrentUser());
        this.role.setLastModified(new java.sql.Date(System.currentTimeMillis()));
      } else {
        this.role.setCreatedBy(SafiServerPlugin.getDefault().getCurrentUser());
        this.role.setLastModified(new java.sql.Date(System.currentTimeMillis()));
      }
      session.saveOrUpdate(this.role);
      session.getTransaction().commit();

    } catch (DBManagerException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      this.setErrorMessage(e.getMessage());
      return false;
    } catch (HibernateException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      this.setErrorMessage(e.getMessage());
      return false;
    } finally {
      if (session != null) {
        session.close();
        session = null;
      }
    }

    // if (this.assigned.size() == 0) {
    // this.setMessage("Please assign at least 1 role");
    // return false;
    // }
    // String firstName = this.textFileName.getText().trim();
    // String lastName = this.textLastName.getText().trim();
    // String loginName = this.textName.getText().trim();
    // String pass = this.textPass.getText();
    // User currUser = SafiServerPlugin.getDefault().getCurrentUser();
    // Session session = null;
    // try {
    // session = DBManager.getInstance().createSession();
    // Criteria criteria = session.createCriteria(User.class).add(
    // (Restrictions.eq("name", loginName)));
    // java.util.List users = criteria.list();
    // if (users.size() > 1) {
    // this
    // .setErrorMessage("Multiple users with same user ID found. Please
    // contact your
    // administrator.");
    // return false;
    // } else if (users.size() == 1) {
    // User aUser = (User) users.get(0);
    // if (aUser.getId() != this.user.getId()) {
    // this.setErrorMessage("login name has to be unique!");
    // return false;
    // }
    // user = aUser;
    // }
    //
    // boolean isCurrentUser = currUser.getId() == user.getId();
    //
    // boolean isNew = user.getId() == -1;
    // session.beginTransaction();
    // if (firstName != null) {
    // user.setFirstname(firstName);
    // }
    // if (lastName != null) {
    // user.setLastname(lastName);
    // }
    // String oldUsername = user.getName();
    // boolean newName = StringUtils.equals(oldUsername, loginName);
    // if (newName && isCurrentUser) {
    // setErrorMessage("Changing the user ID for the currently logged in
    // user is not
    // permitted.");
    // textLastName.setText(oldUsername);
    // return false;
    // }
    // if (newName && "sa".equals(oldUsername)) {
    // setErrorMessage("Changing the user ID for 'sa' is not
    // permitted.");
    // textLastName.setText("sa");
    // return false;
    // }
    // if (loginName != null) {
    // user.setName(loginName);
    // }
    // String oldPass = user.getPassword();
    // if (pass != null) {
    // user.setPassword(pass);
    // }
    // user.getRoles().clear();
    // for (Role role : this.assigned) {
    // Role r = (Role) session.createCriteria(Role.class).add(
    // (Restrictions.eq("id", role.getId()))).uniqueResult();
    // if (r != null)
    // user.getRoles().add(r);
    // session.saveOrUpdate(r);
    // }
    //
    // // for (Role role : user.getRoles()) {
    // // try{
    // // session.saveOrUpdate(role);
    // // }catch(Exception ex){
    // // ex.printStackTrace();
    // // }
    // // }
    //
    // if (isNew || !newName) {
    // Connection connection = ((SessionImpl) session)
    // .getJDBCContext().getConnectionManager()
    // .getConnection();
    // Statement stat = null;
    // try {
    // stat = connection.createStatement();
    // if (!isNew) {
    // try {
    // stat.execute("drop user '" + oldUsername + "';");
    // } catch (SQLException sqle) {
    // if (sqle.getErrorCode() != -Trace.NO_SUCH_GRANTEE)
    // throw sqle;
    // }
    // }
    // try {
    // stat.execute("create user '" + loginName
    // + "'password '" + pass + "' ADMIN;");
    // } catch (SQLException sqle) {
    // if (sqle.getErrorCode() != -Trace.GRANTEE_ALREADY_EXISTS)
    // throw sqle;
    // stat.execute("alter user '" + loginName
    // + "' set password '" + pass + "';");
    // }
    // } finally {
    // if (stat != null)
    // stat.close();
    // }
    // } else if (!isNew && !StringUtils.equals(oldPass, pass)) {
    // Connection connection = ((SessionImpl) session)
    // .getJDBCContext().getConnectionManager()
    // .getConnection();
    // Statement stat = null;
    // try {
    // stat = connection.createStatement();
    // stat.execute("alter user '" + loginName
    // + "' set password '" + pass + "';");
    // } finally {
    // if (stat != null)
    // stat.close();
    // }
    // }
    // if (isNew) {
    // SafiServerPlugin.getDefault().getSafiServer().getUsers().add(
    // user);
    // session.saveOrUpdate(user);
    // session.saveOrUpdate(SafiServerPlugin.getDefault()
    // .getSafiServer());
    // } else
    // session.saveOrUpdate(user);
    //
    // session.flush();
    // session.getTransaction().commit();
    //
    // if (!isNew && isCurrentUser) {
    // IPreferenceStore store = SafiServerPlugin.getDefault()
    // .getPreferenceStore();
    // store.setValue(PreferenceConstants.PREF_SAFISERVER_USER_PROD,
    // user.getName());
    // store.setValue(PreferenceConstants.PREF_SAFISERVER_PASS, user
    // .getPassword());
    // SafiServerPlugin.getDefault().updateServerResources();
    // } else
    // AsteriskDiagramEditorUtil.getSafiNavigator().modelChanged();
    // } catch (Exception e) {
    // e.printStackTrace();
    // this.setMessage(e.getMessage());
    // return false;
    // } finally {
    // if (session != null) {
    // session.close();
    // session = null;
    // }
    // }

    return true;
  }

  public Role getRole() {
    return this.getRole();
  }

}
