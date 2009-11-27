package com.safi.workshop.application;

import java.io.File;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.safi.asterisk.handler.util.FileUtils;
import com.safi.workshop.application.ChooseSafiServerWorkspaceData.SafiWorkspaceProfile;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.swtdesigner.ResourceManager;

public class ChooseSafiWorkspaceDialog extends TitleAreaDialog {

  // public static final String KEY_REMEMBER_WORKSPACE_PREF = "wsRemember";
  // private static Preferences _preferences =
  // Preferences.userNodeForPackage(ChooseSafiWorkspaceDialog.class);
  private TableColumn descriptionColumn;
  private TableColumn pathColumn;
  private TableColumn nameColumn;
  public Image productionSafiServerImage;

  class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
    public String getColumnText(Object element, int columnIndex) {
      if (element instanceof ChooseSafiServerWorkspaceData.SafiWorkspaceProfile) {
        final SafiWorkspaceProfile safiWorkspaceProfile = (ChooseSafiServerWorkspaceData.SafiWorkspaceProfile) element;
        switch (columnIndex) {
          case 0:
            return safiWorkspaceProfile.getName();
          case 1:
            return safiWorkspaceProfile.getPath();
          case 2:
            return safiWorkspaceProfile.getDescription();
        }
      } else {
        if (columnIndex == 0)
          return element.toString();
      }
      return null;
    }

