package com.safi.workshop.actionpak1.editpart;

import org.eclipse.swt.widgets.Composite;

import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.Item;
import com.safi.workshop.actionpak1.command.SetInputItemValueCommand;

public class InvokeSaflet2InputParamEditorWidget extends InputItemEditorWidget {

  public InvokeSaflet2InputParamEditorWidget(Composite parent, int style) {
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
    
    if (!SetInputItemValueCommand.executeCmd((InputItem)item, editingDomain,
        getActionstepEditorDialog().getEditPart().getActionStep().getSaflet().getSafletContext(), false))
        return;
//    Command command = getActionstepEditorDialog().getEditPart().getEditingDomain().getCommandStack().getMostRecentCommand();
//    getActionstepEditorDialog().rollbackCount++;
    listViewer.refresh();
  }
}
