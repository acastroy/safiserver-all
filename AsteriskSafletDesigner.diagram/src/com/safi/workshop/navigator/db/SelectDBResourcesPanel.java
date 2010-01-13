package com.safi.workshop.navigator.db;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;
import com.safi.db.DBConnection;
import com.safi.db.DBDriver;
import com.safi.db.DBResource;
import com.safi.db.DbFactory;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.db.SafiDriverManager;
import com.safi.db.server.config.ServerResource;

public class SelectDBResourcesPanel extends Composite {

  private static ImageDescriptor dbconnectionDesc;

  private static ImageDescriptor dbdriverDesc;

  private static ImageDescriptor queryDesc;

  private static ImageDescriptor parameterDesc;

  private static boolean useImages = true;

  private static void initImages() {
    dbconnectionDesc = ImageDescriptor.createFromURL(FileLocator.find(Platform
        .getBundle("AsteriskSafletDesigner.diagram"), new Path("icons/DBConnection.gif"), null));
    dbdriverDesc = ImageDescriptor.createFromURL(FileLocator.find(Platform
        .getBundle("AsteriskSafletDesigner.diagram"), new Path("icons/DBDriver.gif"), null));
    queryDesc = ImageDescriptor.createFromURL(FileLocator.find(Platform
        .getBundle("AsteriskSafletDesigner.diagram"), new Path("icons/Query.gif"), null));
    parameterDesc = ImageDescriptor.createFromURL(FileLocator.find(Platform
        .getBundle("AsteriskSafletDesigner.diagram"), new Path("icons/QueryParameter.gif"), null));
  }
  public enum Mode {
    RETRIEVE, DELETE, EXPORT
  };
  private Tree tree;
  private SafiDriverManager manager;
  private CheckboxTreeViewer checkboxTreeViewer;
  private ArrayList<DBResource> checkedList;
  private Mode mode;

  public enum NodeType {
    DRIVERMANAGER, DRIVER, CONNECTION, QUERY, QUERYPARAM
  }

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public SelectDBResourcesPanel(Composite parent, SafiDriverManager manager, Mode mode) {
    super(parent, SWT.NONE);
    this.manager = manager;
    this.mode = mode;
    if (useImages)
      initImages();

    createDialogArea();
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  protected void createDialogArea() {
    setLayout(new GridLayout());
    setLayoutData(new GridData(GridData.FILL_BOTH));

    checkboxTreeViewer = new CheckboxTreeViewer(this, SWT.FULL_SELECTION | SWT.BORDER);
    checkboxTreeViewer.addCheckStateListener(new ICheckStateListener() {
      public void checkStateChanged(final CheckStateChangedEvent event) {

        DBResourceNode node = (DBResourceNode) event.getElement();
        Object[] checkedElements = checkboxTreeViewer.getCheckedElements();
        updateTree(node, checkedElements, event.getChecked());
        checkedElements = checkboxTreeViewer.getCheckedElements();
      }
    });
    // checkboxTreeViewer.setLabelProvider(new TreeLabelProvider());
    checkboxTreeViewer.setContentProvider(new TreeContentProvider());
    tree = checkboxTreeViewer.getTree();
    tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    //
    tree.setLinesVisible(true);
    tree.setHeaderVisible(true);
    TreeViewerColumn nameColumn = new TreeViewerColumn(checkboxTreeViewer, SWT.NONE);
    nameColumn.getColumn().setWidth(200);
    nameColumn.getColumn().setMoveable(true);
    nameColumn.getColumn().setText("Name");
    nameColumn.setLabelProvider(new ColumnLabelProvider() {
      private Image dbConnectionImage;
      private Image queryParamImage;
      private Image queryImage;
      private Image dbDriverImage;

      @Override
      public void dispose() {
        if (dbConnectionImage != null)
          dbConnectionImage.dispose();
        if (queryParamImage != null)
          queryParamImage.dispose();
        if (queryImage != null)
          queryImage.dispose();
        if (dbDriverImage != null)
          dbDriverImage.dispose();
        super.dispose();
      }

      @Override
      public String getText(Object element) {
        return ((DBResourceNode) element).resource.getName();
      }

      @Override
      public Image getImage(Object element) {
        if (!useImages)
          return null;
        switch (((DBResourceNode) element).type) {
          case CONNECTION:
            if (dbConnectionImage == null)
              dbConnectionImage = dbconnectionDesc.createImage();
            return dbConnectionImage;
          case DRIVER:
            if (dbDriverImage == null)
              dbDriverImage = dbdriverDesc.createImage();
            return dbDriverImage;
          case QUERY:
            if (queryImage == null)
              queryImage = queryDesc.createImage();
            return queryImage;
          case QUERYPARAM:
            if (queryParamImage == null)
              queryParamImage = parameterDesc.createImage();
            return queryParamImage;
        }
        return null;
      }
    });

    final DateFormat format = DateFormat.getDateTimeInstance();
    TreeViewerColumn lastModifiedCol = new TreeViewerColumn(checkboxTreeViewer, SWT.NONE);
    lastModifiedCol.getColumn().setWidth(100);
    lastModifiedCol.getColumn().setMoveable(true);
    lastModifiedCol.getColumn().setText("Last Modified");
    lastModifiedCol.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(Object element) {
        Date lastModified = ((DBResourceNode) element).resource.getLastModified();
        if (lastModified == null)
          return "";
        return format.format(lastModified);
      }

    });

