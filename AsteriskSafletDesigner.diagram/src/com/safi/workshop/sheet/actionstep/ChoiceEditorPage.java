package com.safi.workshop.sheet.actionstep;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.Choice;
import com.safi.core.actionstep.Item;
import com.safi.workshop.edit.parts.ChoiceEditPart;
import com.safi.workshop.sheet.DynamicValueEditorUtils;

public class ChoiceEditorPage extends AbstractActionstepEditorPage {

  private CaseItemEditorWidget caseItemEditorWidget;
  private Label choicesLabel;
  private DynamicValueEditorWidget valueDVEWidget;
  private Label valueLabel;
  private Text text;
  private Label nameLabel;
	private IObservableList uiList;

  public ChoiceEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    nameLabel = new Label(this, SWT.NONE);
    nameLabel.setText("Name:");

    text = new Text(this, SWT.BORDER);
    final GridData gd_text = new GridData(SWT.FILL, SWT.CENTER, true, false);
    gd_text.widthHint = 50;
    text.setLayoutData(gd_text);

    valueLabel = new Label(this, SWT.NONE);
    valueLabel.setText("Value:");

    valueDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    valueDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    //

    Choice choice = (Choice) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();
    IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, choice, choice
        .eClass().getEStructuralFeature("name"));
    // IObservableValue ob =
    // EMFObservables.observeValue(parent.getEditPart().getActionStep(), parent
    // .getEditPart().getActionStep().eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement = SWTObservables.observeText(text, SWT.FocusOut);
    uiElement = SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    valueDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(choice.getValue()));
    valueDVEWidget.setEditingDomain(editingDomain);
    valueDVEWidget.setObject(choice);
    EStructuralFeature valueFeature = choice.eClass().getEStructuralFeature("value");
    valueDVEWidget.setFeature(valueFeature);
    ob = ActionstepEditObservables.observeValue(editingDomain, choice, valueFeature);
    DynamicValueWidgetObservableValue valVal = new DynamicValueWidgetObservableValue(
        valueDVEWidget, SWT.Modify);

    choicesLabel = new Label(this, SWT.NONE);
    choicesLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    choicesLabel.setText("Choices: ");

    caseItemEditorWidget = new CaseItemEditorWidget(this, SWT.NONE);
    caseItemEditorWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
    caseItemEditorWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    bindingContext.bindValue(valVal, ob, null, null);
    IObservableList modelList = ActionstepEditObservables.observeList(editingDomain, choice, choice
        .eClass().getEStructuralFeature("choices"));

    uiList = new WritableList(new ArrayList<CaseItem>(choice.getChoices()),
        CaseItem.class);
    bindingContext.bindList(uiList, modelList, null, null);

    caseItemEditorWidget.setItemList(uiList);
    caseItemEditorWidget.setActionstepEditorDialog(parent);
  }
  
  @Override
  public void dispose() {
    // TODO Auto-generated method stub
    super.dispose();
    uiList.dispose();
//    uiList.clear();
    uiList = null;
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
  public void operationsComplete() {
    new CaseItemReorderCommand(editPart.getEditingDomain(), editPart) {
      @Override
      protected List<Item> getItems(ActionStep ts) {
        return (List) ((Choice) ((ChoiceEditPart) editPart).getActionStep()).getChoices();
      }
    }.execute();
  }

  @Override
  public void operationsUndone() {
    new CaseItemReorderCommand(editPart.getEditingDomain(), editPart) {
      @Override
      protected List<Item> getItems(ActionStep ts) {
        return (List) ((Choice) ((ChoiceEditPart) editPart).getActionStep()).getChoices();
      }
    }.execute();
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
