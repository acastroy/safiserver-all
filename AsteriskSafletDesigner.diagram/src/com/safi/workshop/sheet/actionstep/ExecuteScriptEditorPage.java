package com.safi.workshop.sheet.actionstep;

import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.jface.internal.databinding.swt.TextObservableValue;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.ExecuteScript;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class ExecuteScriptEditorPage extends AbstractActionstepEditorPage {

  private Text escapeDigitsText;
  private Combo combo;
  private ComboViewer comboViewer;
  private Label call1Label;
  private Text nameText;
  private Label nameLabel;
  private DynamicValueEditorWidget scriptDVEWidget;

  public ExecuteScriptEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    // ----------- ActionStep Stuff
    ExecuteScript executescript = (ExecuteScript) parent.getEditPart().getActionStep();

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

    // ----------- script Field
    final Label digitsLabel = new Label(this, SWT.NONE);
    digitsLabel.setText("Script:");

    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    scriptDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    scriptDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    scriptDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(executescript
        .getScriptText()));
    scriptDVEWidget.setEditingDomain(editingDomain);
    scriptDVEWidget.setObject(executescript);

    EStructuralFeature scriptFeature = executescript.eClass().getEStructuralFeature("scriptText");
    scriptDVEWidget.setFeature(scriptFeature);

    ob = ActionstepEditObservables.observeValue(editingDomain, executescript, scriptFeature);
    DynamicValueWidgetObservableValue scriptVal = new DynamicValueWidgetObservableValue(
        scriptDVEWidget, SWT.Modify);

    bindingContext.bindValue(scriptVal, ob, null, null);

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
