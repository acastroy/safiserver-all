package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.QueryParamMapping;
import com.safi.core.saflet.SafletContext;
import com.safi.db.SQLDataType;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class EditQueryParamMappingDialog extends TitleAreaDialog {

  private Combo combo;
  private ComboViewer comboViewer;
  private Label setAsDataLabel;
  private DynamicValueEditorWidget valueDVEWidget;
  private Label valueLabel;
  private Text dbQueryParamIDText;
  private Label columnLabel;
  private QueryParamMapping mapping;
  private EMFDataBindingContext bindingContext;
  private EditingDomain editingDomain;
  private SafletContext handlerContext;

  /**
   * Create the dialog
   * 
   * @param parentShell
   * @param handlerContext
   */
  public EditQueryParamMappingDialog(Shell parentShell, QueryParamMapping mapping,
      EditingDomain editingDomain, SafletContext handlerContext) {
    super(parentShell);
    this.mapping = mapping;
    this.editingDomain = editingDomain;
    this.handlerContext = handlerContext;
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
    gridLayout.marginTop = 20;
    gridLayout.marginRight = 20;
    gridLayout.marginLeft = 20;
    gridLayout.numColumns = 2;
    container.setLayout(gridLayout);
    container.setLayoutData(new GridData(GridData.FILL_BOTH));

    columnLabel = new Label(container, SWT.NONE);
    columnLabel.setText("Query Param ID:");

    dbQueryParamIDText = new Text(container, SWT.NONE);
    final GridData gd_columnDynamicValueEditorWidget = new GridData(SWT.FILL, SWT.CENTER, true,
        false);
    dbQueryParamIDText.setLayoutData(gd_columnDynamicValueEditorWidget);
    dbQueryParamIDText.setEditable(false);

    valueLabel = new Label(container, SWT.NONE);
    valueLabel.setText("Value:");

    valueDVEWidget = new DynamicValueEditorWidget(container, SWT.NONE);
    valueDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    setAsDataLabel = new Label(container, SWT.NONE);
    setAsDataLabel.setText("Set As Data Type:");

    comboViewer = new ComboViewer(container, SWT.BORDER);
    combo = comboViewer.getCombo();
    combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    setTitle("Set Column Mapping");
    //
    bindingContext = new EMFDataBindingContext();

    // columnDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(mapping.getColumn()));
    // columnDVEWidget.setEditingDomain(editingDomain);
    // columnDVEWidget.setHandlerContext(handlerContext);
    // columnDVEWidget.setObject(mapping);
    // EStructuralFeature colFeature =
    // mapping.eClass().getEStructuralFeature("queryParam");
    // columnDVEWidget.setFeature(colFeature);
    // IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain,
    // mapping,
    // colFeature, null);

    // DynamicValueWidgetObservableValue colVal = new DynamicValueWidgetObservableValue(
    // columnDVEWidget, SWT.Modify);
    // bindingContext.bindValue(colVal, ob, null, null);

    valueDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(mapping.getValue()));
    valueDVEWidget.setEditingDomain(editingDomain);
    valueDVEWidget.setHandlerContext(handlerContext);
    valueDVEWidget.setObject(mapping);
    EStructuralFeature valueFeature = mapping.eClass().getEStructuralFeature("value");
    valueDVEWidget.setFeature(valueFeature);
    IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, mapping,
        valueFeature);
    DynamicValueWidgetObservableValue valVal = new DynamicValueWidgetObservableValue(
        valueDVEWidget, SWT.Modify);
    bindingContext.bindValue(valVal, ob, null, null);

    final List<SQLDataType> dataTypes = new ArrayList<SQLDataType>();
    dataTypes.addAll(SQLDataType.VALUES);

    comboViewer.setContentProvider(new IStructuredContentProvider() {

      @Override
      public void dispose() {
      }

      @Override
      public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
      }

      @Override
      public Object[] getElements(Object inputElement) {

        return dataTypes.toArray();

      }

    });
    comboViewer.setLabelProvider(new ILabelProvider() {

      @Override
      public void addListener(ILabelProviderListener listener) {
      }

      @Override
      public void dispose() {
      }

      @Override
      public boolean isLabelProperty(Object element, String property) {
        return true;
      }

      @Override
      public void removeListener(ILabelProviderListener listener) {

      }

      @Override
      public Image getImage(Object element) {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public String getText(Object element) {
        return ((SQLDataType) element).getName();
      }

    });
    comboViewer.setInput(dataTypes);

    ob = ActionstepEditObservables.observeValue(editingDomain, mapping, mapping.eClass()
        .getEStructuralFeature("setAsDatatype"));
    ISWTObservableValue comboElement = SWTObservables.observeSelection(combo);
    comboElement = SWTObservables.observeDelayedValue(400, comboElement);
    bindingContext.bindValue(comboElement, ob, null, null);
    setTitleImage(ExtendedImageRegistry.getInstance().getImage(
        com.safi.asterisk.provider.AsteriskEditPlugin.getPlugin().getImage(
            "full/obj16/RunQuery.gif")));
    // setTitleImage(AsteriskDiagramEditorPlugin.getInstance().getItemImage(mapping));
    dbQueryParamIDText.setText(mapping.getQueryParam().getId() == null ? "" : mapping
        .getQueryParam().getId());

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

  @Override
  public boolean close() {
    if (bindingContext != null)
      bindingContext.dispose();
    return super.close();
  }

  /**
   * Return the initial size of the dialog
   */
  @Override
  protected Point getInitialSize() {
    return new Point(400, 252);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Set Column Mapping");
  }

}
