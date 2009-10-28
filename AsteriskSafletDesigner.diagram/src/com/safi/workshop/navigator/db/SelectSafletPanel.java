package com.safi.workshop.navigator.db;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import com.safi.db.server.config.ConfigFactory;
import com.safi.db.server.config.Saflet;
import com.safi.db.server.config.SafletProject;
import com.safi.db.server.config.ServerResource;
import com.safi.db.server.config.User;

public class SelectSafletPanel extends Composite {

  public enum Mode {
    IMPORT, EXPORT, DELETE, SELECT_SAFLET
  };
  protected Tree tree;
  protected List<SafletProject> projects;
  protected Map<String, ServerResource> localResources;
  protected CheckboxTreeViewer checkboxTreeViewer;
  protected ArrayList<ServerResource> checkedList;
  protected Mode mode;
  protected List<String> selectedSaflets;

  public SelectSafletPanel(Composite parent) {
    super(parent, SWT.NONE);
    projects = new ArrayList<SafletProject>();
    mode = Mode.SELECT_SAFLET;
  }

  /**
   * Create the dialog
   * 
   * @param parentShell
   */

  public SelectSafletPanel(Composite parent, List<SafletProject> projects,
      Map<String, ServerResource> localResources, Mode mode, List<String> selectedSaflets) {
    super(parent, SWT.NONE);
    this.projects = projects;
    this.mode = mode;
    this.localResources = localResources;
    this.selectedSaflets = selectedSaflets;
    createDialogArea();
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  protected void createDialogArea() {
    // Composite container = new Composite(area, SWT.NONE);
    GridLayout layout = new GridLayout();
    layout.marginBottom = 0;
    layout.marginHeight = 0;
    layout.marginLeft = 0;
    layout.marginRight = 0;
    layout.marginTop = 0;
    layout.marginWidth = 0;
    setLayout(layout);
    setLayoutData(new GridData(GridData.FILL_BOTH));

    checkboxTreeViewer = new CheckboxTreeViewer(this, SWT.FULL_SELECTION | SWT.BORDER);
    checkboxTreeViewer.addCheckStateListener(new ICheckStateListener() {
      public void checkStateChanged(final CheckStateChangedEvent event) {
        boolean isChecked = event.getChecked();
        Object obj = event.getElement();
        updateCheckboxes(isChecked, obj);
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
    nameColumn.getColumn().setWidth(130);
    nameColumn.getColumn().setMoveable(true);
    nameColumn.getColumn().setText("Name");
    nameColumn.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(Object element) {
        if (element instanceof ServerResource) {
          return ((ServerResource) element).getName();
        }
        return super.getText(element);
      }

      @Override
      public Color getForeground(Object element) {
        if (localResources != null) {
          String path = null;
          if (element instanceof Saflet) {
            Saflet saf = (Saflet) element;
            path = saf.getProject().getName() + "/" + saf.getName();
          } else {
            path = ((ServerResource) element).getName();
          }
          if (localResources.containsKey(path)
              && localResources.get(path).getClass() == element.getClass())
            return getShell().getDisplay().getSystemColor(SWT.COLOR_BLUE);
        }
        return null;
      }

    });

    TreeViewerColumn createdByCol = new TreeViewerColumn(checkboxTreeViewer, SWT.NONE);
    createdByCol.getColumn().setWidth(100);
    createdByCol.getColumn().setMoveable(true);
    createdByCol.getColumn().setText("Created By");
    createdByCol.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(Object element) {
        if (element instanceof ServerResource) {
          User createdBy = ((ServerResource) element).getCreatedBy();
          if (createdBy != null)
            return createdBy.getName();
          else
            return "";
        }
        return super.getText(element);
      }

      @Override
      public String getToolTipText(Object element) {
        if (element instanceof ServerResource) {
          User createdBy = ((ServerResource) element).getCreatedBy();
          if (createdBy != null) {
            return createdBy.getLastname() + ", " + createdBy.getFirstname() + "\n"
                + createdBy.getDescription();
          }
        }
        return super.getToolTipText(element);
      }

      @Override
      public int getToolTipDisplayDelayTime(Object object) {
        // TODO Auto-generated method stub
        return 200;
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
        if (element instanceof ServerResource) {
          Date lastModified = ((ServerResource) element).getLastModified();
          if (lastModified == null)
            return "";
          return format.format(lastModified);
        }
        return "";
      }

    });

    TreeViewerColumn descCol = new TreeViewerColumn(checkboxTreeViewer, SWT.NONE);
    descCol.getColumn().setWidth(250);
    descCol.getColumn().setMoveable(false);
    descCol.getColumn().setText("Description");
    descCol.setLabelProvider(new ColumnLabelProvider() {
      @Override
      public String getText(Object element) {
        if (element instanceof ServerResource) {
          return ((ServerResource) element).getDescription();
        }
        return super.getText(element);
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

    checkboxTreeViewer.setInput(projects);
    updateSelectedSaflets();
    // if (StringUtils.isNotBlank(selectedSaflet)) {
    // String[] st = selectedSaflet.split("/");
    // if (st.length == 2) {
    // for (SafletProject p : projects) {
    // if (p.getName().equals(st[0])) {
    // for (Saflet s : p.getSaflets()) {
    // if (s.getName().equals(st[1])) {
    // checkboxTreeViewer.setChecked(s, true);
    // updateCheckboxes(true, s);
    // }
    // }
    // break;
    // }
    // }
    // }
    // }

    // if (mode == Mode.IMPORT) {
    // setMessage("Select Saflets and/or Projects for retrieval from production SafiServer");
    // setTitle("Retrieve Saflet Resources");
    // } else if (mode == Mode.DELETE){ // delete
    // setMessage("Select Saflets and/or Projects for permanent deletion from production SafiServer");
    // setTitle("Delete Saflet Resources");
    // }
    // else
    // {
    // setMessage("Select target Saflet");
    // setTitle("Select Saflet");
    // }

  }

  protected void updateSelectedSaflets() {
    if (checkboxTreeViewer == null || checkboxTreeViewer.getTree().isDisposed())
      return;
    if (selectedSaflets != null && !selectedSaflets.isEmpty()) {

      for (SafletProject p : projects) {
        for (Saflet s : p.getSaflets()) {
          String sname = p.getName() + '/' + s.getName();
          if (selectedSaflets.contains(sname)) {
            checkboxTreeViewer.setChecked(s, true);
            updateCheckboxes(true, s);
          }
        }
      }
    }
  }

  public void setProjects(List<SafletProject> projects) {
    this.projects = projects;
    checkboxTreeViewer.setInput(projects);
    updateSelectedSaflets();
  }

  public void setLocalResources(Map<String, ServerResource> localResources) {
    this.localResources = localResources;
    checkboxTreeViewer.refresh();
  }

  // public void setSelectedSaflet(String selectedSaflet) {
  // this.selectedSaflet = selectedSaflet;
  // if (StringUtils.isNotBlank(selectedSaflet) && projects != null) {
  // String[] st = selectedSaflet.split("/");
  // if (st.length == 2) {
  // for (SafletProject p : projects) {
  // if (p.getName().equals(st[0])) {
  // for (Saflet s : p.getSaflets()) {
  // if (s.getName().equals(st[1])) {
  // checkboxTreeViewer.setChecked(s, true);
  // updateCheckboxes(true, s);
  // }
  // }
  // break;
  // }
  // }
  // }
  // }
  // }

  public List<ServerResource> getCheckedItems() {
    Object[] obj = checkboxTreeViewer.getCheckedElements();
    ServerResource[] result = new ServerResource[obj.length];
    for (int i = 0; i < obj.length; i++) {
      result[i] = (ServerResource) obj[i];
    }
    checkedList = new ArrayList<ServerResource>(Arrays.asList(result));
    return checkedList;
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
      if (parentElement instanceof SafletProject) {
        return ((SafletProject) parentElement).getSaflets().toArray();
      } else if (parentElement instanceof List) {
        return ((List) parentElement).toArray();
      }

      return null;
    }

    public Object getParent(Object element) {
      if (element instanceof Saflet) {
        return ((Saflet) element).getProject();
      }
      return null;
    }

    public boolean hasChildren(Object element) {
      if (element instanceof SafletProject || element instanceof List)
        return true;
      return false;
    }
  }

  private static List<SafletProject> buildDemoProjects() {
    List<SafletProject> projects = new ArrayList<SafletProject>();
    User u = ConfigFactory.eINSTANCE.createUser();
    u.setName("zacw");
    u.setFirstname("Zac");
    u.setLastname("Wolfe");
    SafletProject p = ConfigFactory.eINSTANCE.createSafletProject();
    p.setCreatedBy(u);
    Date now = new Date();
    p.setLastModified(now);
    p.setDescription("This is a sweet punk muffin with a long neck disease");
    p.setName("PunkMuffin");

    Saflet s = ConfigFactory.eINSTANCE.createSaflet();
    s.setName("Rig Me Up");
    s.setCreatedBy(u);
    s
        .setDescription("There are times when turtles stack and change the universe one conference call at a time");
    s.setLastModified(now);
    p.getSaflets().add(s);

    s = ConfigFactory.eINSTANCE.createSaflet();
    s.setName("Ripped And Torn");
    s.setCreatedBy(u);
    s.setDescription("Eat good food so hungry when erol-tines survived the wortseed");
    s.setLastModified(now);
    p.getSaflets().add(s);
    projects.add(p);

    p = ConfigFactory.eINSTANCE.createSafletProject();
    p.setCreatedBy(u);
    p.setLastModified(now);
    p.setDescription("Project 2 for smuckers inside llamas");
    p.setName("Llamas");

    s = ConfigFactory.eINSTANCE.createSaflet();
    s.setName("Nipple Test");
    s.setCreatedBy(u);
    s.setDescription("Nipple conformance survey");
    s.setLastModified(now);
    p.getSaflets().add(s);

    // s = ConfigFactory.eINSTANCE.createSaflet();
    // s.setName("EnjoyReal");
    // s.setCreatedBy(u);
    // s.setDescription("Enjoy the realness when people excape");
    // s.setLastModified(now);
    // p.getSaflets().add(s);

    projects.add(p);

    return projects;
  }

  protected void updateCheckboxes(boolean isChecked, Object obj) {
    if (mode == Mode.SELECT_SAFLET) {
      if (isChecked) {
        Object[] checkedElements = checkboxTreeViewer.getCheckedElements();
        List<Object> l = new ArrayList<Object>();
        boolean isSaflet = obj instanceof Saflet;
        for (Object o : checkedElements) {
          boolean isProj = o instanceof SafletProject;
          boolean added = false;
          if (isProj && isSaflet) {
            if (((Saflet) obj).getProject() == o) {
              l.add(o);
              added = true;
            }
          } else if (isProj && o == obj) {
            l.add(o);
            added = true;
          } else if (!isProj && o == obj) {
            l.add(o);
            added = true;
          }

          if (!added) {
            checkboxTreeViewer.setGrayChecked(o, false);
          }
        }

        checkboxTreeViewer.setCheckedElements(l.toArray());
      } else
        checkboxTreeViewer.setGrayChecked(obj, false);
    }

    Object[] checkedElements = checkboxTreeViewer.getCheckedElements();
    // Button okButton = getButton(IDialogConstants.OK_ID);
    // if (okButton != null)
    // okButton.setEnabled(checkedElements.length > 0);

    if (obj instanceof SafletProject) {
      ArrayList<Object> checked = new ArrayList<Object>(Arrays.asList(checkedElements));
      if (!isChecked) {
        checked.removeAll(((SafletProject) obj).getSaflets());
      } else {
        if (mode == Mode.SELECT_SAFLET) {
          List<Saflet> sfs = ((SafletProject) obj).getSaflets();
          if (!sfs.isEmpty())
            checked.add(sfs.get(0));
          if (sfs.size() > 1)
            checkboxTreeViewer.setGrayChecked(obj, true);
        } else
          checked.addAll(((SafletProject) obj).getSaflets());
      }
      checkboxTreeViewer.setCheckedElements(checked.toArray());
    } else if (obj instanceof Saflet) {

      SafletProject project = ((Saflet) obj).getProject();

      if (!isChecked) { // unchecked
        if ((mode == Mode.DELETE && checkboxTreeViewer.getChecked(project)) || mode == Mode.IMPORT
            || mode == Mode.EXPORT || mode == Mode.SELECT_SAFLET) {
          // ArrayList<Object> checked = new
          // ArrayList<Object>(Arrays.asList(checkedElements));
          boolean childChecked = false;
          for (Saflet s : project.getSaflets()) {
            if (checkboxTreeViewer.getChecked(s)) {
              childChecked = true;
              break;
            }
          }
          checkboxTreeViewer.setGrayChecked(project, childChecked);
        }

      } else {
        ArrayList<Object> checked = new ArrayList<Object>(Arrays.asList(checkedElements));
        if (checked.containsAll(project.getSaflets())
            && (mode == Mode.IMPORT || mode == Mode.EXPORT || mode == Mode.SELECT_SAFLET)) {
          checkboxTreeViewer.setGrayed(project, false);
          checkboxTreeViewer.setChecked(project, true);
        } else if (mode == Mode.IMPORT || mode == Mode.EXPORT || mode == Mode.SELECT_SAFLET)
          checkboxTreeViewer.setGrayChecked(project, true);
      }
    }

    checkedElements = checkboxTreeViewer.getCheckedElements();
    // if (okButton != null)
    // okButton.setEnabled(checkedElements.length > 0);
  }

  public static List<ServerResource> openSelectDialog(Shell parentShell,
      final List<SafletProject> projects, final Map<String, ServerResource> localResources,
      final Mode mode, final List<String> selectedSaflets) {
    final Object[] result = new Object[1];
    TitleAreaDialog dlg = new TitleAreaDialog(parentShell) {
      SelectSafletPanel panel;

      @Override
      protected Control createDialogArea(Composite parent) {
        setShellStyle(getShellStyle() | SWT.RESIZE | SWT.MAX);
        Composite area = (Composite) super.createDialogArea(parent);
        // area.setLayout(new GridLayout());
        panel = new SelectSafletPanel(area, projects, localResources, mode, selectedSaflets) {
          @Override
          protected void updateCheckboxes(boolean arg0, Object arg1) {
            // TODO Auto-generated method stub
            super.updateCheckboxes(arg0, arg1);
            Object[] checkedElements = checkboxTreeViewer.getCheckedElements();
            Button okButton = getButton(IDialogConstants.OK_ID);
            if (okButton != null)
              okButton.setEnabled(checkedElements.length > 0);
          }
        };
        if (mode == Mode.IMPORT) {
          setMessage("Select Saflets and/or Projects for retrieval from production SafiServer");
          setTitle("Retrieve Saflet Resources");
        } else if (mode == Mode.DELETE) { // delete
          setMessage("Select Saflets and/or Projects for permanent deletion from production SafiServer");
          setTitle("Delete Saflet Resources");
        } else if (mode == Mode.EXPORT) { // delete
          setMessage("Select Saflets and/or Projects for export");
          setTitle("Export Saflet Resources");
        } else {
          setMessage("Select target Saflet");
          setTitle("Select Saflet");
        }
        return panel;
      }

      @Override
      protected void okPressed() {
        result[0] = panel.getCheckedItems();
        super.okPressed();
      }

      /**
       * Create contents of the button bar
       * 
       * @param parent
       */
      @Override
      protected void createButtonsForButtonBar(Composite parent) {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true).setEnabled(
            false);
        createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
        panel.updateSelectedSaflets();
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
    dlg.setBlockOnOpen(true);
    int res = dlg.open();

    if (Window.OK == res) {
      return (List<ServerResource>) result[0];
    }
    return null;

  }

  public void setSelectedSaflets(List<String> selectedSaflets) {
    this.selectedSaflets = selectedSaflets;
    updateSelectedSaflets();

  }
}
