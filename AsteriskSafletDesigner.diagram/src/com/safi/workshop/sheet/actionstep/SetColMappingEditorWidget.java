package com.safi.workshop.sheet.actionstep;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.Item;
import com.safi.core.actionstep.SetColMapping;

public class SetColMappingEditorWidget extends AbstractItemEditorWidget {

  public SetColMappingEditorWidget(Composite parent, int style) {
    super(parent, style);
  }

  @Override
  protected void editItem(Item item) {
    SetColMapping newItem = (SetColMapping) EcoreUtil.copy(item);
    EditSetColMappingDialog dlg = new EditSetColMappingDialog(
        Display.getDefault().getActiveShell(), newItem, editingDomain, getActionstepEditorDialog()
            .getEditPart().getActionStep().getSaflet().getSafletContext());
    if (Window.OK == dlg.open()) {
      replace(item, newItem);
      listViewer.refresh();
    }
  }

  @Override
  protected void newItem() {
    SetColMapping item = ActionStepFactory.eINSTANCE.createSetColMapping();
    EditSetColMappingDialog dlg = new EditSetColMappingDialog(
        Display.getDefault().getActiveShell(), item, editingDomain, getActionstepEditorDialog()
            .getEditPart().getActionStep().getSaflet().getSafletContext());
    if (Window.OK == dlg.open()) {
      itemList.add(item);
      listViewer.refresh();
    }

  }

}
