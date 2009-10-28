package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.databinding.EMFDataBindingContext;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
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

import com.safi.core.actionstep.GetColMapping;
import com.safi.core.saflet.SafletContext;
import com.safi.db.SQLDataType;
import com.safi.workshop.part.AsteriskDiagramEditorPlugin;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class EditGetColMappingDialog extends TitleAreaDialog {

  private Combo combo;
  private ComboViewer comboViewer;
  private Label getAsDataLabel;
  private DynamicValueEditorWidget variableNameDVEWidget;
  private Label varNameLabel;
  private DynamicValueEditorWidget columnDVEWidget;
  private Label columnLabel;
  private GetColMapping mapping;
  private EMFDataBindingContext bindingContext;
  private EditingDomain editingDomain;
  private SafletContext handlerContext;

  /**
   * Create the dialog
   * 
   * @param parentShell
   * @param handlerContext
   */
  public EditGetColMappingDialog(Shell parentShell, GetColMapping mapping,
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
    columnLabel.setText("Column:");

    columnDVEWidget = new DynamicValueEditorWidget(container, SWT.NONE);
    final GridData gd_columnDynamicValueEditorWidget = new GridData(SWT.FILL, SWT.CENTER, true,
        false);
    columnDVEWidget.setLayoutData(gd_columnDynamicValueEditorWidget);

    varNameLabel = new Label(container, SWT.NONE);
    varNameLabel.setText("Variable Name:");

    variableNameDVEWidget = new DynamicValueEditorWidget(container, SWT.NONE);
    variableNameDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    getAsDataLabel = new Label(container, SWT.NONE);
    getAsDataLabel.setText("Get As Data Type:");

    comboViewer = new ComboViewer(container, SWT.BORDER);
    combo = comboViewer.getCombo();
    combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    setTitle("Get Column Mapping");
    //
    bindingContext = new EMFDataBindingContext();

    columnDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(mapping.getColumn()));
    columnDVEWidget.setEditingDomain(editingDomain);
    columnDVEWidget.setHandlerContext(handlerContext);
    columnDVEWidget.setObject(mapping);
    EStructuralFeature colFeature = mapping.eClass().getEStructuralFeature("column");
    columnDVEWidget.setFeature(colFeature);
    IObservableValue ob = ActionstepEditObservables
        .observeValue(editingDomain, mapping, colFeature);
    DynamicValueWidgetObservableValue colVal = new DynamicValueWidgetObservableValue(
        columnDVEWidget, SWT.Modify);
    bindingContext.bindValue(colVal, ob, null, null);

    variableNameDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(mapping
        .getVariableName()));
    variableNameDVEWidget.setEditingDomain(editingDomain);
    variableNameDVEWidget.setHandlerContext(handlerContext);
    variableNameDVEWidget.setObject(mapping);
    EStructuralFeature valueFeature = mapping.eClass().getEStructuralFeature("variableName");
    variableNameDVEWidget.setFeature(valueFeature);
    ob = ActionstepEditObservables.observeValue(editingDomain, mapping, valueFeature);
    DynamicValueWidgetObservableValue valVal = new DynamicValueWidgetObservableValue(
        variableNameDVEWidget, SWT.Modify);
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
        .getEStructuralFeature("getAsDatatype"));
    ISWTObservableValue comboElement = SWTObservables.observeSelection(combo);
    comboElement = SWTObservables.observeDelayedValue(400, comboElement);
    bindingContext.bindValue(comboElement, ob, null, null);

    setTitleImage(AsteriskDiagramEditorPlugin.getInstance().getItemImage(mapping));
    return area;
  }

  @Override
  public boolean close() {
    if (bindingContext != null)
      bindingContext.dispose();
    return super.close();
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
    return new Point(400, 252);
  }

  @Override
  protected void configureShell(Shell newShell) {
    super.configureShell(newShell);
    newShell.setText("Get Column Mapping");
  }

}
