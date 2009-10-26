package com.safi.workshop.actionpak1.editpart;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.InputItem;
import com.safi.core.actionstep.Item;
import com.safi.workshop.actionpak1.command.SetInputItemValueCommand;
import com.safi.workshop.sheet.actionstep.AbstractItemEditorWidget;

public class InputItemEditorWidget extends AbstractItemEditorWidget {

  public InputItemEditorWidget(Composite parent, int style) {
    super(parent, style);
  }

  @Override
  protected void editItem(Item item) {

    if (!SetInputItemValueCommand.executeCmd((InputItem) item, editingDomain,
        getActionstepEditorDialog().getEditPart().getActionStep().getSaflet().getSafletContext(),
        true))
      return;
    // Command command =
    // getActionstepEditorDialog().getEditPart().getEditingDomain().getCommandStack().getMostRecentCommand();
    // getActionstepEditorDialog().rollbackCount++;
    listViewer.refresh();
  }

  @Override
  protected void newItem() {
    InputItem item = ActionStepFactory.eINSTANCE.createInputItem();
    // listViewer.add(item);

    editingDomain.getCommandStack().execute(
        SetInputItemValueCommand.getEMFCommand(item, editingDomain, getActionstepEditorDialog()
            .getEditPart().getActionStep().getSaflet().getSafletContext(), true));
    if (item.getDynamicValue() != null) {
      itemList.add(item);
    }
    listViewer.refresh();
  }

  @Override
  protected LabelProvider createLabelProvider() {
    // TODO Auto-generated method stub
    return new ListLabelProvider();
  }

  class ListLabelProvider extends LabelProvider {
    public String getText(Object element) {
      InputItem item = (InputItem) element;
      return item.getParameterName() + " -> "
          + (item.getDynamicValue() == null ? "" : item.getDynamicValue().getText());
    }

    public Image getImage(Object element) {
      return null;
    }
  }
}
