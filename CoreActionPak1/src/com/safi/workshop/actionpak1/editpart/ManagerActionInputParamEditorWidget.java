package com.safi.workshop.actionpak1.editpart;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.Item;
import com.safi.workshop.actionpak1.command.SetInputItemValueCommand;

public class ManagerActionInputParamEditorWidget extends InputItemEditorWidget {

  public ManagerActionInputParamEditorWidget(Composite parent, int style) {
    super(parent, style);
    addButton.setEnabled(false);
    deleteButton.setEnabled(false);
    moveUpButton.setEnabled(false);
    moveDownButton.setEnabled(false);
    
  }

//  @Override
//  protected void newItem() {
//    
//  }
  
  @Override
  protected void editItem(Item item) {
    
    if (!SetInputItemValueCommand.executeCmd((InputItem)item, editingDomain,
        getActionstepEditorDialog().getEditPart().getActionStep().getSaflet().getSafletContext(), false))
        return;
//    Command command = getActionstepEditorDialog().getEditPart().getEditingDomain().getCommandStack().getMostRecentCommand();
//    getActionstepEditorDialog().rollbackCount++;
    listViewer.refresh();
  }
  
  @Override
  protected void delete() {
    // TODO Auto-generated method stub
//    super.delete();
  }
  
  @Override
  protected void moveDown() {
    // TODO Auto-generated method stub
//    super.moveDown();
  }
  
  @Override
  protected void moveUp() {
    // TODO Auto-generated method stub
//    super.moveUp();
  }
  
  @Override
  protected LabelProvider createLabelProvider() {
    // TODO Auto-generated method stub
    return new LabelProvider() {
      public String getText(Object element) {
        InputItem item = (InputItem) element;
        return item.getParameterName() + " = "
            + (item.getDynamicValue() == null ? "" : item.getDynamicValue().getText());
      }

      public Image getImage(Object element) {
       // return WebServicesPlugin.getInstance().getBundledImage("icons/parameter.gif");
    	  return null;
      }
    };
  }

}
