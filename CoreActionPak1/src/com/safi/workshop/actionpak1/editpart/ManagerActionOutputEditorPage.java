package com.safi.workshop.actionpak1.editpart;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.Item;
import com.safi.workshop.edit.parts.ActionstepWithCompartment;
import com.safi.workshop.edit.parts.ItemPanelEditPart;
import com.safi.workshop.model.actionpak1.ManagerAction;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.ActionstepEditObservables;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.CaseItemReorderCommand;
import com.safi.workshop.sheet.actionstep.DynamicValueEditorWidget;
import com.safi.workshop.sheet.actionstep.DynamicValueWidgetObservableValue;

public class ManagerActionOutputEditorPage extends AbstractActionstepEditorPage {

  private DynamicValueEditorWidget returnVarDVEWidget;
  //private DynamicValueEditorWidget faultDVEWidget;
  private Label paramsLabel;

  //private PropertyMappingItemEditorWidget outputItemEditorWidget;
  //private Label outputsLabel;
  
  public ManagerActionOutputEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    ManagerAction callws = (ManagerAction) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();
    
    paramsLabel = new Label(this, SWT.NONE);
    final GridData gd_paramsLabel = new GridData(SWT.LEFT, SWT.TOP, false, false);
    paramsLabel.setLayoutData(gd_paramsLabel);
    paramsLabel.setText("Return variable:");

    returnVarDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    returnVarDVEWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
    returnVarDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    DynamicValueWidgetObservableValue outputVal = new DynamicValueWidgetObservableValue(
        returnVarDVEWidget, SWT.Modify);
    returnVarDVEWidget.setObject(callws);
    EStructuralFeature returnVarFeat = callws.eClass().getEStructuralFeature("returnVariableName");
    returnVarDVEWidget.setFeature(returnVarFeat);
    IObservableValue ob = ActionstepEditObservables.observeValue(editingDomain, callws, returnVarFeat);
    bindingContext.bindValue(outputVal, ob, null, null);
    
/*    
    Label faultLabel = new Label(this, SWT.NONE);
    final GridData gd_faultLabel = new GridData(SWT.LEFT, SWT.TOP, false, false);
    faultLabel.setLayoutData(gd_faultLabel);
    faultLabel.setText("Fault variable:");
    
    faultDVEWidget = new DynamicValueEditorWidget(this, SWT.NONE);
    faultDVEWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
    faultDVEWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    DynamicValueWidgetObservableValue faultVal = new DynamicValueWidgetObservableValue(
        faultDVEWidget, SWT.Modify);
    EStructuralFeature faultFeat = callws.eClass().getEStructuralFeature("faultVariableName");
    faultDVEWidget.setFeature(faultFeat);
    faultDVEWidget.setObject(callws);
    ob = ActionstepEditObservables.observeValue(editingDomain, callws, faultFeat);
    bindingContext.bindValue(faultVal, ob, null, null);
*/
    
   // outputsLabel = new Label(this, SWT.NONE);
   // outputsLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
   // outputsLabel.setText("Output Params: ");

//    outputItemEditorWidget = new PropertyMappingItemEditorWidget(this, SWT.NONE);
//    outputItemEditorWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
//    outputItemEditorWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
//    IObservableList modelList = ActionstepEditObservables.observeList(editingDomain, callws, callws
//        .eClass().getEStructuralFeature("outputProperties"));
//
//    IObservableList uiList = new WritableList(new ArrayList<PropertyMappingItem>(callws.getOutputProperties()),
//    		PropertyMappingItem.class);
//    bindingContext.bindList(uiList, modelList, null, null);
//    
//    outputItemEditorWidget.setItemList(uiList);
//    outputItemEditorWidget.setActionstepEditorDialog(parent);

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
  
  @Override
  public void operationsComplete() {
    
    new CaseItemReorderCommand(editPart.getEditingDomain(), editPart){
      @Override
      protected List<Item> getItems(ActionStep ts) {
        return (List)((ManagerActionEditPart)editPart).getManagerActionModel().getOutputParameters();
      }
      
      @Override
      protected ItemPanelEditPart getInputCompartment(ActionstepWithCompartment cep) {
        return ((ManagerActionEditPart)editPart).getOutputCompartmentPart();
      }
    }
    .execute();
  }
  
  @Override
  public void operationsUndone() {
    new CaseItemReorderCommand(editPart.getEditingDomain(), editPart){
      @Override
      protected List<Item> getItems(ActionStep ts) {
        return (List)((ManagerActionEditPart)editPart).getManagerActionModel().getOutputParameters();
      }
      
      @Override
      protected ItemPanelEditPart getInputCompartment(ActionstepWithCompartment cep) {
        return ((ManagerActionEditPart)editPart).getOutputCompartmentPart();
      }
    }
    .execute();
  }


}
