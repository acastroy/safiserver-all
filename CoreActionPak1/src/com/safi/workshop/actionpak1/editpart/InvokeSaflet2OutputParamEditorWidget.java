package com.safi.workshop.actionpak1.editpart;

import org.eclipse.swt.widgets.Composite;

import com.safi.core.actionstep.Item;
import com.safi.core.actionstep.OutputParameter;
import com.safi.workshop.actionpak1.command.SetOutputItemValueCommand;

public class InvokeSaflet2OutputParamEditorWidget extends OutputItemEditorWidget {

  public InvokeSaflet2OutputParamEditorWidget(Composite parent, int style) {
    super(parent, style);
    addButton.setEnabled(false);
    deleteButton.setEnabled(false);
    moveUpButton.setEnabled(false);
    moveDownButton.setEnabled(false);
    
  }

  @Override
  protected void newItem() {
    
  }
  
  @Override
  protected void editItem(Item item) {
    
    if (!SetOutputItemValueCommand.executeCmd((OutputParameter)item, editingDomain,
        getActionstepEditorDialog().getEditPart().getActionStep().getSaflet().getSafletContext(), false))
        return;
//    Command command = getActionstepEditorDialog().getEditPart().getEditingDomain().getCommandStack().getMostRecentCommand();
//    getActionstepEditorDialog().rollbackCount++;
    listViewer.refresh();
  }
}
