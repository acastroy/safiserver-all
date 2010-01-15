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
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.DynamicValue;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.Item;
import com.safi.core.actionstep.OutputParameter;
import com.safi.workshop.edit.parts.ActionstepWithCompartment;
import com.safi.workshop.edit.parts.ItemPanelEditPart;
import com.safi.workshop.model.actionpak1.ManagerAction;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.ActionstepEditObservables;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.CaseItemReorderCommand;

public class ManagerActionOutputEditorPage extends AbstractActionstepEditorPage {

   private OutputItemEditorWidget outputItemEditorWidget;
   private Label outputsLabel;

  //private PropertyMappingItemEditorWidget outputItemEditorWidget;
  //private Label outputsLabel;
  
  public ManagerActionOutputEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);
    //

    ManagerAction managerAction = ( ManagerAction) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();

    outputsLabel = new Label(this, SWT.NONE);
    outputsLabel.setLayoutData(new GridData(SWT.LEFT, SWT.TOP, false, false));
    outputsLabel.setText("Output Params: ");

    outputItemEditorWidget = new OutputItemEditorWidget(this, SWT.NONE);
    outputItemEditorWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
    outputItemEditorWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    IObservableList modelList = ActionstepEditObservables.observeList(editingDomain, managerAction, managerAction
        .eClass().getEStructuralFeature("outputParameters"));
    if(managerAction.getOutputParameters().isEmpty()){
    	createDefaultOutputParameters();
    }
    IObservableList uiList = new WritableList(new ArrayList<CaseItem>(managerAction.getOutputParameters()),
        OutputParameter.class);
    bindingContext.bindList(uiList, modelList, null, null);
    
    outputItemEditorWidget.setItemList(uiList);
    outputItemEditorWidget.setActionstepEditorDialog(parent);

  }



  private void createDefaultOutputParameters() {
	// TODO Auto-generated method stub
	  DynamicValue resposeValue=ActionStepFactory.eINSTANCE.createDynamicValue();
	  OutputParameter item = ActionStepFactory.eINSTANCE.createOutputParameter();
		//DynamicValue dynamicValue = ActionStepFactory.eINSTANCE.createDynamicValue();
	  item.setParameterName("Message");
	  item.setDynamicValue(resposeValue);
	  ManagerAction managerAction = ( ManagerAction) this.getEditorDialog().getEditPart().getActionStep();
	 
	  managerAction.getOutputParameters().add((OutputParameter) item);
	
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
