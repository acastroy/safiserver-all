package com.safi.workshop.sqlexplorer.wizard;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class PropertyEditorTable extends Composite {

  class TableLabelProvider extends LabelProvider implements ITableLabelProvider {

    public String getColumnText(Object element, int columnIndex) {
      Entry entry = (Entry) element;
      if (columnIndex == 0)
        return entry.getKey();
      else
        return entry.getValue();

    }

    public Image getColumnImage(Object element, int columnIndex) {
      return null;
    }
  }

  class ContentProvider implements IStructuredContentProvider {

    public Object[] getElements(Object inputElement) {
      return ((List<Entry>) inputElement).toArray();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }
  private Table table;
  private Properties properties;
  private TableViewer tableViewer;
  private Button addButton;
  private Button removeButton;
  private List<Entry> entries;

  /**
   * Create the composite
   * 
   * @param parent
   * @param style
   */

  public PropertyEditorTable(Composite parent, int style) {
    this(parent, style, new Properties());
  }

  public PropertyEditorTable(Composite parent, int style, final Properties properties) {
    super(parent, style);
    setLayout(new GridLayout());
    this.properties = properties;

    tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
    tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        if (event.getSelection() != null
            && ((IStructuredSelection) event.getSelection()).size() > 0) {
          removeButton.setEnabled(true);

        } else {
          removeButton.setEnabled(false);
        }
      }
    });
    tableViewer.setLabelProvider(new TableLabelProvider());
    // tableViewer.setColumnViewerEditor(null);
    tableViewer.setContentProvider(new ContentProvider());
    entries = getEntries();
    tableViewer.setInput(entries);
    table = tableViewer.getTable();
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    table.setLinesVisible(true);
    table.setHeaderVisible(true);
    TableColumn nameColumn = new TableColumn(table, SWT.LEFT);
    nameColumn.setWidth(150);
    nameColumn.setMoveable(false);
    nameColumn.setText("Name");
    // tableViewer.setEditingSupport(new NameEditingSupport());

    TableColumn valueColumn = new TableColumn(table, SWT.LEFT);
    valueColumn.setWidth(150);
    valueColumn.setMoveable(false);
    valueColumn.setText("Value");

    tableViewer.setColumnProperties(new String[] { "Name", "Value" });
    // valueColumn.setEditingSupport(new ValueEditingSupport());

    tableViewer.setCellModifier(new CellModifier());
    tableViewer.setCellEditors(new CellEditor[] { new TextCellEditor(table),
        new TextCellEditor(table) });
    tableViewer.refresh();

    final Composite composite = new Composite(this, SWT.NONE);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    composite.setLayout(gridLayout);

    addButton = new Button(composite, SWT.NONE);
    addButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        String prefix = "key";
        int i = 1;
        String key;
        while (properties.get(key = (prefix + i)) != null) {
          i++;
        }
        final String value = "value" + i;
        properties.put(key, value);
        entries.add(new Entry(key, value));
        tableViewer.refresh();

      }
    });
    addButton.setEnabled(true);
    addButton.setLayoutData(new GridData(60, SWT.DEFAULT));
    addButton.setText("Add");

    removeButton = new Button(composite, SWT.NONE);
    removeButton.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
        IStructuredSelection sel = (IStructuredSelection) tableViewer.getSelection();

        if (sel != null && sel.size() > 0) {
          Object[] array = sel.toArray();
          for (Object element : array) {
            Entry entry = (Entry) element;
            entries.remove(entry);
            properties.remove(entry.getKey());
          }

          tableViewer.refresh();
        }
      }
    });
    removeButton.setEnabled(false);
    removeButton.setLayoutData(new GridData(60, SWT.DEFAULT));
    removeButton.setText("Remove");
    //
  }

  private List<Entry> getEntries() {
    List<Entry> entries = new ArrayList<Entry>();
    for (Map.Entry<Object, Object> entry : properties.entrySet()) {
      entries.add(new Entry((String) entry.getKey(), (String) entry.getValue()));
    }
    return entries;
  }

  @Override
  public void dispose() {
    super.dispose();
  }

  @Override
  protected void checkSubclass() {
    // Disable the check that prevents subclassing of SWT components
  }

  class CellModifier implements ICellModifier {

    @Override
    public boolean canModify(Object element, String property) {
      return true;
    }

    @Override
    public Object getValue(Object element, String property) {
      // Find the index of the column
      Entry entry = (Entry) element;
      if ("Name".equals(property)) {

        return entry.getKey();
      } else
        return entry.getValue();
    }

    @Override
    public void modify(Object element, String property, Object value) {
      Entry entry = (Entry) ((TableItem) element).getData();
      if ("Name".equals(property)) {
        EntryChangeResult result = entry.setKey((String) value);
        switch (result) {
          case FAILURE:
            MessageDialog.openError(getShell(), "Property already exists",
                "A property with the name " + entry.getKey()
                    + " already exists.  Please select a different name");
            return;
          case REMOVED:
            ((List<Entry>) tableViewer.getInput()).remove(entry);
            tableViewer.refresh();
            return;
          case SUCCESS:
            tableViewer.refresh();
            return;
          case NO_CHANGE:

        }

      } else {
        entry.setValue((String) value);
        tableViewer.refresh();
      }
    }
  }

  public static void main(String[] args) {
    Display d = new Display();
    final Shell shell = new Shell(d);
    shell.setSize(400, 400);
    shell.setLayout(new FillLayout());
    Properties props = new Properties();
    props.setProperty("key1", "value1");
    props.setProperty("key2", "value2");
    PropertyEditorTable editor = new PropertyEditorTable(shell, SWT.NONE, props);
    shell.pack();
    shell.open();

    while (!shell.isDisposed())
      while (!d.readAndDispatch())
        d.sleep();

  }

  public Properties getProperties() {
    return properties;
  }

  enum EntryChangeResult {
    SUCCESS, FAILURE, REMOVED, NO_CHANGE
  };

  class Entry {
    String key;
    String value;

    public Entry(String key, String value) {
      this.key = key;
      this.value = value;
    }

    public EntryChangeResult setKey(String newKey) {
      if (StringUtils.isBlank(newKey)) {
        properties.remove(key);
        return EntryChangeResult.REMOVED;
      }

      if (StringUtils.equals(key, newKey))
        return EntryChangeResult.NO_CHANGE;

      String old = (String) properties.get(newKey);
      if (old != null && old != value)
        return EntryChangeResult.FAILURE;

      properties.remove(key);
      properties.setProperty(newKey, value);
      key = newKey;
      return EntryChangeResult.SUCCESS;
    }

    public EntryChangeResult setValue(String value) {
      properties.setProperty(key, value);
      this.value = value;
      return EntryChangeResult.SUCCESS;
    }

    public String getKey() {
      return key;
    }

    public String getValue() {
      return value;
    }
  }
}
