package com.safi.workshop.sheet.actionstep;

import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.internal.databinding.swt.TextObservableValue;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.RunQuery;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class RunQueryOutputEditorPage extends AbstractActionstepEditorPage {

  private Text textResultSet;
  private DynamicValueEditorWidget dynamicValueTextRowUpdated;

  public RunQueryOutputEditorPage(final ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 3;
    setLayout(gridLayout);

    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();
    final RunQuery runQuery = (RunQuery) parent.getEditPart().getActionStep();

    final Label oLabel = new Label(this, SWT.NONE);
    oLabel.setText("Result Set:");

    textResultSet = new Text(this, SWT.BORDER);
    textResultSet.setEditable(false);
    final GridData gd_text_ResultSet = new GridData(SWT.FILL, SWT.CENTER, true, false);
    textResultSet.setLayoutData(gd_text_ResultSet);

    IObservableValue obResultSet = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("resultSetName"));
    TextObservableValue uiResultSet = (TextObservableValue) SWTObservables.observeText(
        textResultSet, SWT.FocusOut);
    bindingContext.bindValue(uiResultSet, obResultSet, null, null);

    new Label(this, SWT.NONE);

    final Label osqlLabel = new Label(this, SWT.NONE);
    osqlLabel.setText("Rows Updated Var:");

    dynamicValueTextRowUpdated = new DynamicValueEditorWidget(this, SWT.NONE);
    dynamicValueTextRowUpdated.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    dynamicValueTextRowUpdated.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(runQuery
        .getRowsUpdatedVar()));
    dynamicValueTextRowUpdated.setEditingDomain(editingDomain);
    dynamicValueTextRowUpdated.setObject(runQuery);

    final GridData gd_text_rows_updated_var = new GridData(SWT.FILL, SWT.CENTER, true, false);
    dynamicValueTextRowUpdated.setLayoutData(gd_text_rows_updated_var);
    new Label(this, SWT.NONE);

    EStructuralFeature textFeature2 = runQuery.eClass().getEStructuralFeature("rowsUpdatedVar");
    dynamicValueTextRowUpdated.setFeature(textFeature2);

    IObservableValue ob2 = ActionstepEditObservables.observeValue(editingDomain, runQuery,
        textFeature2);
    DynamicValueWidgetObservableValue valueVal2 = new DynamicValueWidgetObservableValue(
        dynamicValueTextRowUpdated, SWT.Modify);

    bindingContext.bindValue(valueVal2, ob2, null, null);

    // bindingContext.bindValue(comboElement, ob, null, null);
  }

  @Override
  public String getTabText() {
    // TODO Auto-generated method stub
    return "Output";
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
