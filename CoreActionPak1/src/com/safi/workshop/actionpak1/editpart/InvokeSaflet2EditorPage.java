package com.safi.workshop.actionpak1.editpart;

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

import com.safi.core.actionstep.CaseItem;
import com.safi.workshop.model.actionpak1.InvokeSaflet2;
import com.safi.workshop.sheet.DynamicValueEditorUtils;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.ActionstepEditObservables;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.ActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.CaseItemReorderCommand;
import com.safi.workshop.sheet.actionstep.DynamicValueEditorWidget;
import com.safi.workshop.sheet.actionstep.DynamicValueWidgetObservableValue;

public class InvokeSaflet2EditorPage extends AbstractActionstepEditorPage {

  private InvokeSaflet2InputParamEditorWidget inputItemEditorWidget;
  private Label paramsLabel;
  private DynamicValueEditorWidget targetDVEWidget;
  private Label targetLabel;
  private Text text;
  private Label nameLabel;

  public InvokeSaflet2EditorPage(ActionstepEditorDialog parent) {
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

    targetLabel = new Label(this, SWT.NONE);
    targetLabel.setText("Target Saflet:");

    targetDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE){
      @Override
      protected void openEditor() {
        super.openEditor();
        inputItemEditorWidget.refreshListViewer();
        ActionstepEditorPage page = getEditorDialog().getPage(1);
        if (page != null && page instanceof InvokeSaflet2OutputEditorPage)
          ((InvokeSaflet2OutputEditorPage)page).getOutputItemEditorWidget().refreshListViewer();
      }
    };
    targetDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    //

    InvokeSaflet2 invokeSaflet = (InvokeSaflet2) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();
    IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, invokeSaflet, invokeSaflet
        .eClass().getEStructuralFeature("name"));
    // IObservableValue ob =
    // EMFObservables.observeValue(parent.getEditPart().getToolstep(), parent
    // .getEditPart().getToolstep().eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement = SWTObservables.observeText(text,
        SWT.FocusOut);
    uiElement = SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    targetDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(invokeSaflet.getTargetSafletPath()));
    targetDVEWidget.setEditingDomain(editingDomain);
    targetDVEWidget.setObject(invokeSaflet);
    EStructuralFeature valueFeature = invokeSaflet.eClass().getEStructuralFeature("targetSafletPath");
    targetDVEWidget.setFeature(valueFeature);
    ob = ActionstepEditObservables.observeValue(editingDomain, invokeSaflet, valueFeature);
    DynamicValueWidgetObservableValue valVal = new DynamicValueWidgetObservableValue(
        targetDVEWidget, SWT.Modify);

    paramsLabel = new Label(this, SWT.NONE);
    final GridData gd_paramsLabel = new GridData(SWT.LEFT, SWT.TOP, false, false);
    paramsLabel.setLayoutData(gd_paramsLabel);
    paramsLabel.setText("Parameters:");

    inputItemEditorWidget = new InvokeSaflet2InputParamEditorWidget(this, SWT.NONE);
    inputItemEditorWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
    inputItemEditorWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    bindingContext.bindValue(valVal, ob, null, null);
    IObservableList modelList = ActionstepEditObservables.observeList(editingDomain, invokeSaflet, invokeSaflet
        .eClass().getEStructuralFeature("inputs"));

    IObservableList uiList = new WritableList(new ArrayList<CaseItem>(invokeSaflet.getInputs()),
        CaseItem.class);
    bindingContext.bindList(uiList, modelList, null, null);
    
    inputItemEditorWidget.setItemList(uiList);
    inputItemEditorWidget.setActionstepEditorDialog(parent);
  }

//  @Override
//  public void aboutToExecute(CompoundCommand command) {
//    final ToolstepEditPart editPart = editorDialog.getEditPart();
//    Command cmd = new CaseItemReorderCommand(editPart.getEditingDomain(), editPart);
////    editPart.getEditingDomain().getCommandStack().execute(cmd);
////    editorDialog.appendRollbackItem(new ActionstepEditorDialog.RollbackItem(cmd));
//    command.append(cmd);
//    super.aboutToExecute(command);
//  }
//  
//  @Override
//  public void rollbackCommandAdded(CompoundCommand command) {
//    // TODO Auto-generated method stub
//    final ToolstepEditPart editPart = editorDialog.getEditPart();
//    Command cmd = new CaseItemReorderCommand(editPart.getEditingDomain(), editPart);
//    command.append(cmd);
//    super.rollbackCommandAdded(command);
//  }

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
