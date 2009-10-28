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

import com.safi.core.actionstep.IfThen;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class IfThenEditorPage extends AbstractActionstepEditorPage {

  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget booleanDVEWidget;

  public IfThenEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    IfThen ifthen = (IfThen) parent.getEditPart().getActionStep();

    // ----------- Name Field
    nameLabel = new Label(this, SWT.NONE);
    nameLabel.setText("Name:");

    nameText = new Text(this, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 50;
    nameText.setLayoutData(gd_text);

    IObservableValue ob = ActionstepEditObservables.observeValue(parent.getEditPart()
        .getEditingDomain(), parent.getEditPart().getActionStep(), parent.getEditPart()
        .getActionStep().eClass().getEStructuralFeature("name"));
    TextObservableValue uiElement = (TextObservableValue) SWTObservables.observeText(nameText,
        SWT.FocusOut);
    SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    // ----------- Boolean Field
    final Label booleanLabel = new Label(this, SWT.NONE);
    booleanLabel.setText("Boolean:");

    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    booleanDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    booleanDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    booleanDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(ifthen
        .getBooleanExpression()));
    booleanDVEWidget.setEditingDomain(editingDomain);
    booleanDVEWidget.setObject(ifthen);

    EStructuralFeature booleanFeature = ifthen.eClass().getEStructuralFeature("booleanExpression");
    booleanDVEWidget.setFeature(booleanFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, ifthen, booleanFeature);
    DynamicValueWidgetObservableValue booleanVal = new DynamicValueWidgetObservableValue(
        booleanDVEWidget, SWT.Modify);

    bindingContext.bindValue(booleanVal, ob, null, null);

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
