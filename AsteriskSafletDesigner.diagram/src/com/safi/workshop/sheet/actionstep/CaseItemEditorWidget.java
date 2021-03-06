package com.safi.workshop.sheet.actionstep;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;

import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.CaseItem;
import com.safi.core.actionstep.Item;
import com.safi.workshop.edit.policies.EditCaseItemValueCommand;

public class CaseItemEditorWidget extends AbstractItemEditorWidget {

  public CaseItemEditorWidget(Composite parent, int style) {
    super(parent, style);
  }

  @Override
  protected void editItem(Item item) {

    if (!EditCaseItemValueCommand.openEditor((CaseItem) item, editingDomain,
        getActionstepEditorDialog().getEditPart().getActionStep().getSaflet().getSafletContext()))
      return;
    listViewer.refresh();
  }

  @Override
  protected void newItem() {
//  	new WrappedToggleCanonicalModeCommand(false, getActionstepEditorDialog()
//      .getEditPart()).execute();
//  	editingDomain.getCommandStack().execute(new WrappedToggleCanonicalModeCommand(false, getActionstepEditorDialog()
//        .getEditPart()));
	
    CaseItem item = ActionStepFactory.eINSTANCE.createCaseItem();
    EditCaseItemValueCommand.openEditor(item, editingDomain, getActionstepEditorDialog()
        .getEditPart().getActionStep().getSaflet().getSafletContext());
//    editingDomain.getCommandStack().execute(
//        EditCaseItemValueCommand.getEMFCommand(item, editingDomain, getActionstepEditorDialog()
//            .getEditPart().getActionStep().getSaflet().getSafletContext()));
    
   
    if (item.getDynamicValue() != null) {
      itemList.add(item);
    }
   
//    editingDomain.getCommandStack().execute(new WrappedToggleCanonicalModeCommand(true, getActionstepEditorDialog()
//        .getEditPart()));
    listViewer.refresh();
//    new WrappedToggleCanonicalModeCommand(true, getActionstepEditorDialog()
//        .getEditPart()).execute();
  }

  @Override
  protected LabelProvider createLabelProvider() {
    return new ListLabelProvider();
  }

  class ListLabelProvider extends DefaultListLabelProvider {
    @Override
    public String getText(Object element) {
      CaseItem item = (CaseItem) element;
      return item.getDynamicValue() == null ? "" : item.getDynamicValue().getText();
    }

  }

}
