package com.safi.workshop.sheet.actionstep;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import com.safi.core.actionstep.ActionStepFactory;
import com.safi.core.actionstep.GetColMapping;
import com.safi.core.actionstep.Item;

public class GetColMappingEditorWidget extends AbstractItemEditorWidget {

  public GetColMappingEditorWidget(Composite parent, int style) {
    super(parent, style);
  }

  @Override
  protected void editItem(Item item) {
    GetColMapping newItem = (GetColMapping) EcoreUtil.copy(item);
    EditGetColMappingDialog dlg = new EditGetColMappingDialog(
        Display.getDefault().getActiveShell(), newItem, editingDomain, getActionstepEditorDialog()
            .getEditPart().getActionStep().getSaflet().getSafletContext());
    if (Window.OK == dlg.open()) {
      replace(item, newItem);
      listViewer.refresh();
    }
  }

  @Override
  protected void newItem() {
    GetColMapping item = ActionStepFactory.eINSTANCE.createGetColMapping();
    EditGetColMappingDialog dlg = new EditGetColMappingDialog(
        Display.getDefault().getActiveShell(), item, editingDomain, getActionstepEditorDialog()
            .getEditPart().getActionStep().getSaflet().getSafletContext());
    if (Window.OK == dlg.open()) {
      itemList.add(item);
      listViewer.refresh();
    }

  }

}
