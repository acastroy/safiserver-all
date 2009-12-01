package com.safi.workshop.sheet;

import java.net.URL;
import java.util.Collections;

import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.DBConnectionId;
import com.safi.core.actionstep.DBQueryId;
import com.safi.core.actionstep.DBQueryParamId;
import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.db.SafiDriverManager;
import com.safi.db.manager.DBManager;
import com.safi.db.manager.DBManagerException;
import com.safi.server.plugin.SafiServerPlugin;

public class DBResourceChooser extends TitleAreaDialog {

  public enum Mode {
    CONNECTION, QUERY, QUERY_PARAM, RESULT_SET
  }
  private Text infoText;
  private Tree tree;
  private Object selected;
  private Object selectedId; // the Id object
  private String parentId;
  private TreeViewer treeViewer;
  private Mode mode;
  private SafiDriverManager driverManager;
  private boolean disabled;
  private String titleText;
  private String messageText;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public DBResourceChooser(Shell parentShell) {
    super(parentShell);
    // driverManager = SafiServerPlugin.getDefault().getDriverManager();
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
    container.setLayout(new GridLayout());
    container.setLayoutData(new GridData(GridData.FILL_BOTH));

    treeViewer = new TreeViewer(container, SWT.BORDER);
    treeViewer.addDoubleClickListener(new IDoubleClickListener() {
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        handleSelection(selection);
        if (isSelectedValid()) {
          okPressed();
        }

      }
    });
    treeViewer.setLabelProvider(new TreeLabelProvider());
    treeViewer.setContentProvider(new TreeContentProvider());
    treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        handleSelection(selection);

      }
    });
    tree = treeViewer.getTree();
    tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    infoText = new Text(container, SWT.WRAP | SWT.READ_ONLY | SWT.MULTI);
    infoText.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
    infoText.setEditable(false);
    final GridData gd_infoText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_infoText.heightHint = 50;
    infoText.setLayoutData(gd_infoText);

    if (disabled) {
      setTitle(titleText == null ? "No DB Resources Available" : titleText);
      setMessage(messageText == null ? "" : messageText);
    } else {
      setTitle(titleText == null ? "DB Resource Chooser" : titleText);
      setMessage(messageText == null ? "" : messageText);
    }
    driverManager = SafiServerPlugin.getDefault().getDriverManager();
    treeViewer.setInput(driverManager);

    if (selectedId != null)
      revealId(selectedId, false);
    else if (parentId != null)
      revealId(parentId, true);

    // if (StringUtils.isNotBlank(parentId)){
    // Object p = findById(parentId);
    // if (p != null){
    // treeViewer.getTree().set
    // }
    // }
    return area;
  }

  private Object findById(String id) {
    String[] segs = id.split("\\.");
    Object parent = null;
    parent = driverManager.getDriver(segs[0]);
    if (parent == null || segs.length == 1)
      return parent;

    parent = ((DBDriver) parent).getConnection(segs[1]);
    if (parent == null || segs.length == 2)
      return parent;

    parent = ((DBConnection) parent).getQuery(segs[2]);
    if (parent == null || segs.length == 3)
      return parent;

    return ((Query) parent).getParameter(segs[3]);
  }

  public Object findQueryById(String id) {
    String[] segs = id.split("\\.");
    Object parent = null;
    driverManager = SafiServerPlugin.getDefault().getDriverManager();

    parent = driverManager.getDriver(segs[0]);
    if (parent == null || segs.length == 1)
      return parent;

    parent = ((DBDriver) parent).getConnection(segs[1]);
    if (parent == null || segs.length == 2)
      return parent;

    parent = ((DBConnection) parent).getQuery(segs[2]);

    return parent;

  }

  private boolean isChild(String parent, Object child) {
    return constructId(child).startsWith(parent);
  }

  private boolean isChild(Object parent, Object child) {
    return isChild(parent, constructId(child));
  }

  private boolean isChild(Object parent, String childPath) {
    return childPath.startsWith(constructId(parent));
  }

  private void revealId(Object id, boolean expand) {
    if (id != null) {
      switch (mode) {
        case CONNECTION:
          revealId(((DBConnectionId) id).getId(), expand);
          return;
        case QUERY:
          revealId(((DBQueryId) id).getId(), expand);
          return;
        case QUERY_PARAM:
          revealId(((DBQueryParamId) id).getId(), expand);
          return;
      }
    }

    treeViewer.setSelection(null);

  }

  private void revealId(String id, boolean expand) {
    if (id != null) {
      try {
        final Object objectFromPath = DBManager.getInstance().getObjectFromPath(driverManager, id);
        if (objectFromPath != null) {

          treeViewer.setSelection(new StructuredSelection(objectFromPath), true);
          if (expand) {
            treeViewer.expandToLevel(objectFromPath, AbstractTreeViewer.ALL_LEVELS);
          }
        }
      } catch (DBManagerException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    } else
      treeViewer.setSelection(null);

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
    return new Point(500, 375);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("DB Resource Chooser");
  }

  private String getDriverNameFromId(String parentId) {
    String[] str = parentId.split("\\.");
    return str.length > 0 ? str[0] : parentId;
  }

  private String getConnectionNameFromId(String parentId) {
    String[] str = parentId.split("\\.");
    return str.length > 1 ? str[1] : null;
  }

  private String getQueryNameFromId(String parentId) {
    String[] str = parentId.split("\\.");
    return str.length > 2 ? str[2] : null;
  }

  private String getParameterNameFromId(String parentId) {
    String[] str = parentId.split("\\.");
    return str.length > 3 ? str[3] : null;
  }

  class TreeLabelProvider extends LabelProvider {
    private Image driverImage;
    private Image connectionImage;
    private Image queryImage;
    private Image queryParamImage;

    @Override
    public void dispose() {
      if (driverImage != null)
        driverImage.dispose();
      if (connectionImage != null)
        connectionImage.dispose();
      if (queryImage != null)
        queryImage.dispose();
      if (queryParamImage != null)
        queryParamImage.dispose();
    }

    @Override
    public String getText(Object element) {
      if (element instanceof SafiDriverManager)
        return "DB Resource Manager";
      else if (element instanceof DBDriver)
        return "Driver " + ((DBDriver) element).getName();
      else if (element instanceof DBConnection)
        return "Connection " + ((DBConnection) element).getName();
      else if (element instanceof Query)
        return "Query " + ((Query) element).getName();
      else if (element instanceof QueryParameter)
        return "Parameter " + ((QueryParameter) element).getName();

      return super.getText(element);
    }

    @Override
    public Image getImage(Object element) {
      if (element instanceof DBDriver) {
        if (driverImage == null) {
          driverImage = createImageFromPath("full/obj16/DBDriver");
        }
        return driverImage;
      } else if (element instanceof DBConnection) {
        if (connectionImage == null) {
          connectionImage = createImageFromPath("full/obj16/DBConnection");
        }
        return connectionImage;
      } else if (element instanceof Query) {
        if (queryImage == null) {
          queryImage = createImageFromPath("full/obj16/Query");
        }
        return queryImage;
      } else if (element instanceof QueryParameter) {
        if (queryParamImage == null) {
          queryParamImage = createImageFromPath("full/obj16/QueryParameter");
        }
        return queryParamImage;
      }

      return null;
    }

    private Image createImageFromPath(String path) {
      ImageDescriptor imgDesc = ImageDescriptor
          .createFromURL((URL) com.safi.core.provider.CoreEditPluginProv.INSTANCE.getImage(path));
      ImageData data = imgDesc.getImageData();
      data = data.scaledTo(16, 16);
      return ImageDescriptor.createFromImageData(data).createImage(true);
    }
  }
  class TreeContentProvider implements IStructuredContentProvider, ITreeContentProvider {
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

    }

    public void dispose() {
    }

    public Object[] getElements(Object inputElement) {
      return getChildren(inputElement);
    }

    public Object[] getChildren(Object parentElement) {

      if (parentElement instanceof SafiDriverManager) {
        if (disabled)
          return new Object[] { messageText };
        if (parentId != null) {
          String driverNameFromId = getDriverNameFromId(parentId);
          if (driverNameFromId != null)
            return new Object[] { ((SafiDriverManager) parentElement).getDriver(driverNameFromId) };
        }
        return ((SafiDriverManager) parentElement).getDrivers().toArray();
      } else if (parentElement instanceof DBDriver) {
        if (parentId != null) {
          String connectionNameFromId = getConnectionNameFromId(parentId);
          if (connectionNameFromId != null)
            return new Object[] { ((DBDriver) parentElement).getConnection(connectionNameFromId) };
        }
        return ((DBDriver) parentElement).getConnections().toArray();
      } else if (parentElement instanceof DBConnection) {
        if (parentId != null) {
          String queryNameFromId = getQueryNameFromId(parentId);
          if (queryNameFromId != null)
            return new Object[] { ((DBConnection) parentElement).getQuery(queryNameFromId) };
        }
        return ((DBConnection) parentElement).getQueries().toArray();
      } else if (parentElement instanceof Query) {
        if (parentId != null) {
          String parameterNameFromId = getParameterNameFromId(parentId);
          if (parameterNameFromId != null)
            return new Object[] { ((Query) parentElement).getParameter(parameterNameFromId) };
        }

        return ((Query) parentElement).getParameters().toArray();
      }
      return null;
    }

    public Object getParent(Object element) {
      if (element instanceof QueryParameter)
        return ((QueryParameter) element).getQuery();
      if (element instanceof Query)
        return ((Query) element).getConnection();
      else if (element instanceof DBConnection)
        return ((DBConnection) element).getDriver();
      else if (element instanceof DBDriver)
        return ((DBDriver) element).getDriverManager();

      return Collections.EMPTY_LIST;
    }

    public boolean hasChildren(Object element) {
      Object[] children = getChildren(element);
      if (children == null)
        return false;
      return children.length > 0;
    }
  }

  public Object getSelected() {
    return selected;
  }

  public void setSelectedId(Object selected) {
    this.selectedId = selected;
  }

  private String constructId(Object child) {
    if (child instanceof DBDriver)
      return ((DBDriver) child).getName();
    if (child instanceof DBConnection)
      return DBManager.constructConnectionId((DBConnection) child);
    if (child instanceof Query)
      return DBManager.constructQueryId((Query) child);
    if (child instanceof QueryParameter)
      return DBManager.constructQueryParamId((QueryParameter) child);
    return null;
  }

  public Object getSelectedId() {
    if (selected == null)
      return null;

    switch (mode) {
      case CONNECTION:
        if (selected instanceof DBConnection) {
          boolean isValid = selectedId != null && selectedId instanceof DBConnectionId;
          DBConnection connection = (DBConnection) selected;
          String connectionId = DBManager.constructConnectionId(connection);
          if (isValid && ((DBConnectionId) selectedId).getId().equals(connectionId))
            return selectedId;

          // if (!isValid)
          selectedId = ActionStepFactory.eINSTANCE.createDBConnectionId();

          ((DBConnectionId) selectedId).setId(connectionId);

          return selectedId;
        }
        
        break;
      case QUERY:
        if (selected instanceof Query) {
          boolean isValid = selectedId != null && selectedId instanceof DBQueryId;
          Query qry = (Query) selected;
          String qryId = DBManager.constructQueryId(qry);
          if (isValid && ((DBQueryId) selectedId).getId().equals(qryId))
            return selectedId;
          // if (!isValid)
          selectedId = ActionStepFactory.eINSTANCE.createDBQueryId();
          ((DBQueryId) selectedId).setId(qryId);
          return selectedId;
        }
        break;
      case QUERY_PARAM:
        if (selected instanceof QueryParameter) {
          QueryParameter qryParm = (QueryParameter) selected;
          QueryParameter param = qryParm;
          int idx = param.getQuery().getParameters().indexOf(param);
          String parmId = DBManager.constructQueryParamId(qryParm);
          boolean isValid = selectedId != null && selectedId instanceof DBQueryParamId;
          if (isValid && ((DBQueryParamId) selectedId).getId().equals(parmId)
              && ((DBQueryParamId) selectedId).getIndex() == idx)
            return selectedId;

          // if (!isValid)
          selectedId = ActionStepFactory.eINSTANCE.createDBQueryParamId();

          ((DBQueryParamId) selectedId).setId(parmId);

          ((DBQueryParamId) selectedId).setIndex(idx + 1);
          return selectedId;
        }
    }
    return null;
  }

  protected boolean isSelectedIDValid() {
    if (selectedId == null)
      return false;
    switch (mode) {
      case CONNECTION:
        return selectedId instanceof DBConnectionId;
      case QUERY:
        return selectedId instanceof DBQueryId;
      case QUERY_PARAM:
        return selectedId instanceof DBQueryParamId;
      default:
        return false;
    }
  }

  protected boolean isSelectedValid() {
    if (selected == null)
      return false;
    switch (mode) {
      case CONNECTION:
        return selected instanceof DBConnection;
      case QUERY:
        return selected instanceof Query;
      case QUERY_PARAM:
        return selected instanceof QueryParameter;
      default:
        return false;
    }
  }

  public Mode getMode() {
    return mode;
  }

  public void setMode(Mode mode) {
    this.mode = mode;
  }

  public String getParentId() {
    return parentId;
  }

  public void setParentId(String parentId) {
    this.parentId = parentId;
  }

  public void setMessageText(String disabledMessage) {
    this.messageText = disabledMessage;
  }

  public boolean isDisabled() {
    return disabled;
  }

  public void setDisabled(boolean disabled) {
    this.disabled = disabled;
  }

  public void setTitleText(String disabledTitle) {
    this.titleText = disabledTitle;
  }

  private void handleSelection(IStructuredSelection selection) {
    Button b = getButton(IDialogConstants.OK_ID);
    if (selection.isEmpty()) {
      if (b != null)
        b.setEnabled(false);
      infoText.setText("");
      return;
    }

    Object o = selection.getFirstElement();
    if (o instanceof SafiDriverManager) {
      selected = null;
      Button okButton = b;
      if (okButton != null)
        okButton.setEnabled(false);
      infoText.setText("");
    } else if (o instanceof DBDriver) {
      selected = null;
      Button okButton = b;
      if (okButton != null)
        okButton.setEnabled(false);
      infoText.setText("");
      StringBuffer buf = new StringBuffer();
      DBDriver driver = ((DBDriver) o);
      buf.append("Classname: ").append(driver.getDriverClassName()).append('\n');
      buf.append("Example URL: ").append(driver.getExampleUrl()).append('\n');
      buf.append("Pooling: ").append(driver.isPooling()).append('\n');
      infoText.setText(buf.toString());
    } else if (o instanceof DBConnection) {
      if (mode == Mode.CONNECTION && (parentId == null || isChild(parentId, o))) {
        selected = o;
        Button okButton = b;
        if (okButton != null)
          okButton.setEnabled(true);
      } else {
        selected = null;
        Button okButton = b;
        if (okButton != null)
          okButton.setEnabled(false);
      }
      DBConnection conn = (DBConnection) o;
      StringBuffer buf = new StringBuffer();
      buf.append("URL: ").append(conn.getUrl()).append('\n');
      buf.append("User: ").append(conn.getUser()).append('\n');
      buf.append("Login Timeout: ").append(conn.getLoginTimeout()).append('\n');
      buf.append("Transaction Mode: ").append(conn.getTransactionMode()).append('\n');
      buf.append("Min Pool Size: ").append(conn.getMinPoolSize()).append('\n');
      buf.append("Max Pool Size: ").append(conn.getMaxPoolSize()).append('\n');
      buf.append("Acquire Increment: ").append(conn.getAcquireIncrement()).append('\n');
      buf.append("Max Idle Time: ").append(conn.getMaxIdleTime()).append('\n');
      infoText.setText(buf.toString());
    } else if (o instanceof Query) {
      if (mode == Mode.QUERY && (parentId == null || isChild(parentId, o))) {
        selected = o;
        Button okButton = b;
        if (okButton != null)
          okButton.setEnabled(true);
      } else {
        selected = null;
        Button okButton = b;
        if (okButton != null)
          okButton.setEnabled(false);
      }
      Query query = (Query) o;
      StringBuffer buf = new StringBuffer();
      buf.append("SQL: ").append(query.getQuerySql()).append('\n');
      buf.append("Type: ").append(query.getQueryType()).append('\n');
      if (StringUtils.isNotBlank(query.getCatalog()))
        buf.append("Default Catalog: ").append(query.getCatalog()).append('\n');

      infoText.setText(buf.toString());
    } else if (o instanceof QueryParameter) {
      if (mode == Mode.QUERY_PARAM && (parentId == null || isChild(parentId, o))) {
        selected = o;
        Button okButton = b;
        if (okButton != null)
          okButton.setEnabled(true);
      } else {
        selected = null;
        Button okButton = b;
        if (okButton != null)
          okButton.setEnabled(false);
      }
      QueryParameter param = (QueryParameter) o;
      StringBuffer buf = new StringBuffer();
      buf.append("Type: ").append(param.getDataType()).append('\n');
      infoText.setText(buf.toString());

    }
  }

}
