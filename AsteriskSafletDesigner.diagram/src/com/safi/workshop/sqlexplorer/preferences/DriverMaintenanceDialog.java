package com.safi.workshop.sqlexplorer.preferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.ui.PlatformUI;

import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sqlexplorer.ExplorerException;
import com.safi.workshop.sqlexplorer.IConstants;
import com.safi.workshop.sqlexplorer.Messages;
import com.safi.workshop.sqlexplorer.dbproduct.DriverManager;
import com.safi.workshop.sqlexplorer.dbproduct.ManagedDriver;
import com.safi.workshop.sqlexplorer.dialogs.CreateDriverDlg;
import com.safi.workshop.sqlexplorer.plugin.SQLExplorerPlugin;
import com.safi.workshop.sqlexplorer.util.ImageUtil;

public class DriverMaintenanceDialog extends TitleAreaDialog {

  private TableViewer _tableViewer;

  private Font _boldfont;

  private IPreferenceStore _prefs;

  private DriverManager _driverModel;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public DriverMaintenanceDialog(Shell parentShell) {
    super(parentShell);
  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent1) {
    Composite area = (Composite) super.createDialogArea(parent1);
    Composite parent = new Composite(area, SWT.NONE);
    parent.setLayoutData(new GridData(GridData.FILL_BOTH));

    // noDefaultAndApplyButton();
    _driverModel = SQLExplorerPlugin.getDefault().getDriverModel();

    PlatformUI.getWorkbench().getHelpSystem().setHelp(parent,
        SQLExplorerPlugin.PLUGIN_ID + ".DriverContainerGroup");

    _prefs = SQLExplorerPlugin.getDefault().getPreferenceStore();

    GridLayout parentLayout = new GridLayout(1, false);
    parentLayout.marginTop = parentLayout.marginBottom = 0;
    parentLayout.marginHeight = 0;
    parentLayout.verticalSpacing = 10;
    parent.setLayout(parentLayout);

    GridLayout layout;

    Composite myComposite = new Composite(parent, SWT.NONE);

    // Define layout.
    layout = new GridLayout();
    layout.numColumns = 2;
    layout.marginWidth = layout.marginHeight = 0;
    layout.horizontalSpacing = 20;
    layout.verticalSpacing = 10;
    myComposite.setLayout(layout);

    myComposite.setLayoutData(new GridData(SWT.FILL, SWT.LEFT, true, true));

    GridData gid = new GridData(GridData.FILL_BOTH);
    gid.grabExcessHorizontalSpace = gid.grabExcessVerticalSpace = true;
    gid.horizontalAlignment = gid.verticalAlignment = GridData.FILL;
    gid.verticalSpan = 6;
    _tableViewer = new TableViewer(myComposite, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
    _tableViewer.getControl().setLayoutData(gid);
    _tableViewer.setContentProvider(new DriverContentProvider());
    final DriverLabelProvider dlp = new DriverLabelProvider();
    _tableViewer.setLabelProvider(dlp);
    _tableViewer.getTable().addDisposeListener(new DisposeListener() {

      public void widgetDisposed(DisposeEvent e) {
        dlp.dispose();
        if (_boldfont != null)
          _boldfont.dispose();

      }
    });
    _tableViewer.getTable().addMouseListener(new MouseAdapter() {

      @Override
      public void mouseDoubleClick(MouseEvent e) {
        changeDriver();
      }
    });

    _tableViewer.setInput(_driverModel);
    selectFirst();
    final Table table = _tableViewer.getTable();

    myComposite.layout();
    parent.layout();

    // Add Buttons
    gid = new GridData(GridData.FILL);
    gid.widthHint = 75;
    Button add = new Button(myComposite, SWT.PUSH);
    add.setText(Messages.getString("Preferences.Drivers.Button.Add"));
    add.setLayoutData(gid);
    add.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        CreateDriverDlg dlg = new CreateDriverDlg(getShell(), CreateDriverDlg.Type.CREATE, null);
        dlg.open();

        _tableViewer.refresh();
        selectFirst();
      }
    });

    gid = new GridData(GridData.FILL);
    gid.widthHint = 75;
    Button edit = new Button(myComposite, SWT.PUSH);
    edit.setText(Messages.getString("Preferences.Drivers.Button.Edit"));
    edit.setLayoutData(gid);
    edit.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        changeDriver();
        _tableViewer.refresh();
      }
    });

    gid = new GridData(GridData.FILL);
    gid.widthHint = 75;
    Button copy = new Button(myComposite, SWT.PUSH);
    copy.setText(Messages.getString("Preferences.Drivers.Button.Copy"));
    copy.setLayoutData(gid);
    copy.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        StructuredSelection sel = (StructuredSelection) _tableViewer.getSelection();
        ManagedDriver dv = (ManagedDriver) sel.getFirstElement();
        if (dv != null) {
          CreateDriverDlg dlg = new CreateDriverDlg(getShell(), CreateDriverDlg.Type.COPY, dv);
          dlg.open();
          _tableViewer.refresh();
        }
      }
    });

    gid = new GridData(GridData.FILL);
    gid.widthHint = 75;
    Button remove = new Button(myComposite, SWT.PUSH);
    remove.setText(Messages.getString("Preferences.Drivers.Button.Remove"));
    remove.setLayoutData(gid);
    remove.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {

        boolean okToDelete = MessageDialog.openConfirm(getShell(), Messages
            .getString("Preferences.Drivers.ConfirmDelete.Title"), Messages
            .getString("Preferences.Drivers.ConfirmDelete.Prefix")
            + _tableViewer.getTable().getSelection()[0].getText()
            + Messages.getString("Preferences.Drivers.ConfirmDelete.Postfix"));
        if (okToDelete) {
          StructuredSelection sel = (StructuredSelection) _tableViewer.getSelection();
          ManagedDriver dv = (ManagedDriver) sel.getFirstElement();
          if (dv != null) {
            if (dv.getDriver() != null && dv.getDriver().isDefault()) {
              MessageDialog.openConfirm(getShell(), "Default Driver",
                  "This is a default driver and cannot be deleted");
            } else {
              _driverModel.removeDriver(dv);
              _tableViewer.refresh();
              selectFirst();
            }
          }
        }
      }
    });

    gid = new GridData(GridData.FILL);
    gid.widthHint = 73;
    Button bdefault = new Button(myComposite, SWT.PUSH);
    bdefault.setText(Messages.getString("Preferences.Drivers.Button.Default"));
    bdefault.setLayoutData(gid);
    // Remove bold font on all elements, and make selected element bold
    bdefault.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        for (int i = 0; i < _tableViewer.getTable().getItemCount(); i++) {

          _tableViewer.getTable().getItem(i).setFont(0, table.getFont());
        }
        _boldfont = new Font(_tableViewer.getTable().getDisplay(), table.getFont().toString(),
            table.getFont().getFontData()[0].getHeight(), SWT.BOLD);
        _tableViewer.getTable().getSelection()[0].setFont(0, _boldfont);
        _prefs.setValue(IConstants.DEFAULT_DRIVER, _tableViewer.getTable().getSelection()[0]
            .getText());
      }
    });

    // add button to restore default drivers
    Button bRestore = new Button(parent, SWT.PUSH);
    bRestore.setText(Messages.getString("Preferences.Drivers.Button.RestoreDefault"));
    bRestore.addSelectionListener(new SelectionAdapter() {

      @Override
      public void widgetSelected(SelectionEvent e) {
        try {
          _driverModel.restoreDrivers();
          _tableViewer.refresh();
          selectFirst();
        } catch (ExplorerException ex) {
          SQLExplorerPlugin.error("Cannot restore default driver configuration", ex);
        }
      }
    });

    bRestore.setLayoutData(new GridData(SWT.RIGHT, SWT.BOTTOM, false, false));

    selectDefault(table);
    setTitleImage(AsteriskDiagramEditorPlugin.getInstance().getBundledImage(
        "icons/titlearea/UserManager.gif"));
    // setTitleImage(ResourceManager.getPluginImage(SQLExplorerPlugin.getDefault(),
    // "icons/wizban/NewHandlerWizardOld.gif"));
    setMessage("Add/modify/delete database drivers");
    setTitle("Available Drivers");

    // return parent;

    //
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

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return getShell().computeSize(SWT.DEFAULT, SWT.DEFAULT);
  }

  private void changeDriver() {
    StructuredSelection sel = (StructuredSelection) _tableViewer.getSelection();
    ManagedDriver dv = (ManagedDriver) sel.getFirstElement();
    if (dv != null) {
      CreateDriverDlg dlg = new CreateDriverDlg(getShell(), CreateDriverDlg.Type.MODIFY, dv);
      dlg.open();
      _tableViewer.refresh();
      selectFirst();
    }
  }

  void selectFirst() {
    Iterator<ManagedDriver> iter = _driverModel.getDrivers().iterator();
    if (iter.hasNext()) {
      StructuredSelection sel = new StructuredSelection(iter.next());
      _tableViewer.setSelection(sel);
    }
  }

  // Bold the default driver element
  void selectDefault(Table table) {
    String defaultDriver = _prefs.getString(IConstants.DEFAULT_DRIVER);
    if (defaultDriver == null)
      return;

    int index = 0;
    for (ManagedDriver driver : _driverModel.getDrivers()) {
      if (driver.getId().toLowerCase().startsWith(defaultDriver.toLowerCase())) {
        _boldfont = new Font(_tableViewer.getTable().getDisplay(), table.getFont().toString(),
            table.getFont().getFontData()[0].getHeight(), SWT.BOLD);
        _tableViewer.getTable().getItem(index).setFont(0, _boldfont);
        _tableViewer.getTable().pack(true);
        break;
      }
      index++;
    }
  }

  class DriverContentProvider implements IStructuredContentProvider {

    public Object[] getElements(Object input) {
      ArrayList<ManagedDriver> drivers = new ArrayList<ManagedDriver>();
      drivers.addAll(((DriverManager) input).getDrivers());
      Collections.sort(drivers, new Comparator<ManagedDriver>() {
        public int compare(ManagedDriver left, ManagedDriver right) {
          return left.getId().compareTo(right.getId());
        }
      });
      return drivers.toArray();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }

  class DriverLabelProvider extends LabelProvider implements ITableLabelProvider {

    DriverLabelProvider() {
    };

    public Image getColumnImage(Object element, int i) {
      ManagedDriver dv = (ManagedDriver) element;

      try {
        dv.registerSQLDriver();
      } catch (ClassNotFoundException e) {
        // Nothing
      }
      if (dv.isDriverClassLoaded() == true) {
        return ImageUtil.getImage("Images.OkDriver");
      } else {
        return ImageUtil.getImage("Images.ErrorDriver");
      }
    }

    @Override
    public void dispose() {

      super.dispose();
      ImageUtil.disposeImage("Images.OkDriver");
      ImageUtil.disposeImage("Images.ErrorDriver");

    }

    public String getColumnText(Object element, int i) {
      ManagedDriver dv = (ManagedDriver) element;
      return dv.getId();
    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
      return true;
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
    }

    @Override
    public void addListener(ILabelProviderListener listener) {
    }

  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Driver Manager");
  }
}