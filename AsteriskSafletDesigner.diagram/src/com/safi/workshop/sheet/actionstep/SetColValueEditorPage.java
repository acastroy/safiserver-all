package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import com.safi.core.actionstep.DBResultSetId;
import com.safi.core.actionstep.SetColValue;
import com.safi.db.SQLDataType;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class SetColValueEditorPage extends AbstractActionstepEditorPage {

  private Combo setAsTypeCombo;
  private ComboViewer setAsTypeComboViewer;
  private Label setAsDatatypeLabel;
  private DynamicValueEditorWidget colNameDVEWidget;
  private Label columnNameLabel;
  private DynamicValueEditorWidget valDVEWidget;
  private Label valueLabel;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label resultSetLabel;
  private Text text;
  private Label nameLabel;

  public SetColValueEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    nameLabel = new Label(this, SWT.NONE);
    nameLabel.setText("Name*:");

    text = new Text(this, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 50;
    text.setLayoutData(gd_text);

    resultSetLabel = new Label(this, SWT.NONE);
    resultSetLabel.setText("Result Set*:");

    comboViewer = new ComboViewer(this, SWT.BORDER);
    combo = comboViewer.getCombo();
    combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    //

    SetColValue setColValue = (SetColValue) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();
    IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, setColValue,
        setColValue.eClass().getEStructuralFeature("name"));

    ISWTObservableValue uiElement = SWTObservables.observeText(text, SWT.FocusOut);
    uiElement = SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    List<DBResultSetId> resultSets = new ArrayList<DBResultSetId>();
    for (Iterator<EObject> iter = setColValue.eResource().getAllContents(); iter.hasNext();) {
      EObject obj = iter.next();
      if (obj instanceof DBResultSetId)
        resultSets.add((DBResultSetId) obj);
    }
    comboViewer.setContentProvider(new IStructuredContentProvider() {

      @Override
      public void dispose() {
      }

      @Override
      public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
      }

      @Override
      public Object[] getElements(Object inputElement) {
        return ((List<DBResultSetId>) inputElement).toArray();
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
        return ((DBResultSetId) element).getName();
      }

    });
    comboViewer.setInput(resultSets);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(),
        setColValue, setColValue.eClass().getEStructuralFeature("resultSet"));
    ISWTObservableValue comboElement = SWTObservables.observeSelection(combo);

    valueLabel = new Label(this, SWT.NONE);
    valueLabel.setText("Value*:");

    valDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    valDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    columnNameLabel = new Label(this, SWT.NONE);
    columnNameLabel.setText("Column Name*:");

    colNameDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    colNameDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    setAsDatatypeLabel = new Label(this, SWT.NONE);
    setAsDatatypeLabel.setText("Get As Datatype*:");

    setAsTypeComboViewer = new ComboViewer(this, SWT.BORDER);
    setAsTypeCombo = setAsTypeComboViewer.getCombo();
    final GridData gd_getAsTypeCombo = new GridData(SWT.FILL, SWT.CENTER, true, false);
    setAsTypeCombo.setLayoutData(gd_getAsTypeCombo);
    // uiElement = SWTObservables.observeSingleSelectionIndex(combo);
    comboElement = SWTObservables.observeDelayedValue(400, comboElement);
    ResultSetUpdateStrategy cus = new ResultSetUpdateStrategy(resultSets);
    bindingContext.bindValue(comboElement, ob, cus, cus);

    valDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(setColValue.getValue()));
    // varDVEWidget.setDynamicValue(assignmentStep.getVariableName());
    valDVEWidget.setEditingDomain(editingDomain);
    valDVEWidget.setObject(setColValue);

    EStructuralFeature varNameFeature = setColValue.eClass().getEStructuralFeature("value");
    valDVEWidget.setFeature(varNameFeature);
    DynamicValueWidgetObservableValue varVal = new DynamicValueWidgetObservableValue(valDVEWidget,
        SWT.Modify);
    IObservableValue ob2 = ActionstepEditObservables.observeValue(editingDomain, setColValue,
        varNameFeature);
    bindingContext.bindValue(varVal, ob2, null, null);

    colNameDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(setColValue
        .getColumn()));
    // varDVEWidget.setDynamicValue(assignmentStep.getVariableName());
    colNameDVEWidget.setEditingDomain(editingDomain);
    colNameDVEWidget.setObject(setColValue);

    EStructuralFeature colNameFeature = setColValue.eClass().getEStructuralFeature("column");
    colNameDVEWidget.setFeature(colNameFeature);
    DynamicValueWidgetObservableValue colVal = new DynamicValueWidgetObservableValue(
        colNameDVEWidget, SWT.Modify);
    IObservableValue ob3 = ActionstepEditObservables.observeValue(editingDomain, setColValue,
        colNameFeature);
    bindingContext.bindValue(colVal, ob3, null, null);

    final List<SQLDataType> sqlDataTypeValues = new ArrayList<SQLDataType>();
    sqlDataTypeValues.addAll(SQLDataType.VALUES);

    setAsTypeComboViewer.setContentProvider(new IStructuredContentProvider() {

      @Override
      public void dispose() {
      }

      @Override
      public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
      }

      @Override
      public Object[] getElements(Object inputElement) {

        return sqlDataTypeValues.toArray();

      }

    });
    setAsTypeComboViewer.setLabelProvider(new ILabelProvider() {

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
    setAsTypeComboViewer.setInput(sqlDataTypeValues);

    ob = ActionstepEditObservables.observeValue(parent.getEditPart().getEditingDomain(), parent
        .getEditPart().getActionStep(), parent.getEditPart().getActionStep().eClass()
        .getEStructuralFeature("setAsDatatype"));
    ISWTObservableValue comboElement2 = SWTObservables.observeSelection(setAsTypeCombo);

    comboElement2 = SWTObservables.observeDelayedValue(400, comboElement2);
    bindingContext.bindValue(comboElement2, ob, null, null);

  }

  // @Override
  // public void aboutToExecute(CompoundCommand command) {
  // final ToolstepEditPart editPart = editorDialog.getEditPart();
  // Command cmd = new CaseItemReorderCommand(editPart.getEditingDomain(), editPart);
  // // editPart.getEditingDomain().getCommandStack().execute(cmd);
  // // editorDialog.appendRollbackItem(new ActionstepEditorDialog.RollbackItem(cmd));
  // command.append(cmd);
  // super.aboutToExecute(command);
  // }
  //  
  // @Override
  // public void rollbackCommandAdded(CompoundCommand command) {
  // // TODO Auto-generated method stub
  // final ToolstepEditPart editPart = editorDialog.getEditPart();
  // Command cmd = new CaseItemReorderCommand(editPart.getEditingDomain(), editPart);
  // command.append(cmd);
  // super.rollbackCommandAdded(command);
  // }

  @Override
  public String getTabText() {
    // TODO Auto-generated method stub
    return "Basic";
  }

  @Override
  public boolean validate() {
    IObservableList list = bindingContext.getBindings();
    for (Binding b : (List<Binding>) list) {
      b.validateTargetToModel();
    }
    return true;
  }

}
