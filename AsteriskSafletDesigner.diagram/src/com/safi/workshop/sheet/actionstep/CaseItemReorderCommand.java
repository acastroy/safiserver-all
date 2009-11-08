package com.safi.workshop.sheet.actionstep;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AbstractOverrideableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.safi.core.actionstep.ActionStep;
import com.safi.core.actionstep.Item;
import com.safi.workshop.edit.parts.ActionstepWithCompartment;
import com.safi.workshop.edit.parts.ActionstepWithOutputParameters;
import com.safi.workshop.edit.parts.ItemPanelEditPart;
import com.safi.workshop.edit.parts.ToolstepEditPart;

public class CaseItemReorderCommand extends AbstractOverrideableCommand {

  private ToolstepEditPart editPart;

  public CaseItemReorderCommand(EditingDomain domain, ToolstepEditPart editPart) {
    super(domain);
    this.editPart = editPart;
  }

  @Override
  public void doUndo() {
    doRedo();
    // ActionstepWithCompartment cep = (ActionstepWithCompartment) editPart;
    // CaseItemPanelEditPart panel = (CaseItemPanelEditPart) cep.getCompartmentPart();
    // panel.refresh();
    // panel.reorderFromCaseItems(originalOrder);
    // panel.refresh();
    // originalOrder = null;
  }

  @Override
  public void doRedo() {
    doExecute();
  }

  @Override
  public void doExecute() {
    if (editPart instanceof ActionstepWithCompartment) {
      ActionstepWithCompartment cep = (ActionstepWithCompartment) editPart;
      ItemPanelEditPart panel = getInputCompartment(cep);
      if (panel != null && panel.getParent() != null && panel.getRoot() != null) {
      	panel.refresh();
        ActionStep ts = editPart.getActionStep();
        panel.reorderFromItemList(getItems(ts));
        panel.refresh();
      }
    }
    if (editPart instanceof ActionstepWithOutputParameters) {
      ActionstepWithOutputParameters cep = (ActionstepWithOutputParameters) editPart;
      ItemPanelEditPart panel = getOutputCompartment(cep);
      if (panel != null && panel.getParent() != null && panel.getRoot() != null) {
        panel.refresh();
        ActionStep ts = editPart.getActionStep();
        panel.reorderFromItemList(getItems(ts));
        panel.refresh();
      }
    }
  }

  protected ItemPanelEditPart getInputCompartment(ActionstepWithCompartment cep) {
    ItemPanelEditPart panel = cep.getInputCompartmentPart();
    return panel;
  }

  protected ItemPanelEditPart getOutputCompartment(ActionstepWithOutputParameters cep) {
    ItemPanelEditPart panel = cep.getOutputCompartmentPart();
    return panel;
  }

  protected List<Item> getItems(ActionStep ts) {
    EList<EStructuralFeature> features = ts.eClass().getEStructuralFeatures();
    for (EStructuralFeature feature : features) {
      if (feature.isMany() && Item.class.isAssignableFrom(feature.getEType().getInstanceClass())) {
        return (List<Item>) ts.eGet(feature);
      }
    }
    return Collections.emptyList();
  }

  @Override
  protected boolean prepare() {
    // TODO Auto-generated method stub
    return true;
  }

}
