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
import com.safi.workshop.model.actionpak1.InvokeSaflet2;
import com.safi.workshop.sheet.actionstep.AbstractActionstepEditorPage;
import com.safi.workshop.sheet.actionstep.ActionstepEditObservables;
import com.safi.workshop.sheet.actionstep.ActionstepEditorDialog;
import com.safi.workshop.sheet.actionstep.CaseItemReorderCommand;

public class InvokeSaflet2OutputEditorPage extends AbstractActionstepEditorPage {

  private InvokeSaflet2OutputParamEditorWidget outputItemEditorWidget;
  private Label paramsLabel;

  public InvokeSaflet2OutputEditorPage(ActionstepEditorDialog parent) {
    super(parent);
    final GridLayout gridLayout = new GridLayout();
    gridLayout.numColumns = 2;
    setLayout(gridLayout);

    InvokeSaflet2 invokeSaflet = (InvokeSaflet2) parent.getEditPart().getActionStep();
    TransactionalEditingDomain editingDomain = parent.getEditPart().getEditingDomain();
    
    paramsLabel = new Label(this, SWT.NONE);
    final GridData gd_paramsLabel = new GridData(SWT.LEFT, SWT.TOP, false, false);
    paramsLabel.setLayoutData(gd_paramsLabel);
    paramsLabel.setText("Outputs:");

    outputItemEditorWidget = new InvokeSaflet2OutputParamEditorWidget(this, SWT.NONE);
    outputItemEditorWidget.setEditingDomain(parent.getEditPart().getEditingDomain());
    outputItemEditorWidget.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
    IObservableList modelList = ActionstepEditObservables.observeList(editingDomain, invokeSaflet, invokeSaflet
        .eClass().getEStructuralFeature("outputParameters"));

    IObservableList uiList = new WritableList(new ArrayList<CaseItem>(invokeSaflet.getOutputParameters()),
        OutputParameter.class);
    bindingContext.bindList(uiList, modelList, null, null);
    
    outputItemEditorWidget.setItemList(uiList);
    outputItemEditorWidget.setActionstepEditorDialog(parent);
  }

  @Override
  public void operationsComplete() {
    
    new CaseItemReorderCommand(editPart.getEditingDomain(), editPart){
      @Override
      protected List<Item> getItems(ActionStep ts) {
        return (List)((InvokeSaflet2EditPart)editPart).getInvokeSaflet2Model().getOutputParameters();
      }
      
      @Override
      protected ItemPanelEditPart getInputCompartment(ActionstepWithCompartment cep) {
        return ((InvokeSaflet2EditPart)editPart).getOutputCompartmentPart();
      }
    }
    .execute();
  
  }
  
  @Override
  public void operationsUndone() {
    new CaseItemReorderCommand(editPart.getEditingDomain(), editPart){
      @Override
      protected List<Item> getItems(ActionStep ts) {
        return (List)((InvokeSaflet2EditPart)editPart).getInvokeSaflet2Model().getOutputParameters();
      }
      
      @Override
      protected ItemPanelEditPart getInputCompartment(ActionstepWithCompartment cep) {
        return ((InvokeSaflet2EditPart)editPart).getOutputCompartmentPart();
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

  public InvokeSaflet2OutputParamEditorWidget getOutputItemEditorWidget() {
    return outputItemEditorWidget;
  }

}
