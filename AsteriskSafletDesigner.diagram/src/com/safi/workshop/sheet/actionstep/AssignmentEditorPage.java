package com.safi.workshop.sheet.actionstep;

import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.Assignment;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class AssignmentEditorPage extends AbstractActionstepEditorPage {

  private DynamicValueEditorWidget valueDVEWidget;
  private Label valueLabel;
  private DynamicValueEditorWidget varDVEWidget;
  private Label call1Label;
  private Text text;
  private Label nameLabel;

  public AssignmentEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    Assignment assignmentStep = (Assignment) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    nameLabel = new Label(this, SWT.NONE);
    nameLabel.setText("Name:");

    text = new Text(this, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 50;
    text.setLayoutData(gd_text);

    final Label label = new Label(this, SWT.SEPARATOR | SWT.HORIZONTAL);
    final GridData gd_label = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
    gd_label.heightHint = 20;
    label.setLayoutData(gd_label);

    final Composite composite = new Composite(this, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
    final GridLayout gridLayout_1 = new GridLayout();
    gridLayout_1.numColumns = 3;
    composite.setLayout(gridLayout_1);

    call1Label = new Label(composite, SWT.NONE);
    call1Label.setText("Variable:");
    new Label(composite, SWT.NONE);

    valueLabel = new Label(composite, SWT.NONE);
    valueLabel.setText("Value:");

    varDVEWidget = new DynamicValueEditorWidget(composite, SWT.NONE);
    varDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    varDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(assignmentStep
        .getVariableName()));
    // varDVEWidget.setDynamicValue(assignmentStep.getVariableName());
    varDVEWidget.setEditingDomain(editingDomain);
    varDVEWidget.setObject(assignmentStep);

    EStructuralFeature varNameFeature = assignmentStep.eClass().getEStructuralFeature(
        "variableName");
    varDVEWidget.setFeature(varNameFeature);
    DynamicValueWidgetObservableValue varVal = new DynamicValueWidgetObservableValue(varDVEWidget,
        SWT.Modify);

    final Label label_1 = new Label(composite, SWT.NONE);
    label_1.setText(" = ");

    valueDVEWidget = new DynamicValueEditorWidget(composite, SWT.NONE);
    valueDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    valueDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(assignmentStep
        .getValue()));
    // valueDVEWidget.setDynamicValue(assignmentStep.getValue());
    valueDVEWidget.setEditingDomain(editingDomain);
    valueDVEWidget.setObject(assignmentStep);
    EStructuralFeature valueFeature = assignmentStep.eClass().getEStructuralFeature("value");
    valueDVEWidget.setFeature(valueFeature);
    DynamicValueWidgetObservableValue valVal = new DynamicValueWidgetObservableValue(
        valueDVEWidget, SWT.Modify);

    //

    IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, assignmentStep,
        assignmentStep.eClass().getEStructuralFeature("name"));
    // IObservableValue ob =
    // EMFObservables.observeValue(parent.getEditPart().getActionStep(), parent
    // .getEditPart().getActionStep().eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement = SWTObservables.observeText(text, SWT.FocusOut);
    uiElement = SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);
    IObservableValue ob2 = ActionstepEditObservables.observeValue(editingDomain, assignmentStep,
        varNameFeature);
    bindingContext.bindValue(varVal, ob2, null, null);

    IObservableValue ob3 = ActionstepEditObservables.observeValue(editingDomain, assignmentStep,
        valueFeature);
    bindingContext.bindValue(valVal, ob3, null, null);
    // DynamicValueWidgetObservableValue ov = new DynamicValueWidgetObservableValue(dvew);

  }

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
