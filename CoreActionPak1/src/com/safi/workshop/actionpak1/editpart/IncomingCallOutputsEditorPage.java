package com.safi.workshop.actionpak1.editpart;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.Item;
import com.safi.core.actionstep.OutputParameter;
import com.safi.workshop.edit.parts.ActionstepWithCompartment;
import com.safi.workshop.edit.parts.ItemPanelEditPart;
import com.safi.workshop.model.actionpak1.IncomingCall2;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.ActionstepEditObservables;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.CaseItemReorderCommand;

public class IncomingCallOutputsEditorPage extends AbstractActionstepEditorPage {

  private OutputItemEditorWidget outputItemEditorWidget;
  private Label outputsLabel;

  public IncomingCallOutputsEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);
    //

    IncomingCall2 incomingCall = (IncomingCall2) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    outputsLabel = new Label(this, SWT.NONE);
    outputsLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    outputsLabel.setText("Output Params: ");

    outputItemEditorWidget = new OutputItemEditorWidget(this, SWT.NONE);
    outputItemEditorWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
    outputItemEditorWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    IObservableList modelList = ActionstepEditObservables.observeList(editingDomain, incomingCall, incomingCall
        .eClass().getEStructuralFeature("outputParameters"));

    IObservableList uiList = new WritableList(new ArrayList<CaseItem>(incomingCall.getOutputParameters()),
        OutputParameter.class);
    bindingContext.bindList(uiList, modelList, null, null);
    
    outputItemEditorWidget.setItemList(uiList);
    outputItemEditorWidget.setActionstepEditorDialog(parent);
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
    
    new CaseItemReorderCommand(editPart.getEditingDomain(), editPart){
      @Override
      protected List<Item> getItems(ActionStep ts) {
        return (List)((IncomingCall2EditPart)editPart).getIncomingCallModel().getOutputParameters();
      }
      
      @Override
      protected ItemPanelEditPart getInputCompartment(ActionstepWithCompartment cep) {
        return ((IncomingCall2EditPart)editPart).getOutputCompartmentPart();
      }
    }
    .execute();
  }
  
  @Override
  public void operationsUndone() {
    new CaseItemReorderCommand(editPart.getEditingDomain(), editPart){
      @Override
      protected List<Item> getItems(ActionStep ts) {
        return (List)((IncomingCall2EditPart)editPart).getIncomingCallModel().getOutputParameters();
      }
      
      @Override
      protected ItemPanelEditPart getInputCompartment(ActionstepWithCompartment cep) {
        return ((IncomingCall2EditPart)editPart).getOutputCompartmentPart();
      }
    }
    .execute();
  }
  @Override
  public String getTabText() {
    // TODO Auto-generated method stub
    return "Outputs";
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