    TreeViewerColumn descCol = new TreeViewerColumn(checkboxTreeViewer, SWT.NONE);
    descCol.getColumn().setWidth(250);
    descCol.getColumn().setMoveable(false);
    descCol.getColumn().setText("Description");
    descCol.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(Object element) {
        DBResourceNode node = ((DBResourceNode) element);
        switch (node.type) {
          case CONNECTION:
            return "Connection URL: " + ((DBConnection) node.resource).getUrl();
          case DRIVER:
            return "Classname: " + ((DBDriver) node.resource).getDriverClassName();
          case QUERY:
            return "SQL: " + ((Query) node.resource).getQuerySql();
          case QUERYPARAM:
            return "Data type: " + ((QueryParameter) node.resource).getDataType().toString();
          default:
            return "";
        }
      }

      @Override
      public String getToolTipText(Object element) {
        if (element instanceof ServerResource) {
          return ((ServerResource) element).getDescription();
        }
        return super.getToolTipText(element);
      }

      @Override
      public int getToolTipDisplayDelayTime(Object object) {
        return 200;
      }
    });

    checkboxTreeViewer.setInput(new DBResourceNode(manager));
    // if (mode == Mode.RETRIEVE) {
    // setMessage("Select database resources for retrieval from production SafiServer");
    // setTitle("Retrieve Database Resources");
    // } else { // delete
    // setMessage("Select database resources for permanent deletion from production SafiServer");
    // setTitle("Delete Database Resources");
    // }

  }

  protected void updateTree(DBResourceNode node, Object[] checkedElements, boolean checked) {
    List<DBResourceNode> descendants = getDescendants(node);
    Set<Object> checkedList2 = new HashSet<Object>(Arrays.asList(checkedElements));
    for (DBResourceNode n : descendants) {
      checkboxTreeViewer.setGrayChecked(n, false);
      checkboxTreeViewer.setChecked(n, checked);
      if (checked)
        checkedList2.add(n);
      else
        checkedList2.remove(n);
    }

    updateParents(node, checkedList2);
  }

  private void updateParents(DBResourceNode child, Set checkedElements) {
    DBResourceNode parent = child.getParent();
    if (parent == null)
      return;

    List children = parent.getChildren();
    List cloned = (List) ((ArrayList) children).clone();
    cloned.removeAll(checkedElements);
    if (cloned.isEmpty()) { // all checked
      if (mode == Mode.RETRIEVE || mode == Mode.EXPORT) {
        checkboxTreeViewer.setGrayed(parent, false);
        checkboxTreeViewer.setChecked(parent, true);
        checkedElements.add(parent);
      }
    } else {
      if (mode == Mode.RETRIEVE || mode == Mode.EXPORT || checkboxTreeViewer.getChecked(parent)) {
        if (cloned.size() == children.size()) { // no sibs checked
          checkboxTreeViewer.setGrayChecked(parent, false);
        } else {
          checkboxTreeViewer.setGrayChecked(parent, true);
        }
        checkedElements.remove(parent);
      }
    }
    updateParents(parent, checkedElements);
  }

  private List<DBResourceNode> getDescendants(DBResourceNode node) {
    List<DBResourceNode> desc = new ArrayList<DBResourceNode>();
    getDescendantsHelper(desc, node);
    return desc;

  }

  private void getDescendantsHelper(List<DBResourceNode> descendants, DBResourceNode node) {
    List<DBResourceNode> childs = node.getChildren();
    if (childs.isEmpty())
      return;
    descendants.addAll(childs);
    for (DBResourceNode child : childs) {
      getDescendantsHelper(descendants, child);
    }

  }

  private boolean contains(Object[] checkedElements, Object o) {
    for (Object ob : checkedElements)
      if (ob == o)
        return true;
    return false;
  }

  private DBResourceNode getTopParent(DBResourceNode node) {
    DBResourceNode parent = null;
    while ((parent = node.getParent()) != null)
      node = node.getParent();
    return node;
  }

  public List<DBResource> getCheckedItems() {
    Object[] checked = checkboxTreeViewer.getCheckedElements();
    List l = new ArrayList(Arrays.asList(checked));

    Object[] grayed = checkboxTreeViewer.getGrayedElements();
    if (l.size() > 1) {
      Collections.sort(l, new HierarchicalComparator(mode == Mode.RETRIEVE || mode == Mode.EXPORT));
    }
    checkedList = new ArrayList<DBResource>();
    for (Object o : l) {
      checkedList.add(((DBResourceNode) o).resource);
    }

    return checkedList;
  }

  // @SuppressWarnings("unchecked")
  // @Override
  // protected void okPressed() {
  // // Object[] checked = checkboxTreeViewer.getCheckedElements();
  // // List l = new ArrayList(Arrays.asList(checked));
  // //
  // // Object[] grayed = checkboxTreeViewer.getGrayedElements();
  // // if (l.size() > 1){
  // // Collections.sort(l, new HierarchicalComparator(mode == Mode.RETRIEVE));
  // // }
  // // checkedList = new ArrayList<DBResource>();
  // // for (Object o : l) {
  // // checkedList.add(((DBResourceNode) o).resource);
  // // }
  //
  // super.okPressed();
  // }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */

  class TreeContentProvider implements IStructuredContentProvider, ITreeContentProvider {
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

    }

    public void dispose() {
    }

    public Object[] getElements(Object inputElement) {
      return getChildren(inputElement);
    }

    public Object[] getChildren(Object parentElement) {
      return ((DBResourceNode) parentElement).getChildren().toArray();
    }

    public Object getParent(Object element) {
      return ((DBResourceNode) element).getParent();
    }

    public boolean hasChildren(Object element) {
      return !((DBResourceNode) element).getChildren().isEmpty();
    }

  }

  public static void main(String[] args) {
    // Display d = Display.getDefault();
    // Shell shell = new Shell(d);
    // SelectDBResourcesPanel.useImages = false;
    // SelectDBResourcesPanel dlg = new SelectDBResourcesPanel(shell, buildDemoProjects(),
    // Mode.RETRIEVE);
    // dlg.open();
    // d.dispose();
  }

  private static SafiDriverManager buildDemoProjects() {
    List<DBDriver> drivers = new ArrayList<DBDriver>();
    SafiDriverManager m = DbFactory.eINSTANCE.createSafiDriverManager();
    m.setName("SafiDriverManager");

    DBDriver d1 = DbFactory.eINSTANCE.createDBDriver();
    d1.setName("Driver1");
    m.getDrivers().add(d1);

    DBConnection d1c1 = DbFactory.eINSTANCE.createDBConnection();
    d1c1.setName("ConnectionD1C1");
    d1.getConnections().add(d1c1);
    Query d1c1q1 = DbFactory.eINSTANCE.createQuery();
    d1c1q1.setName("Queryd1c1q1");
    d1c1.getQueries().add(d1c1q1);

    Query d1c1q2 = DbFactory.eINSTANCE.createQuery();
    d1c1q2.setName("Queryd1c1q2");
    d1c1.getQueries().add(d1c1q2);

    QueryParameter d1c1q1p1 = DbFactory.eINSTANCE.createQueryParameter();
    d1c1q1p1.setName("QueryParamd1c1q1p1");
    d1c1q2.getParameters().add(d1c1q1p1);

    return m;
  }

  public static List<DBResource> openSelectDialog(final Shell parentShell,
      final SafiDriverManager manager, final Mode mode) {
    final Object[] result = new Object[1];
    TitleAreaDialog dlg = new TitleAreaDialog(parentShell) {
      SelectDBResourcesPanel panel;

      @Override
      protected Control createDialogArea(Composite parent) {
        setShellStyle(getShellStyle() | SWT.RESIZE | SWT.MAX);
        Composite area = (Composite) super.createDialogArea(parent);
        panel = new SelectDBResourcesPanel(area, manager, mode);
        panel.checkboxTreeViewer.addCheckStateListener(new ICheckStateListener() {
          public void checkStateChanged(final CheckStateChangedEvent event) {
            Object[] checkedElements = panel.checkboxTreeViewer.getCheckedElements();
            getButton(IDialogConstants.OK_ID).setEnabled(checkedElements.length > 0);
          }
        });

        if (mode == Mode.RETRIEVE) {
          setMessage("Select database resources for retrieval from production SafiServer");
          setTitle("Retrieve Database Resources");
        } else if (mode == Mode.DELETE) { // delete
          setMessage("Select database resources for permanent deletion from production SafiServer");
          setTitle("Delete Database Resources");
        } else if (mode == Mode.EXPORT) { // delete
          setMessage("Select database resources for export");
          setTitle("Export Database Resources");
        }
        return area;
      }

      @Override
      protected void okPressed() {
        result[0] = panel.getCheckedItems();
        super.okPressed();
      }

      @Override
      protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true).setEnabled(
            false);
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
        newShell.setText("Retrieve Saflet Resources");
      }

    };

    int res = dlg.open();
    if (Window.OK == res) {
      return (List<DBResource>) result[0];
    }
    return null;
  }

  class DBResourceNode {
    NodeType type;
    DBResource resource;
    List<DBResourceNode> children;
    DBResourceNode parent;

    public DBResourceNode(DBResource resource, DBResourceNode parent) {
      this(resource);
      this.parent = parent;
    }

    public DBResourceNode(DBResource resource) {
      this.resource = resource;
      if (resource instanceof DBDriver)
        type = NodeType.DRIVER;
      else if (resource instanceof DBConnection)
        type = NodeType.CONNECTION;
      else if (resource instanceof Query)
        type = NodeType.QUERY;
      else if (resource instanceof QueryParameter)
        type = NodeType.QUERYPARAM;
      else if (resource instanceof SafiDriverManager)
        type = NodeType.DRIVERMANAGER;
    }

    public DBResourceNode getParent() {
      return parent;
    }

    @SuppressWarnings("unchecked")
    public List getChildren() {
      if (children != null)
        return children;

      switch (type) {
        case CONNECTION:
          return buildChildren(((DBConnection) resource).getQueries());
        case DRIVER:
          return buildChildren(((DBDriver) resource).getConnections());
        case QUERY:
          return buildChildren(((Query) resource).getParameters());
        case DRIVERMANAGER:
          return buildChildren(((SafiDriverManager) resource).getDrivers());
        default:
          children = Collections.EMPTY_LIST;
      }
      return children;
    }

    private List buildChildren(List childs) {
      children = new ArrayList<DBResourceNode>();
      for (Object o : childs) {
        children.add(new DBResourceNode((DBResource) o, this));
      }
      return children;
    }

  }

  class HierarchicalComparator implements Comparator<DBResourceNode> {
    boolean ascending = true;

    public HierarchicalComparator(boolean asc) {
      ascending = asc;
    }

    @Override
    public int compare(DBResourceNode o1, DBResourceNode o2) {
      if (ascending)
        return o1.type.compareTo(o2.type);
      else
        return o2.type.compareTo(o1.type);
    }
  }
}
