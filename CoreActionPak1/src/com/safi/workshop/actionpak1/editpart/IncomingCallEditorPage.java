package com.safi.workshop.actionpak1.editpart;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.InputItem;
import com.safi.workshop.model.actionpak1.IncomingCall2;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.ActionstepEditObservables;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.CaseItemReorderCommand;

public class IncomingCallEditorPage extends AbstractActionstepEditorPage {

  private Text callNameText;
  private Label callNameLabel;
  private InputItemEditorWidget inputItemEditorWidget;
  private Label inputsLabel;
  private Text text;
  private Label nameLabel;

  public IncomingCallEditorPage(ActionstepEditorDialog parent) {
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

    //

    IncomingCall2 incomingCall = (IncomingCall2) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();
    IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, incomingCall,
        incomingCall.eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement = SWTObservables.observeText(text, SWT.FocusOut);
    uiElement = SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    callNameLabel = new Label(this, SWT.NONE);
    callNameLabel.setText("Call Name");

    callNameText = new Text(this, SWT.BORDER);
    final GridData gd_callNameText = new GridData(SWT.FILL, SWT.CENTER, true, false);
    callNameText.setLayoutData(gd_callNameText);

    ob = ActionstepEditObservables.observeValue(editingDomain, incomingCall, incomingCall.eClass()
        .getEStructuralFeature("callName"));
    uiElement = SWTObservables.observeText(callNameText, SWT.FocusOut);
    uiElement = SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    inputsLabel = new Label(this, SWT.NONE);
    inputsLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    inputsLabel.setText("Inputs: ");

    inputItemEditorWidget = new InputItemEditorWidget(this, SWT.NONE);
    inputItemEditorWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
    inputItemEditorWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    IObservableList modelList = ActionstepEditObservables.observeList(editingDomain, incomingCall,
        incomingCall.eClass().getEStructuralFeature("inputs"));

    IObservableList uiList = new WritableList(new ArrayList<CaseItem>(incomingCall.getInputs()),
        InputItem.class);
    bindingContext.bindList(uiList, modelList, null, null);

    inputItemEditorWidget.setItemList(uiList);
    inputItemEditorWidget.setActionstepEditorDialog(parent);
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
      new CaseItemReorderCommand(editPart.getEditingDomain(), editPart).execute();
  }

  @Override
  public void operationsUndone() {
      new CaseItemReorderCommand(editPart.getEditingDomain(), editPart).execute();
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