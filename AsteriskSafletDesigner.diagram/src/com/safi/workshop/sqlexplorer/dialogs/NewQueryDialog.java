package com.safi.workshop.sqlexplorer.dialogs;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.safi.db.DBConnection;
import com.safi.db.Query;
import com.safi.db.QueryParameter;
import com.safi.db.QueryType;
import com.safi.db.SQLDataType;
import com.safi.workshop.sqlexplorer.parsers.BasicQueryParser;

public class NewQueryDialog extends org.eclipse.jface.dialogs.TitleAreaDialog {

  public enum Mode {
    ADD, MODIFY, MODIFY_PARAMS, SAVE_QRY
  }

  private Combo combo_1;
  private Combo combo;
  private Text parameterNameText;
  private List list;
  private Text queryText;
  private Text queryNameField;
  private Query query;
  private Query originalQuery;
  private QueryParameter selectedParameter;
  private ComboViewer parameterTypeComboViewer;
  private Mode mode;
  private ListViewer parameterListViewer;
  private ComboViewer typeComboViewer;
  private DBConnection connection;

  /**
   * Create the dialog
   * 
   * @param parentShell
   */
  public NewQueryDialog(Shell parentShell, Query query, Mode mode) {
    super(parentShell);
    this.originalQuery = query;
    this.query = (Query) EcoreUtil.copy(originalQuery);
    this.mode = mode;

  }

