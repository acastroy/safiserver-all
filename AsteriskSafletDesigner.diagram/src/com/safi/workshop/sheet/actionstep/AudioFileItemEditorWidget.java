package com.safi.workshop.sheet.actionstep;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Composite;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.AudioFileItem;
import com.safi.core.actionstep.Item;
import com.safi.workshop.edit.policies.EditAudioFileItemValueCommand;

public class AudioFileItemEditorWidget extends AbstractItemEditorWidget {

  public AudioFileItemEditorWidget(Composite parent, int style) {
    super(parent, style);
  }

  @Override
  protected void editItem(Item item) {

    if (!EditAudioFileItemValueCommand.openEditor((AudioFileItem) item, editingDomain,
        getActionstepEditorDialog().getEditPart().getActionStep().getSaflet().getSafletContext()))
      return;
    listViewer.refresh();
  }

  @Override
  protected void newItem() {
    AudioFileItem item = ActionStepFactory.eINSTANCE.createAudioFileItem();
    
    EditAudioFileItemValueCommand.openEditor(item, editingDomain, getActionstepEditorDialog()
        .getEditPart().getActionStep().getSaflet().getSafletContext());
//    editingDomain.getCommandStack().execute(
//        EditAudioFileItemValueCommand.getEMFCommand(item, editingDomain,
//            getActionstepEditorDialog().getEditPart().getActionStep().getSaflet()
//                .getSafletContext()));
    if (item.getDynamicValue() != null) {
      itemList.add(item);
    }
    listViewer.refresh();
  }

  @Override
  protected LabelProvider createLabelProvider() {
    return new ListLabelProvider();
  }

  class ListLabelProvider extends DefaultListLabelProvider {
    @Override
    public String getText(Object element) {
      AudioFileItem item = (AudioFileItem) element;
      return item.getDynamicValue() == null ? "" : item.getDynamicValue().getText();
    }

  }

}
