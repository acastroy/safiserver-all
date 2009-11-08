package com.safi.workshop.timeBasedRouting.pak.editpart;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.safi.core.actionstep.Item;
import com.safi.workshop.model.timeBasedRouting.TimeBasedRoutingFactory;
import com.safi.workshop.model.timeBasedRouting.TimeItem;
import com.safi.workshop.sheet.actionstep.AbstractItemEditorWidget;

public class TimeItemEditorWidget extends AbstractItemEditorWidget {

  public TimeItemEditorWidget(Composite parent, int style) {
    super(parent, style);
  }

  @Override
  protected void editItem(Item item) {
    
    if (!EditTimeItemValueCommand.openEditor((TimeItem)item, editingDomain,
        getActionstepEditorDialog().getEditPart().getActionStep().getSaflet().getSafletContext()))
        return;
//    Command command = getActionstepEditorDialog().getEditPart().getEditingDomain().getCommandStack().getMostRecentCommand();
//    getActionstepEditorDialog().rollbackCount++;
    listViewer.refresh();
  }

  @Override
  protected void newItem() {
    TimeItem item = TimeBasedRoutingFactory.eINSTANCE.createTimeItem();
//    listViewer.add(item);
    editingDomain.getCommandStack().execute(
        EditTimeItemValueCommand.getEMFCommand(item, editingDomain, getActionstepEditorDialog().getEditPart().getActionStep().getSaflet().getSafletContext()));
    if (item.getDynamicValue() != null){
      itemList.add(item);
    }
    listViewer.refresh();
  }
  
  protected LabelProvider createLabelProvider() {
    return new ListLabelProvider();
  }

  class ListLabelProvider extends DefaultListLabelProvider {
    public String getText(Object element) {
      TimeItem item = (TimeItem) element;
      return item.getDescription();
    }
  }

}
