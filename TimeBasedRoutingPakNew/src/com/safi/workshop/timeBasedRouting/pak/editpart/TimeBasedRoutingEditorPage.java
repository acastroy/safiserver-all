package com.safi.workshop.timeBasedRouting.pak.editpart;

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
import com.safi.workshop.edit.parts.ToolstepEditPart;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRouting;
import com.safi.workshop.model.timeBasedRouting.TimeItem;
import com.safi.workshop.sheet.DynamicValueEditorUtils;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.ActionstepEditObservables;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.CaseItemReorderCommand;
import com.safi.workshop.sheet.actionstep.DynamicValueEditorWidget;
import com.safi.workshop.sheet.actionstep.DynamicValueWidgetObservableValue;

public class TimeBasedRoutingEditorPage extends AbstractActionstepEditorPage {

  private TimeItemEditorWidget timeItemEditorWidget;
  private Label timeRangesLabel;
  private DynamicValueEditorWidget valueDVEWidget;
  private Label valueLabel;
  private Text text;
  private Label nameLabel;

  public TimeBasedRoutingEditorPage(ActionstepEditorDialog parent) {
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

    TimeBasedRouting timeBasedRouting = (TimeBasedRouting) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();
    IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, timeBasedRouting, timeBasedRouting
        .eClass().getEStructuralFeature("name"));
    // IObservableValue ob =
    // EMFObservables.observeValue(parent.getEditPart().getToolstep(), parent
    // .getEditPart().getToolstep().eClass().getEStructuralFeature("name"));
    ISWTObservableValue uiElement = SWTObservables.observeText(text,
        SWT.FocusOut);
    uiElement = SWTObservables.observeDelayedValue(400, uiElement);
    bindingContext.bindValue(uiElement, ob, null, null);

    valueDVEWidget.setDynamicValue(DynamicValueEditorUtils.copyDynamicValue(timeBasedRouting.getValue()));
    valueDVEWidget.setEditingDomain(editingDomain);
    valueDVEWidget.setObject(timeBasedRouting);
    EStructuralFeature valueFeature = timeBasedRouting.eClass().getEStructuralFeature("value");
    valueDVEWidget.setFeature(valueFeature);
    ob = ActionstepEditObservables.observeValue(editingDomain, timeBasedRouting, valueFeature);
    DynamicValueWidgetObservableValue valVal = new DynamicValueWidgetObservableValue(
        valueDVEWidget, SWT.Modify);

    timeRangesLabel = new Label(this, SWT.NONE);
    timeRangesLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    timeRangesLabel.setText("Time Ranges: ");

    timeItemEditorWidget = new TimeItemEditorWidget(this, SWT.NONE);
    timeItemEditorWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
    timeItemEditorWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    bindingContext.bindValue(valVal, ob, null, null);
    IObservableList modelList = ActionstepEditObservables.observeList(editingDomain, timeBasedRouting, timeBasedRouting
        .eClass().getEStructuralFeature("times"));

    IObservableList uiList = new WritableList(new ArrayList<CaseItem>(timeBasedRouting.getTimes()),
        TimeItem.class);
    bindingContext.bindList(uiList, modelList, null, null);
    
    timeItemEditorWidget.setItemList(uiList);
    timeItemEditorWidget.setActionstepEditorDialog(parent);
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