    public Image getColumnImage(Object element, int columnIndex) {
      if (columnIndex == 0) {
        if (productionSafiServerImage == null) {
          productionSafiServerImage = AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
              "icons/server/resource/ProductionSafiServer.gif");
        }
        return productionSafiServerImage;
      }
      return null;
    }
  }
  class ContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      return data == null ? null : data.getRecentWorkspaces().toArray();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }
  private Button deleteWorkspaceButton;
  private Button editWorkspaceButton;
  private Button addWorkspaceButton;
  private Composite buttonPanel;
  private Table table;
  private TableViewer tableViewer;
  private ChooseSafiServerWorkspaceData data;
  private Button rememberWSCheckBox;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public ChooseSafiWorkspaceDialog(Shell parentShell, ChooseSafiServerWorkspaceData data) {
    super(parentShell);
    this.data = data;
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
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    container.setLayoutData(new GridData(GridData.FILL_BOTH));

    tableViewer = new TableViewer(container, SWT.FULL_SELECTION | SWT.BORDER);
    tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(final SelectionChangedEvent event) {
        if (!event.getSelection().isEmpty()) {
          Object o = ((StructuredSelection) event.getSelection()).getFirstElement();
          if (o instanceof ChooseSafiServerWorkspaceData.SafiWorkspaceProfile)
            selectWorkspace((ChooseSafiServerWorkspaceData.SafiWorkspaceProfile) o);
        }
      }
    });
    tableViewer.addDoubleClickListener(new IDoubleClickListener() {
      public void doubleClick(final DoubleClickEvent event) {
//        if (!tableViewer.getSelection().isEmpty()) {
//          Object o = ((StructuredSelection) tableViewer.getSelection()).getFirstElement();
//          if (o instanceof ChooseSafiServerWorkspaceData.SafiWorkspaceProfile) {
//            EditWorkspaceProfileDialog dialog = new EditWorkspaceProfileDialog(getShell(),
//                (ChooseSafiServerWorkspaceData.SafiWorkspaceProfile) o, data.getRecentWorkspaces());
//            if (Window.OK == dialog.open()) {
//              tableViewer.setSelection(new StructuredSelection(dialog.getProfile()));
//              tableViewer.refresh();
//            }
//          }
//        }
      	okPressed();
      }
    });
    tableViewer.setLabelProvider(new TableLabelProvider());
    tableViewer.setContentProvider(new ContentProvider());
    table = tableViewer.getTable();
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    table.setLinesVisible(true);
    table.setHeaderVisible(true);

    nameColumn = new TableColumn(table, SWT.NONE);
    nameColumn.setWidth(120);
    nameColumn.setText("Name");

    pathColumn = new TableColumn(table, SWT.NONE);
    pathColumn.setWidth(170);
    pathColumn.setText("Path");

    descriptionColumn = new TableColumn(table, SWT.NONE);
    descriptionColumn.setWidth(100);
    descriptionColumn.setText("Description");

    buttonPanel = new Composite(container, SWT.NONE);
    buttonPanel.setLayout(new GridLayout());

    addWorkspaceButton = new Button(buttonPanel, SWT.NONE);
    addWorkspaceButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        EditWorkspaceProfileDialog dialog = new EditWorkspaceProfileDialog(getShell(), null, data
            .getRecentWorkspaces());
        if (Window.OK == dialog.open()) {
          data.getRecentWorkspaces().add(dialog.getProfile());
          data.setSelection(dialog.getProfile());

          tableViewer.refresh();
          tableViewer.setSelection(new StructuredSelection(dialog.getProfile()));
        }
      }
    });
    addWorkspaceButton.setToolTipText("Add Workspace");
    addWorkspaceButton.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
        .getDefault(), "icons/vareditor/AddVariable.gif"));

    editWorkspaceButton = new Button(buttonPanel, SWT.NONE);
    editWorkspaceButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        if (!tableViewer.getSelection().isEmpty()) {
          Object o = ((StructuredSelection) tableViewer.getSelection()).getFirstElement();
          if (o instanceof ChooseSafiServerWorkspaceData.SafiWorkspaceProfile) {
            EditWorkspaceProfileDialog dialog = new EditWorkspaceProfileDialog(getShell(),
                (ChooseSafiServerWorkspaceData.SafiWorkspaceProfile) o, data.getRecentWorkspaces());
            if (Window.OK == dialog.open()) {
              tableViewer.setSelection(new StructuredSelection(dialog.getProfile()));
              tableViewer.refresh();
            }
          }
        }
      }
    });

    editWorkspaceButton.setToolTipText("Edit Workspace");
    editWorkspaceButton.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
        .getDefault(), "icons/edittsk_tsk.gif"));

    deleteWorkspaceButton = new Button(buttonPanel, SWT.NONE);
    deleteWorkspaceButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(final SelectionEvent e) {
        if (!tableViewer.getSelection().isEmpty()) {
          Object o = ((StructuredSelection) tableViewer.getSelection()).getFirstElement();
          if (o instanceof ChooseSafiServerWorkspaceData.SafiWorkspaceProfile) {
            deleteWorkspace((ChooseSafiServerWorkspaceData.SafiWorkspaceProfile) o);
          }
        }
      }
    });
    deleteWorkspaceButton.setToolTipText("Delete Workspace");
    deleteWorkspaceButton.setImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin
        .getDefault(), "icons/vareditor/RemoveVariable.gif"));
    //

    tableViewer.setInput(data);
    if (data.getRecentWorkspaces() != null && !data.getRecentWorkspaces().isEmpty()) {
      final SafiWorkspaceProfile ws = data.getRecentWorkspaces().get(0);
      tableViewer.setSelection(new StructuredSelection(ws));
      selectWorkspace(ws);
    }
    setTitleImage(ResourceManager.getPluginImage(AsteriskDiagramEditorPlugin.getDefault(),
        "icons/titlearea/WorkspaceChooser.gif"));
    setTitle("SafiServer Workspace Chooser");
    setMessage("Select, add, edit, or delete SafiServer Workspace");
    tableViewer.getTable().setToolTipText("Double-click a workspace to open it");
    return area;
  }

  @Override
  protected boolean isResizable() {
    return true;
  }
  protected void deleteWorkspace(SafiWorkspaceProfile o) {
    File file = new File(o.getPath());
    if (file.exists()) {
      MessageDialog dlg = new MessageDialog(
          getShell(),
          "Delete Contents?",
          null,
          "Do you want to delete the Workspace contents on the file system as well? (this operation cannot be undone)",
          MessageDialog.QUESTION,
          new String[] { "Cancel", "Delete Contents", "Delete Entry Only" }, 0);
      int res = dlg.open();
      if (res == 0)
        return;
      if (res == 1)
        try {
          if (!FileUtils.deleteDirectory(file)) {
            MessageDialog.openError(getShell(), "Couldn't Delete", "Workspace located at "
                + file.getAbsolutePath() + " could not be deleted.");
            return;
          }
        } catch (Exception e) {
          e.printStackTrace();
          MessageDialog.openError(getShell(), "Couldn't Delete", "Workspace located at "
              + o.getPath() + " could not be deleted: " + e.getLocalizedMessage());
          return;
        }
    } else {
      if (!MessageDialog.openQuestion(getShell(), "Delete Workspace?",
          "Are you sure you want to delete the workspace " + o.getName())) {
        return;
      }
    }
    data.getRecentWorkspaces().remove(o);
    if (data.getSelection() == o)
      data.setSelection(null);

    data.writePersistedData();
    updateOKButton();
    tableViewer.refresh();
  }

  protected void selectWorkspace(SafiWorkspaceProfile o) {
    data.setSelection(o);
    updateOKButton();
  }

  private void updateOKButton() {
    Button okButton = getButton(IDialogConstants.OK_ID);
    if (okButton != null && !okButton.isDisposed()) {
      okButton.setEnabled(data.getSelection() != null);
    }
  }

  @Override
  protected void okPressed() {
    data.setShowDialog(!rememberWSCheckBox.getSelection());
    data.writePersistedData();
    // _preferences.putBoolean(KEY_REMEMBER_WORKSPACE_PREF,
    // rememberWSCheckBox.getSelection());
    super.okPressed();
  }

  /**
   * Create contents of the button bar
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    rememberWSCheckBox = new Button(parent, SWT.CHECK);
    rememberWSCheckBox.setText("Use this workspace as the default from now on");
    setButtonLayoutData(rememberWSCheckBox);
    // rememberWSCheckBox.setSelection(_preferences.getBoolean(KEY_REMEMBER_WORKSPACE_PREF,
    // false));
    rememberWSCheckBox.setSelection(!data.getShowDialog());
    // GridData data = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
    // int widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
    // Point minSize = rememberWSCheckBox.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
    // data.widthHint = Math.max(widthHint, minSize.x);
    // rememberWSCheckBox.setLayoutData(data);

    ((GridLayout) parent.getLayout()).numColumns++;
    ((GridLayout) parent.getLayout()).makeColumnsEqualWidth = false;
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);

    updateOKButton();
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(547, 375);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("SafiServer Workspace Chooser");
  }

}
