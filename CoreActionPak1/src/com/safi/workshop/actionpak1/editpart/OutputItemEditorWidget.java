package com.safi.workshop.actionpak1.editpart;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.Item;
import com.safi.core.actionstep.OutputParameter;
import com.safi.workshop.actionpak1.command.SetOutputItemValueCommand;
import com.safi.workshop.sheet.actionstep.AbstractItemEditorWidget;

public class OutputItemEditorWidget extends AbstractItemEditorWidget {

  public OutputItemEditorWidget(Composite parent, int style) {
    super(parent, style);
  }

  @Override
  protected void editItem(Item item) {

    if (!SetOutputItemValueCommand.executeCmd((OutputParameter) item, editingDomain,
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
    OutputParameter item = ActionStepFactory.eINSTANCE.createOutputParameter();
    // listViewer.add(item);

    editingDomain.getCommandStack().execute(
        SetOutputItemValueCommand.getEMFCommand(item, editingDomain, getActionstepEditorDialog()
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
  class ListLabelProvider extends DefaultListLabelProvider {
    public String getText(Object element) {
      OutputParameter item = (OutputParameter) element;
      return item.getParameterName() + " -> "
          + (item.getDynamicValue() == null ? "" : item.getDynamicValue().getText());
    }

  }
}