  /**
   * Create contents of the dialog
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    final GridLayout gridLayout = new GridLayout();
    container.setLayout(gridLayout);
    new Label(container, SWT.NONE);

    final Composite composite = new Composite(container, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 3;
    composite.setLayout(gridLayout_1);

    queryText = new Text(composite, SWT.MULTI | SWT.BORDER);
    queryText.setEditable(false);
    final GridData gd_queryText = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
    gd_queryText.heightHint = 50;
    queryText.setLayoutData(gd_queryText);
    queryText.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(FocusEvent e) {
        if (query.getQuerySql() == null
            || !StringUtils
                .equalsIgnoreCase(queryText.getText().trim(), query.getQuerySql().trim())) {

          query.setQuerySql(queryText.getText());
          BasicQueryParser.updateParameters(query);
          parameterListViewer.refresh();
        }
      }
    });

    final Composite composite_1 = new Composite(composite, SWT.NONE);
    final GridLayout gridLayout_2 = new GridLayout();
    gridLayout_2.numColumns = 4;
    composite_1.setLayout(gridLayout_2);
    composite_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));

    final Label enterQueryNameLabel = new Label(composite_1, SWT.NONE);
    enterQueryNameLabel.setText("Query name:");

    queryNameField = new Text(composite_1, SWT.BORDER);
    queryNameField.addFocusListener(new FocusAdapter() {
      @Override
      public void focusLost(FocusEvent e) {
        commitChanges();
      }
    });
    queryNameField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    parameterListViewer = new ListViewer(composite, SWT.BORDER);
    parameterListViewer.setLabelProvider(new ListLabelProvider());
    parameterListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        StructuredSelection structuredSelection = ((StructuredSelection) event.getSelection());
        selectedParameterChanged(structuredSelection.size() <= 0 ? null
            : (QueryParameter) structuredSelection.getFirstElement());
      }

    });
    list = parameterListViewer.getList();
    final GridData gd_list = new GridData(SWT.FILL, SWT.FILL, false, true, 1, 4);
    gd_list.widthHint = 133;
    list.setLayoutData(gd_list);
    parameterListViewer.setContentProvider(new ContentProvider());
    parameterListViewer.setInput(new Object());

    final Label label = new Label(composite, SWT.NONE);
    label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

    final Label parameterNameLabel = new Label(composite, SWT.NONE);
    final GridData gd_parameterNameLabel = new GridData();
    parameterNameLabel.setLayoutData(gd_parameterNameLabel);
    parameterNameLabel.setText("Parameter name:");

    parameterNameText = new Text(composite, SWT.BORDER);
    parameterNameText.setEnabled(false);

    final GridData gd_parameterNameText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    parameterNameText.setLayoutData(gd_parameterNameText);

    final Label parameterTypeLabel = new Label(composite, SWT.NONE);
    parameterTypeLabel.setText("Parameter type:");

    parameterTypeComboViewer = new ComboViewer(composite, SWT.BORDER);
    parameterTypeComboViewer.addSelectionChangedListener(new ISelectionChangedListener() {
      public void selectionChanged(SelectionChangedEvent event) {
        commitChanges();
        parameterListViewer.refresh(true);
      }
    });
    parameterTypeComboViewer.setLabelProvider(new ParameterTypeLabelProvider());
    parameterTypeComboViewer.setContentProvider(new ParamTypeProvider());
    parameterTypeComboViewer.setInput(new Object());
    combo = parameterTypeComboViewer.getCombo();
    combo.setEnabled(false);
    combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    final Label label2 = new Label(composite, SWT.NONE);
    label2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));

    setMessage("Specify the name of the query and the type of each parameter (if any).");
    String title = null;
    switch (mode) {
      case ADD:
        title = "Add Query";
        break;
      case MODIFY:
      case MODIFY_PARAMS:
        title = "Edit Query";
        break;
      case SAVE_QRY:
        title = "Save Query";
    }
    setTitle(title);
    parameterListViewer.setInput(query);
    queryText.setText(query.getQuerySql() == null ? "" : query.getQuerySql());
    if (query.getName() != null)
      queryNameField.setText(query.getName());
    else {
      queryNameField.setText("New Query");
    }
    final Label queryTypeLabel = new Label(composite_1, SWT.NONE);
    queryTypeLabel.setText("Query type");

    typeComboViewer = new ComboViewer(composite_1, SWT.BORDER);
    typeComboViewer.setContentProvider(new TypeContentProvider());
    typeComboViewer.setInput(new Object());
    typeComboViewer.setLabelProvider(new QueryTypeLabelProvider());
    combo_1 = typeComboViewer.getCombo();
    combo_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    if (mode == Mode.MODIFY_PARAMS) {
      queryText.setEditable(false);
    } else {
      queryText.setEditable(true);
    }

    typeComboViewer.setSelection(new StructuredSelection(query.getQueryType()));

    if (StringUtils.isNotBlank(query.getQuerySql())) {
      String txt = query.getQuerySql().toLowerCase();
      if (txt.indexOf("update") >= 0)
        parameterTypeComboViewer.setSelection(new StructuredSelection(QueryType.UPDATE));
      else
        parameterTypeComboViewer.setSelection(new StructuredSelection(QueryType.SELECT));
    }
    return container;
  }

  protected void selectedParameterChanged(QueryParameter param) {
    combo.setEnabled(param != null);
    commitChanges();
    selectedParameter = param;
    update();

  }

  private void update() {
    if (query.getName() != null)
      queryNameField.setText(query.getName());
    else
      queryNameField.setText("New Query");

    if (selectedParameter != null) {
      parameterNameText.setText(selectedParameter.getName());
      parameterTypeComboViewer
          .setSelection(new StructuredSelection(selectedParameter.getDataType()));
    }
    typeComboViewer.setSelection(new StructuredSelection(query.getQueryType()));
  }

  private void commitChanges() {
    if (selectedParameter != null) {
      selectedParameter.setDataType((SQLDataType) ((StructuredSelection) parameterTypeComboViewer
          .getSelection()).getFirstElement());

    }
    if (StringUtils.isNotBlank(queryNameField.getText()))
      query.setName(queryNameField.getText());
    if (queryText.isEnabled())
      query.setQuerySql(queryText.getText());
    ISelection selection = typeComboViewer.getSelection();
    if (selection != null) {
      QueryType qryType = (QueryType) ((StructuredSelection) selection).getFirstElement();
      query.setQueryType(qryType);
    }

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
    return new Point(601, 401);
  }

  @Override
  protected void okPressed() {
    commitChanges();
    applyChanges(originalQuery, query);
    if (originalQuery.getConnection() == null && mode == Mode.ADD && connection != null) {
      originalQuery.setConnection(connection);
    }
    super.okPressed();
  }

  private void applyChanges(Query originalQuery, Query query) {
    originalQuery.setName(query.getName());
    originalQuery.setQuerySql(query.getQuerySql());
    originalQuery.setQueryType(query.getQueryType());
    originalQuery.getParameters().clear();
    originalQuery.getParameters().addAll(query.getParameters());
    originalQuery.setLastModified(new java.util.Date());

  }

  class ContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      return query.getParameters().toArray();
      // int size = query.getParameters().size();
      // if (size <= 0) return null;
      //      
      // String[] params = new String[size];
      // int i=0;
      // for (QueryParameter q : query.getParameters()){
      // params[i++] =
      // }
      // return new Object[] { "item_0", "item_1", "item_2" };
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }

  class ListLabelProvider extends LabelProvider {
    @Override
    public String getText(Object element) {
      return ((QueryParameter) element).getName() + "[" + ((QueryParameter) element).getDataType()
          + "]";
    }

    @Override
    public Image getImage(Object element) {
      return null;
    }
  }

  class ParamTypeProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      return SQLDataType.values();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }

  class ParameterTypeLabelProvider extends LabelProvider {
    @Override
    public String getText(Object element) {
      return element.toString();
    }

    @Override
    public Image getImage(Object element) {
      return null;
    }
  }

  public Mode getMode() {
    return mode;
  }

  public void setMode(Mode mode) {
    this.mode = mode;
  }
  class TypeContentProvider implements IStructuredContentProvider {
    public Object[] getElements(Object inputElement) {
      return QueryType.values();
    }

    public void dispose() {
    }

    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
    }
  }
  class QueryTypeLabelProvider extends LabelProvider {
    @Override
    public String getText(Object element) {
      return element.toString();
    }

    @Override
    public Image getImage(Object element) {
      return null;
    }
  }

  public void setParentConnection(DBConnection connection) {
    this.connection = connection;

  }

}
